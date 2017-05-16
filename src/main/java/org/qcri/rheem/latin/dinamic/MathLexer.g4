lexer grammar MathLexer;

tokens { PREOP, POSTOP, BINOP, ERROR }

@header {
    import java.util.*;
}


@members {

    private static List<String> binaryOperators;
    private static List<String> prefixOperators;
    private static List<String> postfixOperators;
    {
        binaryOperators = new ArrayList<String>();
        binaryOperators.add("+");
        binaryOperators.add("*");
        binaryOperators.add("-");
        binaryOperators.add("/");

        prefixOperators = new ArrayList<String>();
        prefixOperators.add("-");

        postfixOperators = new ArrayList<String>();
        postfixOperators.add("!");
    }

    public static void addBinaryOperator(String operator){
        binaryOperators.add(operator);
    }

    private Deque<Token> deque = new LinkedList<Token>();

    private Token previousToken;
    private Token nextToken;

    @Override
    public Token nextToken() {
        if (!deque.isEmpty()) {
            return previousToken = deque.pollFirst();
        }

        Token next = super.nextToken();
        if (next.getType() != SYMBOL) {
            return previousToken = next;
        }

        StringBuilder builder = new StringBuilder();
        while (next.getType() == SYMBOL) {
            builder.append(next.getText());
            next = super.nextToken();
        }
        deque.addLast(nextToken = next);

        List<Token> tokens = findOperatorCombination(builder.toString(), getOperatorType());
        for (int i = tokens.size() - 1; i >= 0; i--) {
            deque.addFirst(tokens.get(i));
        }
        return deque.pollFirst();
    }


    private static List<Token> findOperatorCombination(String sequence, OperatorType type) {
        switch (type) {
        case POSTFIX:
            return getPostfixCombination(sequence);
        case PREFIX:
            return getPrefixCombination(sequence);
        case BINARY:
            return getBinaryCombination(sequence);
        default:
            break;
        }
        return null;
    }

    private static List<Token> getPrefixCombination(String sequence) {
        if (isPrefixOperator(sequence)) {
            List<Token> seq = new ArrayList<Token>(1);
            seq.add(0, new CommonToken(MathParser.PREOP, sequence));
            return seq;
        }
        if (sequence.length() <= 1) {
            return null;
        }

        for (int i = 1; i < sequence.length(); i++) {
            List<Token> seq1 = getPrefixCombination(sequence.substring(0, i));
            List<Token> seq2 = getPrefixCombination(sequence.substring(i, sequence.length()));
            if (seq1 != null & seq2 != null) {
                seq1.addAll(seq2);
                return seq1;
            }
        }
        return null;
    }

    private static List<Token> getPostfixCombination(String sequence) {
        if (isPostfixOperator(sequence)) {
            List<Token> seq = new ArrayList<Token>(1);
            seq.add(0, new CommonToken(MathParser.POSTOP, sequence));
            return seq;
        }
        if (sequence.length() <= 1) {
            return null;
        }

        for (int i = 1; i < sequence.length(); i++) {
            List<Token> seq1 = getPostfixCombination(sequence.substring(0, i));
            List<Token> seq2 = getPostfixCombination(sequence.substring(i, sequence.length()));
            if (seq1 != null && seq2 != null) {
                seq1.addAll(seq2);
                return seq1;
            }
        }
        return null;
    }


    private static List<Token> getBinaryCombination(String sequence) {
        for (int i = 0; i < sequence.length(); i++) { // i is number of postfix spaces
            for (int j = 0; j < sequence.length() - i; j++) { // j is number of prefix spaces
                String seqPost = sequence.substring(0, i);
                List<Token> post = getPostfixCombination(seqPost);

                String seqPre = sequence.substring(sequence.length()-j, sequence.length());
                List<Token> pre = getPrefixCombination(seqPre);

                String seqBin = sequence.substring(i, sequence.length()-j);

                if ((post != null || seqPost.isEmpty()) &&
                    (pre != null || seqPre.isEmpty()) &&
                    isBinaryOperator(seqBin)) {
                    List<Token> res = new ArrayList<Token>();
                    if (post != null)
                        res.addAll(post);
                    res.add(new CommonToken(MathParser.BINOP, seqBin));
                    if (pre != null)
                        res.addAll(pre);
                    return res;
                }
            }
        }
        return null;
    }


    /**
     * Returns the expected operator type based on the previous and next token
     */
    private OperatorType getOperatorType() {
        if (isAfterAtom()) {
            if (isBeforeAtom()) {
                return OperatorType.BINARY;
            }
            return OperatorType.POSTFIX;
        }
        return OperatorType.PREFIX;
    }
    private enum OperatorType { BINARY, PREFIX, POSTFIX };


    /**
     * Checks whether the current token is a token found at the start of atom elements
     * @return
     */
    private boolean isBeforeAtom() {
        int tokenType = nextToken.getType();
        return tokenType == MathParser.INT ||
                tokenType == MathParser.PLEFT;

    }
    /**
     * Checks whether the current token is a token found at the end of atom elements
     * @return
     */
    private boolean isAfterAtom() {
        int tokenType = previousToken.getType();
        return tokenType == MathParser.INT ||
                tokenType == MathParser.PRIGHT;

    }

    private static boolean isBinaryOperator(String operator) {
        return binaryOperators.contains(operator);
    }
    private static boolean isPrefixOperator(String operator) {
        return prefixOperators.contains(operator);
    }
    private static boolean isPostfixOperator(String operator) {
        return postfixOperators.contains(operator);
    }

}

INT
    :   ( '0'..'9' )+
    ;

PLEFT   :   '(';
PRIGHT  :   ')';

WS
    : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

SYMBOL
    :   .
    ;