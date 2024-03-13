
public class LongaTextualResposta extends Resposta{

	public LongaTextualResposta(String texto) {
		super(texto);
	}


	@Override
	public String toString() {
		return "  R:\t" +this.resposta ;
	}

	public double getCotacaoRelativa() {
		return 0;
	}
}
