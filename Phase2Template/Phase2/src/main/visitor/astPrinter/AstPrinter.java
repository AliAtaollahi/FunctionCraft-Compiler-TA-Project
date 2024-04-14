package main.visitor.astPrinter;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.FunctionDeclaration;
import main.ast.nodes.declaration.PatternDeclaration;
import main.ast.nodes.declaration.VarDeclaration;
import main.ast.nodes.expression.Identifier;
import main.visitor.Visitor;

public class AstPrinter extends Visitor<Void> {
    public void printMessage(int line, String message){
        System.out.println("line:" + String.valueOf(line) + message);
    }

    @Override
    public Void visit(Program program) {
        printMessage(program.getLine(), program.toString());
        for(FunctionDeclaration functionDeclaration : program.getFunctionDeclarations()){
            functionDeclaration.accept(this);
        }
        for(PatternDeclaration patternDeclaration : program.getPatternDeclarations()){
            patternDeclaration.accept(this);
        }
        program.getMain().accept(this);
        return null;
    }
    @Override
    public Void visit(Identifier identifier){
        printMessage(identifier.getLine(), identifier.toString());
        return null;
    }
    @Override
    public Void visit(VarDeclaration varDeclaration){
        printMessage(varDeclaration.getLine(), varDeclaration.toString());
        if(varDeclaration.getDefaultVal() != null){
            varDeclaration.getDefaultVal().accept(this);
        }
        return null;
    }
}
