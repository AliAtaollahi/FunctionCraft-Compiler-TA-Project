package main.visitor.nameAnalyzer;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.FunctionDeclaration;
import main.ast.nodes.expression.AccessExpression;
import main.ast.nodes.expression.Expression;
import main.ast.nodes.expression.Identifier;
import main.ast.nodes.statement.ExpressionStatement;
import main.ast.nodes.statement.ReturnStatement;
import main.ast.nodes.statement.Statement;
import main.compileError.CompileError;
import main.compileError.nameErrors.CircularDependency;
import main.visitor.Visitor;
import main.symbolTable.utils.Graph;

import java.util.ArrayList;
import java.util.List;

public class DependencyDetector extends Visitor<Void> {
    public ArrayList<CompileError> dependencyError = new ArrayList<>();
    private Graph dependencyGraph = new Graph();
    @Override
    public Void visit(Program program){
        for(FunctionDeclaration functionDeclaration : program.getFunctionDeclarations()){
            functionDeclaration.accept(this);
        }

        return null;
    }
    @Override
    public Void visit(FunctionDeclaration functionDeclaration){
        for(Statement statement : functionDeclaration.getBody()){
            if(statement instanceof ExpressionStatement){
                ExpressionStatement exp = (ExpressionStatement) statement;
                if(exp.getExpression() instanceof AccessExpression){
                    AccessExpression accessExpression = (AccessExpression) exp.getExpression();
                    if(accessExpression.isFunctionCall()){
                        Identifier id_ = (Identifier) accessExpression.getAccessedExpression();
                        dependencyGraph.addEdge(functionDeclaration.getFunctionName().getName(),
                                id_.getName());
                    }
                }
            }
            else if(statement instanceof ReturnStatement){
                ReturnStatement returnStatement = (ReturnStatement) statement;
                if(returnStatement.hasRetExpression()){
                    if(returnStatement.getReturnExp() instanceof AccessExpression){
                        AccessExpression accessExpression = (AccessExpression) returnStatement.getReturnExp();
                        if(accessExpression.isFunctionCall()){
                            Identifier id_ = (Identifier) accessExpression.getAccessedExpression();
                            dependencyGraph.addEdge(functionDeclaration.getFunctionName().getName()
                                                    , id_.getName());
                        }
                    }
                }
            }
        }
        return null;
    }
    public Void findDependency(){
        ArrayList<List<String>> cycles = dependencyGraph.findCycles();
        for(List<String> cycle : cycles){
            dependencyError.add(new CircularDependency(cycle));
        }
        return null;
    }

}
