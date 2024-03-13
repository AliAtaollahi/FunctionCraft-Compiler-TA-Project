public class QuestaoCurtaTextualType extends QuestaoType {
	public QuestaoCurtaTextualType() {
		super("CurtaTextual");
	}
	
	public boolean isThisSubType(Type other) {
		return super.isThisSubType(other) || other.getName().equals("Questaonull") ;
	}
}
