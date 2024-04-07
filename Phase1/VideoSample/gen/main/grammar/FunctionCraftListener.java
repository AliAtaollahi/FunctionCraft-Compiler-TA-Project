// Generated from D:/8/TA/Compiler/Design-Compiler-Course-Projects/Phase1/VideoSample/src/main/grammar/FunctionCraft.g4 by ANTLR 4.13.1
package main.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FunctionCraftParser}.
 */
public interface FunctionCraftListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(FunctionCraftParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(FunctionCraftParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#primitive}.
	 * @param ctx the parse tree
	 */
	void enterPrimitive(FunctionCraftParser.PrimitiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#primitive}.
	 * @param ctx the parse tree
	 */
	void exitPrimitive(FunctionCraftParser.PrimitiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#primitive_val}.
	 * @param ctx the parse tree
	 */
	void enterPrimitive_val(FunctionCraftParser.Primitive_valContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#primitive_val}.
	 * @param ctx the parse tree
	 */
	void exitPrimitive_val(FunctionCraftParser.Primitive_valContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#primitive_val_sign}.
	 * @param ctx the parse tree
	 */
	void enterPrimitive_val_sign(FunctionCraftParser.Primitive_val_signContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#primitive_val_sign}.
	 * @param ctx the parse tree
	 */
	void exitPrimitive_val_sign(FunctionCraftParser.Primitive_val_signContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(FunctionCraftParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(FunctionCraftParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(FunctionCraftParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(FunctionCraftParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#body_function}.
	 * @param ctx the parse tree
	 */
	void enterBody_function(FunctionCraftParser.Body_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#body_function}.
	 * @param ctx the parse tree
	 */
	void exitBody_function(FunctionCraftParser.Body_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(FunctionCraftParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(FunctionCraftParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(FunctionCraftParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(FunctionCraftParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#forloop}.
	 * @param ctx the parse tree
	 */
	void enterForloop(FunctionCraftParser.ForloopContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#forloop}.
	 * @param ctx the parse tree
	 */
	void exitForloop(FunctionCraftParser.ForloopContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(FunctionCraftParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(FunctionCraftParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(FunctionCraftParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(FunctionCraftParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#initialization}.
	 * @param ctx the parse tree
	 */
	void enterInitialization(FunctionCraftParser.InitializationContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#initialization}.
	 * @param ctx the parse tree
	 */
	void exitInitialization(FunctionCraftParser.InitializationContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#initialization_array}.
	 * @param ctx the parse tree
	 */
	void enterInitialization_array(FunctionCraftParser.Initialization_arrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#initialization_array}.
	 * @param ctx the parse tree
	 */
	void exitInitialization_array(FunctionCraftParser.Initialization_arrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterFunction_call(FunctionCraftParser.Function_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitFunction_call(FunctionCraftParser.Function_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#predicate_def}.
	 * @param ctx the parse tree
	 */
	void enterPredicate_def(FunctionCraftParser.Predicate_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#predicate_def}.
	 * @param ctx the parse tree
	 */
	void exitPredicate_def(FunctionCraftParser.Predicate_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#implication}.
	 * @param ctx the parse tree
	 */
	void enterImplication(FunctionCraftParser.ImplicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#implication}.
	 * @param ctx the parse tree
	 */
	void exitImplication(FunctionCraftParser.ImplicationContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#query_bool}.
	 * @param ctx the parse tree
	 */
	void enterQuery_bool(FunctionCraftParser.Query_boolContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#query_bool}.
	 * @param ctx the parse tree
	 */
	void exitQuery_bool(FunctionCraftParser.Query_boolContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#query_list}.
	 * @param ctx the parse tree
	 */
	void enterQuery_list(FunctionCraftParser.Query_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#query_list}.
	 * @param ctx the parse tree
	 */
	void exitQuery_list(FunctionCraftParser.Query_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(FunctionCraftParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(FunctionCraftParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#expr_other}.
	 * @param ctx the parse tree
	 */
	void enterExpr_other(FunctionCraftParser.Expr_otherContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#expr_other}.
	 * @param ctx the parse tree
	 */
	void exitExpr_other(FunctionCraftParser.Expr_otherContext ctx);
}