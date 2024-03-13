package main.symbolTable.items;



import main.ast.nodes.expression.Identifier;
import main.ast.types.Type;

public class VariableSymbolTableItem extends SymbolTableItem {
    public static String START_KEY = "Var_";
    protected Type type;

    public VariableSymbolTableItem(Identifier id) {
        this.name = id.getName();
    }

    public String getKey() {
        return START_KEY + this.name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}
