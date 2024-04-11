package main.ast.nodes.declaration;

import main.ast.nodes.expression.Expression;
import main.ast.nodes.expression.Identifier;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class PatternDeclaration extends Declaration{
    private Identifier patternName;
    private ArrayList<Expression> conditions = new ArrayList<>();
    private ArrayList<Expression> returnStmts = new ArrayList<>();
    public PatternDeclaration(Identifier name){this.patternName = name;}
    public void setPatternName(Identifier name){this.patternName = name;}
    public Identifier getPatternName(){return this.patternName;}

    public ArrayList<Expression> getConditions(){return this.conditions;}
    public void setConditions(ArrayList<Expression> conditions){this.conditions = conditions;}
    public void addCondition(Expression condition){this.conditions.add(condition);}

    public ArrayList<Expression> getReturnStmts(){return this.returnStmts;}
    public void setReturnStmts(ArrayList<Expression> returnStmts){this.returnStmts = returnStmts;}
    public void addReturnStmt(Expression returnStmt){this.returnStmts.add(returnStmt);}
    @Override
    public String toString(){return "PatternDeclaration:" + patternName;}
    @Override
    public <T> T accept(IVisitor<T>visitor){return visitor.visit(this);}

}
