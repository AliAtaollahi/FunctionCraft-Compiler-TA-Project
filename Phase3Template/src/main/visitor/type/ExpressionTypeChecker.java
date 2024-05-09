package main.visitor.type;

import main.ast.nodes.declaration.*;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.operators.BinaryOperator;
import main.ast.nodes.expression.operators.UnaryOperator;
import main.ast.nodes.expression.value.*;
import main.ast.nodes.expression.value.primitive.*;
import main.ast.type.*;
import main.ast.type.primitiveType.*;
import main.compileError.typeErrors.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.*;
import main.symbolTable.item.*;
import main.visitor.Visitor;
import parsers.FunctionCraftParser;

import java.util.*;

public class ExpressionTypeErrorFinder extends Visitor<Type> {
    private FunctionItem visitingFunction;
    private boolean callIsStmt = false;

    public void setVisitingFunction(FunctionItem visitingFunction) {
        this.visitingFunction = visitingFunction;
    }

    public void setIsCallStmt(boolean flag) {
        this.callIsStmt = flag;
    }

    public boolean functionPtrEqual(FptrType t1, FptrType t2) {
        if(t1.getFunctionName().equals(t2.getFunctionName()))
            return true;
        try {
            String firstFuncKey = "Function_" + t1.getFunctionName();
            FunctionItem firstFuncItem = (FunctionItem) SymbolTable.root.getItem(firstFuncKey);
            String secondFuncKey = "Function_" + t2.getFunctionName();
            FunctionItem secondFuncItem = (FunctionItem) SymbolTable.root.getItem(secondFuncKey);
            if(firstFuncItem.getFunctionDeclaration().getArgs().size() == secondFuncItem.getFunctionDeclaration().getArgs().size()) {
                int i = 0;
                for (Type argType: firstFuncItem.getArgTypes()) {
                    if(areEqual(argType, secondFuncItem.getArgTypes().get(i)))
                        i++;
                    else return false;
                }
                if (!areEqual(firstFuncItem.getReturnType(), secondFuncItem.getReturnType()))
                    return false;
            }
            else
                return false;
        } catch (ItemNotFound e) {

        }

        return true;
    }

    public boolean areEqual(Type t1, Type t2) {
        if (t1 instanceof ListType && t2 instanceof ListType)
            return areEqual(((ListType) t1).getType(), ((ListType) t2).getType());
        if (t1 instanceof ListType && (!(t2 instanceof NoType)))
            return false;
        if (t2 instanceof ListType && (!(t1 instanceof NoType)))
            return false;
        if (t1 instanceof FptrType && t2 instanceof FptrType)
            return functionPtrEqual(((FptrType) t1), ((FptrType) t2));
        return (t1.getClass().equals(t2.getClass())
                || t1 instanceof NoType || t2 instanceof NoType);
    }

    public boolean setArgumentTypeByIndex(String functionKey, ArrayList<Type> argumentTypes) {
        try {
            FunctionItem funcItem = (FunctionItem) SymbolTable.root.getItem(functionKey);
            SymbolTable funcST = funcItem.getFunctionSymbolTable();
            if(argumentTypes.size() != funcItem.getFunctionDeclaration().getArgs().size())
                return false;
            if (funcItem.getFunctionDeclaration().getCalledBefore()) {
                int index = 0;
                for (Type argumentType: funcItem.getArgTypes()) {
                    if(!areEqual(argumentType, argumentTypes.get(index)))
                        return false;
                    index++;
                }
                return true;
            }
            int index = 0;
            for (Type argumentType: argumentTypes) {
                funcItem.addArgType(argumentType);
                String varKey = "Var_" + funcItem.getFunctionDeclaration().getArgs().get(index).getName();
                VarItem varItem = (VarItem) funcST.getItem(varKey);
                varItem.setType(argumentType);
                index++;
            }
            funcItem.getFunctionDeclaration().setCalledBefore();
        } catch (ItemNotFound ignored) {}

        return true;
    }

    public boolean setArgumentTypeByKeyName(ArrayList<String> argumentNames, ArrayList<Type> argumentTypes, String functionKey) {
        try {
            FunctionItem funcItem = (FunctionItem) SymbolTable.root.getItem(functionKey);
            if (funcItem.getFunctionDeclaration().getCalledBefore()) {
                int funcArgIndex = 0;
                for (Identifier identifier : funcItem.getFunctionDeclaration().getArgs()) {
                    int index = 0;
                    for (String argName : argumentNames) {
                        if (argName.equals(identifier.getName())) {
                            if (!areEqual(argumentTypes.get(index), funcItem.getArgTypes().get(funcArgIndex)))
                                return false;
                        }
                        index++;
                    }
                    funcArgIndex++;
                }
                return true;
            }
            SymbolTable funcST = funcItem.getFunctionSymbolTable();
            for (Identifier identifier : funcItem.getFunctionDeclaration().getArgs()) {
                int index = 0;
                for (String argName : argumentNames) {
                    if (argName.equals(identifier.getName())) {
                        funcItem.addArgType(argumentTypes.get(index));
                        String varKey = "Var_" + argName;
                        VarItem varItem = (VarItem) funcST.getItem(varKey);
                        varItem.setType(argumentTypes.get(index));
                        break;
                    }
                    index++;
                }
            }
            funcItem.getFunctionDeclaration().setCalledBefore();
        } catch (ItemNotFound ignored) {}

        return true;
    }

