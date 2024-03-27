package main.ast.nodes.expression;

import main.ast.nodes.statement.Statement;
import main.visitor.IVisitor;

import java.util.ArrayList;

//line -> LPAR before arguments
public class AnonymousFunction extends Expression {
    private ArrayList<Identifier> args = new ArrayList<>();
    private Statement body;

    public AnonymousFunction(ArrayList<Identifier> args) {
        this.args = args;
    }
    public ArrayList<Identifier> getArgs() {
        return args;
    }

    public void setArgs(ArrayList<Identifier> args) {
        this.args = args;
    }

    public Statement getBody() {
        return body;
    }

    public void setBody(Statement body) {
        this.body = body;
    }


    @Override
    public String toString() {
        return "AnonymousFunction";
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }


}
