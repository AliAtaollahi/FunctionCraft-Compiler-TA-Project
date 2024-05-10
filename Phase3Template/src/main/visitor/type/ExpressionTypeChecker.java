package main.visitor.type;

import main.ast.nodes.expression.Expression;
import main.ast.nodes.expression.Identifier;
import main.ast.nodes.expression.value.ListValue;
import main.ast.nodes.expression.value.primitive.BoolValue;
import main.ast.nodes.expression.value.primitive.IntValue;
import main.ast.nodes.expression.value.primitive.StringValue;
import main.ast.type.ListType;
import main.ast.type.Type;
import main.ast.type.primitiveType.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFound;
import main.symbolTable.item.VarItem;
import main.visitor.Visitor;

import java.util.LinkedHashSet;
import java.util.Set;

public class ExpressionTypeChecker extends Visitor<Type> {
    private SymbolTable symbolTable = new SymbolTable();

    public void setSymbolTable(SymbolTable symbolTable){this.symbolTable = symbolTable;}
    public Type visit(Expression expression){
        return expression.accept(this);
    }
    public Type visit(Identifier identifier){
        try {
            VarItem item = (VarItem) symbolTable.getItem(VarItem.START_KEY + identifier.getName());
            return item.getType();
        }catch (ItemNotFound ignored){}
        return null;
    }
    public Type visit(BoolValue boolValue){
        return new BoolType();
    }
    public Type visit(IntValue intValue){
        return new IntType();
    }
    public Type visit(StringValue stringValue){
        return new StringType();
    }
    public Type visit(ListValue listValue){
        Set<Type> listTypes = new LinkedHashSet<>();
        for(Expression expression : listValue.getElements()){
            listTypes.add(expression.accept(this));
        }
        if(listTypes.size() != 1){
            return null;//TODO:Error
        }
        return new ListType(listTypes.stream().toList().getFirst());
    }
}
