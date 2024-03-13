
import java.util.*;


public class Questionario {
	
	public ArrayList<Questao> questoes = new ArrayList<Questao>();
	public int duracao = -1; // tempo demorado a responder
	public String tipo = "Questionário";
	public int tempomaximo = -1;
	

	public ArrayList<Questao> questoesNaoRespondidas = new ArrayList<Questao>();
	public HashMap<Questao, Resposta> questoesRespondidas = new HashMap<Questao, Resposta>();

	
	public double pontuacao = 0;

	public Questionario() { }
	
	public String toString() {
		String ret = "";
		Iterator itr = questoes.iterator();
		while (itr.hasNext()) {
			Questao q = (Questao) itr.next();
			ret += "\n" + q;
		}
		return ret;
	}

	public boolean isGrupo() {
		return false;
	}

	@Override
	public boolean equals(Object o) { 
		if (o == this) { 
			return true; 
		} 
		if (!(o instanceof Questionario)) { 
			return false; 
		} 
		Questionario q = (Questionario) o; 
		Boolean is = questoes.equals(q.questoes) ;
		return is;
	}
	
	@Override
    public int hashCode() {
        return Objects.hash(questoes);
	}
	
}
