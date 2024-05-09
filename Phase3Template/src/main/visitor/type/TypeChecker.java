package main.visitor.type;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.FunctionDeclaration;
import main.ast.nodes.declaration.MainDeclaration;
import main.ast.nodes.expression.AccessExpression;
import main.ast.nodes.expression.Expression;
import main.ast.nodes.expression.Identifier;
import main.ast.nodes.statement.*;
import main.ast.type.*;
import main.ast.type.primitiveType.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemAlreadyExists;
import main.symbolTable.exceptions.ItemNotFound;
import main.symbolTable.item.FunctionItem;
import main.visitor.Visitor;

import java.util.ArrayList;

public class TypeChecker extends Visitor<Type> {
    ExpressionTypeChecker expressionTypeChecker = new ExpressionTypeChecker();
    @Override
    public Type visit(Program program){
        SymbolTable.root = new SymbolTable();
        SymbolTable.top = new SymbolTable();
        for(FunctionDeclaration functionDeclaration : program.getFunctionDeclarations()){
            FunctionItem functionItem = new FunctionItem(functionDeclaration);
            try {
                SymbolTable.root.put(functionItem);
            }catch (ItemAlreadyExists ignored){}
        }
        //TODO:patterns

        program.getMain().accept(this);

        return null;
    }
    @Override
    public Type visit(MainDeclaration mainDeclaration){
        for(Statement statement : mainDeclaration.getBody()) {
            statement.accept(this);
        }
        return null;
    }
    //TODO:Statements
    @Override
    public Type visit(AccessExpression accessExpression){
        if(accessExpression.isFunctionCall()){
            ArrayList<Type> argTypes = new ArrayList<>();
            expressionTypeChecker.setSymbolTable(SymbolTable.top);
            //TODO:default arguments
            for(Expression expression:accessExpression.getArguments()){
                argTypes.add(expression.accept(expressionTypeChecker));
            }
            Identifier functionName = (Identifier)accessExpression.getAccessedExpression();
            try {
                FunctionItem functionItem = (FunctionItem) SymbolTable.root.getItem(FunctionItem.START_KEY + functionName.getName());
                functionItem.setArgumentTypes(argTypes);
                Type functionType = functionItem.getFunctionDeclaration().accept(this);
            }catch (ItemNotFound ignored){}

        }
        return null;
    }
    @Override
    public Type visit(FunctionDeclaration functionDeclaration){
        for(Statement statement : functionDeclaration.getBody()){
            if(statement instanceof ReturnStatement returnStatement){
                return returnStatement.accept(this);
            }
            else{
                statement.accept(this);
            }
        }
        return null;
    }
    @Override
    public Type visit(ReturnStatement returnStatement){
        expressionTypeChecker.setSymbolTable(SymbolTable.top);
        return returnStatement.getReturnExp().accept(expressionTypeChecker);
    }
    @Override
    public Type visit(ExpressionStatement expressionStatement){
        expressionTypeChecker.setSymbolTable(SymbolTable.top);
        return expressionStatement.getExpression().accept(expressionTypeChecker);

    }
    @Override
    public Type visit(ForStatement forStatement){
        expressionTypeChecker.setSymbolTable(SymbolTable.top);
        for(Expression expression : forStatement.getRangeExpressions())
            expression.accept(expressionTypeChecker);
        for(Statement statement : forStatement.getLoopBodyStmts())
            statement.accept(this);

        return null;
    }
    @Override
    public Type visit(IfStatement ifStatement){
        expressionTypeChecker.setSymbolTable(SymbolTable.top);
        for(Expression expression:ifStatement.getConditions())
            if(!(expression.accept(expressionTypeChecker) instanceof BoolType))
                break; // TODO: Gives error
        for(Statement statement : ifStatement.getThenBody())
            statement.accept(this);
        for(Statement statement : ifStatement.getElseBody())
            statement.accept(this);

        return null;
    }
    @Override
    public Type visit(LoopDoStatement loopDoStatement){
        expressionTypeChecker.setSymbolTable(SymbolTable.top);
        for(Statement statement : loopDoStatement.getLoopBodyStmts())
            statement.accept(this);

        return null;
    }

    @Override
    public Type visit(BreakStatement breakStatement){
        expressionTypeChecker.setSymbolTable(SymbolTable.top);
        for(Expression expression : breakStatement.getConditions())
            if(!((expression.accept(expressionTypeChecker)) instanceof BoolType))
                break; // TODO: Gives error

        return null;
    }
    @Override
    public Type visit(NextStatement nextStatement){
        expressionTypeChecker.setSymbolTable(SymbolTable.top);
        for(Expression expression : nextStatement.getConditions())
            if(!((expression.accept(expressionTypeChecker)) instanceof BoolType))
                break; // TODO: Gives error

        return null;
    }
    @Override
    public Type visit(PushStatement pushStatement){
        expressionTypeChecker.setSymbolTable(SymbolTable.top);
        Type initType = pushStatement.getInitial().accept(expressionTypeChecker);
        Type toBeAddedType = pushStatement.getToBeAdded().accept(expressionTypeChecker);
        if(!(initType instanceof ListType && toBeAddedType instanceof ListType) ||
            !(initType instanceof StringType && toBeAddedType instanceof StringType))
            System.out.println("aa"); // TODO: Gives error

        return null;

    }
    @Override
    public Type visit(PutStatement putStatement){
        expressionTypeChecker.setSymbolTable(SymbolTable.top);
        putStatement.getExpression().accept(expressionTypeChecker);

        return null;
    }
}
