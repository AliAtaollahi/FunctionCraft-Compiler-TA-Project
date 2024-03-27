// Generated from D:/8/TA/Compiler/Design-Compiler-Course-Projects/Phase1/Working FLUT/src/main/grammar/UTL.g4 by ANTLR 4.13.1
package parsers;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link UTLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface UTLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link UTLParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(UTLParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(UTLParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#functionArgumentsDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionArgumentsDeclaration(UTLParser.FunctionArgumentsDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(UTLParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(UTLParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(UTLParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#functionArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionArguments(UTLParser.FunctionArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#splitedExpressionsWithComma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSplitedExpressionsWithComma(UTLParser.SplitedExpressionsWithCommaContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#splitedExpressionsWithCommaAndKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSplitedExpressionsWithCommaAndKey(UTLParser.SplitedExpressionsWithCommaAndKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#functionCallStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallStatement(UTLParser.FunctionCallStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(UTLParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(UTLParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#ifStatementWithReturn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatementWithReturn(UTLParser.IfStatementWithReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(UTLParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(UTLParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#singleStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleStatement(UTLParser.SingleStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(UTLParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#conditionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionBody(UTLParser.ConditionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(UTLParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(UTLParser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(UTLParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(UTLParser.RelationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(UTLParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(UTLParser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#preUnaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreUnaryExpression(UTLParser.PreUnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#appendExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAppendExpression(UTLParser.AppendExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#accessExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessExpression(UTLParser.AccessExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#otherExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOtherExpression(UTLParser.OtherExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#anonymousFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnonymousFunction(UTLParser.AnonymousFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#sizeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSizeExpression(UTLParser.SizeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValues(UTLParser.ValuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#listValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListValue(UTLParser.ListValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#boolValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolValue(UTLParser.BoolValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#voidValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidValue(UTLParser.VoidValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(UTLParser.IdentifierContext ctx);
}