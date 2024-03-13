package main.visitor.type;

import main.ast.nodes.expression.*;
import main.ast.nodes.expression.operators.BinaryOperator;
import main.ast.nodes.expression.operators.UnaryOperator;
import main.ast.nodes.expression.values.ListValue;
import main.ast.nodes.expression.values.VoidValue;
import main.ast.nodes.expression.values.primitive.BoolValue;
import main.ast.nodes.expression.values.primitive.IntValue;
import main.ast.nodes.expression.values.primitive.StringValue;
import main.ast.types.NoType;
import main.ast.types.Type;
import main.ast.types.VoidType;
import main.ast.types.functionPointer.FptrType;
import main.ast.types.list.ListType;
import main.ast.types.single.BoolType;
import main.ast.types.single.IntType;
import main.ast.types.single.StringType;
import main.compileError.typeErrors.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.FunctionSymbolTableItem;
import main.symbolTable.items.VariableSymbolTableItem;
import main.visitor.Visitor;

import java.util.*;

public class ExpressionTypeChecker extends Visitor<Type> {
    private TypeCheker typeCheker;
    private FunctionSymbolTableItem curFunction;
    private boolean isFunctioncallStmt;
    private boolean isMain;
    private Set<String> visited;

    public ExpressionTypeChecker(TypeCheker typeCheker, Set<String> visited) {
        this.typeCheker = typeCheker;
        this.visited = visited;
    }

    public void setFunctioncallStmt(boolean isFunctioncallStmt) {
        this.isFunctioncallStmt = isFunctioncallStmt;
    }

    public void setCurFunction(FunctionSymbolTableItem curFunction) {
        this.curFunction = curFunction;
    }

