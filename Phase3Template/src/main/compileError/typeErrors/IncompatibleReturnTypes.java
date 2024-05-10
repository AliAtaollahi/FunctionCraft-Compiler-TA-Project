package main.compileError.typeErrors;

import main.compileError.CompileError;

public class IncompatibleReturnTypes extends CompileError {
    private final String functionName;
    public IncompatibleReturnTypes(int line, String functionName){
        this.line = line;
        this.functionName = functionName;
    }
    public String getErrorMessage(){return "Line:" + this.line + "-> types of return expressions of the function " + this.functionName + " must be same";}
}
