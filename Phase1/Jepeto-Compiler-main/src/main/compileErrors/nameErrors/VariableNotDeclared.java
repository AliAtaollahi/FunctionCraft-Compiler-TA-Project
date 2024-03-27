package main.compileErrors.nameErrors;
import main.compileErrors.CompileError;

public class VariableNotDeclared extends CompileError {
    public VariableNotDeclared(int line, String variableName){
        super(line);
        message = "Variable " + variableName + " not declared";
    }
}