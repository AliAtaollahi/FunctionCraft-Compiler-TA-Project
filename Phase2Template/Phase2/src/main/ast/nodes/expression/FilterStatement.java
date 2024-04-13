package main.ast.nodes.expression;

import main.visitor.IVisitor;

import java.util.ArrayList;

public class FilterStatement extends Expression{
    private Identifier iteratorId;
    private Expression filterExpression;
    private ArrayList<Expression> conditionalExpressions = new ArrayList<>();
    private ArrayList<Expression> rangeExpressions = new ArrayList<>();
    public FilterStatement(Identifier iteratorId, Expression filterExpression,
                           ArrayList<Expression> conditionalExpressions,
                           ArrayList<Expression> rangeExpressions){
        this.iteratorId = iteratorId;
        this.filterExpression =filterExpression;
        this.conditionalExpressions = conditionalExpressions;
        this.rangeExpressions = rangeExpressions;
    }

    public void setRangeExpressions(ArrayList<Expression> rangeExpressions) {
        this.rangeExpressions = rangeExpressions;
    }

    public void setIteratorId(Identifier iteratorId) {
        this.iteratorId = iteratorId;
    }

    public void setConditionalExpressions(ArrayList<Expression> conditionalExpressions) {
        this.conditionalExpressions = conditionalExpressions;
    }

    public void setFilterExpression(Expression filterExpression) {
        this.filterExpression = filterExpression;
    }

    public Identifier getIteratorId() {
        return iteratorId;
    }

    public ArrayList<Expression> getRangeExpressions() {
        return rangeExpressions;
    }

    public Expression getFilterExpression() {
        return filterExpression;
    }

    public ArrayList<Expression> getConditionalExpressions() {
        return conditionalExpressions;
    }
    @Override
    public String toString(){return "FilterOn:" + this.iteratorId.getName();}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
}
