package main.ast.nodes.expression.values.primitive;

import main.ast.nodes.expression.values.Value;
import main.visitor.IVisitor;

//line -> STRING_VALUE
public class StringValue extends Value {
    private String constant;

    public StringValue(String constant) {
        this.constant = constant;
    }

    public String getConstant() {
        return constant;
    }

    public void setConstant(String constant) {
        this.constant = constant;
    }

    @Override
    public String toString() {
        return "StringValue_" + this.constant;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
