package main.visitor.type;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.FunctionDeclaration;
import main.ast.nodes.declaration.MainDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.value.FunctionPointer;
import main.ast.nodes.expression.value.ListValue;
import main.ast.nodes.expression.value.primitive.BoolValue;
import main.ast.nodes.expression.value.primitive.IntValue;
import main.ast.nodes.expression.value.primitive.StringValue;
import main.ast.nodes.statement.*;
import main.ast.type.*;
import main.ast.type.primitiveType.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemAlreadyExists;
import main.symbolTable.exceptions.ItemNotFound;
import main.symbolTable.item.FunctionItem;
import main.symbolTable.item.VarItem;
import main.visitor.Visitor;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class TypeChecker extends Visitor<Type> {


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
            //TODO:default arguments
            for(Expression expression:accessExpression.getArguments()){
                argTypes.add(expression.accept(this));
            }
            Identifier functionName = (Identifier)accessExpression.getAccessedExpression();
            try {
                FunctionItem functionItem = (FunctionItem) SymbolTable.root.getItem(FunctionItem.START_KEY + functionName.getName());
                functionItem.setArgumentTypes(argTypes);
                return functionItem.getFunctionDeclaration().accept(this);
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
        return returnStatement.getReturnExp().accept(this);
    }
    @Override
    public Type visit(ExpressionStatement expressionStatement){
        return expressionStatement.getExpression().accept(this);

    }
    @Override
    public Type visit(ForStatement forStatement){
        SymbolTable.push(SymbolTable.top.copy());
        Set<Type> rangeTypes = new LinkedHashSet<>();
        for(Expression expression : forStatement.getRangeExpressions())
            rangeTypes.add(expression.accept(this));
        if(rangeTypes.size() != 1){
            return null;//TODO:Error
        }
        else{
            VarItem varItem = new VarItem(forStatement.getIteratorId());
            try{
                SymbolTable.top.put(varItem);
            }catch (ItemAlreadyExists ignored){}
        }
        for(Statement statement : forStatement.getLoopBodyStmts())
            statement.accept(this);
        SymbolTable.pop();
        return null;
    }
    @Override
    public Type visit(IfStatement ifStatement){
        SymbolTable.push(SymbolTable.top.copy());
        for(Expression expression:ifStatement.getConditions())
            if(!(expression.accept(this) instanceof BoolType))
                break; // TODO: Gives error
        for(Statement statement : ifStatement.getThenBody())
            statement.accept(this);
        for(Statement statement : ifStatement.getElseBody())
            statement.accept(this);
        SymbolTable.pop();
        return null;
    }
    @Override
    public Type visit(LoopDoStatement loopDoStatement){
        SymbolTable.push(SymbolTable.top.copy());
        for(Statement statement : loopDoStatement.getLoopBodyStmts())
            statement.accept(this);
        SymbolTable.pop();
        return null;
    }
    @Override
    public Type visit(AssignStatement assignStatement){
        if(assignStatement.isAccessList()){
            
        }
        else{

        }
    }
    @Override
    public Type visit(BreakStatement breakStatement){
        for(Expression expression : breakStatement.getConditions())
            if(!((expression.accept(this)) instanceof BoolType))
                break; // TODO: Gives error

        return null;
    }
    @Override
    public Type visit(NextStatement nextStatement){
        for(Expression expression : nextStatement.getConditions())
            if(!((expression.accept(this)) instanceof BoolType))
                break; // TODO: Gives error

        return null;
    }
    @Override
    public Type visit(PushStatement pushStatement){
        Type initType = pushStatement.getInitial().accept(this);
        Type toBeAddedType = pushStatement.getToBeAdded().accept(this);
        if(!initType.sameType(toBeAddedType)){
            return null;//TODO:error
        }
        if(!(initType instanceof ListType) && ! (initType instanceof StringType)){
            return null; //TODO:error
        }

        return null;

    }
    @Override
    public Type visit(PutStatement putStatement){
        Type put = putStatement.getExpression().accept(this);
        if(!(put instanceof StringType)){
            return null;//TODO:error?
        }
        return null;
    }
    @Override
    public Type visit(BoolValue boolValue){
        return new BoolType();
    }
    @Override
    public Type visit(IntValue intValue){
        return new IntType();
    }
    @Override
    public Type visit(StringValue stringValue){
        return new StringType();
    }
    @Override
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
    @Override
    public Type visit(FunctionPointer functionPointer){
        return new FptrType(functionPointer.getId().getName());
    }
    @Override
    public Type visit(AppendExpression appendExpression){
        Type appendeeType = appendExpression.getAppendee().accept(this);
        Set<Type> appendedTypes = new LinkedHashSet<>();
        for(Expression expression: appendExpression.getAppendeds()){
            appendedTypes.add(expression.accept(this));
        }
        if(appendedTypes.size() != 1){
            return new NoType();//TODO:error
        }
        if(!appendeeType.sameType(appendedTypes.stream().toList().getFirst())){
            return new NoType();//TODO:error
        }
        return appendeeType;
    }
    @Override
    public Type visit(BinaryExpression binaryExpression){
        Type leftOpType = binaryExpression.getFirstOperand().accept(this);
        Type rightOpType = binaryExpression.getSecondOperand().accept(this);
        if(!leftOpType.sameType(rightOpType)){
            return new NoType();//TODO:error
        }
        if(!(leftOpType instanceof FloatType) && !(leftOpType instanceof IntType) && !(leftOpType instanceof StringType)){
            return new NoType();//TODO:error
        }
        return leftOpType;
    }

    @Override
    public Type visit(ChompStatement chompStatement){
        return chompStatement.getChompExpression().accept(this);
    }
    @Override
    public Type visit(ChopStatement chopStatement){
        return chopStatement.getChopExpression().accept(this);
    }
    @Override
    public Type visit(Identifier identifier){
        try {
            VarItem varItem = (VarItem) SymbolTable.top.getItem(VarItem.START_KEY + identifier.getName());
            return varItem.getType();

        }catch (ItemNotFound ignored){}
        return new NoType();
    }

    @Override
    public Type visit(LambdaExpression lambdaExpression){
        return new NoType();//TODO:do
    }
    @Override
    public Type visit(LenStatement lenStatement){
        Type queryType = lenStatement.getExpression().accept(this);
        if(!(queryType instanceof StringType) && !(queryType instanceof ListType)){
            return new NoType();//TODO:error
        }
        return new IntType();
    }
    @Override
    public Type visit(MatchPatternStatement matchPatternStatement){
        return new NoType();//TODO:do
    }
    @Override
    public Type visit(UnaryExpression unaryExpression){
        Type expressionType = unaryExpression.getExpression().accept(this);
        if(!(expressionType instanceof IntType) && !(expressionType instanceof FloatType)){
            return new NoType();//TODO:error
        }
        return expressionType;
    }





}
