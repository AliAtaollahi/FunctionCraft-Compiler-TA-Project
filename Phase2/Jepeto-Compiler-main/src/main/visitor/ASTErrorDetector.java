package main.visitor;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.FunctionDeclaration;
import main.ast.nodes.declaration.MainDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.values.ListValue;
import main.ast.nodes.expression.values.VoidValue;
import main.ast.nodes.expression.values.primitive.BoolValue;
import main.ast.nodes.expression.values.primitive.IntValue;
import main.ast.nodes.expression.values.primitive.StringValue;
import main.ast.nodes.statement.*;
import main.compileErrors.nameErrors.DuplicateFunction;
import main.compileErrors.nameErrors.ArgumentNotDeclared;
import main.compileErrors.nameErrors.FunctionNotDeclared;
import main.compileErrors.nameErrors.DuplicateArgument;
import main.compileErrors.nameErrors.NameConflict;
import main.compileErrors.nameErrors.VariableNotDeclared;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.*;

import java.util.ArrayList;
import java.util.Map;

public class ASTErrorDetector extends Visitor<Boolean>{

    private boolean function_identifier_declared;
    private boolean function_call_identifier_flag;
    private String called_function_key;
    private int error_num;

    public boolean argument_key_declared(String keyName){
        boolean found = false;
        try {
            FunctionSymbolTableItem calledFunctionSymbolTableItem = (FunctionSymbolTableItem) SymbolTable.root.getItem(called_function_key);
            ArrayList<Identifier> arguments = calledFunctionSymbolTableItem.getFuncDeclaration().getArgs();
            for(Identifier identifier : arguments) {
                if(keyName.equals(identifier.getName())) {
                    found = true;
                    break;
                }
            }

        } catch (ItemNotFoundException ignored) {

        }
        return found;
    }

    public boolean arg_name_equal_to_function(String argName){
        String functionKey = "Function_" + argName;
        boolean duplicate_function_name_found = true;
        try {
            SymbolTable.root.getItem(functionKey);
        } catch (ItemNotFoundException e) {
            duplicate_function_name_found = false;
        }
        return duplicate_function_name_found;
    }

    @Override
    public Boolean visit(Program program) {
        error_num = 0;
        function_call_identifier_flag = false;
        function_identifier_declared = false;
        called_function_key = null;
        SymbolTable.root = new SymbolTable();
        SymbolTable.top = new SymbolTable();
        ArrayList<FunctionSymbolTableItem> functionItems = new ArrayList<>();
        int duplicate_function_num = 0;
        for(FunctionDeclaration functionDeclaration : program.getFunctions()) {
            FunctionSymbolTableItem newFuncItem = new FunctionSymbolTableItem(functionDeclaration);
            try {
                SymbolTable.root.put(newFuncItem);
                functionItems.add(newFuncItem);
            } catch (ItemAlreadyExistsException e) {
                error_num = error_num + 1;
                String error_msg = new DuplicateFunction(functionDeclaration.getLine(),
                        functionDeclaration.getFunctionName().getName()).getMessage();
                System.out.println(error_msg);
                duplicate_function_num = duplicate_function_num + 1;
                String new_name = newFuncItem.getName();
                String id = String.valueOf(duplicate_function_num);
                new_name = new_name + "@" + id;
                Identifier new_id = functionDeclaration.getFunctionName();
                new_id.setName(new_name);
                functionDeclaration.setFunctionName(new_id);
                FunctionSymbolTableItem new_item = new FunctionSymbolTableItem(functionDeclaration);
                functionItems.add(new_item);
                try {
                     SymbolTable.root.put(new_item);
                } catch (ItemAlreadyExistsException ignored) {

                }
            }
        }
        program.getMain().accept(this);
        int visiting_function_num = 0;
        for(FunctionDeclaration funcDec : program.getFunctions()) {
            FunctionSymbolTableItem functionSTItem = functionItems.get(visiting_function_num);
            SymbolTable funcST = new SymbolTable();
            functionSTItem.setFunctionSymbolTable(funcST);
            SymbolTable.push(funcST);
            funcDec.accept(this);
            SymbolTable.pop();
            visiting_function_num += 1;
        }
//        System.out.println(error_num);
        return error_num == 0;
    }

    @Override
    public Boolean visit(FunctionDeclaration funcDeclaration) {

        SymbolTable functionSymbolTable = SymbolTable.top;
        for(Identifier identifier : funcDeclaration.getArgs()) {
            if(arg_name_equal_to_function(identifier.getName())) {
                error_num = error_num + 1;
                String error_msg = new NameConflict(identifier.getLine(), identifier.getName()).getMessage();
                System.out.println(error_msg);
                continue;
            }
            VariableSymbolTableItem newVariableItem = new VariableSymbolTableItem(identifier);
            try {
                functionSymbolTable.put(newVariableItem);
            } catch (ItemAlreadyExistsException e) {
                error_num = error_num + 1;
                String error_msg = new DuplicateArgument(identifier.getLine(), identifier.getName()).getMessage();
                System.out.println(error_msg);
            }
        }
//        try {
//            String key = "Function_" + funcDeclaration.getFunctionName().getName();
//            FunctionSymbolTableItem functionSymbolTableItem = (FunctionSymbolTableItem) SymbolTable.root.getItem(key);
//            SymbolTable hello = functionSymbolTableItem.getFunctionSymbolTable();
//            functionSymbolTableItem.setFunctionSymbolTable(functionSymbolTable);
//        } catch (ItemNotFoundException ignored) {
//
//        }
//        SymbolTable.push(functionSymbolTable);
        funcDeclaration.getBody().accept(this);
//        SymbolTable.pop();
        return null;
    }

