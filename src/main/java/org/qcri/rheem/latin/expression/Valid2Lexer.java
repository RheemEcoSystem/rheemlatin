// $ANTLR 3.5.2 src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g 2017-04-02 10:19:47

package org.qcri.rheem.latin.expression;


import org.antlr.runtime.*;

@SuppressWarnings("all")
public class Valid2Lexer extends Lexer {
	public static final int EOF=-1;
	public static final int AND_RW=4;
	public static final int COLON=5;
	public static final int COMMA=6;
	public static final int DIGIT=7;
	public static final int DOT=8;
	public static final int EQUAL=9;
	public static final int FALSE_LITERAL=10;
	public static final int FUNCTION=11;
	public static final int GR=12;
	public static final int GR_EQUAL=13;
	public static final int IDENT=14;
	public static final int LE=15;
	public static final int LEFT_BRACE=16;
	public static final int LEFT_BRACKET=17;
	public static final int LEFT_PAREN=18;
	public static final int LETTER=19;
	public static final int LE_EQUAL=20;
	public static final int MOD=21;
	public static final int NOT_EQUAL=22;
	public static final int NUMBER=23;
	public static final int OR_RW=24;
	public static final int PLUS=25;
	public static final int RIGHT_BRACE=26;
	public static final int RIGHT_BRACKET=27;
	public static final int RIGHT_PAREN=28;
	public static final int SEMICOLON=29;
	public static final int SLASH=30;
	public static final int STAR=31;
	public static final int SUB=32;
	public static final int TRUE_LITERAL=33;
	public static final int UNDERSCORE=34;
	public static final int WS=35;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public Valid2Lexer() {} 
	public Valid2Lexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public Valid2Lexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g"; }

