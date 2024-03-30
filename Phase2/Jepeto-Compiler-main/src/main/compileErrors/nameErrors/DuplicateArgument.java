package main.compileErrors.nameErrors;
import main.compileErrors.CompileError;

public class DuplicateArgument extends CompileError {
    public DuplicateArgument(int line, String argumentName){
        super(line);
        message = "Duplicate argument " + argumentName;
    }
}
