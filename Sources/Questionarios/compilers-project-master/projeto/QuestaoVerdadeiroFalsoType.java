public class QuestaoVerdadeiroFalsoType extends QuestaoType {
	public QuestaoVerdadeiroFalsoType() {
		super("VerdaieroFalso");
	}
	
	public boolean isThisSubType(Type other) {
		return super.isThisSubType(other) || other.getName().equals("Questaonull");
	}
}
