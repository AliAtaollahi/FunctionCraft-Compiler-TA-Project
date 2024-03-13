package main.compileError.typeErrors;

import main.compileError.CompileError;

public class UnsupportedOperandType extends CompileError {

    public UnsupportedOperandType(int line, String operatorName) {
        super(line, "Unsupported operand type for operator " + operatorName);
    }

}
