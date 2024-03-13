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

public class Visitor<T> implements IVisitor<T> {

    @Override
    public T visit(Program program) {
        return null;
    }

    @Override
    public T visit(FunctionDeclaration functionDeclaration) {
        return null;
    }

    @Override
    public T visit(MainDeclaration mainDeclaration) {
        return null;
    }


    @Override
    public T visit(BlockStmt blockStmt) {
        return null;
    }

    @Override
    public T visit(ConditionalStmt conditionalStmt) {
        return null;
    }

    @Override
    public T visit(FunctionCallStmt methodCallStmt) {
        return null;
    }

    @Override
    public T visit(PrintStmt print) {
        return null;
    }

    @Override
    public T visit(ReturnStmt returnStmt) {
        return null;
    }



    @Override
    public T visit(BinaryExpression binaryExpression) {
        return null;
    }

    @Override
    public T visit(UnaryExpression unaryExpression) {
        return null;
    }



    @Override
    public T visit(Identifier identifier) {
        return null;
    }

    @Override
    public T visit(ListAccessByIndex listAccessByIndex) {
        return null;
    }

    @Override
    public T visit(FunctionCall methodCall) {
        return null;
    }

    @Override
    public T visit(AnonymousFunction anonymousFunction) {
        return null;
    }



    @Override
    public T visit(ListValue listValue) {
        return null;
    }


    @Override
    public T visit(IntValue intValue) {
        return null;
    }

    @Override
    public T visit(BoolValue boolValue) {
        return null;
    }

    @Override
    public T visit(StringValue stringValue) {
        return null;
    }

    @Override
    public T visit(VoidValue voidValue) {
        return null;
    }


    @Override
    public T visit(ListSize listSize) {
        return null;
    }

}