    @Override
    public Type visit(BinaryExpression binaryExpression) {
        Expression left = binaryExpression.getFirstOperand();
        Expression right = binaryExpression.getSecondOperand();

        Type tl = left.accept(this);
        Type tr = right.accept(this);
        BinaryOperator operator =  binaryExpression.getBinaryOperator();


//        if (operator.equals(BinaryOperator.and) || operator.equals(BinaryOperator.or)){
//            if (tl instanceof BoolType && tr instanceof BoolType)
//                return new BoolType();
//
//            if ((tl instanceof NoType || tl instanceof BoolType) && (tr instanceof BoolType || tr instanceof NoType))
//                return new NoType();
//        }
        if (operator.equals(BinaryOperator.PLUS) || operator.equals(BinaryOperator.MINUS)
                || operator.equals(BinaryOperator.MULT) || operator.equals(BinaryOperator.DIVIDE)) {

            if (tl instanceof IntType && tr instanceof IntType)
                return new IntType();

            if ((tl instanceof NoType || tl instanceof IntType) && (tr instanceof IntType || tr instanceof NoType))
                return new NoType();
        }
        else if (operator.equals(BinaryOperator.LESS_THAN) || operator.equals(BinaryOperator.GREATER_THAN)) {
            if (tl instanceof IntType && tr instanceof IntType)
                return new BoolType();

            if ((tl instanceof NoType || tl instanceof IntType) && (tr instanceof IntType || tr instanceof NoType))
                return new NoType();
        }
//        else if (operator.equals(BinaryOperator.append)) {
//            if(tl instanceof NoType)
//                return new NoType();
//            if(tl instanceof ListType) {
//                if (tr instanceof NoType) {
//                    return tl;
//                }
//                if (((ListType) tl).getType() instanceof NoType)
//                    return new ListType(tr);
//                if (areEqual(tr, ((ListType) tl).getType()))
//                    return tl;
//            }
//        }
        else if (operator.equals(BinaryOperator.EQUAL) || operator.equals(BinaryOperator.NOT_EQUAL)) {
            if (tl instanceof NoType || tr instanceof NoType) {
                return new NoType();
            }
            if (tl instanceof FptrType) {
                if(tr instanceof FptrType) {
                    if(functionPtrEqual((FptrType) tl, (FptrType) tr))
                        return new BoolType();
                }
            }
//            else if (tl.getClass().equals(tr.getClass())) {
//                if(!(tl instanceof ListType))
//                    return new BoolType();
//            }
        }

//        UnsupportedOperandType exception = new UnsupportedOperandType(binaryExpression.getLine(), operator.name());
//        binaryExpression.addError(exception);

        return new NoType();
    }

    @Override
    public Type visit(UnaryExpression unaryExpression) {
        Expression operand = unaryExpression.getExpression();
        UnaryOperator operator = unaryExpression.getOp();

        Type operand_type = operand.accept(this);

        if (operator.equals(UnaryOperator.MINUS)){
            if (operand_type instanceof IntType)
                return new IntType();

            if (operand_type instanceof NoType)
                return new NoType();
        }
        else if (operator.equals(UnaryOperator.NOT)) {
            if (operand_type instanceof BoolType)
                return new BoolType();

            if (operand_type instanceof NoType)
                return new NoType();
        }

//        UnsupportedOperandType exception = new UnsupportedOperandType(unaryExpression.getLine(), operator.name());
//        unaryExpression.addError(exception);

        return new NoType();
    }

    @Override
    public Type visit(LambdaExpression lambdaExpression) {
        String anonymousName = "Function_" + lambdaExpression.getName();
        try {
            SymbolTable.root.getItem(anonymousName);
            return new FptrType(lambdaExpression.getName());
        } catch(ItemNotFound ignored) {}

        return new NoType();
    }

    @Override
    public Type visit(Identifier identifier) {
        try {
            String funcKey = "Function_" + identifier.getName();
            SymbolTable.root.getItem(funcKey);
            return new FptrType(identifier.getName());
        } catch(ItemNotFound exception) {
            try {
                String varKey = "Var_" + identifier.getName();
                VarItem varItem = (VarItem) visitingFunction.getFunctionSymbolTable().getItem(varKey);
                return varItem.getType();
            } catch (ItemNotFound ignored) {}
        }
        return new NoType();
    }

