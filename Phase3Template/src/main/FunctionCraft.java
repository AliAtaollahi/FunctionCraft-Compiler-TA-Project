package main;



import main.ast.nodes.Program;
import main.compileError.CompileError;
import main.visitor.type.TypeChecker;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parsers.FunctionCraftLexer;
import parsers.FunctionCraftParser;


import java.io.IOException;
import java.util.*;

public class FunctionCraft {
    public static void main(String[] args) throws IOException {
        CharStream reader = CharStreams.fromFileName(args[0]);
        FunctionCraftLexer flLexer = new FunctionCraftLexer(reader);
        CommonTokenStream tokens = new CommonTokenStream(flLexer);
        FunctionCraftParser flParser = new FunctionCraftParser(tokens);
        Program program = flParser.program().flProgram;
        TypeChecker typeChecker = new TypeChecker();
        typeChecker.visit(program);
    }
}
