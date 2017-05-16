// Generated from /Users/bertty/Qatar/xxxx/src/main/java/org/qcri/rheem/latin/dinamic/MathParser.g4 by ANTLR 4.6
package org.qcri.rheem.latin.dinamic;

    import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MathParser}.
 */
public interface MathParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MathParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(MathParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link MathParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(MathParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link MathParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(MathParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MathParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(MathParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprNum}
	 * labeled alternative in {@link MathParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterExprNum(MathParser.ExprNumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprNum}
	 * labeled alternative in {@link MathParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitExprNum(MathParser.ExprNumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link MathParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterParens(MathParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link MathParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitParens(MathParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprPre}
	 * labeled alternative in {@link MathParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterExprPre(MathParser.ExprPreContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprPre}
	 * labeled alternative in {@link MathParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitExprPre(MathParser.ExprPreContext ctx);
	/**
	 * Enter a parse tree produced by {@link MathParser#numero}.
	 * @param ctx the parse tree
	 */
	void enterNumero(MathParser.NumeroContext ctx);
	/**
	 * Exit a parse tree produced by {@link MathParser#numero}.
	 * @param ctx the parse tree
	 */
	void exitNumero(MathParser.NumeroContext ctx);
}