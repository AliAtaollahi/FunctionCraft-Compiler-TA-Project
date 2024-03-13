public class RespostaEscolhaMultiplaType extends RespostaType {
	public RespostaEscolhaMultiplaType() {
		super("REscolhaMultipla");
	}
	
	public boolean isThisSubType(Type other) {
		return super.isThisSubType(other) || other.getName().equals("Respostanull") || other.getName().equals("RespostaRCurtaTextual");
	}
}
