
import java.util.*;

public abstract class Questao {
	String pergunta = null;
	Tema tema = null;
	Dificuldade dificuldade = null;
	double pontuacao = 0;
	ArrayList<Resposta> respostas = new ArrayList<Resposta>();
	int tempomaximo = -1;
	String tipo;

	Resposta respostadada = new NullObject();

	Resposta respEscolhida = null;

	public Questao() { }
	
	public String getStringRespostas() {
		Iterator itr = respostas.iterator();
		String res = "";
		while (itr.hasNext()) {
			res +="\n" + itr.next();
		}
		return res;
	}

	
	@Override
	public boolean equals(Object o) {
		if (o == this) { 
			return true; 
		} 
		
		if (!(o instanceof Questao)) { 
			return false; 
		} 
		Questao q = (Questao) o; 
		Boolean is = pergunta.equals(q.pergunta) && tema == q.tema && dificuldade == q.dificuldade && respostas.equals(q.respostas) && tempomaximo == q.tempomaximo && tipo.equals(q.tipo);
		return is;
	} 

	@Override
    public int hashCode() {
        return Objects.hash(pergunta, tema, dificuldade, respostas, tempomaximo, tipo);
	}

	public void printPergunta() {
		System.out.println(apresentarPergunta());
	}

	@Override
	public String toString() {
		return this.apresentarPergunta();
	}

	
	public abstract Resposta printRespostas() ;

	public String apresentarPergunta() {
		String str = "  =>\t" +this.pergunta ;
		String tipo = " tipo: " + this.tipo + ";";
		String tema = this.tema == null ? "" : " tema: " +this.tema + ";";
		String dificuldade = this.dificuldade == null ? "" : " dificuldade: " +this.dificuldade + ";";
		String tempoMax = this.tempomaximo <= 0 ? "" : " tempo máximo: " +  this.tempomaximo + ";";
		String pontuacao = "pontuacao: " + this.pontuacao + ";";
		str += "\n\tinfo: [" + pontuacao + tipo +  tema + dificuldade + tempoMax + " ]";
		return str;
	}
	
}