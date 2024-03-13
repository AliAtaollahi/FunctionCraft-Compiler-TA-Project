public abstract class Type {
	protected final String name;
	
	protected Type (String name) {
		assert name != null;
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean isThisSubType(Type other) {
		assert other != null;
		return this.name.equals(other.getName());
	}

	public Type getListaType() {
		return this;
	}


	public Boolean isCompatible(Type other) {
		if (this.getListaType().isThisSubType(other.getListaType()) || this.getListaType().isThisSubType(new ListaType(null))) {
			if (this.getListaType().isThisSubType(new ListaType(null))) {
				return this.getListaType().isCompatible(other.getListaType());
			} else {
				return true;
			}
		}  else {
			return false;
		}
	}
}
