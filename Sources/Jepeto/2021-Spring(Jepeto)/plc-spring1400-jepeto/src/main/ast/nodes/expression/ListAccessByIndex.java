package main.ast.nodes.expression;

import main.visitor.IVisitor;

//line -> LBRACK before index
public class ListAccessByIndex extends Expression {
    private Expression instance;
    private Expression index;

    public ListAccessByIndex(Expression instance, Expression index) {
        this.instance = instance;
        this.index = index;
    }

    public Expression getInstance() {
        return instance;
    }

    public void setInstance(Expression instance) {
        this.instance = instance;
    }

    public Expression getIndex() {
        return index;
    }

    public void setIndex(Expression index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "ListAccessByIndex";
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
