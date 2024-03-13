package main.compileError.nameError;
import main.compileError.CompileError;

public class DuplicateArgument extends CompileError {
    public DuplicateArgument(int line, String argumentName){
        super(line, "Duplicate argument " + argumentName);
    }
}
