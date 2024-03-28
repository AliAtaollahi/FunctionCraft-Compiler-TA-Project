// Generated from f:/Program Files (x86)/MMD.Soor/University/Term 6/PLC (TA)/Design-Compiler-Course-Projects/Phase1/Working FLUT/src/main/grammar/UTL.g4 by ANTLR 4.13.1
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
	 * Enter a parse tree produced by {@link UTLParser#splitedExpressionsWithComma}.
	 * @param ctx the parse tree
	 */
	void enterSplitedExpressionsWithComma(UTLParser.SplitedExpressionsWithCommaContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#splitedExpressionsWithComma}.
	 * @param ctx the parse tree
	 */
	void exitSplitedExpressionsWithComma(UTLParser.SplitedExpressionsWithCommaContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#splitedExpressionsWithCommaAndKey}.
	 * @param ctx the parse tree
	 */
	void enterSplitedExpressionsWithCommaAndKey(UTLParser.SplitedExpressionsWithCommaAndKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#splitedExpressionsWithCommaAndKey}.
	 * @param ctx the parse tree
	 */
	void exitSplitedExpressionsWithCommaAndKey(UTLParser.SplitedExpressionsWithCommaAndKeyContext ctx);
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
	 * Enter a parse tree produced by {@link UTLParser#ifStatementWithReturn}.
	 * @param ctx the parse tree
	 */
	void enterIfStatementWithReturn(UTLParser.IfStatementWithReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#ifStatementWithReturn}.
	 * @param ctx the parse tree
	 */
	void exitIfStatementWithReturn(UTLParser.IfStatementWithReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(UTLParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(UTLParser.PrintStatementContext ctx);
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
	 * Enter a parse tree produced by {@link UTLParser#singleStatement}.
	 * @param ctx the parse tree
	 */
	void enterSingleStatement(UTLParser.SingleStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#singleStatement}.
	 * @param ctx the parse tree
	 */
	void exitSingleStatement(UTLParser.SingleStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(UTLParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(UTLParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#conditionBody}.
	 * @param ctx the parse tree
	 */
	void enterConditionBody(UTLParser.ConditionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#conditionBody}.
	 * @param ctx the parse tree
	 */
	void exitConditionBody(UTLParser.ConditionBodyContext ctx);
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
	 * Enter a parse tree produced by {@link UTLParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(UTLParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(UTLParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(UTLParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(UTLParser.EqualityExpressionContext ctx);
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
	 * Enter a parse tree produced by {@link UTLParser#anonymousFunction}.
	 * @param ctx the parse tree
	 */
	void enterAnonymousFunction(UTLParser.AnonymousFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#anonymousFunction}.
	 * @param ctx the parse tree
	 */
	void exitAnonymousFunction(UTLParser.AnonymousFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UTLParser#sizeExpression}.
	 * @param ctx the parse tree
	 */
	void enterSizeExpression(UTLParser.SizeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#sizeExpression}.
	 * @param ctx the parse tree
	 */
	void exitSizeExpression(UTLParser.SizeExpressionContext ctx);
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
	 * Enter a parse tree produced by {@link UTLParser#voidValue}.
	 * @param ctx the parse tree
	 */
	void enterVoidValue(UTLParser.VoidValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link UTLParser#voidValue}.
	 * @param ctx the parse tree
	 */
	void exitVoidValue(UTLParser.VoidValueContext ctx);
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