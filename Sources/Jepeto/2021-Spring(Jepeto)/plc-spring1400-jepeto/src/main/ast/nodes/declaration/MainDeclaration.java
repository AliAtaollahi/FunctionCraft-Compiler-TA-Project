package main.ast.nodes.declaration;


import main.ast.nodes.statement.Statement;
import main.visitor.IVisitor;


//MAIN
public class MainDeclaration extends Declaration{

    protected Statement body;



    public Statement getBody() {
        return body;
    }

    public void setBody(Statement body) {
        this.body = body;
    }






    @Override
    public String toString() {
        return "MainDeclaration";
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
