// Generated from /Users/bertty/Qatar/xxxx/src/main/java/org/qcri/rheem/latin/parser/LatinLexer.g4 by ANTLR 4.7
package org.qcri.rheem.latin.parser;

    import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

import java.util.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LatinLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PREOP=1, POSTOP=2, BINOP=3, ERROR=4, OPERATOR_NAME=5, FUNC_NAME=6, NUMBER=7, 
		PLEFT=8, PRIGHT=9, ACCO_LEFT=10, ACCO_RIGHT=11, COR_LEFT=12, COR_RIGHT=13, 
		LOAD=14, AS=15, COLON=16, COMA=17, SEMI_COLON=18, ID=19, ASSING=20, ARROW=21, 
		BOOLEAN=22, INT=23, LONG=24, FLOAT=25, BIGDECIMAL=26, BIGINTEGER=27, DOUBLE=28, 
		DATETIME=29, STRING=30, JSON=31, SQL=32, DOT=33, TRUE=34, FALSE=35, QUOTEDSTRING=36, 
		MULTILINE_QUOTEDSTRING=37, COMMENT=38, WS=39, SYMBOL=40;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"NUMBER", "PLEFT", "PRIGHT", "ACCO_LEFT", "ACCO_RIGHT", "COR_LEFT", "COR_RIGHT", 
		"LOAD", "AS", "COLON", "COMA", "SEMI_COLON", "ID", "ASSING", "ARROW", 
		"BOOLEAN", "INT", "LONG", "FLOAT", "BIGDECIMAL", "BIGINTEGER", "DOUBLE", 
		"DATETIME", "STRING", "JSON", "SQL", "DOT", "TRUE", "FALSE", "QUOTEDSTRING", 
		"MULTILINE_QUOTEDSTRING", "COMMENT", "WS", "SYMBOL"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, "'('", "')'", "'{'", "'}'", 
		"'['", "']'", "'LOAD'", "'AS'", "':'", "','", "';'", null, "'='", "'->'", 
		"'BOOLEAN'", "'INT'", "'LONG'", "'FLOAT'", "'BIGDECIMAL'", "'BIGINTEGER'", 
		"'DOUBLE'", "'DATETIME'", "'STRING'", "'JSON'", "'SQL'", "'.'", "'true'", 
		"'false'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PREOP", "POSTOP", "BINOP", "ERROR", "OPERATOR_NAME", "FUNC_NAME", 
		"NUMBER", "PLEFT", "PRIGHT", "ACCO_LEFT", "ACCO_RIGHT", "COR_LEFT", "COR_RIGHT", 
		"LOAD", "AS", "COLON", "COMA", "SEMI_COLON", "ID", "ASSING", "ARROW", 
		"BOOLEAN", "INT", "LONG", "FLOAT", "BIGDECIMAL", "BIGINTEGER", "DOUBLE", 
		"DATETIME", "STRING", "JSON", "SQL", "DOT", "TRUE", "FALSE", "QUOTEDSTRING", 
		"MULTILINE_QUOTEDSTRING", "COMMENT", "WS", "SYMBOL"
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



	    private static final int    BINARY  = 0;
	    private static List<String> binaryOperators  = new ArrayList<>();
	    private static List<String> prefixOperators  = new ArrayList<>();
	    private static List<String> postfixOperators = new ArrayList<>();
	    private static List<String> nameOperators    = new ArrayList<>();
	    private static List<String> nameFunctions    = new ArrayList<>();

	    private static Map<String, Integer>      map = new HashMap<>();


	    public static void addBinaryOperator(String operator){
	        binaryOperators.add(operator);
	        map.put(operator, 1);
	    }

	    public static void addPrefixOperator(String operator){
	        prefixOperators.add(operator);
	        map.put(operator, 2);
	    }

	    public static void addPostfixOperator(String operator){
	        postfixOperators.add(operator);
	        map.put(operator, 3);
	    }

	    public static void addOperator(String name){
	        nameOperators.add(name);
	        map.put(name, 4);
	    }

	    public static void addFunction(String name){
	        nameFunctions.add(name);
	        map.put(name, 5);
	    }

	    private Deque<Token> deque = new LinkedList<Token>();

	    private Token previousToken;
	    private Token nextToken;

	    @Override
	    public Token nextToken() {
	        Token next;
	        if (!deque.isEmpty()) {
	            next = deque.pollFirst();
	        }else{
	            next = super.nextToken();
	        }

	        if (next.getType() != SYMBOL) {
	            return previousToken = next;
	        }

	        StringBuilder builder = new StringBuilder();
	        int anterior = next.getStartIndex();
	        boolean flag = true;
	        while (next.getType() == SYMBOL && flag == true) {
	            if(next.getStartIndex() - anterior > 1){
	                flag = false;
	            }else {
	                builder.append(next.getText());
	                anterior = next.getStartIndex();
	                next = super.nextToken();
	            }
	        }
	        deque.addLast(nextToken = next);

	        List<Token> tokens = findOperatorCombination(builder.toString(), getOperatorType(builder.toString()));
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
	        case OPERATOR:
	            return getOperatorCombination(sequence);
	        case FUNCTION:
	            return getFunctionCombination(sequence);
	        default:
	            break;
	        }
	        return null;
	    }

	    private static List<Token> getOperatorCombination(String sequence){
	        List<Token> seq = new ArrayList<Token>();
	        seq.add(0, new CommonToken(LatinParser.OPERATOR_NAME, sequence));
	        return seq;
	    }

	    private static List<Token> getFunctionCombination(String sequence){
	        List<Token> seq = new ArrayList<Token>();
	        seq.add(0, new CommonToken(LatinParser.FUNC_NAME, sequence));
	        return seq;
	    }
	    private static List<Token> getPrefixCombination(String sequence) {
	        if (isPrefixOperator(sequence)) {
	            List<Token> seq = new ArrayList<Token>(1);
	            seq.add(0, new CommonToken(LatinParser.PREOP, sequence));
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
	            seq.add(0, new CommonToken(LatinParser.POSTOP, sequence));
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
	                    res.add(new CommonToken(LatinParser.BINOP, seqBin));
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
	    private OperatorType getOperatorType(String operator) {
	       /* if (isAfterAtom()) {
	            if (isBeforeAtom()) {
	                return OperatorType.BINARY;
	            }
	            return OperatorType.POSTFIX;
	        }
	        return OperatorType.PREFIX;*/
			switch(map.get(operator)){
	            case 1:
	                return OperatorType.BINARY;
	            case 2:
	                return OperatorType.PREFIX;
	            case 3:
	                return OperatorType.POSTFIX;
	            case 4:
	                return OperatorType.OPERATOR;
	            case 5:
	                return OperatorType.FUNCTION;
	            default:
	                break;
	        }
	        return null;
	    }

	    private enum OperatorType { BINARY, PREFIX, POSTFIX, OPERATOR, FUNCTION };


	    /**
	     * Checks whether the current token is a token found at the start of atom elements
	     * @return
	     */
	    private boolean isBeforeAtom() {
	        int tokenType = nextToken.getType();
	        return tokenType == LatinParser.INT ||
	                tokenType == LatinParser.PLEFT;
	    }

	    /**
	     * Checks whether the current token is a token found at the end of atom elements
	     * @return
	     */
	    private boolean isAfterAtom() {
	        int tokenType = previousToken.getType();
	        return tokenType == LatinParser.INT ||
	                tokenType == LatinParser.PRIGHT;

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



	public LatinLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LatinLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2*\u0110\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\6\2I\n\2\r\2\16\2J\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3"+
		"\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3"+
		"\r\3\r\3\16\3\16\7\16i\n\16\f\16\16\16l\13\16\3\17\3\17\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32"+
		"\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\35\3\35"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\7\37\u00d8\n\37\f\37\16\37\u00db\13\37\3\37\3\37\3 \3"+
		" \3 \3 \3 \3 \3 \3 \3 \3 \3 \7 \u00ea\n \f \16 \u00ed\13 \3 \3 \3!\3!"+
		"\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\7!\u00fe\n!\f!\16!\u0101\13!\3!\3!\3"+
		"!\3!\3!\3\"\6\"\u0109\n\"\r\"\16\"\u010a\3\"\3\"\3#\3#\2\2$\3\t\5\n\7"+
		"\13\t\f\13\r\r\16\17\17\21\20\23\21\25\22\27\23\31\24\33\25\35\26\37\27"+
		"!\30#\31%\32\'\33)\34+\35-\36/\37\61 \63!\65\"\67#9$;%=&?\'A(C)E*\3\2"+
		"\t\6\2//\62;aac|\6\2\f\f\17\17))^^\t\2))DDHHPPTTVV^^\4\2\62;CH\4\2))^"+
		"^\13\2))DDHHPPTTVV^^pptt\5\2\13\f\17\17\"\"\2\u011b\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63"+
		"\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2"+
		"?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\3H\3\2\2\2\5L\3\2\2\2\7N\3"+
		"\2\2\2\tP\3\2\2\2\13R\3\2\2\2\rT\3\2\2\2\17V\3\2\2\2\21X\3\2\2\2\23]\3"+
		"\2\2\2\25`\3\2\2\2\27b\3\2\2\2\31d\3\2\2\2\33f\3\2\2\2\35m\3\2\2\2\37"+
		"o\3\2\2\2!r\3\2\2\2#z\3\2\2\2%~\3\2\2\2\'\u0083\3\2\2\2)\u0089\3\2\2\2"+
		"+\u0094\3\2\2\2-\u009f\3\2\2\2/\u00a6\3\2\2\2\61\u00af\3\2\2\2\63\u00b6"+
		"\3\2\2\2\65\u00bb\3\2\2\2\67\u00bf\3\2\2\29\u00c1\3\2\2\2;\u00c6\3\2\2"+
		"\2=\u00cc\3\2\2\2?\u00de\3\2\2\2A\u00f0\3\2\2\2C\u0108\3\2\2\2E\u010e"+
		"\3\2\2\2GI\4\62;\2HG\3\2\2\2IJ\3\2\2\2JH\3\2\2\2JK\3\2\2\2K\4\3\2\2\2"+
		"LM\7*\2\2M\6\3\2\2\2NO\7+\2\2O\b\3\2\2\2PQ\7}\2\2Q\n\3\2\2\2RS\7\177\2"+
		"\2S\f\3\2\2\2TU\7]\2\2U\16\3\2\2\2VW\7_\2\2W\20\3\2\2\2XY\7N\2\2YZ\7Q"+
		"\2\2Z[\7C\2\2[\\\7F\2\2\\\22\3\2\2\2]^\7C\2\2^_\7U\2\2_\24\3\2\2\2`a\7"+
		"<\2\2a\26\3\2\2\2bc\7.\2\2c\30\3\2\2\2de\7=\2\2e\32\3\2\2\2fj\4c|\2gi"+
		"\t\2\2\2hg\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2k\34\3\2\2\2lj\3\2\2\2"+
		"mn\7?\2\2n\36\3\2\2\2op\7/\2\2pq\7@\2\2q \3\2\2\2rs\7D\2\2st\7Q\2\2tu"+
		"\7Q\2\2uv\7N\2\2vw\7G\2\2wx\7C\2\2xy\7P\2\2y\"\3\2\2\2z{\7K\2\2{|\7P\2"+
		"\2|}\7V\2\2}$\3\2\2\2~\177\7N\2\2\177\u0080\7Q\2\2\u0080\u0081\7P\2\2"+
		"\u0081\u0082\7I\2\2\u0082&\3\2\2\2\u0083\u0084\7H\2\2\u0084\u0085\7N\2"+
		"\2\u0085\u0086\7Q\2\2\u0086\u0087\7C\2\2\u0087\u0088\7V\2\2\u0088(\3\2"+
		"\2\2\u0089\u008a\7D\2\2\u008a\u008b\7K\2\2\u008b\u008c\7I\2\2\u008c\u008d"+
		"\7F\2\2\u008d\u008e\7G\2\2\u008e\u008f\7E\2\2\u008f\u0090\7K\2\2\u0090"+
		"\u0091\7O\2\2\u0091\u0092\7C\2\2\u0092\u0093\7N\2\2\u0093*\3\2\2\2\u0094"+
		"\u0095\7D\2\2\u0095\u0096\7K\2\2\u0096\u0097\7I\2\2\u0097\u0098\7K\2\2"+
		"\u0098\u0099\7P\2\2\u0099\u009a\7V\2\2\u009a\u009b\7G\2\2\u009b\u009c"+
		"\7I\2\2\u009c\u009d\7G\2\2\u009d\u009e\7T\2\2\u009e,\3\2\2\2\u009f\u00a0"+
		"\7F\2\2\u00a0\u00a1\7Q\2\2\u00a1\u00a2\7W\2\2\u00a2\u00a3\7D\2\2\u00a3"+
		"\u00a4\7N\2\2\u00a4\u00a5\7G\2\2\u00a5.\3\2\2\2\u00a6\u00a7\7F\2\2\u00a7"+
		"\u00a8\7C\2\2\u00a8\u00a9\7V\2\2\u00a9\u00aa\7G\2\2\u00aa\u00ab\7V\2\2"+
		"\u00ab\u00ac\7K\2\2\u00ac\u00ad\7O\2\2\u00ad\u00ae\7G\2\2\u00ae\60\3\2"+
		"\2\2\u00af\u00b0\7U\2\2\u00b0\u00b1\7V\2\2\u00b1\u00b2\7T\2\2\u00b2\u00b3"+
		"\7K\2\2\u00b3\u00b4\7P\2\2\u00b4\u00b5\7I\2\2\u00b5\62\3\2\2\2\u00b6\u00b7"+
		"\7L\2\2\u00b7\u00b8\7U\2\2\u00b8\u00b9\7Q\2\2\u00b9\u00ba\7P\2\2\u00ba"+
		"\64\3\2\2\2\u00bb\u00bc\7U\2\2\u00bc\u00bd\7S\2\2\u00bd\u00be\7N\2\2\u00be"+
		"\66\3\2\2\2\u00bf\u00c0\7\60\2\2\u00c08\3\2\2\2\u00c1\u00c2\7v\2\2\u00c2"+
		"\u00c3\7t\2\2\u00c3\u00c4\7w\2\2\u00c4\u00c5\7g\2\2\u00c5:\3\2\2\2\u00c6"+
		"\u00c7\7h\2\2\u00c7\u00c8\7c\2\2\u00c8\u00c9\7n\2\2\u00c9\u00ca\7u\2\2"+
		"\u00ca\u00cb\7g\2\2\u00cb<\3\2\2\2\u00cc\u00d9\7)\2\2\u00cd\u00d8\n\3"+
		"\2\2\u00ce\u00cf\7^\2\2\u00cf\u00d8\t\4\2\2\u00d0\u00d1\7^\2\2\u00d1\u00d2"+
		"\7W\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\t\5\2\2\u00d4\u00d5\t\5\2\2\u00d5"+
		"\u00d6\t\5\2\2\u00d6\u00d8\t\5\2\2\u00d7\u00cd\3\2\2\2\u00d7\u00ce\3\2"+
		"\2\2\u00d7\u00d0\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9"+
		"\u00da\3\2\2\2\u00da\u00dc\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00dd\7)"+
		"\2\2\u00dd>\3\2\2\2\u00de\u00eb\7)\2\2\u00df\u00ea\n\6\2\2\u00e0\u00e1"+
		"\7^\2\2\u00e1\u00ea\t\7\2\2\u00e2\u00e3\7^\2\2\u00e3\u00e4\7W\2\2\u00e4"+
		"\u00e5\3\2\2\2\u00e5\u00e6\t\5\2\2\u00e6\u00e7\t\5\2\2\u00e7\u00e8\t\5"+
		"\2\2\u00e8\u00ea\t\5\2\2\u00e9\u00df\3\2\2\2\u00e9\u00e0\3\2\2\2\u00e9"+
		"\u00e2\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2"+
		"\2\2\u00ec\u00ee\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00ef\7)\2\2\u00ef"+
		"@\3\2\2\2\u00f0\u00f1\7^\2\2\u00f1\u00f2\7,\2\2\u00f2\u00ff\3\2\2\2\u00f3"+
		"\u00fe\n\6\2\2\u00f4\u00f5\7^\2\2\u00f5\u00fe\t\7\2\2\u00f6\u00f7\7^\2"+
		"\2\u00f7\u00f8\7W\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\t\5\2\2\u00fa\u00fb"+
		"\t\5\2\2\u00fb\u00fc\t\5\2\2\u00fc\u00fe\t\5\2\2\u00fd\u00f3\3\2\2\2\u00fd"+
		"\u00f4\3\2\2\2\u00fd\u00f6\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff\u00fd\3\2"+
		"\2\2\u00ff\u0100\3\2\2\2\u0100\u0102\3\2\2\2\u0101\u00ff\3\2\2\2\u0102"+
		"\u0103\7,\2\2\u0103\u0104\7^\2\2\u0104\u0105\3\2\2\2\u0105\u0106\b!\2"+
		"\2\u0106B\3\2\2\2\u0107\u0109\t\b\2\2\u0108\u0107\3\2\2\2\u0109\u010a"+
		"\3\2\2\2\u010a\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010c\3\2\2\2\u010c"+
		"\u010d\b\"\2\2\u010dD\3\2\2\2\u010e\u010f\13\2\2\2\u010fF\3\2\2\2\f\2"+
		"Jj\u00d7\u00d9\u00e9\u00eb\u00fd\u00ff\u010a\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}