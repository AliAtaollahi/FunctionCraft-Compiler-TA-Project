import static java.lang.System.*;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.util.*;


public class semanticCheckVisitor extends QuestionariosBaseVisitor<Boolean> {
   
   @Override public Boolean visitProgram(QuestionariosParser.ProgramContext ctx) {
      boolean res = visit(ctx.stat(0));
      int i = 1;
      while (true) {
		if (ctx.stat(i) == null) {
			break;
		} else {
			res = (visit(ctx.stat(i)) && res);
			i = i+1;
		}
	  }
      return res;
   }
   
   @Override public Boolean visitStatDeclaracao(QuestionariosParser.StatDeclaracaoContext ctx) {
      boolean res = visit(ctx.declaracao());
      return res;
   }
   
   @Override public Boolean visitStatAtribuicao(QuestionariosParser.StatAtribuicaoContext ctx) {
      boolean res = visit(ctx.atribuicao());
      return res;
   }
   
   @Override public Boolean visitStatMetodo(QuestionariosParser.StatMetodoContext ctx) {
      boolean res = visit(ctx.metodo());
      return res;
   }
   
   @Override public Boolean visitStatCiclo(QuestionariosParser.StatCicloContext ctx) {
      boolean res = visit(ctx.ciclo());
      return res;
   }
   
   @Override public Boolean visitStatSe(QuestionariosParser.StatSeContext ctx) {
      boolean res = visit(ctx.se());
      return res;
   }
   
   @Override public Boolean visitStatInstrucoes_Para(QuestionariosParser.StatInstrucoes_ParaContext ctx) {
      boolean res = visit(ctx.instrucoes_para());
      return res;
   }
   



   @Override public Boolean visitDeclaracao(QuestionariosParser.DeclaracaoContext ctx) {
      boolean res = visit(ctx.type());
      if (res) {
			 ctx.textoList().t = ctx.type().res;
			res = visit(ctx.textoList());
      }
      ctx.t = ctx.textoList().t;
      return res;
   }


