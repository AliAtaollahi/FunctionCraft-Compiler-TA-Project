

public class teste {
    
    public static void main(String[] args) {

        EscolhaMultiplaQuestao a = new EscolhaMultiplaQuestao();
        EscolhaMultiplaQuestao b = new EscolhaMultiplaQuestao();
        System.out.println(a.equals(b));

        Tema c = new Tema(new String[] {"temaS"});
        Tema d = new Tema(new String[] {"temaS"});

        System.out.println(d.equals(c));
        
    }
}