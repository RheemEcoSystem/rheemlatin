// $ANTLR 3.5.2 src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g 2017-03-21 19:37:26

package org.qcri.rheem.latin.expression;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.TreeAdaptor;


@SuppressWarnings("all")
public class Valid2Parser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND_RW", "COLON", "COMMA", "DIGIT", 
		"DOT", "EQUAL", "FALSE_LITERAL", "GR", "GR_EQUAL", "IDENT", "LE", "LEFT_BRACE", 
		"LEFT_BRACKET", "LEFT_PAREN", "LETTER", "LE_EQUAL", "MOD", "NOT_EQUAL", 
		"NUMBER", "OR_RW", "PLUS", "RIGHT_BRACE", "RIGHT_BRACKET", "RIGHT_PAREN", 
		"SEMICOLON", "SLASH", "STAR", "SUB", "TRUE_LITERAL", "UNDERSCORE", "WS", 
		"NOT_RW"
	};
	public static final int EOF=-1;
	public static final int AND_RW=4;
	public static final int COLON=5;
	public static final int COMMA=6;
	public static final int DIGIT=7;
	public static final int DOT=8;
	public static final int EQUAL=9;
	public static final int FALSE_LITERAL=10;
	public static final int GR=11;
	public static final int GR_EQUAL=12;
	public static final int IDENT=13;
	public static final int LE=14;
	public static final int LEFT_BRACE=15;
	public static final int LEFT_BRACKET=16;
	public static final int LEFT_PAREN=17;
	public static final int LETTER=18;
	public static final int LE_EQUAL=19;
	public static final int MOD=20;
	public static final int NOT_EQUAL=21;
	public static final int NUMBER=22;
	public static final int OR_RW=23;
	public static final int PLUS=24;
	public static final int RIGHT_BRACE=25;
	public static final int RIGHT_BRACKET=26;
	public static final int RIGHT_PAREN=27;
	public static final int SEMICOLON=28;
	public static final int SLASH=29;
	public static final int STAR=30;
	public static final int SUB=31;
	public static final int TRUE_LITERAL=32;
	public static final int UNDERSCORE=33;
	public static final int WS=34;
	public static final int NOT_RW=35;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public Valid2Parser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public Valid2Parser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return Valid2Parser.tokenNames; }
	@Override public String getGrammarFileName() { return "src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g"; }


	public static class base_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "base"
	// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:21:1: base : expr EOF ;
	public final Valid2Parser.base_return base() throws RecognitionException {
		Valid2Parser.base_return retval = new Valid2Parser.base_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token EOF2=null;
		ParserRuleReturnScope expr1 =null;

		Object EOF2_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:21:15: ( expr EOF )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:21:17: expr EOF
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_expr_in_base68);
			expr1=expr();
			state._fsp--;

			adaptor.addChild(root_0, expr1.getTree());

			EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_base70); 
			EOF2_tree = (Object)adaptor.create(EOF2);
			adaptor.addChild(root_0, EOF2_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "base"


	public static class expr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr"
	// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:23:1: expr : expAND ( OR_RW ^ expAND )* ;
	public final Valid2Parser.expr_return expr() throws RecognitionException {
		Valid2Parser.expr_return retval = new Valid2Parser.expr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token OR_RW4=null;
		ParserRuleReturnScope expAND3 =null;
		ParserRuleReturnScope expAND5 =null;

		Object OR_RW4_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:23:15: ( expAND ( OR_RW ^ expAND )* )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:23:18: expAND ( OR_RW ^ expAND )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_expAND_in_expr88);
			expAND3=expAND();
			state._fsp--;

			adaptor.addChild(root_0, expAND3.getTree());

			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:23:26: ( OR_RW ^ expAND )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==OR_RW) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:23:27: OR_RW ^ expAND
					{
					OR_RW4=(Token)match(input,OR_RW,FOLLOW_OR_RW_in_expr92); 
					OR_RW4_tree = (Object)adaptor.create(OR_RW4);
					root_0 = (Object)adaptor.becomeRoot(OR_RW4_tree, root_0);

					pushFollow(FOLLOW_expAND_in_expr95);
					expAND5=expAND();
					state._fsp--;

					adaptor.addChild(root_0, expAND5.getTree());

					}
					break;

				default :
					break loop1;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr"


	public static class expAND_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expAND"
	// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:25:1: expAND : expCons ( AND_RW ^ expCons )* ;
	public final Valid2Parser.expAND_return expAND() throws RecognitionException {
		Valid2Parser.expAND_return retval = new Valid2Parser.expAND_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token AND_RW7=null;
		ParserRuleReturnScope expCons6 =null;
		ParserRuleReturnScope expCons8 =null;

		Object AND_RW7_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:25:15: ( expCons ( AND_RW ^ expCons )* )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:25:18: expCons ( AND_RW ^ expCons )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_expCons_in_expAND113);
			expCons6=expCons();
			state._fsp--;

			adaptor.addChild(root_0, expCons6.getTree());

			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:25:26: ( AND_RW ^ expCons )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==AND_RW) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:25:27: AND_RW ^ expCons
					{
					AND_RW7=(Token)match(input,AND_RW,FOLLOW_AND_RW_in_expAND116); 
					AND_RW7_tree = (Object)adaptor.create(AND_RW7);
					root_0 = (Object)adaptor.becomeRoot(AND_RW7_tree, root_0);

					pushFollow(FOLLOW_expCons_in_expAND119);
					expCons8=expCons();
					state._fsp--;

					adaptor.addChild(root_0, expCons8.getTree());

					}
					break;

				default :
					break loop2;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expAND"


	public static class expCons_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expCons"
	// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:27:1: expCons : expSum ( ( EQUAL ^| LE_EQUAL ^| GR_EQUAL ^| NOT_EQUAL ^| GR ^| LE ^) expSum )* ;
	public final Valid2Parser.expCons_return expCons() throws RecognitionException {
		Valid2Parser.expCons_return retval = new Valid2Parser.expCons_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token EQUAL10=null;
		Token LE_EQUAL11=null;
		Token GR_EQUAL12=null;
		Token NOT_EQUAL13=null;
		Token GR14=null;
		Token LE15=null;
		ParserRuleReturnScope expSum9 =null;
		ParserRuleReturnScope expSum16 =null;

		Object EQUAL10_tree=null;
		Object LE_EQUAL11_tree=null;
		Object GR_EQUAL12_tree=null;
		Object NOT_EQUAL13_tree=null;
		Object GR14_tree=null;
		Object LE15_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:27:15: ( expSum ( ( EQUAL ^| LE_EQUAL ^| GR_EQUAL ^| NOT_EQUAL ^| GR ^| LE ^) expSum )* )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:27:18: expSum ( ( EQUAL ^| LE_EQUAL ^| GR_EQUAL ^| NOT_EQUAL ^| GR ^| LE ^) expSum )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_expSum_in_expCons136);
			expSum9=expSum();
			state._fsp--;

			adaptor.addChild(root_0, expSum9.getTree());

			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:27:26: ( ( EQUAL ^| LE_EQUAL ^| GR_EQUAL ^| NOT_EQUAL ^| GR ^| LE ^) expSum )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==EQUAL||(LA4_0 >= GR && LA4_0 <= GR_EQUAL)||LA4_0==LE||LA4_0==LE_EQUAL||LA4_0==NOT_EQUAL) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:27:27: ( EQUAL ^| LE_EQUAL ^| GR_EQUAL ^| NOT_EQUAL ^| GR ^| LE ^) expSum
					{
					// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:27:27: ( EQUAL ^| LE_EQUAL ^| GR_EQUAL ^| NOT_EQUAL ^| GR ^| LE ^)
					int alt3=6;
					switch ( input.LA(1) ) {
					case EQUAL:
						{
						alt3=1;
						}
						break;
					case LE_EQUAL:
						{
						alt3=2;
						}
						break;
					case GR_EQUAL:
						{
						alt3=3;
						}
						break;
					case NOT_EQUAL:
						{
						alt3=4;
						}
						break;
					case GR:
						{
						alt3=5;
						}
						break;
					case LE:
						{
						alt3=6;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 3, 0, input);
						throw nvae;
					}
					switch (alt3) {
						case 1 :
							// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:27:28: EQUAL ^
							{
							EQUAL10=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_expCons141); 
							EQUAL10_tree = (Object)adaptor.create(EQUAL10);
							root_0 = (Object)adaptor.becomeRoot(EQUAL10_tree, root_0);

							}
							break;
						case 2 :
							// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:28:28: LE_EQUAL ^
							{
							LE_EQUAL11=(Token)match(input,LE_EQUAL,FOLLOW_LE_EQUAL_in_expCons172); 
							LE_EQUAL11_tree = (Object)adaptor.create(LE_EQUAL11);
							root_0 = (Object)adaptor.becomeRoot(LE_EQUAL11_tree, root_0);

							}
							break;
						case 3 :
							// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:29:28: GR_EQUAL ^
							{
							GR_EQUAL12=(Token)match(input,GR_EQUAL,FOLLOW_GR_EQUAL_in_expCons203); 
							GR_EQUAL12_tree = (Object)adaptor.create(GR_EQUAL12);
							root_0 = (Object)adaptor.becomeRoot(GR_EQUAL12_tree, root_0);

							}
							break;
						case 4 :
							// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:30:28: NOT_EQUAL ^
							{
							NOT_EQUAL13=(Token)match(input,NOT_EQUAL,FOLLOW_NOT_EQUAL_in_expCons234); 
							NOT_EQUAL13_tree = (Object)adaptor.create(NOT_EQUAL13);
							root_0 = (Object)adaptor.becomeRoot(NOT_EQUAL13_tree, root_0);

							}
							break;
						case 5 :
							// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:31:28: GR ^
							{
							GR14=(Token)match(input,GR,FOLLOW_GR_in_expCons265); 
							GR14_tree = (Object)adaptor.create(GR14);
							root_0 = (Object)adaptor.becomeRoot(GR14_tree, root_0);

							}
							break;
						case 6 :
							// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:32:28: LE ^
							{
							LE15=(Token)match(input,LE,FOLLOW_LE_in_expCons296); 
							LE15_tree = (Object)adaptor.create(LE15);
							root_0 = (Object)adaptor.becomeRoot(LE15_tree, root_0);

							}
							break;

					}

					pushFollow(FOLLOW_expSum_in_expCons300);
					expSum16=expSum();
					state._fsp--;

					adaptor.addChild(root_0, expSum16.getTree());

					}
					break;

				default :
					break loop4;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expCons"


	public static class expSum_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expSum"
	// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:34:1: expSum : expProduct ( ( PLUS ^| SUB ^) expProduct )* ;
	public final Valid2Parser.expSum_return expSum() throws RecognitionException {
		Valid2Parser.expSum_return retval = new Valid2Parser.expSum_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token PLUS18=null;
		Token SUB19=null;
		ParserRuleReturnScope expProduct17 =null;
		ParserRuleReturnScope expProduct20 =null;

		Object PLUS18_tree=null;
		Object SUB19_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:34:15: ( expProduct ( ( PLUS ^| SUB ^) expProduct )* )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:34:18: expProduct ( ( PLUS ^| SUB ^) expProduct )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_expProduct_in_expSum319);
			expProduct17=expProduct();
			state._fsp--;

			adaptor.addChild(root_0, expProduct17.getTree());

			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:34:30: ( ( PLUS ^| SUB ^) expProduct )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==PLUS||LA6_0==SUB) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:34:31: ( PLUS ^| SUB ^) expProduct
					{
					// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:34:31: ( PLUS ^| SUB ^)
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==PLUS) ) {
						alt5=1;
					}
					else if ( (LA5_0==SUB) ) {
						alt5=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 5, 0, input);
						throw nvae;
					}

					switch (alt5) {
						case 1 :
							// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:34:32: PLUS ^
							{
							PLUS18=(Token)match(input,PLUS,FOLLOW_PLUS_in_expSum324); 
							PLUS18_tree = (Object)adaptor.create(PLUS18);
							root_0 = (Object)adaptor.becomeRoot(PLUS18_tree, root_0);

							}
							break;
						case 2 :
							// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:35:32: SUB ^
							{
							SUB19=(Token)match(input,SUB,FOLLOW_SUB_in_expSum359); 
							SUB19_tree = (Object)adaptor.create(SUB19);
							root_0 = (Object)adaptor.becomeRoot(SUB19_tree, root_0);

							}
							break;

					}

					pushFollow(FOLLOW_expProduct_in_expSum363);
					expProduct20=expProduct();
					state._fsp--;

					adaptor.addChild(root_0, expProduct20.getTree());

					}
					break;

				default :
					break loop6;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expSum"


	public static class expProduct_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expProduct"
	// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:37:1: expProduct : expMinus ( ( STAR ^| SLASH ^| MOD ^) expMinus )* ;
	public final Valid2Parser.expProduct_return expProduct() throws RecognitionException {
		Valid2Parser.expProduct_return retval = new Valid2Parser.expProduct_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token STAR22=null;
		Token SLASH23=null;
		Token MOD24=null;
		ParserRuleReturnScope expMinus21 =null;
		ParserRuleReturnScope expMinus25 =null;

		Object STAR22_tree=null;
		Object SLASH23_tree=null;
		Object MOD24_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:37:15: ( expMinus ( ( STAR ^| SLASH ^| MOD ^) expMinus )* )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:37:18: expMinus ( ( STAR ^| SLASH ^| MOD ^) expMinus )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_expMinus_in_expProduct378);
			expMinus21=expMinus();
			state._fsp--;

			adaptor.addChild(root_0, expMinus21.getTree());

			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:37:27: ( ( STAR ^| SLASH ^| MOD ^) expMinus )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==MOD||(LA8_0 >= SLASH && LA8_0 <= STAR)) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:37:28: ( STAR ^| SLASH ^| MOD ^) expMinus
					{
					// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:37:28: ( STAR ^| SLASH ^| MOD ^)
					int alt7=3;
					switch ( input.LA(1) ) {
					case STAR:
						{
						alt7=1;
						}
						break;
					case SLASH:
						{
						alt7=2;
						}
						break;
					case MOD:
						{
						alt7=3;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 7, 0, input);
						throw nvae;
					}
					switch (alt7) {
						case 1 :
							// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:37:29: STAR ^
							{
							STAR22=(Token)match(input,STAR,FOLLOW_STAR_in_expProduct382); 
							STAR22_tree = (Object)adaptor.create(STAR22);
							root_0 = (Object)adaptor.becomeRoot(STAR22_tree, root_0);

							}
							break;
						case 2 :
							// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:38:29: SLASH ^
							{
							SLASH23=(Token)match(input,SLASH,FOLLOW_SLASH_in_expProduct415); 
							SLASH23_tree = (Object)adaptor.create(SLASH23);
							root_0 = (Object)adaptor.becomeRoot(SLASH23_tree, root_0);

							}
							break;
						case 3 :
							// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:39:29: MOD ^
							{
							MOD24=(Token)match(input,MOD,FOLLOW_MOD_in_expProduct447); 
							MOD24_tree = (Object)adaptor.create(MOD24);
							root_0 = (Object)adaptor.becomeRoot(MOD24_tree, root_0);

							}
							break;

					}

					pushFollow(FOLLOW_expMinus_in_expProduct452);
					expMinus25=expMinus();
					state._fsp--;

					adaptor.addChild(root_0, expMinus25.getTree());

					}
					break;

				default :
					break loop8;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expProduct"


	public static class expMinus_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expMinus"
	// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:41:1: expMinus : ( ( SUB ! expNot ) | ( ( PLUS !)? expNot ) );
	public final Valid2Parser.expMinus_return expMinus() throws RecognitionException {
		Valid2Parser.expMinus_return retval = new Valid2Parser.expMinus_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SUB26=null;
		Token PLUS28=null;
		ParserRuleReturnScope expNot27 =null;
		ParserRuleReturnScope expNot29 =null;

		Object SUB26_tree=null;
		Object PLUS28_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:41:15: ( ( SUB ! expNot ) | ( ( PLUS !)? expNot ) )
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==SUB) ) {
				alt10=1;
			}
			else if ( (LA10_0==IDENT||LA10_0==LEFT_PAREN||LA10_0==NUMBER||LA10_0==PLUS||LA10_0==NOT_RW) ) {
				alt10=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:41:17: ( SUB ! expNot )
					{
					root_0 = (Object)adaptor.nil();


					// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:41:17: ( SUB ! expNot )
					// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:41:18: SUB ! expNot
					{
					SUB26=(Token)match(input,SUB,FOLLOW_SUB_in_expMinus469); 
					pushFollow(FOLLOW_expNot_in_expMinus472);
					expNot27=expNot();
					state._fsp--;

					adaptor.addChild(root_0, expNot27.getTree());

					}

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:42:17: ( ( PLUS !)? expNot )
					{
					root_0 = (Object)adaptor.nil();


					// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:42:17: ( ( PLUS !)? expNot )
					// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:42:18: ( PLUS !)? expNot
					{
					// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:42:18: ( PLUS !)?
					int alt9=2;
					int LA9_0 = input.LA(1);
					if ( (LA9_0==PLUS) ) {
						alt9=1;
					}
					switch (alt9) {
						case 1 :
							// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:42:19: PLUS !
							{
							PLUS28=(Token)match(input,PLUS,FOLLOW_PLUS_in_expMinus493); 
							}
							break;

					}

					pushFollow(FOLLOW_expNot_in_expMinus498);
					expNot29=expNot();
					state._fsp--;

					adaptor.addChild(root_0, expNot29.getTree());

					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expMinus"


	public static class expNot_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expNot"
	// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:45:1: expNot : ( NOT_RW ^)? ( IDENT | NUMBER | ( LEFT_PAREN ! expr RIGHT_PAREN !) ) ;
	public final Valid2Parser.expNot_return expNot() throws RecognitionException {
		Valid2Parser.expNot_return retval = new Valid2Parser.expNot_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NOT_RW30=null;
		Token IDENT31=null;
		Token NUMBER32=null;
		Token LEFT_PAREN33=null;
		Token RIGHT_PAREN35=null;
		ParserRuleReturnScope expr34 =null;

		Object NOT_RW30_tree=null;
		Object IDENT31_tree=null;
		Object NUMBER32_tree=null;
		Object LEFT_PAREN33_tree=null;
		Object RIGHT_PAREN35_tree=null;

		try {
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:45:7: ( ( NOT_RW ^)? ( IDENT | NUMBER | ( LEFT_PAREN ! expr RIGHT_PAREN !) ) )
			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:45:9: ( NOT_RW ^)? ( IDENT | NUMBER | ( LEFT_PAREN ! expr RIGHT_PAREN !) )
			{
			root_0 = (Object)adaptor.nil();


			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:45:9: ( NOT_RW ^)?
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==NOT_RW) ) {
				alt11=1;
			}
			switch (alt11) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:45:10: NOT_RW ^
					{
					NOT_RW30=(Token)match(input,NOT_RW,FOLLOW_NOT_RW_in_expNot522); 
					NOT_RW30_tree = (Object)adaptor.create(NOT_RW30);
					root_0 = (Object)adaptor.becomeRoot(NOT_RW30_tree, root_0);

					}
					break;

			}

			// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:45:20: ( IDENT | NUMBER | ( LEFT_PAREN ! expr RIGHT_PAREN !) )
			int alt12=3;
			switch ( input.LA(1) ) {
			case IDENT:
				{
				alt12=1;
				}
				break;
			case NUMBER:
				{
				alt12=2;
				}
				break;
			case LEFT_PAREN:
				{
				alt12=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}
			switch (alt12) {
				case 1 :
					// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:45:21: IDENT
					{
					IDENT31=(Token)match(input,IDENT,FOLLOW_IDENT_in_expNot528); 
					IDENT31_tree = (Object)adaptor.create(IDENT31);
					adaptor.addChild(root_0, IDENT31_tree);

					}
					break;
				case 2 :
					// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:45:27: NUMBER
					{
					NUMBER32=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_expNot530); 
					NUMBER32_tree = (Object)adaptor.create(NUMBER32);
					adaptor.addChild(root_0, NUMBER32_tree);

					}
					break;
				case 3 :
					// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:45:34: ( LEFT_PAREN ! expr RIGHT_PAREN !)
					{
					// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:45:34: ( LEFT_PAREN ! expr RIGHT_PAREN !)
					// src/main/java/org/qcri/rheem/latin/expression/antlr/Valid2Parser.g:45:35: LEFT_PAREN ! expr RIGHT_PAREN !
					{
					LEFT_PAREN33=(Token)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_expNot533); 
					pushFollow(FOLLOW_expr_in_expNot536);
					expr34=expr();
					state._fsp--;

					adaptor.addChild(root_0, expr34.getTree());

					RIGHT_PAREN35=(Token)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_expNot538); 
					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expNot"

	// Delegated rules



	public static final BitSet FOLLOW_expr_in_base68 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_base70 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expAND_in_expr88 = new BitSet(new long[]{0x0000000000800002L});
	public static final BitSet FOLLOW_OR_RW_in_expr92 = new BitSet(new long[]{0x0000000881422000L});
	public static final BitSet FOLLOW_expAND_in_expr95 = new BitSet(new long[]{0x0000000000800002L});
	public static final BitSet FOLLOW_expCons_in_expAND113 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_AND_RW_in_expAND116 = new BitSet(new long[]{0x0000000881422000L});
	public static final BitSet FOLLOW_expCons_in_expAND119 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_expSum_in_expCons136 = new BitSet(new long[]{0x0000000000285A02L});
	public static final BitSet FOLLOW_EQUAL_in_expCons141 = new BitSet(new long[]{0x0000000881422000L});
	public static final BitSet FOLLOW_LE_EQUAL_in_expCons172 = new BitSet(new long[]{0x0000000881422000L});
	public static final BitSet FOLLOW_GR_EQUAL_in_expCons203 = new BitSet(new long[]{0x0000000881422000L});
	public static final BitSet FOLLOW_NOT_EQUAL_in_expCons234 = new BitSet(new long[]{0x0000000881422000L});
	public static final BitSet FOLLOW_GR_in_expCons265 = new BitSet(new long[]{0x0000000881422000L});
	public static final BitSet FOLLOW_LE_in_expCons296 = new BitSet(new long[]{0x0000000881422000L});
	public static final BitSet FOLLOW_expSum_in_expCons300 = new BitSet(new long[]{0x0000000000285A02L});
	public static final BitSet FOLLOW_expProduct_in_expSum319 = new BitSet(new long[]{0x0000000081000002L});
	public static final BitSet FOLLOW_PLUS_in_expSum324 = new BitSet(new long[]{0x0000000881422000L});
	public static final BitSet FOLLOW_SUB_in_expSum359 = new BitSet(new long[]{0x0000000881422000L});
	public static final BitSet FOLLOW_expProduct_in_expSum363 = new BitSet(new long[]{0x0000000081000002L});
	public static final BitSet FOLLOW_expMinus_in_expProduct378 = new BitSet(new long[]{0x0000000060100002L});
	public static final BitSet FOLLOW_STAR_in_expProduct382 = new BitSet(new long[]{0x0000000881422000L});
	public static final BitSet FOLLOW_SLASH_in_expProduct415 = new BitSet(new long[]{0x0000000881422000L});
	public static final BitSet FOLLOW_MOD_in_expProduct447 = new BitSet(new long[]{0x0000000881422000L});
	public static final BitSet FOLLOW_expMinus_in_expProduct452 = new BitSet(new long[]{0x0000000060100002L});
	public static final BitSet FOLLOW_SUB_in_expMinus469 = new BitSet(new long[]{0x0000000800422000L});
	public static final BitSet FOLLOW_expNot_in_expMinus472 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_expMinus493 = new BitSet(new long[]{0x0000000800422000L});
	public static final BitSet FOLLOW_expNot_in_expMinus498 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_RW_in_expNot522 = new BitSet(new long[]{0x0000000000422000L});
	public static final BitSet FOLLOW_IDENT_in_expNot528 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_expNot530 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFT_PAREN_in_expNot533 = new BitSet(new long[]{0x0000000881422000L});
	public static final BitSet FOLLOW_expr_in_expNot536 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_RIGHT_PAREN_in_expNot538 = new BitSet(new long[]{0x0000000000000002L});
}
