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
 
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JepetoParser}.
 */
public interface JepetoListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JepetoParser#jepeto}.
	 * @param ctx the parse tree
	 */
	void enterJepeto(JepetoParser.JepetoContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#jepeto}.
	 * @param ctx the parse tree
	 */
	void exitJepeto(JepetoParser.JepetoContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(JepetoParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(JepetoParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(JepetoParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(JepetoParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#functionArgumentsDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArgumentsDeclaration(JepetoParser.FunctionArgumentsDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#functionArgumentsDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArgumentsDeclaration(JepetoParser.FunctionArgumentsDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(JepetoParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(JepetoParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(JepetoParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(JepetoParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(JepetoParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(JepetoParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#functionArguments}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArguments(JepetoParser.FunctionArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#functionArguments}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArguments(JepetoParser.FunctionArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#splitedExpressionsWithComma}.
	 * @param ctx the parse tree
	 */
	void enterSplitedExpressionsWithComma(JepetoParser.SplitedExpressionsWithCommaContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#splitedExpressionsWithComma}.
	 * @param ctx the parse tree
	 */
	void exitSplitedExpressionsWithComma(JepetoParser.SplitedExpressionsWithCommaContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#splitedExpressionsWithCommaAndKey}.
	 * @param ctx the parse tree
	 */
	void enterSplitedExpressionsWithCommaAndKey(JepetoParser.SplitedExpressionsWithCommaAndKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#splitedExpressionsWithCommaAndKey}.
	 * @param ctx the parse tree
	 */
	void exitSplitedExpressionsWithCommaAndKey(JepetoParser.SplitedExpressionsWithCommaAndKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#functionCallStatement}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallStatement(JepetoParser.FunctionCallStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#functionCallStatement}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallStatement(JepetoParser.FunctionCallStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(JepetoParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(JepetoParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(JepetoParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(JepetoParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#ifStatementWithReturn}.
	 * @param ctx the parse tree
	 */
	void enterIfStatementWithReturn(JepetoParser.IfStatementWithReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#ifStatementWithReturn}.
	 * @param ctx the parse tree
	 */
	void exitIfStatementWithReturn(JepetoParser.IfStatementWithReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(JepetoParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(JepetoParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(JepetoParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(JepetoParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#singleStatement}.
	 * @param ctx the parse tree
	 */
	void enterSingleStatement(JepetoParser.SingleStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#singleStatement}.
	 * @param ctx the parse tree
	 */
	void exitSingleStatement(JepetoParser.SingleStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(JepetoParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(JepetoParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#conditionBody}.
	 * @param ctx the parse tree
	 */
	void enterConditionBody(JepetoParser.ConditionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#conditionBody}.
	 * @param ctx the parse tree
	 */
	void exitConditionBody(JepetoParser.ConditionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(JepetoParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(JepetoParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(JepetoParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(JepetoParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(JepetoParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(JepetoParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(JepetoParser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(JepetoParser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(JepetoParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(JepetoParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(JepetoParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(JepetoParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#preUnaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPreUnaryExpression(JepetoParser.PreUnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#preUnaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPreUnaryExpression(JepetoParser.PreUnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#appendExpression}.
	 * @param ctx the parse tree
	 */
	void enterAppendExpression(JepetoParser.AppendExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#appendExpression}.
	 * @param ctx the parse tree
	 */
	void exitAppendExpression(JepetoParser.AppendExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#accessExpression}.
	 * @param ctx the parse tree
	 */
	void enterAccessExpression(JepetoParser.AccessExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#accessExpression}.
	 * @param ctx the parse tree
	 */
	void exitAccessExpression(JepetoParser.AccessExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#otherExpression}.
	 * @param ctx the parse tree
	 */
	void enterOtherExpression(JepetoParser.OtherExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#otherExpression}.
	 * @param ctx the parse tree
	 */
	void exitOtherExpression(JepetoParser.OtherExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#anonymousFunction}.
	 * @param ctx the parse tree
	 */
	void enterAnonymousFunction(JepetoParser.AnonymousFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#anonymousFunction}.
	 * @param ctx the parse tree
	 */
	void exitAnonymousFunction(JepetoParser.AnonymousFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#sizeExpression}.
	 * @param ctx the parse tree
	 */
	void enterSizeExpression(JepetoParser.SizeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#sizeExpression}.
	 * @param ctx the parse tree
	 */
	void exitSizeExpression(JepetoParser.SizeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#values}.
	 * @param ctx the parse tree
	 */
	void enterValues(JepetoParser.ValuesContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#values}.
	 * @param ctx the parse tree
	 */
	void exitValues(JepetoParser.ValuesContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#listValue}.
	 * @param ctx the parse tree
	 */
	void enterListValue(JepetoParser.ListValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#listValue}.
	 * @param ctx the parse tree
	 */
	void exitListValue(JepetoParser.ListValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#boolValue}.
	 * @param ctx the parse tree
	 */
	void enterBoolValue(JepetoParser.BoolValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#boolValue}.
	 * @param ctx the parse tree
	 */
	void exitBoolValue(JepetoParser.BoolValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#voidValue}.
	 * @param ctx the parse tree
	 */
	void enterVoidValue(JepetoParser.VoidValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#voidValue}.
	 * @param ctx the parse tree
	 */
	void exitVoidValue(JepetoParser.VoidValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link JepetoParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(JepetoParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JepetoParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(JepetoParser.IdentifierContext ctx);
}