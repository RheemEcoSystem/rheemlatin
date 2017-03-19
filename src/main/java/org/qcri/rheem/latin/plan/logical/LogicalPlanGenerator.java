// $ANTLR 3.5.2 src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g 2017-03-09 11:17:21

package org.qcri.rheem.latin.plan.logical;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.qcri.rheem.latin.exception.FrontendException;
import org.qcri.rheem.latin.exception.ParserValidationException;
import org.qcri.rheem.latin.exception.PlanGenerationFailureException;
import org.qcri.rheem.latin.exception.UndefinedAliasException;
import org.qcri.rheem.latin.parser.LatinParserNode;
import org.qcri.rheem.latin.plan.Operator;
import org.qcri.rheem.latin.plan.logical.LogicalSchema.LogicalFieldSchema;
import org.qcri.rheem.latin.plan.operator.expression.LogicalExpression;
import org.qcri.rheem.latin.plan.operator.expression.LogicalExpressionPlan;
import org.qcri.rheem.latin.plan.operator.expression.ProjectExpression;
import org.qcri.rheem.latin.plan.operator.expression.le.*;
import org.qcri.rheem.latin.plan.operator.relational.LogicalRelationalOperator;
import org.qcri.rheem.latin.plan.operator.relational.lo.*;
import org.qcri.rheem.latin.plan.operator.relational.lo.LOCogroup.GROUPTYPE;
import org.qcri.rheem.latin.plan.operator.relational.lo.LOJoin.JOINTYPE;
import org.qcri.rheem.latin.util.*;
import org.qcri.rheem.latin.util.StreamingCommand.HandleSpec;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;


/**
 * Grammar file for Pig tree parser (for schema alias validation).
 *
 * NOTE: THIS FILE IS BASED ON QueryParser.g, SO IF YOU CHANGE THAT FILE, YOU WILL
 *       PROBABLY NEED TO MAKE CORRESPONDING CHANGES TO THIS FILE AS WELL.
 */
@SuppressWarnings("all")
public class LogicalPlanGenerator extends TreeParser {
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
		"TOBAG", "TOMAP", "TOTUPLE", "TUPLE_TYPE", "TUPLE_TYPE_CAST", "TUPLE_VAL", 
		"EVAL", "MATCHES"
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
	public static final int EVAL=187;
	public static final int MATCHES=188;

	// delegates
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators

	protected static class GScope_scope {
		LogicalRelationalOperator currentOp;
	}
	protected Stack<GScope_scope> GScope_stack = new Stack<GScope_scope>();


	public LogicalPlanGenerator(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
        this.state.backtracking = 0;
	}
	public LogicalPlanGenerator(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return LogicalPlanGenerator.tokenNames; }
	@Override public String getGrammarFileName() { return "src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g"; }


	private static Log log = LogFactory.getLog( LogicalPlanGenerator.class );

	private LogicalPlanBuilder builder = null;

	private boolean inForeachPlan = false;

	private boolean inNestedCommand = false;

	public LogicalPlan getLogicalPlan() {
	    return builder.getPlan();
	}

	public Map<String, Operator> getOperators() {
	    return builder.getOperators();
	}

	public String getLastRel() {
	    return builder.getLastRel();
	}

	@Override
	protected Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow)
	throws RecognitionException {
	  //  throw new MismatchedTokenException( ttype, input );
	    return null;
	}

	@Override
	public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow)
	throws RecognitionException {
	    throw e;
	}

	public LogicalPlanGenerator(TreeNodeStream input, LogicalPlanBuilder builder) {
	    this(input, new RecognizerSharedState());
	    this.builder = builder;
	}

	public LogicalPlanGenerator(TreeNodeStream input, LatinContext latinContext, String scope,
	    Map<String, String> fileNameMap) {
	    this( input );
	    builder = new LogicalPlanBuilder( latinContext, scope, fileNameMap, input );
	}



	public static class query_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "query"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:159:1: query : ^( QUERY ( statement )* ) ;
	public final LogicalPlanGenerator.query_return query() throws RecognitionException {
		LogicalPlanGenerator.query_return retval = new LogicalPlanGenerator.query_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree QUERY1=null;
		TreeRuleReturnScope statement2 =null;

		CommonTree QUERY1_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:159:7: ( ^( QUERY ( statement )* ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:159:9: ^( QUERY ( statement )* )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			QUERY1=(CommonTree)match(input,QUERY,FOLLOW_QUERY_in_query87); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			QUERY1_tree = (CommonTree)adaptor.dupNode(QUERY1);


			root_1 = (CommonTree)adaptor.becomeRoot(QUERY1_tree, root_1);
			}

			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); if (state.failed) return retval;
				// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:159:18: ( statement )*
				loop1:
				while (true) {
					int alt1=2;
					int LA1_0 = input.LA(1);
					if ( (LA1_0==ASSERT||LA1_0==REGISTER||LA1_0==SPLIT||LA1_0==REALIAS||LA1_0==STATEMENT) ) {
						alt1=1;
					}

					switch (alt1) {
					case 1 :
						// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:159:18: statement
						{
						_last = (CommonTree)input.LT(1);
						pushFollow(FOLLOW_statement_in_query89);
						statement2=statement();
						state._fsp--;
						if (state.failed) return retval;
						if ( state.backtracking==0 ) 
						adaptor.addChild(root_1, statement2.getTree());

						if ( state.backtracking==0 ) {
						}

						}
						break;

					default :
						break loop1;
					}
				}

				match(input, Token.UP, null); if (state.failed) return retval;
			}
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	protected static class statement_scope {
		String alias;
		Integer parallel;
		String inputAlias;
		int inputIndex;
	}
	protected Stack<statement_scope> statement_stack = new Stack<statement_scope>();

	public static class statement_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "statement"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:162:1: statement : ( general_statement | split_statement | realias_statement | assert_statement | register_statement );
	public final LogicalPlanGenerator.statement_return statement() throws RecognitionException {
	    statement_stack.push(new statement_scope());
		LogicalPlanGenerator.statement_return retval = new LogicalPlanGenerator.statement_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope general_statement3 =null;
		TreeRuleReturnScope split_statement4 =null;
		TreeRuleReturnScope realias_statement5 =null;
		TreeRuleReturnScope assert_statement6 =null;
		TreeRuleReturnScope register_statement7 =null;



		    statement_stack.peek().inputIndex = 0;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:173:2: ( general_statement | split_statement | realias_statement | assert_statement | register_statement )
			int alt2=5;
			switch ( input.LA(1) ) {
			case STATEMENT:
				{
				alt2=1;
				}
				break;
			case SPLIT:
				{
				alt2=2;
				}
				break;
			case REALIAS:
				{
				alt2=3;
				}
				break;
			case ASSERT:
				{
				alt2=4;
				}
				break;
			case REGISTER:
				{
				alt2=5;
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
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:173:4: general_statement
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_general_statement_in_statement111);
					general_statement3=general_statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, general_statement3.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:174:4: split_statement
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_split_statement_in_statement116);
					split_statement4=split_statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, split_statement4.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:175:4: realias_statement
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_realias_statement_in_statement121);

					realias_statement5=realias_statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, realias_statement5.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 4 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:176:4: assert_statement
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_assert_statement_in_statement126);
					assert_statement6=assert_statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, assert_statement6.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 5 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:177:4: register_statement
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_register_statement_in_statement131);
					register_statement7=register_statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, register_statement7.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;

			}
			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			}

		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
			statement_stack.pop();
		}
		return retval;
	}
	// $ANTLR end "statement"


	public static class split_statement_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "split_statement"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:180:1: split_statement : split_clause ;
	public final LogicalPlanGenerator.split_statement_return split_statement() throws RecognitionException {
		LogicalPlanGenerator.split_statement_return retval = new LogicalPlanGenerator.split_statement_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope split_clause8 =null;


		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:180:17: ( split_clause )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:180:19: split_clause
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_split_clause_in_split_statement140);
			split_clause8=split_clause();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_0, split_clause8.getTree());

			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "split_statement"


	public static class realias_statement_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "realias_statement"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:183:1: realias_statement : realias_clause ;
	public final LogicalPlanGenerator.realias_statement_return realias_statement() throws RecognitionException {
		LogicalPlanGenerator.realias_statement_return retval = new LogicalPlanGenerator.realias_statement_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope realias_clause9 =null;


		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:183:19: ( realias_clause )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:183:21: realias_clause
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_realias_clause_in_realias_statement149);
			realias_clause9=realias_clause();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_0, realias_clause9.getTree());

			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "realias_statement"


	public static class assert_statement_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "assert_statement"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:186:1: assert_statement : assert_clause ;
	public final LogicalPlanGenerator.assert_statement_return assert_statement() throws RecognitionException {
		LogicalPlanGenerator.assert_statement_return retval = new LogicalPlanGenerator.assert_statement_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope assert_clause10 =null;


		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:186:18: ( assert_clause )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:186:20: assert_clause
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_assert_clause_in_assert_statement158);
			assert_clause10=assert_clause();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_0, assert_clause10.getTree());

			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "assert_statement"


	public static class register_statement_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "register_statement"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:189:1: register_statement : ^( REGISTER QUOTEDSTRING ( USING IDENTIFIER AS IDENTIFIER )? ) ;
	public final LogicalPlanGenerator.register_statement_return register_statement() throws RecognitionException {
		LogicalPlanGenerator.register_statement_return retval = new LogicalPlanGenerator.register_statement_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree REGISTER11=null;
		CommonTree QUOTEDSTRING12=null;
		CommonTree USING13=null;
		CommonTree IDENTIFIER14=null;
		CommonTree AS15=null;
		CommonTree IDENTIFIER16=null;

		CommonTree REGISTER11_tree=null;
		CommonTree QUOTEDSTRING12_tree=null;
		CommonTree USING13_tree=null;
		CommonTree IDENTIFIER14_tree=null;
		CommonTree AS15_tree=null;
		CommonTree IDENTIFIER16_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:190:3: ( ^( REGISTER QUOTEDSTRING ( USING IDENTIFIER AS IDENTIFIER )? ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:190:3: ^( REGISTER QUOTEDSTRING ( USING IDENTIFIER AS IDENTIFIER )? )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			REGISTER11=(CommonTree)match(input,REGISTER,FOLLOW_REGISTER_in_register_statement169); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			REGISTER11_tree = (CommonTree)adaptor.dupNode(REGISTER11);


			root_1 = (CommonTree)adaptor.becomeRoot(REGISTER11_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			QUOTEDSTRING12=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_register_statement171); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			QUOTEDSTRING12_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING12);


			adaptor.addChild(root_1, QUOTEDSTRING12_tree);
			}

			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:190:28: ( USING IDENTIFIER AS IDENTIFIER )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==USING) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:190:29: USING IDENTIFIER AS IDENTIFIER
					{
					_last = (CommonTree)input.LT(1);
					USING13=(CommonTree)match(input,USING,FOLLOW_USING_in_register_statement174); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					USING13_tree = (CommonTree)adaptor.dupNode(USING13);


					adaptor.addChild(root_1, USING13_tree);
					}

					_last = (CommonTree)input.LT(1);
					IDENTIFIER14=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_register_statement176); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IDENTIFIER14_tree = (CommonTree)adaptor.dupNode(IDENTIFIER14);


					adaptor.addChild(root_1, IDENTIFIER14_tree);
					}

					_last = (CommonTree)input.LT(1);
					AS15=(CommonTree)match(input,AS,FOLLOW_AS_in_register_statement178); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					AS15_tree = (CommonTree)adaptor.dupNode(AS15);


					adaptor.addChild(root_1, AS15_tree);
					}

					_last = (CommonTree)input.LT(1);
					IDENTIFIER16=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_register_statement180); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IDENTIFIER16_tree = (CommonTree)adaptor.dupNode(IDENTIFIER16);


					adaptor.addChild(root_1, IDENTIFIER16_tree);
					}

					if ( state.backtracking==0 ) {
					}

					}
					break;

			}

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			    // registers are handled by QueryParserDriver and are not actually part of the logical plan
			    // so we just ignore them here
			  }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "register_statement"


	public static class general_statement_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "general_statement"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:197:1: general_statement : ^( STATEMENT ( alias )? oa= op_clause ( parallel_clause )? ) ;
	public final LogicalPlanGenerator.general_statement_return general_statement() throws RecognitionException {
		LogicalPlanGenerator.general_statement_return retval = new LogicalPlanGenerator.general_statement_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree STATEMENT17=null;
		TreeRuleReturnScope oa =null;
		TreeRuleReturnScope alias18 =null;
		TreeRuleReturnScope parallel_clause19 =null;

		CommonTree STATEMENT17_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:198:3: ( ^( STATEMENT ( alias )? oa= op_clause ( parallel_clause )? ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:198:3: ^( STATEMENT ( alias )? oa= op_clause ( parallel_clause )? )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			STATEMENT17=(CommonTree)match(input,STATEMENT,FOLLOW_STATEMENT_in_general_statement199); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			STATEMENT17_tree = (CommonTree)adaptor.dupNode(STATEMENT17);


			root_1 = (CommonTree)adaptor.becomeRoot(STATEMENT17_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:198:16: ( alias )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==IDENTIFIER) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:198:18: alias
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_alias_in_general_statement203);
					alias18=alias();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, alias18.getTree());

					if ( state.backtracking==0 ) { statement_stack.peek().alias = (alias18!=null?((LogicalPlanGenerator.alias_return)alias18).name:null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;

			}

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_op_clause_in_general_statement214);
			oa=op_clause();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, oa.getTree());

			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:198:79: ( parallel_clause )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==PARALLEL) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:198:79: parallel_clause
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_parallel_clause_in_general_statement216);
					parallel_clause19=parallel_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, parallel_clause19.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;

			}

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			      Operator op = builder.lookupOperator( (oa!=null?((LogicalPlanGenerator.op_clause_return)oa).alias:null) );
			      builder.setParallel( (LogicalRelationalOperator)op, statement_stack.peek().parallel );
			  }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class realias_clause_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "realias_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:205:1: realias_clause : ^( REALIAS alias IDENTIFIER ) ;
	public final LogicalPlanGenerator.realias_clause_return realias_clause() throws RecognitionException {
		LogicalPlanGenerator.realias_clause_return retval = new LogicalPlanGenerator.realias_clause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree REALIAS20=null;
		CommonTree IDENTIFIER22=null;
		TreeRuleReturnScope alias21 =null;

		CommonTree REALIAS20_tree=null;
		CommonTree IDENTIFIER22_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:206:3: ( ^( REALIAS alias IDENTIFIER ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:206:3: ^( REALIAS alias IDENTIFIER )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			REALIAS20=(CommonTree)match(input,REALIAS,FOLLOW_REALIAS_in_realias_clause233); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			REALIAS20_tree = (CommonTree)adaptor.dupNode(REALIAS20);


			root_1 = (CommonTree)adaptor.becomeRoot(REALIAS20_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_alias_in_realias_clause235);
			alias21=alias();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, alias21.getTree());

			_last = (CommonTree)input.LT(1);
			IDENTIFIER22=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_realias_clause237); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			IDENTIFIER22_tree = (CommonTree)adaptor.dupNode(IDENTIFIER22);


			adaptor.addChild(root_1, IDENTIFIER22_tree);
			}

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
				    Operator op = builder.lookupOperator( (IDENTIFIER22!=null?IDENTIFIER22.getText():null) );
				    if (op==null) {
				        throw new UndefinedAliasException(input,
				            new SourceLocation( (LatinParserNode)IDENTIFIER22 ), (IDENTIFIER22!=null?IDENTIFIER22.getText():null));
				    }
				    builder.putOperator( (alias21!=null?((LogicalPlanGenerator.alias_return)alias21).name:null), (LogicalRelationalOperator)op );
			    }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class parallel_clause_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "parallel_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:217:1: parallel_clause : ^( PARALLEL INTEGER ) ;
	public final LogicalPlanGenerator.parallel_clause_return parallel_clause() throws RecognitionException {
		LogicalPlanGenerator.parallel_clause_return retval = new LogicalPlanGenerator.parallel_clause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree PARALLEL23=null;
		CommonTree INTEGER24=null;

		CommonTree PARALLEL23_tree=null;
		CommonTree INTEGER24_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:218:2: ( ^( PARALLEL INTEGER ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:218:4: ^( PARALLEL INTEGER )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			PARALLEL23=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_parallel_clause256); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			PARALLEL23_tree = (CommonTree)adaptor.dupNode(PARALLEL23);


			root_1 = (CommonTree)adaptor.becomeRoot(PARALLEL23_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			INTEGER24=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_parallel_clause258); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			INTEGER24_tree = (CommonTree)adaptor.dupNode(INTEGER24);


			adaptor.addChild(root_1, INTEGER24_tree);
			}

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			       statement_stack.peek().parallel = Integer.parseInt( (INTEGER24!=null?INTEGER24.getText():null) );
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class alias_return extends TreeRuleReturnScope {
		public String name;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "alias"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:224:1: alias returns [String name] : IDENTIFIER ;
	public final LogicalPlanGenerator.alias_return alias() throws RecognitionException {
		LogicalPlanGenerator.alias_return retval = new LogicalPlanGenerator.alias_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree IDENTIFIER25=null;

		CommonTree IDENTIFIER25_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:224:27: ( IDENTIFIER )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:224:29: IDENTIFIER
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			IDENTIFIER25=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias276); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			IDENTIFIER25_tree = (CommonTree)adaptor.dupNode(IDENTIFIER25);


			adaptor.addChild(root_0, IDENTIFIER25_tree);
			}

			if ( state.backtracking==0 ) { retval.name = (IDENTIFIER25!=null?IDENTIFIER25.getText():null); }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "alias"


	public static class op_clause_return extends TreeRuleReturnScope {
		public String alias;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "op_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:227:1: op_clause returns [String alias] : ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | foreach_clause | cube_clause | assert_clause );
	public final LogicalPlanGenerator.op_clause_return op_clause() throws RecognitionException {
		LogicalPlanGenerator.op_clause_return retval = new LogicalPlanGenerator.op_clause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope define_clause26 =null;
		TreeRuleReturnScope load_clause27 =null;
		TreeRuleReturnScope group_clause28 =null;
		TreeRuleReturnScope store_clause29 =null;
		TreeRuleReturnScope filter_clause30 =null;
		TreeRuleReturnScope distinct_clause31 =null;
		TreeRuleReturnScope limit_clause32 =null;
		TreeRuleReturnScope sample_clause33 =null;
		TreeRuleReturnScope order_clause34 =null;
		TreeRuleReturnScope rank_clause35 =null;
		TreeRuleReturnScope cross_clause36 =null;
		TreeRuleReturnScope join_clause37 =null;
		TreeRuleReturnScope union_clause38 =null;
		TreeRuleReturnScope stream_clause39 =null;
		TreeRuleReturnScope mr_clause40 =null;
		TreeRuleReturnScope foreach_clause41 =null;
		TreeRuleReturnScope cube_clause42 =null;
		TreeRuleReturnScope assert_clause43 =null;


		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:227:33: ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | foreach_clause | cube_clause | assert_clause )
			int alt6=18;
			switch ( input.LA(1) ) {
			case DEFINE:
				{
				alt6=1;
				}
				break;
			case LOAD:
				{
				alt6=2;
				}
				break;
			case COGROUP:
			case GROUP:
				{
				alt6=3;
				}
				break;
			case STORE:
				{
				alt6=4;
				}
				break;
			case FILTER:
				{
				alt6=5;
				}
				break;
			case DISTINCT:
				{
				alt6=6;
				}
				break;
			case LIMIT:
				{
				alt6=7;
				}
				break;
			case SAMPLE:
				{
				alt6=8;
				}
				break;
			case ORDER:
				{
				alt6=9;
				}
				break;
			case RANK:
				{
				alt6=10;
				}
				break;
			case CROSS:
				{
				alt6=11;
				}
				break;
			case JOIN:
				{
				alt6=12;
				}
				break;
			case UNION:
				{
				alt6=13;
				}
				break;
			case STREAM:
				{
				alt6=14;
				}
				break;
			case MAPREDUCE:
				{
				alt6=15;
				}
				break;
			case FOREACH:
				{
				alt6=16;
				}
				break;
			case CUBE:
				{
				alt6=17;
				}
				break;
			case ASSERT:
				{
				alt6=18;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}
			switch (alt6) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:228:13: define_clause
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_define_clause_in_op_clause302);
					define_clause26=define_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, define_clause26.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:229:13: load_clause
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_load_clause_in_op_clause316);
					load_clause27=load_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, load_clause27.getTree());

					if ( state.backtracking==0 ) { retval.alias = (load_clause27!=null?((LogicalPlanGenerator.load_clause_return)load_clause27).alias:null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:230:13: group_clause
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_group_clause_in_op_clause332);
					group_clause28=group_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, group_clause28.getTree());

					if ( state.backtracking==0 ) { retval.alias = (group_clause28!=null?((LogicalPlanGenerator.group_clause_return)group_clause28).alias:null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 4 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:231:13: store_clause
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_store_clause_in_op_clause348);
					store_clause29=store_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, store_clause29.getTree());

					if ( state.backtracking==0 ) { retval.alias = (store_clause29!=null?((LogicalPlanGenerator.store_clause_return)store_clause29).alias:null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 5 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:232:13: filter_clause
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_filter_clause_in_op_clause364);
					filter_clause30=filter_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, filter_clause30.getTree());

					if ( state.backtracking==0 ) { retval.alias = (filter_clause30!=null?((LogicalPlanGenerator.filter_clause_return)filter_clause30).alias:null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 6 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:233:13: distinct_clause
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_distinct_clause_in_op_clause380);
					distinct_clause31=distinct_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, distinct_clause31.getTree());

					if ( state.backtracking==0 ) { retval.alias = (distinct_clause31!=null?((LogicalPlanGenerator.distinct_clause_return)distinct_clause31).alias:null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 7 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:234:13: limit_clause
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_limit_clause_in_op_clause396);
					limit_clause32=limit_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, limit_clause32.getTree());

					if ( state.backtracking==0 ) { retval.alias = (limit_clause32!=null?((LogicalPlanGenerator.limit_clause_return)limit_clause32).alias:null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 8 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:235:13: sample_clause
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_sample_clause_in_op_clause412);
					sample_clause33=sample_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, sample_clause33.getTree());

					if ( state.backtracking==0 ) { retval.alias = (sample_clause33!=null?((LogicalPlanGenerator.sample_clause_return)sample_clause33).alias:null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 9 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:236:13: order_clause
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_order_clause_in_op_clause428);
					order_clause34=order_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, order_clause34.getTree());

					if ( state.backtracking==0 ) { retval.alias = (order_clause34!=null?((LogicalPlanGenerator.order_clause_return)order_clause34).alias:null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 10 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:237:13: rank_clause
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_rank_clause_in_op_clause444);
					rank_clause35=rank_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, rank_clause35.getTree());

					if ( state.backtracking==0 ) { retval.alias = (rank_clause35!=null?((LogicalPlanGenerator.rank_clause_return)rank_clause35).alias:null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 11 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:238:13: cross_clause
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_cross_clause_in_op_clause460);
					cross_clause36=cross_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, cross_clause36.getTree());

					if ( state.backtracking==0 ) { retval.alias = (cross_clause36!=null?((LogicalPlanGenerator.cross_clause_return)cross_clause36).alias:null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 12 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:239:13: join_clause
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_join_clause_in_op_clause476);
					join_clause37=join_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, join_clause37.getTree());

					if ( state.backtracking==0 ) { retval.alias = (join_clause37!=null?((LogicalPlanGenerator.join_clause_return)join_clause37).alias:null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 13 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:240:13: union_clause
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_union_clause_in_op_clause492);
					union_clause38=union_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, union_clause38.getTree());

					if ( state.backtracking==0 ) { retval.alias = (union_clause38!=null?((LogicalPlanGenerator.union_clause_return)union_clause38).alias:null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 14 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:241:13: stream_clause
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_stream_clause_in_op_clause508);
					stream_clause39=stream_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, stream_clause39.getTree());

					if ( state.backtracking==0 ) { retval.alias = (stream_clause39!=null?((LogicalPlanGenerator.stream_clause_return)stream_clause39).alias:null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 15 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:242:13: mr_clause
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_mr_clause_in_op_clause524);
					mr_clause40=mr_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, mr_clause40.getTree());

					if ( state.backtracking==0 ) { retval.alias = (mr_clause40!=null?((LogicalPlanGenerator.mr_clause_return)mr_clause40).alias:null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 16 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:243:13: foreach_clause
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_foreach_clause_in_op_clause540);
					foreach_clause41=foreach_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, foreach_clause41.getTree());

					if ( state.backtracking==0 ) { retval.alias = (foreach_clause41!=null?((LogicalPlanGenerator.foreach_clause_return)foreach_clause41).alias:null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 18 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:245:13: assert_clause
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_assert_clause_in_op_clause572);
					assert_clause43=assert_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, assert_clause43.getTree());

					if ( state.backtracking==0 ) { retval.alias = (assert_clause43!=null?((LogicalPlanGenerator.assert_clause_return)assert_clause43).alias:null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;

			}
			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class define_clause_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "define_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:248:1: define_clause : ( ^( DEFINE alias cmd[$alias.name] ) | ^( DEFINE alias func_clause[FunctionType.UNKNOWNFUNC] ) );
	public final LogicalPlanGenerator.define_clause_return define_clause() throws RecognitionException {
		LogicalPlanGenerator.define_clause_return retval = new LogicalPlanGenerator.define_clause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree DEFINE44=null;
		CommonTree DEFINE47=null;
		TreeRuleReturnScope alias45 =null;
		TreeRuleReturnScope cmd46 =null;
		TreeRuleReturnScope alias48 =null;
		TreeRuleReturnScope func_clause49 =null;

		CommonTree DEFINE44_tree=null;
		CommonTree DEFINE47_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:249:2: ( ^( DEFINE alias cmd[$alias.name] ) | ^( DEFINE alias func_clause[FunctionType.UNKNOWNFUNC] ) )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==DEFINE) ) {
				int LA7_1 = input.LA(2);
				if ( (LA7_1==DOWN) ) {
					int LA7_2 = input.LA(3);
					if ( (LA7_2==IDENTIFIER) ) {
						int LA7_3 = input.LA(4);
						if ( (LA7_3==EXECCOMMAND) ) {
							alt7=1;
						}
						else if ( (LA7_3==FUNC||LA7_3==FUNC_REF) ) {
							alt7=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 7, 3, input);
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
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 7, 2, input);
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
							new NoViableAltException("", 7, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:249:4: ^( DEFINE alias cmd[$alias.name] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					DEFINE44=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_define_clause586); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DEFINE44_tree = (CommonTree)adaptor.dupNode(DEFINE44);


					root_1 = (CommonTree)adaptor.becomeRoot(DEFINE44_tree, root_1);
					}

					match(input, Token.DOWN, null); if (state.failed) return retval;
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_alias_in_define_clause588);
					alias45=alias();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, alias45.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_cmd_in_define_clause590);
					cmd46=cmd((alias45!=null?((LogicalPlanGenerator.alias_return)alias45).name:null));
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, cmd46.getTree());

					match(input, Token.UP, null); if (state.failed) return retval;
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					if ( state.backtracking==0 ) {
					       builder.defineCommand( (alias45!=null?((LogicalPlanGenerator.alias_return)alias45).name:null), (cmd46!=null?((LogicalPlanGenerator.cmd_return)cmd46).command:null) );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;


			}
			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class cmd_return extends TreeRuleReturnScope {
		public StreamingCommand command;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "cmd"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:259:1: cmd[String alias] returns [StreamingCommand command] : ^( EXECCOMMAND ( ship_clause[shipPaths] | cache_clause[cachePaths] | input_clause | output_clause | error_clause )* ) ;
	public final LogicalPlanGenerator.cmd_return cmd(String alias) throws RecognitionException {
		LogicalPlanGenerator.cmd_return retval = new LogicalPlanGenerator.cmd_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree EXECCOMMAND50=null;
		TreeRuleReturnScope ship_clause51 =null;
		TreeRuleReturnScope cache_clause52 =null;
		TreeRuleReturnScope input_clause53 =null;
		TreeRuleReturnScope output_clause54 =null;
		TreeRuleReturnScope error_clause55 =null;

		CommonTree EXECCOMMAND50_tree=null;


		    List<String> shipPaths = new ArrayList<String>();
		    List<String> cachePaths = new ArrayList<String>();
		    SourceLocation loc = new SourceLocation( (LatinParserNode)((CommonTree)retval.start) );

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:265:2: ( ^( EXECCOMMAND ( ship_clause[shipPaths] | cache_clause[cachePaths] | input_clause | output_clause | error_clause )* ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:265:4: ^( EXECCOMMAND ( ship_clause[shipPaths] | cache_clause[cachePaths] | input_clause | output_clause | error_clause )* )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			EXECCOMMAND50=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_cmd638); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			EXECCOMMAND50_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND50);


			root_1 = (CommonTree)adaptor.becomeRoot(EXECCOMMAND50_tree, root_1);
			}

			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); if (state.failed) return retval;
				// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:265:19: ( ship_clause[shipPaths] | cache_clause[cachePaths] | input_clause | output_clause | error_clause )*
				loop8:
				while (true) {
					int alt8=6;
					switch ( input.LA(1) ) {
					case SHIP:
						{
						alt8=1;
						}
						break;
					case CACHE:
						{
						alt8=2;
						}
						break;
					case INPUT:
						{
						alt8=3;
						}
						break;
					case OUTPUT:
						{
						alt8=4;
						}
						break;
					case STDERROR:
						{
						alt8=5;
						}
						break;
					}
					switch (alt8) {
					case 1 :
						// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:265:21: ship_clause[shipPaths]
						{
						_last = (CommonTree)input.LT(1);
						pushFollow(FOLLOW_ship_clause_in_cmd642);
						ship_clause51=ship_clause(shipPaths);
						state._fsp--;
						if (state.failed) return retval;
						if ( state.backtracking==0 ) 
						adaptor.addChild(root_1, ship_clause51.getTree());

						if ( state.backtracking==0 ) {
						}

						}
						break;
					case 2 :
						// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:265:46: cache_clause[cachePaths]
						{
						_last = (CommonTree)input.LT(1);
						pushFollow(FOLLOW_cache_clause_in_cmd647);
						cache_clause52=cache_clause(cachePaths);
						state._fsp--;
						if (state.failed) return retval;
						if ( state.backtracking==0 ) 
						adaptor.addChild(root_1, cache_clause52.getTree());

						if ( state.backtracking==0 ) {
						}

						}
						break;
					case 3 :
						// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:265:73: input_clause
						{
						_last = (CommonTree)input.LT(1);
						pushFollow(FOLLOW_input_clause_in_cmd652);
						input_clause53=input_clause();
						state._fsp--;
						if (state.failed) return retval;
						if ( state.backtracking==0 ) 
						adaptor.addChild(root_1, input_clause53.getTree());

						if ( state.backtracking==0 ) {
						}

						}
						break;
					case 4 :
						// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:265:88: output_clause
						{
						_last = (CommonTree)input.LT(1);
						pushFollow(FOLLOW_output_clause_in_cmd656);
						output_clause54=output_clause();
						state._fsp--;
						if (state.failed) return retval;
						if ( state.backtracking==0 ) 
						adaptor.addChild(root_1, output_clause54.getTree());

						if ( state.backtracking==0 ) {
						}

						}
						break;
					case 5 :
						// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:265:104: error_clause
						{
						_last = (CommonTree)input.LT(1);
						pushFollow(FOLLOW_error_clause_in_cmd660);
						error_clause55=error_clause();
						state._fsp--;
						if (state.failed) return retval;
						if ( state.backtracking==0 ) 
						adaptor.addChild(root_1, error_clause55.getTree());

						if ( state.backtracking==0 ) {
						}

						}
						break;

					default :
						break loop8;
					}
				}

				match(input, Token.UP, null); if (state.failed) return retval;
			}
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			       retval.command = builder.buildCommand( loc, builder.unquote( (EXECCOMMAND50!=null?EXECCOMMAND50.getText():null) ), shipPaths,
			           cachePaths, (input_clause53!=null?((LogicalPlanGenerator.input_clause_return)input_clause53).inputHandleSpecs:null), (output_clause54!=null?((LogicalPlanGenerator.output_clause_return)output_clause54).outputHandleSpecs:null),
			           (error_clause55!=null?((LogicalPlanGenerator.error_clause_return)error_clause55).dir:null), (error_clause55!=null?((LogicalPlanGenerator.error_clause_return)error_clause55).limit:null) );
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class ship_clause_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "ship_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:273:1: ship_clause[List<String> paths] : ^( SHIP ( path_list[$paths] )? ) ;
	public final LogicalPlanGenerator.ship_clause_return ship_clause(List<String> paths) throws RecognitionException {
		LogicalPlanGenerator.ship_clause_return retval = new LogicalPlanGenerator.ship_clause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree SHIP56=null;
		TreeRuleReturnScope path_list57 =null;

		CommonTree SHIP56_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:274:2: ( ^( SHIP ( path_list[$paths] )? ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:274:4: ^( SHIP ( path_list[$paths] )? )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			SHIP56=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_ship_clause683); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			SHIP56_tree = (CommonTree)adaptor.dupNode(SHIP56);


			root_1 = (CommonTree)adaptor.becomeRoot(SHIP56_tree, root_1);
			}

			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); if (state.failed) return retval;
				// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:274:12: ( path_list[$paths] )?
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==QUOTEDSTRING) ) {
					alt9=1;
				}
				switch (alt9) {
					case 1 :
						// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:274:12: path_list[$paths]
						{
						_last = (CommonTree)input.LT(1);
						pushFollow(FOLLOW_path_list_in_ship_clause685);
						path_list57=path_list(paths);
						state._fsp--;
						if (state.failed) return retval;
						if ( state.backtracking==0 ) 
						adaptor.addChild(root_1, path_list57.getTree());

						if ( state.backtracking==0 ) {
						}

						}
						break;

				}

				match(input, Token.UP, null); if (state.failed) return retval;
			}
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class path_list_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "path_list"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:277:1: path_list[List<String> paths] : ( QUOTEDSTRING )+ ;
	public final LogicalPlanGenerator.path_list_return path_list(List<String> paths) throws RecognitionException {
		LogicalPlanGenerator.path_list_return retval = new LogicalPlanGenerator.path_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree QUOTEDSTRING58=null;

		CommonTree QUOTEDSTRING58_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:278:2: ( ( QUOTEDSTRING )+ )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:278:4: ( QUOTEDSTRING )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:278:4: ( QUOTEDSTRING )+
			int cnt10=0;
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==QUOTEDSTRING) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:278:6: QUOTEDSTRING
					{
					_last = (CommonTree)input.LT(1);
					QUOTEDSTRING58=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_path_list702); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					QUOTEDSTRING58_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING58);


					adaptor.addChild(root_0, QUOTEDSTRING58_tree);
					}

					if ( state.backtracking==0 ) { paths.add( builder.unquote( (QUOTEDSTRING58!=null?QUOTEDSTRING58.getText():null) ) ); }
					if ( state.backtracking==0 ) {
					}

					}
					break;

				default :
					if ( cnt10 >= 1 ) break loop10;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(10, input);
					throw eee;
				}
				cnt10++;
			}

			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class cache_clause_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "cache_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:281:1: cache_clause[List<String> paths] : ^( CACHE path_list[$paths] ) ;
	public final LogicalPlanGenerator.cache_clause_return cache_clause(List<String> paths) throws RecognitionException {
		LogicalPlanGenerator.cache_clause_return retval = new LogicalPlanGenerator.cache_clause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree CACHE59=null;
		TreeRuleReturnScope path_list60 =null;

		CommonTree CACHE59_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:282:2: ( ^( CACHE path_list[$paths] ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:282:4: ^( CACHE path_list[$paths] )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			CACHE59=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_cache_clause720); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			CACHE59_tree = (CommonTree)adaptor.dupNode(CACHE59);


			root_1 = (CommonTree)adaptor.becomeRoot(CACHE59_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_path_list_in_cache_clause722);
			path_list60=path_list(paths);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, path_list60.getTree());

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class input_clause_return extends TreeRuleReturnScope {
		public List<HandleSpec> inputHandleSpecs;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "input_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:285:1: input_clause returns [List<HandleSpec> inputHandleSpecs] : ^( INPUT ( stream_cmd[true] )+ ) ;
	public final LogicalPlanGenerator.input_clause_return input_clause() throws RecognitionException {
		LogicalPlanGenerator.input_clause_return retval = new LogicalPlanGenerator.input_clause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree INPUT61=null;
		TreeRuleReturnScope stream_cmd62 =null;

		CommonTree INPUT61_tree=null;


		    retval.inputHandleSpecs = new ArrayList<HandleSpec>();

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:289:2: ( ^( INPUT ( stream_cmd[true] )+ ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:289:4: ^( INPUT ( stream_cmd[true] )+ )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			INPUT61=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_input_clause745); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			INPUT61_tree = (CommonTree)adaptor.dupNode(INPUT61);


			root_1 = (CommonTree)adaptor.becomeRoot(INPUT61_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:289:13: ( stream_cmd[true] )+
			int cnt11=0;
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==QUOTEDSTRING||(LA11_0 >= STDIN && LA11_0 <= STDOUT)) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:289:15: stream_cmd[true]
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_stream_cmd_in_input_clause749);
					stream_cmd62=stream_cmd(true);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, stream_cmd62.getTree());

					if ( state.backtracking==0 ) { retval.inputHandleSpecs.add( (stream_cmd62!=null?((LogicalPlanGenerator.stream_cmd_return)stream_cmd62).handleSpec:null) ); }
					if ( state.backtracking==0 ) {
					}

					}
					break;

				default :
					if ( cnt11 >= 1 ) break loop11;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(11, input);
					throw eee;
				}
				cnt11++;
			}

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class stream_cmd_return extends TreeRuleReturnScope {
		public HandleSpec handleSpec;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	}

	public static class output_clause_return extends TreeRuleReturnScope {
		public List<HandleSpec> outputHandleSpecs;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "output_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:312:1: output_clause returns [List<HandleSpec> outputHandleSpecs] : ^( OUTPUT ( stream_cmd[false] )+ ) ;
	public final LogicalPlanGenerator.output_clause_return output_clause() throws RecognitionException {
		LogicalPlanGenerator.output_clause_return retval = new LogicalPlanGenerator.output_clause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree OUTPUT69=null;
		TreeRuleReturnScope stream_cmd70 =null;

		CommonTree OUTPUT69_tree=null;


		    retval.outputHandleSpecs = new ArrayList<HandleSpec>();

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:316:2: ( ^( OUTPUT ( stream_cmd[false] )+ ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:316:4: ^( OUTPUT ( stream_cmd[false] )+ )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			OUTPUT69=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_output_clause877); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			OUTPUT69_tree = (CommonTree)adaptor.dupNode(OUTPUT69);


			root_1 = (CommonTree)adaptor.becomeRoot(OUTPUT69_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:316:14: ( stream_cmd[false] )+
			int cnt16=0;
			loop16:
			while (true) {
				int alt16=2;
				int LA16_0 = input.LA(1);
				if ( (LA16_0==QUOTEDSTRING||(LA16_0 >= STDIN && LA16_0 <= STDOUT)) ) {
					alt16=1;
				}

				switch (alt16) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:316:16: stream_cmd[false]
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_stream_cmd_in_output_clause881);
					stream_cmd70=stream_cmd(false);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, stream_cmd70.getTree());

					if ( state.backtracking==0 ) { retval.outputHandleSpecs.add( (stream_cmd70!=null?((LogicalPlanGenerator.stream_cmd_return)stream_cmd70).handleSpec:null) ); }
					if ( state.backtracking==0 ) {
					}

					}
					break;

				default :
					if ( cnt16 >= 1 ) break loop16;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(16, input);
					throw eee;
				}
				cnt16++;
			}

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class error_clause_return extends TreeRuleReturnScope {
		public String dir;
		public Integer limit;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "error_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:319:1: error_clause returns [String dir, Integer limit] : ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) ;
	public final LogicalPlanGenerator.error_clause_return error_clause() throws RecognitionException {
		LogicalPlanGenerator.error_clause_return retval = new LogicalPlanGenerator.error_clause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree STDERROR71=null;
		CommonTree QUOTEDSTRING72=null;
		CommonTree INTEGER73=null;

		CommonTree STDERROR71_tree=null;
		CommonTree QUOTEDSTRING72_tree=null;
		CommonTree INTEGER73_tree=null;


		    retval.limit = StreamingCommand.MAX_TASKS;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:323:2: ( ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:323:4: ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			STDERROR71=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_error_clause909); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			STDERROR71_tree = (CommonTree)adaptor.dupNode(STDERROR71);


			root_1 = (CommonTree)adaptor.becomeRoot(STDERROR71_tree, root_1);
			}

			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); if (state.failed) return retval;
				// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:324:7: ( QUOTEDSTRING ( INTEGER )? )?
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( (LA18_0==QUOTEDSTRING) ) {
					alt18=1;
				}
				switch (alt18) {
					case 1 :
						// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:324:9: QUOTEDSTRING ( INTEGER )?
						{
						_last = (CommonTree)input.LT(1);
						QUOTEDSTRING72=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_error_clause919); if (state.failed) return retval;
						if ( state.backtracking==0 ) {
						QUOTEDSTRING72_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING72);


						adaptor.addChild(root_1, QUOTEDSTRING72_tree);
						}

						if ( state.backtracking==0 ) {
						            retval.dir = builder.unquote( (QUOTEDSTRING72!=null?QUOTEDSTRING72.getText():null) );
						        }
						// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:328:9: ( INTEGER )?
						int alt17=2;
						int LA17_0 = input.LA(1);
						if ( (LA17_0==INTEGER) ) {
							alt17=1;
						}
						switch (alt17) {
							case 1 :
								// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:328:11: INTEGER
								{
								_last = (CommonTree)input.LT(1);
								INTEGER73=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_error_clause941); if (state.failed) return retval;
								if ( state.backtracking==0 ) {
								INTEGER73_tree = (CommonTree)adaptor.dupNode(INTEGER73);


								adaptor.addChild(root_1, INTEGER73_tree);
								}

								if ( state.backtracking==0 ) {
								              retval.limit = Integer.parseInt( (INTEGER73!=null?INTEGER73.getText():null) );
								          }
								if ( state.backtracking==0 ) {
								}

								}
								break;

						}

						if ( state.backtracking==0 ) {
						}

						}
						break;

				}

				match(input, Token.UP, null); if (state.failed) return retval;
			}
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class load_clause_return extends TreeRuleReturnScope {
		public String alias;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "load_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:337:1: load_clause returns [String alias] : ^( LOAD filename ( func_clause[FunctionType.LOADFUNC] )? ( as_clause )? ) ;
	public final LogicalPlanGenerator.load_clause_return load_clause() throws RecognitionException {
		LogicalPlanGenerator.load_clause_return retval = new LogicalPlanGenerator.load_clause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree LOAD74=null;
		TreeRuleReturnScope filename75 =null;
		TreeRuleReturnScope func_clause76 =null;
		TreeRuleReturnScope as_clause77 =null;

		CommonTree LOAD74_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:338:2: ( ^( LOAD filename ( func_clause[FunctionType.LOADFUNC] )? ( as_clause )? ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:338:4: ^( LOAD filename ( func_clause[FunctionType.LOADFUNC] )? ( as_clause )? )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			LOAD74=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_load_clause994); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LOAD74_tree = (CommonTree)adaptor.dupNode(LOAD74);


			root_1 = (CommonTree)adaptor.becomeRoot(LOAD74_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_filename_in_load_clause996);
			filename75=filename();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, filename75.getTree());

			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:338:21: ( func_clause[FunctionType.LOADFUNC] )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==FUNC||LA19_0==FUNC_REF) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:338:21: func_clause[FunctionType.LOADFUNC]
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_func_clause_in_load_clause998);
					func_clause76=func_clause(FunctionType.LOADFUNC);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, func_clause76.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;

			}

			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:338:57: ( as_clause )?
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==AS) ) {
				alt20=1;
			}
			switch (alt20) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:338:57: as_clause
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_as_clause_in_load_clause1002);
					as_clause77=as_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, as_clause77.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;

			}

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}

            if ( state.backtracking==0 ) {
                    SourceLocation loc = new SourceLocation( (LatinParserNode)((CommonTree)retval.start) );
                    retval.alias = builder.buildLoadOp( loc, statement_stack.peek().alias,
                            (filename75!=null?((LogicalPlanGenerator.filename_return)filename75).filename:null), (func_clause76!=null?((LogicalPlanGenerator.func_clause_return)func_clause76).funcSpec:null), (as_clause77!=null?((LogicalPlanGenerator.as_clause_return)as_clause77).logicalSchema:null)  );
            }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class filename_return extends TreeRuleReturnScope {
		public String filename;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "filename"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:346:1: filename returns [String filename] : QUOTEDSTRING ;
	public final LogicalPlanGenerator.filename_return filename() throws RecognitionException {
		LogicalPlanGenerator.filename_return retval = new LogicalPlanGenerator.filename_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree QUOTEDSTRING78=null;

		CommonTree QUOTEDSTRING78_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:347:2: ( QUOTEDSTRING )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:347:4: QUOTEDSTRING
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			QUOTEDSTRING78=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_filename1022); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			QUOTEDSTRING78_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING78);


			adaptor.addChild(root_0, QUOTEDSTRING78_tree);
			}

			if ( state.backtracking==0 ) { retval.filename = builder.unquote( (QUOTEDSTRING78!=null?QUOTEDSTRING78.getText():null) ); }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "filename"


	public static class as_clause_return extends TreeRuleReturnScope {
		public LogicalSchema logicalSchema;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "as_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:350:1: as_clause returns [LogicalSchema logicalSchema] : ^( AS field_def_list ) ;
	public final LogicalPlanGenerator.as_clause_return as_clause() throws RecognitionException {
		LogicalPlanGenerator.as_clause_return retval = new LogicalPlanGenerator.as_clause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree AS79=null;
		TreeRuleReturnScope field_def_list80 =null;

		CommonTree AS79_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:351:2: ( ^( AS field_def_list ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:351:4: ^( AS field_def_list )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			AS79=(CommonTree)match(input,AS,FOLLOW_AS_in_as_clause1039); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			AS79_tree = (CommonTree)adaptor.dupNode(AS79);


			root_1 = (CommonTree)adaptor.becomeRoot(AS79_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_field_def_list_in_as_clause1041);
			field_def_list80=field_def_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, field_def_list80.getTree());

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			        LogicalPlanBuilder.setBytearrayForNULLType((field_def_list80!=null?((LogicalPlanGenerator.field_def_list_return)field_def_list80).schema:null));
			        retval.logicalSchema = (field_def_list80!=null?((LogicalPlanGenerator.field_def_list_return)field_def_list80).schema:null);
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class field_def_return extends TreeRuleReturnScope {
		public LogicalFieldSchema fieldSchema;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "field_def"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:358:1: field_def[NumValCarrier nvc] returns [LogicalFieldSchema fieldSchema] : ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF_WITHOUT_IDENTIFIER ( type ) ) );
	public final LogicalPlanGenerator.field_def_return field_def(NumValCarrier nvc) throws RecognitionException {
		LogicalPlanGenerator.field_def_return retval = new LogicalPlanGenerator.field_def_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree FIELD_DEF81=null;
		CommonTree IDENTIFIER82=null;
		CommonTree FIELD_DEF_WITHOUT_IDENTIFIER84=null;
		TreeRuleReturnScope type83 =null;
		TreeRuleReturnScope type85 =null;

		CommonTree FIELD_DEF81_tree=null;
		CommonTree IDENTIFIER82_tree=null;
		CommonTree FIELD_DEF_WITHOUT_IDENTIFIER84_tree=null;


		    byte datatype = DataType.NULL;
		    if (nvc==null) {
		        nvc =new NumValCarrier();
		    }

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:365:2: ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF_WITHOUT_IDENTIFIER ( type ) ) )
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==FIELD_DEF) ) {
				alt22=1;
			}
			else if ( (LA22_0==FIELD_DEF_WITHOUT_IDENTIFIER) ) {
				alt22=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}

			switch (alt22) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:365:4: ^( FIELD_DEF IDENTIFIER ( type )? )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					FIELD_DEF81=(CommonTree)match(input,FIELD_DEF,FOLLOW_FIELD_DEF_in_field_def1069); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FIELD_DEF81_tree = (CommonTree)adaptor.dupNode(FIELD_DEF81);


					root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF81_tree, root_1);
					}

					match(input, Token.DOWN, null); if (state.failed) return retval;
					_last = (CommonTree)input.LT(1);
					IDENTIFIER82=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_field_def1071); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IDENTIFIER82_tree = (CommonTree)adaptor.dupNode(IDENTIFIER82);


					adaptor.addChild(root_1, IDENTIFIER82_tree);
					}

					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:365:28: ( type )?
					int alt21=2;
					int LA21_0 = input.LA(1);
					if ( (LA21_0==BIGDECIMAL||LA21_0==BIGINTEGER||LA21_0==BOOLEAN||LA21_0==BYTEARRAY||LA21_0==CHARARRAY||LA21_0==DATETIME||LA21_0==DOUBLE||LA21_0==FLOAT||LA21_0==INT||LA21_0==LONG||LA21_0==BAG_TYPE||LA21_0==MAP_TYPE||LA21_0==TUPLE_TYPE) ) {
						alt21=1;
					}
					switch (alt21) {
						case 1 :
							// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:365:30: type
							{
							_last = (CommonTree)input.LT(1);
							pushFollow(FOLLOW_type_in_field_def1075);
							type83=type();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) 
							adaptor.addChild(root_1, type83.getTree());

							if ( state.backtracking==0 ) { datatype = (type83!=null?((LogicalPlanGenerator.type_return)type83).datatype:null);}
							if ( state.backtracking==0 ) {
							}

							}
							break;

					}

					match(input, Token.UP, null); if (state.failed) return retval;
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					if ( state.backtracking==0 ) {
					           retval.fieldSchema = new LogicalFieldSchema( (IDENTIFIER82!=null?IDENTIFIER82.getText():null), (type83!=null?((LogicalPlanGenerator.type_return)type83).logicalSchema:null), datatype );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:369:4: ^( FIELD_DEF_WITHOUT_IDENTIFIER ( type ) )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					FIELD_DEF_WITHOUT_IDENTIFIER84=(CommonTree)match(input,FIELD_DEF_WITHOUT_IDENTIFIER,FOLLOW_FIELD_DEF_WITHOUT_IDENTIFIER_in_field_def1094); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FIELD_DEF_WITHOUT_IDENTIFIER84_tree = (CommonTree)adaptor.dupNode(FIELD_DEF_WITHOUT_IDENTIFIER84);


					root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF_WITHOUT_IDENTIFIER84_tree, root_1);
					}

					match(input, Token.DOWN, null); if (state.failed) return retval;
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:369:36: ( type )
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:369:38: type
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_type_in_field_def1098);
					type85=type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, type85.getTree());

					if ( state.backtracking==0 ) { datatype = (type85!=null?((LogicalPlanGenerator.type_return)type85).datatype:null); }
					if ( state.backtracking==0 ) {
					}

					}

					match(input, Token.UP, null); if (state.failed) return retval;
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					if ( state.backtracking==0 ) {
					           retval.fieldSchema = new LogicalSchema.LogicalFieldSchema( nvc.makeNameFromDataType(datatype) , (type85!=null?((LogicalPlanGenerator.type_return)type85).logicalSchema:null), datatype );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;

			}
			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class field_def_list_return extends TreeRuleReturnScope {
		public LogicalSchema schema;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "field_def_list"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:375:1: field_def_list returns [LogicalSchema schema] : ( field_def[nvc] )+ ;
	public final LogicalPlanGenerator.field_def_list_return field_def_list() throws RecognitionException {
		LogicalPlanGenerator.field_def_list_return retval = new LogicalPlanGenerator.field_def_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope field_def86 =null;



		    retval.schema = new LogicalSchema();
		    NumValCarrier nvc = new NumValCarrier();

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:380:2: ( ( field_def[nvc] )+ )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:380:4: ( field_def[nvc] )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:380:4: ( field_def[nvc] )+
			int cnt23=0;
			loop23:
			while (true) {
				int alt23=2;
				int LA23_0 = input.LA(1);
				if ( ((LA23_0 >= FIELD_DEF && LA23_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
					alt23=1;
				}

				switch (alt23) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:380:6: field_def[nvc]
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_field_def_in_field_def_list1129);
					field_def86=field_def(nvc);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, field_def86.getTree());

					if ( state.backtracking==0 ) { retval.schema.addField( (field_def86!=null?((LogicalPlanGenerator.field_def_return)field_def86).fieldSchema:null) ); }
					if ( state.backtracking==0 ) {
					}

					}
					break;

				default :
					if ( cnt23 >= 1 ) break loop23;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(23, input);
					throw eee;
				}
				cnt23++;
			}

			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class type_return extends TreeRuleReturnScope {
		public Byte datatype;
		public LogicalSchema logicalSchema;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "type"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:384:1: type returns [Byte datatype, LogicalSchema logicalSchema] : ( simple_type | tuple_type | bag_type | map_type );
	public final LogicalPlanGenerator.type_return type() throws RecognitionException {
		LogicalPlanGenerator.type_return retval = new LogicalPlanGenerator.type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope simple_type87 =null;
		TreeRuleReturnScope tuple_type88 =null;
		TreeRuleReturnScope bag_type89 =null;
		TreeRuleReturnScope map_type90 =null;


		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:385:2: ( simple_type | tuple_type | bag_type | map_type )
			int alt24=4;
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
				alt24=1;
				}
				break;
			case TUPLE_TYPE:
				{
				alt24=2;
				}
				break;
			case BAG_TYPE:
				{
				alt24=3;
				}
				break;
			case MAP_TYPE:
				{
				alt24=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 24, 0, input);
				throw nvae;
			}
			switch (alt24) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:385:4: simple_type
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_simple_type_in_type1149);
					simple_type87=simple_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, simple_type87.getTree());

					if ( state.backtracking==0 ) {
					        retval.datatype = (simple_type87!=null?((LogicalPlanGenerator.simple_type_return)simple_type87).datatype:0);
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:389:4: tuple_type
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_tuple_type_in_type1159);
					tuple_type88=tuple_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, tuple_type88.getTree());

					if ( state.backtracking==0 ) {
					       retval.datatype = DataType.TUPLE;
					       retval.logicalSchema = (tuple_type88!=null?((LogicalPlanGenerator.tuple_type_return)tuple_type88).logicalSchema:null);
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:394:4: bag_type
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_bag_type_in_type1169);
					bag_type89=bag_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, bag_type89.getTree());

					if ( state.backtracking==0 ) {
					       retval.datatype = DataType.BAG;
					       retval.logicalSchema = (bag_type89!=null?((LogicalPlanGenerator.bag_type_return)bag_type89).logicalSchema:null);
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 4 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:399:4: map_type
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_map_type_in_type1179);
					map_type90=map_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, map_type90.getTree());

					if ( state.backtracking==0 ) {
					       retval.datatype = DataType.MAP;
					       retval.logicalSchema = (map_type90!=null?((LogicalPlanGenerator.map_type_return)map_type90).logicalSchema:null);
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;

			}
			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class simple_type_return extends TreeRuleReturnScope {
		public byte datatype;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "simple_type"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:406:1: simple_type returns [byte datatype] : ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY );
	public final LogicalPlanGenerator.simple_type_return simple_type() throws RecognitionException {
		LogicalPlanGenerator.simple_type_return retval = new LogicalPlanGenerator.simple_type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree BOOLEAN91=null;
		CommonTree INT92=null;
		CommonTree LONG93=null;
		CommonTree FLOAT94=null;
		CommonTree DOUBLE95=null;
		CommonTree BIGINTEGER96=null;
		CommonTree BIGDECIMAL97=null;
		CommonTree DATETIME98=null;
		CommonTree CHARARRAY99=null;
		CommonTree BYTEARRAY100=null;

		CommonTree BOOLEAN91_tree=null;
		CommonTree INT92_tree=null;
		CommonTree LONG93_tree=null;
		CommonTree FLOAT94_tree=null;
		CommonTree DOUBLE95_tree=null;
		CommonTree BIGINTEGER96_tree=null;
		CommonTree BIGDECIMAL97_tree=null;
		CommonTree DATETIME98_tree=null;
		CommonTree CHARARRAY99_tree=null;
		CommonTree BYTEARRAY100_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:407:2: ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY )
			int alt25=10;
			switch ( input.LA(1) ) {
			case BOOLEAN:
				{
				alt25=1;
				}
				break;
			case INT:
				{
				alt25=2;
				}
				break;
			case LONG:
				{
				alt25=3;
				}
				break;
			case FLOAT:
				{
				alt25=4;
				}
				break;
			case DOUBLE:
				{
				alt25=5;
				}
				break;
			case BIGINTEGER:
				{
				alt25=6;
				}
				break;
			case BIGDECIMAL:
				{
				alt25=7;
				}
				break;
			case DATETIME:
				{
				alt25=8;
				}
				break;
			case CHARARRAY:
				{
				alt25=9;
				}
				break;
			case BYTEARRAY:
				{
				alt25=10;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 25, 0, input);
				throw nvae;
			}
			switch (alt25) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:407:4: BOOLEAN
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					BOOLEAN91=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_simple_type1197); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					BOOLEAN91_tree = (CommonTree)adaptor.dupNode(BOOLEAN91);


					adaptor.addChild(root_0, BOOLEAN91_tree);
					}

					if ( state.backtracking==0 ) { retval.datatype = DataType.BOOLEAN; }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:408:4: INT
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					INT92=(CommonTree)match(input,INT,FOLLOW_INT_in_simple_type1204); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INT92_tree = (CommonTree)adaptor.dupNode(INT92);


					adaptor.addChild(root_0, INT92_tree);
					}

					if ( state.backtracking==0 ) { retval.datatype = DataType.INTEGER; }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:409:4: LONG
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					LONG93=(CommonTree)match(input,LONG,FOLLOW_LONG_in_simple_type1211); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LONG93_tree = (CommonTree)adaptor.dupNode(LONG93);


					adaptor.addChild(root_0, LONG93_tree);
					}

					if ( state.backtracking==0 ) { retval.datatype = DataType.LONG; }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 4 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:410:4: FLOAT
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					FLOAT94=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_simple_type1218); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FLOAT94_tree = (CommonTree)adaptor.dupNode(FLOAT94);


					adaptor.addChild(root_0, FLOAT94_tree);
					}

					if ( state.backtracking==0 ) { retval.datatype = DataType.FLOAT; }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 5 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:411:4: DOUBLE
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					DOUBLE95=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_simple_type1225); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DOUBLE95_tree = (CommonTree)adaptor.dupNode(DOUBLE95);


					adaptor.addChild(root_0, DOUBLE95_tree);
					}

					if ( state.backtracking==0 ) { retval.datatype = DataType.DOUBLE; }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 6 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:412:4: BIGINTEGER
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					BIGINTEGER96=(CommonTree)match(input,BIGINTEGER,FOLLOW_BIGINTEGER_in_simple_type1232); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					BIGINTEGER96_tree = (CommonTree)adaptor.dupNode(BIGINTEGER96);


					adaptor.addChild(root_0, BIGINTEGER96_tree);
					}

					if ( state.backtracking==0 ) { retval.datatype = DataType.BIGINTEGER; }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 7 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:413:4: BIGDECIMAL
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					BIGDECIMAL97=(CommonTree)match(input,BIGDECIMAL,FOLLOW_BIGDECIMAL_in_simple_type1239); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					BIGDECIMAL97_tree = (CommonTree)adaptor.dupNode(BIGDECIMAL97);


					adaptor.addChild(root_0, BIGDECIMAL97_tree);
					}

					if ( state.backtracking==0 ) { retval.datatype = DataType.BIGDECIMAL; }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 8 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:414:4: DATETIME
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					DATETIME98=(CommonTree)match(input,DATETIME,FOLLOW_DATETIME_in_simple_type1246); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DATETIME98_tree = (CommonTree)adaptor.dupNode(DATETIME98);


					adaptor.addChild(root_0, DATETIME98_tree);
					}

					if ( state.backtracking==0 ) { retval.datatype = DataType.DATETIME; }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 9 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:415:4: CHARARRAY
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					CHARARRAY99=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_simple_type1253); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					CHARARRAY99_tree = (CommonTree)adaptor.dupNode(CHARARRAY99);


					adaptor.addChild(root_0, CHARARRAY99_tree);
					}

					if ( state.backtracking==0 ) { retval.datatype = DataType.CHARARRAY; }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 10 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:416:4: BYTEARRAY
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					BYTEARRAY100=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_simple_type1260); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					BYTEARRAY100_tree = (CommonTree)adaptor.dupNode(BYTEARRAY100);


					adaptor.addChild(root_0, BYTEARRAY100_tree);
					}

					if ( state.backtracking==0 ) { retval.datatype = DataType.BYTEARRAY; }
					if ( state.backtracking==0 ) {
					}

					}
					break;

			}
			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class tuple_type_return extends TreeRuleReturnScope {
		public LogicalSchema logicalSchema;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "tuple_type"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:419:1: tuple_type returns [LogicalSchema logicalSchema] : ^( TUPLE_TYPE ( field_def_list )? ) ;
	public final LogicalPlanGenerator.tuple_type_return tuple_type() throws RecognitionException {
		LogicalPlanGenerator.tuple_type_return retval = new LogicalPlanGenerator.tuple_type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree TUPLE_TYPE101=null;
		TreeRuleReturnScope field_def_list102 =null;

		CommonTree TUPLE_TYPE101_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:420:2: ( ^( TUPLE_TYPE ( field_def_list )? ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:420:4: ^( TUPLE_TYPE ( field_def_list )? )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			TUPLE_TYPE101=(CommonTree)match(input,TUPLE_TYPE,FOLLOW_TUPLE_TYPE_in_tuple_type1277); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			TUPLE_TYPE101_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE101);


			root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE101_tree, root_1);
			}

			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); if (state.failed) return retval;
				// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:421:7: ( field_def_list )?
				int alt26=2;
				int LA26_0 = input.LA(1);
				if ( ((LA26_0 >= FIELD_DEF && LA26_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
					alt26=1;
				}
				switch (alt26) {
					case 1 :
						// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:421:9: field_def_list
						{
						_last = (CommonTree)input.LT(1);
						pushFollow(FOLLOW_field_def_list_in_tuple_type1287);
						field_def_list102=field_def_list();
						state._fsp--;
						if (state.failed) return retval;
						if ( state.backtracking==0 ) 
						adaptor.addChild(root_1, field_def_list102.getTree());

						if ( state.backtracking==0 ) {
						            LogicalPlanBuilder.setBytearrayForNULLType((field_def_list102!=null?((LogicalPlanGenerator.field_def_list_return)field_def_list102).schema:null));
						            retval.logicalSchema = (field_def_list102!=null?((LogicalPlanGenerator.field_def_list_return)field_def_list102).schema:null);
						        }
						if ( state.backtracking==0 ) {
						}

						}
						break;

				}

				match(input, Token.UP, null); if (state.failed) return retval;
			}
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class bag_type_return extends TreeRuleReturnScope {
		public LogicalSchema logicalSchema;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "bag_type"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:430:1: bag_type returns [LogicalSchema logicalSchema] : ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) ;
	public final LogicalPlanGenerator.bag_type_return bag_type() throws RecognitionException {
		LogicalPlanGenerator.bag_type_return retval = new LogicalPlanGenerator.bag_type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree BAG_TYPE103=null;
		CommonTree IDENTIFIER104=null;
		TreeRuleReturnScope tuple_type105 =null;

		CommonTree BAG_TYPE103_tree=null;
		CommonTree IDENTIFIER104_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:431:2: ( ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:431:4: ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			BAG_TYPE103=(CommonTree)match(input,BAG_TYPE,FOLLOW_BAG_TYPE_in_bag_type1327); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			BAG_TYPE103_tree = (CommonTree)adaptor.dupNode(BAG_TYPE103);


			root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE103_tree, root_1);
			}

			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); if (state.failed) return retval;
				// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:431:16: ( IDENTIFIER )?
				int alt27=2;
				int LA27_0 = input.LA(1);
				if ( (LA27_0==IDENTIFIER) ) {
					alt27=1;
				}
				switch (alt27) {
					case 1 :
						// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:431:16: IDENTIFIER
						{
						_last = (CommonTree)input.LT(1);
						IDENTIFIER104=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_bag_type1329); if (state.failed) return retval;
						if ( state.backtracking==0 ) {
						IDENTIFIER104_tree = (CommonTree)adaptor.dupNode(IDENTIFIER104);


						adaptor.addChild(root_1, IDENTIFIER104_tree);
						}

						if ( state.backtracking==0 ) {
						}

						}
						break;

				}

				// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:431:28: ( tuple_type )?
				int alt28=2;
				int LA28_0 = input.LA(1);
				if ( (LA28_0==TUPLE_TYPE) ) {
					alt28=1;
				}
				switch (alt28) {
					case 1 :
						// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:431:28: tuple_type
						{
						_last = (CommonTree)input.LT(1);
						pushFollow(FOLLOW_tuple_type_in_bag_type1332);
						tuple_type105=tuple_type();
						state._fsp--;
						if (state.failed) return retval;
						if ( state.backtracking==0 ) 
						adaptor.addChild(root_1, tuple_type105.getTree());

						if ( state.backtracking==0 ) {
						}

						}
						break;

				}

				match(input, Token.UP, null); if (state.failed) return retval;
			}
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			       LogicalSchema s = new LogicalSchema();
			       s.addField(new LogicalFieldSchema((IDENTIFIER104!=null?IDENTIFIER104.getText():null), (tuple_type105!=null?((LogicalPlanGenerator.tuple_type_return)tuple_type105).logicalSchema:null), DataType.TUPLE));
			       retval.logicalSchema = s;
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "bag_type"


	public static class map_type_return extends TreeRuleReturnScope {
		public LogicalSchema logicalSchema;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "map_type"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:439:1: map_type returns [LogicalSchema logicalSchema] : ^( MAP_TYPE ( IDENTIFIER )? ( type )? ) ;
	public final LogicalPlanGenerator.map_type_return map_type() throws RecognitionException {
		LogicalPlanGenerator.map_type_return retval = new LogicalPlanGenerator.map_type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree MAP_TYPE106=null;
		CommonTree IDENTIFIER107=null;
		TreeRuleReturnScope type108 =null;

		CommonTree MAP_TYPE106_tree=null;
		CommonTree IDENTIFIER107_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:440:2: ( ^( MAP_TYPE ( IDENTIFIER )? ( type )? ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:440:4: ^( MAP_TYPE ( IDENTIFIER )? ( type )? )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			MAP_TYPE106=(CommonTree)match(input,MAP_TYPE,FOLLOW_MAP_TYPE_in_map_type1355); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			MAP_TYPE106_tree = (CommonTree)adaptor.dupNode(MAP_TYPE106);


			root_1 = (CommonTree)adaptor.becomeRoot(MAP_TYPE106_tree, root_1);
			}

			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); if (state.failed) return retval;
				// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:440:16: ( IDENTIFIER )?
				int alt29=2;
				int LA29_0 = input.LA(1);
				if ( (LA29_0==IDENTIFIER) ) {
					alt29=1;
				}
				switch (alt29) {
					case 1 :
						// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:440:16: IDENTIFIER
						{
						_last = (CommonTree)input.LT(1);
						IDENTIFIER107=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_map_type1357); if (state.failed) return retval;
						if ( state.backtracking==0 ) {
						IDENTIFIER107_tree = (CommonTree)adaptor.dupNode(IDENTIFIER107);


						adaptor.addChild(root_1, IDENTIFIER107_tree);
						}

						if ( state.backtracking==0 ) {
						}

						}
						break;

				}

				// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:440:28: ( type )?
				int alt30=2;
				int LA30_0 = input.LA(1);
				if ( (LA30_0==BIGDECIMAL||LA30_0==BIGINTEGER||LA30_0==BOOLEAN||LA30_0==BYTEARRAY||LA30_0==CHARARRAY||LA30_0==DATETIME||LA30_0==DOUBLE||LA30_0==FLOAT||LA30_0==INT||LA30_0==LONG||LA30_0==BAG_TYPE||LA30_0==MAP_TYPE||LA30_0==TUPLE_TYPE) ) {
					alt30=1;
				}
				switch (alt30) {
					case 1 :
						// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:440:28: type
						{
						_last = (CommonTree)input.LT(1);
						pushFollow(FOLLOW_type_in_map_type1360);
						type108=type();
						state._fsp--;
						if (state.failed) return retval;
						if ( state.backtracking==0 ) 
						adaptor.addChild(root_1, type108.getTree());

						if ( state.backtracking==0 ) {
						}

						}
						break;

				}

				match(input, Token.UP, null); if (state.failed) return retval;
			}
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			       LogicalSchema s = null;
			       if( (type108!=null?((LogicalPlanGenerator.type_return)type108).datatype:null) != null ) {
			           s = new LogicalSchema();
			           s.addField( new LogicalFieldSchema( (IDENTIFIER107!=null?IDENTIFIER107.getText():null), (type108!=null?((LogicalPlanGenerator.type_return)type108).logicalSchema:null), (type108!=null?((LogicalPlanGenerator.type_return)type108).datatype:null) ) );
			       }
			       retval.logicalSchema = s;
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class func_clause_return extends TreeRuleReturnScope {
		public Object funcSpec;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "func_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:451:1: func_clause[byte ft] returns [FuncSpec funcSpec] : ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) );
	public final LogicalPlanGenerator.func_clause_return func_clause(byte ft) throws RecognitionException {
		LogicalPlanGenerator.func_clause_return retval = new LogicalPlanGenerator.func_clause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree FUNC_REF109=null;
		CommonTree FUNC111=null;
		TreeRuleReturnScope func_name110 =null;
		TreeRuleReturnScope func_name112 =null;
		TreeRuleReturnScope func_args113 =null;

		CommonTree FUNC_REF109_tree=null;
		CommonTree FUNC111_tree=null;


		    SourceLocation loc = new SourceLocation( (LatinParserNode)((CommonTree)retval.start) );
		return retval;
	}
	// $ANTLR end "func_clause"


	public static class func_name_return extends TreeRuleReturnScope {
		public String funcName;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "func_name"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:473:1: func_name returns [String funcName] : p1= eid ( ( PERIOD | DOLLAR ) p2= eid )* ;
	public final LogicalPlanGenerator.func_name_return func_name() throws RecognitionException {
		LogicalPlanGenerator.func_name_return retval = new LogicalPlanGenerator.func_name_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree PERIOD114=null;
		CommonTree DOLLAR115=null;
		TreeRuleReturnScope p1 =null;
		TreeRuleReturnScope p2 =null;

		CommonTree PERIOD114_tree=null;
		CommonTree DOLLAR115_tree=null;

		 StringBuilder buf = new StringBuilder(); 
		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:475:2: (p1= eid ( ( PERIOD | DOLLAR ) p2= eid )* )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:475:4: p1= eid ( ( PERIOD | DOLLAR ) p2= eid )*
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_eid_in_func_name1439);
			p1=eid();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_0, p1.getTree());

			if ( state.backtracking==0 ) { buf.append( (p1!=null?((LogicalPlanGenerator.eid_return)p1).id:null) ); }
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:476:7: ( ( PERIOD | DOLLAR ) p2= eid )*
			loop34:
			while (true) {
				int alt34=2;
				int LA34_0 = input.LA(1);
				if ( (LA34_0==DOLLAR||LA34_0==PERIOD) ) {
					alt34=1;
				}

				switch (alt34) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:476:9: ( PERIOD | DOLLAR ) p2= eid
					{
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:476:9: ( PERIOD | DOLLAR )
					int alt33=2;
					int LA33_0 = input.LA(1);
					if ( (LA33_0==PERIOD) ) {
						alt33=1;
					}
					else if ( (LA33_0==DOLLAR) ) {
						alt33=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 33, 0, input);
						throw nvae;
					}

					switch (alt33) {
						case 1 :
							// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:476:11: PERIOD
							{
							_last = (CommonTree)input.LT(1);
							PERIOD114=(CommonTree)match(input,PERIOD,FOLLOW_PERIOD_in_func_name1453); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							PERIOD114_tree = (CommonTree)adaptor.dupNode(PERIOD114);


							adaptor.addChild(root_0, PERIOD114_tree);
							}

							if ( state.backtracking==0 ) { buf.append( (PERIOD114!=null?PERIOD114.getText():null) ); }
							if ( state.backtracking==0 ) {
							}

							}
							break;
						case 2 :
							// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:476:52: DOLLAR
							{
							_last = (CommonTree)input.LT(1);
							DOLLAR115=(CommonTree)match(input,DOLLAR,FOLLOW_DOLLAR_in_func_name1459); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							DOLLAR115_tree = (CommonTree)adaptor.dupNode(DOLLAR115);


							adaptor.addChild(root_0, DOLLAR115_tree);
							}

							if ( state.backtracking==0 ) { buf.append( (DOLLAR115!=null?DOLLAR115.getText():null) ); }
							if ( state.backtracking==0 ) {
							}

							}
							break;

					}

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_eid_in_func_name1475);
					p2=eid();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, p2.getTree());

					if ( state.backtracking==0 ) { buf.append( (p2!=null?((LogicalPlanGenerator.eid_return)p2).id:null) ); }
					if ( state.backtracking==0 ) {
					}

					}
					break;

				default :
					break loop34;
				}
			}

			if ( state.backtracking==0 ) {
			       retval.funcName = buf.toString();
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class func_args_return extends TreeRuleReturnScope {
		public List<String> args;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "func_args"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:483:1: func_args returns [List<String> args] : ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )+ ;
	public final LogicalPlanGenerator.func_args_return func_args() throws RecognitionException {
		LogicalPlanGenerator.func_args_return retval = new LogicalPlanGenerator.func_args_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree QUOTEDSTRING116=null;
		CommonTree MULTILINE_QUOTEDSTRING117=null;

		CommonTree QUOTEDSTRING116_tree=null;
		CommonTree MULTILINE_QUOTEDSTRING117_tree=null;

		 retval.args = new ArrayList<String>(); 
		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:485:3: ( ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )+ )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:485:3: ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:485:3: ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )+
			int cnt35=0;
			loop35:
			while (true) {
				int alt35=3;
				int LA35_0 = input.LA(1);
				if ( (LA35_0==QUOTEDSTRING) ) {
					alt35=1;
				}
				else if ( (LA35_0==MULTILINE_QUOTEDSTRING) ) {
					alt35=2;
				}

				switch (alt35) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:485:5: QUOTEDSTRING
					{
					_last = (CommonTree)input.LT(1);
					QUOTEDSTRING116=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_func_args1504); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					QUOTEDSTRING116_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING116);


					adaptor.addChild(root_0, QUOTEDSTRING116_tree);
					}

					if ( state.backtracking==0 ) { retval.args.add( builder.unquote( (QUOTEDSTRING116!=null?QUOTEDSTRING116.getText():null) ) ); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:486:7: MULTILINE_QUOTEDSTRING
					{
					_last = (CommonTree)input.LT(1);
					MULTILINE_QUOTEDSTRING117=(CommonTree)match(input,MULTILINE_QUOTEDSTRING,FOLLOW_MULTILINE_QUOTEDSTRING_in_func_args1514); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					MULTILINE_QUOTEDSTRING117_tree = (CommonTree)adaptor.dupNode(MULTILINE_QUOTEDSTRING117);


					adaptor.addChild(root_0, MULTILINE_QUOTEDSTRING117_tree);
					}

					if ( state.backtracking==0 ) { retval.args.add( builder.unquote( (MULTILINE_QUOTEDSTRING117!=null?MULTILINE_QUOTEDSTRING117.getText():null) ) ); }
					if ( state.backtracking==0 ) {
					}

					}
					break;

				default :
					if ( cnt35 >= 1 ) break loop35;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(35, input);
					throw eee;
				}
				cnt35++;
			}

			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	protected static class cube_clause_scope {
		LOCube cubeOp;
		MultiMap<Integer, LogicalExpressionPlan> cubePlans;
		List<String> operations;
		int inputIndex;
	}
	protected Stack<cube_clause_scope> cube_clause_stack = new Stack<cube_clause_scope>();

	public static class cube_clause_return extends TreeRuleReturnScope {
		public String alias;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};

	protected static class group_clause_scope {
		MultiMap<Integer, LogicalExpressionPlan> groupPlans;
		int inputIndex;
		List<String> inputAliases;
		List<Boolean> innerFlags;
	}
	protected Stack<group_clause_scope> group_clause_stack = new Stack<group_clause_scope>();

	public static class group_clause_return extends TreeRuleReturnScope {
		public String alias;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "group_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:573:1: group_clause returns [String alias] : ( ^( GROUP ( group_item )+ ( group_type )? ( partition_clause )? ) | ^( COGROUP ( group_item )+ ( group_type )? ( partition_clause )? ) );
	public final LogicalPlanGenerator.group_clause_return group_clause() throws RecognitionException {
		GScope_stack.push(new GScope_scope());
		group_clause_stack.push(new group_clause_scope());
		LogicalPlanGenerator.group_clause_return retval = new LogicalPlanGenerator.group_clause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree GROUP132=null;
		CommonTree COGROUP136=null;
		TreeRuleReturnScope group_item133 =null;
		TreeRuleReturnScope group_type134 =null;
		TreeRuleReturnScope partition_clause135 =null;
		TreeRuleReturnScope group_item137 =null;
		TreeRuleReturnScope group_type138 =null;
		TreeRuleReturnScope partition_clause139 =null;

		CommonTree GROUP132_tree=null;
		CommonTree COGROUP136_tree=null;


		    GScope_stack.peek().currentOp = builder.createGroupOp();
		    group_clause_stack.peek().groupPlans = new MultiMap<Integer, LogicalExpressionPlan>();
		    group_clause_stack.peek().inputAliases = new ArrayList<String>();
		    group_clause_stack.peek().innerFlags = new ArrayList<Boolean>();
		    GROUPTYPE groupType = GROUPTYPE.REGULAR;
		    SourceLocation loc = new SourceLocation( (LatinParserNode)((CommonTree)retval.start) );
		    int oldStatementIndex = statement_stack.peek().inputIndex;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:591:2: ( ^( GROUP ( group_item )+ ( group_type )? ( partition_clause )? ) | ^( COGROUP ( group_item )+ ( group_type )? ( partition_clause )? ) )
			int alt46=2;
			int LA46_0 = input.LA(1);
			if ( (LA46_0==GROUP) ) {
				alt46=1;
			}
			else if ( (LA46_0==COGROUP) ) {
				alt46=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 46, 0, input);
				throw nvae;
			}

			switch (alt46) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:591:4: ^( GROUP ( group_item )+ ( group_type )? ( partition_clause )? )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					GROUP132=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_group_clause1771); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					GROUP132_tree = (CommonTree)adaptor.dupNode(GROUP132);


					root_1 = (CommonTree)adaptor.becomeRoot(GROUP132_tree, root_1);
					}

					match(input, Token.DOWN, null); if (state.failed) return retval;
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:591:13: ( group_item )+
					int cnt40=0;
					loop40:
					while (true) {
						int alt40=2;
						int LA40_0 = input.LA(1);
						if ( (LA40_0==ARROBA||LA40_0==ASSERT||LA40_0==COGROUP||(LA40_0 >= CROSS && LA40_0 <= CUBE)||LA40_0==DEFINE||LA40_0==DISTINCT||LA40_0==FILTER||LA40_0==FOREACH||LA40_0==GROUP||LA40_0==IDENTIFIER||LA40_0==JOIN||(LA40_0 >= LIMIT && LA40_0 <= LOAD)||LA40_0==MAPREDUCE||LA40_0==ORDER||LA40_0==RANK||LA40_0==SAMPLE||(LA40_0 >= STORE && LA40_0 <= STREAM)||LA40_0==UNION) ) {
							alt40=1;
						}

						switch (alt40) {
						case 1 :
							// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:591:13: group_item
							{
							_last = (CommonTree)input.LT(1);
							pushFollow(FOLLOW_group_item_in_group_clause1773);
							group_item133=group_item();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) 
							adaptor.addChild(root_1, group_item133.getTree());

							if ( state.backtracking==0 ) {
							}

							}
							break;

						default :
							if ( cnt40 >= 1 ) break loop40;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(40, input);
							throw eee;
						}
						cnt40++;
					}

					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:591:25: ( group_type )?
					int alt41=2;
					int LA41_0 = input.LA(1);
					if ( (LA41_0==QUOTEDSTRING) ) {
						alt41=1;
					}
					switch (alt41) {
						case 1 :
							// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:591:27: group_type
							{
							_last = (CommonTree)input.LT(1);
							pushFollow(FOLLOW_group_type_in_group_clause1778);
							group_type134=group_type();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) 
							adaptor.addChild(root_1, group_type134.getTree());

							if ( state.backtracking==0 ) { groupType = (group_type134!=null?((LogicalPlanGenerator.group_type_return)group_type134).type:null); ((LOCogroup)GScope_stack.peek().currentOp).pinOption(LOCogroup.OPTION_GROUPTYPE); }
							if ( state.backtracking==0 ) {
							}

							}
							break;

					}

					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:591:146: ( partition_clause )?
					int alt42=2;
					int LA42_0 = input.LA(1);
					if ( (LA42_0==PARTITION) ) {
						alt42=1;
					}
					switch (alt42) {
						case 1 :
							// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:591:146: partition_clause
							{
							_last = (CommonTree)input.LT(1);
							pushFollow(FOLLOW_partition_clause_in_group_clause1785);
							partition_clause135=partition_clause();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) 
							adaptor.addChild(root_1, partition_clause135.getTree());

							if ( state.backtracking==0 ) {
							}

							}
							break;

					}

					match(input, Token.UP, null); if (state.failed) return retval;
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					if ( state.backtracking==0 ) {
					       retval.alias = builder.buildGroupOp( loc, (LOCogroup)GScope_stack.peek().currentOp, statement_stack.peek().alias,
					           group_clause_stack.peek().inputAliases, group_clause_stack.peek().groupPlans, groupType, group_clause_stack.peek().innerFlags,
					           (partition_clause135!=null?((LogicalPlanGenerator.partition_clause_return)partition_clause135).partitioner:null) );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:597:4: ^( COGROUP ( group_item )+ ( group_type )? ( partition_clause )? )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					COGROUP136=(CommonTree)match(input,COGROUP,FOLLOW_COGROUP_in_group_clause1800); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					COGROUP136_tree = (CommonTree)adaptor.dupNode(COGROUP136);


					root_1 = (CommonTree)adaptor.becomeRoot(COGROUP136_tree, root_1);
					}

					match(input, Token.DOWN, null); if (state.failed) return retval;
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:597:15: ( group_item )+
					int cnt43=0;
					loop43:
					while (true) {
						int alt43=2;
						int LA43_0 = input.LA(1);
						if ( (LA43_0==ARROBA||LA43_0==ASSERT||LA43_0==COGROUP||(LA43_0 >= CROSS && LA43_0 <= CUBE)||LA43_0==DEFINE||LA43_0==DISTINCT||LA43_0==FILTER||LA43_0==FOREACH||LA43_0==GROUP||LA43_0==IDENTIFIER||LA43_0==JOIN||(LA43_0 >= LIMIT && LA43_0 <= LOAD)||LA43_0==MAPREDUCE||LA43_0==ORDER||LA43_0==RANK||LA43_0==SAMPLE||(LA43_0 >= STORE && LA43_0 <= STREAM)||LA43_0==UNION) ) {
							alt43=1;
						}

						switch (alt43) {
						case 1 :
							// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:597:15: group_item
							{
							_last = (CommonTree)input.LT(1);
							pushFollow(FOLLOW_group_item_in_group_clause1802);
							group_item137=group_item();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) 
							adaptor.addChild(root_1, group_item137.getTree());

							if ( state.backtracking==0 ) {
							}

							}
							break;

						default :
							if ( cnt43 >= 1 ) break loop43;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(43, input);
							throw eee;
						}
						cnt43++;
					}

					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:597:27: ( group_type )?
					int alt44=2;
					int LA44_0 = input.LA(1);
					if ( (LA44_0==QUOTEDSTRING) ) {
						alt44=1;
					}
					switch (alt44) {
						case 1 :
							// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:597:29: group_type
							{
							_last = (CommonTree)input.LT(1);
							pushFollow(FOLLOW_group_type_in_group_clause1807);
							group_type138=group_type();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) 
							adaptor.addChild(root_1, group_type138.getTree());

							if ( state.backtracking==0 ) { groupType = (group_type138!=null?((LogicalPlanGenerator.group_type_return)group_type138).type:null);((LOCogroup)GScope_stack.peek().currentOp).pinOption(LOCogroup.OPTION_GROUPTYPE); }
							if ( state.backtracking==0 ) {
							}

							}
							break;

					}

					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:597:147: ( partition_clause )?
					int alt45=2;
					int LA45_0 = input.LA(1);
					if ( (LA45_0==PARTITION) ) {
						alt45=1;
					}
					switch (alt45) {
						case 1 :
							// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:597:147: partition_clause
							{
							_last = (CommonTree)input.LT(1);
							pushFollow(FOLLOW_partition_clause_in_group_clause1814);
							partition_clause139=partition_clause();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) 
							adaptor.addChild(root_1, partition_clause139.getTree());

							if ( state.backtracking==0 ) {
							}

							}
							break;

					}

					match(input, Token.UP, null); if (state.failed) return retval;
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					if ( state.backtracking==0 ) {
					       retval.alias = builder.buildGroupOp( loc, (LOCogroup)GScope_stack.peek().currentOp, statement_stack.peek().alias,
					           group_clause_stack.peek().inputAliases, group_clause_stack.peek().groupPlans, groupType, group_clause_stack.peek().innerFlags,
					           (partition_clause139!=null?((LogicalPlanGenerator.partition_clause_return)partition_clause139).partitioner:null) );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;

			}
			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			}

			if ( state.backtracking==0 ) { statement_stack.peek().inputIndex = oldStatementIndex; }
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
			GScope_stack.pop();
			group_clause_stack.pop();
		}
		return retval;
	}
	// $ANTLR end "group_clause"


	public static class group_type_return extends TreeRuleReturnScope {
		public GROUPTYPE type;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "group_type"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:605:1: group_type returns [GROUPTYPE type] : QUOTEDSTRING ;
	public final LogicalPlanGenerator.group_type_return group_type() throws RecognitionException {
		LogicalPlanGenerator.group_type_return retval = new LogicalPlanGenerator.group_type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree QUOTEDSTRING140=null;

		CommonTree QUOTEDSTRING140_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:606:2: ( QUOTEDSTRING )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:606:4: QUOTEDSTRING
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			QUOTEDSTRING140=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_group_type1835); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			QUOTEDSTRING140_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING140);


			adaptor.addChild(root_0, QUOTEDSTRING140_tree);
			}

			if ( state.backtracking==0 ) {
			       retval.type =builder.parseGroupType( (QUOTEDSTRING140!=null?QUOTEDSTRING140.getText():null), new SourceLocation( (LatinParserNode)QUOTEDSTRING140 ) );
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "group_type"


	public static class group_item_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "group_item"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:612:1: group_item : rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? ;
	public final LogicalPlanGenerator.group_item_return group_item() throws RecognitionException {
		LogicalPlanGenerator.group_item_return retval = new LogicalPlanGenerator.group_item_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree ALL143=null;
		CommonTree ANY144=null;
		CommonTree INNER145=null;
		CommonTree OUTER146=null;
		TreeRuleReturnScope rel141 =null;
		TreeRuleReturnScope join_group_by_clause142 =null;

		CommonTree ALL143_tree=null;
		CommonTree ANY144_tree=null;
		CommonTree INNER145_tree=null;
		CommonTree OUTER146_tree=null;

		 boolean inner = false; 
		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:614:2: ( rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:614:4: rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )?
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_rel_in_group_item1855);
			rel141=rel();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_0, rel141.getTree());

			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:614:8: ( join_group_by_clause | ALL | ANY )
			int alt47=3;
			switch ( input.LA(1) ) {
			case BY:
				{
				alt47=1;
				}
				break;
			case ALL:
				{
				alt47=2;
				}
				break;
			case ANY:
				{
				alt47=3;
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
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:614:10: join_group_by_clause
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_join_group_by_clause_in_group_item1859);
					join_group_by_clause142=join_group_by_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, join_group_by_clause142.getTree());

					if ( state.backtracking==0 ) {
					             group_clause_stack.peek().groupPlans.put( group_clause_stack.peek().inputIndex, (join_group_by_clause142!=null?((LogicalPlanGenerator.join_group_by_clause_return)join_group_by_clause142).plans:null) );
					         }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:618:12: ALL
					{
					_last = (CommonTree)input.LT(1);
					ALL143=(CommonTree)match(input,ALL,FOLLOW_ALL_in_group_item1883); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ALL143_tree = (CommonTree)adaptor.dupNode(ALL143);


					adaptor.addChild(root_0, ALL143_tree);
					}

					if ( state.backtracking==0 ) {
					             LogicalExpressionPlan plan = new LogicalExpressionPlan();
					             ConstantExpression ce = new ConstantExpression( plan, "all");
					             ce.setLocation( new SourceLocation( (LatinParserNode)ALL143 ) );
					             List<LogicalExpressionPlan> plans = new ArrayList<LogicalExpressionPlan>( 1 );
					             plans.add( plan );
					             group_clause_stack.peek().groupPlans.put( group_clause_stack.peek().inputIndex, plans );
					         }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:627:12: ANY
					{
					_last = (CommonTree)input.LT(1);
					ANY144=(CommonTree)match(input,ANY,FOLLOW_ANY_in_group_item1907); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ANY144_tree = (CommonTree)adaptor.dupNode(ANY144);


					adaptor.addChild(root_0, ANY144_tree);
					}

					if ( state.backtracking==0 ) {
					}

					}
					break;

			}

			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:636:11: ( INNER | OUTER )?
			int alt48=3;
			int LA48_0 = input.LA(1);
			if ( (LA48_0==INNER) ) {
				alt48=1;
			}
			else if ( (LA48_0==OUTER) ) {
				alt48=2;
			}
			switch (alt48) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:636:13: INNER
					{
					_last = (CommonTree)input.LT(1);
					INNER145=(CommonTree)match(input,INNER,FOLLOW_INNER_in_group_item1932); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INNER145_tree = (CommonTree)adaptor.dupNode(INNER145);


					adaptor.addChild(root_0, INNER145_tree);
					}

					if ( state.backtracking==0 ) { inner =  true; }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:636:40: OUTER
					{
					_last = (CommonTree)input.LT(1);
					OUTER146=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_group_item1938); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					OUTER146_tree = (CommonTree)adaptor.dupNode(OUTER146);


					adaptor.addChild(root_0, OUTER146_tree);
					}

					if ( state.backtracking==0 ) {
					}

					}
					break;

			}

			if ( state.backtracking==0 ) {
			       group_clause_stack.peek().inputAliases.add( statement_stack.peek().inputAlias );
			       group_clause_stack.peek().innerFlags.add( inner );
			       group_clause_stack.peek().inputIndex++;
			       statement_stack.peek().inputIndex++;
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class rel_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rel"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:645:1: rel : ( alias | previous_rel | inline_op );
	public final LogicalPlanGenerator.rel_return rel() throws RecognitionException {
		LogicalPlanGenerator.rel_return retval = new LogicalPlanGenerator.rel_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope alias147 =null;
		TreeRuleReturnScope previous_rel148 =null;
		TreeRuleReturnScope inline_op149 =null;


		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:646:2: ( alias | previous_rel | inline_op )
			int alt49=3;
			switch ( input.LA(1) ) {
			case IDENTIFIER:
				{
				alt49=1;
				}
				break;
			case ARROBA:
				{
				alt49=2;
				}
				break;
			case ASSERT:
			case COGROUP:
			case CROSS:
			case CUBE:
			case DEFINE:
			case DISTINCT:
			case FILTER:
			case FOREACH:
			case GROUP:
			case JOIN:
			case LIMIT:
			case LOAD:
			case MAPREDUCE:
			case ORDER:
			case RANK:
			case SAMPLE:
			case STORE:
			case STREAM:
			case UNION:
				{
				alt49=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 49, 0, input);
				throw nvae;
			}
			switch (alt49) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:646:4: alias
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_alias_in_rel1956);
					alias147=alias();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, alias147.getTree());

					if ( state.backtracking==0 ) {
					       statement_stack.peek().inputAlias = (alias147!=null?((LogicalPlanGenerator.alias_return)alias147).name:null);
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:650:4: previous_rel
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_previous_rel_in_rel1966);
					previous_rel148=previous_rel();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, previous_rel148.getTree());

					if ( state.backtracking==0 ) {
					       statement_stack.peek().inputAlias = (previous_rel148!=null?((LogicalPlanGenerator.previous_rel_return)previous_rel148).name:null);
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:654:4: inline_op
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_inline_op_in_rel1976);
					inline_op149=inline_op();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, inline_op149.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;

			}
			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class previous_rel_return extends TreeRuleReturnScope {
		public String name;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "previous_rel"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:657:1: previous_rel returns [String name] : ARROBA ;
	public final LogicalPlanGenerator.previous_rel_return previous_rel() throws RecognitionException {
		LogicalPlanGenerator.previous_rel_return retval = new LogicalPlanGenerator.previous_rel_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree ARROBA150=null;

		CommonTree ARROBA150_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:657:35: ( ARROBA )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:657:37: ARROBA
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			ARROBA150=(CommonTree)match(input,ARROBA,FOLLOW_ARROBA_in_previous_rel1988); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ARROBA150_tree = (CommonTree)adaptor.dupNode(ARROBA150);


			adaptor.addChild(root_0, ARROBA150_tree);
			}

			if ( state.backtracking==0 ) { retval.name = builder.getLastRel(new SourceLocation((LatinParserNode)ARROBA150)); }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class inline_op_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "inline_op"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:660:1: inline_op : op_clause ( parallel_clause )? ;
	public final LogicalPlanGenerator.inline_op_return inline_op() throws RecognitionException {
		LogicalPlanGenerator.inline_op_return retval = new LogicalPlanGenerator.inline_op_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope op_clause151 =null;
		TreeRuleReturnScope parallel_clause152 =null;



		    String al = statement_stack.peek().alias;
		    statement_stack.peek().alias = null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:668:2: ( op_clause ( parallel_clause )? )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:668:4: op_clause ( parallel_clause )?
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_op_clause_in_inline_op2010);
			op_clause151=op_clause();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_0, op_clause151.getTree());

			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:668:14: ( parallel_clause )?
			int alt50=2;
			int LA50_0 = input.LA(1);
			if ( (LA50_0==PARALLEL) ) {
				alt50=1;
			}
			switch (alt50) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:668:14: parallel_clause
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_parallel_clause_in_inline_op2012);
					parallel_clause152=parallel_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, parallel_clause152.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;

			}

			if ( state.backtracking==0 ) {
			       Operator op = builder.lookupOperator( (op_clause151!=null?((LogicalPlanGenerator.op_clause_return)op_clause151).alias:null) );
			       builder.setParallel( (LogicalRelationalOperator)op, statement_stack.peek().parallel );
			       statement_stack.peek().inputAlias = (op_clause151!=null?((LogicalPlanGenerator.op_clause_return)op_clause151).alias:null);
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			}

			if ( state.backtracking==0 ) {
			    statement_stack.peek().alias = al;
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
	// $ANTLR end "inline_op"


	public static class flatten_generated_item_return extends TreeRuleReturnScope {
		public LogicalExpressionPlan plan;
		public boolean flattenFlag;
		public LogicalSchema schema;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "flatten_generated_item"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:676:1: flatten_generated_item returns [LogicalExpressionPlan plan, boolean flattenFlag, LogicalSchema schema] : ( flatten_clause[$plan] | col_range[$plan] | expr[$plan] | STAR ) ( field_def_list )? ;
	public final LogicalPlanGenerator.flatten_generated_item_return flatten_generated_item() throws RecognitionException {
		LogicalPlanGenerator.flatten_generated_item_return retval = new LogicalPlanGenerator.flatten_generated_item_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree STAR156=null;
		TreeRuleReturnScope flatten_clause153 =null;
		TreeRuleReturnScope col_range154 =null;
		TreeRuleReturnScope expr155 =null;
		TreeRuleReturnScope field_def_list157 =null;

		CommonTree STAR156_tree=null;


		    retval.plan = new LogicalExpressionPlan();

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:680:2: ( ( flatten_clause[$plan] | col_range[$plan] | expr[$plan] | STAR ) ( field_def_list )? )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:680:4: ( flatten_clause[$plan] | col_range[$plan] | expr[$plan] | STAR ) ( field_def_list )?
			{
			root_0 = (CommonTree)adaptor.nil();


			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:680:4: ( flatten_clause[$plan] | col_range[$plan] | expr[$plan] | STAR )
			int alt51=4;
			switch ( input.LA(1) ) {
			case FLATTEN:
				{
				alt51=1;
				}
				break;
			case COL_RANGE:
				{
				alt51=2;
				}
				break;
			case BIGDECIMALNUMBER:
			case BIGINTEGERNUMBER:
			case CUBE:
			case DIV:
			case DOLLARVAR:
			case DOUBLENUMBER:
			case FALSE:
			case FLOATNUMBER:
			case GROUP:
			case IDENTIFIER:
			case INTEGER:
			case LONGINTEGER:
			case MINUS:
			case NULL:
			case PERCENT:
			case PLUS:
			case QUOTEDSTRING:
			case TRUE:
			case BAG_VAL:
			case BIN_EXPR:
			case CASE_COND:
			case CASE_EXPR:
			case CAST_EXPR:
			case EXPR_IN_PAREN:
			case FUNC_EVAL:
			case INVOKER_FUNC_EVAL:
			case MAP_VAL:
			case NEG:
			case TUPLE_VAL:
				{
				alt51=3;
				}
				break;
			case STAR:
				{
				int LA51_4 = input.LA(2);
				if ( (LA51_4==DOWN) ) {
					alt51=3;
				}
				else if ( (LA51_4==EOF||LA51_4==UP||LA51_4==BIGDECIMALNUMBER||LA51_4==BIGINTEGERNUMBER||LA51_4==CUBE||LA51_4==DIV||LA51_4==DOLLARVAR||LA51_4==DOUBLENUMBER||LA51_4==FALSE||LA51_4==FLATTEN||LA51_4==FLOATNUMBER||LA51_4==GROUP||LA51_4==IDENTIFIER||LA51_4==INTEGER||LA51_4==LONGINTEGER||LA51_4==MINUS||LA51_4==NULL||LA51_4==PERCENT||LA51_4==PLUS||LA51_4==QUOTEDSTRING||LA51_4==STAR||LA51_4==TRUE||(LA51_4 >= BAG_VAL && LA51_4 <= BIN_EXPR)||(LA51_4 >= CASE_COND && LA51_4 <= CASE_EXPR)||(LA51_4 >= CAST_EXPR && LA51_4 <= FIELD_DEF_WITHOUT_IDENTIFIER)||LA51_4==FUNC_EVAL||LA51_4==INVOKER_FUNC_EVAL||(LA51_4 >= MAP_VAL && LA51_4 <= NEG)||LA51_4==TUPLE_VAL) ) {
					alt51=4;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 51, 4, input);
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
					new NoViableAltException("", 51, 0, input);
				throw nvae;
			}
			switch (alt51) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:680:6: flatten_clause[$plan]
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_flatten_clause_in_flatten_generated_item2038);
					flatten_clause153=flatten_clause(retval.plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, flatten_clause153.getTree());

					if ( state.backtracking==0 ) { retval.flattenFlag = true; }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:681:6: col_range[$plan]
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_col_range_in_flatten_generated_item2048);
					col_range154=col_range(retval.plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, col_range154.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:682:6: expr[$plan]
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_flatten_generated_item2056);
					expr155=expr(retval.plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, expr155.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 4 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:683:6: STAR
					{
					_last = (CommonTree)input.LT(1);
					STAR156=(CommonTree)match(input,STAR,FOLLOW_STAR_in_flatten_generated_item2064); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STAR156_tree = (CommonTree)adaptor.dupNode(STAR156);


					adaptor.addChild(root_0, STAR156_tree);
					}

					if ( state.backtracking==0 ) {
					         builder.buildProjectExpr( new SourceLocation( (LatinParserNode)STAR156 ), retval.plan, GScope_stack.peek().currentOp,
					             statement_stack.peek().inputIndex, null, -1 );
					     }
					if ( state.backtracking==0 ) {
					}

					}
					break;

			}

			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:689:4: ( field_def_list )?
			int alt52=2;
			int LA52_0 = input.LA(1);
			if ( ((LA52_0 >= FIELD_DEF && LA52_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
				alt52=1;
			}
			switch (alt52) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:689:6: field_def_list
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_field_def_list_in_flatten_generated_item2083);
					field_def_list157=field_def_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, field_def_list157.getTree());

					if ( state.backtracking==0 ) { retval.schema = (field_def_list157!=null?((LogicalPlanGenerator.field_def_list_return)field_def_list157).schema:null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;

			}

			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class flatten_clause_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "flatten_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:692:1: flatten_clause[LogicalExpressionPlan plan] : ^( FLATTEN expr[$plan] ) ;
	public final LogicalPlanGenerator.flatten_clause_return flatten_clause(LogicalExpressionPlan plan) throws RecognitionException {
		LogicalPlanGenerator.flatten_clause_return retval = new LogicalPlanGenerator.flatten_clause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree FLATTEN158=null;
		TreeRuleReturnScope expr159 =null;

		CommonTree FLATTEN158_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:693:2: ( ^( FLATTEN expr[$plan] ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:693:4: ^( FLATTEN expr[$plan] )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			FLATTEN158=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_flatten_clause2101); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			FLATTEN158_tree = (CommonTree)adaptor.dupNode(FLATTEN158);


			root_1 = (CommonTree)adaptor.becomeRoot(FLATTEN158_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_expr_in_flatten_clause2103);
			expr159=expr(plan);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, expr159.getTree());

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class store_clause_return extends TreeRuleReturnScope {
		public String alias;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "store_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:696:1: store_clause returns [String alias] : ^( STORE rel filename ( func_clause[FunctionType.STOREFUNC] )? ) ;
	public final LogicalPlanGenerator.store_clause_return store_clause() throws RecognitionException {
		LogicalPlanGenerator.store_clause_return retval = new LogicalPlanGenerator.store_clause_return();
		retval.start = input.LT(1);
        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;


        CommonTree STORE160=null;
        TreeRuleReturnScope rel161 =null;
        TreeRuleReturnScope filename162 =null;
        TreeRuleReturnScope func_clause163 =null;

        CommonTree STORE160_tree=null;

        try {
            // LogicalPlanGenerator.g4:697:2: ( ^( STORE rel filename ( func_clause[FunctionType.STOREFUNC] )? ) )
            // LogicalPlanGenerator.g4:697:4: ^( STORE rel filename ( func_clause[FunctionType.STOREFUNC] )? )
            {
                root_0 = (CommonTree)adaptor.nil();


                _last = (CommonTree)input.LT(1);
                {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STORE160=(CommonTree)match(input,STORE,FOLLOW_STORE_in_store_clause2121); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                        STORE160_tree = (CommonTree)adaptor.dupNode(STORE160);


                        root_1 = (CommonTree)adaptor.becomeRoot(STORE160_tree, root_1);
                    }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_in_store_clause2123);
                    rel161=rel();
                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 )
                        adaptor.addChild(root_1, rel161.getTree());

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_filename_in_store_clause2125);
                    filename162=filename();
                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 )
                        adaptor.addChild(root_1, filename162.getTree());

                    // LogicalPlanGenerator.g4:697:26: ( func_clause[FunctionType.STOREFUNC] )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);
                    if ( (LA53_0==FUNC||LA53_0==FUNC_REF) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // LogicalPlanGenerator.g4:697:26: func_clause[FunctionType.STOREFUNC]
                        {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_func_clause_in_store_clause2127);
                            func_clause163=func_clause(FunctionType.STOREFUNC);
                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 )
                                adaptor.addChild(root_1, func_clause163.getTree());

                            if ( state.backtracking==0 ) {
                            }

                        }
                        break;

                    }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                }


                if ( state.backtracking==0 ) {
                    SourceLocation loc = new SourceLocation( (LatinParserNode)STORE160 );
                    retval.alias = builder.buildStoreOp( loc, statement_stack.peek().alias,
                            statement_stack.peek().inputAlias, (filename162!=null?((LogicalPlanGenerator.filename_return)filename162).filename:null), (func_clause163!=null?((LogicalPlanGenerator.func_clause_return)func_clause163).funcSpec:null) );
                }
                if ( state.backtracking==0 ) {
                }

            }

            if ( state.backtracking==0 ) {

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class assert_clause_return extends TreeRuleReturnScope {
		public String alias;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "assert_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:705:1: assert_clause returns [String alias] : ^( ASSERT rel cond[exprPlan] ( comment )? ) ;
	public final LogicalPlanGenerator.assert_clause_return assert_clause() throws RecognitionException {
		GScope_stack.push(new GScope_scope());

		LogicalPlanGenerator.assert_clause_return retval = new LogicalPlanGenerator.assert_clause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree ASSERT164=null;
		TreeRuleReturnScope rel165 =null;
		TreeRuleReturnScope cond166 =null;
		TreeRuleReturnScope comment167 =null;

		CommonTree ASSERT164_tree=null;


		    GScope_stack.peek().currentOp = builder.createFilterOp();
		    LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:711:2: ( ^( ASSERT rel cond[exprPlan] ( comment )? ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:711:4: ^( ASSERT rel cond[exprPlan] ( comment )? )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			ASSERT164=(CommonTree)match(input,ASSERT,FOLLOW_ASSERT_in_assert_clause2161); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ASSERT164_tree = (CommonTree)adaptor.dupNode(ASSERT164);


			root_1 = (CommonTree)adaptor.becomeRoot(ASSERT164_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_rel_in_assert_clause2163);
			rel165=rel();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, rel165.getTree());

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_cond_in_assert_clause2165);
			cond166=cond(exprPlan);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, cond166.getTree());

			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:711:33: ( comment )?
			int alt54=2;
			int LA54_0 = input.LA(1);
			if ( (LA54_0==QUOTEDSTRING) ) {
				alt54=1;
			}
			switch (alt54) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:711:33: comment
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_comment_in_assert_clause2168);
					comment167=comment();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, comment167.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;

			}

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			}

		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
			GScope_stack.pop();

		}
		return retval;
	}
	// $ANTLR end "assert_clause"


	public static class comment_return extends TreeRuleReturnScope {
		public String comment;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "comment"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:719:1: comment returns [String comment] : QUOTEDSTRING ;
	public final LogicalPlanGenerator.comment_return comment() throws RecognitionException {
		LogicalPlanGenerator.comment_return retval = new LogicalPlanGenerator.comment_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree QUOTEDSTRING168=null;

		CommonTree QUOTEDSTRING168_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:720:2: ( QUOTEDSTRING )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:720:4: QUOTEDSTRING
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			QUOTEDSTRING168=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_comment2189); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			QUOTEDSTRING168_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING168);


			adaptor.addChild(root_0, QUOTEDSTRING168_tree);
			}

			if ( state.backtracking==0 ) { retval.comment = builder.unquote( (QUOTEDSTRING168!=null?QUOTEDSTRING168.getText():null) ); }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "comment"


	public static class filter_clause_return extends TreeRuleReturnScope {
		public String alias;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "filter_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:723:1: filter_clause returns [String alias] : ^( FILTER rel cond[exprPlan] ) ;
	public final LogicalPlanGenerator.filter_clause_return filter_clause() throws RecognitionException {
		GScope_stack.push(new GScope_scope());

		LogicalPlanGenerator.filter_clause_return retval = new LogicalPlanGenerator.filter_clause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree FILTER169=null;
		TreeRuleReturnScope rel170 =null;
		TreeRuleReturnScope cond171 =null;

		CommonTree FILTER169_tree=null;


		    LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();
		    GScope_stack.peek().currentOp = builder.createFilterOp();

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:729:2: ( ^( FILTER rel cond[exprPlan] ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:729:4: ^( FILTER rel cond[exprPlan] )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			FILTER169=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_filter_clause2216); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			FILTER169_tree = (CommonTree)adaptor.dupNode(FILTER169);


			root_1 = (CommonTree)adaptor.becomeRoot(FILTER169_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_rel_in_filter_clause2218);
			rel170=rel();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, rel170.getTree());

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_cond_in_filter_clause2220);
			cond171=cond(exprPlan);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, cond171.getTree());

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			       retval.alias = builder.buildFilterOp( new SourceLocation( (LatinParserNode)FILTER169 ),
			           (LOFilter)GScope_stack.peek().currentOp, statement_stack.peek().alias,
			           statement_stack.peek().inputAlias, exprPlan );
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			}

		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
			GScope_stack.pop();

		}
		return retval;
	}
	// $ANTLR end "filter_clause"


	public static class cond_return extends TreeRuleReturnScope {
		public LogicalExpression expr;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "cond"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:737:1: cond[LogicalExpressionPlan exprPlan] returns [LogicalExpression expr] : ( ^( OR left= cond[exprPlan] right= cond[exprPlan] ) | ^( AND left= cond[exprPlan] right= cond[exprPlan] ) | ^( NOT c= cond[exprPlan] ) | ^( NULL expr[$exprPlan] ( NOT )? ) | ^( rel_op_eq e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_ne e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_lt e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_lte e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_gt e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_gte e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( STR_OP_MATCHES e1= expr[$exprPlan] e2= expr[$exprPlan] ) | in_eval[$exprPlan] | func_eval[$exprPlan] | ^( BOOL_COND e1= expr[$exprPlan] ) );
	public final LogicalPlanGenerator.cond_return cond(LogicalExpressionPlan exprPlan) throws RecognitionException {
		LogicalPlanGenerator.cond_return retval = new LogicalPlanGenerator.cond_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree OR172=null;
		CommonTree AND173=null;
		CommonTree NOT174=null;
		CommonTree NULL175=null;
		CommonTree NOT177=null;
		CommonTree STR_OP_MATCHES184=null;
		CommonTree BOOL_COND187=null;
		TreeRuleReturnScope left =null;
		TreeRuleReturnScope right =null;
		TreeRuleReturnScope c =null;
		TreeRuleReturnScope e1 =null;
		TreeRuleReturnScope e2 =null;
		TreeRuleReturnScope expr176 =null;
		TreeRuleReturnScope rel_op_eq178 =null;
		TreeRuleReturnScope rel_op_ne179 =null;
		TreeRuleReturnScope rel_op_lt180 =null;
		TreeRuleReturnScope rel_op_lte181 =null;
		TreeRuleReturnScope rel_op_gt182 =null;
		TreeRuleReturnScope rel_op_gte183 =null;
		TreeRuleReturnScope in_eval185 =null;
		TreeRuleReturnScope func_eval186 =null;

		CommonTree OR172_tree=null;
		CommonTree AND173_tree=null;
		CommonTree NOT174_tree=null;
		CommonTree NULL175_tree=null;
		CommonTree NOT177_tree=null;
		CommonTree STR_OP_MATCHES184_tree=null;
		CommonTree BOOL_COND187_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:738:2: ( ^( OR left= cond[exprPlan] right= cond[exprPlan] ) | ^( AND left= cond[exprPlan] right= cond[exprPlan] ) | ^( NOT c= cond[exprPlan] ) | ^( NULL expr[$exprPlan] ( NOT )? ) | ^( rel_op_eq e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_ne e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_lt e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_lte e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_gt e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_gte e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( STR_OP_MATCHES e1= expr[$exprPlan] e2= expr[$exprPlan] ) | in_eval[$exprPlan] | func_eval[$exprPlan] | ^( BOOL_COND e1= expr[$exprPlan] ) )
			int alt56=14;
			switch ( input.LA(1) ) {
			case OR:
				{
				alt56=1;
				}
				break;
			case AND:
				{
				alt56=2;
				}
				break;
			case NOT:
				{
				alt56=3;
				}
				break;
			case NULL:
				{
				alt56=4;
				}
				break;
			case NUM_OP_EQ:
			case STR_OP_EQ:
				{
				alt56=5;
				}
				break;
			case NUM_OP_NE:
			case STR_OP_NE:
				{
				alt56=6;
				}
				break;
			case NUM_OP_LT:
			case STR_OP_LT:
				{
				alt56=7;
				}
				break;
			case NUM_OP_LTE:
			case STR_OP_LTE:
				{
				alt56=8;
				}
				break;
			case NUM_OP_GT:
			case STR_OP_GT:
				{
				alt56=9;
				}
				break;
			case NUM_OP_GTE:
			case STR_OP_GTE:
				{
				alt56=10;
				}
				break;
			case STR_OP_MATCHES:
				{
				alt56=11;
				}
				break;
			case IN:
				{
				alt56=12;
				}
				break;
			case FUNC_EVAL:
			case INVOKER_FUNC_EVAL:
				{
				alt56=13;
				}
				break;
			case BOOL_COND:
				{
				alt56=14;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 56, 0, input);
				throw nvae;
			}
			switch (alt56) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:738:4: ^( OR left= cond[exprPlan] right= cond[exprPlan] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					OR172=(CommonTree)match(input,OR,FOLLOW_OR_in_cond2244); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					OR172_tree = (CommonTree)adaptor.dupNode(OR172);


					root_1 = (CommonTree)adaptor.becomeRoot(OR172_tree, root_1);
					}

					match(input, Token.DOWN, null); if (state.failed) return retval;
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_cond_in_cond2250);
					left=cond(exprPlan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, left.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_cond_in_cond2257);
					right=cond(exprPlan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, right.getTree());

					match(input, Token.UP, null); if (state.failed) return retval;
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					if ( state.backtracking==0 ) {
					       retval.expr = new OrExpression( exprPlan, (left!=null?((LogicalPlanGenerator.cond_return)left).expr:null), (right!=null?((LogicalPlanGenerator.cond_return)right).expr:null) );
					       retval.expr.setLocation( new SourceLocation( (LatinParserNode)OR172 ) );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:743:4: ^( AND left= cond[exprPlan] right= cond[exprPlan] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					AND173=(CommonTree)match(input,AND,FOLLOW_AND_in_cond2272); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					AND173_tree = (CommonTree)adaptor.dupNode(AND173);


					root_1 = (CommonTree)adaptor.becomeRoot(AND173_tree, root_1);
					}

					match(input, Token.DOWN, null); if (state.failed) return retval;
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_cond_in_cond2278);
					left=cond(exprPlan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, left.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_cond_in_cond2285);
					right=cond(exprPlan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, right.getTree());

					match(input, Token.UP, null); if (state.failed) return retval;
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					if ( state.backtracking==0 ) {
					       retval.expr = new AndExpression( exprPlan, (left!=null?((LogicalPlanGenerator.cond_return)left).expr:null), (right!=null?((LogicalPlanGenerator.cond_return)right).expr:null) );
					       retval.expr.setLocation( new SourceLocation( (LatinParserNode)AND173 ) );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:748:4: ^( NOT c= cond[exprPlan] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					NOT174=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond2300); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NOT174_tree = (CommonTree)adaptor.dupNode(NOT174);


					root_1 = (CommonTree)adaptor.becomeRoot(NOT174_tree, root_1);
					}

					match(input, Token.DOWN, null); if (state.failed) return retval;
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_cond_in_cond2306);
					c=cond(exprPlan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, c.getTree());

					match(input, Token.UP, null); if (state.failed) return retval;
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					if ( state.backtracking==0 ) {
					       retval.expr = new NotExpression( exprPlan, (c!=null?((LogicalPlanGenerator.cond_return)c).expr:null) );
					       retval.expr.setLocation( new SourceLocation( (LatinParserNode)NOT174 ) );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 4 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:753:4: ^( NULL expr[$exprPlan] ( NOT )? )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					NULL175=(CommonTree)match(input,NULL,FOLLOW_NULL_in_cond2321); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NULL175_tree = (CommonTree)adaptor.dupNode(NULL175);


					root_1 = (CommonTree)adaptor.becomeRoot(NULL175_tree, root_1);
					}

					match(input, Token.DOWN, null); if (state.failed) return retval;
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_cond2323);
					expr176=expr(exprPlan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, expr176.getTree());

					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:753:28: ( NOT )?
					int alt55=2;
					int LA55_0 = input.LA(1);
					if ( (LA55_0==NOT) ) {
						alt55=1;
					}
					switch (alt55) {
						case 1 :
							// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:753:28: NOT
							{
							_last = (CommonTree)input.LT(1);
							NOT177=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond2326); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							NOT177_tree = (CommonTree)adaptor.dupNode(NOT177);


							adaptor.addChild(root_1, NOT177_tree);
							}

							if ( state.backtracking==0 ) {
							}

							}
							break;

					}

					match(input, Token.UP, null); if (state.failed) return retval;
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					if ( state.backtracking==0 ) {
					       retval.expr = new IsNullExpression( exprPlan, (expr176!=null?((LogicalPlanGenerator.expr_return)expr176).expr:null) );
					       retval.expr.setLocation( new SourceLocation( (LatinParserNode)NULL175 ) );
					       if( NOT177 != null ) {
					           retval.expr = new NotExpression( exprPlan, retval.expr );
					           retval.expr.setLocation( new SourceLocation( (LatinParserNode)NOT177 ) );
					       }
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 5 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:762:4: ^( rel_op_eq e1= expr[$exprPlan] e2= expr[$exprPlan] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_rel_op_eq_in_cond2341);
					rel_op_eq178=rel_op_eq();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_eq178.getTree(), root_1);

					match(input, Token.DOWN, null); if (state.failed) return retval;
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_cond2347);
					e1=expr(exprPlan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, e1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_cond2354);
					e2=expr(exprPlan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, e2.getTree());

					match(input, Token.UP, null); if (state.failed) return retval;
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					if ( state.backtracking==0 ) {
					       retval.expr = new EqualExpression( exprPlan, (e1!=null?((LogicalPlanGenerator.expr_return)e1).expr:null), (e2!=null?((LogicalPlanGenerator.expr_return)e2).expr:null) );
					       retval.expr.setLocation( new SourceLocation( (LatinParserNode)(rel_op_eq178!=null?((CommonTree)rel_op_eq178.start):null) ) );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 6 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:767:4: ^( rel_op_ne e1= expr[$exprPlan] e2= expr[$exprPlan] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_rel_op_ne_in_cond2369);
					rel_op_ne179=rel_op_ne();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_ne179.getTree(), root_1);

					match(input, Token.DOWN, null); if (state.failed) return retval;
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_cond2375);
					e1=expr(exprPlan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, e1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_cond2382);
					e2=expr(exprPlan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, e2.getTree());

					match(input, Token.UP, null); if (state.failed) return retval;
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					if ( state.backtracking==0 ) {
					       retval.expr = new NotEqualExpression( exprPlan, (e1!=null?((LogicalPlanGenerator.expr_return)e1).expr:null), (e2!=null?((LogicalPlanGenerator.expr_return)e2).expr:null) );
					       retval.expr.setLocation( new SourceLocation( (LatinParserNode)(rel_op_ne179!=null?((CommonTree)rel_op_ne179.start):null) ) );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 7 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:772:4: ^( rel_op_lt e1= expr[$exprPlan] e2= expr[$exprPlan] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_rel_op_lt_in_cond2397);
					rel_op_lt180=rel_op_lt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_lt180.getTree(), root_1);

					match(input, Token.DOWN, null); if (state.failed) return retval;
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_cond2403);
					e1=expr(exprPlan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, e1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_cond2410);
					e2=expr(exprPlan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, e2.getTree());

					match(input, Token.UP, null); if (state.failed) return retval;
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					if ( state.backtracking==0 ) {
					       retval.expr = new LessThanExpression( exprPlan, (e1!=null?((LogicalPlanGenerator.expr_return)e1).expr:null), (e2!=null?((LogicalPlanGenerator.expr_return)e2).expr:null) );
					       retval.expr.setLocation( new SourceLocation( (LatinParserNode)(rel_op_lt180!=null?((CommonTree)rel_op_lt180.start):null) ) );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 8 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:777:4: ^( rel_op_lte e1= expr[$exprPlan] e2= expr[$exprPlan] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_rel_op_lte_in_cond2425);
					rel_op_lte181=rel_op_lte();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_lte181.getTree(), root_1);

					match(input, Token.DOWN, null); if (state.failed) return retval;
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_cond2431);
					e1=expr(exprPlan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, e1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_cond2438);
					e2=expr(exprPlan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, e2.getTree());

					match(input, Token.UP, null); if (state.failed) return retval;
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					if ( state.backtracking==0 ) {
					       retval.expr = new LessThanEqualExpression( exprPlan, (e1!=null?((LogicalPlanGenerator.expr_return)e1).expr:null), (e2!=null?((LogicalPlanGenerator.expr_return)e2).expr:null) );
					       retval.expr.setLocation( new SourceLocation( (LatinParserNode)(rel_op_lte181!=null?((CommonTree)rel_op_lte181.start):null) ) );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 9 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:782:4: ^( rel_op_gt e1= expr[$exprPlan] e2= expr[$exprPlan] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_rel_op_gt_in_cond2453);
					rel_op_gt182=rel_op_gt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_gt182.getTree(), root_1);

					match(input, Token.DOWN, null); if (state.failed) return retval;
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_cond2459);
					e1=expr(exprPlan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, e1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_cond2466);
					e2=expr(exprPlan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, e2.getTree());

					match(input, Token.UP, null); if (state.failed) return retval;
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					if ( state.backtracking==0 ) {
					       retval.expr = new GreaterThanExpression( exprPlan, (e1!=null?((LogicalPlanGenerator.expr_return)e1).expr:null), (e2!=null?((LogicalPlanGenerator.expr_return)e2).expr:null) );
					       retval.expr.setLocation( new SourceLocation( (LatinParserNode)(rel_op_gt182!=null?((CommonTree)rel_op_gt182.start):null) ) );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 10 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:787:4: ^( rel_op_gte e1= expr[$exprPlan] e2= expr[$exprPlan] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_rel_op_gte_in_cond2481);
					rel_op_gte183=rel_op_gte();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_gte183.getTree(), root_1);

					match(input, Token.DOWN, null); if (state.failed) return retval;
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_cond2487);
					e1=expr(exprPlan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, e1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_cond2494);
					e2=expr(exprPlan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, e2.getTree());

					match(input, Token.UP, null); if (state.failed) return retval;
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					if ( state.backtracking==0 ) {
					       retval.expr = new GreaterThanEqualExpression( exprPlan, (e1!=null?((LogicalPlanGenerator.expr_return)e1).expr:null), (e2!=null?((LogicalPlanGenerator.expr_return)e2).expr:null) );
					       retval.expr.setLocation( new SourceLocation( (LatinParserNode)(rel_op_gte183!=null?((CommonTree)rel_op_gte183.start):null) ) );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 11 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:792:4: ^( STR_OP_MATCHES e1= expr[$exprPlan] e2= expr[$exprPlan] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					STR_OP_MATCHES184=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_cond2509); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STR_OP_MATCHES184_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES184);


					root_1 = (CommonTree)adaptor.becomeRoot(STR_OP_MATCHES184_tree, root_1);
					}

					match(input, Token.DOWN, null); if (state.failed) return retval;
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_cond2515);
					e1=expr(exprPlan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, e1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_cond2522);
					e2=expr(exprPlan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, e2.getTree());

					match(input, Token.UP, null); if (state.failed) return retval;
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					if ( state.backtracking==0 ) {
					       retval.expr = new RegexExpression( exprPlan, (e1!=null?((LogicalPlanGenerator.expr_return)e1).expr:null), (e2!=null?((LogicalPlanGenerator.expr_return)e2).expr:null) );
					       retval.expr.setLocation( new SourceLocation( (LatinParserNode)STR_OP_MATCHES184 ) );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 12 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:797:4: in_eval[$exprPlan]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_in_eval_in_cond2535);
					in_eval185=in_eval(exprPlan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, in_eval185.getTree());

					if ( state.backtracking==0 ) {
					       retval.expr = (in_eval185!=null?((LogicalPlanGenerator.in_eval_return)in_eval185).expr:null);
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 13 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:801:4: func_eval[$exprPlan]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_func_eval_in_cond2546);
					func_eval186=func_eval(exprPlan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, func_eval186.getTree());

					if ( state.backtracking==0 ) {
					       retval.expr = (func_eval186!=null?((LogicalPlanGenerator.func_eval_return)func_eval186).expr:null);
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 14 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:805:4: ^( BOOL_COND e1= expr[$exprPlan] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					BOOL_COND187=(CommonTree)match(input,BOOL_COND,FOLLOW_BOOL_COND_in_cond2559); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					BOOL_COND187_tree = (CommonTree)adaptor.dupNode(BOOL_COND187);


					root_1 = (CommonTree)adaptor.becomeRoot(BOOL_COND187_tree, root_1);
					}

					match(input, Token.DOWN, null); if (state.failed) return retval;
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_cond2565);
					e1=expr(exprPlan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, e1.getTree());

					match(input, Token.UP, null); if (state.failed) return retval;
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					if ( state.backtracking==0 ) {
					       retval.expr = (e1!=null?((LogicalPlanGenerator.expr_return)e1).expr:null);
					       retval.expr.setLocation( new SourceLocation( (LatinParserNode)BOOL_COND187 ) );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;

			}
			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class in_eval_return extends TreeRuleReturnScope {
		public LogicalExpression expr;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "in_eval"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:812:1: in_eval[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ^( IN ( ^( IN_LHS lhs= expr[$plan] ) ^( IN_RHS rhs= expr[$plan] ) )+ ) ;
	public final LogicalPlanGenerator.in_eval_return in_eval(LogicalExpressionPlan plan) throws RecognitionException {
		LogicalPlanGenerator.in_eval_return retval = new LogicalPlanGenerator.in_eval_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree IN188=null;
		CommonTree IN_LHS189=null;
		CommonTree IN_RHS190=null;
		TreeRuleReturnScope lhs =null;
		TreeRuleReturnScope rhs =null;

		CommonTree IN188_tree=null;
		CommonTree IN_LHS189_tree=null;
		CommonTree IN_RHS190_tree=null;


		    List<LogicalExpression> lhsExprs = new ArrayList<LogicalExpression>();
		    List<LogicalExpression> rhsExprs = new ArrayList<LogicalExpression>();

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:817:2: ( ^( IN ( ^( IN_LHS lhs= expr[$plan] ) ^( IN_RHS rhs= expr[$plan] ) )+ ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:817:4: ^( IN ( ^( IN_LHS lhs= expr[$plan] ) ^( IN_RHS rhs= expr[$plan] ) )+ )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			IN188=(CommonTree)match(input,IN,FOLLOW_IN_in_in_eval2594); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			IN188_tree = (CommonTree)adaptor.dupNode(IN188);


			root_1 = (CommonTree)adaptor.becomeRoot(IN188_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:817:10: ( ^( IN_LHS lhs= expr[$plan] ) ^( IN_RHS rhs= expr[$plan] ) )+
			int cnt57=0;
			loop57:
			while (true) {
				int alt57=2;
				int LA57_0 = input.LA(1);
				if ( (LA57_0==IN_LHS) ) {
					alt57=1;
				}

				switch (alt57) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:817:12: ^( IN_LHS lhs= expr[$plan] ) ^( IN_RHS rhs= expr[$plan] )
					{
					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_2 = _last;
					CommonTree _first_2 = null;
					CommonTree root_2 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					IN_LHS189=(CommonTree)match(input,IN_LHS,FOLLOW_IN_LHS_in_in_eval2600); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IN_LHS189_tree = (CommonTree)adaptor.dupNode(IN_LHS189);


					root_2 = (CommonTree)adaptor.becomeRoot(IN_LHS189_tree, root_2);
					}

					match(input, Token.DOWN, null); if (state.failed) return retval;
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_in_eval2606);
					lhs=expr(plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_2, lhs.getTree());

					match(input, Token.UP, null); if (state.failed) return retval;
					adaptor.addChild(root_1, root_2);
					_last = _save_last_2;
					}


					if ( state.backtracking==0 ) { lhsExprs.add((lhs!=null?((LogicalPlanGenerator.expr_return)lhs).expr:null)); }
					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_2 = _last;
					CommonTree _first_2 = null;
					CommonTree root_2 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					IN_RHS190=(CommonTree)match(input,IN_RHS,FOLLOW_IN_RHS_in_in_eval2626); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IN_RHS190_tree = (CommonTree)adaptor.dupNode(IN_RHS190);


					root_2 = (CommonTree)adaptor.becomeRoot(IN_RHS190_tree, root_2);
					}

					match(input, Token.DOWN, null); if (state.failed) return retval;
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_in_eval2632);
					rhs=expr(plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_2, rhs.getTree());

					match(input, Token.UP, null); if (state.failed) return retval;
					adaptor.addChild(root_1, root_2);
					_last = _save_last_2;
					}


					if ( state.backtracking==0 ) { rhsExprs.add((rhs!=null?((LogicalPlanGenerator.expr_return)rhs).expr:null)); }
					if ( state.backtracking==0 ) {
					}

					}
					break;

				default :
					if ( cnt57 >= 1 ) break loop57;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(57, input);
					throw eee;
				}
				cnt57++;
			}

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			        // Convert IN tree to nested or expressions. Please also see
			        // QueryParser.g for how IN tree is constructed from IN expression.
			        EqualExpression firstBoolExpr = new EqualExpression(plan, lhsExprs.get(0), rhsExprs.get(0));
			        if (lhsExprs.size() == 1) {
			            retval.expr = firstBoolExpr;
			        } else {
			            OrExpression currOrExpr = null;
			            OrExpression prevOrExpr = null;
			            for (int i = 1; i < lhsExprs.size(); i++) {
			                EqualExpression boolExpr = new EqualExpression(plan, lhsExprs.get(i), rhsExprs.get(i));
			                currOrExpr = new OrExpression( plan, prevOrExpr == null ? firstBoolExpr : prevOrExpr, boolExpr );
			                prevOrExpr = currOrExpr;
			            }
			            retval.expr = currOrExpr;
			        }
			        retval.expr.setLocation( new SourceLocation( (LatinParserNode)((CommonTree)retval.start) ) );
			    }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "in_eval"


	public static class func_eval_return extends TreeRuleReturnScope {
		public LogicalExpression expr;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "func_eval"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:839:1: func_eval[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ( ^( FUNC_EVAL func_name ( real_arg[$plan] )* ) | ^( INVOKER_FUNC_EVAL package_name= IDENTIFIER function_name= IDENTIFIER is_static= IDENTIFIER ( real_arg[$plan] )* ) );
	public final LogicalPlanGenerator.func_eval_return func_eval(LogicalExpressionPlan plan) throws RecognitionException {
		LogicalPlanGenerator.func_eval_return retval = new LogicalPlanGenerator.func_eval_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree package_name=null;
		CommonTree function_name=null;
		CommonTree is_static=null;
		CommonTree FUNC_EVAL191=null;
		CommonTree INVOKER_FUNC_EVAL194=null;
		TreeRuleReturnScope func_name192 =null;
		TreeRuleReturnScope real_arg193 =null;
		TreeRuleReturnScope real_arg195 =null;

		CommonTree package_name_tree=null;
		CommonTree function_name_tree=null;
		CommonTree is_static_tree=null;
		CommonTree FUNC_EVAL191_tree=null;
		CommonTree INVOKER_FUNC_EVAL194_tree=null;


		    List<LogicalExpression> args = new ArrayList<LogicalExpression>();

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:843:2: ( ^( FUNC_EVAL func_name ( real_arg[$plan] )* ) | ^( INVOKER_FUNC_EVAL package_name= IDENTIFIER function_name= IDENTIFIER is_static= IDENTIFIER ( real_arg[$plan] )* ) )
			int alt60=2;
			int LA60_0 = input.LA(1);
			if ( (LA60_0==FUNC_EVAL) ) {
				alt60=1;
			}
			else if ( (LA60_0==INVOKER_FUNC_EVAL) ) {
				alt60=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 60, 0, input);
				throw nvae;
			}

			switch (alt60) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:843:4: ^( FUNC_EVAL func_name ( real_arg[$plan] )* )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					FUNC_EVAL191=(CommonTree)match(input,FUNC_EVAL,FOLLOW_FUNC_EVAL_in_func_eval2669); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FUNC_EVAL191_tree = (CommonTree)adaptor.dupNode(FUNC_EVAL191);


					root_1 = (CommonTree)adaptor.becomeRoot(FUNC_EVAL191_tree, root_1);
					}

					match(input, Token.DOWN, null); if (state.failed) return retval;
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_func_name_in_func_eval2671);
					func_name192=func_name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, func_name192.getTree());

					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:843:27: ( real_arg[$plan] )*
					loop58:
					while (true) {
						int alt58=2;
						int LA58_0 = input.LA(1);
						if ( (LA58_0==BIGDECIMALNUMBER||LA58_0==BIGINTEGERNUMBER||LA58_0==CUBE||LA58_0==DIV||LA58_0==DOLLARVAR||LA58_0==DOUBLENUMBER||LA58_0==FALSE||LA58_0==FLOATNUMBER||LA58_0==GROUP||LA58_0==IDENTIFIER||LA58_0==INTEGER||LA58_0==LONGINTEGER||LA58_0==MINUS||LA58_0==NULL||LA58_0==PERCENT||LA58_0==PLUS||LA58_0==QUOTEDSTRING||LA58_0==STAR||LA58_0==TRUE||(LA58_0 >= BAG_VAL && LA58_0 <= BIN_EXPR)||(LA58_0 >= CASE_COND && LA58_0 <= CASE_EXPR)||(LA58_0 >= CAST_EXPR && LA58_0 <= EXPR_IN_PAREN)||LA58_0==FUNC_EVAL||LA58_0==INVOKER_FUNC_EVAL||(LA58_0 >= MAP_VAL && LA58_0 <= NEG)||LA58_0==TUPLE_VAL) ) {
							alt58=1;
						}

						switch (alt58) {
						case 1 :
							// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:843:29: real_arg[$plan]
							{
							_last = (CommonTree)input.LT(1);
							pushFollow(FOLLOW_real_arg_in_func_eval2675);
							real_arg193=real_arg(plan);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) 
							adaptor.addChild(root_1, real_arg193.getTree());

							if ( state.backtracking==0 ) { args.add( (real_arg193!=null?((LogicalPlanGenerator.real_arg_return)real_arg193).expr:null) ); }
							if ( state.backtracking==0 ) {
							}

							}
							break;

						default :
							break loop58;
						}
					}

					match(input, Token.UP, null); if (state.failed) return retval;
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					if ( state.backtracking==0 ) {
					       SourceLocation loc = new SourceLocation( (LatinParserNode)(func_name192!=null?((CommonTree)func_name192.start):null) );
					       retval.expr = builder.buildUDF( loc, plan, (func_name192!=null?((LogicalPlanGenerator.func_name_return)func_name192).funcName:null), args );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:848:4: ^( INVOKER_FUNC_EVAL package_name= IDENTIFIER function_name= IDENTIFIER is_static= IDENTIFIER ( real_arg[$plan] )* )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					INVOKER_FUNC_EVAL194=(CommonTree)match(input,INVOKER_FUNC_EVAL,FOLLOW_INVOKER_FUNC_EVAL_in_func_eval2695); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INVOKER_FUNC_EVAL194_tree = (CommonTree)adaptor.dupNode(INVOKER_FUNC_EVAL194);


					root_1 = (CommonTree)adaptor.becomeRoot(INVOKER_FUNC_EVAL194_tree, root_1);
					}

					match(input, Token.DOWN, null); if (state.failed) return retval;
					_last = (CommonTree)input.LT(1);
					package_name=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_func_eval2699); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					package_name_tree = (CommonTree)adaptor.dupNode(package_name);


					adaptor.addChild(root_1, package_name_tree);
					}

					_last = (CommonTree)input.LT(1);
					function_name=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_func_eval2703); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					function_name_tree = (CommonTree)adaptor.dupNode(function_name);


					adaptor.addChild(root_1, function_name_tree);
					}

					_last = (CommonTree)input.LT(1);
					is_static=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_func_eval2707); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					is_static_tree = (CommonTree)adaptor.dupNode(is_static);


					adaptor.addChild(root_1, is_static_tree);
					}

					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:848:95: ( real_arg[$plan] )*
					loop59:
					while (true) {
						int alt59=2;
						int LA59_0 = input.LA(1);
						if ( (LA59_0==BIGDECIMALNUMBER||LA59_0==BIGINTEGERNUMBER||LA59_0==CUBE||LA59_0==DIV||LA59_0==DOLLARVAR||LA59_0==DOUBLENUMBER||LA59_0==FALSE||LA59_0==FLOATNUMBER||LA59_0==GROUP||LA59_0==IDENTIFIER||LA59_0==INTEGER||LA59_0==LONGINTEGER||LA59_0==MINUS||LA59_0==NULL||LA59_0==PERCENT||LA59_0==PLUS||LA59_0==QUOTEDSTRING||LA59_0==STAR||LA59_0==TRUE||(LA59_0 >= BAG_VAL && LA59_0 <= BIN_EXPR)||(LA59_0 >= CASE_COND && LA59_0 <= CASE_EXPR)||(LA59_0 >= CAST_EXPR && LA59_0 <= EXPR_IN_PAREN)||LA59_0==FUNC_EVAL||LA59_0==INVOKER_FUNC_EVAL||(LA59_0 >= MAP_VAL && LA59_0 <= NEG)||LA59_0==TUPLE_VAL) ) {
							alt59=1;
						}

						switch (alt59) {
						case 1 :
							// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:848:97: real_arg[$plan]
							{
							_last = (CommonTree)input.LT(1);
							pushFollow(FOLLOW_real_arg_in_func_eval2711);
							real_arg195=real_arg(plan);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) 
							adaptor.addChild(root_1, real_arg195.getTree());

							if ( state.backtracking==0 ) { args.add( (real_arg195!=null?((LogicalPlanGenerator.real_arg_return)real_arg195).expr:null) ); }
							if ( state.backtracking==0 ) {
							}

							}
							break;

						default :
							break loop59;
						}
					}

					match(input, Token.UP, null); if (state.failed) return retval;
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					if ( state.backtracking==0 ) {
					       SourceLocation loc = new SourceLocation( (LatinParserNode)function_name );
					       retval.expr = builder.buildInvokerUDF( loc, plan, (package_name!=null?package_name.getText():null), (function_name!=null?function_name.getText():null), Boolean.parseBoolean((is_static!=null?is_static.getText():null)), args );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;

			}
			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "func_eval"


	public static class real_arg_return extends TreeRuleReturnScope {
		public LogicalExpression expr;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "real_arg"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:855:1: real_arg[LogicalExpressionPlan plan] returns [LogicalExpression expr] : (e= expr[$plan] | STAR |cr= col_range[$plan] );
	public final LogicalPlanGenerator.real_arg_return real_arg(LogicalExpressionPlan plan) throws RecognitionException {
		LogicalPlanGenerator.real_arg_return retval = new LogicalPlanGenerator.real_arg_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree STAR196=null;
		TreeRuleReturnScope e =null;
		TreeRuleReturnScope cr =null;

		CommonTree STAR196_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:856:2: (e= expr[$plan] | STAR |cr= col_range[$plan] )
			int alt61=3;
			switch ( input.LA(1) ) {
			case BIGDECIMALNUMBER:
			case BIGINTEGERNUMBER:
			case CUBE:
			case DIV:
			case DOLLARVAR:
			case DOUBLENUMBER:
			case FALSE:
			case FLOATNUMBER:
			case GROUP:
			case IDENTIFIER:
			case INTEGER:
			case LONGINTEGER:
			case MINUS:
			case NULL:
			case PERCENT:
			case PLUS:
			case QUOTEDSTRING:
			case TRUE:
			case BAG_VAL:
			case BIN_EXPR:
			case CASE_COND:
			case CASE_EXPR:
			case CAST_EXPR:
			case EXPR_IN_PAREN:
			case FUNC_EVAL:
			case INVOKER_FUNC_EVAL:
			case MAP_VAL:
			case NEG:
			case TUPLE_VAL:
				{
				alt61=1;
				}
				break;
			case STAR:
				{
				int LA61_2 = input.LA(2);
				if ( (LA61_2==DOWN) ) {
					alt61=1;
				}
				else if ( (LA61_2==EOF||LA61_2==UP||LA61_2==BIGDECIMALNUMBER||LA61_2==BIGINTEGERNUMBER||LA61_2==CUBE||LA61_2==DIV||LA61_2==DOLLARVAR||LA61_2==DOUBLENUMBER||LA61_2==FALSE||LA61_2==FLOATNUMBER||LA61_2==GROUP||LA61_2==IDENTIFIER||LA61_2==INTEGER||LA61_2==LONGINTEGER||LA61_2==MINUS||LA61_2==NULL||LA61_2==PERCENT||LA61_2==PLUS||LA61_2==QUOTEDSTRING||LA61_2==STAR||LA61_2==TRUE||(LA61_2 >= BAG_VAL && LA61_2 <= BIN_EXPR)||(LA61_2 >= CASE_COND && LA61_2 <= CASE_EXPR)||(LA61_2 >= CAST_EXPR && LA61_2 <= EXPR_IN_PAREN)||LA61_2==FUNC_EVAL||LA61_2==INVOKER_FUNC_EVAL||(LA61_2 >= MAP_VAL && LA61_2 <= NEG)||LA61_2==TUPLE_VAL) ) {
					alt61=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 61, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case COL_RANGE:
				{
				alt61=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 61, 0, input);
				throw nvae;
			}
			switch (alt61) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:856:4: e= expr[$plan]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_real_arg2743);
					e=expr(plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, e.getTree());

					if ( state.backtracking==0 ) { retval.expr = (e!=null?((LogicalPlanGenerator.expr_return)e).expr:null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:857:4: STAR
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					STAR196=(CommonTree)match(input,STAR,FOLLOW_STAR_in_real_arg2751); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STAR196_tree = (CommonTree)adaptor.dupNode(STAR196);


					adaptor.addChild(root_0, STAR196_tree);
					}

					if ( state.backtracking==0 ) {
					       retval.expr = builder.buildProjectExpr( new SourceLocation( (LatinParserNode)STAR196 ), plan, GScope_stack.peek().currentOp,
					           statement_stack.peek().inputIndex, null, -1 );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:862:4: cr= col_range[$plan]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_col_range_in_real_arg2765);
					cr=col_range(plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, cr.getTree());

					if ( state.backtracking==0 ) { retval.expr = (cr!=null?((LogicalPlanGenerator.col_range_return)cr).expr:null);}
					if ( state.backtracking==0 ) {
					}

					}
					break;

			}
			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class expr_return extends TreeRuleReturnScope {
		public LogicalExpression expr;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expr"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:865:1: expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ( ^( PLUS left= expr[$plan] right= expr[$plan] ) | ^( MINUS left= expr[$plan] right= expr[$plan] ) | ^( STAR left= expr[$plan] right= expr[$plan] ) | ^( DIV left= expr[$plan] right= expr[$plan] ) | ^( PERCENT left= expr[$plan] right= expr[$plan] ) | const_expr[$plan] | var_expr[$plan] | ^( NEG e= expr[$plan] ) | ^( CAST_EXPR type_cast e= expr[$plan] ) | ^( EXPR_IN_PAREN e= expr[$plan] ) );
	public final LogicalPlanGenerator.expr_return expr(LogicalExpressionPlan plan) throws RecognitionException {
		LogicalPlanGenerator.expr_return retval = new LogicalPlanGenerator.expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree PLUS197=null;
		CommonTree MINUS198=null;
		CommonTree STAR199=null;
		CommonTree DIV200=null;
		CommonTree PERCENT201=null;
		CommonTree NEG204=null;
		CommonTree CAST_EXPR205=null;
		CommonTree EXPR_IN_PAREN207=null;
		TreeRuleReturnScope left =null;
		TreeRuleReturnScope right =null;
		TreeRuleReturnScope e =null;
		TreeRuleReturnScope const_expr202 =null;
		TreeRuleReturnScope var_expr203 =null;
		TreeRuleReturnScope type_cast206 =null;

		CommonTree PLUS197_tree=null;
		CommonTree MINUS198_tree=null;
		CommonTree STAR199_tree=null;
		CommonTree DIV200_tree=null;
		CommonTree PERCENT201_tree=null;
		CommonTree NEG204_tree=null;
		CommonTree CAST_EXPR205_tree=null;
		CommonTree EXPR_IN_PAREN207_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:866:2: ( ^( PLUS left= expr[$plan] right= expr[$plan] ) | ^( MINUS left= expr[$plan] right= expr[$plan] ) | ^( STAR left= expr[$plan] right= expr[$plan] ) | ^( DIV left= expr[$plan] right= expr[$plan] ) | ^( PERCENT left= expr[$plan] right= expr[$plan] ) | const_expr[$plan] | var_expr[$plan] | ^( NEG e= expr[$plan] ) | ^( CAST_EXPR type_cast e= expr[$plan] ) | ^( EXPR_IN_PAREN e= expr[$plan] ) )
			int alt62=10;
			switch ( input.LA(1) ) {
			case PLUS:
				{
				alt62=1;
				}
				break;
			case MINUS:
				{
				int LA62_2 = input.LA(2);
				if ( (LA62_2==DOWN) ) {
					alt62=2;
				}
				else if ( (LA62_2==BIGDECIMALNUMBER||LA62_2==BIGINTEGERNUMBER||LA62_2==DOUBLENUMBER||LA62_2==FLOATNUMBER||LA62_2==INTEGER||LA62_2==LONGINTEGER) ) {
					alt62=6;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 62, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case STAR:
				{
				alt62=3;
				}
				break;
			case DIV:
				{
				alt62=4;
				}
				break;
			case PERCENT:
				{
				alt62=5;
				}
				break;
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
			case BAG_VAL:
			case MAP_VAL:
			case TUPLE_VAL:
				{
				alt62=6;
				}
				break;
			case CUBE:
			case DOLLARVAR:
			case GROUP:
			case IDENTIFIER:
			case BIN_EXPR:
			case CASE_COND:
			case CASE_EXPR:
			case FUNC_EVAL:
			case INVOKER_FUNC_EVAL:
				{
				alt62=7;
				}
				break;
			case NEG:
				{
				alt62=8;
				}
				break;
			case CAST_EXPR:
				{
				alt62=9;
				}
				break;
			case EXPR_IN_PAREN:
				{
				alt62=10;
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
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:866:4: ^( PLUS left= expr[$plan] right= expr[$plan] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					PLUS197=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expr2784); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					PLUS197_tree = (CommonTree)adaptor.dupNode(PLUS197);


					root_1 = (CommonTree)adaptor.becomeRoot(PLUS197_tree, root_1);
					}

					match(input, Token.DOWN, null); if (state.failed) return retval;
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_expr2790);
					left=expr(plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, left.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_expr2797);
					right=expr(plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, right.getTree());

					match(input, Token.UP, null); if (state.failed) return retval;
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					if ( state.backtracking==0 ) {
					       retval.expr = new AddExpression( plan, (left!=null?((LogicalPlanGenerator.expr_return)left).expr:null), (right!=null?((LogicalPlanGenerator.expr_return)right).expr:null) );
					       retval.expr.setLocation( new SourceLocation( (LatinParserNode)PLUS197 ) );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:871:4: ^( MINUS left= expr[$plan] right= expr[$plan] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					MINUS198=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expr2812); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					MINUS198_tree = (CommonTree)adaptor.dupNode(MINUS198);


					root_1 = (CommonTree)adaptor.becomeRoot(MINUS198_tree, root_1);
					}

					match(input, Token.DOWN, null); if (state.failed) return retval;
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_expr2818);
					left=expr(plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, left.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_expr2825);
					right=expr(plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, right.getTree());

					match(input, Token.UP, null); if (state.failed) return retval;
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					if ( state.backtracking==0 ) {
					       retval.expr = new SubtractExpression( plan, (left!=null?((LogicalPlanGenerator.expr_return)left).expr:null), (right!=null?((LogicalPlanGenerator.expr_return)right).expr:null) );
					       retval.expr.setLocation( new SourceLocation( (LatinParserNode)MINUS198 ) );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:876:4: ^( STAR left= expr[$plan] right= expr[$plan] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					STAR199=(CommonTree)match(input,STAR,FOLLOW_STAR_in_expr2840); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STAR199_tree = (CommonTree)adaptor.dupNode(STAR199);


					root_1 = (CommonTree)adaptor.becomeRoot(STAR199_tree, root_1);
					}

					match(input, Token.DOWN, null); if (state.failed) return retval;
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_expr2846);
					left=expr(plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, left.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_expr2853);
					right=expr(plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, right.getTree());

					match(input, Token.UP, null); if (state.failed) return retval;
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					if ( state.backtracking==0 ) {
					       retval.expr = new MultiplyExpression( plan, (left!=null?((LogicalPlanGenerator.expr_return)left).expr:null), (right!=null?((LogicalPlanGenerator.expr_return)right).expr:null) );
					       retval.expr.setLocation( new SourceLocation( (LatinParserNode)STAR199 ) );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 4 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:881:4: ^( DIV left= expr[$plan] right= expr[$plan] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					DIV200=(CommonTree)match(input,DIV,FOLLOW_DIV_in_expr2868); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DIV200_tree = (CommonTree)adaptor.dupNode(DIV200);


					root_1 = (CommonTree)adaptor.becomeRoot(DIV200_tree, root_1);
					}

					match(input, Token.DOWN, null); if (state.failed) return retval;
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_expr2874);
					left=expr(plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, left.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_expr2881);
					right=expr(plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, right.getTree());

					match(input, Token.UP, null); if (state.failed) return retval;
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					if ( state.backtracking==0 ) {
					       retval.expr = new DivideExpression( plan, (left!=null?((LogicalPlanGenerator.expr_return)left).expr:null), (right!=null?((LogicalPlanGenerator.expr_return)right).expr:null) );
					       retval.expr.setLocation( new SourceLocation( (LatinParserNode)DIV200 ) );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 5 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:886:4: ^( PERCENT left= expr[$plan] right= expr[$plan] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					PERCENT201=(CommonTree)match(input,PERCENT,FOLLOW_PERCENT_in_expr2896); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					PERCENT201_tree = (CommonTree)adaptor.dupNode(PERCENT201);


					root_1 = (CommonTree)adaptor.becomeRoot(PERCENT201_tree, root_1);
					}

					match(input, Token.DOWN, null); if (state.failed) return retval;
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_expr2902);
					left=expr(plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, left.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_expr2909);
					right=expr(plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, right.getTree());

					match(input, Token.UP, null); if (state.failed) return retval;
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					if ( state.backtracking==0 ) {
					       retval.expr = new ModExpression( plan, (left!=null?((LogicalPlanGenerator.expr_return)left).expr:null), (right!=null?((LogicalPlanGenerator.expr_return)right).expr:null) );
					       retval.expr.setLocation( new SourceLocation( (LatinParserNode)PERCENT201 ) );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 6 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:891:4: const_expr[$plan]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_const_expr_in_expr2922);
					const_expr202=const_expr(plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, const_expr202.getTree());

					if ( state.backtracking==0 ) {
					       retval.expr = (const_expr202!=null?((LogicalPlanGenerator.const_expr_return)const_expr202).expr:null);
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 7 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:895:4: var_expr[$plan]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_var_expr_in_expr2933);
					var_expr203=var_expr(plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, var_expr203.getTree());

					if ( state.backtracking==0 ) {
					       retval.expr = (var_expr203!=null?((LogicalPlanGenerator.var_expr_return)var_expr203).expr:null);
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 8 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:899:4: ^( NEG e= expr[$plan] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					NEG204=(CommonTree)match(input,NEG,FOLLOW_NEG_in_expr2946); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NEG204_tree = (CommonTree)adaptor.dupNode(NEG204);


					root_1 = (CommonTree)adaptor.becomeRoot(NEG204_tree, root_1);
					}

					match(input, Token.DOWN, null); if (state.failed) return retval;
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_expr2952);
					e=expr(plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, e.getTree());

					match(input, Token.UP, null); if (state.failed) return retval;
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					if ( state.backtracking==0 ) {
					       retval.expr = new NegativeExpression( plan, (e!=null?((LogicalPlanGenerator.expr_return)e).expr:null) );
					       retval.expr.setLocation( new SourceLocation( (LatinParserNode)(e!=null?((CommonTree)e.start):null) ) );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 9 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:904:4: ^( CAST_EXPR type_cast e= expr[$plan] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					CAST_EXPR205=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr2967); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					CAST_EXPR205_tree = (CommonTree)adaptor.dupNode(CAST_EXPR205);


					root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR205_tree, root_1);
					}

					match(input, Token.DOWN, null); if (state.failed) return retval;
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_type_cast_in_expr2969);
					type_cast206=type_cast();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, type_cast206.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_expr2975);
					e=expr(plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, e.getTree());

					match(input, Token.UP, null); if (state.failed) return retval;
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 10 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:909:4: ^( EXPR_IN_PAREN e= expr[$plan] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					EXPR_IN_PAREN207=(CommonTree)match(input,EXPR_IN_PAREN,FOLLOW_EXPR_IN_PAREN_in_expr2991); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					EXPR_IN_PAREN207_tree = (CommonTree)adaptor.dupNode(EXPR_IN_PAREN207);


					root_1 = (CommonTree)adaptor.becomeRoot(EXPR_IN_PAREN207_tree, root_1);
					}

					match(input, Token.DOWN, null); if (state.failed) return retval;
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_expr2997);
					e=expr(plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, e.getTree());

					match(input, Token.UP, null); if (state.failed) return retval;
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					if ( state.backtracking==0 ) {
					       retval.expr = (e!=null?((LogicalPlanGenerator.expr_return)e).expr:null);
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;

			}
			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class type_cast_return extends TreeRuleReturnScope {
		public LogicalFieldSchema fieldSchema;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "type_cast"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:915:1: type_cast returns [LogicalFieldSchema fieldSchema] : ( simple_type | map_type | tuple_type_cast | bag_type_cast );
	public final LogicalPlanGenerator.type_cast_return type_cast() throws RecognitionException {
		LogicalPlanGenerator.type_cast_return retval = new LogicalPlanGenerator.type_cast_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope simple_type208 =null;
		TreeRuleReturnScope map_type209 =null;
		TreeRuleReturnScope tuple_type_cast210 =null;
		TreeRuleReturnScope bag_type_cast211 =null;


		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:916:2: ( simple_type | map_type | tuple_type_cast | bag_type_cast )
			int alt63=4;
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
				alt63=1;
				}
				break;
			case MAP_TYPE:
				{
				alt63=2;
				}
				break;
			case TUPLE_TYPE_CAST:
				{
				alt63=3;
				}
				break;
			case BAG_TYPE_CAST:
				{
				alt63=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 63, 0, input);
				throw nvae;
			}
			switch (alt63) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:916:4: simple_type
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_simple_type_in_type_cast3019);
					simple_type208=simple_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, simple_type208.getTree());

					if ( state.backtracking==0 ) {
					        retval.fieldSchema = new LogicalFieldSchema( null, null, (simple_type208!=null?((LogicalPlanGenerator.simple_type_return)simple_type208).datatype:0) );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:920:4: map_type
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_map_type_in_type_cast3029);
					map_type209=map_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, map_type209.getTree());

					if ( state.backtracking==0 ) {
					       retval.fieldSchema = new LogicalFieldSchema( null, (map_type209!=null?((LogicalPlanGenerator.map_type_return)map_type209).logicalSchema:null), DataType.MAP );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:924:4: tuple_type_cast
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_tuple_type_cast_in_type_cast3039);
					tuple_type_cast210=tuple_type_cast();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, tuple_type_cast210.getTree());

					if ( state.backtracking==0 ) {
					       retval.fieldSchema = new LogicalFieldSchema( null, (tuple_type_cast210!=null?((LogicalPlanGenerator.tuple_type_cast_return)tuple_type_cast210).logicalSchema:null), DataType.TUPLE );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 4 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:928:4: bag_type_cast
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_bag_type_cast_in_type_cast3049);
					bag_type_cast211=bag_type_cast();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, bag_type_cast211.getTree());

					if ( state.backtracking==0 ) {
					       retval.fieldSchema = new LogicalFieldSchema( null, (bag_type_cast211!=null?((LogicalPlanGenerator.bag_type_cast_return)bag_type_cast211).logicalSchema:null), DataType.BAG );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;

			}
			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "type_cast"


	public static class tuple_type_cast_return extends TreeRuleReturnScope {
		public LogicalSchema logicalSchema;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "tuple_type_cast"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:934:1: tuple_type_cast returns [LogicalSchema logicalSchema] : ^( TUPLE_TYPE_CAST ( type_cast )* ) ;
	public final LogicalPlanGenerator.tuple_type_cast_return tuple_type_cast() throws RecognitionException {
		LogicalPlanGenerator.tuple_type_cast_return retval = new LogicalPlanGenerator.tuple_type_cast_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree TUPLE_TYPE_CAST212=null;
		TreeRuleReturnScope type_cast213 =null;

		CommonTree TUPLE_TYPE_CAST212_tree=null;


		    retval.logicalSchema = new LogicalSchema();

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:938:2: ( ^( TUPLE_TYPE_CAST ( type_cast )* ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:938:4: ^( TUPLE_TYPE_CAST ( type_cast )* )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			TUPLE_TYPE_CAST212=(CommonTree)match(input,TUPLE_TYPE_CAST,FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast3074); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			TUPLE_TYPE_CAST212_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE_CAST212);


			root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE_CAST212_tree, root_1);
			}

			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); if (state.failed) return retval;
				// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:938:23: ( type_cast )*
				loop64:
				while (true) {
					int alt64=2;
					int LA64_0 = input.LA(1);
					if ( (LA64_0==BIGDECIMAL||LA64_0==BIGINTEGER||LA64_0==BOOLEAN||LA64_0==BYTEARRAY||LA64_0==CHARARRAY||LA64_0==DATETIME||LA64_0==DOUBLE||LA64_0==FLOAT||LA64_0==INT||LA64_0==LONG||LA64_0==BAG_TYPE_CAST||LA64_0==MAP_TYPE||LA64_0==TUPLE_TYPE_CAST) ) {
						alt64=1;
					}

					switch (alt64) {
					case 1 :
						// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:938:25: type_cast
						{
						_last = (CommonTree)input.LT(1);
						pushFollow(FOLLOW_type_cast_in_tuple_type_cast3078);
						type_cast213=type_cast();
						state._fsp--;
						if (state.failed) return retval;
						if ( state.backtracking==0 ) 
						adaptor.addChild(root_1, type_cast213.getTree());

						if ( state.backtracking==0 ) { retval.logicalSchema.addField( (type_cast213!=null?((LogicalPlanGenerator.type_cast_return)type_cast213).fieldSchema:null) ); }
						if ( state.backtracking==0 ) {
						}

						}
						break;

					default :
						break loop64;
					}
				}

				match(input, Token.UP, null); if (state.failed) return retval;
			}
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "tuple_type_cast"


	public static class bag_type_cast_return extends TreeRuleReturnScope {
		public LogicalSchema logicalSchema;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "bag_type_cast"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:941:1: bag_type_cast returns [LogicalSchema logicalSchema] : ^( BAG_TYPE_CAST ( tuple_type_cast )? ) ;
	public final LogicalPlanGenerator.bag_type_cast_return bag_type_cast() throws RecognitionException {
		LogicalPlanGenerator.bag_type_cast_return retval = new LogicalPlanGenerator.bag_type_cast_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree BAG_TYPE_CAST214=null;
		TreeRuleReturnScope tuple_type_cast215 =null;

		CommonTree BAG_TYPE_CAST214_tree=null;


		    retval.logicalSchema = new LogicalSchema();

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:945:2: ( ^( BAG_TYPE_CAST ( tuple_type_cast )? ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:945:4: ^( BAG_TYPE_CAST ( tuple_type_cast )? )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			BAG_TYPE_CAST214=(CommonTree)match(input,BAG_TYPE_CAST,FOLLOW_BAG_TYPE_CAST_in_bag_type_cast3105); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			BAG_TYPE_CAST214_tree = (CommonTree)adaptor.dupNode(BAG_TYPE_CAST214);


			root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE_CAST214_tree, root_1);
			}

			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); if (state.failed) return retval;
				// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:945:21: ( tuple_type_cast )?
				int alt65=2;
				int LA65_0 = input.LA(1);
				if ( (LA65_0==TUPLE_TYPE_CAST) ) {
					alt65=1;
				}
				switch (alt65) {
					case 1 :
						// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:945:21: tuple_type_cast
						{
						_last = (CommonTree)input.LT(1);
						pushFollow(FOLLOW_tuple_type_cast_in_bag_type_cast3107);
						tuple_type_cast215=tuple_type_cast();
						state._fsp--;
						if (state.failed) return retval;
						if ( state.backtracking==0 ) 
						adaptor.addChild(root_1, tuple_type_cast215.getTree());

						if ( state.backtracking==0 ) {
						}

						}
						break;

				}

				match(input, Token.UP, null); if (state.failed) return retval;
			}
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			       retval.logicalSchema.addField( new LogicalFieldSchema( null, (tuple_type_cast215!=null?((LogicalPlanGenerator.tuple_type_cast_return)tuple_type_cast215).logicalSchema:null), DataType.TUPLE ) );
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "bag_type_cast"


	public static class var_expr_return extends TreeRuleReturnScope {
		public LogicalExpression expr;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "var_expr"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:951:1: var_expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : projectable_expr[$plan] ( dot_proj | pound_proj )* ;
	public final LogicalPlanGenerator.var_expr_return var_expr(LogicalExpressionPlan plan) throws RecognitionException {
		LogicalPlanGenerator.var_expr_return retval = new LogicalPlanGenerator.var_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope projectable_expr216 =null;
		TreeRuleReturnScope dot_proj217 =null;
		TreeRuleReturnScope pound_proj218 =null;



		    List<Object> columns = null;
		    SourceLocation loc = new SourceLocation( (LatinParserNode)((CommonTree)retval.start) );

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:956:2: ( projectable_expr[$plan] ( dot_proj | pound_proj )* )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:956:4: projectable_expr[$plan] ( dot_proj | pound_proj )*
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_projectable_expr_in_var_expr3134);
			projectable_expr216=projectable_expr(plan);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_0, projectable_expr216.getTree());

			if ( state.backtracking==0 ) { retval.expr = (projectable_expr216!=null?((LogicalPlanGenerator.projectable_expr_return)projectable_expr216).expr:null); }
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:957:4: ( dot_proj | pound_proj )*
			loop66:
			while (true) {
				int alt66=3;
				int LA66_0 = input.LA(1);
				if ( (LA66_0==PERIOD) ) {
					alt66=1;
				}
				else if ( (LA66_0==POUND) ) {
					alt66=2;
				}

				switch (alt66) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:957:6: dot_proj
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_dot_proj_in_var_expr3144);
					dot_proj217=dot_proj();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, dot_proj217.getTree());

					if ( state.backtracking==0 ) {
					         columns = (dot_proj217!=null?((LogicalPlanGenerator.dot_proj_return)dot_proj217).cols:null);
					         boolean processScalar = false;



                             DereferenceExpression e = new DereferenceExpression( plan );
                             e.setRawColumns( (dot_proj217!=null?((LogicalPlanGenerator.dot_proj_return)dot_proj217).cols:null) );
                             e.setLocation( new SourceLocation( (LatinParserNode)(dot_proj217!=null?((CommonTree)dot_proj217.start):null) ) );
                             plan.connect( e, retval.expr );
                             retval.expr = e;

					     }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1014:6: pound_proj
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_pound_proj_in_var_expr3158);
					pound_proj218=pound_proj();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, pound_proj218.getTree());

					if ( state.backtracking==0 ) {
					         MapLookupExpression e = new MapLookupExpression( plan, (pound_proj218!=null?((LogicalPlanGenerator.pound_proj_return)pound_proj218).key:null) );
					         e.setLocation( new SourceLocation( (LatinParserNode)(pound_proj218!=null?((CommonTree)pound_proj218.start):null) ) );
					         plan.connect( e, retval.expr );
					         retval.expr = e;
					     }
					if ( state.backtracking==0 ) {
					}

					}
					break;

				default :
					break loop66;
				}
			}

			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "var_expr"


	public static class projectable_expr_return extends TreeRuleReturnScope {
		public LogicalExpression expr;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "projectable_expr"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1029:1: projectable_expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ( func_eval[$plan] | col_ref[$plan] | bin_expr[$plan] | case_expr[$plan] | case_cond[$plan] );
	public final LogicalPlanGenerator.projectable_expr_return projectable_expr(LogicalExpressionPlan plan) throws RecognitionException {
		LogicalPlanGenerator.projectable_expr_return retval = new LogicalPlanGenerator.projectable_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope func_eval219 =null;
		TreeRuleReturnScope col_ref220 =null;
		TreeRuleReturnScope bin_expr221 =null;
		TreeRuleReturnScope case_expr222 =null;
		TreeRuleReturnScope case_cond223 =null;


		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1030:2: ( func_eval[$plan] | col_ref[$plan] | bin_expr[$plan] | case_expr[$plan] | case_cond[$plan] )
			int alt67=5;
			switch ( input.LA(1) ) {
			case FUNC_EVAL:
			case INVOKER_FUNC_EVAL:
				{
				alt67=1;
				}
				break;
			case CUBE:
			case DOLLARVAR:
			case GROUP:
			case IDENTIFIER:
				{
				alt67=2;
				}
				break;
			case BIN_EXPR:
				{
				alt67=3;
				}
				break;
			case CASE_EXPR:
				{
				alt67=4;
				}
				break;
			case CASE_COND:
				{
				alt67=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 67, 0, input);
				throw nvae;
			}
			switch (alt67) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1030:4: func_eval[$plan]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_func_eval_in_projectable_expr3188);
					func_eval219=func_eval(plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, func_eval219.getTree());

					if ( state.backtracking==0 ) {
					       retval.expr = (func_eval219!=null?((LogicalPlanGenerator.func_eval_return)func_eval219).expr:null);
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1034:4: col_ref[$plan]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_col_ref_in_projectable_expr3199);
					col_ref220=col_ref(plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, col_ref220.getTree());

					if ( state.backtracking==0 ) {
					       retval.expr = (col_ref220!=null?((LogicalPlanGenerator.col_ref_return)col_ref220).expr:null);
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1038:4: bin_expr[$plan]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_bin_expr_in_projectable_expr3210);
					bin_expr221=bin_expr(plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, bin_expr221.getTree());

					if ( state.backtracking==0 ) {
					       retval.expr = (bin_expr221!=null?((LogicalPlanGenerator.bin_expr_return)bin_expr221).expr:null);
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 4 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1042:4: case_expr[$plan]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_case_expr_in_projectable_expr3221);
					case_expr222=case_expr(plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, case_expr222.getTree());

					if ( state.backtracking==0 ) {
					       retval.expr = (case_expr222!=null?((LogicalPlanGenerator.case_expr_return)case_expr222).expr:null);
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 5 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1046:4: case_cond[$plan]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_case_cond_in_projectable_expr3232);
					case_cond223=case_cond(plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, case_cond223.getTree());

					if ( state.backtracking==0 ) {
					       retval.expr = (case_cond223!=null?((LogicalPlanGenerator.case_cond_return)case_cond223).expr:null);
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;

			}
			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "projectable_expr"


	public static class dot_proj_return extends TreeRuleReturnScope {
		public List<Object> cols;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "dot_proj"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1052:1: dot_proj returns [List<Object> cols] : ^( PERIOD ( col_alias_or_index )+ ) ;
	public final LogicalPlanGenerator.dot_proj_return dot_proj() throws RecognitionException {
		LogicalPlanGenerator.dot_proj_return retval = new LogicalPlanGenerator.dot_proj_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree PERIOD224=null;
		TreeRuleReturnScope col_alias_or_index225 =null;

		CommonTree PERIOD224_tree=null;


		    retval.cols = new ArrayList<Object>();

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1056:2: ( ^( PERIOD ( col_alias_or_index )+ ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1056:4: ^( PERIOD ( col_alias_or_index )+ )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			PERIOD224=(CommonTree)match(input,PERIOD,FOLLOW_PERIOD_in_dot_proj3258); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			PERIOD224_tree = (CommonTree)adaptor.dupNode(PERIOD224);


			root_1 = (CommonTree)adaptor.becomeRoot(PERIOD224_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1056:14: ( col_alias_or_index )+
			int cnt68=0;
			loop68:
			while (true) {
				int alt68=2;
				int LA68_0 = input.LA(1);
				if ( (LA68_0==CUBE||LA68_0==DOLLARVAR||LA68_0==GROUP||LA68_0==IDENTIFIER) ) {
					alt68=1;
				}

				switch (alt68) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1056:16: col_alias_or_index
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_col_alias_or_index_in_dot_proj3262);
					col_alias_or_index225=col_alias_or_index();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, col_alias_or_index225.getTree());

					if ( state.backtracking==0 ) { retval.cols.add( (col_alias_or_index225!=null?((LogicalPlanGenerator.col_alias_or_index_return)col_alias_or_index225).col:null) ); }
					if ( state.backtracking==0 ) {
					}

					}
					break;

				default :
					if ( cnt68 >= 1 ) break loop68;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(68, input);
					throw eee;
				}
				cnt68++;
			}

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "dot_proj"


	public static class col_alias_or_index_return extends TreeRuleReturnScope {
		public Object col;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "col_alias_or_index"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1059:1: col_alias_or_index returns [Object col] : ( col_alias | col_index );
	public final LogicalPlanGenerator.col_alias_or_index_return col_alias_or_index() throws RecognitionException {
		LogicalPlanGenerator.col_alias_or_index_return retval = new LogicalPlanGenerator.col_alias_or_index_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope col_alias226 =null;
		TreeRuleReturnScope col_index227 =null;


		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1060:2: ( col_alias | col_index )
			int alt69=2;
			int LA69_0 = input.LA(1);
			if ( (LA69_0==CUBE||LA69_0==GROUP||LA69_0==IDENTIFIER) ) {
				alt69=1;
			}
			else if ( (LA69_0==DOLLARVAR) ) {
				alt69=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 69, 0, input);
				throw nvae;
			}

			switch (alt69) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1060:4: col_alias
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_col_alias_in_col_alias_or_index3282);
					col_alias226=col_alias();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, col_alias226.getTree());

					if ( state.backtracking==0 ) { retval.col = (col_alias226!=null?((LogicalPlanGenerator.col_alias_return)col_alias226).col:null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1060:43: col_index
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_col_index_in_col_alias_or_index3288);
					col_index227=col_index();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, col_index227.getTree());

					if ( state.backtracking==0 ) { retval.col = (col_index227!=null?((LogicalPlanGenerator.col_index_return)col_index227).col:null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;

			}
			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "col_alias_or_index"


	public static class col_alias_return extends TreeRuleReturnScope {
		public Object col;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "col_alias"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1063:1: col_alias returns [Object col] : ( GROUP | CUBE | IDENTIFIER );
	public final LogicalPlanGenerator.col_alias_return col_alias() throws RecognitionException {
		LogicalPlanGenerator.col_alias_return retval = new LogicalPlanGenerator.col_alias_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree GROUP228=null;
		CommonTree CUBE229=null;
		CommonTree IDENTIFIER230=null;

		CommonTree GROUP228_tree=null;
		CommonTree CUBE229_tree=null;
		CommonTree IDENTIFIER230_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1064:2: ( GROUP | CUBE | IDENTIFIER )
			int alt70=3;
			switch ( input.LA(1) ) {
			case GROUP:
				{
				alt70=1;
				}
				break;
			case CUBE:
				{
				alt70=2;
				}
				break;
			case IDENTIFIER:
				{
				alt70=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 70, 0, input);
				throw nvae;
			}
			switch (alt70) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1064:4: GROUP
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					GROUP228=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_col_alias3303); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					GROUP228_tree = (CommonTree)adaptor.dupNode(GROUP228);


					adaptor.addChild(root_0, GROUP228_tree);
					}

					if ( state.backtracking==0 ) { retval.col = (GROUP228!=null?GROUP228.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1065:4: CUBE
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					CUBE229=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_col_alias3310); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					CUBE229_tree = (CommonTree)adaptor.dupNode(CUBE229);


					adaptor.addChild(root_0, CUBE229_tree);
					}

					if ( state.backtracking==0 ) { retval.col = (CUBE229!=null?CUBE229.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1066:4: IDENTIFIER
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					IDENTIFIER230=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_col_alias3317); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IDENTIFIER230_tree = (CommonTree)adaptor.dupNode(IDENTIFIER230);


					adaptor.addChild(root_0, IDENTIFIER230_tree);
					}

					if ( state.backtracking==0 ) { retval.col = (IDENTIFIER230!=null?IDENTIFIER230.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;

			}
			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "col_alias"


	public static class col_index_return extends TreeRuleReturnScope {
		public Integer col;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "col_index"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1069:1: col_index returns [Integer col] : DOLLARVAR ;
	public final LogicalPlanGenerator.col_index_return col_index() throws RecognitionException {
		LogicalPlanGenerator.col_index_return retval = new LogicalPlanGenerator.col_index_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree DOLLARVAR231=null;

		CommonTree DOLLARVAR231_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1070:2: ( DOLLARVAR )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1070:4: DOLLARVAR
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			DOLLARVAR231=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_col_index3332); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			DOLLARVAR231_tree = (CommonTree)adaptor.dupNode(DOLLARVAR231);


			adaptor.addChild(root_0, DOLLARVAR231_tree);
			}

			if ( state.backtracking==0 ) { retval.col = builder.undollar( (DOLLARVAR231!=null?DOLLARVAR231.getText():null) ); }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "col_index"


	public static class col_range_return extends TreeRuleReturnScope {
		public LogicalExpression expr;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "col_range"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1074:1: col_range[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ^( COL_RANGE (startExpr= col_ref[$plan] )? DOUBLE_PERIOD (endExpr= col_ref[$plan] )? ) ;
	public final LogicalPlanGenerator.col_range_return col_range(LogicalExpressionPlan plan) throws RecognitionException {
		LogicalPlanGenerator.col_range_return retval = new LogicalPlanGenerator.col_range_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree COL_RANGE232=null;
		CommonTree DOUBLE_PERIOD233=null;
		TreeRuleReturnScope startExpr =null;
		TreeRuleReturnScope endExpr =null;

		CommonTree COL_RANGE232_tree=null;
		CommonTree DOUBLE_PERIOD233_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1075:2: ( ^( COL_RANGE (startExpr= col_ref[$plan] )? DOUBLE_PERIOD (endExpr= col_ref[$plan] )? ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1075:5: ^( COL_RANGE (startExpr= col_ref[$plan] )? DOUBLE_PERIOD (endExpr= col_ref[$plan] )? )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			COL_RANGE232=(CommonTree)match(input,COL_RANGE,FOLLOW_COL_RANGE_in_col_range3351); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			COL_RANGE232_tree = (CommonTree)adaptor.dupNode(COL_RANGE232);


			root_1 = (CommonTree)adaptor.becomeRoot(COL_RANGE232_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1075:17: (startExpr= col_ref[$plan] )?
			int alt71=2;
			int LA71_0 = input.LA(1);
			if ( (LA71_0==CUBE||LA71_0==DOLLARVAR||LA71_0==GROUP||LA71_0==IDENTIFIER) ) {
				alt71=1;
			}
			switch (alt71) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1075:18: startExpr= col_ref[$plan]
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_col_ref_in_col_range3358);
					startExpr=col_ref(plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, startExpr.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;

			}

			_last = (CommonTree)input.LT(1);
			DOUBLE_PERIOD233=(CommonTree)match(input,DOUBLE_PERIOD,FOLLOW_DOUBLE_PERIOD_in_col_range3363); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			DOUBLE_PERIOD233_tree = (CommonTree)adaptor.dupNode(DOUBLE_PERIOD233);


			adaptor.addChild(root_1, DOUBLE_PERIOD233_tree);
			}

			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1075:61: (endExpr= col_ref[$plan] )?
			int alt72=2;
			int LA72_0 = input.LA(1);
			if ( (LA72_0==CUBE||LA72_0==DOLLARVAR||LA72_0==GROUP||LA72_0==IDENTIFIER) ) {
				alt72=1;
			}
			switch (alt72) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1075:62: endExpr= col_ref[$plan]
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_col_ref_in_col_range3370);
					endExpr=col_ref(plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, endExpr.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;

			}

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			        SourceLocation loc = new SourceLocation( (LatinParserNode)((CommonTree)retval.start) );
			        retval.expr = builder.buildRangeProjectExpr(
			                    loc, plan, GScope_stack.peek().currentOp,
			                    statement_stack.peek().inputIndex,
			                    (startExpr!=null?((LogicalPlanGenerator.col_ref_return)startExpr).expr:null),
			                    (endExpr!=null?((LogicalPlanGenerator.col_ref_return)endExpr).expr:null)
			                );
			    }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class pound_proj_return extends TreeRuleReturnScope {
		public String key;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "pound_proj"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1087:1: pound_proj returns [String key] : ^( POUND ( QUOTEDSTRING | NULL ) ) ;
	public final LogicalPlanGenerator.pound_proj_return pound_proj() throws RecognitionException {
		LogicalPlanGenerator.pound_proj_return retval = new LogicalPlanGenerator.pound_proj_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree POUND234=null;
		CommonTree QUOTEDSTRING235=null;
		CommonTree NULL236=null;

		CommonTree POUND234_tree=null;
		CommonTree QUOTEDSTRING235_tree=null;
		CommonTree NULL236_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1088:2: ( ^( POUND ( QUOTEDSTRING | NULL ) ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1088:4: ^( POUND ( QUOTEDSTRING | NULL ) )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			POUND234=(CommonTree)match(input,POUND,FOLLOW_POUND_in_pound_proj3396); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			POUND234_tree = (CommonTree)adaptor.dupNode(POUND234);


			root_1 = (CommonTree)adaptor.becomeRoot(POUND234_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1088:13: ( QUOTEDSTRING | NULL )
			int alt73=2;
			int LA73_0 = input.LA(1);
			if ( (LA73_0==QUOTEDSTRING) ) {
				alt73=1;
			}
			else if ( (LA73_0==NULL) ) {
				alt73=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 73, 0, input);
				throw nvae;
			}

			switch (alt73) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1088:15: QUOTEDSTRING
					{
					_last = (CommonTree)input.LT(1);
					QUOTEDSTRING235=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_pound_proj3400); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					QUOTEDSTRING235_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING235);


					adaptor.addChild(root_1, QUOTEDSTRING235_tree);
					}

					if ( state.backtracking==0 ) { retval.key = builder.unquote( (QUOTEDSTRING235!=null?QUOTEDSTRING235.getText():null) ); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1088:80: NULL
					{
					_last = (CommonTree)input.LT(1);
					NULL236=(CommonTree)match(input,NULL,FOLLOW_NULL_in_pound_proj3406); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NULL236_tree = (CommonTree)adaptor.dupNode(NULL236);


					adaptor.addChild(root_1, NULL236_tree);
					}

					if ( state.backtracking==0 ) {
					}

					}
					break;

			}

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "pound_proj"


	public static class bin_expr_return extends TreeRuleReturnScope {
		public LogicalExpression expr;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "bin_expr"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1091:1: bin_expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ^( BIN_EXPR cond[$plan] e1= expr[$plan] e2= expr[$plan] ) ;
	public final LogicalPlanGenerator.bin_expr_return bin_expr(LogicalExpressionPlan plan) throws RecognitionException {
		LogicalPlanGenerator.bin_expr_return retval = new LogicalPlanGenerator.bin_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree BIN_EXPR237=null;
		TreeRuleReturnScope e1 =null;
		TreeRuleReturnScope e2 =null;
		TreeRuleReturnScope cond238 =null;

		CommonTree BIN_EXPR237_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1092:2: ( ^( BIN_EXPR cond[$plan] e1= expr[$plan] e2= expr[$plan] ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1092:4: ^( BIN_EXPR cond[$plan] e1= expr[$plan] e2= expr[$plan] )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			BIN_EXPR237=(CommonTree)match(input,BIN_EXPR,FOLLOW_BIN_EXPR_in_bin_expr3426); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			BIN_EXPR237_tree = (CommonTree)adaptor.dupNode(BIN_EXPR237);


			root_1 = (CommonTree)adaptor.becomeRoot(BIN_EXPR237_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_cond_in_bin_expr3428);
			cond238=cond(plan);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, cond238.getTree());

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_expr_in_bin_expr3435);
			e1=expr(plan);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, e1.getTree());

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_expr_in_bin_expr3442);
			e2=expr(plan);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, e2.getTree());

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			       retval.expr = new BinCondExpression( plan, (cond238!=null?((LogicalPlanGenerator.cond_return)cond238).expr:null), (e1!=null?((LogicalPlanGenerator.expr_return)e1).expr:null), (e2!=null?((LogicalPlanGenerator.expr_return)e2).expr:null) );
			       retval.expr.setLocation( new SourceLocation( (LatinParserNode)((CommonTree)retval.start) ) );
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "bin_expr"


	public static class case_expr_return extends TreeRuleReturnScope {
		public LogicalExpression expr;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "case_expr"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1099:1: case_expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ^( CASE_EXPR ( ( ^( CASE_EXPR_LHS lhs= expr[$plan] ) ) ( ^( CASE_EXPR_RHS rhs= expr[$plan] ) )+ )+ ) ;
	public final LogicalPlanGenerator.case_expr_return case_expr(LogicalExpressionPlan plan) throws RecognitionException {
		LogicalPlanGenerator.case_expr_return retval = new LogicalPlanGenerator.case_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree CASE_EXPR239=null;
		CommonTree CASE_EXPR_LHS240=null;
		CommonTree CASE_EXPR_RHS241=null;
		TreeRuleReturnScope lhs =null;
		TreeRuleReturnScope rhs =null;

		CommonTree CASE_EXPR239_tree=null;
		CommonTree CASE_EXPR_LHS240_tree=null;
		CommonTree CASE_EXPR_RHS241_tree=null;


		    List<LogicalExpression> lhsExprs = new ArrayList<LogicalExpression>();
		    List<LogicalExpression> rhsExprs = new ArrayList<LogicalExpression>();

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1104:2: ( ^( CASE_EXPR ( ( ^( CASE_EXPR_LHS lhs= expr[$plan] ) ) ( ^( CASE_EXPR_RHS rhs= expr[$plan] ) )+ )+ ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1104:4: ^( CASE_EXPR ( ( ^( CASE_EXPR_LHS lhs= expr[$plan] ) ) ( ^( CASE_EXPR_RHS rhs= expr[$plan] ) )+ )+ )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			CASE_EXPR239=(CommonTree)match(input,CASE_EXPR,FOLLOW_CASE_EXPR_in_case_expr3471); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			CASE_EXPR239_tree = (CommonTree)adaptor.dupNode(CASE_EXPR239);


			root_1 = (CommonTree)adaptor.becomeRoot(CASE_EXPR239_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1104:17: ( ( ^( CASE_EXPR_LHS lhs= expr[$plan] ) ) ( ^( CASE_EXPR_RHS rhs= expr[$plan] ) )+ )+
			int cnt75=0;
			loop75:
			while (true) {
				int alt75=2;
				int LA75_0 = input.LA(1);
				if ( (LA75_0==CASE_EXPR_LHS) ) {
					alt75=1;
				}

				switch (alt75) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1104:19: ( ^( CASE_EXPR_LHS lhs= expr[$plan] ) ) ( ^( CASE_EXPR_RHS rhs= expr[$plan] ) )+
					{
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1104:19: ( ^( CASE_EXPR_LHS lhs= expr[$plan] ) )
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1104:21: ^( CASE_EXPR_LHS lhs= expr[$plan] )
					{
					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_2 = _last;
					CommonTree _first_2 = null;
					CommonTree root_2 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					CASE_EXPR_LHS240=(CommonTree)match(input,CASE_EXPR_LHS,FOLLOW_CASE_EXPR_LHS_in_case_expr3479); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					CASE_EXPR_LHS240_tree = (CommonTree)adaptor.dupNode(CASE_EXPR_LHS240);


					root_2 = (CommonTree)adaptor.becomeRoot(CASE_EXPR_LHS240_tree, root_2);
					}

					match(input, Token.DOWN, null); if (state.failed) return retval;
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_case_expr3485);
					lhs=expr(plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_2, lhs.getTree());

					if ( state.backtracking==0 ) { lhsExprs.add((lhs!=null?((LogicalPlanGenerator.expr_return)lhs).expr:null)); }
					match(input, Token.UP, null); if (state.failed) return retval;
					adaptor.addChild(root_1, root_2);
					_last = _save_last_2;
					}


					if ( state.backtracking==0 ) {
					}

					}

					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1105:19: ( ^( CASE_EXPR_RHS rhs= expr[$plan] ) )+
					int cnt74=0;
					loop74:
					while (true) {
						int alt74=2;
						int LA74_0 = input.LA(1);
						if ( (LA74_0==CASE_EXPR_RHS) ) {
							alt74=1;
						}

						switch (alt74) {
						case 1 :
							// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1105:21: ^( CASE_EXPR_RHS rhs= expr[$plan] )
							{
							_last = (CommonTree)input.LT(1);
							{
							CommonTree _save_last_2 = _last;
							CommonTree _first_2 = null;
							CommonTree root_2 = (CommonTree)adaptor.nil();
							_last = (CommonTree)input.LT(1);
							CASE_EXPR_RHS241=(CommonTree)match(input,CASE_EXPR_RHS,FOLLOW_CASE_EXPR_RHS_in_case_expr3516); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							CASE_EXPR_RHS241_tree = (CommonTree)adaptor.dupNode(CASE_EXPR_RHS241);


							root_2 = (CommonTree)adaptor.becomeRoot(CASE_EXPR_RHS241_tree, root_2);
							}

							match(input, Token.DOWN, null); if (state.failed) return retval;
							_last = (CommonTree)input.LT(1);
							pushFollow(FOLLOW_expr_in_case_expr3522);
							rhs=expr(plan);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) 
							adaptor.addChild(root_2, rhs.getTree());

							if ( state.backtracking==0 ) { rhsExprs.add((rhs!=null?((LogicalPlanGenerator.expr_return)rhs).expr:null)); }
							match(input, Token.UP, null); if (state.failed) return retval;
							adaptor.addChild(root_1, root_2);
							_last = _save_last_2;
							}


							if ( state.backtracking==0 ) {
							}

							}
							break;

						default :
							if ( cnt74 >= 1 ) break loop74;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(74, input);
							throw eee;
						}
						cnt74++;
					}

					if ( state.backtracking==0 ) {
					}

					}
					break;

				default :
					if ( cnt75 >= 1 ) break loop75;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(75, input);
					throw eee;
				}
				cnt75++;
			}

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			        // Convert CASE tree to nested bincond expressions. Please also see
			        // QueryParser.g for how CASE tree is constructed from case statement.
			        boolean hasElse = rhsExprs.size() % 2 == 1;
			        LogicalExpression elseExpr = hasElse ? rhsExprs.get(rhsExprs.size()-1)
			                                             : new ConstantExpression(plan, null);

			        int numWhenBranches = rhsExprs.size() / 2;
			        BinCondExpression prevBinCondExpr = null;
			        BinCondExpression currBinCondExpr = null;
			        for (int i = 0; i < numWhenBranches; i++) {
			            currBinCondExpr = new BinCondExpression( plan,
			                new EqualExpression( plan, lhsExprs.get(i), rhsExprs.get(2*i) ), rhsExprs.get(2*i+1),
			                prevBinCondExpr == null ? elseExpr : prevBinCondExpr);
			            prevBinCondExpr = currBinCondExpr;
			        }
			        retval.expr = currBinCondExpr;
			        retval.expr.setLocation( new SourceLocation( (LatinParserNode)((CommonTree)retval.start) ) );
			    }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "case_expr"


	public static class case_cond_return extends TreeRuleReturnScope {
		public LogicalExpression expr;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "case_cond"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1127:1: case_cond[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ^( CASE_COND ^( WHEN ( cond[$plan] )+ ) ^( THEN ( expr[$plan] )+ ) ) ;
	public final LogicalPlanGenerator.case_cond_return case_cond(LogicalExpressionPlan plan) throws RecognitionException {
		LogicalPlanGenerator.case_cond_return retval = new LogicalPlanGenerator.case_cond_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree CASE_COND242=null;
		CommonTree WHEN243=null;
		CommonTree THEN245=null;
		TreeRuleReturnScope cond244 =null;
		TreeRuleReturnScope expr246 =null;

		CommonTree CASE_COND242_tree=null;
		CommonTree WHEN243_tree=null;
		CommonTree THEN245_tree=null;


		    List<LogicalExpression> conds = new ArrayList<LogicalExpression>();
		    List<LogicalExpression> exprs = new ArrayList<LogicalExpression>();

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1132:2: ( ^( CASE_COND ^( WHEN ( cond[$plan] )+ ) ^( THEN ( expr[$plan] )+ ) ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1132:4: ^( CASE_COND ^( WHEN ( cond[$plan] )+ ) ^( THEN ( expr[$plan] )+ ) )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			CASE_COND242=(CommonTree)match(input,CASE_COND,FOLLOW_CASE_COND_in_case_cond3562); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			CASE_COND242_tree = (CommonTree)adaptor.dupNode(CASE_COND242);


			root_1 = (CommonTree)adaptor.becomeRoot(CASE_COND242_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_2 = _last;
			CommonTree _first_2 = null;
			CommonTree root_2 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			WHEN243=(CommonTree)match(input,WHEN,FOLLOW_WHEN_in_case_cond3566); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			WHEN243_tree = (CommonTree)adaptor.dupNode(WHEN243);


			root_2 = (CommonTree)adaptor.becomeRoot(WHEN243_tree, root_2);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1132:25: ( cond[$plan] )+
			int cnt76=0;
			loop76:
			while (true) {
				int alt76=2;
				int LA76_0 = input.LA(1);
				if ( (LA76_0==AND||LA76_0==IN||(LA76_0 >= NOT && LA76_0 <= NUM_OP_NE)||LA76_0==OR||(LA76_0 >= STR_OP_EQ && LA76_0 <= STR_OP_NE)||LA76_0==BOOL_COND||LA76_0==FUNC_EVAL||LA76_0==INVOKER_FUNC_EVAL) ) {
					alt76=1;
				}

				switch (alt76) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1132:27: cond[$plan]
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_cond_in_case_cond3570);
					cond244=cond(plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_2, cond244.getTree());

					if ( state.backtracking==0 ) { conds.add((cond244!=null?((LogicalPlanGenerator.cond_return)cond244).expr:null)); }
					if ( state.backtracking==0 ) {
					}

					}
					break;

				default :
					if ( cnt76 >= 1 ) break loop76;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(76, input);
					throw eee;
				}
				cnt76++;
			}

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_1, root_2);
			_last = _save_last_2;
			}


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_2 = _last;
			CommonTree _first_2 = null;
			CommonTree root_2 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			THEN245=(CommonTree)match(input,THEN,FOLLOW_THEN_in_case_cond3598); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			THEN245_tree = (CommonTree)adaptor.dupNode(THEN245);


			root_2 = (CommonTree)adaptor.becomeRoot(THEN245_tree, root_2);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1133:25: ( expr[$plan] )+
			int cnt77=0;
			loop77:
			while (true) {
				int alt77=2;
				int LA77_0 = input.LA(1);
				if ( (LA77_0==BIGDECIMALNUMBER||LA77_0==BIGINTEGERNUMBER||LA77_0==CUBE||LA77_0==DIV||LA77_0==DOLLARVAR||LA77_0==DOUBLENUMBER||LA77_0==FALSE||LA77_0==FLOATNUMBER||LA77_0==GROUP||LA77_0==IDENTIFIER||LA77_0==INTEGER||LA77_0==LONGINTEGER||LA77_0==MINUS||LA77_0==NULL||LA77_0==PERCENT||LA77_0==PLUS||LA77_0==QUOTEDSTRING||LA77_0==STAR||LA77_0==TRUE||(LA77_0 >= BAG_VAL && LA77_0 <= BIN_EXPR)||(LA77_0 >= CASE_COND && LA77_0 <= CASE_EXPR)||LA77_0==CAST_EXPR||LA77_0==EXPR_IN_PAREN||LA77_0==FUNC_EVAL||LA77_0==INVOKER_FUNC_EVAL||(LA77_0 >= MAP_VAL && LA77_0 <= NEG)||LA77_0==TUPLE_VAL) ) {
					alt77=1;
				}

				switch (alt77) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1133:27: expr[$plan]
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_case_cond3602);
					expr246=expr(plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_2, expr246.getTree());

					if ( state.backtracking==0 ) { exprs.add((expr246!=null?((LogicalPlanGenerator.expr_return)expr246).expr:null)); }
					if ( state.backtracking==0 ) {
					}

					}
					break;

				default :
					if ( cnt77 >= 1 ) break loop77;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(77, input);
					throw eee;
				}
				cnt77++;
			}

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_1, root_2);
			_last = _save_last_2;
			}


			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			        // Convert CASE tree to nested bincond expressions. Please also see
			        // QueryParser.g for how CASE tree is constructed from case statement.
			        boolean hasElse = exprs.size() != conds.size();
			        LogicalExpression elseExpr = hasElse ? exprs.remove(exprs.size()-1)
			                                             : new ConstantExpression(plan, null);
			        Collections.reverse(exprs);
			        Collections.reverse(conds);
			        int numWhenBranches = conds.size();
			        BinCondExpression prevBinCondExpr = null;
			        BinCondExpression currBinCondExpr = null;
			        for (int i = 0; i < numWhenBranches; i++) {
			            currBinCondExpr = new BinCondExpression( plan,
			                conds.get(i), exprs.get(i),
			                prevBinCondExpr == null ? elseExpr : prevBinCondExpr);
			            prevBinCondExpr = currBinCondExpr;
			        }
			        retval.expr = currBinCondExpr;
			        retval.expr.setLocation( new SourceLocation( (LatinParserNode)((CommonTree)retval.start) ) );
			    }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "case_cond"


	public static class limit_clause_return extends TreeRuleReturnScope {
		public String alias;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "limit_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1156:1: limit_clause returns [String alias] : ^( LIMIT rel ( INTEGER | LONGINTEGER | expr[exprPlan] ) ) ;
	public final LogicalPlanGenerator.limit_clause_return limit_clause() throws RecognitionException {
		GScope_stack.push(new GScope_scope());

		LogicalPlanGenerator.limit_clause_return retval = new LogicalPlanGenerator.limit_clause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree LIMIT247=null;
		CommonTree INTEGER249=null;
		CommonTree LONGINTEGER250=null;
		TreeRuleReturnScope rel248 =null;
		TreeRuleReturnScope expr251 =null;

		CommonTree LIMIT247_tree=null;
		CommonTree INTEGER249_tree=null;
		CommonTree LONGINTEGER250_tree=null;


		    GScope_stack.peek().currentOp = builder.createLimitOp();
		    LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1162:2: ( ^( LIMIT rel ( INTEGER | LONGINTEGER | expr[exprPlan] ) ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1162:5: ^( LIMIT rel ( INTEGER | LONGINTEGER | expr[exprPlan] ) )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			LIMIT247=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_limit_clause3644); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LIMIT247_tree = (CommonTree)adaptor.dupNode(LIMIT247);


			root_1 = (CommonTree)adaptor.becomeRoot(LIMIT247_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_rel_in_limit_clause3646);
			rel248=rel();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, rel248.getTree());

			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1162:18: ( INTEGER | LONGINTEGER | expr[exprPlan] )
			int alt78=3;
			switch ( input.LA(1) ) {
			case INTEGER:
				{
				int LA78_1 = input.LA(2);
				if ( (synpred147_LogicalPlanGenerator()) ) {
					alt78=1;
				}
				else if ( (true) ) {
					alt78=3;
				}

				}
				break;
			case LONGINTEGER:
				{
				int LA78_2 = input.LA(2);
				if ( (synpred148_LogicalPlanGenerator()) ) {
					alt78=2;
				}
				else if ( (true) ) {
					alt78=3;
				}

				}
				break;
			case BIGDECIMALNUMBER:
			case BIGINTEGERNUMBER:
			case CUBE:
			case DIV:
			case DOLLARVAR:
			case DOUBLENUMBER:
			case FALSE:
			case FLOATNUMBER:
			case GROUP:
			case IDENTIFIER:
			case MINUS:
			case NULL:
			case PERCENT:
			case PLUS:
			case QUOTEDSTRING:
			case STAR:
			case TRUE:
			case BAG_VAL:
			case BIN_EXPR:
			case CASE_COND:
			case CASE_EXPR:
			case CAST_EXPR:
			case EXPR_IN_PAREN:
			case FUNC_EVAL:
			case INVOKER_FUNC_EVAL:
			case MAP_VAL:
			case NEG:
			case TUPLE_VAL:
				{
				alt78=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 78, 0, input);
				throw nvae;
			}
			switch (alt78) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1162:20: INTEGER
					{
					_last = (CommonTree)input.LT(1);
					INTEGER249=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_limit_clause3650); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INTEGER249_tree = (CommonTree)adaptor.dupNode(INTEGER249);


					adaptor.addChild(root_1, INTEGER249_tree);
					}

					if ( state.backtracking==0 ) {
					       retval.alias = builder.buildLimitOp( new SourceLocation( (LatinParserNode)LIMIT247 ),
					         statement_stack.peek().alias, statement_stack.peek().inputAlias, Long.valueOf( (INTEGER249!=null?INTEGER249.getText():null) ) );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1167:4: LONGINTEGER
					{
					_last = (CommonTree)input.LT(1);
					LONGINTEGER250=(CommonTree)match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_limit_clause3660); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LONGINTEGER250_tree = (CommonTree)adaptor.dupNode(LONGINTEGER250);


					adaptor.addChild(root_1, LONGINTEGER250_tree);
					}

					if ( state.backtracking==0 ) {
					       retval.alias = builder.buildLimitOp( new SourceLocation( (LatinParserNode)LIMIT247 ),
					         statement_stack.peek().alias, statement_stack.peek().inputAlias, builder.parseLong( (LONGINTEGER250!=null?LONGINTEGER250.getText():null) ) );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1172:4: expr[exprPlan]
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_limit_clause3670);
					expr251=expr(exprPlan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, expr251.getTree());

					if ( state.backtracking==0 ) {
					       retval.alias = builder.buildLimitOp( new SourceLocation( (LatinParserNode)LIMIT247 ),
					           (LOLimit)GScope_stack.peek().currentOp, statement_stack.peek().alias, statement_stack.peek().inputAlias, exprPlan);
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;

			}

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			}

		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
			GScope_stack.pop();

		}
		return retval;
	}
	// $ANTLR end "limit_clause"


	public static class sample_clause_return extends TreeRuleReturnScope {
		public String alias;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "sample_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1180:1: sample_clause returns [String alias] : ^( SAMPLE rel ( DOUBLENUMBER | expr[exprPlan] ) ) ;
	public final LogicalPlanGenerator.sample_clause_return sample_clause() throws RecognitionException {
		GScope_stack.push(new GScope_scope());

		LogicalPlanGenerator.sample_clause_return retval = new LogicalPlanGenerator.sample_clause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree SAMPLE252=null;
		CommonTree DOUBLENUMBER254=null;
		TreeRuleReturnScope rel253 =null;
		TreeRuleReturnScope expr255 =null;

		CommonTree SAMPLE252_tree=null;
		CommonTree DOUBLENUMBER254_tree=null;


		    GScope_stack.peek().currentOp = builder.createSampleOp();
		    LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1186:2: ( ^( SAMPLE rel ( DOUBLENUMBER | expr[exprPlan] ) ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1186:4: ^( SAMPLE rel ( DOUBLENUMBER | expr[exprPlan] ) )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			SAMPLE252=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_sample_clause3706); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			SAMPLE252_tree = (CommonTree)adaptor.dupNode(SAMPLE252);


			root_1 = (CommonTree)adaptor.becomeRoot(SAMPLE252_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_rel_in_sample_clause3708);
			rel253=rel();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, rel253.getTree());

			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1186:18: ( DOUBLENUMBER | expr[exprPlan] )
			int alt79=2;
			int LA79_0 = input.LA(1);
			if ( (LA79_0==DOUBLENUMBER) ) {
				int LA79_1 = input.LA(2);
				if ( (synpred149_LogicalPlanGenerator()) ) {
					alt79=1;
				}
				else if ( (true) ) {
					alt79=2;
				}

			}
			else if ( (LA79_0==BIGDECIMALNUMBER||LA79_0==BIGINTEGERNUMBER||LA79_0==CUBE||LA79_0==DIV||LA79_0==DOLLARVAR||LA79_0==FALSE||LA79_0==FLOATNUMBER||LA79_0==GROUP||LA79_0==IDENTIFIER||LA79_0==INTEGER||LA79_0==LONGINTEGER||LA79_0==MINUS||LA79_0==NULL||LA79_0==PERCENT||LA79_0==PLUS||LA79_0==QUOTEDSTRING||LA79_0==STAR||LA79_0==TRUE||(LA79_0 >= BAG_VAL && LA79_0 <= BIN_EXPR)||(LA79_0 >= CASE_COND && LA79_0 <= CASE_EXPR)||LA79_0==CAST_EXPR||LA79_0==EXPR_IN_PAREN||LA79_0==FUNC_EVAL||LA79_0==INVOKER_FUNC_EVAL||(LA79_0 >= MAP_VAL && LA79_0 <= NEG)||LA79_0==TUPLE_VAL) ) {
				alt79=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 79, 0, input);
				throw nvae;
			}

			switch (alt79) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1186:20: DOUBLENUMBER
					{
					_last = (CommonTree)input.LT(1);
					DOUBLENUMBER254=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_sample_clause3712); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DOUBLENUMBER254_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER254);


					adaptor.addChild(root_1, DOUBLENUMBER254_tree);
					}

					if ( state.backtracking==0 ) {
					       retval.alias = builder.buildSampleOp( new SourceLocation( (LatinParserNode)SAMPLE252 ), statement_stack.peek().alias,
					           statement_stack.peek().inputAlias, Double.valueOf( (DOUBLENUMBER254!=null?DOUBLENUMBER254.getText():null) ),
					           new SourceLocation( (LatinParserNode)DOUBLENUMBER254 ) );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1192:4: expr[exprPlan]
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_sample_clause3722);
					expr255=expr(exprPlan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, expr255.getTree());

					if ( state.backtracking==0 ) {
					       retval.alias = builder.buildSampleOp( new SourceLocation( (LatinParserNode)SAMPLE252 ),
					           (LOFilter)GScope_stack.peek().currentOp,
                               statement_stack.peek().alias,
                               statement_stack.peek().inputAlias,
                               exprPlan,
                               (expr255!=null?((LogicalPlanGenerator.expr_return)expr255).expr:null)
                           );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;

			}

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			}

		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
			GScope_stack.pop();

		}
		return retval;
	}
	// $ANTLR end "sample_clause"


	protected static class rank_clause_scope {
		LORank rankOp;
	}
	protected Stack<rank_clause_scope> rank_clause_stack = new Stack<rank_clause_scope>();

	public static class rank_clause_return extends TreeRuleReturnScope {
		public String alias;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rank_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1200:1: rank_clause returns [String alias] : ^( RANK rel ( rank_by_statement )? ) ;
	public final LogicalPlanGenerator.rank_clause_return rank_clause() throws RecognitionException {
		GScope_stack.push(new GScope_scope());
		rank_clause_stack.push(new rank_clause_scope());
		LogicalPlanGenerator.rank_clause_return retval = new LogicalPlanGenerator.rank_clause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree RANK256=null;
		TreeRuleReturnScope rel257 =null;
		TreeRuleReturnScope rank_by_statement258 =null;

		CommonTree RANK256_tree=null;


			GScope_stack.peek().currentOp = builder.createRankOp();

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1210:2: ( ^( RANK rel ( rank_by_statement )? ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1210:4: ^( RANK rel ( rank_by_statement )? )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			RANK256=(CommonTree)match(input,RANK,FOLLOW_RANK_in_rank_clause3768); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RANK256_tree = (CommonTree)adaptor.dupNode(RANK256);


			root_1 = (CommonTree)adaptor.becomeRoot(RANK256_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_rel_in_rank_clause3770);
			rel257=rel();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, rel257.getTree());

			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1210:16: ( rank_by_statement )?
			int alt80=2;
			int LA80_0 = input.LA(1);
			if ( (LA80_0==BY) ) {
				alt80=1;
			}
			switch (alt80) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1210:16: rank_by_statement
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_rank_by_statement_in_rank_clause3772);
					rank_by_statement258=rank_by_statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, rank_by_statement258.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;

			}

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
				SourceLocation loc = new SourceLocation( (LatinParserNode) ((CommonTree)retval.start) );

				List<LogicalExpressionPlan> tempPlans = (rank_by_statement258!=null?((LogicalPlanGenerator.rank_by_statement_return)rank_by_statement258).plans:null);
				List<Boolean> tempAscFlags = (rank_by_statement258!=null?((LogicalPlanGenerator.rank_by_statement_return)rank_by_statement258).ascFlags:null);

				if(tempPlans == null && tempAscFlags == null) {
					tempPlans = new ArrayList<LogicalExpressionPlan>();
					tempAscFlags = new ArrayList<Boolean>();

					((LORank)GScope_stack.peek().currentOp).setIsRowNumber( true );
				}

				((LORank)GScope_stack.peek().currentOp).setIsDenseRank( (rank_by_statement258!=null?((LogicalPlanGenerator.rank_by_statement_return)rank_by_statement258).isDenseRank:null) != null?(rank_by_statement258!=null?((LogicalPlanGenerator.rank_by_statement_return)rank_by_statement258).isDenseRank:null):false );

				retval.alias = builder.buildRankOp( loc, (LORank)GScope_stack.peek().currentOp, statement_stack.peek().alias, statement_stack.peek().inputAlias, tempPlans, tempAscFlags );
			 }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			}

			if ( state.backtracking==0 ) {
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
			GScope_stack.pop();
			rank_clause_stack.pop();
		}
		return retval;
	}
	// $ANTLR end "rank_clause"


	public static class rank_by_statement_return extends TreeRuleReturnScope {
		public List<LogicalExpressionPlan> plans;
		public List<Boolean> ascFlags;
		public Boolean isDenseRank;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rank_by_statement"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1230:1: rank_by_statement returns [List<LogicalExpressionPlan> plans, List<Boolean> ascFlags, Boolean isDenseRank] : ^( BY rank_by_clause ( DENSE )? ) ;
	public final LogicalPlanGenerator.rank_by_statement_return rank_by_statement() throws RecognitionException {
		LogicalPlanGenerator.rank_by_statement_return retval = new LogicalPlanGenerator.rank_by_statement_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree BY259=null;
		CommonTree DENSE261=null;
		TreeRuleReturnScope rank_by_clause260 =null;

		CommonTree BY259_tree=null;
		CommonTree DENSE261_tree=null;


		    retval.plans = new ArrayList<LogicalExpressionPlan>();
		    retval.ascFlags = new ArrayList<Boolean>();
		    retval.isDenseRank = false;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1236:2: ( ^( BY rank_by_clause ( DENSE )? ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1236:4: ^( BY rank_by_clause ( DENSE )? )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			BY259=(CommonTree)match(input,BY,FOLLOW_BY_in_rank_by_statement3798); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			BY259_tree = (CommonTree)adaptor.dupNode(BY259);


			root_1 = (CommonTree)adaptor.becomeRoot(BY259_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_rank_by_clause_in_rank_by_statement3800);
			rank_by_clause260=rank_by_clause();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, rank_by_clause260.getTree());

			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1236:25: ( DENSE )?
			int alt81=2;
			int LA81_0 = input.LA(1);
			if ( (LA81_0==DENSE) ) {
				alt81=1;
			}
			switch (alt81) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1236:27: DENSE
					{
					_last = (CommonTree)input.LT(1);
					DENSE261=(CommonTree)match(input,DENSE,FOLLOW_DENSE_in_rank_by_statement3804); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DENSE261_tree = (CommonTree)adaptor.dupNode(DENSE261);


					adaptor.addChild(root_1, DENSE261_tree);
					}

					if ( state.backtracking==0 ) { retval.isDenseRank =  true; }
					if ( state.backtracking==0 ) {
					}

					}
					break;

			}

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
				retval.plans = (rank_by_clause260!=null?((LogicalPlanGenerator.rank_by_clause_return)rank_by_clause260).plans:null);
				retval.ascFlags = (rank_by_clause260!=null?((LogicalPlanGenerator.rank_by_clause_return)rank_by_clause260).ascFlags:null);
			 }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class rank_by_clause_return extends TreeRuleReturnScope {
		public List<LogicalExpressionPlan> plans;
		public List<Boolean> ascFlags;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rank_by_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1243:1: rank_by_clause returns [List<LogicalExpressionPlan> plans, List<Boolean> ascFlags] : ( STAR ( ASC | DESC )? | ( rank_col )+ );
	public final LogicalPlanGenerator.rank_by_clause_return rank_by_clause() throws RecognitionException {
		LogicalPlanGenerator.rank_by_clause_return retval = new LogicalPlanGenerator.rank_by_clause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree STAR262=null;
		CommonTree ASC263=null;
		CommonTree DESC264=null;
		TreeRuleReturnScope rank_col265 =null;

		CommonTree STAR262_tree=null;
		CommonTree ASC263_tree=null;
		CommonTree DESC264_tree=null;


		    retval.plans = new ArrayList<LogicalExpressionPlan>();
		    retval.ascFlags = new ArrayList<Boolean>();

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1248:2: ( STAR ( ASC | DESC )? | ( rank_col )+ )
			int alt84=2;
			int LA84_0 = input.LA(1);
			if ( (LA84_0==STAR) ) {
				alt84=1;
			}
			else if ( (LA84_0==CUBE||LA84_0==DOLLARVAR||LA84_0==GROUP||LA84_0==IDENTIFIER||LA84_0==COL_RANGE) ) {
				alt84=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 84, 0, input);
				throw nvae;
			}

			switch (alt84) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1248:4: STAR ( ASC | DESC )?
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					STAR262=(CommonTree)match(input,STAR,FOLLOW_STAR_in_rank_by_clause3833); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STAR262_tree = (CommonTree)adaptor.dupNode(STAR262);


					adaptor.addChild(root_0, STAR262_tree);
					}

					if ( state.backtracking==0 ) {
							LogicalExpressionPlan plan = new LogicalExpressionPlan();
							builder.buildProjectExpr( new SourceLocation( (LatinParserNode)STAR262 ), plan, GScope_stack.peek().currentOp, statement_stack.peek().inputIndex, null, -1 );
							retval.plans.add( plan );
					   }
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1253:4: ( ASC | DESC )?
					int alt82=3;
					int LA82_0 = input.LA(1);
					if ( (LA82_0==ASC) ) {
						alt82=1;
					}
					else if ( (LA82_0==DESC) ) {
						alt82=2;
					}
					switch (alt82) {
						case 1 :
							// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1253:6: ASC
							{
							_last = (CommonTree)input.LT(1);
							ASC263=(CommonTree)match(input,ASC,FOLLOW_ASC_in_rank_by_clause3842); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							ASC263_tree = (CommonTree)adaptor.dupNode(ASC263);


							adaptor.addChild(root_0, ASC263_tree);
							}

							if ( state.backtracking==0 ) { retval.ascFlags.add( true ); }
							if ( state.backtracking==0 ) {
							}

							}
							break;
						case 2 :
							// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1253:39: DESC
							{
							_last = (CommonTree)input.LT(1);
							DESC264=(CommonTree)match(input,DESC,FOLLOW_DESC_in_rank_by_clause3848); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							DESC264_tree = (CommonTree)adaptor.dupNode(DESC264);


							adaptor.addChild(root_0, DESC264_tree);
							}

							if ( state.backtracking==0 ) { retval.ascFlags.add( false ); }
							if ( state.backtracking==0 ) {
							}

							}
							break;

					}

					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1254:4: ( rank_col )+
					{
					root_0 = (CommonTree)adaptor.nil();


					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1254:4: ( rank_col )+
					int cnt83=0;
					loop83:
					while (true) {
						int alt83=2;
						int LA83_0 = input.LA(1);
						if ( (LA83_0==CUBE||LA83_0==DOLLARVAR||LA83_0==GROUP||LA83_0==IDENTIFIER||LA83_0==COL_RANGE) ) {
							alt83=1;
						}

						switch (alt83) {
						case 1 :
							// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1254:6: rank_col
							{
							_last = (CommonTree)input.LT(1);
							pushFollow(FOLLOW_rank_col_in_rank_by_clause3860);
							rank_col265=rank_col();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) 
							adaptor.addChild(root_0, rank_col265.getTree());

							if ( state.backtracking==0 ) {
							       retval.plans.add( (rank_col265!=null?((LogicalPlanGenerator.rank_col_return)rank_col265).plan:null) );
							       retval.ascFlags.add( (rank_col265!=null?((LogicalPlanGenerator.rank_col_return)rank_col265).ascFlag:null) );
							   }
							if ( state.backtracking==0 ) {
							}

							}
							break;

						default :
							if ( cnt83 >= 1 ) break loop83;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(83, input);
							throw eee;
						}
						cnt83++;
					}

					if ( state.backtracking==0 ) {
					}

					}
					break;

			}
			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class rank_col_return extends TreeRuleReturnScope {
		public LogicalExpressionPlan plan;
		public Boolean ascFlag;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rank_col"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1261:1: rank_col returns [LogicalExpressionPlan plan, Boolean ascFlag] : ( col_range[$plan] ( ASC | DESC )? | col_ref[$plan] ( ASC | DESC )? );
	public final LogicalPlanGenerator.rank_col_return rank_col() throws RecognitionException {
		LogicalPlanGenerator.rank_col_return retval = new LogicalPlanGenerator.rank_col_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree ASC267=null;
		CommonTree DESC268=null;
		CommonTree ASC270=null;
		CommonTree DESC271=null;
		TreeRuleReturnScope col_range266 =null;
		TreeRuleReturnScope col_ref269 =null;

		CommonTree ASC267_tree=null;
		CommonTree DESC268_tree=null;
		CommonTree ASC270_tree=null;
		CommonTree DESC271_tree=null;


		    retval.plan = new LogicalExpressionPlan();
		    retval.ascFlag = true;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1266:2: ( col_range[$plan] ( ASC | DESC )? | col_ref[$plan] ( ASC | DESC )? )
			int alt87=2;
			int LA87_0 = input.LA(1);
			if ( (LA87_0==COL_RANGE) ) {
				alt87=1;
			}
			else if ( (LA87_0==CUBE||LA87_0==DOLLARVAR||LA87_0==GROUP||LA87_0==IDENTIFIER) ) {
				alt87=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 87, 0, input);
				throw nvae;
			}

			switch (alt87) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1266:4: col_range[$plan] ( ASC | DESC )?
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_col_range_in_rank_col3886);
					col_range266=col_range(retval.plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, col_range266.getTree());

					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1266:21: ( ASC | DESC )?
					int alt85=3;
					int LA85_0 = input.LA(1);
					if ( (LA85_0==ASC) ) {
						alt85=1;
					}
					else if ( (LA85_0==DESC) ) {
						alt85=2;
					}
					switch (alt85) {
						case 1 :
							// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1266:22: ASC
							{
							_last = (CommonTree)input.LT(1);
							ASC267=(CommonTree)match(input,ASC,FOLLOW_ASC_in_rank_col3890); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							ASC267_tree = (CommonTree)adaptor.dupNode(ASC267);


							adaptor.addChild(root_0, ASC267_tree);
							}

							if ( state.backtracking==0 ) {
							}

							}
							break;
						case 2 :
							// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1266:28: DESC
							{
							_last = (CommonTree)input.LT(1);
							DESC268=(CommonTree)match(input,DESC,FOLLOW_DESC_in_rank_col3894); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							DESC268_tree = (CommonTree)adaptor.dupNode(DESC268);


							adaptor.addChild(root_0, DESC268_tree);
							}

							if ( state.backtracking==0 ) { retval.ascFlag = false; }
							if ( state.backtracking==0 ) {
							}

							}
							break;

					}

					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1267:4: col_ref[$plan] ( ASC | DESC )?
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_col_ref_in_rank_col3904);
					col_ref269=col_ref(retval.plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, col_ref269.getTree());

					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1267:19: ( ASC | DESC )?
					int alt86=3;
					int LA86_0 = input.LA(1);
					if ( (LA86_0==ASC) ) {
						alt86=1;
					}
					else if ( (LA86_0==DESC) ) {
						alt86=2;
					}
					switch (alt86) {
						case 1 :
							// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1267:21: ASC
							{
							_last = (CommonTree)input.LT(1);
							ASC270=(CommonTree)match(input,ASC,FOLLOW_ASC_in_rank_col3909); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							ASC270_tree = (CommonTree)adaptor.dupNode(ASC270);


							adaptor.addChild(root_0, ASC270_tree);
							}

							if ( state.backtracking==0 ) {
							}

							}
							break;
						case 2 :
							// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1267:27: DESC
							{
							_last = (CommonTree)input.LT(1);
							DESC271=(CommonTree)match(input,DESC,FOLLOW_DESC_in_rank_col3913); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							DESC271_tree = (CommonTree)adaptor.dupNode(DESC271);


							adaptor.addChild(root_0, DESC271_tree);
							}

							if ( state.backtracking==0 ) { retval.ascFlag = false; }
							if ( state.backtracking==0 ) {
							}

							}
							break;

					}

					if ( state.backtracking==0 ) {
					}

					}
					break;

			}
			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class order_clause_return extends TreeRuleReturnScope {
		public String alias;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "order_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1270:1: order_clause returns [String alias] : ^( ORDER rel order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? ) ;
	public final LogicalPlanGenerator.order_clause_return order_clause() throws RecognitionException {
		GScope_stack.push(new GScope_scope());

		LogicalPlanGenerator.order_clause_return retval = new LogicalPlanGenerator.order_clause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree ORDER272=null;
		TreeRuleReturnScope rel273 =null;
		TreeRuleReturnScope order_by_clause274 =null;
		TreeRuleReturnScope func_clause275 =null;

		CommonTree ORDER272_tree=null;


		    GScope_stack.peek().currentOp = builder.createSortOp();

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1275:2: ( ^( ORDER rel order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1275:4: ^( ORDER rel order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			ORDER272=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_order_clause3943); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ORDER272_tree = (CommonTree)adaptor.dupNode(ORDER272);


			root_1 = (CommonTree)adaptor.becomeRoot(ORDER272_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_rel_in_order_clause3945);
			rel273=rel();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, rel273.getTree());

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_order_by_clause_in_order_clause3947);
			order_by_clause274=order_by_clause();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, order_by_clause274.getTree());

			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1275:33: ( func_clause[FunctionType.COMPARISONFUNC] )?
			int alt88=2;
			int LA88_0 = input.LA(1);
			if ( (LA88_0==FUNC||LA88_0==FUNC_REF) ) {
				alt88=1;
			}
			switch (alt88) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1275:33: func_clause[FunctionType.COMPARISONFUNC]
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_func_clause_in_order_clause3949);
					func_clause275=func_clause(FunctionType.COMPARISONFUNC);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, func_clause275.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;

			}

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			       SourceLocation loc = new SourceLocation( (LatinParserNode)ORDER272 );
			       retval.alias = builder.buildSortOp( loc, (LOSort)GScope_stack.peek().currentOp, statement_stack.peek().alias,
			           statement_stack.peek().inputAlias, (order_by_clause274!=null?((LogicalPlanGenerator.order_by_clause_return)order_by_clause274).plans:null),
			           (order_by_clause274!=null?((LogicalPlanGenerator.order_by_clause_return)order_by_clause274).ascFlags:null), (func_clause275!=null?((LogicalPlanGenerator.func_clause_return)func_clause275).funcSpec:null) );
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			}

		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
			GScope_stack.pop();

		}
		return retval;
	}
	// $ANTLR end "order_clause"


	public static class order_by_clause_return extends TreeRuleReturnScope {
		public List<LogicalExpressionPlan> plans;
		public List<Boolean> ascFlags;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "order_by_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1284:1: order_by_clause returns [List<LogicalExpressionPlan> plans, List<Boolean> ascFlags] : ( STAR ( ASC | DESC )? | ( order_col )+ );
	public final LogicalPlanGenerator.order_by_clause_return order_by_clause() throws RecognitionException {
		LogicalPlanGenerator.order_by_clause_return retval = new LogicalPlanGenerator.order_by_clause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree STAR276=null;
		CommonTree ASC277=null;
		CommonTree DESC278=null;
		TreeRuleReturnScope order_col279 =null;

		CommonTree STAR276_tree=null;
		CommonTree ASC277_tree=null;
		CommonTree DESC278_tree=null;


		    retval.plans = new ArrayList<LogicalExpressionPlan>();
		    retval.ascFlags = new ArrayList<Boolean>();

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1289:2: ( STAR ( ASC | DESC )? | ( order_col )+ )
			int alt91=2;
			int LA91_0 = input.LA(1);
			if ( (LA91_0==STAR) ) {
				alt91=1;
			}
			else if ( (LA91_0==CUBE||LA91_0==DOLLARVAR||LA91_0==GROUP||LA91_0==IDENTIFIER||LA91_0==COL_RANGE) ) {
				alt91=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 91, 0, input);
				throw nvae;
			}

			switch (alt91) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1289:4: STAR ( ASC | DESC )?
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					STAR276=(CommonTree)match(input,STAR,FOLLOW_STAR_in_order_by_clause3976); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STAR276_tree = (CommonTree)adaptor.dupNode(STAR276);


					adaptor.addChild(root_0, STAR276_tree);
					}

					if ( state.backtracking==0 ) {
					       LogicalExpressionPlan plan = new LogicalExpressionPlan();
					       builder.buildProjectExpr( new SourceLocation( (LatinParserNode)STAR276 ), plan, GScope_stack.peek().currentOp,
					           statement_stack.peek().inputIndex, null, -1 );
					       retval.plans.add( plan );
					   }
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1295:4: ( ASC | DESC )?
					int alt89=3;
					int LA89_0 = input.LA(1);
					if ( (LA89_0==ASC) ) {
						alt89=1;
					}
					else if ( (LA89_0==DESC) ) {
						alt89=2;
					}
					switch (alt89) {
						case 1 :
							// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1295:6: ASC
							{
							_last = (CommonTree)input.LT(1);
							ASC277=(CommonTree)match(input,ASC,FOLLOW_ASC_in_order_by_clause3985); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							ASC277_tree = (CommonTree)adaptor.dupNode(ASC277);


							adaptor.addChild(root_0, ASC277_tree);
							}

							if ( state.backtracking==0 ) { retval.ascFlags.add( true ); }
							if ( state.backtracking==0 ) {
							}

							}
							break;
						case 2 :
							// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1295:39: DESC
							{
							_last = (CommonTree)input.LT(1);
							DESC278=(CommonTree)match(input,DESC,FOLLOW_DESC_in_order_by_clause3991); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							DESC278_tree = (CommonTree)adaptor.dupNode(DESC278);


							adaptor.addChild(root_0, DESC278_tree);
							}

							if ( state.backtracking==0 ) { retval.ascFlags.add( false ); }
							if ( state.backtracking==0 ) {
							}

							}
							break;

					}

					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1296:4: ( order_col )+
					{
					root_0 = (CommonTree)adaptor.nil();


					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1296:4: ( order_col )+
					int cnt90=0;
					loop90:
					while (true) {
						int alt90=2;
						int LA90_0 = input.LA(1);
						if ( (LA90_0==CUBE||LA90_0==DOLLARVAR||LA90_0==GROUP||LA90_0==IDENTIFIER||LA90_0==COL_RANGE) ) {
							alt90=1;
						}

						switch (alt90) {
						case 1 :
							// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1296:6: order_col
							{
							_last = (CommonTree)input.LT(1);
							pushFollow(FOLLOW_order_col_in_order_by_clause4003);
							order_col279=order_col();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) 
							adaptor.addChild(root_0, order_col279.getTree());

							if ( state.backtracking==0 ) {
							       retval.plans.add( (order_col279!=null?((LogicalPlanGenerator.order_col_return)order_col279).plan:null) );
							       retval.ascFlags.add( (order_col279!=null?((LogicalPlanGenerator.order_col_return)order_col279).ascFlag:null) );
							   }
							if ( state.backtracking==0 ) {
							}

							}
							break;

						default :
							if ( cnt90 >= 1 ) break loop90;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(90, input);
							throw eee;
						}
						cnt90++;
					}

					if ( state.backtracking==0 ) {
					}

					}
					break;

			}
			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class order_col_return extends TreeRuleReturnScope {
		public LogicalExpressionPlan plan;
		public Boolean ascFlag;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "order_col"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1303:1: order_col returns [LogicalExpressionPlan plan, Boolean ascFlag] : ( col_range[$plan] ( ASC | DESC )? | col_ref[$plan] ( ASC | DESC )? );
	public final LogicalPlanGenerator.order_col_return order_col() throws RecognitionException {
		LogicalPlanGenerator.order_col_return retval = new LogicalPlanGenerator.order_col_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree ASC281=null;
		CommonTree DESC282=null;
		CommonTree ASC284=null;
		CommonTree DESC285=null;
		TreeRuleReturnScope col_range280 =null;
		TreeRuleReturnScope col_ref283 =null;

		CommonTree ASC281_tree=null;
		CommonTree DESC282_tree=null;
		CommonTree ASC284_tree=null;
		CommonTree DESC285_tree=null;


		    retval.plan = new LogicalExpressionPlan();
		    retval.ascFlag = true;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1308:2: ( col_range[$plan] ( ASC | DESC )? | col_ref[$plan] ( ASC | DESC )? )
			int alt94=2;
			int LA94_0 = input.LA(1);
			if ( (LA94_0==COL_RANGE) ) {
				alt94=1;
			}
			else if ( (LA94_0==CUBE||LA94_0==DOLLARVAR||LA94_0==GROUP||LA94_0==IDENTIFIER) ) {
				alt94=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 94, 0, input);
				throw nvae;
			}

			switch (alt94) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1308:4: col_range[$plan] ( ASC | DESC )?
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_col_range_in_order_col4029);
					col_range280=col_range(retval.plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, col_range280.getTree());

					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1308:21: ( ASC | DESC )?
					int alt92=3;
					int LA92_0 = input.LA(1);
					if ( (LA92_0==ASC) ) {
						alt92=1;
					}
					else if ( (LA92_0==DESC) ) {
						alt92=2;
					}
					switch (alt92) {
						case 1 :
							// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1308:22: ASC
							{
							_last = (CommonTree)input.LT(1);
							ASC281=(CommonTree)match(input,ASC,FOLLOW_ASC_in_order_col4033); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							ASC281_tree = (CommonTree)adaptor.dupNode(ASC281);


							adaptor.addChild(root_0, ASC281_tree);
							}

							if ( state.backtracking==0 ) {
							}

							}
							break;
						case 2 :
							// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1308:28: DESC
							{
							_last = (CommonTree)input.LT(1);
							DESC282=(CommonTree)match(input,DESC,FOLLOW_DESC_in_order_col4037); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							DESC282_tree = (CommonTree)adaptor.dupNode(DESC282);


							adaptor.addChild(root_0, DESC282_tree);
							}

							if ( state.backtracking==0 ) { retval.ascFlag = false; }
							if ( state.backtracking==0 ) {
							}

							}
							break;

					}

					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1309:4: col_ref[$plan] ( ASC | DESC )?
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_col_ref_in_order_col4047);
					col_ref283=col_ref(retval.plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, col_ref283.getTree());

					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1309:19: ( ASC | DESC )?
					int alt93=3;
					int LA93_0 = input.LA(1);
					if ( (LA93_0==ASC) ) {
						alt93=1;
					}
					else if ( (LA93_0==DESC) ) {
						alt93=2;
					}
					switch (alt93) {
						case 1 :
							// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1309:21: ASC
							{
							_last = (CommonTree)input.LT(1);
							ASC284=(CommonTree)match(input,ASC,FOLLOW_ASC_in_order_col4052); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							ASC284_tree = (CommonTree)adaptor.dupNode(ASC284);


							adaptor.addChild(root_0, ASC284_tree);
							}

							if ( state.backtracking==0 ) {
							}

							}
							break;
						case 2 :
							// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1309:27: DESC
							{
							_last = (CommonTree)input.LT(1);
							DESC285=(CommonTree)match(input,DESC,FOLLOW_DESC_in_order_col4056); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							DESC285_tree = (CommonTree)adaptor.dupNode(DESC285);


							adaptor.addChild(root_0, DESC285_tree);
							}

							if ( state.backtracking==0 ) { retval.ascFlag = false; }
							if ( state.backtracking==0 ) {
							}

							}
							break;

					}

					if ( state.backtracking==0 ) {
					}

					}
					break;

			}
			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class distinct_clause_return extends TreeRuleReturnScope {
		public String alias;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "distinct_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1312:1: distinct_clause returns [String alias] : ^( DISTINCT rel ( partition_clause )? ) ;
	public final LogicalPlanGenerator.distinct_clause_return distinct_clause() throws RecognitionException {
		LogicalPlanGenerator.distinct_clause_return retval = new LogicalPlanGenerator.distinct_clause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree DISTINCT286=null;
		TreeRuleReturnScope rel287 =null;
		TreeRuleReturnScope partition_clause288 =null;

		CommonTree DISTINCT286_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1313:2: ( ^( DISTINCT rel ( partition_clause )? ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1313:4: ^( DISTINCT rel ( partition_clause )? )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			DISTINCT286=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_distinct_clause4076); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			DISTINCT286_tree = (CommonTree)adaptor.dupNode(DISTINCT286);


			root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT286_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_rel_in_distinct_clause4078);
			rel287=rel();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, rel287.getTree());

			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1313:20: ( partition_clause )?
			int alt95=2;
			int LA95_0 = input.LA(1);
			if ( (LA95_0==PARTITION) ) {
				alt95=1;
			}
			switch (alt95) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1313:20: partition_clause
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_partition_clause_in_distinct_clause4080);
					partition_clause288=partition_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, partition_clause288.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;

			}

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			       retval.alias = builder.buildDistinctOp( new SourceLocation( (LatinParserNode)DISTINCT286 ), statement_stack.peek().alias,
			          statement_stack.peek().inputAlias, (partition_clause288!=null?((LogicalPlanGenerator.partition_clause_return)partition_clause288).partitioner:null) );
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class partition_clause_return extends TreeRuleReturnScope {
		public String partitioner;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "partition_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1320:1: partition_clause returns [String partitioner] : ^( PARTITION func_name ) ;
	public final LogicalPlanGenerator.partition_clause_return partition_clause() throws RecognitionException {
		LogicalPlanGenerator.partition_clause_return retval = new LogicalPlanGenerator.partition_clause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree PARTITION289=null;
		TreeRuleReturnScope func_name290 =null;

		CommonTree PARTITION289_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1321:2: ( ^( PARTITION func_name ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1321:4: ^( PARTITION func_name )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			PARTITION289=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_partition_clause4103); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			PARTITION289_tree = (CommonTree)adaptor.dupNode(PARTITION289);


			root_1 = (CommonTree)adaptor.becomeRoot(PARTITION289_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_func_name_in_partition_clause4105);
			func_name290=func_name();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, func_name290.getTree());

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			       retval.partitioner = (func_name290!=null?((LogicalPlanGenerator.func_name_return)func_name290).funcName:null);
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class cross_clause_return extends TreeRuleReturnScope {
		public String alias;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "cross_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1327:1: cross_clause returns [String alias] : ^( CROSS rel_list ( partition_clause )? ) ;
	public final LogicalPlanGenerator.cross_clause_return cross_clause() throws RecognitionException {
		LogicalPlanGenerator.cross_clause_return retval = new LogicalPlanGenerator.cross_clause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree CROSS291=null;
		TreeRuleReturnScope rel_list292 =null;
		TreeRuleReturnScope partition_clause293 =null;

		CommonTree CROSS291_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1328:2: ( ^( CROSS rel_list ( partition_clause )? ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1328:4: ^( CROSS rel_list ( partition_clause )? )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			CROSS291=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_cross_clause4127); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			CROSS291_tree = (CommonTree)adaptor.dupNode(CROSS291);


			root_1 = (CommonTree)adaptor.becomeRoot(CROSS291_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_rel_list_in_cross_clause4129);
			rel_list292=rel_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, rel_list292.getTree());

			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1328:22: ( partition_clause )?
			int alt96=2;
			int LA96_0 = input.LA(1);
			if ( (LA96_0==PARTITION) ) {
				alt96=1;
			}
			switch (alt96) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1328:22: partition_clause
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_partition_clause_in_cross_clause4131);
					partition_clause293=partition_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, partition_clause293.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;

			}

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			       retval.alias = builder.buildCrossOp( new SourceLocation( (LatinParserNode)CROSS291 ), statement_stack.peek().alias,
			          (rel_list292!=null?((LogicalPlanGenerator.rel_list_return)rel_list292).aliasList:null), (partition_clause293!=null?((LogicalPlanGenerator.partition_clause_return)partition_clause293).partitioner:null) );
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class rel_list_return extends TreeRuleReturnScope {
		public List<String> aliasList;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rel_list"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1335:1: rel_list returns [List<String> aliasList] : ( rel )+ ;
	public final LogicalPlanGenerator.rel_list_return rel_list() throws RecognitionException {
		LogicalPlanGenerator.rel_list_return retval = new LogicalPlanGenerator.rel_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope rel294 =null;


		 retval.aliasList = new ArrayList<String>(); 
		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1337:2: ( ( rel )+ )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1337:4: ( rel )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1337:4: ( rel )+
			int cnt97=0;
			loop97:
			while (true) {
				int alt97=2;
				int LA97_0 = input.LA(1);
				if ( (LA97_0==ARROBA||LA97_0==ASSERT||LA97_0==COGROUP||(LA97_0 >= CROSS && LA97_0 <= CUBE)||LA97_0==DEFINE||LA97_0==DISTINCT||LA97_0==FILTER||LA97_0==FOREACH||LA97_0==GROUP||LA97_0==IDENTIFIER||LA97_0==JOIN||(LA97_0 >= LIMIT && LA97_0 <= LOAD)||LA97_0==MAPREDUCE||LA97_0==ORDER||LA97_0==RANK||LA97_0==SAMPLE||(LA97_0 >= STORE && LA97_0 <= STREAM)||LA97_0==UNION) ) {
					alt97=1;
				}

				switch (alt97) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1337:6: rel
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_rel_in_rel_list4159);
					rel294=rel();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, rel294.getTree());

					if ( state.backtracking==0 ) { retval.aliasList.add( statement_stack.peek().inputAlias ); }
					if ( state.backtracking==0 ) {
					}

					}
					break;

				default :
					if ( cnt97 >= 1 ) break loop97;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(97, input);
					throw eee;
				}
				cnt97++;
			}

			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	protected static class join_clause_scope {
		MultiMap<Integer, LogicalExpressionPlan> joinPlans;
		int inputIndex;
		List<String> inputAliases;
		List<Boolean> innerFlags;
	}
	protected Stack<join_clause_scope> join_clause_stack = new Stack<join_clause_scope>();

	public static class join_clause_return extends TreeRuleReturnScope {
		public String alias;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "join_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1340:1: join_clause returns [String alias] : ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) ;
	public final LogicalPlanGenerator.join_clause_return join_clause() throws RecognitionException {
		GScope_stack.push(new GScope_scope());
		join_clause_stack.push(new join_clause_scope());
		LogicalPlanGenerator.join_clause_return retval = new LogicalPlanGenerator.join_clause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree JOIN295=null;
		TreeRuleReturnScope join_sub_clause296 =null;
		TreeRuleReturnScope join_type297 =null;
		TreeRuleReturnScope partition_clause298 =null;

		CommonTree JOIN295_tree=null;


		    GScope_stack.peek().currentOp = builder.createJoinOp();
		    join_clause_stack.peek().joinPlans = new MultiMap<Integer, LogicalExpressionPlan>();
		    join_clause_stack.peek().inputAliases = new ArrayList<String>();
		    join_clause_stack.peek().innerFlags = new ArrayList<Boolean>();
		    int oldStatementIndex = statement_stack.peek().inputIndex;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1358:2: ( ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1358:4: ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			JOIN295=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_join_clause4198); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			JOIN295_tree = (CommonTree)adaptor.dupNode(JOIN295);


			root_1 = (CommonTree)adaptor.becomeRoot(JOIN295_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_join_sub_clause_in_join_clause4200);
			join_sub_clause296=join_sub_clause();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, join_sub_clause296.getTree());

			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1358:28: ( join_type )?
			int alt98=2;
			int LA98_0 = input.LA(1);
			if ( (LA98_0==QUOTEDSTRING) ) {
				alt98=1;
			}
			switch (alt98) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1358:28: join_type
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_join_type_in_join_clause4202);
					join_type297=join_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, join_type297.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;

			}

			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1358:39: ( partition_clause )?
			int alt99=2;
			int LA99_0 = input.LA(1);
			if ( (LA99_0==PARTITION) ) {
				alt99=1;
			}
			switch (alt99) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1358:39: partition_clause
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_partition_clause_in_join_clause4205);
					partition_clause298=partition_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, partition_clause298.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;

			}

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			       SourceLocation loc = new SourceLocation( (LatinParserNode)JOIN295 );
			       retval.alias = builder.buildJoinOp( loc, (LOJoin)GScope_stack.peek().currentOp, statement_stack.peek().alias,
			          join_clause_stack.peek().inputAliases, join_clause_stack.peek().joinPlans,
			          (join_type297!=null?((LogicalPlanGenerator.join_type_return)join_type297).type:null), join_clause_stack.peek().innerFlags, (partition_clause298!=null?((LogicalPlanGenerator.partition_clause_return)partition_clause298).partitioner:null) );
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			}

			if ( state.backtracking==0 ) {
			   statement_stack.peek().inputIndex =oldStatementIndex;
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
			GScope_stack.pop();
			join_clause_stack.pop();
		}
		return retval;
	}
	// $ANTLR end "join_clause"


	public static class join_type_return extends TreeRuleReturnScope {
		public JOINTYPE type;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "join_type"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1367:1: join_type returns [JOINTYPE type] : QUOTEDSTRING ;
	public final LogicalPlanGenerator.join_type_return join_type() throws RecognitionException {
		LogicalPlanGenerator.join_type_return retval = new LogicalPlanGenerator.join_type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree QUOTEDSTRING299=null;

		CommonTree QUOTEDSTRING299_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1368:2: ( QUOTEDSTRING )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1368:4: QUOTEDSTRING
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			QUOTEDSTRING299=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_join_type4226); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			QUOTEDSTRING299_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING299);


			adaptor.addChild(root_0, QUOTEDSTRING299_tree);
			}

			if ( state.backtracking==0 ) {
			       retval.type = builder.parseJoinType( (QUOTEDSTRING299!=null?QUOTEDSTRING299.getText():null), new SourceLocation( (LatinParserNode)QUOTEDSTRING299 ) );
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class join_sub_clause_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "join_sub_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1374:1: join_sub_clause : ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ );
	public final LogicalPlanGenerator.join_sub_clause_return join_sub_clause() throws RecognitionException {
		LogicalPlanGenerator.join_sub_clause_return retval = new LogicalPlanGenerator.join_sub_clause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree LEFT301=null;
		CommonTree RIGHT302=null;
		CommonTree FULL303=null;
		CommonTree OUTER304=null;
		TreeRuleReturnScope join_item300 =null;
		TreeRuleReturnScope join_item305 =null;
		TreeRuleReturnScope join_item306 =null;

		CommonTree LEFT301_tree=null;
		CommonTree RIGHT302_tree=null;
		CommonTree FULL303_tree=null;
		CommonTree OUTER304_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1375:2: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ )
			int alt103=2;
			int LA103_0 = input.LA(1);
			if ( (LA103_0==JOIN_ITEM) ) {
				int LA103_1 = input.LA(2);
				if ( (synpred179_LogicalPlanGenerator()) ) {
					alt103=1;
				}
				else if ( (true) ) {
					alt103=2;
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 103, 0, input);
				throw nvae;
			}

			switch (alt103) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1375:4: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_join_item_in_join_sub_clause4241);
					join_item300=join_item();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, join_item300.getTree());

					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1375:14: ( LEFT | RIGHT | FULL )
					int alt100=3;
					switch ( input.LA(1) ) {
					case LEFT:
						{
						alt100=1;
						}
						break;
					case RIGHT:
						{
						alt100=2;
						}
						break;
					case FULL:
						{
						alt100=3;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 100, 0, input);
						throw nvae;
					}
					switch (alt100) {
						case 1 :
							// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1375:16: LEFT
							{
							_last = (CommonTree)input.LT(1);
							LEFT301=(CommonTree)match(input,LEFT,FOLLOW_LEFT_in_join_sub_clause4245); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							LEFT301_tree = (CommonTree)adaptor.dupNode(LEFT301);


							adaptor.addChild(root_0, LEFT301_tree);
							}

							if ( state.backtracking==0 ) { join_clause_stack.peek().innerFlags.add( true );
							                      join_clause_stack.peek().innerFlags.add( false ); }
							if ( state.backtracking==0 ) {
							}

							}
							break;
						case 2 :
							// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1377:16: RIGHT
							{
							_last = (CommonTree)input.LT(1);
							RIGHT302=(CommonTree)match(input,RIGHT,FOLLOW_RIGHT_in_join_sub_clause4264); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							RIGHT302_tree = (CommonTree)adaptor.dupNode(RIGHT302);


							adaptor.addChild(root_0, RIGHT302_tree);
							}

							if ( state.backtracking==0 ) { join_clause_stack.peek().innerFlags.add( false );
							                       join_clause_stack.peek().innerFlags.add( true ); }
							if ( state.backtracking==0 ) {
							}

							}
							break;
						case 3 :
							// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1379:16: FULL
							{
							_last = (CommonTree)input.LT(1);
							FULL303=(CommonTree)match(input,FULL,FOLLOW_FULL_in_join_sub_clause4283); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							FULL303_tree = (CommonTree)adaptor.dupNode(FULL303);


							adaptor.addChild(root_0, FULL303_tree);
							}

							if ( state.backtracking==0 ) { join_clause_stack.peek().innerFlags.add( false );
							                      join_clause_stack.peek().innerFlags.add( false ); }
							if ( state.backtracking==0 ) {
							}

							}
							break;

					}

					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1380:66: ( OUTER )?
					int alt101=2;
					int LA101_0 = input.LA(1);
					if ( (LA101_0==OUTER) ) {
						alt101=1;
					}
					switch (alt101) {
						case 1 :
							// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1380:66: OUTER
							{
							_last = (CommonTree)input.LT(1);
							OUTER304=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_join_sub_clause4289); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							OUTER304_tree = (CommonTree)adaptor.dupNode(OUTER304);


							adaptor.addChild(root_0, OUTER304_tree);
							}

							if ( state.backtracking==0 ) {
							}

							}
							break;

					}

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_join_item_in_join_sub_clause4292);
					join_item305=join_item();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, join_item305.getTree());

					if ( state.backtracking==0 ) {
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1383:4: ( join_item )+
					{
					root_0 = (CommonTree)adaptor.nil();


					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1383:4: ( join_item )+
					int cnt102=0;
					loop102:
					while (true) {
						int alt102=2;
						int LA102_0 = input.LA(1);
						if ( (LA102_0==JOIN_ITEM) ) {
							alt102=1;
						}

						switch (alt102) {
						case 1 :
							// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1383:4: join_item
							{
							_last = (CommonTree)input.LT(1);
							pushFollow(FOLLOW_join_item_in_join_sub_clause4302);
							join_item306=join_item();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) 
							adaptor.addChild(root_0, join_item306.getTree());

							if ( state.backtracking==0 ) {
							}

							}
							break;

						default :
							if ( cnt102 >= 1 ) break loop102;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(102, input);
							throw eee;
						}
						cnt102++;
					}

					if ( state.backtracking==0 ) {
					}

					}
					break;

			}
			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class join_item_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "join_item"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1386:1: join_item : ^( JOIN_ITEM rel join_group_by_clause ) ;
	public final LogicalPlanGenerator.join_item_return join_item() throws RecognitionException {
		LogicalPlanGenerator.join_item_return retval = new LogicalPlanGenerator.join_item_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree JOIN_ITEM307=null;
		TreeRuleReturnScope rel308 =null;
		TreeRuleReturnScope join_group_by_clause309 =null;

		CommonTree JOIN_ITEM307_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1387:2: ( ^( JOIN_ITEM rel join_group_by_clause ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1387:4: ^( JOIN_ITEM rel join_group_by_clause )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			JOIN_ITEM307=(CommonTree)match(input,JOIN_ITEM,FOLLOW_JOIN_ITEM_in_join_item4315); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			JOIN_ITEM307_tree = (CommonTree)adaptor.dupNode(JOIN_ITEM307);


			root_1 = (CommonTree)adaptor.becomeRoot(JOIN_ITEM307_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_rel_in_join_item4317);
			rel308=rel();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, rel308.getTree());

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_join_group_by_clause_in_join_item4319);
			join_group_by_clause309=join_group_by_clause();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, join_group_by_clause309.getTree());

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			       join_clause_stack.peek().inputAliases.add( statement_stack.peek().inputAlias );
			       join_clause_stack.peek().joinPlans.put( join_clause_stack.peek().inputIndex, (join_group_by_clause309!=null?((LogicalPlanGenerator.join_group_by_clause_return)join_group_by_clause309).plans:null) );
			       join_clause_stack.peek().inputIndex++;
			       statement_stack.peek().inputIndex++;
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class join_group_by_clause_return extends TreeRuleReturnScope {
		public List<LogicalExpressionPlan> plans;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "join_group_by_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1396:1: join_group_by_clause returns [List<LogicalExpressionPlan> plans] : ^( BY ( join_group_by_expr )+ ) ;
	public final LogicalPlanGenerator.join_group_by_clause_return join_group_by_clause() throws RecognitionException {
		LogicalPlanGenerator.join_group_by_clause_return retval = new LogicalPlanGenerator.join_group_by_clause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree BY310=null;
		TreeRuleReturnScope join_group_by_expr311 =null;

		CommonTree BY310_tree=null;


		    retval.plans = new ArrayList<LogicalExpressionPlan>();

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1400:2: ( ^( BY ( join_group_by_expr )+ ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1400:4: ^( BY ( join_group_by_expr )+ )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			BY310=(CommonTree)match(input,BY,FOLLOW_BY_in_join_group_by_clause4346); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			BY310_tree = (CommonTree)adaptor.dupNode(BY310);


			root_1 = (CommonTree)adaptor.becomeRoot(BY310_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1400:10: ( join_group_by_expr )+
			int cnt104=0;
			loop104:
			while (true) {
				int alt104=2;
				int LA104_0 = input.LA(1);
				if ( (LA104_0==BIGDECIMALNUMBER||LA104_0==BIGINTEGERNUMBER||LA104_0==CUBE||LA104_0==DIV||LA104_0==DOLLARVAR||LA104_0==DOUBLENUMBER||LA104_0==FALSE||LA104_0==FLOATNUMBER||LA104_0==GROUP||LA104_0==IDENTIFIER||LA104_0==INTEGER||LA104_0==LONGINTEGER||LA104_0==MINUS||LA104_0==NULL||LA104_0==PERCENT||LA104_0==PLUS||LA104_0==QUOTEDSTRING||LA104_0==STAR||LA104_0==TRUE||(LA104_0 >= BAG_VAL && LA104_0 <= BIN_EXPR)||(LA104_0 >= CASE_COND && LA104_0 <= CASE_EXPR)||(LA104_0 >= CAST_EXPR && LA104_0 <= EXPR_IN_PAREN)||LA104_0==FUNC_EVAL||LA104_0==INVOKER_FUNC_EVAL||(LA104_0 >= MAP_VAL && LA104_0 <= NEG)||LA104_0==TUPLE_VAL) ) {
					alt104=1;
				}

				switch (alt104) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1400:12: join_group_by_expr
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_join_group_by_expr_in_join_group_by_clause4350);
					join_group_by_expr311=join_group_by_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, join_group_by_expr311.getTree());

					if ( state.backtracking==0 ) { retval.plans.add( (join_group_by_expr311!=null?((LogicalPlanGenerator.join_group_by_expr_return)join_group_by_expr311).plan:null) ); }
					if ( state.backtracking==0 ) {
					}

					}
					break;

				default :
					if ( cnt104 >= 1 ) break loop104;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(104, input);
					throw eee;
				}
				cnt104++;
			}

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class join_group_by_expr_return extends TreeRuleReturnScope {
		public LogicalExpressionPlan plan;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "join_group_by_expr"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1403:1: join_group_by_expr returns [LogicalExpressionPlan plan] : ( col_range[$plan] | expr[$plan] | STAR );
	public final LogicalPlanGenerator.join_group_by_expr_return join_group_by_expr() throws RecognitionException {
		LogicalPlanGenerator.join_group_by_expr_return retval = new LogicalPlanGenerator.join_group_by_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree STAR314=null;
		TreeRuleReturnScope col_range312 =null;
		TreeRuleReturnScope expr313 =null;

		CommonTree STAR314_tree=null;


		    retval.plan = new LogicalExpressionPlan();

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1407:2: ( col_range[$plan] | expr[$plan] | STAR )
			int alt105=3;
			switch ( input.LA(1) ) {
			case COL_RANGE:
				{
				alt105=1;
				}
				break;
			case BIGDECIMALNUMBER:
			case BIGINTEGERNUMBER:
			case CUBE:
			case DIV:
			case DOLLARVAR:
			case DOUBLENUMBER:
			case FALSE:
			case FLOATNUMBER:
			case GROUP:
			case IDENTIFIER:
			case INTEGER:
			case LONGINTEGER:
			case MINUS:
			case NULL:
			case PERCENT:
			case PLUS:
			case QUOTEDSTRING:
			case TRUE:
			case BAG_VAL:
			case BIN_EXPR:
			case CASE_COND:
			case CASE_EXPR:
			case CAST_EXPR:
			case EXPR_IN_PAREN:
			case FUNC_EVAL:
			case INVOKER_FUNC_EVAL:
			case MAP_VAL:
			case NEG:
			case TUPLE_VAL:
				{
				alt105=2;
				}
				break;
			case STAR:
				{
				int LA105_3 = input.LA(2);
				if ( (LA105_3==DOWN) ) {
					alt105=2;
				}
				else if ( (LA105_3==EOF||LA105_3==UP||LA105_3==BIGDECIMALNUMBER||LA105_3==BIGINTEGERNUMBER||LA105_3==CUBE||LA105_3==DIV||LA105_3==DOLLARVAR||LA105_3==DOUBLENUMBER||LA105_3==FALSE||LA105_3==FLOATNUMBER||LA105_3==GROUP||LA105_3==IDENTIFIER||LA105_3==INTEGER||LA105_3==LONGINTEGER||LA105_3==MINUS||LA105_3==NULL||LA105_3==PERCENT||LA105_3==PLUS||LA105_3==QUOTEDSTRING||LA105_3==STAR||LA105_3==TRUE||(LA105_3 >= BAG_VAL && LA105_3 <= BIN_EXPR)||(LA105_3 >= CASE_COND && LA105_3 <= CASE_EXPR)||(LA105_3 >= CAST_EXPR && LA105_3 <= EXPR_IN_PAREN)||LA105_3==FUNC_EVAL||LA105_3==INVOKER_FUNC_EVAL||(LA105_3 >= MAP_VAL && LA105_3 <= NEG)||LA105_3==TUPLE_VAL) ) {
					alt105=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 105, 3, input);
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
					new NoViableAltException("", 105, 0, input);
				throw nvae;
			}
			switch (alt105) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1407:4: col_range[$plan]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_col_range_in_join_group_by_expr4375);
					col_range312=col_range(retval.plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, col_range312.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1408:4: expr[$plan]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_join_group_by_expr4381);
					expr313=expr(retval.plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, expr313.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1409:4: STAR
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					STAR314=(CommonTree)match(input,STAR,FOLLOW_STAR_in_join_group_by_expr4387); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STAR314_tree = (CommonTree)adaptor.dupNode(STAR314);


					adaptor.addChild(root_0, STAR314_tree);
					}

					if ( state.backtracking==0 ) {
					       builder.buildProjectExpr( new SourceLocation( (LatinParserNode)STAR314 ), retval.plan, GScope_stack.peek().currentOp,
					           statement_stack.peek().inputIndex, null, -1 );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;

			}
			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "join_group_by_expr"


	public static class union_clause_return extends TreeRuleReturnScope {
		public String alias;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "union_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1416:1: union_clause returns [String alias] : ^( UNION ( ONSCHEMA )? rel_list ) ;
	public final LogicalPlanGenerator.union_clause_return union_clause() throws RecognitionException {
		LogicalPlanGenerator.union_clause_return retval = new LogicalPlanGenerator.union_clause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree UNION315=null;
		CommonTree ONSCHEMA316=null;
		TreeRuleReturnScope rel_list317 =null;

		CommonTree UNION315_tree=null;
		CommonTree ONSCHEMA316_tree=null;


		    boolean onSchema = false;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1420:2: ( ^( UNION ( ONSCHEMA )? rel_list ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1420:4: ^( UNION ( ONSCHEMA )? rel_list )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			UNION315=(CommonTree)match(input,UNION,FOLLOW_UNION_in_union_clause4412); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			UNION315_tree = (CommonTree)adaptor.dupNode(UNION315);


			root_1 = (CommonTree)adaptor.becomeRoot(UNION315_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1420:13: ( ONSCHEMA )?
			int alt106=2;
			int LA106_0 = input.LA(1);
			if ( (LA106_0==ONSCHEMA) ) {
				alt106=1;
			}
			switch (alt106) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1420:15: ONSCHEMA
					{
					_last = (CommonTree)input.LT(1);
					ONSCHEMA316=(CommonTree)match(input,ONSCHEMA,FOLLOW_ONSCHEMA_in_union_clause4416); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ONSCHEMA316_tree = (CommonTree)adaptor.dupNode(ONSCHEMA316);


					adaptor.addChild(root_1, ONSCHEMA316_tree);
					}

					if ( state.backtracking==0 ) { onSchema = true; }
					if ( state.backtracking==0 ) {
					}

					}
					break;

			}

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_rel_list_in_union_clause4423);
			rel_list317=rel_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, rel_list317.getTree());

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			      retval.alias = builder.buildUnionOp( new SourceLocation( (LatinParserNode)UNION315 ), statement_stack.peek().alias,
			          (rel_list317!=null?((LogicalPlanGenerator.rel_list_return)rel_list317).aliasList:null), onSchema );
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	protected static class foreach_clause_scope {
		LOForEach foreachOp;
	}
	protected Stack<foreach_clause_scope> foreach_clause_stack = new Stack<foreach_clause_scope>();

	public static class foreach_clause_return extends TreeRuleReturnScope {
		public String alias;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "foreach_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1427:1: foreach_clause returns [String alias] : ^( FOREACH rel foreach_plan ) ;
	public final LogicalPlanGenerator.foreach_clause_return foreach_clause() throws RecognitionException {
		GScope_stack.push(new GScope_scope());
		foreach_clause_stack.push(new foreach_clause_scope());
		LogicalPlanGenerator.foreach_clause_return retval = new LogicalPlanGenerator.foreach_clause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree FOREACH318=null;
		TreeRuleReturnScope rel319 =null;
		TreeRuleReturnScope foreach_plan320 =null;

		CommonTree FOREACH318_tree=null;


		     foreach_clause_stack.peek().foreachOp = builder.createForeachOp();
		     GScope_stack.peek().currentOp = foreach_clause_stack.peek().foreachOp;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1436:2: ( ^( FOREACH rel foreach_plan ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1436:4: ^( FOREACH rel foreach_plan )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			FOREACH318=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_foreach_clause4459); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			FOREACH318_tree = (CommonTree)adaptor.dupNode(FOREACH318);


			root_1 = (CommonTree)adaptor.becomeRoot(FOREACH318_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_rel_in_foreach_clause4461);
			rel319=rel();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, rel319.getTree());

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_foreach_plan_in_foreach_clause4463);
			foreach_plan320=foreach_plan();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, foreach_plan320.getTree());

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			       SourceLocation loc = new SourceLocation( (LatinParserNode)FOREACH318 );
			       retval.alias = builder.buildForeachOp( loc, foreach_clause_stack.peek().foreachOp, statement_stack.peek().alias,
			          statement_stack.peek().inputAlias, (foreach_plan320!=null?((LogicalPlanGenerator.foreach_plan_return)foreach_plan320).plan:null) );
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			}

		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
			GScope_stack.pop();
			foreach_clause_stack.pop();
		}
		return retval;
	}
	// $ANTLR end "foreach_clause"


	protected static class foreach_plan_scope {
		LogicalPlan innerPlan;
		Map<String, LogicalExpressionPlan> exprPlans;
		Map<String, Operator> operators;
	}
	protected Stack<foreach_plan_scope> foreach_plan_stack = new Stack<foreach_plan_scope>();

	public static class foreach_plan_return extends TreeRuleReturnScope {
		public LogicalPlan plan;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "foreach_plan"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1444:1: foreach_plan returns [LogicalPlan plan] : ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) );
	public final LogicalPlanGenerator.foreach_plan_return foreach_plan() throws RecognitionException {
		foreach_plan_stack.push(new foreach_plan_scope());
		LogicalPlanGenerator.foreach_plan_return retval = new LogicalPlanGenerator.foreach_plan_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree FOREACH_PLAN_SIMPLE321=null;
		CommonTree FOREACH_PLAN_COMPLEX323=null;
		TreeRuleReturnScope generate_clause322 =null;
		TreeRuleReturnScope nested_blk324 =null;

		CommonTree FOREACH_PLAN_SIMPLE321_tree=null;
		CommonTree FOREACH_PLAN_COMPLEX323_tree=null;


		    inForeachPlan = true;
		    foreach_plan_stack.peek().innerPlan = new LogicalPlan();
		    foreach_plan_stack.peek().exprPlans = new HashMap<String, LogicalExpressionPlan>();
		    foreach_plan_stack.peek().operators = new HashMap<String, Operator>();

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1460:2: ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) )
			int alt107=2;
			int LA107_0 = input.LA(1);
			if ( (LA107_0==FOREACH_PLAN_SIMPLE) ) {
				alt107=1;
			}
			else if ( (LA107_0==FOREACH_PLAN_COMPLEX) ) {
				alt107=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 107, 0, input);
				throw nvae;
			}

			switch (alt107) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1460:4: ^( FOREACH_PLAN_SIMPLE generate_clause )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					FOREACH_PLAN_SIMPLE321=(CommonTree)match(input,FOREACH_PLAN_SIMPLE,FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan4499); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FOREACH_PLAN_SIMPLE321_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_SIMPLE321);


					root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_SIMPLE321_tree, root_1);
					}

					match(input, Token.DOWN, null); if (state.failed) return retval;
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_generate_clause_in_foreach_plan4501);
					generate_clause322=generate_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, generate_clause322.getTree());

					match(input, Token.UP, null); if (state.failed) return retval;
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1461:4: ^( FOREACH_PLAN_COMPLEX nested_blk )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					FOREACH_PLAN_COMPLEX323=(CommonTree)match(input,FOREACH_PLAN_COMPLEX,FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan4510); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FOREACH_PLAN_COMPLEX323_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_COMPLEX323);


					root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_COMPLEX323_tree, root_1);
					}

					match(input, Token.DOWN, null); if (state.failed) return retval;
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_nested_blk_in_foreach_plan4512);
					nested_blk324=nested_blk();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, nested_blk324.getTree());

					match(input, Token.UP, null); if (state.failed) return retval;
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					if ( state.backtracking==0 ) {
					}

					}
					break;

			}
			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			}

			if ( state.backtracking==0 ) {
			    retval.plan = foreach_plan_stack.peek().innerPlan;
			    inForeachPlan = false;
			}
		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
			foreach_plan_stack.pop();
		}
		return retval;
	}
	// $ANTLR end "foreach_plan"


	public static class nested_blk_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "nested_blk"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1464:1: nested_blk : ( nested_command )* generate_clause ;
	public final LogicalPlanGenerator.nested_blk_return nested_blk() throws RecognitionException {
		LogicalPlanGenerator.nested_blk_return retval = new LogicalPlanGenerator.nested_blk_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope nested_command325 =null;
		TreeRuleReturnScope generate_clause326 =null;


		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1464:12: ( ( nested_command )* generate_clause )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1464:14: ( nested_command )* generate_clause
			{
			root_0 = (CommonTree)adaptor.nil();


			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1464:14: ( nested_command )*
			loop108:
			while (true) {
				int alt108=2;
				int LA108_0 = input.LA(1);
				if ( ((LA108_0 >= NESTED_CMD && LA108_0 <= NESTED_CMD_ASSI)) ) {
					alt108=1;
				}

				switch (alt108) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1464:14: nested_command
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_nested_command_in_nested_blk4523);
					nested_command325=nested_command();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, nested_command325.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;

				default :
					break loop108;
				}
			}

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_generate_clause_in_nested_blk4526);
			generate_clause326=generate_clause();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_0, generate_clause326.getTree());

			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class nested_command_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "nested_command"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1467:1: nested_command : ( ^( NESTED_CMD IDENTIFIER nested_op[$IDENTIFIER.text] ) | ^( NESTED_CMD_ASSI IDENTIFIER expr[exprPlan] ) );
	public final LogicalPlanGenerator.nested_command_return nested_command() throws RecognitionException {
		LogicalPlanGenerator.nested_command_return retval = new LogicalPlanGenerator.nested_command_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree NESTED_CMD327=null;
		CommonTree IDENTIFIER328=null;
		CommonTree NESTED_CMD_ASSI330=null;
		CommonTree IDENTIFIER331=null;
		TreeRuleReturnScope nested_op329 =null;
		TreeRuleReturnScope expr332 =null;

		CommonTree NESTED_CMD327_tree=null;
		CommonTree IDENTIFIER328_tree=null;
		CommonTree NESTED_CMD_ASSI330_tree=null;
		CommonTree IDENTIFIER331_tree=null;


		    LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();
		    inNestedCommand = true;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1475:2: ( ^( NESTED_CMD IDENTIFIER nested_op[$IDENTIFIER.text] ) | ^( NESTED_CMD_ASSI IDENTIFIER expr[exprPlan] ) )
			int alt109=2;
			int LA109_0 = input.LA(1);
			if ( (LA109_0==NESTED_CMD) ) {
				alt109=1;
			}
			else if ( (LA109_0==NESTED_CMD_ASSI) ) {
				alt109=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 109, 0, input);
				throw nvae;
			}

			switch (alt109) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1475:4: ^( NESTED_CMD IDENTIFIER nested_op[$IDENTIFIER.text] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					NESTED_CMD327=(CommonTree)match(input,NESTED_CMD,FOLLOW_NESTED_CMD_in_nested_command4548); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NESTED_CMD327_tree = (CommonTree)adaptor.dupNode(NESTED_CMD327);


					root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD327_tree, root_1);
					}

					match(input, Token.DOWN, null); if (state.failed) return retval;
					_last = (CommonTree)input.LT(1);
					IDENTIFIER328=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command4550); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IDENTIFIER328_tree = (CommonTree)adaptor.dupNode(IDENTIFIER328);


					adaptor.addChild(root_1, IDENTIFIER328_tree);
					}

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_nested_op_in_nested_command4552);
					nested_op329=nested_op((IDENTIFIER328!=null?IDENTIFIER328.getText():null));
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, nested_op329.getTree());

					match(input, Token.UP, null); if (state.failed) return retval;
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					if ( state.backtracking==0 ) {
					       foreach_plan_stack.peek().operators.put( (IDENTIFIER328!=null?IDENTIFIER328.getText():null), (nested_op329!=null?((LogicalPlanGenerator.nested_op_return)nested_op329).op:null) );
					       foreach_plan_stack.peek().exprPlans.remove( (IDENTIFIER328!=null?IDENTIFIER328.getText():null) );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1481:4: ^( NESTED_CMD_ASSI IDENTIFIER expr[exprPlan] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					NESTED_CMD_ASSI330=(CommonTree)match(input,NESTED_CMD_ASSI,FOLLOW_NESTED_CMD_ASSI_in_nested_command4570); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NESTED_CMD_ASSI330_tree = (CommonTree)adaptor.dupNode(NESTED_CMD_ASSI330);


					root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD_ASSI330_tree, root_1);
					}

					match(input, Token.DOWN, null); if (state.failed) return retval;
					_last = (CommonTree)input.LT(1);
					IDENTIFIER331=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command4572); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IDENTIFIER331_tree = (CommonTree)adaptor.dupNode(IDENTIFIER331);


					adaptor.addChild(root_1, IDENTIFIER331_tree);
					}

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_nested_command4574);
					expr332=expr(exprPlan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, expr332.getTree());

					match(input, Token.UP, null); if (state.failed) return retval;
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					if ( state.backtracking==0 ) {
					        foreach_plan_stack.peek().exprPlans.put( (IDENTIFIER331!=null?IDENTIFIER331.getText():null), exprPlan );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;

			}
			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			}

			if ( state.backtracking==0 ) {
				inNestedCommand = false;
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


	public static class nested_op_return extends TreeRuleReturnScope {
		public Operator op;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "nested_op"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1487:1: nested_op[String alias] returns [Operator op] : ( nested_proj[$alias] | nested_filter[$alias] | nested_sort[$alias] | nested_distinct[$alias] | nested_limit[$alias] | nested_cross[$alias] | nested_foreach[$alias] );
	public final LogicalPlanGenerator.nested_op_return nested_op(String alias) throws RecognitionException {
		LogicalPlanGenerator.nested_op_return retval = new LogicalPlanGenerator.nested_op_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope nested_proj333 =null;
		TreeRuleReturnScope nested_filter334 =null;
		TreeRuleReturnScope nested_sort335 =null;
		TreeRuleReturnScope nested_distinct336 =null;
		TreeRuleReturnScope nested_limit337 =null;
		TreeRuleReturnScope nested_cross338 =null;
		TreeRuleReturnScope nested_foreach339 =null;


		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1488:2: ( nested_proj[$alias] | nested_filter[$alias] | nested_sort[$alias] | nested_distinct[$alias] | nested_limit[$alias] | nested_cross[$alias] | nested_foreach[$alias] )
			int alt110=7;
			switch ( input.LA(1) ) {
			case NESTED_PROJ:
				{
				alt110=1;
				}
				break;
			case FILTER:
				{
				alt110=2;
				}
				break;
			case ORDER:
				{
				alt110=3;
				}
				break;
			case DISTINCT:
				{
				alt110=4;
				}
				break;
			case LIMIT:
				{
				alt110=5;
				}
				break;
			case CROSS:
				{
				alt110=6;
				}
				break;
			case FOREACH:
				{
				alt110=7;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 110, 0, input);
				throw nvae;
			}
			switch (alt110) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1488:4: nested_proj[$alias]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_nested_proj_in_nested_op4596);
					nested_proj333=nested_proj(alias);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, nested_proj333.getTree());

					if ( state.backtracking==0 ) { retval.op = (nested_proj333!=null?((LogicalPlanGenerator.nested_proj_return)nested_proj333).op:null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1489:4: nested_filter[$alias]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_nested_filter_in_nested_op4604);
					nested_filter334=nested_filter(alias);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, nested_filter334.getTree());

					if ( state.backtracking==0 ) { retval.op = (nested_filter334!=null?((LogicalPlanGenerator.nested_filter_return)nested_filter334).op:null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1490:4: nested_sort[$alias]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_nested_sort_in_nested_op4612);
					nested_sort335=nested_sort(alias);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, nested_sort335.getTree());

					if ( state.backtracking==0 ) { retval.op = (nested_sort335!=null?((LogicalPlanGenerator.nested_sort_return)nested_sort335).op:null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 4 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1491:4: nested_distinct[$alias]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_nested_distinct_in_nested_op4621);
					nested_distinct336=nested_distinct(alias);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, nested_distinct336.getTree());

					if ( state.backtracking==0 ) { retval.op = (nested_distinct336!=null?((LogicalPlanGenerator.nested_distinct_return)nested_distinct336).op:null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 5 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1492:4: nested_limit[$alias]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_nested_limit_in_nested_op4629);
					nested_limit337=nested_limit(alias);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, nested_limit337.getTree());

					if ( state.backtracking==0 ) { retval.op = (nested_limit337!=null?((LogicalPlanGenerator.nested_limit_return)nested_limit337).op:null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 6 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1493:4: nested_cross[$alias]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_nested_cross_in_nested_op4637);
					nested_cross338=nested_cross(alias);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, nested_cross338.getTree());

					if ( state.backtracking==0 ) { retval.op = (nested_cross338!=null?((LogicalPlanGenerator.nested_cross_return)nested_cross338).op:null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 7 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1494:4: nested_foreach[$alias]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_nested_foreach_in_nested_op4645);
					nested_foreach339=nested_foreach(alias);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, nested_foreach339.getTree());

					if ( state.backtracking==0 ) { retval.op = (nested_foreach339!=null?((LogicalPlanGenerator.nested_foreach_return)nested_foreach339).op:null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;

			}
			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class nested_proj_return extends TreeRuleReturnScope {
		public Operator op;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "nested_proj"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1497:1: nested_proj[String alias] returns [Operator op] : ^( NESTED_PROJ cr0= col_ref[plan] (cr= col_ref[new LogicalExpressionPlan()] )+ ) ;
	public final LogicalPlanGenerator.nested_proj_return nested_proj(String alias) throws RecognitionException {
		LogicalPlanGenerator.nested_proj_return retval = new LogicalPlanGenerator.nested_proj_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree NESTED_PROJ340=null;
		TreeRuleReturnScope cr0 =null;
		TreeRuleReturnScope cr =null;

		CommonTree NESTED_PROJ340_tree=null;


		    LogicalExpressionPlan plan = new LogicalExpressionPlan();
		    List<LogicalExpressionPlan> plans = new ArrayList<LogicalExpressionPlan>();

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1502:2: ( ^( NESTED_PROJ cr0= col_ref[plan] (cr= col_ref[new LogicalExpressionPlan()] )+ ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1502:4: ^( NESTED_PROJ cr0= col_ref[plan] (cr= col_ref[new LogicalExpressionPlan()] )+ )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			NESTED_PROJ340=(CommonTree)match(input,NESTED_PROJ,FOLLOW_NESTED_PROJ_in_nested_proj4669); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			NESTED_PROJ340_tree = (CommonTree)adaptor.dupNode(NESTED_PROJ340);


			root_1 = (CommonTree)adaptor.becomeRoot(NESTED_PROJ340_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_col_ref_in_nested_proj4681);
			cr0=col_ref(plan);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, cr0.getTree());

			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1504:7: (cr= col_ref[new LogicalExpressionPlan()] )+
			int cnt111=0;
			loop111:
			while (true) {
				int alt111=2;
				int LA111_0 = input.LA(1);
				if ( (LA111_0==CUBE||LA111_0==DOLLARVAR||LA111_0==GROUP||LA111_0==IDENTIFIER) ) {
					alt111=1;
				}

				switch (alt111) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1504:9: cr= col_ref[new LogicalExpressionPlan()]
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_col_ref_in_nested_proj4696);
					cr=col_ref(new LogicalExpressionPlan());
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, cr.getTree());

					if ( state.backtracking==0 ) {
					            plans.add( (LogicalExpressionPlan)( (cr!=null?((LogicalPlanGenerator.col_ref_return)cr).expr:null).getPlan() ) );
					        }
					if ( state.backtracking==0 ) {
					}

					}
					break;

				default :
					if ( cnt111 >= 1 ) break loop111;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(111, input);
					throw eee;
				}
				cnt111++;
			}

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			       SourceLocation loc = new SourceLocation( (LatinParserNode)(cr0!=null?((CommonTree)cr0.start):null) );
			       retval.op = builder.buildNestedProjectOp( loc, foreach_plan_stack.peek().innerPlan, foreach_clause_stack.peek().foreachOp,
			           foreach_plan_stack.peek().operators, alias, (ProjectExpression)(cr0!=null?((LogicalPlanGenerator.col_ref_return)cr0).expr:null), plans );
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class nested_filter_return extends TreeRuleReturnScope {
		public Operator op;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "nested_filter"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1516:1: nested_filter[String alias] returns [Operator op] : ^( FILTER nested_op_input cond[plan] ) ;
	public final LogicalPlanGenerator.nested_filter_return nested_filter(String alias) throws RecognitionException {
		GScope_stack.push(new GScope_scope());

		LogicalPlanGenerator.nested_filter_return retval = new LogicalPlanGenerator.nested_filter_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree FILTER341=null;
		TreeRuleReturnScope nested_op_input342 =null;
		TreeRuleReturnScope cond343 =null;

		CommonTree FILTER341_tree=null;


		    LogicalExpressionPlan plan = new LogicalExpressionPlan();
		    Operator inputOp = null;
		    GScope_stack.peek().currentOp = builder.createNestedFilterOp( foreach_plan_stack.peek().innerPlan );

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1523:2: ( ^( FILTER nested_op_input cond[plan] ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1523:4: ^( FILTER nested_op_input cond[plan] )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			FILTER341=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_nested_filter4749); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			FILTER341_tree = (CommonTree)adaptor.dupNode(FILTER341);


			root_1 = (CommonTree)adaptor.becomeRoot(FILTER341_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_nested_op_input_in_nested_filter4751);
			nested_op_input342=nested_op_input();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, nested_op_input342.getTree());

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_cond_in_nested_filter4753);
			cond343=cond(plan);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, cond343.getTree());

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			       SourceLocation loc = new SourceLocation( (LatinParserNode)FILTER341 );
			       retval.op = builder.buildNestedFilterOp( loc, (LOFilter)GScope_stack.peek().currentOp, foreach_plan_stack.peek().innerPlan, alias,
			           (nested_op_input342!=null?((LogicalPlanGenerator.nested_op_input_return)nested_op_input342).op:null), plan );
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			}

		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
			GScope_stack.pop();

		}
		return retval;
	}
	// $ANTLR end "nested_filter"


	public static class nested_sort_return extends TreeRuleReturnScope {
		public Operator op;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "nested_sort"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1531:1: nested_sort[String alias] returns [Operator op] : ^( ORDER nested_op_input order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? ) ;
	public final LogicalPlanGenerator.nested_sort_return nested_sort(String alias) throws RecognitionException {
		GScope_stack.push(new GScope_scope());

		LogicalPlanGenerator.nested_sort_return retval = new LogicalPlanGenerator.nested_sort_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree ORDER344=null;
		TreeRuleReturnScope nested_op_input345 =null;
		TreeRuleReturnScope order_by_clause346 =null;
		TreeRuleReturnScope func_clause347 =null;

		CommonTree ORDER344_tree=null;


		    Operator inputOp = null;
		    GScope_stack.peek().currentOp = builder.createNestedSortOp( foreach_plan_stack.peek().innerPlan );

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1537:2: ( ^( ORDER nested_op_input order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1537:4: ^( ORDER nested_op_input order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			ORDER344=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_nested_sort4787); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ORDER344_tree = (CommonTree)adaptor.dupNode(ORDER344);


			root_1 = (CommonTree)adaptor.becomeRoot(ORDER344_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_nested_op_input_in_nested_sort4789);
			nested_op_input345=nested_op_input();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, nested_op_input345.getTree());

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_order_by_clause_in_nested_sort4791);
			order_by_clause346=order_by_clause();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, order_by_clause346.getTree());

			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1537:45: ( func_clause[FunctionType.COMPARISONFUNC] )?
			int alt112=2;
			int LA112_0 = input.LA(1);
			if ( (LA112_0==FUNC||LA112_0==FUNC_REF) ) {
				alt112=1;
			}
			switch (alt112) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1537:45: func_clause[FunctionType.COMPARISONFUNC]
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_func_clause_in_nested_sort4793);
					func_clause347=func_clause(FunctionType.COMPARISONFUNC);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, func_clause347.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;

			}

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			       SourceLocation loc = new SourceLocation( (LatinParserNode)ORDER344 );
			       retval.op = builder.buildNestedSortOp( loc, (LOSort)GScope_stack.peek().currentOp, foreach_plan_stack.peek().innerPlan, alias,
			           (nested_op_input345!=null?((LogicalPlanGenerator.nested_op_input_return)nested_op_input345).op:null),
			           (order_by_clause346!=null?((LogicalPlanGenerator.order_by_clause_return)order_by_clause346).plans:null), (order_by_clause346!=null?((LogicalPlanGenerator.order_by_clause_return)order_by_clause346).ascFlags:null), (func_clause347!=null?((LogicalPlanGenerator.func_clause_return)func_clause347).funcSpec:null) );
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			}

		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
			GScope_stack.pop();

		}
		return retval;
	}
	// $ANTLR end "nested_sort"


	public static class nested_distinct_return extends TreeRuleReturnScope {
		public Operator op;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "nested_distinct"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1546:1: nested_distinct[String alias] returns [Operator op] : ^( DISTINCT nested_op_input ) ;
	public final LogicalPlanGenerator.nested_distinct_return nested_distinct(String alias) throws RecognitionException {
		LogicalPlanGenerator.nested_distinct_return retval = new LogicalPlanGenerator.nested_distinct_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree DISTINCT348=null;
		TreeRuleReturnScope nested_op_input349 =null;

		CommonTree DISTINCT348_tree=null;


		    Operator inputOp = null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1550:2: ( ^( DISTINCT nested_op_input ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1550:4: ^( DISTINCT nested_op_input )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			DISTINCT348=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_nested_distinct4823); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			DISTINCT348_tree = (CommonTree)adaptor.dupNode(DISTINCT348);


			root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT348_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_nested_op_input_in_nested_distinct4825);
			nested_op_input349=nested_op_input();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, nested_op_input349.getTree());

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			       SourceLocation loc = new SourceLocation( (LatinParserNode)DISTINCT348 );
			       retval.op = builder.buildNestedDistinctOp( loc, foreach_plan_stack.peek().innerPlan, alias, (nested_op_input349!=null?((LogicalPlanGenerator.nested_op_input_return)nested_op_input349).op:null) );
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class nested_limit_return extends TreeRuleReturnScope {
		public Operator op;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "nested_limit"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1557:1: nested_limit[String alias] returns [Operator op] : ^( LIMIT nested_op_input ( INTEGER | expr[exprPlan] ) ) ;
	public final LogicalPlanGenerator.nested_limit_return nested_limit(String alias) throws RecognitionException {
		GScope_stack.push(new GScope_scope());

		LogicalPlanGenerator.nested_limit_return retval = new LogicalPlanGenerator.nested_limit_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree LIMIT350=null;
		CommonTree INTEGER352=null;
		TreeRuleReturnScope nested_op_input351 =null;
		TreeRuleReturnScope expr353 =null;

		CommonTree LIMIT350_tree=null;
		CommonTree INTEGER352_tree=null;


		    Operator inputOp = null;
		    LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();
		    GScope_stack.peek().currentOp = builder.createNestedLimitOp( foreach_plan_stack.peek().innerPlan );

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1564:2: ( ^( LIMIT nested_op_input ( INTEGER | expr[exprPlan] ) ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1564:4: ^( LIMIT nested_op_input ( INTEGER | expr[exprPlan] ) )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			LIMIT350=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_nested_limit4858); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LIMIT350_tree = (CommonTree)adaptor.dupNode(LIMIT350);


			root_1 = (CommonTree)adaptor.becomeRoot(LIMIT350_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_nested_op_input_in_nested_limit4860);
			nested_op_input351=nested_op_input();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, nested_op_input351.getTree());

			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1564:29: ( INTEGER | expr[exprPlan] )
			int alt113=2;
			int LA113_0 = input.LA(1);
			if ( (LA113_0==INTEGER) ) {
				int LA113_1 = input.LA(2);
				if ( (synpred196_LogicalPlanGenerator()) ) {
					alt113=1;
				}
				else if ( (true) ) {
					alt113=2;
				}

			}
			else if ( (LA113_0==BIGDECIMALNUMBER||LA113_0==BIGINTEGERNUMBER||LA113_0==CUBE||LA113_0==DIV||LA113_0==DOLLARVAR||LA113_0==DOUBLENUMBER||LA113_0==FALSE||LA113_0==FLOATNUMBER||LA113_0==GROUP||LA113_0==IDENTIFIER||LA113_0==LONGINTEGER||LA113_0==MINUS||LA113_0==NULL||LA113_0==PERCENT||LA113_0==PLUS||LA113_0==QUOTEDSTRING||LA113_0==STAR||LA113_0==TRUE||(LA113_0 >= BAG_VAL && LA113_0 <= BIN_EXPR)||(LA113_0 >= CASE_COND && LA113_0 <= CASE_EXPR)||LA113_0==CAST_EXPR||LA113_0==EXPR_IN_PAREN||LA113_0==FUNC_EVAL||LA113_0==INVOKER_FUNC_EVAL||(LA113_0 >= MAP_VAL && LA113_0 <= NEG)||LA113_0==TUPLE_VAL) ) {
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
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1564:31: INTEGER
					{
					_last = (CommonTree)input.LT(1);
					INTEGER352=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_nested_limit4864); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INTEGER352_tree = (CommonTree)adaptor.dupNode(INTEGER352);


					adaptor.addChild(root_1, INTEGER352_tree);
					}

					if ( state.backtracking==0 ) {
					       SourceLocation loc = new SourceLocation( (LatinParserNode)LIMIT350 );
					       retval.op = builder.buildNestedLimitOp( loc, foreach_plan_stack.peek().innerPlan, alias, (nested_op_input351!=null?((LogicalPlanGenerator.nested_op_input_return)nested_op_input351).op:null),
					           Integer.valueOf( (INTEGER352!=null?INTEGER352.getText():null) ) );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1570:4: expr[exprPlan]
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_nested_limit4874);
					expr353=expr(exprPlan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, expr353.getTree());

					if ( state.backtracking==0 ) {
					       SourceLocation loc = new SourceLocation( (LatinParserNode)LIMIT350 );
					       retval.op = builder.buildNestedLimitOp( loc, (LOLimit)GScope_stack.peek().currentOp, foreach_plan_stack.peek().innerPlan, alias,
					           (nested_op_input351!=null?((LogicalPlanGenerator.nested_op_input_return)nested_op_input351).op:null), exprPlan);
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;

			}

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			}

		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
			GScope_stack.pop();

		}
		return retval;
	}
	// $ANTLR end "nested_limit"


	public static class nested_cross_return extends TreeRuleReturnScope {
		public Operator op;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "nested_cross"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1579:1: nested_cross[String alias] returns [Operator op] : ^( CROSS nested_op_input_list ) ;
	public final LogicalPlanGenerator.nested_cross_return nested_cross(String alias) throws RecognitionException {
		LogicalPlanGenerator.nested_cross_return retval = new LogicalPlanGenerator.nested_cross_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree CROSS354=null;
		TreeRuleReturnScope nested_op_input_list355 =null;

		CommonTree CROSS354_tree=null;


		    Operator inputOp = null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1583:2: ( ^( CROSS nested_op_input_list ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1583:4: ^( CROSS nested_op_input_list )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			CROSS354=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_nested_cross4907); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			CROSS354_tree = (CommonTree)adaptor.dupNode(CROSS354);


			root_1 = (CommonTree)adaptor.becomeRoot(CROSS354_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_nested_op_input_list_in_nested_cross4909);
			nested_op_input_list355=nested_op_input_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, nested_op_input_list355.getTree());

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			       SourceLocation loc = new SourceLocation( (LatinParserNode)CROSS354 );
			       retval.op = builder.buildNestedCrossOp( loc, foreach_plan_stack.peek().innerPlan, alias, (nested_op_input_list355!=null?((LogicalPlanGenerator.nested_op_input_list_return)nested_op_input_list355).opList:null) );
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	protected static class nested_foreach_scope {
		LogicalPlan innerPlan;
		LOForEach foreachOp;
	}
	protected Stack<nested_foreach_scope> nested_foreach_stack = new Stack<nested_foreach_scope>();

	public static class nested_foreach_return extends TreeRuleReturnScope {
		public Operator op;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "nested_foreach"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1590:1: nested_foreach[String alias] returns [Operator op] : ^( FOREACH nested_op_input generate_clause ) ;
	public final LogicalPlanGenerator.nested_foreach_return nested_foreach(String alias) throws RecognitionException {
		nested_foreach_stack.push(new nested_foreach_scope());
		LogicalPlanGenerator.nested_foreach_return retval = new LogicalPlanGenerator.nested_foreach_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree FOREACH356=null;
		TreeRuleReturnScope nested_op_input357 =null;
		TreeRuleReturnScope generate_clause358 =null;

		CommonTree FOREACH356_tree=null;


			Operator inputOp = null;
			nested_foreach_stack.peek().innerPlan = new LogicalPlan();
			nested_foreach_stack.peek().foreachOp = builder.createNestedForeachOp( foreach_plan_stack.peek().innerPlan );

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1600:2: ( ^( FOREACH nested_op_input generate_clause ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1600:4: ^( FOREACH nested_op_input generate_clause )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			FOREACH356=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_nested_foreach4941); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			FOREACH356_tree = (CommonTree)adaptor.dupNode(FOREACH356);


			root_1 = (CommonTree)adaptor.becomeRoot(FOREACH356_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_nested_op_input_in_nested_foreach4943);
			nested_op_input357=nested_op_input();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, nested_op_input357.getTree());

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_generate_clause_in_nested_foreach4945);
			generate_clause358=generate_clause();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, generate_clause358.getTree());

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			   		SourceLocation loc = new SourceLocation( (LatinParserNode)FOREACH356 );
			   		retval.op = builder.buildNestedForeachOp( loc, (LOForEach)nested_foreach_stack.peek().foreachOp, foreach_plan_stack.peek().innerPlan,
			   							alias, (nested_op_input357!=null?((LogicalPlanGenerator.nested_op_input_return)nested_op_input357).op:null), nested_foreach_stack.peek().innerPlan);
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			}

		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
			nested_foreach_stack.pop();
		}
		return retval;
	}
	// $ANTLR end "nested_foreach"


	public static class generate_clause_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "generate_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1608:1: generate_clause : ^( GENERATE ( flatten_generated_item )+ ) ;
	public final LogicalPlanGenerator.generate_clause_return generate_clause() throws RecognitionException {
		GScope_stack.push(new GScope_scope());

		LogicalPlanGenerator.generate_clause_return retval = new LogicalPlanGenerator.generate_clause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree GENERATE359=null;
		TreeRuleReturnScope flatten_generated_item360 =null;

		CommonTree GENERATE359_tree=null;


			GScope_stack.peek().currentOp = builder.createGenerateOp(inNestedCommand ? nested_foreach_stack.peek().innerPlan : foreach_plan_stack.peek().innerPlan );
		    List<LogicalExpressionPlan> plans = new ArrayList<LogicalExpressionPlan>();
		    List<Boolean> flattenFlags = new ArrayList<Boolean>();
		    List<LogicalSchema> schemas = new ArrayList<LogicalSchema>();

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1616:2: ( ^( GENERATE ( flatten_generated_item )+ ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1616:4: ^( GENERATE ( flatten_generated_item )+ )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			GENERATE359=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_generate_clause4974); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			GENERATE359_tree = (CommonTree)adaptor.dupNode(GENERATE359);


			root_1 = (CommonTree)adaptor.becomeRoot(GENERATE359_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1616:16: ( flatten_generated_item )+
			int cnt114=0;
			loop114:
			while (true) {
				int alt114=2;
				int LA114_0 = input.LA(1);
				if ( (LA114_0==BIGDECIMALNUMBER||LA114_0==BIGINTEGERNUMBER||LA114_0==CUBE||LA114_0==DIV||LA114_0==DOLLARVAR||LA114_0==DOUBLENUMBER||LA114_0==FALSE||LA114_0==FLATTEN||LA114_0==FLOATNUMBER||LA114_0==GROUP||LA114_0==IDENTIFIER||LA114_0==INTEGER||LA114_0==LONGINTEGER||LA114_0==MINUS||LA114_0==NULL||LA114_0==PERCENT||LA114_0==PLUS||LA114_0==QUOTEDSTRING||LA114_0==STAR||LA114_0==TRUE||(LA114_0 >= BAG_VAL && LA114_0 <= BIN_EXPR)||(LA114_0 >= CASE_COND && LA114_0 <= CASE_EXPR)||(LA114_0 >= CAST_EXPR && LA114_0 <= EXPR_IN_PAREN)||LA114_0==FUNC_EVAL||LA114_0==INVOKER_FUNC_EVAL||(LA114_0 >= MAP_VAL && LA114_0 <= NEG)||LA114_0==TUPLE_VAL) ) {
					alt114=1;
				}

				switch (alt114) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1616:18: flatten_generated_item
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_flatten_generated_item_in_generate_clause4978);
					flatten_generated_item360=flatten_generated_item();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, flatten_generated_item360.getTree());

					if ( state.backtracking==0 ) {
					                     plans.add( (flatten_generated_item360!=null?((LogicalPlanGenerator.flatten_generated_item_return)flatten_generated_item360).plan:null) );
					                     flattenFlags.add( (flatten_generated_item360!=null?((LogicalPlanGenerator.flatten_generated_item_return)flatten_generated_item360).flattenFlag:false) );
					                     schemas.add( (flatten_generated_item360!=null?((LogicalPlanGenerator.flatten_generated_item_return)flatten_generated_item360).schema:null) );
					                 }
					if ( state.backtracking==0 ) {
					}

					}
					break;

				default :
					if ( cnt114 >= 1 ) break loop114;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(114, input);
					throw eee;
				}
				cnt114++;
			}

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			       builder.buildGenerateOp( new SourceLocation( (LatinParserNode)GENERATE359 ),
			       	   inNestedCommand ? nested_foreach_stack.peek().foreachOp : foreach_clause_stack.peek().foreachOp,
			           (LOGenerate)GScope_stack.peek().currentOp, plans, flattenFlags, schemas );
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			}

		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
			GScope_stack.pop();

		}
		return retval;
	}
	// $ANTLR end "generate_clause"


	public static class nested_op_input_return extends TreeRuleReturnScope {
		public Operator op;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "nested_op_input"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1631:1: nested_op_input returns [Operator op] : ( col_ref[plan] | nested_proj[null] );
	public final LogicalPlanGenerator.nested_op_input_return nested_op_input() throws RecognitionException {
		LogicalPlanGenerator.nested_op_input_return retval = new LogicalPlanGenerator.nested_op_input_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope col_ref361 =null;
		TreeRuleReturnScope nested_proj362 =null;



		    LogicalExpressionPlan plan = new LogicalExpressionPlan();

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1635:2: ( col_ref[plan] | nested_proj[null] )
			int alt115=2;
			int LA115_0 = input.LA(1);
			if ( (LA115_0==CUBE||LA115_0==DOLLARVAR||LA115_0==GROUP||LA115_0==IDENTIFIER) ) {
				alt115=1;
			}
			else if ( (LA115_0==NESTED_PROJ) ) {
				alt115=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 115, 0, input);
				throw nvae;
			}

			switch (alt115) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1635:4: col_ref[plan]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_col_ref_in_nested_op_input5044);
					col_ref361=col_ref(plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, col_ref361.getTree());

					if ( state.backtracking==0 ) {
					       SourceLocation loc = new SourceLocation( (LatinParserNode)(col_ref361!=null?((CommonTree)col_ref361.start):null) );
					       retval.op = builder.buildNestedOperatorInput( loc, foreach_plan_stack.peek().innerPlan,
					           foreach_clause_stack.peek().foreachOp, foreach_plan_stack.peek().operators, (col_ref361!=null?((LogicalPlanGenerator.col_ref_return)col_ref361).expr:null) );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1641:4: nested_proj[null]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_nested_proj_in_nested_op_input5055);
					nested_proj362=nested_proj(null);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, nested_proj362.getTree());

					if ( state.backtracking==0 ) {
					       retval.op = (nested_proj362!=null?((LogicalPlanGenerator.nested_proj_return)nested_proj362).op:null);
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;

			}
			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class nested_op_input_list_return extends TreeRuleReturnScope {
		public List<Operator> opList;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "nested_op_input_list"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1647:1: nested_op_input_list returns [List<Operator> opList] : ( nested_op_input )+ ;
	public final LogicalPlanGenerator.nested_op_input_list_return nested_op_input_list() throws RecognitionException {
		LogicalPlanGenerator.nested_op_input_list_return retval = new LogicalPlanGenerator.nested_op_input_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope nested_op_input363 =null;


		 retval.opList = new ArrayList<Operator>(); 
		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1649:2: ( ( nested_op_input )+ )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1649:4: ( nested_op_input )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1649:4: ( nested_op_input )+
			int cnt116=0;
			loop116:
			while (true) {
				int alt116=2;
				int LA116_0 = input.LA(1);
				if ( (LA116_0==CUBE||LA116_0==DOLLARVAR||LA116_0==GROUP||LA116_0==IDENTIFIER||LA116_0==NESTED_PROJ) ) {
					alt116=1;
				}

				switch (alt116) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1649:6: nested_op_input
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_nested_op_input_in_nested_op_input_list5081);
					nested_op_input363=nested_op_input();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, nested_op_input363.getTree());

					if ( state.backtracking==0 ) { retval.opList.add( (nested_op_input363!=null?((LogicalPlanGenerator.nested_op_input_return)nested_op_input363).op:null) ); }
					if ( state.backtracking==0 ) {
					}

					}
					break;

				default :
					if ( cnt116 >= 1 ) break loop116;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(116, input);
					throw eee;
				}
				cnt116++;
			}

			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class stream_clause_return extends TreeRuleReturnScope {
		public String alias;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "stream_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1652:1: stream_clause returns [String alias] : ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) ;
	public final LogicalPlanGenerator.stream_clause_return stream_clause() throws RecognitionException {
		LogicalPlanGenerator.stream_clause_return retval = new LogicalPlanGenerator.stream_clause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree STREAM364=null;
		CommonTree EXECCOMMAND366=null;
		CommonTree IDENTIFIER367=null;
		TreeRuleReturnScope rel365 =null;
		TreeRuleReturnScope as_clause368 =null;

		CommonTree STREAM364_tree=null;
		CommonTree EXECCOMMAND366_tree=null;
		CommonTree IDENTIFIER367_tree=null;


		    StreamingCommand cmd = null;
		    SourceLocation loc = new SourceLocation( (LatinParserNode)((CommonTree)retval.start) );

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1657:2: ( ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1657:4: ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			STREAM364=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_stream_clause5106); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			STREAM364_tree = (CommonTree)adaptor.dupNode(STREAM364);


			root_1 = (CommonTree)adaptor.becomeRoot(STREAM364_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_rel_in_stream_clause5108);
			rel365=rel();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, rel365.getTree());

			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1657:18: ( EXECCOMMAND | IDENTIFIER )
			int alt117=2;
			int LA117_0 = input.LA(1);
			if ( (LA117_0==EXECCOMMAND) ) {
				alt117=1;
			}
			else if ( (LA117_0==IDENTIFIER) ) {
				alt117=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 117, 0, input);
				throw nvae;
			}

			switch (alt117) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1657:20: EXECCOMMAND
					{
					_last = (CommonTree)input.LT(1);
					EXECCOMMAND366=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_stream_clause5112); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					EXECCOMMAND366_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND366);


					adaptor.addChild(root_1, EXECCOMMAND366_tree);
					}

					if ( state.backtracking==0 ) { cmd = builder.buildCommand( loc, builder.unquote( (EXECCOMMAND366!=null?EXECCOMMAND366.getText():null) ) ); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1658:20: IDENTIFIER
					{
					_last = (CommonTree)input.LT(1);
					IDENTIFIER367=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_stream_clause5135); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IDENTIFIER367_tree = (CommonTree)adaptor.dupNode(IDENTIFIER367);


					adaptor.addChild(root_1, IDENTIFIER367_tree);
					}

					if ( state.backtracking==0 ) {
					                       cmd = builder.lookupCommand( (IDENTIFIER367!=null?IDENTIFIER367.getText():null) );
					                       if( cmd == null ) {
					                           String msg = "Undefined command-alias [" + (IDENTIFIER367!=null?IDENTIFIER367.getText():null) + "]";
					                           throw new ParserValidationException( input,
					                               new SourceLocation( (LatinParserNode)IDENTIFIER367 ), msg );
					                       }
					                   }
					if ( state.backtracking==0 ) {
					}

					}
					break;

			}

			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1667:20: ( as_clause )?
			int alt118=2;
			int LA118_0 = input.LA(1);
			if ( (LA118_0==AS) ) {
				alt118=1;
			}
			switch (alt118) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1667:20: as_clause
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_as_clause_in_stream_clause5177);
					as_clause368=as_clause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, as_clause368.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;

			}

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			       retval.alias = builder.buildStreamOp( loc, statement_stack.peek().alias,
			          statement_stack.peek().inputAlias, cmd, (as_clause368!=null?((LogicalPlanGenerator.as_clause_return)as_clause368).logicalSchema:null), input );
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class mr_clause_return extends TreeRuleReturnScope {
		public String alias;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "mr_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1674:1: mr_clause returns [String alias] : ^( MAPREDUCE QUOTEDSTRING ( path_list[paths] )? store_clause load_clause ( EXECCOMMAND )? ) ;
	public final LogicalPlanGenerator.mr_clause_return mr_clause() throws RecognitionException {
		LogicalPlanGenerator.mr_clause_return retval = new LogicalPlanGenerator.mr_clause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree MAPREDUCE369=null;
		CommonTree QUOTEDSTRING370=null;
		CommonTree EXECCOMMAND374=null;
		TreeRuleReturnScope path_list371 =null;
		TreeRuleReturnScope store_clause372 =null;
		TreeRuleReturnScope load_clause373 =null;

		CommonTree MAPREDUCE369_tree=null;
		CommonTree QUOTEDSTRING370_tree=null;
		CommonTree EXECCOMMAND374_tree=null;


		    List<String> paths = new ArrayList<String>();
		    String alias = statement_stack.peek().alias;
		    SourceLocation loc = new SourceLocation( (LatinParserNode)((CommonTree)retval.start) );

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1680:2: ( ^( MAPREDUCE QUOTEDSTRING ( path_list[paths] )? store_clause load_clause ( EXECCOMMAND )? ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1680:4: ^( MAPREDUCE QUOTEDSTRING ( path_list[paths] )? store_clause load_clause ( EXECCOMMAND )? )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			MAPREDUCE369=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_mr_clause5205); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			MAPREDUCE369_tree = (CommonTree)adaptor.dupNode(MAPREDUCE369);


			root_1 = (CommonTree)adaptor.becomeRoot(MAPREDUCE369_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			QUOTEDSTRING370=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_mr_clause5207); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			QUOTEDSTRING370_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING370);


			adaptor.addChild(root_1, QUOTEDSTRING370_tree);
			}

			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1680:30: ( path_list[paths] )?
			int alt119=2;
			int LA119_0 = input.LA(1);
			if ( (LA119_0==QUOTEDSTRING) ) {
				alt119=1;
			}
			switch (alt119) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1680:30: path_list[paths]
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_path_list_in_mr_clause5209);
					path_list371=path_list(paths);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, path_list371.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;

			}

			if ( state.backtracking==0 ) { statement_stack.peek().alias = null; }
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_store_clause_in_mr_clause5220);
			store_clause372=store_clause();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, store_clause372.getTree());

			if ( state.backtracking==0 ) { statement_stack.peek().alias = alias; }
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_load_clause_in_mr_clause5229);
			load_clause373=load_clause();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, load_clause373.getTree());

			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1683:6: ( EXECCOMMAND )?
			int alt120=2;
			int LA120_0 = input.LA(1);
			if ( (LA120_0==EXECCOMMAND) ) {
				alt120=1;
			}
			switch (alt120) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1683:6: EXECCOMMAND
					{
					_last = (CommonTree)input.LT(1);
					EXECCOMMAND374=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_mr_clause5236); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					EXECCOMMAND374_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND374);


					adaptor.addChild(root_1, EXECCOMMAND374_tree);
					}

					if ( state.backtracking==0 ) {
					}

					}
					break;

			}

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			       retval.alias = builder.buildNativeOp( loc,
			           builder.unquote( (QUOTEDSTRING370!=null?QUOTEDSTRING370.getText():null) ), builder.unquote( (EXECCOMMAND374!=null?EXECCOMMAND374.getText():null) ),
			           paths, (store_clause372!=null?((LogicalPlanGenerator.store_clause_return)store_clause372).alias:null), (load_clause373!=null?((LogicalPlanGenerator.load_clause_return)load_clause373).alias:null), input );
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class split_clause_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "split_clause"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1691:1: split_clause : ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) ;
	public final LogicalPlanGenerator.split_clause_return split_clause() throws RecognitionException {
		LogicalPlanGenerator.split_clause_return retval = new LogicalPlanGenerator.split_clause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree SPLIT375=null;
		TreeRuleReturnScope rel376 =null;
		TreeRuleReturnScope split_branch377 =null;
		TreeRuleReturnScope split_otherwise378 =null;

		CommonTree SPLIT375_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1692:2: ( ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1692:4: ^( SPLIT rel ( split_branch )+ ( split_otherwise )? )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			SPLIT375=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_split_clause5256); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			SPLIT375_tree = (CommonTree)adaptor.dupNode(SPLIT375);


			root_1 = (CommonTree)adaptor.becomeRoot(SPLIT375_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_rel_in_split_clause5264);
			rel376=rel();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, rel376.getTree());

			if ( state.backtracking==0 ) {
			          SourceLocation loc = new SourceLocation( (LatinParserNode)SPLIT375 );
			          statement_stack.peek().inputAlias = builder.buildSplitOp( loc, statement_stack.peek().inputAlias );
			      }
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1698:7: ( split_branch )+
			int cnt121=0;
			loop121:
			while (true) {
				int alt121=2;
				int LA121_0 = input.LA(1);
				if ( (LA121_0==SPLIT_BRANCH) ) {
					alt121=1;
				}

				switch (alt121) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1698:7: split_branch
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_split_branch_in_split_clause5280);
					split_branch377=split_branch();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, split_branch377.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;

				default :
					if ( cnt121 >= 1 ) break loop121;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(121, input);
					throw eee;
				}
				cnt121++;
			}

			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1698:21: ( split_otherwise )?
			int alt122=2;
			int LA122_0 = input.LA(1);
			if ( (LA122_0==OTHERWISE) ) {
				alt122=1;
			}
			switch (alt122) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1698:21: split_otherwise
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_split_otherwise_in_split_clause5283);
					split_otherwise378=split_otherwise();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_1, split_otherwise378.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;

			}

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class split_branch_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "split_branch"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1702:1: split_branch : ^( SPLIT_BRANCH alias cond[splitPlan] ) ;
	public final LogicalPlanGenerator.split_branch_return split_branch() throws RecognitionException {
		GScope_stack.push(new GScope_scope());

		LogicalPlanGenerator.split_branch_return retval = new LogicalPlanGenerator.split_branch_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree SPLIT_BRANCH379=null;
		TreeRuleReturnScope alias380 =null;
		TreeRuleReturnScope cond381 =null;

		CommonTree SPLIT_BRANCH379_tree=null;


		    LogicalExpressionPlan splitPlan = new LogicalExpressionPlan();
		    GScope_stack.peek().currentOp = builder.createSplitOutputOp();

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1708:2: ( ^( SPLIT_BRANCH alias cond[splitPlan] ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1708:4: ^( SPLIT_BRANCH alias cond[splitPlan] )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			SPLIT_BRANCH379=(CommonTree)match(input,SPLIT_BRANCH,FOLLOW_SPLIT_BRANCH_in_split_branch5312); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			SPLIT_BRANCH379_tree = (CommonTree)adaptor.dupNode(SPLIT_BRANCH379);


			root_1 = (CommonTree)adaptor.becomeRoot(SPLIT_BRANCH379_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_alias_in_split_branch5314);
			alias380=alias();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, alias380.getTree());

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_cond_in_split_branch5316);
			cond381=cond(splitPlan);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, cond381.getTree());

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			       SourceLocation loc = new SourceLocation( (LatinParserNode)(alias380!=null?((CommonTree)alias380.start):null) );
			       builder.buildSplitOutputOp( loc, (LOSplitOutput)GScope_stack.peek().currentOp, (alias380!=null?((LogicalPlanGenerator.alias_return)alias380).name:null),
			           statement_stack.peek().inputAlias, splitPlan );
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			}

		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
			GScope_stack.pop();

		}
		return retval;
	}
	// $ANTLR end "split_branch"


	public static class split_otherwise_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "split_otherwise"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1716:1: split_otherwise : ^( OTHERWISE alias ) ;
	public final LogicalPlanGenerator.split_otherwise_return split_otherwise() throws PlanGenerationFailureException, RecognitionException {
		GScope_stack.push(new GScope_scope());

		LogicalPlanGenerator.split_otherwise_return retval = new LogicalPlanGenerator.split_otherwise_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree OTHERWISE382=null;
		TreeRuleReturnScope alias383 =null;

		CommonTree OTHERWISE382_tree=null;


		    GScope_stack.peek().currentOp = builder.createSplitOutputOp();

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1721:2: ( ^( OTHERWISE alias ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1721:4: ^( OTHERWISE alias )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			OTHERWISE382=(CommonTree)match(input,OTHERWISE,FOLLOW_OTHERWISE_in_split_otherwise5350); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			OTHERWISE382_tree = (CommonTree)adaptor.dupNode(OTHERWISE382);


			root_1 = (CommonTree)adaptor.becomeRoot(OTHERWISE382_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_alias_in_split_otherwise5352);
			alias383=alias();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, alias383.getTree());

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			       SourceLocation loc = new SourceLocation( (LatinParserNode)(alias383!=null?((CommonTree)alias383.start):null) );
			       builder.buildSplitOtherwiseOp( loc, (LOSplitOutput)GScope_stack.peek().currentOp, (alias383!=null?((LogicalPlanGenerator.alias_return)alias383).name:null),
			           statement_stack.peek().inputAlias);
			  }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			}

		}

		catch(RecognitionException re) {
		    throw re;
		}

		finally {
			// do for sure before leaving
			GScope_stack.pop();

		}
		return retval;
	}
	// $ANTLR end "split_otherwise"


	public static class col_ref_return extends TreeRuleReturnScope {
		public LogicalExpression expr;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "col_ref"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1729:1: col_ref[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ( alias_col_ref[$plan] | dollar_col_ref[$plan] );
	public final LogicalPlanGenerator.col_ref_return col_ref(LogicalExpressionPlan plan) throws RecognitionException {
		LogicalPlanGenerator.col_ref_return retval = new LogicalPlanGenerator.col_ref_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope alias_col_ref384 =null;
		TreeRuleReturnScope dollar_col_ref385 =null;


		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1730:2: ( alias_col_ref[$plan] | dollar_col_ref[$plan] )
			int alt123=2;
			int LA123_0 = input.LA(1);
			if ( (LA123_0==CUBE||LA123_0==GROUP||LA123_0==IDENTIFIER) ) {
				alt123=1;
			}
			else if ( (LA123_0==DOLLARVAR) ) {
				alt123=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 123, 0, input);
				throw nvae;
			}

			switch (alt123) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1730:4: alias_col_ref[$plan]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_alias_col_ref_in_col_ref5372);
					alias_col_ref384=alias_col_ref(plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, alias_col_ref384.getTree());

					if ( state.backtracking==0 ) { retval.expr = (alias_col_ref384!=null?((LogicalPlanGenerator.alias_col_ref_return)alias_col_ref384).expr:null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1731:4: dollar_col_ref[$plan]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_dollar_col_ref_in_col_ref5380);
					dollar_col_ref385=dollar_col_ref(plan);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, dollar_col_ref385.getTree());

					if ( state.backtracking==0 ) { retval.expr = (dollar_col_ref385!=null?((LogicalPlanGenerator.dollar_col_ref_return)dollar_col_ref385).expr:null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;

			}
			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class alias_col_ref_return extends TreeRuleReturnScope {
		public LogicalExpression expr;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "alias_col_ref"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1734:1: alias_col_ref[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ( GROUP | CUBE | IDENTIFIER );
	public final LogicalPlanGenerator.alias_col_ref_return alias_col_ref(LogicalExpressionPlan plan) throws RecognitionException {
		LogicalPlanGenerator.alias_col_ref_return retval = new LogicalPlanGenerator.alias_col_ref_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree GROUP386=null;
		CommonTree CUBE387=null;
		CommonTree IDENTIFIER388=null;

		CommonTree GROUP386_tree=null;
		CommonTree CUBE387_tree=null;
		CommonTree IDENTIFIER388_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1735:2: ( GROUP | CUBE | IDENTIFIER )
			int alt124=3;
			switch ( input.LA(1) ) {
			case GROUP:
				{
				alt124=1;
				}
				break;
			case CUBE:
				{
				alt124=2;
				}
				break;
			case IDENTIFIER:
				{
				alt124=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 124, 0, input);
				throw nvae;
			}
			switch (alt124) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1735:4: GROUP
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					GROUP386=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_alias_col_ref5397); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					GROUP386_tree = (CommonTree)adaptor.dupNode(GROUP386);


					adaptor.addChild(root_0, GROUP386_tree);
					}

					if ( state.backtracking==0 ) {
					       retval.expr = builder.buildProjectExpr( new SourceLocation( (LatinParserNode)GROUP386 ), plan, GScope_stack.peek().currentOp,
					           statement_stack.peek().inputIndex, (GROUP386!=null?GROUP386.getText():null), 0 );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1740:4: CUBE
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					CUBE387=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_alias_col_ref5407); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					CUBE387_tree = (CommonTree)adaptor.dupNode(CUBE387);


					adaptor.addChild(root_0, CUBE387_tree);
					}

					if ( state.backtracking==0 ) {
					       retval.expr = builder.buildProjectExpr( new SourceLocation( (LatinParserNode)CUBE387 ), plan, GScope_stack.peek().currentOp,
					           statement_stack.peek().inputIndex, (CUBE387!=null?CUBE387.getText():null), 0 );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1745:4: IDENTIFIER
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					IDENTIFIER388=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias_col_ref5417); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IDENTIFIER388_tree = (CommonTree)adaptor.dupNode(IDENTIFIER388);


					adaptor.addChild(root_0, IDENTIFIER388_tree);
					}

					if ( state.backtracking==0 ) {
					       SourceLocation loc = new SourceLocation( (LatinParserNode)IDENTIFIER388 );
					       String alias = (IDENTIFIER388!=null?IDENTIFIER388.getText():null);
					       Operator inOp = builder.lookupOperator( statement_stack.peek().inputAlias );
					       if(null == inOp)
					       {
					           throw new UndefinedAliasException (input,loc,statement_stack.peek().inputAlias);
					       }
					       LogicalSchema schema;
					       try {
					           schema = ((LogicalRelationalOperator)inOp).getSchema();
					       } catch (FrontendException e) {
					           throw new PlanGenerationFailureException( input, loc, e );
					       }

					       // PIG-3581
					       // check within foreach scope before looking at outer scope for scalar
					       if( inForeachPlan && (foreach_plan_stack.peek().operators).containsKey(alias)) {
					           retval.expr = builder.buildProjectExpr( loc, plan, GScope_stack.peek().currentOp,
					               foreach_plan_stack.peek().operators, foreach_plan_stack.peek().exprPlans, alias, 0 );
					       } else {
					           Operator op = builder.lookupOperator( alias );
					           if( op != null && ( schema == null || schema.getFieldPosition( alias ) == -1 ) ) {
					               retval.expr = new ScalarExpression( plan, op,
					                   inForeachPlan ? foreach_clause_stack.peek().foreachOp : GScope_stack.peek().currentOp );
					               retval.expr.setLocation( loc );
					           } else if( inForeachPlan ) {
					               retval.expr = builder.buildProjectExpr( loc, plan, GScope_stack.peek().currentOp,
					                   foreach_plan_stack.peek().operators, foreach_plan_stack.peek().exprPlans, alias, 0 );
					           } else {
					               retval.expr = builder.buildProjectExpr( loc, plan, GScope_stack.peek().currentOp,
					                   statement_stack.peek().inputIndex, alias, 0 );
					           }
					       }
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;

			}
			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "alias_col_ref"


	public static class dollar_col_ref_return extends TreeRuleReturnScope {
		public LogicalExpression expr;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "dollar_col_ref"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1783:1: dollar_col_ref[LogicalExpressionPlan plan] returns [LogicalExpression expr] : DOLLARVAR ;
	public final LogicalPlanGenerator.dollar_col_ref_return dollar_col_ref(LogicalExpressionPlan plan) throws RecognitionException {
		LogicalPlanGenerator.dollar_col_ref_return retval = new LogicalPlanGenerator.dollar_col_ref_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree DOLLARVAR389=null;

		CommonTree DOLLARVAR389_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1784:2: ( DOLLARVAR )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1784:4: DOLLARVAR
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			DOLLARVAR389=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_dollar_col_ref5436); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			DOLLARVAR389_tree = (CommonTree)adaptor.dupNode(DOLLARVAR389);


			adaptor.addChild(root_0, DOLLARVAR389_tree);
			}

			if ( state.backtracking==0 ) {
			       int col = builder.undollar( (DOLLARVAR389!=null?DOLLARVAR389.getText():null) );
			       retval.expr = builder.buildProjectExpr( new SourceLocation( (LatinParserNode)DOLLARVAR389 ), plan, GScope_stack.peek().currentOp,
			           statement_stack.peek().inputIndex, null, col );
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "dollar_col_ref"


	public static class const_expr_return extends TreeRuleReturnScope {
		public LogicalExpression expr;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "const_expr"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1792:1: const_expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : literal ;
	public final LogicalPlanGenerator.const_expr_return const_expr(LogicalExpressionPlan plan) throws RecognitionException {
		LogicalPlanGenerator.const_expr_return retval = new LogicalPlanGenerator.const_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope literal390 =null;


		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1793:2: ( literal )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1793:4: literal
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_literal_in_const_expr5455);
			literal390=literal();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_0, literal390.getTree());

			if ( state.backtracking==0 ) {
			       retval.expr = new ConstantExpression( plan, (literal390!=null?((LogicalPlanGenerator.literal_return)literal390).value:null));
			       retval.expr.setLocation( new SourceLocation( (LatinParserNode)((CommonTree)retval.start) ) );
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "const_expr"


	public static class literal_return extends TreeRuleReturnScope {
		public Object value;
		public byte type;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "literal"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1800:1: literal returns [Object value, byte type] : ( scalar | map | bag | tuple );
	public final LogicalPlanGenerator.literal_return literal() throws RecognitionException {
		LogicalPlanGenerator.literal_return retval = new LogicalPlanGenerator.literal_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope scalar391 =null;
		TreeRuleReturnScope map392 =null;
		TreeRuleReturnScope bag393 =null;
		TreeRuleReturnScope tuple394 =null;


		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1801:2: ( scalar | map | bag | tuple )
			int alt125=4;
			switch ( input.LA(1) ) {
			case BIGDECIMALNUMBER:
			case BIGINTEGERNUMBER:
			case DOUBLENUMBER:
			case FALSE:
			case FLOATNUMBER:
			case INTEGER:
			case LONGINTEGER:
			case MINUS:
			case NULL:
			case QUOTEDSTRING:
			case TRUE:
				{
				alt125=1;
				}
				break;
			case MAP_VAL:
				{
				alt125=2;
				}
				break;
			case BAG_VAL:
				{
				alt125=3;
				}
				break;
			case TUPLE_VAL:
				{
				alt125=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 125, 0, input);
				throw nvae;
			}
			switch (alt125) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1801:4: scalar
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_scalar_in_literal5473);
					scalar391=scalar();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, scalar391.getTree());

					if ( state.backtracking==0 ) {
					       retval.value = (scalar391!=null?((LogicalPlanGenerator.scalar_return)scalar391).value:null);
					       retval.type = (scalar391!=null?((LogicalPlanGenerator.scalar_return)scalar391).type:0);
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1806:4: map
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_map_in_literal5483);
					map392=map();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, map392.getTree());

					if ( state.backtracking==0 ) {
					       retval.value = (map392!=null?((LogicalPlanGenerator.map_return)map392).value:null);
					       retval.type = DataType.MAP;
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;


			}
			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class scalar_return extends TreeRuleReturnScope {
		public Object value;
		public byte type;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "scalar"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1823:1: scalar returns [Object value, byte type] : ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE );
	public final LogicalPlanGenerator.scalar_return scalar() throws RecognitionException {
		LogicalPlanGenerator.scalar_return retval = new LogicalPlanGenerator.scalar_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree QUOTEDSTRING396=null;
		CommonTree NULL397=null;
		CommonTree TRUE398=null;
		CommonTree FALSE399=null;
		TreeRuleReturnScope num_scalar395 =null;

		CommonTree QUOTEDSTRING396_tree=null;
		CommonTree NULL397_tree=null;
		CommonTree TRUE398_tree=null;
		CommonTree FALSE399_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1824:2: ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE )
			int alt126=5;
			switch ( input.LA(1) ) {
			case BIGDECIMALNUMBER:
			case BIGINTEGERNUMBER:
			case DOUBLENUMBER:
			case FLOATNUMBER:
			case INTEGER:
			case LONGINTEGER:
			case MINUS:
				{
				alt126=1;
				}
				break;
			case QUOTEDSTRING:
				{
				alt126=2;
				}
				break;
			case NULL:
				{
				alt126=3;
				}
				break;
			case TRUE:
				{
				alt126=4;
				}
				break;
			case FALSE:
				{
				alt126=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 126, 0, input);
				throw nvae;
			}
			switch (alt126) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1824:4: num_scalar
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_num_scalar_in_scalar5521);
					num_scalar395=num_scalar();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, num_scalar395.getTree());

					if ( state.backtracking==0 ) {
					       retval.type = (num_scalar395!=null?((LogicalPlanGenerator.num_scalar_return)num_scalar395).type:0);
					       retval.value = (num_scalar395!=null?((LogicalPlanGenerator.num_scalar_return)num_scalar395).value:null);
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1829:4: QUOTEDSTRING
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					QUOTEDSTRING396=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_scalar5531); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					QUOTEDSTRING396_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING396);


					adaptor.addChild(root_0, QUOTEDSTRING396_tree);
					}

					if ( state.backtracking==0 ) {
					       retval.type = DataType.CHARARRAY;
					       retval.value = builder.unquote( (QUOTEDSTRING396!=null?QUOTEDSTRING396.getText():null) );
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1834:4: NULL
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					NULL397=(CommonTree)match(input,NULL,FOLLOW_NULL_in_scalar5541); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NULL397_tree = (CommonTree)adaptor.dupNode(NULL397);


					adaptor.addChild(root_0, NULL397_tree);
					}

					if ( state.backtracking==0 ) {
					       retval.type = DataType.NULL;
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 4 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1838:4: TRUE
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					TRUE398=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_scalar5551); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					TRUE398_tree = (CommonTree)adaptor.dupNode(TRUE398);


					adaptor.addChild(root_0, TRUE398_tree);
					}

					if ( state.backtracking==0 ) {
					       retval.type = DataType.BOOLEAN;
					       retval.value = Boolean.TRUE;
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 5 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1843:4: FALSE
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					FALSE399=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_scalar5561); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FALSE399_tree = (CommonTree)adaptor.dupNode(FALSE399);


					adaptor.addChild(root_0, FALSE399_tree);
					}

					if ( state.backtracking==0 ) {
					       retval.type = DataType.BOOLEAN;
					       retval.value = Boolean.FALSE;
					   }
					if ( state.backtracking==0 ) {
					}

					}
					break;

			}
			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class num_scalar_return extends TreeRuleReturnScope {
		public Object value;
		public byte type;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "num_scalar"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1850:1: num_scalar returns [Object value, byte type] : ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER ) ;
	public final LogicalPlanGenerator.num_scalar_return num_scalar() throws RecognitionException {
		LogicalPlanGenerator.num_scalar_return retval = new LogicalPlanGenerator.num_scalar_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree MINUS400=null;
		CommonTree INTEGER401=null;
		CommonTree LONGINTEGER402=null;
		CommonTree FLOATNUMBER403=null;
		CommonTree DOUBLENUMBER404=null;
		CommonTree BIGINTEGERNUMBER405=null;
		CommonTree BIGDECIMALNUMBER406=null;

		CommonTree MINUS400_tree=null;
		CommonTree INTEGER401_tree=null;
		CommonTree LONGINTEGER402_tree=null;
		CommonTree FLOATNUMBER403_tree=null;
		CommonTree DOUBLENUMBER404_tree=null;
		CommonTree BIGINTEGERNUMBER405_tree=null;
		CommonTree BIGDECIMALNUMBER406_tree=null;


		    int sign = 1;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1854:2: ( ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1854:4: ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER )
			{
			root_0 = (CommonTree)adaptor.nil();


			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1854:4: ( MINUS )?
			int alt127=2;
			int LA127_0 = input.LA(1);
			if ( (LA127_0==MINUS) ) {
				alt127=1;
			}
			switch (alt127) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1854:6: MINUS
					{
					_last = (CommonTree)input.LT(1);
					MINUS400=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_num_scalar5586); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					MINUS400_tree = (CommonTree)adaptor.dupNode(MINUS400);


					adaptor.addChild(root_0, MINUS400_tree);
					}

					if ( state.backtracking==0 ) { sign = -1; }
					if ( state.backtracking==0 ) {
					}

					}
					break;

			}

			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1855:4: ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER )
			int alt128=6;
			switch ( input.LA(1) ) {
			case INTEGER:
				{
				alt128=1;
				}
				break;
			case LONGINTEGER:
				{
				alt128=2;
				}
				break;
			case FLOATNUMBER:
				{
				alt128=3;
				}
				break;
			case DOUBLENUMBER:
				{
				alt128=4;
				}
				break;
			case BIGINTEGERNUMBER:
				{
				alt128=5;
				}
				break;
			case BIGDECIMALNUMBER:
				{
				alt128=6;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 128, 0, input);
				throw nvae;
			}
			switch (alt128) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1855:6: INTEGER
					{
					_last = (CommonTree)input.LT(1);
					INTEGER401=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_num_scalar5599); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INTEGER401_tree = (CommonTree)adaptor.dupNode(INTEGER401);


					adaptor.addChild(root_0, INTEGER401_tree);
					}

					if ( state.backtracking==0 ) {
					         retval.type = DataType.INTEGER;
					         retval.value = sign * Integer.valueOf( (INTEGER401!=null?INTEGER401.getText():null) );
					     }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1860:6: LONGINTEGER
					{
					_last = (CommonTree)input.LT(1);
					LONGINTEGER402=(CommonTree)match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_num_scalar5613); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LONGINTEGER402_tree = (CommonTree)adaptor.dupNode(LONGINTEGER402);


					adaptor.addChild(root_0, LONGINTEGER402_tree);
					}

					if ( state.backtracking==0 ) {
					         retval.type = DataType.LONG;
					         retval.value = sign * builder.parseLong( (LONGINTEGER402!=null?LONGINTEGER402.getText():null) );
					     }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1865:6: FLOATNUMBER
					{
					_last = (CommonTree)input.LT(1);
					FLOATNUMBER403=(CommonTree)match(input,FLOATNUMBER,FOLLOW_FLOATNUMBER_in_num_scalar5627); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FLOATNUMBER403_tree = (CommonTree)adaptor.dupNode(FLOATNUMBER403);


					adaptor.addChild(root_0, FLOATNUMBER403_tree);
					}

					if ( state.backtracking==0 ) {
					         retval.type = DataType.FLOAT;
					         retval.value = sign * Float.valueOf( (FLOATNUMBER403!=null?FLOATNUMBER403.getText():null) );
					     }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 4 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1870:6: DOUBLENUMBER
					{
					_last = (CommonTree)input.LT(1);
					DOUBLENUMBER404=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_num_scalar5641); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DOUBLENUMBER404_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER404);


					adaptor.addChild(root_0, DOUBLENUMBER404_tree);
					}

					if ( state.backtracking==0 ) {
					         retval.type = DataType.DOUBLE;
					         retval.value = sign * Double.valueOf( (DOUBLENUMBER404!=null?DOUBLENUMBER404.getText():null) );
					     }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 5 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1875:6: BIGINTEGERNUMBER
					{
					_last = (CommonTree)input.LT(1);
					BIGINTEGERNUMBER405=(CommonTree)match(input,BIGINTEGERNUMBER,FOLLOW_BIGINTEGERNUMBER_in_num_scalar5655); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					BIGINTEGERNUMBER405_tree = (CommonTree)adaptor.dupNode(BIGINTEGERNUMBER405);


					adaptor.addChild(root_0, BIGINTEGERNUMBER405_tree);
					}

					if ( state.backtracking==0 ) {
					         retval.type = DataType.BIGINTEGER;
					         retval.value = builder.parseBigInteger( (BIGINTEGERNUMBER405!=null?BIGINTEGERNUMBER405.getText():null) );
					         if ( sign == -1 ) {
					             retval.value = ((BigInteger)retval.value).negate();
					         }
					     }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 6 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1883:6: BIGDECIMALNUMBER
					{
					_last = (CommonTree)input.LT(1);
					BIGDECIMALNUMBER406=(CommonTree)match(input,BIGDECIMALNUMBER,FOLLOW_BIGDECIMALNUMBER_in_num_scalar5669); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					BIGDECIMALNUMBER406_tree = (CommonTree)adaptor.dupNode(BIGDECIMALNUMBER406);


					adaptor.addChild(root_0, BIGDECIMALNUMBER406_tree);
					}

					if ( state.backtracking==0 ) {
					         retval.type = DataType.BIGDECIMAL;
					         retval.value = builder.parseBigDecimal( (BIGDECIMALNUMBER406!=null?BIGDECIMALNUMBER406.getText():null) );
					         if ( sign == -1 ) {
					             retval.value = ((BigDecimal)retval.value).negate();
					         }
					     }
					if ( state.backtracking==0 ) {
					}

					}
					break;

			}

			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "num_scalar"


	public static class map_return extends TreeRuleReturnScope {
		public Object value;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "map"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1894:1: map returns [Object value] : ^( MAP_VAL ( keyvalue )* ) ;
	public final LogicalPlanGenerator.map_return map() throws RecognitionException {
		LogicalPlanGenerator.map_return retval = new LogicalPlanGenerator.map_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree MAP_VAL407=null;
		TreeRuleReturnScope keyvalue408 =null;

		CommonTree MAP_VAL407_tree=null;

		 Map<String, Object> kvs = new HashMap<String, Object>(); 
		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1896:2: ( ^( MAP_VAL ( keyvalue )* ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1896:4: ^( MAP_VAL ( keyvalue )* )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			MAP_VAL407=(CommonTree)match(input,MAP_VAL,FOLLOW_MAP_VAL_in_map5701); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			MAP_VAL407_tree = (CommonTree)adaptor.dupNode(MAP_VAL407);


			root_1 = (CommonTree)adaptor.becomeRoot(MAP_VAL407_tree, root_1);
			}

			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); if (state.failed) return retval;
				// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1896:15: ( keyvalue )*
				loop129:
				while (true) {
					int alt129=2;
					int LA129_0 = input.LA(1);
					if ( (LA129_0==KEY_VAL_PAIR) ) {
						alt129=1;
					}

					switch (alt129) {
					case 1 :
						// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1896:17: keyvalue
						{
						_last = (CommonTree)input.LT(1);
						pushFollow(FOLLOW_keyvalue_in_map5705);
						keyvalue408=keyvalue();
						state._fsp--;
						if (state.failed) return retval;
						if ( state.backtracking==0 ) 
						adaptor.addChild(root_1, keyvalue408.getTree());

						if ( state.backtracking==0 ) { kvs.put( (keyvalue408!=null?((LogicalPlanGenerator.keyvalue_return)keyvalue408).key:null), (keyvalue408!=null?((LogicalPlanGenerator.keyvalue_return)keyvalue408).value:null) ); }
						if ( state.backtracking==0 ) {
						}

						}
						break;

					default :
						break loop129;
					}
				}

				match(input, Token.UP, null); if (state.failed) return retval;
			}
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			       retval.value = kvs;
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "map"


	public static class keyvalue_return extends TreeRuleReturnScope {
		public String key;
		public Object value;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "keyvalue"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1902:1: keyvalue returns [String key, Object value] : ^( KEY_VAL_PAIR map_key literal ) ;
	public final LogicalPlanGenerator.keyvalue_return keyvalue() throws RecognitionException {
		LogicalPlanGenerator.keyvalue_return retval = new LogicalPlanGenerator.keyvalue_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree KEY_VAL_PAIR409=null;
		TreeRuleReturnScope map_key410 =null;
		TreeRuleReturnScope literal411 =null;

		CommonTree KEY_VAL_PAIR409_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1903:2: ( ^( KEY_VAL_PAIR map_key literal ) )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1903:4: ^( KEY_VAL_PAIR map_key literal )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			KEY_VAL_PAIR409=(CommonTree)match(input,KEY_VAL_PAIR,FOLLOW_KEY_VAL_PAIR_in_keyvalue5732); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			KEY_VAL_PAIR409_tree = (CommonTree)adaptor.dupNode(KEY_VAL_PAIR409);


			root_1 = (CommonTree)adaptor.becomeRoot(KEY_VAL_PAIR409_tree, root_1);
			}

			match(input, Token.DOWN, null); if (state.failed) return retval;
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_map_key_in_keyvalue5734);
			map_key410=map_key();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, map_key410.getTree());

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_literal_in_keyvalue5736);
			literal411=literal();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) 
			adaptor.addChild(root_1, literal411.getTree());

			match(input, Token.UP, null); if (state.failed) return retval;
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			if ( state.backtracking==0 ) {
			       retval.key = (map_key410!=null?((LogicalPlanGenerator.map_key_return)map_key410).value:null);
			       retval.value = (literal411!=null?((LogicalPlanGenerator.literal_return)literal411).value:null);
			   }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class map_key_return extends TreeRuleReturnScope {
		public String value;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "map_key"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1910:1: map_key returns [String value] : QUOTEDSTRING ;
	public final LogicalPlanGenerator.map_key_return map_key() throws RecognitionException {
		LogicalPlanGenerator.map_key_return retval = new LogicalPlanGenerator.map_key_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree QUOTEDSTRING412=null;

		CommonTree QUOTEDSTRING412_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1911:2: ( QUOTEDSTRING )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1911:4: QUOTEDSTRING
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			QUOTEDSTRING412=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_map_key5756); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			QUOTEDSTRING412_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING412);


			adaptor.addChild(root_0, QUOTEDSTRING412_tree);
			}

			if ( state.backtracking==0 ) { retval.value = builder.unquote( (QUOTEDSTRING412!=null?QUOTEDSTRING412.getText():null) ); }
			if ( state.backtracking==0 ) {
			}

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "map_key"


	public static class bag_return extends TreeRuleReturnScope {
		public Object value;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};



	public static class eid_return extends TreeRuleReturnScope {
		public String id;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "eid"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1931:1: eid returns [String id] : ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | MATCHES | ORDER | DISTINCT | COGROUP | CUBE | ROLLUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE | ASSERT );
	public final LogicalPlanGenerator.eid_return eid() throws RecognitionException {
		LogicalPlanGenerator.eid_return retval = new LogicalPlanGenerator.eid_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree IMPORT418=null;
		CommonTree RETURNS419=null;
		CommonTree DEFINE420=null;
		CommonTree LOAD421=null;
		CommonTree FILTER422=null;
		CommonTree FOREACH423=null;
		CommonTree MATCHES424=null;
		CommonTree ORDER425=null;
		CommonTree DISTINCT426=null;
		CommonTree COGROUP427=null;
		CommonTree CUBE428=null;
		CommonTree ROLLUP429=null;
		CommonTree JOIN430=null;
		CommonTree CROSS431=null;
		CommonTree UNION432=null;
		CommonTree SPLIT433=null;
		CommonTree INTO434=null;
		CommonTree IF435=null;
		CommonTree ALL436=null;
		CommonTree AS437=null;
		CommonTree BY438=null;
		CommonTree USING439=null;
		CommonTree INNER440=null;
		CommonTree OUTER441=null;
		CommonTree PARALLEL442=null;
		CommonTree PARTITION443=null;
		CommonTree GROUP444=null;
		CommonTree AND445=null;
		CommonTree OR446=null;
		CommonTree NOT447=null;
		CommonTree GENERATE448=null;
		CommonTree FLATTEN449=null;
		CommonTree EVAL450=null;
		CommonTree ASC451=null;
		CommonTree DESC452=null;
		CommonTree BOOLEAN453=null;
		CommonTree INT454=null;
		CommonTree LONG455=null;
		CommonTree FLOAT456=null;
		CommonTree DOUBLE457=null;
		CommonTree BIGINTEGER458=null;
		CommonTree BIGDECIMAL459=null;
		CommonTree DATETIME460=null;
		CommonTree CHARARRAY461=null;
		CommonTree BYTEARRAY462=null;
		CommonTree BAG463=null;
		CommonTree TUPLE464=null;
		CommonTree MAP465=null;
		CommonTree IS466=null;
		CommonTree NULL467=null;
		CommonTree TRUE468=null;
		CommonTree FALSE469=null;
		CommonTree STREAM470=null;
		CommonTree THROUGH471=null;
		CommonTree STORE472=null;
		CommonTree MAPREDUCE473=null;
		CommonTree SHIP474=null;
		CommonTree CACHE475=null;
		CommonTree INPUT476=null;
		CommonTree OUTPUT477=null;
		CommonTree STDERROR478=null;
		CommonTree STDIN479=null;
		CommonTree STDOUT480=null;
		CommonTree LIMIT481=null;
		CommonTree SAMPLE482=null;
		CommonTree LEFT483=null;
		CommonTree RIGHT484=null;
		CommonTree FULL485=null;
		CommonTree IDENTIFIER486=null;
		CommonTree TOBAG487=null;
		CommonTree TOMAP488=null;
		CommonTree TOTUPLE489=null;
		CommonTree ASSERT490=null;
		TreeRuleReturnScope rel_str_op417 =null;

		CommonTree IMPORT418_tree=null;
		CommonTree RETURNS419_tree=null;
		CommonTree DEFINE420_tree=null;
		CommonTree LOAD421_tree=null;
		CommonTree FILTER422_tree=null;
		CommonTree FOREACH423_tree=null;
		CommonTree MATCHES424_tree=null;
		CommonTree ORDER425_tree=null;
		CommonTree DISTINCT426_tree=null;
		CommonTree COGROUP427_tree=null;
		CommonTree CUBE428_tree=null;
		CommonTree ROLLUP429_tree=null;
		CommonTree JOIN430_tree=null;
		CommonTree CROSS431_tree=null;
		CommonTree UNION432_tree=null;
		CommonTree SPLIT433_tree=null;
		CommonTree INTO434_tree=null;
		CommonTree IF435_tree=null;
		CommonTree ALL436_tree=null;
		CommonTree AS437_tree=null;
		CommonTree BY438_tree=null;
		CommonTree USING439_tree=null;
		CommonTree INNER440_tree=null;
		CommonTree OUTER441_tree=null;
		CommonTree PARALLEL442_tree=null;
		CommonTree PARTITION443_tree=null;
		CommonTree GROUP444_tree=null;
		CommonTree AND445_tree=null;
		CommonTree OR446_tree=null;
		CommonTree NOT447_tree=null;
		CommonTree GENERATE448_tree=null;
		CommonTree FLATTEN449_tree=null;
		CommonTree EVAL450_tree=null;
		CommonTree ASC451_tree=null;
		CommonTree DESC452_tree=null;
		CommonTree BOOLEAN453_tree=null;
		CommonTree INT454_tree=null;
		CommonTree LONG455_tree=null;
		CommonTree FLOAT456_tree=null;
		CommonTree DOUBLE457_tree=null;
		CommonTree BIGINTEGER458_tree=null;
		CommonTree BIGDECIMAL459_tree=null;
		CommonTree DATETIME460_tree=null;
		CommonTree CHARARRAY461_tree=null;
		CommonTree BYTEARRAY462_tree=null;
		CommonTree BAG463_tree=null;
		CommonTree TUPLE464_tree=null;
		CommonTree MAP465_tree=null;
		CommonTree IS466_tree=null;
		CommonTree NULL467_tree=null;
		CommonTree TRUE468_tree=null;
		CommonTree FALSE469_tree=null;
		CommonTree STREAM470_tree=null;
		CommonTree THROUGH471_tree=null;
		CommonTree STORE472_tree=null;
		CommonTree MAPREDUCE473_tree=null;
		CommonTree SHIP474_tree=null;
		CommonTree CACHE475_tree=null;
		CommonTree INPUT476_tree=null;
		CommonTree OUTPUT477_tree=null;
		CommonTree STDERROR478_tree=null;
		CommonTree STDIN479_tree=null;
		CommonTree STDOUT480_tree=null;
		CommonTree LIMIT481_tree=null;
		CommonTree SAMPLE482_tree=null;
		CommonTree LEFT483_tree=null;
		CommonTree RIGHT484_tree=null;
		CommonTree FULL485_tree=null;
		CommonTree IDENTIFIER486_tree=null;
		CommonTree TOBAG487_tree=null;
		CommonTree TOMAP488_tree=null;
		CommonTree TOTUPLE489_tree=null;
		CommonTree ASSERT490_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1931:24: ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | MATCHES | ORDER | DISTINCT | COGROUP | CUBE | ROLLUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE | ASSERT )
			int alt132=74;
			switch ( input.LA(1) ) {
			case STR_OP_EQ:
			case STR_OP_GT:
			case STR_OP_GTE:
			case STR_OP_LT:
			case STR_OP_LTE:
			case STR_OP_MATCHES:
			case STR_OP_NE:
				{
				alt132=1;
				}
				break;
			case IMPORT:
				{
				alt132=2;
				}
				break;
			case RETURNS:
				{
				alt132=3;
				}
				break;
			case DEFINE:
				{
				alt132=4;
				}
				break;
			case LOAD:
				{
				alt132=5;
				}
				break;
			case FILTER:
				{
				alt132=6;
				}
				break;
			case FOREACH:
				{
				alt132=7;
				}
				break;
			case MATCHES:
				{
				alt132=8;
				}
				break;
			case ORDER:
				{
				alt132=9;
				}
				break;
			case DISTINCT:
				{
				alt132=10;
				}
				break;
			case COGROUP:
				{
				alt132=11;
				}
				break;
			case CUBE:
				{
				alt132=12;
				}
				break;
			case ROLLUP:
				{
				alt132=13;
				}
				break;
			case JOIN:
				{
				alt132=14;
				}
				break;
			case CROSS:
				{
				alt132=15;
				}
				break;
			case UNION:
				{
				alt132=16;
				}
				break;
			case SPLIT:
				{
				alt132=17;
				}
				break;
			case INTO:
				{
				alt132=18;
				}
				break;
			case IF:
				{
				alt132=19;
				}
				break;
			case ALL:
				{
				alt132=20;
				}
				break;
			case AS:
				{
				alt132=21;
				}
				break;
			case BY:
				{
				alt132=22;
				}
				break;
			case USING:
				{
				alt132=23;
				}
				break;
			case INNER:
				{
				alt132=24;
				}
				break;
			case OUTER:
				{
				alt132=25;
				}
				break;
			case PARALLEL:
				{
				alt132=26;
				}
				break;
			case PARTITION:
				{
				alt132=27;
				}
				break;
			case GROUP:
				{
				alt132=28;
				}
				break;
			case AND:
				{
				alt132=29;
				}
				break;
			case OR:
				{
				alt132=30;
				}
				break;
			case NOT:
				{
				alt132=31;
				}
				break;
			case GENERATE:
				{
				alt132=32;
				}
				break;
			case FLATTEN:
				{
				alt132=33;
				}
				break;
			case EVAL:
				{
				alt132=34;
				}
				break;
			case ASC:
				{
				alt132=35;
				}
				break;
			case DESC:
				{
				alt132=36;
				}
				break;
			case BOOLEAN:
				{
				alt132=37;
				}
				break;
			case INT:
				{
				alt132=38;
				}
				break;
			case LONG:
				{
				alt132=39;
				}
				break;
			case FLOAT:
				{
				alt132=40;
				}
				break;
			case DOUBLE:
				{
				alt132=41;
				}
				break;
			case BIGINTEGER:
				{
				alt132=42;
				}
				break;
			case BIGDECIMAL:
				{
				alt132=43;
				}
				break;
			case DATETIME:
				{
				alt132=44;
				}
				break;
			case CHARARRAY:
				{
				alt132=45;
				}
				break;
			case BYTEARRAY:
				{
				alt132=46;
				}
				break;
			case BAG:
				{
				alt132=47;
				}
				break;
			case TUPLE:
				{
				alt132=48;
				}
				break;
			case MAP:
				{
				alt132=49;
				}
				break;
			case IS:
				{
				alt132=50;
				}
				break;
			case NULL:
				{
				alt132=51;
				}
				break;
			case TRUE:
				{
				alt132=52;
				}
				break;
			case FALSE:
				{
				alt132=53;
				}
				break;
			case STREAM:
				{
				alt132=54;
				}
				break;
			case THROUGH:
				{
				alt132=55;
				}
				break;
			case STORE:
				{
				alt132=56;
				}
				break;
			case MAPREDUCE:
				{
				alt132=57;
				}
				break;
			case SHIP:
				{
				alt132=58;
				}
				break;
			case CACHE:
				{
				alt132=59;
				}
				break;
			case INPUT:
				{
				alt132=60;
				}
				break;
			case OUTPUT:
				{
				alt132=61;
				}
				break;
			case STDERROR:
				{
				alt132=62;
				}
				break;
			case STDIN:
				{
				alt132=63;
				}
				break;
			case STDOUT:
				{
				alt132=64;
				}
				break;
			case LIMIT:
				{
				alt132=65;
				}
				break;
			case SAMPLE:
				{
				alt132=66;
				}
				break;
			case LEFT:
				{
				alt132=67;
				}
				break;
			case RIGHT:
				{
				alt132=68;
				}
				break;
			case FULL:
				{
				alt132=69;
				}
				break;
			case IDENTIFIER:
				{
				alt132=70;
				}
				break;
			case TOBAG:
				{
				alt132=71;
				}
				break;
			case TOMAP:
				{
				alt132=72;
				}
				break;
			case TOTUPLE:
				{
				alt132=73;
				}
				break;
			case ASSERT:
				{
				alt132=74;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 132, 0, input);
				throw nvae;
			}
			switch (alt132) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1931:26: rel_str_op
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_rel_str_op_in_eid5843);
					rel_str_op417=rel_str_op();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, rel_str_op417.getTree());

					if ( state.backtracking==0 ) { retval.id = (rel_str_op417!=null?((LogicalPlanGenerator.rel_str_op_return)rel_str_op417).id:null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1932:7: IMPORT
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					IMPORT418=(CommonTree)match(input,IMPORT,FOLLOW_IMPORT_in_eid5853); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IMPORT418_tree = (CommonTree)adaptor.dupNode(IMPORT418);


					adaptor.addChild(root_0, IMPORT418_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (IMPORT418!=null?IMPORT418.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1933:7: RETURNS
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					RETURNS419=(CommonTree)match(input,RETURNS,FOLLOW_RETURNS_in_eid5863); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RETURNS419_tree = (CommonTree)adaptor.dupNode(RETURNS419);


					adaptor.addChild(root_0, RETURNS419_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (RETURNS419!=null?RETURNS419.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 4 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1934:7: DEFINE
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					DEFINE420=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_eid5873); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DEFINE420_tree = (CommonTree)adaptor.dupNode(DEFINE420);


					adaptor.addChild(root_0, DEFINE420_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (DEFINE420!=null?DEFINE420.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 5 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1935:7: LOAD
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					LOAD421=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_eid5883); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LOAD421_tree = (CommonTree)adaptor.dupNode(LOAD421);


					adaptor.addChild(root_0, LOAD421_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (LOAD421!=null?LOAD421.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 6 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1936:7: FILTER
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					FILTER422=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_eid5893); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FILTER422_tree = (CommonTree)adaptor.dupNode(FILTER422);


					adaptor.addChild(root_0, FILTER422_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (FILTER422!=null?FILTER422.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 7 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1937:7: FOREACH
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					FOREACH423=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_eid5903); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FOREACH423_tree = (CommonTree)adaptor.dupNode(FOREACH423);


					adaptor.addChild(root_0, FOREACH423_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (FOREACH423!=null?FOREACH423.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 8 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1938:7: MATCHES
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					MATCHES424=(CommonTree)match(input,MATCHES,FOLLOW_MATCHES_in_eid5913); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					MATCHES424_tree = (CommonTree)adaptor.dupNode(MATCHES424);


					adaptor.addChild(root_0, MATCHES424_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (MATCHES424!=null?MATCHES424.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 9 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1939:7: ORDER
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					ORDER425=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_eid5923); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ORDER425_tree = (CommonTree)adaptor.dupNode(ORDER425);


					adaptor.addChild(root_0, ORDER425_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (ORDER425!=null?ORDER425.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 10 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1940:7: DISTINCT
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					DISTINCT426=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_eid5933); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DISTINCT426_tree = (CommonTree)adaptor.dupNode(DISTINCT426);


					adaptor.addChild(root_0, DISTINCT426_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (DISTINCT426!=null?DISTINCT426.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 11 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1941:7: COGROUP
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					COGROUP427=(CommonTree)match(input,COGROUP,FOLLOW_COGROUP_in_eid5943); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					COGROUP427_tree = (CommonTree)adaptor.dupNode(COGROUP427);


					adaptor.addChild(root_0, COGROUP427_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (COGROUP427!=null?COGROUP427.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 12 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1942:7: CUBE
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					CUBE428=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_eid5953); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					CUBE428_tree = (CommonTree)adaptor.dupNode(CUBE428);


					adaptor.addChild(root_0, CUBE428_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (CUBE428!=null?CUBE428.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 13 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1943:7: ROLLUP
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					ROLLUP429=(CommonTree)match(input,ROLLUP,FOLLOW_ROLLUP_in_eid5963); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ROLLUP429_tree = (CommonTree)adaptor.dupNode(ROLLUP429);


					adaptor.addChild(root_0, ROLLUP429_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (ROLLUP429!=null?ROLLUP429.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 14 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1944:7: JOIN
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					JOIN430=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_eid5973); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					JOIN430_tree = (CommonTree)adaptor.dupNode(JOIN430);


					adaptor.addChild(root_0, JOIN430_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (JOIN430!=null?JOIN430.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 15 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1945:7: CROSS
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					CROSS431=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_eid5983); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					CROSS431_tree = (CommonTree)adaptor.dupNode(CROSS431);


					adaptor.addChild(root_0, CROSS431_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (CROSS431!=null?CROSS431.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 16 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1946:7: UNION
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					UNION432=(CommonTree)match(input,UNION,FOLLOW_UNION_in_eid5993); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					UNION432_tree = (CommonTree)adaptor.dupNode(UNION432);


					adaptor.addChild(root_0, UNION432_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (UNION432!=null?UNION432.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 17 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1947:7: SPLIT
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					SPLIT433=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_eid6003); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					SPLIT433_tree = (CommonTree)adaptor.dupNode(SPLIT433);


					adaptor.addChild(root_0, SPLIT433_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (SPLIT433!=null?SPLIT433.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 18 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1948:7: INTO
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					INTO434=(CommonTree)match(input,INTO,FOLLOW_INTO_in_eid6013); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INTO434_tree = (CommonTree)adaptor.dupNode(INTO434);


					adaptor.addChild(root_0, INTO434_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (INTO434!=null?INTO434.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 19 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1949:7: IF
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					IF435=(CommonTree)match(input,IF,FOLLOW_IF_in_eid6023); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IF435_tree = (CommonTree)adaptor.dupNode(IF435);


					adaptor.addChild(root_0, IF435_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (IF435!=null?IF435.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 20 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1950:7: ALL
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					ALL436=(CommonTree)match(input,ALL,FOLLOW_ALL_in_eid6033); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ALL436_tree = (CommonTree)adaptor.dupNode(ALL436);


					adaptor.addChild(root_0, ALL436_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (ALL436!=null?ALL436.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 21 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1951:7: AS
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					AS437=(CommonTree)match(input,AS,FOLLOW_AS_in_eid6043); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					AS437_tree = (CommonTree)adaptor.dupNode(AS437);


					adaptor.addChild(root_0, AS437_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (AS437!=null?AS437.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 22 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1952:7: BY
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					BY438=(CommonTree)match(input,BY,FOLLOW_BY_in_eid6053); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					BY438_tree = (CommonTree)adaptor.dupNode(BY438);


					adaptor.addChild(root_0, BY438_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (BY438!=null?BY438.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 23 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1953:7: USING
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					USING439=(CommonTree)match(input,USING,FOLLOW_USING_in_eid6063); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					USING439_tree = (CommonTree)adaptor.dupNode(USING439);


					adaptor.addChild(root_0, USING439_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (USING439!=null?USING439.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 24 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1954:7: INNER
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					INNER440=(CommonTree)match(input,INNER,FOLLOW_INNER_in_eid6073); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INNER440_tree = (CommonTree)adaptor.dupNode(INNER440);


					adaptor.addChild(root_0, INNER440_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (INNER440!=null?INNER440.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 25 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1955:7: OUTER
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					OUTER441=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_eid6083); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					OUTER441_tree = (CommonTree)adaptor.dupNode(OUTER441);


					adaptor.addChild(root_0, OUTER441_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (OUTER441!=null?OUTER441.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 26 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1956:7: PARALLEL
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					PARALLEL442=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_eid6093); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					PARALLEL442_tree = (CommonTree)adaptor.dupNode(PARALLEL442);


					adaptor.addChild(root_0, PARALLEL442_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (PARALLEL442!=null?PARALLEL442.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 27 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1957:7: PARTITION
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					PARTITION443=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_eid6103); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					PARTITION443_tree = (CommonTree)adaptor.dupNode(PARTITION443);


					adaptor.addChild(root_0, PARTITION443_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (PARTITION443!=null?PARTITION443.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 28 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1958:7: GROUP
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					GROUP444=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_eid6113); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					GROUP444_tree = (CommonTree)adaptor.dupNode(GROUP444);


					adaptor.addChild(root_0, GROUP444_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (GROUP444!=null?GROUP444.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 29 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1959:7: AND
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					AND445=(CommonTree)match(input,AND,FOLLOW_AND_in_eid6123); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					AND445_tree = (CommonTree)adaptor.dupNode(AND445);


					adaptor.addChild(root_0, AND445_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (AND445!=null?AND445.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 30 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1960:7: OR
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					OR446=(CommonTree)match(input,OR,FOLLOW_OR_in_eid6133); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					OR446_tree = (CommonTree)adaptor.dupNode(OR446);


					adaptor.addChild(root_0, OR446_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (OR446!=null?OR446.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 31 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1961:7: NOT
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					NOT447=(CommonTree)match(input,NOT,FOLLOW_NOT_in_eid6143); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NOT447_tree = (CommonTree)adaptor.dupNode(NOT447);


					adaptor.addChild(root_0, NOT447_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (NOT447!=null?NOT447.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 32 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1962:7: GENERATE
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					GENERATE448=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_eid6153); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					GENERATE448_tree = (CommonTree)adaptor.dupNode(GENERATE448);


					adaptor.addChild(root_0, GENERATE448_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (GENERATE448!=null?GENERATE448.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 33 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1963:7: FLATTEN
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					FLATTEN449=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_eid6163); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FLATTEN449_tree = (CommonTree)adaptor.dupNode(FLATTEN449);


					adaptor.addChild(root_0, FLATTEN449_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (FLATTEN449!=null?FLATTEN449.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 34 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1964:7: EVAL
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					EVAL450=(CommonTree)match(input,EVAL,FOLLOW_EVAL_in_eid6173); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					EVAL450_tree = (CommonTree)adaptor.dupNode(EVAL450);


					adaptor.addChild(root_0, EVAL450_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (EVAL450!=null?EVAL450.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 35 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1965:7: ASC
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					ASC451=(CommonTree)match(input,ASC,FOLLOW_ASC_in_eid6183); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ASC451_tree = (CommonTree)adaptor.dupNode(ASC451);


					adaptor.addChild(root_0, ASC451_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (ASC451!=null?ASC451.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 36 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1966:7: DESC
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					DESC452=(CommonTree)match(input,DESC,FOLLOW_DESC_in_eid6193); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DESC452_tree = (CommonTree)adaptor.dupNode(DESC452);


					adaptor.addChild(root_0, DESC452_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (DESC452!=null?DESC452.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 37 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1967:7: BOOLEAN
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					BOOLEAN453=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_eid6203); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					BOOLEAN453_tree = (CommonTree)adaptor.dupNode(BOOLEAN453);


					adaptor.addChild(root_0, BOOLEAN453_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (BOOLEAN453!=null?BOOLEAN453.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 38 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1968:7: INT
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					INT454=(CommonTree)match(input,INT,FOLLOW_INT_in_eid6213); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INT454_tree = (CommonTree)adaptor.dupNode(INT454);


					adaptor.addChild(root_0, INT454_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (INT454!=null?INT454.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 39 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1969:7: LONG
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					LONG455=(CommonTree)match(input,LONG,FOLLOW_LONG_in_eid6223); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LONG455_tree = (CommonTree)adaptor.dupNode(LONG455);


					adaptor.addChild(root_0, LONG455_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (LONG455!=null?LONG455.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 40 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1970:7: FLOAT
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					FLOAT456=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_eid6233); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FLOAT456_tree = (CommonTree)adaptor.dupNode(FLOAT456);


					adaptor.addChild(root_0, FLOAT456_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (FLOAT456!=null?FLOAT456.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 41 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1971:7: DOUBLE
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					DOUBLE457=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_eid6243); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DOUBLE457_tree = (CommonTree)adaptor.dupNode(DOUBLE457);


					adaptor.addChild(root_0, DOUBLE457_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (DOUBLE457!=null?DOUBLE457.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 42 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1972:7: BIGINTEGER
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					BIGINTEGER458=(CommonTree)match(input,BIGINTEGER,FOLLOW_BIGINTEGER_in_eid6253); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					BIGINTEGER458_tree = (CommonTree)adaptor.dupNode(BIGINTEGER458);


					adaptor.addChild(root_0, BIGINTEGER458_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (BIGINTEGER458!=null?BIGINTEGER458.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 43 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1973:7: BIGDECIMAL
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					BIGDECIMAL459=(CommonTree)match(input,BIGDECIMAL,FOLLOW_BIGDECIMAL_in_eid6263); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					BIGDECIMAL459_tree = (CommonTree)adaptor.dupNode(BIGDECIMAL459);


					adaptor.addChild(root_0, BIGDECIMAL459_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (BIGDECIMAL459!=null?BIGDECIMAL459.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 44 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1974:7: DATETIME
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					DATETIME460=(CommonTree)match(input,DATETIME,FOLLOW_DATETIME_in_eid6273); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DATETIME460_tree = (CommonTree)adaptor.dupNode(DATETIME460);


					adaptor.addChild(root_0, DATETIME460_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (DATETIME460!=null?DATETIME460.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 45 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1975:7: CHARARRAY
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					CHARARRAY461=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_eid6283); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					CHARARRAY461_tree = (CommonTree)adaptor.dupNode(CHARARRAY461);


					adaptor.addChild(root_0, CHARARRAY461_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (CHARARRAY461!=null?CHARARRAY461.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 46 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1976:7: BYTEARRAY
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					BYTEARRAY462=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_eid6293); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					BYTEARRAY462_tree = (CommonTree)adaptor.dupNode(BYTEARRAY462);


					adaptor.addChild(root_0, BYTEARRAY462_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (BYTEARRAY462!=null?BYTEARRAY462.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 47 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1977:7: BAG
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					BAG463=(CommonTree)match(input,BAG,FOLLOW_BAG_in_eid6303); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					BAG463_tree = (CommonTree)adaptor.dupNode(BAG463);


					adaptor.addChild(root_0, BAG463_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (BAG463!=null?BAG463.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 48 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1978:7: TUPLE
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					TUPLE464=(CommonTree)match(input,TUPLE,FOLLOW_TUPLE_in_eid6313); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					TUPLE464_tree = (CommonTree)adaptor.dupNode(TUPLE464);


					adaptor.addChild(root_0, TUPLE464_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (TUPLE464!=null?TUPLE464.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 49 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1979:7: MAP
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					MAP465=(CommonTree)match(input,MAP,FOLLOW_MAP_in_eid6323); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					MAP465_tree = (CommonTree)adaptor.dupNode(MAP465);


					adaptor.addChild(root_0, MAP465_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (MAP465!=null?MAP465.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 50 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1980:7: IS
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					IS466=(CommonTree)match(input,IS,FOLLOW_IS_in_eid6333); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IS466_tree = (CommonTree)adaptor.dupNode(IS466);


					adaptor.addChild(root_0, IS466_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (IS466!=null?IS466.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 51 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1981:7: NULL
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					NULL467=(CommonTree)match(input,NULL,FOLLOW_NULL_in_eid6343); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NULL467_tree = (CommonTree)adaptor.dupNode(NULL467);


					adaptor.addChild(root_0, NULL467_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (NULL467!=null?NULL467.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 52 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1982:7: TRUE
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					TRUE468=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_eid6353); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					TRUE468_tree = (CommonTree)adaptor.dupNode(TRUE468);


					adaptor.addChild(root_0, TRUE468_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (TRUE468!=null?TRUE468.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 53 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1983:7: FALSE
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					FALSE469=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_eid6363); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FALSE469_tree = (CommonTree)adaptor.dupNode(FALSE469);


					adaptor.addChild(root_0, FALSE469_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (FALSE469!=null?FALSE469.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 54 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1984:7: STREAM
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					STREAM470=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_eid6373); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STREAM470_tree = (CommonTree)adaptor.dupNode(STREAM470);


					adaptor.addChild(root_0, STREAM470_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (STREAM470!=null?STREAM470.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 55 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1985:7: THROUGH
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					THROUGH471=(CommonTree)match(input,THROUGH,FOLLOW_THROUGH_in_eid6383); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					THROUGH471_tree = (CommonTree)adaptor.dupNode(THROUGH471);


					adaptor.addChild(root_0, THROUGH471_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (THROUGH471!=null?THROUGH471.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 56 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1986:7: STORE
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					STORE472=(CommonTree)match(input,STORE,FOLLOW_STORE_in_eid6393); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STORE472_tree = (CommonTree)adaptor.dupNode(STORE472);


					adaptor.addChild(root_0, STORE472_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (STORE472!=null?STORE472.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 57 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1987:7: MAPREDUCE
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					MAPREDUCE473=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_eid6403); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					MAPREDUCE473_tree = (CommonTree)adaptor.dupNode(MAPREDUCE473);


					adaptor.addChild(root_0, MAPREDUCE473_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (MAPREDUCE473!=null?MAPREDUCE473.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 58 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1988:7: SHIP
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					SHIP474=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_eid6413); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					SHIP474_tree = (CommonTree)adaptor.dupNode(SHIP474);


					adaptor.addChild(root_0, SHIP474_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (SHIP474!=null?SHIP474.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 59 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1989:7: CACHE
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					CACHE475=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_eid6423); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					CACHE475_tree = (CommonTree)adaptor.dupNode(CACHE475);


					adaptor.addChild(root_0, CACHE475_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (CACHE475!=null?CACHE475.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 60 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1990:7: INPUT
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					INPUT476=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_eid6433); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INPUT476_tree = (CommonTree)adaptor.dupNode(INPUT476);


					adaptor.addChild(root_0, INPUT476_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (INPUT476!=null?INPUT476.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 61 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1991:7: OUTPUT
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					OUTPUT477=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_eid6443); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					OUTPUT477_tree = (CommonTree)adaptor.dupNode(OUTPUT477);


					adaptor.addChild(root_0, OUTPUT477_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (OUTPUT477!=null?OUTPUT477.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 62 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1992:7: STDERROR
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					STDERROR478=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_eid6453); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STDERROR478_tree = (CommonTree)adaptor.dupNode(STDERROR478);


					adaptor.addChild(root_0, STDERROR478_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (STDERROR478!=null?STDERROR478.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 63 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1993:7: STDIN
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					STDIN479=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_eid6463); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STDIN479_tree = (CommonTree)adaptor.dupNode(STDIN479);


					adaptor.addChild(root_0, STDIN479_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (STDIN479!=null?STDIN479.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 64 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1994:7: STDOUT
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					STDOUT480=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_eid6473); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STDOUT480_tree = (CommonTree)adaptor.dupNode(STDOUT480);


					adaptor.addChild(root_0, STDOUT480_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (STDOUT480!=null?STDOUT480.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 65 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1995:7: LIMIT
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					LIMIT481=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_eid6483); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LIMIT481_tree = (CommonTree)adaptor.dupNode(LIMIT481);


					adaptor.addChild(root_0, LIMIT481_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (LIMIT481!=null?LIMIT481.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 66 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1996:7: SAMPLE
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					SAMPLE482=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_eid6493); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					SAMPLE482_tree = (CommonTree)adaptor.dupNode(SAMPLE482);


					adaptor.addChild(root_0, SAMPLE482_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (SAMPLE482!=null?SAMPLE482.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 67 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1997:7: LEFT
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					LEFT483=(CommonTree)match(input,LEFT,FOLLOW_LEFT_in_eid6503); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LEFT483_tree = (CommonTree)adaptor.dupNode(LEFT483);


					adaptor.addChild(root_0, LEFT483_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (LEFT483!=null?LEFT483.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 68 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1998:7: RIGHT
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					RIGHT484=(CommonTree)match(input,RIGHT,FOLLOW_RIGHT_in_eid6513); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RIGHT484_tree = (CommonTree)adaptor.dupNode(RIGHT484);


					adaptor.addChild(root_0, RIGHT484_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (RIGHT484!=null?RIGHT484.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 69 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1999:7: FULL
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					FULL485=(CommonTree)match(input,FULL,FOLLOW_FULL_in_eid6523); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FULL485_tree = (CommonTree)adaptor.dupNode(FULL485);


					adaptor.addChild(root_0, FULL485_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (FULL485!=null?FULL485.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 70 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2000:7: IDENTIFIER
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					IDENTIFIER486=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_eid6533); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IDENTIFIER486_tree = (CommonTree)adaptor.dupNode(IDENTIFIER486);


					adaptor.addChild(root_0, IDENTIFIER486_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (IDENTIFIER486!=null?IDENTIFIER486.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 71 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2001:7: TOBAG
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					TOBAG487=(CommonTree)match(input,TOBAG,FOLLOW_TOBAG_in_eid6543); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					TOBAG487_tree = (CommonTree)adaptor.dupNode(TOBAG487);


					adaptor.addChild(root_0, TOBAG487_tree);
					}

					if ( state.backtracking==0 ) { retval.id = "TOBAG"; }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 72 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2002:7: TOMAP
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					TOMAP488=(CommonTree)match(input,TOMAP,FOLLOW_TOMAP_in_eid6553); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					TOMAP488_tree = (CommonTree)adaptor.dupNode(TOMAP488);


					adaptor.addChild(root_0, TOMAP488_tree);
					}

					if ( state.backtracking==0 ) { retval.id = "TOMAP"; }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 73 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2003:7: TOTUPLE
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					TOTUPLE489=(CommonTree)match(input,TOTUPLE,FOLLOW_TOTUPLE_in_eid6563); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					TOTUPLE489_tree = (CommonTree)adaptor.dupNode(TOTUPLE489);


					adaptor.addChild(root_0, TOTUPLE489_tree);
					}

					if ( state.backtracking==0 ) { retval.id = "TOTUPLE"; }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 74 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2004:7: ASSERT
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					ASSERT490=(CommonTree)match(input,ASSERT,FOLLOW_ASSERT_in_eid6573); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ASSERT490_tree = (CommonTree)adaptor.dupNode(ASSERT490);


					adaptor.addChild(root_0, ASSERT490_tree);
					}

					if ( state.backtracking==0 ) { retval.id = "ASSERT"; }
					if ( state.backtracking==0 ) {
					}

					}
					break;

			}
			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class rel_op_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rel_op"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2008:1: rel_op : ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES );
	public final LogicalPlanGenerator.rel_op_return rel_op() throws RecognitionException {
		LogicalPlanGenerator.rel_op_return retval = new LogicalPlanGenerator.rel_op_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree STR_OP_MATCHES497=null;
		TreeRuleReturnScope rel_op_eq491 =null;
		TreeRuleReturnScope rel_op_ne492 =null;
		TreeRuleReturnScope rel_op_gt493 =null;
		TreeRuleReturnScope rel_op_gte494 =null;
		TreeRuleReturnScope rel_op_lt495 =null;
		TreeRuleReturnScope rel_op_lte496 =null;

		CommonTree STR_OP_MATCHES497_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2008:8: ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES )
			int alt133=7;
			switch ( input.LA(1) ) {
			case NUM_OP_EQ:
			case STR_OP_EQ:
				{
				alt133=1;
				}
				break;
			case NUM_OP_NE:
			case STR_OP_NE:
				{
				alt133=2;
				}
				break;
			case NUM_OP_GT:
			case STR_OP_GT:
				{
				alt133=3;
				}
				break;
			case NUM_OP_GTE:
			case STR_OP_GTE:
				{
				alt133=4;
				}
				break;
			case NUM_OP_LT:
			case STR_OP_LT:
				{
				alt133=5;
				}
				break;
			case NUM_OP_LTE:
			case STR_OP_LTE:
				{
				alt133=6;
				}
				break;
			case STR_OP_MATCHES:
				{
				alt133=7;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 133, 0, input);
				throw nvae;
			}
			switch (alt133) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2008:10: rel_op_eq
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_rel_op_eq_in_rel_op6586);
					rel_op_eq491=rel_op_eq();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, rel_op_eq491.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2009:10: rel_op_ne
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_rel_op_ne_in_rel_op6597);
					rel_op_ne492=rel_op_ne();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, rel_op_ne492.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2010:10: rel_op_gt
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_rel_op_gt_in_rel_op6608);
					rel_op_gt493=rel_op_gt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, rel_op_gt493.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 4 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2011:10: rel_op_gte
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_rel_op_gte_in_rel_op6619);
					rel_op_gte494=rel_op_gte();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, rel_op_gte494.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 5 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2012:10: rel_op_lt
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_rel_op_lt_in_rel_op6630);
					rel_op_lt495=rel_op_lt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, rel_op_lt495.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 6 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2013:10: rel_op_lte
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_rel_op_lte_in_rel_op6641);
					rel_op_lte496=rel_op_lte();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) 
					adaptor.addChild(root_0, rel_op_lte496.getTree());

					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 7 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2014:10: STR_OP_MATCHES
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					STR_OP_MATCHES497=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_rel_op6652); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STR_OP_MATCHES497_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES497);


					adaptor.addChild(root_0, STR_OP_MATCHES497_tree);
					}

					if ( state.backtracking==0 ) {
					}

					}
					break;

			}
			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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


	public static class rel_op_eq_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rel_op_eq"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2017:1: rel_op_eq : ( STR_OP_EQ | NUM_OP_EQ );
	public final LogicalPlanGenerator.rel_op_eq_return rel_op_eq() throws RecognitionException {
		LogicalPlanGenerator.rel_op_eq_return retval = new LogicalPlanGenerator.rel_op_eq_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree set498=null;

		CommonTree set498_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2017:11: ( STR_OP_EQ | NUM_OP_EQ )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			set498=(CommonTree)input.LT(1);
			if ( input.LA(1)==NUM_OP_EQ||input.LA(1)==STR_OP_EQ ) {
				input.consume();
				if ( state.backtracking==0 ) {
				set498_tree = (CommonTree)adaptor.dupNode(set498);


				adaptor.addChild(root_0, set498_tree);
				}

				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}

			if ( state.backtracking==0 ) {
			}
			 

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "rel_op_eq"


	public static class rel_op_ne_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rel_op_ne"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2020:1: rel_op_ne : ( STR_OP_NE | NUM_OP_NE );
	public final LogicalPlanGenerator.rel_op_ne_return rel_op_ne() throws RecognitionException {
		LogicalPlanGenerator.rel_op_ne_return retval = new LogicalPlanGenerator.rel_op_ne_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree set499=null;

		CommonTree set499_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2020:11: ( STR_OP_NE | NUM_OP_NE )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			set499=(CommonTree)input.LT(1);
			if ( input.LA(1)==NUM_OP_NE||input.LA(1)==STR_OP_NE ) {
				input.consume();
				if ( state.backtracking==0 ) {
				set499_tree = (CommonTree)adaptor.dupNode(set499);


				adaptor.addChild(root_0, set499_tree);
				}

				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}

			if ( state.backtracking==0 ) {
			}
			 

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "rel_op_ne"


	public static class rel_op_gt_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rel_op_gt"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2023:1: rel_op_gt : ( STR_OP_GT | NUM_OP_GT );
	public final LogicalPlanGenerator.rel_op_gt_return rel_op_gt() throws RecognitionException {
		LogicalPlanGenerator.rel_op_gt_return retval = new LogicalPlanGenerator.rel_op_gt_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree set500=null;

		CommonTree set500_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2023:11: ( STR_OP_GT | NUM_OP_GT )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			set500=(CommonTree)input.LT(1);
			if ( input.LA(1)==NUM_OP_GT||input.LA(1)==STR_OP_GT ) {
				input.consume();
				if ( state.backtracking==0 ) {
				set500_tree = (CommonTree)adaptor.dupNode(set500);


				adaptor.addChild(root_0, set500_tree);
				}

				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}

			if ( state.backtracking==0 ) {
			}
			 

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "rel_op_gt"


	public static class rel_op_gte_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rel_op_gte"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2026:1: rel_op_gte : ( STR_OP_GTE | NUM_OP_GTE );
	public final LogicalPlanGenerator.rel_op_gte_return rel_op_gte() throws RecognitionException {
		LogicalPlanGenerator.rel_op_gte_return retval = new LogicalPlanGenerator.rel_op_gte_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree set501=null;

		CommonTree set501_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2026:12: ( STR_OP_GTE | NUM_OP_GTE )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			set501=(CommonTree)input.LT(1);
			if ( input.LA(1)==NUM_OP_GTE||input.LA(1)==STR_OP_GTE ) {
				input.consume();
				if ( state.backtracking==0 ) {
				set501_tree = (CommonTree)adaptor.dupNode(set501);


				adaptor.addChild(root_0, set501_tree);
				}

				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}

			if ( state.backtracking==0 ) {
			}
			 

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "rel_op_gte"


	public static class rel_op_lt_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rel_op_lt"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2029:1: rel_op_lt : ( STR_OP_LT | NUM_OP_LT );
	public final LogicalPlanGenerator.rel_op_lt_return rel_op_lt() throws RecognitionException {
		LogicalPlanGenerator.rel_op_lt_return retval = new LogicalPlanGenerator.rel_op_lt_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree set502=null;

		CommonTree set502_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2029:11: ( STR_OP_LT | NUM_OP_LT )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			set502=(CommonTree)input.LT(1);
			if ( input.LA(1)==NUM_OP_LT||input.LA(1)==STR_OP_LT ) {
				input.consume();
				if ( state.backtracking==0 ) {
				set502_tree = (CommonTree)adaptor.dupNode(set502);


				adaptor.addChild(root_0, set502_tree);
				}

				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}

			if ( state.backtracking==0 ) {
			}
			 

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "rel_op_lt"


	public static class rel_op_lte_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rel_op_lte"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2032:1: rel_op_lte : ( STR_OP_LTE | NUM_OP_LTE );
	public final LogicalPlanGenerator.rel_op_lte_return rel_op_lte() throws RecognitionException {
		LogicalPlanGenerator.rel_op_lte_return retval = new LogicalPlanGenerator.rel_op_lte_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree set503=null;

		CommonTree set503_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2032:12: ( STR_OP_LTE | NUM_OP_LTE )
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			set503=(CommonTree)input.LT(1);
			if ( input.LA(1)==NUM_OP_LTE||input.LA(1)==STR_OP_LTE ) {
				input.consume();
				if ( state.backtracking==0 ) {
				set503_tree = (CommonTree)adaptor.dupNode(set503);


				adaptor.addChild(root_0, set503_tree);
				}

				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}

			if ( state.backtracking==0 ) {
			}
			 

			}

			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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
	// $ANTLR end "rel_op_lte"


	public static class rel_str_op_return extends TreeRuleReturnScope {
		public String id;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rel_str_op"
	// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2035:1: rel_str_op returns [String id] : ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES );
	public final LogicalPlanGenerator.rel_str_op_return rel_str_op() throws RecognitionException {
		LogicalPlanGenerator.rel_str_op_return retval = new LogicalPlanGenerator.rel_str_op_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree STR_OP_EQ504=null;
		CommonTree STR_OP_NE505=null;
		CommonTree STR_OP_GT506=null;
		CommonTree STR_OP_LT507=null;
		CommonTree STR_OP_GTE508=null;
		CommonTree STR_OP_LTE509=null;
		CommonTree STR_OP_MATCHES510=null;

		CommonTree STR_OP_EQ504_tree=null;
		CommonTree STR_OP_NE505_tree=null;
		CommonTree STR_OP_GT506_tree=null;
		CommonTree STR_OP_LT507_tree=null;
		CommonTree STR_OP_GTE508_tree=null;
		CommonTree STR_OP_LTE509_tree=null;
		CommonTree STR_OP_MATCHES510_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2036:2: ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES )
			int alt134=7;
			switch ( input.LA(1) ) {
			case STR_OP_EQ:
				{
				alt134=1;
				}
				break;
			case STR_OP_NE:
				{
				alt134=2;
				}
				break;
			case STR_OP_GT:
				{
				alt134=3;
				}
				break;
			case STR_OP_LT:
				{
				alt134=4;
				}
				break;
			case STR_OP_GTE:
				{
				alt134=5;
				}
				break;
			case STR_OP_LTE:
				{
				alt134=6;
				}
				break;
			case STR_OP_MATCHES:
				{
				alt134=7;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 134, 0, input);
				throw nvae;
			}
			switch (alt134) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2036:4: STR_OP_EQ
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					STR_OP_EQ504=(CommonTree)match(input,STR_OP_EQ,FOLLOW_STR_OP_EQ_in_rel_str_op6743); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STR_OP_EQ504_tree = (CommonTree)adaptor.dupNode(STR_OP_EQ504);


					adaptor.addChild(root_0, STR_OP_EQ504_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (STR_OP_EQ504!=null?STR_OP_EQ504.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2037:4: STR_OP_NE
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					STR_OP_NE505=(CommonTree)match(input,STR_OP_NE,FOLLOW_STR_OP_NE_in_rel_str_op6750); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STR_OP_NE505_tree = (CommonTree)adaptor.dupNode(STR_OP_NE505);


					adaptor.addChild(root_0, STR_OP_NE505_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (STR_OP_NE505!=null?STR_OP_NE505.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2038:4: STR_OP_GT
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					STR_OP_GT506=(CommonTree)match(input,STR_OP_GT,FOLLOW_STR_OP_GT_in_rel_str_op6757); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STR_OP_GT506_tree = (CommonTree)adaptor.dupNode(STR_OP_GT506);


					adaptor.addChild(root_0, STR_OP_GT506_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (STR_OP_GT506!=null?STR_OP_GT506.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 4 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2039:4: STR_OP_LT
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					STR_OP_LT507=(CommonTree)match(input,STR_OP_LT,FOLLOW_STR_OP_LT_in_rel_str_op6764); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STR_OP_LT507_tree = (CommonTree)adaptor.dupNode(STR_OP_LT507);


					adaptor.addChild(root_0, STR_OP_LT507_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (STR_OP_LT507!=null?STR_OP_LT507.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 5 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2040:4: STR_OP_GTE
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					STR_OP_GTE508=(CommonTree)match(input,STR_OP_GTE,FOLLOW_STR_OP_GTE_in_rel_str_op6771); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STR_OP_GTE508_tree = (CommonTree)adaptor.dupNode(STR_OP_GTE508);


					adaptor.addChild(root_0, STR_OP_GTE508_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (STR_OP_GTE508!=null?STR_OP_GTE508.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 6 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2041:4: STR_OP_LTE
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					STR_OP_LTE509=(CommonTree)match(input,STR_OP_LTE,FOLLOW_STR_OP_LTE_in_rel_str_op6778); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STR_OP_LTE509_tree = (CommonTree)adaptor.dupNode(STR_OP_LTE509);


					adaptor.addChild(root_0, STR_OP_LTE509_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (STR_OP_LTE509!=null?STR_OP_LTE509.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;
				case 7 :
					// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:2042:4: STR_OP_MATCHES
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					STR_OP_MATCHES510=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_rel_str_op6785); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					STR_OP_MATCHES510_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES510);


					adaptor.addChild(root_0, STR_OP_MATCHES510_tree);
					}

					if ( state.backtracking==0 ) { retval.id = (STR_OP_MATCHES510!=null?STR_OP_MATCHES510.getText():null); }
					if ( state.backtracking==0 ) {
					}

					}
					break;

			}
			if ( state.backtracking==0 ) {

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
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

	// $ANTLR start synpred147_LogicalPlanGenerator
	public final void synpred147_LogicalPlanGenerator_fragment() throws RecognitionException {
		// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1162:20: ( INTEGER )
		// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1162:20: INTEGER
		{
		match(input,INTEGER,FOLLOW_INTEGER_in_synpred147_LogicalPlanGenerator3650); if (state.failed) return;

		}

	}
	// $ANTLR end synpred147_LogicalPlanGenerator

	// $ANTLR start synpred148_LogicalPlanGenerator
	public final void synpred148_LogicalPlanGenerator_fragment() throws RecognitionException {
		// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1167:4: ( LONGINTEGER )
		// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1167:4: LONGINTEGER
		{
		match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_synpred148_LogicalPlanGenerator3660); if (state.failed) return;

		}

	}
	// $ANTLR end synpred148_LogicalPlanGenerator

	// $ANTLR start synpred149_LogicalPlanGenerator
	public final void synpred149_LogicalPlanGenerator_fragment() throws RecognitionException {
		// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1186:20: ( DOUBLENUMBER )
		// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1186:20: DOUBLENUMBER
		{
		match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_synpred149_LogicalPlanGenerator3712); if (state.failed) return;

		}

	}
	// $ANTLR end synpred149_LogicalPlanGenerator

	// $ANTLR start synpred179_LogicalPlanGenerator
	public final void synpred179_LogicalPlanGenerator_fragment() throws RecognitionException {
		// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1375:4: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item )
		// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1375:4: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
		{
		pushFollow(FOLLOW_join_item_in_synpred179_LogicalPlanGenerator4241);
		join_item();
		state._fsp--;
		if (state.failed) return;

		if ( input.LA(1)==FULL||input.LA(1)==LEFT||input.LA(1)==RIGHT ) {
			input.consume();
			state.errorRecovery=false;
			state.failed=false;
		}
		else {
			if (state.backtracking>0) {state.failed=true; return;}
			MismatchedSetException mse = new MismatchedSetException(null,input);
			throw mse;
		}

		// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1380:66: ( OUTER )?
		int alt149=2;
		int LA149_0 = input.LA(1);
		if ( (LA149_0==OUTER) ) {
			alt149=1;
		}
		switch (alt149) {
			case 1 :
				// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1380:66: OUTER
				{
				match(input,OUTER,FOLLOW_OUTER_in_synpred179_LogicalPlanGenerator4289); if (state.failed) return;

				}
				break;

		}

		pushFollow(FOLLOW_join_item_in_synpred179_LogicalPlanGenerator4292);
		join_item();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred179_LogicalPlanGenerator

	// $ANTLR start synpred196_LogicalPlanGenerator
	public final void synpred196_LogicalPlanGenerator_fragment() throws RecognitionException {
		// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1564:31: ( INTEGER )
		// src/main/java/org/qcri/rheem/latin/plan/logical/antlr/LogicalPlanGenerator.g:1564:31: INTEGER
		{
		match(input,INTEGER,FOLLOW_INTEGER_in_synpred196_LogicalPlanGenerator4864); if (state.failed) return;

		}

	}
	// $ANTLR end synpred196_LogicalPlanGenerator

	// Delegated rules

	public final boolean synpred149_LogicalPlanGenerator() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred149_LogicalPlanGenerator_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred179_LogicalPlanGenerator() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred179_LogicalPlanGenerator_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred147_LogicalPlanGenerator() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred147_LogicalPlanGenerator_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred196_LogicalPlanGenerator() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred196_LogicalPlanGenerator_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred148_LogicalPlanGenerator() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred148_LogicalPlanGenerator_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}




	// $ANTLR start "stream_cmd"
	// LogicalPlanGenerator.g4:292:1: stream_cmd[boolean in] returns [HandleSpec handleSpec] : ( ^( STDIN ( func_clause[ft] )? ) | ^( STDOUT ( func_clause[ft] )? ) | ^( QUOTEDSTRING ( func_clause[ft] )? ) );
	public final LogicalPlanGenerator.stream_cmd_return stream_cmd(boolean in) throws RecognitionException {
		LogicalPlanGenerator.stream_cmd_return retval = new LogicalPlanGenerator.stream_cmd_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree STDIN63=null;
		CommonTree STDOUT65=null;
		CommonTree QUOTEDSTRING67=null;
		TreeRuleReturnScope func_clause64 =null;
		TreeRuleReturnScope func_clause66 =null;
		TreeRuleReturnScope func_clause68 =null;

		CommonTree STDIN63_tree=null;
		CommonTree STDOUT65_tree=null;
		CommonTree QUOTEDSTRING67_tree=null;


		String handleName = null;
		String deserializer = "test" + "()";
		byte ft = in ? FunctionType.PIGTOSTREAMFUNC : FunctionType.STREAMTOPIGFUNC;

		try {
			// LogicalPlanGenerator.g4:304:2: ( ^( STDIN ( func_clause[ft] )? ) | ^( STDOUT ( func_clause[ft] )? ) | ^( QUOTEDSTRING ( func_clause[ft] )? ) )
			int alt15=3;
			switch ( input.LA(1) ) {
				case STDIN:
				{
					alt15=1;
				}
				break;
				case STDOUT:
				{
					alt15=2;
				}
				break;
				case QUOTEDSTRING:
				{
					alt15=3;
				}
				break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					NoViableAltException nvae =
							new NoViableAltException("", 15, 0, input);
					throw nvae;
			}
			switch (alt15) {
				case 1 :
					// LogicalPlanGenerator.g4:304:4: ^( STDIN ( func_clause[ft] )? )
				{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
						CommonTree _save_last_1 = _last;
						CommonTree _first_1 = null;
						CommonTree root_1 = (CommonTree)adaptor.nil();
						_last = (CommonTree)input.LT(1);
						STDIN63=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_stream_cmd783); if (state.failed) return retval;
						if ( state.backtracking==0 ) {
							STDIN63_tree = (CommonTree)adaptor.dupNode(STDIN63);


							root_1 = (CommonTree)adaptor.becomeRoot(STDIN63_tree, root_1);
						}

						if ( state.backtracking==0 ) { handleName = "stdin"; }
						if ( input.LA(1)==Token.DOWN ) {
							match(input, Token.DOWN, null); if (state.failed) return retval;
							// LogicalPlanGenerator.g4:305:7: ( func_clause[ft] )?
							int alt12=2;
							int LA12_0 = input.LA(1);
							if ( (LA12_0==FUNC||LA12_0==FUNC_REF) ) {
								alt12=1;
							}
							switch (alt12) {
								case 1 :
									// LogicalPlanGenerator.g4:305:9: func_clause[ft]
								{
									_last = (CommonTree)input.LT(1);
									pushFollow(FOLLOW_func_clause_in_stream_cmd795);
									func_clause64=func_clause(ft);
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 )
										adaptor.addChild(root_1, func_clause64.getTree());

									if ( state.backtracking==0 ) {
									}

								}
								break;

							}

							match(input, Token.UP, null); if (state.failed) return retval;
						}
						adaptor.addChild(root_0, root_1);
						_last = _save_last_1;
					}


					if ( state.backtracking==0 ) {
					}

				}
				break;
				case 2 :
					// LogicalPlanGenerator.g4:306:4: ^( STDOUT ( func_clause[ft] )? )
				{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
						CommonTree _save_last_1 = _last;
						CommonTree _first_1 = null;
						CommonTree root_1 = (CommonTree)adaptor.nil();
						_last = (CommonTree)input.LT(1);
						STDOUT65=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_stream_cmd810); if (state.failed) return retval;
						if ( state.backtracking==0 ) {
							STDOUT65_tree = (CommonTree)adaptor.dupNode(STDOUT65);


							root_1 = (CommonTree)adaptor.becomeRoot(STDOUT65_tree, root_1);
						}

						if ( state.backtracking==0 ) { handleName = "stdout"; }
						if ( input.LA(1)==Token.DOWN ) {
							match(input, Token.DOWN, null); if (state.failed) return retval;
							// LogicalPlanGenerator.g4:307:7: ( func_clause[ft] )?
							int alt13=2;
							int LA13_0 = input.LA(1);
							if ( (LA13_0==FUNC||LA13_0==FUNC_REF) ) {
								alt13=1;
							}
							switch (alt13) {
								case 1 :
									// LogicalPlanGenerator.g4:307:9: func_clause[ft]
								{
									_last = (CommonTree)input.LT(1);
									pushFollow(FOLLOW_func_clause_in_stream_cmd822);
									func_clause66=func_clause(ft);
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 )
										adaptor.addChild(root_1, func_clause66.getTree());

									if ( state.backtracking==0 ) {
									}

								}
								break;

							}

							match(input, Token.UP, null); if (state.failed) return retval;
						}
						adaptor.addChild(root_0, root_1);
						_last = _save_last_1;
					}


					if ( state.backtracking==0 ) {
					}

				}
				break;
				case 3 :
					// LogicalPlanGenerator.g4:308:4: ^( QUOTEDSTRING ( func_clause[ft] )? )
				{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
						CommonTree _save_last_1 = _last;
						CommonTree _first_1 = null;
						CommonTree root_1 = (CommonTree)adaptor.nil();
						_last = (CommonTree)input.LT(1);
						QUOTEDSTRING67=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_stream_cmd837); if (state.failed) return retval;
						if ( state.backtracking==0 ) {
							QUOTEDSTRING67_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING67);


							root_1 = (CommonTree)adaptor.becomeRoot(QUOTEDSTRING67_tree, root_1);
						}

						if ( state.backtracking==0 ) { handleName = builder.unquote( (QUOTEDSTRING67!=null?QUOTEDSTRING67.getText():null) ); }
						if ( input.LA(1)==Token.DOWN ) {
							match(input, Token.DOWN, null); if (state.failed) return retval;
							// LogicalPlanGenerator.g4:309:7: ( func_clause[ft] )?
							int alt14=2;
							int LA14_0 = input.LA(1);
							if ( (LA14_0==FUNC||LA14_0==FUNC_REF) ) {
								alt14=1;
							}
							switch (alt14) {
								case 1 :
									// LogicalPlanGenerator.g4:309:9: func_clause[ft]
								{
									_last = (CommonTree)input.LT(1);
									pushFollow(FOLLOW_func_clause_in_stream_cmd849);
									func_clause68=func_clause(ft);
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 )
										adaptor.addChild(root_1, func_clause68.getTree());

									if ( state.backtracking==0 ) {
									}

								}
								break;

							}

							match(input, Token.UP, null); if (state.failed) return retval;
						}
						adaptor.addChild(root_0, root_1);
						_last = _save_last_1;
					}


					if ( state.backtracking==0 ) {
					}

				}
				break;

			}
			if ( state.backtracking==0 ) {

				retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			}

			if ( state.backtracking==0 ) {
				retval.handleSpec = new HandleSpec( handleName, deserializer );
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



	public static final BitSet FOLLOW_QUERY_in_query87 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_query89 = new BitSet(new long[]{0x0000000000000408L,0x0020020000000000L,0x0012000000000000L});
	public static final BitSet FOLLOW_general_statement_in_statement111 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_split_statement_in_statement116 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_realias_statement_in_statement121 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assert_statement_in_statement126 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_register_statement_in_statement131 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_split_clause_in_split_statement140 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_realias_clause_in_realias_statement149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assert_clause_in_assert_statement158 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_REGISTER_in_register_statement169 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_QUOTEDSTRING_in_register_statement171 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_USING_in_register_statement174 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_register_statement176 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_AS_in_register_statement178 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_register_statement180 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_STATEMENT_in_general_statement199 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_alias_in_general_statement203 = new BitSet(new long[]{0x0048400226400400L,0x0C01010010004608L,0x0000000000000080L});
	public static final BitSet FOLLOW_op_clause_in_general_statement214 = new BitSet(new long[]{0x0000000000000008L,0x0000000100000000L});
	public static final BitSet FOLLOW_parallel_clause_in_general_statement216 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_REALIAS_in_realias_clause233 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_alias_in_realias_clause235 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_realias_clause237 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PARALLEL_in_parallel_clause256 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_INTEGER_in_parallel_clause258 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IDENTIFIER_in_alias276 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_define_clause_in_op_clause302 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_load_clause_in_op_clause316 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_group_clause_in_op_clause332 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_store_clause_in_op_clause348 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_filter_clause_in_op_clause364 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_distinct_clause_in_op_clause380 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_limit_clause_in_op_clause396 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_sample_clause_in_op_clause412 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_order_clause_in_op_clause428 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rank_clause_in_op_clause444 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cross_clause_in_op_clause460 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_join_clause_in_op_clause476 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_union_clause_in_op_clause492 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stream_clause_in_op_clause508 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mr_clause_in_op_clause524 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_foreach_clause_in_op_clause540 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cube_clause_in_op_clause556 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assert_clause_in_op_clause572 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DEFINE_in_define_clause586 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_alias_in_define_clause588 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_cmd_in_define_clause590 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DEFINE_in_define_clause605 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_alias_in_define_clause607 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000140000000L});
	public static final BitSet FOLLOW_func_clause_in_define_clause609 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EXECCOMMAND_in_cmd638 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ship_clause_in_cmd642 = new BitSet(new long[]{0x2000000000080008L,0x0084000080000000L});
	public static final BitSet FOLLOW_cache_clause_in_cmd647 = new BitSet(new long[]{0x2000000000080008L,0x0084000080000000L});
	public static final BitSet FOLLOW_input_clause_in_cmd652 = new BitSet(new long[]{0x2000000000080008L,0x0084000080000000L});
	public static final BitSet FOLLOW_output_clause_in_cmd656 = new BitSet(new long[]{0x2000000000080008L,0x0084000080000000L});
	public static final BitSet FOLLOW_error_clause_in_cmd660 = new BitSet(new long[]{0x2000000000080008L,0x0084000080000000L});
	public static final BitSet FOLLOW_SHIP_in_ship_clause683 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_path_list_in_ship_clause685 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_QUOTEDSTRING_in_path_list702 = new BitSet(new long[]{0x0000000000000002L,0x0000008000000000L});
	public static final BitSet FOLLOW_CACHE_in_cache_clause720 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_path_list_in_cache_clause722 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INPUT_in_input_clause745 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_stream_cmd_in_input_clause749 = new BitSet(new long[]{0x0000000000000008L,0x0300008000000000L});
	public static final BitSet FOLLOW_STDIN_in_stream_cmd783 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_func_clause_in_stream_cmd795 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_STDOUT_in_stream_cmd810 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_func_clause_in_stream_cmd822 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_QUOTEDSTRING_in_stream_cmd837 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_func_clause_in_stream_cmd849 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OUTPUT_in_output_clause877 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_stream_cmd_in_output_clause881 = new BitSet(new long[]{0x0000000000000008L,0x0300008000000000L});
	public static final BitSet FOLLOW_STDERROR_in_error_clause909 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_QUOTEDSTRING_in_error_clause919 = new BitSet(new long[]{0x8000000000000008L});
	public static final BitSet FOLLOW_INTEGER_in_error_clause941 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LOAD_in_load_clause994 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_filename_in_load_clause996 = new BitSet(new long[]{0x0000000000000108L,0x0000000000000000L,0x0000000140000000L});
	public static final BitSet FOLLOW_func_clause_in_load_clause998 = new BitSet(new long[]{0x0000000000000108L});
	public static final BitSet FOLLOW_as_clause_in_load_clause1002 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_QUOTEDSTRING_in_filename1022 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AS_in_as_clause1039 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_field_def_list_in_as_clause1041 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FIELD_DEF_in_field_def1069 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_field_def1071 = new BitSet(new long[]{0x4001002008255008L,0x0000000000000800L,0x0100020000002000L});
	public static final BitSet FOLLOW_type_in_field_def1075 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FIELD_DEF_WITHOUT_IDENTIFIER_in_field_def1094 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_field_def1098 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_field_def_in_field_def_list1129 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x000000000C000000L});
	public static final BitSet FOLLOW_simple_type_in_type1149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tuple_type_in_type1159 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_bag_type_in_type1169 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_map_type_in_type1179 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOLEAN_in_simple_type1197 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_simple_type1204 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LONG_in_simple_type1211 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOAT_in_simple_type1218 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLE_in_simple_type1225 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BIGINTEGER_in_simple_type1232 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BIGDECIMAL_in_simple_type1239 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DATETIME_in_simple_type1246 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHARARRAY_in_simple_type1253 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BYTEARRAY_in_simple_type1260 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TUPLE_TYPE_in_tuple_type1277 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_field_def_list_in_tuple_type1287 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BAG_TYPE_in_bag_type1327 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_bag_type1329 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_tuple_type_in_bag_type1332 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MAP_TYPE_in_map_type1355 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_map_type1357 = new BitSet(new long[]{0x4001002008255008L,0x0000000000000800L,0x0100020000002000L});
	public static final BitSet FOLLOW_type_in_map_type1360 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FUNC_REF_in_func_clause1389 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_func_name_in_func_clause1391 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FUNC_in_func_clause1405 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_func_name_in_func_clause1407 = new BitSet(new long[]{0x0000000000000008L,0x0000008000020000L});
	public static final BitSet FOLLOW_func_args_in_func_clause1409 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_eid_in_func_name1439 = new BitSet(new long[]{0x0000000800000002L,0x0000000800000000L});
	public static final BitSet FOLLOW_PERIOD_in_func_name1453 = new BitSet(new long[]{0x7779D022AE6F5F50L,0xFFA58C03D80C6E1DL,0x18E00000000001F7L});
	public static final BitSet FOLLOW_DOLLAR_in_func_name1459 = new BitSet(new long[]{0x7779D022AE6F5F50L,0xFFA58C03D80C6E1DL,0x18E00000000001F7L});
	public static final BitSet FOLLOW_eid_in_func_name1475 = new BitSet(new long[]{0x0000000800000002L,0x0000000800000000L});
	public static final BitSet FOLLOW_QUOTEDSTRING_in_func_args1504 = new BitSet(new long[]{0x0000000000000002L,0x0000008000020000L});
	public static final BitSet FOLLOW_MULTILINE_QUOTEDSTRING_in_func_args1514 = new BitSet(new long[]{0x0000000000000002L,0x0000008000020000L});
	public static final BitSet FOLLOW_CUBE_in_cube_clause1556 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_cube_item_in_cube_clause1558 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_rel_in_cube_item1575 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_cube_by_clause_in_cube_item1579 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BY_in_cube_by_clause1606 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_cube_or_rollup_in_cube_by_clause1608 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_cube_rollup_list_in_cube_or_rollup1631 = new BitSet(new long[]{0x0000000004000002L,0x0000800000000000L});
	public static final BitSet FOLLOW_CUBE_in_cube_rollup_list1661 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ROLLUP_in_cube_rollup_list1667 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_cube_by_expr_list_in_cube_rollup_list1673 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_cube_by_expr_in_cube_by_expr_list1697 = new BitSet(new long[]{0x814410540400A002L,0x0040009400089000L,0x04000C0283998020L});
	public static final BitSet FOLLOW_col_range_in_cube_by_expr1720 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_cube_by_expr1726 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STAR_in_cube_by_expr1732 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GROUP_in_group_clause1771 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_group_item_in_group_clause1773 = new BitSet(new long[]{0x0148400226400488L,0x0C01018210004608L,0x0000000000000080L});
	public static final BitSet FOLLOW_group_type_in_group_clause1778 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
	public static final BitSet FOLLOW_partition_clause_in_group_clause1785 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_COGROUP_in_group_clause1800 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_group_item_in_group_clause1802 = new BitSet(new long[]{0x0148400226400488L,0x0C01018210004608L,0x0000000000000080L});
	public static final BitSet FOLLOW_group_type_in_group_clause1807 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
	public static final BitSet FOLLOW_partition_clause_in_group_clause1814 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_QUOTEDSTRING_in_group_type1835 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rel_in_group_item1855 = new BitSet(new long[]{0x0000000000020010L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_join_group_by_clause_in_group_item1859 = new BitSet(new long[]{0x1000000000000002L,0x0000000040000000L});
	public static final BitSet FOLLOW_ALL_in_group_item1883 = new BitSet(new long[]{0x1000000000000002L,0x0000000040000000L});
	public static final BitSet FOLLOW_ANY_in_group_item1907 = new BitSet(new long[]{0x1000000000000002L,0x0000000040000000L});
	public static final BitSet FOLLOW_INNER_in_group_item1932 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OUTER_in_group_item1938 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_alias_in_rel1956 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_previous_rel_in_rel1966 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_inline_op_in_rel1976 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARROBA_in_previous_rel1988 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_op_clause_in_inline_op2010 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
	public static final BitSet FOLLOW_parallel_clause_in_inline_op2012 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_flatten_clause_in_flatten_generated_item2038 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x000000000C000000L});
	public static final BitSet FOLLOW_col_range_in_flatten_generated_item2048 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x000000000C000000L});
	public static final BitSet FOLLOW_expr_in_flatten_generated_item2056 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x000000000C000000L});
	public static final BitSet FOLLOW_STAR_in_flatten_generated_item2064 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x000000000C000000L});
	public static final BitSet FOLLOW_field_def_list_in_flatten_generated_item2083 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLATTEN_in_flatten_clause2101 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_flatten_clause2103 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_STORE_in_store_clause2121 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rel_in_store_clause2123 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_filename_in_store_clause2125 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000140000000L});
	public static final BitSet FOLLOW_func_clause_in_store_clause2127 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSERT_in_assert_clause2161 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rel_in_assert_clause2163 = new BitSet(new long[]{0x0800000000000040L,0xF00000000BFC0000L,0x0000000280040007L});
	public static final BitSet FOLLOW_cond_in_assert_clause2165 = new BitSet(new long[]{0x0000000000000008L,0x0000008000000000L});
	public static final BitSet FOLLOW_comment_in_assert_clause2168 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_QUOTEDSTRING_in_comment2189 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FILTER_in_filter_clause2216 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rel_in_filter_clause2218 = new BitSet(new long[]{0x0800000000000040L,0xF00000000BFC0000L,0x0000000280040007L});
	public static final BitSet FOLLOW_cond_in_filter_clause2220 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OR_in_cond2244 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_cond_in_cond2250 = new BitSet(new long[]{0x0800000000000040L,0xF00000000BFC0000L,0x0000000280040007L});
	public static final BitSet FOLLOW_cond_in_cond2257 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_AND_in_cond2272 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_cond_in_cond2278 = new BitSet(new long[]{0x0800000000000040L,0xF00000000BFC0000L,0x0000000280040007L});
	public static final BitSet FOLLOW_cond_in_cond2285 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NOT_in_cond2300 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_cond_in_cond2306 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NULL_in_cond2321 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_cond2323 = new BitSet(new long[]{0x0000000000000008L,0x0000000000040000L});
	public static final BitSet FOLLOW_NOT_in_cond2326 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_rel_op_eq_in_cond2341 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_cond2347 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
	public static final BitSet FOLLOW_expr_in_cond2354 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_rel_op_ne_in_cond2369 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_cond2375 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
	public static final BitSet FOLLOW_expr_in_cond2382 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_rel_op_lt_in_cond2397 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_cond2403 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
	public static final BitSet FOLLOW_expr_in_cond2410 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_rel_op_lte_in_cond2425 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_cond2431 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
	public static final BitSet FOLLOW_expr_in_cond2438 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_rel_op_gt_in_cond2453 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_cond2459 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
	public static final BitSet FOLLOW_expr_in_cond2466 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_rel_op_gte_in_cond2481 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_cond2487 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
	public static final BitSet FOLLOW_expr_in_cond2494 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_STR_OP_MATCHES_in_cond2509 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_cond2515 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
	public static final BitSet FOLLOW_expr_in_cond2522 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_in_eval_in_cond2535 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_func_eval_in_cond2546 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOL_COND_in_cond2559 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_cond2565 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IN_in_in_eval2594 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IN_LHS_in_in_eval2600 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_in_eval2606 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IN_RHS_in_in_eval2626 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_in_eval2632 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FUNC_EVAL_in_func_eval2669 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_func_name_in_func_eval2671 = new BitSet(new long[]{0x814410540400A008L,0x0040009400089000L,0x04000C0283998020L});
	public static final BitSet FOLLOW_real_arg_in_func_eval2675 = new BitSet(new long[]{0x814410540400A008L,0x0040009400089000L,0x04000C0283998020L});
	public static final BitSet FOLLOW_INVOKER_FUNC_EVAL_in_func_eval2695 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_func_eval2699 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_func_eval2703 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_func_eval2707 = new BitSet(new long[]{0x814410540400A008L,0x0040009400089000L,0x04000C0283998020L});
	public static final BitSet FOLLOW_real_arg_in_func_eval2711 = new BitSet(new long[]{0x814410540400A008L,0x0040009400089000L,0x04000C0283998020L});
	public static final BitSet FOLLOW_expr_in_real_arg2743 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STAR_in_real_arg2751 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_col_range_in_real_arg2765 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_expr2784 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr2790 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
	public static final BitSet FOLLOW_expr_in_expr2797 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expr2812 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr2818 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
	public static final BitSet FOLLOW_expr_in_expr2825 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_STAR_in_expr2840 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr2846 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
	public static final BitSet FOLLOW_expr_in_expr2853 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DIV_in_expr2868 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr2874 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
	public static final BitSet FOLLOW_expr_in_expr2881 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PERCENT_in_expr2896 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr2902 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
	public static final BitSet FOLLOW_expr_in_expr2909 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_const_expr_in_expr2922 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_expr_in_expr2933 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEG_in_expr2946 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr2952 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CAST_EXPR_in_expr2967 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_cast_in_expr2969 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
	public static final BitSet FOLLOW_expr_in_expr2975 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EXPR_IN_PAREN_in_expr2991 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr2997 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_simple_type_in_type_cast3019 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_map_type_in_type_cast3029 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tuple_type_cast_in_type_cast3039 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_bag_type_cast_in_type_cast3049 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast3074 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_cast_in_tuple_type_cast3078 = new BitSet(new long[]{0x4001002008255008L,0x0000000000000800L,0x0200020000004000L});
	public static final BitSet FOLLOW_BAG_TYPE_CAST_in_bag_type_cast3105 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_tuple_type_cast_in_bag_type_cast3107 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_projectable_expr_in_var_expr3134 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_dot_proj_in_var_expr3144 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_pound_proj_in_var_expr3158 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
	public static final BitSet FOLLOW_func_eval_in_projectable_expr3188 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_col_ref_in_projectable_expr3199 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_bin_expr_in_projectable_expr3210 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_case_expr_in_projectable_expr3221 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_case_cond_in_projectable_expr3232 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PERIOD_in_dot_proj3258 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_col_alias_or_index_in_dot_proj3262 = new BitSet(new long[]{0x0140001004000008L});
	public static final BitSet FOLLOW_col_alias_in_col_alias_or_index3282 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_col_index_in_col_alias_or_index3288 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GROUP_in_col_alias3303 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CUBE_in_col_alias3310 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_col_alias3317 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOLLARVAR_in_col_index3332 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COL_RANGE_in_col_range3351 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_col_ref_in_col_range3358 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_DOUBLE_PERIOD_in_col_range3363 = new BitSet(new long[]{0x0140001004000008L});
	public static final BitSet FOLLOW_col_ref_in_col_range3370 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_POUND_in_pound_proj3396 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_QUOTEDSTRING_in_pound_proj3400 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NULL_in_pound_proj3406 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BIN_EXPR_in_bin_expr3426 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_cond_in_bin_expr3428 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
	public static final BitSet FOLLOW_expr_in_bin_expr3435 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
	public static final BitSet FOLLOW_expr_in_bin_expr3442 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CASE_EXPR_in_case_expr3471 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_CASE_EXPR_LHS_in_case_expr3479 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_case_expr3485 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CASE_EXPR_RHS_in_case_expr3516 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_case_expr3522 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CASE_COND_in_case_cond3562 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_WHEN_in_case_cond3566 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_cond_in_case_cond3570 = new BitSet(new long[]{0x0800000000000048L,0xF00000000BFC0000L,0x0000000280040007L});
	public static final BitSet FOLLOW_THEN_in_case_cond3598 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_case_cond3602 = new BitSet(new long[]{0x814410540400A008L,0x0040009400089000L,0x04000C0282998020L});
	public static final BitSet FOLLOW_LIMIT_in_limit_clause3644 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rel_in_limit_clause3646 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
	public static final BitSet FOLLOW_INTEGER_in_limit_clause3650 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LONGINTEGER_in_limit_clause3660 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_expr_in_limit_clause3670 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_SAMPLE_in_sample_clause3706 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rel_in_sample_clause3708 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
	public static final BitSet FOLLOW_DOUBLENUMBER_in_sample_clause3712 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_expr_in_sample_clause3722 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RANK_in_rank_clause3768 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rel_in_rank_clause3770 = new BitSet(new long[]{0x0000000000020008L});
	public static final BitSet FOLLOW_rank_by_statement_in_rank_clause3772 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BY_in_rank_by_statement3798 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rank_by_clause_in_rank_by_statement3800 = new BitSet(new long[]{0x0000000040000008L});
	public static final BitSet FOLLOW_DENSE_in_rank_by_statement3804 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_STAR_in_rank_by_clause3833 = new BitSet(new long[]{0x0000000080000202L});
	public static final BitSet FOLLOW_ASC_in_rank_by_clause3842 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DESC_in_rank_by_clause3848 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rank_col_in_rank_by_clause3860 = new BitSet(new long[]{0x0140001004000002L,0x0000000000000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_col_range_in_rank_col3886 = new BitSet(new long[]{0x0000000080000202L});
	public static final BitSet FOLLOW_ASC_in_rank_col3890 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DESC_in_rank_col3894 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_col_ref_in_rank_col3904 = new BitSet(new long[]{0x0000000080000202L});
	public static final BitSet FOLLOW_ASC_in_rank_col3909 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DESC_in_rank_col3913 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ORDER_in_order_clause3943 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rel_in_order_clause3945 = new BitSet(new long[]{0x0140001004000000L,0x0040000000000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_order_by_clause_in_order_clause3947 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000140000000L});
	public static final BitSet FOLLOW_func_clause_in_order_clause3949 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_STAR_in_order_by_clause3976 = new BitSet(new long[]{0x0000000080000202L});
	public static final BitSet FOLLOW_ASC_in_order_by_clause3985 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DESC_in_order_by_clause3991 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_order_col_in_order_by_clause4003 = new BitSet(new long[]{0x0140001004000002L,0x0000000000000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_col_range_in_order_col4029 = new BitSet(new long[]{0x0000000080000202L});
	public static final BitSet FOLLOW_ASC_in_order_col4033 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DESC_in_order_col4037 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_col_ref_in_order_col4047 = new BitSet(new long[]{0x0000000080000202L});
	public static final BitSet FOLLOW_ASC_in_order_col4052 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DESC_in_order_col4056 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DISTINCT_in_distinct_clause4076 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rel_in_distinct_clause4078 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
	public static final BitSet FOLLOW_partition_clause_in_distinct_clause4080 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PARTITION_in_partition_clause4103 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_func_name_in_partition_clause4105 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CROSS_in_cross_clause4127 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rel_list_in_cross_clause4129 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
	public static final BitSet FOLLOW_partition_clause_in_cross_clause4131 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_rel_in_rel_list4159 = new BitSet(new long[]{0x0148400226400482L,0x0C01010010004608L,0x0000000000000080L});
	public static final BitSet FOLLOW_JOIN_in_join_clause4198 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_join_sub_clause_in_join_clause4200 = new BitSet(new long[]{0x0000000000000008L,0x0000008200000000L});
	public static final BitSet FOLLOW_join_type_in_join_clause4202 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
	public static final BitSet FOLLOW_partition_clause_in_join_clause4205 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_QUOTEDSTRING_in_join_type4226 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_join_item_in_join_sub_clause4241 = new BitSet(new long[]{0x0010000000000000L,0x0000080000000010L});
	public static final BitSet FOLLOW_LEFT_in_join_sub_clause4245 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_RIGHT_in_join_sub_clause4264 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_FULL_in_join_sub_clause4283 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_OUTER_in_join_sub_clause4289 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_join_item_in_join_sub_clause4292 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_join_item_in_join_sub_clause4302 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_JOIN_ITEM_in_join_item4315 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rel_in_join_item4317 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_join_group_by_clause_in_join_item4319 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BY_in_join_group_by_clause4346 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_join_group_by_expr_in_join_group_by_clause4350 = new BitSet(new long[]{0x814410540400A008L,0x0040009400089000L,0x04000C0283998020L});
	public static final BitSet FOLLOW_col_range_in_join_group_by_expr4375 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_join_group_by_expr4381 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STAR_in_join_group_by_expr4387 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UNION_in_union_clause4412 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ONSCHEMA_in_union_clause4416 = new BitSet(new long[]{0x0148400226400480L,0x0C01010010004608L,0x0000000000000080L});
	public static final BitSet FOLLOW_rel_list_in_union_clause4423 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FOREACH_in_foreach_clause4459 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rel_in_foreach_clause4461 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000030000000L});
	public static final BitSet FOLLOW_foreach_plan_in_foreach_clause4463 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan4499 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_generate_clause_in_foreach_plan4501 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan4510 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_nested_blk_in_foreach_plan4512 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_nested_command_in_nested_blk4523 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000000L,0x0000300000000000L});
	public static final BitSet FOLLOW_generate_clause_in_nested_blk4526 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NESTED_CMD_in_nested_command4548 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_nested_command4550 = new BitSet(new long[]{0x0008400202000000L,0x0000000010000200L,0x0000400000000000L});
	public static final BitSet FOLLOW_nested_op_in_nested_command4552 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NESTED_CMD_ASSI_in_nested_command4570 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_nested_command4572 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
	public static final BitSet FOLLOW_expr_in_nested_command4574 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_nested_proj_in_nested_op4596 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nested_filter_in_nested_op4604 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nested_sort_in_nested_op4612 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nested_distinct_in_nested_op4621 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nested_limit_in_nested_op4629 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nested_cross_in_nested_op4637 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nested_foreach_in_nested_op4645 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NESTED_PROJ_in_nested_proj4669 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_col_ref_in_nested_proj4681 = new BitSet(new long[]{0x0140001004000000L});
	public static final BitSet FOLLOW_col_ref_in_nested_proj4696 = new BitSet(new long[]{0x0140001004000008L});
	public static final BitSet FOLLOW_FILTER_in_nested_filter4749 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_nested_op_input_in_nested_filter4751 = new BitSet(new long[]{0x0800000000000040L,0xF00000000BFC0000L,0x0000000280040007L});
	public static final BitSet FOLLOW_cond_in_nested_filter4753 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ORDER_in_nested_sort4787 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_nested_op_input_in_nested_sort4789 = new BitSet(new long[]{0x0140001004000000L,0x0040000000000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_order_by_clause_in_nested_sort4791 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000140000000L});
	public static final BitSet FOLLOW_func_clause_in_nested_sort4793 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DISTINCT_in_nested_distinct4823 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_nested_op_input_in_nested_distinct4825 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LIMIT_in_nested_limit4858 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_nested_op_input_in_nested_limit4860 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
	public static final BitSet FOLLOW_INTEGER_in_nested_limit4864 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_expr_in_nested_limit4874 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CROSS_in_nested_cross4907 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_nested_op_input_list_in_nested_cross4909 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FOREACH_in_nested_foreach4941 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_nested_op_input_in_nested_foreach4943 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_generate_clause_in_nested_foreach4945 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_GENERATE_in_generate_clause4974 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_flatten_generated_item_in_generate_clause4978 = new BitSet(new long[]{0x814490540400A008L,0x0040009400089000L,0x04000C0283998020L});
	public static final BitSet FOLLOW_col_ref_in_nested_op_input5044 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nested_proj_in_nested_op_input5055 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nested_op_input_in_nested_op_input_list5081 = new BitSet(new long[]{0x0140001004000002L,0x0000000000000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_STREAM_in_stream_clause5106 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rel_in_stream_clause5108 = new BitSet(new long[]{0x0100080000000000L});
	public static final BitSet FOLLOW_EXECCOMMAND_in_stream_clause5112 = new BitSet(new long[]{0x0000000000000108L});
	public static final BitSet FOLLOW_IDENTIFIER_in_stream_clause5135 = new BitSet(new long[]{0x0000000000000108L});
	public static final BitSet FOLLOW_as_clause_in_stream_clause5177 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MAPREDUCE_in_mr_clause5205 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_QUOTEDSTRING_in_mr_clause5207 = new BitSet(new long[]{0x0000000000000000L,0x0400008000000000L});
	public static final BitSet FOLLOW_path_list_in_mr_clause5209 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
	public static final BitSet FOLLOW_store_clause_in_mr_clause5220 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
	public static final BitSet FOLLOW_load_clause_in_mr_clause5229 = new BitSet(new long[]{0x0000080000000008L});
	public static final BitSet FOLLOW_EXECCOMMAND_in_mr_clause5236 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_SPLIT_in_split_clause5256 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rel_in_split_clause5264 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_split_branch_in_split_clause5280 = new BitSet(new long[]{0x0000000000000008L,0x0000000020000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_split_otherwise_in_split_clause5283 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_SPLIT_BRANCH_in_split_branch5312 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_alias_in_split_branch5314 = new BitSet(new long[]{0x0800000000000040L,0xF00000000BFC0000L,0x0000000280040007L});
	public static final BitSet FOLLOW_cond_in_split_branch5316 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OTHERWISE_in_split_otherwise5350 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_alias_in_split_otherwise5352 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_alias_col_ref_in_col_ref5372 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dollar_col_ref_in_col_ref5380 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GROUP_in_alias_col_ref5397 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CUBE_in_alias_col_ref5407 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_alias_col_ref5417 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOLLARVAR_in_dollar_col_ref5436 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_literal_in_const_expr5455 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_scalar_in_literal5473 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_map_in_literal5483 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_bag_in_literal5493 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tuple_in_literal5503 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_num_scalar_in_scalar5521 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QUOTEDSTRING_in_scalar5531 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NULL_in_scalar5541 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_scalar5551 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_scalar5561 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_num_scalar5586 = new BitSet(new long[]{0x800400400000A000L,0x0000000000001000L});
	public static final BitSet FOLLOW_INTEGER_in_num_scalar5599 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LONGINTEGER_in_num_scalar5613 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOATNUMBER_in_num_scalar5627 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLENUMBER_in_num_scalar5641 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BIGINTEGERNUMBER_in_num_scalar5655 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BIGDECIMALNUMBER_in_num_scalar5669 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAP_VAL_in_map5701 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_keyvalue_in_map5705 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000002000000000L});
	public static final BitSet FOLLOW_KEY_VAL_PAIR_in_keyvalue5732 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_map_key_in_keyvalue5734 = new BitSet(new long[]{0x800410400000A000L,0x0000008000089000L,0x0400040000008020L});
	public static final BitSet FOLLOW_literal_in_keyvalue5736 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_QUOTEDSTRING_in_map_key5756 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BAG_VAL_in_bag5778 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_tuple_in_bag5782 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0400000000000000L});
	public static final BitSet FOLLOW_TUPLE_VAL_in_tuple5814 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_literal_in_tuple5818 = new BitSet(new long[]{0x800410400000A008L,0x0000008000089000L,0x0400040000008020L});
	public static final BitSet FOLLOW_rel_str_op_in_eid5843 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IMPORT_in_eid5853 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RETURNS_in_eid5863 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DEFINE_in_eid5873 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LOAD_in_eid5883 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FILTER_in_eid5893 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOREACH_in_eid5903 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MATCHES_in_eid5913 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ORDER_in_eid5923 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DISTINCT_in_eid5933 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COGROUP_in_eid5943 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CUBE_in_eid5953 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ROLLUP_in_eid5963 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_JOIN_in_eid5973 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CROSS_in_eid5983 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UNION_in_eid5993 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SPLIT_in_eid6003 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTO_in_eid6013 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_eid6023 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ALL_in_eid6033 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AS_in_eid6043 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BY_in_eid6053 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_USING_in_eid6063 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INNER_in_eid6073 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OUTER_in_eid6083 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PARALLEL_in_eid6093 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PARTITION_in_eid6103 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GROUP_in_eid6113 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AND_in_eid6123 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OR_in_eid6133 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_eid6143 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GENERATE_in_eid6153 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLATTEN_in_eid6163 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EVAL_in_eid6173 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASC_in_eid6183 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DESC_in_eid6193 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOLEAN_in_eid6203 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_eid6213 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LONG_in_eid6223 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOAT_in_eid6233 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLE_in_eid6243 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BIGINTEGER_in_eid6253 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BIGDECIMAL_in_eid6263 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DATETIME_in_eid6273 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHARARRAY_in_eid6283 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BYTEARRAY_in_eid6293 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BAG_in_eid6303 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TUPLE_in_eid6313 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAP_in_eid6323 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IS_in_eid6333 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NULL_in_eid6343 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_eid6353 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_eid6363 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STREAM_in_eid6373 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_THROUGH_in_eid6383 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STORE_in_eid6393 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAPREDUCE_in_eid6403 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHIP_in_eid6413 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CACHE_in_eid6423 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INPUT_in_eid6433 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OUTPUT_in_eid6443 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STDERROR_in_eid6453 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STDIN_in_eid6463 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STDOUT_in_eid6473 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LIMIT_in_eid6483 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SAMPLE_in_eid6493 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFT_in_eid6503 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RIGHT_in_eid6513 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FULL_in_eid6523 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_eid6533 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TOBAG_in_eid6543 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TOMAP_in_eid6553 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TOTUPLE_in_eid6563 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSERT_in_eid6573 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rel_op_eq_in_rel_op6586 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rel_op_ne_in_rel_op6597 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rel_op_gt_in_rel_op6608 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rel_op_gte_in_rel_op6619 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rel_op_lt_in_rel_op6630 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rel_op_lte_in_rel_op6641 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STR_OP_MATCHES_in_rel_op6652 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STR_OP_EQ_in_rel_str_op6743 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STR_OP_NE_in_rel_str_op6750 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STR_OP_GT_in_rel_str_op6757 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STR_OP_LT_in_rel_str_op6764 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STR_OP_GTE_in_rel_str_op6771 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STR_OP_LTE_in_rel_str_op6778 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STR_OP_MATCHES_in_rel_str_op6785 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_synpred147_LogicalPlanGenerator3650 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LONGINTEGER_in_synpred148_LogicalPlanGenerator3660 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLENUMBER_in_synpred149_LogicalPlanGenerator3712 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_join_item_in_synpred179_LogicalPlanGenerator4241 = new BitSet(new long[]{0x0010000000000000L,0x0000080000000010L});
	public static final BitSet FOLLOW_set_in_synpred179_LogicalPlanGenerator4243 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_OUTER_in_synpred179_LogicalPlanGenerator4289 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_join_item_in_synpred179_LogicalPlanGenerator4292 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_synpred196_LogicalPlanGenerator4864 = new BitSet(new long[]{0x0000000000000002L});
}
