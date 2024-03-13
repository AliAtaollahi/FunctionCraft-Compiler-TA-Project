package main.ast.types.functionPointer;

import main.ast.types.Type;

import java.util.ArrayList;

public class FptrType extends Type {
    private String functionName;

    public FptrType(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    @Override
    public String toString() {
        return "FptrType";
    }
}
