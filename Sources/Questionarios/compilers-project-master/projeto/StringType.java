public class StringType extends Type {
	public StringType() {
		super("String");
	}
	
	public boolean isThisSubType(Type other) {
		return super.isThisSubType(other) || other.getName().equals("Tema");
	}
}

