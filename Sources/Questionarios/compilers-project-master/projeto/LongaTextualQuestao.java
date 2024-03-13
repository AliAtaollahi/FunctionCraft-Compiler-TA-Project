
import java.io.*;
import java.util.*;

public class LongaTextualQuestao extends Questao {
	
	public LongaTextualQuestao() {super(); tipo = "LongaTextual"; }


	public Resposta printRespostas() {
		System.out.print("Resposta: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String respDada = "";
		try {
			respDada = reader.readLine();
		} catch (Exception ex) {System.out.println("Ocorreu um erro.");}

		return new LongaTextualResposta(respDada);
	}


}
