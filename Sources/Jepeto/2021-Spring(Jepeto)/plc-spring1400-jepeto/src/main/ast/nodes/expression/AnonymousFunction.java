package main.ast.nodes.expression;

import main.ast.nodes.statement.Statement;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class AnonymousFunction extends Expression {
    private ArrayList<Identifier> args;
    private Statement body;
    private String name;

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

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
