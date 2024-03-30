package main.ast.nodes.statement;

import main.ast.nodes.expression.Expression;
import main.visitor.IVisitor;

//line -> RETURN
public class ReturnStmt extends Statement{
    private Expression returnedExpr;

    public ReturnStmt() {
    }

    public ReturnStmt(Expression returnedExpr) {
        this.returnedExpr = returnedExpr;
    }

    public Expression getReturnedExpr() {
        return returnedExpr;
    }

    public void setReturnedExpr(Expression returnedExpr) {
        this.returnedExpr = returnedExpr;
    }

    @Override
    public String toString() {
        return "ReturnStmt";
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
            return visitor.visit(this);
    }
}
