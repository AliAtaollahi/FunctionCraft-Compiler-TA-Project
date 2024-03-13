

import java.util.*;
import java.io.*;

public class VerdadeiroFalsoQuestao extends Questao{
	
	boolean podeSkip;
	public VerdadeiroFalsoQuestao() {
		tipo ="VerdadeiroFalso";
		podeSkip = this.tempomaximo <= 0;
	}

	
	public Resposta printRespostas() {
		Iterator itr = this.respostas.iterator();
		int i = 0;
		
		
        if (podeSkip) System.out.println("0] Regressar ao menu." );

        while (itr.hasNext()) {
            char alinea = (char)((int) 'A' + i++ );
			VerdadeiroFalsoResposta r = (VerdadeiroFalsoResposta)itr.next();
			r.respostaDada= null; // reset
            System.out.println(alinea + ") " + r.resposta);
        }

		Resposta rr = responder();
		return rr;
	}

	private Resposta responder() {
		System.out.println("Respostas: (V/F)");
		for (int i = 0; i<this.respostas.size(); i++) {
			String resp = "";
			while (true) {
				char alinea = (char) ((int) 'A' + i );
				System.out.print( alinea + ") ");
				resp = getResposta();
				resp = resp.toUpperCase();
				
				if (podeSkip && resp.equals("0")) return null;
				if (isValid(resp)) break;
				else {System.out.println(Auxiliar.msgErro);}
			}
			this.respostas.get(i).respostaDada = resp;
			//System.out.println(this.respostas.get(i).respostaDada);
		}

		return new VFRespostasHelper(this.respostas);
	}



	private String getResposta() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String esc = "";
        //while(true) {
            try {
                esc = reader.readLine(); 
                //if (esc.length() == 1 && (esc.equals("0") || esc.toUpperCase().equals("V") || esc.toUpperCase().equals("F") )) break;
                //else System.out.println(Auxiliar.msgErro);
            } catch(Exception ex) {System.out.println(Auxiliar.msgErro);}
        //}

        esc = esc.toUpperCase();
        return esc; // len= 1 garantido!
	}

	private static boolean isValid(String esc) {
		return esc.length() == 1 && (esc.equals("0") || esc.toUpperCase().equals("V") || esc.toUpperCase().equals("F") );
	}
	


}
