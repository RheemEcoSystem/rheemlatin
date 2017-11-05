// Generated from LatinParser.g4 by ANTLR 4.7

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
		PREOP=1, POSTOP=2, BINOP=3, ERROR=4, OPERATOR_NAME=5, FUNC_NAME=6, PLATFORM=7, 
		NUMBER=8, PLEFT=9, PRIGHT=10, ACCO_LEFT=11, ACCO_RIGHT=12, COR_LEFT=13, 
		COR_RIGHT=14, LOAD=15, AS=16, COLON=17, COMA=18, SEMI_COLON=19, ID=20, 
		ASSING=21, ARROW=22, BOOLEAN=23, INT=24, LONG=25, FLOAT=26, BIGDECIMAL=27, 
		BIGINTEGER=28, DOUBLE=29, DATETIME=30, STRING=31, JSON=32, SQL=33, WITH=34, 
		DOT=35, TRUE=36, FALSE=37, QUOTEDSTRING=38, MULTILINE_QUOTEDSTRING=39, 
		COMMENT=40, WS=41, SYMBOL=42;
	public static final int
		RULE_query = 0, RULE_statement = 1, RULE_operator_statement = 2, RULE_lambda = 3, 
		RULE_type = 4, RULE_source_statement = 5, RULE_as_clause = 6, RULE_type_load = 7, 
		RULE_pair = 8, RULE_sink_statement = 9, RULE_expr = 10, RULE_atom = 11, 
		RULE_functionExpr = 12, RULE_constant = 13, RULE_sub_id = 14, RULE_boolean_const = 15, 
		RULE_with = 16;
	public static final String[] ruleNames = {
		"query", "statement", "operator_statement", "lambda", "type", "source_statement", 
		"as_clause", "type_load", "pair", "sink_statement", "expr", "atom", "functionExpr", 
		"constant", "sub_id", "boolean_const", "with"
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
	        System.out.println(op.getType()+"  ");
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
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPERATOR_NAME || _la==ID) {
				{
				{
				setState(34);
				statement();
				}
				}
				setState(39);
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
		public WithContext with() {
			return getRuleContext(WithContext.class,0);
		}
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
		public WithContext with() {
			return getRuleContext(WithContext.class,0);
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
		int _la;
		try {
			setState(57);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new BaseStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				match(ID);
				setState(41);
				match(ASSING);
				setState(44);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case OPERATOR_NAME:
					{
					setState(42);
					operator_statement();
					}
					break;
				case LOAD:
					{
					setState(43);
					source_statement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(46);
					with();
					}
				}

				setState(49);
				match(SEMI_COLON);
				}
				break;
			case OPERATOR_NAME:
				_localctx = new SinkStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				sink_statement();
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(52);
					with();
					}
				}

				setState(55);
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
			setState(59);
			((OperatorStatementContext)_localctx).name = match(OPERATOR_NAME);
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PREOP) | (1L << FUNC_NAME) | (1L << NUMBER) | (1L << PLEFT) | (1L << ID) | (1L << TRUE) | (1L << FALSE) | (1L << QUOTEDSTRING))) != 0)) {
				{
				setState(60);
				lambda();
				}
			}

			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(63);
				match(COMA);
				setState(64);
				lambda();
				}
				}
				setState(69);
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
			setState(83);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				match(ID);
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
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				match(ID);
				setState(75);
				match(ARROW);
				setState(76);
				match(ACCO_LEFT);
				setState(77);
				expr(0);
				setState(78);
				match(ACCO_RIGHT);
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(79);
					type();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(82);
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
			setState(85);
			match(COLON);
			setState(86);
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
			setState(88);
			match(LOAD);
			setState(89);
			match(QUOTEDSTRING);
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AS) {
				{
				{
				setState(90);
				as_clause();
				}
				}
				setState(95);
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
			setState(96);
			match(AS);
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << JSON) | (1L << SQL))) != 0)) {
				{
				setState(97);
				type_load();
				}
			}

			setState(100);
			match(PLEFT);
			setState(101);
			pair();
			setState(102);
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
			setState(104);
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
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID || _la==QUOTEDSTRING) {
				{
				setState(124);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case QUOTEDSTRING:
					{
					{
					setState(106);
					match(QUOTEDSTRING);
					setState(111);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMA) {
						{
						{
						setState(107);
						match(COMA);
						setState(108);
						match(QUOTEDSTRING);
						}
						}
						setState(113);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				case ID:
					{
					{
					setState(114);
					match(ID);
					setState(115);
					type();
					setState(121);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMA) {
						{
						{
						setState(116);
						match(COMA);
						setState(117);
						match(ID);
						setState(118);
						type();
						}
						}
						setState(123);
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
				setState(128);
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
			setState(129);
			((Sink_statementContext)_localctx).name = match(OPERATOR_NAME);
			setState(130);
			match(ID);
			setState(131);
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
			setState(133);
			atom();
			setState(141);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(139);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						setState(134);
						if (!(getPrecedence(_input.LT(1)) >= _localctx._p)) throw new FailedPredicateException(this, "getPrecedence(_input.LT(1)) >= $_p");
						setState(135);
						((ExprContext)_localctx).op = match(BINOP);
						setState(136);
						expr(getNextPrecedence(((ExprContext)_localctx).op));
						}
						break;
					case 2:
						{
						setState(137);
						if (!(getPrecedence(_input.LT(1)) >= _localctx._p)) throw new FailedPredicateException(this, "getPrecedence(_input.LT(1)) >= $_p");
						setState(138);
						((ExprContext)_localctx).op = match(POSTOP);
						}
						break;
					}
					} 
				}
				setState(143);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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
			setState(152);
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
				setState(144);
				constant();
				}
				break;
			case PLEFT:
				_localctx = new ParenExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				match(PLEFT);
				setState(146);
				expr(0);
				setState(147);
				match(PRIGHT);
				}
				break;
			case PREOP:
				_localctx = new PrefixExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(149);
				((PrefixExpressionContext)_localctx).op = match(PREOP);
				setState(150);
				expr(getNextPrecedence(((PrefixExpressionContext)_localctx).op));
				}
				break;
			case FUNC_NAME:
				_localctx = new FunctionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(151);
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
			setState(154);
			((FunctionExprContext)_localctx).name = match(FUNC_NAME);
			setState(155);
			match(PLEFT);
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PREOP) | (1L << FUNC_NAME) | (1L << NUMBER) | (1L << PLEFT) | (1L << ID) | (1L << TRUE) | (1L << FALSE) | (1L << QUOTEDSTRING))) != 0)) {
				{
				setState(156);
				expr(0);
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(157);
					match(COMA);
					setState(158);
					expr(0);
					}
					}
					setState(163);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(166);
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
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				match(NUMBER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(170);
				match(QUOTEDSTRING);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(171);
				boolean_const();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(172);
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
			setState(193);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				match(ID);
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(176);
					match(DOT);
					setState(177);
					match(ID);
					}
				}

				setState(180);
				match(COR_LEFT);
				setState(181);
				match(QUOTEDSTRING);
				setState(182);
				match(COR_RIGHT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				match(ID);
				setState(184);
				match(DOT);
				setState(185);
				match(ID);
				setState(190);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(186);
						match(DOT);
						setState(187);
						match(ID);
						}
						} 
					}
					setState(192);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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
			setState(195);
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

	public static class WithContext extends ParserRuleContext {
		public WithContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_with; }
	 
		public WithContext() { }
		public void copyFrom(WithContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NamePlatformContext extends WithContext {
		public TerminalNode WITH() { return getToken(LatinParser.WITH, 0); }
		public TerminalNode QUOTEDSTRING() { return getToken(LatinParser.QUOTEDSTRING, 0); }
		public NamePlatformContext(WithContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).enterNamePlatform(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).exitNamePlatform(this);
		}
	}

	public final WithContext with() throws RecognitionException {
		WithContext _localctx = new WithContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_with);
		try {
			_localctx = new NamePlatformContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(WITH);
			setState(198);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3,\u00cb\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\7\2&\n\2\f\2\16\2)\13\2\3\3\3\3\3\3\3\3\5\3/\n\3\3\3\5\3\62\n\3\3"+
		"\3\3\3\3\3\3\3\5\38\n\3\3\3\3\3\5\3<\n\3\3\4\3\4\5\4@\n\4\3\4\3\4\7\4"+
		"D\n\4\f\4\16\4G\13\4\3\5\3\5\5\5K\n\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5S\n\5"+
		"\3\5\5\5V\n\5\3\6\3\6\3\6\3\7\3\7\3\7\7\7^\n\7\f\7\16\7a\13\7\3\b\3\b"+
		"\5\be\n\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\7\np\n\n\f\n\16\ns\13\n"+
		"\3\n\3\n\3\n\3\n\3\n\7\nz\n\n\f\n\16\n}\13\n\7\n\177\n\n\f\n\16\n\u0082"+
		"\13\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u008e\n\f\f\f\16"+
		"\f\u0091\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u009b\n\r\3\16\3\16"+
		"\3\16\3\16\3\16\7\16\u00a2\n\16\f\16\16\16\u00a5\13\16\5\16\u00a7\n\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\5\17\u00b0\n\17\3\20\3\20\3\20\5\20"+
		"\u00b5\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00bf\n\20\f"+
		"\20\16\20\u00c2\13\20\5\20\u00c4\n\20\3\21\3\21\3\22\3\22\3\22\3\22\2"+
		"\2\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\5\3\2\31!\4\2\26\26"+
		"\"#\3\2&\'\2\u00d8\2\'\3\2\2\2\4;\3\2\2\2\6=\3\2\2\2\bU\3\2\2\2\nW\3\2"+
		"\2\2\fZ\3\2\2\2\16b\3\2\2\2\20j\3\2\2\2\22\u0080\3\2\2\2\24\u0083\3\2"+
		"\2\2\26\u0087\3\2\2\2\30\u009a\3\2\2\2\32\u009c\3\2\2\2\34\u00af\3\2\2"+
		"\2\36\u00c3\3\2\2\2 \u00c5\3\2\2\2\"\u00c7\3\2\2\2$&\5\4\3\2%$\3\2\2\2"+
		"&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(\3\3\2\2\2)\'\3\2\2\2*+\7\26\2\2+.\7"+
		"\27\2\2,/\5\6\4\2-/\5\f\7\2.,\3\2\2\2.-\3\2\2\2/\61\3\2\2\2\60\62\5\""+
		"\22\2\61\60\3\2\2\2\61\62\3\2\2\2\62\63\3\2\2\2\63\64\7\25\2\2\64<\3\2"+
		"\2\2\65\67\5\24\13\2\668\5\"\22\2\67\66\3\2\2\2\678\3\2\2\289\3\2\2\2"+
		"9:\7\25\2\2:<\3\2\2\2;*\3\2\2\2;\65\3\2\2\2<\5\3\2\2\2=?\7\7\2\2>@\5\b"+
		"\5\2?>\3\2\2\2?@\3\2\2\2@E\3\2\2\2AB\7\24\2\2BD\5\b\5\2CA\3\2\2\2DG\3"+
		"\2\2\2EC\3\2\2\2EF\3\2\2\2F\7\3\2\2\2GE\3\2\2\2HJ\7\26\2\2IK\5\n\6\2J"+
		"I\3\2\2\2JK\3\2\2\2KV\3\2\2\2LM\7\26\2\2MN\7\30\2\2NO\7\r\2\2OP\5\26\f"+
		"\2PR\7\16\2\2QS\5\n\6\2RQ\3\2\2\2RS\3\2\2\2SV\3\2\2\2TV\5\26\f\2UH\3\2"+
		"\2\2UL\3\2\2\2UT\3\2\2\2V\t\3\2\2\2WX\7\23\2\2XY\t\2\2\2Y\13\3\2\2\2Z"+
		"[\7\21\2\2[_\7(\2\2\\^\5\16\b\2]\\\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2"+
		"\2`\r\3\2\2\2a_\3\2\2\2bd\7\22\2\2ce\5\20\t\2dc\3\2\2\2de\3\2\2\2ef\3"+
		"\2\2\2fg\7\13\2\2gh\5\22\n\2hi\7\f\2\2i\17\3\2\2\2jk\t\3\2\2k\21\3\2\2"+
		"\2lq\7(\2\2mn\7\24\2\2np\7(\2\2om\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2"+
		"\2r\177\3\2\2\2sq\3\2\2\2tu\7\26\2\2u{\5\n\6\2vw\7\24\2\2wx\7\26\2\2x"+
		"z\5\n\6\2yv\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|\177\3\2\2\2}{\3\2\2"+
		"\2~l\3\2\2\2~t\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3"+
		"\2\2\2\u0081\23\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0084\7\7\2\2\u0084"+
		"\u0085\7\26\2\2\u0085\u0086\7(\2\2\u0086\25\3\2\2\2\u0087\u008f\5\30\r"+
		"\2\u0088\u0089\6\f\2\3\u0089\u008a\7\5\2\2\u008a\u008e\5\26\f\2\u008b"+
		"\u008c\6\f\3\3\u008c\u008e\7\4\2\2\u008d\u0088\3\2\2\2\u008d\u008b\3\2"+
		"\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090"+
		"\27\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u009b\5\34\17\2\u0093\u0094\7\13"+
		"\2\2\u0094\u0095\5\26\f\2\u0095\u0096\7\f\2\2\u0096\u009b\3\2\2\2\u0097"+
		"\u0098\7\3\2\2\u0098\u009b\5\26\f\2\u0099\u009b\5\32\16\2\u009a\u0092"+
		"\3\2\2\2\u009a\u0093\3\2\2\2\u009a\u0097\3\2\2\2\u009a\u0099\3\2\2\2\u009b"+
		"\31\3\2\2\2\u009c\u009d\7\b\2\2\u009d\u00a6\7\13\2\2\u009e\u00a3\5\26"+
		"\f\2\u009f\u00a0\7\24\2\2\u00a0\u00a2\5\26\f\2\u00a1\u009f\3\2\2\2\u00a2"+
		"\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a7\3\2"+
		"\2\2\u00a5\u00a3\3\2\2\2\u00a6\u009e\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7"+
		"\u00a8\3\2\2\2\u00a8\u00a9\7\f\2\2\u00a9\33\3\2\2\2\u00aa\u00b0\7\n\2"+
		"\2\u00ab\u00b0\7\26\2\2\u00ac\u00b0\7(\2\2\u00ad\u00b0\5 \21\2\u00ae\u00b0"+
		"\5\36\20\2\u00af\u00aa\3\2\2\2\u00af\u00ab\3\2\2\2\u00af\u00ac\3\2\2\2"+
		"\u00af\u00ad\3\2\2\2\u00af\u00ae\3\2\2\2\u00b0\35\3\2\2\2\u00b1\u00b4"+
		"\7\26\2\2\u00b2\u00b3\7%\2\2\u00b3\u00b5\7\26\2\2\u00b4\u00b2\3\2\2\2"+
		"\u00b4\u00b5\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\7\17\2\2\u00b7\u00b8"+
		"\7(\2\2\u00b8\u00c4\7\20\2\2\u00b9\u00ba\7\26\2\2\u00ba\u00bb\7%\2\2\u00bb"+
		"\u00c0\7\26\2\2\u00bc\u00bd\7%\2\2\u00bd\u00bf\7\26\2\2\u00be\u00bc\3"+
		"\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1"+
		"\u00c4\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00b1\3\2\2\2\u00c3\u00b9\3\2"+
		"\2\2\u00c4\37\3\2\2\2\u00c5\u00c6\t\4\2\2\u00c6!\3\2\2\2\u00c7\u00c8\7"+
		"$\2\2\u00c8\u00c9\7(\2\2\u00c9#\3\2\2\2\33\'.\61\67;?EJRU_dq{~\u0080\u008d"+
		"\u008f\u009a\u00a3\u00a6\u00af\u00b4\u00c0\u00c3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}