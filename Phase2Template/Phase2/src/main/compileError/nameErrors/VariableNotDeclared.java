package main.compileError.nameErrors;

import main.compileError.CompileError;

public class VariableNotDeclared extends CompileError {
    private int line;
    private String name;
    public VariableNotDeclared(int line, String name){
        this.line = line;
        this.name = name;
    }
    public String getErrorMessage(){return "Line:" + this.line + "-> variable " + this.name + " is not declared";}
}
