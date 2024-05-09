package main.visitor.type;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.FunctionDeclaration;
import main.ast.nodes.declaration.MainDeclaration;
import main.ast.nodes.expression.AccessExpression;
import main.ast.nodes.expression.Expression;
import main.ast.nodes.expression.Identifier;
import main.ast.nodes.statement.ReturnStatement;
import main.ast.nodes.statement.Statement;
import main.ast.type.Type;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemAlreadyExists;
import main.symbolTable.exceptions.ItemNotFound;
import main.symbolTable.item.FunctionItem;
import main.visitor.Visitor;

import javax.security.auth.kerberos.KerberosTicket;
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
        for(Statement statement: mainDeclaration.getBody()) {
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
        for(Statement statement: functionDeclaration.getBody()){
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


}