    @Override
    public Type visit(ListAccessByIndex listAccessByIndex) {
        Type indexType = listAccessByIndex.getIndex().accept(this);
        Type instanceType = listAccessByIndex.getInstance().accept(this);
        if (!(indexType instanceof IntType) && !(indexType instanceof NoType)) {
//            ListIndexNotInt exception = new ListIndexNotInt(listAccessByIndex.getIndex().getLine());
//            listAccessByIndex.addError(exception);
        }
        if (!(instanceType instanceof ListType) && !(instanceType instanceof NoType)) {
//            ListAccessByIndexOnNoneList exception = new ListAccessByIndexOnNoneList(listAccessByIndex.getInstance().getLine());
//            listAccessByIndex.addError(exception);
        }
        if (instanceType instanceof ListType && indexType instanceof IntType)
            return ((ListType) instanceType).getType();

        return new NoType();
    }

    @Override
    public Type visit(LenStatement lenStatement) {
        Type instanceType = lenStatement.getExpression().accept(this);
        if (instanceType instanceof ListType)
            return new IntType();

//        GetSizeOfNoneList exception = new GetSizeOfNoneList(listSize.getLine());
//        listSize.addError(exception);
        return new NoType();
    }

    @Override
    public Type visit(FunctionCall funcCall) {
        boolean savedIsStmtFlag = false;
        if(callIsStmt) {
            savedIsStmtFlag = true;
            callIsStmt = false;
        }
        Type instanceType = funcCall.getInstance().accept(this);
        if (instanceType instanceof NoType)
            return new NoType();
        if (!(instanceType instanceof FptrType)) {
//            CallOnNoneFptrType exception = new CallOnNoneFptrType(funcCall.getLine());
//            funcCall.addError(exception);
            return new NoType();
        }

        String funcKey = "Function_" + ((FptrType) instanceType).getFunctionName();
        if (funcCall.getArgs().size() > 0) {
            ArrayList<Type> argumentTypes = new ArrayList<>();
            for (Expression argument: funcCall.getArgs()) {
                Type argType = argument.accept(this);
                argumentTypes.add(argType);
            }
            if(!setArgumentTypeByIndex(funcKey, argumentTypes)) {
//                FunctionCallNotMatchDefinition exception = new FunctionCallNotMatchDefinition(funcCall.getLine());
//                funcCall.addError(exception);
                return new NoType();
            }
        }
        else if (funcCall.getArgsWithKey().size() > 0) {
            ArrayList<Type> argumentTypes = new ArrayList<>();
            ArrayList<String> argumentNames = new ArrayList<>();
            for (Map.Entry<Identifier, Expression> entry : funcCall.getArgsWithKey().entrySet()) {
                Type argType = entry.getValue().accept(this);
                argumentNames.add(entry.getKey().getName());
                argumentTypes.add(argType);
            }
            if(!setArgumentTypeByKeyName(argumentNames, argumentTypes, funcKey)) {
//                FunctionCallNotMatchDefinition exception = new FunctionCallNotMatchDefinition(funcCall.getLine());
//                funcCall.addError(exception);
                return new NoType();
            }
        }
        else {
            if(!setArgumentTypeByIndex(funcKey, new ArrayList<>())) {
//                FunctionCallNotMatchDefinition exception = new FunctionCallNotMatchDefinition(funcCall.getLine());
//                funcCall.addError(exception);
                return new NoType();
            }
        }
        Type returnType = null;
        try {
            FunctionItem funcItem = (FunctionItem) SymbolTable.root.getItem(funcKey);
            TypeErrorFinder typeErrorFinder = new TypeErrorFinder();
            typeErrorFinder.setVisitingFunction(funcItem);
            funcItem.getFunctionDeclaration().accept(typeErrorFinder);
            returnType = funcItem.getReturnType();
        } catch(ItemNotFound ignored) {}

//        if (!savedIsStmtFlag && returnType instanceof VoidType) {
////            CantUseValueOfVoidFunction exception = new CantUseValueOfVoidFunction(funcCall.getLine());
////            funcCall.addError(exception);
//            return new NoType();
//        }
        return returnType;
    }

    @Override
    public Type visit(ListValue listValue) {
        ListType listType = null;
        for (Expression element: listValue.getElements()) {
            Type elementType = element.accept(this);
            if (elementType instanceof NoType)
                continue;
            if (listType != null && !(areEqual(elementType, listType.getType()))) {
//                ListElementsTypeNotMatch exception = new ListElementsTypeNotMatch(listValue.getLine());
//                listValue.addError(exception);
                return new NoType();
            }
            if (listType == null) listType = new ListType(elementType);
        }
        if (listType == null)
            return new ListType(new NoType());
        return listType;
    }

    @Override
    public Type visit(IntValue intValue) {
        return new IntType();
    }

    @Override
    public Type visit(FloatValue floatValue) {
        return new FloatType();
    }

    @Override
    public Type visit(BoolValue boolValue) {
        return new BoolType();
    }

    @Override
    public Type visit(StringValue stringValue) {
        return new StringType();
    }
}