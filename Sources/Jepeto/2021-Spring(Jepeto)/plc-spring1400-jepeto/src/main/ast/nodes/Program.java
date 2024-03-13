package main.ast.nodes;

import main.ast.nodes.declaration.FunctionDeclaration;
import main.ast.nodes.declaration.MainDeclaration;
import main.visitor.IVisitor;

import java.util.ArrayList;

//line -> 1
public class Program extends Node {
    private ArrayList<FunctionDeclaration> functions = new ArrayList<>();
    private MainDeclaration main = new MainDeclaration();

    public Program(){

    }


    public ArrayList<FunctionDeclaration> getFunctions() {
        return functions;
    }

    public void setFunctions(ArrayList<FunctionDeclaration> functions) {
        this.functions = functions;
    }

    public MainDeclaration getMain() {
        return main;
    }

    public void setMain(MainDeclaration main) {
        this.main = main;
    }

    public void addFunction(FunctionDeclaration function) {
        functions.add(function);
    }


    @Override
    public String toString() {
        return "Program";
    }

    public <R> R accept(IVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
