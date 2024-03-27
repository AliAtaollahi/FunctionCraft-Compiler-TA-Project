package main.compileErrors.nameErrors;
import main.compileErrors.CompileError;

public class NameConflict extends CompileError {
    public NameConflict(int line, String argumentName){
        super(line);
        message = "Name of argument " + argumentName + " conflicts with a function’s name";
    }
}
