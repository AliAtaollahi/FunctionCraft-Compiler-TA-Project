public class RespostaLongaTextualType extends RespostaType {
	public RespostaLongaTextualType() {
		super("RLongaTextual");
	}
	
	public boolean isThisSubType(Type other) {
		return super.isThisSubType(other) || other.getName().equals("Respostanull");
	}
}
