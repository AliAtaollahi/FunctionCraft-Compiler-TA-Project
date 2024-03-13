import org.stringtemplate.v4.*;
import java.util.*;

public class QuestionariosCompiler extends QuestionariosBaseVisitor<ST> {

   @Override public ST visitProgram(QuestionariosParser.ProgramContext ctx) {
      ST res = templates.getInstanceOf("module");
      Iterator <QuestionariosParser.StatContext> list = ctx.stat().iterator();
      while (list.hasNext()) {
         QuestionariosParser.StatContext q = list.next();
         res.add("stat", visit(q).render());
      }
      return res;
   }

   @Override public ST visitStatDeclaracao(QuestionariosParser.StatDeclaracaoContext ctx) {
      ST res = templates.getInstanceOf("stats");
      res.add("stat", visit(ctx.declaracao()).render());
      return res;
   }

   @Override public ST visitStatAtribuicao(QuestionariosParser.StatAtribuicaoContext ctx) {
      ST res = templates.getInstanceOf("stats");
      res.add("stat", visit(ctx.atribuicao()).render());
      return res;
   }

   @Override public ST visitStatMetodo(QuestionariosParser.StatMetodoContext ctx) {
      ST res = templates.getInstanceOf("stats");
      res.add("stat", visit(ctx.metodo()).render());
      return res;
   }

   @Override public ST visitStatCiclo(QuestionariosParser.StatCicloContext ctx) {
      return visit(ctx.ciclo());
   }

   @Override public ST visitStatSe(QuestionariosParser.StatSeContext ctx) {
      return visit(ctx.se());
   }

   @Override public ST visitStatInstrucoes_Para(QuestionariosParser.StatInstrucoes_ParaContext ctx) {
      return visit(ctx.instrucoes_para());
   }

   @Override public ST visitDeclaracao(QuestionariosParser.DeclaracaoContext ctx) {
      ST ret = templates.getInstanceOf("stats");

      visit(ctx.textoList());

      for (String v : ctx.textoList().var) {
         ST res = cicloFor ? templates.getInstanceOf("declForFor") : templates.getInstanceOf("decl");         
         String tipo = visit(ctx.type()).render();
         res.add("type", tipo);
         res.add("var", v);
         varTipos.put(v, tipo);

         ret.add("stat", res);
         if ( !cicloFor && !naoPrecisaNew.contains(tipo)) {
            ST init = templates.getInstanceOf("init");
            init.add("var",v);
            init.add("type",tipo);

            ret.add("stat", init.render());
         }
      }
      return ret;
   }

   @Override public ST visitTextoList(QuestionariosParser.TextoListContext ctx) {
      ST res = templates.getInstanceOf("stats");
      ctx.var = new String[ctx.TEXTO().size()];
      for (int i = 0; i< ctx.var.length ; i++) {
         ctx.var[i] = ctx.TEXTO(i).getText();
      }
      return res;
   }

   @Override public ST visitAtribuicao(QuestionariosParser.AtribuicaoContext ctx) {
      ST res = templates.getInstanceOf("stats");
      
      ST attr = templates.getInstanceOf("attr");
      attr.add("var", visit(ctx.variavel())); 
      varAtualStack.push(ctx.variavel().var);
      ST valor = visit(ctx.valor());
      attr.add("value", ctx.valor().var);
      res.add("stat", valor.render());
      res.add("stat", attr.render());
      varAtualStack.pop();
      return res;
   }

   @Override public ST visitVariavel(QuestionariosParser.VariavelContext ctx) {
      ST vars = templates.getInstanceOf("variavel");
      vars.add("var",  ctx.TEXTO().toString());
      if (ctx.variavel() != null) {
         vars.add("var", visit(ctx.variavel())) ;
      }
      ctx.var = vars.render();
      return vars;
   }

   @Override public ST visitMetodoComVariavel(QuestionariosParser.MetodoComVariavelContext ctx) {
      ST ret = visit(ctx.metodo_em_si());
      ret.add("arg", visit(ctx.variavel()).render());
      return ret;
   }
   
   @Override public ST visitMetodoSemVariavel(QuestionariosParser.MetodoSemVariavelContext ctx) {

      ST ret = visit(ctx.metodo_em_si()); 
      return ret;
   }

