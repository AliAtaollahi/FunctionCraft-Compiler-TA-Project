package main.ast.nodes.expression.values.primitive;

import main.ast.nodes.expression.values.Value;
import main.visitor.IVisitor;

//line -> INT_VALUE
public class IntValue extends Value {
    private int constant;

    public IntValue(int constant) {
        this.constant = constant;
    }

    public int getConstant() {
        return constant;
    }

    public void setConstant(int constant) {
        this.constant = constant;
    }

    @Override
    public String toString() {
        return "IntValue_" + this.constant;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