   @Override public Boolean visitTextoList(QuestionariosParser.TextoListContext ctx) {
	  
      boolean res = true;
      Iterator<TerminalNode> list = ctx.TEXTO().iterator();
      while(list.hasNext()) {
         String texto = list.next().getText(); 
          if (tabelas.contains(ctx.contextnumID,texto)) {
			  ErrorHandling.printError(ctx, "variable "+texto+" already exists!");
			 res = false;
		  } else {
			switch (ctx.t.toString().split("@")[0]) {
				case "QuestaoType":
					Symbol s = new VariableSymbol(texto+"->pergunta", StringType);
					tabelas.put(ctx.contextnumID,texto+"->pergunta", s);
					s = new VariableSymbol(texto+"->dificuldade", DificuldadeType);
					tabelas.put(ctx.contextnumID,texto+"->dificuldade", s);
					s = new VariableSymbol(texto+"->pontuacao", RealType);
					tabelas.put(ctx.contextnumID,texto+"->pontuacao", s);
					s = new VariableSymbol(texto+"->tempomaximo", InteiroType);
					tabelas.put(ctx.contextnumID,texto+"->tempomaximo", s);
					s = new VariableSymbol(texto+"->respostas", new ListaType(RespostaType));
					tabelas.put(ctx.contextnumID,texto+"->respostas", s);
					s = new VariableSymbol(texto+"->tema", TemaType);
					tabelas.put(ctx.contextnumID,texto+"->tema", s);
					s = new VariableSymbol(texto+"->tipo", StringType);
					tabelas.put(ctx.contextnumID,texto+"->tipo", s);
					s = new VariableSymbol(texto+"->respostadada", RespostaType);
					tabelas.put(ctx.contextnumID,texto+"->respostadada", s);
					s = new VariableSymbol(texto+"->respostadada->pontuacao", RealType);
					tabelas.put(ctx.contextnumID,texto+"->respostadada->pontuacao", s);
					break;
				case "QuestionarioType":
					s = new VariableSymbol(texto+"->questoes", new ListaType(QuestaoType));
					tabelas.put(ctx.contextnumID,texto+"->questoes", s);
					s = new VariableSymbol(texto+"->tempomaximo", InteiroType);
					tabelas.put(ctx.contextnumID,texto+"->tempomaximo", s);
					s = new VariableSymbol(texto+"->duracao", InteiroType);
					tabelas.put(ctx.contextnumID,texto+"->duracao", s);
					s = new VariableSymbol(texto+"->pontuacao", RealType);
					tabelas.put(ctx.contextnumID,texto+"->pontuacao", s);
					break;
				case "QuestaoEscolhaMultiplaType":
					s = new VariableSymbol(texto+"->pergunta", StringType);
					tabelas.put(ctx.contextnumID,texto+"->pergunta", s);
					s = new VariableSymbol(texto+"->dificuldade", DificuldadeType);
					tabelas.put(ctx.contextnumID,texto+"->dificuldade", s);
					s = new VariableSymbol(texto+"->pontuacao", RealType);
					tabelas.put(ctx.contextnumID,texto+"->pontuacao", s);
					s = new VariableSymbol(texto+"->tempomaximo", InteiroType);
					tabelas.put(ctx.contextnumID,texto+"->tempomaximo", s);
					s = new VariableSymbol(texto+"->respostas", new ListaType(REscolhaMultiplaType));
					tabelas.put(ctx.contextnumID,texto+"->respostas", s);
					s = new VariableSymbol(texto+"->tema", TemaType);
					tabelas.put(ctx.contextnumID,texto+"->tema", s);
					s = new VariableSymbol(texto+"->tipo", StringType);
					tabelas.put(ctx.contextnumID,texto+"->tipo", s);
					s = new VariableSymbol(texto+"->respostadada", REscolhaMultiplaType);
					tabelas.put(ctx.contextnumID,texto+"->respostadada", s);
					break;
				case "QuestaoVerdadeiroFalsoType":
					s = new VariableSymbol(texto+"->pergunta", StringType);
					tabelas.put(ctx.contextnumID,texto+"->pergunta", s);
					s = new VariableSymbol(texto+"->dificuldade", DificuldadeType);
					tabelas.put(ctx.contextnumID,texto+"->dificuldade", s);
					s = new VariableSymbol(texto+"->pontuacao", RealType);
					tabelas.put(ctx.contextnumID,texto+"->pontuacao", s);
					s = new VariableSymbol(texto+"->tempomaximo", InteiroType);
					tabelas.put(ctx.contextnumID,texto+"->tempomaximo", s);
					s = new VariableSymbol(texto+"->respostas", new ListaType(RVerdadeiroFalsoType));
					tabelas.put(ctx.contextnumID,texto+"->respostas", s);
					s = new VariableSymbol(texto+"->tema", TemaType);
					tabelas.put(ctx.contextnumID,texto+"->tema", s);
					s = new VariableSymbol(texto+"->tipo", StringType);
					tabelas.put(ctx.contextnumID,texto+"->tipo", s);
					s = new VariableSymbol(texto+"->respostadada", RVerdadeiroFalsoType);
					tabelas.put(ctx.contextnumID,texto+"->respostadada", s);
					break;
				case "QuestaoCurtaTextualType":
					s = new VariableSymbol(texto+"->pergunta", StringType);
					tabelas.put(ctx.contextnumID,texto+"->pergunta", s);
					s = new VariableSymbol(texto+"->dificuldade", DificuldadeType);
					tabelas.put(ctx.contextnumID,texto+"->dificuldade", s);
					s = new VariableSymbol(texto+"->pontuacao", RealType);
					tabelas.put(ctx.contextnumID,texto+"->pontuacao", s);
					s = new VariableSymbol(texto+"->tempomaximo", InteiroType);
					tabelas.put(ctx.contextnumID,texto+"->tempomaximo", s);
					s = new VariableSymbol(texto+"->respostas", new ListaType(RCurtaTextualType));
					tabelas.put(ctx.contextnumID,texto+"->respostas", s);
					s = new VariableSymbol(texto+"->tema", TemaType);
					tabelas.put(ctx.contextnumID,texto+"->tema", s);
					s = new VariableSymbol(texto+"->tipo", StringType);
					tabelas.put(ctx.contextnumID,texto+"->tipo", s);
					s = new VariableSymbol(texto+"->respostadada", RCurtaTextualType);
					tabelas.put(ctx.contextnumID,texto+"->respostadada", s);
					break;
				case "QuestaoLongaTextualType":
					s = new VariableSymbol(texto+"->pergunta", StringType);
					tabelas.put(ctx.contextnumID,texto+"->pergunta", s);
					s = new VariableSymbol(texto+"->dificuldade", DificuldadeType);
					tabelas.put(ctx.contextnumID,texto+"->dificuldade", s);
					s = new VariableSymbol(texto+"->tempomaximo", InteiroType);
					tabelas.put(ctx.contextnumID,texto+"->tempomaximo", s);
					s = new VariableSymbol(texto+"->tema", TemaType);
					tabelas.put(ctx.contextnumID,texto+"->tema", s);
					s = new VariableSymbol(texto+"->tipo", StringType);
					tabelas.put(ctx.contextnumID,texto+"->tipo", s);
					s = new VariableSymbol(texto+"->respostadada", RLongaTextualType);
					tabelas.put(ctx.contextnumID,texto+"->respostadada", s);
					break;
				case "RespostaType":
					s = new VariableSymbol(texto+"->pontuacao", RealType);
					tabelas.put(ctx.contextnumID,texto+"->pontuacao", s);
				case "RespostaEscolhaMultiplaType":
					s = new VariableSymbol(texto+"->pontuacao", RealType);
					tabelas.put(ctx.contextnumID,texto+"->pontuacao", s);
				case "RespostaVerdadeiroFalsoType":
					s = new VariableSymbol(texto+"->pontuacao", RealType);
					tabelas.put(ctx.contextnumID,texto+"->pontuacao", s);
				case "RespostaCurtaTextualType":
					s = new VariableSymbol(texto+"->pontuacao", RealType);
					tabelas.put(ctx.contextnumID,texto+"->pontuacao", s);
				case "RespostaLongaTextualType":
					s = new VariableSymbol(texto+"->pontuacao", RealType);
					tabelas.put(ctx.contextnumID,texto+"->pontuacao", s);
				case "GrupoType":
					s = new VariableSymbol(texto+"->tema", TemaType);
					tabelas.put(ctx.contextnumID,texto+"->tema", s);
					s = new VariableSymbol(texto+"->tipo", StringType);
					tabelas.put(ctx.contextnumID,texto+"->tipo", s);
					s = new VariableSymbol(texto+"->dificuldade", DificuldadeType);
					tabelas.put(ctx.contextnumID,texto+"->dificuldade", s);
					s = new VariableSymbol(texto+"->pontuacao", RealType);
					tabelas.put(ctx.contextnumID,texto+"->pontuacao", s);
					s = new VariableSymbol(texto+"->duracao", InteiroType);
					tabelas.put(ctx.contextnumID,texto+"->duracao", s);	
					s = new VariableSymbol(texto+"->tempomaximo", InteiroType);
					tabelas.put(ctx.contextnumID,texto+"->tempomaximo", s);		
					s = new VariableSymbol(texto+"->minperguntasaresponder", InteiroType);
					tabelas.put(ctx.contextnumID,texto+"->minperguntasaresponder", s);
					s = new VariableSymbol(texto+"->nrperguntasaapresentar", InteiroType);
					tabelas.put(ctx.contextnumID,texto+"->nrperguntasaapresentar", s);		
					s = new VariableSymbol(texto+"->questoes", new ListaType(QuestaoType));
					tabelas.put(ctx.contextnumID,texto+"->questoes", s);
					break;
			}
		
            Symbol s = new VariableSymbol(texto, ctx.t);
            if (s.type().isThisSubType(ListaType)) {
				s.setValue(true);
			}
            tabelas.put(ctx.contextnumID,texto, s);
		}
      }
      return res;
   }

