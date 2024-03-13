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

public interface IVisitor<T> {

    T visit(Program program);

    T visit(FunctionDeclaration functionDeclaration);
    T visit(MainDeclaration mainDeclaration);

    T visit(BlockStmt blockStmt);
    T visit(ConditionalStmt conditionalStmt);
    T visit(FunctionCallStmt methodCallStmt);
    T visit(PrintStmt print);
    T visit(ReturnStmt returnStmt);


    T visit(BinaryExpression binaryExpression);
    T visit(UnaryExpression unaryExpression);
    T visit(AnonymousFunction anonymousFunction);
    T visit(FunctionCall methodCall);
    T visit(Identifier identifier);
    T visit(ListAccessByIndex listAccessByIndex);
    T visit(ListSize listSize);


    T visit(ListValue listValue);
    T visit(IntValue intValue);
    T visit(BoolValue boolValue);
    T visit(StringValue stringValue);


    T visit(VoidValue voidValue);
}
