import java.io.*;
import java.util.*;

public class Saver {
    int cotacao = 0;
    //ArrayList<Questoes> questoes ;
    //ArrayList<Questoes> questionarios ;
    // quest e grupos tmb
    ArrayList<Questionario> questionarios = new ArrayList<Questionario>(); 


    public Saver() {}

    /*
    public void adicionarQuestoes(ArrayList<Questoes> quests) {
        questoes = quests;
    }
    */

    public void adicionarQuestionario(Questionario q) { // quest ou grupos
        questionarios.add(q);
    }
    


    public void printInFile(Questionario q, String filename) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true)); // true para dar append!
            writer.newLine();
            writer.write(Auxiliar.del);
            writer.write("NOVO LOG:\n");
            writer.write(transformarTudoEmTexto(q));
            writer.write(Auxiliar.del);

            writer.close(); 
        } catch (Exception ex) {System.out.println("Ocorreu um erro ao guardar os dados para o ficheiro " + filename + ".");}
            
    }


    public String transformarTudoEmTexto(Questionario questionario) {
        Iterator itr = questionarios.iterator();
        String total ="";
        Questionario q = questionario;

            Iterator<Questao> questNResp = q.questoesNaoRespondidas.iterator();

            String questNRespStr = "Questões não respondidas: ";
            while (questNResp.hasNext()) {
                Questao qNRes = (Questao) questNResp.next();
                questNRespStr += "\n\t" + qNRes.apresentarPergunta() + "\n";
            }
            
            String questRespondidas = "Questões respondidas: ";

            for (Map.Entry<Questao, Resposta> entry : q.questoesRespondidas.entrySet()) {
                Questao quest = (Questao)entry.getKey();
                Resposta resp = (Resposta)entry.getValue();
                
                questRespondidas += "\n" + quest.apresentarPergunta();
                questRespondidas +="\n" + resp  + "\n";

                cotacao += calcCotacao(resp, quest);

            }
            total = questNRespStr + Auxiliar.del2 + questRespondidas +  Auxiliar.del2 + "cotacao total: " + cotacao;

        return total;
    }


    public static double calcCotacao(Resposta r, Questao q) {
        return q.pontuacao * r.getCotacaoRelativa()/100;
    }

}