    private FunctionSymbolTableItem findFunccSymobolTableItem(FptrType fptr) {
        try{
            FunctionSymbolTableItem func = (FunctionSymbolTableItem) SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + fptr.getFunctionName());
            return func;
        }catch (ItemNotFoundException e){
            return null;
        }

    }

    public boolean sameType(Type el1,Type el2){

        if(el1 instanceof NoType || el2 instanceof NoType)
            return true;
        if(el1 instanceof IntType  && el2 instanceof IntType)
            return true;
        if(el1 instanceof BoolType && el2 instanceof BoolType)
            return true;
        if(el1 instanceof StringType && el2 instanceof StringType)
            return true;
        if(el1 instanceof VoidType && el2 instanceof VoidType)
            return true;
        if (el1 instanceof ListType && el2 instanceof ListType){
            return sameType(((ListType) el1).getType(), ((ListType) el2).getType());
        }
        if(el1 instanceof FptrType && el2 instanceof FptrType){
            if(((FptrType) el1).getFunctionName().equals(((FptrType) el2).getFunctionName()))
                return true;
            FunctionSymbolTableItem f1 = findFunccSymobolTableItem((FptrType) el1);
            FunctionSymbolTableItem f2 = findFunccSymobolTableItem((FptrType) el2);
            Type el1RetType = f1.getReturnType();
            Type el2RetType = f2.getReturnType();
            if(!sameType(el1RetType,el2RetType))
                return false;
            ArrayList<Type> el1ArgsTypes = new ArrayList<>(f1.getArgTypes().values());
            ArrayList<Type> el2ArgsTypes = new ArrayList<>(f2.getArgTypes().values());

            if(el1ArgsTypes.size() != el2ArgsTypes.size())
                return false;
            else{
                for(int i = 0; i < el1ArgsTypes.size(); i++){
                    if(!sameType(el1ArgsTypes.get(i),el2ArgsTypes.get(i)))
                        return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public Type visit(BinaryExpression binaryExpression) {
        Expression left = binaryExpression.getFirstOperand();
        Expression right = binaryExpression.getSecondOperand();

        Type tl = left.accept(this);
        Type tr = right.accept(this);
        BinaryOperator operator =  binaryExpression.getBinaryOperator();


        if (operator.equals(BinaryOperator.and) || operator.equals(BinaryOperator.or)){
            if (tl instanceof BoolType && tr instanceof BoolType)
                return new BoolType();

            if ((tl instanceof NoType || tl instanceof BoolType) &&
                    (tr instanceof BoolType || tr instanceof NoType))
                return new NoType();
        }

        else if(operator.equals(BinaryOperator.eq) || operator.equals(BinaryOperator.neq)){
            if(tl instanceof ListType || tr instanceof ListType){
                UnsupportedOperandType exception = new UnsupportedOperandType(left.getLine(), operator.name());
                binaryExpression.addError(exception);
                return new NoType();
            }
            if(!sameType(tl,tr)){
                UnsupportedOperandType exception = new UnsupportedOperandType(right.getLine(), operator.name());
                binaryExpression.addError(exception);
                return new NoType();
            }
            else {
                if(tl instanceof NoType || tr instanceof NoType)
                    return new NoType();
                else
                    return new BoolType();
            }
        }

        else if(operator.equals(BinaryOperator.gt) || operator.equals(BinaryOperator.lt)){
            if (tl instanceof IntType && tr instanceof IntType)
                return new BoolType();

            if ((tl instanceof NoType || tl instanceof IntType) &&
                    (tr instanceof IntType || tr instanceof NoType))
                return new NoType();
        }

        else if (operator.equals(BinaryOperator.append)) {
            if(tl instanceof ListType && sameType(((ListType) tl).getType(), tr)) {
                if (!((ListType) tl).isTypeSet() && ! (tr instanceof NoType)) {
                    ListType newList = new ListType(tr);
                    newList.setTypeSet(true);
                    return newList;
                }
                else {
                    ListType newList = new ListType(((ListType) tl).getType());
                    newList.setTypeSet(false);
                    return newList;
                }
            }
            if(tl instanceof NoType)
                return new NoType();
        }

        else { // + - / *
            if (tl instanceof IntType && tr instanceof IntType)
                return new IntType();

            if ((tl instanceof NoType || tl instanceof IntType) &&
                    (tr instanceof IntType || tr instanceof NoType))
                return new NoType();
        }

        UnsupportedOperandType exception = new UnsupportedOperandType(left.getLine(), operator.name());
        left.addError(exception);
        return new NoType();
    }

    @Override
    public Type visit(UnaryExpression unaryExpression) {
        Expression uExpr = unaryExpression.getOperand();
        Type ut = uExpr.accept(this);
        UnaryOperator operator = unaryExpression.getOperator();

        if(operator.equals(UnaryOperator.not)) {
            if(ut instanceof BoolType)
                return new BoolType();
            if(ut instanceof NoType)
                return new NoType();
            else {
                UnsupportedOperandType exception = new UnsupportedOperandType(uExpr.getLine(), operator.name());
                uExpr.addError(exception);
                return new NoType();
            }
        }

        else { //-
            if (ut instanceof IntType)
                return new IntType();
            if(ut instanceof NoType)
                return new NoType();
            else{
                UnsupportedOperandType exception = new UnsupportedOperandType(uExpr.getLine(), operator.name());
                uExpr.addError(exception);
                return new NoType();
            }
        }
    }

    @Override
    public Type visit(AnonymousFunction anonymousFunction) {
        FunctionSymbolTableItem temp = curFunction;
        curFunction = findFunccSymobolTableItem(new FptrType(anonymousFunction.getName()));
        FunctionSymbolTableItem typeCheckerTemp = typeCheker.getCurFunction();
        typeCheker.setCurFunction(curFunction);
        if (visited.contains(anonymousFunction.getName()))
            anonymousFunction.getBody().accept(typeCheker);

        curFunction = temp;
        typeCheker.setCurFunction(typeCheckerTemp);
        return new FptrType(anonymousFunction.getName());
    }

    @Override
    public Type visit(Identifier identifier) {
        try {
            FunctionSymbolTableItem funcSym = (FunctionSymbolTableItem) SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + identifier.getName());
            return new FptrType(identifier.getName());

        }catch (ItemNotFoundException e) {
            try{
                VariableSymbolTableItem varSym = (VariableSymbolTableItem) curFunction.getFunctionSymbolTable().getItem(VariableSymbolTableItem.START_KEY + identifier.getName());
                return varSym.getType();
            }catch (ItemNotFoundException e1) {
            }
        }
        return null;

    }

    @Override
    public Type visit(ListAccessByIndex listAccessByIndex) {
        Type indexType = listAccessByIndex.getIndex().accept(this);
        Type instanceType = listAccessByIndex.getInstance().accept(this);

        if(!(indexType instanceof IntType || indexType instanceof NoType)){
            ListIndexNotInt exception = new ListIndexNotInt(listAccessByIndex.getLine());
            listAccessByIndex.addError(exception);
        }
        if(instanceType instanceof NoType)
            return new NoType();

        if(!(instanceType instanceof ListType)){
            ListAccessByIndexOnNoneList exception = new ListAccessByIndexOnNoneList(listAccessByIndex.getLine());
            listAccessByIndex.addError(exception);
            return new NoType();
        }

        else {
            if (indexType instanceof IntType)
                return ((ListType) instanceType).getType();
            else
                return new NoType();
        }
    }

    @Override
    public Type visit(ListSize listSize) {
        Type instanceType = listSize.getInstance().accept(this);
        if(instanceType instanceof ListType)
            return new IntType();
        else {
            if(!(instanceType instanceof NoType)) {
                GetSizeOfNoneList exception = new GetSizeOfNoneList(listSize.getLine());
                listSize.addError(exception);
            }
            return new NoType();
        }
    }

    @Override
    public Type visit(FunctionCall funcCall) {
        Type type = funcCall.getInstance().accept(this);
        boolean temp = isFunctioncallStmt;
        isFunctioncallStmt = false;
        ArrayList<Type> rtypes = new ArrayList<>();
        Map<String, Type> rtypesWithKey = new HashMap<>();
        for (Map.Entry<Identifier,Expression> argsWithKey: funcCall.getArgsWithKey().entrySet()) {
            Type curType = argsWithKey.getValue().accept(this);
            rtypesWithKey.put(argsWithKey.getKey().getName(), curType);
        }
        for (Expression expression : funcCall.getArgs()) {
            Type t = expression.accept(this);
            rtypes.add(t);
        }
        isFunctioncallStmt = temp;

        if (!(type instanceof FptrType || type instanceof NoType)){
            CallOnNoneFptrType exception = new CallOnNoneFptrType(funcCall.getLine());
            funcCall.addError(exception);
            return new NoType();
        }
        if (type instanceof FptrType) {
            boolean declareError = false;
            boolean error = false;
            FunctionSymbolTableItem func = findFunccSymobolTableItem((FptrType) type);
            if (func.getReturnType() instanceof VoidType && !isFunctioncallStmt) {
                CantUseValueOfVoidFunction exception = new CantUseValueOfVoidFunction(funcCall.getLine());
                funcCall.addError(exception);
                error = true;
            }
            if(funcCall.getArgsWithKey().size() != 0) {
                if(funcCall.getArgsWithKey().size() != func.getArgTypes().size()) {
                    FunctionCallNotMatchDefinition exception = new FunctionCallNotMatchDefinition(funcCall.getLine());
                    funcCall.addError(exception);
                    error = true;
                }
            }
            else if(funcCall.getArgs().size() != func.getArgTypes().size())

                declareError = true;

            else {
                if(rtypes.size() != 0) {
                    int i = 0;
                    for (Map.Entry<String, Type> ltype : func.getArgTypes().entrySet()) {
                        if (!sameType(ltype.getValue(), rtypes.get(i))) {
                            declareError = true;
                            break;
                        }
                        i++;

                    }
                }
                if(rtypesWithKey.size() != 0) {
                    for (Map.Entry<String, Type> ltype : func.getArgTypes().entrySet()) {
                        if (rtypesWithKey.containsKey(ltype.getKey())) {
                            if (!sameType(rtypesWithKey.get(ltype.getKey()), ltype.getValue())) {
                                declareError = true;
                                break;
                            }
                        } else {

                            declareError = true;
                            break;
                        }
                    }
                }
            }
            if (declareError) {
                FunctionCallNotMatchDefinition exception = new FunctionCallNotMatchDefinition(funcCall.getLine());
                funcCall.addError(exception);
            }
            if (declareError || error)
                return new NoType();
            else
                return func.getReturnType();

        }
        else
            return new NoType();
    }

    @Override
    public Type visit(ListValue listValue) {
        if (listValue.getElements().size() == 0)
            return new ListType(new NoType());

        Type type = listValue.getElements().get(0).accept(this);
        boolean typeSet = true;
        if (type instanceof NoType)
            typeSet = false;
        for (int i = 1; i < listValue.getElements().size(); i++) {
            Type elementType = listValue.getElements().get(i).accept(this);
            if (!sameType(elementType, type)) {
                ListElementsTypeNotMatch exception = new ListElementsTypeNotMatch(listValue.getLine());
                listValue.addError(exception);
                return new NoType();
            }
            if (!typeSet && !(elementType instanceof NoType)) {
                typeSet = true;
                type = elementType;
            }

        }
        ListType newList = new ListType(type);
        newList.setTypeSet(typeSet);
        return newList;
    }

    @Override
    public Type visit(IntValue intValue) {
        return new IntType();
    }

    @Override
    public Type visit(BoolValue boolValue) {
        return new BoolType();
    }

    @Override
    public Type visit(StringValue stringValue) {
        return new StringType();
    }

    @Override
    public Type visit(VoidValue voidValue) {
        return new VoidType();
    }
}
