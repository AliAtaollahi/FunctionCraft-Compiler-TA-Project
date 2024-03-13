package main.visitor.name;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.*;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.values.*;
import main.ast.nodes.statement.*;
import main.compileError.nameError.*;
import main.symbolTable.*;
import main.symbolTable.exceptions.*;
import main.symbolTable.items.*;
import main.visitor.Visitor;

import java.util.*;

public class NameAnalyser extends Visitor<Void> {
    private int newFunctionNameId = 1;
    private int numOfAnonymous = 0;
    private boolean isInFunctionCall = false;
    private boolean funcDeclared;
    private FunctionDeclaration fDec;

    @Override
    public Void visit(Program program) {
        SymbolTable root = new SymbolTable();
        SymbolTable.root = root;
        SymbolTable.push(root);

        for (FunctionDeclaration funcDec: program.getFunctions()) {
            SymbolTable newSymbolTable = new SymbolTable();
            FunctionSymbolTableItem newSymbolTableItem = new FunctionSymbolTableItem(funcDec);
            newSymbolTableItem.setFunctionSymbolTable(newSymbolTable);
            try {
                root.put(newSymbolTableItem);

            } catch (ItemAlreadyExistsException e) {
                DuplicateFunction exception = new DuplicateFunction(funcDec.getLine(), funcDec.getFunctionName().getName());
                funcDec.addError(exception);
                String newName = funcDec.getFunctionName().getName() + newFunctionNameId + "@";
                newFunctionNameId += 1;
                funcDec.setFunctionName(new Identifier(newName));
                try {
                    FunctionSymbolTableItem newFuncSym = new FunctionSymbolTableItem(funcDec);
                    newFuncSym.setFunctionSymbolTable(newSymbolTable);
                    root.put(newFuncSym);
                } catch (ItemAlreadyExistsException e1) { //Unreachable
                }
            }
            SymbolTable.push(newSymbolTable);
        }

        program.getMain().accept(this);
        for (FunctionDeclaration funcDec: program.getFunctions()){
            SymbolTableItem curSymbolTableItem;
            FunctionSymbolTableItem functionSymbolTableItem;
            try{
                curSymbolTableItem = SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + funcDec.getFunctionName().getName());
                functionSymbolTableItem = (FunctionSymbolTableItem) curSymbolTableItem;
                SymbolTable.push(functionSymbolTableItem.getFunctionSymbolTable());
                funcDec.accept(this);
                SymbolTable.pop();
            }catch (ItemNotFoundException e){ //Unreachable
            }
        }
        return null;
    }

    @Override
    public Void visit (MainDeclaration mainDeclaration) {
        mainDeclaration.getBody().accept(this);
        return null;
    }

    @Override
    public Void visit (FunctionDeclaration funcDec) {
        for (Identifier arg: funcDec.getArgs()) {
            VariableSymbolTableItem varSym = new VariableSymbolTableItem(arg);
            try {
                SymbolTable.top.put(varSym);

            } catch (ItemAlreadyExistsException e) {
                DuplicateArgument exception = new DuplicateArgument(arg.getLine(), arg.getName());
                funcDec.addError(exception);
            }
            try{
                SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + arg.getName());
                NameConflict exception = new NameConflict(arg.getLine(), arg.getName());
                funcDec.addError(exception);
            }catch (ItemNotFoundException e) {
                //unreachable
            }
        }
        funcDec.getBody().accept(this);
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
        conditionalStmt.getCondition().accept(this);
        conditionalStmt.getThenBody().accept(this);
        if(conditionalStmt.getElseBody() != null) {
            conditionalStmt.getElseBody().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(FunctionCallStmt funcCallStmt) {
        funcCallStmt.getFunctionCall().accept(this);
        return null;
    }

    @Override
    public Void visit(PrintStmt print) {
        print.getArg().accept(this);
        return null;
    }

    @Override
    public Void visit(ReturnStmt returnStmt) {
        returnStmt.getReturnedExpr().accept(this);
        return null;
    }

    @Override
    public Void visit(BinaryExpression binaryExpression) {
        binaryExpression.getFirstOperand().accept(this);
        binaryExpression.getSecondOperand().accept(this);
        return null;
    }

    @Override
    public Void visit(UnaryExpression unaryExpression) {
        unaryExpression.getOperand().accept(this);
        return null;
    }

    @Override
    public Void visit(AnonymousFunction anonymousFunction) {
        if (isInFunctionCall){
            isInFunctionCall = false;
        }
        numOfAnonymous += 1;
        SymbolTable anonymousSymbolTable = new SymbolTable();
        FunctionDeclaration anonymousDec = new FunctionDeclaration();
        FunctionSymbolTableItem anonymousSymbolTableItem;
        anonymousFunction.setName("anonymous" + numOfAnonymous);


        anonymousDec.setFunctionName(new Identifier(anonymousFunction.getName()));
        anonymousDec.setArgs(anonymousFunction.getArgs());
        anonymousDec.setBody(anonymousFunction.getBody());
        anonymousDec.setLine(anonymousFunction.getLine());

        SymbolTable.push(anonymousSymbolTable);
        for (Identifier arg: anonymousFunction.getArgs()) {
            VariableSymbolTableItem varSym = new VariableSymbolTableItem(arg);
            try {
                SymbolTable.top.put(varSym);

            } catch (ItemAlreadyExistsException e) {
                DuplicateArgument exception = new DuplicateArgument(arg.getLine(), arg.getName());
                arg.addError(exception);
            }
            try{
                SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + arg.getName());
                NameConflict exception = new NameConflict(arg.getLine(), arg.getName());
                arg.addError(exception);
            }catch (ItemNotFoundException e) {//unreachable
            }
        }
        anonymousFunction.getBody().accept(this);

        anonymousSymbolTableItem = new FunctionSymbolTableItem(anonymousDec);
        anonymousSymbolTableItem.setFunctionSymbolTable(SymbolTable.top);

        try {
            SymbolTable.root.put(anonymousSymbolTableItem);

        } catch (ItemAlreadyExistsException e) {//unreachable
        }
        SymbolTable.pop();
        return null;
    }


    @Override
    public Void visit(Identifier identifier) {
        try{
            FunctionSymbolTableItem fItem = (FunctionSymbolTableItem) SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + identifier.getName());
            fDec = fItem.getFuncDeclaration();
            if(isInFunctionCall)
                funcDeclared = true;

        }catch (ItemNotFoundException e) {
            try{
                SymbolTable.top.getItem(VariableSymbolTableItem.START_KEY + identifier.getName());
            } catch (ItemNotFoundException e1) {
                if (isInFunctionCall) {
                    FunctionNotDeclared exception = new FunctionNotDeclared(identifier.getLine(), identifier.getName());
                    identifier.addError(exception);
                }
                else{
                    VariableNotDeclared exception = new VariableNotDeclared(identifier.getLine(), identifier.getName());
                    identifier.addError(exception);
                }
            }
        }
        return null;
    }

    @Override
    public Void visit(ListAccessByIndex listAccessByIndex) {
        listAccessByIndex.getInstance().accept(this);
        listAccessByIndex.getIndex().accept(this);
        return null;
    }

    @Override
    public Void visit(ListSize listSize) {
        listSize.getInstance().accept(this);
        return null;
    }

    @Override
    public Void visit(FunctionCall funcCall) {
        isInFunctionCall = true;
        funcCall.getInstance().accept(this);
        isInFunctionCall = false;

        for (Expression args: funcCall.getArgs()) {
            args.accept(this);
        }
        Set<String> arguments = new HashSet<>();
        if (funcDeclared) {
            for (Identifier id : fDec.getArgs())
                arguments.add(id.getName());
        }
        if (funcDeclared) {
            for (Map.Entry<Identifier,Expression> argsWithKey: funcCall.getArgsWithKey().entrySet()){
                argsWithKey.getValue().accept(this);
                if ( ! arguments.contains(argsWithKey.getKey().getName())) {
                    ArgumentNotDeclared exception = new ArgumentNotDeclared(argsWithKey.getKey().getLine(),
                            argsWithKey.getKey().getName(),
                            fDec.getFunctionName().getName());
                    funcCall.addError(exception);
                }
            }
        }
        funcDeclared = false;
        return null;
    }

    @Override
    public Void visit(ListValue listValue) {
        for (Expression element : listValue.getElements())
            element.accept(this);
        return null;
    }
}
