package main.ast.nodes.expression;

import main.ast.nodes.expression.operators.UnaryOperator;
import main.visitor.IVisitor;

//line -> NOT or MINUS
public class UnaryExpression extends Expression{
    private Expression operand;
    private UnaryOperator operator;

    public UnaryExpression(Expression operand, UnaryOperator operator) {
        this.operand = operand;
        this.operator = operator;
    }

    public Expression getOperand() {
        return operand;
    }

    public void setOperand(Expression operand) {
        this.operand = operand;
    }

    public UnaryOperator getOperator() {
        return operator;
    }

    public void setOperator(UnaryOperator operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "UnaryExpression_" + this.operator.name();
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
