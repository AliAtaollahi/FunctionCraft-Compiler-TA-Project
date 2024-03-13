
public class EscolhaMultiplaResposta extends Resposta{
	double pontuacao = 0; //relativa!
	//boolean correcao;

	public EscolhaMultiplaResposta(String texto, double pontuacao) {
		super(texto);
		this.pontuacao = pontuacao;
	}

	public EscolhaMultiplaResposta() { super(); }

	@Override
	public String toString() {
		String correcao = pontuacao == 0 ? "" : pontuacao> 0 ? " scorrecao: certa;" : " correcao: errada;";
		return "  R:\t" + this.resposta + "\n\tinfo: [" + correcao + " pontuacao relativa: " + this.pontuacao + " ]";
	}

	public double getCotacaoRelativa() {
		return pontuacao;
	}

}
