

import java.util.*;

public class Tema {
	ArrayList<Tema> subtemas = new ArrayList<Tema>();
	String[] nome;
	String nomeString;

	public Tema(String[] tema) {
		nome = tema;
		fillNomeString();
	}

	public void fillNomeString() {
		String ret = "[";
		for (int i = 0; i<nome.length ; i++) {
			if (i != 0) ret += " -> ";
			ret += nome[i];
		}
		ret += "]";
		nomeString = ret;
	}

	public String toString() {
		return nomeString;
	}

	@Override
	public boolean equals(Object o) { 
		if (o == this) { 
			return true; 
		} 
		if (!(o instanceof Tema)) { 
			return false; 
		} 
		Tema t = (Tema) o; 
		
		Boolean is = this.nomeString.toUpperCase().equals(t.nomeString.toUpperCase());
		return is;
	}
	
	@Override
    public int hashCode() {
        return Objects.hash(nomeString);
	}
	
}
