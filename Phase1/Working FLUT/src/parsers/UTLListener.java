// Generated from D:/8/TA/Compiler/Design-Compiler-Course-Projects/Phase1/Working FLUT/src/main/grammar/UTL.g4 by ANTLR 4.13.1
package parsers;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link UTLParser}.
 */
public interface UTLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link UTLParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(UTLParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(UTLParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(UTLParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(UTLParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#functionArgumentsDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArgumentsDeclaration(UTLParser.FunctionArgumentsDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#functionArgumentsDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArgumentsDeclaration(UTLParser.FunctionArgumentsDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#patternMatching}.
	 * @param ctx the parse tree
	 */
	void enterPatternMatching(UTLParser.PatternMatchingContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#patternMatching}.
	 * @param ctx the parse tree
	 */
	void exitPatternMatching(UTLParser.PatternMatchingContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(UTLParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(UTLParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(UTLParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(UTLParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#functionArguments}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArguments(UTLParser.FunctionArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#functionArguments}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArguments(UTLParser.FunctionArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#functionCallStatement}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallStatement(UTLParser.FunctionCallStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#functionCallStatement}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallStatement(UTLParser.FunctionCallStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(UTLParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(UTLParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(UTLParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(UTLParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(UTLParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(UTLParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#putsStatement}.
	 * @param ctx the parse tree
	 */
	void enterPutsStatement(UTLParser.PutsStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#putsStatement}.
	 * @param ctx the parse tree
	 */
	void exitPutsStatement(UTLParser.PutsStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#lenStatement}.
	 * @param ctx the parse tree
	 */
	void enterLenStatement(UTLParser.LenStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#lenStatement}.
	 * @param ctx the parse tree
	 */
	void exitLenStatement(UTLParser.LenStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#pushStatement}.
	 * @param ctx the parse tree
	 */
	void enterPushStatement(UTLParser.PushStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#pushStatement}.
	 * @param ctx the parse tree
	 */
	void exitPushStatement(UTLParser.PushStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#loopDoStatement}.
	 * @param ctx the parse tree
	 */
	void enterLoopDoStatement(UTLParser.LoopDoStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#loopDoStatement}.
	 * @param ctx the parse tree
	 */
	void exitLoopDoStatement(UTLParser.LoopDoStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#loopBody}.
	 * @param ctx the parse tree
	 */
	void enterLoopBody(UTLParser.LoopBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#loopBody}.
	 * @param ctx the parse tree
	 */
	void exitLoopBody(UTLParser.LoopBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(UTLParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(UTLParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#range}.
	 * @param ctx the parse tree
	 */
	void enterRange(UTLParser.RangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#range}.
	 * @param ctx the parse tree
	 */
	void exitRange(UTLParser.RangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#filterStatement}.
	 * @param ctx the parse tree
	 */
	void enterFilterStatement(UTLParser.FilterStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#filterStatement}.
	 * @param ctx the parse tree
	 */
	void exitFilterStatement(UTLParser.FilterStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#matchPatternStatement}.
	 * @param ctx the parse tree
	 */
	void enterMatchPatternStatement(UTLParser.MatchPatternStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#matchPatternStatement}.
	 * @param ctx the parse tree
	 */
	void exitMatchPatternStatement(UTLParser.MatchPatternStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#chopAndChompStatement}.
	 * @param ctx the parse tree
	 */
	void enterChopAndChompStatement(UTLParser.ChopAndChompStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#chopAndChompStatement}.
	 * @param ctx the parse tree
	 */
	void exitChopAndChompStatement(UTLParser.ChopAndChompStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(UTLParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(UTLParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(UTLParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(UTLParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(UTLParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(UTLParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(UTLParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(UTLParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(UTLParser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(UTLParser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(UTLParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(UTLParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(UTLParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(UTLParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#preUnaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPreUnaryExpression(UTLParser.PreUnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#preUnaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPreUnaryExpression(UTLParser.PreUnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#appendExpression}.
	 * @param ctx the parse tree
	 */
	void enterAppendExpression(UTLParser.AppendExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#appendExpression}.
	 * @param ctx the parse tree
	 */
	void exitAppendExpression(UTLParser.AppendExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#accessExpression}.
	 * @param ctx the parse tree
	 */
	void enterAccessExpression(UTLParser.AccessExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#accessExpression}.
	 * @param ctx the parse tree
	 */
	void exitAccessExpression(UTLParser.AccessExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#otherExpression}.
	 * @param ctx the parse tree
	 */
	void enterOtherExpression(UTLParser.OtherExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#otherExpression}.
	 * @param ctx the parse tree
	 */
	void exitOtherExpression(UTLParser.OtherExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#lambdaFunction}.
	 * @param ctx the parse tree
	 */
	void enterLambdaFunction(UTLParser.LambdaFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#lambdaFunction}.
	 * @param ctx the parse tree
	 */
	void exitLambdaFunction(UTLParser.LambdaFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#values}.
	 * @param ctx the parse tree
	 */
	void enterValues(UTLParser.ValuesContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#values}.
	 * @param ctx the parse tree
	 */
	void exitValues(UTLParser.ValuesContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#listValue}.
	 * @param ctx the parse tree
	 */
	void enterListValue(UTLParser.ListValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#listValue}.
	 * @param ctx the parse tree
	 */
	void exitListValue(UTLParser.ListValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#boolValue}.
	 * @param ctx the parse tree
	 */
	void enterBoolValue(UTLParser.BoolValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#boolValue}.
	 * @param ctx the parse tree
	 */
	void exitBoolValue(UTLParser.BoolValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#functionPointer}.
	 * @param ctx the parse tree
	 */
	void enterFunctionPointer(UTLParser.FunctionPointerContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#functionPointer}.
	 * @param ctx the parse tree
	 */
	void exitFunctionPointer(UTLParser.FunctionPointerContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(UTLParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(UTLParser.IdentifierContext ctx);
}