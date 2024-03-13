public class RespostaVerdadeiroFalsoType extends RespostaType {
	public RespostaVerdadeiroFalsoType() {
		super("RVerdaieroFalso");
	}
	
	public boolean isThisSubType(Type other) {
		return super.isThisSubType(other) || other.getName().equals("Respostanull") ;
	}
}
