package main.compileError.typeErrors;

import main.compileError.CompileError;

public class ListAccessByIndexOnNoneList extends CompileError {

    public ListAccessByIndexOnNoneList(int line) {
        super(line, "Access by index on a non-list");
    }

}
