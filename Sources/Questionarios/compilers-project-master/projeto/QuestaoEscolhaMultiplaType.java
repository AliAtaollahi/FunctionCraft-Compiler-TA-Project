public class QuestaoEscolhaMultiplaType extends QuestaoType {
	public QuestaoEscolhaMultiplaType() {
		super("EscolhaMultipla");
	}
	
	public boolean isThisSubType(Type other) {
		return super.isThisSubType(other) || other.getName().equals("Questaonull");
	}
}
