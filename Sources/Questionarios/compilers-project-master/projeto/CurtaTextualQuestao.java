
import java.io.*;
import java.util.*;

public class CurtaTextualQuestao extends Questao {

	public CurtaTextualQuestao() {
		super();
		tipo = "CurtaTextual";
	}


	public Resposta printRespostas() {
		System.out.print("Resposta: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String respDada = "";
		try {
			respDada = reader.readLine();
			respDada = respDada.toLowerCase();
		} catch (Exception ex) {System.out.println("Ocorreu um erro.");}
		Resposta res = findRespostaByTexto(respDada);
		return res;
	}

	private Resposta findRespostaByTexto(String texto) {
		Iterator itr = this.respostas.iterator();
		while (itr.hasNext()) {
			Resposta r = (EscolhaMultiplaResposta)itr.next();
			if (r.resposta.toLowerCase().equals(texto)) return r;
		}
		return new EscolhaMultiplaResposta(texto, 0);
	}



}