   @Override public ST visitMetodo_em_si(QuestionariosParser.Metodo_em_siContext ctx) {
      int i = 0;
      
      ST res = metodoRetorno ? templates.getInstanceOf("metodoComRetorno") : templates.getInstanceOf("metodo");

      variaveisParamOpcionais.push(getVar());
      ST declOp = templates.getInstanceOf("decl");
      declOp.add("var", variaveisParamOpcionais.peek());
      declOp.add("type", "ParamOpcionais");
      
      ST initOp = templates.getInstanceOf("init");
      initOp.add("type", "ParamOpcionais");
      initOp.add("var", variaveisParamOpcionais.peek());
      
      res.add("stat",declOp.render());
      res.add("stat", initOp);

      List<String> argums = new ArrayList<String>();
      
      while (ctx.argum(i) != null) {
         res.add("stat", visit(ctx.argum(i)) );
         argums.add(ctx.argum(i).var);
         i++;
      }
      
      res.add("met", ctx.TEXTO().toString());
      res.add("arg", variaveisParamOpcionais.pop());
      res.add("arg", argums);

      return res;
   }

   @Override public ST visitArgumVariavel(QuestionariosParser.ArgumVariavelContext ctx) {
      ST res = templates.getInstanceOf("stats");
      res.add("stat", visit(ctx.valor()));
      ST attr = templates.getInstanceOf("attr");
      ST var = templates.getInstanceOf("variavel");
      var.add("var", variaveisParamOpcionais.peek());
      var.add("var", visit(ctx.variavel()));

      attr.add("var", var.render());
      attr.add("value", ctx.valor().var);

      res.add("stat", attr.render());

      return res;
   }
   
   @Override public ST visitArgumValor(QuestionariosParser.ArgumValorContext ctx) {
      ST res = visit(ctx.valor());
      ctx.var = ctx.valor().var;
      return res;
   }

   @Override public ST visitInstrucoes_para_parar(QuestionariosParser.Instrucoes_para_pararContext ctx) {
      ST res = templates.getInstanceOf("comando");
      res.add("cmd", "break");
      return res;
   }

   @Override public ST visitInstrucoes_para_continuar(QuestionariosParser.Instrucoes_para_continuarContext ctx) {
      ST res = templates.getInstanceOf("comando");
      res.add("cmd", "continue");
      return res;
   }

   @Override public ST visitCiclo(QuestionariosParser.CicloContext ctx) {
      ST res = templates.getInstanceOf("stats");

      ST cond = templates.getInstanceOf("cicloCondForEach");
      cond.add("lista", visit(ctx.variavel()));

      cicloFor = true; // é usado no ctx.declaracao();
      cond.add("declFor", visit(ctx.declaracao()));
      cicloFor = false;

      ST ciclo = templates.getInstanceOf("ciclo");
      ciclo.add("cond", cond);

      for (int i = 0; i< ctx.stat().size(); i++) {
         ciclo.add("stat", visit(ctx.stat(i)));
      }

      res.add("stat",ciclo);
      return res;
   }

   @Override public ST visitSe(QuestionariosParser.SeContext ctx) {
      
      ST res = templates.getInstanceOf("stats");

      ST res2 = templates.getInstanceOf("stats");
      res2.add("stat",visit(ctx.se_inicial()).render());

      int i = 0;
      while (true) {
         if (ctx.ouse(i) == null ) break;
         res2.add("stat", visit(ctx.ouse(i)).render());
         i++;
      }
      
      if (ctx.senao() != null) {
         res2.add("stat", visit(ctx.senao()).render());
      }


      res.add("stat", ((ST) statsAntesDoIf.pop()).render());
      res.add("stat", res2.render());

      return res;
   }

   @Override public ST visitSe_inicial(QuestionariosParser.Se_inicialContext ctx) {
      ST stats = templates.getInstanceOf("stats");
      stats.add("stat", visit(ctx.condicao()));

      statsAntesDoIf.push(stats);

      ST se = templates.getInstanceOf("se");
      se.add("condicao", ctx.condicao().var);
      int i = 0;
      while (true) {
         if (ctx.stat(i) == null) break;
         se.add("stat", visit(ctx.stat(i)));
         i++;
      }
      
      return se;
   }