   @Override public Boolean visitAtribuicao(QuestionariosParser.AtribuicaoContext ctx) {
    boolean res = visit(ctx.variavel());
    String v = ctx.variavel().nameASemantica;
	res = (visit(ctx.valor()) && res);
	if (ctx.valor().t != null) {
	  if (!tabelas.contains(ctx.contextnumID,v)) {
		 ErrorHandling.printError(ctx, "variable "+v+" not declared!");
		 res = false;
	  } else {
		  if (ctx.valor().isVariavel == true && tabelas.get(ctx.contextnumID,ctx.valor().isVariavelNome).getValue() == null) {
				ErrorHandling.printError(ctx, "Assigned variable is not initializated yet!");
				res = false;
		  } else if (ListaType.isThisSubType(tabelas.get(ctx.contextnumID,v).type())){
				if (!ctx.valor().t.isCompatible(tabelas.get(ctx.contextnumID,v).type())) {
					ErrorHandling.printError(ctx, "Given Lists are not assignable!");
					res = false;
				}
		  }
		  else if (res && !ctx.valor().t.isThisSubType(tabelas.get(ctx.contextnumID,v).type())) {
			 ErrorHandling.printError(ctx, ctx.valor().t.getName()+" expression is not assignable to variable "+v+" "+tabelas.get(ctx.contextnumID,v).type().getName()+" type!");
			 res = false;
		  }
		  if (res) {
			tabelas.get(ctx.contextnumID,v).setValue(true);
		  }
	  } 
	} else {
		ErrorHandling.printError(ctx, ctx.valor().t+" expression is not assignable to variable "+v+" "+tabelas.get(ctx.contextnumID,v).type().getName()+" type!");
		res = false;
	}
      return res;
   }
   
   

   @Override public Boolean visitVariavel(QuestionariosParser.VariavelContext ctx) {
      ctx.nameASemantica = ctx.nameASemantica + ctx.TEXTO().getText();
      boolean javi = false;
      while (true) {
		if (ctx.variavel() == null || javi == true) {
			break;
		} else {
			ctx.nameASemantica = ctx.nameASemantica + "->";
			visit(ctx.variavel());
			ctx.nameASemantica = ctx.nameASemantica + ctx.variavel().nameASemantica;
			javi = true;
		}
	  }
      return true;
   }

    @Override public Boolean visitMetodoComVariavel(QuestionariosParser.MetodoComVariavelContext ctx) {
      boolean res = visit(ctx.variavel());
	  String v = ctx.variavel().nameASemantica;
	  ctx.metodo_em_si().varName = v;
      res = (visit(ctx.metodo_em_si()) && res);
      switch(ctx.metodo_em_si().metodoNome) {
		  case "baralhar":
		    //code verificacao variavel baralhar
			  if (!tabelas.contains(ctx.contextnumID,v)) {
				 ErrorHandling.printError(ctx, "variable "+v+" not declared!");
				 res = false;
			  } 
			  else if (res && !tabelas.get(ctx.contextnumID,v).type().isThisSubType(ListaType)) {
				 ErrorHandling.printError(ctx, tabelas.get(ctx.contextnumID,v).type()+" was passed while ListaType was expected!");
				 res = false;
			  }
			ctx.t = null;
			break;
		  case "adicionarquestao":
			// code verificacao variavel adicionarquestao
			  if (!tabelas.contains(ctx.contextnumID,v)) {
				 ErrorHandling.printError(ctx, "variable "+v+" not declared!");
				 res = false;
			  } 
			  else if (res && !(tabelas.get(ctx.contextnumID,v).type().isThisSubType(QuestionarioType) ||  tabelas.get(ctx.contextnumID,v).type().isThisSubType(GrupoType))) {
				 ErrorHandling.printError(ctx, tabelas.get(ctx.contextnumID,v).type()+" was passed while QuestionarioType was expected!");
				 res = false;
			  }
			ctx.t = null;
			break;
		  case "adicionarquestoes":
		    // code verificacao variavel adicionarquestoes
			  if (!tabelas.contains(ctx.contextnumID,v)) {
				 ErrorHandling.printError(ctx, "variable "+v+" not declared!");
				 res = false;
			  } 
			  else if (res && !tabelas.get(ctx.contextnumID,v).type().isThisSubType(GrupoType) ) {
				 ErrorHandling.printError(ctx, tabelas.get(ctx.contextnumID,v).type()+" was passed while GrupoType was expected!");
				 res = false;
			  }
			ctx.t = null;
			break;
		  case "importar":
			// code verificacao variavel importar
			 if (!tabelas.contains(ctx.contextnumID,v)) {
				 ErrorHandling.printError(ctx, "variable "+v+" not declared!");
				 res = false;
			  } 
			  else if (res && !(tabelas.get(ctx.contextnumID,v).type().isThisSubType(GrupoType) || tabelas.get(ctx.contextnumID,v).type().isThisSubType(QuestionarioType) )) {
				 ErrorHandling.printError(ctx, tabelas.get(ctx.contextnumID,v).type()+" was passed while GrupoType or QuestionarioType was expected!");
				 res = false;
			  }
			ctx.t = null;
			break;
		   case "apresentarMenu":
			// code verificacao variavel importar
				 ErrorHandling.printError(ctx, "variable " + v + " does not have apresentarMenu method ");
				 res = false;
			ctx.t = null;
			break;
			case "apresentar":
			// code verificacao variavel importar
				 ErrorHandling.printError(ctx, "variable " + v + " does not have apresentar method ");
				 res = false;
			ctx.t = null;
			break;
			case "str":
			// code verificacao variavel str
				 ErrorHandling.printError(ctx, "variable " + v + " does not have str method ");
				 res = false;
			ctx.t = StringType;
			break;
			case "guardarrespostas":
			// code verificacao variavel str
				 ErrorHandling.printError(ctx, "variable " + v + " does not have str method ");
				 res = false;
			ctx.t = null;
		  default:
			// code verificacao variavel str
				 ErrorHandling.printError(ctx.metodo_em_si().metodoNome + " method don't exists");
				 res = false;
			ctx.t = null;
	  }
      return res;
   }
   
