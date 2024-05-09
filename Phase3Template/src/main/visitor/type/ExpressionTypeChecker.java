package main.visitor.type;

import main.ast.nodes.expression.Expression;
import main.ast.type.Type;
import main.symbolTable.SymbolTable;
import main.visitor.Visitor;

public class ExpressionTypeChecker extends Visitor<Type> {
    private SymbolTable symbolTable = new SymbolTable();

    public void setSymbolTable(SymbolTable symbolTable){this.symbolTable = symbolTable;}
    public Type visit(Expression expression){
        return expression.accept(this);
    }
}
