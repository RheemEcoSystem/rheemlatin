// Generated from LatinParser.g4 by ANTLR 4.7

package org.qcri.rheem.latin.parser;
import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LatinParser}.
 */
public interface LatinParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LatinParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(LatinParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatinParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(LatinParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BaseStatement}
	 * labeled alternative in {@link LatinParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBaseStatement(LatinParser.BaseStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BaseStatement}
	 * labeled alternative in {@link LatinParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBaseStatement(LatinParser.BaseStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SinkStatement}
	 * labeled alternative in {@link LatinParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterSinkStatement(LatinParser.SinkStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SinkStatement}
	 * labeled alternative in {@link LatinParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitSinkStatement(LatinParser.SinkStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BagStatement}
	 * labeled alternative in {@link LatinParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBagStatement(LatinParser.BagStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BagStatement}
	 * labeled alternative in {@link LatinParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBagStatement(LatinParser.BagStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OperatorStatement}
	 * labeled alternative in {@link LatinParser#operator_statement}.
	 * @param ctx the parse tree
	 */
	void enterOperatorStatement(LatinParser.OperatorStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OperatorStatement}
	 * labeled alternative in {@link LatinParser#operator_statement}.
	 * @param ctx the parse tree
	 */
	void exitOperatorStatement(LatinParser.OperatorStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatinParser#lambda}.
	 * @param ctx the parse tree
	 */
	void enterLambda(LatinParser.LambdaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatinParser#lambda}.
	 * @param ctx the parse tree
	 */
	void exitLambda(LatinParser.LambdaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatinParser#real_function}.
	 * @param ctx the parse tree
	 */
	void enterReal_function(LatinParser.Real_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatinParser#real_function}.
	 * @param ctx the parse tree
	 */
	void exitReal_function(LatinParser.Real_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatinParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(LatinParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatinParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(LatinParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatinParser#source_statement}.
	 * @param ctx the parse tree
	 */
	void enterSource_statement(LatinParser.Source_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatinParser#source_statement}.
	 * @param ctx the parse tree
	 */
	void exitSource_statement(LatinParser.Source_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatinParser#as_clause}.
	 * @param ctx the parse tree
	 */
	void enterAs_clause(LatinParser.As_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatinParser#as_clause}.
	 * @param ctx the parse tree
	 */
	void exitAs_clause(LatinParser.As_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatinParser#type_load}.
	 * @param ctx the parse tree
	 */
	void enterType_load(LatinParser.Type_loadContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatinParser#type_load}.
	 * @param ctx the parse tree
	 */
	void exitType_load(LatinParser.Type_loadContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatinParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterPair(LatinParser.PairContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatinParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitPair(LatinParser.PairContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatinParser#sink_statement}.
	 * @param ctx the parse tree
	 */
	void enterSink_statement(LatinParser.Sink_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatinParser#sink_statement}.
	 * @param ctx the parse tree
	 */
	void exitSink_statement(LatinParser.Sink_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatinParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(LatinParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatinParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(LatinParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumberExpression}
	 * labeled alternative in {@link LatinParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpression(LatinParser.NumberExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumberExpression}
	 * labeled alternative in {@link LatinParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpression(LatinParser.NumberExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenExpression}
	 * labeled alternative in {@link LatinParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterParenExpression(LatinParser.ParenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenExpression}
	 * labeled alternative in {@link LatinParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitParenExpression(LatinParser.ParenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrefixExpression}
	 * labeled alternative in {@link LatinParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterPrefixExpression(LatinParser.PrefixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrefixExpression}
	 * labeled alternative in {@link LatinParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitPrefixExpression(LatinParser.PrefixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionExpression}
	 * labeled alternative in {@link LatinParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterFunctionExpression(LatinParser.FunctionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionExpression}
	 * labeled alternative in {@link LatinParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitFunctionExpression(LatinParser.FunctionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatinParser#functionExpr}.
	 * @param ctx the parse tree
	 */
	void enterFunctionExpr(LatinParser.FunctionExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatinParser#functionExpr}.
	 * @param ctx the parse tree
	 */
	void exitFunctionExpr(LatinParser.FunctionExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatinParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(LatinParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatinParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(LatinParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatinParser#sub_id}.
	 * @param ctx the parse tree
	 */
	void enterSub_id(LatinParser.Sub_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatinParser#sub_id}.
	 * @param ctx the parse tree
	 */
	void exitSub_id(LatinParser.Sub_idContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatinParser#boolean_const}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_const(LatinParser.Boolean_constContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatinParser#boolean_const}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_const(LatinParser.Boolean_constContext ctx);
	/**
	 * Enter a parse tree produced by the {@code namePlatform}
	 * labeled alternative in {@link LatinParser#with_platform}.
	 * @param ctx the parse tree
	 */
	void enterNamePlatform(LatinParser.NamePlatformContext ctx);
	/**
	 * Exit a parse tree produced by the {@code namePlatform}
	 * labeled alternative in {@link LatinParser#with_platform}.
	 * @param ctx the parse tree
	 */
	void exitNamePlatform(LatinParser.NamePlatformContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatinParser#with_broadcast}.
	 * @param ctx the parse tree
	 */
	void enterWith_broadcast(LatinParser.With_broadcastContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatinParser#with_broadcast}.
	 * @param ctx the parse tree
	 */
	void exitWith_broadcast(LatinParser.With_broadcastContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatinParser#bag_stattement}.
	 * @param ctx the parse tree
	 */
	void enterBag_stattement(LatinParser.Bag_stattementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatinParser#bag_stattement}.
	 * @param ctx the parse tree
	 */
	void exitBag_stattement(LatinParser.Bag_stattementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatinParser#bag_header}.
	 * @param ctx the parse tree
	 */
	void enterBag_header(LatinParser.Bag_headerContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatinParser#bag_header}.
	 * @param ctx the parse tree
	 */
	void exitBag_header(LatinParser.Bag_headerContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatinParser#bag_header_titles}.
	 * @param ctx the parse tree
	 */
	void enterBag_header_titles(LatinParser.Bag_header_titlesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatinParser#bag_header_titles}.
	 * @param ctx the parse tree
	 */
	void exitBag_header_titles(LatinParser.Bag_header_titlesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatinParser#bag_header_element}.
	 * @param ctx the parse tree
	 */
	void enterBag_header_element(LatinParser.Bag_header_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatinParser#bag_header_element}.
	 * @param ctx the parse tree
	 */
	void exitBag_header_element(LatinParser.Bag_header_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatinParser#bag_header_params}.
	 * @param ctx the parse tree
	 */
	void enterBag_header_params(LatinParser.Bag_header_paramsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatinParser#bag_header_params}.
	 * @param ctx the parse tree
	 */
	void exitBag_header_params(LatinParser.Bag_header_paramsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatinParser#bag_set_param}.
	 * @param ctx the parse tree
	 */
	void enterBag_set_param(LatinParser.Bag_set_paramContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatinParser#bag_set_param}.
	 * @param ctx the parse tree
	 */
	void exitBag_set_param(LatinParser.Bag_set_paramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ClassDefine}
	 * labeled alternative in {@link LatinParser#class_define}.
	 * @param ctx the parse tree
	 */
	void enterClassDefine(LatinParser.ClassDefineContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClassDefine}
	 * labeled alternative in {@link LatinParser#class_define}.
	 * @param ctx the parse tree
	 */
	void exitClassDefine(LatinParser.ClassDefineContext ctx);
	/**
	 * Enter a parse tree produced by {@link LatinParser#include_statement}.
	 * @param ctx the parse tree
	 */
	void enterInclude_statement(LatinParser.Include_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LatinParser#include_statement}.
	 * @param ctx the parse tree
	 */
	void exitInclude_statement(LatinParser.Include_statementContext ctx);
}