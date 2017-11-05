// Generated from LatinLexer.g4 by ANTLR 4.7

package org.qcri.rheem.latin.parser;
import java.util.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LatinLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PREOP=1, POSTOP=2, BINOP=3, ERROR=4, OPERATOR_NAME=5, FUNC_NAME=6, PLATFORM=7, 
		NUMBER=8, PLEFT=9, PRIGHT=10, ACCO_LEFT=11, ACCO_RIGHT=12, COR_LEFT=13, 
		COR_RIGHT=14, LOAD=15, AS=16, COLON=17, COMA=18, SEMI_COLON=19, ID=20, 
		ASSING=21, ARROW=22, BOOLEAN=23, INT=24, LONG=25, FLOAT=26, BIGDECIMAL=27, 
		BIGINTEGER=28, DOUBLE=29, DATETIME=30, STRING=31, JSON=32, SQL=33, WITH=34, 
		DOT=35, TRUE=36, FALSE=37, QUOTEDSTRING=38, MULTILINE_QUOTEDSTRING=39, 
		COMMENT=40, WS=41, SYMBOL=42;
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
		"DATETIME", "STRING", "JSON", "SQL", "WITH", "DOT", "TRUE", "FALSE", "QUOTEDSTRING", 
		"MULTILINE_QUOTEDSTRING", "COMMENT", "WS", "SYMBOL"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, "'('", "')'", "'{'", 
		"'}'", "'['", "']'", "'LOAD'", "'AS'", "':'", "','", "';'", null, "'='", 
		"'->'", "'BOOLEAN'", "'INT'", "'LONG'", "'FLOAT'", "'BIGDECIMAL'", "'BIGINTEGER'", 
		"'DOUBLE'", "'DATETIME'", "'STRING'", "'JSON'", "'SQL'", "'WITH'", "'.'", 
		"'true'", "'false'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PREOP", "POSTOP", "BINOP", "ERROR", "OPERATOR_NAME", "FUNC_NAME", 
		"PLATFORM", "NUMBER", "PLEFT", "PRIGHT", "ACCO_LEFT", "ACCO_RIGHT", "COR_LEFT", 
		"COR_RIGHT", "LOAD", "AS", "COLON", "COMA", "SEMI_COLON", "ID", "ASSING", 
		"ARROW", "BOOLEAN", "INT", "LONG", "FLOAT", "BIGDECIMAL", "BIGINTEGER", 
		"DOUBLE", "DATETIME", "STRING", "JSON", "SQL", "WITH", "DOT", "TRUE", 
		"FALSE", "QUOTEDSTRING", "MULTILINE_QUOTEDSTRING", "COMMENT", "WS", "SYMBOL"
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

	    public static void addPlatform(String name){
	        map.put(name, 6);
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
	        case PLATFORM:
	            List<Token> seq = new ArrayList<Token>();
	            seq.add(0, new CommonToken(LatinParser.PLATFORM, sequence));
	            return seq;
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
	            case 6:
	                return OperatorType.PLATFORM;
	            default:
	                break;
	        }
	        return null;
	    }

	    private enum OperatorType { BINARY, PREFIX, POSTFIX, OPERATOR, FUNCTION, PLATFORM };


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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2,\u0117\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\6\2K\n\2\r\2\16\2L\3\3\3\3\3\4\3\4\3\5\3\5"+
		"\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f"+
		"\3\f\3\r\3\r\3\16\3\16\7\16k\n\16\f\16\16\16n\13\16\3\17\3\17\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32"+
		"\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35"+
		"\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 "+
		"\3 \3 \3 \3 \3 \3 \3 \3 \7 \u00df\n \f \16 \u00e2\13 \3 \3 \3!\3!\3!\3"+
		"!\3!\3!\3!\3!\3!\3!\3!\7!\u00f1\n!\f!\16!\u00f4\13!\3!\3!\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\7\"\u0105\n\"\f\"\16\"\u0108"+
		"\13\"\3\"\3\"\3\"\3\"\3\"\3#\6#\u0110\n#\r#\16#\u0111\3#\3#\3$\3$\2\2"+
		"%\3\n\5\13\7\f\t\r\13\16\r\17\17\20\21\21\23\22\25\23\27\24\31\25\33\26"+
		"\35\27\37\30!\31#\32%\33\'\34)\35+\36-\37/ \61!\63\"\65#\67$9%;&=\'?("+
		"A)C*E+G,\3\2\t\6\2//\62;aac|\6\2\f\f\17\17))^^\t\2))DDHHPPTTVV^^\4\2\62"+
		";CH\4\2))^^\13\2))DDHHPPTTVV^^pptt\5\2\13\f\17\17\"\"\2\u0122\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2"+
		"=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\3J\3"+
		"\2\2\2\5N\3\2\2\2\7P\3\2\2\2\tR\3\2\2\2\13T\3\2\2\2\rV\3\2\2\2\17X\3\2"+
		"\2\2\21Z\3\2\2\2\23_\3\2\2\2\25b\3\2\2\2\27d\3\2\2\2\31f\3\2\2\2\33h\3"+
		"\2\2\2\35o\3\2\2\2\37q\3\2\2\2!t\3\2\2\2#|\3\2\2\2%\u0080\3\2\2\2\'\u0085"+
		"\3\2\2\2)\u008b\3\2\2\2+\u0096\3\2\2\2-\u00a1\3\2\2\2/\u00a8\3\2\2\2\61"+
		"\u00b1\3\2\2\2\63\u00b8\3\2\2\2\65\u00bd\3\2\2\2\67\u00c1\3\2\2\29\u00c6"+
		"\3\2\2\2;\u00c8\3\2\2\2=\u00cd\3\2\2\2?\u00d3\3\2\2\2A\u00e5\3\2\2\2C"+
		"\u00f7\3\2\2\2E\u010f\3\2\2\2G\u0115\3\2\2\2IK\4\62;\2JI\3\2\2\2KL\3\2"+
		"\2\2LJ\3\2\2\2LM\3\2\2\2M\4\3\2\2\2NO\7*\2\2O\6\3\2\2\2PQ\7+\2\2Q\b\3"+
		"\2\2\2RS\7}\2\2S\n\3\2\2\2TU\7\177\2\2U\f\3\2\2\2VW\7]\2\2W\16\3\2\2\2"+
		"XY\7_\2\2Y\20\3\2\2\2Z[\7N\2\2[\\\7Q\2\2\\]\7C\2\2]^\7F\2\2^\22\3\2\2"+
		"\2_`\7C\2\2`a\7U\2\2a\24\3\2\2\2bc\7<\2\2c\26\3\2\2\2de\7.\2\2e\30\3\2"+
		"\2\2fg\7=\2\2g\32\3\2\2\2hl\4c|\2ik\t\2\2\2ji\3\2\2\2kn\3\2\2\2lj\3\2"+
		"\2\2lm\3\2\2\2m\34\3\2\2\2nl\3\2\2\2op\7?\2\2p\36\3\2\2\2qr\7/\2\2rs\7"+
		"@\2\2s \3\2\2\2tu\7D\2\2uv\7Q\2\2vw\7Q\2\2wx\7N\2\2xy\7G\2\2yz\7C\2\2"+
		"z{\7P\2\2{\"\3\2\2\2|}\7K\2\2}~\7P\2\2~\177\7V\2\2\177$\3\2\2\2\u0080"+
		"\u0081\7N\2\2\u0081\u0082\7Q\2\2\u0082\u0083\7P\2\2\u0083\u0084\7I\2\2"+
		"\u0084&\3\2\2\2\u0085\u0086\7H\2\2\u0086\u0087\7N\2\2\u0087\u0088\7Q\2"+
		"\2\u0088\u0089\7C\2\2\u0089\u008a\7V\2\2\u008a(\3\2\2\2\u008b\u008c\7"+
		"D\2\2\u008c\u008d\7K\2\2\u008d\u008e\7I\2\2\u008e\u008f\7F\2\2\u008f\u0090"+
		"\7G\2\2\u0090\u0091\7E\2\2\u0091\u0092\7K\2\2\u0092\u0093\7O\2\2\u0093"+
		"\u0094\7C\2\2\u0094\u0095\7N\2\2\u0095*\3\2\2\2\u0096\u0097\7D\2\2\u0097"+
		"\u0098\7K\2\2\u0098\u0099\7I\2\2\u0099\u009a\7K\2\2\u009a\u009b\7P\2\2"+
		"\u009b\u009c\7V\2\2\u009c\u009d\7G\2\2\u009d\u009e\7I\2\2\u009e\u009f"+
		"\7G\2\2\u009f\u00a0\7T\2\2\u00a0,\3\2\2\2\u00a1\u00a2\7F\2\2\u00a2\u00a3"+
		"\7Q\2\2\u00a3\u00a4\7W\2\2\u00a4\u00a5\7D\2\2\u00a5\u00a6\7N\2\2\u00a6"+
		"\u00a7\7G\2\2\u00a7.\3\2\2\2\u00a8\u00a9\7F\2\2\u00a9\u00aa\7C\2\2\u00aa"+
		"\u00ab\7V\2\2\u00ab\u00ac\7G\2\2\u00ac\u00ad\7V\2\2\u00ad\u00ae\7K\2\2"+
		"\u00ae\u00af\7O\2\2\u00af\u00b0\7G\2\2\u00b0\60\3\2\2\2\u00b1\u00b2\7"+
		"U\2\2\u00b2\u00b3\7V\2\2\u00b3\u00b4\7T\2\2\u00b4\u00b5\7K\2\2\u00b5\u00b6"+
		"\7P\2\2\u00b6\u00b7\7I\2\2\u00b7\62\3\2\2\2\u00b8\u00b9\7L\2\2\u00b9\u00ba"+
		"\7U\2\2\u00ba\u00bb\7Q\2\2\u00bb\u00bc\7P\2\2\u00bc\64\3\2\2\2\u00bd\u00be"+
		"\7U\2\2\u00be\u00bf\7S\2\2\u00bf\u00c0\7N\2\2\u00c0\66\3\2\2\2\u00c1\u00c2"+
		"\7Y\2\2\u00c2\u00c3\7K\2\2\u00c3\u00c4\7V\2\2\u00c4\u00c5\7J\2\2\u00c5"+
		"8\3\2\2\2\u00c6\u00c7\7\60\2\2\u00c7:\3\2\2\2\u00c8\u00c9\7v\2\2\u00c9"+
		"\u00ca\7t\2\2\u00ca\u00cb\7w\2\2\u00cb\u00cc\7g\2\2\u00cc<\3\2\2\2\u00cd"+
		"\u00ce\7h\2\2\u00ce\u00cf\7c\2\2\u00cf\u00d0\7n\2\2\u00d0\u00d1\7u\2\2"+
		"\u00d1\u00d2\7g\2\2\u00d2>\3\2\2\2\u00d3\u00e0\7)\2\2\u00d4\u00df\n\3"+
		"\2\2\u00d5\u00d6\7^\2\2\u00d6\u00df\t\4\2\2\u00d7\u00d8\7^\2\2\u00d8\u00d9"+
		"\7W\2\2\u00d9\u00da\3\2\2\2\u00da\u00db\t\5\2\2\u00db\u00dc\t\5\2\2\u00dc"+
		"\u00dd\t\5\2\2\u00dd\u00df\t\5\2\2\u00de\u00d4\3\2\2\2\u00de\u00d5\3\2"+
		"\2\2\u00de\u00d7\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0"+
		"\u00e1\3\2\2\2\u00e1\u00e3\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00e4\7)"+
		"\2\2\u00e4@\3\2\2\2\u00e5\u00f2\7)\2\2\u00e6\u00f1\n\6\2\2\u00e7\u00e8"+
		"\7^\2\2\u00e8\u00f1\t\7\2\2\u00e9\u00ea\7^\2\2\u00ea\u00eb\7W\2\2\u00eb"+
		"\u00ec\3\2\2\2\u00ec\u00ed\t\5\2\2\u00ed\u00ee\t\5\2\2\u00ee\u00ef\t\5"+
		"\2\2\u00ef\u00f1\t\5\2\2\u00f0\u00e6\3\2\2\2\u00f0\u00e7\3\2\2\2\u00f0"+
		"\u00e9\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2"+
		"\2\2\u00f3\u00f5\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f6\7)\2\2\u00f6"+
		"B\3\2\2\2\u00f7\u00f8\7^\2\2\u00f8\u00f9\7,\2\2\u00f9\u0106\3\2\2\2\u00fa"+
		"\u0105\n\6\2\2\u00fb\u00fc\7^\2\2\u00fc\u0105\t\7\2\2\u00fd\u00fe\7^\2"+
		"\2\u00fe\u00ff\7W\2\2\u00ff\u0100\3\2\2\2\u0100\u0101\t\5\2\2\u0101\u0102"+
		"\t\5\2\2\u0102\u0103\t\5\2\2\u0103\u0105\t\5\2\2\u0104\u00fa\3\2\2\2\u0104"+
		"\u00fb\3\2\2\2\u0104\u00fd\3\2\2\2\u0105\u0108\3\2\2\2\u0106\u0104\3\2"+
		"\2\2\u0106\u0107\3\2\2\2\u0107\u0109\3\2\2\2\u0108\u0106\3\2\2\2\u0109"+
		"\u010a\7,\2\2\u010a\u010b\7^\2\2\u010b\u010c\3\2\2\2\u010c\u010d\b\"\2"+
		"\2\u010dD\3\2\2\2\u010e\u0110\t\b\2\2\u010f\u010e\3\2\2\2\u0110\u0111"+
		"\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0113\3\2\2\2\u0113"+
		"\u0114\b#\2\2\u0114F\3\2\2\2\u0115\u0116\13\2\2\2\u0116H\3\2\2\2\f\2L"+
		"l\u00de\u00e0\u00f0\u00f2\u0104\u0106\u0111\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}