package main.ast.nodes.expression.values.primitive;

import main.ast.nodes.expression.values.Value;
import main.visitor.IVisitor;

//line -> TRUE or FALSE
public class BoolValue extends Value {
    private boolean constant;

    public BoolValue(boolean constant) {
        this.constant = constant;
    }

    public boolean getConstant() {
        return constant;
    }

    public void setConstant(boolean constant) {
        this.constant = constant;
    }

    @Override
    public String toString() {
        return "BoolValue_" + this.constant;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
