public class NullObject extends Resposta{
    public double cotacao = 0;

    public NullObject() {super("**nao respondido**");}

	public double getCotacaoRelativa() {
        return cotacao;
    }
}