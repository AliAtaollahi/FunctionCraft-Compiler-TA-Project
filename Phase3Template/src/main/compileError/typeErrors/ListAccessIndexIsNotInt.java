package main.compileError.typeErrors;

import main.compileError.CompileError;

public class ListAccessIndexIsNotInt extends CompileError {
    public ListAccessIndexIsNotInt(int line){
        this.line = line;
    }
    public String getErrorMessage(){return "Line:" + this.line + "-> list access index for list must be integer";}
}