   @Override public Boolean visitMetodoSemVariavel(QuestionariosParser.MetodoSemVariavelContext ctx) {
      boolean res = visit(ctx.metodo_em_si());
      switch(ctx.metodo_em_si().metodoNome) {
		  case "baralhar":
			 ErrorHandling.printError(ctx, "baralhar method need to be called by List<Resposta> variable.");
			 res = false;
			 ctx.t = null;
			break;
		  case "adicionarquestao":
			ErrorHandling.printError(ctx, "adicionarquestao method need to be called by Questionario/Grupo variable.");
			 res = false;
			 ctx.t = null;
			break;
		  case "adicionarquestoes":
		     ErrorHandling.printError(ctx, "adicionarquestoes method need to be called by Questionario/Grupo variable.");
			 res = false;
			 ctx.t = null;
			break;
		  case "importar":
			 ErrorHandling.printError(ctx, "importar method need to be called by Questionario/Grupo variable.");
			 res = false;
			 ctx.t = null;
			break;
		  case "apresentarMenu":
			ctx.t = null;
			break;
		  case "apresentar":
			ctx.t = null;
			break;
		  case "str":
			ctx.t = StringType;
			break;
		  case "guardarrespostas":
			ctx.t = null;
			break;
			
		default:
			// code verificacao variavel str
				 ErrorHandling.printError(ctx.metodo_em_si().metodoNome + " method don't exists");
				 res = false;
			ctx.t = null;
	  }
      return res;
   }


   @Override public Boolean visitMetodo_em_si(QuestionariosParser.Metodo_em_siContext ctx) {
	   boolean res = true;
	   String v = ctx.TEXTO().getText();
	   switch(v) {
		  case "baralhar":
		    ctx.metodoNome = "baralhar";
		    //code verificacao baralhar
		    int i = 0;
			while (true) {
				if (ctx.argum(i) == null) {
					break;
				} else {
					i = i+1;
				}
			}
			if (!(i == 0)) {
				ErrorHandling.printError("baralhar method don't accept arguments");
				res = false;
			}
			break;
		  case "adicionarquestao":
		    ctx.metodoNome = "adicionarquestao";
			// code verificacao adicionarquestao
			i = 0;
			while (true) {
				if (ctx.argum(i) == null) {
					break;
				} else {
					res = (visit(ctx.argum(i)) && res);
					i = i+1;
				}
			}
			if (!(i == 1)) {
				ErrorHandling.printError("adicionarquestao method requires 1 argument");
				res = false;
			} else {
				if (res && !ctx.argum(0).t.isThisSubType(QuestaoType)) {
					ErrorHandling.printError(ctx, "type expression "+ctx.argum(0).t+" is not Question!");
					res = false;
				}	
		   }
			break;
		  case "adicionarquestoes":
			ctx.metodoNome = "adicionarquestoes";
		    // code verificacao adicionarquestoes
		    i = 0;
			while (true) {
				if (ctx.argum(i) == null) {
					break;
				} else {
					ctx.argum(i).varName = ctx.varName;
					ctx.argum(i).metodoNome = ctx.metodoNome;
					res = (visit(ctx.argum(i)) && res);
					i = i+1;
				}
			}
			if (i < 1) {
				ErrorHandling.printError("adicionarquestoes method requires atleast 1 argument");
				res = false;
			} else {
					if (res && !ctx.argum(0).t.isThisSubType(QuestionarioType)) {
						ErrorHandling.printError(ctx, "type expression "+ctx.argum(0).t+" is not Questionario!");
						res = false;
					}
		   }
			break;
		  case "importar":
		    ctx.metodoNome = "importar";
			// code verificacao importar
			i = 0;
			while (true) {
				if (ctx.argum(i) == null) {
					break;
				} else {
					res = (visit(ctx.argum(i)) && res);
					i = i+1;
				}
			}
			if (!(i == 1)) {
				ErrorHandling.printError("importar method requires 1 argument");
				res = false;
			} else {
				if (res && !ctx.argum(0).t.isThisSubType(StringType)) {
					ErrorHandling.printError(ctx, "type expression "+ctx.argum(0).t+" is not String!");
					res = false;
				}	
		   }
		   break;
		   case "apresentarMenu":
		    ctx.metodoNome = "apresentarMenu";
			// code verificacao importar
			i = 0;
			while (true) {
				if (ctx.argum(i) == null) {
					break;
				} else {
					res = (visit(ctx.argum(i)) && res);
					i = i+1;
				}
			}
			if (i > 2) {
				ErrorHandling.printError("apresentarMenu method requires maximum 2 argument");
				res = false;
			} else {
				if (res && !(ctx.argum(0).t.isThisSubType(QuestionarioType) || ctx.argum(0).t.isThisSubType(GrupoType)) ) {
					ErrorHandling.printError(ctx, "type expression "+ctx.argum(0).t+" was passed while Grupo/Questionario Type was expected!");
					res = false;
				}	
				if (ctx.argum(1) != null) {
					if (res && !(ctx.argum(1).t.isThisSubType(InteiroType))) {
						ErrorHandling.printError(ctx, "type expression "+ctx.argum(1).t+" was passed while InteiroType was expected!");
						res = false;
					}
				}
		   }
		   break;
		   case "apresentar":
		    ctx.metodoNome = "apresentar";
			// code verificacao apresentar
			i = 0;
			while (true) {
				if (ctx.argum(i) == null) {
					break;
				} else {
					res = (visit(ctx.argum(i)) && res);
					i = i+1;
				}
			}
			if (i != 1) {
				ErrorHandling.printError("apresentar method requires maximum 1 argument");
				res = false;
			} else {
				if (res && !(ctx.argum(0).t.isThisSubType(StringType) )) {
					ErrorHandling.printError(ctx, "type expression "+ctx.argum(0).t+" was passed while StringType was expected!");
					res = false;
				}
		   }
		   break;
		   case "str":
		    ctx.metodoNome = "str";
			// code verificacao str
			i = 0;
			while (true) {
				if (ctx.argum(i) == null) {
					break;
				} else {
					res = (visit(ctx.argum(i)) && res);
					i = i+1;
				}
			}
			if (i != 1) {
				ErrorHandling.printError("str method requires maximum 1 argument");
				res = false;
			} else {
				if (res && !(ctx.argum(0).t.isThisSubType(InteiroType) || ctx.argum(0).t.isThisSubType(RealType) || ctx.argum(0).t.isThisSubType(BooleanType) || ctx.argum(0).t.isThisSubType(RespostaType) || ctx.argum(0).t.isThisSubType(TemaType) || ctx.argum(0).t.isThisSubType(QuestaoType) || ctx.argum(0).t.isThisSubType(DificuldadeType))) {
					ErrorHandling.printError(ctx, "type expression "+ctx.argum(0).t+" was passed while Inteiro/Real/Boolean Type was expected!");
					res = false;
				}
		   }
		   break;
		   case "guardarrespostas":
		    ctx.metodoNome = "guardarrespostas";
			// code verificacao str
			i = 0;
			while (true) {
				if (ctx.argum(i) == null) {
					break;
				} else {
					res = (visit(ctx.argum(i)) && res);
					i = i+1;
				}
			}
			if (i != 2) {
				ErrorHandling.printError("guardarrespostas method requires 2 arguments");
				res = false;
			} else {
				if (res && !(ctx.argum(0).t.isThisSubType(QuestionarioType) || ctx.argum(0).t.isThisSubType(GrupoType) )) {
					ErrorHandling.printError(ctx, "type expression "+ctx.argum(0).t+" was passed while Questionario/Grupo Type was expected!");
					res = false;
				}
				if (res && !ctx.argum(1).t.isThisSubType(StringType)) {
					ErrorHandling.printError(ctx, "type expression "+ctx.argum(1).t+" was passed while StringType was expected!");
					res = false;
				}
		   }
		   break;
		  default:
			ctx.metodoNome = v;
			ErrorHandling.printError(ctx, ctx.TEXTO().getText()+ " is not valid method");
			res = false;
	  }
      return res;
   }

