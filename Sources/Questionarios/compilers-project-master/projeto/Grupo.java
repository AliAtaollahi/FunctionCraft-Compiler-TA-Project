

import java.util.ArrayList;

public class Grupo extends Questionario {
	public int minperguntasaresponder = -1; // min perguntas q tem de ser respondidas
	public int nrperguntasaapresentar = -1; // perguntas a apresentar
	
	
	public Grupo() {super(); tipo = "Grupo"; };


	@Override
	public boolean isGrupo() {
		return true;
	}

}