    @Override
    public Boolean visit(MainDeclaration mainDeclaration) {
        mainDeclaration.getBody().accept(this);
        return null;
    }


    @Override
    public Boolean visit(BlockStmt blockStmt) {
        for(Statement statement : blockStmt.getStatements()) {
            statement.accept(this);
        }
        return null;
    }

    @Override
    public Boolean visit(ConditionalStmt conditionalStmt) {
        conditionalStmt.getCondition().accept(this);
        conditionalStmt.getCondition().accept(this);
        conditionalStmt.getThenBody().accept(this);
        if(conditionalStmt.getElseBody() != null) {
            conditionalStmt.getElseBody().accept(this);
        }
        return null;
    }

    @Override
    public Boolean visit(FunctionCallStmt funcCallStmt) {
        funcCallStmt.getFunctionCall().accept(this);
        return null;
    }

    @Override
    public Boolean visit(PrintStmt print) {
        print.getArg().accept(this);
        return null;
    }

    @Override
    public Boolean visit(ReturnStmt returnStmt) {
        returnStmt.getReturnedExpr().accept(this);
        return null;
    }

    @Override
    public Boolean visit(BinaryExpression binaryExpression) {
        binaryExpression.getFirstOperand().accept(this);
        binaryExpression.getSecondOperand().accept(this);
        return null;
    }

    @Override
    public Boolean visit(UnaryExpression unaryExpression) {
        unaryExpression.getOperand().accept(this);
        return null;
    }

    @Override
    public Boolean visit(AnonymousFunction anonymousFunction) {
        function_call_identifier_flag = false;
        SymbolTable anonymous_symbol_table = new SymbolTable();
        SymbolTable.push(anonymous_symbol_table);
        for(Identifier identifier : anonymousFunction.getArgs()) {
            if(arg_name_equal_to_function(identifier.getName())) {
                error_num = error_num + 1;
                String error_msg = new NameConflict(identifier.getLine(), identifier.getName()).getMessage();
                System.out.println(error_msg);
                return null;
            }
            VariableSymbolTableItem newVarItem = new VariableSymbolTableItem(identifier);
            try {
                anonymous_symbol_table.put(newVarItem);
            } catch (ItemAlreadyExistsException e) {
                error_num = error_num + 1;
                String error_msg = new DuplicateArgument(identifier.getLine(), identifier.getName()).getMessage();
                System.out.println(error_msg);
            }
            identifier.accept(this);
        }
        anonymousFunction.getBody().accept(this);
        SymbolTable.pop();
        return null;
    }

    @Override
    public Boolean visit(Identifier identifier) {
        boolean found = true;
        String new_key = "Function_" + identifier.getName();
        try {
            SymbolTable.root.getItem(new_key);
        } catch (ItemNotFoundException e) {
            found = false;
        }

        if(!found && !function_call_identifier_flag) {
            found = true;
            new_key = "Var_" + identifier.getName();
            try {
                SymbolTable.top.getItem(new_key);
            } catch (ItemNotFoundException e) {
                found = false;
            }
        }
        if(!function_call_identifier_flag && !found) {
            error_num = error_num + 1;
            String error_msg = new VariableNotDeclared(identifier.getLine(), identifier.getName()).getMessage();
            System.out.println(error_msg);
        }
        else if(function_call_identifier_flag && !found) {
            error_num = error_num + 1;
            String error_msg = new FunctionNotDeclared(identifier.getLine(), identifier.getName()).getMessage();
            System.out.println(error_msg);
        }
        else if(function_call_identifier_flag) {
            called_function_key = "Function_" + identifier.getName();
            function_identifier_declared = true;
        }
        return null;
    }

    @Override
    public Boolean visit(ListAccessByIndex listAccessByIndex) {
        listAccessByIndex.getIndex().accept(this);
        listAccessByIndex.getInstance().accept(this);
        return null;
    }

    @Override
    public Boolean visit(ListSize listSize) {
        listSize.getInstance().accept(this);
        return null;
    }

    @Override
    public Boolean visit(FunctionCall funcCall) {
        function_call_identifier_flag = true;
        function_identifier_declared = false;
        funcCall.getInstance().accept(this);
        function_call_identifier_flag = false;
        if (function_identifier_declared) {
            if (funcCall.getArgsWithKey() != null) {
                for (Map.Entry<Identifier, Expression> entry : funcCall.getArgsWithKey().entrySet()) {
                    if (!argument_key_declared(entry.getKey().getName())) {
                        error_num = error_num + 1;
                        String functionName = called_function_key.replace("Function_", "");
                        String error_msg = new ArgumentNotDeclared(funcCall.getLine(), entry.getKey().getName(), functionName).getMessage();
                        System.out.println(error_msg);
                    }
                    entry.getValue().accept(this);
                }
            }
            if (funcCall.getArgs() != null) {
                for (Expression expression : funcCall.getArgs()) {
                    expression.accept(this);
                }
            }
        }
        return null;
    }

    @Override
    public Boolean visit(ListValue listValue) {
        for(Expression expression : listValue.getElements()) {
            expression.accept(this);
        }
        return null;
    }

    @Override
    public Boolean visit(IntValue intValue) {
        return null;
    }

    @Override
    public Boolean visit(BoolValue boolValue) {
        return null;
    }

    @Override
    public Boolean visit(StringValue stringValue) {
        return null;
    }

    @Override
    public Boolean visit(VoidValue voidValue) {
        return null;
    }
}