   @Override public ST visitOuse(QuestionariosParser.OuseContext ctx) {
      
      statsAntesDoIf.peek().add("stat", visit(ctx.condicao()));

      ST ouse = templates.getInstanceOf("ouse");
      ouse.add("condicao", ctx.condicao().var);
      int i = 0;
      while (true) {
         if (ctx.stat(i) == null) break;
         ouse.add("stat", visit(ctx.stat(i)));
         i++;
      }
      return ouse;
   }

   @Override public ST visitSenao(QuestionariosParser.SenaoContext ctx) {
      
      ST res = templates.getInstanceOf("senao");

      int i = 0;
      while (true) {
         if (ctx.stat(i) == null) break;
         res.add("stat", visit(ctx.stat(i)));
         i++;
      }
      return res;
   }

   @Override public ST visitCondicaoComparacao(QuestionariosParser.CondicaoComparacaoContext ctx) { 
      ctx.var = getVar();
      ST res = templates.getInstanceOf("stats");
      res.add("stat", visit(ctx.condicao(0)));
      res.add("stat", visit(ctx.condicao(1)));
      ST bool = templates.getInstanceOf("declAndAttr");
      bool.add("type", "boolean");
      bool.add("var", ctx.var);
      ST comp = null;
      String t = varTipos.containsKey(ctx.condicao(0).var) ? varTipos.get(ctx.condicao(0).var) : "boolean";

      if (naoPrecisaNew.contains(t) ){
         comp = templates.getInstanceOf("comparacao");

         comp.add("op", ctx.op.getText());
      } else {
         comp = templates.getInstanceOf("comparacaoObj");
         comp.add("not", ctx.op.getText().equals("!=") ? "!" : "" );
      }

      comp.add("stat1", ctx.condicao(0).var);
      comp.add("stat2", ctx.condicao(1).var);

      bool.add("value", comp.render());

      res.add("stat", bool.render());
      return res;
   }      

   @Override public ST visitCondicaoEOu(QuestionariosParser.CondicaoEOuContext ctx) { 
      ctx.var = getVar();
      ST res = templates.getInstanceOf("stats");
      res.add("stat", visit(ctx.condicao(0)));
      res.add("stat", visit(ctx.condicao(1)));

      ST bool = templates.getInstanceOf("declAndAttr");
      bool.add("type", "boolean");
      bool.add("var", ctx.var);

      ST comp = templates.getInstanceOf("comparacao");
      comp.add("stat1", ctx.condicao(0).var);
      comp.add("stat2", ctx.condicao(1).var);
      comp.add("op", ctx.op2.getText().equals("e") ? "&&" : "||" );

      bool.add("value", comp.render());

      res.add("stat", bool.render());
      return res;
   }

   @Override public ST visitCondicaoValor(QuestionariosParser.CondicaoValorContext ctx) { 
      ctx.var = visit(ctx.variavel()).render(); //getVar();

      ST res = templates.getInstanceOf("stats");
      
      return res;
   }

   @Override public ST visitCondicaoPerentesis(QuestionariosParser.CondicaoPerentesisContext ctx) { 
      ST res = visit(ctx.condicao());
      ctx.var = ctx.condicao().var;
      return res;
   }

   @Override public ST visitAux_StringString(QuestionariosParser.Aux_StringStringContext ctx) {
      ST res = templates.getInstanceOf("declAndAttr");
      ctx.var = getVar();
      res.add("var", ctx.var);
      res.add("type", "String");
      res.add("value", ctx.STRING().toString());
      return res;
   }

   @Override public ST visitAux_StringMetodo(QuestionariosParser.Aux_StringMetodoContext ctx) {

      metodoRetorno = true;
      ctx.var = getVar();
      ST res = visit(ctx.metodo());
      
      res.add("var", ctx.var);
      res.add("type", "String");

      metodoRetorno = false;
      return res;
   }

   @Override public ST visitAux_StringVariavel(QuestionariosParser.Aux_StringVariavelContext ctx) {      
      ST res = templates.getInstanceOf("stats");

      ctx.var = visit(ctx.variavel()).render();

      return res;
   }

