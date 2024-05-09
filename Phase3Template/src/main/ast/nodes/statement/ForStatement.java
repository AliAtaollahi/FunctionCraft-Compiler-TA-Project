package main.ast.nodes.statement;


import main.ast.nodes.expression.Expression;
import main.ast.nodes.expression.Identifier;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class ForStatement extends Statement{
    private Identifier iteratorId;
    private ArrayList<Expression> rangeExpressions = new ArrayList<>();
    private ArrayList<Statement> loopBodyStmts = new ArrayList<>();

    public ForStatement(Identifier identifierId, ArrayList<Expression> rangeExpressions ,ArrayList<Statement> loopBodyStmts){
        this.iteratorId = identifierId;
        this.rangeExpressions = rangeExpressions;
        this.loopBodyStmts = loopBodyStmts;
    }

    public ArrayList<Expression> getRangeExpressions() {
        return rangeExpressions;
    }

    public ArrayList<Statement> getLoopBodyStmts() {
        return loopBodyStmts;
    }

    public Identifier getIteratorId() {
        return iteratorId;
    }

    public void setIteratorId(Identifier iteratorId) {
        this.iteratorId = iteratorId;
    }

    public void setLoopBodyStmts(ArrayList<Statement> loopBodyStmts) {
        this.loopBodyStmts = loopBodyStmts;
    }

    public void setRangeExpressions(ArrayList<Expression> rangeExpressions) {
        this.rangeExpressions = rangeExpressions;
    }

    @Override
    public String toString(){return "ForLoop:"+iteratorId.getName();}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}

}
