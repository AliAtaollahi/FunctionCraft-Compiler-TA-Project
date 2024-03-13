package main.ast.nodes.expression;

import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//line -> LPAR before arguments
public class FunctionCall extends Expression {
    private Expression instance;
    private ArrayList<Expression> args = new ArrayList<>();
    private Map<Identifier, Expression> argsWithKey = new HashMap<>();

    public FunctionCall(Expression instance) {
        this.instance = instance;
    }

    public FunctionCall(Expression instance, ArrayList<Expression> args, Map<Identifier, Expression> argsWithKey) {
        this.instance = instance;
        if (args != null)
            this.args = args;
        if (argsWithKey != null)
            this.argsWithKey = argsWithKey;
    }

    public Expression getInstance() {
        return instance;
    }

    public void setInstance(Expression instance) {
        this.instance = instance;
    }

    public ArrayList<Expression> getArgs() {
        return args;
    }

    public void setArgs(ArrayList<Expression> args) {
        this.args = args;
    }

    public void addArg(Expression arg) {
        this.args.add(arg);
    }
    public Map<Identifier, Expression> getArgsWithKey() {
        return argsWithKey;
    }

    public void setArgsWithKey(Map<Identifier, Expression> argsWithKey) {
        this.argsWithKey = argsWithKey;
    }




    @Override
    public String toString() {
        return "FunctionCall";
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }


}
