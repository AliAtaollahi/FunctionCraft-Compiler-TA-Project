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
	 * Visit a parse tree produced by {@link UTLParser#patternMatching}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternMatching(UTLParser.PatternMatchingContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(UTLParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#functionArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionArguments(UTLParser.FunctionArgumentsContext ctx);
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
	 * Visit a parse tree produced by {@link UTLParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(UTLParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#putsStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPutsStatement(UTLParser.PutsStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#lenStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLenStatement(UTLParser.LenStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#pushStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPushStatement(UTLParser.PushStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#loopDoStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopDoStatement(UTLParser.LoopDoStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#loopBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopBody(UTLParser.LoopBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(UTLParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRange(UTLParser.RangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#filterStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterStatement(UTLParser.FilterStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#matchPatternStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchPatternStatement(UTLParser.MatchPatternStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#chopAndChompStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChopAndChompStatement(UTLParser.ChopAndChompStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(UTLParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#accessList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessList(UTLParser.AccessListContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(UTLParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(UTLParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(UTLParser.ExpressionContext ctx);
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
	 * Visit a parse tree produced by {@link UTLParser#lambdaFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaFunction(UTLParser.LambdaFunctionContext ctx);
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
	 * Visit a parse tree produced by {@link UTLParser#functionPointer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionPointer(UTLParser.FunctionPointerContext ctx);
}