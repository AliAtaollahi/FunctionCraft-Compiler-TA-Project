package main.visitor.type;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.FunctionDeclaration;
import main.ast.nodes.declaration.MainDeclaration;
import main.ast.nodes.declaration.VarDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.value.FunctionPointer;
import main.ast.nodes.expression.value.ListValue;
import main.ast.nodes.expression.value.primitive.BoolValue;
import main.ast.nodes.expression.value.primitive.IntValue;
import main.ast.nodes.expression.value.primitive.StringValue;
import main.ast.nodes.statement.*;
import main.ast.type.*;
import main.ast.type.primitiveType.*;
import main.compileError.CompileError;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemAlreadyExists;
import main.symbolTable.exceptions.ItemNotFound;
import main.symbolTable.item.FunctionItem;
import main.symbolTable.item.VarItem;
import main.visitor.Visitor;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class TypeChecker extends Visitor<Type> {
    public ArrayList<CompileError> typeErrors = new ArrayList<>();
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
                List<VarDeclaration> defaultVals = functionItem.getFunctionDeclaration().getArgs().
                        stream().
                        filter(a->a.getDefaultVal() != null).toList();
                int i = defaultVals.size() - 1;
                while(argTypes.size() < functionItem.getFunctionDeclaration().getArgs().size()){
                    argTypes.add(defaultVals.get(i).getDefaultVal().accept(this));
                    i -= 1;
                }
                functionItem.setArgumentTypes(argTypes);
                return functionItem.getFunctionDeclaration().accept(this);
            }catch (ItemNotFound e){
                Type nonFunctionType = accessExpression.getAccessedExpression().accept(this);
                if(! (nonFunctionType instanceof FptrType fptrType)){
                    return new NoType();//TODO:calling a non callable
                }
                else{
                    try {
                        FunctionItem functionItem = (FunctionItem) SymbolTable.root.getItem(FunctionItem.START_KEY + fptrType.getFunctionName());
                        List<VarDeclaration> defaultVals = functionItem.getFunctionDeclaration().getArgs().
                                stream().
                                filter(a->a.getDefaultVal() != null).toList();
                        int i = defaultVals.size() - 1;
                        while(argTypes.size() < functionItem.getFunctionDeclaration().getArgs().size()){
                            argTypes.add(defaultVals.get(i).getDefaultVal().accept(this));
                            i -= 1;
                        }
                        functionItem.setArgumentTypes(argTypes);
                        return functionItem.getFunctionDeclaration().accept(this);
                    }catch (ItemNotFound ignored){}

                }
            }
        }
        else{
            Type accessedType = accessExpression.getAccessedExpression().accept(this);
            if(!(accessedType instanceof StringType) && !(accessedType instanceof ListType)){
                return new NoType();//TODO:Not Indexable
            }
            Set<Type> accessTypes = new LinkedHashSet<>();
            for(Expression expression : accessExpression.getDimentionalAccess()){
                accessTypes.add(expression.accept(this));
            }
            if(! (accessTypes.stream().toList().getFirst() instanceof IntType)){
                return new NoType();//TODO:INT index only
            }
        }
        return null;
    }
    @Override
    public Type visit(FunctionDeclaration functionDeclaration){
        Set<Type> returnTypes = new LinkedHashSet<>();
        for(Statement statement : functionDeclaration.getBody()){
            if(statement instanceof ReturnStatement returnStatement){
                returnTypes.add(returnStatement.accept(this));
            }
            else{
                statement.accept(this);
            }
        }
        if(returnTypes.size() != 1){
            return new NoType();//TODO:Incompatible return expressions
        }
        return returnTypes.stream().toList().getFirst();
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
        forStatement.getRangeExpression().accept(this);
        VarItem varItem = new VarItem(forStatement.getIteratorId());
        try{
            SymbolTable.top.put(varItem);
        }catch (ItemAlreadyExists ignored){}

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
            if(! (assignStatement.getAccessListExpression().accept(this) instanceof IntType)){
                return new NoType();//TODO:not integer
            }
            try {
                VarItem listItem = (VarItem) SymbolTable.top.getItem(VarItem.START_KEY + assignStatement.getAssignedId().getName());
                Type assignExpType = assignStatement.getAssignExpression().accept(this);
                ListType listType = (ListType) listItem.getType();
                if(! assignExpType.sameType(listType.getType())){
                    return new NoType();//TODO:error
                }
            }catch (ItemNotFound ignored){}
        }
        else{
            Type assignExpType = assignStatement.getAssignExpression().accept(this);
            VarItem newVarItem = new VarItem(assignStatement.getAssignedId());
            newVarItem.setType(assignExpType);
            try {
                SymbolTable.top.put(newVarItem);
            }catch (ItemAlreadyExists ignored){}
        }
        return new NoType();
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
        if(initType instanceof ListType listType){//TODO:handle empty list
            if(!toBeAddedType.sameType(listType.getType())){
                return new NoType();//TODO:list error
            }
        } else if (initType instanceof StringType) {
            if(! (toBeAddedType instanceof StringType)){
                return new NoType();//TODO:string error
            }
        }
        else{
            return new NoType();//TODO:not pushable
        }

        return null;

    }
    @Override
    public Type visit(PutStatement putStatement){
        Type put = putStatement.getExpression().accept(this);
        if(put instanceof FptrType){
            return new NoType();//TODO:not printable
        }
        return put;
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
        Type appendeeType = appendExpression.getAppendee().accept(this);//TODO:only string or list
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
        return chompStatement.getChompExpression().accept(this);//TODO:Only String
    }
    @Override
    public Type visit(ChopStatement chopStatement){
        return chopStatement.getChopExpression().accept(this);//TODO:Only String
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
        return new NoType();
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
    @Override
    public Type visit(RangeExpression rangeExpression){
        if(rangeExpression.getRangeType().equals(RangeType.IDENTIFIER)){
            Identifier rangeIdentifier = (Identifier) rangeExpression.getRangeExpressions().getFirst();
            try{
                VarItem varItem = (VarItem) SymbolTable.top.getItem(VarItem.START_KEY + rangeIdentifier.getName());
                if(! (varItem.getType() instanceof IntType)){
                    return new NoType();//TODO:error
                }
            }catch (ItemNotFound ignored){}
        } else if (rangeExpression.getRangeType().equals(RangeType.LIST)) {
            Set<Type> typesOfElements = new LinkedHashSet<>();
            for(Expression expression : rangeExpression.getRangeExpressions()){
                typesOfElements.add(expression.accept(this));
            }
            if(typesOfElements.size() != 1){
                return new NoType();//TODO:Bad List
            }
        }
        else{
            Type beginRange = rangeExpression.getRangeExpressions().getFirst().accept(this);
            Type endRange = rangeExpression.getRangeExpressions().getLast().accept(this);
            if(!(beginRange instanceof IntType) || !(endRange instanceof IntType)){
                return new NoType();//TODO:Integer only accepted
            }
        }
        return new NoType();
    }





}
