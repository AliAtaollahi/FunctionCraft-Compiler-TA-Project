package main.compileError.typeErrors;

import main.compileError.CompileError;

public class CantUseValueOfVoidFunction extends CompileError {

    public CantUseValueOfVoidFunction(int line) {
        super(line, "Cannot use return value of a function having void return type");
    }

}
