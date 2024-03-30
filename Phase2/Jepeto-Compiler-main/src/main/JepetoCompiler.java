package main;

import main.ast.nodes.Program;
import main.visitor.ASTErrorDetector;
import main.visitor.ASTTreePrinter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import parsers.*;

public class JepetoCompiler {
    public void compile(CharStream textStream) {
        JepetoLexer jepetoLexer = new JepetoLexer(textStream);
        CommonTokenStream tokenStream = new CommonTokenStream(jepetoLexer);
        JepetoParser jepetoParser = new JepetoParser(tokenStream);
        Program program = jepetoParser.jepeto().jepetoProgram;

        ASTErrorDetector error_detector = new ASTErrorDetector();
        if(error_detector.visit(program)) {
            ASTTreePrinter printer = new ASTTreePrinter();
            printer.visit(program);
        }
    }
}