	// $ANTLR start "TRUE_LITERAL"
	public final void mTRUE_LITERAL() throws RecognitionException {
		try {
			int _type = TRUE_LITERAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:12:15: ( 'TRUE' )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:12:17: 'TRUE'
			{
			match("TRUE"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TRUE_LITERAL"

	// $ANTLR start "FALSE_LITERAL"
	public final void mFALSE_LITERAL() throws RecognitionException {
		try {
			int _type = FALSE_LITERAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:13:15: ( 'FALSE' )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:13:17: 'FALSE'
			{
			match("FALSE"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FALSE_LITERAL"

	// $ANTLR start "LETTER"
	public final void mLETTER() throws RecognitionException {
		try {
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:21:17: ( 'a' .. 'z' )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:
			{
			if ( (input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LETTER"

	// $ANTLR start "DIGIT"
	public final void mDIGIT() throws RecognitionException {
		try {
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:26:16: ( '0' .. '9' )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIGIT"

	// $ANTLR start "UNDERSCORE"
	public final void mUNDERSCORE() throws RecognitionException {
		try {
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:31:21: ( '_' )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:31:23: '_'
			{
			match('_'); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UNDERSCORE"

	// $ANTLR start "IDENT"
	public final void mIDENT() throws RecognitionException {
		try {
			int _type = IDENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:33:7: ( LETTER ( LETTER | DIGIT | UNDERSCORE )* )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:33:9: LETTER ( LETTER | DIGIT | UNDERSCORE )*
			{
			mLETTER(); if (state.failed) return;

			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:33:16: ( LETTER | DIGIT | UNDERSCORE )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop1;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IDENT"

	// $ANTLR start "SEMICOLON"
	public final void mSEMICOLON() throws RecognitionException {
		try {
			int _type = SEMICOLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:40:14: ( ';' )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:40:16: ';'
			{
			match(';'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMICOLON"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:42:14: ( ',' )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:42:16: ','
			{
			match(','); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA"

	// $ANTLR start "DOT"
	public final void mDOT() throws RecognitionException {
		try {
			int _type = DOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:44:14: ( '.' )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:44:16: '.'
			{
			match('.'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOT"

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:46:14: ( ':' )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:46:16: ':'
			{
			match(':'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COLON"

	// $ANTLR start "LEFT_PAREN"
	public final void mLEFT_PAREN() throws RecognitionException {
		try {
			int _type = LEFT_PAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:52:18: ( '(' )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:52:20: '('
			{
			match('('); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LEFT_PAREN"

	// $ANTLR start "RIGHT_PAREN"
	public final void mRIGHT_PAREN() throws RecognitionException {
		try {
			int _type = RIGHT_PAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:53:18: ( ')' )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:53:20: ')'
			{
			match(')'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RIGHT_PAREN"

	// $ANTLR start "LEFT_BRACE"
	public final void mLEFT_BRACE() throws RecognitionException {
		try {
			int _type = LEFT_BRACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:54:18: ( '{' )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:54:20: '{'
			{
			match('{'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LEFT_BRACE"

	// $ANTLR start "RIGHT_BRACE"
	public final void mRIGHT_BRACE() throws RecognitionException {
		try {
			int _type = RIGHT_BRACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:55:18: ( '}' )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:55:20: '}'
			{
			match('}'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RIGHT_BRACE"

	// $ANTLR start "LEFT_BRACKET"
	public final void mLEFT_BRACKET() throws RecognitionException {
		try {
			int _type = LEFT_BRACKET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:56:18: ( '[' )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:56:20: '['
			{
			match('['); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LEFT_BRACKET"

	// $ANTLR start "RIGHT_BRACKET"
	public final void mRIGHT_BRACKET() throws RecognitionException {
		try {
			int _type = RIGHT_BRACKET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:57:18: ( ']' )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:57:20: ']'
			{
			match(']'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RIGHT_BRACKET"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:63:10: ( '+' )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:63:12: '+'
			{
			match('+'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "SUB"
	public final void mSUB() throws RecognitionException {
		try {
			int _type = SUB;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:64:10: ( '-' )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:64:12: '-'
			{
			match('-'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SUB"

	// $ANTLR start "STAR"
	public final void mSTAR() throws RecognitionException {
		try {
			int _type = STAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:65:10: ( '*' )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:65:12: '*'
			{
			match('*'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STAR"

	// $ANTLR start "SLASH"
	public final void mSLASH() throws RecognitionException {
		try {
			int _type = SLASH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:66:10: ( '/' )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:66:12: '/'
			{
			match('/'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SLASH"

	// $ANTLR start "MOD"
	public final void mMOD() throws RecognitionException {
		try {
			int _type = MOD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:67:10: ( '%' )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:67:12: '%'
			{
			match('%'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MOD"

	// $ANTLR start "EQUAL"
	public final void mEQUAL() throws RecognitionException {
		try {
			int _type = EQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:73:14: ( '==' )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:73:16: '=='
			{
			match("=="); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQUAL"

	// $ANTLR start "NOT_EQUAL"
	public final void mNOT_EQUAL() throws RecognitionException {
		try {
			int _type = NOT_EQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:74:14: ( '!=' )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:74:16: '!='
			{
			match("!="); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT_EQUAL"

	// $ANTLR start "GR_EQUAL"
	public final void mGR_EQUAL() throws RecognitionException {
		try {
			int _type = GR_EQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:75:14: ( '>=' )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:75:16: '>='
			{
			match(">="); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GR_EQUAL"

	// $ANTLR start "LE_EQUAL"
	public final void mLE_EQUAL() throws RecognitionException {
		try {
			int _type = LE_EQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:76:14: ( '<=' )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:76:16: '<='
			{
			match("<="); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LE_EQUAL"

	// $ANTLR start "GR"
	public final void mGR() throws RecognitionException {
		try {
			int _type = GR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:77:14: ( '>' )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:77:16: '>'
			{
			match('>'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GR"

	// $ANTLR start "LE"
	public final void mLE() throws RecognitionException {
		try {
			int _type = LE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:78:14: ( '<' )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:78:16: '<'
			{
			match('<'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LE"

	// $ANTLR start "OR_RW"
	public final void mOR_RW() throws RecognitionException {
		try {
			int _type = OR_RW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:79:14: ( '&&' )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:79:16: '&&'
			{
			match("&&"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OR_RW"

	// $ANTLR start "AND_RW"
	public final void mAND_RW() throws RecognitionException {
		try {
			int _type = AND_RW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:80:14: ( '||' )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:80:16: '||'
			{
			match("||"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AND_RW"

	// $ANTLR start "NUMBER"
	public final void mNUMBER() throws RecognitionException {
		try {
			int _type = NUMBER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:85:8: ( ( ( DIGIT )+ DOT ( DIGIT )+ )=> ( DIGIT )+ DOT ( DIGIT )+ | ( DIGIT )+ )
			int alt5=2;
			alt5 = dfa5.predict(input);
			switch (alt5) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:85:10: ( ( DIGIT )+ DOT ( DIGIT )+ )=> ( DIGIT )+ DOT ( DIGIT )+
					{
					// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:85:39: ( DIGIT )+
					int cnt2=0;
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt2 >= 1 ) break loop2;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(2, input);
							throw eee;
						}
						cnt2++;
					}

					mDOT(); if (state.failed) return;

					// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:85:54: ( DIGIT )+
					int cnt3=0;
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt3 >= 1 ) break loop3;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(3, input);
							throw eee;
						}
						cnt3++;
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:86:12: ( DIGIT )+
					{
					// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:86:12: ( DIGIT )+
					int cnt4=0;
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt4 >= 1 ) break loop4;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(4, input);
							throw eee;
						}
						cnt4++;
					}

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUMBER"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:99:4: ( ( ( ' ' | '\\t' | '\\f' ) | ( '\\n' | '\\r' ) ) )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:99:9: ( ( ' ' | '\\t' | '\\f' ) | ( '\\n' | '\\r' ) )
			{
			if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( state.backtracking==0 ) { _channel = HIDDEN; }
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "FUNCTION"
	public final void mFUNCTION() throws RecognitionException {
		try {
			int _type = FUNCTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:104:10: ( ( '@' ( 'A' .. 'Z' )+ ) )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:104:12: ( '@' ( 'A' .. 'Z' )+ )
			{
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:104:12: ( '@' ( 'A' .. 'Z' )+ )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:104:13: '@' ( 'A' .. 'Z' )+
			{
			match('@'); if (state.failed) return;
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:104:17: ( 'A' .. 'Z' )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= 'A' && LA6_0 <= 'Z')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:
					{
					if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FUNCTION"

	@Override
	public void mTokens() throws RecognitionException {
		// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:1:8: ( TRUE_LITERAL | FALSE_LITERAL | IDENT | SEMICOLON | COMMA | DOT | COLON | LEFT_PAREN | RIGHT_PAREN | LEFT_BRACE | RIGHT_BRACE | LEFT_BRACKET | RIGHT_BRACKET | PLUS | SUB | STAR | SLASH | MOD | EQUAL | NOT_EQUAL | GR_EQUAL | LE_EQUAL | GR | LE | OR_RW | AND_RW | NUMBER | WS | FUNCTION )
		int alt7=29;
		switch ( input.LA(1) ) {
		case 'T':
			{
			alt7=1;
			}
			break;
		case 'F':
			{
			alt7=2;
			}
			break;
		case 'a':
		case 'b':
		case 'c':
		case 'd':
		case 'e':
		case 'f':
		case 'g':
		case 'h':
		case 'i':
		case 'j':
		case 'k':
		case 'l':
		case 'm':
		case 'n':
		case 'o':
		case 'p':
		case 'q':
		case 'r':
		case 's':
		case 't':
		case 'u':
		case 'v':
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			{
			alt7=3;
			}
			break;
		case ';':
			{
			alt7=4;
			}
			break;
		case ',':
			{
			alt7=5;
			}
			break;
		case '.':
			{
			alt7=6;
			}
			break;
		case ':':
			{
			alt7=7;
			}
			break;
		case '(':
			{
			alt7=8;
			}
			break;
		case ')':
			{
			alt7=9;
			}
			break;
		case '{':
			{
			alt7=10;
			}
			break;
		case '}':
			{
			alt7=11;
			}
			break;
		case '[':
			{
			alt7=12;
			}
			break;
		case ']':
			{
			alt7=13;
			}
			break;
		case '+':
			{
			alt7=14;
			}
			break;
		case '-':
			{
			alt7=15;
			}
			break;
		case '*':
			{
			alt7=16;
			}
			break;
		case '/':
			{
			alt7=17;
			}
			break;
		case '%':
			{
			alt7=18;
			}
			break;
		case '=':
			{
			alt7=19;
			}
			break;
		case '!':
			{
			alt7=20;
			}
			break;
		case '>':
			{
			int LA7_21 = input.LA(2);
			if ( (LA7_21=='=') ) {
				alt7=21;
			}

			else {
				alt7=23;
			}

			}
			break;
		case '<':
			{
			int LA7_22 = input.LA(2);
			if ( (LA7_22=='=') ) {
				alt7=22;
			}

			else {
				alt7=24;
			}

			}
			break;
		case '&':
			{
			alt7=25;
			}
			break;
		case '|':
			{
			alt7=26;
			}
			break;
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			{
			alt7=27;
			}
			break;
		case '\t':
		case '\n':
		case '\f':
		case '\r':
		case ' ':
			{
			alt7=28;
			}
			break;
		case '@':
			{
			alt7=29;
			}
			break;
		default:
			if (state.backtracking>0) {state.failed=true; return;}
			NoViableAltException nvae =
				new NoViableAltException("", 7, 0, input);
			throw nvae;
		}
		switch (alt7) {
			case 1 :
				// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:1:10: TRUE_LITERAL
				{
				mTRUE_LITERAL(); if (state.failed) return;

				}
				break;
			case 2 :
				// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:1:23: FALSE_LITERAL
				{
				mFALSE_LITERAL(); if (state.failed) return;

				}
				break;
			case 3 :
				// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:1:37: IDENT
				{
				mIDENT(); if (state.failed) return;

				}
				break;
			case 4 :
				// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:1:43: SEMICOLON
				{
				mSEMICOLON(); if (state.failed) return;

				}
				break;
			case 5 :
				// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:1:53: COMMA
				{
				mCOMMA(); if (state.failed) return;

				}
				break;
			case 6 :
				// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:1:59: DOT
				{
				mDOT(); if (state.failed) return;

				}
				break;
			case 7 :
				// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:1:63: COLON
				{
				mCOLON(); if (state.failed) return;

				}
				break;
			case 8 :
				// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:1:69: LEFT_PAREN
				{
				mLEFT_PAREN(); if (state.failed) return;

				}
				break;
			case 9 :
				// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:1:80: RIGHT_PAREN
				{
				mRIGHT_PAREN(); if (state.failed) return;

				}
				break;
			case 10 :
				// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:1:92: LEFT_BRACE
				{
				mLEFT_BRACE(); if (state.failed) return;

				}
				break;
			case 11 :
				// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:1:103: RIGHT_BRACE
				{
				mRIGHT_BRACE(); if (state.failed) return;

				}
				break;
			case 12 :
				// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:1:115: LEFT_BRACKET
				{
				mLEFT_BRACKET(); if (state.failed) return;

				}
				break;
			case 13 :
				// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:1:128: RIGHT_BRACKET
				{
				mRIGHT_BRACKET(); if (state.failed) return;

				}
				break;
			case 14 :
				// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:1:142: PLUS
				{
				mPLUS(); if (state.failed) return;

				}
				break;
			case 15 :
				// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:1:147: SUB
				{
				mSUB(); if (state.failed) return;

				}
				break;
			case 16 :
				// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:1:151: STAR
				{
				mSTAR(); if (state.failed) return;

				}
				break;
			case 17 :
				// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:1:156: SLASH
				{
				mSLASH(); if (state.failed) return;

				}
				break;
			case 18 :
				// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:1:162: MOD
				{
				mMOD(); if (state.failed) return;

				}
				break;
			case 19 :
				// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:1:166: EQUAL
				{
				mEQUAL(); if (state.failed) return;

				}
				break;
			case 20 :
				// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:1:172: NOT_EQUAL
				{
				mNOT_EQUAL(); if (state.failed) return;

				}
				break;
			case 21 :
				// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:1:182: GR_EQUAL
				{
				mGR_EQUAL(); if (state.failed) return;

				}
				break;
			case 22 :
				// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:1:191: LE_EQUAL
				{
				mLE_EQUAL(); if (state.failed) return;

				}
				break;
			case 23 :
				// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:1:200: GR
				{
				mGR(); if (state.failed) return;

				}
				break;
			case 24 :
				// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:1:203: LE
				{
				mLE(); if (state.failed) return;

				}
				break;
			case 25 :
				// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:1:206: OR_RW
				{
				mOR_RW(); if (state.failed) return;

				}
				break;
			case 26 :
				// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:1:212: AND_RW
				{
				mAND_RW(); if (state.failed) return;

				}
				break;
			case 27 :
				// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:1:219: NUMBER
				{
				mNUMBER(); if (state.failed) return;

				}
				break;
			case 28 :
				// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:1:226: WS
				{
				mWS(); if (state.failed) return;

				}
				break;
			case 29 :
				// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:1:229: FUNCTION
				{
				mFUNCTION(); if (state.failed) return;

				}
				break;

		}
	}

	// $ANTLR start synpred1_Valid2Lexer
	public final void synpred1_Valid2Lexer_fragment() throws RecognitionException {
		// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:85:10: ( ( DIGIT )+ DOT ( DIGIT )+ )
		// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:85:11: ( DIGIT )+ DOT ( DIGIT )+
		{
		// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:85:11: ( DIGIT )+
		int cnt8=0;
		loop8:
		while (true) {
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
				alt8=1;
			}

			switch (alt8) {
			case 1 :
				// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:
				{
				if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
					input.consume();
					state.failed=false;
				}
				else {
					if (state.backtracking>0) {state.failed=true; return;}
					MismatchedSetException mse = new MismatchedSetException(null,input);
					recover(mse);
					throw mse;
				}
				}
				break;

			default :
				if ( cnt8 >= 1 ) break loop8;
				if (state.backtracking>0) {state.failed=true; return;}
				EarlyExitException eee = new EarlyExitException(8, input);
				throw eee;
			}
			cnt8++;
		}

		mDOT(); if (state.failed) return;

		// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:85:26: ( DIGIT )+
		int cnt9=0;
		loop9:
		while (true) {
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( ((LA9_0 >= '0' && LA9_0 <= '9')) ) {
				alt9=1;
			}

			switch (alt9) {
			case 1 :
				// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Lexer.g:
				{
				if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
					input.consume();
					state.failed=false;
				}
				else {
					if (state.backtracking>0) {state.failed=true; return;}
					MismatchedSetException mse = new MismatchedSetException(null,input);
					recover(mse);
					throw mse;
				}
				}
				break;

			default :
				if ( cnt9 >= 1 ) break loop9;
				if (state.backtracking>0) {state.failed=true; return;}
				EarlyExitException eee = new EarlyExitException(9, input);
				throw eee;
			}
			cnt9++;
		}

		}

	}
	// $ANTLR end synpred1_Valid2Lexer

	public final boolean synpred1_Valid2Lexer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_Valid2Lexer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}


	protected DFA5 dfa5 = new DFA5(this);
	static final String DFA5_eotS =
		"\1\uffff\1\3\2\uffff";
	static final String DFA5_eofS =
		"\4\uffff";
	static final String DFA5_minS =
		"\1\60\1\56\2\uffff";
	static final String DFA5_maxS =
		"\2\71\2\uffff";
	static final String DFA5_acceptS =
		"\2\uffff\1\1\1\2";
	static final String DFA5_specialS =
		"\1\uffff\1\0\2\uffff}>";
	static final String[] DFA5_transitionS = {
			"\12\1",
			"\1\2\1\uffff\12\1",
			"",
			""
	};

	static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
	static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
	static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
	static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
	static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
	static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
	static final short[][] DFA5_transition;

	static {
		int numStates = DFA5_transitionS.length;
		DFA5_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
		}
	}

	protected class DFA5 extends DFA {

		public DFA5(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 5;
			this.eot = DFA5_eot;
			this.eof = DFA5_eof;
			this.min = DFA5_min;
			this.max = DFA5_max;
			this.accept = DFA5_accept;
			this.special = DFA5_special;
			this.transition = DFA5_transition;
		}
		@Override
		public String getDescription() {
			return "85:1: NUMBER : ( ( ( DIGIT )+ DOT ( DIGIT )+ )=> ( DIGIT )+ DOT ( DIGIT )+ | ( DIGIT )+ );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA5_1 = input.LA(1);
						 
						int index5_1 = input.index();
						input.rewind();
						s = -1;
						if ( (LA5_1=='.') && (synpred1_Valid2Lexer())) {s = 2;}
						else if ( ((LA5_1 >= '0' && LA5_1 <= '9')) ) {s = 1;}
						else s = 3;
						 
						input.seek(index5_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 5, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
