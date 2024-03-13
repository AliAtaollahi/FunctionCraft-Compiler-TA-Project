package main.compileError.typeErrors;

import main.ast.nodes.statement.ReturnStmt;
import main.compileError.CompileError;

public class ReturnValueNotMatchFunctionReturnType extends CompileError{

    public ReturnValueNotMatchFunctionReturnType(ReturnStmt returnStmt) {
        super(returnStmt.getLine(), "Return value does not match with function return type");
    }

}
