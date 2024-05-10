package main.visitor.type;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.*;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.value.*;
import main.ast.nodes.expression.value.primitive.*;
import main.ast.nodes.statement.*;
import main.ast.type.*;
import main.ast.type.primitiveType.*;
import main.compileError.CompileError;
import main.compileError.typeErrors.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.*;
import main.symbolTable.item.*;
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
                    typeErrors.add(new IsNotCallable(accessExpression.getLine()));
                    return new NoType();
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
                typeErrors.add(new IsNotIndexable(accessExpression.getLine()));
                return new NoType();
            }
            Set<Type> accessTypes = new LinkedHashSet<>();
            for(Expression expression : accessExpression.getDimentionalAccess()){
                accessTypes.add(expression.accept(this));
            }
            if(! (accessTypes.stream().toList().getFirst() instanceof IntType)){
                typeErrors.add(new ListAccessIndexIsNotInt(accessExpression.getLine()));
                return new NoType();
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
            typeErrors.add(new IncompatibleReturnTypes(functionDeclaration.getLine(),
                    functionDeclaration.getFunctionName().getName()));
            return new NoType();
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
        for(Expression expression : ifStatement.getConditions())
            if(!(expression.accept(this) instanceof BoolType))
                typeErrors.add(new ConditionIsNotBool(expression.getLine()));
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
                typeErrors.add(new ConditionIsNotBool(expression.getLine()));

        return null;
    }
    @Override
    public Type visit(NextStatement nextStatement){
        for(Expression expression : nextStatement.getConditions())
            if(!((expression.accept(this)) instanceof BoolType))
                typeErrors.add(new ConditionIsNotBool(expression.getLine()));

        return null;
    }
    @Override
    public Type visit(PushStatement pushStatement){
        Type initType = pushStatement.getInitial().accept(this);
        Type toBeAddedType = pushStatement.getToBeAdded().accept(this);
        if(!(initType instanceof ListType) && !(initType instanceof StringType)){
            typeErrors.add(new IsNotPushedable(pushStatement.getLine()));
            return new NoType();
        }
        else if(initType instanceof ListType listType && !(toBeAddedType.sameType(listType.getType()))){
            typeErrors.add(new PushArgumentsTypesMisMatch(pushStatement.getLine()));
            return new NoType();
        }
        else if(initType instanceof StringType && !(toBeAddedType instanceof StringType)) {
            typeErrors.add(new PushArgumentsTypesMisMatch(pushStatement.getLine()));
            return new NoType();
        }

        return null; //TODO -> null or type of init?
    }
    @Override
    public Type visit(PutStatement putStatement){
        Type put = putStatement.getExpression().accept(this);
        if(put instanceof FptrType){
            typeErrors.add(new IsNotPrintable(putStatement.getLine()));
            return new NoType();
        }
        return put; //TODO -> null or type of put?
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
            typeErrors.add(new ListElementsTypesMisMatch(listValue.getLine()));
            return null;
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
        if(!(appendeeType instanceof ListType) && !(appendeeType instanceof StringType)){
            typeErrors.add(new IsNotAppendable(appendExpression.getLine()));
            return new NoType();
        }
        for(Expression expression: appendExpression.getAppendeds())
            appendedTypes.add(expression.accept(this));

        if(appendedTypes.size() != 1){
            typeErrors.add(new AppendTypesMisMatch(appendExpression.getLine()));
            return new NoType();
        }
        Type apendedType = appendedTypes.stream().toList().getFirst();
        if(appendeeType instanceof ListType listType && !(apendedType.sameType(listType.getType()))){
            typeErrors.add(new AppendTypesMisMatch(appendExpression.getLine()));
            return new NoType();
        }
        else if(appendeeType instanceof StringType && !(apendedType instanceof StringType)){
            typeErrors.add(new AppendTypesMisMatch(appendExpression.getLine()));
            return new NoType();
        }

        return appendeeType; //TODO -> null or type of appendeeType?
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
        if (!(chompStatement.getChompExpression().accept(this) instanceof StringType)) {
            typeErrors.add(new ChompArgumentTypeMisMatch(chompStatement.getLine()));
            return new NoType();
        }

        return new StringType();
    }
    @Override
    public Type visit(ChopStatement chopStatement){
        if (!(chopStatement.getChopExpression().accept(this) instanceof StringType)) {
            typeErrors.add(new ChopArgumentTypeMisMatch(chopStatement.getLine()));
            return new NoType();
        }

        return new StringType();
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
        Type argType = lenStatement.getExpression().accept(this);
        if(!(argType instanceof StringType) && !(argType instanceof ListType)){
            typeErrors.add(new LenArgumentTypeMisMatch(lenStatement.getLine()));
            return new NoType();
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
        RangeType rangeType = rangeExpression.getRangeType();
//        if(rangeType.equals(RangeType.IDENTIFIER)){
//            Identifier rangeIdentifier = (Identifier) rangeExpression.getRangeExpressions().getFirst();
//            try{
//                VarItem varItem = (VarItem) SymbolTable.top.getItem(VarItem.START_KEY + rangeIdentifier.getName());
//                if(! (varItem.getType() instanceof IntType)){
//                    return new NoType();//TODO:error
//                }
//            }catch (ItemNotFound ignored){}
//        }
        if(rangeType.equals(RangeType.IDENTIFIER)){
            Type rangeIdentifierType = rangeExpression.getRangeExpressions().getFirst().accept(this);
            if(!(rangeIdentifierType instanceof ListType)){
                typeErrors.add(new IsNotIterable(rangeExpression.getLine()));
                return new NoType();
            }
        }
        else if(rangeType.equals(RangeType.LIST)){
            Set<Type> typesOfElements = new LinkedHashSet<>();
            for(Expression expression : rangeExpression.getRangeExpressions())
                typesOfElements.add(expression.accept(this));

//            if(typesOfElements.size() != 1){
//                return new NoType();//TODO:Bad List -- Handled in ListValue
//            }
        }
        else if(rangeType.equals(RangeType.DOUBLE_DOT)){
            Type beginRange = rangeExpression.getRangeExpressions().getFirst().accept(this);
            Type endRange = rangeExpression.getRangeExpressions().getLast().accept(this);
            if(!(beginRange instanceof IntType) || !(endRange instanceof IntType)){
                typeErrors.add(new RangeValuesMisMatch(rangeExpression.getLine()));
                return new NoType();
            }
        }
        return new NoType();
    }
}
