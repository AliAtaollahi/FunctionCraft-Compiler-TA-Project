package main.compileError.nameError;
import main.compileError.CompileError;

public class NameConflict extends CompileError {
    public NameConflict(int line, String argumentName){
        super(line, "Name of argument " + argumentName + " conflicts with a function’s name");
    }
}
