// Generated from /Users/bertty/Qatar/xxxx/src/main/java/org/qcri/rheem/latin/dinamic/MathParser.g4 by ANTLR 4.6
package org.qcri.rheem.latin.dinamic;

    import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MathParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PREOP=1, POSTOP=2, BINOP=3, ERROR=4, INT=5, PLEFT=6, PRIGHT=7, WS=8, SYMBOL=9;
	public static final int
		RULE_prog = 0, RULE_expr = 1, RULE_atom = 2, RULE_numero = 3;
	public static final String[] ruleNames = {
		"prog", "expr", "atom", "numero"
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

	@Override
	public String getGrammarFileName() { return "MathParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    static Map<String, Integer> precedenceMap = new HashMap<String, Integer>();
	    static {
	        precedenceMap.put("*", 2);
	        precedenceMap.put("+", 1);
	        precedenceMap.put("^", 4);
	        precedenceMap.put("-", 3);
	        precedenceMap.put("!", 5);
	    }

	    public static void addPrecedenceMap(String symbol, int code){
	        precedenceMap.put(symbol, code);
	    }

	    public static Integer getPrecedence(Token op) {
	        return precedenceMap.get(op.getText());
	    }

	    public static Integer getNextPrecedence(Token op) {
	        Integer p = getPrecedence(op);
	        if (op.getType() == PREOP)          return p;
	        else if (op.getText().equals("^"))  return p;
	        else if (op.getType() == BINOP)     return p+1;
	        throw new IllegalArgumentException(op.getText());
	    }

	public MathParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathParserListener ) ((MathParserListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathParserListener ) ((MathParserListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			expr(0);
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
		public List<TerminalNode> BINOP() { return getTokens(MathParser.BINOP); }
		public TerminalNode BINOP(int i) {
			return getToken(MathParser.BINOP, i);
		}
		public List<TerminalNode> POSTOP() { return getTokens(MathParser.POSTOP); }
		public TerminalNode POSTOP(int i) {
			return getToken(MathParser.POSTOP, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExprContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathParserListener ) ((MathParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathParserListener ) ((MathParserListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr(int _p) throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState(), _p);
		enterRule(_localctx, 2, RULE_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			atom();
			setState(18);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(16);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
					case 1:
						{
						setState(11);
						if (!(getPrecedence(_input.LT(1)) >= _localctx._p)) throw new FailedPredicateException(this, "getPrecedence(_input.LT(1)) >= $_p");
						setState(12);
						((ExprContext)_localctx).op = match(BINOP);
						setState(13);
						expr(getNextPrecedence(((ExprContext)_localctx).op));
						}
						break;
					case 2:
						{
						setState(14);
						if (!(getPrecedence(_input.LT(1)) >= _localctx._p)) throw new FailedPredicateException(this, "getPrecedence(_input.LT(1)) >= $_p");
						setState(15);
						((ExprContext)_localctx).op = match(POSTOP);
						}
						break;
					}
					} 
				}
				setState(20);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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
	public static class ExprNumContext extends AtomContext {
		public NumeroContext numero() {
			return getRuleContext(NumeroContext.class,0);
		}
		public ExprNumContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathParserListener ) ((MathParserListener)listener).enterExprNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathParserListener ) ((MathParserListener)listener).exitExprNum(this);
		}
	}
	public static class ParensContext extends AtomContext {
		public TerminalNode PLEFT() { return getToken(MathParser.PLEFT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PRIGHT() { return getToken(MathParser.PRIGHT, 0); }
		public ParensContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathParserListener ) ((MathParserListener)listener).enterParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathParserListener ) ((MathParserListener)listener).exitParens(this);
		}
	}
	public static class ExprPreContext extends AtomContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PREOP() { return getToken(MathParser.PREOP, 0); }
		public ExprPreContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathParserListener ) ((MathParserListener)listener).enterExprPre(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathParserListener ) ((MathParserListener)listener).exitExprPre(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_atom);
		try {
			setState(28);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new ExprNumContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(21);
				numero();
				}
				break;
			case PLEFT:
				_localctx = new ParensContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(22);
				match(PLEFT);
				setState(23);
				expr(0);
				setState(24);
				match(PRIGHT);
				}
				break;
			case PREOP:
				_localctx = new ExprPreContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(26);
				((ExprPreContext)_localctx).op = match(PREOP);
				setState(27);
				expr(getNextPrecedence(((ExprPreContext)_localctx).op));
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

	public static class NumeroContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(MathParser.INT, 0); }
		public NumeroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numero; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathParserListener ) ((MathParserListener)listener).enterNumero(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathParserListener ) ((MathParserListener)listener).exitNumero(this);
		}
	}

	public final NumeroContext numero() throws RecognitionException {
		NumeroContext _localctx = new NumeroContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_numero);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(INT);
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
		case 1:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\13#\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3\23\n\3\f\3\16\3"+
		"\26\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\37\n\4\3\5\3\5\3\5\2\2\6\2\4"+
		"\6\b\2\2\"\2\n\3\2\2\2\4\f\3\2\2\2\6\36\3\2\2\2\b \3\2\2\2\n\13\5\4\3"+
		"\2\13\3\3\2\2\2\f\24\5\6\4\2\r\16\6\3\2\3\16\17\7\5\2\2\17\23\5\4\3\2"+
		"\20\21\6\3\3\3\21\23\7\4\2\2\22\r\3\2\2\2\22\20\3\2\2\2\23\26\3\2\2\2"+
		"\24\22\3\2\2\2\24\25\3\2\2\2\25\5\3\2\2\2\26\24\3\2\2\2\27\37\5\b\5\2"+
		"\30\31\7\b\2\2\31\32\5\4\3\2\32\33\7\t\2\2\33\37\3\2\2\2\34\35\7\3\2\2"+
		"\35\37\5\4\3\2\36\27\3\2\2\2\36\30\3\2\2\2\36\34\3\2\2\2\37\7\3\2\2\2"+
		" !\7\7\2\2!\t\3\2\2\2\5\22\24\36";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}