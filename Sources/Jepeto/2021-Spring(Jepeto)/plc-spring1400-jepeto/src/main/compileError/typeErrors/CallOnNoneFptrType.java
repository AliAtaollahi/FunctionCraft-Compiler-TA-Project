package main.compileError.typeErrors;

import main.compileError.CompileError;

public class CallOnNoneFptrType extends CompileError {

    public CallOnNoneFptrType(int line) {
        super(line, "Calling a non-callable");
    }

}
