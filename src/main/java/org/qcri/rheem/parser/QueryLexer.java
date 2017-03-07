// $ANTLR 3.5.2 QueryLexer.g 2016-12-10 11:53:49

package org.qcri.rheem.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Lexer file for Pig Parser
 */
@SuppressWarnings("all")
public class QueryLexer extends Lexer {
	public static final int EOF=-1;
	public static final int ALL=4;
	public static final int AMPERSAND=5;
	public static final int AND=6;
	public static final int ARROBA=7;
	public static final int AS=8;
	public static final int ASC=9;
	public static final int ASSERT=10;
	public static final int BAG=11;
	public static final int BIGDECIMAL=12;
	public static final int BIGDECIMALNUMBER=13;
	public static final int BIGINTEGER=14;
	public static final int BIGINTEGERNUMBER=15;
	public static final int BOOLEAN=16;
	public static final int BY=17;
	public static final int BYTEARRAY=18;
	public static final int CACHE=19;
	public static final int CASE=20;
	public static final int CHARARRAY=21;
	public static final int COGROUP=22;
	public static final int COLON=23;
	public static final int COMMA=24;
	public static final int CROSS=25;
	public static final int CUBE=26;
	public static final int DATETIME=27;
	public static final int DCOLON=28;
	public static final int DEFINE=29;
	public static final int DENSE=30;
	public static final int DESC=31;
	public static final int DIGIT=32;
	public static final int DISTINCT=33;
	public static final int DIV=34;
	public static final int DOLLAR=35;
	public static final int DOLLARVAR=36;
	public static final int DOUBLE=37;
	public static final int DOUBLENUMBER=38;
	public static final int DOUBLE_PERIOD=39;
	public static final int ELSE=40;
	public static final int END=41;
	public static final int EQUAL=42;
	public static final int EXECCOMMAND=43;
	public static final int FALSE=44;
	public static final int FAT_ARROW=45;
	public static final int FILTER=46;
	public static final int FLATTEN=47;
	public static final int FLOAT=48;
	public static final int FLOATINGPOINT=49;
	public static final int FLOATNUMBER=50;
	public static final int FOREACH=51;
	public static final int FULL=52;
	public static final int GENERATE=53;
	public static final int GROUP=54;
	public static final int ID=55;
	public static final int IDENTIFIER=56;
	public static final int IF=57;
	public static final int IMPORT=58;
	public static final int IN=59;
	public static final int INNER=60;
	public static final int INPUT=61;
	public static final int INT=62;
	public static final int INTEGER=63;
	public static final int INTO=64;
	public static final int INVOKE=65;
	public static final int IS=66;
	public static final int JOIN=67;
	public static final int LEFT=68;
	public static final int LEFT_BRACKET=69;
	public static final int LEFT_CURLY=70;
	public static final int LEFT_PAREN=71;
	public static final int LETTER=72;
	public static final int LIMIT=73;
	public static final int LOAD=74;
	public static final int LONG=75;
	public static final int LONGINTEGER=76;
	public static final int MAP=77;
	public static final int MAPREDUCE=78;
	public static final int MINUS=79;
	public static final int ML_COMMENT=80;
	public static final int MULTILINE_QUOTEDSTRING=81;
	public static final int NOT=82;
	public static final int NULL=83;
	public static final int NUM_OP_EQ=84;
	public static final int NUM_OP_GT=85;
	public static final int NUM_OP_GTE=86;
	public static final int NUM_OP_LT=87;
	public static final int NUM_OP_LTE=88;
	public static final int NUM_OP_NE=89;
	public static final int ONSCHEMA=90;
	public static final int OR=91;
	public static final int ORDER=92;
	public static final int OTHERWISE=93;
	public static final int OUTER=94;
	public static final int OUTPUT=95;
	public static final int PARALLEL=96;
	public static final int PARTITION=97;
	public static final int PERCENT=98;
	public static final int PERIOD=99;
	public static final int PLUS=100;
	public static final int POUND=101;
	public static final int QMARK=102;
	public static final int QUOTEDSTRING=103;
	public static final int RANK=104;
	public static final int REGISTER=105;
	public static final int RETURNS=106;
	public static final int RIGHT=107;
	public static final int RIGHT_BRACKET=108;
	public static final int RIGHT_CURLY=109;
	public static final int RIGHT_PAREN=110;
	public static final int ROLLUP=111;
	public static final int SAMPLE=112;
	public static final int SEMI_COLON=113;
	public static final int SHIP=114;
	public static final int SL_COMMENT=115;
	public static final int SPECIALCHAR=116;
	public static final int SPLIT=117;
	public static final int STAR=118;
	public static final int STDERROR=119;
	public static final int STDIN=120;
	public static final int STDOUT=121;
	public static final int STORE=122;
	public static final int STREAM=123;
	public static final int STR_OP_EQ=124;
	public static final int STR_OP_GT=125;
	public static final int STR_OP_GTE=126;
	public static final int STR_OP_LT=127;
	public static final int STR_OP_LTE=128;
	public static final int STR_OP_MATCHES=129;
	public static final int STR_OP_NE=130;
	public static final int THEN=131;
	public static final int THROUGH=132;
	public static final int TRUE=133;
	public static final int TUPLE=134;
	public static final int UNION=135;
	public static final int USING=136;
	public static final int VOID=137;
	public static final int WHEN=138;
	public static final int WS=139;


	@Override
	public void reportError(RecognitionException e) {
	    super.reportError( e );

	    // The method of this signature doesn't permit checked exception. Here we have to
	    // throw a unchecked execption in order to stop at the first error.
	    // For more information, visit http://www.antlr.org/wiki/pages/viewpage.action?pageId=5341217.
	    StringBuilder sb = new StringBuilder();
	    sb.append( getErrorHeader( e ) ).append( " " );
	    sb.append( getErrorMessage( e, getTokenNames() ) );
	    throw new RuntimeException( sb.toString() );
	}

	@Override
	public String getErrorMessage(RecognitionException e, String[] tokenNames ) {
	    if( e instanceof NoViableAltException ) {
	        return "Unexpected character " + getCharErrorDisplay( e.c );
	    } else {
	        return super.getErrorMessage( e, tokenNames );
	    }
	}

