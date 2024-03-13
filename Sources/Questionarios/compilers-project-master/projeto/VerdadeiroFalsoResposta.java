

public class VerdadeiroFalsoResposta extends Resposta{
	double pontuacao = 0;
	double desconto = 0;

	boolean correcao;

	

	double pontGanha = 0;

	public VerdadeiroFalsoResposta(String texto, boolean correcao, double pontuacao, double desconto) {
		super(texto);
		this.correcao = correcao;
		this.pontuacao = pontuacao;
		this.desconto = desconto;
	}

	public VerdadeiroFalsoResposta() { super(); }


	@Override
	public String toString() {
		if (respostaDada == null) return ""; // nnc deve acontecer!
		String acertou = respostaDada.equals("V") && correcao ? "certa" :  "errada";
		pontGanha = acertou.equals("certa") ? pontuacao : desconto ;
		return "  R:\t" + this.resposta + "\n\tinfo: [ correcao: " + acertou + "; valor certo: " + (correcao ? "V" : "F") + ";valor escolhido: " + respostaDada + "; pontuacao relativa: " + pontGanha + "; ]";
	}


	public double getCotacaoRelativa() {
		return pontGanha;
	}
}
