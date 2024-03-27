package main.symbolTable.items;

import main.ast.nodes.declaration.FunctionDeclaration;
import main.symbolTable.SymbolTable;

public class FunctionSymbolTableItem extends SymbolTableItem {
    public static final String START_KEY = "Function_";
    private SymbolTable FunctionSymbolTable;
    private FunctionDeclaration funcDeclaration;

    public FunctionSymbolTableItem(FunctionDeclaration funcDeclaration) {
        this.funcDeclaration = funcDeclaration;
        this.name = funcDeclaration.getFunctionName().getName();
    }

    public SymbolTable getFunctionSymbolTable() {
        return FunctionSymbolTable;
    }

    public void setFunctionSymbolTable(SymbolTable functionSymbolTable) {
        FunctionSymbolTable = functionSymbolTable;
    }

    public FunctionDeclaration getFuncDeclaration() {
        return funcDeclaration;
    }

    public void setFuncDeclaration(FunctionDeclaration funcDeclaration) {
        this.funcDeclaration = funcDeclaration;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getKey() {
        return START_KEY + this.name;
    }
}
