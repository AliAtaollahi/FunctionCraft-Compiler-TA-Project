package main.ast.nodes.statement;

import main.ast.nodes.expression.Expression;
import main.ast.nodes.expression.Identifier;

import java.util.ArrayList;

//visit Identifier first
public class FilterStatement extends Statement{
    private Identifier filterId;
    private Expression filterExpression;
    private ArrayList<Expression> conditionalExpressions = new ArrayList<>();
    private ArrayList<Expression> rangeExpressions = new ArrayList<>();

}
