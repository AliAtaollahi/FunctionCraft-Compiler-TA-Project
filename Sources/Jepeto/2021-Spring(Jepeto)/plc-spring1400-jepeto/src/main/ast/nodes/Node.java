package main.ast.nodes;


import main.compileError.CompileError;
import main.visitor.IVisitor;

import java.util.ArrayList;


public abstract class Node{
    private int line;
    private ArrayList<CompileError> errors = new ArrayList<>();
    public static boolean isCatchErrorsActive = true;

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public abstract String toString();
    public void addError(CompileError e) {
        if(Node.isCatchErrorsActive) {
            this.errors.add(e);
        }
    }

    public ArrayList<CompileError> flushErrors() {
        ArrayList<CompileError> errors = this.errors;
        this.errors = new ArrayList<>();
        return errors;
    }

    public abstract <T> T accept(IVisitor<T> visitor);

}

