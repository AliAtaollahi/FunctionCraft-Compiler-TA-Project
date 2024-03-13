// Generated from C:/Users/Asus/Desktop/Phase 3/src/main/grammar\Jepeto.g4 by ANTLR 4.9.1
package parsers;

     import main.ast.nodes.*;
     import main.ast.nodes.declaration.*;
     import main.ast.nodes.expression.*;
     import main.ast.nodes.expression.operators.*;
     import main.ast.nodes.expression.values.*;
     import main.ast.nodes.expression.values.primitive.*;
     import main.ast.nodes.statement.*;
     import java.util.*;
 
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JepetoParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JepetoVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JepetoParser#jepeto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJepeto(JepetoParser.JepetoContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(JepetoParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(JepetoParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#functionArgumentsDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionArgumentsDeclaration(JepetoParser.FunctionArgumentsDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(JepetoParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(JepetoParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(JepetoParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#functionArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionArguments(JepetoParser.FunctionArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#splitedExpressionsWithComma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSplitedExpressionsWithComma(JepetoParser.SplitedExpressionsWithCommaContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#splitedExpressionsWithCommaAndKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSplitedExpressionsWithCommaAndKey(JepetoParser.SplitedExpressionsWithCommaAndKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#functionCallStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallStatement(JepetoParser.FunctionCallStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(JepetoParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(JepetoParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#ifStatementWithReturn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatementWithReturn(JepetoParser.IfStatementWithReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(JepetoParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(JepetoParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#singleStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleStatement(JepetoParser.SingleStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(JepetoParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#conditionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionBody(JepetoParser.ConditionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(JepetoParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(JepetoParser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(JepetoParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(JepetoParser.RelationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(JepetoParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(JepetoParser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#preUnaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreUnaryExpression(JepetoParser.PreUnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#appendExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAppendExpression(JepetoParser.AppendExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#accessExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessExpression(JepetoParser.AccessExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#otherExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOtherExpression(JepetoParser.OtherExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#anonymousFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnonymousFunction(JepetoParser.AnonymousFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#sizeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSizeExpression(JepetoParser.SizeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValues(JepetoParser.ValuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#listValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListValue(JepetoParser.ListValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#boolValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolValue(JepetoParser.BoolValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#voidValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidValue(JepetoParser.VoidValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link JepetoParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(JepetoParser.IdentifierContext ctx);
}