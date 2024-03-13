package main.visitor.type;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.FunctionDeclaration;
import main.ast.nodes.declaration.MainDeclaration;
import main.ast.nodes.statement.*;
import main.ast.types.NoType;
import main.ast.types.Type;
import main.ast.types.functionPointer.FptrType;
import main.ast.types.single.BoolType;
import main.compileError.typeErrors.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.FunctionSymbolTableItem;
import main.visitor.Visitor;

import java.util.*;

public class TypeCheker extends Visitor<Void> {
    private ExpressionTypeChecker expressionTypeChecker;
    private FunctionSymbolTableItem curFunction;
    private Set<String> visited;

    public TypeCheker(Set<String> visited) {
        expressionTypeChecker = new ExpressionTypeChecker(this, visited);
        this.visited = visited;
    }

    public void setCurFunction(FunctionSymbolTableItem curFunction) {
        this.curFunction = curFunction;
    }

    public FunctionSymbolTableItem getCurFunction() {
        return curFunction;
    }

    public ExpressionTypeChecker getExpressionTypeChecker(){return expressionTypeChecker;}

    private FunctionSymbolTableItem findFunccSymobolTableItem(FptrType fptr) {
        try{
            FunctionSymbolTableItem func = (FunctionSymbolTableItem) SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + fptr.getFunctionName());
            return func;
        }catch (ItemNotFoundException e){
            return null;
        }

    }


    @Override
    public Void visit(Program program) {
        program.getMain().accept(this);
        for (FunctionDeclaration funcDec: program.getFunctions())
            if (visited.contains(funcDec.getFunctionName().getName()))
                funcDec.accept(this);
        return null;
    }

    @Override
    public Void visit(FunctionDeclaration funcDeclaration) {
        curFunction = findFunccSymobolTableItem(new FptrType(funcDeclaration.getFunctionName().getName()));
        expressionTypeChecker.setCurFunction(curFunction);
        funcDeclaration.getBody().accept(this);
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
        Type condType = conditionalStmt.getCondition().accept(expressionTypeChecker);
        if(!(condType instanceof BoolType || condType instanceof NoType)) {
            ConditionNotBool exception = new ConditionNotBool(conditionalStmt.getLine());
            conditionalStmt.addError(exception);
        }
        conditionalStmt.getThenBody().accept(this);

        if(conditionalStmt.getElseBody() != null) {
            conditionalStmt.getElseBody().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(FunctionCallStmt funcCallStmt) {
        expressionTypeChecker.setFunctioncallStmt(true);
        funcCallStmt.getFunctionCall().accept(expressionTypeChecker);
        expressionTypeChecker.setFunctioncallStmt(false);
        return null;
    }

    @Override
    public Void visit(PrintStmt print) {
        Type argType =  print.getArg().accept(expressionTypeChecker);
        if(argType instanceof FptrType) {
            UnsupportedTypeForPrint exception = new UnsupportedTypeForPrint(print.getLine());
            print.addError(exception);
        }
        return null;
    }

    @Override
    public Void visit(ReturnStmt returnStmt) {
        Type returnType = returnStmt.getReturnedExpr().accept(expressionTypeChecker);
        if(!expressionTypeChecker.sameType(curFunction.getReturnType(), returnType)){
            ReturnValueNotMatchFunctionReturnType exception = new ReturnValueNotMatchFunctionReturnType(returnStmt);
            returnStmt.addError(exception);
        }
        return null;
    }
}