	@Override
	public String getErrorHeader(RecognitionException ex) {
		return QueryParserUtils.generateErrorHeader( ex, this.getSourceName() );
	}



	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public QueryLexer() {} 
	public QueryLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public QueryLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "QueryLexer.g"; }

	// $ANTLR start "VOID"
	public final void mVOID() throws RecognitionException {
		try {
			int _type = VOID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:60:9: ( 'VOID' )
			// QueryLexer.g:60:11: 'VOID'
			{
			match("VOID"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VOID"

	// $ANTLR start "NULL"
	public final void mNULL() throws RecognitionException {
		try {
			int _type = NULL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:63:9: ( 'NULL' )
			// QueryLexer.g:63:11: 'NULL'
			{
			match("NULL"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NULL"

	// $ANTLR start "IMPORT"
	public final void mIMPORT() throws RecognitionException {
		try {
			int _type = IMPORT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:66:9: ( 'IMPORT' )
			// QueryLexer.g:66:11: 'IMPORT'
			{
			match("IMPORT"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IMPORT"

	// $ANTLR start "REGISTER"
	public final void mREGISTER() throws RecognitionException {
		try {
			int _type = REGISTER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:69:10: ( 'REGISTER' )
			// QueryLexer.g:69:12: 'REGISTER'
			{
			match("REGISTER"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "REGISTER"

	// $ANTLR start "RETURNS"
	public final void mRETURNS() throws RecognitionException {
		try {
			int _type = RETURNS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:72:9: ( 'RETURNS' )
			// QueryLexer.g:72:11: 'RETURNS'
			{
			match("RETURNS"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RETURNS"

	// $ANTLR start "DEFINE"
	public final void mDEFINE() throws RecognitionException {
		try {
			int _type = DEFINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:75:8: ( 'DEFINE' )
			// QueryLexer.g:75:10: 'DEFINE'
			{
			match("DEFINE"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DEFINE"

	// $ANTLR start "LOAD"
	public final void mLOAD() throws RecognitionException {
		try {
			int _type = LOAD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:78:8: ( 'LOAD' )
			// QueryLexer.g:78:10: 'LOAD'
			{
			match("LOAD"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LOAD"

	// $ANTLR start "FILTER"
	public final void mFILTER() throws RecognitionException {
		try {
			int _type = FILTER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:81:8: ( 'FILTER' )
			// QueryLexer.g:81:10: 'FILTER'
			{
			match("FILTER"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FILTER"

	// $ANTLR start "FOREACH"
	public final void mFOREACH() throws RecognitionException {
		try {
			int _type = FOREACH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:84:9: ( 'FOREACH' )
			// QueryLexer.g:84:11: 'FOREACH'
			{
			match("FOREACH"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FOREACH"

	// $ANTLR start "ORDER"
	public final void mORDER() throws RecognitionException {
		try {
			int _type = ORDER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:87:9: ( 'ORDER' )
			// QueryLexer.g:87:12: 'ORDER'
			{
			match("ORDER"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ORDER"

	// $ANTLR start "RANK"
	public final void mRANK() throws RecognitionException {
		try {
			int _type = RANK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:90:8: ( 'RANK' )
			// QueryLexer.g:90:11: 'RANK'
			{
			match("RANK"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RANK"

	// $ANTLR start "DENSE"
	public final void mDENSE() throws RecognitionException {
		try {
			int _type = DENSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:93:9: ( 'DENSE' )
			// QueryLexer.g:93:12: 'DENSE'
			{
			match("DENSE"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DENSE"

	// $ANTLR start "CUBE"
	public final void mCUBE() throws RecognitionException {
		try {
			int _type = CUBE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:96:9: ( 'CUBE' )
			// QueryLexer.g:96:11: 'CUBE'
			{
			match("CUBE"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CUBE"

	// $ANTLR start "ROLLUP"
	public final void mROLLUP() throws RecognitionException {
		try {
			int _type = ROLLUP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:99:8: ( 'ROLLUP' )
			// QueryLexer.g:99:10: 'ROLLUP'
			{
			match("ROLLUP"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ROLLUP"

	// $ANTLR start "INVOKE"
	public final void mINVOKE() throws RecognitionException {
		try {
			int _type = INVOKE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:102:9: ( 'INVOKE' )
			// QueryLexer.g:102:11: 'INVOKE'
			{
			match("INVOKE"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INVOKE"

	// $ANTLR start "DISTINCT"
	public final void mDISTINCT() throws RecognitionException {
		try {
			int _type = DISTINCT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:105:10: ( 'DISTINCT' )
			// QueryLexer.g:105:12: 'DISTINCT'
			{
			match("DISTINCT"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DISTINCT"

	// $ANTLR start "COGROUP"
	public final void mCOGROUP() throws RecognitionException {
		try {
			int _type = COGROUP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:108:9: ( 'COGROUP' )
			// QueryLexer.g:108:11: 'COGROUP'
			{
			match("COGROUP"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COGROUP"

	// $ANTLR start "JOIN"
	public final void mJOIN() throws RecognitionException {
		try {
			int _type = JOIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:111:6: ( 'JOIN' )
			// QueryLexer.g:111:8: 'JOIN'
			{
			match("JOIN"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "JOIN"

	// $ANTLR start "CROSS"
	public final void mCROSS() throws RecognitionException {
		try {
			int _type = CROSS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:114:7: ( 'CROSS' )
			// QueryLexer.g:114:9: 'CROSS'
			{
			match("CROSS"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CROSS"

	// $ANTLR start "UNION"
	public final void mUNION() throws RecognitionException {
		try {
			int _type = UNION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:117:7: ( 'UNION' )
			// QueryLexer.g:117:9: 'UNION'
			{
			match("UNION"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UNION"

	// $ANTLR start "SPLIT"
	public final void mSPLIT() throws RecognitionException {
		try {
			int _type = SPLIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:120:7: ( 'SPLIT' )
			// QueryLexer.g:120:9: 'SPLIT'
			{
			match("SPLIT"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SPLIT"

	// $ANTLR start "INTO"
	public final void mINTO() throws RecognitionException {
		try {
			int _type = INTO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:123:6: ( 'INTO' )
			// QueryLexer.g:123:8: 'INTO'
			{
			match("INTO"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INTO"

	// $ANTLR start "IF"
	public final void mIF() throws RecognitionException {
		try {
			int _type = IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:126:4: ( 'IF' )
			// QueryLexer.g:126:6: 'IF'
			{
			match("IF"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IF"

	// $ANTLR start "OTHERWISE"
	public final void mOTHERWISE() throws RecognitionException {
		try {
			int _type = OTHERWISE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:129:11: ( 'OTHERWISE' )
			// QueryLexer.g:129:13: 'OTHERWISE'
			{
			match("OTHERWISE"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OTHERWISE"

	// $ANTLR start "ALL"
	public final void mALL() throws RecognitionException {
		try {
			int _type = ALL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:132:5: ( 'ALL' )
			// QueryLexer.g:132:7: 'ALL'
			{
			match("ALL"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ALL"

	// $ANTLR start "AS"
	public final void mAS() throws RecognitionException {
		try {
			int _type = AS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:135:4: ( 'AS' )
			// QueryLexer.g:135:6: 'AS'
			{
			match("AS"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AS"

	// $ANTLR start "BY"
	public final void mBY() throws RecognitionException {
		try {
			int _type = BY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:138:4: ( 'BY' )
			// QueryLexer.g:138:6: 'BY'
			{
			match("BY"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BY"

	// $ANTLR start "USING"
	public final void mUSING() throws RecognitionException {
		try {
			int _type = USING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:141:7: ( 'USING' )
			// QueryLexer.g:141:9: 'USING'
			{
			match("USING"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "USING"

	// $ANTLR start "INNER"
	public final void mINNER() throws RecognitionException {
		try {
			int _type = INNER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:144:7: ( 'INNER' )
			// QueryLexer.g:144:9: 'INNER'
			{
			match("INNER"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INNER"

	// $ANTLR start "OUTER"
	public final void mOUTER() throws RecognitionException {
		try {
			int _type = OUTER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:147:7: ( 'OUTER' )
			// QueryLexer.g:147:9: 'OUTER'
			{
			match("OUTER"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OUTER"

	// $ANTLR start "ONSCHEMA"
	public final void mONSCHEMA() throws RecognitionException {
		try {
			int _type = ONSCHEMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:150:10: ( 'ONSCHEMA' )
			// QueryLexer.g:150:12: 'ONSCHEMA'
			{
			match("ONSCHEMA"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ONSCHEMA"

	// $ANTLR start "PARALLEL"
	public final void mPARALLEL() throws RecognitionException {
		try {
			int _type = PARALLEL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:153:10: ( 'PARALLEL' )
			// QueryLexer.g:153:12: 'PARALLEL'
			{
			match("PARALLEL"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PARALLEL"

	// $ANTLR start "PARTITION"
	public final void mPARTITION() throws RecognitionException {
		try {
			int _type = PARTITION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:156:11: ( 'PARTITION' )
			// QueryLexer.g:156:13: 'PARTITION'
			{
			match("PARTITION"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PARTITION"

	// $ANTLR start "GROUP"
	public final void mGROUP() throws RecognitionException {
		try {
			int _type = GROUP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:159:7: ( 'GROUP' )
			// QueryLexer.g:159:9: 'GROUP'
			{
			match("GROUP"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GROUP"

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		try {
			int _type = AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:162:5: ( 'AND' )
			// QueryLexer.g:162:7: 'AND'
			{
			match("AND"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AND"

	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
		try {
			int _type = OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:165:4: ( 'OR' )
			// QueryLexer.g:165:6: 'OR'
			{
			match("OR"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OR"

	// $ANTLR start "NOT"
	public final void mNOT() throws RecognitionException {
		try {
			int _type = NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:168:5: ( 'NOT' )
			// QueryLexer.g:168:7: 'NOT'
			{
			match("NOT"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT"

	// $ANTLR start "GENERATE"
	public final void mGENERATE() throws RecognitionException {
		try {
			int _type = GENERATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:171:10: ( 'GENERATE' )
			// QueryLexer.g:171:12: 'GENERATE'
			{
			match("GENERATE"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GENERATE"

	// $ANTLR start "FLATTEN"
	public final void mFLATTEN() throws RecognitionException {
		try {
			int _type = FLATTEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:174:9: ( 'FLATTEN' )
			// QueryLexer.g:174:11: 'FLATTEN'
			{
			match("FLATTEN"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLATTEN"

	// $ANTLR start "ASC"
	public final void mASC() throws RecognitionException {
		try {
			int _type = ASC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:177:5: ( 'ASC' )
			// QueryLexer.g:177:7: 'ASC'
			{
			match("ASC"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASC"

	// $ANTLR start "DESC"
	public final void mDESC() throws RecognitionException {
		try {
			int _type = DESC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:180:6: ( 'DESC' )
			// QueryLexer.g:180:8: 'DESC'
			{
			match("DESC"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DESC"

	// $ANTLR start "BOOLEAN"
	public final void mBOOLEAN() throws RecognitionException {
		try {
			int _type = BOOLEAN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:183:9: ( 'BOOLEAN' )
			// QueryLexer.g:183:11: 'BOOLEAN'
			{
			match("BOOLEAN"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BOOLEAN"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:186:5: ( 'INT' )
			// QueryLexer.g:186:7: 'INT'
			{
			match("INT"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "LONG"
	public final void mLONG() throws RecognitionException {
		try {
			int _type = LONG;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:189:6: ( 'LONG' )
			// QueryLexer.g:189:8: 'LONG'
			{
			match("LONG"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LONG"

	// $ANTLR start "FLOAT"
	public final void mFLOAT() throws RecognitionException {
		try {
			int _type = FLOAT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:192:7: ( 'FLOAT' )
			// QueryLexer.g:192:9: 'FLOAT'
			{
			match("FLOAT"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOAT"

	// $ANTLR start "BIGDECIMAL"
	public final void mBIGDECIMAL() throws RecognitionException {
		try {
			int _type = BIGDECIMAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:195:12: ( 'BIGDECIMAL' )
			// QueryLexer.g:195:14: 'BIGDECIMAL'
			{
			match("BIGDECIMAL"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BIGDECIMAL"

	// $ANTLR start "BIGINTEGER"
	public final void mBIGINTEGER() throws RecognitionException {
		try {
			int _type = BIGINTEGER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:198:12: ( 'BIGINTEGER' )
			// QueryLexer.g:198:14: 'BIGINTEGER'
			{
			match("BIGINTEGER"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BIGINTEGER"

	// $ANTLR start "DOUBLE"
	public final void mDOUBLE() throws RecognitionException {
		try {
			int _type = DOUBLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:201:8: ( 'DOUBLE' )
			// QueryLexer.g:201:10: 'DOUBLE'
			{
			match("DOUBLE"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOUBLE"

	// $ANTLR start "DATETIME"
	public final void mDATETIME() throws RecognitionException {
		try {
			int _type = DATETIME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:204:10: ( 'DATETIME' )
			// QueryLexer.g:204:12: 'DATETIME'
			{
			match("DATETIME"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DATETIME"

	// $ANTLR start "CHARARRAY"
	public final void mCHARARRAY() throws RecognitionException {
		try {
			int _type = CHARARRAY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:207:11: ( 'CHARARRAY' )
			// QueryLexer.g:207:13: 'CHARARRAY'
			{
			match("CHARARRAY"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CHARARRAY"

	// $ANTLR start "BYTEARRAY"
	public final void mBYTEARRAY() throws RecognitionException {
		try {
			int _type = BYTEARRAY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:210:11: ( 'BYTEARRAY' )
			// QueryLexer.g:210:13: 'BYTEARRAY'
			{
			match("BYTEARRAY"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BYTEARRAY"

	// $ANTLR start "BAG"
	public final void mBAG() throws RecognitionException {
		try {
			int _type = BAG;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:213:5: ( 'BAG' )
			// QueryLexer.g:213:7: 'BAG'
			{
			match("BAG"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BAG"

	// $ANTLR start "TUPLE"
	public final void mTUPLE() throws RecognitionException {
		try {
			int _type = TUPLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:216:7: ( 'TUPLE' )
			// QueryLexer.g:216:9: 'TUPLE'
			{
			match("TUPLE"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TUPLE"

	// $ANTLR start "MAP"
	public final void mMAP() throws RecognitionException {
		try {
			int _type = MAP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:219:5: ( 'MAP' )
			// QueryLexer.g:219:7: 'MAP'
			{
			match("MAP"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MAP"

	// $ANTLR start "IS"
	public final void mIS() throws RecognitionException {
		try {
			int _type = IS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:222:4: ( 'IS' )
			// QueryLexer.g:222:6: 'IS'
			{
			match("IS"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IS"

	// $ANTLR start "STREAM"
	public final void mSTREAM() throws RecognitionException {
		try {
			int _type = STREAM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:225:8: ( 'STREAM' )
			// QueryLexer.g:225:10: 'STREAM'
			{
			match("STREAM"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STREAM"

	// $ANTLR start "THROUGH"
	public final void mTHROUGH() throws RecognitionException {
		try {
			int _type = THROUGH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:228:9: ( 'THROUGH' )
			// QueryLexer.g:228:11: 'THROUGH'
			{
			match("THROUGH"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "THROUGH"

	// $ANTLR start "STORE"
	public final void mSTORE() throws RecognitionException {
		try {
			int _type = STORE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:231:7: ( 'STORE' )
			// QueryLexer.g:231:9: 'STORE'
			{
			match("STORE"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STORE"

	// $ANTLR start "ASSERT"
	public final void mASSERT() throws RecognitionException {
		try {
			int _type = ASSERT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:234:8: ( 'ASSERT' )
			// QueryLexer.g:234:10: 'ASSERT'
			{
			match("ASSERT"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASSERT"

	// $ANTLR start "MAPREDUCE"
	public final void mMAPREDUCE() throws RecognitionException {
		try {
			int _type = MAPREDUCE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:237:11: ( 'MAPREDUCE' | 'NATIVE' )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0=='M') ) {
				alt1=1;
			}
			else if ( (LA1_0=='N') ) {
				alt1=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// QueryLexer.g:237:13: 'MAPREDUCE'
					{
					match("MAPREDUCE"); if (state.failed) return;

					}
					break;
				case 2 :
					// QueryLexer.g:237:27: 'NATIVE'
					{
					match("NATIVE"); if (state.failed) return;

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
	// $ANTLR end "MAPREDUCE"

	// $ANTLR start "SHIP"
	public final void mSHIP() throws RecognitionException {
		try {
			int _type = SHIP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:240:6: ( 'SHIP' )
			// QueryLexer.g:240:8: 'SHIP'
			{
			match("SHIP"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SHIP"

	// $ANTLR start "CACHE"
	public final void mCACHE() throws RecognitionException {
		try {
			int _type = CACHE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:243:7: ( 'CACHE' )
			// QueryLexer.g:243:9: 'CACHE'
			{
			match("CACHE"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CACHE"

	// $ANTLR start "INPUT"
	public final void mINPUT() throws RecognitionException {
		try {
			int _type = INPUT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:246:7: ( 'INPUT' )
			// QueryLexer.g:246:9: 'INPUT'
			{
			match("INPUT"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INPUT"

	// $ANTLR start "OUTPUT"
	public final void mOUTPUT() throws RecognitionException {
		try {
			int _type = OUTPUT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:249:8: ( 'OUTPUT' )
			// QueryLexer.g:249:10: 'OUTPUT'
			{
			match("OUTPUT"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OUTPUT"

	// $ANTLR start "STDERROR"
	public final void mSTDERROR() throws RecognitionException {
		try {
			int _type = STDERROR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:252:10: ( 'STDERR' )
			// QueryLexer.g:252:12: 'STDERR'
			{
			match("STDERR"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STDERROR"

	// $ANTLR start "STDIN"
	public final void mSTDIN() throws RecognitionException {
		try {
			int _type = STDIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:255:7: ( 'STDIN' )
			// QueryLexer.g:255:9: 'STDIN'
			{
			match("STDIN"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STDIN"

	// $ANTLR start "STDOUT"
	public final void mSTDOUT() throws RecognitionException {
		try {
			int _type = STDOUT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:258:8: ( 'STDOUT' )
			// QueryLexer.g:258:10: 'STDOUT'
			{
			match("STDOUT"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STDOUT"

	// $ANTLR start "LIMIT"
	public final void mLIMIT() throws RecognitionException {
		try {
			int _type = LIMIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:261:7: ( 'LIMIT' )
			// QueryLexer.g:261:9: 'LIMIT'
			{
			match("LIMIT"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LIMIT"

	// $ANTLR start "SAMPLE"
	public final void mSAMPLE() throws RecognitionException {
		try {
			int _type = SAMPLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:264:8: ( 'SAMPLE' )
			// QueryLexer.g:264:10: 'SAMPLE'
			{
			match("SAMPLE"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SAMPLE"

	// $ANTLR start "LEFT"
	public final void mLEFT() throws RecognitionException {
		try {
			int _type = LEFT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:267:6: ( 'LEFT' )
			// QueryLexer.g:267:8: 'LEFT'
			{
			match("LEFT"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LEFT"

	// $ANTLR start "RIGHT"
	public final void mRIGHT() throws RecognitionException {
		try {
			int _type = RIGHT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:270:7: ( 'RIGHT' )
			// QueryLexer.g:270:9: 'RIGHT'
			{
			match("RIGHT"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RIGHT"

	// $ANTLR start "FULL"
	public final void mFULL() throws RecognitionException {
		try {
			int _type = FULL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:273:6: ( 'FULL' )
			// QueryLexer.g:273:8: 'FULL'
			{
			match("FULL"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FULL"

	// $ANTLR start "CASE"
	public final void mCASE() throws RecognitionException {
		try {
			int _type = CASE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:276:6: ( 'CASE' )
			// QueryLexer.g:276:8: 'CASE'
			{
			match("CASE"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CASE"

	// $ANTLR start "WHEN"
	public final void mWHEN() throws RecognitionException {
		try {
			int _type = WHEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:279:6: ( 'WHEN' )
			// QueryLexer.g:279:8: 'WHEN'
			{
			match("WHEN"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHEN"

	// $ANTLR start "THEN"
	public final void mTHEN() throws RecognitionException {
		try {
			int _type = THEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:282:6: ( 'THEN' )
			// QueryLexer.g:282:8: 'THEN'
			{
			match("THEN"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "THEN"

	// $ANTLR start "ELSE"
	public final void mELSE() throws RecognitionException {
		try {
			int _type = ELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:285:6: ( 'ELSE' )
			// QueryLexer.g:285:8: 'ELSE'
			{
			match("ELSE"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ELSE"

	// $ANTLR start "END"
	public final void mEND() throws RecognitionException {
		try {
			int _type = END;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:288:5: ( 'END' )
			// QueryLexer.g:288:7: 'END'
			{
			match("END"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "END"

	// $ANTLR start "STR_OP_EQ"
	public final void mSTR_OP_EQ() throws RecognitionException {
		try {
			int _type = STR_OP_EQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:291:11: ( 'EQ' )
			// QueryLexer.g:291:13: 'EQ'
			{
			match("EQ"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STR_OP_EQ"

	// $ANTLR start "STR_OP_GT"
	public final void mSTR_OP_GT() throws RecognitionException {
		try {
			int _type = STR_OP_GT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:294:11: ( 'GT' )
			// QueryLexer.g:294:13: 'GT'
			{
			match("GT"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STR_OP_GT"

	// $ANTLR start "STR_OP_LT"
	public final void mSTR_OP_LT() throws RecognitionException {
		try {
			int _type = STR_OP_LT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:297:11: ( 'LT' )
			// QueryLexer.g:297:13: 'LT'
			{
			match("LT"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STR_OP_LT"

	// $ANTLR start "STR_OP_GTE"
	public final void mSTR_OP_GTE() throws RecognitionException {
		try {
			int _type = STR_OP_GTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:300:12: ( 'GTE' )
			// QueryLexer.g:300:14: 'GTE'
			{
			match("GTE"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STR_OP_GTE"

	// $ANTLR start "STR_OP_LTE"
	public final void mSTR_OP_LTE() throws RecognitionException {
		try {
			int _type = STR_OP_LTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:303:12: ( 'LTE' )
			// QueryLexer.g:303:14: 'LTE'
			{
			match("LTE"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STR_OP_LTE"

	// $ANTLR start "STR_OP_NE"
	public final void mSTR_OP_NE() throws RecognitionException {
		try {
			int _type = STR_OP_NE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:306:11: ( 'NEQ' )
			// QueryLexer.g:306:13: 'NEQ'
			{
			match("NEQ"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STR_OP_NE"

	// $ANTLR start "STR_OP_MATCHES"
	public final void mSTR_OP_MATCHES() throws RecognitionException {
		try {
			int _type = STR_OP_MATCHES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:309:16: ( 'MATCHES' )
			// QueryLexer.g:309:18: 'MATCHES'
			{
			match("MATCHES"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STR_OP_MATCHES"

	// $ANTLR start "IN"
	public final void mIN() throws RecognitionException {
		try {
			int _type = IN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:312:4: ( 'IN' )
			// QueryLexer.g:312:6: 'IN'
			{
			match("IN"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IN"

	// $ANTLR start "TRUE"
	public final void mTRUE() throws RecognitionException {
		try {
			int _type = TRUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:315:6: ( 'TRUE' )
			// QueryLexer.g:315:8: 'TRUE'
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
	// $ANTLR end "TRUE"

	// $ANTLR start "FALSE"
	public final void mFALSE() throws RecognitionException {
		try {
			int _type = FALSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:318:7: ( 'FALSE' )
			// QueryLexer.g:318:9: 'FALSE'
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
	// $ANTLR end "FALSE"

	// $ANTLR start "NUM_OP_EQ"
	public final void mNUM_OP_EQ() throws RecognitionException {
		try {
			int _type = NUM_OP_EQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:321:11: ( '==' )
			// QueryLexer.g:321:13: '=='
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
	// $ANTLR end "NUM_OP_EQ"

	// $ANTLR start "NUM_OP_LT"
	public final void mNUM_OP_LT() throws RecognitionException {
		try {
			int _type = NUM_OP_LT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:324:11: ( '<' )
			// QueryLexer.g:324:13: '<'
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
	// $ANTLR end "NUM_OP_LT"

	// $ANTLR start "NUM_OP_LTE"
	public final void mNUM_OP_LTE() throws RecognitionException {
		try {
			int _type = NUM_OP_LTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:327:12: ( '<=' )
			// QueryLexer.g:327:14: '<='
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
	// $ANTLR end "NUM_OP_LTE"

	// $ANTLR start "NUM_OP_GT"
	public final void mNUM_OP_GT() throws RecognitionException {
		try {
			int _type = NUM_OP_GT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:330:11: ( '>' )
			// QueryLexer.g:330:13: '>'
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
	// $ANTLR end "NUM_OP_GT"

	// $ANTLR start "NUM_OP_GTE"
	public final void mNUM_OP_GTE() throws RecognitionException {
		try {
			int _type = NUM_OP_GTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:333:12: ( '>=' )
			// QueryLexer.g:333:14: '>='
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
	// $ANTLR end "NUM_OP_GTE"

	// $ANTLR start "NUM_OP_NE"
	public final void mNUM_OP_NE() throws RecognitionException {
		try {
			int _type = NUM_OP_NE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:336:11: ( '!=' )
			// QueryLexer.g:336:13: '!='
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
	// $ANTLR end "NUM_OP_NE"

	// $ANTLR start "DIGIT"
	public final void mDIGIT() throws RecognitionException {
		try {
			// QueryLexer.g:339:16: ( '0' .. '9' )
			// QueryLexer.g:
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

	// $ANTLR start "LETTER"
	public final void mLETTER() throws RecognitionException {
		try {
			// QueryLexer.g:342:17: ( 'A' .. 'Z' )
			// QueryLexer.g:
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

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LETTER"

	// $ANTLR start "SPECIALCHAR"
	public final void mSPECIALCHAR() throws RecognitionException {
		try {
			// QueryLexer.g:345:22: ( '_' )
			// QueryLexer.g:345:24: '_'
			{
			match('_'); if (state.failed) return;
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SPECIALCHAR"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			// QueryLexer.g:348:12: ( LETTER ( DIGIT | LETTER | SPECIALCHAR )* )
			// QueryLexer.g:348:14: LETTER ( DIGIT | LETTER | SPECIALCHAR )*
			{
			mLETTER(); if (state.failed) return;

			// QueryLexer.g:348:21: ( DIGIT | LETTER | SPECIALCHAR )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_') ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// QueryLexer.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_' ) {
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
					break loop2;
				}
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "DCOLON"
	public final void mDCOLON() throws RecognitionException {
		try {
			int _type = DCOLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:351:8: ( '::' )
			// QueryLexer.g:351:10: '::'
			{
			match("::"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DCOLON"

	// $ANTLR start "IDENTIFIER"
	public final void mIDENTIFIER() throws RecognitionException {
		try {
			int _type = IDENTIFIER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:359:7: ( ( ID DCOLON )=> ( ID DCOLON IDENTIFIER ) | ID )
			int alt3=2;
			alt3 = dfa3.predict(input);
			switch (alt3) {
				case 1 :
					// QueryLexer.g:359:9: ( ID DCOLON )=> ( ID DCOLON IDENTIFIER )
					{
					// QueryLexer.g:359:26: ( ID DCOLON IDENTIFIER )
					// QueryLexer.g:359:28: ID DCOLON IDENTIFIER
					{
					mID(); if (state.failed) return;

					mDCOLON(); if (state.failed) return;

					mIDENTIFIER(); if (state.failed) return;

					}

					}
					break;
				case 2 :
					// QueryLexer.g:359:53: ID
					{
					mID(); if (state.failed) return;

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
			if ( state.backtracking==0 ) {
			        if("null".equalsIgnoreCase(getText())){
			            state.type = NULL;
			        }
			    }
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IDENTIFIER"

	// $ANTLR start "FLOATINGPOINT"
	public final void mFLOATINGPOINT() throws RecognitionException {
		try {
			// QueryLexer.g:362:24: ( INTEGER ( PERIOD INTEGER )? | PERIOD INTEGER )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
				alt5=1;
			}
			else if ( (LA5_0=='.') ) {
				alt5=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// QueryLexer.g:362:26: INTEGER ( PERIOD INTEGER )?
					{
					mINTEGER(); if (state.failed) return;

					// QueryLexer.g:362:34: ( PERIOD INTEGER )?
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0=='.') ) {
						alt4=1;
					}
					switch (alt4) {
						case 1 :
							// QueryLexer.g:362:36: PERIOD INTEGER
							{
							mPERIOD(); if (state.failed) return;

							mINTEGER(); if (state.failed) return;

							}
							break;

					}

					}
					break;
				case 2 :
					// QueryLexer.g:362:56: PERIOD INTEGER
					{
					mPERIOD(); if (state.failed) return;

					mINTEGER(); if (state.failed) return;

					}
					break;

			}
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOATINGPOINT"

	// $ANTLR start "INTEGER"
	public final void mINTEGER() throws RecognitionException {
		try {
			int _type = INTEGER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:365:8: ( ( DIGIT )+ )
			// QueryLexer.g:365:10: ( DIGIT )+
			{
			// QueryLexer.g:365:10: ( DIGIT )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// QueryLexer.g:
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
					if ( cnt6 >= 1 ) break loop6;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INTEGER"

	// $ANTLR start "LONGINTEGER"
	public final void mLONGINTEGER() throws RecognitionException {
		try {
			int _type = LONGINTEGER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:368:12: ( INTEGER 'L' )
			// QueryLexer.g:368:14: INTEGER 'L'
			{
			mINTEGER(); if (state.failed) return;

			match('L'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LONGINTEGER"

	// $ANTLR start "DOLLARVAR"
	public final void mDOLLARVAR() throws RecognitionException {
		try {
			int _type = DOLLARVAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:371:11: ( DOLLAR INTEGER )
			// QueryLexer.g:371:13: DOLLAR INTEGER
			{
			mDOLLAR(); if (state.failed) return;

			mINTEGER(); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOLLARVAR"

	// $ANTLR start "DOUBLENUMBER"
	public final void mDOUBLENUMBER() throws RecognitionException {
		try {
			int _type = DOUBLENUMBER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:374:14: ( FLOATINGPOINT ( 'E' ( MINUS | PLUS )? INTEGER )? )
			// QueryLexer.g:374:16: FLOATINGPOINT ( 'E' ( MINUS | PLUS )? INTEGER )?
			{
			mFLOATINGPOINT(); if (state.failed) return;

			// QueryLexer.g:374:30: ( 'E' ( MINUS | PLUS )? INTEGER )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0=='E') ) {
				alt8=1;
			}
			switch (alt8) {
				case 1 :
					// QueryLexer.g:374:32: 'E' ( MINUS | PLUS )? INTEGER
					{
					match('E'); if (state.failed) return;
					// QueryLexer.g:374:36: ( MINUS | PLUS )?
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0=='+'||LA7_0=='-') ) {
						alt7=1;
					}
					switch (alt7) {
						case 1 :
							// QueryLexer.g:
							{
							if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
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

					}

					mINTEGER(); if (state.failed) return;

					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOUBLENUMBER"

	// $ANTLR start "BIGDECIMALNUMBER"
	public final void mBIGDECIMALNUMBER() throws RecognitionException {
		try {
			int _type = BIGDECIMALNUMBER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:377:18: ( DOUBLENUMBER 'BD' )
			// QueryLexer.g:377:20: DOUBLENUMBER 'BD'
			{
			mDOUBLENUMBER(); if (state.failed) return;

			match("BD"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BIGDECIMALNUMBER"

	// $ANTLR start "BIGINTEGERNUMBER"
	public final void mBIGINTEGERNUMBER() throws RecognitionException {
		try {
			int _type = BIGINTEGERNUMBER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:380:18: ( INTEGER 'BI' )
			// QueryLexer.g:380:20: INTEGER 'BI'
			{
			mINTEGER(); if (state.failed) return;

			match("BI"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BIGINTEGERNUMBER"

	// $ANTLR start "FLOATNUMBER"
	public final void mFLOATNUMBER() throws RecognitionException {
		try {
			int _type = FLOATNUMBER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:383:13: ( DOUBLENUMBER 'F' )
			// QueryLexer.g:383:15: DOUBLENUMBER 'F'
			{
			mDOUBLENUMBER(); if (state.failed) return;

			match('F'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOATNUMBER"

	// $ANTLR start "QUOTEDSTRING"
	public final void mQUOTEDSTRING() throws RecognitionException {
		try {
			int _type = QUOTEDSTRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:386:14: ( '\\'' ( (~ ( '\\'' | '\\\\' | '\\n' | '\\r' ) ) | ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' ) ) ) | ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ) )* '\\'' )
			// QueryLexer.g:386:17: '\\'' ( (~ ( '\\'' | '\\\\' | '\\n' | '\\r' ) ) | ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' ) ) ) | ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ) )* '\\''
			{
			match('\''); if (state.failed) return;
			// QueryLexer.g:386:22: ( (~ ( '\\'' | '\\\\' | '\\n' | '\\r' ) ) | ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' ) ) ) | ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ) )*
			loop9:
			while (true) {
				int alt9=4;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= '\u0000' && LA9_0 <= '\t')||(LA9_0 >= '\u000B' && LA9_0 <= '\f')||(LA9_0 >= '\u000E' && LA9_0 <= '&')||(LA9_0 >= '(' && LA9_0 <= '[')||(LA9_0 >= ']' && LA9_0 <= '\uFFFF')) ) {
					alt9=1;
				}
				else if ( (LA9_0=='\\') ) {
					int LA9_3 = input.LA(2);
					if ( (LA9_3=='\''||LA9_3=='B'||LA9_3=='F'||LA9_3=='N'||LA9_3=='R'||LA9_3=='T'||LA9_3=='\\') ) {
						alt9=2;
					}
					else if ( (LA9_3=='U') ) {
						alt9=3;
					}

				}

				switch (alt9) {
				case 1 :
					// QueryLexer.g:386:26: (~ ( '\\'' | '\\\\' | '\\n' | '\\r' ) )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
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
				case 2 :
					// QueryLexer.g:387:26: ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' ) ) )
					{
					// QueryLexer.g:387:26: ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' ) ) )
					// QueryLexer.g:387:28: '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' ) )
					{
					match('\\'); if (state.failed) return;
					if ( input.LA(1)=='\''||input.LA(1)=='B'||input.LA(1)=='F'||input.LA(1)=='N'||input.LA(1)=='R'||input.LA(1)=='T'||input.LA(1)=='\\' ) {
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
					break;
				case 3 :
					// QueryLexer.g:388:26: ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) )
					{
					// QueryLexer.g:388:26: ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) )
					// QueryLexer.g:388:28: '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' )
					{
					match("\\U"); if (state.failed) return;

					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F') ) {
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
					break;

				default :
					break loop9;
				}
			}

			match('\''); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "QUOTEDSTRING"

	// $ANTLR start "MULTILINE_QUOTEDSTRING"
	public final void mMULTILINE_QUOTEDSTRING() throws RecognitionException {
		try {
			int _type = MULTILINE_QUOTEDSTRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:396:24: ( '\\'' ( (~ ( '\\'' | '\\\\' ) ) | ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' | 'n' | 'r' ) ) ) | ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ) )* '\\'' )
			// QueryLexer.g:396:27: '\\'' ( (~ ( '\\'' | '\\\\' ) ) | ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' | 'n' | 'r' ) ) ) | ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ) )* '\\''
			{
			match('\''); if (state.failed) return;
			// QueryLexer.g:396:32: ( (~ ( '\\'' | '\\\\' ) ) | ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' | 'n' | 'r' ) ) ) | ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ) )*
			loop10:
			while (true) {
				int alt10=4;
				int LA10_0 = input.LA(1);
				if ( ((LA10_0 >= '\u0000' && LA10_0 <= '&')||(LA10_0 >= '(' && LA10_0 <= '[')||(LA10_0 >= ']' && LA10_0 <= '\uFFFF')) ) {
					alt10=1;
				}
				else if ( (LA10_0=='\\') ) {
					int LA10_3 = input.LA(2);
					if ( (LA10_3=='\''||LA10_3=='B'||LA10_3=='F'||LA10_3=='N'||LA10_3=='R'||LA10_3=='T'||LA10_3=='\\'||LA10_3=='n'||LA10_3=='r') ) {
						alt10=2;
					}
					else if ( (LA10_3=='U') ) {
						alt10=3;
					}

				}

				switch (alt10) {
				case 1 :
					// QueryLexer.g:396:36: (~ ( '\\'' | '\\\\' ) )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
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
				case 2 :
					// QueryLexer.g:397:36: ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' | 'n' | 'r' ) ) )
					{
					// QueryLexer.g:397:36: ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' | 'n' | 'r' ) ) )
					// QueryLexer.g:397:38: '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' | 'n' | 'r' ) )
					{
					match('\\'); if (state.failed) return;
					if ( input.LA(1)=='\''||input.LA(1)=='B'||input.LA(1)=='F'||input.LA(1)=='N'||input.LA(1)=='R'||input.LA(1)=='T'||input.LA(1)=='\\'||input.LA(1)=='n'||input.LA(1)=='r' ) {
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
					break;
				case 3 :
					// QueryLexer.g:398:36: ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) )
					{
					// QueryLexer.g:398:36: ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) )
					// QueryLexer.g:398:38: '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' )
					{
					match("\\U"); if (state.failed) return;

					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F') ) {
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
					break;

				default :
					break loop10;
				}
			}

			match('\''); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MULTILINE_QUOTEDSTRING"

	// $ANTLR start "EXECCOMMAND"
	public final void mEXECCOMMAND() throws RecognitionException {
		try {
			int _type = EXECCOMMAND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:406:13: ( '`' (~ ( '`' ) )* '`' )
			// QueryLexer.g:406:15: '`' (~ ( '`' ) )* '`'
			{
			match('`'); if (state.failed) return;
			// QueryLexer.g:406:19: (~ ( '`' ) )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( ((LA11_0 >= '\u0000' && LA11_0 <= '_')||(LA11_0 >= 'a' && LA11_0 <= '\uFFFF')) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// QueryLexer.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '_')||(input.LA(1) >= 'a' && input.LA(1) <= '\uFFFF') ) {
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
					break loop11;
				}
			}

			match('`'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXECCOMMAND"

	// $ANTLR start "STAR"
	public final void mSTAR() throws RecognitionException {
		try {
			int _type = STAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:409:6: ( '*' )
			// QueryLexer.g:409:8: '*'
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

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:412:7: ( ':' )
			// QueryLexer.g:412:9: ':'
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

	// $ANTLR start "DOLLAR"
	public final void mDOLLAR() throws RecognitionException {
		try {
			int _type = DOLLAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:415:8: ( '$' )
			// QueryLexer.g:415:10: '$'
			{
			match('$'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOLLAR"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:418:5: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
			// QueryLexer.g:418:8: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
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

	// $ANTLR start "SL_COMMENT"
	public final void mSL_COMMENT() throws RecognitionException {
		try {
			int _type = SL_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:421:12: ( '--' (~ ( '\\r' | '\\n' ) )* )
			// QueryLexer.g:421:14: '--' (~ ( '\\r' | '\\n' ) )*
			{
			match("--"); if (state.failed) return;

			// QueryLexer.g:421:19: (~ ( '\\r' | '\\n' ) )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( ((LA12_0 >= '\u0000' && LA12_0 <= '\t')||(LA12_0 >= '\u000B' && LA12_0 <= '\f')||(LA12_0 >= '\u000E' && LA12_0 <= '\uFFFF')) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// QueryLexer.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
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
					break loop12;
				}
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
	// $ANTLR end "SL_COMMENT"

	// $ANTLR start "ML_COMMENT"
	public final void mML_COMMENT() throws RecognitionException {
		try {
			int _type = ML_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:424:12: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// QueryLexer.g:424:14: '/*' ( options {greedy=false; } : . )* '*/'
			{
			match("/*"); if (state.failed) return;

			// QueryLexer.g:424:19: ( options {greedy=false; } : . )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0=='*') ) {
					int LA13_1 = input.LA(2);
					if ( (LA13_1=='/') ) {
						alt13=2;
					}
					else if ( ((LA13_1 >= '\u0000' && LA13_1 <= '.')||(LA13_1 >= '0' && LA13_1 <= '\uFFFF')) ) {
						alt13=1;
					}

				}
				else if ( ((LA13_0 >= '\u0000' && LA13_0 <= ')')||(LA13_0 >= '+' && LA13_0 <= '\uFFFF')) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// QueryLexer.g:424:49: .
					{
					matchAny(); if (state.failed) return;
					}
					break;

				default :
					break loop13;
				}
			}

			match("*/"); if (state.failed) return;

			if ( state.backtracking==0 ) { _channel = HIDDEN; }
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ML_COMMENT"

	// $ANTLR start "SEMI_COLON"
	public final void mSEMI_COLON() throws RecognitionException {
		try {
			int _type = SEMI_COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:427:12: ( ';' )
			// QueryLexer.g:427:14: ';'
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
	// $ANTLR end "SEMI_COLON"

	// $ANTLR start "LEFT_PAREN"
	public final void mLEFT_PAREN() throws RecognitionException {
		try {
			int _type = LEFT_PAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:430:12: ( '(' )
			// QueryLexer.g:430:14: '('
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
			// QueryLexer.g:433:13: ( ')' )
			// QueryLexer.g:433:15: ')'
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

	// $ANTLR start "LEFT_CURLY"
	public final void mLEFT_CURLY() throws RecognitionException {
		try {
			int _type = LEFT_CURLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:436:12: ( '{' )
			// QueryLexer.g:436:14: '{'
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
	// $ANTLR end "LEFT_CURLY"

	// $ANTLR start "RIGHT_CURLY"
	public final void mRIGHT_CURLY() throws RecognitionException {
		try {
			int _type = RIGHT_CURLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:439:13: ( '}' )
			// QueryLexer.g:439:15: '}'
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
	// $ANTLR end "RIGHT_CURLY"

	// $ANTLR start "LEFT_BRACKET"
	public final void mLEFT_BRACKET() throws RecognitionException {
		try {
			int _type = LEFT_BRACKET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:442:14: ( '[' )
			// QueryLexer.g:442:16: '['
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
			// QueryLexer.g:445:15: ( ']' )
			// QueryLexer.g:445:17: ']'
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

	// $ANTLR start "POUND"
	public final void mPOUND() throws RecognitionException {
		try {
			int _type = POUND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:448:7: ( '#' )
			// QueryLexer.g:448:9: '#'
			{
			match('#'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "POUND"

	// $ANTLR start "EQUAL"
	public final void mEQUAL() throws RecognitionException {
		try {
			int _type = EQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:451:7: ( '=' )
			// QueryLexer.g:451:9: '='
			{
			match('='); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQUAL"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:454:7: ( ',' )
			// QueryLexer.g:454:9: ','
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

	// $ANTLR start "PERIOD"
	public final void mPERIOD() throws RecognitionException {
		try {
			int _type = PERIOD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:457:8: ( '.' )
			// QueryLexer.g:457:10: '.'
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
	// $ANTLR end "PERIOD"

	// $ANTLR start "DOUBLE_PERIOD"
	public final void mDOUBLE_PERIOD() throws RecognitionException {
		try {
			int _type = DOUBLE_PERIOD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:460:15: ( '..' )
			// QueryLexer.g:460:17: '..'
			{
			match(".."); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOUBLE_PERIOD"

	// $ANTLR start "DIV"
	public final void mDIV() throws RecognitionException {
		try {
			int _type = DIV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:463:5: ( '/' )
			// QueryLexer.g:463:7: '/'
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
	// $ANTLR end "DIV"

	// $ANTLR start "PERCENT"
	public final void mPERCENT() throws RecognitionException {
		try {
			int _type = PERCENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:466:9: ( '%' )
			// QueryLexer.g:466:11: '%'
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
	// $ANTLR end "PERCENT"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:469:6: ( '+' )
			// QueryLexer.g:469:8: '+'
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

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:472:7: ( '-' )
			// QueryLexer.g:472:9: '-'
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
	// $ANTLR end "MINUS"

	// $ANTLR start "QMARK"
	public final void mQMARK() throws RecognitionException {
		try {
			int _type = QMARK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:475:7: ( '?' )
			// QueryLexer.g:475:9: '?'
			{
			match('?'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "QMARK"

	// $ANTLR start "ARROBA"
	public final void mARROBA() throws RecognitionException {
		try {
			int _type = ARROBA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:478:8: ( '@' )
			// QueryLexer.g:478:10: '@'
			{
			match('@'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ARROBA"

	// $ANTLR start "AMPERSAND"
	public final void mAMPERSAND() throws RecognitionException {
		try {
			int _type = AMPERSAND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:481:11: ( '&' )
			// QueryLexer.g:481:13: '&'
			{
			match('&'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AMPERSAND"

	// $ANTLR start "FAT_ARROW"
	public final void mFAT_ARROW() throws RecognitionException {
		try {
			int _type = FAT_ARROW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// QueryLexer.g:484:11: ( '=>' )
			// QueryLexer.g:484:13: '=>'
			{
			match("=>"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FAT_ARROW"

	@Override
	public void mTokens() throws RecognitionException {
		// QueryLexer.g:1:8: ( VOID | NULL | IMPORT | REGISTER | RETURNS | DEFINE | LOAD | FILTER | FOREACH | ORDER | RANK | DENSE | CUBE | ROLLUP | INVOKE | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | OTHERWISE | ALL | AS | BY | USING | INNER | OUTER | ONSCHEMA | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | BIGDECIMAL | BIGINTEGER | DOUBLE | DATETIME | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | STREAM | THROUGH | STORE | ASSERT | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | CASE | WHEN | THEN | ELSE | END | STR_OP_EQ | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_NE | STR_OP_MATCHES | IN | TRUE | FALSE | NUM_OP_EQ | NUM_OP_LT | NUM_OP_LTE | NUM_OP_GT | NUM_OP_GTE | NUM_OP_NE | DCOLON | IDENTIFIER | INTEGER | LONGINTEGER | DOLLARVAR | DOUBLENUMBER | BIGDECIMALNUMBER | BIGINTEGERNUMBER | FLOATNUMBER | QUOTEDSTRING | MULTILINE_QUOTEDSTRING | EXECCOMMAND | STAR | COLON | DOLLAR | WS | SL_COMMENT | ML_COMMENT | SEMI_COLON | LEFT_PAREN | RIGHT_PAREN | LEFT_CURLY | RIGHT_CURLY | LEFT_BRACKET | RIGHT_BRACKET | POUND | EQUAL | COMMA | PERIOD | DOUBLE_PERIOD | DIV | PERCENT | PLUS | MINUS | QMARK | ARROBA | AMPERSAND | FAT_ARROW )
		int alt14=131;
		alt14 = dfa14.predict(input);
		switch (alt14) {
			case 1 :
				// QueryLexer.g:1:10: VOID
				{
				mVOID(); if (state.failed) return;

				}
				break;
			case 2 :
				// QueryLexer.g:1:15: NULL
				{
				mNULL(); if (state.failed) return;

				}
				break;
			case 3 :
				// QueryLexer.g:1:20: IMPORT
				{
				mIMPORT(); if (state.failed) return;

				}
				break;
			case 4 :
				// QueryLexer.g:1:27: REGISTER
				{
				mREGISTER(); if (state.failed) return;

				}
				break;
			case 5 :
				// QueryLexer.g:1:36: RETURNS
				{
				mRETURNS(); if (state.failed) return;

				}
				break;
			case 6 :
				// QueryLexer.g:1:44: DEFINE
				{
				mDEFINE(); if (state.failed) return;

				}
				break;
			case 7 :
				// QueryLexer.g:1:51: LOAD
				{
				mLOAD(); if (state.failed) return;

				}
				break;
			case 8 :
				// QueryLexer.g:1:56: FILTER
				{
				mFILTER(); if (state.failed) return;

				}
				break;
			case 9 :
				// QueryLexer.g:1:63: FOREACH
				{
				mFOREACH(); if (state.failed) return;

				}
				break;
			case 10 :
				// QueryLexer.g:1:71: ORDER
				{
				mORDER(); if (state.failed) return;

				}
				break;
			case 11 :
				// QueryLexer.g:1:77: RANK
				{
				mRANK(); if (state.failed) return;

				}
				break;
			case 12 :
				// QueryLexer.g:1:82: DENSE
				{
				mDENSE(); if (state.failed) return;

				}
				break;
			case 13 :
				// QueryLexer.g:1:88: CUBE
				{
				mCUBE(); if (state.failed) return;

				}
				break;
			case 14 :
				// QueryLexer.g:1:93: ROLLUP
				{
				mROLLUP(); if (state.failed) return;

				}
				break;
			case 15 :
				// QueryLexer.g:1:100: INVOKE
				{
				mINVOKE(); if (state.failed) return;

				}
				break;
			case 16 :
				// QueryLexer.g:1:107: DISTINCT
				{
				mDISTINCT(); if (state.failed) return;

				}
				break;
			case 17 :
				// QueryLexer.g:1:116: COGROUP
				{
				mCOGROUP(); if (state.failed) return;

				}
				break;
			case 18 :
				// QueryLexer.g:1:124: JOIN
				{
				mJOIN(); if (state.failed) return;

				}
				break;
			case 19 :
				// QueryLexer.g:1:129: CROSS
				{
				mCROSS(); if (state.failed) return;

				}
				break;
			case 20 :
				// QueryLexer.g:1:135: UNION
				{
				mUNION(); if (state.failed) return;

				}
				break;
			case 21 :
				// QueryLexer.g:1:141: SPLIT
				{
				mSPLIT(); if (state.failed) return;

				}
				break;
			case 22 :
				// QueryLexer.g:1:147: INTO
				{
				mINTO(); if (state.failed) return;

				}
				break;
			case 23 :
				// QueryLexer.g:1:152: IF
				{
				mIF(); if (state.failed) return;

				}
				break;
			case 24 :
				// QueryLexer.g:1:155: OTHERWISE
				{
				mOTHERWISE(); if (state.failed) return;

				}
				break;
			case 25 :
				// QueryLexer.g:1:165: ALL
				{
				mALL(); if (state.failed) return;

				}
				break;
			case 26 :
				// QueryLexer.g:1:169: AS
				{
				mAS(); if (state.failed) return;

				}
				break;
			case 27 :
				// QueryLexer.g:1:172: BY
				{
				mBY(); if (state.failed) return;

				}
				break;
			case 28 :
				// QueryLexer.g:1:175: USING
				{
				mUSING(); if (state.failed) return;

				}
				break;
			case 29 :
				// QueryLexer.g:1:181: INNER
				{
				mINNER(); if (state.failed) return;

				}
				break;
			case 30 :
				// QueryLexer.g:1:187: OUTER
				{
				mOUTER(); if (state.failed) return;

				}
				break;
			case 31 :
				// QueryLexer.g:1:193: ONSCHEMA
				{
				mONSCHEMA(); if (state.failed) return;

				}
				break;
			case 32 :
				// QueryLexer.g:1:202: PARALLEL
				{
				mPARALLEL(); if (state.failed) return;

				}
				break;
			case 33 :
				// QueryLexer.g:1:211: PARTITION
				{
				mPARTITION(); if (state.failed) return;

				}
				break;
			case 34 :
				// QueryLexer.g:1:221: GROUP
				{
				mGROUP(); if (state.failed) return;

				}
				break;
			case 35 :
				// QueryLexer.g:1:227: AND
				{
				mAND(); if (state.failed) return;

				}
				break;
			case 36 :
				// QueryLexer.g:1:231: OR
				{
				mOR(); if (state.failed) return;

				}
				break;
			case 37 :
				// QueryLexer.g:1:234: NOT
				{
				mNOT(); if (state.failed) return;

				}
				break;
			case 38 :
				// QueryLexer.g:1:238: GENERATE
				{
				mGENERATE(); if (state.failed) return;

				}
				break;
			case 39 :
				// QueryLexer.g:1:247: FLATTEN
				{
				mFLATTEN(); if (state.failed) return;

				}
				break;
			case 40 :
				// QueryLexer.g:1:255: ASC
				{
				mASC(); if (state.failed) return;

				}
				break;
			case 41 :
				// QueryLexer.g:1:259: DESC
				{
				mDESC(); if (state.failed) return;

				}
				break;
			case 42 :
				// QueryLexer.g:1:264: BOOLEAN
				{
				mBOOLEAN(); if (state.failed) return;

				}
				break;
			case 43 :
				// QueryLexer.g:1:272: INT
				{
				mINT(); if (state.failed) return;

				}
				break;
			case 44 :
				// QueryLexer.g:1:276: LONG
				{
				mLONG(); if (state.failed) return;

				}
				break;
			case 45 :
				// QueryLexer.g:1:281: FLOAT
				{
				mFLOAT(); if (state.failed) return;

				}
				break;
			case 46 :
				// QueryLexer.g:1:287: BIGDECIMAL
				{
				mBIGDECIMAL(); if (state.failed) return;

				}
				break;
			case 47 :
				// QueryLexer.g:1:298: BIGINTEGER
				{
				mBIGINTEGER(); if (state.failed) return;

				}
				break;
			case 48 :
				// QueryLexer.g:1:309: DOUBLE
				{
				mDOUBLE(); if (state.failed) return;

				}
				break;
			case 49 :
				// QueryLexer.g:1:316: DATETIME
				{
				mDATETIME(); if (state.failed) return;

				}
				break;
			case 50 :
				// QueryLexer.g:1:325: CHARARRAY
				{
				mCHARARRAY(); if (state.failed) return;

				}
				break;
			case 51 :
				// QueryLexer.g:1:335: BYTEARRAY
				{
				mBYTEARRAY(); if (state.failed) return;

				}
				break;
			case 52 :
				// QueryLexer.g:1:345: BAG
				{
				mBAG(); if (state.failed) return;

				}
				break;
			case 53 :
				// QueryLexer.g:1:349: TUPLE
				{
				mTUPLE(); if (state.failed) return;

				}
				break;
			case 54 :
				// QueryLexer.g:1:355: MAP
				{
				mMAP(); if (state.failed) return;

				}
				break;
			case 55 :
				// QueryLexer.g:1:359: IS
				{
				mIS(); if (state.failed) return;

				}
				break;
			case 56 :
				// QueryLexer.g:1:362: STREAM
				{
				mSTREAM(); if (state.failed) return;

				}
				break;
			case 57 :
				// QueryLexer.g:1:369: THROUGH
				{
				mTHROUGH(); if (state.failed) return;

				}
				break;
			case 58 :
				// QueryLexer.g:1:377: STORE
				{
				mSTORE(); if (state.failed) return;

				}
				break;
			case 59 :
				// QueryLexer.g:1:383: ASSERT
				{
				mASSERT(); if (state.failed) return;

				}
				break;
			case 60 :
				// QueryLexer.g:1:390: MAPREDUCE
				{
				mMAPREDUCE(); if (state.failed) return;

				}
				break;
			case 61 :
				// QueryLexer.g:1:400: SHIP
				{
				mSHIP(); if (state.failed) return;

				}
				break;
			case 62 :
				// QueryLexer.g:1:405: CACHE
				{
				mCACHE(); if (state.failed) return;

				}
				break;
			case 63 :
				// QueryLexer.g:1:411: INPUT
				{
				mINPUT(); if (state.failed) return;

				}
				break;
			case 64 :
				// QueryLexer.g:1:417: OUTPUT
				{
				mOUTPUT(); if (state.failed) return;

				}
				break;
			case 65 :
				// QueryLexer.g:1:424: STDERROR
				{
				mSTDERROR(); if (state.failed) return;

				}
				break;
			case 66 :
				// QueryLexer.g:1:433: STDIN
				{
				mSTDIN(); if (state.failed) return;

				}
				break;
			case 67 :
				// QueryLexer.g:1:439: STDOUT
				{
				mSTDOUT(); if (state.failed) return;

				}
				break;
			case 68 :
				// QueryLexer.g:1:446: LIMIT
				{
				mLIMIT(); if (state.failed) return;

				}
				break;
			case 69 :
				// QueryLexer.g:1:452: SAMPLE
				{
				mSAMPLE(); if (state.failed) return;

				}
				break;
			case 70 :
				// QueryLexer.g:1:459: LEFT
				{
				mLEFT(); if (state.failed) return;

				}
				break;
			case 71 :
				// QueryLexer.g:1:464: RIGHT
				{
				mRIGHT(); if (state.failed) return;

				}
				break;
			case 72 :
				// QueryLexer.g:1:470: FULL
				{
				mFULL(); if (state.failed) return;

				}
				break;
			case 73 :
				// QueryLexer.g:1:475: CASE
				{
				mCASE(); if (state.failed) return;

				}
				break;
			case 74 :
				// QueryLexer.g:1:480: WHEN
				{
				mWHEN(); if (state.failed) return;

				}
				break;
			case 75 :
				// QueryLexer.g:1:485: THEN
				{
				mTHEN(); if (state.failed) return;

				}
				break;
			case 76 :
				// QueryLexer.g:1:490: ELSE
				{
				mELSE(); if (state.failed) return;

				}
				break;
			case 77 :
				// QueryLexer.g:1:495: END
				{
				mEND(); if (state.failed) return;

				}
				break;
			case 78 :
				// QueryLexer.g:1:499: STR_OP_EQ
				{
				mSTR_OP_EQ(); if (state.failed) return;

				}
				break;
			case 79 :
				// QueryLexer.g:1:509: STR_OP_GT
				{
				mSTR_OP_GT(); if (state.failed) return;

				}
				break;
			case 80 :
				// QueryLexer.g:1:519: STR_OP_LT
				{
				mSTR_OP_LT(); if (state.failed) return;

				}
				break;
			case 81 :
				// QueryLexer.g:1:529: STR_OP_GTE
				{
				mSTR_OP_GTE(); if (state.failed) return;

				}
				break;
			case 82 :
				// QueryLexer.g:1:540: STR_OP_LTE
				{
				mSTR_OP_LTE(); if (state.failed) return;

				}
				break;
			case 83 :
				// QueryLexer.g:1:551: STR_OP_NE
				{
				mSTR_OP_NE(); if (state.failed) return;

				}
				break;
			case 84 :
				// QueryLexer.g:1:561: STR_OP_MATCHES
				{
				mSTR_OP_MATCHES(); if (state.failed) return;

				}
				break;
			case 85 :
				// QueryLexer.g:1:576: IN
				{
				mIN(); if (state.failed) return;

				}
				break;
			case 86 :
				// QueryLexer.g:1:579: TRUE
				{
				mTRUE(); if (state.failed) return;

				}
				break;
			case 87 :
				// QueryLexer.g:1:584: FALSE
				{
				mFALSE(); if (state.failed) return;

				}
				break;
			case 88 :
				// QueryLexer.g:1:590: NUM_OP_EQ
				{
				mNUM_OP_EQ(); if (state.failed) return;

				}
				break;
			case 89 :
				// QueryLexer.g:1:600: NUM_OP_LT
				{
				mNUM_OP_LT(); if (state.failed) return;

				}
				break;
			case 90 :
				// QueryLexer.g:1:610: NUM_OP_LTE
				{
				mNUM_OP_LTE(); if (state.failed) return;

				}
				break;
			case 91 :
				// QueryLexer.g:1:621: NUM_OP_GT
				{
				mNUM_OP_GT(); if (state.failed) return;

				}
				break;
			case 92 :
				// QueryLexer.g:1:631: NUM_OP_GTE
				{
				mNUM_OP_GTE(); if (state.failed) return;

				}
				break;
			case 93 :
				// QueryLexer.g:1:642: NUM_OP_NE
				{
				mNUM_OP_NE(); if (state.failed) return;

				}
				break;
			case 94 :
				// QueryLexer.g:1:652: DCOLON
				{
				mDCOLON(); if (state.failed) return;

				}
				break;
			case 95 :
				// QueryLexer.g:1:659: IDENTIFIER
				{
				mIDENTIFIER(); if (state.failed) return;

				}
				break;
			case 96 :
				// QueryLexer.g:1:670: INTEGER
				{
				mINTEGER(); if (state.failed) return;

				}
				break;
			case 97 :
				// QueryLexer.g:1:678: LONGINTEGER
				{
				mLONGINTEGER(); if (state.failed) return;

				}
				break;
			case 98 :
				// QueryLexer.g:1:690: DOLLARVAR
				{
				mDOLLARVAR(); if (state.failed) return;

				}
				break;
			case 99 :
				// QueryLexer.g:1:700: DOUBLENUMBER
				{
				mDOUBLENUMBER(); if (state.failed) return;

				}
				break;
			case 100 :
				// QueryLexer.g:1:713: BIGDECIMALNUMBER
				{
				mBIGDECIMALNUMBER(); if (state.failed) return;

				}
				break;
			case 101 :
				// QueryLexer.g:1:730: BIGINTEGERNUMBER
				{
				mBIGINTEGERNUMBER(); if (state.failed) return;

				}
				break;
			case 102 :
				// QueryLexer.g:1:747: FLOATNUMBER
				{
				mFLOATNUMBER(); if (state.failed) return;

				}
				break;
			case 103 :
				// QueryLexer.g:1:759: QUOTEDSTRING
				{
				mQUOTEDSTRING(); if (state.failed) return;

				}
				break;
			case 104 :
				// QueryLexer.g:1:772: MULTILINE_QUOTEDSTRING
				{
				mMULTILINE_QUOTEDSTRING(); if (state.failed) return;

				}
				break;
			case 105 :
				// QueryLexer.g:1:795: EXECCOMMAND
				{
				mEXECCOMMAND(); if (state.failed) return;

				}
				break;
			case 106 :
				// QueryLexer.g:1:807: STAR
				{
				mSTAR(); if (state.failed) return;

				}
				break;
			case 107 :
				// QueryLexer.g:1:812: COLON
				{
				mCOLON(); if (state.failed) return;

				}
				break;
			case 108 :
				// QueryLexer.g:1:818: DOLLAR
				{
				mDOLLAR(); if (state.failed) return;

				}
				break;
			case 109 :
				// QueryLexer.g:1:825: WS
				{
				mWS(); if (state.failed) return;

				}
				break;
			case 110 :
				// QueryLexer.g:1:828: SL_COMMENT
				{
				mSL_COMMENT(); if (state.failed) return;

				}
				break;
			case 111 :
				// QueryLexer.g:1:839: ML_COMMENT
				{
				mML_COMMENT(); if (state.failed) return;

				}
				break;
			case 112 :
				// QueryLexer.g:1:850: SEMI_COLON
				{
				mSEMI_COLON(); if (state.failed) return;

				}
				break;
			case 113 :
				// QueryLexer.g:1:861: LEFT_PAREN
				{
				mLEFT_PAREN(); if (state.failed) return;

				}
				break;
			case 114 :
				// QueryLexer.g:1:872: RIGHT_PAREN
				{
				mRIGHT_PAREN(); if (state.failed) return;

				}
				break;
			case 115 :
				// QueryLexer.g:1:884: LEFT_CURLY
				{
				mLEFT_CURLY(); if (state.failed) return;

				}
				break;
			case 116 :
				// QueryLexer.g:1:895: RIGHT_CURLY
				{
				mRIGHT_CURLY(); if (state.failed) return;

				}
				break;
			case 117 :
				// QueryLexer.g:1:907: LEFT_BRACKET
				{
				mLEFT_BRACKET(); if (state.failed) return;

				}
				break;
			case 118 :
				// QueryLexer.g:1:920: RIGHT_BRACKET
				{
				mRIGHT_BRACKET(); if (state.failed) return;

				}
				break;
			case 119 :
				// QueryLexer.g:1:934: POUND
				{
				mPOUND(); if (state.failed) return;

				}
				break;
			case 120 :
				// QueryLexer.g:1:940: EQUAL
				{
				mEQUAL(); if (state.failed) return;

				}
				break;
			case 121 :
				// QueryLexer.g:1:946: COMMA
				{
				mCOMMA(); if (state.failed) return;

				}
				break;
			case 122 :
				// QueryLexer.g:1:952: PERIOD
				{
				mPERIOD(); if (state.failed) return;

				}
				break;
			case 123 :
				// QueryLexer.g:1:959: DOUBLE_PERIOD
				{
				mDOUBLE_PERIOD(); if (state.failed) return;

				}
				break;
			case 124 :
				// QueryLexer.g:1:973: DIV
				{
				mDIV(); if (state.failed) return;

				}
				break;
			case 125 :
				// QueryLexer.g:1:977: PERCENT
				{
				mPERCENT(); if (state.failed) return;

				}
				break;
			case 126 :
				// QueryLexer.g:1:985: PLUS
				{
				mPLUS(); if (state.failed) return;

				}
				break;
			case 127 :
				// QueryLexer.g:1:990: MINUS
				{
				mMINUS(); if (state.failed) return;

				}
				break;
			case 128 :
				// QueryLexer.g:1:996: QMARK
				{
				mQMARK(); if (state.failed) return;

				}
				break;
			case 129 :
				// QueryLexer.g:1:1002: ARROBA
				{
				mARROBA(); if (state.failed) return;

				}
				break;
			case 130 :
				// QueryLexer.g:1:1009: AMPERSAND
				{
				mAMPERSAND(); if (state.failed) return;

				}
				break;
			case 131 :
				// QueryLexer.g:1:1019: FAT_ARROW
				{
				mFAT_ARROW(); if (state.failed) return;

				}
				break;

		}
	}

	// $ANTLR start synpred1_QueryLexer
	public final void synpred1_QueryLexer_fragment() throws RecognitionException {
		// QueryLexer.g:359:9: ( ID DCOLON )
		// QueryLexer.g:359:11: ID DCOLON
		{
		mID(); if (state.failed) return;

		mDCOLON(); if (state.failed) return;

		}

	}
	// $ANTLR end synpred1_QueryLexer

	public final boolean synpred1_QueryLexer() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_QueryLexer_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}


	protected DFA3 dfa3 = new DFA3(this);
	protected DFA14 dfa14 = new DFA14(this);
	static final String DFA3_eotS =
		"\1\uffff\1\2\1\uffff\1\2\1\uffff";
	static final String DFA3_eofS =
		"\5\uffff";
	static final String DFA3_minS =
		"\1\101\1\60\1\uffff\1\60\1\uffff";
	static final String DFA3_maxS =
		"\1\132\1\137\1\uffff\1\137\1\uffff";
	static final String DFA3_acceptS =
		"\2\uffff\1\2\1\uffff\1\1";
	static final String DFA3_specialS =
		"\1\uffff\1\0\1\uffff\1\1\1\uffff}>";
	static final String[] DFA3_transitionS = {
			"\32\1",
			"\12\3\1\4\6\uffff\32\3\4\uffff\1\3",
			"",
			"\12\3\1\4\6\uffff\32\3\4\uffff\1\3",
			""
	};

	static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
	static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
	static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
	static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
	static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
	static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
	static final short[][] DFA3_transition;

	static {
		int numStates = DFA3_transitionS.length;
		DFA3_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
		}
	}

	protected class DFA3 extends DFA {

		public DFA3(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 3;
			this.eot = DFA3_eot;
			this.eof = DFA3_eof;
			this.min = DFA3_min;
			this.max = DFA3_max;
			this.accept = DFA3_accept;
			this.special = DFA3_special;
			this.transition = DFA3_transition;
		}
		@Override
		public String getDescription() {
			return "354:1: IDENTIFIER : ( ( ID DCOLON )=> ( ID DCOLON IDENTIFIER ) | ID );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA3_1 = input.LA(1);
						 
						int index3_1 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA3_1 >= '0' && LA3_1 <= '9')||(LA3_1 >= 'A' && LA3_1 <= 'Z')||LA3_1=='_') ) {s = 3;}
						else if ( (LA3_1==':') && (synpred1_QueryLexer())) {s = 4;}
						else s = 2;
						 
						input.seek(index3_1);
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA3_3 = input.LA(1);
						 
						int index3_3 = input.index();
						input.rewind();
						s = -1;
						if ( (LA3_3==':') && (synpred1_QueryLexer())) {s = 4;}
						else if ( ((LA3_3 >= '0' && LA3_3 <= '9')||(LA3_3 >= 'A' && LA3_3 <= 'Z')||LA3_3=='_') ) {s = 3;}
						else s = 2;
						 
						input.seek(index3_3);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 3, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	static final String DFA14_eotS =
		"\1\uffff\24\32\1\161\1\163\1\165\1\uffff\1\167\1\uffff\1\170\1\176\1\u0081"+
		"\4\uffff\1\u0088\1\u008a\16\uffff\6\32\1\u0095\1\u0096\1\u0097\13\32\1"+
		"\u00a8\5\32\1\u00b0\20\32\1\u00c6\1\32\1\u00c9\6\32\1\u00d1\7\32\1\u00db"+
		"\23\uffff\1\u00e1\10\uffff\2\32\1\u00e7\1\32\1\u00e9\2\32\1\u00ed\2\32"+
		"\3\uffff\17\32\1\u00ff\1\uffff\7\32\1\uffff\22\32\1\u011c\1\u011d\1\32"+
		"\1\uffff\1\u011f\1\32\1\uffff\2\32\1\u0124\3\32\1\u0129\1\uffff\4\32\1"+
		"\u012f\3\32\1\u0133\1\uffff\1\u00e1\1\uffff\1\u00e1\6\uffff\1\u0135\1"+
		"\u0136\1\uffff\1\32\1\uffff\2\32\1\u013a\1\uffff\4\32\1\u013f\4\32\1\u0144"+
		"\3\32\1\u0148\1\u0149\1\32\1\u014b\1\uffff\4\32\1\u0150\6\32\1\u0157\4"+
		"\32\1\u015c\1\u015d\10\32\1\u0166\1\32\2\uffff\1\32\1\uffff\4\32\1\uffff"+
		"\4\32\1\uffff\2\32\1\u0173\1\u0174\1\32\1\uffff\1\32\1\u0177\1\u0178\4"+
		"\uffff\3\32\1\uffff\1\u017d\1\u017e\2\32\1\uffff\1\32\1\u0182\1\32\1\u0184"+
		"\1\uffff\3\32\2\uffff\1\u0188\1\uffff\3\32\1\u018c\1\uffff\1\u018d\1\u018e"+
		"\1\32\1\u0190\2\32\1\uffff\1\32\1\u0194\1\32\1\u0196\2\uffff\1\u0197\1"+
		"\u0198\1\u0199\1\32\1\u019b\1\32\1\u019d\1\32\1\uffff\10\32\1\u01a7\1"+
		"\32\1\u01a9\1\32\2\uffff\2\32\3\uffff\1\u01ae\1\u01af\1\u01b0\2\uffff"+
		"\2\32\1\u01b3\1\uffff\1\u01b4\1\uffff\1\32\1\u01b6\1\32\1\uffff\1\u01b8"+
		"\2\32\3\uffff\1\32\1\uffff\1\u01bc\2\32\1\uffff\1\32\4\uffff\1\u01c0\1"+
		"\uffff\1\u01c1\1\uffff\1\u01c2\1\u01c3\1\u01c4\6\32\1\uffff\1\32\1\uffff"+
		"\3\32\4\uffff\1\32\1\u01d1\2\uffff\1\32\1\uffff\1\32\1\uffff\1\u01d4\1"+
		"\u01d5\1\32\1\uffff\1\32\1\u01d8\1\32\5\uffff\1\32\1\u01db\5\32\1\u01e1"+
		"\1\32\1\u01e3\1\uffff\1\u01e4\1\uffff\1\u01e5\1\u01e6\2\uffff\1\32\1\u01e8"+
		"\1\uffff\2\32\1\uffff\2\32\1\u01ed\1\32\1\u01ef\1\uffff\1\32\4\uffff\1"+
		"\u01f1\1\uffff\1\u01f2\1\u01f3\2\32\1\uffff\1\u01f6\1\uffff\1\u01ae\3"+
		"\uffff\1\u01f7\1\u01f8\3\uffff";
	static final String DFA14_eofS =
		"\u01f9\uffff";
	static final String DFA14_minS =
		"\1\11\1\117\1\101\1\106\2\101\1\105\1\101\1\116\1\101\1\117\1\116\1\101"+
		"\1\114\2\101\1\105\1\110\1\101\1\110\1\114\3\75\1\uffff\1\72\1\uffff\1"+
		"\56\1\60\1\56\1\0\3\uffff\1\55\1\52\16\uffff\1\111\1\114\2\124\1\121\1"+
		"\120\3\60\1\107\1\116\1\114\1\107\1\106\1\123\1\125\1\124\1\101\1\115"+
		"\1\106\1\60\1\114\1\122\1\101\2\114\1\60\1\110\1\124\1\123\1\102\1\107"+
		"\1\117\1\101\1\103\3\111\1\114\1\104\1\111\1\115\1\114\1\60\1\104\1\60"+
		"\1\117\2\107\1\122\1\117\1\116\1\60\1\120\1\105\1\125\1\120\1\105\1\123"+
		"\1\104\1\60\13\uffff\1\60\1\53\1\104\5\uffff\1\60\1\0\1\47\6\uffff\1\104"+
		"\1\114\1\60\1\111\1\60\2\117\1\60\1\105\1\125\3\uffff\1\111\1\125\1\113"+
		"\1\114\1\110\1\111\1\123\1\103\1\124\1\102\1\105\1\104\1\107\1\111\1\124"+
		"\1\60\1\uffff\1\124\1\105\1\124\1\101\1\114\1\123\1\105\1\uffff\2\105"+
		"\1\103\1\105\1\122\1\123\1\122\1\110\1\105\1\116\1\117\1\116\1\111\1\105"+
		"\1\122\1\105\2\120\2\60\1\105\1\uffff\1\60\1\105\1\uffff\1\114\1\104\1"+
		"\60\1\101\1\125\1\105\1\60\1\uffff\1\114\1\117\1\116\1\105\1\60\1\103"+
		"\1\116\1\105\1\60\1\uffff\3\60\3\uffff\1\0\1\60\1\uffff\2\60\1\uffff\1"+
		"\126\1\uffff\1\122\1\113\1\60\1\uffff\1\122\1\124\1\123\1\122\1\60\1\125"+
		"\1\124\1\116\1\105\1\60\1\111\1\114\1\124\2\60\1\124\1\60\1\uffff\1\105"+
		"\1\101\2\124\1\60\1\105\3\122\1\125\1\110\1\60\1\117\1\123\1\101\1\105"+
		"\2\60\1\116\1\107\1\124\1\101\1\105\1\122\1\116\1\125\1\60\1\114\2\uffff"+
		"\1\122\1\uffff\1\101\2\105\1\116\1\uffff\1\114\1\111\1\120\1\122\1\uffff"+
		"\1\105\1\125\2\60\1\105\1\uffff\1\110\2\60\1\uffff\1\60\2\uffff\1\105"+
		"\1\124\1\105\1\uffff\2\60\1\124\1\116\1\uffff\1\120\1\60\1\105\1\60\1"+
		"\uffff\1\116\1\105\1\111\2\uffff\1\60\1\uffff\1\122\1\103\1\105\1\60\1"+
		"\uffff\2\60\1\127\1\60\1\124\1\105\1\uffff\1\125\1\60\1\122\1\60\2\uffff"+
		"\3\60\1\115\1\60\1\122\1\60\1\124\1\uffff\1\105\1\124\1\122\1\101\1\103"+
		"\1\124\1\114\1\124\1\60\1\101\1\60\1\107\2\uffff\1\104\1\105\2\uffff\4"+
		"\60\2\uffff\1\105\1\123\1\60\1\uffff\1\60\1\uffff\1\103\1\60\1\115\1\uffff"+
		"\1\60\1\110\1\116\3\uffff\1\111\1\uffff\1\60\1\115\1\120\1\uffff\1\122"+
		"\4\uffff\1\60\1\uffff\1\60\1\uffff\3\60\1\122\1\116\1\111\2\105\1\111"+
		"\1\uffff\1\124\1\uffff\1\110\1\125\1\123\1\60\3\uffff\1\122\1\60\2\uffff"+
		"\1\124\1\uffff\1\105\1\uffff\2\60\1\123\1\uffff\1\101\1\60\1\101\5\uffff"+
		"\1\101\1\60\1\115\1\107\1\114\1\117\1\105\1\60\1\103\1\60\1\0\1\60\1\uffff"+
		"\2\60\2\uffff\1\105\1\60\1\uffff\2\131\1\uffff\1\101\1\105\1\60\1\116"+
		"\1\60\1\uffff\1\105\4\uffff\1\60\1\uffff\2\60\1\114\1\122\1\uffff\1\60"+
		"\1\uffff\1\60\3\uffff\2\60\3\uffff";
	static final String DFA14_maxS =
		"\1\175\1\117\1\125\1\123\2\117\1\124\3\125\1\117\1\123\1\124\1\123\1\131"+
		"\1\101\1\124\1\125\1\101\1\110\1\121\1\76\2\75\1\uffff\1\72\1\uffff\1"+
		"\114\2\71\1\uffff\3\uffff\1\55\1\52\16\uffff\1\111\1\114\2\124\1\121\1"+
		"\120\3\137\1\124\1\116\1\114\1\107\2\123\1\125\1\124\1\116\1\115\1\106"+
		"\1\137\1\114\1\122\1\117\2\114\1\137\1\110\1\124\1\123\1\102\1\107\1\117"+
		"\1\101\1\123\3\111\1\114\1\122\1\111\1\115\1\114\1\137\1\104\1\137\1\117"+
		"\2\107\1\122\1\117\1\116\1\137\1\120\1\122\1\125\1\124\1\105\1\123\1\104"+
		"\1\137\13\uffff\2\71\1\111\5\uffff\1\106\1\uffff\1\162\6\uffff\1\104\1"+
		"\114\1\137\1\111\1\137\2\117\1\137\1\105\1\125\3\uffff\1\111\1\125\1\113"+
		"\1\114\1\110\1\111\1\123\1\103\1\124\1\102\1\105\1\104\1\107\1\111\1\124"+
		"\1\137\1\uffff\1\124\1\105\1\124\1\101\1\114\1\123\1\105\1\uffff\1\105"+
		"\1\120\1\103\1\105\1\122\1\123\1\122\1\110\1\105\1\116\1\117\1\116\1\111"+
		"\1\105\1\122\1\117\2\120\2\137\1\105\1\uffff\1\137\1\105\1\uffff\1\114"+
		"\1\111\1\137\1\124\1\125\1\105\1\137\1\uffff\1\114\1\117\1\116\1\105\1"+
		"\137\1\103\1\116\1\105\1\137\1\uffff\1\106\1\71\1\106\3\uffff\1\uffff"+
		"\1\106\1\uffff\2\137\1\uffff\1\126\1\uffff\1\122\1\113\1\137\1\uffff\1"+
		"\122\1\124\1\123\1\122\1\137\1\125\1\124\1\116\1\105\1\137\1\111\1\114"+
		"\1\124\2\137\1\124\1\137\1\uffff\1\105\1\101\2\124\1\137\1\105\3\122\1"+
		"\125\1\110\1\137\1\117\1\123\1\101\1\105\2\137\1\116\1\107\1\124\1\101"+
		"\1\105\1\122\1\116\1\125\1\137\1\114\2\uffff\1\122\1\uffff\1\101\2\105"+
		"\1\116\1\uffff\1\114\1\111\1\120\1\122\1\uffff\1\105\1\125\2\137\1\105"+
		"\1\uffff\1\110\2\137\1\uffff\1\106\2\uffff\1\105\1\124\1\105\1\uffff\2"+
		"\137\1\124\1\116\1\uffff\1\120\1\137\1\105\1\137\1\uffff\1\116\1\105\1"+
		"\111\2\uffff\1\137\1\uffff\1\122\1\103\1\105\1\137\1\uffff\2\137\1\127"+
		"\1\137\1\124\1\105\1\uffff\1\125\1\137\1\122\1\137\2\uffff\3\137\1\115"+
		"\1\137\1\122\1\137\1\124\1\uffff\1\105\1\124\1\122\1\101\1\103\1\124\1"+
		"\114\1\124\1\137\1\101\1\137\1\107\2\uffff\1\104\1\105\2\uffff\1\106\3"+
		"\137\2\uffff\1\105\1\123\1\137\1\uffff\1\137\1\uffff\1\103\1\137\1\115"+
		"\1\uffff\1\137\1\110\1\116\3\uffff\1\111\1\uffff\1\137\1\115\1\120\1\uffff"+
		"\1\122\4\uffff\1\137\1\uffff\1\137\1\uffff\3\137\1\122\1\116\1\111\2\105"+
		"\1\111\1\uffff\1\124\1\uffff\1\110\1\125\1\123\1\106\3\uffff\1\122\1\137"+
		"\2\uffff\1\124\1\uffff\1\105\1\uffff\2\137\1\123\1\uffff\1\101\1\137\1"+
		"\101\5\uffff\1\101\1\137\1\115\1\107\1\114\1\117\1\105\1\137\1\103\1\137"+
		"\1\uffff\1\137\1\uffff\2\137\2\uffff\1\105\1\137\1\uffff\2\131\1\uffff"+
		"\1\101\1\105\1\137\1\116\1\137\1\uffff\1\105\4\uffff\1\137\1\uffff\2\137"+
		"\1\114\1\122\1\uffff\1\137\1\uffff\1\137\3\uffff\2\137\3\uffff";
	static final String DFA14_acceptS =
		"\30\uffff\1\135\1\uffff\1\137\4\uffff\1\151\1\152\1\155\2\uffff\1\160"+
		"\1\161\1\162\1\163\1\164\1\165\1\166\1\167\1\171\1\175\1\176\1\u0080\1"+
		"\u0081\1\u0082\75\uffff\1\130\1\u0083\1\170\1\132\1\131\1\134\1\133\1"+
		"\136\1\153\1\140\1\141\3\uffff\1\146\1\154\1\142\1\173\1\172\3\uffff\1"+
		"\147\1\150\1\156\1\177\1\157\1\174\12\uffff\1\125\1\27\1\67\20\uffff\1"+
		"\120\7\uffff\1\44\25\uffff\1\32\2\uffff\1\33\7\uffff\1\117\11\uffff\1"+
		"\116\3\uffff\1\144\1\145\1\143\2\uffff\1\147\2\uffff\1\45\1\uffff\1\123"+
		"\3\uffff\1\53\21\uffff\1\122\34\uffff\1\31\1\50\1\uffff\1\43\4\uffff\1"+
		"\64\4\uffff\1\121\5\uffff\1\66\3\uffff\1\115\1\uffff\1\1\1\2\3\uffff\1"+
		"\26\4\uffff\1\13\4\uffff\1\51\3\uffff\1\7\1\54\1\uffff\1\106\4\uffff\1"+
		"\110\6\uffff\1\15\4\uffff\1\111\1\22\10\uffff\1\75\14\uffff\1\113\1\126"+
		"\2\uffff\1\112\1\114\4\uffff\1\35\1\77\3\uffff\1\107\1\uffff\1\14\3\uffff"+
		"\1\104\3\uffff\1\55\1\127\1\12\1\uffff\1\36\3\uffff\1\23\1\uffff\1\76"+
		"\1\24\1\34\1\25\1\uffff\1\72\1\uffff\1\102\11\uffff\1\42\1\uffff\1\65"+
		"\4\uffff\1\74\1\3\1\17\2\uffff\1\16\1\6\1\uffff\1\60\1\uffff\1\10\3\uffff"+
		"\1\100\3\uffff\1\70\1\101\1\103\1\105\1\73\14\uffff\1\5\2\uffff\1\11\1"+
		"\47\2\uffff\1\21\2\uffff\1\52\5\uffff\1\71\1\uffff\1\124\1\4\1\20\1\61"+
		"\1\uffff\1\37\4\uffff\1\40\1\uffff\1\46\1\uffff\1\30\1\62\1\63\2\uffff"+
		"\1\41\1\56\1\57";
	static final String DFA14_specialS =
		"\36\uffff\1\3\144\uffff\1\0\136\uffff\1\1\u00ec\uffff\1\2\51\uffff}>";
	static final String[] DFA14_transitionS = {
			"\2\41\1\uffff\2\41\22\uffff\1\41\1\30\1\uffff\1\53\1\34\1\55\1\61\1\36"+
			"\1\45\1\46\1\40\1\56\1\54\1\42\1\35\1\43\12\33\1\31\1\44\1\26\1\25\1"+
			"\27\1\57\1\60\1\15\1\16\1\11\1\5\1\24\1\7\1\20\1\32\1\3\1\12\1\32\1\6"+
			"\1\22\1\2\1\10\1\17\1\32\1\4\1\14\1\21\1\13\1\1\1\23\3\32\1\51\1\uffff"+
			"\1\52\2\uffff\1\37\32\uffff\1\47\1\uffff\1\50",
			"\1\62",
			"\1\65\3\uffff\1\66\11\uffff\1\64\5\uffff\1\63",
			"\1\71\6\uffff\1\67\1\70\4\uffff\1\72",
			"\1\74\3\uffff\1\73\3\uffff\1\76\5\uffff\1\75",
			"\1\102\3\uffff\1\77\3\uffff\1\100\5\uffff\1\101",
			"\1\105\3\uffff\1\104\5\uffff\1\103\4\uffff\1\106",
			"\1\113\7\uffff\1\107\2\uffff\1\111\2\uffff\1\110\5\uffff\1\112",
			"\1\117\3\uffff\1\114\1\uffff\1\115\1\116",
			"\1\124\6\uffff\1\123\6\uffff\1\121\2\uffff\1\122\2\uffff\1\120",
			"\1\125",
			"\1\126\4\uffff\1\127",
			"\1\133\6\uffff\1\132\7\uffff\1\130\3\uffff\1\131",
			"\1\134\1\uffff\1\136\4\uffff\1\135",
			"\1\142\7\uffff\1\141\5\uffff\1\140\11\uffff\1\137",
			"\1\143",
			"\1\145\14\uffff\1\144\1\uffff\1\146",
			"\1\150\11\uffff\1\151\2\uffff\1\147",
			"\1\152",
			"\1\153",
			"\1\154\1\uffff\1\155\2\uffff\1\156",
			"\1\157\1\160",
			"\1\162",
			"\1\164",
			"",
			"\1\166",
			"",
			"\1\172\1\uffff\12\33\10\uffff\1\174\2\uffff\1\173\1\175\5\uffff\1\171",
			"\12\177",
			"\1\u0080\1\uffff\12\u0082",
			"\12\u0083\1\u0086\2\u0083\1\u0086\31\u0083\1\u0085\64\u0083\1\u0084"+
			"\uffa3\u0083",
			"",
			"",
			"",
			"\1\u0087",
			"\1\u0089",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\u008b",
			"\1\u008c",
			"\1\u008d",
			"\1\u008e",
			"\1\u008f",
			"\1\u0090",
			"\13\32\6\uffff\15\32\1\u0093\1\32\1\u0094\3\32\1\u0092\1\32\1\u0091"+
			"\4\32\4\uffff\1\32",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\1\u0098\14\uffff\1\u0099",
			"\1\u009a",
			"\1\u009b",
			"\1\u009c",
			"\1\u009d\7\uffff\1\u009e\4\uffff\1\u009f",
			"\1\u00a0",
			"\1\u00a1",
			"\1\u00a2",
			"\1\u00a3\14\uffff\1\u00a4",
			"\1\u00a5",
			"\1\u00a6",
			"\13\32\6\uffff\4\32\1\u00a7\25\32\4\uffff\1\32",
			"\1\u00a9",
			"\1\u00aa",
			"\1\u00ab\15\uffff\1\u00ac",
			"\1\u00ad",
			"\1\u00ae",
			"\13\32\6\uffff\3\32\1\u00af\26\32\4\uffff\1\32",
			"\1\u00b1",
			"\1\u00b2",
			"\1\u00b3",
			"\1\u00b4",
			"\1\u00b5",
			"\1\u00b6",
			"\1\u00b7",
			"\1\u00b8\17\uffff\1\u00b9",
			"\1\u00ba",
			"\1\u00bb",
			"\1\u00bc",
			"\1\u00bd",
			"\1\u00c0\12\uffff\1\u00bf\2\uffff\1\u00be",
			"\1\u00c1",
			"\1\u00c2",
			"\1\u00c3",
			"\13\32\6\uffff\2\32\1\u00c4\17\32\1\u00c5\7\32\4\uffff\1\32",
			"\1\u00c7",
			"\13\32\6\uffff\23\32\1\u00c8\6\32\4\uffff\1\32",
			"\1\u00ca",
			"\1\u00cb",
			"\1\u00cc",
			"\1\u00cd",
			"\1\u00ce",
			"\1\u00cf",
			"\13\32\6\uffff\4\32\1\u00d0\25\32\4\uffff\1\32",
			"\1\u00d2",
			"\1\u00d4\14\uffff\1\u00d3",
			"\1\u00d5",
			"\1\u00d6\3\uffff\1\u00d7",
			"\1\u00d8",
			"\1\u00d9",
			"\1\u00da",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\12\u00dc",
			"\1\u00dd\1\uffff\1\u00dd\2\uffff\12\u00de",
			"\1\u00df\4\uffff\1\u00e0",
			"",
			"",
			"",
			"",
			"",
			"\12\u0082\10\uffff\1\u00df\2\uffff\1\173\1\175",
			"\12\u0083\1\u0086\2\u0083\1\u0086\31\u0083\1\u0085\64\u0083\1\u0084"+
			"\uffa3\u0083",
			"\1\u00e2\32\uffff\1\u00e2\3\uffff\1\u00e2\7\uffff\1\u00e2\3\uffff\1"+
			"\u00e2\1\uffff\1\u00e2\1\u00e3\6\uffff\1\u00e2\21\uffff\1\u0086\3\uffff"+
			"\1\u0086",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\u00e5",
			"\1\u00e6",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\1\u00e8",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\1\u00ea",
			"\1\u00eb",
			"\13\32\6\uffff\16\32\1\u00ec\13\32\4\uffff\1\32",
			"\1\u00ee",
			"\1\u00ef",
			"",
			"",
			"",
			"\1\u00f0",
			"\1\u00f1",
			"\1\u00f2",
			"\1\u00f3",
			"\1\u00f4",
			"\1\u00f5",
			"\1\u00f6",
			"\1\u00f7",
			"\1\u00f8",
			"\1\u00f9",
			"\1\u00fa",
			"\1\u00fb",
			"\1\u00fc",
			"\1\u00fd",
			"\1\u00fe",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"",
			"\1\u0100",
			"\1\u0101",
			"\1\u0102",
			"\1\u0103",
			"\1\u0104",
			"\1\u0105",
			"\1\u0106",
			"",
			"\1\u0107",
			"\1\u0108\12\uffff\1\u0109",
			"\1\u010a",
			"\1\u010b",
			"\1\u010c",
			"\1\u010d",
			"\1\u010e",
			"\1\u010f",
			"\1\u0110",
			"\1\u0111",
			"\1\u0112",
			"\1\u0113",
			"\1\u0114",
			"\1\u0115",
			"\1\u0116",
			"\1\u0117\3\uffff\1\u0118\5\uffff\1\u0119",
			"\1\u011a",
			"\1\u011b",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\1\u011e",
			"",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\1\u0120",
			"",
			"\1\u0121",
			"\1\u0122\4\uffff\1\u0123",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\1\u0125\22\uffff\1\u0126",
			"\1\u0127",
			"\1\u0128",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"",
			"\1\u012a",
			"\1\u012b",
			"\1\u012c",
			"\1\u012d",
			"\13\32\6\uffff\21\32\1\u012e\10\32\4\uffff\1\32",
			"\1\u0130",
			"\1\u0131",
			"\1\u0132",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"",
			"\12\u00dc\10\uffff\1\u00df\2\uffff\1\173\1\175",
			"\12\u00de",
			"\12\u00de\10\uffff\1\u00df\3\uffff\1\175",
			"",
			"",
			"",
			"\12\u0083\1\u0086\2\u0083\1\u0086\31\u0083\1\u0085\64\u0083\1\u0084"+
			"\uffa3\u0083",
			"\12\u0134\7\uffff\6\u0134",
			"",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"",
			"\1\u0137",
			"",
			"\1\u0138",
			"\1\u0139",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"",
			"\1\u013b",
			"\1\u013c",
			"\1\u013d",
			"\1\u013e",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\1\u0140",
			"\1\u0141",
			"\1\u0142",
			"\1\u0143",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\1\u0145",
			"\1\u0146",
			"\1\u0147",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\1\u014a",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"",
			"\1\u014c",
			"\1\u014d",
			"\1\u014e",
			"\1\u014f",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\1\u0151",
			"\1\u0152",
			"\1\u0153",
			"\1\u0154",
			"\1\u0155",
			"\1\u0156",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\1\u0158",
			"\1\u0159",
			"\1\u015a",
			"\1\u015b",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\1\u015e",
			"\1\u015f",
			"\1\u0160",
			"\1\u0161",
			"\1\u0162",
			"\1\u0163",
			"\1\u0164",
			"\1\u0165",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\1\u0167",
			"",
			"",
			"\1\u0168",
			"",
			"\1\u0169",
			"\1\u016a",
			"\1\u016b",
			"\1\u016c",
			"",
			"\1\u016d",
			"\1\u016e",
			"\1\u016f",
			"\1\u0170",
			"",
			"\1\u0171",
			"\1\u0172",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\1\u0175",
			"",
			"\1\u0176",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"",
			"\12\u0179\7\uffff\6\u0179",
			"",
			"",
			"\1\u017a",
			"\1\u017b",
			"\1\u017c",
			"",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\1\u017f",
			"\1\u0180",
			"",
			"\1\u0181",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\1\u0183",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"",
			"\1\u0185",
			"\1\u0186",
			"\1\u0187",
			"",
			"",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"",
			"\1\u0189",
			"\1\u018a",
			"\1\u018b",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\1\u018f",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\1\u0191",
			"\1\u0192",
			"",
			"\1\u0193",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\1\u0195",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"",
			"",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\1\u019a",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\1\u019c",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\1\u019e",
			"",
			"\1\u019f",
			"\1\u01a0",
			"\1\u01a1",
			"\1\u01a2",
			"\1\u01a3",
			"\1\u01a4",
			"\1\u01a5",
			"\1\u01a6",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\1\u01a8",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\1\u01aa",
			"",
			"",
			"\1\u01ab",
			"\1\u01ac",
			"",
			"",
			"\12\u01ad\7\uffff\6\u01ad",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"",
			"",
			"\1\u01b1",
			"\1\u01b2",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"",
			"\1\u01b5",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\1\u01b7",
			"",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\1\u01b9",
			"\1\u01ba",
			"",
			"",
			"",
			"\1\u01bb",
			"",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\1\u01bd",
			"\1\u01be",
			"",
			"\1\u01bf",
			"",
			"",
			"",
			"",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\1\u01c5",
			"\1\u01c6",
			"\1\u01c7",
			"\1\u01c8",
			"\1\u01c9",
			"\1\u01ca",
			"",
			"\1\u01cb",
			"",
			"\1\u01cc",
			"\1\u01cd",
			"\1\u01ce",
			"\12\u01cf\7\uffff\6\u01cf",
			"",
			"",
			"",
			"\1\u01d0",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"",
			"",
			"\1\u01d2",
			"",
			"\1\u01d3",
			"",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\1\u01d6",
			"",
			"\1\u01d7",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\1\u01d9",
			"",
			"",
			"",
			"",
			"",
			"\1\u01da",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\1\u01dc",
			"\1\u01dd",
			"\1\u01de",
			"\1\u01df",
			"\1\u01e0",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\1\u01e2",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\12\u0083\1\u0086\2\u0083\1\u0086\31\u0083\1\u0085\64\u0083\1\u0084"+
			"\uffa3\u0083",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"",
			"",
			"\1\u01e7",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"",
			"\1\u01e9",
			"\1\u01ea",
			"",
			"\1\u01eb",
			"\1\u01ec",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\1\u01ee",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"",
			"\1\u01f0",
			"",
			"",
			"",
			"",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\1\u01f4",
			"\1\u01f5",
			"",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"",
			"",
			"",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"\13\32\6\uffff\32\32\4\uffff\1\32",
			"",
			"",
			""
	};

	static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
	static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
	static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
	static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
	static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
	static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
	static final short[][] DFA14_transition;

	static {
		int numStates = DFA14_transitionS.length;
		DFA14_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
		}
	}

	protected class DFA14 extends DFA {

		public DFA14(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 14;
			this.eot = DFA14_eot;
			this.eof = DFA14_eof;
			this.min = DFA14_min;
			this.max = DFA14_max;
			this.accept = DFA14_accept;
			this.special = DFA14_special;
			this.transition = DFA14_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( VOID | NULL | IMPORT | REGISTER | RETURNS | DEFINE | LOAD | FILTER | FOREACH | ORDER | RANK | DENSE | CUBE | ROLLUP | INVOKE | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | OTHERWISE | ALL | AS | BY | USING | INNER | OUTER | ONSCHEMA | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | BIGDECIMAL | BIGINTEGER | DOUBLE | DATETIME | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | STREAM | THROUGH | STORE | ASSERT | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | CASE | WHEN | THEN | ELSE | END | STR_OP_EQ | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_NE | STR_OP_MATCHES | IN | TRUE | FALSE | NUM_OP_EQ | NUM_OP_LT | NUM_OP_LTE | NUM_OP_GT | NUM_OP_GTE | NUM_OP_NE | DCOLON | IDENTIFIER | INTEGER | LONGINTEGER | DOLLARVAR | DOUBLENUMBER | BIGDECIMALNUMBER | BIGINTEGERNUMBER | FLOATNUMBER | QUOTEDSTRING | MULTILINE_QUOTEDSTRING | EXECCOMMAND | STAR | COLON | DOLLAR | WS | SL_COMMENT | ML_COMMENT | SEMI_COLON | LEFT_PAREN | RIGHT_PAREN | LEFT_CURLY | RIGHT_CURLY | LEFT_BRACKET | RIGHT_BRACKET | POUND | EQUAL | COMMA | PERIOD | DOUBLE_PERIOD | DIV | PERCENT | PLUS | MINUS | QMARK | ARROBA | AMPERSAND | FAT_ARROW );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA14_131 = input.LA(1);
						s = -1;
						if ( (LA14_131=='\'') ) {s = 133;}
						else if ( ((LA14_131 >= '\u0000' && LA14_131 <= '\t')||(LA14_131 >= '\u000B' && LA14_131 <= '\f')||(LA14_131 >= '\u000E' && LA14_131 <= '&')||(LA14_131 >= '(' && LA14_131 <= '[')||(LA14_131 >= ']' && LA14_131 <= '\uFFFF')) ) {s = 131;}
						else if ( (LA14_131=='\\') ) {s = 132;}
						else if ( (LA14_131=='\n'||LA14_131=='\r') ) {s = 134;}
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA14_226 = input.LA(1);
						s = -1;
						if ( (LA14_226=='\'') ) {s = 133;}
						else if ( ((LA14_226 >= '\u0000' && LA14_226 <= '\t')||(LA14_226 >= '\u000B' && LA14_226 <= '\f')||(LA14_226 >= '\u000E' && LA14_226 <= '&')||(LA14_226 >= '(' && LA14_226 <= '[')||(LA14_226 >= ']' && LA14_226 <= '\uFFFF')) ) {s = 131;}
						else if ( (LA14_226=='\\') ) {s = 132;}
						else if ( (LA14_226=='\n'||LA14_226=='\r') ) {s = 134;}
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA14_463 = input.LA(1);
						s = -1;
						if ( (LA14_463=='\'') ) {s = 133;}
						else if ( ((LA14_463 >= '\u0000' && LA14_463 <= '\t')||(LA14_463 >= '\u000B' && LA14_463 <= '\f')||(LA14_463 >= '\u000E' && LA14_463 <= '&')||(LA14_463 >= '(' && LA14_463 <= '[')||(LA14_463 >= ']' && LA14_463 <= '\uFFFF')) ) {s = 131;}
						else if ( (LA14_463=='\\') ) {s = 132;}
						else if ( (LA14_463=='\n'||LA14_463=='\r') ) {s = 134;}
						if ( s>=0 ) return s;
						break;

					case 3 : 
						int LA14_30 = input.LA(1);
						s = -1;
						if ( ((LA14_30 >= '\u0000' && LA14_30 <= '\t')||(LA14_30 >= '\u000B' && LA14_30 <= '\f')||(LA14_30 >= '\u000E' && LA14_30 <= '&')||(LA14_30 >= '(' && LA14_30 <= '[')||(LA14_30 >= ']' && LA14_30 <= '\uFFFF')) ) {s = 131;}
						else if ( (LA14_30=='\\') ) {s = 132;}
						else if ( (LA14_30=='\'') ) {s = 133;}
						else if ( (LA14_30=='\n'||LA14_30=='\r') ) {s = 134;}
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 14, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
