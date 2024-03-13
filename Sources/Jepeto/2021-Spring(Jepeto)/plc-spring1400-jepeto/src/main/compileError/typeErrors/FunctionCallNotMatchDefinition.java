package main.compileError.typeErrors;

import main.compileError.CompileError;

public class FunctionCallNotMatchDefinition extends CompileError {

    public FunctionCallNotMatchDefinition(int line) {
        super(line, "Args in function call do not match with definition");
    }

}
