public class ListaType extends Type {
	Type tipo;
	public ListaType(Type t) {
		super("Lista");
		this.tipo = t;
	}
	
	public Type getListaType() {
		return this.tipo;
	}
	
	public boolean isThisSubType(Type other) {
		return super.isThisSubType(other);
	}


	public Boolean isCompatible(Type other) {
		if (this.getListaType() == null && !(other.getListaType().isThisSubType(new ListaType(null)))) {
			return true;
		} else if (this.getListaType().isThisSubType(other.getListaType())) {
			if (this.getListaType().isThisSubType(new ListaType(null))) {
				return this.getListaType().isCompatible(other.getListaType());
			} else {
				return true;
			}		
		} else {
			return false;
		}
	}
}
