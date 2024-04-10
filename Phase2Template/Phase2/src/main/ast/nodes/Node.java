package main.ast.nodes;

import main.compileError.CompileError;
import main.visitor.IVisitor;

import java.util.ArrayList;

public abstract class Node {
    private int line;
    private ArrayList<CompileError>compileErrors = new ArrayList<>();

    public void setLine(int line){this.line = line;}
    public int getLine(){return this.line;}
    public abstract String toString();
    public void addCompileError(CompileError ce){this.compileErrors.add(ce);}
    public abstract <T> T accept(IVisitor<T> visitor);
}
