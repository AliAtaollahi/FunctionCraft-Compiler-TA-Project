import java.util.*;

public class SymbolTableClass{
    private ArrayList<Map<String,Symbol>> tabelas = new ArrayList<>();

    public SymbolTableClass() {
	Map<String,Symbol> symbolTable = new HashMap<>();
	tabelas.add(symbolTable);
    }
    public boolean contains(int id, String name){
        return this.tabelas.get(id).containsKey(name);
    }

    public void put(int id, String name, Symbol s){
	   this.tabelas.get(id).put(name,s);
    }

    public Symbol get(int id, String name){
        return this.tabelas.get(id).get(name);
    }


    public Map<String,Symbol> get(int id){
        return this.tabelas.get(id);
    }

    public void addTable() {
	Map<String,Symbol> symbolTable = new HashMap<>();
	for (int i = 0; i<tabelas.size(); i++) {
		 for (Map.Entry m : tabelas.get(i).entrySet()) {
			symbolTable.put((String) m.getKey(), (Symbol)m.getValue());
        	}	
	}
	tabelas.add(symbolTable);
   }
    
    public void removeTable() {
	tabelas.remove(tabelas.size()-1);
   }

}
