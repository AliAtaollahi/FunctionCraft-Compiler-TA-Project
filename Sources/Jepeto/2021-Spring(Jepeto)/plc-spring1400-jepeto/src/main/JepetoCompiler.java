package main;

import main.ast.nodes.Program;
import main.visitor.*;
import main.visitor.codeGenerator.CodeGenerator;
import main.visitor.name.NameAnalyser;
import main.visitor.type.TypeCheker;
import main.visitor.type.TypeSetter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import parsers.*;

import java.io.*;

public class JepetoCompiler {

    public void compile(CharStream textStream) {
        JepetoLexer jepetoLexer = new JepetoLexer(textStream);
        CommonTokenStream tokenStream = new CommonTokenStream(jepetoLexer);

        JepetoParser jepetoParser = new JepetoParser(tokenStream);
        Program program = jepetoParser.jepeto().jepetoProgram;
        ErrorReporter errorReporter = new ErrorReporter();

        NameAnalyser nameAnalyser = new NameAnalyser();
        program.accept(nameAnalyser);
        int numberOfErrors = program.accept(errorReporter);
        if(numberOfErrors > 0)
            System.exit(1);
        TypeSetter typeSetter = new TypeSetter();
        program.accept(typeSetter);
        TypeCheker typeCheker = new TypeCheker(typeSetter.getVisited());
        program.accept(typeCheker);
        numberOfErrors = program.accept(errorReporter);
        if (numberOfErrors > 0)
            System.exit(1);
        System.out.println("Compilation successful");

        CodeGenerator codeGenerator = new CodeGenerator(typeCheker.getExpressionTypeChecker(), typeSetter.getVisited());
        program.accept(codeGenerator);

        runJasminFiles();
    }

    private void runJasminFiles() {
        try {
            System.out.println("\n-------------------Generating Class Files-------------------");
            File dir = new File("./output");
            Process process = Runtime.getRuntime().exec("java -jar jasmin.jar *.j", null, dir);
            printResults(process.getInputStream());
            printResults(process.getErrorStream());
            System.out.println("\n---------------------------Output---------------------------");
            process = Runtime.getRuntime().exec("java Main", null, dir);
            printResults(process.getInputStream());
            printResults(process.getErrorStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printResults(InputStream stream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String line;
        try {
            while ((line = reader.readLine()) != null)
                System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
