public class RespostaType extends Type {
	public RespostaType(String tipo) {
		super("Resposta"+tipo);
	}
	
	public boolean isThisSubType(Type other) {
		return super.isThisSubType(other);
	}
}
