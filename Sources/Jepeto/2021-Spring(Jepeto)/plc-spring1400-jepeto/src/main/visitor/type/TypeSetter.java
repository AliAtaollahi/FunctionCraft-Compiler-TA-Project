package main.visitor.type;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.FunctionDeclaration;
import main.ast.nodes.declaration.MainDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.statement.*;
import main.ast.types.NoType;
import main.ast.types.Type;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.FunctionSymbolTableItem;
import main.visitor.Visitor;

import java.util.*;

public class TypeSetter  extends Visitor<Void> {
    private boolean fcall = false;
    private TypeInference typeInference;
    private Set<String> visited;
    private FunctionSymbolTableItem curFuncSymbolTableItem;
    public TypeSetter() {
        typeInference = new TypeInference(this);
        visited = new HashSet<>();
    }

    public Set<String> getVisited() {
        return visited;
    }

    private SymbolTable findFuncSymbolTable(Identifier name) {
        try {
            FunctionSymbolTableItem fitem = (FunctionSymbolTableItem) SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + name.getName());
            curFuncSymbolTableItem = fitem;
            return fitem.getFunctionSymbolTable();
        }catch (ItemNotFoundException e) {
            return null;
        }

    }

    @Override
    public Void visit(Program program) {
        program.getMain().accept(this);
        visited.clear();
        program.getMain().accept(this);
        for (FunctionDeclaration funcDec : program.getFunctions()) {
            if (! visited.contains(funcDec.getFunctionName().getName()))
                continue;
            try {
                FunctionSymbolTableItem fitem = (FunctionSymbolTableItem) SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + funcDec.getFunctionName().getName());
                FunctionDeclaration fdec = fitem.getFuncDeclaration();
                if (fitem.getReturnType() == null)
                    fitem.setReturnType(new NoType());
//                System.out.println(fdec.getFunctionName().getName());
//                System.out.println(fitem.getArgTypes().values());
//                System.out.println(fitem.getReturnType());
            }catch (ItemNotFoundException e) {

            }

        }
        return null;
    }

    @Override
    public Void visit(FunctionDeclaration funcDeclaration) {
        if(visited.contains(funcDeclaration.getFunctionName().getName()))
            return null;
        visited.add(funcDeclaration.getFunctionName().getName());
        typeInference.addVisited(funcDeclaration.getFunctionName().getName());
        FunctionSymbolTableItem temp = curFuncSymbolTableItem;
        typeInference.setFunctionSymbolTable(findFuncSymbolTable(funcDeclaration.getFunctionName()));
        funcDeclaration.getBody().accept(this);
        curFuncSymbolTableItem = temp;
        if (curFuncSymbolTableItem != null)
            typeInference.setFunctionSymbolTable(curFuncSymbolTableItem.getFunctionSymbolTable());
        return null;

    }

    @Override
    public Void visit(MainDeclaration mainDeclaration) {
        mainDeclaration.getBody().accept(this);
        return null;

    }


    @Override
    public Void visit(BlockStmt blockStmt) {
        for (Statement stmt: blockStmt.getStatements())
            stmt.accept(this);
        return null;
    }

    @Override
    public Void visit(ConditionalStmt conditionalStmt) {
        conditionalStmt.getCondition().accept(typeInference);
        conditionalStmt.getThenBody().accept(this);

        if(conditionalStmt.getElseBody() != null) {
            conditionalStmt.getElseBody().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(FunctionCallStmt funcCallStmt) {
        typeInference.setFunctioncallStmt(true);
        funcCallStmt.getFunctionCall().accept(typeInference);
        typeInference.setFunctioncallStmt(false);
        return null;
    }

    @Override
    public Void visit(PrintStmt print) {
        print.getArg().accept(typeInference);
        return null;
    }

    @Override
    public Void visit(ReturnStmt returnStmt) {
        Type returnType = returnStmt.getReturnedExpr().accept(typeInference);
        if(curFuncSymbolTableItem.getReturnType() == null || curFuncSymbolTableItem.getReturnType() instanceof NoType) {

            curFuncSymbolTableItem.setReturnType(returnType);
        }
        return null;
    }


}
