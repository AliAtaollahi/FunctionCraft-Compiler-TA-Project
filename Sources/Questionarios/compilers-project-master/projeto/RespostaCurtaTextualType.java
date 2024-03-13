public class RespostaCurtaTextualType extends RespostaType {
	public RespostaCurtaTextualType() {
		super("RCurtaTextual");
	}
	
	public boolean isThisSubType(Type other) {
		return super.isThisSubType(other) || other.getName().equals("Respostanull") || other.getName().equals("RespostaREscolhaMultipla");
	}
}
