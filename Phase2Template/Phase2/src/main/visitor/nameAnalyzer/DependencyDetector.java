package main.visitor.nameAnalyzer;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.FunctionDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.statement.*;
import main.compileError.CompileError;
import main.compileError.nameErrors.CircularDependency;
import main.visitor.Visitor;
import main.symbolTable.utils.Graph;

import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.List;

public class DependencyDetector extends Visitor<Void> {
    public ArrayList<CompileError> dependencyError = new ArrayList<>();
    String currentParent;
    private Graph dependencyGraph = new Graph();
    @Override
    public Void visit(Program program){
        for(FunctionDeclaration functionDeclaration : program.getFunctionDeclarations()){
            currentParent = functionDeclaration.getFunctionName().getName();
            functionDeclaration.accept(this);
        }

        return null;
    }
    @Override
    public Void visit(FunctionDeclaration functionDeclaration){
        for(Statement statement : functionDeclaration.getBody()) {
            statement.accept(this);
        }
        return null;
    }
    public Void visit(AssignStatement assignStatement){
        if(assignStatement.isAccessList()){
            assignStatement.getAccessListExpression().accept(this);
        }
        assignStatement.getAssignExpression().accept(this);
        return null;
    }
    public Void visit(ExpressionStatement expressionStatement){
        expressionStatement.accept(this);
        return null;
    }
    public Void visit(ForStatement forStatement){
        for(Expression expression:forStatement.getLoopBodyExpressions()){
            expression.accept(this);
        }
        for(Expression expression: forStatement.getRangeExpressions()){
            expression.accept(this);
        }
        for(Statement statement: forStatement.getLoopBody()){
            statement.accept(this);
        }
        return null;
    }
    public Void visit(IfStatement ifStatement){
        for(Expression expression: ifStatement.getConditions()){
            expression.accept(this);
        }
        for(Statement statement: ifStatement.getThenBody()){
            statement.accept(this);
        }
        for(Statement statement: ifStatement.getElseBody()){
            statement.accept(this);
        }
        return null;
    }
    public Void visit(LoopDoStatement loopDoStatement){
        for(Statement statement : loopDoStatement.getLoopBodyStmts()){
            statement.accept(this);
        }
        for(Expression expression : loopDoStatement.getLoopConditions()){
            expression.accept(this);
        }
        if(loopDoStatement.getLoopRetStmt() != null){
            loopDoStatement.getLoopRetStmt().accept(this);
        }
        return null;
    }
    public Void visit(PushStatement pushStatement){
        pushStatement.getToBeAdded().accept(this);
        return null;
    }
    public Void visit(PutStatement putStatement){
        putStatement.getExpression().accept(this);
        return null;
    }
    public Void visit(ReturnStatement returnStatement){
        if(returnStatement.hasRetExpression()){
            returnStatement.getReturnExp().accept(this);
        }
        return null;
    }
    public Void visit(AccessExpression accessExpression){
        if(accessExpression.isFunctionCall()){
//            dependencyGraph.addEdge(currentParent, accessExpression.getAccessedExpression().toString());
            accessExpression.getAccessedExpression().accept(this);
        }
        return null;
    }
    public Void visit(Identifier identifier){
        dependencyGraph.addEdge(currentParent, identifier.getName());
        return null;
    }
    public Void visit(AppendExpression appendExpression){
        appendExpression.getAppendee().accept(this);
        for(Expression expression: appendExpression.getAppendeds()){
            expression.accept(this);
        }
        return null;
    }
    public Void visit(BinaryExpression binaryExpression){
        binaryExpression.getFirstOperand().accept(this);
        binaryExpression.getSecondOperand().accept(this);
        return null;
    }
    public Void visit(ChopStatement chopStatement){
        chopStatement.getChopExpression().accept(this);
        return null;
    }
    public Void visit(ChompStatement chompStatement){
        chompStatement.getChompExpression().accept(this);
        return null;
    }
    public Void visit(LenStatement lenStatement){
        lenStatement.getExpression().accept(this);
        return null;
    }
    public Void visit(UnaryExpression unaryExpression){
        unaryExpression.getExpression().accept(this);
        return null;
    }
    public Void findDependency(){
//        ArrayList<List<String>> cycles = dependencyGraph.findCycles();
//        for(List<String> cycle : cycles){
//            dependencyError.add(new CircularDependency(cycle));
//        }
        dependencyGraph.printGraph();
        return null;
    }

}
