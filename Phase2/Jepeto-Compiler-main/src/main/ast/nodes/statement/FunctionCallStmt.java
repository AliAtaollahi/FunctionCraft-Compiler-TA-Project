package main.ast.nodes.statement;

import main.ast.nodes.expression.FunctionCall;
import main.visitor.IVisitor;

//line -> LPAR before arguments
public class FunctionCallStmt extends Statement{
    private FunctionCall funcCall;

    public FunctionCallStmt(FunctionCall funcCall) {
        this.funcCall = funcCall;
    }

    public FunctionCall getFunctionCall() {
        return funcCall;
    }

    public void setFunctionCall(FunctionCall methodCall) {
        this.funcCall = methodCall;
    }

    @Override
    public String toString() {
        return "FunctionCallStmt";
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
