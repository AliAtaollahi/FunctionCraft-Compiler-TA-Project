import java.util.*;

public class Execute extends BaseDadosBaseVisitor<Object> {
   //ArrayList<Questao> questoes = new ArrayList<>();
   String tipo = null;

   @Override public Object visitStat(BaseDadosParser.StatContext ctx) {
	  for(BaseDadosParser.DeclaracaoContext decl : ctx.declaracao()){
		  visit(decl);
	  }
	  
	//   for(int i = 0; i < questoes.size(); i++){
	// 	  System.out.println(questoes.get(i));
	//   }
		
	  //System.out.println(questoes.get(0));
	  //System.out.println("size->:"+questoes.size());
	  //System.out.println(questoes.get(1));
	  return null;
   }

   @Override public Object visitDeclaracao(BaseDadosParser.DeclaracaoContext ctx) {
	String tema = "";
	tipo = ctx.TIPO().getText();
	// for(BaseDadosParser.TemaContext tc: ctx.tema()){
	// 	tema += (String) visit(tc);
	// }
	tema = (String) visit(ctx.tema());
	//System.out.println(tema);
	String subTema = "", Dificuldade = "", pergunta = "";
	double pont = 0,desc = 0;
	ArrayList<Resposta> respostas = new ArrayList<>();


	if(ctx.respostas() != null){
		respostas = (ArrayList<Resposta>) visit(ctx.respostas());

	}
		
		//String id = "";
	Tema t = null;
	//if(tema.contains("->")){
	String tem[] = tema.split("->");
		//String[] aux_tema = new String[tem.length-1];
		//id = tem[tem.length-1]; //ou tem.length-1?
		//for(int i = 0; i < tem.length -1; i++){
			//aux_tema[i] = tem[i];
	//}
		// tema = tem[0];
		// subTema = tem[1];
	t = new Tema(tem);
	/*}else{
		String tem[] = new String[2];
		tem[0] = tema;
 		t = new Tema(tem);
		id = tem[]
	}*/
	
	if(ctx.pontuacao() != null){
		String pontuacao = (String) visit(ctx.pontuacao());
		if(pontuacao.contains(",")){
			String[] p = pontuacao.split(",");
			try{
				pont = Double.parseDouble(p[0]);
				desc = Double.parseDouble(p[1]);
			}catch(NumberFormatException e){;}
		}else {
			pont = Double.parseDouble(pontuacao);	
		}
	}

	Dificuldade d = null;
	if(ctx.DIFICULDADE() != null){
		String dif = ctx.DIFICULDADE().getText();
		switch (dif) {
			case "medio":
				d = d.MEDIO;
				break;
			case "facil":
				d = d.FACIL;
				break;
			case "dificil":
				d = d.DIFICIL;
		}
	}

	if(ctx.STRING() != null){
		pergunta = ctx.STRING().getText();
		pergunta = pergunta.substring(1, pergunta.length()-1);
	}

	switch(tipo){
		case "EscolhaMultipla":
			EscolhaMultiplaQuestao em1  = new EscolhaMultiplaQuestao();
			em1.tema = t;
			em1.dificuldade = d;
			em1.pergunta = pergunta;
			em1.pontuacao = pont;
			em1.respostas = respostas;
			//em1.id = id;
			Auxiliar.importQuestoes.add(em1);
			break;
		case "VerdadeiroFalso":
			VerdadeiroFalsoQuestao vf1  = new VerdadeiroFalsoQuestao();
			vf1.tema = t;
			vf1.dificuldade = d;
			vf1.pontuacao = pont;
			vf1.respostas = respostas;
			vf1.pergunta = pergunta;
			//vf1.id = id;
			Auxiliar.importQuestoes.add(vf1);	
			break;
		case "LongaTextual":
			LongaTextualQuestao lt1 = new LongaTextualQuestao();
			lt1.tema = t;
			lt1.pergunta = pergunta;
			lt1.dificuldade = d;
			//lt1.id = id;
			Auxiliar.importQuestoes.add(lt1);
			break;
		case "CurtaTextual":
			CurtaTextualQuestao ct1 = new CurtaTextualQuestao();
			ct1.tema = t;
			ct1.pergunta = pergunta;
			ct1.dificuldade = d;
			ct1.pontuacao = pont;
			//ct1.id = id;
			ct1.respostas = respostas;
			Auxiliar.importQuestoes.add(ct1);
			break;
	}
	return null;
   }

