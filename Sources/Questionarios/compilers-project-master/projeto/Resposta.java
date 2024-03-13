import java.util.*;
public abstract class Resposta {
	String resposta= null;	
	String respostaDada = null;
	double pontuacao = 0;

	public Resposta(String texto) {
		resposta = texto;
	}

	public Resposta() { }
	
	public void atualizarPontuacao() { pontuacao = this.getCotacaoRelativa(); }
	
	@Override
	public boolean equals(Object o) { 
		if (o == this) { 
			return true; 
		} 
		if (!(o instanceof Questao)) { 
			return false; 
		} 
		Resposta r = (Resposta) o; 
		Boolean is = resposta.equals(r.resposta);
		return is;
	}

	@Override
    public int hashCode() {
        return Objects.hash(resposta);
	}
	
	public abstract double getCotacaoRelativa();

}
