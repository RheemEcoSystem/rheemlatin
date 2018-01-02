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
		ASSING=21, ARROW=22, ARROW_I=23, BOOLEAN=24, INT=25, LONG=26, FLOAT=27, 
		BIGDECIMAL=28, BIGINTEGER=29, DOUBLE=30, DATETIME=31, STRING=32, JSON=33, 
		SQL=34, WITH=35, DOT=36, TRUE=37, FALSE=38, BAG=39, IMPORT=40, INCLUDE=41, 
		BROADCAST=42, QUOTEDSTRING=43, MULTILINE_QUOTEDSTRING=44, COMMENT=45, 
		LINE_COMMENT=46, WS=47, SYMBOL=48;
	public static final int
		RULE_query = 0, RULE_statement = 1, RULE_operator_statement = 2, RULE_lambda = 3, 
		RULE_real_function = 4, RULE_type = 5, RULE_source_statement = 6, RULE_as_clause = 7, 
		RULE_type_load = 8, RULE_pair = 9, RULE_sink_statement = 10, RULE_expr = 11, 
		RULE_atom = 12, RULE_functionExpr = 13, RULE_constant = 14, RULE_sub_id = 15, 
		RULE_boolean_const = 16, RULE_with_platform = 17, RULE_with_broadcast = 18, 
		RULE_bag_stattement = 19, RULE_bag_header = 20, RULE_bag_header_titles = 21, 
		RULE_bag_header_element = 22, RULE_bag_header_params = 23, RULE_bag_set_param = 24, 
		RULE_class_define = 25, RULE_include_statement = 26;
	public static final String[] ruleNames = {
		"query", "statement", "operator_statement", "lambda", "real_function", 
		"type", "source_statement", "as_clause", "type_load", "pair", "sink_statement", 
		"expr", "atom", "functionExpr", "constant", "sub_id", "boolean_const", 
		"with_platform", "with_broadcast", "bag_stattement", "bag_header", "bag_header_titles", 
		"bag_header_element", "bag_header_params", "bag_set_param", "class_define", 
		"include_statement"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, "'PLATFORM'", null, "'('", "')'", 
		"'{'", "'}'", "'['", "']'", "'LOAD'", "'AS'", "':'", "','", "';'", null, 
		"'='", "'->'", "'<-'", "'BOOLEAN'", "'INT'", "'LONG'", "'FLOAT'", "'BIGDECIMAL'", 
		"'BIGINTEGER'", "'DOUBLE'", "'DATETIME'", "'STRING'", "'JSON'", "'SQL'", 
		"'WITH'", "'.'", "'TRUE'", "'FALSE'", "'BAG'", "'IMPORT'", "'INCLUDE'", 
		"'BROADCAST'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PREOP", "POSTOP", "BINOP", "ERROR", "OPERATOR_NAME", "FUNC_NAME", 
		"PLATFORM", "NUMBER", "PLEFT", "PRIGHT", "ACCO_LEFT", "ACCO_RIGHT", "COR_LEFT", 
		"COR_RIGHT", "LOAD", "AS", "COLON", "COMA", "SEMI_COLON", "ID", "ASSING", 
		"ARROW", "ARROW_I", "BOOLEAN", "INT", "LONG", "FLOAT", "BIGDECIMAL", "BIGINTEGER", 
		"DOUBLE", "DATETIME", "STRING", "JSON", "SQL", "WITH", "DOT", "TRUE", 
		"FALSE", "BAG", "IMPORT", "INCLUDE", "BROADCAST", "QUOTEDSTRING", "MULTILINE_QUOTEDSTRING", 
		"COMMENT", "LINE_COMMENT", "WS", "SYMBOL"
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
		public List<Class_defineContext> class_define() {
			return getRuleContexts(Class_defineContext.class);
		}
		public Class_defineContext class_define(int i) {
			return getRuleContext(Class_defineContext.class,i);
		}
		public List<Bag_set_paramContext> bag_set_param() {
			return getRuleContexts(Bag_set_paramContext.class);
		}
		public Bag_set_paramContext bag_set_param(int i) {
			return getRuleContext(Bag_set_paramContext.class,i);
		}
		public List<Include_statementContext> include_statement() {
			return getRuleContexts(Include_statementContext.class);
		}
		public Include_statementContext include_statement(int i) {
			return getRuleContext(Include_statementContext.class,i);
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
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPERATOR_NAME) | (1L << ID) | (1L << IMPORT))) != 0)) {
				{
				setState(58);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(54);
					statement();
					}
					break;
				case 2:
					{
					setState(55);
					class_define();
					}
					break;
				case 3:
					{
					setState(56);
					bag_set_param();
					}
					break;
				case 4:
					{
					setState(57);
					include_statement();
					}
					break;
				}
				}
				setState(62);
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
		public With_platformContext with_platform() {
			return getRuleContext(With_platformContext.class,0);
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
		public With_platformContext with_platform() {
			return getRuleContext(With_platformContext.class,0);
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
	public static class BagStatementContext extends StatementContext {
		public TerminalNode ID() { return getToken(LatinParser.ID, 0); }
		public TerminalNode ASSING() { return getToken(LatinParser.ASSING, 0); }
		public Bag_stattementContext bag_stattement() {
			return getRuleContext(Bag_stattementContext.class,0);
		}
		public TerminalNode SEMI_COLON() { return getToken(LatinParser.SEMI_COLON, 0); }
		public BagStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).enterBagStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).exitBagStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		int _la;
		try {
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new BaseStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				match(ID);
				setState(64);
				match(ASSING);
				setState(67);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case OPERATOR_NAME:
					{
					setState(65);
					operator_statement();
					}
					break;
				case LOAD:
					{
					setState(66);
					source_statement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(69);
					with_platform();
					}
				}

				setState(72);
				match(SEMI_COLON);
				}
				break;
			case 2:
				_localctx = new SinkStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				sink_statement();
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(75);
					with_platform();
					}
				}

				setState(78);
				match(SEMI_COLON);
				}
				break;
			case 3:
				_localctx = new BagStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
				match(ID);
				setState(81);
				match(ASSING);
				setState(82);
				bag_stattement();
				setState(83);
				match(SEMI_COLON);
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
		public With_broadcastContext with_broadcast() {
			return getRuleContext(With_broadcastContext.class,0);
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
			setState(87);
			((OperatorStatementContext)_localctx).name = match(OPERATOR_NAME);
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PREOP) | (1L << FUNC_NAME) | (1L << NUMBER) | (1L << PLEFT) | (1L << ID) | (1L << TRUE) | (1L << FALSE) | (1L << QUOTEDSTRING))) != 0)) {
				{
				setState(88);
				lambda();
				}
			}

			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(91);
				match(COMA);
				setState(92);
				lambda();
				}
				}
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(99);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(98);
				with_broadcast();
				}
				break;
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
		public Real_functionContext real_function() {
			return getRuleContext(Real_functionContext.class,0);
		}
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
			setState(115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				match(ID);
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(102);
					type();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				match(ID);
				setState(106);
				match(ARROW);
				setState(107);
				match(ACCO_LEFT);
				setState(108);
				expr(0);
				setState(109);
				match(ACCO_RIGHT);
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(110);
					type();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
				expr(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(114);
				real_function();
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

	public static class Real_functionContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(LatinParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LatinParser.ID, i);
		}
		public TerminalNode ARROW() { return getToken(LatinParser.ARROW, 0); }
		public TerminalNode DOT() { return getToken(LatinParser.DOT, 0); }
		public TerminalNode PLEFT() { return getToken(LatinParser.PLEFT, 0); }
		public TerminalNode PRIGHT() { return getToken(LatinParser.PRIGHT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Real_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_real_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).enterReal_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).exitReal_function(this);
		}
	}

	public final Real_functionContext real_function() throws RecognitionException {
		Real_functionContext _localctx = new Real_functionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_real_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(ID);
			setState(118);
			match(ARROW);
			setState(119);
			match(ID);
			setState(120);
			match(DOT);
			setState(121);
			match(ID);
			setState(122);
			match(PLEFT);
			setState(123);
			match(PRIGHT);
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(124);
				type();
				}
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
		public TerminalNode ID() { return getToken(LatinParser.ID, 0); }
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
		enterRule(_localctx, 10, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(COLON);
			setState(128);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << BOOLEAN) | (1L << INT) | (1L << LONG) | (1L << FLOAT) | (1L << BIGDECIMAL) | (1L << BIGINTEGER) | (1L << DOUBLE) | (1L << DATETIME) | (1L << STRING))) != 0)) ) {
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
		public As_clauseContext as_clause() {
			return getRuleContext(As_clauseContext.class,0);
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
		enterRule(_localctx, 12, RULE_source_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(LOAD);
			setState(131);
			match(QUOTEDSTRING);
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(132);
				as_clause();
				}
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
		enterRule(_localctx, 14, RULE_as_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(AS);
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << JSON) | (1L << SQL))) != 0)) {
				{
				setState(136);
				type_load();
				}
			}

			setState(139);
			match(PLEFT);
			setState(140);
			pair();
			setState(141);
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
		enterRule(_localctx, 16, RULE_type_load);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
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
		enterRule(_localctx, 18, RULE_pair);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID || _la==QUOTEDSTRING) {
				{
				setState(163);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case QUOTEDSTRING:
					{
					{
					setState(145);
					match(QUOTEDSTRING);
					setState(150);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMA) {
						{
						{
						setState(146);
						match(COMA);
						setState(147);
						match(QUOTEDSTRING);
						}
						}
						setState(152);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				case ID:
					{
					{
					setState(153);
					match(ID);
					setState(154);
					type();
					setState(160);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMA) {
						{
						{
						setState(155);
						match(COMA);
						setState(156);
						match(ID);
						setState(157);
						type();
						}
						}
						setState(162);
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
				setState(167);
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
		enterRule(_localctx, 20, RULE_sink_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			((Sink_statementContext)_localctx).name = match(OPERATOR_NAME);
			setState(169);
			match(ID);
			setState(170);
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
		enterRule(_localctx, 22, RULE_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			atom();
			setState(180);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(178);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						setState(173);
						if (!(getPrecedence(_input.LT(1)) >= _localctx._p)) throw new FailedPredicateException(this, "getPrecedence(_input.LT(1)) >= $_p");
						setState(174);
						((ExprContext)_localctx).op = match(BINOP);
						setState(175);
						expr(getNextPrecedence(((ExprContext)_localctx).op));
						}
						break;
					case 2:
						{
						setState(176);
						if (!(getPrecedence(_input.LT(1)) >= _localctx._p)) throw new FailedPredicateException(this, "getPrecedence(_input.LT(1)) >= $_p");
						setState(177);
						((ExprContext)_localctx).op = match(POSTOP);
						}
						break;
					}
					} 
				}
				setState(182);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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
		enterRule(_localctx, 24, RULE_atom);
		try {
			setState(191);
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
				setState(183);
				constant();
				}
				break;
			case PLEFT:
				_localctx = new ParenExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(184);
				match(PLEFT);
				setState(185);
				expr(0);
				setState(186);
				match(PRIGHT);
				}
				break;
			case PREOP:
				_localctx = new PrefixExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(188);
				((PrefixExpressionContext)_localctx).op = match(PREOP);
				setState(189);
				expr(getNextPrecedence(((PrefixExpressionContext)_localctx).op));
				}
				break;
			case FUNC_NAME:
				_localctx = new FunctionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(190);
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
		enterRule(_localctx, 26, RULE_functionExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			((FunctionExprContext)_localctx).name = match(FUNC_NAME);
			setState(194);
			match(PLEFT);
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PREOP) | (1L << FUNC_NAME) | (1L << NUMBER) | (1L << PLEFT) | (1L << ID) | (1L << TRUE) | (1L << FALSE) | (1L << QUOTEDSTRING))) != 0)) {
				{
				setState(195);
				expr(0);
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(196);
					match(COMA);
					setState(197);
					expr(0);
					}
					}
					setState(202);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(205);
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
		enterRule(_localctx, 28, RULE_constant);
		try {
			setState(212);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(207);
				match(NUMBER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(208);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(209);
				match(QUOTEDSTRING);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(210);
				boolean_const();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(211);
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
		enterRule(_localctx, 30, RULE_sub_id);
		int _la;
		try {
			int _alt;
			setState(232);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(214);
				match(ID);
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(215);
					match(DOT);
					setState(216);
					match(ID);
					}
				}

				setState(219);
				match(COR_LEFT);
				setState(220);
				match(QUOTEDSTRING);
				setState(221);
				match(COR_RIGHT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
				match(ID);
				setState(223);
				match(DOT);
				setState(224);
				match(ID);
				setState(229);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(225);
						match(DOT);
						setState(226);
						match(ID);
						}
						} 
					}
					setState(231);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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
		enterRule(_localctx, 32, RULE_boolean_const);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
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

	public static class With_platformContext extends ParserRuleContext {
		public With_platformContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_with_platform; }
	 
		public With_platformContext() { }
		public void copyFrom(With_platformContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NamePlatformContext extends With_platformContext {
		public TerminalNode WITH() { return getToken(LatinParser.WITH, 0); }
		public TerminalNode PLATFORM() { return getToken(LatinParser.PLATFORM, 0); }
		public TerminalNode QUOTEDSTRING() { return getToken(LatinParser.QUOTEDSTRING, 0); }
		public NamePlatformContext(With_platformContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).enterNamePlatform(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).exitNamePlatform(this);
		}
	}

	public final With_platformContext with_platform() throws RecognitionException {
		With_platformContext _localctx = new With_platformContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_with_platform);
		try {
			_localctx = new NamePlatformContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(WITH);
			setState(237);
			match(PLATFORM);
			setState(238);
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

	public static class With_broadcastContext extends ParserRuleContext {
		public TerminalNode WITH() { return getToken(LatinParser.WITH, 0); }
		public TerminalNode BROADCAST() { return getToken(LatinParser.BROADCAST, 0); }
		public TerminalNode ID() { return getToken(LatinParser.ID, 0); }
		public With_broadcastContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_with_broadcast; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).enterWith_broadcast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).exitWith_broadcast(this);
		}
	}

	public final With_broadcastContext with_broadcast() throws RecognitionException {
		With_broadcastContext _localctx = new With_broadcastContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_with_broadcast);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(WITH);
			setState(241);
			match(BROADCAST);
			setState(242);
			match(ID);
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

	public static class Bag_stattementContext extends ParserRuleContext {
		public TerminalNode BAG() { return getToken(LatinParser.BAG, 0); }
		public TerminalNode PLEFT() { return getToken(LatinParser.PLEFT, 0); }
		public TerminalNode PRIGHT() { return getToken(LatinParser.PRIGHT, 0); }
		public TerminalNode ARROW_I() { return getToken(LatinParser.ARROW_I, 0); }
		public TerminalNode ID() { return getToken(LatinParser.ID, 0); }
		public Bag_headerContext bag_header() {
			return getRuleContext(Bag_headerContext.class,0);
		}
		public Bag_stattementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bag_stattement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).enterBag_stattement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).exitBag_stattement(this);
		}
	}

	public final Bag_stattementContext bag_stattement() throws RecognitionException {
		Bag_stattementContext _localctx = new Bag_stattementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_bag_stattement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(BAG);
			setState(245);
			match(PLEFT);
			setState(247);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COR_LEFT || _la==ID) {
				{
				setState(246);
				bag_header();
				}
			}

			setState(249);
			match(PRIGHT);
			setState(250);
			match(ARROW_I);
			setState(251);
			match(ID);
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

	public static class Bag_headerContext extends ParserRuleContext {
		public Bag_header_titlesContext bag_header_titles() {
			return getRuleContext(Bag_header_titlesContext.class,0);
		}
		public List<TerminalNode> COMA() { return getTokens(LatinParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(LatinParser.COMA, i);
		}
		public List<Bag_header_paramsContext> bag_header_params() {
			return getRuleContexts(Bag_header_paramsContext.class);
		}
		public Bag_header_paramsContext bag_header_params(int i) {
			return getRuleContext(Bag_header_paramsContext.class,i);
		}
		public Bag_headerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bag_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).enterBag_header(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).exitBag_header(this);
		}
	}

	public final Bag_headerContext bag_header() throws RecognitionException {
		Bag_headerContext _localctx = new Bag_headerContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_bag_header);
		int _la;
		try {
			setState(269);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COR_LEFT:
				enterOuterAlt(_localctx, 1);
				{
				setState(253);
				bag_header_titles();
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(254);
					match(COMA);
					setState(255);
					bag_header_params();
					}
					}
					setState(260);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(261);
				bag_header_params();
				setState(266);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(262);
					match(COMA);
					setState(263);
					bag_header_params();
					}
					}
					setState(268);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class Bag_header_titlesContext extends ParserRuleContext {
		public TerminalNode COR_LEFT() { return getToken(LatinParser.COR_LEFT, 0); }
		public TerminalNode COR_RIGHT() { return getToken(LatinParser.COR_RIGHT, 0); }
		public List<Bag_header_elementContext> bag_header_element() {
			return getRuleContexts(Bag_header_elementContext.class);
		}
		public Bag_header_elementContext bag_header_element(int i) {
			return getRuleContext(Bag_header_elementContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(LatinParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(LatinParser.COMA, i);
		}
		public Bag_header_titlesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bag_header_titles; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).enterBag_header_titles(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).exitBag_header_titles(this);
		}
	}

	public final Bag_header_titlesContext bag_header_titles() throws RecognitionException {
		Bag_header_titlesContext _localctx = new Bag_header_titlesContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_bag_header_titles);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			match(COR_LEFT);
			{
			setState(272);
			bag_header_element();
			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(273);
				match(COMA);
				setState(274);
				bag_header_element();
				}
				}
				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(280);
			match(COR_RIGHT);
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

	public static class Bag_header_elementContext extends ParserRuleContext {
		public TerminalNode QUOTEDSTRING() { return getToken(LatinParser.QUOTEDSTRING, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Bag_header_elementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bag_header_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).enterBag_header_element(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).exitBag_header_element(this);
		}
	}

	public final Bag_header_elementContext bag_header_element() throws RecognitionException {
		Bag_header_elementContext _localctx = new Bag_header_elementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_bag_header_element);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			match(QUOTEDSTRING);
			setState(284);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(283);
				type();
				}
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

	public static class Bag_header_paramsContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LatinParser.ID, 0); }
		public TerminalNode ASSING() { return getToken(LatinParser.ASSING, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public Bag_header_paramsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bag_header_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).enterBag_header_params(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).exitBag_header_params(this);
		}
	}

	public final Bag_header_paramsContext bag_header_params() throws RecognitionException {
		Bag_header_paramsContext _localctx = new Bag_header_paramsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_bag_header_params);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			match(ID);
			setState(287);
			match(ASSING);
			setState(288);
			constant();
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

	public static class Bag_set_paramContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(LatinParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LatinParser.ID, i);
		}
		public TerminalNode DOT() { return getToken(LatinParser.DOT, 0); }
		public TerminalNode ARROW_I() { return getToken(LatinParser.ARROW_I, 0); }
		public TerminalNode SEMI_COLON() { return getToken(LatinParser.SEMI_COLON, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public Bag_header_titlesContext bag_header_titles() {
			return getRuleContext(Bag_header_titlesContext.class,0);
		}
		public Bag_set_paramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bag_set_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).enterBag_set_param(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).exitBag_set_param(this);
		}
	}

	public final Bag_set_paramContext bag_set_param() throws RecognitionException {
		Bag_set_paramContext _localctx = new Bag_set_paramContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_bag_set_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			match(ID);
			setState(291);
			match(DOT);
			setState(292);
			match(ID);
			setState(293);
			match(ARROW_I);
			setState(296);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
			case ID:
			case TRUE:
			case FALSE:
			case QUOTEDSTRING:
				{
				setState(294);
				constant();
				}
				break;
			case COR_LEFT:
				{
				setState(295);
				bag_header_titles();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(298);
			match(SEMI_COLON);
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

	public static class Class_defineContext extends ParserRuleContext {
		public Class_defineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_define; }
	 
		public Class_defineContext() { }
		public void copyFrom(Class_defineContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ClassDefineContext extends Class_defineContext {
		public TerminalNode IMPORT() { return getToken(LatinParser.IMPORT, 0); }
		public TerminalNode QUOTEDSTRING() { return getToken(LatinParser.QUOTEDSTRING, 0); }
		public TerminalNode AS() { return getToken(LatinParser.AS, 0); }
		public TerminalNode ID() { return getToken(LatinParser.ID, 0); }
		public TerminalNode SEMI_COLON() { return getToken(LatinParser.SEMI_COLON, 0); }
		public ClassDefineContext(Class_defineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).enterClassDefine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).exitClassDefine(this);
		}
	}

	public final Class_defineContext class_define() throws RecognitionException {
		Class_defineContext _localctx = new Class_defineContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_class_define);
		try {
			_localctx = new ClassDefineContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			match(IMPORT);
			setState(301);
			match(QUOTEDSTRING);
			setState(302);
			match(AS);
			setState(303);
			match(ID);
			setState(304);
			match(SEMI_COLON);
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

	public static class Include_statementContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(LatinParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LatinParser.ID, i);
		}
		public TerminalNode ASSING() { return getToken(LatinParser.ASSING, 0); }
		public TerminalNode INCLUDE() { return getToken(LatinParser.INCLUDE, 0); }
		public TerminalNode QUOTEDSTRING() { return getToken(LatinParser.QUOTEDSTRING, 0); }
		public TerminalNode PLEFT() { return getToken(LatinParser.PLEFT, 0); }
		public TerminalNode PRIGHT() { return getToken(LatinParser.PRIGHT, 0); }
		public TerminalNode SEMI_COLON() { return getToken(LatinParser.SEMI_COLON, 0); }
		public Include_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_include_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).enterInclude_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LatinParserListener ) ((LatinParserListener)listener).exitInclude_statement(this);
		}
	}

	public final Include_statementContext include_statement() throws RecognitionException {
		Include_statementContext _localctx = new Include_statementContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_include_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			match(ID);
			setState(307);
			match(ASSING);
			setState(308);
			match(INCLUDE);
			setState(309);
			match(QUOTEDSTRING);
			setState(310);
			match(PLEFT);
			setState(312); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(311);
				match(ID);
				}
				}
				setState(314); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(316);
			match(PRIGHT);
			setState(317);
			match(SEMI_COLON);
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
		case 11:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\62\u0142\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\3\2\7\2=\n\2\f\2\16\2@\13\2"+
		"\3\3\3\3\3\3\3\3\5\3F\n\3\3\3\5\3I\n\3\3\3\3\3\3\3\3\3\5\3O\n\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\5\3X\n\3\3\4\3\4\5\4\\\n\4\3\4\3\4\7\4`\n\4\f\4"+
		"\16\4c\13\4\3\4\5\4f\n\4\3\5\3\5\5\5j\n\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5"+
		"r\n\5\3\5\3\5\5\5v\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0080\n\6\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\5\b\u0088\n\b\3\t\3\t\5\t\u008c\n\t\3\t\3\t\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\13\7\13\u0097\n\13\f\13\16\13\u009a\13\13\3\13"+
		"\3\13\3\13\3\13\3\13\7\13\u00a1\n\13\f\13\16\13\u00a4\13\13\7\13\u00a6"+
		"\n\13\f\13\16\13\u00a9\13\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\7"+
		"\r\u00b5\n\r\f\r\16\r\u00b8\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\5\16\u00c2\n\16\3\17\3\17\3\17\3\17\3\17\7\17\u00c9\n\17\f\17\16\17"+
		"\u00cc\13\17\5\17\u00ce\n\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\5\20\u00d7"+
		"\n\20\3\21\3\21\3\21\5\21\u00dc\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\7\21\u00e6\n\21\f\21\16\21\u00e9\13\21\5\21\u00eb\n\21\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\5\25\u00fa\n\25"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\7\26\u0103\n\26\f\26\16\26\u0106\13"+
		"\26\3\26\3\26\3\26\7\26\u010b\n\26\f\26\16\26\u010e\13\26\5\26\u0110\n"+
		"\26\3\27\3\27\3\27\3\27\7\27\u0116\n\27\f\27\16\27\u0119\13\27\3\27\3"+
		"\27\3\30\3\30\5\30\u011f\n\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\5\32\u012b\n\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\6\34\u013b\n\34\r\34\16\34\u013c\3\34\3\34\3"+
		"\34\3\34\2\2\35\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\66\2\5\4\2\26\26\32\"\4\2\26\26#$\3\2\'(\2\u0154\2>\3\2\2\2\4W\3\2"+
		"\2\2\6Y\3\2\2\2\bu\3\2\2\2\nw\3\2\2\2\f\u0081\3\2\2\2\16\u0084\3\2\2\2"+
		"\20\u0089\3\2\2\2\22\u0091\3\2\2\2\24\u00a7\3\2\2\2\26\u00aa\3\2\2\2\30"+
		"\u00ae\3\2\2\2\32\u00c1\3\2\2\2\34\u00c3\3\2\2\2\36\u00d6\3\2\2\2 \u00ea"+
		"\3\2\2\2\"\u00ec\3\2\2\2$\u00ee\3\2\2\2&\u00f2\3\2\2\2(\u00f6\3\2\2\2"+
		"*\u010f\3\2\2\2,\u0111\3\2\2\2.\u011c\3\2\2\2\60\u0120\3\2\2\2\62\u0124"+
		"\3\2\2\2\64\u012e\3\2\2\2\66\u0134\3\2\2\28=\5\4\3\29=\5\64\33\2:=\5\62"+
		"\32\2;=\5\66\34\2<8\3\2\2\2<9\3\2\2\2<:\3\2\2\2<;\3\2\2\2=@\3\2\2\2><"+
		"\3\2\2\2>?\3\2\2\2?\3\3\2\2\2@>\3\2\2\2AB\7\26\2\2BE\7\27\2\2CF\5\6\4"+
		"\2DF\5\16\b\2EC\3\2\2\2ED\3\2\2\2FH\3\2\2\2GI\5$\23\2HG\3\2\2\2HI\3\2"+
		"\2\2IJ\3\2\2\2JK\7\25\2\2KX\3\2\2\2LN\5\26\f\2MO\5$\23\2NM\3\2\2\2NO\3"+
		"\2\2\2OP\3\2\2\2PQ\7\25\2\2QX\3\2\2\2RS\7\26\2\2ST\7\27\2\2TU\5(\25\2"+
		"UV\7\25\2\2VX\3\2\2\2WA\3\2\2\2WL\3\2\2\2WR\3\2\2\2X\5\3\2\2\2Y[\7\7\2"+
		"\2Z\\\5\b\5\2[Z\3\2\2\2[\\\3\2\2\2\\a\3\2\2\2]^\7\24\2\2^`\5\b\5\2_]\3"+
		"\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2be\3\2\2\2ca\3\2\2\2df\5&\24\2ed\3"+
		"\2\2\2ef\3\2\2\2f\7\3\2\2\2gi\7\26\2\2hj\5\f\7\2ih\3\2\2\2ij\3\2\2\2j"+
		"v\3\2\2\2kl\7\26\2\2lm\7\30\2\2mn\7\r\2\2no\5\30\r\2oq\7\16\2\2pr\5\f"+
		"\7\2qp\3\2\2\2qr\3\2\2\2rv\3\2\2\2sv\5\30\r\2tv\5\n\6\2ug\3\2\2\2uk\3"+
		"\2\2\2us\3\2\2\2ut\3\2\2\2v\t\3\2\2\2wx\7\26\2\2xy\7\30\2\2yz\7\26\2\2"+
		"z{\7&\2\2{|\7\26\2\2|}\7\13\2\2}\177\7\f\2\2~\u0080\5\f\7\2\177~\3\2\2"+
		"\2\177\u0080\3\2\2\2\u0080\13\3\2\2\2\u0081\u0082\7\23\2\2\u0082\u0083"+
		"\t\2\2\2\u0083\r\3\2\2\2\u0084\u0085\7\21\2\2\u0085\u0087\7-\2\2\u0086"+
		"\u0088\5\20\t\2\u0087\u0086\3\2\2\2\u0087\u0088\3\2\2\2\u0088\17\3\2\2"+
		"\2\u0089\u008b\7\22\2\2\u008a\u008c\5\22\n\2\u008b\u008a\3\2\2\2\u008b"+
		"\u008c\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\7\13\2\2\u008e\u008f\5"+
		"\24\13\2\u008f\u0090\7\f\2\2\u0090\21\3\2\2\2\u0091\u0092\t\3\2\2\u0092"+
		"\23\3\2\2\2\u0093\u0098\7-\2\2\u0094\u0095\7\24\2\2\u0095\u0097\7-\2\2"+
		"\u0096\u0094\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099"+
		"\3\2\2\2\u0099\u00a6\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009c\7\26\2\2"+
		"\u009c\u00a2\5\f\7\2\u009d\u009e\7\24\2\2\u009e\u009f\7\26\2\2\u009f\u00a1"+
		"\5\f\7\2\u00a0\u009d\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2"+
		"\u00a3\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u0093\3\2"+
		"\2\2\u00a5\u009b\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7"+
		"\u00a8\3\2\2\2\u00a8\25\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00ab\7\7\2"+
		"\2\u00ab\u00ac\7\26\2\2\u00ac\u00ad\7-\2\2\u00ad\27\3\2\2\2\u00ae\u00b6"+
		"\5\32\16\2\u00af\u00b0\6\r\2\3\u00b0\u00b1\7\5\2\2\u00b1\u00b5\5\30\r"+
		"\2\u00b2\u00b3\6\r\3\3\u00b3\u00b5\7\4\2\2\u00b4\u00af\3\2\2\2\u00b4\u00b2"+
		"\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7"+
		"\31\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00c2\5\36\20\2\u00ba\u00bb\7\13"+
		"\2\2\u00bb\u00bc\5\30\r\2\u00bc\u00bd\7\f\2\2\u00bd\u00c2\3\2\2\2\u00be"+
		"\u00bf\7\3\2\2\u00bf\u00c2\5\30\r\2\u00c0\u00c2\5\34\17\2\u00c1\u00b9"+
		"\3\2\2\2\u00c1\u00ba\3\2\2\2\u00c1\u00be\3\2\2\2\u00c1\u00c0\3\2\2\2\u00c2"+
		"\33\3\2\2\2\u00c3\u00c4\7\b\2\2\u00c4\u00cd\7\13\2\2\u00c5\u00ca\5\30"+
		"\r\2\u00c6\u00c7\7\24\2\2\u00c7\u00c9\5\30\r\2\u00c8\u00c6\3\2\2\2\u00c9"+
		"\u00cc\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00ce\3\2"+
		"\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00c5\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce"+
		"\u00cf\3\2\2\2\u00cf\u00d0\7\f\2\2\u00d0\35\3\2\2\2\u00d1\u00d7\7\n\2"+
		"\2\u00d2\u00d7\7\26\2\2\u00d3\u00d7\7-\2\2\u00d4\u00d7\5\"\22\2\u00d5"+
		"\u00d7\5 \21\2\u00d6\u00d1\3\2\2\2\u00d6\u00d2\3\2\2\2\u00d6\u00d3\3\2"+
		"\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d5\3\2\2\2\u00d7\37\3\2\2\2\u00d8\u00db"+
		"\7\26\2\2\u00d9\u00da\7&\2\2\u00da\u00dc\7\26\2\2\u00db\u00d9\3\2\2\2"+
		"\u00db\u00dc\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\7\17\2\2\u00de\u00df"+
		"\7-\2\2\u00df\u00eb\7\20\2\2\u00e0\u00e1\7\26\2\2\u00e1\u00e2\7&\2\2\u00e2"+
		"\u00e7\7\26\2\2\u00e3\u00e4\7&\2\2\u00e4\u00e6\7\26\2\2\u00e5\u00e3\3"+
		"\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8"+
		"\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00d8\3\2\2\2\u00ea\u00e0\3\2"+
		"\2\2\u00eb!\3\2\2\2\u00ec\u00ed\t\4\2\2\u00ed#\3\2\2\2\u00ee\u00ef\7%"+
		"\2\2\u00ef\u00f0\7\t\2\2\u00f0\u00f1\7-\2\2\u00f1%\3\2\2\2\u00f2\u00f3"+
		"\7%\2\2\u00f3\u00f4\7,\2\2\u00f4\u00f5\7\26\2\2\u00f5\'\3\2\2\2\u00f6"+
		"\u00f7\7)\2\2\u00f7\u00f9\7\13\2\2\u00f8\u00fa\5*\26\2\u00f9\u00f8\3\2"+
		"\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\7\f\2\2\u00fc"+
		"\u00fd\7\31\2\2\u00fd\u00fe\7\26\2\2\u00fe)\3\2\2\2\u00ff\u0104\5,\27"+
		"\2\u0100\u0101\7\24\2\2\u0101\u0103\5\60\31\2\u0102\u0100\3\2\2\2\u0103"+
		"\u0106\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0110\3\2"+
		"\2\2\u0106\u0104\3\2\2\2\u0107\u010c\5\60\31\2\u0108\u0109\7\24\2\2\u0109"+
		"\u010b\5\60\31\2\u010a\u0108\3\2\2\2\u010b\u010e\3\2\2\2\u010c\u010a\3"+
		"\2\2\2\u010c\u010d\3\2\2\2\u010d\u0110\3\2\2\2\u010e\u010c\3\2\2\2\u010f"+
		"\u00ff\3\2\2\2\u010f\u0107\3\2\2\2\u0110+\3\2\2\2\u0111\u0112\7\17\2\2"+
		"\u0112\u0117\5.\30\2\u0113\u0114\7\24\2\2\u0114\u0116\5.\30\2\u0115\u0113"+
		"\3\2\2\2\u0116\u0119\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118"+
		"\u011a\3\2\2\2\u0119\u0117\3\2\2\2\u011a\u011b\7\20\2\2\u011b-\3\2\2\2"+
		"\u011c\u011e\7-\2\2\u011d\u011f\5\f\7\2\u011e\u011d\3\2\2\2\u011e\u011f"+
		"\3\2\2\2\u011f/\3\2\2\2\u0120\u0121\7\26\2\2\u0121\u0122\7\27\2\2\u0122"+
		"\u0123\5\36\20\2\u0123\61\3\2\2\2\u0124\u0125\7\26\2\2\u0125\u0126\7&"+
		"\2\2\u0126\u0127\7\26\2\2\u0127\u012a\7\31\2\2\u0128\u012b\5\36\20\2\u0129"+
		"\u012b\5,\27\2\u012a\u0128\3\2\2\2\u012a\u0129\3\2\2\2\u012b\u012c\3\2"+
		"\2\2\u012c\u012d\7\25\2\2\u012d\63\3\2\2\2\u012e\u012f\7*\2\2\u012f\u0130"+
		"\7-\2\2\u0130\u0131\7\22\2\2\u0131\u0132\7\26\2\2\u0132\u0133\7\25\2\2"+
		"\u0133\65\3\2\2\2\u0134\u0135\7\26\2\2\u0135\u0136\7\27\2\2\u0136\u0137"+
		"\7+\2\2\u0137\u0138\7-\2\2\u0138\u013a\7\13\2\2\u0139\u013b\7\26\2\2\u013a"+
		"\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013d\3\2"+
		"\2\2\u013d\u013e\3\2\2\2\u013e\u013f\7\f\2\2\u013f\u0140\7\25\2\2\u0140"+
		"\67\3\2\2\2&<>EHNW[aeiqu\177\u0087\u008b\u0098\u00a2\u00a5\u00a7\u00b4"+
		"\u00b6\u00c1\u00ca\u00cd\u00d6\u00db\u00e7\u00ea\u00f9\u0104\u010c\u010f"+
		"\u0117\u011e\u012a\u013c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}