   @Override public ST visitString(QuestionariosParser.StringContext ctx) {
      ctx.var = getVar();
      ST res = templates.getInstanceOf("declAndAttr");
      res.add("var", ctx.var);
      res.add("type", "String");

      ST concat = templates.getInstanceOf("stringConcat");

      int i = 0;
      while (true) {
         if (ctx.aux_string(i) == null) break;

         res.add("stat" , visit(ctx.aux_string(i)).render() );
         concat.add("str", ctx.aux_string(i).var );
         i++;
      }

      res.add("value", concat); 
      return res;
   }

   @Override public ST visitValorVariavel(QuestionariosParser.ValorVariavelContext ctx) {
      visit(ctx.variavel());
      ctx.var = ctx.variavel().var;

      ST res = templates.getInstanceOf("stats");

      return res;
   }

   @Override public ST visitValorString(QuestionariosParser.ValorStringContext ctx) {
      ST res = visit(ctx.string());
      ctx.var = ctx.string().var;
      return res;
   }

   @Override public ST visitValorExpr(QuestionariosParser.ValorExprContext ctx) {
      ST res = visit(ctx.expr());
      ctx.var = ctx.expr().var;
      return res;
   }
   
   @Override public ST visitValorLista(QuestionariosParser.ValorListaContext ctx) {

      ctx.var = varAtualStack.peek() ;
      ST res = templates.getInstanceOf("stats");

      varAtualStack.push(ctx.var);

      if (ctx.listaMembro() != null) {
         res.add("stat", visit(ctx.listaMembro()).render());
      }
      return res;
   }

   @Override public ST visitValorDificuldade(QuestionariosParser.ValorDificuldadeContext ctx) {
      ST res = visit(ctx.dificuldade());
      ctx.var = ctx.dificuldade().var;
      return res;
   }

   @Override public ST visitValorResposta(QuestionariosParser.ValorRespostaContext ctx) {
      ST res = visit(ctx.resposta());
      ctx.var = ctx.resposta().var;
      return res;
   }

