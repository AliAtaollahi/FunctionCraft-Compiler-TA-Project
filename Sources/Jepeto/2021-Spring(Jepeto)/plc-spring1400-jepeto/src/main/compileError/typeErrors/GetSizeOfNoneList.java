package main.compileError.typeErrors;

import main.compileError.CompileError;

public class GetSizeOfNoneList extends CompileError {
    public GetSizeOfNoneList(int line) {
        super(line, "Get size of a non-list");
    }
}
