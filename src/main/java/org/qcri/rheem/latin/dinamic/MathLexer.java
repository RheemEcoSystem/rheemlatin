// Generated from /Users/bertty/Qatar/xxxx/src/main/java/org/qcri/rheem/latin/dinamic/MathLexer.g4 by ANTLR 4.6
package org.qcri.rheem.latin.dinamic;

    import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MathLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PREOP=1, POSTOP=2, BINOP=3, ERROR=4, INT=5, PLEFT=6, PRIGHT=7, WS=8, SYMBOL=9;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"INT", "PLEFT", "PRIGHT", "WS", "SYMBOL"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PREOP", "POSTOP", "BINOP", "ERROR", "INT", "PLEFT", "PRIGHT", "WS", 
		"SYMBOL"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}



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



	public MathLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MathLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\13\37\b\1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\6\2\17\n\2\r\2\16\2\20\3\3\3\3\3"+
		"\4\3\4\3\5\6\5\30\n\5\r\5\16\5\31\3\5\3\5\3\6\3\6\2\2\7\3\7\5\b\7\t\t"+
		"\n\13\13\3\2\3\5\2\13\f\17\17\"\" \2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\3\16\3\2\2\2\5\22\3\2\2\2\7\24\3\2\2\2\t\27"+
		"\3\2\2\2\13\35\3\2\2\2\r\17\4\62;\2\16\r\3\2\2\2\17\20\3\2\2\2\20\16\3"+
		"\2\2\2\20\21\3\2\2\2\21\4\3\2\2\2\22\23\7*\2\2\23\6\3\2\2\2\24\25\7+\2"+
		"\2\25\b\3\2\2\2\26\30\t\2\2\2\27\26\3\2\2\2\30\31\3\2\2\2\31\27\3\2\2"+
		"\2\31\32\3\2\2\2\32\33\3\2\2\2\33\34\b\5\2\2\34\n\3\2\2\2\35\36\13\2\2"+
		"\2\36\f\3\2\2\2\5\2\20\31\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}