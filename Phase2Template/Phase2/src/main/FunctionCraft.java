package main;



import main.ast.nodes.Program;
import main.compileError.CompileError;
import main.visitor.astPrinter.AstPrinter;
import main.visitor.nameAnalyzer.NameAnalyzer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parsers.FunctionCraftLexer;
import parsers.FunctionCraftParser;


import java.io.IOException;

public class FunctionCraft {
    public static void main(String[] args) throws IOException{
        CharStream reader = CharStreams.fromFileName(args[0]);
        FunctionCraftLexer flLexer = new FunctionCraftLexer(reader);
        CommonTokenStream tokens = new CommonTokenStream(flLexer);
        FunctionCraftParser flParser = new FunctionCraftParser(tokens);
        Program program = flParser.program().flProgram;
//        AstPrinter astPrinter = new AstPrinter();
//        astPrinter.visit(program);
        NameAnalyzer nameAnalyzer = new NameAnalyzer();
        nameAnalyzer.visit(program);
        for(CompileError compileError : nameAnalyzer.nameErrors){
            System.out.println(compileError.getErrorMessage());
        }
    }
}
