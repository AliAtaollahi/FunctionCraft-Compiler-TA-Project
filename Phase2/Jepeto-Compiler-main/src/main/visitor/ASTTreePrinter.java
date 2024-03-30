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
import java.util.Map;

public class ASTTreePrinter extends Visitor<Void> {

    public void messagePrinter(int line, String message){
        System.out.println("Line " + line + ": " + message);
    }

    @Override
    public Void visit(Program program) {
        messagePrinter(program.getLine(), program.toString());
        boolean main_handled = false;
        program.getMain().accept(this);
        for(FunctionDeclaration funcDec : program.getFunctions()) {
//            if (!main_handled && main.getLine() < funcDec.getLine()) {
//                main_handled = true;
//                main.accept(this);
//            }
            funcDec.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(FunctionDeclaration funcDeclaration) {
        messagePrinter(funcDeclaration.getLine(), funcDeclaration.toString());
        funcDeclaration.getFunctionName().accept(this);
        for(Identifier identifier : funcDeclaration.getArgs()) {
            identifier.accept(this);
        }
        funcDeclaration.getBody().accept(this);
        return null;
    }

    @Override
    public Void visit(MainDeclaration mainDeclaration) {
        messagePrinter(mainDeclaration.getLine(), mainDeclaration.toString());
        mainDeclaration.getBody().accept(this);
        return null;
    }


    @Override
    public Void visit(BlockStmt blockStmt) {
        messagePrinter(blockStmt.getLine(), blockStmt.toString());
        for(Statement statement : blockStmt.getStatements()) {
            statement.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ConditionalStmt conditionalStmt) {
        messagePrinter(conditionalStmt.getLine(), conditionalStmt.toString());
        conditionalStmt.getCondition().accept(this);
        conditionalStmt.getThenBody().accept(this);
        if(conditionalStmt.getElseBody() != null) {
            conditionalStmt.getElseBody().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(FunctionCallStmt funcCallStmt) {
        messagePrinter(funcCallStmt.getLine(), funcCallStmt.toString());
        funcCallStmt.getFunctionCall().accept(this);
        return null;
    }

    @Override
    public Void visit(PrintStmt print) {
        messagePrinter(print.getLine(), print.toString());
        print.getArg().accept(this);
        return null;
    }

    @Override
    public Void visit(ReturnStmt returnStmt) {
        messagePrinter(returnStmt.getLine(), returnStmt.toString());
        returnStmt.getReturnedExpr().accept(this);
        return null;
    }

    @Override
    public Void visit(BinaryExpression binaryExpression) {
        messagePrinter(binaryExpression.getLine(), binaryExpression.toString());
        binaryExpression.getFirstOperand().accept(this);
        binaryExpression.getSecondOperand().accept(this);
        return null;
    }

    @Override
    public Void visit(UnaryExpression unaryExpression) {
        messagePrinter(unaryExpression.getLine(), unaryExpression.toString());
        unaryExpression.getOperand().accept(this);
        return null;
    }

    @Override
    public Void visit(AnonymousFunction anonymousFunction) {
        messagePrinter(anonymousFunction.getLine(), anonymousFunction.toString());
        for(Identifier identifier : anonymousFunction.getArgs()) {
            identifier.accept(this);
        }
        anonymousFunction.getBody().accept(this);
        return null;
    }

    @Override
    public Void visit(Identifier identifier) {
        messagePrinter(identifier.getLine(), identifier.toString());
        return null;
    }

    @Override
    public Void visit(ListAccessByIndex listAccessByIndex) {
        messagePrinter(listAccessByIndex.getLine(), listAccessByIndex.toString());
        listAccessByIndex.getInstance().accept(this);
        listAccessByIndex.getIndex().accept(this);
        return null;
    }

    @Override
    public Void visit(ListSize listSize) {
        messagePrinter(listSize.getLine(), listSize.toString());
        listSize.getInstance().accept(this);
        return null;
    }

    @Override
    public Void visit(FunctionCall funcCall) {
        messagePrinter(funcCall.getLine(), funcCall.toString());
        funcCall.getInstance().accept(this);
        if (funcCall.getArgsWithKey() != null) {
            for (Map.Entry<Identifier, Expression> entry : funcCall.getArgsWithKey().entrySet()) {
                entry.getKey().accept(this);
                entry.getValue().accept(this);
            }
        }
        if (funcCall.getArgs() != null) {
            for (Expression expression : funcCall.getArgs()) {
                expression.accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visit(ListValue listValue) {
        messagePrinter(listValue.getLine(), listValue.toString());
        for(Expression expression : listValue.getElements()) {
            expression.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(IntValue intValue) {
        messagePrinter(intValue.getLine(), intValue.toString());
        return null;
    }

    @Override
    public Void visit(BoolValue boolValue) {
        messagePrinter(boolValue.getLine(), boolValue.toString());
        return null;
    }

    @Override
    public Void visit(StringValue stringValue) {
        messagePrinter(stringValue.getLine(), stringValue.toString());
        return null;
    }

    @Override
    public Void visit(VoidValue voidValue) {
        messagePrinter(voidValue.getLine(), voidValue.toString());
        return null;
    }

}
