package main.compileError.typeErrors;

import main.compileError.CompileError;

public class ListElementsTypeNotMatch extends CompileError {
    public ListElementsTypeNotMatch(int line) {
        super(line, "Elements of the list have different types");
    }
}
