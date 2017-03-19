// $ANTLR 3.5.2 src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g 2017-03-08 13:11:08

package org.qcri.rheem.latin.parser;

import java.util.Set;
import java.util.HashSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.apache.pig.parser.PigMacro;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.base.Joiner;


import org.antlr.runtime.*;

import java.util.List;
import java.util.Map;

import org.antlr.runtime.tree.*;


/**
 * Parser file for Pig Parser
 *
 * NOTE: THIS FILE IS THE BASE FOR A FEW TREE PARSER FILES, such as AstValidator.g,
 *       SO IF YOU CHANGE THIS FILE, YOU WILL PROBABLY NEED TO MAKE CORRESPONDING CHANGES TO
 *       THOSE FILES AS WELL.
 */
@SuppressWarnings("all")
public class QueryParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ALL", "AMPERSAND", "AND", "ARROBA", 
		"AS", "ASC", "ASSERT", "BAG", "BIGDECIMAL", "BIGDECIMALNUMBER", "BIGINTEGER", 
		"BIGINTEGERNUMBER", "BOOLEAN", "BY", "BYTEARRAY", "CACHE", "CASE", "CHARARRAY", 
		"COGROUP", "COLON", "COMMA", "CROSS", "CUBE", "DATETIME", "DCOLON", "DEFINE", 
		"DENSE", "DESC", "DIGIT", "DISTINCT", "DIV", "DOLLAR", "DOLLARVAR", "DOUBLE", 
		"DOUBLENUMBER", "DOUBLE_PERIOD", "ELSE", "END", "EQUAL", "EXECCOMMAND", 
		"FALSE", "FAT_ARROW", "FILTER", "FLATTEN", "FLOAT", "FLOATINGPOINT", "FLOATNUMBER", 
		"FOREACH", "FULL", "GENERATE", "GROUP", "ID", "IDENTIFIER", "IF", "IMPORT", 
		"IN", "INNER", "INPUT", "INT", "INTEGER", "INTO", "INVOKE", "IS", "JOIN", 
		"LEFT", "LEFT_BRACKET", "LEFT_CURLY", "LEFT_PAREN", "LETTER", "LIMIT", 
		"LOAD", "LONG", "LONGINTEGER", "MAP", "MAPREDUCE", "MINUS", "ML_COMMENT", 
		"MULTILINE_QUOTEDSTRING", "NOT", "NULL", "NUM_OP_EQ", "NUM_OP_GT", "NUM_OP_GTE", 
		"NUM_OP_LT", "NUM_OP_LTE", "NUM_OP_NE", "ONSCHEMA", "OR", "ORDER", "OTHERWISE", 
		"OUTER", "OUTPUT", "PARALLEL", "PARTITION", "PERCENT", "PERIOD", "PLUS", 
		"POUND", "QMARK", "QUOTEDSTRING", "RANK", "REGISTER", "RETURNS", "RIGHT", 
		"RIGHT_BRACKET", "RIGHT_CURLY", "RIGHT_PAREN", "ROLLUP", "SAMPLE", "SEMI_COLON", 
		"SHIP", "SL_COMMENT", "SPECIALCHAR", "SPLIT", "STAR", "STDERROR", "STDIN", 
		"STDOUT", "STORE", "STREAM", "STR_OP_EQ", "STR_OP_GT", "STR_OP_GTE", "STR_OP_LT", 
		"STR_OP_LTE", "STR_OP_MATCHES", "STR_OP_NE", "THEN", "THROUGH", "TRUE", 
		"TUPLE", "UNION", "USING", "VOID", "WHEN", "WS", "ANY", "BAG_TYPE", "BAG_TYPE_CAST", 
		"BAG_VAL", "BIN_EXPR", "BOOL", "BOOL_COND", "CASE_COND", "CASE_EXPR", 
		"CASE_EXPR_LHS", "CASE_EXPR_RHS", "CAST_EXPR", "COL_RANGE", "EXPR_IN_PAREN", 
		"FIELD_DEF", "FIELD_DEF_WITHOUT_IDENTIFIER", "FOREACH_PLAN_COMPLEX", "FOREACH_PLAN_SIMPLE", 
		"FUNC", "FUNC_EVAL", "FUNC_REF", "INVOKER_FUNC_EVAL", "IN_LHS", "IN_RHS", 
		"JOIN_ITEM", "KEY_VAL_PAIR", "MACRO_BODY", "MACRO_DEF", "MACRO_INLINE", 
		"MAP_TYPE", "MAP_VAL", "NEG", "NESTED_CMD", "NESTED_CMD_ASSI", "NESTED_PROJ", 
		"PARAMS", "QUERY", "REALIAS", "RETURN_VAL", "SPLIT_BRANCH", "STATEMENT", 
		"TOBAG", "TOMAP", "TOTUPLE", "TUPLE_TYPE", "TUPLE_TYPE_CAST", "TUPLE_VAL"
	};
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
	public static final int ANY=140;
	public static final int BAG_TYPE=141;
	public static final int BAG_TYPE_CAST=142;
	public static final int BAG_VAL=143;
	public static final int BIN_EXPR=144;
	public static final int BOOL=145;
	public static final int BOOL_COND=146;
	public static final int CASE_COND=147;
	public static final int CASE_EXPR=148;
	public static final int CASE_EXPR_LHS=149;
	public static final int CASE_EXPR_RHS=150;
	public static final int CAST_EXPR=151;
	public static final int COL_RANGE=152;
	public static final int EXPR_IN_PAREN=153;
	public static final int FIELD_DEF=154;
	public static final int FIELD_DEF_WITHOUT_IDENTIFIER=155;
	public static final int FOREACH_PLAN_COMPLEX=156;
	public static final int FOREACH_PLAN_SIMPLE=157;
	public static final int FUNC=158;
	public static final int FUNC_EVAL=159;
	public static final int FUNC_REF=160;
	public static final int INVOKER_FUNC_EVAL=161;
	public static final int IN_LHS=162;
	public static final int IN_RHS=163;
	public static final int JOIN_ITEM=164;
	public static final int KEY_VAL_PAIR=165;
	public static final int MACRO_BODY=166;
	public static final int MACRO_DEF=167;
	public static final int MACRO_INLINE=168;
	public static final int MAP_TYPE=169;
	public static final int MAP_VAL=170;
	public static final int NEG=171;
	public static final int NESTED_CMD=172;
	public static final int NESTED_CMD_ASSI=173;
	public static final int NESTED_PROJ=174;
	public static final int PARAMS=175;
	public static final int QUERY=176;
	public static final int REALIAS=177;
	public static final int RETURN_VAL=178;
	public static final int SPLIT_BRANCH=179;
	public static final int STATEMENT=180;
	public static final int TOBAG=181;
	public static final int TOMAP=182;
	public static final int TOTUPLE=183;
	public static final int TUPLE_TYPE=184;
	public static final int TUPLE_TYPE_CAST=185;
	public static final int TUPLE_VAL=186;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public QueryParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public QueryParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return QueryParser.tokenNames; }
	@Override public String getGrammarFileName() { return "src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g"; }


	private static Log log = LogFactory.getLog( QueryParser.class );

	private Set<String> memory = new HashSet<String>();

	// Make a deep copy of the given node
	private static Tree deepCopy(Tree tree) {
	    Tree copy = tree.dupNode();
	    for (int i = 0; i < tree.getChildCount(); i++) {
	        Tree child = deepCopy(tree.getChild(i));
	        child.setParent(copy);
	        copy.addChild(child);
	    }
	    return copy;
	}

	@Override
	protected Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow)
	throws RecognitionException {
	    throw new MismatchedTokenException( ttype, input );
	}

	@Override
	public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow)
	throws RecognitionException {
	    throw e;
	}

	@Override
	public String getErrorMessage(RecognitionException e, String[] tokenNames ) {
	    if( !log.isDebugEnabled() ) {
	        if( e instanceof NoViableAltException ) {
	            return "Syntax error, unexpected symbol at or near " + getTokenErrorDisplay( e.token );
	        } else {
	            return super.getErrorMessage( e, tokenNames );
	        }
	    }

	    List stack =  getRuleInvocationStack( e, this.getClass().getName() );
	    String msg = null;
	    if( e instanceof NoViableAltException ) {
	        NoViableAltException nvae = (NoViableAltException)e;
	        msg = " no viable alt; token = " + e.token + " (decision=" + nvae.decisionNumber + " state " + nvae.stateNumber + ")" +
	            " decision=<<" + nvae.grammarDecisionDescription + ">>";
	    } else {
	        msg =  super.getErrorMessage( e, tokenNames );
	    }
	    return stack + " " + msg;
	}

	@Override
	public String getTokenErrorDisplay(Token t) {
	    return "'" + t.getText() + "'";
	}

	@Override
	public String getErrorHeader(RecognitionException ex) {
		return QueryParserUtils.generateErrorHeader( ex, this.getSourceName() );
	}

	private static final Map<Integer, Integer> FUNC_TO_LITERAL = ImmutableMap.of(
	    TOBAG, BAG_VAL,
	    TOMAP, MAP_VAL,
	    TOTUPLE, TUPLE_VAL);

	private static final Set<Integer> BOOLEAN_TOKENS = ImmutableSet.of(
	    STR_OP_EQ,
	    STR_OP_NE,
	    STR_OP_GT,
	    STR_OP_LT,
	    STR_OP_GTE,
	    STR_OP_LTE,
	    STR_OP_MATCHES,
	    AND,
	    OR,
	    NOT,
	    NULL,
	    NUM_OP_EQ,
	    NUM_OP_NE,
	    NUM_OP_GT,
	    NUM_OP_GTE,
	    NUM_OP_LT,
	    NUM_OP_LTE);

	private static final Set<Integer> LITERAL_TOKENS = ImmutableSet.of(
	    INTEGER,
	    LONGINTEGER,
	    FLOATNUMBER,
	    DOUBLENUMBER,
	    QUOTEDSTRING,
	    NULL,
	    TRUE,
	    FALSE,
	    MAP_VAL,
	    BAG_VAL,
	    TUPLE_VAL,
	    PERIOD,
	    POUND);



	public static class query_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "query"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:212:1: query : ( statement )* EOF -> ^( QUERY ( statement )* ) ;
	public final QueryParser.query_return query() throws RecognitionException {
		QueryParser.query_return retval = new QueryParser.query_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token EOF2=null;
		ParserRuleReturnScope statement1 =null;

		Object EOF2_tree=null;
		RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
		RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:212:7: ( ( statement )* EOF -> ^( QUERY ( statement )* ) )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:212:9: ( statement )* EOF
			{
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:212:9: ( statement )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==ASSERT||LA1_0==COGROUP||(LA1_0 >= CROSS && LA1_0 <= CUBE)||LA1_0==DEFINE||LA1_0==DISTINCT||(LA1_0 >= ELSE && LA1_0 <= END)||(LA1_0 >= FAT_ARROW && LA1_0 <= FILTER)||LA1_0==FOREACH||LA1_0==GROUP||LA1_0==IDENTIFIER||(LA1_0 >= IMPORT && LA1_0 <= IN)||LA1_0==JOIN||LA1_0==LEFT_PAREN||(LA1_0 >= LIMIT && LA1_0 <= LOAD)||LA1_0==MAPREDUCE||LA1_0==ORDER||(LA1_0 >= RANK && LA1_0 <= REGISTER)||(LA1_0 >= SAMPLE && LA1_0 <= SEMI_COLON)||LA1_0==SPLIT||(LA1_0 >= STORE && LA1_0 <= STREAM)||LA1_0==THEN||LA1_0==UNION||LA1_0==WHEN) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:212:9: statement
					{
					pushFollow(FOLLOW_statement_in_query426);
					statement1=statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_statement.add(statement1.getTree());
					}
					break;

				default :
					break loop1;
				}
			}

			EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_query429); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_EOF.add(EOF2);

			// AST REWRITE
			// elements: statement
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 212:24: -> ^( QUERY ( statement )* )
			{
				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:212:27: ^( QUERY ( statement )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(QUERY, "QUERY"), root_1);
				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:212:36: ( statement )*
				while ( stream_statement.hasNext() ) {
					adaptor.addChild(root_1, stream_statement.nextTree());
				}
				stream_statement.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "query"


	public static class schema_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "schema"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:215:1: schema : field_def_list EOF ;
	public final QueryParser.schema_return schema() throws RecognitionException {
		QueryParser.schema_return retval = new QueryParser.schema_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token EOF4=null;
		ParserRuleReturnScope field_def_list3 =null;

		Object EOF4_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:215:7: ( field_def_list EOF )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:215:9: field_def_list EOF
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_field_def_list_in_schema448);
			field_def_list3=field_def_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, field_def_list3.getTree());

			EOF4=(Token)match(input,EOF,FOLLOW_EOF_in_schema450); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			EOF4_tree = (Object)adaptor.create(EOF4);
			adaptor.addChild(root_0, EOF4_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "schema"


	public static class statement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "statement"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:220:1: statement : ( SEMI_COLON !| general_statement SEMI_COLON !| split_clause SEMI_COLON !| inline_clause SEMI_COLON !| import_clause SEMI_COLON !| realias_clause SEMI_COLON !| register_clause SEMI_COLON !| assert_clause SEMI_COLON !| foreach_statement );
	public final QueryParser.statement_return statement() throws RecognitionException {
		QueryParser.statement_return retval = new QueryParser.statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SEMI_COLON5=null;
		Token SEMI_COLON7=null;
		Token SEMI_COLON9=null;
		Token SEMI_COLON11=null;
		Token SEMI_COLON13=null;
		Token SEMI_COLON15=null;
		Token SEMI_COLON17=null;
		Token SEMI_COLON19=null;
		ParserRuleReturnScope general_statement6 =null;
		ParserRuleReturnScope split_clause8 =null;
		ParserRuleReturnScope inline_clause10 =null;
		ParserRuleReturnScope import_clause12 =null;
		ParserRuleReturnScope realias_clause14 =null;
		ParserRuleReturnScope register_clause16 =null;
		ParserRuleReturnScope assert_clause18 =null;
		ParserRuleReturnScope foreach_statement20 =null;

		Object SEMI_COLON5_tree=null;
		Object SEMI_COLON7_tree=null;
		Object SEMI_COLON9_tree=null;
		Object SEMI_COLON11_tree=null;
		Object SEMI_COLON13_tree=null;
		Object SEMI_COLON15_tree=null;
		Object SEMI_COLON17_tree=null;
		Object SEMI_COLON19_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:220:11: ( SEMI_COLON !| general_statement SEMI_COLON !| split_clause SEMI_COLON !| inline_clause SEMI_COLON !| import_clause SEMI_COLON !| realias_clause SEMI_COLON !| register_clause SEMI_COLON !| assert_clause SEMI_COLON !| foreach_statement )
			int alt2=9;
			switch ( input.LA(1) ) {
			case SEMI_COLON:
				{
				alt2=1;
				}
				break;
			case FAT_ARROW:
				{
				int LA2_2 = input.LA(2);
				if ( (LA2_2==FOREACH) ) {
					alt2=9;
				}
				else if ( (LA2_2==COGROUP||(LA2_2 >= CROSS && LA2_2 <= CUBE)||LA2_2==DEFINE||LA2_2==DISTINCT||LA2_2==FILTER||LA2_2==GROUP||LA2_2==JOIN||LA2_2==LEFT_PAREN||(LA2_2 >= LIMIT && LA2_2 <= LOAD)||LA2_2==MAPREDUCE||LA2_2==ORDER||LA2_2==RANK||LA2_2==SAMPLE||(LA2_2 >= STORE && LA2_2 <= STREAM)||LA2_2==UNION) ) {
					alt2=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case IDENTIFIER:
				{
				int LA2_3 = input.LA(2);
				if ( (LA2_3==EQUAL) ) {
					switch ( input.LA(3) ) {
					case COGROUP:
					case CROSS:
					case DEFINE:
					case DISTINCT:
					case FILTER:
					case GROUP:
					case JOIN:
					case LEFT_PAREN:
					case LIMIT:
					case LOAD:
					case MAPREDUCE:
					case ORDER:
					case SAMPLE:
					case STORE:
					case STREAM:
					case UNION:
						{
						alt2=2;
						}
						break;
					case CUBE:
						{
						switch ( input.LA(4) ) {
						case ARROBA:
						case CUBE:
						case ELSE:
						case END:
						case IDENTIFIER:
						case IN:
						case RANK:
						case THEN:
						case WHEN:
							{
							alt2=2;
							}
							break;
						case LEFT_PAREN:
							{
							int LA2_15 = input.LA(5);
							if ( (LA2_15==COGROUP||(LA2_15 >= CROSS && LA2_15 <= CUBE)||LA2_15==DEFINE||LA2_15==DISTINCT||LA2_15==FILTER||LA2_15==FOREACH||LA2_15==GROUP||LA2_15==JOIN||(LA2_15 >= LIMIT && LA2_15 <= LOAD)||LA2_15==MAPREDUCE||LA2_15==ORDER||LA2_15==RANK||LA2_15==SAMPLE||(LA2_15 >= STORE && LA2_15 <= STREAM)||LA2_15==UNION) ) {
								alt2=2;
							}
							else if ( (LA2_15==BIGDECIMALNUMBER||LA2_15==BIGINTEGERNUMBER||LA2_15==DOLLARVAR||LA2_15==DOUBLENUMBER||LA2_15==IDENTIFIER||LA2_15==INTEGER||LA2_15==QUOTEDSTRING||LA2_15==RIGHT_PAREN) ) {
								alt2=4;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 2, 15, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						case SEMI_COLON:
							{
							alt2=6;
							}
							break;
						default:
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 2, 17, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}
						}
						break;
					case RANK:
						{
						switch ( input.LA(4) ) {
						case ARROBA:
						case CUBE:
						case ELSE:
						case END:
						case IDENTIFIER:
						case IN:
						case RANK:
						case THEN:
						case WHEN:
							{
							alt2=2;
							}
							break;
						case LEFT_PAREN:
							{
							int LA2_16 = input.LA(5);
							if ( (LA2_16==COGROUP||(LA2_16 >= CROSS && LA2_16 <= CUBE)||LA2_16==DEFINE||LA2_16==DISTINCT||LA2_16==FILTER||LA2_16==FOREACH||LA2_16==GROUP||LA2_16==JOIN||(LA2_16 >= LIMIT && LA2_16 <= LOAD)||LA2_16==MAPREDUCE||LA2_16==ORDER||LA2_16==RANK||LA2_16==SAMPLE||(LA2_16 >= STORE && LA2_16 <= STREAM)||LA2_16==UNION) ) {
								alt2=2;
							}
							else if ( (LA2_16==BIGDECIMALNUMBER||LA2_16==BIGINTEGERNUMBER||LA2_16==DOLLARVAR||LA2_16==DOUBLENUMBER||LA2_16==IDENTIFIER||LA2_16==INTEGER||LA2_16==QUOTEDSTRING||LA2_16==RIGHT_PAREN) ) {
								alt2=4;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 2, 16, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						case SEMI_COLON:
							{
							alt2=6;
							}
							break;
						default:
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 2, 18, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}
						}
						break;
					case IDENTIFIER:
						{
						int LA2_19 = input.LA(4);
						if ( (LA2_19==LEFT_PAREN) ) {
							alt2=4;
						}
						else if ( (LA2_19==SEMI_COLON) ) {
							alt2=6;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 2, 19, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case ELSE:
					case END:
					case IN:
					case THEN:
					case WHEN:
						{
						int LA2_20 = input.LA(4);
						if ( (LA2_20==LEFT_PAREN) ) {
							alt2=4;
						}
						else if ( (LA2_20==SEMI_COLON) ) {
							alt2=6;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 2, 20, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case FOREACH:
						{
						alt2=9;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 2, 13, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}
				else if ( (LA2_3==COMMA||LA2_3==LEFT_PAREN) ) {
					alt2=4;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case CUBE:
				{
				switch ( input.LA(2) ) {
				case EQUAL:
					{
					switch ( input.LA(3) ) {
					case COGROUP:
					case CROSS:
					case DEFINE:
					case DISTINCT:
					case FILTER:
					case GROUP:
					case JOIN:
					case LEFT_PAREN:
					case LIMIT:
					case LOAD:
					case MAPREDUCE:
					case ORDER:
					case SAMPLE:
					case STORE:
					case STREAM:
					case UNION:
						{
						alt2=2;
						}
						break;
					case CUBE:
						{
						switch ( input.LA(4) ) {
						case ARROBA:
						case CUBE:
						case ELSE:
						case END:
						case IDENTIFIER:
						case IN:
						case RANK:
						case THEN:
						case WHEN:
							{
							alt2=2;
							}
							break;
						case LEFT_PAREN:
							{
							int LA2_15 = input.LA(5);
							if ( (LA2_15==COGROUP||(LA2_15 >= CROSS && LA2_15 <= CUBE)||LA2_15==DEFINE||LA2_15==DISTINCT||LA2_15==FILTER||LA2_15==FOREACH||LA2_15==GROUP||LA2_15==JOIN||(LA2_15 >= LIMIT && LA2_15 <= LOAD)||LA2_15==MAPREDUCE||LA2_15==ORDER||LA2_15==RANK||LA2_15==SAMPLE||(LA2_15 >= STORE && LA2_15 <= STREAM)||LA2_15==UNION) ) {
								alt2=2;
							}
							else if ( (LA2_15==BIGDECIMALNUMBER||LA2_15==BIGINTEGERNUMBER||LA2_15==DOLLARVAR||LA2_15==DOUBLENUMBER||LA2_15==IDENTIFIER||LA2_15==INTEGER||LA2_15==QUOTEDSTRING||LA2_15==RIGHT_PAREN) ) {
								alt2=4;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 2, 15, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						case SEMI_COLON:
							{
							alt2=6;
							}
							break;
						default:
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 2, 17, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}
						}
						break;
					case RANK:
						{
						switch ( input.LA(4) ) {
						case ARROBA:
						case CUBE:
						case ELSE:
						case END:
						case IDENTIFIER:
						case IN:
						case RANK:
						case THEN:
						case WHEN:
							{
							alt2=2;
							}
							break;
						case LEFT_PAREN:
							{
							int LA2_16 = input.LA(5);
							if ( (LA2_16==COGROUP||(LA2_16 >= CROSS && LA2_16 <= CUBE)||LA2_16==DEFINE||LA2_16==DISTINCT||LA2_16==FILTER||LA2_16==FOREACH||LA2_16==GROUP||LA2_16==JOIN||(LA2_16 >= LIMIT && LA2_16 <= LOAD)||LA2_16==MAPREDUCE||LA2_16==ORDER||LA2_16==RANK||LA2_16==SAMPLE||(LA2_16 >= STORE && LA2_16 <= STREAM)||LA2_16==UNION) ) {
								alt2=2;
							}
							else if ( (LA2_16==BIGDECIMALNUMBER||LA2_16==BIGINTEGERNUMBER||LA2_16==DOLLARVAR||LA2_16==DOUBLENUMBER||LA2_16==IDENTIFIER||LA2_16==INTEGER||LA2_16==QUOTEDSTRING||LA2_16==RIGHT_PAREN) ) {
								alt2=4;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 2, 16, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						case SEMI_COLON:
							{
							alt2=6;
							}
							break;
						default:
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 2, 18, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}
						}
						break;
					case IDENTIFIER:
						{
						int LA2_19 = input.LA(4);
						if ( (LA2_19==LEFT_PAREN) ) {
							alt2=4;
						}
						else if ( (LA2_19==SEMI_COLON) ) {
							alt2=6;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 2, 19, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case ELSE:
					case END:
					case IN:
					case THEN:
					case WHEN:
						{
						int LA2_20 = input.LA(4);
						if ( (LA2_20==LEFT_PAREN) ) {
							alt2=4;
						}
						else if ( (LA2_20==SEMI_COLON) ) {
							alt2=6;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 2, 20, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case FOREACH:
						{
						alt2=9;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 2, 13, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
					}
					break;
				case ARROBA:
				case CUBE:
				case ELSE:
				case END:
				case IDENTIFIER:
				case IN:
				case RANK:
				case THEN:
				case WHEN:
					{
					alt2=2;
					}
					break;
				case LEFT_PAREN:
					{
					int LA2_15 = input.LA(3);
					if ( (LA2_15==COGROUP||(LA2_15 >= CROSS && LA2_15 <= CUBE)||LA2_15==DEFINE||LA2_15==DISTINCT||LA2_15==FILTER||LA2_15==FOREACH||LA2_15==GROUP||LA2_15==JOIN||(LA2_15 >= LIMIT && LA2_15 <= LOAD)||LA2_15==MAPREDUCE||LA2_15==ORDER||LA2_15==RANK||LA2_15==SAMPLE||(LA2_15 >= STORE && LA2_15 <= STREAM)||LA2_15==UNION) ) {
						alt2=2;
					}
					else if ( (LA2_15==BIGDECIMALNUMBER||LA2_15==BIGINTEGERNUMBER||LA2_15==DOLLARVAR||LA2_15==DOUBLENUMBER||LA2_15==IDENTIFIER||LA2_15==INTEGER||LA2_15==QUOTEDSTRING||LA2_15==RIGHT_PAREN) ) {
						alt2=4;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 2, 15, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case COMMA:
					{
					alt2=4;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
				}
				break;
			case COGROUP:
			case CROSS:
			case DEFINE:
			case DISTINCT:
			case FILTER:
			case GROUP:
			case JOIN:
			case LEFT_PAREN:
			case LIMIT:
			case LOAD:
			case MAPREDUCE:
			case ORDER:
			case SAMPLE:
			case STORE:
			case STREAM:
			case UNION:
				{
				alt2=2;
				}
				break;
			case RANK:
				{
				switch ( input.LA(2) ) {
				case EQUAL:
					{
					switch ( input.LA(3) ) {
					case COGROUP:
					case CROSS:
					case DEFINE:
					case DISTINCT:
					case FILTER:
					case GROUP:
					case JOIN:
					case LEFT_PAREN:
					case LIMIT:
					case LOAD:
					case MAPREDUCE:
					case ORDER:
					case SAMPLE:
					case STORE:
					case STREAM:
					case UNION:
						{
						alt2=2;
						}
						break;
					case CUBE:
						{
						switch ( input.LA(4) ) {
						case ARROBA:
						case CUBE:
						case ELSE:
						case END:
						case IDENTIFIER:
						case IN:
						case RANK:
						case THEN:
						case WHEN:
							{
							alt2=2;
							}
							break;
						case LEFT_PAREN:
							{
							int LA2_15 = input.LA(5);
							if ( (LA2_15==COGROUP||(LA2_15 >= CROSS && LA2_15 <= CUBE)||LA2_15==DEFINE||LA2_15==DISTINCT||LA2_15==FILTER||LA2_15==FOREACH||LA2_15==GROUP||LA2_15==JOIN||(LA2_15 >= LIMIT && LA2_15 <= LOAD)||LA2_15==MAPREDUCE||LA2_15==ORDER||LA2_15==RANK||LA2_15==SAMPLE||(LA2_15 >= STORE && LA2_15 <= STREAM)||LA2_15==UNION) ) {
								alt2=2;
							}
							else if ( (LA2_15==BIGDECIMALNUMBER||LA2_15==BIGINTEGERNUMBER||LA2_15==DOLLARVAR||LA2_15==DOUBLENUMBER||LA2_15==IDENTIFIER||LA2_15==INTEGER||LA2_15==QUOTEDSTRING||LA2_15==RIGHT_PAREN) ) {
								alt2=4;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 2, 15, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						case SEMI_COLON:
							{
							alt2=6;
							}
							break;
						default:
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 2, 17, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}
						}
						break;
					case RANK:
						{
						switch ( input.LA(4) ) {
						case ARROBA:
						case CUBE:
						case ELSE:
						case END:
						case IDENTIFIER:
						case IN:
						case RANK:
						case THEN:
						case WHEN:
							{
							alt2=2;
							}
							break;
						case LEFT_PAREN:
							{
							int LA2_16 = input.LA(5);
							if ( (LA2_16==COGROUP||(LA2_16 >= CROSS && LA2_16 <= CUBE)||LA2_16==DEFINE||LA2_16==DISTINCT||LA2_16==FILTER||LA2_16==FOREACH||LA2_16==GROUP||LA2_16==JOIN||(LA2_16 >= LIMIT && LA2_16 <= LOAD)||LA2_16==MAPREDUCE||LA2_16==ORDER||LA2_16==RANK||LA2_16==SAMPLE||(LA2_16 >= STORE && LA2_16 <= STREAM)||LA2_16==UNION) ) {
								alt2=2;
							}
							else if ( (LA2_16==BIGDECIMALNUMBER||LA2_16==BIGINTEGERNUMBER||LA2_16==DOLLARVAR||LA2_16==DOUBLENUMBER||LA2_16==IDENTIFIER||LA2_16==INTEGER||LA2_16==QUOTEDSTRING||LA2_16==RIGHT_PAREN) ) {
								alt2=4;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 2, 16, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						case SEMI_COLON:
							{
							alt2=6;
							}
							break;
						default:
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 2, 18, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}
						}
						break;
					case IDENTIFIER:
						{
						int LA2_19 = input.LA(4);
						if ( (LA2_19==LEFT_PAREN) ) {
							alt2=4;
						}
						else if ( (LA2_19==SEMI_COLON) ) {
							alt2=6;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 2, 19, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case ELSE:
					case END:
					case IN:
					case THEN:
					case WHEN:
						{
						int LA2_20 = input.LA(4);
						if ( (LA2_20==LEFT_PAREN) ) {
							alt2=4;
						}
						else if ( (LA2_20==SEMI_COLON) ) {
							alt2=6;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 2, 20, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case FOREACH:
						{
						alt2=9;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 2, 13, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
					}
					break;
				case ARROBA:
				case CUBE:
				case ELSE:
				case END:
				case IDENTIFIER:
				case IN:
				case RANK:
				case THEN:
				case WHEN:
					{
					alt2=2;
					}
					break;
				case LEFT_PAREN:
					{
					int LA2_16 = input.LA(3);
					if ( (LA2_16==COGROUP||(LA2_16 >= CROSS && LA2_16 <= CUBE)||LA2_16==DEFINE||LA2_16==DISTINCT||LA2_16==FILTER||LA2_16==FOREACH||LA2_16==GROUP||LA2_16==JOIN||(LA2_16 >= LIMIT && LA2_16 <= LOAD)||LA2_16==MAPREDUCE||LA2_16==ORDER||LA2_16==RANK||LA2_16==SAMPLE||(LA2_16 >= STORE && LA2_16 <= STREAM)||LA2_16==UNION) ) {
						alt2=2;
					}
					else if ( (LA2_16==BIGDECIMALNUMBER||LA2_16==BIGINTEGERNUMBER||LA2_16==DOLLARVAR||LA2_16==DOUBLENUMBER||LA2_16==IDENTIFIER||LA2_16==INTEGER||LA2_16==QUOTEDSTRING||LA2_16==RIGHT_PAREN) ) {
						alt2=4;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 2, 16, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case COMMA:
					{
					alt2=4;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 6, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
				}
				break;
			case ELSE:
			case END:
			case IN:
			case THEN:
			case WHEN:
				{
				int LA2_7 = input.LA(2);
				if ( (LA2_7==EQUAL) ) {
					switch ( input.LA(3) ) {
					case COGROUP:
					case CROSS:
					case DEFINE:
					case DISTINCT:
					case FILTER:
					case GROUP:
					case JOIN:
					case LEFT_PAREN:
					case LIMIT:
					case LOAD:
					case MAPREDUCE:
					case ORDER:
					case SAMPLE:
					case STORE:
					case STREAM:
					case UNION:
						{
						alt2=2;
						}
						break;
					case CUBE:
						{
						switch ( input.LA(4) ) {
						case ARROBA:
						case CUBE:
						case ELSE:
						case END:
						case IDENTIFIER:
						case IN:
						case RANK:
						case THEN:
						case WHEN:
							{
							alt2=2;
							}
							break;
						case LEFT_PAREN:
							{
							int LA2_15 = input.LA(5);
							if ( (LA2_15==COGROUP||(LA2_15 >= CROSS && LA2_15 <= CUBE)||LA2_15==DEFINE||LA2_15==DISTINCT||LA2_15==FILTER||LA2_15==FOREACH||LA2_15==GROUP||LA2_15==JOIN||(LA2_15 >= LIMIT && LA2_15 <= LOAD)||LA2_15==MAPREDUCE||LA2_15==ORDER||LA2_15==RANK||LA2_15==SAMPLE||(LA2_15 >= STORE && LA2_15 <= STREAM)||LA2_15==UNION) ) {
								alt2=2;
							}
							else if ( (LA2_15==BIGDECIMALNUMBER||LA2_15==BIGINTEGERNUMBER||LA2_15==DOLLARVAR||LA2_15==DOUBLENUMBER||LA2_15==IDENTIFIER||LA2_15==INTEGER||LA2_15==QUOTEDSTRING||LA2_15==RIGHT_PAREN) ) {
								alt2=4;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 2, 15, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						case SEMI_COLON:
							{
							alt2=6;
							}
							break;
						default:
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 2, 17, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}
						}
						break;
					case RANK:
						{
						switch ( input.LA(4) ) {
						case ARROBA:
						case CUBE:
						case ELSE:
						case END:
						case IDENTIFIER:
						case IN:
						case RANK:
						case THEN:
						case WHEN:
							{
							alt2=2;
							}
							break;
						case LEFT_PAREN:
							{
							int LA2_16 = input.LA(5);
							if ( (LA2_16==COGROUP||(LA2_16 >= CROSS && LA2_16 <= CUBE)||LA2_16==DEFINE||LA2_16==DISTINCT||LA2_16==FILTER||LA2_16==FOREACH||LA2_16==GROUP||LA2_16==JOIN||(LA2_16 >= LIMIT && LA2_16 <= LOAD)||LA2_16==MAPREDUCE||LA2_16==ORDER||LA2_16==RANK||LA2_16==SAMPLE||(LA2_16 >= STORE && LA2_16 <= STREAM)||LA2_16==UNION) ) {
								alt2=2;
							}
							else if ( (LA2_16==BIGDECIMALNUMBER||LA2_16==BIGINTEGERNUMBER||LA2_16==DOLLARVAR||LA2_16==DOUBLENUMBER||LA2_16==IDENTIFIER||LA2_16==INTEGER||LA2_16==QUOTEDSTRING||LA2_16==RIGHT_PAREN) ) {
								alt2=4;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 2, 16, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						case SEMI_COLON:
							{
							alt2=6;
							}
							break;
						default:
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 2, 18, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}
						}
						break;
					case IDENTIFIER:
						{
						int LA2_19 = input.LA(4);
						if ( (LA2_19==LEFT_PAREN) ) {
							alt2=4;
						}
						else if ( (LA2_19==SEMI_COLON) ) {
							alt2=6;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 2, 19, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case ELSE:
					case END:
					case IN:
					case THEN:
					case WHEN:
						{
						int LA2_20 = input.LA(4);
						if ( (LA2_20==LEFT_PAREN) ) {
							alt2=4;
						}
						else if ( (LA2_20==SEMI_COLON) ) {
							alt2=6;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 2, 20, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case FOREACH:
						{
						alt2=9;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 2, 13, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}
				else if ( (LA2_7==COMMA||LA2_7==LEFT_PAREN) ) {
					alt2=4;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 7, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case SPLIT:
				{
				alt2=3;
				}
				break;
			case IMPORT:
				{
				alt2=5;
				}
				break;
			case REGISTER:
				{
				alt2=7;
				}
				break;
			case ASSERT:
				{
				alt2=8;
				}
				break;
			case FOREACH:
				{
				alt2=9;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:220:13: SEMI_COLON !
					{
					root_0 = (Object)adaptor.nil();


					SEMI_COLON5=(Token)match(input,SEMI_COLON,FOLLOW_SEMI_COLON_in_statement461); if (state.failed) return retval;
					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:221:13: general_statement SEMI_COLON !
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_general_statement_in_statement476);
					general_statement6=general_statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, general_statement6.getTree());

					SEMI_COLON7=(Token)match(input,SEMI_COLON,FOLLOW_SEMI_COLON_in_statement478); if (state.failed) return retval;
					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:222:13: split_clause SEMI_COLON !
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_split_clause_in_statement493);
					split_clause8=split_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, split_clause8.getTree());

					SEMI_COLON9=(Token)match(input,SEMI_COLON,FOLLOW_SEMI_COLON_in_statement495); if (state.failed) return retval;
					}
					break;
				case 4 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:223:13: inline_clause SEMI_COLON !
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_inline_clause_in_statement510);
					inline_clause10=inline_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, inline_clause10.getTree());

					SEMI_COLON11=(Token)match(input,SEMI_COLON,FOLLOW_SEMI_COLON_in_statement512); if (state.failed) return retval;
					}
					break;
				case 5 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:224:13: import_clause SEMI_COLON !
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_import_clause_in_statement527);
					import_clause12=import_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, import_clause12.getTree());

					SEMI_COLON13=(Token)match(input,SEMI_COLON,FOLLOW_SEMI_COLON_in_statement529); if (state.failed) return retval;
					}
					break;
				case 6 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:225:13: realias_clause SEMI_COLON !
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_realias_clause_in_statement544);
					realias_clause14=realias_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, realias_clause14.getTree());

					SEMI_COLON15=(Token)match(input,SEMI_COLON,FOLLOW_SEMI_COLON_in_statement546); if (state.failed) return retval;
					}
					break;
				case 7 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:226:13: register_clause SEMI_COLON !
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_register_clause_in_statement561);
					register_clause16=register_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, register_clause16.getTree());

					SEMI_COLON17=(Token)match(input,SEMI_COLON,FOLLOW_SEMI_COLON_in_statement563); if (state.failed) return retval;
					}
					break;
				case 8 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:227:13: assert_clause SEMI_COLON !
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_assert_clause_in_statement578);
					assert_clause18=assert_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, assert_clause18.getTree());

					SEMI_COLON19=(Token)match(input,SEMI_COLON,FOLLOW_SEMI_COLON_in_statement580); if (state.failed) return retval;
					}
					break;
				case 9 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:231:13: foreach_statement
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_foreach_statement_in_statement628);
					foreach_statement20=foreach_statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, foreach_statement20.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "statement"


	public static class nested_op_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "nested_op_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:234:1: nested_op_clause : ( LEFT_PAREN ! op_clause ( parallel_clause )? RIGHT_PAREN !| LEFT_PAREN FOREACH rel ( foreach_plan_complex | ( foreach_plan_simple ( parallel_clause )? ) ) RIGHT_PAREN -> ^( FOREACH rel ( foreach_plan_complex )? ( foreach_plan_simple )? ) ( parallel_clause )? );
	public final QueryParser.nested_op_clause_return nested_op_clause() throws RecognitionException {
		QueryParser.nested_op_clause_return retval = new QueryParser.nested_op_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LEFT_PAREN21=null;
		Token RIGHT_PAREN24=null;
		Token LEFT_PAREN25=null;
		Token FOREACH26=null;
		Token RIGHT_PAREN31=null;
		ParserRuleReturnScope op_clause22 =null;
		ParserRuleReturnScope parallel_clause23 =null;
		ParserRuleReturnScope rel27 =null;
		ParserRuleReturnScope foreach_plan_complex28 =null;
		ParserRuleReturnScope foreach_plan_simple29 =null;
		ParserRuleReturnScope parallel_clause30 =null;

		Object LEFT_PAREN21_tree=null;
		Object RIGHT_PAREN24_tree=null;
		Object LEFT_PAREN25_tree=null;
		Object FOREACH26_tree=null;
		Object RIGHT_PAREN31_tree=null;
		RewriteRuleTokenStream stream_RIGHT_PAREN=new RewriteRuleTokenStream(adaptor,"token RIGHT_PAREN");
		RewriteRuleTokenStream stream_FOREACH=new RewriteRuleTokenStream(adaptor,"token FOREACH");
		RewriteRuleTokenStream stream_LEFT_PAREN=new RewriteRuleTokenStream(adaptor,"token LEFT_PAREN");
		RewriteRuleSubtreeStream stream_parallel_clause=new RewriteRuleSubtreeStream(adaptor,"rule parallel_clause");
		RewriteRuleSubtreeStream stream_foreach_plan_simple=new RewriteRuleSubtreeStream(adaptor,"rule foreach_plan_simple");
		RewriteRuleSubtreeStream stream_rel=new RewriteRuleSubtreeStream(adaptor,"rule rel");
		RewriteRuleSubtreeStream stream_foreach_plan_complex=new RewriteRuleSubtreeStream(adaptor,"rule foreach_plan_complex");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:234:18: ( LEFT_PAREN ! op_clause ( parallel_clause )? RIGHT_PAREN !| LEFT_PAREN FOREACH rel ( foreach_plan_complex | ( foreach_plan_simple ( parallel_clause )? ) ) RIGHT_PAREN -> ^( FOREACH rel ( foreach_plan_complex )? ( foreach_plan_simple )? ) ( parallel_clause )? )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==LEFT_PAREN) ) {
				int LA6_1 = input.LA(2);
				if ( (LA6_1==FOREACH) ) {
					alt6=2;
				}
				else if ( (LA6_1==COGROUP||(LA6_1 >= CROSS && LA6_1 <= CUBE)||LA6_1==DEFINE||LA6_1==DISTINCT||LA6_1==FILTER||LA6_1==GROUP||LA6_1==JOIN||(LA6_1 >= LIMIT && LA6_1 <= LOAD)||LA6_1==MAPREDUCE||LA6_1==ORDER||LA6_1==RANK||LA6_1==SAMPLE||(LA6_1 >= STORE && LA6_1 <= STREAM)||LA6_1==UNION) ) {
					alt6=1;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 6, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:234:20: LEFT_PAREN ! op_clause ( parallel_clause )? RIGHT_PAREN !
					{
					root_0 = (Object)adaptor.nil();


					LEFT_PAREN21=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_nested_op_clause637); if (state.failed) return retval;
					pushFollow(FOLLOW_op_clause_in_nested_op_clause640);
					op_clause22=op_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, op_clause22.getTree());

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:234:42: ( parallel_clause )?
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0==PARALLEL) ) {
						alt3=1;
					}
					switch (alt3) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:234:42: parallel_clause
							{
							pushFollow(FOLLOW_parallel_clause_in_nested_op_clause642);
							parallel_clause23=parallel_clause();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, parallel_clause23.getTree());

							}
							break;

					}

					RIGHT_PAREN24=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_nested_op_clause645); if (state.failed) return retval;
					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:235:20: LEFT_PAREN FOREACH rel ( foreach_plan_complex | ( foreach_plan_simple ( parallel_clause )? ) ) RIGHT_PAREN
					{
					LEFT_PAREN25=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_nested_op_clause667); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LEFT_PAREN.add(LEFT_PAREN25);

					FOREACH26=(Token)match(input,FOREACH,FOLLOW_FOREACH_in_nested_op_clause669); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_FOREACH.add(FOREACH26);

					pushFollow(FOLLOW_rel_in_nested_op_clause671);
					rel27=rel();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_rel.add(rel27.getTree());
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:235:43: ( foreach_plan_complex | ( foreach_plan_simple ( parallel_clause )? ) )
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==LEFT_CURLY) ) {
						alt5=1;
					}
					else if ( (LA5_0==GENERATE) ) {
						alt5=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 5, 0, input);
						throw nvae;
					}

					switch (alt5) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:235:45: foreach_plan_complex
							{
							pushFollow(FOLLOW_foreach_plan_complex_in_nested_op_clause675);
							foreach_plan_complex28=foreach_plan_complex();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_foreach_plan_complex.add(foreach_plan_complex28.getTree());
							}
							break;
						case 2 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:235:68: ( foreach_plan_simple ( parallel_clause )? )
							{
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:235:68: ( foreach_plan_simple ( parallel_clause )? )
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:235:70: foreach_plan_simple ( parallel_clause )?
							{
							pushFollow(FOLLOW_foreach_plan_simple_in_nested_op_clause681);
							foreach_plan_simple29=foreach_plan_simple();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_foreach_plan_simple.add(foreach_plan_simple29.getTree());
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:235:90: ( parallel_clause )?
							int alt4=2;
							int LA4_0 = input.LA(1);
							if ( (LA4_0==PARALLEL) ) {
								alt4=1;
							}
							switch (alt4) {
								case 1 :
									// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:235:90: parallel_clause
									{
									pushFollow(FOLLOW_parallel_clause_in_nested_op_clause683);
									parallel_clause30=parallel_clause();
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) stream_parallel_clause.add(parallel_clause30.getTree());
									}
									break;

							}

							}

							}
							break;

					}

					RIGHT_PAREN31=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_nested_op_clause690); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RIGHT_PAREN.add(RIGHT_PAREN31);

					// AST REWRITE
					// elements: rel, FOREACH, foreach_plan_simple, parallel_clause, foreach_plan_complex
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 236:21: -> ^( FOREACH rel ( foreach_plan_complex )? ( foreach_plan_simple )? ) ( parallel_clause )?
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:236:24: ^( FOREACH rel ( foreach_plan_complex )? ( foreach_plan_simple )? )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot(stream_FOREACH.nextNode(), root_1);
						adaptor.addChild(root_1, stream_rel.nextTree());
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:236:39: ( foreach_plan_complex )?
						if ( stream_foreach_plan_complex.hasNext() ) {
							adaptor.addChild(root_1, stream_foreach_plan_complex.nextTree());
						}
						stream_foreach_plan_complex.reset();

						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:236:61: ( foreach_plan_simple )?
						if ( stream_foreach_plan_simple.hasNext() ) {
							adaptor.addChild(root_1, stream_foreach_plan_simple.nextTree());
						}
						stream_foreach_plan_simple.reset();

						adaptor.addChild(root_0, root_1);
						}

						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:236:84: ( parallel_clause )?
						if ( stream_parallel_clause.hasNext() ) {
							adaptor.addChild(root_0, stream_parallel_clause.nextTree());
						}
						stream_parallel_clause.reset();

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "nested_op_clause"


	public static class general_statement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "general_statement"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:239:1: general_statement : ( FAT_ARROW ( ( op_clause ( parallel_clause )? ) | nested_op_clause ) -> ^( STATEMENT IDENTIFIER[\"____RESERVED____\"] ( op_clause )? ( parallel_clause )? ( nested_op_clause )? ) | ( identifier_plus EQUAL )? ( ( op_clause ( parallel_clause )? ) | nested_op_clause ) -> ^( STATEMENT ( identifier_plus )? ( op_clause )? ( parallel_clause )? ( nested_op_clause )? ) );
	public final QueryParser.general_statement_return general_statement() throws RecognitionException {
		QueryParser.general_statement_return retval = new QueryParser.general_statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token FAT_ARROW32=null;
		Token EQUAL37=null;
		ParserRuleReturnScope op_clause33 =null;
		ParserRuleReturnScope parallel_clause34 =null;
		ParserRuleReturnScope nested_op_clause35 =null;
		ParserRuleReturnScope identifier_plus36 =null;
		ParserRuleReturnScope op_clause38 =null;
		ParserRuleReturnScope parallel_clause39 =null;
		ParserRuleReturnScope nested_op_clause40 =null;

		Object FAT_ARROW32_tree=null;
		Object EQUAL37_tree=null;
		RewriteRuleTokenStream stream_FAT_ARROW=new RewriteRuleTokenStream(adaptor,"token FAT_ARROW");
		RewriteRuleTokenStream stream_EQUAL=new RewriteRuleTokenStream(adaptor,"token EQUAL");
		RewriteRuleSubtreeStream stream_op_clause=new RewriteRuleSubtreeStream(adaptor,"rule op_clause");
		RewriteRuleSubtreeStream stream_parallel_clause=new RewriteRuleSubtreeStream(adaptor,"rule parallel_clause");
		RewriteRuleSubtreeStream stream_identifier_plus=new RewriteRuleSubtreeStream(adaptor,"rule identifier_plus");
		RewriteRuleSubtreeStream stream_nested_op_clause=new RewriteRuleSubtreeStream(adaptor,"rule nested_op_clause");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:239:19: ( FAT_ARROW ( ( op_clause ( parallel_clause )? ) | nested_op_clause ) -> ^( STATEMENT IDENTIFIER[\"____RESERVED____\"] ( op_clause )? ( parallel_clause )? ( nested_op_clause )? ) | ( identifier_plus EQUAL )? ( ( op_clause ( parallel_clause )? ) | nested_op_clause ) -> ^( STATEMENT ( identifier_plus )? ( op_clause )? ( parallel_clause )? ( nested_op_clause )? ) )
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==FAT_ARROW) ) {
				alt12=1;
			}
			else if ( (LA12_0==COGROUP||(LA12_0 >= CROSS && LA12_0 <= CUBE)||LA12_0==DEFINE||LA12_0==DISTINCT||(LA12_0 >= ELSE && LA12_0 <= END)||LA12_0==FILTER||LA12_0==GROUP||LA12_0==IDENTIFIER||LA12_0==IN||LA12_0==JOIN||LA12_0==LEFT_PAREN||(LA12_0 >= LIMIT && LA12_0 <= LOAD)||LA12_0==MAPREDUCE||LA12_0==ORDER||LA12_0==RANK||LA12_0==SAMPLE||(LA12_0 >= STORE && LA12_0 <= STREAM)||LA12_0==THEN||LA12_0==UNION||LA12_0==WHEN) ) {
				alt12=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:239:21: FAT_ARROW ( ( op_clause ( parallel_clause )? ) | nested_op_clause )
					{
					FAT_ARROW32=(Token)match(input,FAT_ARROW,FOLLOW_FAT_ARROW_in_general_statement738); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_FAT_ARROW.add(FAT_ARROW32);

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:239:31: ( ( op_clause ( parallel_clause )? ) | nested_op_clause )
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==COGROUP||(LA8_0 >= CROSS && LA8_0 <= CUBE)||LA8_0==DEFINE||LA8_0==DISTINCT||LA8_0==FILTER||LA8_0==GROUP||LA8_0==JOIN||(LA8_0 >= LIMIT && LA8_0 <= LOAD)||LA8_0==MAPREDUCE||LA8_0==ORDER||LA8_0==RANK||LA8_0==SAMPLE||(LA8_0 >= STORE && LA8_0 <= STREAM)||LA8_0==UNION) ) {
						alt8=1;
					}
					else if ( (LA8_0==LEFT_PAREN) ) {
						alt8=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 8, 0, input);
						throw nvae;
					}

					switch (alt8) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:239:33: ( op_clause ( parallel_clause )? )
							{
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:239:33: ( op_clause ( parallel_clause )? )
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:239:35: op_clause ( parallel_clause )?
							{
							pushFollow(FOLLOW_op_clause_in_general_statement744);
							op_clause33=op_clause();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_op_clause.add(op_clause33.getTree());
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:239:45: ( parallel_clause )?
							int alt7=2;
							int LA7_0 = input.LA(1);
							if ( (LA7_0==PARALLEL) ) {
								alt7=1;
							}
							switch (alt7) {
								case 1 :
									// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:239:45: parallel_clause
									{
									pushFollow(FOLLOW_parallel_clause_in_general_statement746);
									parallel_clause34=parallel_clause();
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) stream_parallel_clause.add(parallel_clause34.getTree());
									}
									break;

							}

							}

							}
							break;
						case 2 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:239:66: nested_op_clause
							{
							pushFollow(FOLLOW_nested_op_clause_in_general_statement753);
							nested_op_clause35=nested_op_clause();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_nested_op_clause.add(nested_op_clause35.getTree());
							}
							break;

					}

					// AST REWRITE
					// elements: parallel_clause, op_clause, nested_op_clause
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 239:85: -> ^( STATEMENT IDENTIFIER[\"____RESERVED____\"] ( op_clause )? ( parallel_clause )? ( nested_op_clause )? )
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:239:88: ^( STATEMENT IDENTIFIER[\"____RESERVED____\"] ( op_clause )? ( parallel_clause )? ( nested_op_clause )? )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STATEMENT, "STATEMENT"), root_1);
						adaptor.addChild(root_1, (Object)adaptor.create(IDENTIFIER, "____RESERVED____"));
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:239:132: ( op_clause )?
						if ( stream_op_clause.hasNext() ) {
							adaptor.addChild(root_1, stream_op_clause.nextTree());
						}
						stream_op_clause.reset();

						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:239:143: ( parallel_clause )?
						if ( stream_parallel_clause.hasNext() ) {
							adaptor.addChild(root_1, stream_parallel_clause.nextTree());
						}
						stream_parallel_clause.reset();

						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:239:160: ( nested_op_clause )?
						if ( stream_nested_op_clause.hasNext() ) {
							adaptor.addChild(root_1, stream_nested_op_clause.nextTree());
						}
						stream_nested_op_clause.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:240:21: ( identifier_plus EQUAL )? ( ( op_clause ( parallel_clause )? ) | nested_op_clause )
					{
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:240:21: ( identifier_plus EQUAL )?
					int alt9=2;
					switch ( input.LA(1) ) {
						case ELSE:
						case END:
						case IDENTIFIER:
						case IN:
						case THEN:
						case WHEN:
							{
							alt9=1;
							}
							break;
						case CUBE:
							{
							int LA9_2 = input.LA(2);
							if ( (LA9_2==EQUAL) ) {
								alt9=1;
							}
							}
							break;
						case RANK:
							{
							int LA9_4 = input.LA(2);
							if ( (LA9_4==EQUAL) ) {
								alt9=1;
							}
							}
							break;
					}
					switch (alt9) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:240:23: identifier_plus EQUAL
							{
							pushFollow(FOLLOW_identifier_plus_in_general_statement799);
							identifier_plus36=identifier_plus();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_identifier_plus.add(identifier_plus36.getTree());
							EQUAL37=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_general_statement801); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_EQUAL.add(EQUAL37);

							}
							break;

					}

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:240:48: ( ( op_clause ( parallel_clause )? ) | nested_op_clause )
					int alt11=2;
					int LA11_0 = input.LA(1);
					if ( (LA11_0==COGROUP||(LA11_0 >= CROSS && LA11_0 <= CUBE)||LA11_0==DEFINE||LA11_0==DISTINCT||LA11_0==FILTER||LA11_0==GROUP||LA11_0==JOIN||(LA11_0 >= LIMIT && LA11_0 <= LOAD)||LA11_0==MAPREDUCE||LA11_0==ORDER||LA11_0==RANK||LA11_0==SAMPLE||(LA11_0 >= STORE && LA11_0 <= STREAM)||LA11_0==UNION) ) {
						alt11=1;
					}
					else if ( (LA11_0==LEFT_PAREN) ) {
						alt11=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 11, 0, input);
						throw nvae;
					}

					switch (alt11) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:240:50: ( op_clause ( parallel_clause )? )
							{
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:240:50: ( op_clause ( parallel_clause )? )
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:240:52: op_clause ( parallel_clause )?
							{
							pushFollow(FOLLOW_op_clause_in_general_statement810);
							op_clause38=op_clause();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_op_clause.add(op_clause38.getTree());
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:240:62: ( parallel_clause )?
							int alt10=2;
							int LA10_0 = input.LA(1);
							if ( (LA10_0==PARALLEL) ) {
								alt10=1;
							}
							switch (alt10) {
								case 1 :
									// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:240:62: parallel_clause
									{
									pushFollow(FOLLOW_parallel_clause_in_general_statement812);
									parallel_clause39=parallel_clause();
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) stream_parallel_clause.add(parallel_clause39.getTree());
									}
									break;

							}

							}

							}
							break;
						case 2 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:240:83: nested_op_clause
							{
							pushFollow(FOLLOW_nested_op_clause_in_general_statement819);
							nested_op_clause40=nested_op_clause();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_nested_op_clause.add(nested_op_clause40.getTree());
							}
							break;

					}

					// AST REWRITE
					// elements: identifier_plus, nested_op_clause, op_clause, parallel_clause
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 240:102: -> ^( STATEMENT ( identifier_plus )? ( op_clause )? ( parallel_clause )? ( nested_op_clause )? )
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:240:105: ^( STATEMENT ( identifier_plus )? ( op_clause )? ( parallel_clause )? ( nested_op_clause )? )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STATEMENT, "STATEMENT"), root_1);
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:240:118: ( identifier_plus )?
						if ( stream_identifier_plus.hasNext() ) {
							adaptor.addChild(root_1, stream_identifier_plus.nextTree());
						}
						stream_identifier_plus.reset();

						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:240:135: ( op_clause )?
						if ( stream_op_clause.hasNext() ) {
							adaptor.addChild(root_1, stream_op_clause.nextTree());
						}
						stream_op_clause.reset();

						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:240:146: ( parallel_clause )?
						if ( stream_parallel_clause.hasNext() ) {
							adaptor.addChild(root_1, stream_parallel_clause.nextTree());
						}
						stream_parallel_clause.reset();

						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:240:163: ( nested_op_clause )?
						if ( stream_nested_op_clause.hasNext() ) {
							adaptor.addChild(root_1, stream_nested_op_clause.nextTree());
						}
						stream_nested_op_clause.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "general_statement"


	public static class foreach_statement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "foreach_statement"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:247:1: foreach_statement : ( FAT_ARROW FOREACH rel ( foreach_plan_complex | ( foreach_plan_simple ( parallel_clause )? SEMI_COLON ) ) -> ^( STATEMENT IDENTIFIER[\"____RESERVED____\"] ^( FOREACH rel ( foreach_plan_complex )? ( foreach_plan_simple )? ) ( parallel_clause )? ) | ( identifier_plus EQUAL )? FOREACH rel ( foreach_plan_complex | ( foreach_plan_simple ( parallel_clause )? SEMI_COLON ) ) -> ^( STATEMENT ( identifier_plus )? ^( FOREACH rel ( foreach_plan_complex )? ( foreach_plan_simple )? ) ( parallel_clause )? ) );
	public final QueryParser.foreach_statement_return foreach_statement() throws RecognitionException {
		QueryParser.foreach_statement_return retval = new QueryParser.foreach_statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token FAT_ARROW41=null;
		Token FOREACH42=null;
		Token SEMI_COLON47=null;
		Token EQUAL49=null;
		Token FOREACH50=null;
		Token SEMI_COLON55=null;
		ParserRuleReturnScope rel43 =null;
		ParserRuleReturnScope foreach_plan_complex44 =null;
		ParserRuleReturnScope foreach_plan_simple45 =null;
		ParserRuleReturnScope parallel_clause46 =null;
		ParserRuleReturnScope identifier_plus48 =null;
		ParserRuleReturnScope rel51 =null;
		ParserRuleReturnScope foreach_plan_complex52 =null;
		ParserRuleReturnScope foreach_plan_simple53 =null;
		ParserRuleReturnScope parallel_clause54 =null;

		Object FAT_ARROW41_tree=null;
		Object FOREACH42_tree=null;
		Object SEMI_COLON47_tree=null;
		Object EQUAL49_tree=null;
		Object FOREACH50_tree=null;
		Object SEMI_COLON55_tree=null;
		RewriteRuleTokenStream stream_FAT_ARROW=new RewriteRuleTokenStream(adaptor,"token FAT_ARROW");
		RewriteRuleTokenStream stream_EQUAL=new RewriteRuleTokenStream(adaptor,"token EQUAL");
		RewriteRuleTokenStream stream_SEMI_COLON=new RewriteRuleTokenStream(adaptor,"token SEMI_COLON");
		RewriteRuleTokenStream stream_FOREACH=new RewriteRuleTokenStream(adaptor,"token FOREACH");
		RewriteRuleSubtreeStream stream_parallel_clause=new RewriteRuleSubtreeStream(adaptor,"rule parallel_clause");
		RewriteRuleSubtreeStream stream_foreach_plan_simple=new RewriteRuleSubtreeStream(adaptor,"rule foreach_plan_simple");
		RewriteRuleSubtreeStream stream_identifier_plus=new RewriteRuleSubtreeStream(adaptor,"rule identifier_plus");
		RewriteRuleSubtreeStream stream_rel=new RewriteRuleSubtreeStream(adaptor,"rule rel");
		RewriteRuleSubtreeStream stream_foreach_plan_complex=new RewriteRuleSubtreeStream(adaptor,"rule foreach_plan_complex");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:247:19: ( FAT_ARROW FOREACH rel ( foreach_plan_complex | ( foreach_plan_simple ( parallel_clause )? SEMI_COLON ) ) -> ^( STATEMENT IDENTIFIER[\"____RESERVED____\"] ^( FOREACH rel ( foreach_plan_complex )? ( foreach_plan_simple )? ) ( parallel_clause )? ) | ( identifier_plus EQUAL )? FOREACH rel ( foreach_plan_complex | ( foreach_plan_simple ( parallel_clause )? SEMI_COLON ) ) -> ^( STATEMENT ( identifier_plus )? ^( FOREACH rel ( foreach_plan_complex )? ( foreach_plan_simple )? ) ( parallel_clause )? ) )
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==FAT_ARROW) ) {
				alt18=1;
			}
			else if ( (LA18_0==CUBE||(LA18_0 >= ELSE && LA18_0 <= END)||LA18_0==FOREACH||LA18_0==IDENTIFIER||LA18_0==IN||LA18_0==RANK||LA18_0==THEN||LA18_0==WHEN) ) {
				alt18=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}

			switch (alt18) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:247:21: FAT_ARROW FOREACH rel ( foreach_plan_complex | ( foreach_plan_simple ( parallel_clause )? SEMI_COLON ) )
					{
					FAT_ARROW41=(Token)match(input,FAT_ARROW,FOLLOW_FAT_ARROW_in_foreach_statement854); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_FAT_ARROW.add(FAT_ARROW41);

					FOREACH42=(Token)match(input,FOREACH,FOLLOW_FOREACH_in_foreach_statement856); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_FOREACH.add(FOREACH42);

					pushFollow(FOLLOW_rel_in_foreach_statement858);
					rel43=rel();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_rel.add(rel43.getTree());
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:247:43: ( foreach_plan_complex | ( foreach_plan_simple ( parallel_clause )? SEMI_COLON ) )
					int alt14=2;
					int LA14_0 = input.LA(1);
					if ( (LA14_0==LEFT_CURLY) ) {
						alt14=1;
					}
					else if ( (LA14_0==GENERATE) ) {
						alt14=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 14, 0, input);
						throw nvae;
					}

					switch (alt14) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:247:45: foreach_plan_complex
							{
							pushFollow(FOLLOW_foreach_plan_complex_in_foreach_statement862);
							foreach_plan_complex44=foreach_plan_complex();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_foreach_plan_complex.add(foreach_plan_complex44.getTree());
							}
							break;
						case 2 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:247:68: ( foreach_plan_simple ( parallel_clause )? SEMI_COLON )
							{
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:247:68: ( foreach_plan_simple ( parallel_clause )? SEMI_COLON )
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:247:70: foreach_plan_simple ( parallel_clause )? SEMI_COLON
							{
							pushFollow(FOLLOW_foreach_plan_simple_in_foreach_statement868);
							foreach_plan_simple45=foreach_plan_simple();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_foreach_plan_simple.add(foreach_plan_simple45.getTree());
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:247:90: ( parallel_clause )?
							int alt13=2;
							int LA13_0 = input.LA(1);
							if ( (LA13_0==PARALLEL) ) {
								alt13=1;
							}
							switch (alt13) {
								case 1 :
									// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:247:90: parallel_clause
									{
									pushFollow(FOLLOW_parallel_clause_in_foreach_statement870);
									parallel_clause46=parallel_clause();
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) stream_parallel_clause.add(parallel_clause46.getTree());
									}
									break;

							}

							SEMI_COLON47=(Token)match(input,SEMI_COLON,FOLLOW_SEMI_COLON_in_foreach_statement873); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_SEMI_COLON.add(SEMI_COLON47);

							}

							}
							break;

					}

					// AST REWRITE
					// elements: foreach_plan_complex, FOREACH, rel, foreach_plan_simple, parallel_clause
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 248:5: -> ^( STATEMENT IDENTIFIER[\"____RESERVED____\"] ^( FOREACH rel ( foreach_plan_complex )? ( foreach_plan_simple )? ) ( parallel_clause )? )
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:248:8: ^( STATEMENT IDENTIFIER[\"____RESERVED____\"] ^( FOREACH rel ( foreach_plan_complex )? ( foreach_plan_simple )? ) ( parallel_clause )? )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STATEMENT, "STATEMENT"), root_1);
						adaptor.addChild(root_1, (Object)adaptor.create(IDENTIFIER, "____RESERVED____"));
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:248:52: ^( FOREACH rel ( foreach_plan_complex )? ( foreach_plan_simple )? )
						{
						Object root_2 = (Object)adaptor.nil();
						root_2 = (Object)adaptor.becomeRoot(stream_FOREACH.nextNode(), root_2);
						adaptor.addChild(root_2, stream_rel.nextTree());
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:248:67: ( foreach_plan_complex )?
						if ( stream_foreach_plan_complex.hasNext() ) {
							adaptor.addChild(root_2, stream_foreach_plan_complex.nextTree());
						}
						stream_foreach_plan_complex.reset();

						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:248:89: ( foreach_plan_simple )?
						if ( stream_foreach_plan_simple.hasNext() ) {
							adaptor.addChild(root_2, stream_foreach_plan_simple.nextTree());
						}
						stream_foreach_plan_simple.reset();

						adaptor.addChild(root_1, root_2);
						}

						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:248:112: ( parallel_clause )?
						if ( stream_parallel_clause.hasNext() ) {
							adaptor.addChild(root_1, stream_parallel_clause.nextTree());
						}
						stream_parallel_clause.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:249:21: ( identifier_plus EQUAL )? FOREACH rel ( foreach_plan_complex | ( foreach_plan_simple ( parallel_clause )? SEMI_COLON ) )
					{
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:249:21: ( identifier_plus EQUAL )?
					int alt15=2;
					int LA15_0 = input.LA(1);
					if ( (LA15_0==CUBE||(LA15_0 >= ELSE && LA15_0 <= END)||LA15_0==IDENTIFIER||LA15_0==IN||LA15_0==RANK||LA15_0==THEN||LA15_0==WHEN) ) {
						alt15=1;
					}
					switch (alt15) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:249:23: identifier_plus EQUAL
							{
							pushFollow(FOLLOW_identifier_plus_in_foreach_statement933);
							identifier_plus48=identifier_plus();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_identifier_plus.add(identifier_plus48.getTree());
							EQUAL49=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_foreach_statement935); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_EQUAL.add(EQUAL49);

							}
							break;

					}

					FOREACH50=(Token)match(input,FOREACH,FOLLOW_FOREACH_in_foreach_statement940); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_FOREACH.add(FOREACH50);

					pushFollow(FOLLOW_rel_in_foreach_statement942);
					rel51=rel();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_rel.add(rel51.getTree());
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:249:60: ( foreach_plan_complex | ( foreach_plan_simple ( parallel_clause )? SEMI_COLON ) )
					int alt17=2;
					int LA17_0 = input.LA(1);
					if ( (LA17_0==LEFT_CURLY) ) {
						alt17=1;
					}
					else if ( (LA17_0==GENERATE) ) {
						alt17=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 17, 0, input);
						throw nvae;
					}

					switch (alt17) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:249:62: foreach_plan_complex
							{
							pushFollow(FOLLOW_foreach_plan_complex_in_foreach_statement946);
							foreach_plan_complex52=foreach_plan_complex();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_foreach_plan_complex.add(foreach_plan_complex52.getTree());
							}
							break;
						case 2 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:249:85: ( foreach_plan_simple ( parallel_clause )? SEMI_COLON )
							{
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:249:85: ( foreach_plan_simple ( parallel_clause )? SEMI_COLON )
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:249:87: foreach_plan_simple ( parallel_clause )? SEMI_COLON
							{
							pushFollow(FOLLOW_foreach_plan_simple_in_foreach_statement952);
							foreach_plan_simple53=foreach_plan_simple();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_foreach_plan_simple.add(foreach_plan_simple53.getTree());
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:249:107: ( parallel_clause )?
							int alt16=2;
							int LA16_0 = input.LA(1);
							if ( (LA16_0==PARALLEL) ) {
								alt16=1;
							}
							switch (alt16) {
								case 1 :
									// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:249:107: parallel_clause
									{
									pushFollow(FOLLOW_parallel_clause_in_foreach_statement954);
									parallel_clause54=parallel_clause();
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) stream_parallel_clause.add(parallel_clause54.getTree());
									}
									break;

							}

							SEMI_COLON55=(Token)match(input,SEMI_COLON,FOLLOW_SEMI_COLON_in_foreach_statement957); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_SEMI_COLON.add(SEMI_COLON55);

							}

							}
							break;

					}

					// AST REWRITE
					// elements: identifier_plus, foreach_plan_complex, rel, foreach_plan_simple, FOREACH, parallel_clause
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 250:5: -> ^( STATEMENT ( identifier_plus )? ^( FOREACH rel ( foreach_plan_complex )? ( foreach_plan_simple )? ) ( parallel_clause )? )
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:250:8: ^( STATEMENT ( identifier_plus )? ^( FOREACH rel ( foreach_plan_complex )? ( foreach_plan_simple )? ) ( parallel_clause )? )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STATEMENT, "STATEMENT"), root_1);
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:250:21: ( identifier_plus )?
						if ( stream_identifier_plus.hasNext() ) {
							adaptor.addChild(root_1, stream_identifier_plus.nextTree());
						}
						stream_identifier_plus.reset();

						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:250:38: ^( FOREACH rel ( foreach_plan_complex )? ( foreach_plan_simple )? )
						{
						Object root_2 = (Object)adaptor.nil();
						root_2 = (Object)adaptor.becomeRoot(stream_FOREACH.nextNode(), root_2);
						adaptor.addChild(root_2, stream_rel.nextTree());
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:250:53: ( foreach_plan_complex )?
						if ( stream_foreach_plan_complex.hasNext() ) {
							adaptor.addChild(root_2, stream_foreach_plan_complex.nextTree());
						}
						stream_foreach_plan_complex.reset();

						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:250:75: ( foreach_plan_simple )?
						if ( stream_foreach_plan_simple.hasNext() ) {
							adaptor.addChild(root_2, stream_foreach_plan_simple.nextTree());
						}
						stream_foreach_plan_simple.reset();

						adaptor.addChild(root_1, root_2);
						}

						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:250:98: ( parallel_clause )?
						if ( stream_parallel_clause.hasNext() ) {
							adaptor.addChild(root_1, stream_parallel_clause.nextTree());
						}
						stream_parallel_clause.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "foreach_statement"


	public static class foreach_plan_complex_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "foreach_plan_complex"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:253:1: foreach_plan_complex : LEFT_CURLY nested_blk RIGHT_CURLY -> ^( FOREACH_PLAN_COMPLEX nested_blk ) ;
	public final QueryParser.foreach_plan_complex_return foreach_plan_complex() throws RecognitionException {
		QueryParser.foreach_plan_complex_return retval = new QueryParser.foreach_plan_complex_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LEFT_CURLY56=null;
		Token RIGHT_CURLY58=null;
		ParserRuleReturnScope nested_blk57 =null;

		Object LEFT_CURLY56_tree=null;
		Object RIGHT_CURLY58_tree=null;
		RewriteRuleTokenStream stream_LEFT_CURLY=new RewriteRuleTokenStream(adaptor,"token LEFT_CURLY");
		RewriteRuleTokenStream stream_RIGHT_CURLY=new RewriteRuleTokenStream(adaptor,"token RIGHT_CURLY");
		RewriteRuleSubtreeStream stream_nested_blk=new RewriteRuleSubtreeStream(adaptor,"rule nested_blk");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:253:22: ( LEFT_CURLY nested_blk RIGHT_CURLY -> ^( FOREACH_PLAN_COMPLEX nested_blk ) )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:253:24: LEFT_CURLY nested_blk RIGHT_CURLY
			{
			LEFT_CURLY56=(Token)match(input,LEFT_CURLY,FOLLOW_LEFT_CURLY_in_foreach_plan_complex1002); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LEFT_CURLY.add(LEFT_CURLY56);

			pushFollow(FOLLOW_nested_blk_in_foreach_plan_complex1004);
			nested_blk57=nested_blk();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_nested_blk.add(nested_blk57.getTree());
			RIGHT_CURLY58=(Token)match(input,RIGHT_CURLY,FOLLOW_RIGHT_CURLY_in_foreach_plan_complex1006); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RIGHT_CURLY.add(RIGHT_CURLY58);

			// AST REWRITE
			// elements: nested_blk
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 253:58: -> ^( FOREACH_PLAN_COMPLEX nested_blk )
			{
				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:253:61: ^( FOREACH_PLAN_COMPLEX nested_blk )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FOREACH_PLAN_COMPLEX, "FOREACH_PLAN_COMPLEX"), root_1);
				adaptor.addChild(root_1, stream_nested_blk.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "foreach_plan_complex"


	public static class foreach_plan_simple_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "foreach_plan_simple"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:256:1: foreach_plan_simple : GENERATE flatten_generated_item ( COMMA flatten_generated_item )* -> ^( FOREACH_PLAN_SIMPLE ^( GENERATE ( flatten_generated_item )+ ) ) ;
	public final QueryParser.foreach_plan_simple_return foreach_plan_simple() throws RecognitionException {
		QueryParser.foreach_plan_simple_return retval = new QueryParser.foreach_plan_simple_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token GENERATE59=null;
		Token COMMA61=null;
		ParserRuleReturnScope flatten_generated_item60 =null;
		ParserRuleReturnScope flatten_generated_item62 =null;

		Object GENERATE59_tree=null;
		Object COMMA61_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleTokenStream stream_GENERATE=new RewriteRuleTokenStream(adaptor,"token GENERATE");
		RewriteRuleSubtreeStream stream_flatten_generated_item=new RewriteRuleSubtreeStream(adaptor,"rule flatten_generated_item");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:256:21: ( GENERATE flatten_generated_item ( COMMA flatten_generated_item )* -> ^( FOREACH_PLAN_SIMPLE ^( GENERATE ( flatten_generated_item )+ ) ) )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:256:23: GENERATE flatten_generated_item ( COMMA flatten_generated_item )*
			{
			GENERATE59=(Token)match(input,GENERATE,FOLLOW_GENERATE_in_foreach_plan_simple1025); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_GENERATE.add(GENERATE59);

			pushFollow(FOLLOW_flatten_generated_item_in_foreach_plan_simple1027);
			flatten_generated_item60=flatten_generated_item();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_flatten_generated_item.add(flatten_generated_item60.getTree());
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:256:55: ( COMMA flatten_generated_item )*
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==COMMA) ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:256:57: COMMA flatten_generated_item
					{
					COMMA61=(Token)match(input,COMMA,FOLLOW_COMMA_in_foreach_plan_simple1031); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COMMA.add(COMMA61);

					pushFollow(FOLLOW_flatten_generated_item_in_foreach_plan_simple1033);
					flatten_generated_item62=flatten_generated_item();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_flatten_generated_item.add(flatten_generated_item62.getTree());
					}
					break;

				default :
					break loop19;
				}
			}

			// AST REWRITE
			// elements: flatten_generated_item, GENERATE
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 256:89: -> ^( FOREACH_PLAN_SIMPLE ^( GENERATE ( flatten_generated_item )+ ) )
			{
				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:256:92: ^( FOREACH_PLAN_SIMPLE ^( GENERATE ( flatten_generated_item )+ ) )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FOREACH_PLAN_SIMPLE, "FOREACH_PLAN_SIMPLE"), root_1);
				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:256:115: ^( GENERATE ( flatten_generated_item )+ )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot(stream_GENERATE.nextNode(), root_2);
				if ( !(stream_flatten_generated_item.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_flatten_generated_item.hasNext() ) {
					adaptor.addChild(root_2, stream_flatten_generated_item.nextTree());
				}
				stream_flatten_generated_item.reset();

				adaptor.addChild(root_1, root_2);
				}

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "foreach_plan_simple"


	public static class macro_content_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "macro_content"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:261:1: macro_content : LEFT_CURLY ( macro_content |~ ( LEFT_CURLY | RIGHT_CURLY ) )* RIGHT_CURLY ;
	public final QueryParser.macro_content_return macro_content() throws RecognitionException {
		QueryParser.macro_content_return retval = new QueryParser.macro_content_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LEFT_CURLY63=null;
		Token set65=null;
		Token RIGHT_CURLY66=null;
		ParserRuleReturnScope macro_content64 =null;

		Object LEFT_CURLY63_tree=null;
		Object set65_tree=null;
		Object RIGHT_CURLY66_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:261:15: ( LEFT_CURLY ( macro_content |~ ( LEFT_CURLY | RIGHT_CURLY ) )* RIGHT_CURLY )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:261:17: LEFT_CURLY ( macro_content |~ ( LEFT_CURLY | RIGHT_CURLY ) )* RIGHT_CURLY
			{
			root_0 = (Object)adaptor.nil();


			LEFT_CURLY63=(Token)match(input,LEFT_CURLY,FOLLOW_LEFT_CURLY_in_macro_content1064); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LEFT_CURLY63_tree = (Object)adaptor.create(LEFT_CURLY63);
			adaptor.addChild(root_0, LEFT_CURLY63_tree);
			}

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:261:28: ( macro_content |~ ( LEFT_CURLY | RIGHT_CURLY ) )*
			loop20:
			while (true) {
				int alt20=3;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==LEFT_CURLY) ) {
					alt20=1;
				}
				else if ( ((LA20_0 >= ALL && LA20_0 <= LEFT_BRACKET)||(LA20_0 >= LEFT_PAREN && LA20_0 <= RIGHT_BRACKET)||(LA20_0 >= RIGHT_PAREN && LA20_0 <= TUPLE_VAL)) ) {
					alt20=2;
				}

				switch (alt20) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:261:30: macro_content
					{
					pushFollow(FOLLOW_macro_content_in_macro_content1068);
					macro_content64=macro_content();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, macro_content64.getTree());

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:261:46: ~ ( LEFT_CURLY | RIGHT_CURLY )
					{
					set65=input.LT(1);
					if ( (input.LA(1) >= ALL && input.LA(1) <= LEFT_BRACKET)||(input.LA(1) >= LEFT_PAREN && input.LA(1) <= RIGHT_BRACKET)||(input.LA(1) >= RIGHT_PAREN && input.LA(1) <= TUPLE_VAL) ) {
						input.consume();
						if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set65));
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

				default :
					break loop20;
				}
			}

			RIGHT_CURLY66=(Token)match(input,RIGHT_CURLY,FOLLOW_RIGHT_CURLY_in_macro_content1084); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RIGHT_CURLY66_tree = (Object)adaptor.create(RIGHT_CURLY66);
			adaptor.addChild(root_0, RIGHT_CURLY66_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "macro_content"


	public static class macro_param_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "macro_param_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:264:1: macro_param_clause : LEFT_PAREN ( identifier_plus ( COMMA identifier_plus )* )? RIGHT_PAREN -> ^( PARAMS ( identifier_plus )* ) ;
	public final QueryParser.macro_param_clause_return macro_param_clause() throws RecognitionException {
		QueryParser.macro_param_clause_return retval = new QueryParser.macro_param_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LEFT_PAREN67=null;
		Token COMMA69=null;
		Token RIGHT_PAREN71=null;
		ParserRuleReturnScope identifier_plus68 =null;
		ParserRuleReturnScope identifier_plus70 =null;

		Object LEFT_PAREN67_tree=null;
		Object COMMA69_tree=null;
		Object RIGHT_PAREN71_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleTokenStream stream_RIGHT_PAREN=new RewriteRuleTokenStream(adaptor,"token RIGHT_PAREN");
		RewriteRuleTokenStream stream_LEFT_PAREN=new RewriteRuleTokenStream(adaptor,"token LEFT_PAREN");
		RewriteRuleSubtreeStream stream_identifier_plus=new RewriteRuleSubtreeStream(adaptor,"rule identifier_plus");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:264:20: ( LEFT_PAREN ( identifier_plus ( COMMA identifier_plus )* )? RIGHT_PAREN -> ^( PARAMS ( identifier_plus )* ) )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:264:22: LEFT_PAREN ( identifier_plus ( COMMA identifier_plus )* )? RIGHT_PAREN
			{
			LEFT_PAREN67=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_macro_param_clause1093); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LEFT_PAREN.add(LEFT_PAREN67);

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:264:33: ( identifier_plus ( COMMA identifier_plus )* )?
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==CUBE||(LA22_0 >= ELSE && LA22_0 <= END)||LA22_0==IDENTIFIER||LA22_0==IN||LA22_0==RANK||LA22_0==THEN||LA22_0==WHEN) ) {
				alt22=1;
			}
			switch (alt22) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:264:35: identifier_plus ( COMMA identifier_plus )*
					{
					pushFollow(FOLLOW_identifier_plus_in_macro_param_clause1097);
					identifier_plus68=identifier_plus();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_identifier_plus.add(identifier_plus68.getTree());
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:264:51: ( COMMA identifier_plus )*
					loop21:
					while (true) {
						int alt21=2;
						int LA21_0 = input.LA(1);
						if ( (LA21_0==COMMA) ) {
							alt21=1;
						}

						switch (alt21) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:264:52: COMMA identifier_plus
							{
							COMMA69=(Token)match(input,COMMA,FOLLOW_COMMA_in_macro_param_clause1100); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COMMA.add(COMMA69);

							pushFollow(FOLLOW_identifier_plus_in_macro_param_clause1102);
							identifier_plus70=identifier_plus();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_identifier_plus.add(identifier_plus70.getTree());
							}
							break;

						default :
							break loop21;
						}
					}

					}
					break;

			}

			RIGHT_PAREN71=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_macro_param_clause1109); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RIGHT_PAREN.add(RIGHT_PAREN71);

			// AST REWRITE
			// elements: identifier_plus
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 265:5: -> ^( PARAMS ( identifier_plus )* )
			{
				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:265:8: ^( PARAMS ( identifier_plus )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PARAMS, "PARAMS"), root_1);
				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:265:17: ( identifier_plus )*
				while ( stream_identifier_plus.hasNext() ) {
					adaptor.addChild(root_1, stream_identifier_plus.nextTree());
				}
				stream_identifier_plus.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "macro_param_clause"


	public static class macro_return_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "macro_return_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:268:1: macro_return_clause : RETURNS ( ( identifier_plus ( COMMA identifier_plus )* ) | VOID ) -> ^( RETURN_VAL ( identifier_plus )* ) ;
	public final QueryParser.macro_return_clause_return macro_return_clause() throws RecognitionException {
		QueryParser.macro_return_clause_return retval = new QueryParser.macro_return_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token RETURNS72=null;
		Token COMMA74=null;
		Token VOID76=null;
		ParserRuleReturnScope identifier_plus73 =null;
		ParserRuleReturnScope identifier_plus75 =null;

		Object RETURNS72_tree=null;
		Object COMMA74_tree=null;
		Object VOID76_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleTokenStream stream_RETURNS=new RewriteRuleTokenStream(adaptor,"token RETURNS");
		RewriteRuleTokenStream stream_VOID=new RewriteRuleTokenStream(adaptor,"token VOID");
		RewriteRuleSubtreeStream stream_identifier_plus=new RewriteRuleSubtreeStream(adaptor,"rule identifier_plus");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:269:5: ( RETURNS ( ( identifier_plus ( COMMA identifier_plus )* ) | VOID ) -> ^( RETURN_VAL ( identifier_plus )* ) )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:269:7: RETURNS ( ( identifier_plus ( COMMA identifier_plus )* ) | VOID )
			{
			RETURNS72=(Token)match(input,RETURNS,FOLLOW_RETURNS_in_macro_return_clause1135); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RETURNS.add(RETURNS72);

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:269:15: ( ( identifier_plus ( COMMA identifier_plus )* ) | VOID )
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( (LA24_0==CUBE||(LA24_0 >= ELSE && LA24_0 <= END)||LA24_0==IDENTIFIER||LA24_0==IN||LA24_0==RANK||LA24_0==THEN||LA24_0==WHEN) ) {
				alt24=1;
			}
			else if ( (LA24_0==VOID) ) {
				alt24=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 24, 0, input);
				throw nvae;
			}

			switch (alt24) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:269:16: ( identifier_plus ( COMMA identifier_plus )* )
					{
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:269:16: ( identifier_plus ( COMMA identifier_plus )* )
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:269:17: identifier_plus ( COMMA identifier_plus )*
					{
					pushFollow(FOLLOW_identifier_plus_in_macro_return_clause1139);
					identifier_plus73=identifier_plus();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_identifier_plus.add(identifier_plus73.getTree());
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:269:33: ( COMMA identifier_plus )*
					loop23:
					while (true) {
						int alt23=2;
						int LA23_0 = input.LA(1);
						if ( (LA23_0==COMMA) ) {
							alt23=1;
						}

						switch (alt23) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:269:34: COMMA identifier_plus
							{
							COMMA74=(Token)match(input,COMMA,FOLLOW_COMMA_in_macro_return_clause1142); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COMMA.add(COMMA74);

							pushFollow(FOLLOW_identifier_plus_in_macro_return_clause1144);
							identifier_plus75=identifier_plus();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_identifier_plus.add(identifier_plus75.getTree());
							}
							break;

						default :
							break loop23;
						}
					}

					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:269:61: VOID
					{
					VOID76=(Token)match(input,VOID,FOLLOW_VOID_in_macro_return_clause1151); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_VOID.add(VOID76);

					}
					break;

			}

			// AST REWRITE
			// elements: identifier_plus
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 270:9: -> ^( RETURN_VAL ( identifier_plus )* )
			{
				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:270:12: ^( RETURN_VAL ( identifier_plus )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(RETURN_VAL, "RETURN_VAL"), root_1);
				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:270:25: ( identifier_plus )*
				while ( stream_identifier_plus.hasNext() ) {
					adaptor.addChild(root_1, stream_identifier_plus.nextTree());
				}
				stream_identifier_plus.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "macro_return_clause"


	public static class macro_body_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "macro_body_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:273:1: macro_body_clause : macro_content -> ^( MACRO_BODY ) ;
	public final QueryParser.macro_body_clause_return macro_body_clause() throws RecognitionException {
		QueryParser.macro_body_clause_return retval = new QueryParser.macro_body_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope macro_content77 =null;

		RewriteRuleSubtreeStream stream_macro_content=new RewriteRuleSubtreeStream(adaptor,"rule macro_content");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:273:19: ( macro_content -> ^( MACRO_BODY ) )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:273:21: macro_content
			{
			pushFollow(FOLLOW_macro_content_in_macro_body_clause1178);
			macro_content77=macro_content();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_macro_content.add(macro_content77.getTree());
			// AST REWRITE
			// elements: 
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 273:35: -> ^( MACRO_BODY )
			{
				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:273:38: ^( MACRO_BODY )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MACRO_BODY, "MACRO_BODY"), root_1);
				adaptor.addChild(root_1,  new LatinParserNode(new CommonToken(1, (macro_content77!=null?input.toString(macro_content77.start,macro_content77.stop):null)), this.getSourceName(), (macro_content77!=null?(macro_content77.start):null)) );
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "macro_body_clause"


	public static class macro_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "macro_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:276:1: macro_clause : macro_param_clause macro_return_clause macro_body_clause -> ^( MACRO_DEF macro_param_clause macro_return_clause macro_body_clause ) ;
	public final QueryParser.macro_clause_return macro_clause() throws RecognitionException {
		QueryParser.macro_clause_return retval = new QueryParser.macro_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope macro_param_clause78 =null;
		ParserRuleReturnScope macro_return_clause79 =null;
		ParserRuleReturnScope macro_body_clause80 =null;

		RewriteRuleSubtreeStream stream_macro_param_clause=new RewriteRuleSubtreeStream(adaptor,"rule macro_param_clause");
		RewriteRuleSubtreeStream stream_macro_return_clause=new RewriteRuleSubtreeStream(adaptor,"rule macro_return_clause");
		RewriteRuleSubtreeStream stream_macro_body_clause=new RewriteRuleSubtreeStream(adaptor,"rule macro_body_clause");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:276:14: ( macro_param_clause macro_return_clause macro_body_clause -> ^( MACRO_DEF macro_param_clause macro_return_clause macro_body_clause ) )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:276:16: macro_param_clause macro_return_clause macro_body_clause
			{
			pushFollow(FOLLOW_macro_param_clause_in_macro_clause1196);
			macro_param_clause78=macro_param_clause();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_macro_param_clause.add(macro_param_clause78.getTree());
			pushFollow(FOLLOW_macro_return_clause_in_macro_clause1198);
			macro_return_clause79=macro_return_clause();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_macro_return_clause.add(macro_return_clause79.getTree());
			pushFollow(FOLLOW_macro_body_clause_in_macro_clause1200);
			macro_body_clause80=macro_body_clause();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_macro_body_clause.add(macro_body_clause80.getTree());
			// AST REWRITE
			// elements: macro_body_clause, macro_param_clause, macro_return_clause
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 277:5: -> ^( MACRO_DEF macro_param_clause macro_return_clause macro_body_clause )
			{
				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:277:8: ^( MACRO_DEF macro_param_clause macro_return_clause macro_body_clause )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MACRO_DEF, "MACRO_DEF"), root_1);
				adaptor.addChild(root_1, stream_macro_param_clause.nextTree());
				adaptor.addChild(root_1, stream_macro_return_clause.nextTree());
				adaptor.addChild(root_1, stream_macro_body_clause.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "macro_clause"


	public static class inline_return_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "inline_return_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:280:1: inline_return_clause : ( identifier_plus EQUAL -> ^( RETURN_VAL identifier_plus ) | identifier_plus ( COMMA identifier_plus )+ EQUAL -> ^( RETURN_VAL ( identifier_plus )+ ) | -> ^( RETURN_VAL ) );
	public final QueryParser.inline_return_clause_return inline_return_clause() throws RecognitionException {
		QueryParser.inline_return_clause_return retval = new QueryParser.inline_return_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token EQUAL82=null;
		Token COMMA84=null;
		Token EQUAL86=null;
		ParserRuleReturnScope identifier_plus81 =null;
		ParserRuleReturnScope identifier_plus83 =null;
		ParserRuleReturnScope identifier_plus85 =null;

		Object EQUAL82_tree=null;
		Object COMMA84_tree=null;
		Object EQUAL86_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleTokenStream stream_EQUAL=new RewriteRuleTokenStream(adaptor,"token EQUAL");
		RewriteRuleSubtreeStream stream_identifier_plus=new RewriteRuleSubtreeStream(adaptor,"rule identifier_plus");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:281:5: ( identifier_plus EQUAL -> ^( RETURN_VAL identifier_plus ) | identifier_plus ( COMMA identifier_plus )+ EQUAL -> ^( RETURN_VAL ( identifier_plus )+ ) | -> ^( RETURN_VAL ) )
			int alt26=3;
			int LA26_0 = input.LA(1);
			if ( (LA26_0==IDENTIFIER) ) {
				switch ( input.LA(2) ) {
				case EQUAL:
					{
					alt26=1;
					}
					break;
				case COMMA:
					{
					alt26=2;
					}
					break;
				case LEFT_PAREN:
					{
					alt26=3;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 26, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}
			else if ( (LA26_0==CUBE||(LA26_0 >= ELSE && LA26_0 <= END)||LA26_0==IN||LA26_0==RANK||LA26_0==THEN||LA26_0==WHEN) ) {
				switch ( input.LA(2) ) {
				case EQUAL:
					{
					alt26=1;
					}
					break;
				case COMMA:
					{
					alt26=2;
					}
					break;
				case LEFT_PAREN:
					{
					alt26=3;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 26, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 26, 0, input);
				throw nvae;
			}

			switch (alt26) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:281:7: identifier_plus EQUAL
					{
					pushFollow(FOLLOW_identifier_plus_in_inline_return_clause1229);
					identifier_plus81=identifier_plus();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_identifier_plus.add(identifier_plus81.getTree());
					EQUAL82=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_inline_return_clause1231); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_EQUAL.add(EQUAL82);

					// AST REWRITE
					// elements: identifier_plus
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 281:29: -> ^( RETURN_VAL identifier_plus )
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:281:32: ^( RETURN_VAL identifier_plus )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(RETURN_VAL, "RETURN_VAL"), root_1);
						adaptor.addChild(root_1, stream_identifier_plus.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:282:4: identifier_plus ( COMMA identifier_plus )+ EQUAL
					{
					pushFollow(FOLLOW_identifier_plus_in_inline_return_clause1244);
					identifier_plus83=identifier_plus();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_identifier_plus.add(identifier_plus83.getTree());
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:282:20: ( COMMA identifier_plus )+
					int cnt25=0;
					loop25:
					while (true) {
						int alt25=2;
						int LA25_0 = input.LA(1);
						if ( (LA25_0==COMMA) ) {
							alt25=1;
						}

						switch (alt25) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:282:21: COMMA identifier_plus
							{
							COMMA84=(Token)match(input,COMMA,FOLLOW_COMMA_in_inline_return_clause1247); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COMMA.add(COMMA84);

							pushFollow(FOLLOW_identifier_plus_in_inline_return_clause1249);
							identifier_plus85=identifier_plus();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_identifier_plus.add(identifier_plus85.getTree());
							}
							break;

						default :
							if ( cnt25 >= 1 ) break loop25;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(25, input);
							throw eee;
						}
						cnt25++;
					}

					EQUAL86=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_inline_return_clause1253); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_EQUAL.add(EQUAL86);

					// AST REWRITE
					// elements: identifier_plus
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 282:51: -> ^( RETURN_VAL ( identifier_plus )+ )
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:282:54: ^( RETURN_VAL ( identifier_plus )+ )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(RETURN_VAL, "RETURN_VAL"), root_1);
						if ( !(stream_identifier_plus.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_identifier_plus.hasNext() ) {
							adaptor.addChild(root_1, stream_identifier_plus.nextTree());
						}
						stream_identifier_plus.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:283:4: 
					{
					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 283:4: -> ^( RETURN_VAL )
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:283:7: ^( RETURN_VAL )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(RETURN_VAL, "RETURN_VAL"), root_1);
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "inline_return_clause"


	public static class parameter_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "parameter"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:286:1: parameter : ( IDENTIFIER | INTEGER | DOUBLENUMBER | BIGDECIMALNUMBER | BIGINTEGERNUMBER | QUOTEDSTRING | DOLLARVAR );
	public final QueryParser.parameter_return parameter() throws RecognitionException {
		QueryParser.parameter_return retval = new QueryParser.parameter_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set87=null;

		Object set87_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:287:5: ( IDENTIFIER | INTEGER | DOUBLENUMBER | BIGDECIMALNUMBER | BIGINTEGERNUMBER | QUOTEDSTRING | DOLLARVAR )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:
			{
			root_0 = (Object)adaptor.nil();


			set87=input.LT(1);
			if ( input.LA(1)==BIGDECIMALNUMBER||input.LA(1)==BIGINTEGERNUMBER||input.LA(1)==DOLLARVAR||input.LA(1)==DOUBLENUMBER||input.LA(1)==IDENTIFIER||input.LA(1)==INTEGER||input.LA(1)==QUOTEDSTRING ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set87));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "parameter"


	public static class inline_param_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "inline_param_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:296:1: inline_param_clause : LEFT_PAREN ( parameter ( COMMA parameter )* )? RIGHT_PAREN -> ^( PARAMS ( parameter )* ) ;
	public final QueryParser.inline_param_clause_return inline_param_clause() throws RecognitionException {
		QueryParser.inline_param_clause_return retval = new QueryParser.inline_param_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LEFT_PAREN88=null;
		Token COMMA90=null;
		Token RIGHT_PAREN92=null;
		ParserRuleReturnScope parameter89 =null;
		ParserRuleReturnScope parameter91 =null;

		Object LEFT_PAREN88_tree=null;
		Object COMMA90_tree=null;
		Object RIGHT_PAREN92_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleTokenStream stream_RIGHT_PAREN=new RewriteRuleTokenStream(adaptor,"token RIGHT_PAREN");
		RewriteRuleTokenStream stream_LEFT_PAREN=new RewriteRuleTokenStream(adaptor,"token LEFT_PAREN");
		RewriteRuleSubtreeStream stream_parameter=new RewriteRuleSubtreeStream(adaptor,"rule parameter");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:296:21: ( LEFT_PAREN ( parameter ( COMMA parameter )* )? RIGHT_PAREN -> ^( PARAMS ( parameter )* ) )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:296:23: LEFT_PAREN ( parameter ( COMMA parameter )* )? RIGHT_PAREN
			{
			LEFT_PAREN88=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_inline_param_clause1341); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LEFT_PAREN.add(LEFT_PAREN88);

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:296:34: ( parameter ( COMMA parameter )* )?
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0==BIGDECIMALNUMBER||LA28_0==BIGINTEGERNUMBER||LA28_0==DOLLARVAR||LA28_0==DOUBLENUMBER||LA28_0==IDENTIFIER||LA28_0==INTEGER||LA28_0==QUOTEDSTRING) ) {
				alt28=1;
			}
			switch (alt28) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:296:36: parameter ( COMMA parameter )*
					{
					pushFollow(FOLLOW_parameter_in_inline_param_clause1345);
					parameter89=parameter();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_parameter.add(parameter89.getTree());
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:296:46: ( COMMA parameter )*
					loop27:
					while (true) {
						int alt27=2;
						int LA27_0 = input.LA(1);
						if ( (LA27_0==COMMA) ) {
							alt27=1;
						}

						switch (alt27) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:296:47: COMMA parameter
							{
							COMMA90=(Token)match(input,COMMA,FOLLOW_COMMA_in_inline_param_clause1348); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COMMA.add(COMMA90);

							pushFollow(FOLLOW_parameter_in_inline_param_clause1350);
							parameter91=parameter();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_parameter.add(parameter91.getTree());
							}
							break;

						default :
							break loop27;
						}
					}

					}
					break;

			}

			RIGHT_PAREN92=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_inline_param_clause1357); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RIGHT_PAREN.add(RIGHT_PAREN92);

			// AST REWRITE
			// elements: parameter
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 297:5: -> ^( PARAMS ( parameter )* )
			{
				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:297:8: ^( PARAMS ( parameter )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PARAMS, "PARAMS"), root_1);
				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:297:17: ( parameter )*
				while ( stream_parameter.hasNext() ) {
					adaptor.addChild(root_1, stream_parameter.nextTree());
				}
				stream_parameter.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "inline_param_clause"


	public static class inline_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "inline_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:300:1: inline_clause : inline_return_clause identifier_plus inline_param_clause -> ^( MACRO_INLINE identifier_plus inline_return_clause inline_param_clause ) ;
	public final QueryParser.inline_clause_return inline_clause() throws RecognitionException {
		QueryParser.inline_clause_return retval = new QueryParser.inline_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope inline_return_clause93 =null;
		ParserRuleReturnScope identifier_plus94 =null;
		ParserRuleReturnScope inline_param_clause95 =null;

		RewriteRuleSubtreeStream stream_identifier_plus=new RewriteRuleSubtreeStream(adaptor,"rule identifier_plus");
		RewriteRuleSubtreeStream stream_inline_return_clause=new RewriteRuleSubtreeStream(adaptor,"rule inline_return_clause");
		RewriteRuleSubtreeStream stream_inline_param_clause=new RewriteRuleSubtreeStream(adaptor,"rule inline_param_clause");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:300:15: ( inline_return_clause identifier_plus inline_param_clause -> ^( MACRO_INLINE identifier_plus inline_return_clause inline_param_clause ) )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:300:17: inline_return_clause identifier_plus inline_param_clause
			{
			pushFollow(FOLLOW_inline_return_clause_in_inline_clause1379);
			inline_return_clause93=inline_return_clause();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_inline_return_clause.add(inline_return_clause93.getTree());
			pushFollow(FOLLOW_identifier_plus_in_inline_clause1381);
			identifier_plus94=identifier_plus();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_identifier_plus.add(identifier_plus94.getTree());
			pushFollow(FOLLOW_inline_param_clause_in_inline_clause1383);
			inline_param_clause95=inline_param_clause();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_inline_param_clause.add(inline_param_clause95.getTree());
			// AST REWRITE
			// elements: inline_param_clause, inline_return_clause, identifier_plus
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 301:5: -> ^( MACRO_INLINE identifier_plus inline_return_clause inline_param_clause )
			{
				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:301:8: ^( MACRO_INLINE identifier_plus inline_return_clause inline_param_clause )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MACRO_INLINE, "MACRO_INLINE"), root_1);
				adaptor.addChild(root_1, stream_identifier_plus.nextTree());
				adaptor.addChild(root_1, stream_inline_return_clause.nextTree());
				adaptor.addChild(root_1, stream_inline_param_clause.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "inline_clause"


	public static class simple_type_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "simple_type"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:306:1: simple_type : ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | DATETIME | BIGINTEGER | BIGDECIMAL | CHARARRAY | BYTEARRAY );
	public final QueryParser.simple_type_return simple_type() throws RecognitionException {
		QueryParser.simple_type_return retval = new QueryParser.simple_type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set96=null;

		Object set96_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:306:13: ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | DATETIME | BIGINTEGER | BIGDECIMAL | CHARARRAY | BYTEARRAY )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:
			{
			root_0 = (Object)adaptor.nil();


			set96=input.LT(1);
			if ( input.LA(1)==BIGDECIMAL||input.LA(1)==BIGINTEGER||input.LA(1)==BOOLEAN||input.LA(1)==BYTEARRAY||input.LA(1)==CHARARRAY||input.LA(1)==DATETIME||input.LA(1)==DOUBLE||input.LA(1)==FLOAT||input.LA(1)==INT||input.LA(1)==LONG ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set96));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "simple_type"


	public static class implicit_tuple_type_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "implicit_tuple_type"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:309:1: implicit_tuple_type : LEFT_PAREN ( field_def_list )? RIGHT_PAREN -> ^( TUPLE_TYPE ( field_def_list )? ) ;
	public final QueryParser.implicit_tuple_type_return implicit_tuple_type() throws RecognitionException {
		QueryParser.implicit_tuple_type_return retval = new QueryParser.implicit_tuple_type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LEFT_PAREN97=null;
		Token RIGHT_PAREN99=null;
		ParserRuleReturnScope field_def_list98 =null;

		Object LEFT_PAREN97_tree=null;
		Object RIGHT_PAREN99_tree=null;
		RewriteRuleTokenStream stream_RIGHT_PAREN=new RewriteRuleTokenStream(adaptor,"token RIGHT_PAREN");
		RewriteRuleTokenStream stream_LEFT_PAREN=new RewriteRuleTokenStream(adaptor,"token LEFT_PAREN");
		RewriteRuleSubtreeStream stream_field_def_list=new RewriteRuleSubtreeStream(adaptor,"rule field_def_list");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:309:21: ( LEFT_PAREN ( field_def_list )? RIGHT_PAREN -> ^( TUPLE_TYPE ( field_def_list )? ) )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:309:23: LEFT_PAREN ( field_def_list )? RIGHT_PAREN
			{
			LEFT_PAREN97=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_implicit_tuple_type1455); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LEFT_PAREN.add(LEFT_PAREN97);

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:309:34: ( field_def_list )?
			int alt29=2;
			int LA29_0 = input.LA(1);
			if ( ((LA29_0 >= BAG && LA29_0 <= BIGDECIMAL)||LA29_0==BIGINTEGER||LA29_0==BOOLEAN||LA29_0==BYTEARRAY||LA29_0==CHARARRAY||(LA29_0 >= CUBE && LA29_0 <= DATETIME)||LA29_0==DOUBLE||(LA29_0 >= ELSE && LA29_0 <= END)||LA29_0==FLOAT||LA29_0==IDENTIFIER||LA29_0==IN||LA29_0==INT||(LA29_0 >= LEFT_BRACKET && LA29_0 <= LEFT_PAREN)||LA29_0==LONG||LA29_0==MAP||LA29_0==RANK||LA29_0==THEN||LA29_0==TUPLE||LA29_0==WHEN) ) {
				alt29=1;
			}
			switch (alt29) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:309:34: field_def_list
					{
					pushFollow(FOLLOW_field_def_list_in_implicit_tuple_type1457);
					field_def_list98=field_def_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_field_def_list.add(field_def_list98.getTree());
					}
					break;

			}

			RIGHT_PAREN99=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_implicit_tuple_type1460); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RIGHT_PAREN.add(RIGHT_PAREN99);

			// AST REWRITE
			// elements: field_def_list
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 309:62: -> ^( TUPLE_TYPE ( field_def_list )? )
			{
				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:309:65: ^( TUPLE_TYPE ( field_def_list )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TUPLE_TYPE, "TUPLE_TYPE"), root_1);
				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:309:79: ( field_def_list )?
				if ( stream_field_def_list.hasNext() ) {
					adaptor.addChild(root_1, stream_field_def_list.nextTree());
				}
				stream_field_def_list.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "implicit_tuple_type"


	public static class explicit_tuple_type_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "explicit_tuple_type"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:312:1: explicit_tuple_type : TUPLE ! implicit_tuple_type ;
	public final QueryParser.explicit_tuple_type_return explicit_tuple_type() throws RecognitionException {
		QueryParser.explicit_tuple_type_return retval = new QueryParser.explicit_tuple_type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token TUPLE100=null;
		ParserRuleReturnScope implicit_tuple_type101 =null;

		Object TUPLE100_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:312:21: ( TUPLE ! implicit_tuple_type )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:312:23: TUPLE ! implicit_tuple_type
			{
			root_0 = (Object)adaptor.nil();


			TUPLE100=(Token)match(input,TUPLE,FOLLOW_TUPLE_in_explicit_tuple_type1480); if (state.failed) return retval;
			pushFollow(FOLLOW_implicit_tuple_type_in_explicit_tuple_type1483);
			implicit_tuple_type101=implicit_tuple_type();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, implicit_tuple_type101.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "explicit_tuple_type"


	public static class explicit_tuple_type_cast_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "explicit_tuple_type_cast"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:315:1: explicit_tuple_type_cast : TUPLE LEFT_PAREN ( explicit_type_cast ( COMMA explicit_type_cast )* )? RIGHT_PAREN -> ^( TUPLE_TYPE_CAST ( explicit_type_cast )* ) ;
	public final QueryParser.explicit_tuple_type_cast_return explicit_tuple_type_cast() throws RecognitionException {
		QueryParser.explicit_tuple_type_cast_return retval = new QueryParser.explicit_tuple_type_cast_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token TUPLE102=null;
		Token LEFT_PAREN103=null;
		Token COMMA105=null;
		Token RIGHT_PAREN107=null;
		ParserRuleReturnScope explicit_type_cast104 =null;
		ParserRuleReturnScope explicit_type_cast106 =null;

		Object TUPLE102_tree=null;
		Object LEFT_PAREN103_tree=null;
		Object COMMA105_tree=null;
		Object RIGHT_PAREN107_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleTokenStream stream_RIGHT_PAREN=new RewriteRuleTokenStream(adaptor,"token RIGHT_PAREN");
		RewriteRuleTokenStream stream_LEFT_PAREN=new RewriteRuleTokenStream(adaptor,"token LEFT_PAREN");
		RewriteRuleTokenStream stream_TUPLE=new RewriteRuleTokenStream(adaptor,"token TUPLE");
		RewriteRuleSubtreeStream stream_explicit_type_cast=new RewriteRuleSubtreeStream(adaptor,"rule explicit_type_cast");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:315:26: ( TUPLE LEFT_PAREN ( explicit_type_cast ( COMMA explicit_type_cast )* )? RIGHT_PAREN -> ^( TUPLE_TYPE_CAST ( explicit_type_cast )* ) )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:315:28: TUPLE LEFT_PAREN ( explicit_type_cast ( COMMA explicit_type_cast )* )? RIGHT_PAREN
			{
			TUPLE102=(Token)match(input,TUPLE,FOLLOW_TUPLE_in_explicit_tuple_type_cast1492); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_TUPLE.add(TUPLE102);

			LEFT_PAREN103=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_explicit_tuple_type_cast1494); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LEFT_PAREN.add(LEFT_PAREN103);

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:315:45: ( explicit_type_cast ( COMMA explicit_type_cast )* )?
			int alt31=2;
			int LA31_0 = input.LA(1);
			if ( ((LA31_0 >= BAG && LA31_0 <= BIGDECIMAL)||LA31_0==BIGINTEGER||LA31_0==BOOLEAN||LA31_0==BYTEARRAY||LA31_0==CHARARRAY||LA31_0==DATETIME||LA31_0==DOUBLE||LA31_0==FLOAT||LA31_0==INT||LA31_0==LONG||LA31_0==MAP||LA31_0==TUPLE) ) {
				alt31=1;
			}
			switch (alt31) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:315:47: explicit_type_cast ( COMMA explicit_type_cast )*
					{
					pushFollow(FOLLOW_explicit_type_cast_in_explicit_tuple_type_cast1498);
					explicit_type_cast104=explicit_type_cast();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_explicit_type_cast.add(explicit_type_cast104.getTree());
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:315:66: ( COMMA explicit_type_cast )*
					loop30:
					while (true) {
						int alt30=2;
						int LA30_0 = input.LA(1);
						if ( (LA30_0==COMMA) ) {
							alt30=1;
						}

						switch (alt30) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:315:68: COMMA explicit_type_cast
							{
							COMMA105=(Token)match(input,COMMA,FOLLOW_COMMA_in_explicit_tuple_type_cast1502); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COMMA.add(COMMA105);

							pushFollow(FOLLOW_explicit_type_cast_in_explicit_tuple_type_cast1504);
							explicit_type_cast106=explicit_type_cast();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_explicit_type_cast.add(explicit_type_cast106.getTree());
							}
							break;

						default :
							break loop30;
						}
					}

					}
					break;

			}

			RIGHT_PAREN107=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_explicit_tuple_type_cast1512); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RIGHT_PAREN.add(RIGHT_PAREN107);

			// AST REWRITE
			// elements: explicit_type_cast
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 316:5: -> ^( TUPLE_TYPE_CAST ( explicit_type_cast )* )
			{
				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:316:8: ^( TUPLE_TYPE_CAST ( explicit_type_cast )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TUPLE_TYPE_CAST, "TUPLE_TYPE_CAST"), root_1);
				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:316:27: ( explicit_type_cast )*
				while ( stream_explicit_type_cast.hasNext() ) {
					adaptor.addChild(root_1, stream_explicit_type_cast.nextTree());
				}
				stream_explicit_type_cast.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "explicit_tuple_type_cast"


	public static class tuple_type_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "tuple_type"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:319:1: tuple_type : ( implicit_tuple_type | explicit_tuple_type );
	public final QueryParser.tuple_type_return tuple_type() throws RecognitionException {
		QueryParser.tuple_type_return retval = new QueryParser.tuple_type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope implicit_tuple_type108 =null;
		ParserRuleReturnScope explicit_tuple_type109 =null;


		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:319:12: ( implicit_tuple_type | explicit_tuple_type )
			int alt32=2;
			int LA32_0 = input.LA(1);
			if ( (LA32_0==LEFT_PAREN) ) {
				alt32=1;
			}
			else if ( (LA32_0==TUPLE) ) {
				alt32=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 32, 0, input);
				throw nvae;
			}

			switch (alt32) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:319:14: implicit_tuple_type
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_implicit_tuple_type_in_tuple_type1536);
					implicit_tuple_type108=implicit_tuple_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, implicit_tuple_type108.getTree());

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:319:36: explicit_tuple_type
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_explicit_tuple_type_in_tuple_type1540);
					explicit_tuple_type109=explicit_tuple_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, explicit_tuple_type109.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tuple_type"


	public static class implicit_bag_type_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "implicit_bag_type"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:322:1: implicit_bag_type : ( LEFT_CURLY NULL COLON ( tuple_type )? RIGHT_CURLY -> ^( BAG_TYPE ( tuple_type )? ) | LEFT_CURLY ( ( identifier_plus COLON )? tuple_type )? RIGHT_CURLY -> ^( BAG_TYPE ( identifier_plus )? ( tuple_type )? ) );
	public final QueryParser.implicit_bag_type_return implicit_bag_type() throws RecognitionException {
		QueryParser.implicit_bag_type_return retval = new QueryParser.implicit_bag_type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LEFT_CURLY110=null;
		Token NULL111=null;
		Token COLON112=null;
		Token RIGHT_CURLY114=null;
		Token LEFT_CURLY115=null;
		Token COLON117=null;
		Token RIGHT_CURLY119=null;
		ParserRuleReturnScope tuple_type113 =null;
		ParserRuleReturnScope identifier_plus116 =null;
		ParserRuleReturnScope tuple_type118 =null;

		Object LEFT_CURLY110_tree=null;
		Object NULL111_tree=null;
		Object COLON112_tree=null;
		Object RIGHT_CURLY114_tree=null;
		Object LEFT_CURLY115_tree=null;
		Object COLON117_tree=null;
		Object RIGHT_CURLY119_tree=null;
		RewriteRuleTokenStream stream_NULL=new RewriteRuleTokenStream(adaptor,"token NULL");
		RewriteRuleTokenStream stream_LEFT_CURLY=new RewriteRuleTokenStream(adaptor,"token LEFT_CURLY");
		RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
		RewriteRuleTokenStream stream_RIGHT_CURLY=new RewriteRuleTokenStream(adaptor,"token RIGHT_CURLY");
		RewriteRuleSubtreeStream stream_identifier_plus=new RewriteRuleSubtreeStream(adaptor,"rule identifier_plus");
		RewriteRuleSubtreeStream stream_tuple_type=new RewriteRuleSubtreeStream(adaptor,"rule tuple_type");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:322:19: ( LEFT_CURLY NULL COLON ( tuple_type )? RIGHT_CURLY -> ^( BAG_TYPE ( tuple_type )? ) | LEFT_CURLY ( ( identifier_plus COLON )? tuple_type )? RIGHT_CURLY -> ^( BAG_TYPE ( identifier_plus )? ( tuple_type )? ) )
			int alt36=2;
			int LA36_0 = input.LA(1);
			if ( (LA36_0==LEFT_CURLY) ) {
				int LA36_1 = input.LA(2);
				if ( (LA36_1==NULL) ) {
					alt36=1;
				}
				else if ( (LA36_1==CUBE||(LA36_1 >= ELSE && LA36_1 <= END)||LA36_1==IDENTIFIER||LA36_1==IN||LA36_1==LEFT_PAREN||LA36_1==RANK||LA36_1==RIGHT_CURLY||LA36_1==THEN||LA36_1==TUPLE||LA36_1==WHEN) ) {
					alt36=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 36, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 36, 0, input);
				throw nvae;
			}

			switch (alt36) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:322:21: LEFT_CURLY NULL COLON ( tuple_type )? RIGHT_CURLY
					{
					LEFT_CURLY110=(Token)match(input,LEFT_CURLY,FOLLOW_LEFT_CURLY_in_implicit_bag_type1549); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LEFT_CURLY.add(LEFT_CURLY110);

					NULL111=(Token)match(input,NULL,FOLLOW_NULL_in_implicit_bag_type1551); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NULL.add(NULL111);

					COLON112=(Token)match(input,COLON,FOLLOW_COLON_in_implicit_bag_type1553); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COLON.add(COLON112);

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:322:43: ( tuple_type )?
					int alt33=2;
					int LA33_0 = input.LA(1);
					if ( (LA33_0==LEFT_PAREN||LA33_0==TUPLE) ) {
						alt33=1;
					}
					switch (alt33) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:322:43: tuple_type
							{
							pushFollow(FOLLOW_tuple_type_in_implicit_bag_type1555);
							tuple_type113=tuple_type();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_tuple_type.add(tuple_type113.getTree());
							}
							break;

					}

					RIGHT_CURLY114=(Token)match(input,RIGHT_CURLY,FOLLOW_RIGHT_CURLY_in_implicit_bag_type1558); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RIGHT_CURLY.add(RIGHT_CURLY114);

					// AST REWRITE
					// elements: tuple_type
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 322:67: -> ^( BAG_TYPE ( tuple_type )? )
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:322:70: ^( BAG_TYPE ( tuple_type )? )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BAG_TYPE, "BAG_TYPE"), root_1);
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:322:82: ( tuple_type )?
						if ( stream_tuple_type.hasNext() ) {
							adaptor.addChild(root_1, stream_tuple_type.nextTree());
						}
						stream_tuple_type.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:323:21: LEFT_CURLY ( ( identifier_plus COLON )? tuple_type )? RIGHT_CURLY
					{
					LEFT_CURLY115=(Token)match(input,LEFT_CURLY,FOLLOW_LEFT_CURLY_in_implicit_bag_type1591); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LEFT_CURLY.add(LEFT_CURLY115);

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:323:32: ( ( identifier_plus COLON )? tuple_type )?
					int alt35=2;
					int LA35_0 = input.LA(1);
					if ( (LA35_0==CUBE||(LA35_0 >= ELSE && LA35_0 <= END)||LA35_0==IDENTIFIER||LA35_0==IN||LA35_0==LEFT_PAREN||LA35_0==RANK||LA35_0==THEN||LA35_0==TUPLE||LA35_0==WHEN) ) {
						alt35=1;
					}
					switch (alt35) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:323:34: ( identifier_plus COLON )? tuple_type
							{
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:323:34: ( identifier_plus COLON )?
							int alt34=2;
							int LA34_0 = input.LA(1);
							if ( (LA34_0==CUBE||(LA34_0 >= ELSE && LA34_0 <= END)||LA34_0==IDENTIFIER||LA34_0==IN||LA34_0==RANK||LA34_0==THEN||LA34_0==WHEN) ) {
								alt34=1;
							}
							switch (alt34) {
								case 1 :
									// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:323:36: identifier_plus COLON
									{
									pushFollow(FOLLOW_identifier_plus_in_implicit_bag_type1597);
									identifier_plus116=identifier_plus();
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) stream_identifier_plus.add(identifier_plus116.getTree());
									COLON117=(Token)match(input,COLON,FOLLOW_COLON_in_implicit_bag_type1599); if (state.failed) return retval; 
									if ( state.backtracking==0 ) stream_COLON.add(COLON117);

									}
									break;

							}

							pushFollow(FOLLOW_tuple_type_in_implicit_bag_type1604);
							tuple_type118=tuple_type();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_tuple_type.add(tuple_type118.getTree());
							}
							break;

					}

					RIGHT_CURLY119=(Token)match(input,RIGHT_CURLY,FOLLOW_RIGHT_CURLY_in_implicit_bag_type1609); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RIGHT_CURLY.add(RIGHT_CURLY119);

					// AST REWRITE
					// elements: identifier_plus, tuple_type
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 323:87: -> ^( BAG_TYPE ( identifier_plus )? ( tuple_type )? )
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:323:90: ^( BAG_TYPE ( identifier_plus )? ( tuple_type )? )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BAG_TYPE, "BAG_TYPE"), root_1);
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:323:102: ( identifier_plus )?
						if ( stream_identifier_plus.hasNext() ) {
							adaptor.addChild(root_1, stream_identifier_plus.nextTree());
						}
						stream_identifier_plus.reset();

						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:323:119: ( tuple_type )?
						if ( stream_tuple_type.hasNext() ) {
							adaptor.addChild(root_1, stream_tuple_type.nextTree());
						}
						stream_tuple_type.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "implicit_bag_type"


	public static class explicit_bag_type_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "explicit_bag_type"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:326:1: explicit_bag_type : BAG ! implicit_bag_type ;
	public final QueryParser.explicit_bag_type_return explicit_bag_type() throws RecognitionException {
		QueryParser.explicit_bag_type_return retval = new QueryParser.explicit_bag_type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token BAG120=null;
		ParserRuleReturnScope implicit_bag_type121 =null;

		Object BAG120_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:326:19: ( BAG ! implicit_bag_type )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:326:21: BAG ! implicit_bag_type
			{
			root_0 = (Object)adaptor.nil();


			BAG120=(Token)match(input,BAG,FOLLOW_BAG_in_explicit_bag_type1632); if (state.failed) return retval;
			pushFollow(FOLLOW_implicit_bag_type_in_explicit_bag_type1635);
			implicit_bag_type121=implicit_bag_type();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, implicit_bag_type121.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "explicit_bag_type"


	public static class explicit_bag_type_cast_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "explicit_bag_type_cast"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:329:1: explicit_bag_type_cast : BAG LEFT_CURLY ( explicit_tuple_type_cast )? RIGHT_CURLY -> ^( BAG_TYPE_CAST ( explicit_tuple_type_cast )? ) ;
	public final QueryParser.explicit_bag_type_cast_return explicit_bag_type_cast() throws RecognitionException {
		QueryParser.explicit_bag_type_cast_return retval = new QueryParser.explicit_bag_type_cast_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token BAG122=null;
		Token LEFT_CURLY123=null;
		Token RIGHT_CURLY125=null;
		ParserRuleReturnScope explicit_tuple_type_cast124 =null;

		Object BAG122_tree=null;
		Object LEFT_CURLY123_tree=null;
		Object RIGHT_CURLY125_tree=null;
		RewriteRuleTokenStream stream_LEFT_CURLY=new RewriteRuleTokenStream(adaptor,"token LEFT_CURLY");
		RewriteRuleTokenStream stream_BAG=new RewriteRuleTokenStream(adaptor,"token BAG");
		RewriteRuleTokenStream stream_RIGHT_CURLY=new RewriteRuleTokenStream(adaptor,"token RIGHT_CURLY");
		RewriteRuleSubtreeStream stream_explicit_tuple_type_cast=new RewriteRuleSubtreeStream(adaptor,"rule explicit_tuple_type_cast");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:329:24: ( BAG LEFT_CURLY ( explicit_tuple_type_cast )? RIGHT_CURLY -> ^( BAG_TYPE_CAST ( explicit_tuple_type_cast )? ) )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:329:26: BAG LEFT_CURLY ( explicit_tuple_type_cast )? RIGHT_CURLY
			{
			BAG122=(Token)match(input,BAG,FOLLOW_BAG_in_explicit_bag_type_cast1644); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_BAG.add(BAG122);

			LEFT_CURLY123=(Token)match(input,LEFT_CURLY,FOLLOW_LEFT_CURLY_in_explicit_bag_type_cast1646); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LEFT_CURLY.add(LEFT_CURLY123);

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:329:41: ( explicit_tuple_type_cast )?
			int alt37=2;
			int LA37_0 = input.LA(1);
			if ( (LA37_0==TUPLE) ) {
				alt37=1;
			}
			switch (alt37) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:329:41: explicit_tuple_type_cast
					{
					pushFollow(FOLLOW_explicit_tuple_type_cast_in_explicit_bag_type_cast1648);
					explicit_tuple_type_cast124=explicit_tuple_type_cast();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_explicit_tuple_type_cast.add(explicit_tuple_type_cast124.getTree());
					}
					break;

			}

			RIGHT_CURLY125=(Token)match(input,RIGHT_CURLY,FOLLOW_RIGHT_CURLY_in_explicit_bag_type_cast1651); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RIGHT_CURLY.add(RIGHT_CURLY125);

			// AST REWRITE
			// elements: explicit_tuple_type_cast
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 329:79: -> ^( BAG_TYPE_CAST ( explicit_tuple_type_cast )? )
			{
				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:329:82: ^( BAG_TYPE_CAST ( explicit_tuple_type_cast )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BAG_TYPE_CAST, "BAG_TYPE_CAST"), root_1);
				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:329:99: ( explicit_tuple_type_cast )?
				if ( stream_explicit_tuple_type_cast.hasNext() ) {
					adaptor.addChild(root_1, stream_explicit_tuple_type_cast.nextTree());
				}
				stream_explicit_tuple_type_cast.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "explicit_bag_type_cast"


	public static class implicit_map_type_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "implicit_map_type"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:332:1: implicit_map_type : LEFT_BRACKET ( ( identifier_plus COLON )? type )? RIGHT_BRACKET -> ^( MAP_TYPE ( identifier_plus )? ( type )? ) ;
	public final QueryParser.implicit_map_type_return implicit_map_type() throws RecognitionException {
		QueryParser.implicit_map_type_return retval = new QueryParser.implicit_map_type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LEFT_BRACKET126=null;
		Token COLON128=null;
		Token RIGHT_BRACKET130=null;
		ParserRuleReturnScope identifier_plus127 =null;
		ParserRuleReturnScope type129 =null;

		Object LEFT_BRACKET126_tree=null;
		Object COLON128_tree=null;
		Object RIGHT_BRACKET130_tree=null;
		RewriteRuleTokenStream stream_RIGHT_BRACKET=new RewriteRuleTokenStream(adaptor,"token RIGHT_BRACKET");
		RewriteRuleTokenStream stream_LEFT_BRACKET=new RewriteRuleTokenStream(adaptor,"token LEFT_BRACKET");
		RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
		RewriteRuleSubtreeStream stream_identifier_plus=new RewriteRuleSubtreeStream(adaptor,"rule identifier_plus");
		RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:332:19: ( LEFT_BRACKET ( ( identifier_plus COLON )? type )? RIGHT_BRACKET -> ^( MAP_TYPE ( identifier_plus )? ( type )? ) )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:332:21: LEFT_BRACKET ( ( identifier_plus COLON )? type )? RIGHT_BRACKET
			{
			LEFT_BRACKET126=(Token)match(input,LEFT_BRACKET,FOLLOW_LEFT_BRACKET_in_implicit_map_type1671); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LEFT_BRACKET.add(LEFT_BRACKET126);

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:332:34: ( ( identifier_plus COLON )? type )?
			int alt39=2;
			int LA39_0 = input.LA(1);
			if ( ((LA39_0 >= BAG && LA39_0 <= BIGDECIMAL)||LA39_0==BIGINTEGER||LA39_0==BOOLEAN||LA39_0==BYTEARRAY||LA39_0==CHARARRAY||(LA39_0 >= CUBE && LA39_0 <= DATETIME)||LA39_0==DOUBLE||(LA39_0 >= ELSE && LA39_0 <= END)||LA39_0==FLOAT||LA39_0==IDENTIFIER||LA39_0==IN||LA39_0==INT||(LA39_0 >= LEFT_BRACKET && LA39_0 <= LEFT_PAREN)||LA39_0==LONG||LA39_0==MAP||LA39_0==RANK||LA39_0==THEN||LA39_0==TUPLE||LA39_0==WHEN) ) {
				alt39=1;
			}
			switch (alt39) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:332:36: ( identifier_plus COLON )? type
					{
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:332:36: ( identifier_plus COLON )?
					int alt38=2;
					int LA38_0 = input.LA(1);
					if ( (LA38_0==CUBE||(LA38_0 >= ELSE && LA38_0 <= END)||LA38_0==IDENTIFIER||LA38_0==IN||LA38_0==RANK||LA38_0==THEN||LA38_0==WHEN) ) {
						alt38=1;
					}
					switch (alt38) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:332:38: identifier_plus COLON
							{
							pushFollow(FOLLOW_identifier_plus_in_implicit_map_type1677);
							identifier_plus127=identifier_plus();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_identifier_plus.add(identifier_plus127.getTree());
							COLON128=(Token)match(input,COLON,FOLLOW_COLON_in_implicit_map_type1679); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COLON.add(COLON128);

							}
							break;

					}

					pushFollow(FOLLOW_type_in_implicit_map_type1684);
					type129=type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_type.add(type129.getTree());
					}
					break;

			}

			RIGHT_BRACKET130=(Token)match(input,RIGHT_BRACKET,FOLLOW_RIGHT_BRACKET_in_implicit_map_type1689); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RIGHT_BRACKET.add(RIGHT_BRACKET130);

			// AST REWRITE
			// elements: type, identifier_plus
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 332:85: -> ^( MAP_TYPE ( identifier_plus )? ( type )? )
			{
				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:332:88: ^( MAP_TYPE ( identifier_plus )? ( type )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MAP_TYPE, "MAP_TYPE"), root_1);
				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:332:100: ( identifier_plus )?
				if ( stream_identifier_plus.hasNext() ) {
					adaptor.addChild(root_1, stream_identifier_plus.nextTree());
				}
				stream_identifier_plus.reset();

				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:332:117: ( type )?
				if ( stream_type.hasNext() ) {
					adaptor.addChild(root_1, stream_type.nextTree());
				}
				stream_type.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "implicit_map_type"


	public static class explicit_map_type_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "explicit_map_type"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:335:1: explicit_map_type : MAP ! implicit_map_type ;
	public final QueryParser.explicit_map_type_return explicit_map_type() throws RecognitionException {
		QueryParser.explicit_map_type_return retval = new QueryParser.explicit_map_type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token MAP131=null;
		ParserRuleReturnScope implicit_map_type132 =null;

		Object MAP131_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:335:19: ( MAP ! implicit_map_type )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:335:21: MAP ! implicit_map_type
			{
			root_0 = (Object)adaptor.nil();


			MAP131=(Token)match(input,MAP,FOLLOW_MAP_in_explicit_map_type1712); if (state.failed) return retval;
			pushFollow(FOLLOW_implicit_map_type_in_explicit_map_type1715);
			implicit_map_type132=implicit_map_type();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, implicit_map_type132.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "explicit_map_type"


	public static class map_type_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "map_type"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:338:1: map_type : ( implicit_map_type | explicit_map_type );
	public final QueryParser.map_type_return map_type() throws RecognitionException {
		QueryParser.map_type_return retval = new QueryParser.map_type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope implicit_map_type133 =null;
		ParserRuleReturnScope explicit_map_type134 =null;


		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:338:10: ( implicit_map_type | explicit_map_type )
			int alt40=2;
			int LA40_0 = input.LA(1);
			if ( (LA40_0==LEFT_BRACKET) ) {
				alt40=1;
			}
			else if ( (LA40_0==MAP) ) {
				alt40=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 40, 0, input);
				throw nvae;
			}

			switch (alt40) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:338:12: implicit_map_type
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_implicit_map_type_in_map_type1724);
					implicit_map_type133=implicit_map_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, implicit_map_type133.getTree());

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:338:32: explicit_map_type
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_explicit_map_type_in_map_type1728);
					explicit_map_type134=explicit_map_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, explicit_map_type134.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "map_type"


	public static class explicit_type_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "explicit_type"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:341:1: explicit_type : ( simple_type | explicit_tuple_type | explicit_bag_type | explicit_map_type );
	public final QueryParser.explicit_type_return explicit_type() throws RecognitionException {
		QueryParser.explicit_type_return retval = new QueryParser.explicit_type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope simple_type135 =null;
		ParserRuleReturnScope explicit_tuple_type136 =null;
		ParserRuleReturnScope explicit_bag_type137 =null;
		ParserRuleReturnScope explicit_map_type138 =null;


		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:341:15: ( simple_type | explicit_tuple_type | explicit_bag_type | explicit_map_type )
			int alt41=4;
			switch ( input.LA(1) ) {
			case BIGDECIMAL:
			case BIGINTEGER:
			case BOOLEAN:
			case BYTEARRAY:
			case CHARARRAY:
			case DATETIME:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
				{
				alt41=1;
				}
				break;
			case TUPLE:
				{
				alt41=2;
				}
				break;
			case BAG:
				{
				alt41=3;
				}
				break;
			case MAP:
				{
				alt41=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 41, 0, input);
				throw nvae;
			}
			switch (alt41) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:341:17: simple_type
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_simple_type_in_explicit_type1737);
					simple_type135=simple_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, simple_type135.getTree());

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:341:31: explicit_tuple_type
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_explicit_tuple_type_in_explicit_type1741);
					explicit_tuple_type136=explicit_tuple_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, explicit_tuple_type136.getTree());

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:341:53: explicit_bag_type
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_explicit_bag_type_in_explicit_type1745);
					explicit_bag_type137=explicit_bag_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, explicit_bag_type137.getTree());

					}
					break;
				case 4 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:341:73: explicit_map_type
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_explicit_map_type_in_explicit_type1749);
					explicit_map_type138=explicit_map_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, explicit_map_type138.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "explicit_type"


	public static class implicit_type_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "implicit_type"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:344:1: implicit_type : ( implicit_tuple_type | implicit_bag_type | implicit_map_type );
	public final QueryParser.implicit_type_return implicit_type() throws RecognitionException {
		QueryParser.implicit_type_return retval = new QueryParser.implicit_type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope implicit_tuple_type139 =null;
		ParserRuleReturnScope implicit_bag_type140 =null;
		ParserRuleReturnScope implicit_map_type141 =null;


		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:344:15: ( implicit_tuple_type | implicit_bag_type | implicit_map_type )
			int alt42=3;
			switch ( input.LA(1) ) {
			case LEFT_PAREN:
				{
				alt42=1;
				}
				break;
			case LEFT_CURLY:
				{
				alt42=2;
				}
				break;
			case LEFT_BRACKET:
				{
				alt42=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 42, 0, input);
				throw nvae;
			}
			switch (alt42) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:344:17: implicit_tuple_type
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_implicit_tuple_type_in_implicit_type1758);
					implicit_tuple_type139=implicit_tuple_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, implicit_tuple_type139.getTree());

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:344:39: implicit_bag_type
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_implicit_bag_type_in_implicit_type1762);
					implicit_bag_type140=implicit_bag_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, implicit_bag_type140.getTree());

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:344:59: implicit_map_type
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_implicit_map_type_in_implicit_type1766);
					implicit_map_type141=implicit_map_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, implicit_map_type141.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "implicit_type"


	public static class type_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "type"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:347:1: type : ( explicit_type | implicit_type );
	public final QueryParser.type_return type() throws RecognitionException {
		QueryParser.type_return retval = new QueryParser.type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope explicit_type142 =null;
		ParserRuleReturnScope implicit_type143 =null;


		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:347:6: ( explicit_type | implicit_type )
			int alt43=2;
			int LA43_0 = input.LA(1);
			if ( ((LA43_0 >= BAG && LA43_0 <= BIGDECIMAL)||LA43_0==BIGINTEGER||LA43_0==BOOLEAN||LA43_0==BYTEARRAY||LA43_0==CHARARRAY||LA43_0==DATETIME||LA43_0==DOUBLE||LA43_0==FLOAT||LA43_0==INT||LA43_0==LONG||LA43_0==MAP||LA43_0==TUPLE) ) {
				alt43=1;
			}
			else if ( ((LA43_0 >= LEFT_BRACKET && LA43_0 <= LEFT_PAREN)) ) {
				alt43=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 43, 0, input);
				throw nvae;
			}

			switch (alt43) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:347:8: explicit_type
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_explicit_type_in_type1775);
					explicit_type142=explicit_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, explicit_type142.getTree());

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:347:24: implicit_type
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_implicit_type_in_type1779);
					implicit_type143=implicit_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, implicit_type143.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "type"


	public static class explicit_type_cast_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "explicit_type_cast"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:350:1: explicit_type_cast : ( simple_type | explicit_map_type | explicit_tuple_type_cast | explicit_bag_type_cast );
	public final QueryParser.explicit_type_cast_return explicit_type_cast() throws RecognitionException {
		QueryParser.explicit_type_cast_return retval = new QueryParser.explicit_type_cast_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope simple_type144 =null;
		ParserRuleReturnScope explicit_map_type145 =null;
		ParserRuleReturnScope explicit_tuple_type_cast146 =null;
		ParserRuleReturnScope explicit_bag_type_cast147 =null;


		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:350:20: ( simple_type | explicit_map_type | explicit_tuple_type_cast | explicit_bag_type_cast )
			int alt44=4;
			switch ( input.LA(1) ) {
			case BIGDECIMAL:
			case BIGINTEGER:
			case BOOLEAN:
			case BYTEARRAY:
			case CHARARRAY:
			case DATETIME:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
				{
				alt44=1;
				}
				break;
			case MAP:
				{
				alt44=2;
				}
				break;
			case TUPLE:
				{
				alt44=3;
				}
				break;
			case BAG:
				{
				alt44=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 44, 0, input);
				throw nvae;
			}
			switch (alt44) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:350:22: simple_type
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_simple_type_in_explicit_type_cast1788);
					simple_type144=simple_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, simple_type144.getTree());

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:350:36: explicit_map_type
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_explicit_map_type_in_explicit_type_cast1792);
					explicit_map_type145=explicit_map_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, explicit_map_type145.getTree());

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:350:56: explicit_tuple_type_cast
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_explicit_tuple_type_cast_in_explicit_type_cast1796);
					explicit_tuple_type_cast146=explicit_tuple_type_cast();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, explicit_tuple_type_cast146.getTree());

					}
					break;
				case 4 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:350:83: explicit_bag_type_cast
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_explicit_bag_type_cast_in_explicit_type_cast1800);
					explicit_bag_type_cast147=explicit_bag_type_cast();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, explicit_bag_type_cast147.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "explicit_type_cast"


	public static class import_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "import_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:355:1: import_clause : IMPORT ^ QUOTEDSTRING ;
	public final QueryParser.import_clause_return import_clause() throws RecognitionException {
		QueryParser.import_clause_return retval = new QueryParser.import_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token IMPORT148=null;
		Token QUOTEDSTRING149=null;

		Object IMPORT148_tree=null;
		Object QUOTEDSTRING149_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:355:15: ( IMPORT ^ QUOTEDSTRING )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:355:17: IMPORT ^ QUOTEDSTRING
			{
			root_0 = (Object)adaptor.nil();


			IMPORT148=(Token)match(input,IMPORT,FOLLOW_IMPORT_in_import_clause1811); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			IMPORT148_tree = (Object)adaptor.create(IMPORT148);
			root_0 = (Object)adaptor.becomeRoot(IMPORT148_tree, root_0);
			}

			QUOTEDSTRING149=(Token)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_import_clause1814); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			QUOTEDSTRING149_tree = (Object)adaptor.create(QUOTEDSTRING149);
			adaptor.addChild(root_0, QUOTEDSTRING149_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "import_clause"


	public static class register_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "register_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:358:1: register_clause : REGISTER ^ QUOTEDSTRING ( USING identifier_plus AS identifier_plus )? ;
	public final QueryParser.register_clause_return register_clause() throws RecognitionException {
		QueryParser.register_clause_return retval = new QueryParser.register_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token REGISTER150=null;
		Token QUOTEDSTRING151=null;
		Token USING152=null;
		Token AS154=null;
		ParserRuleReturnScope identifier_plus153 =null;
		ParserRuleReturnScope identifier_plus155 =null;

		Object REGISTER150_tree=null;
		Object QUOTEDSTRING151_tree=null;
		Object USING152_tree=null;
		Object AS154_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:358:17: ( REGISTER ^ QUOTEDSTRING ( USING identifier_plus AS identifier_plus )? )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:358:19: REGISTER ^ QUOTEDSTRING ( USING identifier_plus AS identifier_plus )?
			{
			root_0 = (Object)adaptor.nil();


			REGISTER150=(Token)match(input,REGISTER,FOLLOW_REGISTER_in_register_clause1823); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			REGISTER150_tree = (Object)adaptor.create(REGISTER150);
			root_0 = (Object)adaptor.becomeRoot(REGISTER150_tree, root_0);
			}

			QUOTEDSTRING151=(Token)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_register_clause1826); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			QUOTEDSTRING151_tree = (Object)adaptor.create(QUOTEDSTRING151);
			adaptor.addChild(root_0, QUOTEDSTRING151_tree);
			}

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:358:42: ( USING identifier_plus AS identifier_plus )?
			int alt45=2;
			int LA45_0 = input.LA(1);
			if ( (LA45_0==USING) ) {
				alt45=1;
			}
			switch (alt45) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:358:43: USING identifier_plus AS identifier_plus
					{
					USING152=(Token)match(input,USING,FOLLOW_USING_in_register_clause1829); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					USING152_tree = (Object)adaptor.create(USING152);
					adaptor.addChild(root_0, USING152_tree);
					}

					pushFollow(FOLLOW_identifier_plus_in_register_clause1831);
					identifier_plus153=identifier_plus();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, identifier_plus153.getTree());

					AS154=(Token)match(input,AS,FOLLOW_AS_in_register_clause1833); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					AS154_tree = (Object)adaptor.create(AS154);
					adaptor.addChild(root_0, AS154_tree);
					}

					pushFollow(FOLLOW_identifier_plus_in_register_clause1835);
					identifier_plus155=identifier_plus();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, identifier_plus155.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "register_clause"


	public static class define_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "define_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:361:1: define_clause : DEFINE ^ IDENTIFIER ( cmd | func_clause | macro_clause ) ;
	public final QueryParser.define_clause_return define_clause() throws RecognitionException {
		QueryParser.define_clause_return retval = new QueryParser.define_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token DEFINE156=null;
		Token IDENTIFIER157=null;
		ParserRuleReturnScope cmd158 =null;
		ParserRuleReturnScope func_clause159 =null;
		ParserRuleReturnScope macro_clause160 =null;

		Object DEFINE156_tree=null;
		Object IDENTIFIER157_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:361:15: ( DEFINE ^ IDENTIFIER ( cmd | func_clause | macro_clause ) )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:361:17: DEFINE ^ IDENTIFIER ( cmd | func_clause | macro_clause )
			{
			root_0 = (Object)adaptor.nil();


			DEFINE156=(Token)match(input,DEFINE,FOLLOW_DEFINE_in_define_clause1846); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			DEFINE156_tree = (Object)adaptor.create(DEFINE156);
			root_0 = (Object)adaptor.becomeRoot(DEFINE156_tree, root_0);
			}

			IDENTIFIER157=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_define_clause1849); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			IDENTIFIER157_tree = (Object)adaptor.create(IDENTIFIER157);
			adaptor.addChild(root_0, IDENTIFIER157_tree);
			}

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:361:36: ( cmd | func_clause | macro_clause )
			int alt46=3;
			switch ( input.LA(1) ) {
			case EXECCOMMAND:
				{
				alt46=1;
				}
				break;
			case ALL:
			case AND:
			case AS:
			case ASC:
			case ASSERT:
			case BAG:
			case BIGDECIMAL:
			case BIGINTEGER:
			case BY:
			case BYTEARRAY:
			case CACHE:
			case CHARARRAY:
			case COGROUP:
			case CROSS:
			case CUBE:
			case DATETIME:
			case DEFINE:
			case DESC:
			case DISTINCT:
			case DOUBLE:
			case FALSE:
			case FILTER:
			case FLATTEN:
			case FLOAT:
			case FOREACH:
			case FULL:
			case GENERATE:
			case GROUP:
			case IDENTIFIER:
			case IF:
			case IMPORT:
			case INNER:
			case INPUT:
			case INT:
			case INTO:
			case IS:
			case JOIN:
			case LEFT:
			case LIMIT:
			case LOAD:
			case LONG:
			case MAP:
			case MAPREDUCE:
			case NOT:
			case NULL:
			case OR:
			case ORDER:
			case OUTER:
			case OUTPUT:
			case PARALLEL:
			case PARTITION:
			case REGISTER:
			case RETURNS:
			case RIGHT:
			case ROLLUP:
			case SAMPLE:
			case SHIP:
			case SPLIT:
			case STDERROR:
			case STDIN:
			case STDOUT:
			case STORE:
			case STREAM:
			case STR_OP_EQ:
			case STR_OP_GT:
			case STR_OP_GTE:
			case STR_OP_LT:
			case STR_OP_LTE:
			case STR_OP_MATCHES:
			case STR_OP_NE:
			case THROUGH:
			case TRUE:
			case TUPLE:
			case UNION:
			case USING:
			case BOOL:
			case BOOL_COND:
			case REALIAS:
				{
				alt46=2;
				}
				break;
			case LEFT_PAREN:
				{
				alt46=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 46, 0, input);
				throw nvae;
			}
			switch (alt46) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:361:38: cmd
					{
					pushFollow(FOLLOW_cmd_in_define_clause1853);
					cmd158=cmd();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, cmd158.getTree());

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:361:44: func_clause
					{
					pushFollow(FOLLOW_func_clause_in_define_clause1857);
					func_clause159=func_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, func_clause159.getTree());

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:361:58: macro_clause
					{
					pushFollow(FOLLOW_macro_clause_in_define_clause1861);
					macro_clause160=macro_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, macro_clause160.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "define_clause"


	public static class realias_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "realias_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:364:1: realias_clause : identifier_plus EQUAL identifier_plus -> ^( REALIAS identifier_plus identifier_plus ) ;
	public final QueryParser.realias_clause_return realias_clause() throws RecognitionException {
		QueryParser.realias_clause_return retval = new QueryParser.realias_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token EQUAL162=null;
		ParserRuleReturnScope identifier_plus161 =null;
		ParserRuleReturnScope identifier_plus163 =null;

		Object EQUAL162_tree=null;
		RewriteRuleTokenStream stream_EQUAL=new RewriteRuleTokenStream(adaptor,"token EQUAL");
		RewriteRuleSubtreeStream stream_identifier_plus=new RewriteRuleSubtreeStream(adaptor,"rule identifier_plus");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:364:16: ( identifier_plus EQUAL identifier_plus -> ^( REALIAS identifier_plus identifier_plus ) )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:364:18: identifier_plus EQUAL identifier_plus
			{
			pushFollow(FOLLOW_identifier_plus_in_realias_clause1871);
			identifier_plus161=identifier_plus();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_identifier_plus.add(identifier_plus161.getTree());
			EQUAL162=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_realias_clause1873); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_EQUAL.add(EQUAL162);

			pushFollow(FOLLOW_identifier_plus_in_realias_clause1875);
			identifier_plus163=identifier_plus();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_identifier_plus.add(identifier_plus163.getTree());
			// AST REWRITE
			// elements: identifier_plus, identifier_plus
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 364:56: -> ^( REALIAS identifier_plus identifier_plus )
			{
				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:364:59: ^( REALIAS identifier_plus identifier_plus )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(REALIAS, "REALIAS"), root_1);
				adaptor.addChild(root_1, stream_identifier_plus.nextTree());
				adaptor.addChild(root_1, stream_identifier_plus.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "realias_clause"


	public static class parallel_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "parallel_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:367:1: parallel_clause : PARALLEL ^ INTEGER ;
	public final QueryParser.parallel_clause_return parallel_clause() throws RecognitionException {
		QueryParser.parallel_clause_return retval = new QueryParser.parallel_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token PARALLEL164=null;
		Token INTEGER165=null;

		Object PARALLEL164_tree=null;
		Object INTEGER165_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:367:17: ( PARALLEL ^ INTEGER )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:367:19: PARALLEL ^ INTEGER
			{
			root_0 = (Object)adaptor.nil();


			PARALLEL164=(Token)match(input,PARALLEL,FOLLOW_PARALLEL_in_parallel_clause1894); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			PARALLEL164_tree = (Object)adaptor.create(PARALLEL164);
			root_0 = (Object)adaptor.becomeRoot(PARALLEL164_tree, root_0);
			}

			INTEGER165=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_parallel_clause1897); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			INTEGER165_tree = (Object)adaptor.create(INTEGER165);
			adaptor.addChild(root_0, INTEGER165_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "parallel_clause"


	public static class op_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "op_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:370:1: op_clause : ( define_clause | load_clause | group_clause | cube_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause );
	public final QueryParser.op_clause_return op_clause() throws RecognitionException {
		QueryParser.op_clause_return retval = new QueryParser.op_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope define_clause166 =null;
		ParserRuleReturnScope load_clause167 =null;
		ParserRuleReturnScope group_clause168 =null;
		ParserRuleReturnScope cube_clause169 =null;
		ParserRuleReturnScope store_clause170 =null;
		ParserRuleReturnScope filter_clause171 =null;
		ParserRuleReturnScope distinct_clause172 =null;
		ParserRuleReturnScope limit_clause173 =null;
		ParserRuleReturnScope sample_clause174 =null;
		ParserRuleReturnScope order_clause175 =null;
		ParserRuleReturnScope rank_clause176 =null;
		ParserRuleReturnScope cross_clause177 =null;
		ParserRuleReturnScope join_clause178 =null;
		ParserRuleReturnScope union_clause179 =null;
		ParserRuleReturnScope stream_clause180 =null;
		ParserRuleReturnScope mr_clause181 =null;


		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:370:11: ( define_clause | load_clause | group_clause | cube_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause )
			int alt47=16;
			switch ( input.LA(1) ) {
			case DEFINE:
				{
				alt47=1;
				}
				break;
			case LOAD:
				{
				alt47=2;
				}
				break;
			case COGROUP:
			case GROUP:
				{
				alt47=3;
				}
				break;
			case CUBE:
				{
				alt47=4;
				}
				break;
			case STORE:
				{
				alt47=5;
				}
				break;
			case FILTER:
				{
				alt47=6;
				}
				break;
			case DISTINCT:
				{
				alt47=7;
				}
				break;
			case LIMIT:
				{
				alt47=8;
				}
				break;
			case SAMPLE:
				{
				alt47=9;
				}
				break;
			case ORDER:
				{
				alt47=10;
				}
				break;
			case RANK:
				{
				alt47=11;
				}
				break;
			case CROSS:
				{
				alt47=12;
				}
				break;
			case JOIN:
				{
				alt47=13;
				}
				break;
			case UNION:
				{
				alt47=14;
				}
				break;
			case STREAM:
				{
				alt47=15;
				}
				break;
			case MAPREDUCE:
				{
				alt47=16;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 47, 0, input);
				throw nvae;
			}
			switch (alt47) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:370:13: define_clause
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_define_clause_in_op_clause1906);
					define_clause166=define_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, define_clause166.getTree());

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:371:13: load_clause
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_load_clause_in_op_clause1920);
					load_clause167=load_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, load_clause167.getTree());

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:372:13: group_clause
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_group_clause_in_op_clause1934);
					group_clause168=group_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, group_clause168.getTree());

					}
					break;
				case 4 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:373:13: cube_clause
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_cube_clause_in_op_clause1948);
					cube_clause169=cube_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, cube_clause169.getTree());

					}
					break;
				case 5 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:374:13: store_clause
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_store_clause_in_op_clause1962);
					store_clause170=store_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, store_clause170.getTree());

					}
					break;
				case 6 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:375:13: filter_clause
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_filter_clause_in_op_clause1976);
					filter_clause171=filter_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, filter_clause171.getTree());

					}
					break;
				case 7 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:376:13: distinct_clause
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_distinct_clause_in_op_clause1990);
					distinct_clause172=distinct_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, distinct_clause172.getTree());

					}
					break;
				case 8 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:377:13: limit_clause
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_limit_clause_in_op_clause2004);
					limit_clause173=limit_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, limit_clause173.getTree());

					}
					break;
				case 9 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:378:13: sample_clause
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_sample_clause_in_op_clause2018);
					sample_clause174=sample_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, sample_clause174.getTree());

					}
					break;
				case 10 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:379:13: order_clause
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_order_clause_in_op_clause2032);
					order_clause175=order_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, order_clause175.getTree());

					}
					break;
				case 11 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:380:13: rank_clause
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_rank_clause_in_op_clause2046);
					rank_clause176=rank_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rank_clause176.getTree());

					}
					break;
				case 12 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:381:13: cross_clause
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_cross_clause_in_op_clause2060);
					cross_clause177=cross_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, cross_clause177.getTree());

					}
					break;
				case 13 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:382:13: join_clause
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_join_clause_in_op_clause2074);
					join_clause178=join_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, join_clause178.getTree());

					}
					break;
				case 14 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:383:13: union_clause
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_union_clause_in_op_clause2088);
					union_clause179=union_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, union_clause179.getTree());

					}
					break;
				case 15 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:384:13: stream_clause
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_stream_clause_in_op_clause2102);
					stream_clause180=stream_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, stream_clause180.getTree());

					}
					break;
				case 16 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:385:13: mr_clause
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_mr_clause_in_op_clause2116);
					mr_clause181=mr_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, mr_clause181.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "op_clause"


	public static class ship_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "ship_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:388:1: ship_clause : SHIP ^ LEFT_PAREN ! ( path_list )? RIGHT_PAREN !;
	public final QueryParser.ship_clause_return ship_clause() throws RecognitionException {
		QueryParser.ship_clause_return retval = new QueryParser.ship_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SHIP182=null;
		Token LEFT_PAREN183=null;
		Token RIGHT_PAREN185=null;
		ParserRuleReturnScope path_list184 =null;

		Object SHIP182_tree=null;
		Object LEFT_PAREN183_tree=null;
		Object RIGHT_PAREN185_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:388:13: ( SHIP ^ LEFT_PAREN ! ( path_list )? RIGHT_PAREN !)
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:388:15: SHIP ^ LEFT_PAREN ! ( path_list )? RIGHT_PAREN !
			{
			root_0 = (Object)adaptor.nil();


			SHIP182=(Token)match(input,SHIP,FOLLOW_SHIP_in_ship_clause2125); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			SHIP182_tree = (Object)adaptor.create(SHIP182);
			root_0 = (Object)adaptor.becomeRoot(SHIP182_tree, root_0);
			}

			LEFT_PAREN183=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_ship_clause2128); if (state.failed) return retval;
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:388:33: ( path_list )?
			int alt48=2;
			int LA48_0 = input.LA(1);
			if ( (LA48_0==QUOTEDSTRING) ) {
				alt48=1;
			}
			switch (alt48) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:388:33: path_list
					{
					pushFollow(FOLLOW_path_list_in_ship_clause2131);
					path_list184=path_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, path_list184.getTree());

					}
					break;

			}

			RIGHT_PAREN185=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_ship_clause2134); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "ship_clause"


	public static class path_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "path_list"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:391:1: path_list : QUOTEDSTRING ( COMMA QUOTEDSTRING )* -> ( QUOTEDSTRING )+ ;
	public final QueryParser.path_list_return path_list() throws RecognitionException {
		QueryParser.path_list_return retval = new QueryParser.path_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token QUOTEDSTRING186=null;
		Token COMMA187=null;
		Token QUOTEDSTRING188=null;

		Object QUOTEDSTRING186_tree=null;
		Object COMMA187_tree=null;
		Object QUOTEDSTRING188_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleTokenStream stream_QUOTEDSTRING=new RewriteRuleTokenStream(adaptor,"token QUOTEDSTRING");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:391:11: ( QUOTEDSTRING ( COMMA QUOTEDSTRING )* -> ( QUOTEDSTRING )+ )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:391:13: QUOTEDSTRING ( COMMA QUOTEDSTRING )*
			{
			QUOTEDSTRING186=(Token)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_path_list2144); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_QUOTEDSTRING.add(QUOTEDSTRING186);

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:391:26: ( COMMA QUOTEDSTRING )*
			loop49:
			while (true) {
				int alt49=2;
				int LA49_0 = input.LA(1);
				if ( (LA49_0==COMMA) ) {
					alt49=1;
				}

				switch (alt49) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:391:28: COMMA QUOTEDSTRING
					{
					COMMA187=(Token)match(input,COMMA,FOLLOW_COMMA_in_path_list2148); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COMMA.add(COMMA187);

					QUOTEDSTRING188=(Token)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_path_list2150); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QUOTEDSTRING.add(QUOTEDSTRING188);

					}
					break;

				default :
					break loop49;
				}
			}

			// AST REWRITE
			// elements: QUOTEDSTRING
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 391:50: -> ( QUOTEDSTRING )+
			{
				if ( !(stream_QUOTEDSTRING.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_QUOTEDSTRING.hasNext() ) {
					adaptor.addChild(root_0, stream_QUOTEDSTRING.nextNode());
				}
				stream_QUOTEDSTRING.reset();

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "path_list"


	public static class cache_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "cache_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:394:1: cache_clause : CACHE ^ LEFT_PAREN ! path_list RIGHT_PAREN !;
	public final QueryParser.cache_clause_return cache_clause() throws RecognitionException {
		QueryParser.cache_clause_return retval = new QueryParser.cache_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token CACHE189=null;
		Token LEFT_PAREN190=null;
		Token RIGHT_PAREN192=null;
		ParserRuleReturnScope path_list191 =null;

		Object CACHE189_tree=null;
		Object LEFT_PAREN190_tree=null;
		Object RIGHT_PAREN192_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:394:14: ( CACHE ^ LEFT_PAREN ! path_list RIGHT_PAREN !)
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:394:16: CACHE ^ LEFT_PAREN ! path_list RIGHT_PAREN !
			{
			root_0 = (Object)adaptor.nil();


			CACHE189=(Token)match(input,CACHE,FOLLOW_CACHE_in_cache_clause2167); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			CACHE189_tree = (Object)adaptor.create(CACHE189);
			root_0 = (Object)adaptor.becomeRoot(CACHE189_tree, root_0);
			}

			LEFT_PAREN190=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_cache_clause2170); if (state.failed) return retval;
			pushFollow(FOLLOW_path_list_in_cache_clause2173);
			path_list191=path_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, path_list191.getTree());

			RIGHT_PAREN192=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_cache_clause2175); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "cache_clause"


	public static class input_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "input_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:397:1: input_clause : INPUT ^ LEFT_PAREN ! stream_cmd_list RIGHT_PAREN !;
	public final QueryParser.input_clause_return input_clause() throws RecognitionException {
		QueryParser.input_clause_return retval = new QueryParser.input_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token INPUT193=null;
		Token LEFT_PAREN194=null;
		Token RIGHT_PAREN196=null;
		ParserRuleReturnScope stream_cmd_list195 =null;

		Object INPUT193_tree=null;
		Object LEFT_PAREN194_tree=null;
		Object RIGHT_PAREN196_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:397:14: ( INPUT ^ LEFT_PAREN ! stream_cmd_list RIGHT_PAREN !)
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:397:16: INPUT ^ LEFT_PAREN ! stream_cmd_list RIGHT_PAREN !
			{
			root_0 = (Object)adaptor.nil();


			INPUT193=(Token)match(input,INPUT,FOLLOW_INPUT_in_input_clause2185); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			INPUT193_tree = (Object)adaptor.create(INPUT193);
			root_0 = (Object)adaptor.becomeRoot(INPUT193_tree, root_0);
			}

			LEFT_PAREN194=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_input_clause2188); if (state.failed) return retval;
			pushFollow(FOLLOW_stream_cmd_list_in_input_clause2191);
			stream_cmd_list195=stream_cmd_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, stream_cmd_list195.getTree());

			RIGHT_PAREN196=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_input_clause2193); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "input_clause"


	public static class output_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "output_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:400:1: output_clause : OUTPUT ^ LEFT_PAREN ! stream_cmd_list RIGHT_PAREN !;
	public final QueryParser.output_clause_return output_clause() throws RecognitionException {
		QueryParser.output_clause_return retval = new QueryParser.output_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token OUTPUT197=null;
		Token LEFT_PAREN198=null;
		Token RIGHT_PAREN200=null;
		ParserRuleReturnScope stream_cmd_list199 =null;

		Object OUTPUT197_tree=null;
		Object LEFT_PAREN198_tree=null;
		Object RIGHT_PAREN200_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:400:15: ( OUTPUT ^ LEFT_PAREN ! stream_cmd_list RIGHT_PAREN !)
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:400:17: OUTPUT ^ LEFT_PAREN ! stream_cmd_list RIGHT_PAREN !
			{
			root_0 = (Object)adaptor.nil();


			OUTPUT197=(Token)match(input,OUTPUT,FOLLOW_OUTPUT_in_output_clause2203); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			OUTPUT197_tree = (Object)adaptor.create(OUTPUT197);
			root_0 = (Object)adaptor.becomeRoot(OUTPUT197_tree, root_0);
			}

			LEFT_PAREN198=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_output_clause2206); if (state.failed) return retval;
			pushFollow(FOLLOW_stream_cmd_list_in_output_clause2209);
			stream_cmd_list199=stream_cmd_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, stream_cmd_list199.getTree());

			RIGHT_PAREN200=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_output_clause2211); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "output_clause"


	public static class error_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "error_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:403:1: error_clause : STDERROR ^ LEFT_PAREN ! ( QUOTEDSTRING ( LIMIT ! INTEGER )? )? RIGHT_PAREN !;
	public final QueryParser.error_clause_return error_clause() throws RecognitionException {
		QueryParser.error_clause_return retval = new QueryParser.error_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token STDERROR201=null;
		Token LEFT_PAREN202=null;
		Token QUOTEDSTRING203=null;
		Token LIMIT204=null;
		Token INTEGER205=null;
		Token RIGHT_PAREN206=null;

		Object STDERROR201_tree=null;
		Object LEFT_PAREN202_tree=null;
		Object QUOTEDSTRING203_tree=null;
		Object LIMIT204_tree=null;
		Object INTEGER205_tree=null;
		Object RIGHT_PAREN206_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:403:14: ( STDERROR ^ LEFT_PAREN ! ( QUOTEDSTRING ( LIMIT ! INTEGER )? )? RIGHT_PAREN !)
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:403:16: STDERROR ^ LEFT_PAREN ! ( QUOTEDSTRING ( LIMIT ! INTEGER )? )? RIGHT_PAREN !
			{
			root_0 = (Object)adaptor.nil();


			STDERROR201=(Token)match(input,STDERROR,FOLLOW_STDERROR_in_error_clause2221); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			STDERROR201_tree = (Object)adaptor.create(STDERROR201);
			root_0 = (Object)adaptor.becomeRoot(STDERROR201_tree, root_0);
			}

			LEFT_PAREN202=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_error_clause2224); if (state.failed) return retval;
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:403:38: ( QUOTEDSTRING ( LIMIT ! INTEGER )? )?
			int alt51=2;
			int LA51_0 = input.LA(1);
			if ( (LA51_0==QUOTEDSTRING) ) {
				alt51=1;
			}
			switch (alt51) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:403:40: QUOTEDSTRING ( LIMIT ! INTEGER )?
					{
					QUOTEDSTRING203=(Token)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_error_clause2229); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					QUOTEDSTRING203_tree = (Object)adaptor.create(QUOTEDSTRING203);
					adaptor.addChild(root_0, QUOTEDSTRING203_tree);
					}

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:403:53: ( LIMIT ! INTEGER )?
					int alt50=2;
					int LA50_0 = input.LA(1);
					if ( (LA50_0==LIMIT) ) {
						alt50=1;
					}
					switch (alt50) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:403:55: LIMIT ! INTEGER
							{
							LIMIT204=(Token)match(input,LIMIT,FOLLOW_LIMIT_in_error_clause2233); if (state.failed) return retval;
							INTEGER205=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_error_clause2236); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							INTEGER205_tree = (Object)adaptor.create(INTEGER205);
							adaptor.addChild(root_0, INTEGER205_tree);
							}

							}
							break;

					}

					}
					break;

			}

			RIGHT_PAREN206=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_error_clause2244); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "error_clause"


	public static class load_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "load_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:406:1: load_clause : LOAD ^ QUOTEDSTRING ( USING ! func_clause )? ( as_clause )? ;
	public final QueryParser.load_clause_return load_clause() throws RecognitionException {
		QueryParser.load_clause_return retval = new QueryParser.load_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LOAD207=null;
		Token QUOTEDSTRING208=null;
		Token USING209=null;
		ParserRuleReturnScope func_clause210 =null;
		ParserRuleReturnScope as_clause211 =null;

		Object LOAD207_tree=null;
		Object QUOTEDSTRING208_tree=null;
		Object USING209_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:406:13: ( LOAD ^ QUOTEDSTRING ( USING ! func_clause )? ( as_clause )? )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:406:15: LOAD ^ QUOTEDSTRING ( USING ! func_clause )? ( as_clause )?
			{
			root_0 = (Object)adaptor.nil();


			LOAD207=(Token)match(input,LOAD,FOLLOW_LOAD_in_load_clause2254); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LOAD207_tree = (Object)adaptor.create(LOAD207);
			root_0 = (Object)adaptor.becomeRoot(LOAD207_tree, root_0);
			}

			QUOTEDSTRING208=(Token)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_load_clause2257); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			QUOTEDSTRING208_tree = (Object)adaptor.create(QUOTEDSTRING208);
			adaptor.addChild(root_0, QUOTEDSTRING208_tree);
			}

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:406:34: ( USING ! func_clause )?
			int alt52=2;
			int LA52_0 = input.LA(1);
			if ( (LA52_0==USING) ) {
				alt52=1;
			}
			switch (alt52) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:406:36: USING ! func_clause
					{
					USING209=(Token)match(input,USING,FOLLOW_USING_in_load_clause2261); if (state.failed) return retval;
					pushFollow(FOLLOW_func_clause_in_load_clause2264);
					func_clause210=func_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, func_clause210.getTree());

					}
					break;

			}

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:406:58: ( as_clause )?
			int alt53=2;
			int LA53_0 = input.LA(1);
			if ( (LA53_0==AS) ) {
				alt53=1;
			}
			switch (alt53) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:406:58: as_clause
					{
					pushFollow(FOLLOW_as_clause_in_load_clause2269);
					as_clause211=as_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, as_clause211.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "load_clause"


	public static class func_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "func_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:409:1: func_clause : ( func_name -> ^( FUNC_REF func_name ) | func_name LEFT_PAREN ( func_args )? RIGHT_PAREN -> ^( FUNC func_name ( func_args )? ) );
	public final QueryParser.func_clause_return func_clause() throws RecognitionException {
		QueryParser.func_clause_return retval = new QueryParser.func_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LEFT_PAREN214=null;
		Token RIGHT_PAREN216=null;
		ParserRuleReturnScope func_name212 =null;
		ParserRuleReturnScope func_name213 =null;
		ParserRuleReturnScope func_args215 =null;

		Object LEFT_PAREN214_tree=null;
		Object RIGHT_PAREN216_tree=null;
		RewriteRuleTokenStream stream_RIGHT_PAREN=new RewriteRuleTokenStream(adaptor,"token RIGHT_PAREN");
		RewriteRuleTokenStream stream_LEFT_PAREN=new RewriteRuleTokenStream(adaptor,"token LEFT_PAREN");
		RewriteRuleSubtreeStream stream_func_args=new RewriteRuleSubtreeStream(adaptor,"rule func_args");
		RewriteRuleSubtreeStream stream_func_name=new RewriteRuleSubtreeStream(adaptor,"rule func_name");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:409:13: ( func_name -> ^( FUNC_REF func_name ) | func_name LEFT_PAREN ( func_args )? RIGHT_PAREN -> ^( FUNC func_name ( func_args )? ) )
			int alt55=2;
			alt55 = dfa55.predict(input);
			switch (alt55) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:409:15: func_name
					{
					pushFollow(FOLLOW_func_name_in_func_clause2279);
					func_name212=func_name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_func_name.add(func_name212.getTree());
					// AST REWRITE
					// elements: func_name
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 410:12: -> ^( FUNC_REF func_name )
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:410:15: ^( FUNC_REF func_name )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_REF, "FUNC_REF"), root_1);
						adaptor.addChild(root_1, stream_func_name.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:411:15: func_name LEFT_PAREN ( func_args )? RIGHT_PAREN
					{
					pushFollow(FOLLOW_func_name_in_func_clause2316);
					func_name213=func_name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_func_name.add(func_name213.getTree());
					LEFT_PAREN214=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_func_clause2318); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LEFT_PAREN.add(LEFT_PAREN214);

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:411:36: ( func_args )?
					int alt54=2;
					int LA54_0 = input.LA(1);
					if ( (LA54_0==MULTILINE_QUOTEDSTRING||LA54_0==QUOTEDSTRING) ) {
						alt54=1;
					}
					switch (alt54) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:411:36: func_args
							{
							pushFollow(FOLLOW_func_args_in_func_clause2320);
							func_args215=func_args();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_func_args.add(func_args215.getTree());
							}
							break;

					}

					RIGHT_PAREN216=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_func_clause2323); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RIGHT_PAREN.add(RIGHT_PAREN216);

					// AST REWRITE
					// elements: func_args, func_name
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 412:12: -> ^( FUNC func_name ( func_args )? )
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:412:15: ^( FUNC func_name ( func_args )? )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC, "FUNC"), root_1);
						adaptor.addChild(root_1, stream_func_name.nextTree());
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:412:33: ( func_args )?
						if ( stream_func_args.hasNext() ) {
							adaptor.addChild(root_1, stream_func_args.nextTree());
						}
						stream_func_args.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "func_clause"


	public static class func_name_without_columns_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "func_name_without_columns"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:416:1: func_name_without_columns : eid_without_columns ( ( PERIOD | DOLLAR ) eid )* ;
	public final QueryParser.func_name_without_columns_return func_name_without_columns() throws RecognitionException {
		QueryParser.func_name_without_columns_return retval = new QueryParser.func_name_without_columns_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set218=null;
		ParserRuleReturnScope eid_without_columns217 =null;
		ParserRuleReturnScope eid219 =null;

		Object set218_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:416:27: ( eid_without_columns ( ( PERIOD | DOLLAR ) eid )* )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:416:29: eid_without_columns ( ( PERIOD | DOLLAR ) eid )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_eid_without_columns_in_func_name_without_columns2357);
			eid_without_columns217=eid_without_columns();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, eid_without_columns217.getTree());

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:416:49: ( ( PERIOD | DOLLAR ) eid )*
			loop56:
			while (true) {
				int alt56=2;
				int LA56_0 = input.LA(1);
				if ( (LA56_0==DOLLAR||LA56_0==PERIOD) ) {
					alt56=1;
				}

				switch (alt56) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:416:51: ( PERIOD | DOLLAR ) eid
					{
					set218=input.LT(1);
					if ( input.LA(1)==DOLLAR||input.LA(1)==PERIOD ) {
						input.consume();
						if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set218));
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_eid_in_func_name_without_columns2371);
					eid219=eid();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, eid219.getTree());

					}
					break;

				default :
					break loop56;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "func_name_without_columns"


	public static class func_name_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "func_name"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:419:1: func_name : eid ( ( PERIOD | DOLLAR ) eid )* ;
	public final QueryParser.func_name_return func_name() throws RecognitionException {
		QueryParser.func_name_return retval = new QueryParser.func_name_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set221=null;
		ParserRuleReturnScope eid220 =null;
		ParserRuleReturnScope eid222 =null;

		Object set221_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:419:11: ( eid ( ( PERIOD | DOLLAR ) eid )* )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:419:13: eid ( ( PERIOD | DOLLAR ) eid )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_eid_in_func_name2383);
			eid220=eid();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, eid220.getTree());

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:419:17: ( ( PERIOD | DOLLAR ) eid )*
			loop57:
			while (true) {
				int alt57=2;
				int LA57_0 = input.LA(1);
				if ( (LA57_0==DOLLAR||LA57_0==PERIOD) ) {
					alt57=1;
				}

				switch (alt57) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:419:19: ( PERIOD | DOLLAR ) eid
					{
					set221=input.LT(1);
					if ( input.LA(1)==DOLLAR||input.LA(1)==PERIOD ) {
						input.consume();
						if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set221));
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_eid_in_func_name2397);
					eid222=eid();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, eid222.getTree());

					}
					break;

				default :
					break loop57;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "func_name"


	public static class func_args_string_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "func_args_string"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:422:1: func_args_string : ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING );
	public final QueryParser.func_args_string_return func_args_string() throws RecognitionException {
		QueryParser.func_args_string_return retval = new QueryParser.func_args_string_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set223=null;

		Object set223_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:422:18: ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:
			{
			root_0 = (Object)adaptor.nil();


			set223=input.LT(1);
			if ( input.LA(1)==MULTILINE_QUOTEDSTRING||input.LA(1)==QUOTEDSTRING ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set223));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "func_args_string"


	public static class func_args_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "func_args"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:425:1: func_args : func_args_string ( COMMA func_args_string )* -> ( func_args_string )+ ;
	public final QueryParser.func_args_return func_args() throws RecognitionException {
		QueryParser.func_args_return retval = new QueryParser.func_args_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA225=null;
		ParserRuleReturnScope func_args_string224 =null;
		ParserRuleReturnScope func_args_string226 =null;

		Object COMMA225_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_func_args_string=new RewriteRuleSubtreeStream(adaptor,"rule func_args_string");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:425:11: ( func_args_string ( COMMA func_args_string )* -> ( func_args_string )+ )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:425:13: func_args_string ( COMMA func_args_string )*
			{
			pushFollow(FOLLOW_func_args_string_in_func_args2422);
			func_args_string224=func_args_string();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_func_args_string.add(func_args_string224.getTree());
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:425:30: ( COMMA func_args_string )*
			loop58:
			while (true) {
				int alt58=2;
				int LA58_0 = input.LA(1);
				if ( (LA58_0==COMMA) ) {
					alt58=1;
				}

				switch (alt58) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:425:32: COMMA func_args_string
					{
					COMMA225=(Token)match(input,COMMA,FOLLOW_COMMA_in_func_args2426); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COMMA.add(COMMA225);

					pushFollow(FOLLOW_func_args_string_in_func_args2428);
					func_args_string226=func_args_string();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_func_args_string.add(func_args_string226.getTree());
					}
					break;

				default :
					break loop58;
				}
			}

			// AST REWRITE
			// elements: func_args_string
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 426:10: -> ( func_args_string )+
			{
				if ( !(stream_func_args_string.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_func_args_string.hasNext() ) {
					adaptor.addChild(root_0, stream_func_args_string.nextTree());
				}
				stream_func_args_string.reset();

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "func_args"


	public static class group_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "group_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:429:1: group_clause : ( GROUP | COGROUP ) ^ group_item_list ( USING ! QUOTEDSTRING )? ( partition_clause )? ;
	public final QueryParser.group_clause_return group_clause() throws RecognitionException {
		QueryParser.group_clause_return retval = new QueryParser.group_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set227=null;
		Token USING229=null;
		Token QUOTEDSTRING230=null;
		ParserRuleReturnScope group_item_list228 =null;
		ParserRuleReturnScope partition_clause231 =null;

		Object set227_tree=null;
		Object USING229_tree=null;
		Object QUOTEDSTRING230_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:429:14: ( ( GROUP | COGROUP ) ^ group_item_list ( USING ! QUOTEDSTRING )? ( partition_clause )? )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:429:16: ( GROUP | COGROUP ) ^ group_item_list ( USING ! QUOTEDSTRING )? ( partition_clause )?
			{
			root_0 = (Object)adaptor.nil();


			set227=input.LT(1);
			set227=input.LT(1);
			if ( input.LA(1)==COGROUP||input.LA(1)==GROUP ) {
				input.consume();
				if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set227), root_0);
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			pushFollow(FOLLOW_group_item_list_in_group_clause2465);
			group_item_list228=group_item_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, group_item_list228.getTree());

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:429:53: ( USING ! QUOTEDSTRING )?
			int alt59=2;
			int LA59_0 = input.LA(1);
			if ( (LA59_0==USING) ) {
				alt59=1;
			}
			switch (alt59) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:429:55: USING ! QUOTEDSTRING
					{
					USING229=(Token)match(input,USING,FOLLOW_USING_in_group_clause2469); if (state.failed) return retval;
					QUOTEDSTRING230=(Token)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_group_clause2472); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					QUOTEDSTRING230_tree = (Object)adaptor.create(QUOTEDSTRING230);
					adaptor.addChild(root_0, QUOTEDSTRING230_tree);
					}

					}
					break;

			}

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:429:78: ( partition_clause )?
			int alt60=2;
			int LA60_0 = input.LA(1);
			if ( (LA60_0==PARTITION) ) {
				alt60=1;
			}
			switch (alt60) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:429:78: partition_clause
					{
					pushFollow(FOLLOW_partition_clause_in_group_clause2477);
					partition_clause231=partition_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, partition_clause231.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "group_clause"


	public static class group_item_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "group_item_list"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:432:1: group_item_list : group_item ( COMMA group_item )* -> ( group_item )+ ;
	public final QueryParser.group_item_list_return group_item_list() throws RecognitionException {
		QueryParser.group_item_list_return retval = new QueryParser.group_item_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA233=null;
		ParserRuleReturnScope group_item232 =null;
		ParserRuleReturnScope group_item234 =null;

		Object COMMA233_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_group_item=new RewriteRuleSubtreeStream(adaptor,"rule group_item");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:432:17: ( group_item ( COMMA group_item )* -> ( group_item )+ )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:432:19: group_item ( COMMA group_item )*
			{
			pushFollow(FOLLOW_group_item_in_group_item_list2487);
			group_item232=group_item();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_group_item.add(group_item232.getTree());
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:432:30: ( COMMA group_item )*
			loop61:
			while (true) {
				int alt61=2;
				int LA61_0 = input.LA(1);
				if ( (LA61_0==COMMA) ) {
					alt61=1;
				}

				switch (alt61) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:432:32: COMMA group_item
					{
					COMMA233=(Token)match(input,COMMA,FOLLOW_COMMA_in_group_item_list2491); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COMMA.add(COMMA233);

					pushFollow(FOLLOW_group_item_in_group_item_list2493);
					group_item234=group_item();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_group_item.add(group_item234.getTree());
					}
					break;

				default :
					break loop61;
				}
			}

			// AST REWRITE
			// elements: group_item
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 433:16: -> ( group_item )+
			{
				if ( !(stream_group_item.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_group_item.hasNext() ) {
					adaptor.addChild(root_0, stream_group_item.nextTree());
				}
				stream_group_item.reset();

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "group_item_list"


	public static class group_item_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "group_item"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:436:1: group_item : rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? ;
	public final QueryParser.group_item_return group_item() throws RecognitionException {
		QueryParser.group_item_return retval = new QueryParser.group_item_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ALL237=null;
		Token ANY238=null;
		Token set239=null;
		ParserRuleReturnScope rel235 =null;
		ParserRuleReturnScope join_group_by_clause236 =null;

		Object ALL237_tree=null;
		Object ANY238_tree=null;
		Object set239_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:436:12: ( rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:436:14: rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )?
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_rel_in_group_item2525);
			rel235=rel();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, rel235.getTree());

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:436:18: ( join_group_by_clause | ALL | ANY )
			int alt62=3;
			switch ( input.LA(1) ) {
			case BY:
				{
				alt62=1;
				}
				break;
			case ALL:
				{
				alt62=2;
				}
				break;
			case ANY:
				{
				alt62=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 62, 0, input);
				throw nvae;
			}
			switch (alt62) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:436:20: join_group_by_clause
					{
					pushFollow(FOLLOW_join_group_by_clause_in_group_item2529);
					join_group_by_clause236=join_group_by_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, join_group_by_clause236.getTree());

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:436:43: ALL
					{
					ALL237=(Token)match(input,ALL,FOLLOW_ALL_in_group_item2533); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ALL237_tree = (Object)adaptor.create(ALL237);
					adaptor.addChild(root_0, ALL237_tree);
					}

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:436:49: ANY
					{
					ANY238=(Token)match(input,ANY,FOLLOW_ANY_in_group_item2537); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ANY238_tree = (Object)adaptor.create(ANY238);
					adaptor.addChild(root_0, ANY238_tree);
					}

					}
					break;

			}

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:436:55: ( INNER | OUTER )?
			int alt63=2;
			int LA63_0 = input.LA(1);
			if ( (LA63_0==INNER||LA63_0==OUTER) ) {
				alt63=1;
			}
			switch (alt63) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:
					{
					set239=input.LT(1);
					if ( input.LA(1)==INNER||input.LA(1)==OUTER ) {
						input.consume();
						if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set239));
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "group_item"


	public static class identifier_plus_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "identifier_plus"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:441:1: identifier_plus : ( IDENTIFIER | reserved_identifier_whitelist -> IDENTIFIER[$reserved_identifier_whitelist.text] );
	public final QueryParser.identifier_plus_return identifier_plus() throws RecognitionException {
		QueryParser.identifier_plus_return retval = new QueryParser.identifier_plus_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token IDENTIFIER240=null;
		ParserRuleReturnScope reserved_identifier_whitelist241 =null;

		Object IDENTIFIER240_tree=null;
		RewriteRuleSubtreeStream stream_reserved_identifier_whitelist=new RewriteRuleSubtreeStream(adaptor,"rule reserved_identifier_whitelist");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:441:17: ( IDENTIFIER | reserved_identifier_whitelist -> IDENTIFIER[$reserved_identifier_whitelist.text] )
			int alt64=2;
			int LA64_0 = input.LA(1);
			if ( (LA64_0==IDENTIFIER) ) {
				alt64=1;
			}
			else if ( (LA64_0==CUBE||(LA64_0 >= ELSE && LA64_0 <= END)||LA64_0==IN||LA64_0==RANK||LA64_0==THEN||LA64_0==WHEN) ) {
				alt64=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 64, 0, input);
				throw nvae;
			}

			switch (alt64) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:441:19: IDENTIFIER
					{
					root_0 = (Object)adaptor.nil();


					IDENTIFIER240=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_identifier_plus2561); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IDENTIFIER240_tree = (Object)adaptor.create(IDENTIFIER240);
					adaptor.addChild(root_0, IDENTIFIER240_tree);
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:441:32: reserved_identifier_whitelist
					{
					pushFollow(FOLLOW_reserved_identifier_whitelist_in_identifier_plus2565);
					reserved_identifier_whitelist241=reserved_identifier_whitelist();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_reserved_identifier_whitelist.add(reserved_identifier_whitelist241.getTree());
					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 441:62: -> IDENTIFIER[$reserved_identifier_whitelist.text]
					{
						adaptor.addChild(root_0, (Object)adaptor.create(IDENTIFIER, (reserved_identifier_whitelist241!=null?input.toString(reserved_identifier_whitelist241.start,reserved_identifier_whitelist241.stop):null)));
					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "identifier_plus"


	public static class explicit_field_def_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "explicit_field_def"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:444:1: explicit_field_def : ( identifier_plus ( COLON type )? -> ^( FIELD_DEF identifier_plus ( type )? ) | explicit_type -> ^( FIELD_DEF_WITHOUT_IDENTIFIER explicit_type ) );
	public final QueryParser.explicit_field_def_return explicit_field_def() throws RecognitionException {
		QueryParser.explicit_field_def_return retval = new QueryParser.explicit_field_def_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COLON243=null;
		ParserRuleReturnScope identifier_plus242 =null;
		ParserRuleReturnScope type244 =null;
		ParserRuleReturnScope explicit_type245 =null;

		Object COLON243_tree=null;
		RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
		RewriteRuleSubtreeStream stream_identifier_plus=new RewriteRuleSubtreeStream(adaptor,"rule identifier_plus");
		RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
		RewriteRuleSubtreeStream stream_explicit_type=new RewriteRuleSubtreeStream(adaptor,"rule explicit_type");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:444:20: ( identifier_plus ( COLON type )? -> ^( FIELD_DEF identifier_plus ( type )? ) | explicit_type -> ^( FIELD_DEF_WITHOUT_IDENTIFIER explicit_type ) )
			int alt66=2;
			int LA66_0 = input.LA(1);
			if ( (LA66_0==CUBE||(LA66_0 >= ELSE && LA66_0 <= END)||LA66_0==IDENTIFIER||LA66_0==IN||LA66_0==RANK||LA66_0==THEN||LA66_0==WHEN) ) {
				alt66=1;
			}
			else if ( ((LA66_0 >= BAG && LA66_0 <= BIGDECIMAL)||LA66_0==BIGINTEGER||LA66_0==BOOLEAN||LA66_0==BYTEARRAY||LA66_0==CHARARRAY||LA66_0==DATETIME||LA66_0==DOUBLE||LA66_0==FLOAT||LA66_0==INT||LA66_0==LONG||LA66_0==MAP||LA66_0==TUPLE) ) {
				alt66=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 66, 0, input);
				throw nvae;
			}

			switch (alt66) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:444:22: identifier_plus ( COLON type )?
					{
					pushFollow(FOLLOW_identifier_plus_in_explicit_field_def2579);
					identifier_plus242=identifier_plus();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_identifier_plus.add(identifier_plus242.getTree());
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:444:38: ( COLON type )?
					int alt65=2;
					int LA65_0 = input.LA(1);
					if ( (LA65_0==COLON) ) {
						alt65=1;
					}
					switch (alt65) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:444:40: COLON type
							{
							COLON243=(Token)match(input,COLON,FOLLOW_COLON_in_explicit_field_def2583); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COLON.add(COLON243);

							pushFollow(FOLLOW_type_in_explicit_field_def2585);
							type244=type();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_type.add(type244.getTree());
							}
							break;

					}

					// AST REWRITE
					// elements: identifier_plus, type
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 444:54: -> ^( FIELD_DEF identifier_plus ( type )? )
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:444:57: ^( FIELD_DEF identifier_plus ( type )? )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FIELD_DEF, "FIELD_DEF"), root_1);
						adaptor.addChild(root_1, stream_identifier_plus.nextTree());
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:444:86: ( type )?
						if ( stream_type.hasNext() ) {
							adaptor.addChild(root_1, stream_type.nextTree());
						}
						stream_type.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:445:22: explicit_type
					{
					pushFollow(FOLLOW_explicit_type_in_explicit_field_def2624);
					explicit_type245=explicit_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_explicit_type.add(explicit_type245.getTree());
					// AST REWRITE
					// elements: explicit_type
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 445:36: -> ^( FIELD_DEF_WITHOUT_IDENTIFIER explicit_type )
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:445:39: ^( FIELD_DEF_WITHOUT_IDENTIFIER explicit_type )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FIELD_DEF_WITHOUT_IDENTIFIER, "FIELD_DEF_WITHOUT_IDENTIFIER"), root_1);
						adaptor.addChild(root_1, stream_explicit_type.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "explicit_field_def"


	public static class field_def_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "field_def"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:448:1: field_def : ( explicit_field_def | implicit_type -> ^( FIELD_DEF_WITHOUT_IDENTIFIER implicit_type ) );
	public final QueryParser.field_def_return field_def() throws RecognitionException {
		QueryParser.field_def_return retval = new QueryParser.field_def_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope explicit_field_def246 =null;
		ParserRuleReturnScope implicit_type247 =null;

		RewriteRuleSubtreeStream stream_implicit_type=new RewriteRuleSubtreeStream(adaptor,"rule implicit_type");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:448:11: ( explicit_field_def | implicit_type -> ^( FIELD_DEF_WITHOUT_IDENTIFIER implicit_type ) )
			int alt67=2;
			int LA67_0 = input.LA(1);
			if ( ((LA67_0 >= BAG && LA67_0 <= BIGDECIMAL)||LA67_0==BIGINTEGER||LA67_0==BOOLEAN||LA67_0==BYTEARRAY||LA67_0==CHARARRAY||(LA67_0 >= CUBE && LA67_0 <= DATETIME)||LA67_0==DOUBLE||(LA67_0 >= ELSE && LA67_0 <= END)||LA67_0==FLOAT||LA67_0==IDENTIFIER||LA67_0==IN||LA67_0==INT||LA67_0==LONG||LA67_0==MAP||LA67_0==RANK||LA67_0==THEN||LA67_0==TUPLE||LA67_0==WHEN) ) {
				alt67=1;
			}
			else if ( ((LA67_0 >= LEFT_BRACKET && LA67_0 <= LEFT_PAREN)) ) {
				alt67=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 67, 0, input);
				throw nvae;
			}

			switch (alt67) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:448:13: explicit_field_def
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_explicit_field_def_in_field_def2643);
					explicit_field_def246=explicit_field_def();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, explicit_field_def246.getTree());

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:449:13: implicit_type
					{
					pushFollow(FOLLOW_implicit_type_in_field_def2657);
					implicit_type247=implicit_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_implicit_type.add(implicit_type247.getTree());
					// AST REWRITE
					// elements: implicit_type
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 449:27: -> ^( FIELD_DEF_WITHOUT_IDENTIFIER implicit_type )
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:449:30: ^( FIELD_DEF_WITHOUT_IDENTIFIER implicit_type )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FIELD_DEF_WITHOUT_IDENTIFIER, "FIELD_DEF_WITHOUT_IDENTIFIER"), root_1);
						adaptor.addChild(root_1, stream_implicit_type.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "field_def"


	public static class field_def_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "field_def_list"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:452:1: field_def_list : field_def ( COMMA ! field_def )* ;
	public final QueryParser.field_def_list_return field_def_list() throws RecognitionException {
		QueryParser.field_def_list_return retval = new QueryParser.field_def_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA249=null;
		ParserRuleReturnScope field_def248 =null;
		ParserRuleReturnScope field_def250 =null;

		Object COMMA249_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:452:16: ( field_def ( COMMA ! field_def )* )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:452:18: field_def ( COMMA ! field_def )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_field_def_in_field_def_list2676);
			field_def248=field_def();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, field_def248.getTree());

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:452:28: ( COMMA ! field_def )*
			loop68:
			while (true) {
				int alt68=2;
				int LA68_0 = input.LA(1);
				if ( (LA68_0==COMMA) ) {
					alt68=1;
				}

				switch (alt68) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:452:30: COMMA ! field_def
					{
					COMMA249=(Token)match(input,COMMA,FOLLOW_COMMA_in_field_def_list2680); if (state.failed) return retval;
					pushFollow(FOLLOW_field_def_in_field_def_list2683);
					field_def250=field_def();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, field_def250.getTree());

					}
					break;

				default :
					break loop68;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "field_def_list"


	public static class as_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "as_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:458:1: as_clause : AS ^ ( explicit_field_def | ( LEFT_PAREN ! ( field_def_list )? RIGHT_PAREN !) ) ;
	public final QueryParser.as_clause_return as_clause() throws RecognitionException {
		QueryParser.as_clause_return retval = new QueryParser.as_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token AS251=null;
		Token LEFT_PAREN253=null;
		Token RIGHT_PAREN255=null;
		ParserRuleReturnScope explicit_field_def252 =null;
		ParserRuleReturnScope field_def_list254 =null;

		Object AS251_tree=null;
		Object LEFT_PAREN253_tree=null;
		Object RIGHT_PAREN255_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:458:11: ( AS ^ ( explicit_field_def | ( LEFT_PAREN ! ( field_def_list )? RIGHT_PAREN !) ) )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:458:13: AS ^ ( explicit_field_def | ( LEFT_PAREN ! ( field_def_list )? RIGHT_PAREN !) )
			{
			root_0 = (Object)adaptor.nil();


			AS251=(Token)match(input,AS,FOLLOW_AS_in_as_clause2698); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			AS251_tree = (Object)adaptor.create(AS251);
			root_0 = (Object)adaptor.becomeRoot(AS251_tree, root_0);
			}

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:458:17: ( explicit_field_def | ( LEFT_PAREN ! ( field_def_list )? RIGHT_PAREN !) )
			int alt70=2;
			int LA70_0 = input.LA(1);
			if ( ((LA70_0 >= BAG && LA70_0 <= BIGDECIMAL)||LA70_0==BIGINTEGER||LA70_0==BOOLEAN||LA70_0==BYTEARRAY||LA70_0==CHARARRAY||(LA70_0 >= CUBE && LA70_0 <= DATETIME)||LA70_0==DOUBLE||(LA70_0 >= ELSE && LA70_0 <= END)||LA70_0==FLOAT||LA70_0==IDENTIFIER||LA70_0==IN||LA70_0==INT||LA70_0==LONG||LA70_0==MAP||LA70_0==RANK||LA70_0==THEN||LA70_0==TUPLE||LA70_0==WHEN) ) {
				alt70=1;
			}
			else if ( (LA70_0==LEFT_PAREN) ) {
				alt70=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 70, 0, input);
				throw nvae;
			}

			switch (alt70) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:458:19: explicit_field_def
					{
					pushFollow(FOLLOW_explicit_field_def_in_as_clause2703);
					explicit_field_def252=explicit_field_def();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, explicit_field_def252.getTree());

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:458:40: ( LEFT_PAREN ! ( field_def_list )? RIGHT_PAREN !)
					{
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:458:40: ( LEFT_PAREN ! ( field_def_list )? RIGHT_PAREN !)
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:458:42: LEFT_PAREN ! ( field_def_list )? RIGHT_PAREN !
					{
					LEFT_PAREN253=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_as_clause2709); if (state.failed) return retval;
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:458:54: ( field_def_list )?
					int alt69=2;
					int LA69_0 = input.LA(1);
					if ( ((LA69_0 >= BAG && LA69_0 <= BIGDECIMAL)||LA69_0==BIGINTEGER||LA69_0==BOOLEAN||LA69_0==BYTEARRAY||LA69_0==CHARARRAY||(LA69_0 >= CUBE && LA69_0 <= DATETIME)||LA69_0==DOUBLE||(LA69_0 >= ELSE && LA69_0 <= END)||LA69_0==FLOAT||LA69_0==IDENTIFIER||LA69_0==IN||LA69_0==INT||(LA69_0 >= LEFT_BRACKET && LA69_0 <= LEFT_PAREN)||LA69_0==LONG||LA69_0==MAP||LA69_0==RANK||LA69_0==THEN||LA69_0==TUPLE||LA69_0==WHEN) ) {
						alt69=1;
					}
					switch (alt69) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:458:54: field_def_list
							{
							pushFollow(FOLLOW_field_def_list_in_as_clause2712);
							field_def_list254=field_def_list();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, field_def_list254.getTree());

							}
							break;

					}

					RIGHT_PAREN255=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_as_clause2715); if (state.failed) return retval;
					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "as_clause"


	public static class stream_cmd_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "stream_cmd_list"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:463:1: stream_cmd_list : stream_cmd ( COMMA stream_cmd )* -> ( stream_cmd )+ ;
	public final QueryParser.stream_cmd_list_return stream_cmd_list() throws RecognitionException {
		QueryParser.stream_cmd_list_return retval = new QueryParser.stream_cmd_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA257=null;
		ParserRuleReturnScope stream_cmd256 =null;
		ParserRuleReturnScope stream_cmd258 =null;

		Object COMMA257_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_stream_cmd=new RewriteRuleSubtreeStream(adaptor,"rule stream_cmd");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:463:17: ( stream_cmd ( COMMA stream_cmd )* -> ( stream_cmd )+ )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:463:19: stream_cmd ( COMMA stream_cmd )*
			{
			pushFollow(FOLLOW_stream_cmd_in_stream_cmd_list2731);
			stream_cmd256=stream_cmd();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_stream_cmd.add(stream_cmd256.getTree());
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:463:30: ( COMMA stream_cmd )*
			loop71:
			while (true) {
				int alt71=2;
				int LA71_0 = input.LA(1);
				if ( (LA71_0==COMMA) ) {
					alt71=1;
				}

				switch (alt71) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:463:32: COMMA stream_cmd
					{
					COMMA257=(Token)match(input,COMMA,FOLLOW_COMMA_in_stream_cmd_list2735); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COMMA.add(COMMA257);

					pushFollow(FOLLOW_stream_cmd_in_stream_cmd_list2737);
					stream_cmd258=stream_cmd();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_stream_cmd.add(stream_cmd258.getTree());
					}
					break;

				default :
					break loop71;
				}
			}

			// AST REWRITE
			// elements: stream_cmd
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 463:52: -> ( stream_cmd )+
			{
				if ( !(stream_stream_cmd.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_stream_cmd.hasNext() ) {
					adaptor.addChild(root_0, stream_stream_cmd.nextTree());
				}
				stream_stream_cmd.reset();

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "stream_cmd_list"


	public static class stream_cmd_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "stream_cmd"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:466:1: stream_cmd : ( STDIN | STDOUT | QUOTEDSTRING ) ^ ( USING ! func_clause )? ;
	public final QueryParser.stream_cmd_return stream_cmd() throws RecognitionException {
		QueryParser.stream_cmd_return retval = new QueryParser.stream_cmd_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set259=null;
		Token USING260=null;
		ParserRuleReturnScope func_clause261 =null;

		Object set259_tree=null;
		Object USING260_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:466:12: ( ( STDIN | STDOUT | QUOTEDSTRING ) ^ ( USING ! func_clause )? )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:466:14: ( STDIN | STDOUT | QUOTEDSTRING ) ^ ( USING ! func_clause )?
			{
			root_0 = (Object)adaptor.nil();


			set259=input.LT(1);
			set259=input.LT(1);
			if ( input.LA(1)==QUOTEDSTRING||(input.LA(1) >= STDIN && input.LA(1) <= STDOUT) ) {
				input.consume();
				if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set259), root_0);
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:466:49: ( USING ! func_clause )?
			int alt72=2;
			int LA72_0 = input.LA(1);
			if ( (LA72_0==USING) ) {
				alt72=1;
			}
			switch (alt72) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:466:51: USING ! func_clause
					{
					USING260=(Token)match(input,USING,FOLLOW_USING_in_stream_cmd2771); if (state.failed) return retval;
					pushFollow(FOLLOW_func_clause_in_stream_cmd2774);
					func_clause261=func_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, func_clause261.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "stream_cmd"


	public static class cmd_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "cmd"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:469:1: cmd : EXECCOMMAND ^ ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* ;
	public final QueryParser.cmd_return cmd() throws RecognitionException {
		QueryParser.cmd_return retval = new QueryParser.cmd_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token EXECCOMMAND262=null;
		ParserRuleReturnScope ship_clause263 =null;
		ParserRuleReturnScope cache_clause264 =null;
		ParserRuleReturnScope input_clause265 =null;
		ParserRuleReturnScope output_clause266 =null;
		ParserRuleReturnScope error_clause267 =null;

		Object EXECCOMMAND262_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:469:5: ( EXECCOMMAND ^ ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:469:7: EXECCOMMAND ^ ( ship_clause | cache_clause | input_clause | output_clause | error_clause )*
			{
			root_0 = (Object)adaptor.nil();


			EXECCOMMAND262=(Token)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_cmd2786); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			EXECCOMMAND262_tree = (Object)adaptor.create(EXECCOMMAND262);
			root_0 = (Object)adaptor.becomeRoot(EXECCOMMAND262_tree, root_0);
			}

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:469:20: ( ship_clause | cache_clause | input_clause | output_clause | error_clause )*
			loop73:
			while (true) {
				int alt73=6;
				switch ( input.LA(1) ) {
				case SHIP:
					{
					alt73=1;
					}
					break;
				case CACHE:
					{
					alt73=2;
					}
					break;
				case INPUT:
					{
					alt73=3;
					}
					break;
				case OUTPUT:
					{
					alt73=4;
					}
					break;
				case STDERROR:
					{
					alt73=5;
					}
					break;
				}
				switch (alt73) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:469:22: ship_clause
					{
					pushFollow(FOLLOW_ship_clause_in_cmd2791);
					ship_clause263=ship_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ship_clause263.getTree());

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:469:36: cache_clause
					{
					pushFollow(FOLLOW_cache_clause_in_cmd2795);
					cache_clause264=cache_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, cache_clause264.getTree());

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:469:51: input_clause
					{
					pushFollow(FOLLOW_input_clause_in_cmd2799);
					input_clause265=input_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, input_clause265.getTree());

					}
					break;
				case 4 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:469:66: output_clause
					{
					pushFollow(FOLLOW_output_clause_in_cmd2803);
					output_clause266=output_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, output_clause266.getTree());

					}
					break;
				case 5 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:469:82: error_clause
					{
					pushFollow(FOLLOW_error_clause_in_cmd2807);
					error_clause267=error_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, error_clause267.getTree());

					}
					break;

				default :
					break loop73;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "cmd"


	public static class rel_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "rel"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:472:1: rel : ( identifier_plus | previous_rel | nested_op_clause );
	public final QueryParser.rel_return rel() throws RecognitionException {
		QueryParser.rel_return retval = new QueryParser.rel_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope identifier_plus268 =null;
		ParserRuleReturnScope previous_rel269 =null;
		ParserRuleReturnScope nested_op_clause270 =null;


		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:472:5: ( identifier_plus | previous_rel | nested_op_clause )
			int alt74=3;
			switch ( input.LA(1) ) {
			case CUBE:
			case ELSE:
			case END:
			case IDENTIFIER:
			case IN:
			case RANK:
			case THEN:
			case WHEN:
				{
				alt74=1;
				}
				break;
			case ARROBA:
				{
				alt74=2;
				}
				break;
			case LEFT_PAREN:
				{
				alt74=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 74, 0, input);
				throw nvae;
			}
			switch (alt74) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:472:7: identifier_plus
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_identifier_plus_in_rel2819);
					identifier_plus268=identifier_plus();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, identifier_plus268.getTree());

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:472:25: previous_rel
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_previous_rel_in_rel2823);
					previous_rel269=previous_rel();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, previous_rel269.getTree());

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:472:40: nested_op_clause
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_nested_op_clause_in_rel2827);
					nested_op_clause270=nested_op_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, nested_op_clause270.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rel"


	public static class previous_rel_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "previous_rel"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:475:1: previous_rel : ARROBA ;
	public final QueryParser.previous_rel_return previous_rel() throws RecognitionException {
		QueryParser.previous_rel_return retval = new QueryParser.previous_rel_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ARROBA271=null;

		Object ARROBA271_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:475:14: ( ARROBA )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:475:16: ARROBA
			{
			root_0 = (Object)adaptor.nil();


			ARROBA271=(Token)match(input,ARROBA,FOLLOW_ARROBA_in_previous_rel2836); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ARROBA271_tree = (Object)adaptor.create(ARROBA271);
			adaptor.addChild(root_0, ARROBA271_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "previous_rel"


	public static class store_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "store_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:478:1: store_clause : STORE ^ rel INTO ! QUOTEDSTRING ( USING ! func_clause )? ;
	public final QueryParser.store_clause_return store_clause() throws RecognitionException {
		QueryParser.store_clause_return retval = new QueryParser.store_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token STORE272=null;
		Token INTO274=null;
		Token QUOTEDSTRING275=null;
		Token USING276=null;
		ParserRuleReturnScope rel273 =null;
		ParserRuleReturnScope func_clause277 =null;

		Object STORE272_tree=null;
		Object INTO274_tree=null;
		Object QUOTEDSTRING275_tree=null;
		Object USING276_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:478:14: ( STORE ^ rel INTO ! QUOTEDSTRING ( USING ! func_clause )? )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:478:16: STORE ^ rel INTO ! QUOTEDSTRING ( USING ! func_clause )?
			{
			root_0 = (Object)adaptor.nil();


			STORE272=(Token)match(input,STORE,FOLLOW_STORE_in_store_clause2845); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			STORE272_tree = (Object)adaptor.create(STORE272);
			root_0 = (Object)adaptor.becomeRoot(STORE272_tree, root_0);
			}

			pushFollow(FOLLOW_rel_in_store_clause2848);
			rel273=rel();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, rel273.getTree());

			INTO274=(Token)match(input,INTO,FOLLOW_INTO_in_store_clause2850); if (state.failed) return retval;
			QUOTEDSTRING275=(Token)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_store_clause2853); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			QUOTEDSTRING275_tree = (Object)adaptor.create(QUOTEDSTRING275);
			adaptor.addChild(root_0, QUOTEDSTRING275_tree);
			}

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:478:46: ( USING ! func_clause )?
			int alt75=2;
			int LA75_0 = input.LA(1);
			if ( (LA75_0==USING) ) {
				alt75=1;
			}
			switch (alt75) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:478:48: USING ! func_clause
					{
					USING276=(Token)match(input,USING,FOLLOW_USING_in_store_clause2857); if (state.failed) return retval;
					pushFollow(FOLLOW_func_clause_in_store_clause2860);
					func_clause277=func_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, func_clause277.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "store_clause"


	public static class assert_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "assert_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:481:1: assert_clause : ASSERT ^ rel BY ! cond ( COMMA ! QUOTEDSTRING )? ;
	public final QueryParser.assert_clause_return assert_clause() throws RecognitionException {
		QueryParser.assert_clause_return retval = new QueryParser.assert_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ASSERT278=null;
		Token BY280=null;
		Token COMMA282=null;
		Token QUOTEDSTRING283=null;
		ParserRuleReturnScope rel279 =null;
		ParserRuleReturnScope cond281 =null;

		Object ASSERT278_tree=null;
		Object BY280_tree=null;
		Object COMMA282_tree=null;
		Object QUOTEDSTRING283_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:481:15: ( ASSERT ^ rel BY ! cond ( COMMA ! QUOTEDSTRING )? )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:481:17: ASSERT ^ rel BY ! cond ( COMMA ! QUOTEDSTRING )?
			{
			root_0 = (Object)adaptor.nil();


			ASSERT278=(Token)match(input,ASSERT,FOLLOW_ASSERT_in_assert_clause2872); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ASSERT278_tree = (Object)adaptor.create(ASSERT278);
			root_0 = (Object)adaptor.becomeRoot(ASSERT278_tree, root_0);
			}

			pushFollow(FOLLOW_rel_in_assert_clause2875);
			rel279=rel();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, rel279.getTree());

			BY280=(Token)match(input,BY,FOLLOW_BY_in_assert_clause2877); if (state.failed) return retval;
			pushFollow(FOLLOW_cond_in_assert_clause2880);
			cond281=cond();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, cond281.getTree());

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:481:38: ( COMMA ! QUOTEDSTRING )?
			int alt76=2;
			int LA76_0 = input.LA(1);
			if ( (LA76_0==COMMA) ) {
				alt76=1;
			}
			switch (alt76) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:481:40: COMMA ! QUOTEDSTRING
					{
					COMMA282=(Token)match(input,COMMA,FOLLOW_COMMA_in_assert_clause2884); if (state.failed) return retval;
					QUOTEDSTRING283=(Token)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_assert_clause2887); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					QUOTEDSTRING283_tree = (Object)adaptor.create(QUOTEDSTRING283);
					adaptor.addChild(root_0, QUOTEDSTRING283_tree);
					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "assert_clause"


	public static class filter_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "filter_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:484:1: filter_clause : FILTER ^ rel BY ! cond ;
	public final QueryParser.filter_clause_return filter_clause() throws RecognitionException {
		QueryParser.filter_clause_return retval = new QueryParser.filter_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token FILTER284=null;
		Token BY286=null;
		ParserRuleReturnScope rel285 =null;
		ParserRuleReturnScope cond287 =null;

		Object FILTER284_tree=null;
		Object BY286_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:484:15: ( FILTER ^ rel BY ! cond )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:484:17: FILTER ^ rel BY ! cond
			{
			root_0 = (Object)adaptor.nil();


			FILTER284=(Token)match(input,FILTER,FOLLOW_FILTER_in_filter_clause2899); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			FILTER284_tree = (Object)adaptor.create(FILTER284);
			root_0 = (Object)adaptor.becomeRoot(FILTER284_tree, root_0);
			}

			pushFollow(FOLLOW_rel_in_filter_clause2902);
			rel285=rel();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, rel285.getTree());

			BY286=(Token)match(input,BY,FOLLOW_BY_in_filter_clause2904); if (state.failed) return retval;
			pushFollow(FOLLOW_cond_in_filter_clause2907);
			cond287=cond();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, cond287.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "filter_clause"


	public static class stream_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "stream_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:487:1: stream_clause : STREAM ^ rel THROUGH ! ( EXECCOMMAND | identifier_plus ) ( as_clause )? ;
	public final QueryParser.stream_clause_return stream_clause() throws RecognitionException {
		QueryParser.stream_clause_return retval = new QueryParser.stream_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token STREAM288=null;
		Token THROUGH290=null;
		Token EXECCOMMAND291=null;
		ParserRuleReturnScope rel289 =null;
		ParserRuleReturnScope identifier_plus292 =null;
		ParserRuleReturnScope as_clause293 =null;

		Object STREAM288_tree=null;
		Object THROUGH290_tree=null;
		Object EXECCOMMAND291_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:487:15: ( STREAM ^ rel THROUGH ! ( EXECCOMMAND | identifier_plus ) ( as_clause )? )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:487:17: STREAM ^ rel THROUGH ! ( EXECCOMMAND | identifier_plus ) ( as_clause )?
			{
			root_0 = (Object)adaptor.nil();


			STREAM288=(Token)match(input,STREAM,FOLLOW_STREAM_in_stream_clause2916); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			STREAM288_tree = (Object)adaptor.create(STREAM288);
			root_0 = (Object)adaptor.becomeRoot(STREAM288_tree, root_0);
			}

			pushFollow(FOLLOW_rel_in_stream_clause2919);
			rel289=rel();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, rel289.getTree());

			THROUGH290=(Token)match(input,THROUGH,FOLLOW_THROUGH_in_stream_clause2921); if (state.failed) return retval;
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:487:38: ( EXECCOMMAND | identifier_plus )
			int alt77=2;
			int LA77_0 = input.LA(1);
			if ( (LA77_0==EXECCOMMAND) ) {
				alt77=1;
			}
			else if ( (LA77_0==CUBE||(LA77_0 >= ELSE && LA77_0 <= END)||LA77_0==IDENTIFIER||LA77_0==IN||LA77_0==RANK||LA77_0==THEN||LA77_0==WHEN) ) {
				alt77=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 77, 0, input);
				throw nvae;
			}

			switch (alt77) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:487:40: EXECCOMMAND
					{
					EXECCOMMAND291=(Token)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_stream_clause2926); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					EXECCOMMAND291_tree = (Object)adaptor.create(EXECCOMMAND291);
					adaptor.addChild(root_0, EXECCOMMAND291_tree);
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:487:54: identifier_plus
					{
					pushFollow(FOLLOW_identifier_plus_in_stream_clause2930);
					identifier_plus292=identifier_plus();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, identifier_plus292.getTree());

					}
					break;

			}

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:487:72: ( as_clause )?
			int alt78=2;
			int LA78_0 = input.LA(1);
			if ( (LA78_0==AS) ) {
				alt78=1;
			}
			switch (alt78) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:487:72: as_clause
					{
					pushFollow(FOLLOW_as_clause_in_stream_clause2934);
					as_clause293=as_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, as_clause293.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "stream_clause"


	public static class mr_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "mr_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:490:1: mr_clause : MAPREDUCE ^ QUOTEDSTRING ( LEFT_PAREN ! path_list RIGHT_PAREN !)? store_clause load_clause ( EXECCOMMAND )? ;
	public final QueryParser.mr_clause_return mr_clause() throws RecognitionException {
		QueryParser.mr_clause_return retval = new QueryParser.mr_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token MAPREDUCE294=null;
		Token QUOTEDSTRING295=null;
		Token LEFT_PAREN296=null;
		Token RIGHT_PAREN298=null;
		Token EXECCOMMAND301=null;
		ParserRuleReturnScope path_list297 =null;
		ParserRuleReturnScope store_clause299 =null;
		ParserRuleReturnScope load_clause300 =null;

		Object MAPREDUCE294_tree=null;
		Object QUOTEDSTRING295_tree=null;
		Object LEFT_PAREN296_tree=null;
		Object RIGHT_PAREN298_tree=null;
		Object EXECCOMMAND301_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:490:11: ( MAPREDUCE ^ QUOTEDSTRING ( LEFT_PAREN ! path_list RIGHT_PAREN !)? store_clause load_clause ( EXECCOMMAND )? )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:490:13: MAPREDUCE ^ QUOTEDSTRING ( LEFT_PAREN ! path_list RIGHT_PAREN !)? store_clause load_clause ( EXECCOMMAND )?
			{
			root_0 = (Object)adaptor.nil();


			MAPREDUCE294=(Token)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_mr_clause2944); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			MAPREDUCE294_tree = (Object)adaptor.create(MAPREDUCE294);
			root_0 = (Object)adaptor.becomeRoot(MAPREDUCE294_tree, root_0);
			}

			QUOTEDSTRING295=(Token)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_mr_clause2947); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			QUOTEDSTRING295_tree = (Object)adaptor.create(QUOTEDSTRING295);
			adaptor.addChild(root_0, QUOTEDSTRING295_tree);
			}

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:490:37: ( LEFT_PAREN ! path_list RIGHT_PAREN !)?
			int alt79=2;
			int LA79_0 = input.LA(1);
			if ( (LA79_0==LEFT_PAREN) ) {
				alt79=1;
			}
			switch (alt79) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:490:39: LEFT_PAREN ! path_list RIGHT_PAREN !
					{
					LEFT_PAREN296=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_mr_clause2951); if (state.failed) return retval;
					pushFollow(FOLLOW_path_list_in_mr_clause2954);
					path_list297=path_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, path_list297.getTree());

					RIGHT_PAREN298=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_mr_clause2956); if (state.failed) return retval;
					}
					break;

			}

			pushFollow(FOLLOW_store_clause_in_mr_clause2962);
			store_clause299=store_clause();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, store_clause299.getTree());

			pushFollow(FOLLOW_load_clause_in_mr_clause2964);
			load_clause300=load_clause();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, load_clause300.getTree());

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:490:102: ( EXECCOMMAND )?
			int alt80=2;
			int LA80_0 = input.LA(1);
			if ( (LA80_0==EXECCOMMAND) ) {
				alt80=1;
			}
			switch (alt80) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:490:102: EXECCOMMAND
					{
					EXECCOMMAND301=(Token)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_mr_clause2966); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					EXECCOMMAND301_tree = (Object)adaptor.create(EXECCOMMAND301);
					adaptor.addChild(root_0, EXECCOMMAND301_tree);
					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "mr_clause"


	public static class split_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "split_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:493:1: split_clause : SPLIT ^ rel INTO ! split_branch split_branches ;
	public final QueryParser.split_clause_return split_clause() throws RecognitionException {
		QueryParser.split_clause_return retval = new QueryParser.split_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SPLIT302=null;
		Token INTO304=null;
		ParserRuleReturnScope rel303 =null;
		ParserRuleReturnScope split_branch305 =null;
		ParserRuleReturnScope split_branches306 =null;

		Object SPLIT302_tree=null;
		Object INTO304_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:493:14: ( SPLIT ^ rel INTO ! split_branch split_branches )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:493:16: SPLIT ^ rel INTO ! split_branch split_branches
			{
			root_0 = (Object)adaptor.nil();


			SPLIT302=(Token)match(input,SPLIT,FOLLOW_SPLIT_in_split_clause2976); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			SPLIT302_tree = (Object)adaptor.create(SPLIT302);
			root_0 = (Object)adaptor.becomeRoot(SPLIT302_tree, root_0);
			}

			pushFollow(FOLLOW_rel_in_split_clause2979);
			rel303=rel();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, rel303.getTree());

			INTO304=(Token)match(input,INTO,FOLLOW_INTO_in_split_clause2981); if (state.failed) return retval;
			pushFollow(FOLLOW_split_branch_in_split_clause2984);
			split_branch305=split_branch();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, split_branch305.getTree());

			pushFollow(FOLLOW_split_branches_in_split_clause2986);
			split_branches306=split_branches();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, split_branches306.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "split_clause"


	public static class split_branch_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "split_branch"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:496:1: split_branch : identifier_plus IF cond -> ^( SPLIT_BRANCH identifier_plus cond ) ;
	public final QueryParser.split_branch_return split_branch() throws RecognitionException {
		QueryParser.split_branch_return retval = new QueryParser.split_branch_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token IF308=null;
		ParserRuleReturnScope identifier_plus307 =null;
		ParserRuleReturnScope cond309 =null;

		Object IF308_tree=null;
		RewriteRuleTokenStream stream_IF=new RewriteRuleTokenStream(adaptor,"token IF");
		RewriteRuleSubtreeStream stream_identifier_plus=new RewriteRuleSubtreeStream(adaptor,"rule identifier_plus");
		RewriteRuleSubtreeStream stream_cond=new RewriteRuleSubtreeStream(adaptor,"rule cond");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:496:14: ( identifier_plus IF cond -> ^( SPLIT_BRANCH identifier_plus cond ) )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:496:16: identifier_plus IF cond
			{
			pushFollow(FOLLOW_identifier_plus_in_split_branch2995);
			identifier_plus307=identifier_plus();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_identifier_plus.add(identifier_plus307.getTree());
			IF308=(Token)match(input,IF,FOLLOW_IF_in_split_branch2997); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IF.add(IF308);

			pushFollow(FOLLOW_cond_in_split_branch2999);
			cond309=cond();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_cond.add(cond309.getTree());
			// AST REWRITE
			// elements: identifier_plus, cond
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 496:40: -> ^( SPLIT_BRANCH identifier_plus cond )
			{
				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:496:43: ^( SPLIT_BRANCH identifier_plus cond )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SPLIT_BRANCH, "SPLIT_BRANCH"), root_1);
				adaptor.addChild(root_1, stream_identifier_plus.nextTree());
				adaptor.addChild(root_1, stream_cond.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "split_branch"


	public static class split_otherwise_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "split_otherwise"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:499:1: split_otherwise : identifier_plus OTHERWISE ^;
	public final QueryParser.split_otherwise_return split_otherwise() throws RecognitionException {
		QueryParser.split_otherwise_return retval = new QueryParser.split_otherwise_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token OTHERWISE311=null;
		ParserRuleReturnScope identifier_plus310 =null;

		Object OTHERWISE311_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:499:17: ( identifier_plus OTHERWISE ^)
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:499:19: identifier_plus OTHERWISE ^
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_identifier_plus_in_split_otherwise3020);
			identifier_plus310=identifier_plus();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, identifier_plus310.getTree());

			OTHERWISE311=(Token)match(input,OTHERWISE,FOLLOW_OTHERWISE_in_split_otherwise3022); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			OTHERWISE311_tree = (Object)adaptor.create(OTHERWISE311);
			root_0 = (Object)adaptor.becomeRoot(OTHERWISE311_tree, root_0);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "split_otherwise"


	public static class split_branches_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "split_branches"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:502:1: split_branches : ( COMMA ! split_branch ( split_branches )? | COMMA ! split_otherwise );
	public final QueryParser.split_branches_return split_branches() throws RecognitionException {
		QueryParser.split_branches_return retval = new QueryParser.split_branches_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA312=null;
		Token COMMA315=null;
		ParserRuleReturnScope split_branch313 =null;
		ParserRuleReturnScope split_branches314 =null;
		ParserRuleReturnScope split_otherwise316 =null;

		Object COMMA312_tree=null;
		Object COMMA315_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:502:16: ( COMMA ! split_branch ( split_branches )? | COMMA ! split_otherwise )
			int alt82=2;
			int LA82_0 = input.LA(1);
			if ( (LA82_0==COMMA) ) {
				int LA82_1 = input.LA(2);
				if ( (LA82_1==IDENTIFIER) ) {
					int LA82_2 = input.LA(3);
					if ( (LA82_2==IF) ) {
						alt82=1;
					}
					else if ( (LA82_2==OTHERWISE) ) {
						alt82=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 82, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA82_1==CUBE||(LA82_1 >= ELSE && LA82_1 <= END)||LA82_1==IN||LA82_1==RANK||LA82_1==THEN||LA82_1==WHEN) ) {
					int LA82_3 = input.LA(3);
					if ( (LA82_3==IF) ) {
						alt82=1;
					}
					else if ( (LA82_3==OTHERWISE) ) {
						alt82=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 82, 3, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 82, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 82, 0, input);
				throw nvae;
			}

			switch (alt82) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:502:18: COMMA ! split_branch ( split_branches )?
					{
					root_0 = (Object)adaptor.nil();


					COMMA312=(Token)match(input,COMMA,FOLLOW_COMMA_in_split_branches3032); if (state.failed) return retval;
					pushFollow(FOLLOW_split_branch_in_split_branches3035);
					split_branch313=split_branch();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, split_branch313.getTree());

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:502:38: ( split_branches )?
					int alt81=2;
					int LA81_0 = input.LA(1);
					if ( (LA81_0==COMMA) ) {
						alt81=1;
					}
					switch (alt81) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:502:38: split_branches
							{
							pushFollow(FOLLOW_split_branches_in_split_branches3037);
							split_branches314=split_branches();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, split_branches314.getTree());

							}
							break;

					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:503:18: COMMA ! split_otherwise
					{
					root_0 = (Object)adaptor.nil();


					COMMA315=(Token)match(input,COMMA,FOLLOW_COMMA_in_split_branches3057); if (state.failed) return retval;
					pushFollow(FOLLOW_split_otherwise_in_split_branches3060);
					split_otherwise316=split_otherwise();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, split_otherwise316.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "split_branches"


	public static class limit_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "limit_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:506:1: limit_clause : LIMIT ^ rel expr ;
	public final QueryParser.limit_clause_return limit_clause() throws RecognitionException {
		QueryParser.limit_clause_return retval = new QueryParser.limit_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LIMIT317=null;
		ParserRuleReturnScope rel318 =null;
		ParserRuleReturnScope expr319 =null;

		Object LIMIT317_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:506:14: ( LIMIT ^ rel expr )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:506:16: LIMIT ^ rel expr
			{
			root_0 = (Object)adaptor.nil();


			LIMIT317=(Token)match(input,LIMIT,FOLLOW_LIMIT_in_limit_clause3069); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LIMIT317_tree = (Object)adaptor.create(LIMIT317);
			root_0 = (Object)adaptor.becomeRoot(LIMIT317_tree, root_0);
			}

			pushFollow(FOLLOW_rel_in_limit_clause3072);
			rel318=rel();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, rel318.getTree());

			pushFollow(FOLLOW_expr_in_limit_clause3074);
			expr319=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expr319.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "limit_clause"


	public static class sample_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "sample_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:509:1: sample_clause : SAMPLE ^ rel expr ;
	public final QueryParser.sample_clause_return sample_clause() throws RecognitionException {
		QueryParser.sample_clause_return retval = new QueryParser.sample_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SAMPLE320=null;
		ParserRuleReturnScope rel321 =null;
		ParserRuleReturnScope expr322 =null;

		Object SAMPLE320_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:509:15: ( SAMPLE ^ rel expr )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:509:17: SAMPLE ^ rel expr
			{
			root_0 = (Object)adaptor.nil();


			SAMPLE320=(Token)match(input,SAMPLE,FOLLOW_SAMPLE_in_sample_clause3083); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			SAMPLE320_tree = (Object)adaptor.create(SAMPLE320);
			root_0 = (Object)adaptor.becomeRoot(SAMPLE320_tree, root_0);
			}

			pushFollow(FOLLOW_rel_in_sample_clause3086);
			rel321=rel();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, rel321.getTree());

			pushFollow(FOLLOW_expr_in_sample_clause3088);
			expr322=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expr322.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "sample_clause"


	public static class rank_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "rank_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:512:1: rank_clause : RANK ^ rel ( rank_by_statement )? ;
	public final QueryParser.rank_clause_return rank_clause() throws RecognitionException {
		QueryParser.rank_clause_return retval = new QueryParser.rank_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token RANK323=null;
		ParserRuleReturnScope rel324 =null;
		ParserRuleReturnScope rank_by_statement325 =null;

		Object RANK323_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:512:13: ( RANK ^ rel ( rank_by_statement )? )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:512:15: RANK ^ rel ( rank_by_statement )?
			{
			root_0 = (Object)adaptor.nil();


			RANK323=(Token)match(input,RANK,FOLLOW_RANK_in_rank_clause3097); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RANK323_tree = (Object)adaptor.create(RANK323);
			root_0 = (Object)adaptor.becomeRoot(RANK323_tree, root_0);
			}

			pushFollow(FOLLOW_rel_in_rank_clause3100);
			rel324=rel();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, rel324.getTree());

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:512:25: ( rank_by_statement )?
			int alt83=2;
			int LA83_0 = input.LA(1);
			if ( (LA83_0==BY) ) {
				alt83=1;
			}
			switch (alt83) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:512:27: rank_by_statement
					{
					pushFollow(FOLLOW_rank_by_statement_in_rank_clause3104);
					rank_by_statement325=rank_by_statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rank_by_statement325.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rank_clause"


	public static class rank_by_statement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "rank_by_statement"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:515:1: rank_by_statement : BY ^ rank_by_clause ( DENSE )? ;
	public final QueryParser.rank_by_statement_return rank_by_statement() throws RecognitionException {
		QueryParser.rank_by_statement_return retval = new QueryParser.rank_by_statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token BY326=null;
		Token DENSE328=null;
		ParserRuleReturnScope rank_by_clause327 =null;

		Object BY326_tree=null;
		Object DENSE328_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:515:19: ( BY ^ rank_by_clause ( DENSE )? )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:515:21: BY ^ rank_by_clause ( DENSE )?
			{
			root_0 = (Object)adaptor.nil();


			BY326=(Token)match(input,BY,FOLLOW_BY_in_rank_by_statement3116); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			BY326_tree = (Object)adaptor.create(BY326);
			root_0 = (Object)adaptor.becomeRoot(BY326_tree, root_0);
			}

			pushFollow(FOLLOW_rank_by_clause_in_rank_by_statement3119);
			rank_by_clause327=rank_by_clause();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, rank_by_clause327.getTree());

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:515:40: ( DENSE )?
			int alt84=2;
			int LA84_0 = input.LA(1);
			if ( (LA84_0==DENSE) ) {
				alt84=1;
			}
			switch (alt84) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:515:40: DENSE
					{
					DENSE328=(Token)match(input,DENSE,FOLLOW_DENSE_in_rank_by_statement3121); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DENSE328_tree = (Object)adaptor.create(DENSE328);
					adaptor.addChild(root_0, DENSE328_tree);
					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rank_by_statement"


	public static class rank_by_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "rank_by_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:518:1: rank_by_clause : ( STAR ( ASC | DESC )? | rank_list );
	public final QueryParser.rank_by_clause_return rank_by_clause() throws RecognitionException {
		QueryParser.rank_by_clause_return retval = new QueryParser.rank_by_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token STAR329=null;
		Token set330=null;
		ParserRuleReturnScope rank_list331 =null;

		Object STAR329_tree=null;
		Object set330_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:518:16: ( STAR ( ASC | DESC )? | rank_list )
			int alt86=2;
			int LA86_0 = input.LA(1);
			if ( (LA86_0==STAR) ) {
				alt86=1;
			}
			else if ( (LA86_0==CUBE||LA86_0==DOLLARVAR||(LA86_0 >= DOUBLE_PERIOD && LA86_0 <= END)||LA86_0==GROUP||LA86_0==IDENTIFIER||LA86_0==IN||LA86_0==RANK||LA86_0==THEN||LA86_0==WHEN) ) {
				alt86=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 86, 0, input);
				throw nvae;
			}

			switch (alt86) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:518:18: STAR ( ASC | DESC )?
					{
					root_0 = (Object)adaptor.nil();


					STAR329=(Token)match(input,STAR,FOLLOW_STAR_in_rank_by_clause3131); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STAR329_tree = (Object)adaptor.create(STAR329);
					adaptor.addChild(root_0, STAR329_tree);
					}

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:518:23: ( ASC | DESC )?
					int alt85=2;
					int LA85_0 = input.LA(1);
					if ( (LA85_0==ASC||LA85_0==DESC) ) {
						alt85=1;
					}
					switch (alt85) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:
							{
							set330=input.LT(1);
							if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
								input.consume();
								if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set330));
								state.errorRecovery=false;
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:519:18: rank_list
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_rank_list_in_rank_by_clause3161);
					rank_list331=rank_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rank_list331.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rank_by_clause"


	public static class rank_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "rank_list"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:522:1: rank_list : rank_col ( COMMA rank_col )* -> ( rank_col )+ ;
	public final QueryParser.rank_list_return rank_list() throws RecognitionException {
		QueryParser.rank_list_return retval = new QueryParser.rank_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA333=null;
		ParserRuleReturnScope rank_col332 =null;
		ParserRuleReturnScope rank_col334 =null;

		Object COMMA333_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_rank_col=new RewriteRuleSubtreeStream(adaptor,"rule rank_col");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:522:11: ( rank_col ( COMMA rank_col )* -> ( rank_col )+ )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:522:13: rank_col ( COMMA rank_col )*
			{
			pushFollow(FOLLOW_rank_col_in_rank_list3170);
			rank_col332=rank_col();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_rank_col.add(rank_col332.getTree());
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:522:22: ( COMMA rank_col )*
			loop87:
			while (true) {
				int alt87=2;
				int LA87_0 = input.LA(1);
				if ( (LA87_0==COMMA) ) {
					alt87=1;
				}

				switch (alt87) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:522:24: COMMA rank_col
					{
					COMMA333=(Token)match(input,COMMA,FOLLOW_COMMA_in_rank_list3174); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COMMA.add(COMMA333);

					pushFollow(FOLLOW_rank_col_in_rank_list3176);
					rank_col334=rank_col();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_rank_col.add(rank_col334.getTree());
					}
					break;

				default :
					break loop87;
				}
			}

			// AST REWRITE
			// elements: rank_col
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 523:10: -> ( rank_col )+
			{
				if ( !(stream_rank_col.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_rank_col.hasNext() ) {
					adaptor.addChild(root_0, stream_rank_col.nextTree());
				}
				stream_rank_col.reset();

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rank_list"


	public static class rank_col_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "rank_col"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:526:1: rank_col : ( col_range ( ASC | DESC )? | col_ref ( ASC | DESC )? );
	public final QueryParser.rank_col_return rank_col() throws RecognitionException {
		QueryParser.rank_col_return retval = new QueryParser.rank_col_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set336=null;
		Token set338=null;
		ParserRuleReturnScope col_range335 =null;
		ParserRuleReturnScope col_ref337 =null;

		Object set336_tree=null;
		Object set338_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:526:10: ( col_range ( ASC | DESC )? | col_ref ( ASC | DESC )? )
			int alt90=2;
			switch ( input.LA(1) ) {
			case DOLLARVAR:
			case GROUP:
				{
				int LA90_1 = input.LA(2);
				if ( (LA90_1==DOUBLE_PERIOD) ) {
					alt90=1;
				}
				else if ( (LA90_1==ASC||LA90_1==COMMA||(LA90_1 >= DENSE && LA90_1 <= DESC)||LA90_1==PARALLEL||LA90_1==RIGHT_PAREN||LA90_1==SEMI_COLON) ) {
					alt90=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 90, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case IDENTIFIER:
				{
				int LA90_2 = input.LA(2);
				if ( (LA90_2==DOUBLE_PERIOD) ) {
					alt90=1;
				}
				else if ( (LA90_2==ASC||LA90_2==COMMA||(LA90_2 >= DENSE && LA90_2 <= DESC)||LA90_2==PARALLEL||LA90_2==RIGHT_PAREN||LA90_2==SEMI_COLON) ) {
					alt90=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 90, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case CUBE:
			case ELSE:
			case END:
			case IN:
			case RANK:
			case THEN:
			case WHEN:
				{
				int LA90_3 = input.LA(2);
				if ( (LA90_3==DOUBLE_PERIOD) ) {
					alt90=1;
				}
				else if ( (LA90_3==ASC||LA90_3==COMMA||(LA90_3 >= DENSE && LA90_3 <= DESC)||LA90_3==PARALLEL||LA90_3==RIGHT_PAREN||LA90_3==SEMI_COLON) ) {
					alt90=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 90, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case DOUBLE_PERIOD:
				{
				alt90=1;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 90, 0, input);
				throw nvae;
			}
			switch (alt90) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:526:12: col_range ( ASC | DESC )?
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_col_range_in_rank_col3202);
					col_range335=col_range();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, col_range335.getTree());

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:526:22: ( ASC | DESC )?
					int alt88=2;
					int LA88_0 = input.LA(1);
					if ( (LA88_0==ASC||LA88_0==DESC) ) {
						alt88=1;
					}
					switch (alt88) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:
							{
							set336=input.LT(1);
							if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
								input.consume();
								if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set336));
								state.errorRecovery=false;
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:527:12: col_ref ( ASC | DESC )?
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_col_ref_in_rank_col3226);
					col_ref337=col_ref();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, col_ref337.getTree());

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:527:20: ( ASC | DESC )?
					int alt89=2;
					int LA89_0 = input.LA(1);
					if ( (LA89_0==ASC||LA89_0==DESC) ) {
						alt89=1;
					}
					switch (alt89) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:
							{
							set338=input.LT(1);
							if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
								input.consume();
								if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set338));
								state.errorRecovery=false;
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rank_col"


	public static class order_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "order_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:530:1: order_clause : ORDER ^ rel BY ! order_by_clause ( USING ! func_clause )? ;
	public final QueryParser.order_clause_return order_clause() throws RecognitionException {
		QueryParser.order_clause_return retval = new QueryParser.order_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ORDER339=null;
		Token BY341=null;
		Token USING343=null;
		ParserRuleReturnScope rel340 =null;
		ParserRuleReturnScope order_by_clause342 =null;
		ParserRuleReturnScope func_clause344 =null;

		Object ORDER339_tree=null;
		Object BY341_tree=null;
		Object USING343_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:530:14: ( ORDER ^ rel BY ! order_by_clause ( USING ! func_clause )? )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:530:16: ORDER ^ rel BY ! order_by_clause ( USING ! func_clause )?
			{
			root_0 = (Object)adaptor.nil();


			ORDER339=(Token)match(input,ORDER,FOLLOW_ORDER_in_order_clause3246); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ORDER339_tree = (Object)adaptor.create(ORDER339);
			root_0 = (Object)adaptor.becomeRoot(ORDER339_tree, root_0);
			}

			pushFollow(FOLLOW_rel_in_order_clause3249);
			rel340=rel();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, rel340.getTree());

			BY341=(Token)match(input,BY,FOLLOW_BY_in_order_clause3251); if (state.failed) return retval;
			pushFollow(FOLLOW_order_by_clause_in_order_clause3254);
			order_by_clause342=order_by_clause();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, order_by_clause342.getTree());

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:530:47: ( USING ! func_clause )?
			int alt91=2;
			int LA91_0 = input.LA(1);
			if ( (LA91_0==USING) ) {
				alt91=1;
			}
			switch (alt91) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:530:49: USING ! func_clause
					{
					USING343=(Token)match(input,USING,FOLLOW_USING_in_order_clause3258); if (state.failed) return retval;
					pushFollow(FOLLOW_func_clause_in_order_clause3261);
					func_clause344=func_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, func_clause344.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "order_clause"


	public static class order_by_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "order_by_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:533:1: order_by_clause : ( STAR ( ASC | DESC )? | order_col_list );
	public final QueryParser.order_by_clause_return order_by_clause() throws RecognitionException {
		QueryParser.order_by_clause_return retval = new QueryParser.order_by_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token STAR345=null;
		Token set346=null;
		ParserRuleReturnScope order_col_list347 =null;

		Object STAR345_tree=null;
		Object set346_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:533:17: ( STAR ( ASC | DESC )? | order_col_list )
			int alt93=2;
			int LA93_0 = input.LA(1);
			if ( (LA93_0==STAR) ) {
				alt93=1;
			}
			else if ( (LA93_0==CUBE||LA93_0==DOLLARVAR||(LA93_0 >= DOUBLE_PERIOD && LA93_0 <= END)||LA93_0==GROUP||LA93_0==IDENTIFIER||LA93_0==IN||LA93_0==LEFT_PAREN||LA93_0==RANK||LA93_0==THEN||LA93_0==WHEN) ) {
				alt93=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 93, 0, input);
				throw nvae;
			}

			switch (alt93) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:533:19: STAR ( ASC | DESC )?
					{
					root_0 = (Object)adaptor.nil();


					STAR345=(Token)match(input,STAR,FOLLOW_STAR_in_order_by_clause3273); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STAR345_tree = (Object)adaptor.create(STAR345);
					adaptor.addChild(root_0, STAR345_tree);
					}

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:533:24: ( ASC | DESC )?
					int alt92=2;
					int LA92_0 = input.LA(1);
					if ( (LA92_0==ASC||LA92_0==DESC) ) {
						alt92=1;
					}
					switch (alt92) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:
							{
							set346=input.LT(1);
							if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
								input.consume();
								if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set346));
								state.errorRecovery=false;
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:534:19: order_col_list
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_order_col_list_in_order_by_clause3304);
					order_col_list347=order_col_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, order_col_list347.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "order_by_clause"


	public static class order_col_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "order_col_list"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:537:1: order_col_list : order_col ( COMMA order_col )* -> ( order_col )+ ;
	public final QueryParser.order_col_list_return order_col_list() throws RecognitionException {
		QueryParser.order_col_list_return retval = new QueryParser.order_col_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA349=null;
		ParserRuleReturnScope order_col348 =null;
		ParserRuleReturnScope order_col350 =null;

		Object COMMA349_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_order_col=new RewriteRuleSubtreeStream(adaptor,"rule order_col");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:537:16: ( order_col ( COMMA order_col )* -> ( order_col )+ )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:537:18: order_col ( COMMA order_col )*
			{
			pushFollow(FOLLOW_order_col_in_order_col_list3313);
			order_col348=order_col();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_order_col.add(order_col348.getTree());
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:537:28: ( COMMA order_col )*
			loop94:
			while (true) {
				int alt94=2;
				int LA94_0 = input.LA(1);
				if ( (LA94_0==COMMA) ) {
					alt94=1;
				}

				switch (alt94) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:537:30: COMMA order_col
					{
					COMMA349=(Token)match(input,COMMA,FOLLOW_COMMA_in_order_col_list3317); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COMMA.add(COMMA349);

					pushFollow(FOLLOW_order_col_in_order_col_list3319);
					order_col350=order_col();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_order_col.add(order_col350.getTree());
					}
					break;

				default :
					break loop94;
				}
			}

			// AST REWRITE
			// elements: order_col
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 538:15: -> ( order_col )+
			{
				if ( !(stream_order_col.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_order_col.hasNext() ) {
					adaptor.addChild(root_0, stream_order_col.nextTree());
				}
				stream_order_col.reset();

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "order_col_list"


	public static class order_col_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "order_col"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:541:1: order_col : ( col_range ( ASC | DESC )? | col_ref ( ASC | DESC )? | LEFT_PAREN ! col_ref ( ASC | DESC )? RIGHT_PAREN !);
	public final QueryParser.order_col_return order_col() throws RecognitionException {
		QueryParser.order_col_return retval = new QueryParser.order_col_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set352=null;
		Token set354=null;
		Token LEFT_PAREN355=null;
		Token set357=null;
		Token RIGHT_PAREN358=null;
		ParserRuleReturnScope col_range351 =null;
		ParserRuleReturnScope col_ref353 =null;
		ParserRuleReturnScope col_ref356 =null;

		Object set352_tree=null;
		Object set354_tree=null;
		Object LEFT_PAREN355_tree=null;
		Object set357_tree=null;
		Object RIGHT_PAREN358_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:541:11: ( col_range ( ASC | DESC )? | col_ref ( ASC | DESC )? | LEFT_PAREN ! col_ref ( ASC | DESC )? RIGHT_PAREN !)
			int alt98=3;
			switch ( input.LA(1) ) {
			case DOLLARVAR:
			case GROUP:
				{
				int LA98_1 = input.LA(2);
				if ( (LA98_1==DOUBLE_PERIOD) ) {
					alt98=1;
				}
				else if ( (LA98_1==ASC||LA98_1==COMMA||LA98_1==DESC||LA98_1==PARALLEL||LA98_1==RIGHT_PAREN||LA98_1==SEMI_COLON||LA98_1==USING) ) {
					alt98=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 98, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case IDENTIFIER:
				{
				int LA98_2 = input.LA(2);
				if ( (LA98_2==DOUBLE_PERIOD) ) {
					alt98=1;
				}
				else if ( (LA98_2==ASC||LA98_2==COMMA||LA98_2==DESC||LA98_2==PARALLEL||LA98_2==RIGHT_PAREN||LA98_2==SEMI_COLON||LA98_2==USING) ) {
					alt98=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 98, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case CUBE:
			case ELSE:
			case END:
			case IN:
			case RANK:
			case THEN:
			case WHEN:
				{
				int LA98_3 = input.LA(2);
				if ( (LA98_3==DOUBLE_PERIOD) ) {
					alt98=1;
				}
				else if ( (LA98_3==ASC||LA98_3==COMMA||LA98_3==DESC||LA98_3==PARALLEL||LA98_3==RIGHT_PAREN||LA98_3==SEMI_COLON||LA98_3==USING) ) {
					alt98=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 98, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case DOUBLE_PERIOD:
				{
				alt98=1;
				}
				break;
			case LEFT_PAREN:
				{
				alt98=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 98, 0, input);
				throw nvae;
			}
			switch (alt98) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:541:13: col_range ( ASC | DESC )?
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_col_range_in_order_col3350);
					col_range351=col_range();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, col_range351.getTree());

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:541:23: ( ASC | DESC )?
					int alt95=2;
					int LA95_0 = input.LA(1);
					if ( (LA95_0==ASC||LA95_0==DESC) ) {
						alt95=1;
					}
					switch (alt95) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:
							{
							set352=input.LT(1);
							if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
								input.consume();
								if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set352));
								state.errorRecovery=false;
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:542:13: col_ref ( ASC | DESC )?
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_col_ref_in_order_col3373);
					col_ref353=col_ref();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, col_ref353.getTree());

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:542:21: ( ASC | DESC )?
					int alt96=2;
					int LA96_0 = input.LA(1);
					if ( (LA96_0==ASC||LA96_0==DESC) ) {
						alt96=1;
					}
					switch (alt96) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:
							{
							set354=input.LT(1);
							if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
								input.consume();
								if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set354));
								state.errorRecovery=false;
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:543:13: LEFT_PAREN ! col_ref ( ASC | DESC )? RIGHT_PAREN !
					{
					root_0 = (Object)adaptor.nil();


					LEFT_PAREN355=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_order_col3398); if (state.failed) return retval;
					pushFollow(FOLLOW_col_ref_in_order_col3401);
					col_ref356=col_ref();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, col_ref356.getTree());

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:543:33: ( ASC | DESC )?
					int alt97=2;
					int LA97_0 = input.LA(1);
					if ( (LA97_0==ASC||LA97_0==DESC) ) {
						alt97=1;
					}
					switch (alt97) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:
							{
							set357=input.LT(1);
							if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
								input.consume();
								if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set357));
								state.errorRecovery=false;
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					RIGHT_PAREN358=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_order_col3414); if (state.failed) return retval;
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "order_col"


	public static class distinct_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "distinct_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:546:1: distinct_clause : DISTINCT ^ rel ( partition_clause )? ;
	public final QueryParser.distinct_clause_return distinct_clause() throws RecognitionException {
		QueryParser.distinct_clause_return retval = new QueryParser.distinct_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token DISTINCT359=null;
		ParserRuleReturnScope rel360 =null;
		ParserRuleReturnScope partition_clause361 =null;

		Object DISTINCT359_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:546:17: ( DISTINCT ^ rel ( partition_clause )? )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:546:19: DISTINCT ^ rel ( partition_clause )?
			{
			root_0 = (Object)adaptor.nil();


			DISTINCT359=(Token)match(input,DISTINCT,FOLLOW_DISTINCT_in_distinct_clause3424); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			DISTINCT359_tree = (Object)adaptor.create(DISTINCT359);
			root_0 = (Object)adaptor.becomeRoot(DISTINCT359_tree, root_0);
			}

			pushFollow(FOLLOW_rel_in_distinct_clause3427);
			rel360=rel();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, rel360.getTree());

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:546:33: ( partition_clause )?
			int alt99=2;
			int LA99_0 = input.LA(1);
			if ( (LA99_0==PARTITION) ) {
				alt99=1;
			}
			switch (alt99) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:546:33: partition_clause
					{
					pushFollow(FOLLOW_partition_clause_in_distinct_clause3429);
					partition_clause361=partition_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, partition_clause361.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "distinct_clause"


	public static class partition_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "partition_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:549:1: partition_clause : PARTITION ^ BY ! func_name ;
	public final QueryParser.partition_clause_return partition_clause() throws RecognitionException {
		QueryParser.partition_clause_return retval = new QueryParser.partition_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token PARTITION362=null;
		Token BY363=null;
		ParserRuleReturnScope func_name364 =null;

		Object PARTITION362_tree=null;
		Object BY363_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:549:18: ( PARTITION ^ BY ! func_name )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:549:20: PARTITION ^ BY ! func_name
			{
			root_0 = (Object)adaptor.nil();


			PARTITION362=(Token)match(input,PARTITION,FOLLOW_PARTITION_in_partition_clause3439); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			PARTITION362_tree = (Object)adaptor.create(PARTITION362);
			root_0 = (Object)adaptor.becomeRoot(PARTITION362_tree, root_0);
			}

			BY363=(Token)match(input,BY,FOLLOW_BY_in_partition_clause3442); if (state.failed) return retval;
			pushFollow(FOLLOW_func_name_in_partition_clause3445);
			func_name364=func_name();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, func_name364.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "partition_clause"


	public static class rel_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "rel_list"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:552:1: rel_list : rel ( COMMA rel )* -> ( rel )+ ;
	public final QueryParser.rel_list_return rel_list() throws RecognitionException {
		QueryParser.rel_list_return retval = new QueryParser.rel_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA366=null;
		ParserRuleReturnScope rel365 =null;
		ParserRuleReturnScope rel367 =null;

		Object COMMA366_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_rel=new RewriteRuleSubtreeStream(adaptor,"rule rel");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:552:10: ( rel ( COMMA rel )* -> ( rel )+ )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:552:12: rel ( COMMA rel )*
			{
			pushFollow(FOLLOW_rel_in_rel_list3454);
			rel365=rel();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_rel.add(rel365.getTree());
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:552:16: ( COMMA rel )*
			loop100:
			while (true) {
				int alt100=2;
				int LA100_0 = input.LA(1);
				if ( (LA100_0==COMMA) ) {
					alt100=1;
				}

				switch (alt100) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:552:18: COMMA rel
					{
					COMMA366=(Token)match(input,COMMA,FOLLOW_COMMA_in_rel_list3458); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COMMA.add(COMMA366);

					pushFollow(FOLLOW_rel_in_rel_list3460);
					rel367=rel();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_rel.add(rel367.getTree());
					}
					break;

				default :
					break loop100;
				}
			}

			// AST REWRITE
			// elements: rel
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 552:31: -> ( rel )+
			{
				if ( !(stream_rel.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_rel.hasNext() ) {
					adaptor.addChild(root_0, stream_rel.nextTree());
				}
				stream_rel.reset();

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rel_list"


	public static class cross_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "cross_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:555:1: cross_clause : CROSS ^ rel_list ( partition_clause )? ;
	public final QueryParser.cross_clause_return cross_clause() throws RecognitionException {
		QueryParser.cross_clause_return retval = new QueryParser.cross_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token CROSS368=null;
		ParserRuleReturnScope rel_list369 =null;
		ParserRuleReturnScope partition_clause370 =null;

		Object CROSS368_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:555:14: ( CROSS ^ rel_list ( partition_clause )? )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:555:16: CROSS ^ rel_list ( partition_clause )?
			{
			root_0 = (Object)adaptor.nil();


			CROSS368=(Token)match(input,CROSS,FOLLOW_CROSS_in_cross_clause3477); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			CROSS368_tree = (Object)adaptor.create(CROSS368);
			root_0 = (Object)adaptor.becomeRoot(CROSS368_tree, root_0);
			}

			pushFollow(FOLLOW_rel_list_in_cross_clause3480);
			rel_list369=rel_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, rel_list369.getTree());

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:555:32: ( partition_clause )?
			int alt101=2;
			int LA101_0 = input.LA(1);
			if ( (LA101_0==PARTITION) ) {
				alt101=1;
			}
			switch (alt101) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:555:32: partition_clause
					{
					pushFollow(FOLLOW_partition_clause_in_cross_clause3482);
					partition_clause370=partition_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, partition_clause370.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "cross_clause"


	public static class join_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "join_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:559:1: join_clause : JOIN ^ join_sub_clause ( USING ! join_type )? ( partition_clause )? ;
	public final QueryParser.join_clause_return join_clause() throws RecognitionException {
		QueryParser.join_clause_return retval = new QueryParser.join_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token JOIN371=null;
		Token USING373=null;
		ParserRuleReturnScope join_sub_clause372 =null;
		ParserRuleReturnScope join_type374 =null;
		ParserRuleReturnScope partition_clause375 =null;

		Object JOIN371_tree=null;
		Object USING373_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:559:13: ( JOIN ^ join_sub_clause ( USING ! join_type )? ( partition_clause )? )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:559:15: JOIN ^ join_sub_clause ( USING ! join_type )? ( partition_clause )?
			{
			root_0 = (Object)adaptor.nil();


			JOIN371=(Token)match(input,JOIN,FOLLOW_JOIN_in_join_clause3493); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			JOIN371_tree = (Object)adaptor.create(JOIN371);
			root_0 = (Object)adaptor.becomeRoot(JOIN371_tree, root_0);
			}

			pushFollow(FOLLOW_join_sub_clause_in_join_clause3496);
			join_sub_clause372=join_sub_clause();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, join_sub_clause372.getTree());

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:559:37: ( USING ! join_type )?
			int alt102=2;
			int LA102_0 = input.LA(1);
			if ( (LA102_0==USING) ) {
				alt102=1;
			}
			switch (alt102) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:559:39: USING ! join_type
					{
					USING373=(Token)match(input,USING,FOLLOW_USING_in_join_clause3500); if (state.failed) return retval;
					pushFollow(FOLLOW_join_type_in_join_clause3503);
					join_type374=join_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, join_type374.getTree());

					}
					break;

			}

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:559:59: ( partition_clause )?
			int alt103=2;
			int LA103_0 = input.LA(1);
			if ( (LA103_0==PARTITION) ) {
				alt103=1;
			}
			switch (alt103) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:559:59: partition_clause
					{
					pushFollow(FOLLOW_partition_clause_in_join_clause3508);
					partition_clause375=partition_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, partition_clause375.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "join_clause"


	public static class join_type_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "join_type"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:562:1: join_type : QUOTEDSTRING ;
	public final QueryParser.join_type_return join_type() throws RecognitionException {
		QueryParser.join_type_return retval = new QueryParser.join_type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token QUOTEDSTRING376=null;

		Object QUOTEDSTRING376_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:562:11: ( QUOTEDSTRING )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:562:13: QUOTEDSTRING
			{
			root_0 = (Object)adaptor.nil();


			QUOTEDSTRING376=(Token)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_join_type3518); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			QUOTEDSTRING376_tree = (Object)adaptor.create(QUOTEDSTRING376);
			adaptor.addChild(root_0, QUOTEDSTRING376_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "join_type"


	public static class join_sub_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "join_sub_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:565:1: join_sub_clause : join_item ( ( ( LEFT | RIGHT | FULL ) ( OUTER )? COMMA ! join_item ) | ( ( COMMA ! join_item )+ ) ) ;
	public final QueryParser.join_sub_clause_return join_sub_clause() throws RecognitionException {
		QueryParser.join_sub_clause_return retval = new QueryParser.join_sub_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set378=null;
		Token OUTER379=null;
		Token COMMA380=null;
		Token COMMA382=null;
		ParserRuleReturnScope join_item377 =null;
		ParserRuleReturnScope join_item381 =null;
		ParserRuleReturnScope join_item383 =null;

		Object set378_tree=null;
		Object OUTER379_tree=null;
		Object COMMA380_tree=null;
		Object COMMA382_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:565:17: ( join_item ( ( ( LEFT | RIGHT | FULL ) ( OUTER )? COMMA ! join_item ) | ( ( COMMA ! join_item )+ ) ) )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:565:19: join_item ( ( ( LEFT | RIGHT | FULL ) ( OUTER )? COMMA ! join_item ) | ( ( COMMA ! join_item )+ ) )
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_join_item_in_join_sub_clause3527);
			join_item377=join_item();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, join_item377.getTree());

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:565:29: ( ( ( LEFT | RIGHT | FULL ) ( OUTER )? COMMA ! join_item ) | ( ( COMMA ! join_item )+ ) )
			int alt106=2;
			int LA106_0 = input.LA(1);
			if ( (LA106_0==FULL||LA106_0==LEFT||LA106_0==RIGHT) ) {
				alt106=1;
			}
			else if ( (LA106_0==COMMA) ) {
				alt106=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 106, 0, input);
				throw nvae;
			}

			switch (alt106) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:565:31: ( ( LEFT | RIGHT | FULL ) ( OUTER )? COMMA ! join_item )
					{
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:565:31: ( ( LEFT | RIGHT | FULL ) ( OUTER )? COMMA ! join_item )
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:565:33: ( LEFT | RIGHT | FULL ) ( OUTER )? COMMA ! join_item
					{
					set378=input.LT(1);
					if ( input.LA(1)==FULL||input.LA(1)==LEFT||input.LA(1)==RIGHT ) {
						input.consume();
						if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set378));
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:565:57: ( OUTER )?
					int alt104=2;
					int LA104_0 = input.LA(1);
					if ( (LA104_0==OUTER) ) {
						alt104=1;
					}
					switch (alt104) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:565:57: OUTER
							{
							OUTER379=(Token)match(input,OUTER,FOLLOW_OUTER_in_join_sub_clause3547); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							OUTER379_tree = (Object)adaptor.create(OUTER379);
							adaptor.addChild(root_0, OUTER379_tree);
							}

							}
							break;

					}

					COMMA380=(Token)match(input,COMMA,FOLLOW_COMMA_in_join_sub_clause3550); if (state.failed) return retval;
					pushFollow(FOLLOW_join_item_in_join_sub_clause3553);
					join_item381=join_item();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, join_item381.getTree());

					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:565:85: ( ( COMMA ! join_item )+ )
					{
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:565:85: ( ( COMMA ! join_item )+ )
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:565:87: ( COMMA ! join_item )+
					{
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:565:87: ( COMMA ! join_item )+
					int cnt105=0;
					loop105:
					while (true) {
						int alt105=2;
						int LA105_0 = input.LA(1);
						if ( (LA105_0==COMMA) ) {
							alt105=1;
						}

						switch (alt105) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:565:89: COMMA ! join_item
							{
							COMMA382=(Token)match(input,COMMA,FOLLOW_COMMA_in_join_sub_clause3563); if (state.failed) return retval;
							pushFollow(FOLLOW_join_item_in_join_sub_clause3566);
							join_item383=join_item();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, join_item383.getTree());

							}
							break;

						default :
							if ( cnt105 >= 1 ) break loop105;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(105, input);
							throw eee;
						}
						cnt105++;
					}

					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "join_sub_clause"


	public static class join_item_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "join_item"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:568:1: join_item : rel join_group_by_clause -> ^( JOIN_ITEM rel join_group_by_clause ) ;
	public final QueryParser.join_item_return join_item() throws RecognitionException {
		QueryParser.join_item_return retval = new QueryParser.join_item_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope rel384 =null;
		ParserRuleReturnScope join_group_by_clause385 =null;

		RewriteRuleSubtreeStream stream_join_group_by_clause=new RewriteRuleSubtreeStream(adaptor,"rule join_group_by_clause");
		RewriteRuleSubtreeStream stream_rel=new RewriteRuleSubtreeStream(adaptor,"rule rel");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:568:11: ( rel join_group_by_clause -> ^( JOIN_ITEM rel join_group_by_clause ) )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:568:13: rel join_group_by_clause
			{
			pushFollow(FOLLOW_rel_in_join_item3582);
			rel384=rel();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_rel.add(rel384.getTree());
			pushFollow(FOLLOW_join_group_by_clause_in_join_item3584);
			join_group_by_clause385=join_group_by_clause();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_join_group_by_clause.add(join_group_by_clause385.getTree());
			// AST REWRITE
			// elements: join_group_by_clause, rel
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 568:38: -> ^( JOIN_ITEM rel join_group_by_clause )
			{
				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:568:41: ^( JOIN_ITEM rel join_group_by_clause )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(JOIN_ITEM, "JOIN_ITEM"), root_1);
				adaptor.addChild(root_1, stream_rel.nextTree());
				adaptor.addChild(root_1, stream_join_group_by_clause.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "join_item"


	public static class join_group_by_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "join_group_by_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:574:1: join_group_by_clause : BY ^ real_arg ;
	public final QueryParser.join_group_by_clause_return join_group_by_clause() throws RecognitionException {
		QueryParser.join_group_by_clause_return retval = new QueryParser.join_group_by_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token BY386=null;
		ParserRuleReturnScope real_arg387 =null;

		Object BY386_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:589:22: ( BY ^ real_arg )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:589:24: BY ^ real_arg
			{
			root_0 = (Object)adaptor.nil();


			BY386=(Token)match(input,BY,FOLLOW_BY_in_join_group_by_clause3643); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			BY386_tree = (Object)adaptor.create(BY386);
			root_0 = (Object)adaptor.becomeRoot(BY386_tree, root_0);
			}

			pushFollow(FOLLOW_real_arg_in_join_group_by_clause3646);
			real_arg387=real_arg();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, real_arg387.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			        Tree by = (Tree) retval.getTree();
			        Tree realArg = by.getChild(0);
			        if(realArg.getType() == TUPLE_VAL
			        || (realArg.getType() == FUNC_EVAL && realArg.getChild(0).getType() == TOTUPLE)) {
			            retval.tree = adaptor.create(by.getType(), by.getText());
			            for(int i = 0; i < realArg.getChildCount(); ++i) {
			                if(realArg.getChild(i).getType()!=TOTUPLE)
			                ((Tree)retval.tree).addChild(realArg.getChild(i));
			            }
			            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			        }
			    }
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "join_group_by_clause"


	public static class union_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "union_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:592:1: union_clause : UNION ^ ( ONSCHEMA )? rel_list ;
	public final QueryParser.union_clause_return union_clause() throws RecognitionException {
		QueryParser.union_clause_return retval = new QueryParser.union_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token UNION388=null;
		Token ONSCHEMA389=null;
		ParserRuleReturnScope rel_list390 =null;

		Object UNION388_tree=null;
		Object ONSCHEMA389_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:592:14: ( UNION ^ ( ONSCHEMA )? rel_list )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:592:16: UNION ^ ( ONSCHEMA )? rel_list
			{
			root_0 = (Object)adaptor.nil();


			UNION388=(Token)match(input,UNION,FOLLOW_UNION_in_union_clause3655); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			UNION388_tree = (Object)adaptor.create(UNION388);
			root_0 = (Object)adaptor.becomeRoot(UNION388_tree, root_0);
			}

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:592:23: ( ONSCHEMA )?
			int alt107=2;
			int LA107_0 = input.LA(1);
			if ( (LA107_0==ONSCHEMA) ) {
				alt107=1;
			}
			switch (alt107) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:592:23: ONSCHEMA
					{
					ONSCHEMA389=(Token)match(input,ONSCHEMA,FOLLOW_ONSCHEMA_in_union_clause3658); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ONSCHEMA389_tree = (Object)adaptor.create(ONSCHEMA389);
					adaptor.addChild(root_0, ONSCHEMA389_tree);
					}

					}
					break;

			}

			pushFollow(FOLLOW_rel_list_in_union_clause3661);
			rel_list390=rel_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, rel_list390.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "union_clause"


	public static class cube_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "cube_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:595:1: cube_clause : CUBE rel BY cube_rollup_list ( COMMA cube_rollup_list )* -> ^( CUBE rel ^( BY ( cube_rollup_list )+ ) ) ;
	public final QueryParser.cube_clause_return cube_clause() throws RecognitionException {
		QueryParser.cube_clause_return retval = new QueryParser.cube_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token CUBE391=null;
		Token BY393=null;
		Token COMMA395=null;
		ParserRuleReturnScope rel392 =null;
		ParserRuleReturnScope cube_rollup_list394 =null;
		ParserRuleReturnScope cube_rollup_list396 =null;

		Object CUBE391_tree=null;
		Object BY393_tree=null;
		Object COMMA395_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleTokenStream stream_BY=new RewriteRuleTokenStream(adaptor,"token BY");
		RewriteRuleTokenStream stream_CUBE=new RewriteRuleTokenStream(adaptor,"token CUBE");
		RewriteRuleSubtreeStream stream_cube_rollup_list=new RewriteRuleSubtreeStream(adaptor,"rule cube_rollup_list");
		RewriteRuleSubtreeStream stream_rel=new RewriteRuleSubtreeStream(adaptor,"rule rel");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:595:13: ( CUBE rel BY cube_rollup_list ( COMMA cube_rollup_list )* -> ^( CUBE rel ^( BY ( cube_rollup_list )+ ) ) )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:595:15: CUBE rel BY cube_rollup_list ( COMMA cube_rollup_list )*
			{
			CUBE391=(Token)match(input,CUBE,FOLLOW_CUBE_in_cube_clause3670); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_CUBE.add(CUBE391);

			pushFollow(FOLLOW_rel_in_cube_clause3672);
			rel392=rel();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_rel.add(rel392.getTree());
			BY393=(Token)match(input,BY,FOLLOW_BY_in_cube_clause3674); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_BY.add(BY393);

			pushFollow(FOLLOW_cube_rollup_list_in_cube_clause3676);
			cube_rollup_list394=cube_rollup_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_cube_rollup_list.add(cube_rollup_list394.getTree());
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:595:44: ( COMMA cube_rollup_list )*
			loop108:
			while (true) {
				int alt108=2;
				int LA108_0 = input.LA(1);
				if ( (LA108_0==COMMA) ) {
					alt108=1;
				}

				switch (alt108) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:595:46: COMMA cube_rollup_list
					{
					COMMA395=(Token)match(input,COMMA,FOLLOW_COMMA_in_cube_clause3680); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COMMA.add(COMMA395);

					pushFollow(FOLLOW_cube_rollup_list_in_cube_clause3682);
					cube_rollup_list396=cube_rollup_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_cube_rollup_list.add(cube_rollup_list396.getTree());
					}
					break;

				default :
					break loop108;
				}
			}

			// AST REWRITE
			// elements: BY, cube_rollup_list, rel, CUBE
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 595:72: -> ^( CUBE rel ^( BY ( cube_rollup_list )+ ) )
			{
				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:595:75: ^( CUBE rel ^( BY ( cube_rollup_list )+ ) )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot(stream_CUBE.nextNode(), root_1);
				adaptor.addChild(root_1, stream_rel.nextTree());
				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:595:87: ^( BY ( cube_rollup_list )+ )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot(stream_BY.nextNode(), root_2);
				if ( !(stream_cube_rollup_list.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_cube_rollup_list.hasNext() ) {
					adaptor.addChild(root_2, stream_cube_rollup_list.nextTree());
				}
				stream_cube_rollup_list.reset();

				adaptor.addChild(root_1, root_2);
				}

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "cube_clause"


	public static class cube_rollup_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "cube_rollup_list"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:598:1: cube_rollup_list : ( CUBE | ROLLUP ) ^ LEFT_PAREN ! real_arg ( COMMA ! real_arg )* RIGHT_PAREN !;
	public final QueryParser.cube_rollup_list_return cube_rollup_list() throws RecognitionException {
		QueryParser.cube_rollup_list_return retval = new QueryParser.cube_rollup_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set397=null;
		Token LEFT_PAREN398=null;
		Token COMMA400=null;
		Token RIGHT_PAREN402=null;
		ParserRuleReturnScope real_arg399 =null;
		ParserRuleReturnScope real_arg401 =null;

		Object set397_tree=null;
		Object LEFT_PAREN398_tree=null;
		Object COMMA400_tree=null;
		Object RIGHT_PAREN402_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:598:18: ( ( CUBE | ROLLUP ) ^ LEFT_PAREN ! real_arg ( COMMA ! real_arg )* RIGHT_PAREN !)
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:598:20: ( CUBE | ROLLUP ) ^ LEFT_PAREN ! real_arg ( COMMA ! real_arg )* RIGHT_PAREN !
			{
			root_0 = (Object)adaptor.nil();


			set397=input.LT(1);
			set397=input.LT(1);
			if ( input.LA(1)==CUBE||input.LA(1)==ROLLUP ) {
				input.consume();
				if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set397), root_0);
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			LEFT_PAREN398=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_cube_rollup_list3724); if (state.failed) return retval;
			pushFollow(FOLLOW_real_arg_in_cube_rollup_list3727);
			real_arg399=real_arg();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, real_arg399.getTree());

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:598:60: ( COMMA ! real_arg )*
			loop109:
			while (true) {
				int alt109=2;
				int LA109_0 = input.LA(1);
				if ( (LA109_0==COMMA) ) {
					alt109=1;
				}

				switch (alt109) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:598:62: COMMA ! real_arg
					{
					COMMA400=(Token)match(input,COMMA,FOLLOW_COMMA_in_cube_rollup_list3731); if (state.failed) return retval;
					pushFollow(FOLLOW_real_arg_in_cube_rollup_list3734);
					real_arg401=real_arg();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, real_arg401.getTree());

					}
					break;

				default :
					break loop109;
				}
			}

			RIGHT_PAREN402=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_cube_rollup_list3739); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "cube_rollup_list"


	public static class flatten_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "flatten_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:601:1: flatten_clause : FLATTEN ^ LEFT_PAREN ! expr RIGHT_PAREN !;
	public final QueryParser.flatten_clause_return flatten_clause() throws RecognitionException {
		QueryParser.flatten_clause_return retval = new QueryParser.flatten_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token FLATTEN403=null;
		Token LEFT_PAREN404=null;
		Token RIGHT_PAREN406=null;
		ParserRuleReturnScope expr405 =null;

		Object FLATTEN403_tree=null;
		Object LEFT_PAREN404_tree=null;
		Object RIGHT_PAREN406_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:601:16: ( FLATTEN ^ LEFT_PAREN ! expr RIGHT_PAREN !)
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:601:18: FLATTEN ^ LEFT_PAREN ! expr RIGHT_PAREN !
			{
			root_0 = (Object)adaptor.nil();


			FLATTEN403=(Token)match(input,FLATTEN,FOLLOW_FLATTEN_in_flatten_clause3749); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			FLATTEN403_tree = (Object)adaptor.create(FLATTEN403);
			root_0 = (Object)adaptor.becomeRoot(FLATTEN403_tree, root_0);
			}

			LEFT_PAREN404=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_flatten_clause3752); if (state.failed) return retval;
			pushFollow(FOLLOW_expr_in_flatten_clause3755);
			expr405=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expr405.getTree());

			RIGHT_PAREN406=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_flatten_clause3757); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "flatten_clause"


	public static class generate_as_clause_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "generate_as_clause"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:606:1: generate_as_clause : AS ! ( ( LEFT_PAREN ! field_def_list RIGHT_PAREN !) | explicit_field_def ) ;
	public final QueryParser.generate_as_clause_return generate_as_clause() throws RecognitionException {
		QueryParser.generate_as_clause_return retval = new QueryParser.generate_as_clause_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token AS407=null;
		Token LEFT_PAREN408=null;
		Token RIGHT_PAREN410=null;
		ParserRuleReturnScope field_def_list409 =null;
		ParserRuleReturnScope explicit_field_def411 =null;

		Object AS407_tree=null;
		Object LEFT_PAREN408_tree=null;
		Object RIGHT_PAREN410_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:606:20: ( AS ! ( ( LEFT_PAREN ! field_def_list RIGHT_PAREN !) | explicit_field_def ) )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:606:23: AS ! ( ( LEFT_PAREN ! field_def_list RIGHT_PAREN !) | explicit_field_def )
			{
			root_0 = (Object)adaptor.nil();


			AS407=(Token)match(input,AS,FOLLOW_AS_in_generate_as_clause3770); if (state.failed) return retval;
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:606:27: ( ( LEFT_PAREN ! field_def_list RIGHT_PAREN !) | explicit_field_def )
			int alt110=2;
			int LA110_0 = input.LA(1);
			if ( (LA110_0==LEFT_PAREN) ) {
				alt110=1;
			}
			else if ( ((LA110_0 >= BAG && LA110_0 <= BIGDECIMAL)||LA110_0==BIGINTEGER||LA110_0==BOOLEAN||LA110_0==BYTEARRAY||LA110_0==CHARARRAY||(LA110_0 >= CUBE && LA110_0 <= DATETIME)||LA110_0==DOUBLE||(LA110_0 >= ELSE && LA110_0 <= END)||LA110_0==FLOAT||LA110_0==IDENTIFIER||LA110_0==IN||LA110_0==INT||LA110_0==LONG||LA110_0==MAP||LA110_0==RANK||LA110_0==THEN||LA110_0==TUPLE||LA110_0==WHEN) ) {
				alt110=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 110, 0, input);
				throw nvae;
			}

			switch (alt110) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:606:29: ( LEFT_PAREN ! field_def_list RIGHT_PAREN !)
					{
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:606:29: ( LEFT_PAREN ! field_def_list RIGHT_PAREN !)
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:606:31: LEFT_PAREN ! field_def_list RIGHT_PAREN !
					{
					LEFT_PAREN408=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_generate_as_clause3777); if (state.failed) return retval;
					pushFollow(FOLLOW_field_def_list_in_generate_as_clause3780);
					field_def_list409=field_def_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, field_def_list409.getTree());

					RIGHT_PAREN410=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_generate_as_clause3782); if (state.failed) return retval;
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:606:75: explicit_field_def
					{
					pushFollow(FOLLOW_explicit_field_def_in_generate_as_clause3789);
					explicit_field_def411=explicit_field_def();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, explicit_field_def411.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "generate_as_clause"


	public static class flatten_generated_item_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "flatten_generated_item"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:609:1: flatten_generated_item : ( flatten_clause ( generate_as_clause )? | real_arg ( generate_as_clause )? );
	public final QueryParser.flatten_generated_item_return flatten_generated_item() throws RecognitionException {
		QueryParser.flatten_generated_item_return retval = new QueryParser.flatten_generated_item_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope flatten_clause412 =null;
		ParserRuleReturnScope generate_as_clause413 =null;
		ParserRuleReturnScope real_arg414 =null;
		ParserRuleReturnScope generate_as_clause415 =null;


		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:609:24: ( flatten_clause ( generate_as_clause )? | real_arg ( generate_as_clause )? )
			int alt113=2;
			int LA113_0 = input.LA(1);
			if ( (LA113_0==FLATTEN) ) {
				alt113=1;
			}
			else if ( (LA113_0==ALL||LA113_0==AND||(LA113_0 >= AS && LA113_0 <= ASSERT)||(LA113_0 >= BIGDECIMAL && LA113_0 <= BIGINTEGERNUMBER)||(LA113_0 >= BY && LA113_0 <= COGROUP)||(LA113_0 >= CROSS && LA113_0 <= DATETIME)||LA113_0==DEFINE||LA113_0==DESC||LA113_0==DISTINCT||LA113_0==DOLLARVAR||(LA113_0 >= DOUBLENUMBER && LA113_0 <= END)||LA113_0==FALSE||LA113_0==FILTER||(LA113_0 >= FLOATNUMBER && LA113_0 <= GROUP)||(LA113_0 >= IDENTIFIER && LA113_0 <= INPUT)||(LA113_0 >= INTEGER && LA113_0 <= LEFT_PAREN)||(LA113_0 >= LIMIT && LA113_0 <= LOAD)||LA113_0==LONGINTEGER||(LA113_0 >= MAPREDUCE && LA113_0 <= MINUS)||LA113_0==NULL||(LA113_0 >= OR && LA113_0 <= ORDER)||(LA113_0 >= OUTER && LA113_0 <= PARTITION)||(LA113_0 >= QUOTEDSTRING && LA113_0 <= RIGHT)||(LA113_0 >= ROLLUP && LA113_0 <= SAMPLE)||LA113_0==SHIP||(LA113_0 >= SPLIT && LA113_0 <= TRUE)||(LA113_0 >= UNION && LA113_0 <= USING)||LA113_0==WHEN||(LA113_0 >= BOOL && LA113_0 <= BOOL_COND)||LA113_0==REALIAS) ) {
				alt113=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 113, 0, input);
				throw nvae;
			}

			switch (alt113) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:609:26: flatten_clause ( generate_as_clause )?
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_flatten_clause_in_flatten_generated_item3800);
					flatten_clause412=flatten_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, flatten_clause412.getTree());

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:609:41: ( generate_as_clause )?
					int alt111=2;
					int LA111_0 = input.LA(1);
					if ( (LA111_0==AS) ) {
						alt111=1;
					}
					switch (alt111) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:609:41: generate_as_clause
							{
							pushFollow(FOLLOW_generate_as_clause_in_flatten_generated_item3802);
							generate_as_clause413=generate_as_clause();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, generate_as_clause413.getTree());

							}
							break;

					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:610:26: real_arg ( generate_as_clause )?
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_real_arg_in_flatten_generated_item3830);
					real_arg414=real_arg();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, real_arg414.getTree());

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:610:35: ( generate_as_clause )?
					int alt112=2;
					int LA112_0 = input.LA(1);
					if ( (LA112_0==AS) ) {
						alt112=1;
					}
					switch (alt112) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:610:35: generate_as_clause
							{
							pushFollow(FOLLOW_generate_as_clause_in_flatten_generated_item3832);
							generate_as_clause415=generate_as_clause();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, generate_as_clause415.getTree());

							}
							break;

					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "flatten_generated_item"


	public static class real_arg_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "real_arg"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:618:1: real_arg : ( expr | STAR | col_range );
	public final QueryParser.real_arg_return real_arg() throws RecognitionException {
		QueryParser.real_arg_return retval = new QueryParser.real_arg_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token STAR417=null;
		ParserRuleReturnScope expr416 =null;
		ParserRuleReturnScope col_range418 =null;

		Object STAR417_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:618:10: ( expr | STAR | col_range )
			int alt114=3;
			switch ( input.LA(1) ) {
			case ALL:
			case AND:
			case AS:
			case ASC:
			case ASSERT:
			case BIGDECIMAL:
			case BIGDECIMALNUMBER:
			case BIGINTEGER:
			case BIGINTEGERNUMBER:
			case BY:
			case BYTEARRAY:
			case CACHE:
			case CASE:
			case CHARARRAY:
			case COGROUP:
			case CROSS:
			case DATETIME:
			case DEFINE:
			case DESC:
			case DISTINCT:
			case DOUBLENUMBER:
			case FALSE:
			case FILTER:
			case FLOATNUMBER:
			case FOREACH:
			case FULL:
			case GENERATE:
			case IF:
			case IMPORT:
			case INNER:
			case INPUT:
			case INTEGER:
			case INTO:
			case INVOKE:
			case IS:
			case JOIN:
			case LEFT:
			case LEFT_BRACKET:
			case LEFT_CURLY:
			case LEFT_PAREN:
			case LIMIT:
			case LOAD:
			case LONGINTEGER:
			case MAPREDUCE:
			case MINUS:
			case NULL:
			case OR:
			case ORDER:
			case OUTER:
			case OUTPUT:
			case PARALLEL:
			case PARTITION:
			case QUOTEDSTRING:
			case REGISTER:
			case RETURNS:
			case RIGHT:
			case ROLLUP:
			case SAMPLE:
			case SHIP:
			case SPLIT:
			case STDERROR:
			case STDIN:
			case STDOUT:
			case STORE:
			case STREAM:
			case STR_OP_EQ:
			case STR_OP_GT:
			case STR_OP_GTE:
			case STR_OP_LT:
			case STR_OP_LTE:
			case STR_OP_MATCHES:
			case STR_OP_NE:
			case THROUGH:
			case TRUE:
			case UNION:
			case USING:
			case BOOL:
			case BOOL_COND:
			case REALIAS:
				{
				alt114=1;
				}
				break;
			case DOLLARVAR:
			case GROUP:
				{
				int LA114_2 = input.LA(2);
				if ( (LA114_2==AS||LA114_2==COMMA||LA114_2==DIV||LA114_2==FULL||LA114_2==INNER||LA114_2==LEFT||LA114_2==MINUS||LA114_2==OUTER||(LA114_2 >= PARALLEL && LA114_2 <= POUND)||(LA114_2 >= RIGHT && LA114_2 <= RIGHT_PAREN)||LA114_2==SEMI_COLON||LA114_2==STAR||LA114_2==USING) ) {
					alt114=1;
				}
				else if ( (LA114_2==DOUBLE_PERIOD) ) {
					alt114=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case IDENTIFIER:
				{
				int LA114_3 = input.LA(2);
				if ( (LA114_3==AS||LA114_3==COMMA||(LA114_3 >= DIV && LA114_3 <= DOLLAR)||LA114_3==FULL||LA114_3==INNER||LA114_3==LEFT||LA114_3==LEFT_PAREN||LA114_3==MINUS||LA114_3==OUTER||(LA114_3 >= PARALLEL && LA114_3 <= POUND)||(LA114_3 >= RIGHT && LA114_3 <= RIGHT_PAREN)||LA114_3==SEMI_COLON||LA114_3==STAR||LA114_3==USING) ) {
					alt114=1;
				}
				else if ( (LA114_3==DOUBLE_PERIOD) ) {
					alt114=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case CUBE:
			case ELSE:
			case END:
			case IN:
			case RANK:
			case THEN:
			case WHEN:
				{
				int LA114_4 = input.LA(2);
				if ( (LA114_4==AS||LA114_4==COMMA||(LA114_4 >= DIV && LA114_4 <= DOLLAR)||LA114_4==FULL||LA114_4==INNER||LA114_4==LEFT||LA114_4==LEFT_PAREN||LA114_4==MINUS||LA114_4==OUTER||(LA114_4 >= PARALLEL && LA114_4 <= POUND)||(LA114_4 >= RIGHT && LA114_4 <= RIGHT_PAREN)||LA114_4==SEMI_COLON||LA114_4==STAR||LA114_4==USING) ) {
					alt114=1;
				}
				else if ( (LA114_4==DOUBLE_PERIOD) ) {
					alt114=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 114, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case STAR:
				{
				alt114=2;
				}
				break;
			case DOUBLE_PERIOD:
				{
				alt114=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 114, 0, input);
				throw nvae;
			}
			switch (alt114) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:618:12: expr
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_expr_in_real_arg3847);
					expr416=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr416.getTree());

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:619:12: STAR
					{
					root_0 = (Object)adaptor.nil();


					STAR417=(Token)match(input,STAR,FOLLOW_STAR_in_real_arg3860); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STAR417_tree = (Object)adaptor.create(STAR417);
					adaptor.addChild(root_0, STAR417_tree);
					}

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:620:12: col_range
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_col_range_in_real_arg3873);
					col_range418=col_range();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, col_range418.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "real_arg"


	public static class cond_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "cond"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:623:1: cond : and_cond ( OR ^ and_cond )* ;
	public final QueryParser.cond_return cond() throws RecognitionException {
		QueryParser.cond_return retval = new QueryParser.cond_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token OR420=null;
		ParserRuleReturnScope and_cond419 =null;
		ParserRuleReturnScope and_cond421 =null;

		Object OR420_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:623:6: ( and_cond ( OR ^ and_cond )* )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:623:8: and_cond ( OR ^ and_cond )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_and_cond_in_cond3882);
			and_cond419=and_cond();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, and_cond419.getTree());

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:623:18: ( OR ^ and_cond )*
			loop115:
			while (true) {
				int alt115=2;
				int LA115_0 = input.LA(1);
				if ( (LA115_0==OR) ) {
					alt115=1;
				}

				switch (alt115) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:623:20: OR ^ and_cond
					{
					OR420=(Token)match(input,OR,FOLLOW_OR_in_cond3887); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					OR420_tree = (Object)adaptor.create(OR420);
					root_0 = (Object)adaptor.becomeRoot(OR420_tree, root_0);
					}

					pushFollow(FOLLOW_and_cond_in_cond3890);
					and_cond421=and_cond();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, and_cond421.getTree());

					}
					break;

				default :
					break loop115;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "cond"


	public static class and_cond_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "and_cond"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:626:1: and_cond : not_cond ( AND ^ not_cond )* ;
	public final QueryParser.and_cond_return and_cond() throws RecognitionException {
		QueryParser.and_cond_return retval = new QueryParser.and_cond_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token AND423=null;
		ParserRuleReturnScope not_cond422 =null;
		ParserRuleReturnScope not_cond424 =null;

		Object AND423_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:626:10: ( not_cond ( AND ^ not_cond )* )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:626:12: not_cond ( AND ^ not_cond )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_not_cond_in_and_cond3902);
			not_cond422=not_cond();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, not_cond422.getTree());

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:626:21: ( AND ^ not_cond )*
			loop116:
			while (true) {
				int alt116=2;
				int LA116_0 = input.LA(1);
				if ( (LA116_0==AND) ) {
					alt116=1;
				}

				switch (alt116) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:626:23: AND ^ not_cond
					{
					AND423=(Token)match(input,AND,FOLLOW_AND_in_and_cond3906); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					AND423_tree = (Object)adaptor.create(AND423);
					root_0 = (Object)adaptor.becomeRoot(AND423_tree, root_0);
					}

					pushFollow(FOLLOW_not_cond_in_and_cond3909);
					not_cond424=not_cond();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, not_cond424.getTree());

					}
					break;

				default :
					break loop116;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "and_cond"


	public static class not_cond_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "not_cond"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:629:1: not_cond : ( NOT ^)? unary_cond ;
	public final QueryParser.not_cond_return not_cond() throws RecognitionException {
		QueryParser.not_cond_return retval = new QueryParser.not_cond_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NOT425=null;
		ParserRuleReturnScope unary_cond426 =null;

		Object NOT425_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:629:10: ( ( NOT ^)? unary_cond )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:629:12: ( NOT ^)? unary_cond
			{
			root_0 = (Object)adaptor.nil();


			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:629:15: ( NOT ^)?
			int alt117=2;
			int LA117_0 = input.LA(1);
			if ( (LA117_0==NOT) ) {
				alt117=1;
			}
			switch (alt117) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:629:15: NOT ^
					{
					NOT425=(Token)match(input,NOT,FOLLOW_NOT_in_not_cond3921); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NOT425_tree = (Object)adaptor.create(NOT425);
					root_0 = (Object)adaptor.becomeRoot(NOT425_tree, root_0);
					}

					}
					break;

			}

			pushFollow(FOLLOW_unary_cond_in_not_cond3925);
			unary_cond426=unary_cond();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, unary_cond426.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "not_cond"


	public static class unary_cond_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "unary_cond"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:632:1: unary_cond : exp1= expr ( ( IS ( NOT )? NULL -> ^( NULL $exp1 ( NOT )? ) ) | ( IN LEFT_PAREN ( rhs_operand ( COMMA rhs_operand )* ) RIGHT_PAREN -> ^( IN ^( IN_LHS expr ) ( ^( IN_RHS rhs_operand ) )+ ) ) | ( rel_op exp2= expr -> ^( rel_op $exp1 $exp2) ) | ( -> ^( BOOL_COND expr ) ) ) ;
	public final QueryParser.unary_cond_return unary_cond() throws RecognitionException {
		QueryParser.unary_cond_return retval = new QueryParser.unary_cond_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token IS427=null;
		Token NOT428=null;
		Token NULL429=null;
		Token IN430=null;
		Token LEFT_PAREN431=null;
		Token COMMA433=null;
		Token RIGHT_PAREN435=null;
		ParserRuleReturnScope exp1 =null;
		ParserRuleReturnScope exp2 =null;
		ParserRuleReturnScope rhs_operand432 =null;
		ParserRuleReturnScope rhs_operand434 =null;
		ParserRuleReturnScope rel_op436 =null;

		Object IS427_tree=null;
		Object NOT428_tree=null;
		Object NULL429_tree=null;
		Object IN430_tree=null;
		Object LEFT_PAREN431_tree=null;
		Object COMMA433_tree=null;
		Object RIGHT_PAREN435_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
		RewriteRuleTokenStream stream_NULL=new RewriteRuleTokenStream(adaptor,"token NULL");
		RewriteRuleTokenStream stream_IN=new RewriteRuleTokenStream(adaptor,"token IN");
		RewriteRuleTokenStream stream_RIGHT_PAREN=new RewriteRuleTokenStream(adaptor,"token RIGHT_PAREN");
		RewriteRuleTokenStream stream_IS=new RewriteRuleTokenStream(adaptor,"token IS");
		RewriteRuleTokenStream stream_LEFT_PAREN=new RewriteRuleTokenStream(adaptor,"token LEFT_PAREN");
		RewriteRuleSubtreeStream stream_rhs_operand=new RewriteRuleSubtreeStream(adaptor,"rule rhs_operand");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_rel_op=new RewriteRuleSubtreeStream(adaptor,"rule rel_op");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:672:5: (exp1= expr ( ( IS ( NOT )? NULL -> ^( NULL $exp1 ( NOT )? ) ) | ( IN LEFT_PAREN ( rhs_operand ( COMMA rhs_operand )* ) RIGHT_PAREN -> ^( IN ^( IN_LHS expr ) ( ^( IN_RHS rhs_operand ) )+ ) ) | ( rel_op exp2= expr -> ^( rel_op $exp1 $exp2) ) | ( -> ^( BOOL_COND expr ) ) ) )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:672:7: exp1= expr ( ( IS ( NOT )? NULL -> ^( NULL $exp1 ( NOT )? ) ) | ( IN LEFT_PAREN ( rhs_operand ( COMMA rhs_operand )* ) RIGHT_PAREN -> ^( IN ^( IN_LHS expr ) ( ^( IN_RHS rhs_operand ) )+ ) ) | ( rel_op exp2= expr -> ^( rel_op $exp1 $exp2) ) | ( -> ^( BOOL_COND expr ) ) )
			{
			pushFollow(FOLLOW_expr_in_unary_cond3955);
			exp1=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(exp1.getTree());
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:673:9: ( ( IS ( NOT )? NULL -> ^( NULL $exp1 ( NOT )? ) ) | ( IN LEFT_PAREN ( rhs_operand ( COMMA rhs_operand )* ) RIGHT_PAREN -> ^( IN ^( IN_LHS expr ) ( ^( IN_RHS rhs_operand ) )+ ) ) | ( rel_op exp2= expr -> ^( rel_op $exp1 $exp2) ) | ( -> ^( BOOL_COND expr ) ) )
			int alt120=4;
			switch ( input.LA(1) ) {
			case IS:
				{
				alt120=1;
				}
				break;
			case IN:
				{
				alt120=2;
				}
				break;
			case NUM_OP_EQ:
			case NUM_OP_GT:
			case NUM_OP_GTE:
			case NUM_OP_LT:
			case NUM_OP_LTE:
			case NUM_OP_NE:
			case STR_OP_EQ:
			case STR_OP_GT:
			case STR_OP_GTE:
			case STR_OP_LT:
			case STR_OP_LTE:
			case STR_OP_MATCHES:
			case STR_OP_NE:
				{
				alt120=3;
				}
				break;
			case AND:
			case COMMA:
			case OR:
			case PARALLEL:
			case QMARK:
			case RIGHT_PAREN:
			case SEMI_COLON:
			case THEN:
				{
				alt120=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 120, 0, input);
				throw nvae;
			}
			switch (alt120) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:673:11: ( IS ( NOT )? NULL -> ^( NULL $exp1 ( NOT )? ) )
					{
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:673:11: ( IS ( NOT )? NULL -> ^( NULL $exp1 ( NOT )? ) )
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:673:13: IS ( NOT )? NULL
					{
					IS427=(Token)match(input,IS,FOLLOW_IS_in_unary_cond3969); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_IS.add(IS427);

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:673:16: ( NOT )?
					int alt118=2;
					int LA118_0 = input.LA(1);
					if ( (LA118_0==NOT) ) {
						alt118=1;
					}
					switch (alt118) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:673:16: NOT
							{
							NOT428=(Token)match(input,NOT,FOLLOW_NOT_in_unary_cond3971); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_NOT.add(NOT428);

							}
							break;

					}

					NULL429=(Token)match(input,NULL,FOLLOW_NULL_in_unary_cond3974); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NULL.add(NULL429);

					// AST REWRITE
					// elements: exp1, NOT, NULL
					// token labels: 
					// rule labels: exp1, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_exp1=new RewriteRuleSubtreeStream(adaptor,"rule exp1",exp1!=null?exp1.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 673:26: -> ^( NULL $exp1 ( NOT )? )
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:673:29: ^( NULL $exp1 ( NOT )? )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot(stream_NULL.nextNode(), root_1);
						adaptor.addChild(root_1, stream_exp1.nextTree());
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:673:43: ( NOT )?
						if ( stream_NOT.hasNext() ) {
							adaptor.addChild(root_1, stream_NOT.nextNode());
						}
						stream_NOT.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:674:11: ( IN LEFT_PAREN ( rhs_operand ( COMMA rhs_operand )* ) RIGHT_PAREN -> ^( IN ^( IN_LHS expr ) ( ^( IN_RHS rhs_operand ) )+ ) )
					{
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:674:11: ( IN LEFT_PAREN ( rhs_operand ( COMMA rhs_operand )* ) RIGHT_PAREN -> ^( IN ^( IN_LHS expr ) ( ^( IN_RHS rhs_operand ) )+ ) )
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:674:13: IN LEFT_PAREN ( rhs_operand ( COMMA rhs_operand )* ) RIGHT_PAREN
					{
					IN430=(Token)match(input,IN,FOLLOW_IN_in_unary_cond4004); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_IN.add(IN430);

					LEFT_PAREN431=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_unary_cond4006); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LEFT_PAREN.add(LEFT_PAREN431);

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:674:27: ( rhs_operand ( COMMA rhs_operand )* )
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:674:29: rhs_operand ( COMMA rhs_operand )*
					{
					pushFollow(FOLLOW_rhs_operand_in_unary_cond4010);
					rhs_operand432=rhs_operand();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_rhs_operand.add(rhs_operand432.getTree());
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:674:41: ( COMMA rhs_operand )*
					loop119:
					while (true) {
						int alt119=2;
						int LA119_0 = input.LA(1);
						if ( (LA119_0==COMMA) ) {
							alt119=1;
						}

						switch (alt119) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:674:43: COMMA rhs_operand
							{
							COMMA433=(Token)match(input,COMMA,FOLLOW_COMMA_in_unary_cond4014); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COMMA.add(COMMA433);

							pushFollow(FOLLOW_rhs_operand_in_unary_cond4016);
							rhs_operand434=rhs_operand();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_rhs_operand.add(rhs_operand434.getTree());
							}
							break;

						default :
							break loop119;
						}
					}

					}

					RIGHT_PAREN435=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_unary_cond4023); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RIGHT_PAREN.add(RIGHT_PAREN435);

					// AST REWRITE
					// elements: IN, expr, rhs_operand
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 674:78: -> ^( IN ^( IN_LHS expr ) ( ^( IN_RHS rhs_operand ) )+ )
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:674:81: ^( IN ^( IN_LHS expr ) ( ^( IN_RHS rhs_operand ) )+ )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot(stream_IN.nextNode(), root_1);
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:674:87: ^( IN_LHS expr )
						{
						Object root_2 = (Object)adaptor.nil();
						root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IN_LHS, "IN_LHS"), root_2);
						adaptor.addChild(root_2, stream_expr.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						if ( !(stream_rhs_operand.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_rhs_operand.hasNext() ) {
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:674:104: ^( IN_RHS rhs_operand )
							{
							Object root_2 = (Object)adaptor.nil();
							root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IN_RHS, "IN_RHS"), root_2);
							adaptor.addChild(root_2, stream_rhs_operand.nextTree());
							adaptor.addChild(root_1, root_2);
							}

						}
						stream_rhs_operand.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:675:11: ( rel_op exp2= expr -> ^( rel_op $exp1 $exp2) )
					{
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:675:11: ( rel_op exp2= expr -> ^( rel_op $exp1 $exp2) )
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:675:13: rel_op exp2= expr
					{
					pushFollow(FOLLOW_rel_op_in_unary_cond4064);
					rel_op436=rel_op();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_rel_op.add(rel_op436.getTree());
					pushFollow(FOLLOW_expr_in_unary_cond4070);
					exp2=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(exp2.getTree());
					// AST REWRITE
					// elements: rel_op, exp1, exp2
					// token labels: 
					// rule labels: exp2, exp1, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_exp2=new RewriteRuleSubtreeStream(adaptor,"rule exp2",exp2!=null?exp2.getTree():null);
					RewriteRuleSubtreeStream stream_exp1=new RewriteRuleSubtreeStream(adaptor,"rule exp1",exp1!=null?exp1.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 675:32: -> ^( rel_op $exp1 $exp2)
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:675:35: ^( rel_op $exp1 $exp2)
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot(stream_rel_op.nextNode(), root_1);
						adaptor.addChild(root_1, stream_exp1.nextTree());
						adaptor.addChild(root_1, stream_exp2.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}

					}
					break;
				case 4 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:676:11: ( -> ^( BOOL_COND expr ) )
					{
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:676:11: ( -> ^( BOOL_COND expr ) )
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:676:13: 
					{
					// AST REWRITE
					// elements: expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 676:13: -> ^( BOOL_COND expr )
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:676:16: ^( BOOL_COND expr )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BOOL_COND, "BOOL_COND"), root_1);
						adaptor.addChild(root_1, stream_expr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			        // Expressions in parentheses are a little tricky to match as
			        // they could contain either "cond" rules or "expr" rules. If
			        // they are "expr" rules then they're put under a BOOL_COND node
			        // in the tree, but "cond" rules put no extra tokens in the tree.
			        // As we're matching non-recursively we'll parse whatever's in the
			        // brackets, and if the AST has a boolean expression at its root
			        // then we'll assume we've just got a "cond" expression in
			        // brackets, and otherwise we'll assume its an "expr" (and so
			        // we'll have to strip off the BOOL_COND token the "cast_expr"
			        // rule added)
			        BaseTree tree = (BaseTree) retval.getTree();
			        if(tree.getType() == BOOL_COND
			        && tree.getChild(0).getType() == EXPR_IN_PAREN
			        && BOOLEAN_TOKENS.contains(tree.getChild(0).getChild(0).getType())) {
			            retval.tree = tree.getChild(0).getChild(0);
			            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			        }

			        // For IN expression, we clone the lhs expression (1st child of the
			        // returned tree) and insert it before every rhs expression. For example,
			        //
			        //   lhs IN (rhs1, rhs2, rhs3)
			        // =>
			        //   ^( IN lhs, rhs1, lhs, rhs2, lhs, rhs3 )
			        //
			        // Note that lhs appears three times at index 0, 2 and 4.
			        //
			        // This is needed because in LogicalPlanGenerator.g, we translate this
			        // tree to nested or expressions, and we need to construct a new
			        // LogicalExpression object per rhs expression.
			        if(tree.getType() == IN) {
			            Tree lhs = tree.getChild(0);
			            for(int i = 2; i < tree.getChildCount(); i = i + 2) {
			                tree.insertChild(i, deepCopy(lhs));
			            }
			        }
			    }
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "unary_cond"


	public static class rhs_operand_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "rhs_operand"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:679:1: rhs_operand : expr ;
	public final QueryParser.rhs_operand_return rhs_operand() throws RecognitionException {
		QueryParser.rhs_operand_return retval = new QueryParser.rhs_operand_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope expr437 =null;


		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:679:13: ( expr )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:679:15: expr
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_expr_in_rhs_operand4119);
			expr437=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expr437.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rhs_operand"


	public static class expr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:682:1: expr : multi_expr ( ( PLUS | MINUS ) ^ multi_expr )* ;
	public final QueryParser.expr_return expr() throws RecognitionException {
		QueryParser.expr_return retval = new QueryParser.expr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set439=null;
		ParserRuleReturnScope multi_expr438 =null;
		ParserRuleReturnScope multi_expr440 =null;

		Object set439_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:682:6: ( multi_expr ( ( PLUS | MINUS ) ^ multi_expr )* )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:682:8: multi_expr ( ( PLUS | MINUS ) ^ multi_expr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_multi_expr_in_expr4128);
			multi_expr438=multi_expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, multi_expr438.getTree());

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:682:19: ( ( PLUS | MINUS ) ^ multi_expr )*
			loop121:
			while (true) {
				int alt121=2;
				int LA121_0 = input.LA(1);
				if ( (LA121_0==MINUS||LA121_0==PLUS) ) {
					alt121=1;
				}

				switch (alt121) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:682:21: ( PLUS | MINUS ) ^ multi_expr
					{
					set439=input.LT(1);
					set439=input.LT(1);
					if ( input.LA(1)==MINUS||input.LA(1)==PLUS ) {
						input.consume();
						if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set439), root_0);
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_multi_expr_in_expr4143);
					multi_expr440=multi_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, multi_expr440.getTree());

					}
					break;

				default :
					break loop121;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr"


	public static class multi_expr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "multi_expr"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:685:1: multi_expr : cast_expr ( ( STAR | DIV | PERCENT ) ^ cast_expr )* ;
	public final QueryParser.multi_expr_return multi_expr() throws RecognitionException {
		QueryParser.multi_expr_return retval = new QueryParser.multi_expr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set442=null;
		ParserRuleReturnScope cast_expr441 =null;
		ParserRuleReturnScope cast_expr443 =null;

		Object set442_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:685:12: ( cast_expr ( ( STAR | DIV | PERCENT ) ^ cast_expr )* )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:685:14: cast_expr ( ( STAR | DIV | PERCENT ) ^ cast_expr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_cast_expr_in_multi_expr4155);
			cast_expr441=cast_expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, cast_expr441.getTree());

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:685:24: ( ( STAR | DIV | PERCENT ) ^ cast_expr )*
			loop122:
			while (true) {
				int alt122=2;
				int LA122_0 = input.LA(1);
				if ( (LA122_0==DIV||LA122_0==PERCENT||LA122_0==STAR) ) {
					alt122=1;
				}

				switch (alt122) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:685:26: ( STAR | DIV | PERCENT ) ^ cast_expr
					{
					set442=input.LT(1);
					set442=input.LT(1);
					if ( input.LA(1)==DIV||input.LA(1)==PERCENT||input.LA(1)==STAR ) {
						input.consume();
						if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set442), root_0);
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_cast_expr_in_multi_expr4174);
					cast_expr443=cast_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, cast_expr443.getTree());

					}
					break;

				default :
					break loop122;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "multi_expr"


	public static class func_name_suffix_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "func_name_suffix"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:688:1: func_name_suffix : ( ( DOLLAR | PERIOD ) eid )+ ;
	public final QueryParser.func_name_suffix_return func_name_suffix() throws RecognitionException {
		QueryParser.func_name_suffix_return retval = new QueryParser.func_name_suffix_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set444=null;
		ParserRuleReturnScope eid445 =null;

		Object set444_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:688:18: ( ( ( DOLLAR | PERIOD ) eid )+ )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:688:20: ( ( DOLLAR | PERIOD ) eid )+
			{
			root_0 = (Object)adaptor.nil();


			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:688:20: ( ( DOLLAR | PERIOD ) eid )+
			int cnt123=0;
			loop123:
			while (true) {
				int alt123=2;
				int LA123_0 = input.LA(1);
				if ( (LA123_0==DOLLAR||LA123_0==PERIOD) ) {
					alt123=1;
				}

				switch (alt123) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:688:22: ( DOLLAR | PERIOD ) eid
					{
					set444=input.LT(1);
					if ( input.LA(1)==DOLLAR||input.LA(1)==PERIOD ) {
						input.consume();
						if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set444));
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_eid_in_func_name_suffix4198);
					eid445=eid();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, eid445.getTree());

					}
					break;

				default :
					if ( cnt123 >= 1 ) break loop123;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(123, input);
					throw eee;
				}
				cnt123++;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "func_name_suffix"


	public static class cast_expr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "cast_expr"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:691:1: cast_expr : ( scalar | MINUS cast_expr -> ^( NEG cast_expr ) | col_ref_without_identifier ( projection )* | invoker_func ( projection )* | identifier_plus ( projection )* | identifier_plus ( func_name_suffix )? LEFT_PAREN ( real_arg ( COMMA real_arg )* )? RIGHT_PAREN ( projection )* -> ^( FUNC_EVAL identifier_plus ( func_name_suffix )? ( real_arg )* ) ( projection )* | func_name_without_columns LEFT_PAREN ( real_arg ( COMMA real_arg )* )? RIGHT_PAREN ( projection )* -> ^( FUNC_EVAL func_name_without_columns ( real_arg )* ) ( projection )* | CASE ( ( WHEN )=> WHEN cond THEN expr ( WHEN cond THEN expr )* ( ELSE expr )? END ( projection )* -> ^( CASE_COND ^( WHEN ( cond )+ ) ^( THEN ( expr )+ ) ) ( projection )* | expr WHEN rhs_operand THEN rhs_operand ( WHEN rhs_operand THEN rhs_operand )* ( ELSE rhs_operand )? END ( projection )* -> ^( CASE_EXPR ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS rhs_operand ) )+ ) ( projection )* ) | paren_expr | curly_expr | bracket_expr );
	public final QueryParser.cast_expr_return cast_expr() throws RecognitionException {
		QueryParser.cast_expr_return retval = new QueryParser.cast_expr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token MINUS447=null;
		Token LEFT_PAREN457=null;
		Token COMMA459=null;
		Token RIGHT_PAREN461=null;
		Token LEFT_PAREN464=null;
		Token COMMA466=null;
		Token RIGHT_PAREN468=null;
		Token CASE470=null;
		Token WHEN471=null;
		Token THEN473=null;
		Token WHEN475=null;
		Token THEN477=null;
		Token ELSE479=null;
		Token END481=null;
		Token WHEN484=null;
		Token THEN486=null;
		Token WHEN488=null;
		Token THEN490=null;
		Token ELSE492=null;
		Token END494=null;
		ParserRuleReturnScope scalar446 =null;
		ParserRuleReturnScope cast_expr448 =null;
		ParserRuleReturnScope col_ref_without_identifier449 =null;
		ParserRuleReturnScope projection450 =null;
		ParserRuleReturnScope invoker_func451 =null;
		ParserRuleReturnScope projection452 =null;
		ParserRuleReturnScope identifier_plus453 =null;
		ParserRuleReturnScope projection454 =null;
		ParserRuleReturnScope identifier_plus455 =null;
		ParserRuleReturnScope func_name_suffix456 =null;
		ParserRuleReturnScope real_arg458 =null;
		ParserRuleReturnScope real_arg460 =null;
		ParserRuleReturnScope projection462 =null;
		ParserRuleReturnScope func_name_without_columns463 =null;
		ParserRuleReturnScope real_arg465 =null;
		ParserRuleReturnScope real_arg467 =null;
		ParserRuleReturnScope projection469 =null;
		ParserRuleReturnScope cond472 =null;
		ParserRuleReturnScope expr474 =null;
		ParserRuleReturnScope cond476 =null;
		ParserRuleReturnScope expr478 =null;
		ParserRuleReturnScope expr480 =null;
		ParserRuleReturnScope projection482 =null;
		ParserRuleReturnScope expr483 =null;
		ParserRuleReturnScope rhs_operand485 =null;
		ParserRuleReturnScope rhs_operand487 =null;
		ParserRuleReturnScope rhs_operand489 =null;
		ParserRuleReturnScope rhs_operand491 =null;
		ParserRuleReturnScope rhs_operand493 =null;
		ParserRuleReturnScope projection495 =null;
		ParserRuleReturnScope paren_expr496 =null;
		ParserRuleReturnScope curly_expr497 =null;
		ParserRuleReturnScope bracket_expr498 =null;

		Object MINUS447_tree=null;
		Object LEFT_PAREN457_tree=null;
		Object COMMA459_tree=null;
		Object RIGHT_PAREN461_tree=null;
		Object LEFT_PAREN464_tree=null;
		Object COMMA466_tree=null;
		Object RIGHT_PAREN468_tree=null;
		Object CASE470_tree=null;
		Object WHEN471_tree=null;
		Object THEN473_tree=null;
		Object WHEN475_tree=null;
		Object THEN477_tree=null;
		Object ELSE479_tree=null;
		Object END481_tree=null;
		Object WHEN484_tree=null;
		Object THEN486_tree=null;
		Object WHEN488_tree=null;
		Object THEN490_tree=null;
		Object ELSE492_tree=null;
		Object END494_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleTokenStream stream_WHEN=new RewriteRuleTokenStream(adaptor,"token WHEN");
		RewriteRuleTokenStream stream_RIGHT_PAREN=new RewriteRuleTokenStream(adaptor,"token RIGHT_PAREN");
		RewriteRuleTokenStream stream_ELSE=new RewriteRuleTokenStream(adaptor,"token ELSE");
		RewriteRuleTokenStream stream_THEN=new RewriteRuleTokenStream(adaptor,"token THEN");
		RewriteRuleTokenStream stream_END=new RewriteRuleTokenStream(adaptor,"token END");
		RewriteRuleTokenStream stream_LEFT_PAREN=new RewriteRuleTokenStream(adaptor,"token LEFT_PAREN");
		RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");
		RewriteRuleTokenStream stream_CASE=new RewriteRuleTokenStream(adaptor,"token CASE");
		RewriteRuleSubtreeStream stream_func_name_suffix=new RewriteRuleSubtreeStream(adaptor,"rule func_name_suffix");
		RewriteRuleSubtreeStream stream_identifier_plus=new RewriteRuleSubtreeStream(adaptor,"rule identifier_plus");
		RewriteRuleSubtreeStream stream_real_arg=new RewriteRuleSubtreeStream(adaptor,"rule real_arg");
		RewriteRuleSubtreeStream stream_rhs_operand=new RewriteRuleSubtreeStream(adaptor,"rule rhs_operand");
		RewriteRuleSubtreeStream stream_cast_expr=new RewriteRuleSubtreeStream(adaptor,"rule cast_expr");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_projection=new RewriteRuleSubtreeStream(adaptor,"rule projection");
		RewriteRuleSubtreeStream stream_cond=new RewriteRuleSubtreeStream(adaptor,"rule cond");
		RewriteRuleSubtreeStream stream_func_name_without_columns=new RewriteRuleSubtreeStream(adaptor,"rule func_name_without_columns");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:757:11: ( scalar | MINUS cast_expr -> ^( NEG cast_expr ) | col_ref_without_identifier ( projection )* | invoker_func ( projection )* | identifier_plus ( projection )* | identifier_plus ( func_name_suffix )? LEFT_PAREN ( real_arg ( COMMA real_arg )* )? RIGHT_PAREN ( projection )* -> ^( FUNC_EVAL identifier_plus ( func_name_suffix )? ( real_arg )* ) ( projection )* | func_name_without_columns LEFT_PAREN ( real_arg ( COMMA real_arg )* )? RIGHT_PAREN ( projection )* -> ^( FUNC_EVAL func_name_without_columns ( real_arg )* ) ( projection )* | CASE ( ( WHEN )=> WHEN cond THEN expr ( WHEN cond THEN expr )* ( ELSE expr )? END ( projection )* -> ^( CASE_COND ^( WHEN ( cond )+ ) ^( THEN ( expr )+ ) ) ( projection )* | expr WHEN rhs_operand THEN rhs_operand ( WHEN rhs_operand THEN rhs_operand )* ( ELSE rhs_operand )? END ( projection )* -> ^( CASE_EXPR ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS rhs_operand ) )+ ) ( projection )* ) | paren_expr | curly_expr | bracket_expr )
			int alt141=11;
			alt141 = dfa141.predict(input);
			switch (alt141) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:757:13: scalar
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_scalar_in_cast_expr4233);
					scalar446=scalar();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, scalar446.getTree());

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:758:13: MINUS cast_expr
					{
					MINUS447=(Token)match(input,MINUS,FOLLOW_MINUS_in_cast_expr4247); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_MINUS.add(MINUS447);

					pushFollow(FOLLOW_cast_expr_in_cast_expr4249);
					cast_expr448=cast_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_cast_expr.add(cast_expr448.getTree());
					// AST REWRITE
					// elements: cast_expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 758:29: -> ^( NEG cast_expr )
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:758:32: ^( NEG cast_expr )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NEG, "NEG"), root_1);
						adaptor.addChild(root_1, stream_cast_expr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:762:13: col_ref_without_identifier ( projection )*
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_col_ref_without_identifier_in_cast_expr4306);
					col_ref_without_identifier449=col_ref_without_identifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, col_ref_without_identifier449.getTree());

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:762:40: ( projection )*
					loop124:
					while (true) {
						int alt124=2;
						int LA124_0 = input.LA(1);
						if ( (LA124_0==PERIOD||LA124_0==POUND) ) {
							alt124=1;
						}

						switch (alt124) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:762:40: projection
							{
							pushFollow(FOLLOW_projection_in_cast_expr4308);
							projection450=projection();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, projection450.getTree());

							}
							break;

						default :
							break loop124;
						}
					}

					}
					break;
				case 4 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:763:13: invoker_func ( projection )*
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_invoker_func_in_cast_expr4323);
					invoker_func451=invoker_func();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, invoker_func451.getTree());

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:763:26: ( projection )*
					loop125:
					while (true) {
						int alt125=2;
						int LA125_0 = input.LA(1);
						if ( (LA125_0==PERIOD||LA125_0==POUND) ) {
							alt125=1;
						}

						switch (alt125) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:763:26: projection
							{
							pushFollow(FOLLOW_projection_in_cast_expr4325);
							projection452=projection();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, projection452.getTree());

							}
							break;

						default :
							break loop125;
						}
					}

					}
					break;
				case 5 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:764:13: identifier_plus ( projection )*
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_identifier_plus_in_cast_expr4340);
					identifier_plus453=identifier_plus();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, identifier_plus453.getTree());

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:764:29: ( projection )*
					loop126:
					while (true) {
						int alt126=2;
						int LA126_0 = input.LA(1);
						if ( (LA126_0==PERIOD||LA126_0==POUND) ) {
							alt126=1;
						}

						switch (alt126) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:764:29: projection
							{
							pushFollow(FOLLOW_projection_in_cast_expr4342);
							projection454=projection();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, projection454.getTree());

							}
							break;

						default :
							break loop126;
						}
					}

					}
					break;
				case 6 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:765:13: identifier_plus ( func_name_suffix )? LEFT_PAREN ( real_arg ( COMMA real_arg )* )? RIGHT_PAREN ( projection )*
					{
					pushFollow(FOLLOW_identifier_plus_in_cast_expr4357);
					identifier_plus455=identifier_plus();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_identifier_plus.add(identifier_plus455.getTree());
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:765:29: ( func_name_suffix )?
					int alt127=2;
					int LA127_0 = input.LA(1);
					if ( (LA127_0==DOLLAR||LA127_0==PERIOD) ) {
						alt127=1;
					}
					switch (alt127) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:765:29: func_name_suffix
							{
							pushFollow(FOLLOW_func_name_suffix_in_cast_expr4359);
							func_name_suffix456=func_name_suffix();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_func_name_suffix.add(func_name_suffix456.getTree());
							}
							break;

					}

					LEFT_PAREN457=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_cast_expr4362); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LEFT_PAREN.add(LEFT_PAREN457);

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:765:58: ( real_arg ( COMMA real_arg )* )?
					int alt129=2;
					int LA129_0 = input.LA(1);
					if ( (LA129_0==ALL||LA129_0==AND||(LA129_0 >= AS && LA129_0 <= ASSERT)||(LA129_0 >= BIGDECIMAL && LA129_0 <= BIGINTEGERNUMBER)||(LA129_0 >= BY && LA129_0 <= COGROUP)||(LA129_0 >= CROSS && LA129_0 <= DATETIME)||LA129_0==DEFINE||LA129_0==DESC||LA129_0==DISTINCT||LA129_0==DOLLARVAR||(LA129_0 >= DOUBLENUMBER && LA129_0 <= END)||LA129_0==FALSE||LA129_0==FILTER||(LA129_0 >= FLOATNUMBER && LA129_0 <= GROUP)||(LA129_0 >= IDENTIFIER && LA129_0 <= INPUT)||(LA129_0 >= INTEGER && LA129_0 <= LEFT_PAREN)||(LA129_0 >= LIMIT && LA129_0 <= LOAD)||LA129_0==LONGINTEGER||(LA129_0 >= MAPREDUCE && LA129_0 <= MINUS)||LA129_0==NULL||(LA129_0 >= OR && LA129_0 <= ORDER)||(LA129_0 >= OUTER && LA129_0 <= PARTITION)||(LA129_0 >= QUOTEDSTRING && LA129_0 <= RIGHT)||(LA129_0 >= ROLLUP && LA129_0 <= SAMPLE)||LA129_0==SHIP||(LA129_0 >= SPLIT && LA129_0 <= TRUE)||(LA129_0 >= UNION && LA129_0 <= USING)||LA129_0==WHEN||(LA129_0 >= BOOL && LA129_0 <= BOOL_COND)||LA129_0==REALIAS) ) {
						alt129=1;
					}
					switch (alt129) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:765:60: real_arg ( COMMA real_arg )*
							{
							pushFollow(FOLLOW_real_arg_in_cast_expr4366);
							real_arg458=real_arg();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_real_arg.add(real_arg458.getTree());
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:765:69: ( COMMA real_arg )*
							loop128:
							while (true) {
								int alt128=2;
								int LA128_0 = input.LA(1);
								if ( (LA128_0==COMMA) ) {
									alt128=1;
								}

								switch (alt128) {
								case 1 :
									// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:765:71: COMMA real_arg
									{
									COMMA459=(Token)match(input,COMMA,FOLLOW_COMMA_in_cast_expr4370); if (state.failed) return retval; 
									if ( state.backtracking==0 ) stream_COMMA.add(COMMA459);

									pushFollow(FOLLOW_real_arg_in_cast_expr4372);
									real_arg460=real_arg();
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) stream_real_arg.add(real_arg460.getTree());
									}
									break;

								default :
									break loop128;
								}
							}

							}
							break;

					}

					RIGHT_PAREN461=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_cast_expr4380); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RIGHT_PAREN.add(RIGHT_PAREN461);

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:765:104: ( projection )*
					loop130:
					while (true) {
						int alt130=2;
						int LA130_0 = input.LA(1);
						if ( (LA130_0==PERIOD||LA130_0==POUND) ) {
							alt130=1;
						}

						switch (alt130) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:765:104: projection
							{
							pushFollow(FOLLOW_projection_in_cast_expr4382);
							projection462=projection();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_projection.add(projection462.getTree());
							}
							break;

						default :
							break loop130;
						}
					}

					// AST REWRITE
					// elements: identifier_plus, func_name_suffix, real_arg, projection
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 765:116: -> ^( FUNC_EVAL identifier_plus ( func_name_suffix )? ( real_arg )* ) ( projection )*
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:765:119: ^( FUNC_EVAL identifier_plus ( func_name_suffix )? ( real_arg )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_EVAL, "FUNC_EVAL"), root_1);
						adaptor.addChild(root_1, stream_identifier_plus.nextTree());
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:765:148: ( func_name_suffix )?
						if ( stream_func_name_suffix.hasNext() ) {
							adaptor.addChild(root_1, stream_func_name_suffix.nextTree());
						}
						stream_func_name_suffix.reset();

						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:765:166: ( real_arg )*
						while ( stream_real_arg.hasNext() ) {
							adaptor.addChild(root_1, stream_real_arg.nextTree());
						}
						stream_real_arg.reset();

						adaptor.addChild(root_0, root_1);
						}

						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:765:178: ( projection )*
						while ( stream_projection.hasNext() ) {
							adaptor.addChild(root_0, stream_projection.nextTree());
						}
						stream_projection.reset();

					}


					retval.tree = root_0;
					}

					}
					break;
				case 7 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:766:13: func_name_without_columns LEFT_PAREN ( real_arg ( COMMA real_arg )* )? RIGHT_PAREN ( projection )*
					{
					pushFollow(FOLLOW_func_name_without_columns_in_cast_expr4416);
					func_name_without_columns463=func_name_without_columns();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_func_name_without_columns.add(func_name_without_columns463.getTree());
					LEFT_PAREN464=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_cast_expr4418); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LEFT_PAREN.add(LEFT_PAREN464);

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:766:50: ( real_arg ( COMMA real_arg )* )?
					int alt132=2;
					int LA132_0 = input.LA(1);
					if ( (LA132_0==ALL||LA132_0==AND||(LA132_0 >= AS && LA132_0 <= ASSERT)||(LA132_0 >= BIGDECIMAL && LA132_0 <= BIGINTEGERNUMBER)||(LA132_0 >= BY && LA132_0 <= COGROUP)||(LA132_0 >= CROSS && LA132_0 <= DATETIME)||LA132_0==DEFINE||LA132_0==DESC||LA132_0==DISTINCT||LA132_0==DOLLARVAR||(LA132_0 >= DOUBLENUMBER && LA132_0 <= END)||LA132_0==FALSE||LA132_0==FILTER||(LA132_0 >= FLOATNUMBER && LA132_0 <= GROUP)||(LA132_0 >= IDENTIFIER && LA132_0 <= INPUT)||(LA132_0 >= INTEGER && LA132_0 <= LEFT_PAREN)||(LA132_0 >= LIMIT && LA132_0 <= LOAD)||LA132_0==LONGINTEGER||(LA132_0 >= MAPREDUCE && LA132_0 <= MINUS)||LA132_0==NULL||(LA132_0 >= OR && LA132_0 <= ORDER)||(LA132_0 >= OUTER && LA132_0 <= PARTITION)||(LA132_0 >= QUOTEDSTRING && LA132_0 <= RIGHT)||(LA132_0 >= ROLLUP && LA132_0 <= SAMPLE)||LA132_0==SHIP||(LA132_0 >= SPLIT && LA132_0 <= TRUE)||(LA132_0 >= UNION && LA132_0 <= USING)||LA132_0==WHEN||(LA132_0 >= BOOL && LA132_0 <= BOOL_COND)||LA132_0==REALIAS) ) {
						alt132=1;
					}
					switch (alt132) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:766:52: real_arg ( COMMA real_arg )*
							{
							pushFollow(FOLLOW_real_arg_in_cast_expr4422);
							real_arg465=real_arg();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_real_arg.add(real_arg465.getTree());
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:766:61: ( COMMA real_arg )*
							loop131:
							while (true) {
								int alt131=2;
								int LA131_0 = input.LA(1);
								if ( (LA131_0==COMMA) ) {
									alt131=1;
								}

								switch (alt131) {
								case 1 :
									// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:766:63: COMMA real_arg
									{
									COMMA466=(Token)match(input,COMMA,FOLLOW_COMMA_in_cast_expr4426); if (state.failed) return retval; 
									if ( state.backtracking==0 ) stream_COMMA.add(COMMA466);

									pushFollow(FOLLOW_real_arg_in_cast_expr4428);
									real_arg467=real_arg();
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) stream_real_arg.add(real_arg467.getTree());
									}
									break;

								default :
									break loop131;
								}
							}

							}
							break;

					}

					RIGHT_PAREN468=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_cast_expr4436); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RIGHT_PAREN.add(RIGHT_PAREN468);

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:766:96: ( projection )*
					loop133:
					while (true) {
						int alt133=2;
						int LA133_0 = input.LA(1);
						if ( (LA133_0==PERIOD||LA133_0==POUND) ) {
							alt133=1;
						}

						switch (alt133) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:766:96: projection
							{
							pushFollow(FOLLOW_projection_in_cast_expr4438);
							projection469=projection();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_projection.add(projection469.getTree());
							}
							break;

						default :
							break loop133;
						}
					}

					// AST REWRITE
					// elements: func_name_without_columns, projection, real_arg
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 766:108: -> ^( FUNC_EVAL func_name_without_columns ( real_arg )* ) ( projection )*
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:766:111: ^( FUNC_EVAL func_name_without_columns ( real_arg )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_EVAL, "FUNC_EVAL"), root_1);
						adaptor.addChild(root_1, stream_func_name_without_columns.nextTree());
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:766:150: ( real_arg )*
						while ( stream_real_arg.hasNext() ) {
							adaptor.addChild(root_1, stream_real_arg.nextTree());
						}
						stream_real_arg.reset();

						adaptor.addChild(root_0, root_1);
						}

						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:766:162: ( projection )*
						while ( stream_projection.hasNext() ) {
							adaptor.addChild(root_0, stream_projection.nextTree());
						}
						stream_projection.reset();

					}


					retval.tree = root_0;
					}

					}
					break;
				case 8 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:767:13: CASE ( ( WHEN )=> WHEN cond THEN expr ( WHEN cond THEN expr )* ( ELSE expr )? END ( projection )* -> ^( CASE_COND ^( WHEN ( cond )+ ) ^( THEN ( expr )+ ) ) ( projection )* | expr WHEN rhs_operand THEN rhs_operand ( WHEN rhs_operand THEN rhs_operand )* ( ELSE rhs_operand )? END ( projection )* -> ^( CASE_EXPR ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS rhs_operand ) )+ ) ( projection )* )
					{
					CASE470=(Token)match(input,CASE,FOLLOW_CASE_in_cast_expr4469); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CASE.add(CASE470);

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:767:18: ( ( WHEN )=> WHEN cond THEN expr ( WHEN cond THEN expr )* ( ELSE expr )? END ( projection )* -> ^( CASE_COND ^( WHEN ( cond )+ ) ^( THEN ( expr )+ ) ) ( projection )* | expr WHEN rhs_operand THEN rhs_operand ( WHEN rhs_operand THEN rhs_operand )* ( ELSE rhs_operand )? END ( projection )* -> ^( CASE_EXPR ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS rhs_operand ) )+ ) ( projection )* )
					int alt140=2;
					alt140 = dfa140.predict(input);
					switch (alt140) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:767:20: ( WHEN )=> WHEN cond THEN expr ( WHEN cond THEN expr )* ( ELSE expr )? END ( projection )*
							{
							WHEN471=(Token)match(input,WHEN,FOLLOW_WHEN_in_cast_expr4478); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_WHEN.add(WHEN471);

							pushFollow(FOLLOW_cond_in_cast_expr4480);
							cond472=cond();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_cond.add(cond472.getTree());
							THEN473=(Token)match(input,THEN,FOLLOW_THEN_in_cast_expr4482); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_THEN.add(THEN473);

							pushFollow(FOLLOW_expr_in_cast_expr4484);
							expr474=expr();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_expr.add(expr474.getTree());
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:767:49: ( WHEN cond THEN expr )*
							loop134:
							while (true) {
								int alt134=2;
								int LA134_0 = input.LA(1);
								if ( (LA134_0==WHEN) ) {
									alt134=1;
								}

								switch (alt134) {
								case 1 :
									// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:767:51: WHEN cond THEN expr
									{
									WHEN475=(Token)match(input,WHEN,FOLLOW_WHEN_in_cast_expr4488); if (state.failed) return retval; 
									if ( state.backtracking==0 ) stream_WHEN.add(WHEN475);

									pushFollow(FOLLOW_cond_in_cast_expr4490);
									cond476=cond();
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) stream_cond.add(cond476.getTree());
									THEN477=(Token)match(input,THEN,FOLLOW_THEN_in_cast_expr4492); if (state.failed) return retval; 
									if ( state.backtracking==0 ) stream_THEN.add(THEN477);

									pushFollow(FOLLOW_expr_in_cast_expr4494);
									expr478=expr();
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) stream_expr.add(expr478.getTree());
									}
									break;

								default :
									break loop134;
								}
							}

							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:767:74: ( ELSE expr )?
							int alt135=2;
							int LA135_0 = input.LA(1);
							if ( (LA135_0==ELSE) ) {
								alt135=1;
							}
							switch (alt135) {
								case 1 :
									// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:767:76: ELSE expr
									{
									ELSE479=(Token)match(input,ELSE,FOLLOW_ELSE_in_cast_expr4501); if (state.failed) return retval; 
									if ( state.backtracking==0 ) stream_ELSE.add(ELSE479);

									pushFollow(FOLLOW_expr_in_cast_expr4503);
									expr480=expr();
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) stream_expr.add(expr480.getTree());
									}
									break;

							}

							END481=(Token)match(input,END,FOLLOW_END_in_cast_expr4508); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_END.add(END481);

							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:767:93: ( projection )*
							loop136:
							while (true) {
								int alt136=2;
								int LA136_0 = input.LA(1);
								if ( (LA136_0==PERIOD||LA136_0==POUND) ) {
									alt136=1;
								}

								switch (alt136) {
								case 1 :
									// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:767:93: projection
									{
									pushFollow(FOLLOW_projection_in_cast_expr4510);
									projection482=projection();
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) stream_projection.add(projection482.getTree());
									}
									break;

								default :
									break loop136;
								}
							}

							// AST REWRITE
							// elements: THEN, WHEN, expr, projection, cond
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 767:105: -> ^( CASE_COND ^( WHEN ( cond )+ ) ^( THEN ( expr )+ ) ) ( projection )*
							{
								// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:767:108: ^( CASE_COND ^( WHEN ( cond )+ ) ^( THEN ( expr )+ ) )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CASE_COND, "CASE_COND"), root_1);
								// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:767:121: ^( WHEN ( cond )+ )
								{
								Object root_2 = (Object)adaptor.nil();
								root_2 = (Object)adaptor.becomeRoot(stream_WHEN.nextNode(), root_2);
								if ( !(stream_cond.hasNext()) ) {
									throw new RewriteEarlyExitException();
								}
								while ( stream_cond.hasNext() ) {
									adaptor.addChild(root_2, stream_cond.nextTree());
								}
								stream_cond.reset();

								adaptor.addChild(root_1, root_2);
								}

								// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:767:135: ^( THEN ( expr )+ )
								{
								Object root_2 = (Object)adaptor.nil();
								root_2 = (Object)adaptor.becomeRoot(stream_THEN.nextNode(), root_2);
								if ( !(stream_expr.hasNext()) ) {
									throw new RewriteEarlyExitException();
								}
								while ( stream_expr.hasNext() ) {
									adaptor.addChild(root_2, stream_expr.nextTree());
								}
								stream_expr.reset();

								adaptor.addChild(root_1, root_2);
								}

								adaptor.addChild(root_0, root_1);
								}

								// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:767:151: ( projection )*
								while ( stream_projection.hasNext() ) {
									adaptor.addChild(root_0, stream_projection.nextTree());
								}
								stream_projection.reset();

							}


							retval.tree = root_0;
							}

							}
							break;
						case 2 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:768:20: expr WHEN rhs_operand THEN rhs_operand ( WHEN rhs_operand THEN rhs_operand )* ( ELSE rhs_operand )? END ( projection )*
							{
							pushFollow(FOLLOW_expr_in_cast_expr4557);
							expr483=expr();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_expr.add(expr483.getTree());
							WHEN484=(Token)match(input,WHEN,FOLLOW_WHEN_in_cast_expr4559); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_WHEN.add(WHEN484);

							pushFollow(FOLLOW_rhs_operand_in_cast_expr4561);
							rhs_operand485=rhs_operand();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_rhs_operand.add(rhs_operand485.getTree());
							THEN486=(Token)match(input,THEN,FOLLOW_THEN_in_cast_expr4563); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_THEN.add(THEN486);

							pushFollow(FOLLOW_rhs_operand_in_cast_expr4565);
							rhs_operand487=rhs_operand();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_rhs_operand.add(rhs_operand487.getTree());
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:768:59: ( WHEN rhs_operand THEN rhs_operand )*
							loop137:
							while (true) {
								int alt137=2;
								int LA137_0 = input.LA(1);
								if ( (LA137_0==WHEN) ) {
									alt137=1;
								}

								switch (alt137) {
								case 1 :
									// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:768:61: WHEN rhs_operand THEN rhs_operand
									{
									WHEN488=(Token)match(input,WHEN,FOLLOW_WHEN_in_cast_expr4569); if (state.failed) return retval; 
									if ( state.backtracking==0 ) stream_WHEN.add(WHEN488);

									pushFollow(FOLLOW_rhs_operand_in_cast_expr4571);
									rhs_operand489=rhs_operand();
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) stream_rhs_operand.add(rhs_operand489.getTree());
									THEN490=(Token)match(input,THEN,FOLLOW_THEN_in_cast_expr4573); if (state.failed) return retval; 
									if ( state.backtracking==0 ) stream_THEN.add(THEN490);

									pushFollow(FOLLOW_rhs_operand_in_cast_expr4575);
									rhs_operand491=rhs_operand();
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) stream_rhs_operand.add(rhs_operand491.getTree());
									}
									break;

								default :
									break loop137;
								}
							}

							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:768:98: ( ELSE rhs_operand )?
							int alt138=2;
							int LA138_0 = input.LA(1);
							if ( (LA138_0==ELSE) ) {
								alt138=1;
							}
							switch (alt138) {
								case 1 :
									// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:768:100: ELSE rhs_operand
									{
									ELSE492=(Token)match(input,ELSE,FOLLOW_ELSE_in_cast_expr4582); if (state.failed) return retval; 
									if ( state.backtracking==0 ) stream_ELSE.add(ELSE492);

									pushFollow(FOLLOW_rhs_operand_in_cast_expr4584);
									rhs_operand493=rhs_operand();
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) stream_rhs_operand.add(rhs_operand493.getTree());
									}
									break;

							}

							END494=(Token)match(input,END,FOLLOW_END_in_cast_expr4589); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_END.add(END494);

							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:768:124: ( projection )*
							loop139:
							while (true) {
								int alt139=2;
								int LA139_0 = input.LA(1);
								if ( (LA139_0==PERIOD||LA139_0==POUND) ) {
									alt139=1;
								}

								switch (alt139) {
								case 1 :
									// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:768:124: projection
									{
									pushFollow(FOLLOW_projection_in_cast_expr4591);
									projection495=projection();
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) stream_projection.add(projection495.getTree());
									}
									break;

								default :
									break loop139;
								}
							}

							// AST REWRITE
							// elements: expr, projection, rhs_operand
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 769:18: -> ^( CASE_EXPR ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS rhs_operand ) )+ ) ( projection )*
							{
								// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:769:21: ^( CASE_EXPR ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS rhs_operand ) )+ )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CASE_EXPR, "CASE_EXPR"), root_1);
								// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:769:34: ^( CASE_EXPR_LHS expr )
								{
								Object root_2 = (Object)adaptor.nil();
								root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(CASE_EXPR_LHS, "CASE_EXPR_LHS"), root_2);
								adaptor.addChild(root_2, stream_expr.nextTree());
								adaptor.addChild(root_1, root_2);
								}

								if ( !(stream_rhs_operand.hasNext()) ) {
									throw new RewriteEarlyExitException();
								}
								while ( stream_rhs_operand.hasNext() ) {
									// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:769:56: ^( CASE_EXPR_RHS rhs_operand )
									{
									Object root_2 = (Object)adaptor.nil();
									root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(CASE_EXPR_RHS, "CASE_EXPR_RHS"), root_2);
									adaptor.addChild(root_2, stream_rhs_operand.nextTree());
									adaptor.addChild(root_1, root_2);
									}

								}
								stream_rhs_operand.reset();

								adaptor.addChild(root_0, root_1);
								}

								// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:769:88: ( projection )*
								while ( stream_projection.hasNext() ) {
									adaptor.addChild(root_0, stream_projection.nextTree());
								}
								stream_projection.reset();

							}


							retval.tree = root_0;
							}

							}
							break;

					}

					}
					break;
				case 9 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:771:13: paren_expr
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_paren_expr_in_cast_expr4666);
					paren_expr496=paren_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, paren_expr496.getTree());

					}
					break;
				case 10 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:772:13: curly_expr
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_curly_expr_in_cast_expr4680);
					curly_expr497=curly_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, curly_expr497.getTree());

					}
					break;
				case 11 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:773:13: bracket_expr
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_bracket_expr_in_cast_expr4694);
					bracket_expr498=bracket_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, bracket_expr498.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			        BaseTree tree = (BaseTree) retval.getTree();

			        // the parser does an initial optimisation step: it removes TOTUPLE / TOMAP / TOBAG
			        // function calls if it knows they'll just return the input (i.e. because the function's
			        // argument is a literal). We'll do this here by post-processing the result:
			        if(tree.getType() == FUNC_EVAL) {
			            Integer func = FUNC_TO_LITERAL.get(tree.getChild(0).getType());
			            if(func != null) {
			                boolean canBeOptimised = true;
			                for(int arg = 1; arg < tree.getChildCount() && canBeOptimised; ++arg) {
			                    canBeOptimised &= LITERAL_TOKENS.contains(tree.getChild(arg).getType());
			                }
			                if(canBeOptimised) {
			                    retval.tree = adaptor.create(func, func.toString());
			                    ((BaseTree)retval.tree).addChildren((List<? extends Tree>) tree.getChildren());
			                    ((BaseTree)retval.tree).deleteChild(0); // the (e.g.) TOBAG token
			                    adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			                }
			            }
			        }

			        // a minor correction to the token text for formatting -
			        // we want NEG's text to be the same as MINUSes
			        if(tree.getType() == NEG) {
			            ((CommonTree)tree).token.setText("-");
			        }

			        // As noted below, brackets around a single literal mean a tuple
			        // of that literal, not a nested expression which evaluates to
			        // that literal. Remember that a NULL with children is a boolean
			        // expression, not a literal!
			        if(tree.getType() == EXPR_IN_PAREN
			        && LITERAL_TOKENS.contains(tree.getChild(0).getType())
			        && (tree.getChild(0).getType() != NULL || tree.getChild(0).getChildCount() == 0)) {
			            ((CommonTree)tree).token.setType(TUPLE_VAL);
			        }

			        // For CASE statement, we clone the case expression (1st child of the
			        // returned tree) and insert it before every when expression. For example,
			        //
			        //   CASE e1
			        //     WHEN e2 THEN e3
			        //     WHEN e4 THEN e5
			        //     ELSE e6
			        //   END
			        // =>
			        //   ^( CASE e1, e2, e3, e1, e4, e5, e6 )
			        //
			        // Note that e1 appears twice at index 0 and 3.
			        //
			        // This is needed because in LogicalPlanGenerator.g, we translate this
			        // tree to nested bincond expressions, and we need to construct a new
			        // LogicalExpression object per when branch.
			        if(tree.getType() == CASE_EXPR) {
			            Tree caseExpr = tree.getChild(0);
			            int childCount = tree.getChildCount();
			            boolean hasElse = childCount % 2 == 0;
			            int whenBranchCount = ( childCount - (hasElse ? 2 : 1) ) / 2;
			            for(int i = 1; i < whenBranchCount; i++) {
			                tree.insertChild(3*i, deepCopy(caseExpr));
			            }
			        }
			    }
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "cast_expr"


	public static class invoker_func_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "invoker_func"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:776:1: invoker_func : INVOKE ( AMPERSAND | LEFT_PAREN real_arg RIGHT_PAREN ) (packageName= identifier_plus PERIOD )* methodName= identifier_plus LEFT_PAREN ( real_arg ( COMMA real_arg )* )? RIGHT_PAREN -> ^( INVOKER_FUNC_EVAL IDENTIFIER[Joiner.on(\".\").join(packageStr)] IDENTIFIER[methodStr] IDENTIFIER[staticStr] ( real_arg )* ) ;
	public final QueryParser.invoker_func_return invoker_func() throws RecognitionException {
		QueryParser.invoker_func_return retval = new QueryParser.invoker_func_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token INVOKE499=null;
		Token AMPERSAND500=null;
		Token LEFT_PAREN501=null;
		Token RIGHT_PAREN503=null;
		Token PERIOD504=null;
		Token LEFT_PAREN505=null;
		Token COMMA507=null;
		Token RIGHT_PAREN509=null;
		ParserRuleReturnScope packageName =null;
		ParserRuleReturnScope methodName =null;
		ParserRuleReturnScope real_arg502 =null;
		ParserRuleReturnScope real_arg506 =null;
		ParserRuleReturnScope real_arg508 =null;

		Object INVOKE499_tree=null;
		Object AMPERSAND500_tree=null;
		Object LEFT_PAREN501_tree=null;
		Object RIGHT_PAREN503_tree=null;
		Object PERIOD504_tree=null;
		Object LEFT_PAREN505_tree=null;
		Object COMMA507_tree=null;
		Object RIGHT_PAREN509_tree=null;
		RewriteRuleTokenStream stream_AMPERSAND=new RewriteRuleTokenStream(adaptor,"token AMPERSAND");
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleTokenStream stream_PERIOD=new RewriteRuleTokenStream(adaptor,"token PERIOD");
		RewriteRuleTokenStream stream_RIGHT_PAREN=new RewriteRuleTokenStream(adaptor,"token RIGHT_PAREN");
		RewriteRuleTokenStream stream_INVOKE=new RewriteRuleTokenStream(adaptor,"token INVOKE");
		RewriteRuleTokenStream stream_LEFT_PAREN=new RewriteRuleTokenStream(adaptor,"token LEFT_PAREN");
		RewriteRuleSubtreeStream stream_real_arg=new RewriteRuleSubtreeStream(adaptor,"rule real_arg");
		RewriteRuleSubtreeStream stream_identifier_plus=new RewriteRuleSubtreeStream(adaptor,"rule identifier_plus");


		    String staticStr = "true";
		    List<String> packageStr = Lists.newArrayList();
		    String methodStr = null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:782:3: ( INVOKE ( AMPERSAND | LEFT_PAREN real_arg RIGHT_PAREN ) (packageName= identifier_plus PERIOD )* methodName= identifier_plus LEFT_PAREN ( real_arg ( COMMA real_arg )* )? RIGHT_PAREN -> ^( INVOKER_FUNC_EVAL IDENTIFIER[Joiner.on(\".\").join(packageStr)] IDENTIFIER[methodStr] IDENTIFIER[staticStr] ( real_arg )* ) )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:782:3: INVOKE ( AMPERSAND | LEFT_PAREN real_arg RIGHT_PAREN ) (packageName= identifier_plus PERIOD )* methodName= identifier_plus LEFT_PAREN ( real_arg ( COMMA real_arg )* )? RIGHT_PAREN
			{
			INVOKE499=(Token)match(input,INVOKE,FOLLOW_INVOKE_in_invoker_func4708); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_INVOKE.add(INVOKE499);

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:782:10: ( AMPERSAND | LEFT_PAREN real_arg RIGHT_PAREN )
			int alt142=2;
			int LA142_0 = input.LA(1);
			if ( (LA142_0==AMPERSAND) ) {
				alt142=1;
			}
			else if ( (LA142_0==LEFT_PAREN) ) {
				alt142=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 142, 0, input);
				throw nvae;
			}

			switch (alt142) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:782:12: AMPERSAND
					{
					AMPERSAND500=(Token)match(input,AMPERSAND,FOLLOW_AMPERSAND_in_invoker_func4712); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_AMPERSAND.add(AMPERSAND500);

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:782:24: LEFT_PAREN real_arg RIGHT_PAREN
					{
					LEFT_PAREN501=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_invoker_func4716); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LEFT_PAREN.add(LEFT_PAREN501);

					pushFollow(FOLLOW_real_arg_in_invoker_func4718);
					real_arg502=real_arg();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_real_arg.add(real_arg502.getTree());
					if ( state.backtracking==0 ) { staticStr = "false"; }
					RIGHT_PAREN503=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_invoker_func4722); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RIGHT_PAREN.add(RIGHT_PAREN503);

					}
					break;

			}

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:782:83: (packageName= identifier_plus PERIOD )*
			loop143:
			while (true) {
				int alt143=2;
				int LA143_0 = input.LA(1);
				if ( (LA143_0==IDENTIFIER) ) {
					int LA143_1 = input.LA(2);
					if ( (LA143_1==PERIOD) ) {
						alt143=1;
					}

				}
				else if ( (LA143_0==CUBE||(LA143_0 >= ELSE && LA143_0 <= END)||LA143_0==IN||LA143_0==RANK||LA143_0==THEN||LA143_0==WHEN) ) {
					int LA143_2 = input.LA(2);
					if ( (LA143_2==PERIOD) ) {
						alt143=1;
					}

				}

				switch (alt143) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:782:85: packageName= identifier_plus PERIOD
					{
					pushFollow(FOLLOW_identifier_plus_in_invoker_func4730);
					packageName=identifier_plus();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_identifier_plus.add(packageName.getTree());
					PERIOD504=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_invoker_func4732); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_PERIOD.add(PERIOD504);

					if ( state.backtracking==0 ) { packageStr.add((packageName!=null?input.toString(packageName.start,packageName.stop):null)); }
					}
					break;

				default :
					break loop143;
				}
			}

			pushFollow(FOLLOW_identifier_plus_in_invoker_func4741);
			methodName=identifier_plus();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_identifier_plus.add(methodName.getTree());
			if ( state.backtracking==0 ) { methodStr=(methodName!=null?input.toString(methodName.start,methodName.stop):null); }
			LEFT_PAREN505=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_invoker_func4745); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LEFT_PAREN.add(LEFT_PAREN505);

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:782:232: ( real_arg ( COMMA real_arg )* )?
			int alt145=2;
			int LA145_0 = input.LA(1);
			if ( (LA145_0==ALL||LA145_0==AND||(LA145_0 >= AS && LA145_0 <= ASSERT)||(LA145_0 >= BIGDECIMAL && LA145_0 <= BIGINTEGERNUMBER)||(LA145_0 >= BY && LA145_0 <= COGROUP)||(LA145_0 >= CROSS && LA145_0 <= DATETIME)||LA145_0==DEFINE||LA145_0==DESC||LA145_0==DISTINCT||LA145_0==DOLLARVAR||(LA145_0 >= DOUBLENUMBER && LA145_0 <= END)||LA145_0==FALSE||LA145_0==FILTER||(LA145_0 >= FLOATNUMBER && LA145_0 <= GROUP)||(LA145_0 >= IDENTIFIER && LA145_0 <= INPUT)||(LA145_0 >= INTEGER && LA145_0 <= LEFT_PAREN)||(LA145_0 >= LIMIT && LA145_0 <= LOAD)||LA145_0==LONGINTEGER||(LA145_0 >= MAPREDUCE && LA145_0 <= MINUS)||LA145_0==NULL||(LA145_0 >= OR && LA145_0 <= ORDER)||(LA145_0 >= OUTER && LA145_0 <= PARTITION)||(LA145_0 >= QUOTEDSTRING && LA145_0 <= RIGHT)||(LA145_0 >= ROLLUP && LA145_0 <= SAMPLE)||LA145_0==SHIP||(LA145_0 >= SPLIT && LA145_0 <= TRUE)||(LA145_0 >= UNION && LA145_0 <= USING)||LA145_0==WHEN||(LA145_0 >= BOOL && LA145_0 <= BOOL_COND)||LA145_0==REALIAS) ) {
				alt145=1;
			}
			switch (alt145) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:782:234: real_arg ( COMMA real_arg )*
					{
					pushFollow(FOLLOW_real_arg_in_invoker_func4749);
					real_arg506=real_arg();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_real_arg.add(real_arg506.getTree());
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:782:243: ( COMMA real_arg )*
					loop144:
					while (true) {
						int alt144=2;
						int LA144_0 = input.LA(1);
						if ( (LA144_0==COMMA) ) {
							alt144=1;
						}

						switch (alt144) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:782:245: COMMA real_arg
							{
							COMMA507=(Token)match(input,COMMA,FOLLOW_COMMA_in_invoker_func4753); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COMMA.add(COMMA507);

							pushFollow(FOLLOW_real_arg_in_invoker_func4755);
							real_arg508=real_arg();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_real_arg.add(real_arg508.getTree());
							}
							break;

						default :
							break loop144;
						}
					}

					}
					break;

			}

			RIGHT_PAREN509=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_invoker_func4763); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RIGHT_PAREN.add(RIGHT_PAREN509);

			// AST REWRITE
			// elements: real_arg
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 783:15: -> ^( INVOKER_FUNC_EVAL IDENTIFIER[Joiner.on(\".\").join(packageStr)] IDENTIFIER[methodStr] IDENTIFIER[staticStr] ( real_arg )* )
			{
				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:783:18: ^( INVOKER_FUNC_EVAL IDENTIFIER[Joiner.on(\".\").join(packageStr)] IDENTIFIER[methodStr] IDENTIFIER[staticStr] ( real_arg )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INVOKER_FUNC_EVAL, "INVOKER_FUNC_EVAL"), root_1);
				adaptor.addChild(root_1, (Object)adaptor.create(IDENTIFIER, Joiner.on(".").join(packageStr)));
				adaptor.addChild(root_1, (Object)adaptor.create(IDENTIFIER, methodStr));
				adaptor.addChild(root_1, (Object)adaptor.create(IDENTIFIER, staticStr));
				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:783:127: ( real_arg )*
				while ( stream_real_arg.hasNext() ) {
					adaptor.addChild(root_1, stream_real_arg.nextTree());
				}
				stream_real_arg.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "invoker_func"


	public static class paren_expr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "paren_expr"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:793:1: paren_expr : LEFT_PAREN ! try_implicit_map_cast ;
	public final QueryParser.paren_expr_return paren_expr() throws RecognitionException {
		QueryParser.paren_expr_return retval = new QueryParser.paren_expr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LEFT_PAREN510=null;
		ParserRuleReturnScope try_implicit_map_cast511 =null;

		Object LEFT_PAREN510_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:833:5: ( LEFT_PAREN ! try_implicit_map_cast )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:833:7: LEFT_PAREN ! try_implicit_map_cast
			{
			root_0 = (Object)adaptor.nil();


			LEFT_PAREN510=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_paren_expr4830); if (state.failed) return retval;
			pushFollow(FOLLOW_try_implicit_map_cast_in_paren_expr4833);
			try_implicit_map_cast511=try_implicit_map_cast();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, try_implicit_map_cast511.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			        BaseTree tree = (BaseTree)retval.getTree();

			        // the other side of the @after block in unary_cond: if we've
			        // matched an EXPR_IN_PAREN we expect the nested expression to
			        // be an "expr", not a "cond", so we should strip off the
			        // BOOL_COND token.
			        if(tree.getType() == EXPR_IN_PAREN
			        && tree.getChild(0).getType() == BOOL_COND) {
			            int type = tree.getChild(0).getChild(0).getType();
			            // NULL is a special case - if it has children it's a boolean
			            // expression, and if not it's a literal NULL. Note that we
			            // replace *all* children
			            if(!BOOLEAN_TOKENS.contains(type)
			            || (type == NULL && tree.getChild(0).getChild(0).getChildCount() == 0)) {
			                Tree addChildrenOf = tree.getChild(0);
			                for(int i = 0; i < tree.getChildCount(); ++i)
			                    tree.deleteChild(i);
			                for(int i = 0; i < addChildrenOf.getChildCount(); ++i)
			                    tree.addChild(addChildrenOf.getChild(i));
			            }
			        }

			        // A function call to TOTUPLE is inserted into the AST for
			        // some tuple literals - but as we assume the first expression
			        // after an open bracket is a "cond" rule, and as "cond" rules
			        // nest "expr" rules under a BOOL_COND token we get an invalid
			        // AST. We'll remove this BOOL_COND here:
			        if(tree.getType() == FUNC_EVAL
			        && tree.getChild(0).getType() == TOTUPLE
			        && tree.getChildCount() > 1
			        && tree.getChild(1).getType() == BOOL_COND) {
			            Tree insertChildrenOf = tree.getChild(1);
			            tree.deleteChild(1);
			            for(int i = insertChildrenOf.getChildCount() - 1; i >= 0; --i)
			                tree.insertChild(1, insertChildrenOf.getChild(i));
			        }
			    }
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "paren_expr"


	public static class try_implicit_map_cast_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "try_implicit_map_cast"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:836:1: try_implicit_map_cast : ( ( implicit_map_type RIGHT_PAREN cast_expr )=> implicit_map_type RIGHT_PAREN cast_expr -> ^( CAST_EXPR implicit_map_type cast_expr ) | after_left_paren );
	public final QueryParser.try_implicit_map_cast_return try_implicit_map_cast() throws RecognitionException {
		QueryParser.try_implicit_map_cast_return retval = new QueryParser.try_implicit_map_cast_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token RIGHT_PAREN513=null;
		ParserRuleReturnScope implicit_map_type512 =null;
		ParserRuleReturnScope cast_expr514 =null;
		ParserRuleReturnScope after_left_paren515 =null;

		Object RIGHT_PAREN513_tree=null;
		RewriteRuleTokenStream stream_RIGHT_PAREN=new RewriteRuleTokenStream(adaptor,"token RIGHT_PAREN");
		RewriteRuleSubtreeStream stream_cast_expr=new RewriteRuleSubtreeStream(adaptor,"rule cast_expr");
		RewriteRuleSubtreeStream stream_implicit_map_type=new RewriteRuleSubtreeStream(adaptor,"rule implicit_map_type");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:843:12: ( ( implicit_map_type RIGHT_PAREN cast_expr )=> implicit_map_type RIGHT_PAREN cast_expr -> ^( CAST_EXPR implicit_map_type cast_expr ) | after_left_paren )
			int alt146=2;
			alt146 = dfa146.predict(input);
			switch (alt146) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:843:14: ( implicit_map_type RIGHT_PAREN cast_expr )=> implicit_map_type RIGHT_PAREN cast_expr
					{
					pushFollow(FOLLOW_implicit_map_type_in_try_implicit_map_cast4936);
					implicit_map_type512=implicit_map_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_implicit_map_type.add(implicit_map_type512.getTree());
					RIGHT_PAREN513=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_try_implicit_map_cast4938); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RIGHT_PAREN.add(RIGHT_PAREN513);

					pushFollow(FOLLOW_cast_expr_in_try_implicit_map_cast4940);
					cast_expr514=cast_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_cast_expr.add(cast_expr514.getTree());
					// AST REWRITE
					// elements: cast_expr, implicit_map_type
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 843:100: -> ^( CAST_EXPR implicit_map_type cast_expr )
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:843:103: ^( CAST_EXPR implicit_map_type cast_expr )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CAST_EXPR, "CAST_EXPR"), root_1);
						adaptor.addChild(root_1, stream_implicit_map_type.nextTree());
						adaptor.addChild(root_1, stream_cast_expr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:844:14: after_left_paren
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_after_left_paren_in_try_implicit_map_cast4967);
					after_left_paren515=after_left_paren();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, after_left_paren515.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "try_implicit_map_cast"


	public static class after_left_paren_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "after_left_paren"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:847:1: after_left_paren : ( explicit_type_cast RIGHT_PAREN cast_expr -> ^( CAST_EXPR explicit_type_cast cast_expr ) | RIGHT_PAREN ( projection )* -> ^( TUPLE_VAL ) ( projection )* | STAR ( COMMA real_arg )* RIGHT_PAREN ( projection )* -> ^( FUNC_EVAL TOTUPLE STAR ( real_arg )* ) ( projection )* | col_range ( COMMA real_arg )* RIGHT_PAREN ( projection )* -> ^( FUNC_EVAL TOTUPLE col_range ( real_arg )* ) ( projection )* | cond ( ( ( COMMA real_arg )+ RIGHT_PAREN ( projection )* -> ^( FUNC_EVAL TOTUPLE cond ( real_arg )+ ) ( projection )* ) | ( RIGHT_PAREN -> ^( EXPR_IN_PAREN cond ) ) | ( QMARK exp1= expr COLON exp2= expr RIGHT_PAREN -> ^( BIN_EXPR cond $exp1 $exp2) ) ) );
	public final QueryParser.after_left_paren_return after_left_paren() throws RecognitionException {
		QueryParser.after_left_paren_return retval = new QueryParser.after_left_paren_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token RIGHT_PAREN517=null;
		Token RIGHT_PAREN519=null;
		Token STAR521=null;
		Token COMMA522=null;
		Token RIGHT_PAREN524=null;
		Token COMMA527=null;
		Token RIGHT_PAREN529=null;
		Token COMMA532=null;
		Token RIGHT_PAREN534=null;
		Token RIGHT_PAREN536=null;
		Token QMARK537=null;
		Token COLON538=null;
		Token RIGHT_PAREN539=null;
		ParserRuleReturnScope exp1 =null;
		ParserRuleReturnScope exp2 =null;
		ParserRuleReturnScope explicit_type_cast516 =null;
		ParserRuleReturnScope cast_expr518 =null;
		ParserRuleReturnScope projection520 =null;
		ParserRuleReturnScope real_arg523 =null;
		ParserRuleReturnScope projection525 =null;
		ParserRuleReturnScope col_range526 =null;
		ParserRuleReturnScope real_arg528 =null;
		ParserRuleReturnScope projection530 =null;
		ParserRuleReturnScope cond531 =null;
		ParserRuleReturnScope real_arg533 =null;
		ParserRuleReturnScope projection535 =null;

		Object RIGHT_PAREN517_tree=null;
		Object RIGHT_PAREN519_tree=null;
		Object STAR521_tree=null;
		Object COMMA522_tree=null;
		Object RIGHT_PAREN524_tree=null;
		Object COMMA527_tree=null;
		Object RIGHT_PAREN529_tree=null;
		Object COMMA532_tree=null;
		Object RIGHT_PAREN534_tree=null;
		Object RIGHT_PAREN536_tree=null;
		Object QMARK537_tree=null;
		Object COLON538_tree=null;
		Object RIGHT_PAREN539_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleTokenStream stream_STAR=new RewriteRuleTokenStream(adaptor,"token STAR");
		RewriteRuleTokenStream stream_QMARK=new RewriteRuleTokenStream(adaptor,"token QMARK");
		RewriteRuleTokenStream stream_RIGHT_PAREN=new RewriteRuleTokenStream(adaptor,"token RIGHT_PAREN");
		RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
		RewriteRuleSubtreeStream stream_col_range=new RewriteRuleSubtreeStream(adaptor,"rule col_range");
		RewriteRuleSubtreeStream stream_real_arg=new RewriteRuleSubtreeStream(adaptor,"rule real_arg");
		RewriteRuleSubtreeStream stream_explicit_type_cast=new RewriteRuleSubtreeStream(adaptor,"rule explicit_type_cast");
		RewriteRuleSubtreeStream stream_cast_expr=new RewriteRuleSubtreeStream(adaptor,"rule cast_expr");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_projection=new RewriteRuleSubtreeStream(adaptor,"rule projection");
		RewriteRuleSubtreeStream stream_cond=new RewriteRuleSubtreeStream(adaptor,"rule cond");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:847:18: ( explicit_type_cast RIGHT_PAREN cast_expr -> ^( CAST_EXPR explicit_type_cast cast_expr ) | RIGHT_PAREN ( projection )* -> ^( TUPLE_VAL ) ( projection )* | STAR ( COMMA real_arg )* RIGHT_PAREN ( projection )* -> ^( FUNC_EVAL TOTUPLE STAR ( real_arg )* ) ( projection )* | col_range ( COMMA real_arg )* RIGHT_PAREN ( projection )* -> ^( FUNC_EVAL TOTUPLE col_range ( real_arg )* ) ( projection )* | cond ( ( ( COMMA real_arg )+ RIGHT_PAREN ( projection )* -> ^( FUNC_EVAL TOTUPLE cond ( real_arg )+ ) ( projection )* ) | ( RIGHT_PAREN -> ^( EXPR_IN_PAREN cond ) ) | ( QMARK exp1= expr COLON exp2= expr RIGHT_PAREN -> ^( BIN_EXPR cond $exp1 $exp2) ) ) )
			int alt155=5;
			switch ( input.LA(1) ) {
			case BIGINTEGER:
				{
				int LA155_1 = input.LA(2);
				if ( (LA155_1==RIGHT_PAREN) ) {
					alt155=1;
				}
				else if ( (LA155_1==DOLLAR||LA155_1==LEFT_PAREN||LA155_1==PERIOD) ) {
					alt155=5;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 155, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case BAG:
			case BOOLEAN:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case MAP:
			case TUPLE:
				{
				alt155=1;
				}
				break;
			case RIGHT_PAREN:
				{
				alt155=2;
				}
				break;
			case STAR:
				{
				alt155=3;
				}
				break;
			case DOLLARVAR:
			case GROUP:
				{
				int LA155_5 = input.LA(2);
				if ( (LA155_5==DOUBLE_PERIOD) ) {
					alt155=4;
				}
				else if ( (LA155_5==AND||LA155_5==COMMA||LA155_5==DIV||LA155_5==IN||LA155_5==IS||LA155_5==MINUS||(LA155_5 >= NUM_OP_EQ && LA155_5 <= NUM_OP_NE)||LA155_5==OR||(LA155_5 >= PERCENT && LA155_5 <= QMARK)||LA155_5==RIGHT_PAREN||LA155_5==STAR||(LA155_5 >= STR_OP_EQ && LA155_5 <= STR_OP_NE)) ) {
					alt155=5;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 155, 5, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case IDENTIFIER:
				{
				int LA155_6 = input.LA(2);
				if ( (LA155_6==DOUBLE_PERIOD) ) {
					alt155=4;
				}
				else if ( (LA155_6==AND||LA155_6==COMMA||(LA155_6 >= DIV && LA155_6 <= DOLLAR)||LA155_6==IN||LA155_6==IS||LA155_6==LEFT_PAREN||LA155_6==MINUS||(LA155_6 >= NUM_OP_EQ && LA155_6 <= NUM_OP_NE)||LA155_6==OR||(LA155_6 >= PERCENT && LA155_6 <= QMARK)||LA155_6==RIGHT_PAREN||LA155_6==STAR||(LA155_6 >= STR_OP_EQ && LA155_6 <= STR_OP_NE)) ) {
					alt155=5;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 155, 6, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case CUBE:
			case ELSE:
			case END:
			case IN:
			case RANK:
			case THEN:
			case WHEN:
				{
				int LA155_7 = input.LA(2);
				if ( (LA155_7==DOUBLE_PERIOD) ) {
					alt155=4;
				}
				else if ( (LA155_7==AND||LA155_7==COMMA||(LA155_7 >= DIV && LA155_7 <= DOLLAR)||LA155_7==IN||LA155_7==IS||LA155_7==LEFT_PAREN||LA155_7==MINUS||(LA155_7 >= NUM_OP_EQ && LA155_7 <= NUM_OP_NE)||LA155_7==OR||(LA155_7 >= PERCENT && LA155_7 <= QMARK)||LA155_7==RIGHT_PAREN||LA155_7==STAR||(LA155_7 >= STR_OP_EQ && LA155_7 <= STR_OP_NE)) ) {
					alt155=5;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 155, 7, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case DOUBLE_PERIOD:
				{
				alt155=4;
				}
				break;
			case ALL:
			case AND:
			case AS:
			case ASC:
			case ASSERT:
			case BIGDECIMALNUMBER:
			case BIGINTEGERNUMBER:
			case BY:
			case CACHE:
			case CASE:
			case COGROUP:
			case CROSS:
			case DEFINE:
			case DESC:
			case DISTINCT:
			case DOUBLENUMBER:
			case FALSE:
			case FILTER:
			case FLOATNUMBER:
			case FOREACH:
			case FULL:
			case GENERATE:
			case IF:
			case IMPORT:
			case INNER:
			case INPUT:
			case INTEGER:
			case INTO:
			case INVOKE:
			case IS:
			case JOIN:
			case LEFT:
			case LEFT_BRACKET:
			case LEFT_CURLY:
			case LEFT_PAREN:
			case LIMIT:
			case LOAD:
			case LONGINTEGER:
			case MAPREDUCE:
			case MINUS:
			case NOT:
			case NULL:
			case OR:
			case ORDER:
			case OUTER:
			case OUTPUT:
			case PARALLEL:
			case PARTITION:
			case QUOTEDSTRING:
			case REGISTER:
			case RETURNS:
			case RIGHT:
			case ROLLUP:
			case SAMPLE:
			case SHIP:
			case SPLIT:
			case STDERROR:
			case STDIN:
			case STDOUT:
			case STORE:
			case STREAM:
			case STR_OP_EQ:
			case STR_OP_GT:
			case STR_OP_GTE:
			case STR_OP_LT:
			case STR_OP_LTE:
			case STR_OP_MATCHES:
			case STR_OP_NE:
			case THROUGH:
			case TRUE:
			case UNION:
			case USING:
			case BOOL:
			case BOOL_COND:
			case REALIAS:
				{
				alt155=5;
				}
				break;
			case BIGDECIMAL:
				{
				int LA155_10 = input.LA(2);
				if ( (LA155_10==RIGHT_PAREN) ) {
					alt155=1;
				}
				else if ( (LA155_10==DOLLAR||LA155_10==LEFT_PAREN||LA155_10==PERIOD) ) {
					alt155=5;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 155, 10, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case DATETIME:
				{
				int LA155_11 = input.LA(2);
				if ( (LA155_11==RIGHT_PAREN) ) {
					alt155=1;
				}
				else if ( (LA155_11==DOLLAR||LA155_11==LEFT_PAREN||LA155_11==PERIOD) ) {
					alt155=5;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 155, 11, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case CHARARRAY:
				{
				int LA155_12 = input.LA(2);
				if ( (LA155_12==RIGHT_PAREN) ) {
					alt155=1;
				}
				else if ( (LA155_12==DOLLAR||LA155_12==LEFT_PAREN||LA155_12==PERIOD) ) {
					alt155=5;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 155, 12, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case BYTEARRAY:
				{
				int LA155_13 = input.LA(2);
				if ( (LA155_13==RIGHT_PAREN) ) {
					alt155=1;
				}
				else if ( (LA155_13==DOLLAR||LA155_13==LEFT_PAREN||LA155_13==PERIOD) ) {
					alt155=5;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 155, 13, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 155, 0, input);
				throw nvae;
			}
			switch (alt155) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:847:20: explicit_type_cast RIGHT_PAREN cast_expr
					{
					pushFollow(FOLLOW_explicit_type_cast_in_after_left_paren4976);
					explicit_type_cast516=explicit_type_cast();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_explicit_type_cast.add(explicit_type_cast516.getTree());
					RIGHT_PAREN517=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_after_left_paren4978); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RIGHT_PAREN.add(RIGHT_PAREN517);

					pushFollow(FOLLOW_cast_expr_in_after_left_paren4980);
					cast_expr518=cast_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_cast_expr.add(cast_expr518.getTree());
					// AST REWRITE
					// elements: explicit_type_cast, cast_expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 847:61: -> ^( CAST_EXPR explicit_type_cast cast_expr )
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:847:64: ^( CAST_EXPR explicit_type_cast cast_expr )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CAST_EXPR, "CAST_EXPR"), root_1);
						adaptor.addChild(root_1, stream_explicit_type_cast.nextTree());
						adaptor.addChild(root_1, stream_cast_expr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:849:20: RIGHT_PAREN ( projection )*
					{
					RIGHT_PAREN519=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_after_left_paren5031); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RIGHT_PAREN.add(RIGHT_PAREN519);

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:849:32: ( projection )*
					loop147:
					while (true) {
						int alt147=2;
						int LA147_0 = input.LA(1);
						if ( (LA147_0==PERIOD||LA147_0==POUND) ) {
							alt147=1;
						}

						switch (alt147) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:849:32: projection
							{
							pushFollow(FOLLOW_projection_in_after_left_paren5033);
							projection520=projection();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_projection.add(projection520.getTree());
							}
							break;

						default :
							break loop147;
						}
					}

					// AST REWRITE
					// elements: projection
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 849:44: -> ^( TUPLE_VAL ) ( projection )*
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:849:47: ^( TUPLE_VAL )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TUPLE_VAL, "TUPLE_VAL"), root_1);
						adaptor.addChild(root_0, root_1);
						}

						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:849:62: ( projection )*
						while ( stream_projection.hasNext() ) {
							adaptor.addChild(root_0, stream_projection.nextTree());
						}
						stream_projection.reset();

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:850:20: STAR ( COMMA real_arg )* RIGHT_PAREN ( projection )*
					{
					STAR521=(Token)match(input,STAR,FOLLOW_STAR_in_after_left_paren5066); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_STAR.add(STAR521);

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:850:25: ( COMMA real_arg )*
					loop148:
					while (true) {
						int alt148=2;
						int LA148_0 = input.LA(1);
						if ( (LA148_0==COMMA) ) {
							alt148=1;
						}

						switch (alt148) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:850:27: COMMA real_arg
							{
							COMMA522=(Token)match(input,COMMA,FOLLOW_COMMA_in_after_left_paren5070); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COMMA.add(COMMA522);

							pushFollow(FOLLOW_real_arg_in_after_left_paren5072);
							real_arg523=real_arg();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_real_arg.add(real_arg523.getTree());
							}
							break;

						default :
							break loop148;
						}
					}

					RIGHT_PAREN524=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_after_left_paren5077); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RIGHT_PAREN.add(RIGHT_PAREN524);

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:850:57: ( projection )*
					loop149:
					while (true) {
						int alt149=2;
						int LA149_0 = input.LA(1);
						if ( (LA149_0==PERIOD||LA149_0==POUND) ) {
							alt149=1;
						}

						switch (alt149) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:850:57: projection
							{
							pushFollow(FOLLOW_projection_in_after_left_paren5079);
							projection525=projection();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_projection.add(projection525.getTree());
							}
							break;

						default :
							break loop149;
						}
					}

					// AST REWRITE
					// elements: STAR, real_arg, projection
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 850:69: -> ^( FUNC_EVAL TOTUPLE STAR ( real_arg )* ) ( projection )*
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:850:72: ^( FUNC_EVAL TOTUPLE STAR ( real_arg )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_EVAL, "FUNC_EVAL"), root_1);
						adaptor.addChild(root_1, (Object)adaptor.create(TOTUPLE, "TOTUPLE"));
						adaptor.addChild(root_1, stream_STAR.nextNode());
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:850:98: ( real_arg )*
						while ( stream_real_arg.hasNext() ) {
							adaptor.addChild(root_1, stream_real_arg.nextTree());
						}
						stream_real_arg.reset();

						adaptor.addChild(root_0, root_1);
						}

						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:850:110: ( projection )*
						while ( stream_projection.hasNext() ) {
							adaptor.addChild(root_0, stream_projection.nextTree());
						}
						stream_projection.reset();

					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:851:20: col_range ( COMMA real_arg )* RIGHT_PAREN ( projection )*
					{
					pushFollow(FOLLOW_col_range_in_after_left_paren5119);
					col_range526=col_range();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_col_range.add(col_range526.getTree());
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:851:30: ( COMMA real_arg )*
					loop150:
					while (true) {
						int alt150=2;
						int LA150_0 = input.LA(1);
						if ( (LA150_0==COMMA) ) {
							alt150=1;
						}

						switch (alt150) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:851:32: COMMA real_arg
							{
							COMMA527=(Token)match(input,COMMA,FOLLOW_COMMA_in_after_left_paren5123); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COMMA.add(COMMA527);

							pushFollow(FOLLOW_real_arg_in_after_left_paren5125);
							real_arg528=real_arg();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_real_arg.add(real_arg528.getTree());
							}
							break;

						default :
							break loop150;
						}
					}

					RIGHT_PAREN529=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_after_left_paren5130); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RIGHT_PAREN.add(RIGHT_PAREN529);

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:851:62: ( projection )*
					loop151:
					while (true) {
						int alt151=2;
						int LA151_0 = input.LA(1);
						if ( (LA151_0==PERIOD||LA151_0==POUND) ) {
							alt151=1;
						}

						switch (alt151) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:851:62: projection
							{
							pushFollow(FOLLOW_projection_in_after_left_paren5132);
							projection530=projection();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_projection.add(projection530.getTree());
							}
							break;

						default :
							break loop151;
						}
					}

					// AST REWRITE
					// elements: real_arg, col_range, projection
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 851:74: -> ^( FUNC_EVAL TOTUPLE col_range ( real_arg )* ) ( projection )*
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:851:77: ^( FUNC_EVAL TOTUPLE col_range ( real_arg )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_EVAL, "FUNC_EVAL"), root_1);
						adaptor.addChild(root_1, (Object)adaptor.create(TOTUPLE, "TOTUPLE"));
						adaptor.addChild(root_1, stream_col_range.nextTree());
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:851:108: ( real_arg )*
						while ( stream_real_arg.hasNext() ) {
							adaptor.addChild(root_1, stream_real_arg.nextTree());
						}
						stream_real_arg.reset();

						adaptor.addChild(root_0, root_1);
						}

						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:851:120: ( projection )*
						while ( stream_projection.hasNext() ) {
							adaptor.addChild(root_0, stream_projection.nextTree());
						}
						stream_projection.reset();

					}


					retval.tree = root_0;
					}

					}
					break;
				case 5 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:856:20: cond ( ( ( COMMA real_arg )+ RIGHT_PAREN ( projection )* -> ^( FUNC_EVAL TOTUPLE cond ( real_arg )+ ) ( projection )* ) | ( RIGHT_PAREN -> ^( EXPR_IN_PAREN cond ) ) | ( QMARK exp1= expr COLON exp2= expr RIGHT_PAREN -> ^( BIN_EXPR cond $exp1 $exp2) ) )
					{
					pushFollow(FOLLOW_cond_in_after_left_paren5244);
					cond531=cond();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_cond.add(cond531.getTree());
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:857:20: ( ( ( COMMA real_arg )+ RIGHT_PAREN ( projection )* -> ^( FUNC_EVAL TOTUPLE cond ( real_arg )+ ) ( projection )* ) | ( RIGHT_PAREN -> ^( EXPR_IN_PAREN cond ) ) | ( QMARK exp1= expr COLON exp2= expr RIGHT_PAREN -> ^( BIN_EXPR cond $exp1 $exp2) ) )
					int alt154=3;
					switch ( input.LA(1) ) {
					case COMMA:
						{
						alt154=1;
						}
						break;
					case RIGHT_PAREN:
						{
						alt154=2;
						}
						break;
					case QMARK:
						{
						alt154=3;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 154, 0, input);
						throw nvae;
					}
					switch (alt154) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:857:22: ( ( COMMA real_arg )+ RIGHT_PAREN ( projection )* -> ^( FUNC_EVAL TOTUPLE cond ( real_arg )+ ) ( projection )* )
							{
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:857:22: ( ( COMMA real_arg )+ RIGHT_PAREN ( projection )* -> ^( FUNC_EVAL TOTUPLE cond ( real_arg )+ ) ( projection )* )
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:857:24: ( COMMA real_arg )+ RIGHT_PAREN ( projection )*
							{
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:857:24: ( COMMA real_arg )+
							int cnt152=0;
							loop152:
							while (true) {
								int alt152=2;
								int LA152_0 = input.LA(1);
								if ( (LA152_0==COMMA) ) {
									alt152=1;
								}

								switch (alt152) {
								case 1 :
									// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:857:26: COMMA real_arg
									{
									COMMA532=(Token)match(input,COMMA,FOLLOW_COMMA_in_after_left_paren5271); if (state.failed) return retval; 
									if ( state.backtracking==0 ) stream_COMMA.add(COMMA532);

									pushFollow(FOLLOW_real_arg_in_after_left_paren5273);
									real_arg533=real_arg();
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) stream_real_arg.add(real_arg533.getTree());
									}
									break;

								default :
									if ( cnt152 >= 1 ) break loop152;
									if (state.backtracking>0) {state.failed=true; return retval;}
									EarlyExitException eee = new EarlyExitException(152, input);
									throw eee;
								}
								cnt152++;
							}

							RIGHT_PAREN534=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_after_left_paren5278); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_RIGHT_PAREN.add(RIGHT_PAREN534);

							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:857:56: ( projection )*
							loop153:
							while (true) {
								int alt153=2;
								int LA153_0 = input.LA(1);
								if ( (LA153_0==PERIOD||LA153_0==POUND) ) {
									alt153=1;
								}

								switch (alt153) {
								case 1 :
									// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:857:56: projection
									{
									pushFollow(FOLLOW_projection_in_after_left_paren5280);
									projection535=projection();
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) stream_projection.add(projection535.getTree());
									}
									break;

								default :
									break loop153;
								}
							}

							// AST REWRITE
							// elements: projection, cond, real_arg
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 857:68: -> ^( FUNC_EVAL TOTUPLE cond ( real_arg )+ ) ( projection )*
							{
								// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:857:71: ^( FUNC_EVAL TOTUPLE cond ( real_arg )+ )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_EVAL, "FUNC_EVAL"), root_1);
								adaptor.addChild(root_1, (Object)adaptor.create(TOTUPLE, "TOTUPLE"));
								adaptor.addChild(root_1, stream_cond.nextTree());
								if ( !(stream_real_arg.hasNext()) ) {
									throw new RewriteEarlyExitException();
								}
								while ( stream_real_arg.hasNext() ) {
									adaptor.addChild(root_1, stream_real_arg.nextTree());
								}
								stream_real_arg.reset();

								adaptor.addChild(root_0, root_1);
								}

								// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:857:109: ( projection )*
								while ( stream_projection.hasNext() ) {
									adaptor.addChild(root_0, stream_projection.nextTree());
								}
								stream_projection.reset();

							}


							retval.tree = root_0;
							}

							}

							}
							break;
						case 2 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:858:22: ( RIGHT_PAREN -> ^( EXPR_IN_PAREN cond ) )
							{
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:858:22: ( RIGHT_PAREN -> ^( EXPR_IN_PAREN cond ) )
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:858:24: RIGHT_PAREN
							{
							RIGHT_PAREN536=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_after_left_paren5326); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_RIGHT_PAREN.add(RIGHT_PAREN536);

							// AST REWRITE
							// elements: cond
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 858:36: -> ^( EXPR_IN_PAREN cond )
							{
								// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:858:39: ^( EXPR_IN_PAREN cond )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPR_IN_PAREN, "EXPR_IN_PAREN"), root_1);
								adaptor.addChild(root_1, stream_cond.nextTree());
								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;
							}

							}

							}
							break;
						case 3 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:859:22: ( QMARK exp1= expr COLON exp2= expr RIGHT_PAREN -> ^( BIN_EXPR cond $exp1 $exp2) )
							{
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:859:22: ( QMARK exp1= expr COLON exp2= expr RIGHT_PAREN -> ^( BIN_EXPR cond $exp1 $exp2) )
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:859:24: QMARK exp1= expr COLON exp2= expr RIGHT_PAREN
							{
							QMARK537=(Token)match(input,QMARK,FOLLOW_QMARK_in_after_left_paren5363); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_QMARK.add(QMARK537);

							pushFollow(FOLLOW_expr_in_after_left_paren5369);
							exp1=expr();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_expr.add(exp1.getTree());
							COLON538=(Token)match(input,COLON,FOLLOW_COLON_in_after_left_paren5371); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COLON.add(COLON538);

							pushFollow(FOLLOW_expr_in_after_left_paren5377);
							exp2=expr();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_expr.add(exp2.getTree());
							RIGHT_PAREN539=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_after_left_paren5379); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_RIGHT_PAREN.add(RIGHT_PAREN539);

							// AST REWRITE
							// elements: exp2, cond, exp1
							// token labels: 
							// rule labels: exp2, exp1, retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_exp2=new RewriteRuleSubtreeStream(adaptor,"rule exp2",exp2!=null?exp2.getTree():null);
							RewriteRuleSubtreeStream stream_exp1=new RewriteRuleSubtreeStream(adaptor,"rule exp1",exp1!=null?exp1.getTree():null);
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 859:72: -> ^( BIN_EXPR cond $exp1 $exp2)
							{
								// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:859:75: ^( BIN_EXPR cond $exp1 $exp2)
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BIN_EXPR, "BIN_EXPR"), root_1);
								adaptor.addChild(root_1, stream_cond.nextTree());
								adaptor.addChild(root_1, stream_exp1.nextTree());
								adaptor.addChild(root_1, stream_exp2.nextTree());
								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;
							}

							}

							}
							break;

					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "after_left_paren"


	public static class curly_expr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "curly_expr"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:862:1: curly_expr : ( LEFT_CURLY real_arg ( COMMA real_arg )* RIGHT_CURLY ( projection )* -> ^( FUNC_EVAL TOBAG ( real_arg )+ ) ( projection )* | LEFT_CURLY RIGHT_CURLY ( projection )* -> ^( BAG_VAL ) ( projection )* );
	public final QueryParser.curly_expr_return curly_expr() throws RecognitionException {
		QueryParser.curly_expr_return retval = new QueryParser.curly_expr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LEFT_CURLY540=null;
		Token COMMA542=null;
		Token RIGHT_CURLY544=null;
		Token LEFT_CURLY546=null;
		Token RIGHT_CURLY547=null;
		ParserRuleReturnScope real_arg541 =null;
		ParserRuleReturnScope real_arg543 =null;
		ParserRuleReturnScope projection545 =null;
		ParserRuleReturnScope projection548 =null;

		Object LEFT_CURLY540_tree=null;
		Object COMMA542_tree=null;
		Object RIGHT_CURLY544_tree=null;
		Object LEFT_CURLY546_tree=null;
		Object RIGHT_CURLY547_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleTokenStream stream_LEFT_CURLY=new RewriteRuleTokenStream(adaptor,"token LEFT_CURLY");
		RewriteRuleTokenStream stream_RIGHT_CURLY=new RewriteRuleTokenStream(adaptor,"token RIGHT_CURLY");
		RewriteRuleSubtreeStream stream_real_arg=new RewriteRuleSubtreeStream(adaptor,"rule real_arg");
		RewriteRuleSubtreeStream stream_projection=new RewriteRuleSubtreeStream(adaptor,"rule projection");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:862:12: ( LEFT_CURLY real_arg ( COMMA real_arg )* RIGHT_CURLY ( projection )* -> ^( FUNC_EVAL TOBAG ( real_arg )+ ) ( projection )* | LEFT_CURLY RIGHT_CURLY ( projection )* -> ^( BAG_VAL ) ( projection )* )
			int alt159=2;
			int LA159_0 = input.LA(1);
			if ( (LA159_0==LEFT_CURLY) ) {
				int LA159_1 = input.LA(2);
				if ( (LA159_1==RIGHT_CURLY) ) {
					alt159=2;
				}
				else if ( (LA159_1==ALL||LA159_1==AND||(LA159_1 >= AS && LA159_1 <= ASSERT)||(LA159_1 >= BIGDECIMAL && LA159_1 <= BIGINTEGERNUMBER)||(LA159_1 >= BY && LA159_1 <= COGROUP)||(LA159_1 >= CROSS && LA159_1 <= DATETIME)||LA159_1==DEFINE||LA159_1==DESC||LA159_1==DISTINCT||LA159_1==DOLLARVAR||(LA159_1 >= DOUBLENUMBER && LA159_1 <= END)||LA159_1==FALSE||LA159_1==FILTER||(LA159_1 >= FLOATNUMBER && LA159_1 <= GROUP)||(LA159_1 >= IDENTIFIER && LA159_1 <= INPUT)||(LA159_1 >= INTEGER && LA159_1 <= LEFT_PAREN)||(LA159_1 >= LIMIT && LA159_1 <= LOAD)||LA159_1==LONGINTEGER||(LA159_1 >= MAPREDUCE && LA159_1 <= MINUS)||LA159_1==NULL||(LA159_1 >= OR && LA159_1 <= ORDER)||(LA159_1 >= OUTER && LA159_1 <= PARTITION)||(LA159_1 >= QUOTEDSTRING && LA159_1 <= RIGHT)||(LA159_1 >= ROLLUP && LA159_1 <= SAMPLE)||LA159_1==SHIP||(LA159_1 >= SPLIT && LA159_1 <= TRUE)||(LA159_1 >= UNION && LA159_1 <= USING)||LA159_1==WHEN||(LA159_1 >= BOOL && LA159_1 <= BOOL_COND)||LA159_1==REALIAS) ) {
					alt159=1;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 159, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 159, 0, input);
				throw nvae;
			}

			switch (alt159) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:862:14: LEFT_CURLY real_arg ( COMMA real_arg )* RIGHT_CURLY ( projection )*
					{
					LEFT_CURLY540=(Token)match(input,LEFT_CURLY,FOLLOW_LEFT_CURLY_in_curly_expr5408); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LEFT_CURLY.add(LEFT_CURLY540);

					pushFollow(FOLLOW_real_arg_in_curly_expr5410);
					real_arg541=real_arg();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_real_arg.add(real_arg541.getTree());
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:862:34: ( COMMA real_arg )*
					loop156:
					while (true) {
						int alt156=2;
						int LA156_0 = input.LA(1);
						if ( (LA156_0==COMMA) ) {
							alt156=1;
						}

						switch (alt156) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:862:36: COMMA real_arg
							{
							COMMA542=(Token)match(input,COMMA,FOLLOW_COMMA_in_curly_expr5414); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COMMA.add(COMMA542);

							pushFollow(FOLLOW_real_arg_in_curly_expr5416);
							real_arg543=real_arg();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_real_arg.add(real_arg543.getTree());
							}
							break;

						default :
							break loop156;
						}
					}

					RIGHT_CURLY544=(Token)match(input,RIGHT_CURLY,FOLLOW_RIGHT_CURLY_in_curly_expr5421); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RIGHT_CURLY.add(RIGHT_CURLY544);

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:862:66: ( projection )*
					loop157:
					while (true) {
						int alt157=2;
						int LA157_0 = input.LA(1);
						if ( (LA157_0==PERIOD||LA157_0==POUND) ) {
							alt157=1;
						}

						switch (alt157) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:862:66: projection
							{
							pushFollow(FOLLOW_projection_in_curly_expr5423);
							projection545=projection();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_projection.add(projection545.getTree());
							}
							break;

						default :
							break loop157;
						}
					}

					// AST REWRITE
					// elements: real_arg, projection
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 862:78: -> ^( FUNC_EVAL TOBAG ( real_arg )+ ) ( projection )*
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:862:81: ^( FUNC_EVAL TOBAG ( real_arg )+ )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_EVAL, "FUNC_EVAL"), root_1);
						adaptor.addChild(root_1, (Object)adaptor.create(TOBAG, "TOBAG"));
						if ( !(stream_real_arg.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_real_arg.hasNext() ) {
							adaptor.addChild(root_1, stream_real_arg.nextTree());
						}
						stream_real_arg.reset();

						adaptor.addChild(root_0, root_1);
						}

						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:862:112: ( projection )*
						while ( stream_projection.hasNext() ) {
							adaptor.addChild(root_0, stream_projection.nextTree());
						}
						stream_projection.reset();

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:863:14: LEFT_CURLY RIGHT_CURLY ( projection )*
					{
					LEFT_CURLY546=(Token)match(input,LEFT_CURLY,FOLLOW_LEFT_CURLY_in_curly_expr5455); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LEFT_CURLY.add(LEFT_CURLY546);

					RIGHT_CURLY547=(Token)match(input,RIGHT_CURLY,FOLLOW_RIGHT_CURLY_in_curly_expr5457); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RIGHT_CURLY.add(RIGHT_CURLY547);

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:863:37: ( projection )*
					loop158:
					while (true) {
						int alt158=2;
						int LA158_0 = input.LA(1);
						if ( (LA158_0==PERIOD||LA158_0==POUND) ) {
							alt158=1;
						}

						switch (alt158) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:863:37: projection
							{
							pushFollow(FOLLOW_projection_in_curly_expr5459);
							projection548=projection();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_projection.add(projection548.getTree());
							}
							break;

						default :
							break loop158;
						}
					}

					// AST REWRITE
					// elements: projection
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 863:49: -> ^( BAG_VAL ) ( projection )*
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:863:52: ^( BAG_VAL )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BAG_VAL, "BAG_VAL"), root_1);
						adaptor.addChild(root_0, root_1);
						}

						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:863:65: ( projection )*
						while ( stream_projection.hasNext() ) {
							adaptor.addChild(root_0, stream_projection.nextTree());
						}
						stream_projection.reset();

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "curly_expr"


	public static class bracket_expr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "bracket_expr"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:866:1: bracket_expr : ( LEFT_BRACKET real_arg ( COMMA real_arg )* RIGHT_BRACKET ( projection )* -> ^( FUNC_EVAL TOMAP ( real_arg )+ ) ( projection )* | LEFT_BRACKET keyvalue ( COMMA keyvalue )* RIGHT_BRACKET ( projection )* -> ^( MAP_VAL ( keyvalue )+ ) ( projection )* | LEFT_BRACKET RIGHT_BRACKET ( projection )* -> ^( MAP_VAL ) ( projection )* );
	public final QueryParser.bracket_expr_return bracket_expr() throws RecognitionException {
		QueryParser.bracket_expr_return retval = new QueryParser.bracket_expr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LEFT_BRACKET549=null;
		Token COMMA551=null;
		Token RIGHT_BRACKET553=null;
		Token LEFT_BRACKET555=null;
		Token COMMA557=null;
		Token RIGHT_BRACKET559=null;
		Token LEFT_BRACKET561=null;
		Token RIGHT_BRACKET562=null;
		ParserRuleReturnScope real_arg550 =null;
		ParserRuleReturnScope real_arg552 =null;
		ParserRuleReturnScope projection554 =null;
		ParserRuleReturnScope keyvalue556 =null;
		ParserRuleReturnScope keyvalue558 =null;
		ParserRuleReturnScope projection560 =null;
		ParserRuleReturnScope projection563 =null;

		Object LEFT_BRACKET549_tree=null;
		Object COMMA551_tree=null;
		Object RIGHT_BRACKET553_tree=null;
		Object LEFT_BRACKET555_tree=null;
		Object COMMA557_tree=null;
		Object RIGHT_BRACKET559_tree=null;
		Object LEFT_BRACKET561_tree=null;
		Object RIGHT_BRACKET562_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleTokenStream stream_RIGHT_BRACKET=new RewriteRuleTokenStream(adaptor,"token RIGHT_BRACKET");
		RewriteRuleTokenStream stream_LEFT_BRACKET=new RewriteRuleTokenStream(adaptor,"token LEFT_BRACKET");
		RewriteRuleSubtreeStream stream_real_arg=new RewriteRuleSubtreeStream(adaptor,"rule real_arg");
		RewriteRuleSubtreeStream stream_keyvalue=new RewriteRuleSubtreeStream(adaptor,"rule keyvalue");
		RewriteRuleSubtreeStream stream_projection=new RewriteRuleSubtreeStream(adaptor,"rule projection");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:866:14: ( LEFT_BRACKET real_arg ( COMMA real_arg )* RIGHT_BRACKET ( projection )* -> ^( FUNC_EVAL TOMAP ( real_arg )+ ) ( projection )* | LEFT_BRACKET keyvalue ( COMMA keyvalue )* RIGHT_BRACKET ( projection )* -> ^( MAP_VAL ( keyvalue )+ ) ( projection )* | LEFT_BRACKET RIGHT_BRACKET ( projection )* -> ^( MAP_VAL ) ( projection )* )
			int alt165=3;
			int LA165_0 = input.LA(1);
			if ( (LA165_0==LEFT_BRACKET) ) {
				switch ( input.LA(2) ) {
				case RIGHT_BRACKET:
					{
					alt165=3;
					}
					break;
				case QUOTEDSTRING:
					{
					int LA165_3 = input.LA(3);
					if ( (LA165_3==POUND) ) {
						alt165=2;
					}
					else if ( (LA165_3==COMMA||LA165_3==DIV||LA165_3==MINUS||LA165_3==PERCENT||LA165_3==PLUS||LA165_3==RIGHT_BRACKET||LA165_3==STAR) ) {
						alt165=1;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 165, 3, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case ALL:
				case AND:
				case AS:
				case ASC:
				case ASSERT:
				case BIGDECIMAL:
				case BIGDECIMALNUMBER:
				case BIGINTEGER:
				case BIGINTEGERNUMBER:
				case BY:
				case BYTEARRAY:
				case CACHE:
				case CASE:
				case CHARARRAY:
				case COGROUP:
				case CROSS:
				case CUBE:
				case DATETIME:
				case DEFINE:
				case DESC:
				case DISTINCT:
				case DOLLARVAR:
				case DOUBLENUMBER:
				case DOUBLE_PERIOD:
				case ELSE:
				case END:
				case FALSE:
				case FILTER:
				case FLOATNUMBER:
				case FOREACH:
				case FULL:
				case GENERATE:
				case GROUP:
				case IDENTIFIER:
				case IF:
				case IMPORT:
				case IN:
				case INNER:
				case INPUT:
				case INTEGER:
				case INTO:
				case INVOKE:
				case IS:
				case JOIN:
				case LEFT:
				case LEFT_BRACKET:
				case LEFT_CURLY:
				case LEFT_PAREN:
				case LIMIT:
				case LOAD:
				case LONGINTEGER:
				case MAPREDUCE:
				case MINUS:
				case NULL:
				case OR:
				case ORDER:
				case OUTER:
				case OUTPUT:
				case PARALLEL:
				case PARTITION:
				case RANK:
				case REGISTER:
				case RETURNS:
				case RIGHT:
				case ROLLUP:
				case SAMPLE:
				case SHIP:
				case SPLIT:
				case STAR:
				case STDERROR:
				case STDIN:
				case STDOUT:
				case STORE:
				case STREAM:
				case STR_OP_EQ:
				case STR_OP_GT:
				case STR_OP_GTE:
				case STR_OP_LT:
				case STR_OP_LTE:
				case STR_OP_MATCHES:
				case STR_OP_NE:
				case THEN:
				case THROUGH:
				case TRUE:
				case UNION:
				case USING:
				case WHEN:
				case BOOL:
				case BOOL_COND:
				case REALIAS:
					{
					alt165=1;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 165, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 165, 0, input);
				throw nvae;
			}

			switch (alt165) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:866:16: LEFT_BRACKET real_arg ( COMMA real_arg )* RIGHT_BRACKET ( projection )*
					{
					LEFT_BRACKET549=(Token)match(input,LEFT_BRACKET,FOLLOW_LEFT_BRACKET_in_bracket_expr5480); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LEFT_BRACKET.add(LEFT_BRACKET549);

					pushFollow(FOLLOW_real_arg_in_bracket_expr5482);
					real_arg550=real_arg();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_real_arg.add(real_arg550.getTree());
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:866:38: ( COMMA real_arg )*
					loop160:
					while (true) {
						int alt160=2;
						int LA160_0 = input.LA(1);
						if ( (LA160_0==COMMA) ) {
							alt160=1;
						}

						switch (alt160) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:866:40: COMMA real_arg
							{
							COMMA551=(Token)match(input,COMMA,FOLLOW_COMMA_in_bracket_expr5486); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COMMA.add(COMMA551);

							pushFollow(FOLLOW_real_arg_in_bracket_expr5488);
							real_arg552=real_arg();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_real_arg.add(real_arg552.getTree());
							}
							break;

						default :
							break loop160;
						}
					}

					RIGHT_BRACKET553=(Token)match(input,RIGHT_BRACKET,FOLLOW_RIGHT_BRACKET_in_bracket_expr5493); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RIGHT_BRACKET.add(RIGHT_BRACKET553);

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:866:72: ( projection )*
					loop161:
					while (true) {
						int alt161=2;
						int LA161_0 = input.LA(1);
						if ( (LA161_0==PERIOD||LA161_0==POUND) ) {
							alt161=1;
						}

						switch (alt161) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:866:72: projection
							{
							pushFollow(FOLLOW_projection_in_bracket_expr5495);
							projection554=projection();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_projection.add(projection554.getTree());
							}
							break;

						default :
							break loop161;
						}
					}

					// AST REWRITE
					// elements: projection, real_arg
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 866:84: -> ^( FUNC_EVAL TOMAP ( real_arg )+ ) ( projection )*
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:866:87: ^( FUNC_EVAL TOMAP ( real_arg )+ )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_EVAL, "FUNC_EVAL"), root_1);
						adaptor.addChild(root_1, (Object)adaptor.create(TOMAP, "TOMAP"));
						if ( !(stream_real_arg.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_real_arg.hasNext() ) {
							adaptor.addChild(root_1, stream_real_arg.nextTree());
						}
						stream_real_arg.reset();

						adaptor.addChild(root_0, root_1);
						}

						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:866:118: ( projection )*
						while ( stream_projection.hasNext() ) {
							adaptor.addChild(root_0, stream_projection.nextTree());
						}
						stream_projection.reset();

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:867:16: LEFT_BRACKET keyvalue ( COMMA keyvalue )* RIGHT_BRACKET ( projection )*
					{
					LEFT_BRACKET555=(Token)match(input,LEFT_BRACKET,FOLLOW_LEFT_BRACKET_in_bracket_expr5529); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LEFT_BRACKET.add(LEFT_BRACKET555);

					pushFollow(FOLLOW_keyvalue_in_bracket_expr5531);
					keyvalue556=keyvalue();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_keyvalue.add(keyvalue556.getTree());
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:867:38: ( COMMA keyvalue )*
					loop162:
					while (true) {
						int alt162=2;
						int LA162_0 = input.LA(1);
						if ( (LA162_0==COMMA) ) {
							alt162=1;
						}

						switch (alt162) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:867:40: COMMA keyvalue
							{
							COMMA557=(Token)match(input,COMMA,FOLLOW_COMMA_in_bracket_expr5535); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COMMA.add(COMMA557);

							pushFollow(FOLLOW_keyvalue_in_bracket_expr5537);
							keyvalue558=keyvalue();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_keyvalue.add(keyvalue558.getTree());
							}
							break;

						default :
							break loop162;
						}
					}

					RIGHT_BRACKET559=(Token)match(input,RIGHT_BRACKET,FOLLOW_RIGHT_BRACKET_in_bracket_expr5542); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RIGHT_BRACKET.add(RIGHT_BRACKET559);

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:867:72: ( projection )*
					loop163:
					while (true) {
						int alt163=2;
						int LA163_0 = input.LA(1);
						if ( (LA163_0==PERIOD||LA163_0==POUND) ) {
							alt163=1;
						}

						switch (alt163) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:867:72: projection
							{
							pushFollow(FOLLOW_projection_in_bracket_expr5544);
							projection560=projection();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_projection.add(projection560.getTree());
							}
							break;

						default :
							break loop163;
						}
					}

					// AST REWRITE
					// elements: keyvalue, projection
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 867:84: -> ^( MAP_VAL ( keyvalue )+ ) ( projection )*
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:867:87: ^( MAP_VAL ( keyvalue )+ )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MAP_VAL, "MAP_VAL"), root_1);
						if ( !(stream_keyvalue.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_keyvalue.hasNext() ) {
							adaptor.addChild(root_1, stream_keyvalue.nextTree());
						}
						stream_keyvalue.reset();

						adaptor.addChild(root_0, root_1);
						}

						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:867:110: ( projection )*
						while ( stream_projection.hasNext() ) {
							adaptor.addChild(root_0, stream_projection.nextTree());
						}
						stream_projection.reset();

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:868:16: LEFT_BRACKET RIGHT_BRACKET ( projection )*
					{
					LEFT_BRACKET561=(Token)match(input,LEFT_BRACKET,FOLLOW_LEFT_BRACKET_in_bracket_expr5576); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LEFT_BRACKET.add(LEFT_BRACKET561);

					RIGHT_BRACKET562=(Token)match(input,RIGHT_BRACKET,FOLLOW_RIGHT_BRACKET_in_bracket_expr5578); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RIGHT_BRACKET.add(RIGHT_BRACKET562);

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:868:43: ( projection )*
					loop164:
					while (true) {
						int alt164=2;
						int LA164_0 = input.LA(1);
						if ( (LA164_0==PERIOD||LA164_0==POUND) ) {
							alt164=1;
						}

						switch (alt164) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:868:43: projection
							{
							pushFollow(FOLLOW_projection_in_bracket_expr5580);
							projection563=projection();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_projection.add(projection563.getTree());
							}
							break;

						default :
							break loop164;
						}
					}

					// AST REWRITE
					// elements: projection
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 868:55: -> ^( MAP_VAL ) ( projection )*
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:868:58: ^( MAP_VAL )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MAP_VAL, "MAP_VAL"), root_1);
						adaptor.addChild(root_0, root_1);
						}

						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:868:71: ( projection )*
						while ( stream_projection.hasNext() ) {
							adaptor.addChild(root_0, stream_projection.nextTree());
						}
						stream_projection.reset();

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "bracket_expr"


	public static class projection_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "projection"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:871:1: projection : ( PERIOD ( col_ref | LEFT_PAREN col_ref ( COMMA col_ref )* RIGHT_PAREN ) -> ^( PERIOD ( col_ref )+ ) | POUND ^ ( QUOTEDSTRING | NULL ) );
	public final QueryParser.projection_return projection() throws RecognitionException {
		QueryParser.projection_return retval = new QueryParser.projection_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token PERIOD564=null;
		Token LEFT_PAREN566=null;
		Token COMMA568=null;
		Token RIGHT_PAREN570=null;
		Token POUND571=null;
		Token set572=null;
		ParserRuleReturnScope col_ref565 =null;
		ParserRuleReturnScope col_ref567 =null;
		ParserRuleReturnScope col_ref569 =null;

		Object PERIOD564_tree=null;
		Object LEFT_PAREN566_tree=null;
		Object COMMA568_tree=null;
		Object RIGHT_PAREN570_tree=null;
		Object POUND571_tree=null;
		Object set572_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleTokenStream stream_PERIOD=new RewriteRuleTokenStream(adaptor,"token PERIOD");
		RewriteRuleTokenStream stream_RIGHT_PAREN=new RewriteRuleTokenStream(adaptor,"token RIGHT_PAREN");
		RewriteRuleTokenStream stream_LEFT_PAREN=new RewriteRuleTokenStream(adaptor,"token LEFT_PAREN");
		RewriteRuleSubtreeStream stream_col_ref=new RewriteRuleSubtreeStream(adaptor,"rule col_ref");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:871:12: ( PERIOD ( col_ref | LEFT_PAREN col_ref ( COMMA col_ref )* RIGHT_PAREN ) -> ^( PERIOD ( col_ref )+ ) | POUND ^ ( QUOTEDSTRING | NULL ) )
			int alt168=2;
			int LA168_0 = input.LA(1);
			if ( (LA168_0==PERIOD) ) {
				alt168=1;
			}
			else if ( (LA168_0==POUND) ) {
				alt168=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 168, 0, input);
				throw nvae;
			}

			switch (alt168) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:871:14: PERIOD ( col_ref | LEFT_PAREN col_ref ( COMMA col_ref )* RIGHT_PAREN )
					{
					PERIOD564=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_projection5601); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_PERIOD.add(PERIOD564);

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:871:21: ( col_ref | LEFT_PAREN col_ref ( COMMA col_ref )* RIGHT_PAREN )
					int alt167=2;
					int LA167_0 = input.LA(1);
					if ( (LA167_0==CUBE||LA167_0==DOLLARVAR||(LA167_0 >= ELSE && LA167_0 <= END)||LA167_0==GROUP||LA167_0==IDENTIFIER||LA167_0==IN||LA167_0==RANK||LA167_0==THEN||LA167_0==WHEN) ) {
						alt167=1;
					}
					else if ( (LA167_0==LEFT_PAREN) ) {
						alt167=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 167, 0, input);
						throw nvae;
					}

					switch (alt167) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:871:23: col_ref
							{
							pushFollow(FOLLOW_col_ref_in_projection5605);
							col_ref565=col_ref();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_col_ref.add(col_ref565.getTree());
							}
							break;
						case 2 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:871:33: LEFT_PAREN col_ref ( COMMA col_ref )* RIGHT_PAREN
							{
							LEFT_PAREN566=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_projection5609); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_LEFT_PAREN.add(LEFT_PAREN566);

							pushFollow(FOLLOW_col_ref_in_projection5611);
							col_ref567=col_ref();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_col_ref.add(col_ref567.getTree());
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:871:52: ( COMMA col_ref )*
							loop166:
							while (true) {
								int alt166=2;
								int LA166_0 = input.LA(1);
								if ( (LA166_0==COMMA) ) {
									alt166=1;
								}

								switch (alt166) {
								case 1 :
									// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:871:54: COMMA col_ref
									{
									COMMA568=(Token)match(input,COMMA,FOLLOW_COMMA_in_projection5615); if (state.failed) return retval; 
									if ( state.backtracking==0 ) stream_COMMA.add(COMMA568);

									pushFollow(FOLLOW_col_ref_in_projection5617);
									col_ref569=col_ref();
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) stream_col_ref.add(col_ref569.getTree());
									}
									break;

								default :
									break loop166;
								}
							}

							RIGHT_PAREN570=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_projection5622); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_RIGHT_PAREN.add(RIGHT_PAREN570);

							}
							break;

					}

					// AST REWRITE
					// elements: col_ref, PERIOD
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 871:85: -> ^( PERIOD ( col_ref )+ )
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:871:88: ^( PERIOD ( col_ref )+ )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot(stream_PERIOD.nextNode(), root_1);
						if ( !(stream_col_ref.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_col_ref.hasNext() ) {
							adaptor.addChild(root_1, stream_col_ref.nextTree());
						}
						stream_col_ref.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:872:14: POUND ^ ( QUOTEDSTRING | NULL )
					{
					root_0 = (Object)adaptor.nil();


					POUND571=(Token)match(input,POUND,FOLLOW_POUND_in_projection5650); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					POUND571_tree = (Object)adaptor.create(POUND571);
					root_0 = (Object)adaptor.becomeRoot(POUND571_tree, root_0);
					}

					set572=input.LT(1);
					if ( input.LA(1)==NULL||input.LA(1)==QUOTEDSTRING ) {
						input.consume();
						if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set572));
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "projection"


	public static class col_ref_without_identifier_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "col_ref_without_identifier"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:878:1: col_ref_without_identifier : ( GROUP | DOLLARVAR );
	public final QueryParser.col_ref_without_identifier_return col_ref_without_identifier() throws RecognitionException {
		QueryParser.col_ref_without_identifier_return retval = new QueryParser.col_ref_without_identifier_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set573=null;

		Object set573_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:878:28: ( GROUP | DOLLARVAR )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:
			{
			root_0 = (Object)adaptor.nil();


			set573=input.LT(1);
			if ( input.LA(1)==DOLLARVAR||input.LA(1)==GROUP ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set573));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "col_ref_without_identifier"


	public static class col_ref_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "col_ref"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:881:1: col_ref : ( col_ref_without_identifier | identifier_plus );
	public final QueryParser.col_ref_return col_ref() throws RecognitionException {
		QueryParser.col_ref_return retval = new QueryParser.col_ref_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope col_ref_without_identifier574 =null;
		ParserRuleReturnScope identifier_plus575 =null;


		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:881:9: ( col_ref_without_identifier | identifier_plus )
			int alt169=2;
			int LA169_0 = input.LA(1);
			if ( (LA169_0==DOLLARVAR||LA169_0==GROUP) ) {
				alt169=1;
			}
			else if ( (LA169_0==CUBE||(LA169_0 >= ELSE && LA169_0 <= END)||LA169_0==IDENTIFIER||LA169_0==IN||LA169_0==RANK||LA169_0==THEN||LA169_0==WHEN) ) {
				alt169=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 169, 0, input);
				throw nvae;
			}

			switch (alt169) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:881:11: col_ref_without_identifier
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_col_ref_without_identifier_in_col_ref5686);
					col_ref_without_identifier574=col_ref_without_identifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, col_ref_without_identifier574.getTree());

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:881:40: identifier_plus
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_identifier_plus_in_col_ref5690);
					identifier_plus575=identifier_plus();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, identifier_plus575.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "col_ref"


	public static class col_range_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "col_range"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:884:1: col_range : (c1= col_ref DOUBLE_PERIOD (c2= col_ref )? -> ^( COL_RANGE $c1 DOUBLE_PERIOD ( $c2)? ) | DOUBLE_PERIOD col_ref -> ^( COL_RANGE DOUBLE_PERIOD col_ref ) );
	public final QueryParser.col_range_return col_range() throws RecognitionException {
		QueryParser.col_range_return retval = new QueryParser.col_range_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token DOUBLE_PERIOD576=null;
		Token DOUBLE_PERIOD577=null;
		ParserRuleReturnScope c1 =null;
		ParserRuleReturnScope c2 =null;
		ParserRuleReturnScope col_ref578 =null;

		Object DOUBLE_PERIOD576_tree=null;
		Object DOUBLE_PERIOD577_tree=null;
		RewriteRuleTokenStream stream_DOUBLE_PERIOD=new RewriteRuleTokenStream(adaptor,"token DOUBLE_PERIOD");
		RewriteRuleSubtreeStream stream_col_ref=new RewriteRuleSubtreeStream(adaptor,"rule col_ref");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:884:11: (c1= col_ref DOUBLE_PERIOD (c2= col_ref )? -> ^( COL_RANGE $c1 DOUBLE_PERIOD ( $c2)? ) | DOUBLE_PERIOD col_ref -> ^( COL_RANGE DOUBLE_PERIOD col_ref ) )
			int alt171=2;
			int LA171_0 = input.LA(1);
			if ( (LA171_0==CUBE||LA171_0==DOLLARVAR||(LA171_0 >= ELSE && LA171_0 <= END)||LA171_0==GROUP||LA171_0==IDENTIFIER||LA171_0==IN||LA171_0==RANK||LA171_0==THEN||LA171_0==WHEN) ) {
				alt171=1;
			}
			else if ( (LA171_0==DOUBLE_PERIOD) ) {
				alt171=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 171, 0, input);
				throw nvae;
			}

			switch (alt171) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:884:13: c1= col_ref DOUBLE_PERIOD (c2= col_ref )?
					{
					pushFollow(FOLLOW_col_ref_in_col_range5703);
					c1=col_ref();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_col_ref.add(c1.getTree());
					DOUBLE_PERIOD576=(Token)match(input,DOUBLE_PERIOD,FOLLOW_DOUBLE_PERIOD_in_col_range5705); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_DOUBLE_PERIOD.add(DOUBLE_PERIOD576);

					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:884:43: (c2= col_ref )?
					int alt170=2;
					int LA170_0 = input.LA(1);
					if ( (LA170_0==CUBE||LA170_0==DOLLARVAR||(LA170_0 >= ELSE && LA170_0 <= END)||LA170_0==GROUP||LA170_0==IDENTIFIER||LA170_0==IN||LA170_0==RANK||LA170_0==THEN||LA170_0==WHEN) ) {
						alt170=1;
					}
					switch (alt170) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:884:43: c2= col_ref
							{
							pushFollow(FOLLOW_col_ref_in_col_range5711);
							c2=col_ref();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_col_ref.add(c2.getTree());
							}
							break;

					}

					// AST REWRITE
					// elements: DOUBLE_PERIOD, c1, c2
					// token labels: 
					// rule labels: c1, retval, c2
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_c1=new RewriteRuleSubtreeStream(adaptor,"rule c1",c1!=null?c1.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);
					RewriteRuleSubtreeStream stream_c2=new RewriteRuleSubtreeStream(adaptor,"rule c2",c2!=null?c2.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 884:54: -> ^( COL_RANGE $c1 DOUBLE_PERIOD ( $c2)? )
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:884:57: ^( COL_RANGE $c1 DOUBLE_PERIOD ( $c2)? )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COL_RANGE, "COL_RANGE"), root_1);
						adaptor.addChild(root_1, stream_c1.nextTree());
						adaptor.addChild(root_1, stream_DOUBLE_PERIOD.nextNode());
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:884:88: ( $c2)?
						if ( stream_c2.hasNext() ) {
							adaptor.addChild(root_1, stream_c2.nextTree());
						}
						stream_c2.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:885:14: DOUBLE_PERIOD col_ref
					{
					DOUBLE_PERIOD577=(Token)match(input,DOUBLE_PERIOD,FOLLOW_DOUBLE_PERIOD_in_col_range5742); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_DOUBLE_PERIOD.add(DOUBLE_PERIOD577);

					pushFollow(FOLLOW_col_ref_in_col_range5744);
					col_ref578=col_ref();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_col_ref.add(col_ref578.getTree());
					// AST REWRITE
					// elements: col_ref, DOUBLE_PERIOD
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 885:36: -> ^( COL_RANGE DOUBLE_PERIOD col_ref )
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:885:39: ^( COL_RANGE DOUBLE_PERIOD col_ref )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COL_RANGE, "COL_RANGE"), root_1);
						adaptor.addChild(root_1, stream_DOUBLE_PERIOD.nextNode());
						adaptor.addChild(root_1, stream_col_ref.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "col_range"


	public static class scalar_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "scalar"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:888:1: scalar : ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER | QUOTEDSTRING | NULL | TRUE | FALSE );
	public final QueryParser.scalar_return scalar() throws RecognitionException {
		QueryParser.scalar_return retval = new QueryParser.scalar_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set579=null;

		Object set579_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:888:8: ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER | QUOTEDSTRING | NULL | TRUE | FALSE )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:
			{
			root_0 = (Object)adaptor.nil();


			set579=input.LT(1);
			if ( input.LA(1)==BIGDECIMALNUMBER||input.LA(1)==BIGINTEGERNUMBER||input.LA(1)==DOUBLENUMBER||input.LA(1)==FALSE||input.LA(1)==FLOATNUMBER||input.LA(1)==INTEGER||input.LA(1)==LONGINTEGER||input.LA(1)==NULL||input.LA(1)==QUOTEDSTRING||input.LA(1)==TRUE ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set579));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "scalar"


	public static class keyvalue_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "keyvalue"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:900:1: keyvalue : QUOTEDSTRING POUND literal -> ^( KEY_VAL_PAIR QUOTEDSTRING literal ) ;
	public final QueryParser.keyvalue_return keyvalue() throws RecognitionException {
		QueryParser.keyvalue_return retval = new QueryParser.keyvalue_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token QUOTEDSTRING580=null;
		Token POUND581=null;
		ParserRuleReturnScope literal582 =null;

		Object QUOTEDSTRING580_tree=null;
		Object POUND581_tree=null;
		RewriteRuleTokenStream stream_POUND=new RewriteRuleTokenStream(adaptor,"token POUND");
		RewriteRuleTokenStream stream_QUOTEDSTRING=new RewriteRuleTokenStream(adaptor,"token QUOTEDSTRING");
		RewriteRuleSubtreeStream stream_literal=new RewriteRuleSubtreeStream(adaptor,"rule literal");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:900:10: ( QUOTEDSTRING POUND literal -> ^( KEY_VAL_PAIR QUOTEDSTRING literal ) )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:900:12: QUOTEDSTRING POUND literal
			{
			QUOTEDSTRING580=(Token)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_keyvalue5871); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_QUOTEDSTRING.add(QUOTEDSTRING580);

			POUND581=(Token)match(input,POUND,FOLLOW_POUND_in_keyvalue5873); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_POUND.add(POUND581);

			pushFollow(FOLLOW_literal_in_keyvalue5875);
			literal582=literal();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_literal.add(literal582.getTree());
			// AST REWRITE
			// elements: literal, QUOTEDSTRING
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 900:39: -> ^( KEY_VAL_PAIR QUOTEDSTRING literal )
			{
				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:900:42: ^( KEY_VAL_PAIR QUOTEDSTRING literal )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(KEY_VAL_PAIR, "KEY_VAL_PAIR"), root_1);
				adaptor.addChild(root_1, stream_QUOTEDSTRING.nextNode());
				adaptor.addChild(root_1, stream_literal.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "keyvalue"


	public static class literal_map_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "literal_map"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:903:1: literal_map : ( LEFT_BRACKET keyvalue ( COMMA keyvalue )* RIGHT_BRACKET -> ^( MAP_VAL ( keyvalue )+ ) | LEFT_BRACKET RIGHT_BRACKET -> ^( MAP_VAL ) );
	public final QueryParser.literal_map_return literal_map() throws RecognitionException {
		QueryParser.literal_map_return retval = new QueryParser.literal_map_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LEFT_BRACKET583=null;
		Token COMMA585=null;
		Token RIGHT_BRACKET587=null;
		Token LEFT_BRACKET588=null;
		Token RIGHT_BRACKET589=null;
		ParserRuleReturnScope keyvalue584 =null;
		ParserRuleReturnScope keyvalue586 =null;

		Object LEFT_BRACKET583_tree=null;
		Object COMMA585_tree=null;
		Object RIGHT_BRACKET587_tree=null;
		Object LEFT_BRACKET588_tree=null;
		Object RIGHT_BRACKET589_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleTokenStream stream_RIGHT_BRACKET=new RewriteRuleTokenStream(adaptor,"token RIGHT_BRACKET");
		RewriteRuleTokenStream stream_LEFT_BRACKET=new RewriteRuleTokenStream(adaptor,"token LEFT_BRACKET");
		RewriteRuleSubtreeStream stream_keyvalue=new RewriteRuleSubtreeStream(adaptor,"rule keyvalue");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:903:13: ( LEFT_BRACKET keyvalue ( COMMA keyvalue )* RIGHT_BRACKET -> ^( MAP_VAL ( keyvalue )+ ) | LEFT_BRACKET RIGHT_BRACKET -> ^( MAP_VAL ) )
			int alt173=2;
			int LA173_0 = input.LA(1);
			if ( (LA173_0==LEFT_BRACKET) ) {
				int LA173_1 = input.LA(2);
				if ( (LA173_1==RIGHT_BRACKET) ) {
					alt173=2;
				}
				else if ( (LA173_1==QUOTEDSTRING) ) {
					alt173=1;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 173, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 173, 0, input);
				throw nvae;
			}

			switch (alt173) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:903:15: LEFT_BRACKET keyvalue ( COMMA keyvalue )* RIGHT_BRACKET
					{
					LEFT_BRACKET583=(Token)match(input,LEFT_BRACKET,FOLLOW_LEFT_BRACKET_in_literal_map5896); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LEFT_BRACKET.add(LEFT_BRACKET583);

					pushFollow(FOLLOW_keyvalue_in_literal_map5898);
					keyvalue584=keyvalue();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_keyvalue.add(keyvalue584.getTree());
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:903:37: ( COMMA keyvalue )*
					loop172:
					while (true) {
						int alt172=2;
						int LA172_0 = input.LA(1);
						if ( (LA172_0==COMMA) ) {
							alt172=1;
						}

						switch (alt172) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:903:39: COMMA keyvalue
							{
							COMMA585=(Token)match(input,COMMA,FOLLOW_COMMA_in_literal_map5902); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COMMA.add(COMMA585);

							pushFollow(FOLLOW_keyvalue_in_literal_map5904);
							keyvalue586=keyvalue();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_keyvalue.add(keyvalue586.getTree());
							}
							break;

						default :
							break loop172;
						}
					}

					RIGHT_BRACKET587=(Token)match(input,RIGHT_BRACKET,FOLLOW_RIGHT_BRACKET_in_literal_map5909); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RIGHT_BRACKET.add(RIGHT_BRACKET587);

					// AST REWRITE
					// elements: keyvalue
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 903:71: -> ^( MAP_VAL ( keyvalue )+ )
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:903:74: ^( MAP_VAL ( keyvalue )+ )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MAP_VAL, "MAP_VAL"), root_1);
						if ( !(stream_keyvalue.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_keyvalue.hasNext() ) {
							adaptor.addChild(root_1, stream_keyvalue.nextTree());
						}
						stream_keyvalue.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:904:15: LEFT_BRACKET RIGHT_BRACKET
					{
					LEFT_BRACKET588=(Token)match(input,LEFT_BRACKET,FOLLOW_LEFT_BRACKET_in_literal_map5936); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LEFT_BRACKET.add(LEFT_BRACKET588);

					RIGHT_BRACKET589=(Token)match(input,RIGHT_BRACKET,FOLLOW_RIGHT_BRACKET_in_literal_map5938); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RIGHT_BRACKET.add(RIGHT_BRACKET589);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 904:42: -> ^( MAP_VAL )
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:904:45: ^( MAP_VAL )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MAP_VAL, "MAP_VAL"), root_1);
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "literal_map"


	public static class literal_bag_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "literal_bag"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:908:1: literal_bag : ( LEFT_CURLY literal_tuple ( COMMA literal_tuple )* RIGHT_CURLY -> ^( BAG_VAL ( literal_tuple )+ ) | LEFT_CURLY RIGHT_CURLY -> ^( BAG_VAL ) );
	public final QueryParser.literal_bag_return literal_bag() throws RecognitionException {
		QueryParser.literal_bag_return retval = new QueryParser.literal_bag_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LEFT_CURLY590=null;
		Token COMMA592=null;
		Token RIGHT_CURLY594=null;
		Token LEFT_CURLY595=null;
		Token RIGHT_CURLY596=null;
		ParserRuleReturnScope literal_tuple591 =null;
		ParserRuleReturnScope literal_tuple593 =null;

		Object LEFT_CURLY590_tree=null;
		Object COMMA592_tree=null;
		Object RIGHT_CURLY594_tree=null;
		Object LEFT_CURLY595_tree=null;
		Object RIGHT_CURLY596_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleTokenStream stream_LEFT_CURLY=new RewriteRuleTokenStream(adaptor,"token LEFT_CURLY");
		RewriteRuleTokenStream stream_RIGHT_CURLY=new RewriteRuleTokenStream(adaptor,"token RIGHT_CURLY");
		RewriteRuleSubtreeStream stream_literal_tuple=new RewriteRuleSubtreeStream(adaptor,"rule literal_tuple");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:908:13: ( LEFT_CURLY literal_tuple ( COMMA literal_tuple )* RIGHT_CURLY -> ^( BAG_VAL ( literal_tuple )+ ) | LEFT_CURLY RIGHT_CURLY -> ^( BAG_VAL ) )
			int alt175=2;
			int LA175_0 = input.LA(1);
			if ( (LA175_0==LEFT_CURLY) ) {
				int LA175_1 = input.LA(2);
				if ( (LA175_1==RIGHT_CURLY) ) {
					alt175=2;
				}
				else if ( (LA175_1==LEFT_PAREN) ) {
					alt175=1;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 175, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 175, 0, input);
				throw nvae;
			}

			switch (alt175) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:908:15: LEFT_CURLY literal_tuple ( COMMA literal_tuple )* RIGHT_CURLY
					{
					LEFT_CURLY590=(Token)match(input,LEFT_CURLY,FOLLOW_LEFT_CURLY_in_literal_bag5956); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LEFT_CURLY.add(LEFT_CURLY590);

					pushFollow(FOLLOW_literal_tuple_in_literal_bag5958);
					literal_tuple591=literal_tuple();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_literal_tuple.add(literal_tuple591.getTree());
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:908:40: ( COMMA literal_tuple )*
					loop174:
					while (true) {
						int alt174=2;
						int LA174_0 = input.LA(1);
						if ( (LA174_0==COMMA) ) {
							alt174=1;
						}

						switch (alt174) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:908:42: COMMA literal_tuple
							{
							COMMA592=(Token)match(input,COMMA,FOLLOW_COMMA_in_literal_bag5962); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COMMA.add(COMMA592);

							pushFollow(FOLLOW_literal_tuple_in_literal_bag5964);
							literal_tuple593=literal_tuple();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_literal_tuple.add(literal_tuple593.getTree());
							}
							break;

						default :
							break loop174;
						}
					}

					RIGHT_CURLY594=(Token)match(input,RIGHT_CURLY,FOLLOW_RIGHT_CURLY_in_literal_bag5969); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RIGHT_CURLY.add(RIGHT_CURLY594);

					// AST REWRITE
					// elements: literal_tuple
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 908:77: -> ^( BAG_VAL ( literal_tuple )+ )
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:908:80: ^( BAG_VAL ( literal_tuple )+ )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BAG_VAL, "BAG_VAL"), root_1);
						if ( !(stream_literal_tuple.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_literal_tuple.hasNext() ) {
							adaptor.addChild(root_1, stream_literal_tuple.nextTree());
						}
						stream_literal_tuple.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:909:15: LEFT_CURLY RIGHT_CURLY
					{
					LEFT_CURLY595=(Token)match(input,LEFT_CURLY,FOLLOW_LEFT_CURLY_in_literal_bag5996); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LEFT_CURLY.add(LEFT_CURLY595);

					RIGHT_CURLY596=(Token)match(input,RIGHT_CURLY,FOLLOW_RIGHT_CURLY_in_literal_bag5998); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RIGHT_CURLY.add(RIGHT_CURLY596);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 909:38: -> ^( BAG_VAL )
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:909:41: ^( BAG_VAL )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BAG_VAL, "BAG_VAL"), root_1);
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "literal_bag"


	public static class literal_tuple_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "literal_tuple"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:912:1: literal_tuple : ( LEFT_PAREN literal ( COMMA literal )* RIGHT_PAREN -> ^( TUPLE_VAL ( literal )+ ) | LEFT_PAREN RIGHT_PAREN -> ^( TUPLE_VAL ) );
	public final QueryParser.literal_tuple_return literal_tuple() throws RecognitionException {
		QueryParser.literal_tuple_return retval = new QueryParser.literal_tuple_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LEFT_PAREN597=null;
		Token COMMA599=null;
		Token RIGHT_PAREN601=null;
		Token LEFT_PAREN602=null;
		Token RIGHT_PAREN603=null;
		ParserRuleReturnScope literal598 =null;
		ParserRuleReturnScope literal600 =null;

		Object LEFT_PAREN597_tree=null;
		Object COMMA599_tree=null;
		Object RIGHT_PAREN601_tree=null;
		Object LEFT_PAREN602_tree=null;
		Object RIGHT_PAREN603_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleTokenStream stream_RIGHT_PAREN=new RewriteRuleTokenStream(adaptor,"token RIGHT_PAREN");
		RewriteRuleTokenStream stream_LEFT_PAREN=new RewriteRuleTokenStream(adaptor,"token LEFT_PAREN");
		RewriteRuleSubtreeStream stream_literal=new RewriteRuleSubtreeStream(adaptor,"rule literal");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:912:15: ( LEFT_PAREN literal ( COMMA literal )* RIGHT_PAREN -> ^( TUPLE_VAL ( literal )+ ) | LEFT_PAREN RIGHT_PAREN -> ^( TUPLE_VAL ) )
			int alt177=2;
			int LA177_0 = input.LA(1);
			if ( (LA177_0==LEFT_PAREN) ) {
				int LA177_1 = input.LA(2);
				if ( (LA177_1==RIGHT_PAREN) ) {
					alt177=2;
				}
				else if ( (LA177_1==BIGDECIMALNUMBER||LA177_1==BIGINTEGERNUMBER||LA177_1==DOUBLENUMBER||LA177_1==FALSE||LA177_1==FLOATNUMBER||LA177_1==INTEGER||(LA177_1 >= LEFT_BRACKET && LA177_1 <= LEFT_PAREN)||LA177_1==LONGINTEGER||LA177_1==NULL||LA177_1==QUOTEDSTRING||LA177_1==TRUE) ) {
					alt177=1;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 177, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 177, 0, input);
				throw nvae;
			}

			switch (alt177) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:912:17: LEFT_PAREN literal ( COMMA literal )* RIGHT_PAREN
					{
					LEFT_PAREN597=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_literal_tuple6015); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LEFT_PAREN.add(LEFT_PAREN597);

					pushFollow(FOLLOW_literal_in_literal_tuple6017);
					literal598=literal();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_literal.add(literal598.getTree());
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:912:36: ( COMMA literal )*
					loop176:
					while (true) {
						int alt176=2;
						int LA176_0 = input.LA(1);
						if ( (LA176_0==COMMA) ) {
							alt176=1;
						}

						switch (alt176) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:912:38: COMMA literal
							{
							COMMA599=(Token)match(input,COMMA,FOLLOW_COMMA_in_literal_tuple6021); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COMMA.add(COMMA599);

							pushFollow(FOLLOW_literal_in_literal_tuple6023);
							literal600=literal();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_literal.add(literal600.getTree());
							}
							break;

						default :
							break loop176;
						}
					}

					RIGHT_PAREN601=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_literal_tuple6028); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RIGHT_PAREN.add(RIGHT_PAREN601);

					// AST REWRITE
					// elements: literal
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 912:67: -> ^( TUPLE_VAL ( literal )+ )
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:912:70: ^( TUPLE_VAL ( literal )+ )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TUPLE_VAL, "TUPLE_VAL"), root_1);
						if ( !(stream_literal.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_literal.hasNext() ) {
							adaptor.addChild(root_1, stream_literal.nextTree());
						}
						stream_literal.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:913:17: LEFT_PAREN RIGHT_PAREN
					{
					LEFT_PAREN602=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_literal_tuple6057); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LEFT_PAREN.add(LEFT_PAREN602);

					RIGHT_PAREN603=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_literal_tuple6059); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RIGHT_PAREN.add(RIGHT_PAREN603);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 913:40: -> ^( TUPLE_VAL )
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:913:43: ^( TUPLE_VAL )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TUPLE_VAL, "TUPLE_VAL"), root_1);
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "literal_tuple"


	public static class literal_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "literal"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:916:1: literal : ( scalar | literal_map | literal_bag | literal_tuple );
	public final QueryParser.literal_return literal() throws RecognitionException {
		QueryParser.literal_return retval = new QueryParser.literal_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope scalar604 =null;
		ParserRuleReturnScope literal_map605 =null;
		ParserRuleReturnScope literal_bag606 =null;
		ParserRuleReturnScope literal_tuple607 =null;


		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:916:9: ( scalar | literal_map | literal_bag | literal_tuple )
			int alt178=4;
			switch ( input.LA(1) ) {
			case BIGDECIMALNUMBER:
			case BIGINTEGERNUMBER:
			case DOUBLENUMBER:
			case FALSE:
			case FLOATNUMBER:
			case INTEGER:
			case LONGINTEGER:
			case NULL:
			case QUOTEDSTRING:
			case TRUE:
				{
				alt178=1;
				}
				break;
			case LEFT_BRACKET:
				{
				alt178=2;
				}
				break;
			case LEFT_CURLY:
				{
				alt178=3;
				}
				break;
			case LEFT_PAREN:
				{
				alt178=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 178, 0, input);
				throw nvae;
			}
			switch (alt178) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:916:11: scalar
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_scalar_in_literal6076);
					scalar604=scalar();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, scalar604.getTree());

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:916:20: literal_map
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_literal_map_in_literal6080);
					literal_map605=literal_map();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, literal_map605.getTree());

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:916:34: literal_bag
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_literal_bag_in_literal6084);
					literal_bag606=literal_bag();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, literal_bag606.getTree());

					}
					break;
				case 4 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:916:48: literal_tuple
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_literal_tuple_in_literal6088);
					literal_tuple607=literal_tuple();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, literal_tuple607.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "literal"


	public static class nested_blk_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "nested_blk"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:921:1: nested_blk : ( nested_command SEMI_COLON )* GENERATE flatten_generated_item ( COMMA flatten_generated_item )* SEMI_COLON -> ( nested_command )* ^( GENERATE ( flatten_generated_item )+ ) ;
	public final QueryParser.nested_blk_return nested_blk() throws RecognitionException {
		QueryParser.nested_blk_return retval = new QueryParser.nested_blk_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SEMI_COLON609=null;
		Token GENERATE610=null;
		Token COMMA612=null;
		Token SEMI_COLON614=null;
		ParserRuleReturnScope nested_command608 =null;
		ParserRuleReturnScope flatten_generated_item611 =null;
		ParserRuleReturnScope flatten_generated_item613 =null;

		Object SEMI_COLON609_tree=null;
		Object GENERATE610_tree=null;
		Object COMMA612_tree=null;
		Object SEMI_COLON614_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleTokenStream stream_SEMI_COLON=new RewriteRuleTokenStream(adaptor,"token SEMI_COLON");
		RewriteRuleTokenStream stream_GENERATE=new RewriteRuleTokenStream(adaptor,"token GENERATE");
		RewriteRuleSubtreeStream stream_flatten_generated_item=new RewriteRuleSubtreeStream(adaptor,"rule flatten_generated_item");
		RewriteRuleSubtreeStream stream_nested_command=new RewriteRuleSubtreeStream(adaptor,"rule nested_command");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:921:12: ( ( nested_command SEMI_COLON )* GENERATE flatten_generated_item ( COMMA flatten_generated_item )* SEMI_COLON -> ( nested_command )* ^( GENERATE ( flatten_generated_item )+ ) )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:921:14: ( nested_command SEMI_COLON )* GENERATE flatten_generated_item ( COMMA flatten_generated_item )* SEMI_COLON
			{
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:921:14: ( nested_command SEMI_COLON )*
			loop179:
			while (true) {
				int alt179=2;
				int LA179_0 = input.LA(1);
				if ( (LA179_0==CUBE||(LA179_0 >= ELSE && LA179_0 <= END)||LA179_0==IDENTIFIER||LA179_0==IN||LA179_0==RANK||LA179_0==THEN||LA179_0==WHEN) ) {
					alt179=1;
				}

				switch (alt179) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:921:16: nested_command SEMI_COLON
					{
					pushFollow(FOLLOW_nested_command_in_nested_blk6101);
					nested_command608=nested_command();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_nested_command.add(nested_command608.getTree());
					SEMI_COLON609=(Token)match(input,SEMI_COLON,FOLLOW_SEMI_COLON_in_nested_blk6103); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SEMI_COLON.add(SEMI_COLON609);

					}
					break;

				default :
					break loop179;
				}
			}

			GENERATE610=(Token)match(input,GENERATE,FOLLOW_GENERATE_in_nested_blk6108); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_GENERATE.add(GENERATE610);

			pushFollow(FOLLOW_flatten_generated_item_in_nested_blk6110);
			flatten_generated_item611=flatten_generated_item();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_flatten_generated_item.add(flatten_generated_item611.getTree());
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:921:77: ( COMMA flatten_generated_item )*
			loop180:
			while (true) {
				int alt180=2;
				int LA180_0 = input.LA(1);
				if ( (LA180_0==COMMA) ) {
					alt180=1;
				}

				switch (alt180) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:921:79: COMMA flatten_generated_item
					{
					COMMA612=(Token)match(input,COMMA,FOLLOW_COMMA_in_nested_blk6114); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COMMA.add(COMMA612);

					pushFollow(FOLLOW_flatten_generated_item_in_nested_blk6116);
					flatten_generated_item613=flatten_generated_item();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_flatten_generated_item.add(flatten_generated_item613.getTree());
					}
					break;

				default :
					break loop180;
				}
			}

			SEMI_COLON614=(Token)match(input,SEMI_COLON,FOLLOW_SEMI_COLON_in_nested_blk6121); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEMI_COLON.add(SEMI_COLON614);

			// AST REWRITE
			// elements: nested_command, GENERATE, flatten_generated_item
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 922:5: -> ( nested_command )* ^( GENERATE ( flatten_generated_item )+ )
			{
				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:922:8: ( nested_command )*
				while ( stream_nested_command.hasNext() ) {
					adaptor.addChild(root_0, stream_nested_command.nextTree());
				}
				stream_nested_command.reset();

				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:922:24: ^( GENERATE ( flatten_generated_item )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot(stream_GENERATE.nextNode(), root_1);
				if ( !(stream_flatten_generated_item.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_flatten_generated_item.hasNext() ) {
					adaptor.addChild(root_1, stream_flatten_generated_item.nextTree());
				}
				stream_flatten_generated_item.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "nested_blk"


	public static class nested_command_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "nested_command"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:925:1: nested_command : ( ( identifier_plus EQUAL col_ref PERIOD col_ref_list {...}?)=> ( identifier_plus EQUAL nested_proj ) -> ^( NESTED_CMD identifier_plus nested_proj ) | identifier_plus EQUAL expr -> ^( NESTED_CMD_ASSI identifier_plus expr ) | identifier_plus EQUAL nested_op -> ^( NESTED_CMD identifier_plus nested_op ) );
	public final QueryParser.nested_command_return nested_command() throws RecognitionException {
		QueryParser.nested_command_return retval = new QueryParser.nested_command_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token EQUAL616=null;
		Token EQUAL619=null;
		Token EQUAL622=null;
		ParserRuleReturnScope identifier_plus615 =null;
		ParserRuleReturnScope nested_proj617 =null;
		ParserRuleReturnScope identifier_plus618 =null;
		ParserRuleReturnScope expr620 =null;
		ParserRuleReturnScope identifier_plus621 =null;
		ParserRuleReturnScope nested_op623 =null;

		Object EQUAL616_tree=null;
		Object EQUAL619_tree=null;
		Object EQUAL622_tree=null;
		RewriteRuleTokenStream stream_EQUAL=new RewriteRuleTokenStream(adaptor,"token EQUAL");
		RewriteRuleSubtreeStream stream_nested_op=new RewriteRuleSubtreeStream(adaptor,"rule nested_op");
		RewriteRuleSubtreeStream stream_identifier_plus=new RewriteRuleSubtreeStream(adaptor,"rule identifier_plus");
		RewriteRuleSubtreeStream stream_nested_proj=new RewriteRuleSubtreeStream(adaptor,"rule nested_proj");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:925:16: ( ( identifier_plus EQUAL col_ref PERIOD col_ref_list {...}?)=> ( identifier_plus EQUAL nested_proj ) -> ^( NESTED_CMD identifier_plus nested_proj ) | identifier_plus EQUAL expr -> ^( NESTED_CMD_ASSI identifier_plus expr ) | identifier_plus EQUAL nested_op -> ^( NESTED_CMD identifier_plus nested_op ) )
			int alt181=3;
			alt181 = dfa181.predict(input);
			switch (alt181) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:925:18: ( identifier_plus EQUAL col_ref PERIOD col_ref_list {...}?)=> ( identifier_plus EQUAL nested_proj )
					{
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:925:108: ( identifier_plus EQUAL nested_proj )
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:925:110: identifier_plus EQUAL nested_proj
					{
					pushFollow(FOLLOW_identifier_plus_in_nested_command6168);
					identifier_plus615=identifier_plus();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_identifier_plus.add(identifier_plus615.getTree());
					EQUAL616=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_nested_command6170); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_EQUAL.add(EQUAL616);

					pushFollow(FOLLOW_nested_proj_in_nested_command6172);
					nested_proj617=nested_proj();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_nested_proj.add(nested_proj617.getTree());
					}

					// AST REWRITE
					// elements: identifier_plus, nested_proj
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 926:15: -> ^( NESTED_CMD identifier_plus nested_proj )
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:926:18: ^( NESTED_CMD identifier_plus nested_proj )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NESTED_CMD, "NESTED_CMD"), root_1);
						adaptor.addChild(root_1, stream_identifier_plus.nextTree());
						adaptor.addChild(root_1, stream_nested_proj.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:927:18: identifier_plus EQUAL expr
					{
					pushFollow(FOLLOW_identifier_plus_in_nested_command6219);
					identifier_plus618=identifier_plus();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_identifier_plus.add(identifier_plus618.getTree());
					EQUAL619=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_nested_command6221); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_EQUAL.add(EQUAL619);

					pushFollow(FOLLOW_expr_in_nested_command6223);
					expr620=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr620.getTree());
					// AST REWRITE
					// elements: expr, identifier_plus
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 928:15: -> ^( NESTED_CMD_ASSI identifier_plus expr )
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:928:18: ^( NESTED_CMD_ASSI identifier_plus expr )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NESTED_CMD_ASSI, "NESTED_CMD_ASSI"), root_1);
						adaptor.addChild(root_1, stream_identifier_plus.nextTree());
						adaptor.addChild(root_1, stream_expr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:929:18: identifier_plus EQUAL nested_op
					{
					pushFollow(FOLLOW_identifier_plus_in_nested_command6268);
					identifier_plus621=identifier_plus();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_identifier_plus.add(identifier_plus621.getTree());
					EQUAL622=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_nested_command6270); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_EQUAL.add(EQUAL622);

					pushFollow(FOLLOW_nested_op_in_nested_command6272);
					nested_op623=nested_op();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_nested_op.add(nested_op623.getTree());
					// AST REWRITE
					// elements: nested_op, identifier_plus
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 930:15: -> ^( NESTED_CMD identifier_plus nested_op )
					{
						// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:930:18: ^( NESTED_CMD identifier_plus nested_op )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NESTED_CMD, "NESTED_CMD"), root_1);
						adaptor.addChild(root_1, stream_identifier_plus.nextTree());
						adaptor.addChild(root_1, stream_nested_op.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "nested_command"


	public static class nested_op_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "nested_op"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:933:1: nested_op : ( nested_filter | nested_sort | nested_distinct | nested_limit | nested_cross | nested_foreach );
	public final QueryParser.nested_op_return nested_op() throws RecognitionException {
		QueryParser.nested_op_return retval = new QueryParser.nested_op_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope nested_filter624 =null;
		ParserRuleReturnScope nested_sort625 =null;
		ParserRuleReturnScope nested_distinct626 =null;
		ParserRuleReturnScope nested_limit627 =null;
		ParserRuleReturnScope nested_cross628 =null;
		ParserRuleReturnScope nested_foreach629 =null;


		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:933:11: ( nested_filter | nested_sort | nested_distinct | nested_limit | nested_cross | nested_foreach )
			int alt182=6;
			switch ( input.LA(1) ) {
			case FILTER:
				{
				alt182=1;
				}
				break;
			case ORDER:
				{
				alt182=2;
				}
				break;
			case DISTINCT:
				{
				alt182=3;
				}
				break;
			case LIMIT:
				{
				alt182=4;
				}
				break;
			case CROSS:
				{
				alt182=5;
				}
				break;
			case FOREACH:
				{
				alt182=6;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 182, 0, input);
				throw nvae;
			}
			switch (alt182) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:933:13: nested_filter
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_nested_filter_in_nested_op6307);
					nested_filter624=nested_filter();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, nested_filter624.getTree());

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:934:13: nested_sort
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_nested_sort_in_nested_op6321);
					nested_sort625=nested_sort();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, nested_sort625.getTree());

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:935:13: nested_distinct
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_nested_distinct_in_nested_op6335);
					nested_distinct626=nested_distinct();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, nested_distinct626.getTree());

					}
					break;
				case 4 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:936:13: nested_limit
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_nested_limit_in_nested_op6349);
					nested_limit627=nested_limit();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, nested_limit627.getTree());

					}
					break;
				case 5 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:937:13: nested_cross
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_nested_cross_in_nested_op6363);
					nested_cross628=nested_cross();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, nested_cross628.getTree());

					}
					break;
				case 6 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:938:13: nested_foreach
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_nested_foreach_in_nested_op6377);
					nested_foreach629=nested_foreach();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, nested_foreach629.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "nested_op"


	public static class nested_proj_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "nested_proj"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:941:1: nested_proj : col_ref PERIOD col_ref_list -> ^( NESTED_PROJ col_ref col_ref_list ) ;
	public final QueryParser.nested_proj_return nested_proj() throws RecognitionException {
		QueryParser.nested_proj_return retval = new QueryParser.nested_proj_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token PERIOD631=null;
		ParserRuleReturnScope col_ref630 =null;
		ParserRuleReturnScope col_ref_list632 =null;

		Object PERIOD631_tree=null;
		RewriteRuleTokenStream stream_PERIOD=new RewriteRuleTokenStream(adaptor,"token PERIOD");
		RewriteRuleSubtreeStream stream_col_ref=new RewriteRuleSubtreeStream(adaptor,"rule col_ref");
		RewriteRuleSubtreeStream stream_col_ref_list=new RewriteRuleSubtreeStream(adaptor,"rule col_ref_list");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:941:13: ( col_ref PERIOD col_ref_list -> ^( NESTED_PROJ col_ref col_ref_list ) )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:941:15: col_ref PERIOD col_ref_list
			{
			pushFollow(FOLLOW_col_ref_in_nested_proj6386);
			col_ref630=col_ref();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_col_ref.add(col_ref630.getTree());
			PERIOD631=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_nested_proj6388); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_PERIOD.add(PERIOD631);

			pushFollow(FOLLOW_col_ref_list_in_nested_proj6390);
			col_ref_list632=col_ref_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_col_ref_list.add(col_ref_list632.getTree());
			// AST REWRITE
			// elements: col_ref_list, col_ref
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 942:12: -> ^( NESTED_PROJ col_ref col_ref_list )
			{
				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:942:15: ^( NESTED_PROJ col_ref col_ref_list )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NESTED_PROJ, "NESTED_PROJ"), root_1);
				adaptor.addChild(root_1, stream_col_ref.nextTree());
				adaptor.addChild(root_1, stream_col_ref_list.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "nested_proj"


	public static class col_ref_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "col_ref_list"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:945:1: col_ref_list : ( col_ref | ( LEFT_PAREN col_ref ( COMMA col_ref )* RIGHT_PAREN ) ) -> ( col_ref )+ ;
	public final QueryParser.col_ref_list_return col_ref_list() throws RecognitionException {
		QueryParser.col_ref_list_return retval = new QueryParser.col_ref_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LEFT_PAREN634=null;
		Token COMMA636=null;
		Token RIGHT_PAREN638=null;
		ParserRuleReturnScope col_ref633 =null;
		ParserRuleReturnScope col_ref635 =null;
		ParserRuleReturnScope col_ref637 =null;

		Object LEFT_PAREN634_tree=null;
		Object COMMA636_tree=null;
		Object RIGHT_PAREN638_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleTokenStream stream_RIGHT_PAREN=new RewriteRuleTokenStream(adaptor,"token RIGHT_PAREN");
		RewriteRuleTokenStream stream_LEFT_PAREN=new RewriteRuleTokenStream(adaptor,"token LEFT_PAREN");
		RewriteRuleSubtreeStream stream_col_ref=new RewriteRuleSubtreeStream(adaptor,"rule col_ref");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:945:14: ( ( col_ref | ( LEFT_PAREN col_ref ( COMMA col_ref )* RIGHT_PAREN ) ) -> ( col_ref )+ )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:945:16: ( col_ref | ( LEFT_PAREN col_ref ( COMMA col_ref )* RIGHT_PAREN ) )
			{
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:945:16: ( col_ref | ( LEFT_PAREN col_ref ( COMMA col_ref )* RIGHT_PAREN ) )
			int alt184=2;
			int LA184_0 = input.LA(1);
			if ( (LA184_0==CUBE||LA184_0==DOLLARVAR||(LA184_0 >= ELSE && LA184_0 <= END)||LA184_0==GROUP||LA184_0==IDENTIFIER||LA184_0==IN||LA184_0==RANK||LA184_0==THEN||LA184_0==WHEN) ) {
				alt184=1;
			}
			else if ( (LA184_0==LEFT_PAREN) ) {
				alt184=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 184, 0, input);
				throw nvae;
			}

			switch (alt184) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:945:18: col_ref
					{
					pushFollow(FOLLOW_col_ref_in_col_ref_list6424);
					col_ref633=col_ref();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_col_ref.add(col_ref633.getTree());
					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:945:28: ( LEFT_PAREN col_ref ( COMMA col_ref )* RIGHT_PAREN )
					{
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:945:28: ( LEFT_PAREN col_ref ( COMMA col_ref )* RIGHT_PAREN )
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:945:30: LEFT_PAREN col_ref ( COMMA col_ref )* RIGHT_PAREN
					{
					LEFT_PAREN634=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_col_ref_list6430); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LEFT_PAREN.add(LEFT_PAREN634);

					pushFollow(FOLLOW_col_ref_in_col_ref_list6432);
					col_ref635=col_ref();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_col_ref.add(col_ref635.getTree());
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:945:49: ( COMMA col_ref )*
					loop183:
					while (true) {
						int alt183=2;
						int LA183_0 = input.LA(1);
						if ( (LA183_0==COMMA) ) {
							alt183=1;
						}

						switch (alt183) {
						case 1 :
							// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:945:51: COMMA col_ref
							{
							COMMA636=(Token)match(input,COMMA,FOLLOW_COMMA_in_col_ref_list6436); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COMMA.add(COMMA636);

							pushFollow(FOLLOW_col_ref_in_col_ref_list6438);
							col_ref637=col_ref();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_col_ref.add(col_ref637.getTree());
							}
							break;

						default :
							break loop183;
						}
					}

					RIGHT_PAREN638=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_col_ref_list6443); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RIGHT_PAREN.add(RIGHT_PAREN638);

					}

					}
					break;

			}

			// AST REWRITE
			// elements: col_ref
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 946:13: -> ( col_ref )+
			{
				if ( !(stream_col_ref.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_col_ref.hasNext() ) {
					adaptor.addChild(root_0, stream_col_ref.nextTree());
				}
				stream_col_ref.reset();

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "col_ref_list"


	public static class nested_filter_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "nested_filter"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:949:1: nested_filter : FILTER ^ nested_op_input BY ! cond ;
	public final QueryParser.nested_filter_return nested_filter() throws RecognitionException {
		QueryParser.nested_filter_return retval = new QueryParser.nested_filter_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token FILTER639=null;
		Token BY641=null;
		ParserRuleReturnScope nested_op_input640 =null;
		ParserRuleReturnScope cond642 =null;

		Object FILTER639_tree=null;
		Object BY641_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:949:15: ( FILTER ^ nested_op_input BY ! cond )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:949:17: FILTER ^ nested_op_input BY ! cond
			{
			root_0 = (Object)adaptor.nil();


			FILTER639=(Token)match(input,FILTER,FOLLOW_FILTER_in_nested_filter6473); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			FILTER639_tree = (Object)adaptor.create(FILTER639);
			root_0 = (Object)adaptor.becomeRoot(FILTER639_tree, root_0);
			}

			pushFollow(FOLLOW_nested_op_input_in_nested_filter6476);
			nested_op_input640=nested_op_input();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, nested_op_input640.getTree());

			BY641=(Token)match(input,BY,FOLLOW_BY_in_nested_filter6478); if (state.failed) return retval;
			pushFollow(FOLLOW_cond_in_nested_filter6481);
			cond642=cond();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, cond642.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "nested_filter"


	public static class nested_sort_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "nested_sort"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:952:1: nested_sort : ORDER ^ nested_op_input BY ! order_by_clause ( USING ! func_clause )? ;
	public final QueryParser.nested_sort_return nested_sort() throws RecognitionException {
		QueryParser.nested_sort_return retval = new QueryParser.nested_sort_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ORDER643=null;
		Token BY645=null;
		Token USING647=null;
		ParserRuleReturnScope nested_op_input644 =null;
		ParserRuleReturnScope order_by_clause646 =null;
		ParserRuleReturnScope func_clause648 =null;

		Object ORDER643_tree=null;
		Object BY645_tree=null;
		Object USING647_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:952:13: ( ORDER ^ nested_op_input BY ! order_by_clause ( USING ! func_clause )? )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:952:15: ORDER ^ nested_op_input BY ! order_by_clause ( USING ! func_clause )?
			{
			root_0 = (Object)adaptor.nil();


			ORDER643=(Token)match(input,ORDER,FOLLOW_ORDER_in_nested_sort6490); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ORDER643_tree = (Object)adaptor.create(ORDER643);
			root_0 = (Object)adaptor.becomeRoot(ORDER643_tree, root_0);
			}

			pushFollow(FOLLOW_nested_op_input_in_nested_sort6493);
			nested_op_input644=nested_op_input();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, nested_op_input644.getTree());

			BY645=(Token)match(input,BY,FOLLOW_BY_in_nested_sort6495); if (state.failed) return retval;
			pushFollow(FOLLOW_order_by_clause_in_nested_sort6499);
			order_by_clause646=order_by_clause();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, order_by_clause646.getTree());

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:952:59: ( USING ! func_clause )?
			int alt185=2;
			int LA185_0 = input.LA(1);
			if ( (LA185_0==USING) ) {
				alt185=1;
			}
			switch (alt185) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:952:61: USING ! func_clause
					{
					USING647=(Token)match(input,USING,FOLLOW_USING_in_nested_sort6503); if (state.failed) return retval;
					pushFollow(FOLLOW_func_clause_in_nested_sort6506);
					func_clause648=func_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, func_clause648.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "nested_sort"


	public static class nested_distinct_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "nested_distinct"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:955:1: nested_distinct : DISTINCT ^ nested_op_input ;
	public final QueryParser.nested_distinct_return nested_distinct() throws RecognitionException {
		QueryParser.nested_distinct_return retval = new QueryParser.nested_distinct_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token DISTINCT649=null;
		ParserRuleReturnScope nested_op_input650 =null;

		Object DISTINCT649_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:955:17: ( DISTINCT ^ nested_op_input )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:955:19: DISTINCT ^ nested_op_input
			{
			root_0 = (Object)adaptor.nil();


			DISTINCT649=(Token)match(input,DISTINCT,FOLLOW_DISTINCT_in_nested_distinct6518); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			DISTINCT649_tree = (Object)adaptor.create(DISTINCT649);
			root_0 = (Object)adaptor.becomeRoot(DISTINCT649_tree, root_0);
			}

			pushFollow(FOLLOW_nested_op_input_in_nested_distinct6521);
			nested_op_input650=nested_op_input();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, nested_op_input650.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "nested_distinct"


	public static class nested_limit_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "nested_limit"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:958:1: nested_limit : LIMIT ^ nested_op_input ( ( INTEGER SEMI_COLON )=> INTEGER | expr ) ;
	public final QueryParser.nested_limit_return nested_limit() throws RecognitionException {
		QueryParser.nested_limit_return retval = new QueryParser.nested_limit_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LIMIT651=null;
		Token INTEGER653=null;
		ParserRuleReturnScope nested_op_input652 =null;
		ParserRuleReturnScope expr654 =null;

		Object LIMIT651_tree=null;
		Object INTEGER653_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:958:14: ( LIMIT ^ nested_op_input ( ( INTEGER SEMI_COLON )=> INTEGER | expr ) )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:958:16: LIMIT ^ nested_op_input ( ( INTEGER SEMI_COLON )=> INTEGER | expr )
			{
			root_0 = (Object)adaptor.nil();


			LIMIT651=(Token)match(input,LIMIT,FOLLOW_LIMIT_in_nested_limit6530); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LIMIT651_tree = (Object)adaptor.create(LIMIT651);
			root_0 = (Object)adaptor.becomeRoot(LIMIT651_tree, root_0);
			}

			pushFollow(FOLLOW_nested_op_input_in_nested_limit6533);
			nested_op_input652=nested_op_input();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, nested_op_input652.getTree());

			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:958:39: ( ( INTEGER SEMI_COLON )=> INTEGER | expr )
			int alt186=2;
			int LA186_0 = input.LA(1);
			if ( (LA186_0==INTEGER) ) {
				int LA186_1 = input.LA(2);
				if ( (synpred4_QueryParser()) ) {
					alt186=1;
				}
				else if ( (true) ) {
					alt186=2;
				}

			}
			else if ( (LA186_0==ALL||LA186_0==AND||(LA186_0 >= AS && LA186_0 <= ASSERT)||(LA186_0 >= BIGDECIMAL && LA186_0 <= BIGINTEGERNUMBER)||(LA186_0 >= BY && LA186_0 <= COGROUP)||(LA186_0 >= CROSS && LA186_0 <= DATETIME)||LA186_0==DEFINE||LA186_0==DESC||LA186_0==DISTINCT||LA186_0==DOLLARVAR||LA186_0==DOUBLENUMBER||(LA186_0 >= ELSE && LA186_0 <= END)||LA186_0==FALSE||LA186_0==FILTER||(LA186_0 >= FLOATNUMBER && LA186_0 <= GROUP)||(LA186_0 >= IDENTIFIER && LA186_0 <= INPUT)||(LA186_0 >= INTO && LA186_0 <= LEFT_PAREN)||(LA186_0 >= LIMIT && LA186_0 <= LOAD)||LA186_0==LONGINTEGER||(LA186_0 >= MAPREDUCE && LA186_0 <= MINUS)||LA186_0==NULL||(LA186_0 >= OR && LA186_0 <= ORDER)||(LA186_0 >= OUTER && LA186_0 <= PARTITION)||(LA186_0 >= QUOTEDSTRING && LA186_0 <= RIGHT)||(LA186_0 >= ROLLUP && LA186_0 <= SAMPLE)||LA186_0==SHIP||LA186_0==SPLIT||(LA186_0 >= STDERROR && LA186_0 <= TRUE)||(LA186_0 >= UNION && LA186_0 <= USING)||LA186_0==WHEN||(LA186_0 >= BOOL && LA186_0 <= BOOL_COND)||LA186_0==REALIAS) ) {
				alt186=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 186, 0, input);
				throw nvae;
			}

			switch (alt186) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:958:41: ( INTEGER SEMI_COLON )=> INTEGER
					{
					INTEGER653=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_nested_limit6545); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INTEGER653_tree = (Object)adaptor.create(INTEGER653);
					adaptor.addChild(root_0, INTEGER653_tree);
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:958:75: expr
					{
					pushFollow(FOLLOW_expr_in_nested_limit6549);
					expr654=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr654.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "nested_limit"


	public static class nested_cross_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "nested_cross"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:961:1: nested_cross : CROSS ^ nested_op_input_list ;
	public final QueryParser.nested_cross_return nested_cross() throws RecognitionException {
		QueryParser.nested_cross_return retval = new QueryParser.nested_cross_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token CROSS655=null;
		ParserRuleReturnScope nested_op_input_list656 =null;

		Object CROSS655_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:961:14: ( CROSS ^ nested_op_input_list )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:961:16: CROSS ^ nested_op_input_list
			{
			root_0 = (Object)adaptor.nil();


			CROSS655=(Token)match(input,CROSS,FOLLOW_CROSS_in_nested_cross6560); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			CROSS655_tree = (Object)adaptor.create(CROSS655);
			root_0 = (Object)adaptor.becomeRoot(CROSS655_tree, root_0);
			}

			pushFollow(FOLLOW_nested_op_input_list_in_nested_cross6563);
			nested_op_input_list656=nested_op_input_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, nested_op_input_list656.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "nested_cross"


	public static class nested_foreach_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "nested_foreach"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:964:1: nested_foreach : FOREACH nested_op_input GENERATE flatten_generated_item ( COMMA flatten_generated_item )* -> ^( FOREACH nested_op_input ^( GENERATE ( flatten_generated_item )+ ) ) ;
	public final QueryParser.nested_foreach_return nested_foreach() throws RecognitionException {
		QueryParser.nested_foreach_return retval = new QueryParser.nested_foreach_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token FOREACH657=null;
		Token GENERATE659=null;
		Token COMMA661=null;
		ParserRuleReturnScope nested_op_input658 =null;
		ParserRuleReturnScope flatten_generated_item660 =null;
		ParserRuleReturnScope flatten_generated_item662 =null;

		Object FOREACH657_tree=null;
		Object GENERATE659_tree=null;
		Object COMMA661_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleTokenStream stream_GENERATE=new RewriteRuleTokenStream(adaptor,"token GENERATE");
		RewriteRuleTokenStream stream_FOREACH=new RewriteRuleTokenStream(adaptor,"token FOREACH");
		RewriteRuleSubtreeStream stream_nested_op_input=new RewriteRuleSubtreeStream(adaptor,"rule nested_op_input");
		RewriteRuleSubtreeStream stream_flatten_generated_item=new RewriteRuleSubtreeStream(adaptor,"rule flatten_generated_item");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:964:15: ( FOREACH nested_op_input GENERATE flatten_generated_item ( COMMA flatten_generated_item )* -> ^( FOREACH nested_op_input ^( GENERATE ( flatten_generated_item )+ ) ) )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:964:17: FOREACH nested_op_input GENERATE flatten_generated_item ( COMMA flatten_generated_item )*
			{
			FOREACH657=(Token)match(input,FOREACH,FOLLOW_FOREACH_in_nested_foreach6571); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_FOREACH.add(FOREACH657);

			pushFollow(FOLLOW_nested_op_input_in_nested_foreach6573);
			nested_op_input658=nested_op_input();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_nested_op_input.add(nested_op_input658.getTree());
			GENERATE659=(Token)match(input,GENERATE,FOLLOW_GENERATE_in_nested_foreach6575); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_GENERATE.add(GENERATE659);

			pushFollow(FOLLOW_flatten_generated_item_in_nested_foreach6577);
			flatten_generated_item660=flatten_generated_item();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_flatten_generated_item.add(flatten_generated_item660.getTree());
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:964:73: ( COMMA flatten_generated_item )*
			loop187:
			while (true) {
				int alt187=2;
				int LA187_0 = input.LA(1);
				if ( (LA187_0==COMMA) ) {
					alt187=1;
				}

				switch (alt187) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:964:75: COMMA flatten_generated_item
					{
					COMMA661=(Token)match(input,COMMA,FOLLOW_COMMA_in_nested_foreach6581); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COMMA.add(COMMA661);

					pushFollow(FOLLOW_flatten_generated_item_in_nested_foreach6583);
					flatten_generated_item662=flatten_generated_item();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_flatten_generated_item.add(flatten_generated_item662.getTree());
					}
					break;

				default :
					break loop187;
				}
			}

			// AST REWRITE
			// elements: nested_op_input, flatten_generated_item, GENERATE, FOREACH
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 965:5: -> ^( FOREACH nested_op_input ^( GENERATE ( flatten_generated_item )+ ) )
			{
				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:965:8: ^( FOREACH nested_op_input ^( GENERATE ( flatten_generated_item )+ ) )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot(stream_FOREACH.nextNode(), root_1);
				adaptor.addChild(root_1, stream_nested_op_input.nextTree());
				// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:965:35: ^( GENERATE ( flatten_generated_item )+ )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot(stream_GENERATE.nextNode(), root_2);
				if ( !(stream_flatten_generated_item.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_flatten_generated_item.hasNext() ) {
					adaptor.addChild(root_2, stream_flatten_generated_item.nextTree());
				}
				stream_flatten_generated_item.reset();

				adaptor.addChild(root_1, root_2);
				}

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "nested_foreach"


	public static class nested_op_input_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "nested_op_input"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:968:1: nested_op_input : ( col_ref | nested_proj );
	public final QueryParser.nested_op_input_return nested_op_input() throws RecognitionException {
		QueryParser.nested_op_input_return retval = new QueryParser.nested_op_input_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope col_ref663 =null;
		ParserRuleReturnScope nested_proj664 =null;


		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:968:17: ( col_ref | nested_proj )
			int alt188=2;
			switch ( input.LA(1) ) {
			case DOLLARVAR:
			case GROUP:
				{
				int LA188_1 = input.LA(2);
				if ( (LA188_1==ALL||LA188_1==AND||(LA188_1 >= AS && LA188_1 <= ASSERT)||(LA188_1 >= BIGDECIMAL && LA188_1 <= BIGINTEGERNUMBER)||(LA188_1 >= BY && LA188_1 <= COGROUP)||(LA188_1 >= COMMA && LA188_1 <= DATETIME)||LA188_1==DEFINE||LA188_1==DESC||LA188_1==DISTINCT||LA188_1==DOLLARVAR||LA188_1==DOUBLENUMBER||(LA188_1 >= ELSE && LA188_1 <= END)||LA188_1==FALSE||LA188_1==FILTER||(LA188_1 >= FLOATNUMBER && LA188_1 <= GROUP)||(LA188_1 >= IDENTIFIER && LA188_1 <= INPUT)||(LA188_1 >= INTEGER && LA188_1 <= LEFT_PAREN)||(LA188_1 >= LIMIT && LA188_1 <= LOAD)||LA188_1==LONGINTEGER||(LA188_1 >= MAPREDUCE && LA188_1 <= MINUS)||LA188_1==NULL||(LA188_1 >= OR && LA188_1 <= ORDER)||(LA188_1 >= OUTER && LA188_1 <= PARTITION)||(LA188_1 >= QUOTEDSTRING && LA188_1 <= RIGHT)||(LA188_1 >= ROLLUP && LA188_1 <= SHIP)||LA188_1==SPLIT||(LA188_1 >= STDERROR && LA188_1 <= TRUE)||(LA188_1 >= UNION && LA188_1 <= USING)||LA188_1==WHEN||(LA188_1 >= BOOL && LA188_1 <= BOOL_COND)||LA188_1==REALIAS) ) {
					alt188=1;
				}
				else if ( (LA188_1==PERIOD) ) {
					alt188=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 188, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case IDENTIFIER:
				{
				int LA188_2 = input.LA(2);
				if ( (LA188_2==ALL||LA188_2==AND||(LA188_2 >= AS && LA188_2 <= ASSERT)||(LA188_2 >= BIGDECIMAL && LA188_2 <= BIGINTEGERNUMBER)||(LA188_2 >= BY && LA188_2 <= COGROUP)||(LA188_2 >= COMMA && LA188_2 <= DATETIME)||LA188_2==DEFINE||LA188_2==DESC||LA188_2==DISTINCT||LA188_2==DOLLARVAR||LA188_2==DOUBLENUMBER||(LA188_2 >= ELSE && LA188_2 <= END)||LA188_2==FALSE||LA188_2==FILTER||(LA188_2 >= FLOATNUMBER && LA188_2 <= GROUP)||(LA188_2 >= IDENTIFIER && LA188_2 <= INPUT)||(LA188_2 >= INTEGER && LA188_2 <= LEFT_PAREN)||(LA188_2 >= LIMIT && LA188_2 <= LOAD)||LA188_2==LONGINTEGER||(LA188_2 >= MAPREDUCE && LA188_2 <= MINUS)||LA188_2==NULL||(LA188_2 >= OR && LA188_2 <= ORDER)||(LA188_2 >= OUTER && LA188_2 <= PARTITION)||(LA188_2 >= QUOTEDSTRING && LA188_2 <= RIGHT)||(LA188_2 >= ROLLUP && LA188_2 <= SHIP)||LA188_2==SPLIT||(LA188_2 >= STDERROR && LA188_2 <= TRUE)||(LA188_2 >= UNION && LA188_2 <= USING)||LA188_2==WHEN||(LA188_2 >= BOOL && LA188_2 <= BOOL_COND)||LA188_2==REALIAS) ) {
					alt188=1;
				}
				else if ( (LA188_2==PERIOD) ) {
					alt188=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 188, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case CUBE:
			case ELSE:
			case END:
			case IN:
			case RANK:
			case THEN:
			case WHEN:
				{
				int LA188_3 = input.LA(2);
				if ( (LA188_3==ALL||LA188_3==AND||(LA188_3 >= AS && LA188_3 <= ASSERT)||(LA188_3 >= BIGDECIMAL && LA188_3 <= BIGINTEGERNUMBER)||(LA188_3 >= BY && LA188_3 <= COGROUP)||(LA188_3 >= COMMA && LA188_3 <= DATETIME)||LA188_3==DEFINE||LA188_3==DESC||LA188_3==DISTINCT||LA188_3==DOLLARVAR||LA188_3==DOUBLENUMBER||(LA188_3 >= ELSE && LA188_3 <= END)||LA188_3==FALSE||LA188_3==FILTER||(LA188_3 >= FLOATNUMBER && LA188_3 <= GROUP)||(LA188_3 >= IDENTIFIER && LA188_3 <= INPUT)||(LA188_3 >= INTEGER && LA188_3 <= LEFT_PAREN)||(LA188_3 >= LIMIT && LA188_3 <= LOAD)||LA188_3==LONGINTEGER||(LA188_3 >= MAPREDUCE && LA188_3 <= MINUS)||LA188_3==NULL||(LA188_3 >= OR && LA188_3 <= ORDER)||(LA188_3 >= OUTER && LA188_3 <= PARTITION)||(LA188_3 >= QUOTEDSTRING && LA188_3 <= RIGHT)||(LA188_3 >= ROLLUP && LA188_3 <= SHIP)||LA188_3==SPLIT||(LA188_3 >= STDERROR && LA188_3 <= TRUE)||(LA188_3 >= UNION && LA188_3 <= USING)||LA188_3==WHEN||(LA188_3 >= BOOL && LA188_3 <= BOOL_COND)||LA188_3==REALIAS) ) {
					alt188=1;
				}
				else if ( (LA188_3==PERIOD) ) {
					alt188=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 188, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 188, 0, input);
				throw nvae;
			}
			switch (alt188) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:968:19: col_ref
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_col_ref_in_nested_op_input6618);
					col_ref663=col_ref();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, col_ref663.getTree());

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:968:29: nested_proj
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_nested_proj_in_nested_op_input6622);
					nested_proj664=nested_proj();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, nested_proj664.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "nested_op_input"


	public static class nested_op_input_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "nested_op_input_list"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:971:1: nested_op_input_list : nested_op_input ( COMMA nested_op_input )* -> ( nested_op_input )+ ;
	public final QueryParser.nested_op_input_list_return nested_op_input_list() throws RecognitionException {
		QueryParser.nested_op_input_list_return retval = new QueryParser.nested_op_input_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA666=null;
		ParserRuleReturnScope nested_op_input665 =null;
		ParserRuleReturnScope nested_op_input667 =null;

		Object COMMA666_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_nested_op_input=new RewriteRuleSubtreeStream(adaptor,"rule nested_op_input");

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:971:22: ( nested_op_input ( COMMA nested_op_input )* -> ( nested_op_input )+ )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:971:24: nested_op_input ( COMMA nested_op_input )*
			{
			pushFollow(FOLLOW_nested_op_input_in_nested_op_input_list6631);
			nested_op_input665=nested_op_input();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_nested_op_input.add(nested_op_input665.getTree());
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:971:40: ( COMMA nested_op_input )*
			loop189:
			while (true) {
				int alt189=2;
				int LA189_0 = input.LA(1);
				if ( (LA189_0==COMMA) ) {
					alt189=1;
				}

				switch (alt189) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:971:42: COMMA nested_op_input
					{
					COMMA666=(Token)match(input,COMMA,FOLLOW_COMMA_in_nested_op_input_list6635); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COMMA.add(COMMA666);

					pushFollow(FOLLOW_nested_op_input_in_nested_op_input_list6637);
					nested_op_input667=nested_op_input();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_nested_op_input.add(nested_op_input667.getTree());
					}
					break;

				default :
					break loop189;
				}
			}

			// AST REWRITE
			// elements: nested_op_input
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 972:9: -> ( nested_op_input )+
			{
				if ( !(stream_nested_op_input.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_nested_op_input.hasNext() ) {
					adaptor.addChild(root_0, stream_nested_op_input.nextTree());
				}
				stream_nested_op_input.reset();

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "nested_op_input_list"


	public static class eid_without_columns_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "eid_without_columns"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:978:1: eid_without_columns : ( rel_str_op | IMPORT | REGISTER | RETURNS | DEFINE | LOAD | FILTER | FOREACH | ROLLUP | ORDER | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | AND | OR | GENERATE | ASC | DESC | BOOL | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY | IS | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | REALIAS | BOOL_COND | ASSERT );
	public final QueryParser.eid_without_columns_return eid_without_columns() throws RecognitionException {
		QueryParser.eid_without_columns_return retval = new QueryParser.eid_without_columns_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token IMPORT669=null;
		Token REGISTER670=null;
		Token RETURNS671=null;
		Token DEFINE672=null;
		Token LOAD673=null;
		Token FILTER674=null;
		Token FOREACH675=null;
		Token ROLLUP676=null;
		Token ORDER677=null;
		Token DISTINCT678=null;
		Token COGROUP679=null;
		Token JOIN680=null;
		Token CROSS681=null;
		Token UNION682=null;
		Token SPLIT683=null;
		Token INTO684=null;
		Token IF685=null;
		Token ALL686=null;
		Token AS687=null;
		Token BY688=null;
		Token USING689=null;
		Token INNER690=null;
		Token OUTER691=null;
		Token PARALLEL692=null;
		Token PARTITION693=null;
		Token AND694=null;
		Token OR695=null;
		Token GENERATE696=null;
		Token ASC697=null;
		Token DESC698=null;
		Token BOOL699=null;
		Token BIGINTEGER700=null;
		Token BIGDECIMAL701=null;
		Token DATETIME702=null;
		Token CHARARRAY703=null;
		Token BYTEARRAY704=null;
		Token IS705=null;
		Token STREAM706=null;
		Token THROUGH707=null;
		Token STORE708=null;
		Token MAPREDUCE709=null;
		Token SHIP710=null;
		Token CACHE711=null;
		Token INPUT712=null;
		Token OUTPUT713=null;
		Token STDERROR714=null;
		Token STDIN715=null;
		Token STDOUT716=null;
		Token LIMIT717=null;
		Token SAMPLE718=null;
		Token LEFT719=null;
		Token RIGHT720=null;
		Token FULL721=null;
		Token REALIAS722=null;
		Token BOOL_COND723=null;
		Token ASSERT724=null;
		ParserRuleReturnScope rel_str_op668 =null;

		Object IMPORT669_tree=null;
		Object REGISTER670_tree=null;
		Object RETURNS671_tree=null;
		Object DEFINE672_tree=null;
		Object LOAD673_tree=null;
		Object FILTER674_tree=null;
		Object FOREACH675_tree=null;
		Object ROLLUP676_tree=null;
		Object ORDER677_tree=null;
		Object DISTINCT678_tree=null;
		Object COGROUP679_tree=null;
		Object JOIN680_tree=null;
		Object CROSS681_tree=null;
		Object UNION682_tree=null;
		Object SPLIT683_tree=null;
		Object INTO684_tree=null;
		Object IF685_tree=null;
		Object ALL686_tree=null;
		Object AS687_tree=null;
		Object BY688_tree=null;
		Object USING689_tree=null;
		Object INNER690_tree=null;
		Object OUTER691_tree=null;
		Object PARALLEL692_tree=null;
		Object PARTITION693_tree=null;
		Object AND694_tree=null;
		Object OR695_tree=null;
		Object GENERATE696_tree=null;
		Object ASC697_tree=null;
		Object DESC698_tree=null;
		Object BOOL699_tree=null;
		Object BIGINTEGER700_tree=null;
		Object BIGDECIMAL701_tree=null;
		Object DATETIME702_tree=null;
		Object CHARARRAY703_tree=null;
		Object BYTEARRAY704_tree=null;
		Object IS705_tree=null;
		Object STREAM706_tree=null;
		Object THROUGH707_tree=null;
		Object STORE708_tree=null;
		Object MAPREDUCE709_tree=null;
		Object SHIP710_tree=null;
		Object CACHE711_tree=null;
		Object INPUT712_tree=null;
		Object OUTPUT713_tree=null;
		Object STDERROR714_tree=null;
		Object STDIN715_tree=null;
		Object STDOUT716_tree=null;
		Object LIMIT717_tree=null;
		Object SAMPLE718_tree=null;
		Object LEFT719_tree=null;
		Object RIGHT720_tree=null;
		Object FULL721_tree=null;
		Object REALIAS722_tree=null;
		Object BOOL_COND723_tree=null;
		Object ASSERT724_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:978:21: ( rel_str_op | IMPORT | REGISTER | RETURNS | DEFINE | LOAD | FILTER | FOREACH | ROLLUP | ORDER | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | AND | OR | GENERATE | ASC | DESC | BOOL | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY | IS | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | REALIAS | BOOL_COND | ASSERT )
			int alt190=57;
			switch ( input.LA(1) ) {
			case STR_OP_EQ:
			case STR_OP_GT:
			case STR_OP_GTE:
			case STR_OP_LT:
			case STR_OP_LTE:
			case STR_OP_MATCHES:
			case STR_OP_NE:
				{
				alt190=1;
				}
				break;
			case IMPORT:
				{
				alt190=2;
				}
				break;
			case REGISTER:
				{
				alt190=3;
				}
				break;
			case RETURNS:
				{
				alt190=4;
				}
				break;
			case DEFINE:
				{
				alt190=5;
				}
				break;
			case LOAD:
				{
				alt190=6;
				}
				break;
			case FILTER:
				{
				alt190=7;
				}
				break;
			case FOREACH:
				{
				alt190=8;
				}
				break;
			case ROLLUP:
				{
				alt190=9;
				}
				break;
			case ORDER:
				{
				alt190=10;
				}
				break;
			case DISTINCT:
				{
				alt190=11;
				}
				break;
			case COGROUP:
				{
				alt190=12;
				}
				break;
			case JOIN:
				{
				alt190=13;
				}
				break;
			case CROSS:
				{
				alt190=14;
				}
				break;
			case UNION:
				{
				alt190=15;
				}
				break;
			case SPLIT:
				{
				alt190=16;
				}
				break;
			case INTO:
				{
				alt190=17;
				}
				break;
			case IF:
				{
				alt190=18;
				}
				break;
			case ALL:
				{
				alt190=19;
				}
				break;
			case AS:
				{
				alt190=20;
				}
				break;
			case BY:
				{
				alt190=21;
				}
				break;
			case USING:
				{
				alt190=22;
				}
				break;
			case INNER:
				{
				alt190=23;
				}
				break;
			case OUTER:
				{
				alt190=24;
				}
				break;
			case PARALLEL:
				{
				alt190=25;
				}
				break;
			case PARTITION:
				{
				alt190=26;
				}
				break;
			case AND:
				{
				alt190=27;
				}
				break;
			case OR:
				{
				alt190=28;
				}
				break;
			case GENERATE:
				{
				alt190=29;
				}
				break;
			case ASC:
				{
				alt190=30;
				}
				break;
			case DESC:
				{
				alt190=31;
				}
				break;
			case BOOL:
				{
				alt190=32;
				}
				break;
			case BIGINTEGER:
				{
				alt190=33;
				}
				break;
			case BIGDECIMAL:
				{
				alt190=34;
				}
				break;
			case DATETIME:
				{
				alt190=35;
				}
				break;
			case CHARARRAY:
				{
				alt190=36;
				}
				break;
			case BYTEARRAY:
				{
				alt190=37;
				}
				break;
			case IS:
				{
				alt190=38;
				}
				break;
			case STREAM:
				{
				alt190=39;
				}
				break;
			case THROUGH:
				{
				alt190=40;
				}
				break;
			case STORE:
				{
				alt190=41;
				}
				break;
			case MAPREDUCE:
				{
				alt190=42;
				}
				break;
			case SHIP:
				{
				alt190=43;
				}
				break;
			case CACHE:
				{
				alt190=44;
				}
				break;
			case INPUT:
				{
				alt190=45;
				}
				break;
			case OUTPUT:
				{
				alt190=46;
				}
				break;
			case STDERROR:
				{
				alt190=47;
				}
				break;
			case STDIN:
				{
				alt190=48;
				}
				break;
			case STDOUT:
				{
				alt190=49;
				}
				break;
			case LIMIT:
				{
				alt190=50;
				}
				break;
			case SAMPLE:
				{
				alt190=51;
				}
				break;
			case LEFT:
				{
				alt190=52;
				}
				break;
			case RIGHT:
				{
				alt190=53;
				}
				break;
			case FULL:
				{
				alt190=54;
				}
				break;
			case REALIAS:
				{
				alt190=55;
				}
				break;
			case BOOL_COND:
				{
				alt190=56;
				}
				break;
			case ASSERT:
				{
				alt190=57;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 190, 0, input);
				throw nvae;
			}
			switch (alt190) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:978:23: rel_str_op
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_rel_str_op_in_eid_without_columns6665);
					rel_str_op668=rel_str_op();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rel_str_op668.getTree());

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:979:7: IMPORT
					{
					root_0 = (Object)adaptor.nil();


					IMPORT669=(Token)match(input,IMPORT,FOLLOW_IMPORT_in_eid_without_columns6673); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IMPORT669_tree = (Object)adaptor.create(IMPORT669);
					adaptor.addChild(root_0, IMPORT669_tree);
					}

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:980:7: REGISTER
					{
					root_0 = (Object)adaptor.nil();


					REGISTER670=(Token)match(input,REGISTER,FOLLOW_REGISTER_in_eid_without_columns6681); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					REGISTER670_tree = (Object)adaptor.create(REGISTER670);
					adaptor.addChild(root_0, REGISTER670_tree);
					}

					}
					break;
				case 4 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:981:7: RETURNS
					{
					root_0 = (Object)adaptor.nil();


					RETURNS671=(Token)match(input,RETURNS,FOLLOW_RETURNS_in_eid_without_columns6689); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RETURNS671_tree = (Object)adaptor.create(RETURNS671);
					adaptor.addChild(root_0, RETURNS671_tree);
					}

					}
					break;
				case 5 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:982:7: DEFINE
					{
					root_0 = (Object)adaptor.nil();


					DEFINE672=(Token)match(input,DEFINE,FOLLOW_DEFINE_in_eid_without_columns6697); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DEFINE672_tree = (Object)adaptor.create(DEFINE672);
					adaptor.addChild(root_0, DEFINE672_tree);
					}

					}
					break;
				case 6 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:983:7: LOAD
					{
					root_0 = (Object)adaptor.nil();


					LOAD673=(Token)match(input,LOAD,FOLLOW_LOAD_in_eid_without_columns6705); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LOAD673_tree = (Object)adaptor.create(LOAD673);
					adaptor.addChild(root_0, LOAD673_tree);
					}

					}
					break;
				case 7 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:984:7: FILTER
					{
					root_0 = (Object)adaptor.nil();


					FILTER674=(Token)match(input,FILTER,FOLLOW_FILTER_in_eid_without_columns6713); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FILTER674_tree = (Object)adaptor.create(FILTER674);
					adaptor.addChild(root_0, FILTER674_tree);
					}

					}
					break;
				case 8 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:985:7: FOREACH
					{
					root_0 = (Object)adaptor.nil();


					FOREACH675=(Token)match(input,FOREACH,FOLLOW_FOREACH_in_eid_without_columns6721); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FOREACH675_tree = (Object)adaptor.create(FOREACH675);
					adaptor.addChild(root_0, FOREACH675_tree);
					}

					}
					break;
				case 9 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:986:7: ROLLUP
					{
					root_0 = (Object)adaptor.nil();


					ROLLUP676=(Token)match(input,ROLLUP,FOLLOW_ROLLUP_in_eid_without_columns6729); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ROLLUP676_tree = (Object)adaptor.create(ROLLUP676);
					adaptor.addChild(root_0, ROLLUP676_tree);
					}

					}
					break;
				case 10 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:987:7: ORDER
					{
					root_0 = (Object)adaptor.nil();


					ORDER677=(Token)match(input,ORDER,FOLLOW_ORDER_in_eid_without_columns6737); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ORDER677_tree = (Object)adaptor.create(ORDER677);
					adaptor.addChild(root_0, ORDER677_tree);
					}

					}
					break;
				case 11 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:988:7: DISTINCT
					{
					root_0 = (Object)adaptor.nil();


					DISTINCT678=(Token)match(input,DISTINCT,FOLLOW_DISTINCT_in_eid_without_columns6745); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DISTINCT678_tree = (Object)adaptor.create(DISTINCT678);
					adaptor.addChild(root_0, DISTINCT678_tree);
					}

					}
					break;
				case 12 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:989:7: COGROUP
					{
					root_0 = (Object)adaptor.nil();


					COGROUP679=(Token)match(input,COGROUP,FOLLOW_COGROUP_in_eid_without_columns6753); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					COGROUP679_tree = (Object)adaptor.create(COGROUP679);
					adaptor.addChild(root_0, COGROUP679_tree);
					}

					}
					break;
				case 13 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:990:7: JOIN
					{
					root_0 = (Object)adaptor.nil();


					JOIN680=(Token)match(input,JOIN,FOLLOW_JOIN_in_eid_without_columns6761); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					JOIN680_tree = (Object)adaptor.create(JOIN680);
					adaptor.addChild(root_0, JOIN680_tree);
					}

					}
					break;
				case 14 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:991:7: CROSS
					{
					root_0 = (Object)adaptor.nil();


					CROSS681=(Token)match(input,CROSS,FOLLOW_CROSS_in_eid_without_columns6769); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					CROSS681_tree = (Object)adaptor.create(CROSS681);
					adaptor.addChild(root_0, CROSS681_tree);
					}

					}
					break;
				case 15 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:992:7: UNION
					{
					root_0 = (Object)adaptor.nil();


					UNION682=(Token)match(input,UNION,FOLLOW_UNION_in_eid_without_columns6777); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					UNION682_tree = (Object)adaptor.create(UNION682);
					adaptor.addChild(root_0, UNION682_tree);
					}

					}
					break;
				case 16 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:993:7: SPLIT
					{
					root_0 = (Object)adaptor.nil();


					SPLIT683=(Token)match(input,SPLIT,FOLLOW_SPLIT_in_eid_without_columns6785); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					SPLIT683_tree = (Object)adaptor.create(SPLIT683);
					adaptor.addChild(root_0, SPLIT683_tree);
					}

					}
					break;
				case 17 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:994:7: INTO
					{
					root_0 = (Object)adaptor.nil();


					INTO684=(Token)match(input,INTO,FOLLOW_INTO_in_eid_without_columns6793); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INTO684_tree = (Object)adaptor.create(INTO684);
					adaptor.addChild(root_0, INTO684_tree);
					}

					}
					break;
				case 18 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:995:7: IF
					{
					root_0 = (Object)adaptor.nil();


					IF685=(Token)match(input,IF,FOLLOW_IF_in_eid_without_columns6801); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IF685_tree = (Object)adaptor.create(IF685);
					adaptor.addChild(root_0, IF685_tree);
					}

					}
					break;
				case 19 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:996:7: ALL
					{
					root_0 = (Object)adaptor.nil();


					ALL686=(Token)match(input,ALL,FOLLOW_ALL_in_eid_without_columns6809); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ALL686_tree = (Object)adaptor.create(ALL686);
					adaptor.addChild(root_0, ALL686_tree);
					}

					}
					break;
				case 20 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:997:7: AS
					{
					root_0 = (Object)adaptor.nil();


					AS687=(Token)match(input,AS,FOLLOW_AS_in_eid_without_columns6817); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					AS687_tree = (Object)adaptor.create(AS687);
					adaptor.addChild(root_0, AS687_tree);
					}

					}
					break;
				case 21 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:998:7: BY
					{
					root_0 = (Object)adaptor.nil();


					BY688=(Token)match(input,BY,FOLLOW_BY_in_eid_without_columns6825); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					BY688_tree = (Object)adaptor.create(BY688);
					adaptor.addChild(root_0, BY688_tree);
					}

					}
					break;
				case 22 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:999:7: USING
					{
					root_0 = (Object)adaptor.nil();


					USING689=(Token)match(input,USING,FOLLOW_USING_in_eid_without_columns6833); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					USING689_tree = (Object)adaptor.create(USING689);
					adaptor.addChild(root_0, USING689_tree);
					}

					}
					break;
				case 23 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1000:7: INNER
					{
					root_0 = (Object)adaptor.nil();


					INNER690=(Token)match(input,INNER,FOLLOW_INNER_in_eid_without_columns6841); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INNER690_tree = (Object)adaptor.create(INNER690);
					adaptor.addChild(root_0, INNER690_tree);
					}

					}
					break;
				case 24 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1001:7: OUTER
					{
					root_0 = (Object)adaptor.nil();


					OUTER691=(Token)match(input,OUTER,FOLLOW_OUTER_in_eid_without_columns6849); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					OUTER691_tree = (Object)adaptor.create(OUTER691);
					adaptor.addChild(root_0, OUTER691_tree);
					}

					}
					break;
				case 25 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1002:7: PARALLEL
					{
					root_0 = (Object)adaptor.nil();


					PARALLEL692=(Token)match(input,PARALLEL,FOLLOW_PARALLEL_in_eid_without_columns6857); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					PARALLEL692_tree = (Object)adaptor.create(PARALLEL692);
					adaptor.addChild(root_0, PARALLEL692_tree);
					}

					}
					break;
				case 26 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1003:7: PARTITION
					{
					root_0 = (Object)adaptor.nil();


					PARTITION693=(Token)match(input,PARTITION,FOLLOW_PARTITION_in_eid_without_columns6865); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					PARTITION693_tree = (Object)adaptor.create(PARTITION693);
					adaptor.addChild(root_0, PARTITION693_tree);
					}

					}
					break;
				case 27 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1004:7: AND
					{
					root_0 = (Object)adaptor.nil();


					AND694=(Token)match(input,AND,FOLLOW_AND_in_eid_without_columns6873); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					AND694_tree = (Object)adaptor.create(AND694);
					adaptor.addChild(root_0, AND694_tree);
					}

					}
					break;
				case 28 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1005:7: OR
					{
					root_0 = (Object)adaptor.nil();


					OR695=(Token)match(input,OR,FOLLOW_OR_in_eid_without_columns6881); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					OR695_tree = (Object)adaptor.create(OR695);
					adaptor.addChild(root_0, OR695_tree);
					}

					}
					break;
				case 29 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1006:7: GENERATE
					{
					root_0 = (Object)adaptor.nil();


					GENERATE696=(Token)match(input,GENERATE,FOLLOW_GENERATE_in_eid_without_columns6889); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					GENERATE696_tree = (Object)adaptor.create(GENERATE696);
					adaptor.addChild(root_0, GENERATE696_tree);
					}

					}
					break;
				case 30 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1007:7: ASC
					{
					root_0 = (Object)adaptor.nil();


					ASC697=(Token)match(input,ASC,FOLLOW_ASC_in_eid_without_columns6897); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ASC697_tree = (Object)adaptor.create(ASC697);
					adaptor.addChild(root_0, ASC697_tree);
					}

					}
					break;
				case 31 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1008:7: DESC
					{
					root_0 = (Object)adaptor.nil();


					DESC698=(Token)match(input,DESC,FOLLOW_DESC_in_eid_without_columns6905); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DESC698_tree = (Object)adaptor.create(DESC698);
					adaptor.addChild(root_0, DESC698_tree);
					}

					}
					break;
				case 32 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1009:7: BOOL
					{
					root_0 = (Object)adaptor.nil();


					BOOL699=(Token)match(input,BOOL,FOLLOW_BOOL_in_eid_without_columns6913); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					BOOL699_tree = (Object)adaptor.create(BOOL699);
					adaptor.addChild(root_0, BOOL699_tree);
					}

					}
					break;
				case 33 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1010:7: BIGINTEGER
					{
					root_0 = (Object)adaptor.nil();


					BIGINTEGER700=(Token)match(input,BIGINTEGER,FOLLOW_BIGINTEGER_in_eid_without_columns6921); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					BIGINTEGER700_tree = (Object)adaptor.create(BIGINTEGER700);
					adaptor.addChild(root_0, BIGINTEGER700_tree);
					}

					}
					break;
				case 34 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1011:7: BIGDECIMAL
					{
					root_0 = (Object)adaptor.nil();


					BIGDECIMAL701=(Token)match(input,BIGDECIMAL,FOLLOW_BIGDECIMAL_in_eid_without_columns6929); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					BIGDECIMAL701_tree = (Object)adaptor.create(BIGDECIMAL701);
					adaptor.addChild(root_0, BIGDECIMAL701_tree);
					}

					}
					break;
				case 35 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1012:7: DATETIME
					{
					root_0 = (Object)adaptor.nil();


					DATETIME702=(Token)match(input,DATETIME,FOLLOW_DATETIME_in_eid_without_columns6937); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DATETIME702_tree = (Object)adaptor.create(DATETIME702);
					adaptor.addChild(root_0, DATETIME702_tree);
					}

					}
					break;
				case 36 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1013:7: CHARARRAY
					{
					root_0 = (Object)adaptor.nil();


					CHARARRAY703=(Token)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_eid_without_columns6945); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					CHARARRAY703_tree = (Object)adaptor.create(CHARARRAY703);
					adaptor.addChild(root_0, CHARARRAY703_tree);
					}

					}
					break;
				case 37 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1014:7: BYTEARRAY
					{
					root_0 = (Object)adaptor.nil();


					BYTEARRAY704=(Token)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_eid_without_columns6953); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					BYTEARRAY704_tree = (Object)adaptor.create(BYTEARRAY704);
					adaptor.addChild(root_0, BYTEARRAY704_tree);
					}

					}
					break;
				case 38 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1015:7: IS
					{
					root_0 = (Object)adaptor.nil();


					IS705=(Token)match(input,IS,FOLLOW_IS_in_eid_without_columns6961); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IS705_tree = (Object)adaptor.create(IS705);
					adaptor.addChild(root_0, IS705_tree);
					}

					}
					break;
				case 39 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1016:7: STREAM
					{
					root_0 = (Object)adaptor.nil();


					STREAM706=(Token)match(input,STREAM,FOLLOW_STREAM_in_eid_without_columns6969); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STREAM706_tree = (Object)adaptor.create(STREAM706);
					adaptor.addChild(root_0, STREAM706_tree);
					}

					}
					break;
				case 40 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1017:7: THROUGH
					{
					root_0 = (Object)adaptor.nil();


					THROUGH707=(Token)match(input,THROUGH,FOLLOW_THROUGH_in_eid_without_columns6977); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					THROUGH707_tree = (Object)adaptor.create(THROUGH707);
					adaptor.addChild(root_0, THROUGH707_tree);
					}

					}
					break;
				case 41 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1018:7: STORE
					{
					root_0 = (Object)adaptor.nil();


					STORE708=(Token)match(input,STORE,FOLLOW_STORE_in_eid_without_columns6985); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STORE708_tree = (Object)adaptor.create(STORE708);
					adaptor.addChild(root_0, STORE708_tree);
					}

					}
					break;
				case 42 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1019:7: MAPREDUCE
					{
					root_0 = (Object)adaptor.nil();


					MAPREDUCE709=(Token)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_eid_without_columns6993); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					MAPREDUCE709_tree = (Object)adaptor.create(MAPREDUCE709);
					adaptor.addChild(root_0, MAPREDUCE709_tree);
					}

					}
					break;
				case 43 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1020:7: SHIP
					{
					root_0 = (Object)adaptor.nil();


					SHIP710=(Token)match(input,SHIP,FOLLOW_SHIP_in_eid_without_columns7001); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					SHIP710_tree = (Object)adaptor.create(SHIP710);
					adaptor.addChild(root_0, SHIP710_tree);
					}

					}
					break;
				case 44 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1021:7: CACHE
					{
					root_0 = (Object)adaptor.nil();


					CACHE711=(Token)match(input,CACHE,FOLLOW_CACHE_in_eid_without_columns7009); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					CACHE711_tree = (Object)adaptor.create(CACHE711);
					adaptor.addChild(root_0, CACHE711_tree);
					}

					}
					break;
				case 45 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1022:7: INPUT
					{
					root_0 = (Object)adaptor.nil();


					INPUT712=(Token)match(input,INPUT,FOLLOW_INPUT_in_eid_without_columns7017); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INPUT712_tree = (Object)adaptor.create(INPUT712);
					adaptor.addChild(root_0, INPUT712_tree);
					}

					}
					break;
				case 46 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1023:7: OUTPUT
					{
					root_0 = (Object)adaptor.nil();


					OUTPUT713=(Token)match(input,OUTPUT,FOLLOW_OUTPUT_in_eid_without_columns7025); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					OUTPUT713_tree = (Object)adaptor.create(OUTPUT713);
					adaptor.addChild(root_0, OUTPUT713_tree);
					}

					}
					break;
				case 47 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1024:7: STDERROR
					{
					root_0 = (Object)adaptor.nil();


					STDERROR714=(Token)match(input,STDERROR,FOLLOW_STDERROR_in_eid_without_columns7033); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STDERROR714_tree = (Object)adaptor.create(STDERROR714);
					adaptor.addChild(root_0, STDERROR714_tree);
					}

					}
					break;
				case 48 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1025:7: STDIN
					{
					root_0 = (Object)adaptor.nil();


					STDIN715=(Token)match(input,STDIN,FOLLOW_STDIN_in_eid_without_columns7041); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STDIN715_tree = (Object)adaptor.create(STDIN715);
					adaptor.addChild(root_0, STDIN715_tree);
					}

					}
					break;
				case 49 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1026:7: STDOUT
					{
					root_0 = (Object)adaptor.nil();


					STDOUT716=(Token)match(input,STDOUT,FOLLOW_STDOUT_in_eid_without_columns7049); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STDOUT716_tree = (Object)adaptor.create(STDOUT716);
					adaptor.addChild(root_0, STDOUT716_tree);
					}

					}
					break;
				case 50 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1027:7: LIMIT
					{
					root_0 = (Object)adaptor.nil();


					LIMIT717=(Token)match(input,LIMIT,FOLLOW_LIMIT_in_eid_without_columns7057); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LIMIT717_tree = (Object)adaptor.create(LIMIT717);
					adaptor.addChild(root_0, LIMIT717_tree);
					}

					}
					break;
				case 51 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1028:7: SAMPLE
					{
					root_0 = (Object)adaptor.nil();


					SAMPLE718=(Token)match(input,SAMPLE,FOLLOW_SAMPLE_in_eid_without_columns7065); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					SAMPLE718_tree = (Object)adaptor.create(SAMPLE718);
					adaptor.addChild(root_0, SAMPLE718_tree);
					}

					}
					break;
				case 52 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1029:7: LEFT
					{
					root_0 = (Object)adaptor.nil();


					LEFT719=(Token)match(input,LEFT,FOLLOW_LEFT_in_eid_without_columns7073); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LEFT719_tree = (Object)adaptor.create(LEFT719);
					adaptor.addChild(root_0, LEFT719_tree);
					}

					}
					break;
				case 53 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1030:7: RIGHT
					{
					root_0 = (Object)adaptor.nil();


					RIGHT720=(Token)match(input,RIGHT,FOLLOW_RIGHT_in_eid_without_columns7081); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RIGHT720_tree = (Object)adaptor.create(RIGHT720);
					adaptor.addChild(root_0, RIGHT720_tree);
					}

					}
					break;
				case 54 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1031:7: FULL
					{
					root_0 = (Object)adaptor.nil();


					FULL721=(Token)match(input,FULL,FOLLOW_FULL_in_eid_without_columns7089); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FULL721_tree = (Object)adaptor.create(FULL721);
					adaptor.addChild(root_0, FULL721_tree);
					}

					}
					break;
				case 55 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1032:7: REALIAS
					{
					root_0 = (Object)adaptor.nil();


					REALIAS722=(Token)match(input,REALIAS,FOLLOW_REALIAS_in_eid_without_columns7097); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					REALIAS722_tree = (Object)adaptor.create(REALIAS722);
					adaptor.addChild(root_0, REALIAS722_tree);
					}

					}
					break;
				case 56 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1033:7: BOOL_COND
					{
					root_0 = (Object)adaptor.nil();


					BOOL_COND723=(Token)match(input,BOOL_COND,FOLLOW_BOOL_COND_in_eid_without_columns7105); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					BOOL_COND723_tree = (Object)adaptor.create(BOOL_COND723);
					adaptor.addChild(root_0, BOOL_COND723_tree);
					}

					}
					break;
				case 57 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1034:7: ASSERT
					{
					root_0 = (Object)adaptor.nil();


					ASSERT724=(Token)match(input,ASSERT,FOLLOW_ASSERT_in_eid_without_columns7113); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ASSERT724_tree = (Object)adaptor.create(ASSERT724);
					adaptor.addChild(root_0, ASSERT724_tree);
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "eid_without_columns"


	public static class eid_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "eid"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1037:1: eid : ( eid_without_columns | IDENTIFIER | GROUP | CUBE | TRUE | FALSE | INT | LONG | FLOAT | DOUBLE | NULL | NOT | FLATTEN | BAG | TUPLE | MAP );
	public final QueryParser.eid_return eid() throws RecognitionException {
		QueryParser.eid_return retval = new QueryParser.eid_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token IDENTIFIER726=null;
		Token GROUP727=null;
		Token CUBE728=null;
		Token TRUE729=null;
		Token FALSE730=null;
		Token INT731=null;
		Token LONG732=null;
		Token FLOAT733=null;
		Token DOUBLE734=null;
		Token NULL735=null;
		Token NOT736=null;
		Token FLATTEN737=null;
		Token BAG738=null;
		Token TUPLE739=null;
		Token MAP740=null;
		ParserRuleReturnScope eid_without_columns725 =null;

		Object IDENTIFIER726_tree=null;
		Object GROUP727_tree=null;
		Object CUBE728_tree=null;
		Object TRUE729_tree=null;
		Object FALSE730_tree=null;
		Object INT731_tree=null;
		Object LONG732_tree=null;
		Object FLOAT733_tree=null;
		Object DOUBLE734_tree=null;
		Object NULL735_tree=null;
		Object NOT736_tree=null;
		Object FLATTEN737_tree=null;
		Object BAG738_tree=null;
		Object TUPLE739_tree=null;
		Object MAP740_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1037:5: ( eid_without_columns | IDENTIFIER | GROUP | CUBE | TRUE | FALSE | INT | LONG | FLOAT | DOUBLE | NULL | NOT | FLATTEN | BAG | TUPLE | MAP )
			int alt191=16;
			switch ( input.LA(1) ) {
			case ALL:
			case AND:
			case AS:
			case ASC:
			case ASSERT:
			case BIGDECIMAL:
			case BIGINTEGER:
			case BY:
			case BYTEARRAY:
			case CACHE:
			case CHARARRAY:
			case COGROUP:
			case CROSS:
			case DATETIME:
			case DEFINE:
			case DESC:
			case DISTINCT:
			case FILTER:
			case FOREACH:
			case FULL:
			case GENERATE:
			case IF:
			case IMPORT:
			case INNER:
			case INPUT:
			case INTO:
			case IS:
			case JOIN:
			case LEFT:
			case LIMIT:
			case LOAD:
			case MAPREDUCE:
			case OR:
			case ORDER:
			case OUTER:
			case OUTPUT:
			case PARALLEL:
			case PARTITION:
			case REGISTER:
			case RETURNS:
			case RIGHT:
			case ROLLUP:
			case SAMPLE:
			case SHIP:
			case SPLIT:
			case STDERROR:
			case STDIN:
			case STDOUT:
			case STORE:
			case STREAM:
			case STR_OP_EQ:
			case STR_OP_GT:
			case STR_OP_GTE:
			case STR_OP_LT:
			case STR_OP_LTE:
			case STR_OP_MATCHES:
			case STR_OP_NE:
			case THROUGH:
			case UNION:
			case USING:
			case BOOL:
			case BOOL_COND:
			case REALIAS:
				{
				alt191=1;
				}
				break;
			case IDENTIFIER:
				{
				alt191=2;
				}
				break;
			case GROUP:
				{
				alt191=3;
				}
				break;
			case CUBE:
				{
				alt191=4;
				}
				break;
			case TRUE:
				{
				alt191=5;
				}
				break;
			case FALSE:
				{
				alt191=6;
				}
				break;
			case INT:
				{
				alt191=7;
				}
				break;
			case LONG:
				{
				alt191=8;
				}
				break;
			case FLOAT:
				{
				alt191=9;
				}
				break;
			case DOUBLE:
				{
				alt191=10;
				}
				break;
			case NULL:
				{
				alt191=11;
				}
				break;
			case NOT:
				{
				alt191=12;
				}
				break;
			case FLATTEN:
				{
				alt191=13;
				}
				break;
			case BAG:
				{
				alt191=14;
				}
				break;
			case TUPLE:
				{
				alt191=15;
				}
				break;
			case MAP:
				{
				alt191=16;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 191, 0, input);
				throw nvae;
			}
			switch (alt191) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1037:7: eid_without_columns
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_eid_without_columns_in_eid7122);
					eid_without_columns725=eid_without_columns();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, eid_without_columns725.getTree());

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1038:7: IDENTIFIER
					{
					root_0 = (Object)adaptor.nil();


					IDENTIFIER726=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_eid7130); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IDENTIFIER726_tree = (Object)adaptor.create(IDENTIFIER726);
					adaptor.addChild(root_0, IDENTIFIER726_tree);
					}

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1039:7: GROUP
					{
					root_0 = (Object)adaptor.nil();


					GROUP727=(Token)match(input,GROUP,FOLLOW_GROUP_in_eid7138); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					GROUP727_tree = (Object)adaptor.create(GROUP727);
					adaptor.addChild(root_0, GROUP727_tree);
					}

					}
					break;
				case 4 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1040:7: CUBE
					{
					root_0 = (Object)adaptor.nil();


					CUBE728=(Token)match(input,CUBE,FOLLOW_CUBE_in_eid7146); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					CUBE728_tree = (Object)adaptor.create(CUBE728);
					adaptor.addChild(root_0, CUBE728_tree);
					}

					}
					break;
				case 5 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1041:7: TRUE
					{
					root_0 = (Object)adaptor.nil();


					TRUE729=(Token)match(input,TRUE,FOLLOW_TRUE_in_eid7154); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					TRUE729_tree = (Object)adaptor.create(TRUE729);
					adaptor.addChild(root_0, TRUE729_tree);
					}

					}
					break;
				case 6 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1042:7: FALSE
					{
					root_0 = (Object)adaptor.nil();


					FALSE730=(Token)match(input,FALSE,FOLLOW_FALSE_in_eid7162); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FALSE730_tree = (Object)adaptor.create(FALSE730);
					adaptor.addChild(root_0, FALSE730_tree);
					}

					}
					break;
				case 7 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1043:7: INT
					{
					root_0 = (Object)adaptor.nil();


					INT731=(Token)match(input,INT,FOLLOW_INT_in_eid7170); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INT731_tree = (Object)adaptor.create(INT731);
					adaptor.addChild(root_0, INT731_tree);
					}

					}
					break;
				case 8 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1044:7: LONG
					{
					root_0 = (Object)adaptor.nil();


					LONG732=(Token)match(input,LONG,FOLLOW_LONG_in_eid7178); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LONG732_tree = (Object)adaptor.create(LONG732);
					adaptor.addChild(root_0, LONG732_tree);
					}

					}
					break;
				case 9 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1045:7: FLOAT
					{
					root_0 = (Object)adaptor.nil();


					FLOAT733=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_eid7186); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FLOAT733_tree = (Object)adaptor.create(FLOAT733);
					adaptor.addChild(root_0, FLOAT733_tree);
					}

					}
					break;
				case 10 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1046:7: DOUBLE
					{
					root_0 = (Object)adaptor.nil();


					DOUBLE734=(Token)match(input,DOUBLE,FOLLOW_DOUBLE_in_eid7194); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DOUBLE734_tree = (Object)adaptor.create(DOUBLE734);
					adaptor.addChild(root_0, DOUBLE734_tree);
					}

					}
					break;
				case 11 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1047:7: NULL
					{
					root_0 = (Object)adaptor.nil();


					NULL735=(Token)match(input,NULL,FOLLOW_NULL_in_eid7202); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NULL735_tree = (Object)adaptor.create(NULL735);
					adaptor.addChild(root_0, NULL735_tree);
					}

					}
					break;
				case 12 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1048:7: NOT
					{
					root_0 = (Object)adaptor.nil();


					NOT736=(Token)match(input,NOT,FOLLOW_NOT_in_eid7210); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NOT736_tree = (Object)adaptor.create(NOT736);
					adaptor.addChild(root_0, NOT736_tree);
					}

					}
					break;
				case 13 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1049:7: FLATTEN
					{
					root_0 = (Object)adaptor.nil();


					FLATTEN737=(Token)match(input,FLATTEN,FOLLOW_FLATTEN_in_eid7218); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FLATTEN737_tree = (Object)adaptor.create(FLATTEN737);
					adaptor.addChild(root_0, FLATTEN737_tree);
					}

					}
					break;
				case 14 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1050:7: BAG
					{
					root_0 = (Object)adaptor.nil();


					BAG738=(Token)match(input,BAG,FOLLOW_BAG_in_eid7226); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					BAG738_tree = (Object)adaptor.create(BAG738);
					adaptor.addChild(root_0, BAG738_tree);
					}

					}
					break;
				case 15 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1051:7: TUPLE
					{
					root_0 = (Object)adaptor.nil();


					TUPLE739=(Token)match(input,TUPLE,FOLLOW_TUPLE_in_eid7234); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					TUPLE739_tree = (Object)adaptor.create(TUPLE739);
					adaptor.addChild(root_0, TUPLE739_tree);
					}

					}
					break;
				case 16 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1052:7: MAP
					{
					root_0 = (Object)adaptor.nil();


					MAP740=(Token)match(input,MAP,FOLLOW_MAP_in_eid7242); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					MAP740_tree = (Object)adaptor.create(MAP740);
					adaptor.addChild(root_0, MAP740_tree);
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "eid"


	public static class rel_op_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "rel_op"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1056:1: rel_op : ( rel_str_op | NUM_OP_EQ | NUM_OP_NE | NUM_OP_GT | NUM_OP_GTE | NUM_OP_LT | NUM_OP_LTE );
	public final QueryParser.rel_op_return rel_op() throws RecognitionException {
		QueryParser.rel_op_return retval = new QueryParser.rel_op_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NUM_OP_EQ742=null;
		Token NUM_OP_NE743=null;
		Token NUM_OP_GT744=null;
		Token NUM_OP_GTE745=null;
		Token NUM_OP_LT746=null;
		Token NUM_OP_LTE747=null;
		ParserRuleReturnScope rel_str_op741 =null;

		Object NUM_OP_EQ742_tree=null;
		Object NUM_OP_NE743_tree=null;
		Object NUM_OP_GT744_tree=null;
		Object NUM_OP_GTE745_tree=null;
		Object NUM_OP_LT746_tree=null;
		Object NUM_OP_LTE747_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1056:8: ( rel_str_op | NUM_OP_EQ | NUM_OP_NE | NUM_OP_GT | NUM_OP_GTE | NUM_OP_LT | NUM_OP_LTE )
			int alt192=7;
			switch ( input.LA(1) ) {
			case STR_OP_EQ:
			case STR_OP_GT:
			case STR_OP_GTE:
			case STR_OP_LT:
			case STR_OP_LTE:
			case STR_OP_MATCHES:
			case STR_OP_NE:
				{
				alt192=1;
				}
				break;
			case NUM_OP_EQ:
				{
				alt192=2;
				}
				break;
			case NUM_OP_NE:
				{
				alt192=3;
				}
				break;
			case NUM_OP_GT:
				{
				alt192=4;
				}
				break;
			case NUM_OP_GTE:
				{
				alt192=5;
				}
				break;
			case NUM_OP_LT:
				{
				alt192=6;
				}
				break;
			case NUM_OP_LTE:
				{
				alt192=7;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 192, 0, input);
				throw nvae;
			}
			switch (alt192) {
				case 1 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1056:10: rel_str_op
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_rel_str_op_in_rel_op7252);
					rel_str_op741=rel_str_op();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rel_str_op741.getTree());

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1057:10: NUM_OP_EQ
					{
					root_0 = (Object)adaptor.nil();


					NUM_OP_EQ742=(Token)match(input,NUM_OP_EQ,FOLLOW_NUM_OP_EQ_in_rel_op7263); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUM_OP_EQ742_tree = (Object)adaptor.create(NUM_OP_EQ742);
					adaptor.addChild(root_0, NUM_OP_EQ742_tree);
					}

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1058:10: NUM_OP_NE
					{
					root_0 = (Object)adaptor.nil();


					NUM_OP_NE743=(Token)match(input,NUM_OP_NE,FOLLOW_NUM_OP_NE_in_rel_op7274); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUM_OP_NE743_tree = (Object)adaptor.create(NUM_OP_NE743);
					adaptor.addChild(root_0, NUM_OP_NE743_tree);
					}

					}
					break;
				case 4 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1059:10: NUM_OP_GT
					{
					root_0 = (Object)adaptor.nil();


					NUM_OP_GT744=(Token)match(input,NUM_OP_GT,FOLLOW_NUM_OP_GT_in_rel_op7285); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUM_OP_GT744_tree = (Object)adaptor.create(NUM_OP_GT744);
					adaptor.addChild(root_0, NUM_OP_GT744_tree);
					}

					}
					break;
				case 5 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1060:10: NUM_OP_GTE
					{
					root_0 = (Object)adaptor.nil();


					NUM_OP_GTE745=(Token)match(input,NUM_OP_GTE,FOLLOW_NUM_OP_GTE_in_rel_op7296); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUM_OP_GTE745_tree = (Object)adaptor.create(NUM_OP_GTE745);
					adaptor.addChild(root_0, NUM_OP_GTE745_tree);
					}

					}
					break;
				case 6 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1061:10: NUM_OP_LT
					{
					root_0 = (Object)adaptor.nil();


					NUM_OP_LT746=(Token)match(input,NUM_OP_LT,FOLLOW_NUM_OP_LT_in_rel_op7307); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUM_OP_LT746_tree = (Object)adaptor.create(NUM_OP_LT746);
					adaptor.addChild(root_0, NUM_OP_LT746_tree);
					}

					}
					break;
				case 7 :
					// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1062:10: NUM_OP_LTE
					{
					root_0 = (Object)adaptor.nil();


					NUM_OP_LTE747=(Token)match(input,NUM_OP_LTE,FOLLOW_NUM_OP_LTE_in_rel_op7318); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NUM_OP_LTE747_tree = (Object)adaptor.create(NUM_OP_LTE747);
					adaptor.addChild(root_0, NUM_OP_LTE747_tree);
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rel_op"


	public static class rel_str_op_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "rel_str_op"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1065:1: rel_str_op : ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES );
	public final QueryParser.rel_str_op_return rel_str_op() throws RecognitionException {
		QueryParser.rel_str_op_return retval = new QueryParser.rel_str_op_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set748=null;

		Object set748_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1065:12: ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:
			{
			root_0 = (Object)adaptor.nil();


			set748=input.LT(1);
			if ( (input.LA(1) >= STR_OP_EQ && input.LA(1) <= STR_OP_NE) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set748));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rel_str_op"


	public static class reserved_identifier_whitelist_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "reserved_identifier_whitelist"
	// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1074:1: reserved_identifier_whitelist : ( RANK | CUBE | IN | WHEN | THEN | ELSE | END );
	public final QueryParser.reserved_identifier_whitelist_return reserved_identifier_whitelist() throws RecognitionException {
		QueryParser.reserved_identifier_whitelist_return retval = new QueryParser.reserved_identifier_whitelist_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set749=null;

		Object set749_tree=null;

		try {
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:1074:31: ( RANK | CUBE | IN | WHEN | THEN | ELSE | END )
			// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:
			{
			root_0 = (Object)adaptor.nil();


			set749=input.LT(1);
			if ( input.LA(1)==CUBE||(input.LA(1) >= ELSE && input.LA(1) <= END)||input.LA(1)==IN||input.LA(1)==RANK||input.LA(1)==THEN||input.LA(1)==WHEN ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set749));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "reserved_identifier_whitelist"

	// $ANTLR start synpred1_QueryParser
	public final void synpred1_QueryParser_fragment() throws RecognitionException {
		// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:767:20: ( WHEN )
		// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:767:21: WHEN
		{
		match(input,WHEN,FOLLOW_WHEN_in_synpred1_QueryParser4474); if (state.failed) return;

		}

	}
	// $ANTLR end synpred1_QueryParser

	// $ANTLR start synpred2_QueryParser
	public final void synpred2_QueryParser_fragment() throws RecognitionException {
		// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:843:14: ( implicit_map_type RIGHT_PAREN cast_expr )
		// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:843:16: implicit_map_type RIGHT_PAREN cast_expr
		{
		pushFollow(FOLLOW_implicit_map_type_in_synpred2_QueryParser4927);
		implicit_map_type();
		state._fsp--;
		if (state.failed) return;

		match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_synpred2_QueryParser4929); if (state.failed) return;

		pushFollow(FOLLOW_cast_expr_in_synpred2_QueryParser4931);
		cast_expr();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred2_QueryParser

	// $ANTLR start synpred3_QueryParser
	public final void synpred3_QueryParser_fragment() throws RecognitionException {
		// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:925:18: ( identifier_plus EQUAL col_ref PERIOD col_ref_list {...}?)
		// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:925:20: identifier_plus EQUAL col_ref PERIOD col_ref_list {...}?
		{
		pushFollow(FOLLOW_identifier_plus_in_synpred3_QueryParser6150);
		identifier_plus();
		state._fsp--;
		if (state.failed) return;

		match(input,EQUAL,FOLLOW_EQUAL_in_synpred3_QueryParser6152); if (state.failed) return;

		pushFollow(FOLLOW_col_ref_in_synpred3_QueryParser6154);
		col_ref();
		state._fsp--;
		if (state.failed) return;

		match(input,PERIOD,FOLLOW_PERIOD_in_synpred3_QueryParser6156); if (state.failed) return;

		pushFollow(FOLLOW_col_ref_list_in_synpred3_QueryParser6158);
		col_ref_list();
		state._fsp--;
		if (state.failed) return;

		if ( !(( input.LA( 1 ) == SEMI_COLON )) ) {
			if (state.backtracking>0) {state.failed=true; return;}
			throw new FailedPredicateException(input, "synpred3_QueryParser", " input.LA( 1 ) == SEMI_COLON ");
		}
		}

	}
	// $ANTLR end synpred3_QueryParser

	// $ANTLR start synpred4_QueryParser
	public final void synpred4_QueryParser_fragment() throws RecognitionException {
		// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:958:41: ( INTEGER SEMI_COLON )
		// src/main/java/org/qcri/rheem/parser/antlr/QueryParser.g:958:42: INTEGER SEMI_COLON
		{
		match(input,INTEGER,FOLLOW_INTEGER_in_synpred4_QueryParser6538); if (state.failed) return;

		match(input,SEMI_COLON,FOLLOW_SEMI_COLON_in_synpred4_QueryParser6540); if (state.failed) return;

		}

	}
	// $ANTLR end synpred4_QueryParser

	// Delegated rules

	public final boolean synpred4_QueryParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred4_QueryParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred3_QueryParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred3_QueryParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred1_QueryParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_QueryParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred2_QueryParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred2_QueryParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}


	protected DFA55 dfa55 = new DFA55(this);
	protected DFA141 dfa141 = new DFA141(this);
	protected DFA140 dfa140 = new DFA140(this);
	protected DFA146 dfa146 = new DFA146(this);
	protected DFA181 dfa181 = new DFA181(this);
	static final String DFA55_eotS =
		"\u0094\uffff";
	static final String DFA55_eofS =
		"\u0094\uffff";
	static final String DFA55_minS =
		"\1\4\110\10\1\4\2\uffff\110\10";
	static final String DFA55_maxS =
		"\1\u00b1\110\161\1\u00b1\2\uffff\110\161";
	static final String DFA55_acceptS =
		"\112\uffff\1\1\1\2\110\uffff";
	static final String DFA55_specialS =
		"\u0094\uffff}>";
	static final String[] DFA55_transitionS = {
			"\1\23\1\uffff\1\33\1\uffff\1\24\1\36\1\71\1\106\1\42\1\uffff\1\41\2\uffff"+
			"\1\25\1\45\1\54\1\uffff\1\44\1\14\2\uffff\1\16\1\74\1\43\1\uffff\1\5"+
			"\1\uffff\1\37\1\uffff\1\13\3\uffff\1\102\6\uffff\1\76\1\uffff\1\7\1\105"+
			"\1\101\2\uffff\1\10\1\66\1\35\1\73\1\uffff\1\72\1\22\1\2\1\uffff\1\27"+
			"\1\55\1\77\1\uffff\1\21\1\uffff\1\46\1\15\1\64\4\uffff\1\62\1\6\1\100"+
			"\1\uffff\1\110\1\52\3\uffff\1\104\1\103\7\uffff\1\34\1\12\1\uffff\1\30"+
			"\1\56\1\31\1\32\7\uffff\1\3\1\4\1\65\3\uffff\1\11\1\63\1\uffff\1\53\2"+
			"\uffff\1\20\1\uffff\1\57\1\60\1\61\1\51\1\47\7\1\1\uffff\1\50\1\75\1"+
			"\107\1\17\1\26\10\uffff\1\40\1\70\36\uffff\1\67",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\136\1\uffff\1\146\1\uffff\1\137\1\151\1\u0084\1\u0091\1\155\1\uffff"+
			"\1\154\2\uffff\1\140\1\160\1\167\1\uffff\1\157\1\127\2\uffff\1\131\1"+
			"\u0087\1\156\1\uffff\1\120\1\uffff\1\152\1\uffff\1\126\3\uffff\1\u008d"+
			"\6\uffff\1\u0089\1\uffff\1\122\1\u0090\1\u008c\2\uffff\1\123\1\u0081"+
			"\1\150\1\u0086\1\uffff\1\u0085\1\135\1\115\1\uffff\1\142\1\170\1\u008a"+
			"\1\uffff\1\134\1\uffff\1\161\1\130\1\177\4\uffff\1\175\1\121\1\u008b"+
			"\1\uffff\1\u0093\1\165\3\uffff\1\u008f\1\u008e\7\uffff\1\147\1\125\1"+
			"\uffff\1\143\1\171\1\144\1\145\7\uffff\1\116\1\117\1\u0080\3\uffff\1"+
			"\124\1\176\1\uffff\1\166\2\uffff\1\133\1\uffff\1\172\1\173\1\174\1\164"+
			"\1\162\7\114\1\uffff\1\163\1\u0088\1\u0092\1\132\1\141\10\uffff\1\153"+
			"\1\u0083\36\uffff\1\u0082",
			"",
			"",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112",
			"\1\112\17\uffff\1\112\12\uffff\1\111\7\uffff\1\112\33\uffff\1\113\2"+
			"\uffff\1\112\25\uffff\1\112\2\uffff\1\111\12\uffff\1\112\2\uffff\1\112"
	};

	static final short[] DFA55_eot = DFA.unpackEncodedString(DFA55_eotS);
	static final short[] DFA55_eof = DFA.unpackEncodedString(DFA55_eofS);
	static final char[] DFA55_min = DFA.unpackEncodedStringToUnsignedChars(DFA55_minS);
	static final char[] DFA55_max = DFA.unpackEncodedStringToUnsignedChars(DFA55_maxS);
	static final short[] DFA55_accept = DFA.unpackEncodedString(DFA55_acceptS);
	static final short[] DFA55_special = DFA.unpackEncodedString(DFA55_specialS);
	static final short[][] DFA55_transition;

	static {
		int numStates = DFA55_transitionS.length;
		DFA55_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA55_transition[i] = DFA.unpackEncodedString(DFA55_transitionS[i]);
		}
	}

	protected class DFA55 extends DFA {

		public DFA55(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 55;
			this.eot = DFA55_eot;
			this.eof = DFA55_eof;
			this.min = DFA55_min;
			this.max = DFA55_max;
			this.accept = DFA55_accept;
			this.special = DFA55_special;
			this.transition = DFA55_transition;
		}
		@Override
		public String getDescription() {
			return "409:1: func_clause : ( func_name -> ^( FUNC_REF func_name ) | func_name LEFT_PAREN ( func_args )? RIGHT_PAREN -> ^( FUNC func_name ( func_args )? ) );";
		}
	}

	static final String DFA141_eotS =
		"\22\uffff";
	static final String DFA141_eofS =
		"\5\uffff\2\15\10\uffff\3\15";
	static final String DFA141_minS =
		"\1\4\4\uffff\2\6\5\uffff\1\4\2\uffff\3\6";
	static final String DFA141_maxS =
		"\1\u00b1\4\uffff\2\u008a\5\uffff\1\u00b1\2\uffff\3\u008a";
	static final String DFA141_acceptS =
		"\1\uffff\1\1\1\2\1\3\1\4\2\uffff\1\7\1\10\1\11\1\12\1\13\1\uffff\1\5\1"+
		"\6\3\uffff";
	static final String DFA141_specialS =
		"\22\uffff}>";
	static final String[] DFA141_transitionS = {
			"\1\7\1\uffff\1\7\1\uffff\3\7\1\uffff\1\7\1\1\1\7\1\1\1\uffff\3\7\1\10"+
			"\2\7\2\uffff\1\7\1\6\1\7\1\uffff\1\7\1\uffff\1\7\1\uffff\1\7\2\uffff"+
			"\1\3\1\uffff\1\1\1\uffff\2\6\2\uffff\1\1\1\uffff\1\7\3\uffff\1\1\3\7"+
			"\1\3\1\uffff\1\5\2\7\1\6\2\7\1\uffff\1\1\1\7\1\4\3\7\1\13\1\12\1\11\1"+
			"\uffff\2\7\1\uffff\1\1\1\uffff\1\7\1\2\3\uffff\1\1\7\uffff\2\7\1\uffff"+
			"\4\7\5\uffff\1\1\1\6\3\7\3\uffff\2\7\1\uffff\1\7\2\uffff\1\7\1\uffff"+
			"\14\7\1\6\1\7\1\1\1\uffff\2\7\1\uffff\1\6\6\uffff\2\7\36\uffff\1\7",
			"",
			"",
			"",
			"",
			"\1\15\1\uffff\1\15\16\uffff\2\15\11\uffff\1\15\1\16\4\uffff\2\15\12"+
			"\uffff\1\15\6\uffff\2\15\5\uffff\1\15\1\uffff\1\15\2\uffff\1\16\7\uffff"+
			"\1\15\4\uffff\6\15\1\uffff\1\15\2\uffff\1\15\1\uffff\3\15\1\14\3\15\4"+
			"\uffff\4\15\2\uffff\1\15\4\uffff\1\15\5\uffff\10\15\4\uffff\1\15\1\uffff"+
			"\1\15",
			"\1\15\1\uffff\1\15\16\uffff\2\15\11\uffff\1\15\1\16\4\uffff\2\15\12"+
			"\uffff\1\15\6\uffff\2\15\5\uffff\1\15\1\uffff\1\15\2\uffff\1\16\7\uffff"+
			"\1\15\4\uffff\6\15\1\uffff\1\15\2\uffff\1\15\1\uffff\3\15\1\14\3\15\4"+
			"\uffff\4\15\2\uffff\1\15\4\uffff\1\15\5\uffff\10\15\4\uffff\1\15\1\uffff"+
			"\1\15",
			"",
			"",
			"",
			"",
			"",
			"\1\16\1\uffff\1\16\1\uffff\5\16\1\uffff\1\16\2\uffff\3\16\1\uffff\2"+
			"\16\2\uffff\1\16\1\21\1\16\1\uffff\1\16\1\uffff\1\16\1\uffff\1\16\2\uffff"+
			"\1\15\1\16\2\uffff\2\15\2\uffff\1\16\1\uffff\3\16\2\uffff\3\16\1\17\1"+
			"\uffff\1\20\2\16\1\15\3\16\1\uffff\1\16\1\uffff\3\16\2\uffff\1\15\1\uffff"+
			"\3\16\1\uffff\2\16\3\uffff\2\16\7\uffff\2\16\1\uffff\4\16\6\uffff\1\15"+
			"\3\16\3\uffff\2\16\1\uffff\1\16\2\uffff\1\16\1\uffff\14\16\1\15\5\16"+
			"\1\uffff\1\15\6\uffff\2\16\36\uffff\1\16",
			"",
			"",
			"\1\15\1\uffff\1\15\16\uffff\2\15\11\uffff\1\15\1\16\4\uffff\2\15\12"+
			"\uffff\1\15\6\uffff\2\15\5\uffff\1\15\1\uffff\1\15\2\uffff\1\16\7\uffff"+
			"\1\15\4\uffff\6\15\1\uffff\1\15\2\uffff\1\15\1\uffff\3\15\1\14\3\15\4"+
			"\uffff\4\15\2\uffff\1\15\4\uffff\1\15\5\uffff\10\15\4\uffff\1\15\1\uffff"+
			"\1\15",
			"\1\15\1\uffff\1\15\16\uffff\2\15\11\uffff\1\15\1\16\4\uffff\2\15\12"+
			"\uffff\1\15\6\uffff\2\15\5\uffff\1\15\1\uffff\1\15\2\uffff\1\16\7\uffff"+
			"\1\15\4\uffff\6\15\1\uffff\1\15\2\uffff\1\15\1\uffff\3\15\1\14\3\15\4"+
			"\uffff\4\15\2\uffff\1\15\4\uffff\1\15\5\uffff\10\15\4\uffff\1\15\1\uffff"+
			"\1\15",
			"\1\15\1\uffff\1\15\16\uffff\2\15\11\uffff\1\15\1\16\4\uffff\2\15\12"+
			"\uffff\1\15\6\uffff\2\15\5\uffff\1\15\1\uffff\1\15\2\uffff\1\16\7\uffff"+
			"\1\15\4\uffff\6\15\1\uffff\1\15\2\uffff\1\15\1\uffff\3\15\1\14\3\15\4"+
			"\uffff\4\15\2\uffff\1\15\4\uffff\1\15\5\uffff\10\15\4\uffff\1\15\1\uffff"+
			"\1\15"
	};

	static final short[] DFA141_eot = DFA.unpackEncodedString(DFA141_eotS);
	static final short[] DFA141_eof = DFA.unpackEncodedString(DFA141_eofS);
	static final char[] DFA141_min = DFA.unpackEncodedStringToUnsignedChars(DFA141_minS);
	static final char[] DFA141_max = DFA.unpackEncodedStringToUnsignedChars(DFA141_maxS);
	static final short[] DFA141_accept = DFA.unpackEncodedString(DFA141_acceptS);
	static final short[] DFA141_special = DFA.unpackEncodedString(DFA141_specialS);
	static final short[][] DFA141_transition;

	static {
		int numStates = DFA141_transitionS.length;
		DFA141_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA141_transition[i] = DFA.unpackEncodedString(DFA141_transitionS[i]);
		}
	}

	protected class DFA141 extends DFA {

		public DFA141(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 141;
			this.eot = DFA141_eot;
			this.eof = DFA141_eof;
			this.min = DFA141_min;
			this.max = DFA141_max;
			this.accept = DFA141_accept;
			this.special = DFA141_special;
			this.transition = DFA141_transition;
		}
		@Override
		public String getDescription() {
			return "691:1: cast_expr : ( scalar | MINUS cast_expr -> ^( NEG cast_expr ) | col_ref_without_identifier ( projection )* | invoker_func ( projection )* | identifier_plus ( projection )* | identifier_plus ( func_name_suffix )? LEFT_PAREN ( real_arg ( COMMA real_arg )* )? RIGHT_PAREN ( projection )* -> ^( FUNC_EVAL identifier_plus ( func_name_suffix )? ( real_arg )* ) ( projection )* | func_name_without_columns LEFT_PAREN ( real_arg ( COMMA real_arg )* )? RIGHT_PAREN ( projection )* -> ^( FUNC_EVAL func_name_without_columns ( real_arg )* ) ( projection )* | CASE ( ( WHEN )=> WHEN cond THEN expr ( WHEN cond THEN expr )* ( ELSE expr )? END ( projection )* -> ^( CASE_COND ^( WHEN ( cond )+ ) ^( THEN ( expr )+ ) ) ( projection )* | expr WHEN rhs_operand THEN rhs_operand ( WHEN rhs_operand THEN rhs_operand )* ( ELSE rhs_operand )? END ( projection )* -> ^( CASE_EXPR ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS rhs_operand ) )+ ) ( projection )* ) | paren_expr | curly_expr | bracket_expr );";
		}
	}

	static final String DFA140_eotS =
		"\106\uffff";
	static final String DFA140_eofS =
		"\106\uffff";
	static final String DFA140_minS =
		"\1\4\1\0\104\uffff";
	static final String DFA140_maxS =
		"\1\u00b1\1\0\104\uffff";
	static final String DFA140_acceptS =
		"\2\uffff\1\2\102\uffff\1\1";
	static final String DFA140_specialS =
		"\1\uffff\1\0\104\uffff}>";
	static final String[] DFA140_transitionS = {
			"\1\2\1\uffff\1\2\1\uffff\3\2\1\uffff\4\2\1\uffff\6\2\2\uffff\3\2\1\uffff"+
			"\1\2\1\uffff\1\2\1\uffff\1\2\2\uffff\1\2\1\uffff\1\2\1\uffff\2\2\2\uffff"+
			"\1\2\1\uffff\1\2\3\uffff\5\2\1\uffff\6\2\1\uffff\11\2\1\uffff\2\2\1\uffff"+
			"\1\2\1\uffff\2\2\3\uffff\1\2\7\uffff\2\2\1\uffff\4\2\5\uffff\5\2\3\uffff"+
			"\2\2\1\uffff\1\2\2\uffff\1\2\1\uffff\17\2\1\uffff\2\2\1\uffff\1\1\6\uffff"+
			"\2\2\36\uffff\1\2",
			"\1\uffff",
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
			""
	};

	static final short[] DFA140_eot = DFA.unpackEncodedString(DFA140_eotS);
	static final short[] DFA140_eof = DFA.unpackEncodedString(DFA140_eofS);
	static final char[] DFA140_min = DFA.unpackEncodedStringToUnsignedChars(DFA140_minS);
	static final char[] DFA140_max = DFA.unpackEncodedStringToUnsignedChars(DFA140_maxS);
	static final short[] DFA140_accept = DFA.unpackEncodedString(DFA140_acceptS);
	static final short[] DFA140_special = DFA.unpackEncodedString(DFA140_specialS);
	static final short[][] DFA140_transition;

	static {
		int numStates = DFA140_transitionS.length;
		DFA140_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA140_transition[i] = DFA.unpackEncodedString(DFA140_transitionS[i]);
		}
	}

	protected class DFA140 extends DFA {

		public DFA140(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 140;
			this.eot = DFA140_eot;
			this.eof = DFA140_eof;
			this.min = DFA140_min;
			this.max = DFA140_max;
			this.accept = DFA140_accept;
			this.special = DFA140_special;
			this.transition = DFA140_transition;
		}
		@Override
		public String getDescription() {
			return "767:18: ( ( WHEN )=> WHEN cond THEN expr ( WHEN cond THEN expr )* ( ELSE expr )? END ( projection )* -> ^( CASE_COND ^( WHEN ( cond )+ ) ^( THEN ( expr )+ ) ) ( projection )* | expr WHEN rhs_operand THEN rhs_operand ( WHEN rhs_operand THEN rhs_operand )* ( ELSE rhs_operand )? END ( projection )* -> ^( CASE_EXPR ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS rhs_operand ) )+ ) ( projection )* )";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA140_1 = input.LA(1);
						 
						int index140_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_QueryParser()) ) {s = 69;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index140_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 140, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	static final String DFA146_eotS =
		"\115\uffff";
	static final String DFA146_eofS =
		"\115\uffff";
	static final String DFA146_minS =
		"\1\4\1\0\113\uffff";
	static final String DFA146_maxS =
		"\1\u00b1\1\0\113\uffff";
	static final String DFA146_acceptS =
		"\2\uffff\1\2\111\uffff\1\1";
	static final String DFA146_specialS =
		"\1\uffff\1\0\113\uffff}>";
	static final String[] DFA146_transitionS = {
			"\1\2\1\uffff\1\2\1\uffff\17\2\2\uffff\3\2\1\uffff\1\2\1\uffff\1\2\1\uffff"+
			"\1\2\2\uffff\6\2\2\uffff\1\2\1\uffff\1\2\1\uffff\1\2\1\uffff\5\2\1\uffff"+
			"\15\2\1\1\2\2\1\uffff\7\2\2\uffff\2\2\7\uffff\2\2\1\uffff\4\2\5\uffff"+
			"\5\2\2\uffff\3\2\1\uffff\1\2\2\uffff\24\2\1\uffff\1\2\6\uffff\2\2\36"+
			"\uffff\1\2",
			"\1\uffff",
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
			"",
			"",
			"",
			"",
			""
	};

	static final short[] DFA146_eot = DFA.unpackEncodedString(DFA146_eotS);
	static final short[] DFA146_eof = DFA.unpackEncodedString(DFA146_eofS);
	static final char[] DFA146_min = DFA.unpackEncodedStringToUnsignedChars(DFA146_minS);
	static final char[] DFA146_max = DFA.unpackEncodedStringToUnsignedChars(DFA146_maxS);
	static final short[] DFA146_accept = DFA.unpackEncodedString(DFA146_acceptS);
	static final short[] DFA146_special = DFA.unpackEncodedString(DFA146_specialS);
	static final short[][] DFA146_transition;

	static {
		int numStates = DFA146_transitionS.length;
		DFA146_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA146_transition[i] = DFA.unpackEncodedString(DFA146_transitionS[i]);
		}
	}

	protected class DFA146 extends DFA {

		public DFA146(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 146;
			this.eot = DFA146_eot;
			this.eof = DFA146_eof;
			this.min = DFA146_min;
			this.max = DFA146_max;
			this.accept = DFA146_accept;
			this.special = DFA146_special;
			this.transition = DFA146_transition;
		}
		@Override
		public String getDescription() {
			return "836:1: try_implicit_map_cast : ( ( implicit_map_type RIGHT_PAREN cast_expr )=> implicit_map_type RIGHT_PAREN cast_expr -> ^( CAST_EXPR implicit_map_type cast_expr ) | after_left_paren );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA146_1 = input.LA(1);
						 
						int index146_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred2_QueryParser()) ) {s = 76;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index146_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 146, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	static final String DFA181_eotS =
		"\66\uffff";
	static final String DFA181_eofS =
		"\66\uffff";
	static final String DFA181_minS =
		"\1\32\2\52\1\4\3\42\1\uffff\7\32\1\4\1\uffff\3\0\1\32\3\0\1\32\2\0\1\uffff"+
		"\6\30\1\32\3\0\1\32\3\0\6\30\6\0";
	static final String DFA181_maxS =
		"\1\u008a\2\52\1\u00b1\3\166\1\uffff\7\u008a\1\u00b1\1\uffff\3\0\1\u008a"+
		"\3\0\1\u008a\2\0\1\uffff\6\156\1\u008a\3\0\1\u008a\3\0\6\156\6\0";
	static final String DFA181_acceptS =
		"\7\uffff\1\2\10\uffff\1\3\12\uffff\1\1\32\uffff";
	static final String DFA181_specialS =
		"\21\uffff\1\3\1\1\1\12\1\uffff\1\23\1\13\1\2\1\uffff\1\14\1\0\10\uffff"+
		"\1\4\1\5\1\6\1\uffff\1\15\1\16\1\17\6\uffff\1\7\1\10\1\11\1\20\1\21\1"+
		"\22}>";
	static final String[] DFA181_transitionS = {
			"\1\2\15\uffff\2\2\16\uffff\1\1\2\uffff\1\2\54\uffff\1\2\32\uffff\1\2"+
			"\6\uffff\1\2",
			"\1\3",
			"\1\3",
			"\1\7\1\uffff\1\7\1\uffff\3\7\1\uffff\4\7\1\uffff\6\7\2\uffff\1\14\1"+
			"\6\1\7\1\uffff\1\7\1\uffff\1\7\1\uffff\1\13\2\uffff\1\4\1\uffff\1\7\1"+
			"\uffff\2\6\2\uffff\1\7\1\uffff\1\10\3\uffff\1\7\1\11\2\7\1\4\1\uffff"+
			"\1\5\2\7\1\6\2\7\1\uffff\11\7\1\uffff\1\15\1\7\1\uffff\1\7\1\uffff\2"+
			"\7\3\uffff\1\7\7\uffff\1\7\1\12\1\uffff\4\7\5\uffff\1\7\1\6\3\7\3\uffff"+
			"\2\7\1\uffff\1\7\2\uffff\1\7\1\uffff\14\7\1\6\2\7\1\uffff\2\7\1\uffff"+
			"\1\6\6\uffff\2\7\36\uffff\1\7",
			"\1\7\54\uffff\1\7\22\uffff\1\7\1\16\2\7\13\uffff\1\7\4\uffff\1\7",
			"\2\7\43\uffff\1\7\7\uffff\1\7\22\uffff\1\7\1\17\2\7\13\uffff\1\7\4\uffff"+
			"\1\7",
			"\2\7\43\uffff\1\7\7\uffff\1\7\22\uffff\1\7\1\17\2\7\13\uffff\1\7\4\uffff"+
			"\1\7",
			"",
			"\1\20\10\uffff\1\7\1\20\3\uffff\2\20\14\uffff\1\20\1\uffff\1\20\2\uffff"+
			"\1\20\13\uffff\1\7\33\uffff\1\7\4\uffff\1\20\32\uffff\1\20\6\uffff\1"+
			"\20",
			"\1\20\10\uffff\1\7\1\20\3\uffff\2\20\14\uffff\1\20\1\uffff\1\20\2\uffff"+
			"\1\20\13\uffff\1\7\33\uffff\1\7\4\uffff\1\20\32\uffff\1\20\6\uffff\1"+
			"\20",
			"\1\20\10\uffff\1\7\1\20\3\uffff\2\20\14\uffff\1\20\1\uffff\1\20\2\uffff"+
			"\1\20\13\uffff\1\7\33\uffff\1\7\4\uffff\1\20\32\uffff\1\20\6\uffff\1"+
			"\20",
			"\1\20\10\uffff\1\7\1\20\3\uffff\2\20\14\uffff\1\20\1\uffff\1\20\2\uffff"+
			"\1\20\13\uffff\1\7\33\uffff\1\7\4\uffff\1\20\32\uffff\1\20\6\uffff\1"+
			"\20",
			"\1\20\10\uffff\1\7\1\20\3\uffff\2\20\14\uffff\1\20\1\uffff\1\20\2\uffff"+
			"\1\20\13\uffff\1\7\33\uffff\1\7\4\uffff\1\20\32\uffff\1\20\6\uffff\1"+
			"\20",
			"\1\20\10\uffff\1\7\1\20\3\uffff\2\20\14\uffff\1\20\1\uffff\1\20\2\uffff"+
			"\1\20\13\uffff\1\7\33\uffff\1\7\4\uffff\1\20\32\uffff\1\20\6\uffff\1"+
			"\20",
			"\1\23\11\uffff\1\21\3\uffff\2\23\14\uffff\1\21\1\uffff\1\22\2\uffff"+
			"\1\23\13\uffff\1\24\40\uffff\1\23\32\uffff\1\23\6\uffff\1\23",
			"\1\7\1\uffff\1\7\1\uffff\5\7\1\uffff\1\7\2\uffff\3\7\1\uffff\2\7\2\uffff"+
			"\1\7\1\27\1\7\1\uffff\1\7\1\uffff\1\7\1\uffff\1\7\2\uffff\1\31\1\7\2"+
			"\uffff\2\32\2\uffff\1\7\1\uffff\3\7\2\uffff\3\7\1\25\1\uffff\1\26\2\7"+
			"\1\32\3\7\1\uffff\1\7\1\uffff\3\7\2\uffff\1\30\1\uffff\3\7\1\uffff\2"+
			"\7\3\uffff\2\7\7\uffff\2\7\1\uffff\4\7\6\uffff\1\32\3\7\3\uffff\2\7\1"+
			"\uffff\1\7\2\uffff\1\7\1\uffff\14\7\1\32\5\7\1\uffff\1\32\6\uffff\2\7"+
			"\36\uffff\1\7",
			"",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\36\11\uffff\1\34\3\uffff\2\36\14\uffff\1\34\1\uffff\1\35\2\uffff"+
			"\1\36\54\uffff\1\36\32\uffff\1\36\6\uffff\1\36",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\41\11\uffff\1\37\3\uffff\2\41\14\uffff\1\37\1\uffff\1\40\2\uffff"+
			"\1\41\54\uffff\1\41\32\uffff\1\41\6\uffff\1\41",
			"\1\uffff",
			"\1\uffff",
			"",
			"\1\42\125\uffff\1\43",
			"\1\42\125\uffff\1\44",
			"\1\42\125\uffff\1\45",
			"\1\46\125\uffff\1\47",
			"\1\46\125\uffff\1\50",
			"\1\46\125\uffff\1\51",
			"\1\54\11\uffff\1\52\3\uffff\2\54\14\uffff\1\52\1\uffff\1\53\2\uffff"+
			"\1\54\54\uffff\1\54\32\uffff\1\54\6\uffff\1\54",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\57\11\uffff\1\55\3\uffff\2\57\14\uffff\1\55\1\uffff\1\56\2\uffff"+
			"\1\57\54\uffff\1\57\32\uffff\1\57\6\uffff\1\57",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\42\125\uffff\1\60",
			"\1\42\125\uffff\1\61",
			"\1\42\125\uffff\1\62",
			"\1\46\125\uffff\1\63",
			"\1\46\125\uffff\1\64",
			"\1\46\125\uffff\1\65",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff"
	};

	static final short[] DFA181_eot = DFA.unpackEncodedString(DFA181_eotS);
	static final short[] DFA181_eof = DFA.unpackEncodedString(DFA181_eofS);
	static final char[] DFA181_min = DFA.unpackEncodedStringToUnsignedChars(DFA181_minS);
	static final char[] DFA181_max = DFA.unpackEncodedStringToUnsignedChars(DFA181_maxS);
	static final short[] DFA181_accept = DFA.unpackEncodedString(DFA181_acceptS);
	static final short[] DFA181_special = DFA.unpackEncodedString(DFA181_specialS);
	static final short[][] DFA181_transition;

	static {
		int numStates = DFA181_transitionS.length;
		DFA181_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA181_transition[i] = DFA.unpackEncodedString(DFA181_transitionS[i]);
		}
	}

	protected class DFA181 extends DFA {

		public DFA181(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 181;
			this.eot = DFA181_eot;
			this.eof = DFA181_eof;
			this.min = DFA181_min;
			this.max = DFA181_max;
			this.accept = DFA181_accept;
			this.special = DFA181_special;
			this.transition = DFA181_transition;
		}
		@Override
		public String getDescription() {
			return "925:1: nested_command : ( ( identifier_plus EQUAL col_ref PERIOD col_ref_list {...}?)=> ( identifier_plus EQUAL nested_proj ) -> ^( NESTED_CMD identifier_plus nested_proj ) | identifier_plus EQUAL expr -> ^( NESTED_CMD_ASSI identifier_plus expr ) | identifier_plus EQUAL nested_op -> ^( NESTED_CMD identifier_plus nested_op ) );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA181_26 = input.LA(1);
						 
						int index181_26 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred3_QueryParser()) ) {s = 27;}
						else if ( (true) ) {s = 7;}
						 
						input.seek(index181_26);
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA181_18 = input.LA(1);
						 
						int index181_18 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred3_QueryParser()) ) {s = 27;}
						else if ( (true) ) {s = 7;}
						 
						input.seek(index181_18);
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA181_23 = input.LA(1);
						 
						int index181_23 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred3_QueryParser()) ) {s = 27;}
						else if ( (true) ) {s = 7;}
						 
						input.seek(index181_23);
						if ( s>=0 ) return s;
						break;

					case 3 : 
						int LA181_17 = input.LA(1);
						 
						int index181_17 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred3_QueryParser()) ) {s = 27;}
						else if ( (true) ) {s = 7;}
						 
						input.seek(index181_17);
						if ( s>=0 ) return s;
						break;

					case 4 : 
						int LA181_35 = input.LA(1);
						 
						int index181_35 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred3_QueryParser()) ) {s = 27;}
						else if ( (true) ) {s = 7;}
						 
						input.seek(index181_35);
						if ( s>=0 ) return s;
						break;

					case 5 : 
						int LA181_36 = input.LA(1);
						 
						int index181_36 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred3_QueryParser()) ) {s = 27;}
						else if ( (true) ) {s = 7;}
						 
						input.seek(index181_36);
						if ( s>=0 ) return s;
						break;

					case 6 : 
						int LA181_37 = input.LA(1);
						 
						int index181_37 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred3_QueryParser()) ) {s = 27;}
						else if ( (true) ) {s = 7;}
						 
						input.seek(index181_37);
						if ( s>=0 ) return s;
						break;

					case 7 : 
						int LA181_48 = input.LA(1);
						 
						int index181_48 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred3_QueryParser()) ) {s = 27;}
						else if ( (true) ) {s = 7;}
						 
						input.seek(index181_48);
						if ( s>=0 ) return s;
						break;

					case 8 : 
						int LA181_49 = input.LA(1);
						 
						int index181_49 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred3_QueryParser()) ) {s = 27;}
						else if ( (true) ) {s = 7;}
						 
						input.seek(index181_49);
						if ( s>=0 ) return s;
						break;

					case 9 : 
						int LA181_50 = input.LA(1);
						 
						int index181_50 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred3_QueryParser()) ) {s = 27;}
						else if ( (true) ) {s = 7;}
						 
						input.seek(index181_50);
						if ( s>=0 ) return s;
						break;

					case 10 : 
						int LA181_19 = input.LA(1);
						 
						int index181_19 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred3_QueryParser()) ) {s = 27;}
						else if ( (true) ) {s = 7;}
						 
						input.seek(index181_19);
						if ( s>=0 ) return s;
						break;

					case 11 : 
						int LA181_22 = input.LA(1);
						 
						int index181_22 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred3_QueryParser()) ) {s = 27;}
						else if ( (true) ) {s = 7;}
						 
						input.seek(index181_22);
						if ( s>=0 ) return s;
						break;

					case 12 : 
						int LA181_25 = input.LA(1);
						 
						int index181_25 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred3_QueryParser()) ) {s = 27;}
						else if ( (true) ) {s = 7;}
						 
						input.seek(index181_25);
						if ( s>=0 ) return s;
						break;

					case 13 : 
						int LA181_39 = input.LA(1);
						 
						int index181_39 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred3_QueryParser()) ) {s = 27;}
						else if ( (true) ) {s = 7;}
						 
						input.seek(index181_39);
						if ( s>=0 ) return s;
						break;

					case 14 : 
						int LA181_40 = input.LA(1);
						 
						int index181_40 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred3_QueryParser()) ) {s = 27;}
						else if ( (true) ) {s = 7;}
						 
						input.seek(index181_40);
						if ( s>=0 ) return s;
						break;

					case 15 : 
						int LA181_41 = input.LA(1);
						 
						int index181_41 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred3_QueryParser()) ) {s = 27;}
						else if ( (true) ) {s = 7;}
						 
						input.seek(index181_41);
						if ( s>=0 ) return s;
						break;

					case 16 : 
						int LA181_51 = input.LA(1);
						 
						int index181_51 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred3_QueryParser()) ) {s = 27;}
						else if ( (true) ) {s = 7;}
						 
						input.seek(index181_51);
						if ( s>=0 ) return s;
						break;

					case 17 : 
						int LA181_52 = input.LA(1);
						 
						int index181_52 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred3_QueryParser()) ) {s = 27;}
						else if ( (true) ) {s = 7;}
						 
						input.seek(index181_52);
						if ( s>=0 ) return s;
						break;

					case 18 : 
						int LA181_53 = input.LA(1);
						 
						int index181_53 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred3_QueryParser()) ) {s = 27;}
						else if ( (true) ) {s = 7;}
						 
						input.seek(index181_53);
						if ( s>=0 ) return s;
						break;

					case 19 : 
						int LA181_21 = input.LA(1);
						 
						int index181_21 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred3_QueryParser()) ) {s = 27;}
						else if ( (true) ) {s = 7;}
						 
						input.seek(index181_21);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 181, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	public static final BitSet FOLLOW_statement_in_query426 = new BitSet(new long[]{0x0D48630226400400L,0x0C23030010004688L,0x0000000000000488L});
	public static final BitSet FOLLOW_EOF_in_query429 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_field_def_list_in_schema448 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_schema450 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEMI_COLON_in_statement461 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_general_statement_in_statement476 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_SEMI_COLON_in_statement478 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_split_clause_in_statement493 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_SEMI_COLON_in_statement495 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_inline_clause_in_statement510 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_SEMI_COLON_in_statement512 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_import_clause_in_statement527 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_SEMI_COLON_in_statement529 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_realias_clause_in_statement544 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_SEMI_COLON_in_statement546 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_register_clause_in_statement561 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_SEMI_COLON_in_statement563 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assert_clause_in_statement578 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_SEMI_COLON_in_statement580 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_foreach_statement_in_statement628 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFT_PAREN_in_nested_op_clause637 = new BitSet(new long[]{0x0040400226400000L,0x0C01010010004608L,0x0000000000000080L});
	public static final BitSet FOLLOW_op_clause_in_nested_op_clause640 = new BitSet(new long[]{0x0000000000000000L,0x0000400100000000L});
	public static final BitSet FOLLOW_parallel_clause_in_nested_op_clause642 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_nested_op_clause645 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFT_PAREN_in_nested_op_clause667 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_FOREACH_in_nested_op_clause669 = new BitSet(new long[]{0x0900030004000080L,0x0000010000000080L,0x0000000000000408L});
	public static final BitSet FOLLOW_rel_in_nested_op_clause671 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_foreach_plan_complex_in_nested_op_clause675 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_foreach_plan_simple_in_nested_op_clause681 = new BitSet(new long[]{0x0000000000000000L,0x0000400100000000L});
	public static final BitSet FOLLOW_parallel_clause_in_nested_op_clause683 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_nested_op_clause690 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FAT_ARROW_in_general_statement738 = new BitSet(new long[]{0x0040400226400000L,0x0C01010010004688L,0x0000000000000080L});
	public static final BitSet FOLLOW_op_clause_in_general_statement744 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
	public static final BitSet FOLLOW_parallel_clause_in_general_statement746 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nested_op_clause_in_general_statement753 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_plus_in_general_statement799 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_EQUAL_in_general_statement801 = new BitSet(new long[]{0x0040400226400000L,0x0C01010010004688L,0x0000000000000080L});
	public static final BitSet FOLLOW_op_clause_in_general_statement810 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
	public static final BitSet FOLLOW_parallel_clause_in_general_statement812 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nested_op_clause_in_general_statement819 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FAT_ARROW_in_foreach_statement854 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_FOREACH_in_foreach_statement856 = new BitSet(new long[]{0x0900030004000080L,0x0000010000000080L,0x0000000000000408L});
	public static final BitSet FOLLOW_rel_in_foreach_statement858 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_foreach_plan_complex_in_foreach_statement862 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_foreach_plan_simple_in_foreach_statement868 = new BitSet(new long[]{0x0000000000000000L,0x0002000100000000L});
	public static final BitSet FOLLOW_parallel_clause_in_foreach_statement870 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_SEMI_COLON_in_foreach_statement873 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_plus_in_foreach_statement933 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_EQUAL_in_foreach_statement935 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_FOREACH_in_foreach_statement940 = new BitSet(new long[]{0x0900030004000080L,0x0000010000000080L,0x0000000000000408L});
	public static final BitSet FOLLOW_rel_in_foreach_statement942 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_foreach_plan_complex_in_foreach_statement946 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_foreach_plan_simple_in_foreach_statement952 = new BitSet(new long[]{0x0000000000000000L,0x0002000100000000L});
	public static final BitSet FOLLOW_parallel_clause_in_foreach_statement954 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_SEMI_COLON_in_foreach_statement957 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFT_CURLY_in_foreach_plan_complex1002 = new BitSet(new long[]{0x0920030004000000L,0x0000010000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_nested_blk_in_foreach_plan_complex1004 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_RIGHT_CURLY_in_foreach_plan_complex1006 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GENERATE_in_foreach_plan_simple1025 = new BitSet(new long[]{0xBF7CD3D2AE7EF750L,0xFFE58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_flatten_generated_item_in_foreach_plan_simple1027 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_COMMA_in_foreach_plan_simple1031 = new BitSet(new long[]{0xBF7CD3D2AE7EF750L,0xFFE58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_flatten_generated_item_in_foreach_plan_simple1033 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_LEFT_CURLY_in_macro_content1064 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0xFFFFFFFFFFFFFFFFL,0x07FFFFFFFFFFFFFFL});
	public static final BitSet FOLLOW_macro_content_in_macro_content1068 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0xFFFFFFFFFFFFFFFFL,0x07FFFFFFFFFFFFFFL});
	public static final BitSet FOLLOW_set_in_macro_content1072 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0xFFFFFFFFFFFFFFFFL,0x07FFFFFFFFFFFFFFL});
	public static final BitSet FOLLOW_RIGHT_CURLY_in_macro_content1084 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFT_PAREN_in_macro_param_clause1093 = new BitSet(new long[]{0x0900030004000000L,0x0000410000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_identifier_plus_in_macro_param_clause1097 = new BitSet(new long[]{0x0000000001000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_COMMA_in_macro_param_clause1100 = new BitSet(new long[]{0x0900030004000000L,0x0000010000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_identifier_plus_in_macro_param_clause1102 = new BitSet(new long[]{0x0000000001000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_macro_param_clause1109 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RETURNS_in_macro_return_clause1135 = new BitSet(new long[]{0x0900030004000000L,0x0000010000000000L,0x0000000000000608L});
	public static final BitSet FOLLOW_identifier_plus_in_macro_return_clause1139 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_COMMA_in_macro_return_clause1142 = new BitSet(new long[]{0x0900030004000000L,0x0000010000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_identifier_plus_in_macro_return_clause1144 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_VOID_in_macro_return_clause1151 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_macro_content_in_macro_body_clause1178 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_macro_param_clause_in_macro_clause1196 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
	public static final BitSet FOLLOW_macro_return_clause_in_macro_clause1198 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_macro_body_clause_in_macro_clause1200 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_plus_in_inline_return_clause1229 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_EQUAL_in_inline_return_clause1231 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_plus_in_inline_return_clause1244 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_COMMA_in_inline_return_clause1247 = new BitSet(new long[]{0x0900030004000000L,0x0000010000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_identifier_plus_in_inline_return_clause1249 = new BitSet(new long[]{0x0000040001000000L});
	public static final BitSet FOLLOW_EQUAL_in_inline_return_clause1253 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFT_PAREN_in_inline_param_clause1341 = new BitSet(new long[]{0x810000500000A000L,0x0000408000000000L});
	public static final BitSet FOLLOW_parameter_in_inline_param_clause1345 = new BitSet(new long[]{0x0000000001000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_COMMA_in_inline_param_clause1348 = new BitSet(new long[]{0x810000500000A000L,0x0000008000000000L});
	public static final BitSet FOLLOW_parameter_in_inline_param_clause1350 = new BitSet(new long[]{0x0000000001000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_inline_param_clause1357 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_inline_return_clause_in_inline_clause1379 = new BitSet(new long[]{0x0900030004000000L,0x0000010000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_identifier_plus_in_inline_clause1381 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_inline_param_clause_in_inline_clause1383 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFT_PAREN_in_implicit_tuple_type1455 = new BitSet(new long[]{0x490103200C255800L,0x00004100000028E0L,0x0000000000000448L});
	public static final BitSet FOLLOW_field_def_list_in_implicit_tuple_type1457 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_implicit_tuple_type1460 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TUPLE_in_explicit_tuple_type1480 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_implicit_tuple_type_in_explicit_tuple_type1483 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TUPLE_in_explicit_tuple_type_cast1492 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_LEFT_PAREN_in_explicit_tuple_type_cast1494 = new BitSet(new long[]{0x4001002008255800L,0x0000400000002800L,0x0000000000000040L});
	public static final BitSet FOLLOW_explicit_type_cast_in_explicit_tuple_type_cast1498 = new BitSet(new long[]{0x0000000001000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_COMMA_in_explicit_tuple_type_cast1502 = new BitSet(new long[]{0x4001002008255800L,0x0000000000002800L,0x0000000000000040L});
	public static final BitSet FOLLOW_explicit_type_cast_in_explicit_tuple_type_cast1504 = new BitSet(new long[]{0x0000000001000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_explicit_tuple_type_cast1512 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_implicit_tuple_type_in_tuple_type1536 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_explicit_tuple_type_in_tuple_type1540 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFT_CURLY_in_implicit_bag_type1549 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
	public static final BitSet FOLLOW_NULL_in_implicit_bag_type1551 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_COLON_in_implicit_bag_type1553 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000080L,0x0000000000000040L});
	public static final BitSet FOLLOW_tuple_type_in_implicit_bag_type1555 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_RIGHT_CURLY_in_implicit_bag_type1558 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFT_CURLY_in_implicit_bag_type1591 = new BitSet(new long[]{0x0900030004000000L,0x0000210000000080L,0x0000000000000448L});
	public static final BitSet FOLLOW_identifier_plus_in_implicit_bag_type1597 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_COLON_in_implicit_bag_type1599 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L,0x0000000000000040L});
	public static final BitSet FOLLOW_tuple_type_in_implicit_bag_type1604 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_RIGHT_CURLY_in_implicit_bag_type1609 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BAG_in_explicit_bag_type1632 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_implicit_bag_type_in_explicit_bag_type1635 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BAG_in_explicit_bag_type_cast1644 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_LEFT_CURLY_in_explicit_bag_type_cast1646 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_explicit_tuple_type_cast_in_explicit_bag_type_cast1648 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_RIGHT_CURLY_in_explicit_bag_type_cast1651 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFT_BRACKET_in_implicit_map_type1671 = new BitSet(new long[]{0x490103200C255800L,0x00001100000028E0L,0x0000000000000448L});
	public static final BitSet FOLLOW_identifier_plus_in_implicit_map_type1677 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_COLON_in_implicit_map_type1679 = new BitSet(new long[]{0x4001002008255800L,0x00000000000028E0L,0x0000000000000040L});
	public static final BitSet FOLLOW_type_in_implicit_map_type1684 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_RIGHT_BRACKET_in_implicit_map_type1689 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAP_in_explicit_map_type1712 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_implicit_map_type_in_explicit_map_type1715 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_implicit_map_type_in_map_type1724 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_explicit_map_type_in_map_type1728 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_simple_type_in_explicit_type1737 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_explicit_tuple_type_in_explicit_type1741 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_explicit_bag_type_in_explicit_type1745 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_explicit_map_type_in_explicit_type1749 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_implicit_tuple_type_in_implicit_type1758 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_implicit_bag_type_in_implicit_type1762 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_implicit_map_type_in_implicit_type1766 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_explicit_type_in_type1775 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_implicit_type_in_type1779 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_simple_type_in_explicit_type_cast1788 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_explicit_map_type_in_explicit_type_cast1792 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_explicit_tuple_type_cast_in_explicit_type_cast1796 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_explicit_bag_type_cast_in_explicit_type_cast1800 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IMPORT_in_import_clause1811 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_QUOTEDSTRING_in_import_clause1814 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_REGISTER_in_register_clause1823 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_QUOTEDSTRING_in_register_clause1826 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_USING_in_register_clause1829 = new BitSet(new long[]{0x0900030004000000L,0x0000010000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_identifier_plus_in_register_clause1831 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_AS_in_register_clause1833 = new BitSet(new long[]{0x0900030004000000L,0x0000010000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_identifier_plus_in_register_clause1835 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DEFINE_in_define_clause1846 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_define_clause1849 = new BitSet(new long[]{0x7779D822AE6E5F50L,0xFFA58E03D80C6E9DL,0x00020000000601F7L});
	public static final BitSet FOLLOW_cmd_in_define_clause1853 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_func_clause_in_define_clause1857 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_macro_clause_in_define_clause1861 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_plus_in_realias_clause1871 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_EQUAL_in_realias_clause1873 = new BitSet(new long[]{0x0900030004000000L,0x0000010000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_identifier_plus_in_realias_clause1875 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PARALLEL_in_parallel_clause1894 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_INTEGER_in_parallel_clause1897 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_define_clause_in_op_clause1906 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_load_clause_in_op_clause1920 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_group_clause_in_op_clause1934 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cube_clause_in_op_clause1948 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_store_clause_in_op_clause1962 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_filter_clause_in_op_clause1976 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_distinct_clause_in_op_clause1990 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_limit_clause_in_op_clause2004 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_sample_clause_in_op_clause2018 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_order_clause_in_op_clause2032 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rank_clause_in_op_clause2046 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cross_clause_in_op_clause2060 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_join_clause_in_op_clause2074 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_union_clause_in_op_clause2088 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stream_clause_in_op_clause2102 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mr_clause_in_op_clause2116 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHIP_in_ship_clause2125 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_LEFT_PAREN_in_ship_clause2128 = new BitSet(new long[]{0x0000000000000000L,0x0000408000000000L});
	public static final BitSet FOLLOW_path_list_in_ship_clause2131 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_ship_clause2134 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QUOTEDSTRING_in_path_list2144 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_COMMA_in_path_list2148 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_QUOTEDSTRING_in_path_list2150 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_CACHE_in_cache_clause2167 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_LEFT_PAREN_in_cache_clause2170 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_path_list_in_cache_clause2173 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_cache_clause2175 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INPUT_in_input_clause2185 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_LEFT_PAREN_in_input_clause2188 = new BitSet(new long[]{0x0000000000000000L,0x0300008000000000L});
	public static final BitSet FOLLOW_stream_cmd_list_in_input_clause2191 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_input_clause2193 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OUTPUT_in_output_clause2203 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_LEFT_PAREN_in_output_clause2206 = new BitSet(new long[]{0x0000000000000000L,0x0300008000000000L});
	public static final BitSet FOLLOW_stream_cmd_list_in_output_clause2209 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_output_clause2211 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STDERROR_in_error_clause2221 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_LEFT_PAREN_in_error_clause2224 = new BitSet(new long[]{0x0000000000000000L,0x0000408000000000L});
	public static final BitSet FOLLOW_QUOTEDSTRING_in_error_clause2229 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000200L});
	public static final BitSet FOLLOW_LIMIT_in_error_clause2233 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_INTEGER_in_error_clause2236 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_error_clause2244 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LOAD_in_load_clause2254 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_QUOTEDSTRING_in_load_clause2257 = new BitSet(new long[]{0x0000000000000102L,0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_USING_in_load_clause2261 = new BitSet(new long[]{0x7779D022AE6E5F50L,0xFFA58E03D80C6E1DL,0x00020000000601F7L});
	public static final BitSet FOLLOW_func_clause_in_load_clause2264 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_as_clause_in_load_clause2269 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_func_name_in_func_clause2279 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_func_name_in_func_clause2316 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_LEFT_PAREN_in_func_clause2318 = new BitSet(new long[]{0x0000000000000000L,0x0000408000020000L});
	public static final BitSet FOLLOW_func_args_in_func_clause2320 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_func_clause2323 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_eid_without_columns_in_func_name_without_columns2357 = new BitSet(new long[]{0x0000000800000002L,0x0000000800000000L});
	public static final BitSet FOLLOW_set_in_func_name_without_columns2361 = new BitSet(new long[]{0x7779D022AE6E5F50L,0xFFA58E03D80C6E1DL,0x00020000000601F7L});
	public static final BitSet FOLLOW_eid_in_func_name_without_columns2371 = new BitSet(new long[]{0x0000000800000002L,0x0000000800000000L});
	public static final BitSet FOLLOW_eid_in_func_name2383 = new BitSet(new long[]{0x0000000800000002L,0x0000000800000000L});
	public static final BitSet FOLLOW_set_in_func_name2387 = new BitSet(new long[]{0x7779D022AE6E5F50L,0xFFA58E03D80C6E1DL,0x00020000000601F7L});
	public static final BitSet FOLLOW_eid_in_func_name2397 = new BitSet(new long[]{0x0000000800000002L,0x0000000800000000L});
	public static final BitSet FOLLOW_func_args_string_in_func_args2422 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_COMMA_in_func_args2426 = new BitSet(new long[]{0x0000000000000000L,0x0000008000020000L});
	public static final BitSet FOLLOW_func_args_string_in_func_args2428 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_set_in_group_clause2454 = new BitSet(new long[]{0x0900030004000080L,0x0000010000000080L,0x0000000000000408L});
	public static final BitSet FOLLOW_group_item_list_in_group_clause2465 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_USING_in_group_clause2469 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_QUOTEDSTRING_in_group_clause2472 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
	public static final BitSet FOLLOW_partition_clause_in_group_clause2477 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_group_item_in_group_item_list2487 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_COMMA_in_group_item_list2491 = new BitSet(new long[]{0x0900030004000080L,0x0000010000000080L,0x0000000000000408L});
	public static final BitSet FOLLOW_group_item_in_group_item_list2493 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_rel_in_group_item2525 = new BitSet(new long[]{0x0000000000020010L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_join_group_by_clause_in_group_item2529 = new BitSet(new long[]{0x1000000000000002L,0x0000000040000000L});
	public static final BitSet FOLLOW_ALL_in_group_item2533 = new BitSet(new long[]{0x1000000000000002L,0x0000000040000000L});
	public static final BitSet FOLLOW_ANY_in_group_item2537 = new BitSet(new long[]{0x1000000000000002L,0x0000000040000000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_identifier_plus2561 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_reserved_identifier_whitelist_in_identifier_plus2565 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_plus_in_explicit_field_def2579 = new BitSet(new long[]{0x0000000000800002L});
	public static final BitSet FOLLOW_COLON_in_explicit_field_def2583 = new BitSet(new long[]{0x4001002008255800L,0x00000000000028E0L,0x0000000000000040L});
	public static final BitSet FOLLOW_type_in_explicit_field_def2585 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_explicit_type_in_explicit_field_def2624 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_explicit_field_def_in_field_def2643 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_implicit_type_in_field_def2657 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_field_def_in_field_def_list2676 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_COMMA_in_field_def_list2680 = new BitSet(new long[]{0x490103200C255800L,0x00000100000028E0L,0x0000000000000448L});
	public static final BitSet FOLLOW_field_def_in_field_def_list2683 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_AS_in_as_clause2698 = new BitSet(new long[]{0x490103200C255800L,0x0000010000002880L,0x0000000000000448L});
	public static final BitSet FOLLOW_explicit_field_def_in_as_clause2703 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFT_PAREN_in_as_clause2709 = new BitSet(new long[]{0x490103200C255800L,0x00004100000028E0L,0x0000000000000448L});
	public static final BitSet FOLLOW_field_def_list_in_as_clause2712 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_as_clause2715 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stream_cmd_in_stream_cmd_list2731 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_COMMA_in_stream_cmd_list2735 = new BitSet(new long[]{0x0000000000000000L,0x0300008000000000L});
	public static final BitSet FOLLOW_stream_cmd_in_stream_cmd_list2737 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_set_in_stream_cmd2754 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_USING_in_stream_cmd2771 = new BitSet(new long[]{0x7779D022AE6E5F50L,0xFFA58E03D80C6E1DL,0x00020000000601F7L});
	public static final BitSet FOLLOW_func_clause_in_stream_cmd2774 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EXECCOMMAND_in_cmd2786 = new BitSet(new long[]{0x2000000000080002L,0x0084000080000000L});
	public static final BitSet FOLLOW_ship_clause_in_cmd2791 = new BitSet(new long[]{0x2000000000080002L,0x0084000080000000L});
	public static final BitSet FOLLOW_cache_clause_in_cmd2795 = new BitSet(new long[]{0x2000000000080002L,0x0084000080000000L});
	public static final BitSet FOLLOW_input_clause_in_cmd2799 = new BitSet(new long[]{0x2000000000080002L,0x0084000080000000L});
	public static final BitSet FOLLOW_output_clause_in_cmd2803 = new BitSet(new long[]{0x2000000000080002L,0x0084000080000000L});
	public static final BitSet FOLLOW_error_clause_in_cmd2807 = new BitSet(new long[]{0x2000000000080002L,0x0084000080000000L});
	public static final BitSet FOLLOW_identifier_plus_in_rel2819 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_previous_rel_in_rel2823 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nested_op_clause_in_rel2827 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARROBA_in_previous_rel2836 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STORE_in_store_clause2845 = new BitSet(new long[]{0x0900030004000080L,0x0000010000000080L,0x0000000000000408L});
	public static final BitSet FOLLOW_rel_in_store_clause2848 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_INTO_in_store_clause2850 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_QUOTEDSTRING_in_store_clause2853 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_USING_in_store_clause2857 = new BitSet(new long[]{0x7779D022AE6E5F50L,0xFFA58E03D80C6E1DL,0x00020000000601F7L});
	public static final BitSet FOLLOW_func_clause_in_store_clause2860 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSERT_in_assert_clause2872 = new BitSet(new long[]{0x0900030004000080L,0x0000010000000080L,0x0000000000000408L});
	public static final BitSet FOLLOW_rel_in_assert_clause2875 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_BY_in_assert_clause2877 = new BitSet(new long[]{0xBF7C5352AE7EF750L,0xFFA58F83D80CD6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_cond_in_assert_clause2880 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_COMMA_in_assert_clause2884 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_QUOTEDSTRING_in_assert_clause2887 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FILTER_in_filter_clause2899 = new BitSet(new long[]{0x0900030004000080L,0x0000010000000080L,0x0000000000000408L});
	public static final BitSet FOLLOW_rel_in_filter_clause2902 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_BY_in_filter_clause2904 = new BitSet(new long[]{0xBF7C5352AE7EF750L,0xFFA58F83D80CD6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_cond_in_filter_clause2907 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STREAM_in_stream_clause2916 = new BitSet(new long[]{0x0900030004000080L,0x0000010000000080L,0x0000000000000408L});
	public static final BitSet FOLLOW_rel_in_stream_clause2919 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_THROUGH_in_stream_clause2921 = new BitSet(new long[]{0x09000B0004000000L,0x0000010000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_EXECCOMMAND_in_stream_clause2926 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_identifier_plus_in_stream_clause2930 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_as_clause_in_stream_clause2934 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAPREDUCE_in_mr_clause2944 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_QUOTEDSTRING_in_mr_clause2947 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000080L});
	public static final BitSet FOLLOW_LEFT_PAREN_in_mr_clause2951 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_path_list_in_mr_clause2954 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_mr_clause2956 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
	public static final BitSet FOLLOW_store_clause_in_mr_clause2962 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
	public static final BitSet FOLLOW_load_clause_in_mr_clause2964 = new BitSet(new long[]{0x0000080000000002L});
	public static final BitSet FOLLOW_EXECCOMMAND_in_mr_clause2966 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SPLIT_in_split_clause2976 = new BitSet(new long[]{0x0900030004000080L,0x0000010000000080L,0x0000000000000408L});
	public static final BitSet FOLLOW_rel_in_split_clause2979 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_INTO_in_split_clause2981 = new BitSet(new long[]{0x0900030004000000L,0x0000010000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_split_branch_in_split_clause2984 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_split_branches_in_split_clause2986 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_plus_in_split_branch2995 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_IF_in_split_branch2997 = new BitSet(new long[]{0xBF7C5352AE7EF750L,0xFFA58F83D80CD6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_cond_in_split_branch2999 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_plus_in_split_otherwise3020 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_OTHERWISE_in_split_otherwise3022 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_split_branches3032 = new BitSet(new long[]{0x0900030004000000L,0x0000010000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_split_branch_in_split_branches3035 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_split_branches_in_split_branches3037 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_split_branches3057 = new BitSet(new long[]{0x0900030004000000L,0x0000010000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_split_otherwise_in_split_branches3060 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LIMIT_in_limit_clause3069 = new BitSet(new long[]{0x0900030004000080L,0x0000010000000080L,0x0000000000000408L});
	public static final BitSet FOLLOW_rel_in_limit_clause3072 = new BitSet(new long[]{0xBF7C5352AE7EF750L,0xFFA58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_expr_in_limit_clause3074 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SAMPLE_in_sample_clause3083 = new BitSet(new long[]{0x0900030004000080L,0x0000010000000080L,0x0000000000000408L});
	public static final BitSet FOLLOW_rel_in_sample_clause3086 = new BitSet(new long[]{0xBF7C5352AE7EF750L,0xFFA58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_expr_in_sample_clause3088 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RANK_in_rank_clause3097 = new BitSet(new long[]{0x0900030004000080L,0x0000010000000080L,0x0000000000000408L});
	public static final BitSet FOLLOW_rel_in_rank_clause3100 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_rank_by_statement_in_rank_clause3104 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BY_in_rank_by_statement3116 = new BitSet(new long[]{0x0940039004000000L,0x0040010000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_rank_by_clause_in_rank_by_statement3119 = new BitSet(new long[]{0x0000000040000002L});
	public static final BitSet FOLLOW_DENSE_in_rank_by_statement3121 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STAR_in_rank_by_clause3131 = new BitSet(new long[]{0x0000000080000202L});
	public static final BitSet FOLLOW_rank_list_in_rank_by_clause3161 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rank_col_in_rank_list3170 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_COMMA_in_rank_list3174 = new BitSet(new long[]{0x0940039004000000L,0x0000010000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_rank_col_in_rank_list3176 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_col_range_in_rank_col3202 = new BitSet(new long[]{0x0000000080000202L});
	public static final BitSet FOLLOW_col_ref_in_rank_col3226 = new BitSet(new long[]{0x0000000080000202L});
	public static final BitSet FOLLOW_ORDER_in_order_clause3246 = new BitSet(new long[]{0x0900030004000080L,0x0000010000000080L,0x0000000000000408L});
	public static final BitSet FOLLOW_rel_in_order_clause3249 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_BY_in_order_clause3251 = new BitSet(new long[]{0x0940039004000000L,0x0040010000000080L,0x0000000000000408L});
	public static final BitSet FOLLOW_order_by_clause_in_order_clause3254 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_USING_in_order_clause3258 = new BitSet(new long[]{0x7779D022AE6E5F50L,0xFFA58E03D80C6E1DL,0x00020000000601F7L});
	public static final BitSet FOLLOW_func_clause_in_order_clause3261 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STAR_in_order_by_clause3273 = new BitSet(new long[]{0x0000000080000202L});
	public static final BitSet FOLLOW_order_col_list_in_order_by_clause3304 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_order_col_in_order_col_list3313 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_COMMA_in_order_col_list3317 = new BitSet(new long[]{0x0940039004000000L,0x0000010000000080L,0x0000000000000408L});
	public static final BitSet FOLLOW_order_col_in_order_col_list3319 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_col_range_in_order_col3350 = new BitSet(new long[]{0x0000000080000202L});
	public static final BitSet FOLLOW_col_ref_in_order_col3373 = new BitSet(new long[]{0x0000000080000202L});
	public static final BitSet FOLLOW_LEFT_PAREN_in_order_col3398 = new BitSet(new long[]{0x0940031004000000L,0x0000010000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_col_ref_in_order_col3401 = new BitSet(new long[]{0x0000000080000200L,0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_order_col3414 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DISTINCT_in_distinct_clause3424 = new BitSet(new long[]{0x0900030004000080L,0x0000010000000080L,0x0000000000000408L});
	public static final BitSet FOLLOW_rel_in_distinct_clause3427 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
	public static final BitSet FOLLOW_partition_clause_in_distinct_clause3429 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PARTITION_in_partition_clause3439 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_BY_in_partition_clause3442 = new BitSet(new long[]{0x7779D022AE6E5F50L,0xFFA58E03D80C6E1DL,0x00020000000601F7L});
	public static final BitSet FOLLOW_func_name_in_partition_clause3445 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rel_in_rel_list3454 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_COMMA_in_rel_list3458 = new BitSet(new long[]{0x0900030004000080L,0x0000010000000080L,0x0000000000000408L});
	public static final BitSet FOLLOW_rel_in_rel_list3460 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_CROSS_in_cross_clause3477 = new BitSet(new long[]{0x0900030004000080L,0x0000010000000080L,0x0000000000000408L});
	public static final BitSet FOLLOW_rel_list_in_cross_clause3480 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
	public static final BitSet FOLLOW_partition_clause_in_cross_clause3482 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_JOIN_in_join_clause3493 = new BitSet(new long[]{0x0900030004000080L,0x0000010000000080L,0x0000000000000408L});
	public static final BitSet FOLLOW_join_sub_clause_in_join_clause3496 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_USING_in_join_clause3500 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_join_type_in_join_clause3503 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
	public static final BitSet FOLLOW_partition_clause_in_join_clause3508 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QUOTEDSTRING_in_join_type3518 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_join_item_in_join_sub_clause3527 = new BitSet(new long[]{0x0010000001000000L,0x0000080000000010L});
	public static final BitSet FOLLOW_set_in_join_sub_clause3533 = new BitSet(new long[]{0x0000000001000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_OUTER_in_join_sub_clause3547 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_COMMA_in_join_sub_clause3550 = new BitSet(new long[]{0x0900030004000080L,0x0000010000000080L,0x0000000000000408L});
	public static final BitSet FOLLOW_join_item_in_join_sub_clause3553 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_join_sub_clause3563 = new BitSet(new long[]{0x0900030004000080L,0x0000010000000080L,0x0000000000000408L});
	public static final BitSet FOLLOW_join_item_in_join_sub_clause3566 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_rel_in_join_item3582 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_join_group_by_clause_in_join_item3584 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BY_in_join_group_by_clause3643 = new BitSet(new long[]{0xBF7C53D2AE7EF750L,0xFFE58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_real_arg_in_join_group_by_clause3646 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UNION_in_union_clause3655 = new BitSet(new long[]{0x0900030004000080L,0x0000010004000080L,0x0000000000000408L});
	public static final BitSet FOLLOW_ONSCHEMA_in_union_clause3658 = new BitSet(new long[]{0x0900030004000080L,0x0000010000000080L,0x0000000000000408L});
	public static final BitSet FOLLOW_rel_list_in_union_clause3661 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CUBE_in_cube_clause3670 = new BitSet(new long[]{0x0900030004000080L,0x0000010000000080L,0x0000000000000408L});
	public static final BitSet FOLLOW_rel_in_cube_clause3672 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_BY_in_cube_clause3674 = new BitSet(new long[]{0x0000000004000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_cube_rollup_list_in_cube_clause3676 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_COMMA_in_cube_clause3680 = new BitSet(new long[]{0x0000000004000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_cube_rollup_list_in_cube_clause3682 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_set_in_cube_rollup_list3713 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_LEFT_PAREN_in_cube_rollup_list3724 = new BitSet(new long[]{0xBF7C53D2AE7EF750L,0xFFE58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_real_arg_in_cube_rollup_list3727 = new BitSet(new long[]{0x0000000001000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_COMMA_in_cube_rollup_list3731 = new BitSet(new long[]{0xBF7C53D2AE7EF750L,0xFFE58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_real_arg_in_cube_rollup_list3734 = new BitSet(new long[]{0x0000000001000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_cube_rollup_list3739 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLATTEN_in_flatten_clause3749 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_LEFT_PAREN_in_flatten_clause3752 = new BitSet(new long[]{0xBF7C5352AE7EF750L,0xFFA58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_expr_in_flatten_clause3755 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_flatten_clause3757 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AS_in_generate_as_clause3770 = new BitSet(new long[]{0x490103200C255800L,0x0000010000002880L,0x0000000000000448L});
	public static final BitSet FOLLOW_LEFT_PAREN_in_generate_as_clause3777 = new BitSet(new long[]{0x490103200C255800L,0x00000100000028E0L,0x0000000000000448L});
	public static final BitSet FOLLOW_field_def_list_in_generate_as_clause3780 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_generate_as_clause3782 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_explicit_field_def_in_generate_as_clause3789 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_flatten_clause_in_flatten_generated_item3800 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_generate_as_clause_in_flatten_generated_item3802 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_real_arg_in_flatten_generated_item3830 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_generate_as_clause_in_flatten_generated_item3832 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_real_arg3847 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STAR_in_real_arg3860 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_col_range_in_real_arg3873 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_and_cond_in_cond3882 = new BitSet(new long[]{0x0000000000000002L,0x0000000008000000L});
	public static final BitSet FOLLOW_OR_in_cond3887 = new BitSet(new long[]{0xBF7C5352AE7EF750L,0xFFA58F83D80CD6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_and_cond_in_cond3890 = new BitSet(new long[]{0x0000000000000002L,0x0000000008000000L});
	public static final BitSet FOLLOW_not_cond_in_and_cond3902 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_AND_in_and_cond3906 = new BitSet(new long[]{0xBF7C5352AE7EF750L,0xFFA58F83D80CD6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_not_cond_in_and_cond3909 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_NOT_in_not_cond3921 = new BitSet(new long[]{0xBF7C5352AE7EF750L,0xFFA58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_unary_cond_in_not_cond3925 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_unary_cond3955 = new BitSet(new long[]{0x0800000000000002L,0xF000000003F00004L,0x0000000000000007L});
	public static final BitSet FOLLOW_IS_in_unary_cond3969 = new BitSet(new long[]{0x0000000000000000L,0x00000000000C0000L});
	public static final BitSet FOLLOW_NOT_in_unary_cond3971 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
	public static final BitSet FOLLOW_NULL_in_unary_cond3974 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IN_in_unary_cond4004 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_LEFT_PAREN_in_unary_cond4006 = new BitSet(new long[]{0xBF7C5352AE7EF750L,0xFFA58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_rhs_operand_in_unary_cond4010 = new BitSet(new long[]{0x0000000001000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_COMMA_in_unary_cond4014 = new BitSet(new long[]{0xBF7C5352AE7EF750L,0xFFA58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_rhs_operand_in_unary_cond4016 = new BitSet(new long[]{0x0000000001000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_unary_cond4023 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rel_op_in_unary_cond4064 = new BitSet(new long[]{0xBF7C5352AE7EF750L,0xFFA58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_expr_in_unary_cond4070 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_rhs_operand4119 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multi_expr_in_expr4128 = new BitSet(new long[]{0x0000000000000002L,0x0000001000008000L});
	public static final BitSet FOLLOW_set_in_expr4132 = new BitSet(new long[]{0xBF7C5352AE7EF750L,0xFFA58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_multi_expr_in_expr4143 = new BitSet(new long[]{0x0000000000000002L,0x0000001000008000L});
	public static final BitSet FOLLOW_cast_expr_in_multi_expr4155 = new BitSet(new long[]{0x0000000400000002L,0x0040000400000000L});
	public static final BitSet FOLLOW_set_in_multi_expr4159 = new BitSet(new long[]{0xBF7C5352AE7EF750L,0xFFA58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_cast_expr_in_multi_expr4174 = new BitSet(new long[]{0x0000000400000002L,0x0040000400000000L});
	public static final BitSet FOLLOW_set_in_func_name_suffix4188 = new BitSet(new long[]{0x7779D022AE6E5F50L,0xFFA58E03D80C6E1DL,0x00020000000601F7L});
	public static final BitSet FOLLOW_eid_in_func_name_suffix4198 = new BitSet(new long[]{0x0000000800000002L,0x0000000800000000L});
	public static final BitSet FOLLOW_scalar_in_cast_expr4233 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_cast_expr4247 = new BitSet(new long[]{0xBF7C5352AE7EF750L,0xFFA58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_cast_expr_in_cast_expr4249 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_col_ref_without_identifier_in_cast_expr4306 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_projection_in_cast_expr4308 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_invoker_func_in_cast_expr4323 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_projection_in_cast_expr4325 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_identifier_plus_in_cast_expr4340 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_projection_in_cast_expr4342 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_identifier_plus_in_cast_expr4357 = new BitSet(new long[]{0x0000000800000000L,0x0000000800000080L});
	public static final BitSet FOLLOW_func_name_suffix_in_cast_expr4359 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_LEFT_PAREN_in_cast_expr4362 = new BitSet(new long[]{0xBF7C53D2AE7EF750L,0xFFE5CF83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_real_arg_in_cast_expr4366 = new BitSet(new long[]{0x0000000001000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_COMMA_in_cast_expr4370 = new BitSet(new long[]{0xBF7C53D2AE7EF750L,0xFFE58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_real_arg_in_cast_expr4372 = new BitSet(new long[]{0x0000000001000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_cast_expr4380 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_projection_in_cast_expr4382 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_func_name_without_columns_in_cast_expr4416 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_LEFT_PAREN_in_cast_expr4418 = new BitSet(new long[]{0xBF7C53D2AE7EF750L,0xFFE5CF83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_real_arg_in_cast_expr4422 = new BitSet(new long[]{0x0000000001000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_COMMA_in_cast_expr4426 = new BitSet(new long[]{0xBF7C53D2AE7EF750L,0xFFE58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_real_arg_in_cast_expr4428 = new BitSet(new long[]{0x0000000001000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_cast_expr4436 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_projection_in_cast_expr4438 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_CASE_in_cast_expr4469 = new BitSet(new long[]{0xBF7C5352AE7EF750L,0xFFA58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_WHEN_in_cast_expr4478 = new BitSet(new long[]{0xBF7C5352AE7EF750L,0xFFA58F83D80CD6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_cond_in_cast_expr4480 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_THEN_in_cast_expr4482 = new BitSet(new long[]{0xBF7C5352AE7EF750L,0xFFA58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_expr_in_cast_expr4484 = new BitSet(new long[]{0x0000030000000000L,0x0000000000000000L,0x0000000000000400L});
	public static final BitSet FOLLOW_WHEN_in_cast_expr4488 = new BitSet(new long[]{0xBF7C5352AE7EF750L,0xFFA58F83D80CD6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_cond_in_cast_expr4490 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_THEN_in_cast_expr4492 = new BitSet(new long[]{0xBF7C5352AE7EF750L,0xFFA58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_expr_in_cast_expr4494 = new BitSet(new long[]{0x0000030000000000L,0x0000000000000000L,0x0000000000000400L});
	public static final BitSet FOLLOW_ELSE_in_cast_expr4501 = new BitSet(new long[]{0xBF7C5352AE7EF750L,0xFFA58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_expr_in_cast_expr4503 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_END_in_cast_expr4508 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_projection_in_cast_expr4510 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_expr_in_cast_expr4557 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000400L});
	public static final BitSet FOLLOW_WHEN_in_cast_expr4559 = new BitSet(new long[]{0xBF7C5352AE7EF750L,0xFFA58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_rhs_operand_in_cast_expr4561 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_THEN_in_cast_expr4563 = new BitSet(new long[]{0xBF7C5352AE7EF750L,0xFFA58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_rhs_operand_in_cast_expr4565 = new BitSet(new long[]{0x0000030000000000L,0x0000000000000000L,0x0000000000000400L});
	public static final BitSet FOLLOW_WHEN_in_cast_expr4569 = new BitSet(new long[]{0xBF7C5352AE7EF750L,0xFFA58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_rhs_operand_in_cast_expr4571 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_THEN_in_cast_expr4573 = new BitSet(new long[]{0xBF7C5352AE7EF750L,0xFFA58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_rhs_operand_in_cast_expr4575 = new BitSet(new long[]{0x0000030000000000L,0x0000000000000000L,0x0000000000000400L});
	public static final BitSet FOLLOW_ELSE_in_cast_expr4582 = new BitSet(new long[]{0xBF7C5352AE7EF750L,0xFFA58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_rhs_operand_in_cast_expr4584 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_END_in_cast_expr4589 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_projection_in_cast_expr4591 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_paren_expr_in_cast_expr4666 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_curly_expr_in_cast_expr4680 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_bracket_expr_in_cast_expr4694 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INVOKE_in_invoker_func4708 = new BitSet(new long[]{0x0000000000000020L,0x0000000000000080L});
	public static final BitSet FOLLOW_AMPERSAND_in_invoker_func4712 = new BitSet(new long[]{0x0900030004000000L,0x0000010000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_LEFT_PAREN_in_invoker_func4716 = new BitSet(new long[]{0xBF7C53D2AE7EF750L,0xFFE58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_real_arg_in_invoker_func4718 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_invoker_func4722 = new BitSet(new long[]{0x0900030004000000L,0x0000010000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_identifier_plus_in_invoker_func4730 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_PERIOD_in_invoker_func4732 = new BitSet(new long[]{0x0900030004000000L,0x0000010000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_identifier_plus_in_invoker_func4741 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_LEFT_PAREN_in_invoker_func4745 = new BitSet(new long[]{0xBF7C53D2AE7EF750L,0xFFE5CF83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_real_arg_in_invoker_func4749 = new BitSet(new long[]{0x0000000001000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_COMMA_in_invoker_func4753 = new BitSet(new long[]{0xBF7C53D2AE7EF750L,0xFFE58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_real_arg_in_invoker_func4755 = new BitSet(new long[]{0x0000000001000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_invoker_func4763 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFT_PAREN_in_paren_expr4830 = new BitSet(new long[]{0xFF7D53F2AE7FFF50L,0xFFE5CF83D80CFEFFL,0x00020000000605FFL});
	public static final BitSet FOLLOW_try_implicit_map_cast_in_paren_expr4833 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_implicit_map_type_in_try_implicit_map_cast4936 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_try_implicit_map_cast4938 = new BitSet(new long[]{0xBF7C5352AE7EF750L,0xFFA58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_cast_expr_in_try_implicit_map_cast4940 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_after_left_paren_in_try_implicit_map_cast4967 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_explicit_type_cast_in_after_left_paren4976 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_after_left_paren4978 = new BitSet(new long[]{0xBF7C5352AE7EF750L,0xFFA58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_cast_expr_in_after_left_paren4980 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_after_left_paren5031 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_projection_in_after_left_paren5033 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_STAR_in_after_left_paren5066 = new BitSet(new long[]{0x0000000001000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_COMMA_in_after_left_paren5070 = new BitSet(new long[]{0xBF7C53D2AE7EF750L,0xFFE58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_real_arg_in_after_left_paren5072 = new BitSet(new long[]{0x0000000001000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_after_left_paren5077 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_projection_in_after_left_paren5079 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_col_range_in_after_left_paren5119 = new BitSet(new long[]{0x0000000001000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_COMMA_in_after_left_paren5123 = new BitSet(new long[]{0xBF7C53D2AE7EF750L,0xFFE58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_real_arg_in_after_left_paren5125 = new BitSet(new long[]{0x0000000001000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_after_left_paren5130 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_projection_in_after_left_paren5132 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_cond_in_after_left_paren5244 = new BitSet(new long[]{0x0000000001000000L,0x0000404000000000L});
	public static final BitSet FOLLOW_COMMA_in_after_left_paren5271 = new BitSet(new long[]{0xBF7C53D2AE7EF750L,0xFFE58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_real_arg_in_after_left_paren5273 = new BitSet(new long[]{0x0000000001000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_after_left_paren5278 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_projection_in_after_left_paren5280 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_after_left_paren5326 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QMARK_in_after_left_paren5363 = new BitSet(new long[]{0xBF7C5352AE7EF750L,0xFFA58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_expr_in_after_left_paren5369 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_COLON_in_after_left_paren5371 = new BitSet(new long[]{0xBF7C5352AE7EF750L,0xFFA58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_expr_in_after_left_paren5377 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_after_left_paren5379 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFT_CURLY_in_curly_expr5408 = new BitSet(new long[]{0xBF7C53D2AE7EF750L,0xFFE58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_real_arg_in_curly_expr5410 = new BitSet(new long[]{0x0000000001000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_COMMA_in_curly_expr5414 = new BitSet(new long[]{0xBF7C53D2AE7EF750L,0xFFE58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_real_arg_in_curly_expr5416 = new BitSet(new long[]{0x0000000001000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_RIGHT_CURLY_in_curly_expr5421 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_projection_in_curly_expr5423 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_LEFT_CURLY_in_curly_expr5455 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_RIGHT_CURLY_in_curly_expr5457 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_projection_in_curly_expr5459 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_LEFT_BRACKET_in_bracket_expr5480 = new BitSet(new long[]{0xBF7C53D2AE7EF750L,0xFFE58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_real_arg_in_bracket_expr5482 = new BitSet(new long[]{0x0000000001000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_COMMA_in_bracket_expr5486 = new BitSet(new long[]{0xBF7C53D2AE7EF750L,0xFFE58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_real_arg_in_bracket_expr5488 = new BitSet(new long[]{0x0000000001000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_RIGHT_BRACKET_in_bracket_expr5493 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_projection_in_bracket_expr5495 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_LEFT_BRACKET_in_bracket_expr5529 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_keyvalue_in_bracket_expr5531 = new BitSet(new long[]{0x0000000001000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_COMMA_in_bracket_expr5535 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_keyvalue_in_bracket_expr5537 = new BitSet(new long[]{0x0000000001000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_RIGHT_BRACKET_in_bracket_expr5542 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_projection_in_bracket_expr5544 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_LEFT_BRACKET_in_bracket_expr5576 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_RIGHT_BRACKET_in_bracket_expr5578 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_projection_in_bracket_expr5580 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_PERIOD_in_projection5601 = new BitSet(new long[]{0x0940031004000000L,0x0000010000000080L,0x0000000000000408L});
	public static final BitSet FOLLOW_col_ref_in_projection5605 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFT_PAREN_in_projection5609 = new BitSet(new long[]{0x0940031004000000L,0x0000010000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_col_ref_in_projection5611 = new BitSet(new long[]{0x0000000001000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_COMMA_in_projection5615 = new BitSet(new long[]{0x0940031004000000L,0x0000010000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_col_ref_in_projection5617 = new BitSet(new long[]{0x0000000001000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_projection5622 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_POUND_in_projection5650 = new BitSet(new long[]{0x0000000000000000L,0x0000008000080000L});
	public static final BitSet FOLLOW_set_in_projection5653 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_col_ref_without_identifier_in_col_ref5686 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_plus_in_col_ref5690 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_col_ref_in_col_range5703 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_DOUBLE_PERIOD_in_col_range5705 = new BitSet(new long[]{0x0940031004000002L,0x0000010000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_col_ref_in_col_range5711 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLE_PERIOD_in_col_range5742 = new BitSet(new long[]{0x0940031004000000L,0x0000010000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_col_ref_in_col_range5744 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QUOTEDSTRING_in_keyvalue5871 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
	public static final BitSet FOLLOW_POUND_in_keyvalue5873 = new BitSet(new long[]{0x800410400000A000L,0x00000080000810E0L,0x0000000000000020L});
	public static final BitSet FOLLOW_literal_in_keyvalue5875 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFT_BRACKET_in_literal_map5896 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_keyvalue_in_literal_map5898 = new BitSet(new long[]{0x0000000001000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_COMMA_in_literal_map5902 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_keyvalue_in_literal_map5904 = new BitSet(new long[]{0x0000000001000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_RIGHT_BRACKET_in_literal_map5909 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFT_BRACKET_in_literal_map5936 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_RIGHT_BRACKET_in_literal_map5938 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFT_CURLY_in_literal_bag5956 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_literal_tuple_in_literal_bag5958 = new BitSet(new long[]{0x0000000001000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_COMMA_in_literal_bag5962 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_literal_tuple_in_literal_bag5964 = new BitSet(new long[]{0x0000000001000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_RIGHT_CURLY_in_literal_bag5969 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFT_CURLY_in_literal_bag5996 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_RIGHT_CURLY_in_literal_bag5998 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFT_PAREN_in_literal_tuple6015 = new BitSet(new long[]{0x800410400000A000L,0x00000080000810E0L,0x0000000000000020L});
	public static final BitSet FOLLOW_literal_in_literal_tuple6017 = new BitSet(new long[]{0x0000000001000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_COMMA_in_literal_tuple6021 = new BitSet(new long[]{0x800410400000A000L,0x00000080000810E0L,0x0000000000000020L});
	public static final BitSet FOLLOW_literal_in_literal_tuple6023 = new BitSet(new long[]{0x0000000001000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_literal_tuple6028 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFT_PAREN_in_literal_tuple6057 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_literal_tuple6059 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_scalar_in_literal6076 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_literal_map_in_literal6080 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_literal_bag_in_literal6084 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_literal_tuple_in_literal6088 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nested_command_in_nested_blk6101 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_SEMI_COLON_in_nested_blk6103 = new BitSet(new long[]{0x0920030004000000L,0x0000010000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_GENERATE_in_nested_blk6108 = new BitSet(new long[]{0xBF7CD3D2AE7EF750L,0xFFE58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_flatten_generated_item_in_nested_blk6110 = new BitSet(new long[]{0x0000000001000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_COMMA_in_nested_blk6114 = new BitSet(new long[]{0xBF7CD3D2AE7EF750L,0xFFE58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_flatten_generated_item_in_nested_blk6116 = new BitSet(new long[]{0x0000000001000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_SEMI_COLON_in_nested_blk6121 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_plus_in_nested_command6168 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_EQUAL_in_nested_command6170 = new BitSet(new long[]{0x0940031004000000L,0x0000010000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_nested_proj_in_nested_command6172 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_plus_in_nested_command6219 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_EQUAL_in_nested_command6221 = new BitSet(new long[]{0xBF7C5352AE7EF750L,0xFFA58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_expr_in_nested_command6223 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_plus_in_nested_command6268 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_EQUAL_in_nested_command6270 = new BitSet(new long[]{0x0008400202000000L,0x0000000010000200L});
	public static final BitSet FOLLOW_nested_op_in_nested_command6272 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nested_filter_in_nested_op6307 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nested_sort_in_nested_op6321 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nested_distinct_in_nested_op6335 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nested_limit_in_nested_op6349 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nested_cross_in_nested_op6363 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nested_foreach_in_nested_op6377 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_col_ref_in_nested_proj6386 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_PERIOD_in_nested_proj6388 = new BitSet(new long[]{0x0940031004000000L,0x0000010000000080L,0x0000000000000408L});
	public static final BitSet FOLLOW_col_ref_list_in_nested_proj6390 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_col_ref_in_col_ref_list6424 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFT_PAREN_in_col_ref_list6430 = new BitSet(new long[]{0x0940031004000000L,0x0000010000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_col_ref_in_col_ref_list6432 = new BitSet(new long[]{0x0000000001000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_COMMA_in_col_ref_list6436 = new BitSet(new long[]{0x0940031004000000L,0x0000010000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_col_ref_in_col_ref_list6438 = new BitSet(new long[]{0x0000000001000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_col_ref_list6443 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FILTER_in_nested_filter6473 = new BitSet(new long[]{0x0940031004000000L,0x0000010000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_nested_op_input_in_nested_filter6476 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_BY_in_nested_filter6478 = new BitSet(new long[]{0xBF7C5352AE7EF750L,0xFFA58F83D80CD6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_cond_in_nested_filter6481 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ORDER_in_nested_sort6490 = new BitSet(new long[]{0x0940031004000000L,0x0000010000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_nested_op_input_in_nested_sort6493 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_BY_in_nested_sort6495 = new BitSet(new long[]{0x0940039004000000L,0x0040010000000080L,0x0000000000000408L});
	public static final BitSet FOLLOW_order_by_clause_in_nested_sort6499 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_USING_in_nested_sort6503 = new BitSet(new long[]{0x7779D022AE6E5F50L,0xFFA58E03D80C6E1DL,0x00020000000601F7L});
	public static final BitSet FOLLOW_func_clause_in_nested_sort6506 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DISTINCT_in_nested_distinct6518 = new BitSet(new long[]{0x0940031004000000L,0x0000010000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_nested_op_input_in_nested_distinct6521 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LIMIT_in_nested_limit6530 = new BitSet(new long[]{0x0940031004000000L,0x0000010000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_nested_op_input_in_nested_limit6533 = new BitSet(new long[]{0xBF7C5352AE7EF750L,0xFFA58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_INTEGER_in_nested_limit6545 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_nested_limit6549 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CROSS_in_nested_cross6560 = new BitSet(new long[]{0x0940031004000000L,0x0000010000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_nested_op_input_list_in_nested_cross6563 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOREACH_in_nested_foreach6571 = new BitSet(new long[]{0x0940031004000000L,0x0000010000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_nested_op_input_in_nested_foreach6573 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_GENERATE_in_nested_foreach6575 = new BitSet(new long[]{0xBF7CD3D2AE7EF750L,0xFFE58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_flatten_generated_item_in_nested_foreach6577 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_COMMA_in_nested_foreach6581 = new BitSet(new long[]{0xBF7CD3D2AE7EF750L,0xFFE58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_flatten_generated_item_in_nested_foreach6583 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_col_ref_in_nested_op_input6618 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nested_proj_in_nested_op_input6622 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nested_op_input_in_nested_op_input_list6631 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_COMMA_in_nested_op_input_list6635 = new BitSet(new long[]{0x0940031004000000L,0x0000010000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_nested_op_input_in_nested_op_input_list6637 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_rel_str_op_in_eid_without_columns6665 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IMPORT_in_eid_without_columns6673 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_REGISTER_in_eid_without_columns6681 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RETURNS_in_eid_without_columns6689 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DEFINE_in_eid_without_columns6697 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LOAD_in_eid_without_columns6705 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FILTER_in_eid_without_columns6713 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOREACH_in_eid_without_columns6721 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ROLLUP_in_eid_without_columns6729 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ORDER_in_eid_without_columns6737 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DISTINCT_in_eid_without_columns6745 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COGROUP_in_eid_without_columns6753 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_JOIN_in_eid_without_columns6761 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CROSS_in_eid_without_columns6769 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UNION_in_eid_without_columns6777 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SPLIT_in_eid_without_columns6785 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTO_in_eid_without_columns6793 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_eid_without_columns6801 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ALL_in_eid_without_columns6809 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AS_in_eid_without_columns6817 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BY_in_eid_without_columns6825 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_USING_in_eid_without_columns6833 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INNER_in_eid_without_columns6841 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OUTER_in_eid_without_columns6849 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PARALLEL_in_eid_without_columns6857 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PARTITION_in_eid_without_columns6865 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AND_in_eid_without_columns6873 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OR_in_eid_without_columns6881 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GENERATE_in_eid_without_columns6889 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASC_in_eid_without_columns6897 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DESC_in_eid_without_columns6905 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOL_in_eid_without_columns6913 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BIGINTEGER_in_eid_without_columns6921 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BIGDECIMAL_in_eid_without_columns6929 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DATETIME_in_eid_without_columns6937 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHARARRAY_in_eid_without_columns6945 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BYTEARRAY_in_eid_without_columns6953 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IS_in_eid_without_columns6961 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STREAM_in_eid_without_columns6969 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_THROUGH_in_eid_without_columns6977 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STORE_in_eid_without_columns6985 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAPREDUCE_in_eid_without_columns6993 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHIP_in_eid_without_columns7001 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CACHE_in_eid_without_columns7009 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INPUT_in_eid_without_columns7017 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OUTPUT_in_eid_without_columns7025 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STDERROR_in_eid_without_columns7033 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STDIN_in_eid_without_columns7041 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STDOUT_in_eid_without_columns7049 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LIMIT_in_eid_without_columns7057 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SAMPLE_in_eid_without_columns7065 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFT_in_eid_without_columns7073 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RIGHT_in_eid_without_columns7081 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FULL_in_eid_without_columns7089 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_REALIAS_in_eid_without_columns7097 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOL_COND_in_eid_without_columns7105 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSERT_in_eid_without_columns7113 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_eid_without_columns_in_eid7122 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_eid7130 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GROUP_in_eid7138 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CUBE_in_eid7146 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_eid7154 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_eid7162 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_eid7170 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LONG_in_eid7178 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOAT_in_eid7186 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLE_in_eid7194 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NULL_in_eid7202 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_eid7210 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLATTEN_in_eid7218 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BAG_in_eid7226 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TUPLE_in_eid7234 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAP_in_eid7242 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rel_str_op_in_rel_op7252 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUM_OP_EQ_in_rel_op7263 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUM_OP_NE_in_rel_op7274 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUM_OP_GT_in_rel_op7285 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUM_OP_GTE_in_rel_op7296 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUM_OP_LT_in_rel_op7307 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUM_OP_LTE_in_rel_op7318 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHEN_in_synpred1_QueryParser4474 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_implicit_map_type_in_synpred2_QueryParser4927 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_synpred2_QueryParser4929 = new BitSet(new long[]{0xBF7C5352AE7EF750L,0xFFA58F83D808D6FFL,0x00020000000605BFL});
	public static final BitSet FOLLOW_cast_expr_in_synpred2_QueryParser4931 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_plus_in_synpred3_QueryParser6150 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_EQUAL_in_synpred3_QueryParser6152 = new BitSet(new long[]{0x0940031004000000L,0x0000010000000000L,0x0000000000000408L});
	public static final BitSet FOLLOW_col_ref_in_synpred3_QueryParser6154 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_PERIOD_in_synpred3_QueryParser6156 = new BitSet(new long[]{0x0940031004000000L,0x0000010000000080L,0x0000000000000408L});
	public static final BitSet FOLLOW_col_ref_list_in_synpred3_QueryParser6158 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_synpred4_QueryParser6538 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_SEMI_COLON_in_synpred4_QueryParser6540 = new BitSet(new long[]{0x0000000000000002L});
}
