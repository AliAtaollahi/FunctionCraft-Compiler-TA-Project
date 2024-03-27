package main.compileErrors.nameErrors;
import main.compileErrors.CompileError;

public class DuplicateFunction extends CompileError {
    public DuplicateFunction(int line, String functionName){
        super(line);
        message = "Duplicate function " + functionName;
    }
}
