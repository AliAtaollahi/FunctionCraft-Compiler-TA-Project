// Generated from D:/8/TA/Compiler/Design-Compiler-Course-Projects/Phase1/VideoSample/src/main/grammar/FunctionCraft.g4 by ANTLR 4.13.1
package main.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FunctionCraftParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FunctionCraftVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(FunctionCraftParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#primitive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitive(FunctionCraftParser.PrimitiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#primitive_val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitive_val(FunctionCraftParser.Primitive_valContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#primitive_val_sign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitive_val_sign(FunctionCraftParser.Primitive_val_signContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(FunctionCraftParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(FunctionCraftParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#body_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody_function(FunctionCraftParser.Body_functionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(FunctionCraftParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(FunctionCraftParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#forloop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForloop(FunctionCraftParser.ForloopContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(FunctionCraftParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(FunctionCraftParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#initialization}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitialization(FunctionCraftParser.InitializationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#initialization_array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitialization_array(FunctionCraftParser.Initialization_arrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(FunctionCraftParser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#predicate_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate_def(FunctionCraftParser.Predicate_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#implication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplication(FunctionCraftParser.ImplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#query_bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery_bool(FunctionCraftParser.Query_boolContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#query_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery_list(FunctionCraftParser.Query_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(FunctionCraftParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#expr_other}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_other(FunctionCraftParser.Expr_otherContext ctx);
}