   @Override public Boolean visitArgumVariavel(QuestionariosParser.ArgumVariavelContext ctx) {
      boolean res = visit(ctx.valor());
      res = (visit(ctx.variavel()) && res);
      String v = ctx.variavel().nameASemantica;
      switch (ctx.metodoNome) {
		case "adicionarquestoes":
			 if (!tabelas.contains(ctx.contextnumID,ctx.varName+"->"+v)) {
				 ErrorHandling.printError(ctx, "variable "+ctx.varName+"->"+v+" not declared!");
				 res = false;
			  } else if (ListaType.isThisSubType(tabelas.get(ctx.contextnumID,ctx.varName+"->"+v).type())){
					if (res && !ctx.valor().t.isThisSubType(tabelas.get(ctx.contextnumID,ctx.varName+"->"+v).type().getListaType())) {
						ErrorHandling.printError(ctx, ctx.valor().t.getName()+" expression is not assignable to variable "+v+" "+tabelas.get(ctx.contextnumID,ctx.varName+"->"+v).type().getName()+" of " +tabelas.get(ctx.contextnumID,ctx.varName+"->"+v).type().getListaType()+" type!");
						res = false;
					}
			  }
			  else if (res && !ctx.valor().t.isThisSubType(tabelas.get(ctx.contextnumID,ctx.varName+"->"+v).type())) {
				 ErrorHandling.printError(ctx, ctx.valor().t.getName()+" expression is not assignable to variable "+v+" "+tabelas.get(ctx.contextnumID,ctx.varName+"->"+v).type().getName()+" type!");
				 res = false;
			  } 
			  ctx.t = ctx.variavel().t;
			  return res;
		default:
			 if (!tabelas.contains(ctx.contextnumID,v)) {
				 ErrorHandling.printError(ctx, "variable "+v+" not declared!");
				 res = false;
			  } else if (ListaType.isThisSubType(tabelas.get(ctx.contextnumID,v).type())){
					if (res && !ctx.valor().t.isThisSubType(tabelas.get(ctx.contextnumID,v).type().getListaType())) {
						ErrorHandling.printError(ctx, ctx.valor().t.getName()+" expression is not assignable to variable "+v+" "+tabelas.get(ctx.contextnumID,v).type().getName()+" of " +tabelas.get(ctx.contextnumID,v).type().getListaType()+" type!");
						res = false;
					}
			  }
			  else if (res && !ctx.valor().t.isThisSubType(tabelas.get(ctx.contextnumID,v).type())) {
				 ErrorHandling.printError(ctx, ctx.valor().t.getName()+" expression is not assignable to variable "+v+" "+tabelas.get(ctx.contextnumID,v).type().getName()+" type!");
				 res = false;
			  } 
			  ctx.t = ctx.variavel().t;
			  return res;
	  }
      
   }
   
   @Override public Boolean visitArgumValor(QuestionariosParser.ArgumValorContext ctx) {
      Boolean res = visit(ctx.valor());
      ctx.t = ctx.valor().t;
      return res;
   }
   
   
   

   @Override public Boolean visitInstrucoes_para_parar(QuestionariosParser.Instrucoes_para_pararContext ctx) {
      Boolean res = true;
      if (ctx.num == 0) {
			ErrorHandling.printError("Parar instructions must be used within loop");
			res = false;
	  }
      return res;
   }
   
   @Override public Boolean visitInstrucoes_para_continuar(QuestionariosParser.Instrucoes_para_continuarContext ctx) {
      Boolean res = true;
      if (ctx.num == 0) {
			ErrorHandling.printError("Continuar instructions must be used within loop");
			res = false;
	  }
      return res;
   }


   @Override public Boolean visitCiclo(QuestionariosParser.CicloContext ctx) {
      tabelas.addTable();
      boolean res = visit(ctx.declaracao());
      res = (visit(ctx.variavel()) && res);
      String v = ctx.variavel().nameASemantica;
      if (!tabelas.contains(ctx.contextnumID,v)) {
				 ErrorHandling.printError(ctx, "variable "+v+" not declared!");
				 res = false;
	  } else {
		if (ListaType.isThisSubType(tabelas.get(ctx.contextnumID,v).type())) {
			if (res && !ctx.declaracao().t.toString().split("@")[0].equals(tabelas.get(ctx.contextnumID,v).type().getListaType().toString().split("@")[0])) {
				ErrorHandling.printError(ctx, ctx.declaracao().t+" expression is not iterateble in variables of "+tabelas.get(ctx.contextnumID,v).type().getListaType()+" type!");
				res = false;
			}
		} else {
			ErrorHandling.printError(ctx, tabelas.get(ctx.contextnumID,v).type()+" expression was passed while ListaType variable was expected!");
			res = false;
		}
	  }
	  
      int i = 0;
      while (true) {
		if (ctx.stat(i) == null) {
			break;
		} else {
			res = (visit(ctx.stat(i)) && res);
			i = i+1;
		}
	  }
      tabelas.removeTable();
      return res;
   }

