package main.compileError.nameError;
import main.compileError.CompileError;

public class ArgumentNotDeclared extends CompileError {
    public ArgumentNotDeclared(int line, String argumentName, String functionName){
        super(line, "Argument " + argumentName + " not declared in function " + functionName);
    }
}

