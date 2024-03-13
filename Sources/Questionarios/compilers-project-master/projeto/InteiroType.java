public class InteiroType extends Type {
	public InteiroType() {
		super("Inteiro");
	}
	
	public boolean isThisSubType(Type other) {
		return super.isThisSubType(other) || other.getName().equals("Real");
	}
}

