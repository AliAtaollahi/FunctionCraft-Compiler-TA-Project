public class QuestaoType extends Type {
	public QuestaoType(String tipo) {
		super("Questao"+tipo);
	}

	public boolean isThisSubType(Type other) {
		return super.isThisSubType(other);
	}
}
