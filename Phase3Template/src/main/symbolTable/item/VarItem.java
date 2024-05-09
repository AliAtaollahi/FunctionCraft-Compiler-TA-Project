package main.symbolTable.item;

import main.ast.nodes.expression.Identifier;
import main.ast.type.Type;

public class VarItem extends SymbolTableItem{
    public static String START_KEY = "VAR:";
    public VarItem(Identifier identifier){
        this.name = identifier.getName();
    }
    public Type type;
    @Override
    public String getKey(){return START_KEY + this.name;}
}
