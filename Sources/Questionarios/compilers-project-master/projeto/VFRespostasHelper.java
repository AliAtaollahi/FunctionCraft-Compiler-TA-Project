import java.util.*;

public class VFRespostasHelper extends Resposta {
    

    ArrayList<Resposta> resps;

    public VFRespostasHelper(ArrayList<Resposta> resp) {
        super();
    //System.out.println("\n\né aqui?");
        resps = resp;
        String a = ((VerdadeiroFalsoResposta)resp.get(0)).respostaDada;
        System.out.println(a);

    }

    @Override
    public String toString() {
        String ret = "";
        Iterator itr = resps.iterator();
        while (itr.hasNext()) {
            //System.out.println(r);
            VerdadeiroFalsoResposta r = (VerdadeiroFalsoResposta) itr.next();
            ret += r.toString() + "\n";
        }
        return ret;
    }

    public double getCotacaoRelativa() {
        int sum = 0;
        for (Resposta r : resps) {
            sum += r.getCotacaoRelativa();
        }

        if (resps.size() != 0) return sum;
        else return 0;
    }
}