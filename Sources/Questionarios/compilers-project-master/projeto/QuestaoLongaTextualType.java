public class QuestaoLongaTextualType extends QuestaoType {
	public QuestaoLongaTextualType() {
		super("LongaTextual");
	}
	
	public boolean isThisSubType(Type other) {
		return super.isThisSubType(other) || other.getName().equals("Questaonull");
	}
}
