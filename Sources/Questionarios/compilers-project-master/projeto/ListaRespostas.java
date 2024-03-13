
import java.util.ArrayList;
import java.util.Collections;

public class ListaRespostas {
	public ArrayList<Resposta> respostas;
	
	public ListaRespostas(ArrayList<Resposta> respostas) {
		this.respostas = respostas;
	}
	
	public void respostasRandom() {
		Collections.shuffle(respostas);
	}
}