   @Override public ST visitValorMetodo(QuestionariosParser.ValorMetodoContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitValorTema(QuestionariosParser.ValorTemaContext ctx) {
      ST res = visit(ctx.tema());
      ctx.var = ctx.tema().var;
      return res;
   }

   @Override public ST visitValorType(QuestionariosParser.ValorTypeContext ctx) {
      ctx.var = "";
      return visit(ctx.type());
   }

   @Override public ST visitValorCondicao(QuestionariosParser.ValorCondicaoContext ctx) {
      ST res = visit(ctx.condicao());
      ctx.var = ctx.condicao().var;
      return res;
   }

   @Override public ST visitTema(QuestionariosParser.TemaContext ctx) {
      ctx.var = getVar();
      ST res = templates.getInstanceOf("stats");

      ST dec = templates.getInstanceOf("decl");
      dec.add("var", ctx.var);
      dec.add("type", "Tema");

      String varArr = getVar();
      ST arrayDecl = templates.getInstanceOf("arrDeclAndInit");
      arrayDecl.add("type", "String");
      arrayDecl.add("var", varArr);

      ST init = templates.getInstanceOf("init");
      init.add("type", "Tema");
      init.add("var", ctx.var);
      int i = 0;
      while (true) {
         if (ctx.TEXTO(i) == null) break;
         arrayDecl.add("arg", "\"" + ctx.TEXTO(i).getText() + "\"");
         i++;
      }
      res.add("stat", arrayDecl);
      init.add("arg", varArr);
      res.add("stat", dec);
      res.add("stat", init);

      return res;
   }
   
   @Override public ST visitExprOp(QuestionariosParser.ExprOpContext ctx) {
      ctx.var = getVar();
      ST res = templates.getInstanceOf("stats");
      res.add("stat", visit(ctx.expr()));

      ST dec = templates.getInstanceOf("declAndAttr");
      String tipo = (varTipos.containsKey(varAtualStack.peek()) ? varTipos.get(varAtualStack.peek()) : getTipoDefault(varAtualStack.peek()) );
      dec.add("type", tipo);
      dec.add("var", ctx.var);
      dec.add("value", ctx.op.getText().equals("+") ? ctx.expr().var : "-" + ctx.expr().var);

      res.add("stat", dec.render());
      return res;
   }

   @Override public ST visitExprMultDiv(QuestionariosParser.ExprMultDivContext ctx) {
      ctx.var = getVar();
      ST res = templates.getInstanceOf("stats");
      res.add("stat", visit(ctx.e1) );
      res.add("stat", visit(ctx.e2) );

      ST oper = templates.getInstanceOf("operacao");
      oper.add("var1", ctx.e1.var);
      oper.add("var2", ctx.e2.var);
      oper.add("op", ctx.op.getText().equals("//") ? "%" : ctx.op.getText());

      ST decl = templates.getInstanceOf("declAndAttr");
      String tipo = (varTipos.containsKey(varAtualStack.peek()) ? varTipos.get(varAtualStack.peek()) : getTipoDefault(varAtualStack.peek()) );
      decl.add("type", tipo);
      decl.add("var", ctx.var );
      decl.add("value", oper.render());

      res.add("stat", decl.render());

      return res;
   }

   @Override public ST visitExprAddSub(QuestionariosParser.ExprAddSubContext ctx) {
      ctx.var = getVar();
      ST res = templates.getInstanceOf("stats");
      res.add("stat", visit(ctx.e1) );
      res.add("stat", visit(ctx.e2) );

      ST oper = templates.getInstanceOf("operacao");
      oper.add("var1", ctx.e1.var);
      oper.add("var2", ctx.e2.var);
      oper.add("op", ctx.op.getText());

      ST decl = templates.getInstanceOf("declAndAttr");
      String tipo = (varTipos.containsKey(varAtualStack.peek()) ? varTipos.get(varAtualStack.peek()) : getTipoDefault(varAtualStack.peek()) );
      decl.add("type", tipo);
      decl.add("var", ctx.var );
      decl.add("value", oper.render());

      res.add("stat", decl.render());

      return res;
   }
   
   @Override public ST visitExprInt(QuestionariosParser.ExprIntContext ctx) {
      ctx.var = getVar();
      String num = ctx.INT(0).getText();

      varTipos.put("temp", "int");

      if (ctx.INT(1) != null) {
         num += "." + ctx.INT(1).getText();
         varTipos.put("temp", "double");
      }

      ST res = templates.getInstanceOf("declAndAttr");
      
      String tipo = "";
      if (!varAtualStack.empty())
         tipo = varTipos.containsKey(varAtualStack.peek()) ? varTipos.get(varAtualStack.peek()) : getTipoDefault(varAtualStack.peek());
      
      if (varAtualStack.empty() || (varAtualStack.peek() != "double" && varAtualStack.peek() != "double" ) )
         tipo = varTipos.get("temp");

      res.add("type", tipo );
      res.add("var", ctx.var);
      res.add("value", num);

      return res;
   }

   @Override public ST visitExprExpr(QuestionariosParser.ExprExprContext ctx) {
      ST res = visit(ctx.expr());
      ctx.var = ctx.expr().var;
      return res;
   }

   @Override public ST visitExprVariavel(QuestionariosParser.ExprVariavelContext ctx) {
      ctx.var = visit(ctx.variavel()).render();
      ST res = templates.getInstanceOf("stats");
      return res;
   }

   @Override public ST visitRespostaPalavra(QuestionariosParser.RespostaPalavraContext ctx) {
      ctx.var = getVar();
      String tipo = "EscolhaMultiplaResposta";
      ST res = templates.getInstanceOf("stats");
      varAtualStack.push("temp");
      res.add("stat", visit(ctx.expr()));
      varAtualStack.pop();
      res.add("stat", visit(ctx.string()));

      ST decl = templates.getInstanceOf("decl");
      decl.add("type", tipo);
      decl.add("var", ctx.var);

      ST init = templates.getInstanceOf("init");
      init.add("var", ctx.var);
      init.add("type", tipo);
      init.add("arg", ctx.string().var);
      init.add("arg", ctx.expr().var);

      res.add("stat", decl);
      res.add("stat", init);
      return res;
   }

   @Override public ST visitRespostaVF(QuestionariosParser.RespostaVFContext ctx) {
      ctx.var = getVar();
      String tipo = "VerdadeiroFalsoResposta";
      ST res = templates.getInstanceOf("stats");

      varAtualStack.push("temp");
      res.add("stat", visit(ctx.expr(0)));
      res.add("stat", visit(ctx.expr(1)));
      varAtualStack.pop();
      res.add("stat", visit(ctx.booleano()));
      res.add("stat", visit(ctx.string()));

      ST decl = templates.getInstanceOf("decl");
      decl.add("type", tipo);
      decl.add("var", ctx.var);

      ST init = templates.getInstanceOf("init");
      init.add("var", ctx.var);
      init.add("type", tipo);
      init.add("arg", ctx.string().var);
      init.add("arg", ctx.booleano().var);
      init.add("arg", ctx.expr(0).var);
      init.add("arg", ctx.expr(1).var);

      res.add("stat", decl);
      res.add("stat", init);
      return res;
   }

   @Override public ST visitListaMembroValor(QuestionariosParser.ListaMembroValorContext ctx) {
      ST res = templates.getInstanceOf("stats");
      res.add("stat", visit(ctx.valor()));

      ST res1 = templates.getInstanceOf("addToArrayList");
      res1.add("valor", ctx.valor().var);
      res1.add("var", varAtualStack.peek());

      res.add("stat", res1);
      return res;
   }

   @Override public ST visitListaMembroMembro(QuestionariosParser.ListaMembroMembroContext ctx) {
      ST res = templates.getInstanceOf("stats");

      res.add("stat", visit(ctx.valor()));
      ST add = templates.getInstanceOf("addToArrayList");
      add.add("valor", ctx.valor().var);
      add.add("var", varAtualStack.peek());

      res.add("stat", add.render());


      if (ctx.listaMembro() != null) {
         res.add("stat",visit(ctx.listaMembro()));
      } 

      return res;

   }
   @Override public ST visitDificuldade(QuestionariosParser.DificuldadeContext ctx) {
      ctx.var = getVar();
      ST res = templates.getInstanceOf("defineDificuldade");
      res.add("var", ctx.var);
      res.add("diff", ctx.DIFICULDADE().toString());
      return res;
   }

   @Override public ST visitBooleano(QuestionariosParser.BooleanoContext ctx) {
      ctx.var = getVar();
      ST res = templates.getInstanceOf("declAndAttr");
      res.add("value", ctx.BOOLEANO().getText());
      res.add("type", "boolean");
      res.add("var", ctx.var);
      return res;
   }

   @Override public ST visitInteiroType(QuestionariosParser.InteiroTypeContext ctx) {
      ST res = templates.getInstanceOf("token");
      res.add("t", "int");
      return res;
   }

   @Override public ST visitRealType(QuestionariosParser.RealTypeContext ctx) {
      ST res = templates.getInstanceOf("token");
      res.add("t", "double");
      return res;
   }

   @Override public ST visitEscolhaMultiplaType(QuestionariosParser.EscolhaMultiplaTypeContext ctx) {
      ST res = templates.getInstanceOf("token");
      res.add("t", "EscolhaMultiplaQuestao");
      return res;
   }

   @Override public ST visitQuestaoType(QuestionariosParser.QuestaoTypeContext ctx) {
      ST res = templates.getInstanceOf("token");
      res.add("t", "Questao");
      return res;
   }

   @Override public ST visitVerdadeiroFalsoType(QuestionariosParser.VerdadeiroFalsoTypeContext ctx) {
      ST res = templates.getInstanceOf("token");
      res.add("t", "VerdadeiroFalsoQuestao");
      return res;
   }

   @Override public ST visitCurtaTextualType(QuestionariosParser.CurtaTextualTypeContext ctx) {
      ST res = templates.getInstanceOf("token");
      res.add("t", "CurtaTextualQuestao");
      return res;
   }

   @Override public ST visitLongaTextualType(QuestionariosParser.LongaTextualTypeContext ctx) {
      ST res = templates.getInstanceOf("token");
      res.add("t", "LongaTextualQuestao");
      return res;
   }

   @Override public ST visitStringType(QuestionariosParser.StringTypeContext ctx) {
      ST res = templates.getInstanceOf("token");
      res.add("t", "String");
      return res;
   }

   @Override public ST visitQuestionarioType(QuestionariosParser.QuestionarioTypeContext ctx) {
      ST res = templates.getInstanceOf("token");
      res.add("t", "Questionario");
      return res;
   }

   @Override public ST visitREscolhaMultiplaType(QuestionariosParser.REscolhaMultiplaTypeContext ctx) {
      ST res = templates.getInstanceOf("token");
      res.add("t", "EscolhaMultiplaResposta");
      return res;
   }

   @Override public ST visitRCurtaTextualType(QuestionariosParser.RCurtaTextualTypeContext ctx) {
      ST res = templates.getInstanceOf("token");
      res.add("t", "EscolhaMultiplaResposta");
      return res;
   }

   @Override public ST visitRLongaTextualType(QuestionariosParser.RLongaTextualTypeContext ctx) {
      ST res = templates.getInstanceOf("token");
      res.add("t", "LongaTextualResposta");
      return res;
   }

   @Override public ST visitRVerdadeiroFalsoType(QuestionariosParser.RVerdadeiroFalsoTypeContext ctx) {
      ST res = templates.getInstanceOf("token");
      res.add("t", "VerdadeiroFalsoResposta");
      return res;
   }

   @Override public ST visitGrupoType(QuestionariosParser.GrupoTypeContext ctx) {
      ST res = templates.getInstanceOf("token");
      res.add("t", "Grupo");
      return res;
   }

   @Override public ST visitBooleanType(QuestionariosParser.BooleanTypeContext ctx) {
      ST res = templates.getInstanceOf("token");
      res.add("t", "boolean");
      return res;
   }

   @Override public ST visitRespostaType(QuestionariosParser.RespostaTypeContext ctx) {
      ST res = templates.getInstanceOf("token");
      res.add("t", "Resposta");
      return res;
   }

   @Override public ST visitTemaType(QuestionariosParser.TemaTypeContext ctx) {
      ST res = templates.getInstanceOf("token");
      res.add("t", "Tema");
      return res;
   }

   @Override public ST visitListaType(QuestionariosParser.ListaTypeContext ctx) {
      ST res = templates.getInstanceOf("token");
      
      String tipo = visit(ctx.type()).render();
      tipo = tipo.contains("Resposta") ? "Resposta" : tipo;
      res.add("t", "ArrayList<" + tipo + ">");

      return res;
   }

   @Override public ST visitDificuldadeType(QuestionariosParser.DificuldadeTypeContext ctx) {
      ST res = templates.getInstanceOf("token");
      res.add("t", "Dificuldade");
      return res;
   }

   int i = 0;
   private String getVar() { return "v" + i++; }
   private STGroup templates = new STGroupFile("java.stg");

   private HashMap<String, String> varTipos = new HashMap<String, String>();
   private static HashMap<String, String> tiposDefault = new HashMap<String, String>();
   private static HashSet<String> naoPrecisaNew = new HashSet<String>();

   static {
      naoPrecisaNew.add("int");
      naoPrecisaNew.add("double");
      naoPrecisaNew.add("boolean");
      naoPrecisaNew.add("String");
      naoPrecisaNew.add("Dificuldade");
      naoPrecisaNew.add("LongaTextualResposta");
   }

   static {
      tiposDefault.put("tema", "Tema");
      tiposDefault.put("pergunta", "String");
      tiposDefault.put("dificuldade", "Dificuldade");
      tiposDefault.put("respostas", "ArrayList<Respostas>");
      tiposDefault.put("pontuacao", "double");
      tiposDefault.put("tempomaximo", "int");
      tiposDefault.put("minperguntasaresponder", "int");
      tiposDefault.put("nrperguntasaapresentar", "int");
      
   }

   private String getTipoDefault(String var) {
      if (!var.contains(".")) return null;

      String var2 = var.substring(var.indexOf(".") + 1, var.length());

      if (!tiposDefault.containsKey(var2)) return null;
      return tiposDefault.get(var2);
   }

   private String varAtual = "default";

   Stack<String> varAtualStack = new Stack<String>();
   private String variavelLista = null;

   Stack<ST> statsAntesDoIf = new Stack<ST>();
   boolean cicloFor = false;
   boolean metodoRetorno = false;
   Stack<String> variaveisParamOpcionais = new Stack<String>();

}