   @Override public Boolean visitSe(QuestionariosParser.SeContext ctx) {
	  boolean res = visit(ctx.se_inicial());
	  int i = 0;
	  while (true) {
		if (ctx.ouse(i) == null) {
			break;
		} else {
			res = (visit(ctx.ouse(i)) && res);
			i = i+1;
		}
	  }
	  if (!(ctx.senao() == null)) {
		res = (visit(ctx.senao()) && res);
	  }
      return res;
   }
   
   @Override public Boolean visitSe_inicial(QuestionariosParser.Se_inicialContext ctx) {
      tabelas.addTable();
      boolean res = visit(ctx.condicao());
      int i = 0;
      while (true) {
		if (ctx.stat(i) == null) {
			break;
		} else {
			res = (visit(ctx.stat(i)) && res);
			i = i+1;
		}
	  }
      tabelas.removeTable();
      return res;
   }
   
      @Override public Boolean visitOuse(QuestionariosParser.OuseContext ctx) {
      tabelas.addTable();
      boolean res = visit(ctx.condicao());
      int i = 0;
      while (true) {
		if (ctx.stat(i) == null) {
			break;
		} else {
			res = (visit(ctx.stat(i)) && res);
			i = i+1;
		}
	  }
      tabelas.removeTable();
      return res;
   }
   
      @Override public Boolean visitSenao(QuestionariosParser.SenaoContext ctx) {
      tabelas.addTable();
      boolean res = true;
      int i = 0;
      while (true) {
		if (ctx.stat(i) == null) {
			break;
		} else {
			res = (visit(ctx.stat(i)) && res);
			i = i+1;
		}
	  }
      tabelas.removeTable();
      return true;
   }
   
   

   @Override public Boolean visitCondicaoComparacao(QuestionariosParser.CondicaoComparacaoContext ctx) {
      boolean res = visit(ctx.condicao(0));
      res = (visit(ctx.condicao(1)) && res);
      if (res && !(ctx.condicao(0).t.isThisSubType(ctx.condicao(1).t) || ctx.condicao(1).t.isThisSubType(ctx.condicao(0).t))) {
			ErrorHandling.printError(ctx, "type expression "+ctx.condicao(0).t+" and expression " + ctx.condicao(1).t+"are not comparable !");
			res = false;
	  }
	  ctx.t = BooleanType;
      return res;
   }
   
   @Override public Boolean visitCondicaoEOu(QuestionariosParser.CondicaoEOuContext ctx) {
      boolean res = visit(ctx.condicao(0));
      res = (visit(ctx.condicao(1)) && res);
      if (res && !(ctx.condicao(0).t.isThisSubType(ctx.condicao(1).t) && ctx.condicao(1).t.isThisSubType(ctx.condicao(0).t))) {
			ErrorHandling.printError(ctx, "type expression "+ctx.condicao(0).t+" and expression " + ctx.condicao(1).t+"are not comparable !");
			res = false;
	  }
      ctx.t = BooleanType;
      return res;
   }
   
   @Override public Boolean visitCondicaoValor(QuestionariosParser.CondicaoValorContext ctx) {
      boolean res = visit(ctx.variavel());
      String v = ctx.variavel().nameASemantica;
      if (!tabelas.contains(ctx.contextnumID,v)) {
         ErrorHandling.printError(ctx, "variable "+v+" not declared!");
         res = false;
      }
      else {
         ctx.t = tabelas.get(ctx.contextnumID,v).type();
	  }
      return res;
   }
	
	@Override public Boolean visitCondicaoPerentesis(QuestionariosParser.CondicaoPerentesisContext ctx) {
      boolean res = visit(ctx.condicao());
      ctx.t = ctx.condicao().t;
      return res;
   }



   @Override public Boolean visitString(QuestionariosParser.StringContext ctx) {
	  boolean res = visit(ctx.aux_string(0));
	  int i = 1;
      while (true) {
		if (ctx.aux_string(i) == null) {
			break;
		} else {
			res = (visit(ctx.aux_string(i)) && res);
			if (!ctx.aux_string(i).t.isThisSubType(StringType)) {
				ErrorHandling.printError(ctx, "type expression "+ctx.aux_string(i).getText()+" is not String!");
				res = false;
			}
			i=i+1;
		}
	  }
      ctx.t = ctx.aux_string(0).t;
      return res;
   }
   
    @Override public Boolean visitAux_StringString(QuestionariosParser.Aux_StringStringContext ctx) {
      boolean res = true;
      ctx.t = StringType;
      return res;
   }
   
    @Override public Boolean visitAux_StringVariavel(QuestionariosParser.Aux_StringVariavelContext ctx) {
      boolean res = visit(ctx.variavel());
      String v = ctx.variavel().nameASemantica;
      if (!tabelas.contains(ctx.contextnumID,v)) {
         ErrorHandling.printError(ctx, "variable "+v+" not declared!");
         res = false;
      } else {
		  ctx.t = tabelas.get(ctx.contextnumID,v).type();
	  }
      return res;
   }
   
   @Override public Boolean visitAux_StringMetodo(QuestionariosParser.Aux_StringMetodoContext ctx) {
      boolean res = visit(ctx.metodo());
	  ctx.t = ctx.metodo().t;
      return res;
   }
   

   @Override public Boolean visitValorVariavel(QuestionariosParser.ValorVariavelContext ctx) {
      boolean res = visit(ctx.variavel());
      String v = ctx.variavel().nameASemantica;
      if (!tabelas.contains(ctx.contextnumID,v)) {
         ErrorHandling.printError(ctx, "variable "+v+" not declared!");
         res = false;
      }
      else {
         ctx.t = tabelas.get(ctx.contextnumID,v).type();
	  }
	  ctx.isVariavelNome = v;
	  ctx.isVariavel = true;
      return res;
   }

   @Override public Boolean visitValorString(QuestionariosParser.ValorStringContext ctx) {
      boolean res = visit(ctx.string());
      ctx.t = ctx.string().t;
      return res;
   }

   @Override public Boolean visitValorExpr(QuestionariosParser.ValorExprContext ctx) {
      boolean res = visit(ctx.expr());
      ctx.t = ctx.expr().t;
      return res;
   }

