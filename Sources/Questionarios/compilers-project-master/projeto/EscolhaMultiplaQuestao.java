

import java.io.*;
import java.util.*;

public class EscolhaMultiplaQuestao extends Questao{

    
	public EscolhaMultiplaQuestao() {
		super();
		tipo = "EscolhaMultipla";
    }
    

	public Resposta printRespostas() {
        Iterator itr = this.respostas.iterator();
        
        
        boolean podeSkip = this.tempomaximo <= 0;
        if (podeSkip) System.out.println("0] escolher outra pergunta" );

        int i = 0;
        while (itr.hasNext()) {
            char alinea = (char)((int) 'A' + i++ );
            Resposta r = (Resposta)itr.next();
            System.out.println(alinea + ") " + r.resposta);
        }

        int resp = -1;
        while (resp < 0 || resp > i) {
            resp = getAlineaEscolhida();
            if ( podeSkip && resp == -17) break;
            if (resp < 0 || resp > i) System.out.println(Auxiliar.msgErro);
        }

        if ( resp >= 0 ) this.respEscolhida = this.respostas.get(resp); // se n for skip...
        else this.respEscolhida = null;
        
        return this.respEscolhida;
	}


	private static int getAlineaEscolhida() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String esc = "";
        System.out.print("Alínea escolhida: ");
        while(true) {
            try {
                esc = reader.readLine(); 
                if (esc.length() == 1) break;
                else System.out.println(Auxiliar.msgErro);
            } catch(Exception ex) {System.out.println(Auxiliar.msgErro);}
        }

        esc = esc.toUpperCase();
        int res = (int) (esc.charAt(0) - 'A');
        return res;
    }
	
	
}
