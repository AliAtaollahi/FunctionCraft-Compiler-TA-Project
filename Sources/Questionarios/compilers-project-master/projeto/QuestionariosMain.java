import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.stringtemplate.v4.*;
import java.io.*;


public class QuestionariosMain {
   public static void main(String[] args) {
      for (String a : args) {
         try {
            process(new FileInputStream(a));
         } catch (Exception ex) {
            System.err.println("Ocorreu um erro ao ler o ficheiro passado.");
         }
      }
   }

   public static void process(InputStream in) throws IOException {
      // create a CharStream that reads from standard input:
      CharStream input = CharStreams.fromStream(in);
      // create a lexer that feeds off of input CharStream:
      QuestionariosLexer lexer = new QuestionariosLexer(input);
      // create a buffer of tokens pulled from the lexer:
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      // create a parser that feeds off the tokens buffer:
      QuestionariosParser parser = new QuestionariosParser(tokens);
      // replace error listener:
      //parser.removeErrorListeners(); // remove ConsoleErrorListener
      //parser.addErrorListener(new ErrorHandlingListener());
      // begin parsing at program rule:
      ParseTree tree = parser.program();
      if (parser.getNumberOfSyntaxErrors() == 0) {
         // print LISP-style tree:
         // System.out.println(tree.toStringTree(parser));
         semanticCheckVisitor visitor0 = new semanticCheckVisitor();
         //System.out.println(visitor0.visit(tree));
         Boolean naoTemErros = visitor0.visit(tree);

         if (naoTemErros) {
            QuestionariosCompiler compiler = new QuestionariosCompiler();
            ST result = compiler.visit(tree);
            result.add("name", "Out");
            System.out.println(result.render());
         }
      }
   }
}
