package main.visitor;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.FunctionDeclaration;
import main.ast.nodes.declaration.MainDeclaration;
import main.ast.nodes.declaration.PatternDeclaration;
import main.ast.nodes.declaration.VarDeclaration;
import main.ast.nodes.expression.Identifier;
import main.ast.nodes.statement.*;

public interface IVisitor<T> {
    T visit(Program program);
    T visit(Identifier identifier);
    T visit(VarDeclaration varDeclaration);
    T visit(FunctionDeclaration functionDeclaration);
    T visit(PatternDeclaration patternDeclaration);
    T visit(MainDeclaration mainDeclaration);
    T visit(ReturnStatement returnStatement);
    T visit(IfStatement ifStatement);
    T visit(PutStatement putStatement);
    T visit(LenStatement lenStatement);
    T visit(PushStatement pushStatement);
    T visit(LoopDoStatement loopDoStatement);
}
