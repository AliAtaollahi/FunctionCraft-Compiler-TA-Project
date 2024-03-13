package main.ast.nodes.expression.values;

import main.visitor.IVisitor;

public class VoidValue extends Value{
    public VoidValue() {}
    @Override
    public String toString() {
        return "VoidValue";
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