   @Override public Boolean visitValorLista(QuestionariosParser.ValorListaContext ctx) {
      boolean res = true;;
      if (ctx.listaMembro() == null) {
		  ctx.t = ListaType;
	  } else {
		 res = visit(ctx.listaMembro());
		 ctx.t = new ListaType(ctx.listaMembro().t);
	  }
      return res;
   }

   @Override public Boolean visitValorDificuldade(QuestionariosParser.ValorDificuldadeContext ctx) {
      boolean res = visit(ctx.dificuldade());
      ctx.t = ctx.dificuldade().t;
      return res;
   }

   @Override public Boolean visitValorResposta(QuestionariosParser.ValorRespostaContext ctx) {
      boolean res = visit(ctx.resposta());
      ctx.t = ctx.resposta().t;
      return res;
   }

   @Override public Boolean visitValorMetodo(QuestionariosParser.ValorMetodoContext ctx) {
      boolean res = visit(ctx.metodo());
      ctx.t = ctx.metodo().t;
      return res;
   }

   @Override public Boolean visitValorTema(QuestionariosParser.ValorTemaContext ctx) {
      boolean res = visit(ctx.tema());
      ctx.t = ctx.tema().t;
      return res;
   }

   @Override public Boolean visitValorType(QuestionariosParser.ValorTypeContext ctx) {
      boolean res = visit(ctx.type());
      ctx.t = ctx.type().res;
      return res;
   }

   @Override public Boolean visitValorTipoQuestao(QuestionariosParser.ValorTipoQuestaoContext ctx) {
      ctx.t = StringType;
      return true;
   }
   
   @Override public Boolean visitValorBooleano(QuestionariosParser.ValorBooleanoContext ctx) {
      boolean res = visit(ctx.booleano());
      ctx.t = ctx.booleano().t;
      return res;
   }

	@Override public Boolean visitValorCondicao(QuestionariosParser.ValorCondicaoContext ctx) {
      boolean res = visit(ctx.condicao());
      ctx.t = ctx.condicao().t;
      return res;
   }



   @Override public Boolean visitTema(QuestionariosParser.TemaContext ctx) {
	  ctx.t = TemaType;
      return true;
   }
   
   
   
   

   @Override public Boolean visitExprAddSub(QuestionariosParser.ExprAddSubContext ctx) {
      boolean res = visit(ctx.e1) && visit(ctx.e2);
      if (res)
         ctx.t = getBinaryOperationType(ctx.e1, ctx.e2);
         switch(ctx.op.getText())
         {
			  case "+":
               if (!ctx.e1.t.isThisSubType(RealType)) {
                  ErrorHandling.printError(ctx, "type expression "+ctx.e1.getText()+" is not RealType!");
                  res = false;
               }
               else if (!ctx.e2.t.isThisSubType(RealType)) {
                  ErrorHandling.printError(ctx, "type expression "+ctx.e2.getText()+" is not RealType!");
                  res = false;
               }
               break;
             case "-":
               if (!ctx.e1.t.isThisSubType(RealType)) {
                  ErrorHandling.printError(ctx, "type expression "+ctx.e1.getText()+" is not RealType!");
                  res = false;
               }
               else if (!ctx.e2.t.isThisSubType(RealType)) {
                  ErrorHandling.printError(ctx, "type expression "+ctx.e2.getText()+" is not RealType!");
                  res = false;
               }
               break;
          }
      return res;
   }


   @Override public Boolean visitExprOp(QuestionariosParser.ExprOpContext ctx) {
      boolean res = visit(ctx.expr());
      ctx.t = ctx.expr().t;
      return res;
   }

   @Override public Boolean visitExprInt(QuestionariosParser.ExprIntContext ctx) {
      ctx.t = InteiroType;
      return true;
   }

   @Override public Boolean visitExprExpr(QuestionariosParser.ExprExprContext ctx) {
      boolean res = visit(ctx.expr());
      ctx.t = ctx.expr().t;
      return res;
   }

   @Override public Boolean visitExprMultDiv(QuestionariosParser.ExprMultDivContext ctx) {
      boolean res = visit(ctx.e1) && visit(ctx.e2);
      if (res) {
         ctx.t = getBinaryOperationType(ctx.e1, ctx.e2);
         switch(ctx.op.getText())
         {
			  case "*":
               if (!ctx.e1.t.isThisSubType(RealType)) {
                  ErrorHandling.printError(ctx, "type expression "+ctx.e1.getText()+" is not RealType!");
                  res = false;
               }
               else if (!ctx.e2.t.isThisSubType(RealType)) {
                  ErrorHandling.printError(ctx, "type expression "+ctx.e2.getText()+" is not RealType!");
                  res = false;
               }
               break;
             case "/":
               if (!ctx.e1.t.isThisSubType(RealType)) {
                  ErrorHandling.printError(ctx, "type expression "+ctx.e1.getText()+" is not RealType!");
                  res = false;
               }
               else if (!ctx.e2.t.isThisSubType(RealType)) {
                  ErrorHandling.printError(ctx, "type expression "+ctx.e2.getText()+" is not RealType!");
                  res = false;
               }
               break;
               
            case "//":
               if (!ctx.e1.t.isThisSubType(RealType)) {
                  ErrorHandling.printError(ctx, "type expression "+ctx.e1.getText()+" is not RealType!");
                  res = false;
               }
               else if (!ctx.e2.t.isThisSubType(RealType)) {
                  ErrorHandling.printError(ctx, "type expression "+ctx.e2.getText()+" is not RealType!");
                  res = false;
               }
               break;
         }
      }
      return res;
   }

   @Override public Boolean visitExprVariavel(QuestionariosParser.ExprVariavelContext ctx) {
      boolean res = true;
      visit(ctx.variavel());
      String v = ctx.variavel().nameASemantica;
      if (!tabelas.contains(ctx.contextnumID,v)) {
         ErrorHandling.printError(ctx, "variable "+v+" not declared!");
         res = false;
      }
      else
         ctx.t = tabelas.get(ctx.contextnumID,v).type();
      return res;
   }





   @Override public Boolean visitRespostaPalavra(QuestionariosParser.RespostaPalavraContext ctx) {
	  ctx.t = REscolhaMultiplaType;
      return true;
   }
   
