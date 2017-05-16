// Generated from /Users/bertty/Qatar/xxxx/src/main/java/org/qcri/rheem/latin/parser/LatinParser.g4 by ANTLR 4.7
package org.qcri.rheem.latin.parser;

    import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LatinParser extends Parser {
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
	public static final int
		RULE_query = 0, RULE_statement = 1, RULE_operator_statement = 2, RULE_lambda = 3, 
		RULE_type = 4, RULE_source_statement = 5, RULE_as_clause = 6, RULE_type_load = 7, 
		RULE_pair = 8, RULE_sink_statement = 9, RULE_expr = 10, RULE_atom = 11, 
		RULE_functionExpr = 12, RULE_constant = 13, RULE_sub_id = 14, RULE_boolean_const = 15;
	public static final String[] ruleNames = {
		"query", "statement", "operator_statement", "lambda", "type", "source_statement", 
		"as_clause", "type_load", "pair", "sink_statement", "expr", "atom", "functionExpr", 
		"constant", "sub_id", "boolean_const"
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

	@Override
	public String getGrammarFileName() { return "LatinParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    private static final int    BINARY  = 0;
	    static Map<String, Integer> precedenceMap = new HashMap<String, Integer>();
	    static Map<String, Integer> operatorMap   = new HashMap<String, Integer>();
	    static Map<String, Integer> functionMap   = new HashMap<String, Integer>();


	    public static void addPrecedenceMap(String symbol, int code){
	        precedenceMap.put(symbol, code);
	    }

	    public static Integer getPrecedence(Token op) {
	        Integer tmp = precedenceMap.get(op.getText());
	        return (tmp != null)? tmp: -1;
	    }

	    public static Integer getNextPrecedence(Token op) {
	        Integer p = getPrecedence(op);
	        if (op.getType() == PREOP)              return p;
	        else if (op.getType() == BINOP)         return p+1;
	        else if (op.getType() == POSTOP)        return p+1;
	        else if (op.getType() == OPERATOR_NAME) return p+1;
	        else if (op.getType() == FUNC_NAME)     return p+1;
	        throw new IllegalArgumentException(op.getText());
	    }

	    public static void addOperatorMap(String symbol, int code){
	        operatorMap.put(symbol, code);
	    }

	    public static void addFunctionMap(String symbol, int code){
	        functionMap.put(symbol, code);
	    }

	public LatinParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class QueryContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).exitQuery(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_query);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPERATOR_NAME || _la==ID) {
				{
				{
				setState(32);
				statement();
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SinkStatementContext extends StatementContext {
		public Sink_statementContext sink_statement() {
			return getRuleContext(Sink_statementContext.class,0);
		}
		public TerminalNode SEMI_COLON() { return getToken(LatinParser.SEMI_COLON, 0); }
		public SinkStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).enterSinkStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).exitSinkStatement(this);
		}
	}
	public static class BaseStatementContext extends StatementContext {
		public TerminalNode ID() { return getToken(LatinParser.ID, 0); }
		public TerminalNode ASSING() { return getToken(LatinParser.ASSING, 0); }
		public TerminalNode SEMI_COLON() { return getToken(LatinParser.SEMI_COLON, 0); }
		public Operator_statementContext operator_statement() {
			return getRuleContext(Operator_statementContext.class,0);
		}
		public Source_statementContext source_statement() {
			return getRuleContext(Source_statementContext.class,0);
		}
		public BaseStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).enterBaseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).exitBaseStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new BaseStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				match(ID);
				setState(39);
				match(ASSING);
				setState(42);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case OPERATOR_NAME:
					{
					setState(40);
					operator_statement();
					}
					break;
				case LOAD:
					{
					setState(41);
					source_statement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(44);
				match(SEMI_COLON);
				}
				break;
			case OPERATOR_NAME:
				_localctx = new SinkStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				sink_statement();
				setState(47);
				match(SEMI_COLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Operator_statementContext extends ParserRuleContext {
		public Operator_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator_statement; }
	 
		public Operator_statementContext() { }
		public void copyFrom(Operator_statementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class OperatorStatementContext extends Operator_statementContext {
		public Token name;
		public TerminalNode OPERATOR_NAME() { return getToken(LatinParser.OPERATOR_NAME, 0); }
		public List<LambdaContext> lambda() {
			return getRuleContexts(LambdaContext.class);
		}
		public LambdaContext lambda(int i) {
			return getRuleContext(LambdaContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(LatinParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(LatinParser.COMA, i);
		}
		public OperatorStatementContext(Operator_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).enterOperatorStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).exitOperatorStatement(this);
		}
	}

	public final Operator_statementContext operator_statement() throws RecognitionException {
		Operator_statementContext _localctx = new Operator_statementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_operator_statement);
		int _la;
		try {
			_localctx = new OperatorStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			((OperatorStatementContext)_localctx).name = match(OPERATOR_NAME);
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PREOP) | (1L << FUNC_NAME) | (1L << NUMBER) | (1L << PLEFT) | (1L << ID) | (1L << TRUE) | (1L << FALSE) | (1L << QUOTEDSTRING))) != 0)) {
				{
				setState(52);
				lambda();
				}
			}

			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(55);
				match(COMA);
				setState(56);
				lambda();
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdaContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LatinParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(LatinParser.ARROW, 0); }
		public TerminalNode ACCO_LEFT() { return getToken(LatinParser.ACCO_LEFT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ACCO_RIGHT() { return getToken(LatinParser.ACCO_RIGHT, 0); }
		public LambdaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).enterLambda(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).exitLambda(this);
		}
	}

	public final LambdaContext lambda() throws RecognitionException {
		LambdaContext _localctx = new LambdaContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_lambda);
		int _la;
		try {
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				match(ID);
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(63);
					type();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				match(ID);
				setState(67);
				match(ARROW);
				setState(68);
				match(ACCO_LEFT);
				setState(69);
				expr(0);
				setState(70);
				match(ACCO_RIGHT);
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(71);
					type();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				expr(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(LatinParser.COLON, 0); }
		public TerminalNode BOOLEAN() { return getToken(LatinParser.BOOLEAN, 0); }
		public TerminalNode INT() { return getToken(LatinParser.INT, 0); }
		public TerminalNode LONG() { return getToken(LatinParser.LONG, 0); }
		public TerminalNode FLOAT() { return getToken(LatinParser.FLOAT, 0); }
		public TerminalNode BIGDECIMAL() { return getToken(LatinParser.BIGDECIMAL, 0); }
		public TerminalNode BIGINTEGER() { return getToken(LatinParser.BIGINTEGER, 0); }
		public TerminalNode DOUBLE() { return getToken(LatinParser.DOUBLE, 0); }
		public TerminalNode DATETIME() { return getToken(LatinParser.DATETIME, 0); }
		public TerminalNode STRING() { return getToken(LatinParser.STRING, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(COLON);
			setState(78);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INT) | (1L << LONG) | (1L << FLOAT) | (1L << BIGDECIMAL) | (1L << BIGINTEGER) | (1L << DOUBLE) | (1L << DATETIME) | (1L << STRING))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Source_statementContext extends ParserRuleContext {
		public TerminalNode LOAD() { return getToken(LatinParser.LOAD, 0); }
		public TerminalNode QUOTEDSTRING() { return getToken(LatinParser.QUOTEDSTRING, 0); }
		public List<As_clauseContext> as_clause() {
			return getRuleContexts(As_clauseContext.class);
		}
		public As_clauseContext as_clause(int i) {
			return getRuleContext(As_clauseContext.class,i);
		}
		public Source_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_source_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).enterSource_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).exitSource_statement(this);
		}
	}

	public final Source_statementContext source_statement() throws RecognitionException {
		Source_statementContext _localctx = new Source_statementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_source_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(LOAD);
			setState(81);
			match(QUOTEDSTRING);
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AS) {
				{
				{
				setState(82);
				as_clause();
				}
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class As_clauseContext extends ParserRuleContext {
		public TerminalNode AS() { return getToken(LatinParser.AS, 0); }
		public TerminalNode PLEFT() { return getToken(LatinParser.PLEFT, 0); }
		public PairContext pair() {
			return getRuleContext(PairContext.class,0);
		}
		public TerminalNode PRIGHT() { return getToken(LatinParser.PRIGHT, 0); }
		public Type_loadContext type_load() {
			return getRuleContext(Type_loadContext.class,0);
		}
		public As_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_as_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).enterAs_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).exitAs_clause(this);
		}
	}

	public final As_clauseContext as_clause() throws RecognitionException {
		As_clauseContext _localctx = new As_clauseContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_as_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(AS);
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << JSON) | (1L << SQL))) != 0)) {
				{
				setState(89);
				type_load();
				}
			}

			setState(92);
			match(PLEFT);
			setState(93);
			pair();
			setState(94);
			match(PRIGHT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_loadContext extends ParserRuleContext {
		public TerminalNode JSON() { return getToken(LatinParser.JSON, 0); }
		public TerminalNode ID() { return getToken(LatinParser.ID, 0); }
		public TerminalNode SQL() { return getToken(LatinParser.SQL, 0); }
		public Type_loadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_load; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).enterType_load(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).exitType_load(this);
		}
	}

	public final Type_loadContext type_load() throws RecognitionException {
		Type_loadContext _localctx = new Type_loadContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type_load);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << JSON) | (1L << SQL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PairContext extends ParserRuleContext {
		public List<TerminalNode> QUOTEDSTRING() { return getTokens(LatinParser.QUOTEDSTRING); }
		public TerminalNode QUOTEDSTRING(int i) {
			return getToken(LatinParser.QUOTEDSTRING, i);
		}
		public List<TerminalNode> ID() { return getTokens(LatinParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LatinParser.ID, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(LatinParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(LatinParser.COMA, i);
		}
		public PairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).enterPair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).exitPair(this);
		}
	}

	public final PairContext pair() throws RecognitionException {
		PairContext _localctx = new PairContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_pair);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID || _la==QUOTEDSTRING) {
				{
				setState(116);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case QUOTEDSTRING:
					{
					{
					setState(98);
					match(QUOTEDSTRING);
					setState(103);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMA) {
						{
						{
						setState(99);
						match(COMA);
						setState(100);
						match(QUOTEDSTRING);
						}
						}
						setState(105);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				case ID:
					{
					{
					setState(106);
					match(ID);
					setState(107);
					type();
					setState(113);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMA) {
						{
						{
						setState(108);
						match(COMA);
						setState(109);
						match(ID);
						setState(110);
						type();
						}
						}
						setState(115);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sink_statementContext extends ParserRuleContext {
		public Token name;
		public TerminalNode ID() { return getToken(LatinParser.ID, 0); }
		public TerminalNode QUOTEDSTRING() { return getToken(LatinParser.QUOTEDSTRING, 0); }
		public TerminalNode OPERATOR_NAME() { return getToken(LatinParser.OPERATOR_NAME, 0); }
		public Sink_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sink_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).enterSink_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).exitSink_statement(this);
		}
	}

	public final Sink_statementContext sink_statement() throws RecognitionException {
		Sink_statementContext _localctx = new Sink_statementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_sink_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			((Sink_statementContext)_localctx).name = match(OPERATOR_NAME);
			setState(122);
			match(ID);
			setState(123);
			match(QUOTEDSTRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public int _p;
		public Token op;
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> BINOP() { return getTokens(LatinParser.BINOP); }
		public TerminalNode BINOP(int i) {
			return getToken(LatinParser.BINOP, i);
		}
		public List<TerminalNode> POSTOP() { return getTokens(LatinParser.POSTOP); }
		public TerminalNode POSTOP(int i) {
			return getToken(LatinParser.POSTOP, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExprContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr(int _p) throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState(), _p);
		enterRule(_localctx, 20, RULE_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			atom();
			setState(133);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(131);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						setState(126);
						if (!(getPrecedence(_input.LT(1)) >= _localctx._p)) throw new FailedPredicateException(this, "getPrecedence(_input.LT(1)) >= $_p");
						setState(127);
						((ExprContext)_localctx).op = match(BINOP);
						setState(128);
						expr(getNextPrecedence(((ExprContext)_localctx).op));
						}
						break;
					case 2:
						{
						setState(129);
						if (!(getPrecedence(_input.LT(1)) >= _localctx._p)) throw new FailedPredicateException(this, "getPrecedence(_input.LT(1)) >= $_p");
						setState(130);
						((ExprContext)_localctx).op = match(POSTOP);
						}
						break;
					}
					} 
				}
				setState(135);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunctionExpressionContext extends AtomContext {
		public FunctionExprContext functionExpr() {
			return getRuleContext(FunctionExprContext.class,0);
		}
		public FunctionExpressionContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).enterFunctionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).exitFunctionExpression(this);
		}
	}
	public static class PrefixExpressionContext extends AtomContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PREOP() { return getToken(LatinParser.PREOP, 0); }
		public PrefixExpressionContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).enterPrefixExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).exitPrefixExpression(this);
		}
	}
	public static class ParenExpressionContext extends AtomContext {
		public TerminalNode PLEFT() { return getToken(LatinParser.PLEFT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PRIGHT() { return getToken(LatinParser.PRIGHT, 0); }
		public ParenExpressionContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).enterParenExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).exitParenExpression(this);
		}
	}
	public static class NumberExpressionContext extends AtomContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public NumberExpressionContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).enterNumberExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).exitNumberExpression(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_atom);
		try {
			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
			case ID:
			case TRUE:
			case FALSE:
			case QUOTEDSTRING:
				_localctx = new NumberExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				constant();
				}
				break;
			case PLEFT:
				_localctx = new ParenExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				match(PLEFT);
				setState(138);
				expr(0);
				setState(139);
				match(PRIGHT);
				}
				break;
			case PREOP:
				_localctx = new PrefixExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(141);
				((PrefixExpressionContext)_localctx).op = match(PREOP);
				setState(142);
				expr(getNextPrecedence(((PrefixExpressionContext)_localctx).op));
				}
				break;
			case FUNC_NAME:
				_localctx = new FunctionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(143);
				functionExpr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionExprContext extends ParserRuleContext {
		public Token name;
		public TerminalNode PLEFT() { return getToken(LatinParser.PLEFT, 0); }
		public TerminalNode PRIGHT() { return getToken(LatinParser.PRIGHT, 0); }
		public TerminalNode FUNC_NAME() { return getToken(LatinParser.FUNC_NAME, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(LatinParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(LatinParser.COMA, i);
		}
		public FunctionExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).enterFunctionExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).exitFunctionExpr(this);
		}
	}

	public final FunctionExprContext functionExpr() throws RecognitionException {
		FunctionExprContext _localctx = new FunctionExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_functionExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			((FunctionExprContext)_localctx).name = match(FUNC_NAME);
			setState(147);
			match(PLEFT);
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PREOP) | (1L << FUNC_NAME) | (1L << NUMBER) | (1L << PLEFT) | (1L << ID) | (1L << TRUE) | (1L << FALSE) | (1L << QUOTEDSTRING))) != 0)) {
				{
				setState(148);
				expr(0);
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(149);
					match(COMA);
					setState(150);
					expr(0);
					}
					}
					setState(155);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(158);
			match(PRIGHT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(LatinParser.NUMBER, 0); }
		public TerminalNode ID() { return getToken(LatinParser.ID, 0); }
		public TerminalNode QUOTEDSTRING() { return getToken(LatinParser.QUOTEDSTRING, 0); }
		public Boolean_constContext boolean_const() {
			return getRuleContext(Boolean_constContext.class,0);
		}
		public Sub_idContext sub_id() {
			return getRuleContext(Sub_idContext.class,0);
		}
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_constant);
		try {
			setState(165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				match(NUMBER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(162);
				match(QUOTEDSTRING);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(163);
				boolean_const();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(164);
				sub_id();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sub_idContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(LatinParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LatinParser.ID, i);
		}
		public TerminalNode COR_LEFT() { return getToken(LatinParser.COR_LEFT, 0); }
		public TerminalNode QUOTEDSTRING() { return getToken(LatinParser.QUOTEDSTRING, 0); }
		public TerminalNode COR_RIGHT() { return getToken(LatinParser.COR_RIGHT, 0); }
		public List<TerminalNode> DOT() { return getTokens(LatinParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(LatinParser.DOT, i);
		}
		public Sub_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sub_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).enterSub_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).exitSub_id(this);
		}
	}

	public final Sub_idContext sub_id() throws RecognitionException {
		Sub_idContext _localctx = new Sub_idContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_sub_id);
		int _la;
		try {
			int _alt;
			setState(185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				match(ID);
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(168);
					match(DOT);
					setState(169);
					match(ID);
					}
				}

				setState(172);
				match(COR_LEFT);
				setState(173);
				match(QUOTEDSTRING);
				setState(174);
				match(COR_RIGHT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(175);
				match(ID);
				setState(176);
				match(DOT);
				setState(177);
				match(ID);
				setState(182);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(178);
						match(DOT);
						setState(179);
						match(ID);
						}
						} 
					}
					setState(184);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Boolean_constContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(LatinParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(LatinParser.FALSE, 0); }
		public Boolean_constContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_const; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).enterBoolean_const(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).exitBoolean_const(this);
		}
	}

	public final Boolean_constContext boolean_const() throws RecognitionException {
		Boolean_constContext _localctx = new Boolean_constContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_boolean_const);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return getPrecedence(_input.LT(1)) >= _localctx._p;
		case 1:
			return getPrecedence(_input.LT(1)) >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3*\u00c0\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\7\2$\n"+
		"\2\f\2\16\2\'\13\2\3\3\3\3\3\3\3\3\5\3-\n\3\3\3\3\3\3\3\3\3\3\3\5\3\64"+
		"\n\3\3\4\3\4\5\48\n\4\3\4\3\4\7\4<\n\4\f\4\16\4?\13\4\3\5\3\5\5\5C\n\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\5\5K\n\5\3\5\5\5N\n\5\3\6\3\6\3\6\3\7\3\7\3\7"+
		"\7\7V\n\7\f\7\16\7Y\13\7\3\b\3\b\5\b]\n\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n"+
		"\3\n\3\n\7\nh\n\n\f\n\16\nk\13\n\3\n\3\n\3\n\3\n\3\n\7\nr\n\n\f\n\16\n"+
		"u\13\n\7\nw\n\n\f\n\16\nz\13\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\7\f\u0086\n\f\f\f\16\f\u0089\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\5\r\u0093\n\r\3\16\3\16\3\16\3\16\3\16\7\16\u009a\n\16\f\16\16\16\u009d"+
		"\13\16\5\16\u009f\n\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\5\17\u00a8\n"+
		"\17\3\20\3\20\3\20\5\20\u00ad\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\7\20\u00b7\n\20\f\20\16\20\u00ba\13\20\5\20\u00bc\n\20\3\21\3\21"+
		"\3\21\2\2\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\5\3\2\30 \4\2\25"+
		"\25!\"\3\2$%\2\u00cc\2%\3\2\2\2\4\63\3\2\2\2\6\65\3\2\2\2\bM\3\2\2\2\n"+
		"O\3\2\2\2\fR\3\2\2\2\16Z\3\2\2\2\20b\3\2\2\2\22x\3\2\2\2\24{\3\2\2\2\26"+
		"\177\3\2\2\2\30\u0092\3\2\2\2\32\u0094\3\2\2\2\34\u00a7\3\2\2\2\36\u00bb"+
		"\3\2\2\2 \u00bd\3\2\2\2\"$\5\4\3\2#\"\3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3"+
		"\2\2\2&\3\3\2\2\2\'%\3\2\2\2()\7\25\2\2),\7\26\2\2*-\5\6\4\2+-\5\f\7\2"+
		",*\3\2\2\2,+\3\2\2\2-.\3\2\2\2./\7\24\2\2/\64\3\2\2\2\60\61\5\24\13\2"+
		"\61\62\7\24\2\2\62\64\3\2\2\2\63(\3\2\2\2\63\60\3\2\2\2\64\5\3\2\2\2\65"+
		"\67\7\7\2\2\668\5\b\5\2\67\66\3\2\2\2\678\3\2\2\28=\3\2\2\29:\7\23\2\2"+
		":<\5\b\5\2;9\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>\7\3\2\2\2?=\3\2\2"+
		"\2@B\7\25\2\2AC\5\n\6\2BA\3\2\2\2BC\3\2\2\2CN\3\2\2\2DE\7\25\2\2EF\7\27"+
		"\2\2FG\7\f\2\2GH\5\26\f\2HJ\7\r\2\2IK\5\n\6\2JI\3\2\2\2JK\3\2\2\2KN\3"+
		"\2\2\2LN\5\26\f\2M@\3\2\2\2MD\3\2\2\2ML\3\2\2\2N\t\3\2\2\2OP\7\22\2\2"+
		"PQ\t\2\2\2Q\13\3\2\2\2RS\7\20\2\2SW\7&\2\2TV\5\16\b\2UT\3\2\2\2VY\3\2"+
		"\2\2WU\3\2\2\2WX\3\2\2\2X\r\3\2\2\2YW\3\2\2\2Z\\\7\21\2\2[]\5\20\t\2\\"+
		"[\3\2\2\2\\]\3\2\2\2]^\3\2\2\2^_\7\n\2\2_`\5\22\n\2`a\7\13\2\2a\17\3\2"+
		"\2\2bc\t\3\2\2c\21\3\2\2\2di\7&\2\2ef\7\23\2\2fh\7&\2\2ge\3\2\2\2hk\3"+
		"\2\2\2ig\3\2\2\2ij\3\2\2\2jw\3\2\2\2ki\3\2\2\2lm\7\25\2\2ms\5\n\6\2no"+
		"\7\23\2\2op\7\25\2\2pr\5\n\6\2qn\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2"+
		"tw\3\2\2\2us\3\2\2\2vd\3\2\2\2vl\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2"+
		"y\23\3\2\2\2zx\3\2\2\2{|\7\7\2\2|}\7\25\2\2}~\7&\2\2~\25\3\2\2\2\177\u0087"+
		"\5\30\r\2\u0080\u0081\6\f\2\3\u0081\u0082\7\5\2\2\u0082\u0086\5\26\f\2"+
		"\u0083\u0084\6\f\3\3\u0084\u0086\7\4\2\2\u0085\u0080\3\2\2\2\u0085\u0083"+
		"\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088"+
		"\27\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u0093\5\34\17\2\u008b\u008c\7\n"+
		"\2\2\u008c\u008d\5\26\f\2\u008d\u008e\7\13\2\2\u008e\u0093\3\2\2\2\u008f"+
		"\u0090\7\3\2\2\u0090\u0093\5\26\f\2\u0091\u0093\5\32\16\2\u0092\u008a"+
		"\3\2\2\2\u0092\u008b\3\2\2\2\u0092\u008f\3\2\2\2\u0092\u0091\3\2\2\2\u0093"+
		"\31\3\2\2\2\u0094\u0095\7\b\2\2\u0095\u009e\7\n\2\2\u0096\u009b\5\26\f"+
		"\2\u0097\u0098\7\23\2\2\u0098\u009a\5\26\f\2\u0099\u0097\3\2\2\2\u009a"+
		"\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009f\3\2"+
		"\2\2\u009d\u009b\3\2\2\2\u009e\u0096\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0\u00a1\7\13\2\2\u00a1\33\3\2\2\2\u00a2\u00a8\7\t\2"+
		"\2\u00a3\u00a8\7\25\2\2\u00a4\u00a8\7&\2\2\u00a5\u00a8\5 \21\2\u00a6\u00a8"+
		"\5\36\20\2\u00a7\u00a2\3\2\2\2\u00a7\u00a3\3\2\2\2\u00a7\u00a4\3\2\2\2"+
		"\u00a7\u00a5\3\2\2\2\u00a7\u00a6\3\2\2\2\u00a8\35\3\2\2\2\u00a9\u00ac"+
		"\7\25\2\2\u00aa\u00ab\7#\2\2\u00ab\u00ad\7\25\2\2\u00ac\u00aa\3\2\2\2"+
		"\u00ac\u00ad\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\7\16\2\2\u00af\u00b0"+
		"\7&\2\2\u00b0\u00bc\7\17\2\2\u00b1\u00b2\7\25\2\2\u00b2\u00b3\7#\2\2\u00b3"+
		"\u00b8\7\25\2\2\u00b4\u00b5\7#\2\2\u00b5\u00b7\7\25\2\2\u00b6\u00b4\3"+
		"\2\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9"+
		"\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00a9\3\2\2\2\u00bb\u00b1\3\2"+
		"\2\2\u00bc\37\3\2\2\2\u00bd\u00be\t\4\2\2\u00be!\3\2\2\2\31%,\63\67=B"+
		"JMW\\isvx\u0085\u0087\u0092\u009b\u009e\u00a7\u00ac\u00b8\u00bb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}