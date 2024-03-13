package main.ast.types.list;

import main.ast.types.Type;

import java.util.ArrayList;

public class ListType extends Type {
    private Type type;
    private boolean typeSet;

    public ListType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isTypeSet() {
        return typeSet;
    }

    public void setTypeSet(boolean typeSet) {
        this.typeSet = typeSet;
    }

    @Override
    public String toString() {
        return "ListType";
    }
}