   @Override public Object visitRespostas(BaseDadosParser.RespostasContext ctx) {
	ArrayList<Resposta> resps = new ArrayList<>();	
	
	for(BaseDadosParser.RespContext rp: ctx.resp()){
		Resposta r = (Resposta) visit(rp);
		resps.add(r);
		}
	return resps;
   }	

   @Override public Object visitResp(BaseDadosParser.RespContext ctx) {
	String resposta = (String)ctx.STRING().getText();
	resposta = resposta.substring(1, resposta.length()-1);
	
	String correcao = "";
	double pont = 0,desc = 0;
	if(ctx.BOOLEANO() != null){
		correcao = (String)ctx.BOOLEANO().getText();
	}

	if(ctx.pontuacao() != null){
		String pontuacao = (String) visit(ctx.pontuacao());
		if(pontuacao.contains(",")){
			String[] p = pontuacao.split(",");
			try{
				pont = Double.parseDouble(p[0]);
				desc = Double.parseDouble(p[1]);
			}catch(NumberFormatException e){;}
		}else {
			pont = Double.parseDouble(pontuacao);	
		}
	}
	switch(tipo){
		case "EscolhaMultipla":
			EscolhaMultiplaResposta  em1 = new EscolhaMultiplaResposta();
			em1.resposta = resposta;
			em1.pontuacao = pont;
			return em1;
		case "VerdadeiroFalso":
			VerdadeiroFalsoResposta vf  = new VerdadeiroFalsoResposta();
			vf.resposta = resposta;
			vf.pontuacao = pont;
			vf.desconto = desc;
			vf.correcao = Boolean.parseBoolean(correcao);
			return vf;
		case "LongaTextual":
			LongaTextualResposta lt = new LongaTextualResposta(resposta);
			return lt;
		case "CurtaTextual":
			EscolhaMultiplaResposta ct = new EscolhaMultiplaResposta();
			ct.resposta = resposta;
			ct.pontuacao = pont;
			//ct.desconto = desc;
			return ct;
	}
	return null;
   }

   @Override public Object visitPontuacao(BaseDadosParser.PontuacaoContext ctx) {
	return visit(ctx.valor());
   }

   @Override public Object visitIntegerCtx(BaseDadosParser.IntegerCtxContext ctx) {
      return (String)ctx.INT().getText();
   }

   @Override public Object visitValorTuploCtx(BaseDadosParser.ValorTuploCtxContext ctx) {
      return "("+ctx.INT(0).getText()+","+ctx.INT(1).getText()+")";
   }

//    @Override public Object visitTema(BaseDadosParser.TemaContext ctx) {
// 	String temaa = "";
// 	String sep = "";
// 	for(BaseDadosParser.TemaContext tc: ctx.tema()){
// 		if(ctx.TEXTO() != null)
// 			temaa += sep+ ctx.TEXTO().getText();
// 		else if(ctx.TIPO() != null)
// 			temaa += sep+ ctx.TIPO().getText();
// 		sep = "->";
// 	}
// 	// if(ctx.TEXTO() != null)
// 	// 	temaa = "->"+ (String)ctx.TEXTO().getText();
// 	// else if(ctx.TIPO() != null)
// 	// 	temaa =	"->"+ (String)ctx.TIPO().getText();
// 	return temaa;
//    }

   @Override public Object visitTemaPlus(BaseDadosParser.TemaPlusContext ctx) {
	String temaa = "";
	String sep = "->";
	if(ctx.TEXTO() != null)
		temaa += ctx.TEXTO().getText()+sep;
	else if(ctx.TIPO() != null)
		temaa += ctx.TIPO().getText()+sep;

	temaa += (String) visit(ctx.tema());
	return temaa;
   }

   @Override public Object visitTemaFinish(BaseDadosParser.TemaFinishContext ctx) {
	if(ctx.TEXTO() != null)
		return ctx.TEXTO().getText();
	else{
		return ctx.TIPO().getText();
	}
   }
}
