package main.ast.nodes.expression;

import main.visitor.IVisitor;

//line -> DOT
public class ListSize extends Expression {
    private Expression instance;
    public ListSize (Expression instance) {
        this.instance = instance;
    }
    public Expression getInstance() {
        return instance;
    }
    @Override
    public String toString() {
        return "listSize";
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }


}
