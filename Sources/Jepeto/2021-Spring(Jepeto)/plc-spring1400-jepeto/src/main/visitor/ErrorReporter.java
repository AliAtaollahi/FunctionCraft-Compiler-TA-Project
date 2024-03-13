package main.visitor;

import main.ast.nodes.Node;
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
import main.compileError.CompileError;


import java.util.ArrayList;
import java.util.Map;

public class ErrorReporter extends Visitor<Integer> {

    private int printErrors(Node node) {
        ArrayList<CompileError> errors = node.flushErrors();
        for(CompileError compileErrorException : errors) {
            System.out.println(compileErrorException.getMessage());
        }
        return errors.size();
    }

    @Override
    public Integer visit(Program program) {
        int numOfErrors = printErrors(program);
        numOfErrors += program.getMain().accept(this);
        for(FunctionDeclaration funcDeclaration : program.getFunctions()) {
            numOfErrors += funcDeclaration.accept(this);
        }

        return numOfErrors;
    }


    @Override
    public Integer visit(FunctionDeclaration funcDeclaration) {
        int numOfErrors = printErrors(funcDeclaration);
        numOfErrors += funcDeclaration.getFunctionName().accept(this);
        for(Identifier arg : funcDeclaration.getArgs()) {
            numOfErrors += arg.accept(this);
        }


        numOfErrors += funcDeclaration.getBody().accept(this);

        return numOfErrors;
    }

    @Override
    public Integer visit(MainDeclaration mainDeclaration) {
        int numOfErrors = printErrors(mainDeclaration);
        numOfErrors += mainDeclaration.getBody().accept(this);
        return numOfErrors;

    }




    @Override
    public Integer visit(BlockStmt blockStmt) {
        int numOfErrors = printErrors(blockStmt);
        for(Statement statement : blockStmt.getStatements()) {
            numOfErrors += statement.accept(this);
        }
        return numOfErrors;
    }

    @Override
    public Integer visit(ConditionalStmt conditionalStmt) {
        int numOfErrors = printErrors(conditionalStmt);
        numOfErrors += conditionalStmt.getCondition().accept(this);
        numOfErrors += conditionalStmt.getThenBody().accept(this);
        if(conditionalStmt.getElseBody() != null) {
            numOfErrors += conditionalStmt.getElseBody().accept(this);
        }
        return numOfErrors;
    }

    @Override
    public Integer visit(FunctionCallStmt funcCallStmt) {
        int numOfErrors = printErrors(funcCallStmt);
        numOfErrors +=funcCallStmt.getFunctionCall().accept(this);
        return numOfErrors;
    }

    @Override
    public Integer visit(PrintStmt printErrors) {
        int numOfErrors = printErrors(printErrors);
        numOfErrors += printErrors.getArg().accept(this);
        return numOfErrors;
    }

    @Override
    public Integer visit(ReturnStmt returnStmt) {
        int numOfErrors = printErrors(returnStmt);
        numOfErrors += returnStmt.getReturnedExpr().accept(this);
        return numOfErrors;
    }



    @Override
    public Integer visit(BinaryExpression binaryExpression) {
        int numOfErrors = printErrors(binaryExpression);
        numOfErrors += binaryExpression.getFirstOperand().accept(this);
        numOfErrors += binaryExpression.getSecondOperand().accept(this);
        return numOfErrors;
    }

    @Override
    public Integer visit(UnaryExpression unaryExpression) {
        int numOfErrors = printErrors(unaryExpression);
        numOfErrors += unaryExpression.getOperand().accept(this);
        return numOfErrors;
    }

    @Override
    public Integer visit(AnonymousFunction anonymousFunction) {
        int numOfErrors = printErrors(anonymousFunction);
        for (Identifier arg: anonymousFunction.getArgs())
            numOfErrors += arg.accept(this);
        numOfErrors += anonymousFunction.getBody().accept(this);
        return numOfErrors;
    }

    @Override
    public Integer visit(Identifier identifier) {
        return printErrors(identifier);
    }

    @Override
    public Integer visit(ListAccessByIndex listAccessByIndex) {
        int numOfErrors = printErrors(listAccessByIndex);
        numOfErrors += listAccessByIndex.getInstance().accept(this);
        numOfErrors += listAccessByIndex.getIndex().accept(this);
        return numOfErrors;
    }

    @Override
    public Integer visit(ListSize listSize) {
        int numOfErrors = printErrors(listSize);
        numOfErrors += listSize.getInstance().accept(this);
        return numOfErrors;
    }

    @Override
    public Integer visit(FunctionCall funcCall) {
        int numOfErrors = printErrors(funcCall);
        numOfErrors += funcCall.getInstance().accept(this);
        for(Expression expression : funcCall.getArgs()) {
            numOfErrors += expression.accept(this);
        }
        for (Map.Entry<Identifier,Expression> argsWithKey: funcCall.getArgsWithKey().entrySet()){
            numOfErrors += argsWithKey.getKey().accept(this);
            numOfErrors += argsWithKey.getValue().accept(this);

        }
        return numOfErrors;
    }


    @Override
    public Integer visit(ListValue listValue) {
        int numOfErrors = printErrors(listValue);
        for(Expression expression : listValue.getElements()) {
            numOfErrors += expression.accept(this);
        }
        return numOfErrors;
    }

    @Override
    public Integer visit(IntValue intValue) {
        return printErrors(intValue);
    }

    @Override
    public Integer visit(BoolValue boolValue) {
        return printErrors(boolValue);
    }

    @Override
    public Integer visit(StringValue stringValue) {
        return printErrors(stringValue);
    }

    @Override
    public Integer visit(VoidValue voidValue) {
        return printErrors(voidValue);
    }
}