   @Override public Boolean visitRespostaVF(QuestionariosParser.RespostaVFContext ctx) {
	  ctx.t = RVerdadeiroFalsoType;
      return true;
   }
   
   

   
   @Override public Boolean visitListaMembroValor(QuestionariosParser.ListaMembroValorContext ctx) {
      boolean res = visit(ctx.valor());
	  ctx.t = ctx.valor().t;
      return res;
   }
   
   @Override public Boolean visitListaMembroMembro(QuestionariosParser.ListaMembroMembroContext ctx) {
      boolean res = visit(ctx.valor());
      ctx.t = ctx.valor().t;
      res = (visit(ctx.listaMembro()) && res);
      if (!ctx.listaMembro().t.isThisSubType(ctx.t)) {
		 ErrorHandling.printError(ctx, "Values in List Should All Have Compatible Types");
         res = false;
	  }
      
      return res;
   }
   
   
   
   

   @Override public Boolean visitDificuldade(QuestionariosParser.DificuldadeContext ctx) {
      ctx.t = DificuldadeType;
      return true;
   }

   @Override public Boolean visitBooleano(QuestionariosParser.BooleanoContext ctx) {
      ctx.t = BooleanType;
      return true;
   }

   @Override public Boolean visitInteiroType(QuestionariosParser.InteiroTypeContext ctx) {
      ctx.res = InteiroType;
      return true;
   }

   @Override public Boolean visitRealType(QuestionariosParser.RealTypeContext ctx) {
      ctx.res = RealType;
      return true;
   }

   @Override public Boolean visitEscolhaMultiplaType(QuestionariosParser.EscolhaMultiplaTypeContext ctx) {
      ctx.res = EscolhaMultiplaType;
      return true;
   }

   @Override public Boolean visitVerdadeiroFalsoType(QuestionariosParser.VerdadeiroFalsoTypeContext ctx) {
      ctx.res = VerdadeiroFalsoType;
      return true;
   }

   @Override public Boolean visitCurtaTextualType(QuestionariosParser.CurtaTextualTypeContext ctx) {
      ctx.res = CurtaTextualType;
      return true;
   }

   @Override public Boolean visitLongaTextualType(QuestionariosParser.LongaTextualTypeContext ctx) {
      ctx.res = LongaTextualType;
      return true;
   }
   
   
   @Override public Boolean visitREscolhaMultiplaType(QuestionariosParser.REscolhaMultiplaTypeContext ctx) {
      ctx.res = REscolhaMultiplaType; 
      return true;
   }

   @Override public Boolean visitRVerdadeiroFalsoType(QuestionariosParser.RVerdadeiroFalsoTypeContext ctx) {
      ctx.res = RVerdadeiroFalsoType;
      return true;
   }

   @Override public Boolean visitRCurtaTextualType(QuestionariosParser.RCurtaTextualTypeContext ctx) {
      ctx.res = RCurtaTextualType;
      return true;
   }

   @Override public Boolean visitRLongaTextualType(QuestionariosParser.RLongaTextualTypeContext ctx) {
      ctx.res = RLongaTextualType;
      return true;
   }
   

   @Override public Boolean visitStringType(QuestionariosParser.StringTypeContext ctx) {
      ctx.res = StringType;
      return true;
   }

   @Override public Boolean visitQuestionarioType(QuestionariosParser.QuestionarioTypeContext ctx) {
      ctx.res = QuestionarioType;
      return true;
   }

   @Override public Boolean visitGrupoType(QuestionariosParser.GrupoTypeContext ctx) {
      ctx.res = GrupoType;
      return true;
   }
   
   @Override public Boolean visitTemaType(QuestionariosParser.TemaTypeContext ctx) {
      ctx.res = TemaType;
      return true;
   }
   
   @Override public Boolean visitRespostaType(QuestionariosParser.RespostaTypeContext ctx) {
      ctx.res = RespostaType;
      return true;
   }

   @Override public Boolean visitBooleanType(QuestionariosParser.BooleanTypeContext ctx) {
      ctx.res = BooleanType;
      return true;
   }
   
   @Override public Boolean visitQuestaoType(QuestionariosParser.QuestaoTypeContext ctx) {
      ctx.res = QuestaoType;
      return true;
   }
   
    @Override public Boolean visitDificuldadeType(QuestionariosParser.DificuldadeTypeContext ctx) {
      ctx.res = DificuldadeType;
      return true;
   }
   
    @Override public Boolean visitListaType(QuestionariosParser.ListaTypeContext ctx) {
      boolean res = visit(ctx.type());
      ctx.res = new ListaType(ctx.type().res); 
      return res;
   }
   
   
    protected Type getBinaryOperationType(QuestionariosParser.ExprContext e1, QuestionariosParser.ExprContext e2) {
      Type res;
      if (e1.t.equals(e2.t))
         res = e1.t;
      else
         res = RealType;
      return res;
   }
   
   protected SymbolTableClass tabelas = new SymbolTableClass();
   //Fprotected Map<String,Symbol> symbolTable = new HashMap<>();
   protected static final Type RealType = new RealType();
   protected static final Type InteiroType = new InteiroType();
   protected static final Type EscolhaMultiplaType = new QuestaoEscolhaMultiplaType();
   protected static final Type VerdadeiroFalsoType = new QuestaoVerdadeiroFalsoType();
   protected static final Type CurtaTextualType = new QuestaoCurtaTextualType();
   protected static final Type LongaTextualType = new QuestaoLongaTextualType(); 
   protected static final Type REscolhaMultiplaType = new RespostaEscolhaMultiplaType();
   protected static final Type RVerdadeiroFalsoType = new RespostaVerdadeiroFalsoType();
   protected static final Type RCurtaTextualType = new RespostaCurtaTextualType();
   protected static final Type RLongaTextualType = new RespostaLongaTextualType();
   protected static final Type QuestionarioType = new QuestionarioType();
   protected static final Type GrupoType = new GrupoType();
   protected static final Type StringType = new StringType();
   protected static final Type RespostaType = new RespostaType(null);
   protected static final Type TemaType = new TemaType();
   protected static final Type BooleanType = new BooleanType();
   protected static final Type DificuldadeType = new DificuldadeType();
   protected static final Type ListaType = new ListaType(null);
   protected static final Type QuestaoType = new QuestaoType(null);
}
