import java.io.*;
import java.util.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Auxiliar {

    public static String del = "\n----------------------------------------------------------------------------------------------------\n";
    public static String del2 = "\n - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n";

    private static double start;
    private static int nrQueFaltaResponder = -1;
    private static int respondidas = 0;
    public static String msgErro = "O valor introduzido não é válido.";

    public static int tempoMaximo = -1;
    public static boolean podeGuardar = true;

    public static boolean sair = false;
    
    public static void baralhar(ParamOpcionais p, ArrayList lista) {
        Collections.shuffle(lista);
    }

    public static void adicionarquestao(ParamOpcionais p, Questao perg, Questionario q) {
        q.questoes.add(perg);
    }


    public static boolean compareTema(Tema t1, Tema t2) {
        // t1 -> existente
        // t2 -> o tema pelo qual queremos filtrar
        if (t2.nome.length > t1.nome.length) return false;
        for (int i = 0; i<t2.nome.length; i++) {
            if (!t1.nome[i].equals(t2.nome[i])) return false;
        }
        return true;
    }
    public static void adicionarquestoes(ParamOpcionais p, Questionario arg, Questionario var) { // quero passar do arg para o var
        HashSet<Questao> quest = new HashSet<Questao>();


        Iterator itr = arg.questoes.iterator();
        while (itr.hasNext()) {
            Questao q = (Questao)itr.next();
            quest.add(q);
        }

        // comeca por ter todos...
        
        
        if (p.tema != null) {
            Iterator itr2 = arg.questoes.iterator();
            while (itr2.hasNext()) {
                Questao q = (Questao)itr2.next();
                //if (q.tema != null) System.out.println("tema: " + q.tema + "; -> " + p.tema + "equals? " + q.tema.equals(p.tema));
                if ( q.tema == null || !compareTema(q.tema, p.tema)) quest.remove(q);
            }
        }

        //System.out.println(quest);

        if (p.tipo != null) {
            Iterator itr2 = arg.questoes.iterator();
            while (itr2.hasNext()) {
                Questao q = (Questao)itr2.next();
                if ( q.tipo == null || !q.tipo.equals(p.tipo)) quest.remove(q);
            }
        }

        if (p.dificuldade != null) {
            Iterator itr2 = arg.questoes.iterator();
            while (itr2.hasNext()) {
                Questao q = (Questao)itr2.next();
                if ( q.dificuldade == null || q.dificuldade != p.dificuldade) quest.remove(q);
            }
        }
    
        adicionarNoQuestOuGrupo(var, quest);
        
    }

    private static void adicionarNoQuestOuGrupo(Questionario var, HashSet<Questao> arg) {
        int nrPerguntas = -1;
        if (var.isGrupo()) nrPerguntas = ((Grupo)var).nrperguntasaapresentar;

        if (nrPerguntas < 0) nrPerguntas = arg.size();
        
        Iterator itr = arg.iterator();
        for (int i = 0; i<nrPerguntas ; i++ ) {
            if (itr.hasNext()) var.questoes.add( (Questao)itr.next());
        }
    }


    public static String str(ParamOpcionais p, boolean b) {
        return "" + b;
    }


    public static String str(ParamOpcionais p, int nr) {
        return "" + nr;
    }

    public static String str(ParamOpcionais p, double nr) {
        return "" + nr;
    }

    public static String str(ParamOpcionais p, Object o) {
        return o.toString();
    }

    public static void apresentar(ParamOpcionais p, Object str) {
        System.out.println(str);
    }

    public static void apresentarMenu(ParamOpcionais p, Questionario q){
        try {apresentarMenu(p, q, -1);}
        catch (Exception ex) {}
    }

    public static void apresentarMenu(ParamOpcionais p, Questionario q, int tempo){
        start = System.currentTimeMillis() / 1000;
        nrQueFaltaResponder = (q.isGrupo() && ((Grupo)q).minperguntasaresponder >=0) ? ((Grupo)q).minperguntasaresponder : -1;
        respondidas = 0;

        tempoMaximo = -1;

        if (q.tempomaximo >0 ) {
            tempoMaximo = q.tempomaximo ;
            if (tempo != -1 && tempo < tempoMaximo ) tempoMaximo = tempo;   // se o tempo do apresentar for menor, é esse
                                                                            // o tempoMaximo, se não, é o tempo do grupo
        }
        
        if (tempoMaximo == -1 && tempo != -1 ) { tempoMaximo = tempo; }


        adicionarTodasAQuestoesNaoRespondidas(q);

        sair = false;
        while (true) {
            
            try {
                menu(q);
                if (sair || (temTempoMaximo() && getElapsedTime(start) > tempoMaximo)) {
                    break;
                }
            }
            catch (Exception ex) { }
        }
        q.duracao = (int) getElapsedTime(start);

        System.err.println("Este " + q.tipo + " acabou!");

        System.out.println(del);

        q.pontuacao = calcularPontuacao(q);
    }



    private static double  getElapsedTime(double start) {
        double current = System.currentTimeMillis() / 1000;
        return current-start;
    }




    private static void menu(Questionario q) throws IOException{
        double elapsed = getElapsedTime(start);
        int nrFaltam = nrQueFaltaResponder-respondidas;

        System.out.println(del);
        if (q.isGrupo() && ((Grupo)q).minperguntasaresponder >=0 ) {
            String falta = (nrFaltam >0) ?  "É obrigatório responder a mais " + nrFaltam + " perguntas." : "Já foram respondidas o número de questões obrigatórias.";
            System.out.println(falta);
        }
        
        String t = "Tempo passado: " + elapsed + "segundos ";
        if (temTempoMaximo() && tempoMaximo > 0) t+= "(faltam " + (int)( tempoMaximo-elapsed) + "segundos para o "+ q.tipo +" acabar).";
        //String str1 = "Perguntas Disponíveis para resp";
        String str2 = "Perguntas que falta responder: ";
        System.out.println(t + "\n" + str2);
        Iterator itr = q.questoesNaoRespondidas.iterator();
        int i = 1;
        
        if (nrFaltam <= 0) {System.out.println( "0] entrgar e acabar este " + q.tipo );}

        System.out.println();

        while (itr.hasNext()) {
            System.out.println(i++ +") " + ((Questao)itr.next()).apresentarPergunta() );
        }
        //if (nrFaltam <= 0) {System.out.println( i + "] entrgar e acabar este " + q.tipo );}


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int escolha = -1;
        while (!inputValido(escolha, q)) { // ainda n verifica se é igual a i (sair)
            System.out.print("número da pergunta > ");
            String h = reader.readLine();
            try {
                escolha = Integer.parseInt(h);
                if (nrFaltam <= 0 && escolha == 0) {sair = true; return;}
            } catch (Exception ex) {}
            if (!inputValido(escolha, q)) System.out.println("\tERRO: "+msgErro);
        }

        if (temTempoMaximo() && getElapsedTime(start) > tempoMaximo ) {
            System.out.println("O tempo máximo do " + q.tipo + " acabou.");
            return;
        }

        System.out.println(del);
        Questao questEscolhida = q.questoesNaoRespondidas.get(escolha-1);
        Resposta resp = mostrarQuestao(questEscolhida);
        
        if (temTempoMaximo() && getElapsedTime(start) > tempoMaximo ) {
            System.out.println("O tempo máximo do " + q.tipo + " acabou. A resposta não será guardada.");
            return;
        }

        if (resp != null) {

            if (podeGuardar) {
                q.questoesRespondidas.put(questEscolhida, resp);
                questEscolhida.respostadada = resp;
                //System.out.println("\n\n\nresp dada :" + questEscolhida.respostadada + "\n\n");
                resp.atualizarPontuacao();
            } 
            else q.questoesRespondidas.put(questEscolhida, null); // se o tempo da questao tiver acabado...

            respondidas++; 
            q.questoesNaoRespondidas.remove(questEscolhida);
        }
    }



    public static Resposta mostrarQuestao(Questao quest) {

        double startQuestion = System.currentTimeMillis() / 1000;

        if (quest.tempomaximo >0 ) {System.out.println("Tempo disponível para responder esta pergunta: " + quest.tempomaximo);}
        quest.printPergunta();
        
        podeGuardar = true;

        Resposta resp = quest.printRespostas(); 
        double tempoPassado = getElapsedTime(startQuestion);
        if (quest.tempomaximo > 0 && tempoPassado > quest.tempomaximo) {
            System.out.println("ERRO:O tempo máximo para a pergunta foi atingido.\nA resposta não será guardada.");
            podeGuardar = false;
        }
        return resp;

    }

    public static boolean temTempoMaximo() {
        return tempoMaximo > 0;
    }


    private static boolean inputValido(int numPergunta, Questionario q) {
        return numPergunta > 0  && numPergunta <= q.questoesNaoRespondidas.size();
    }

    private static void adicionarTodasAQuestoesNaoRespondidas(Questionario q) {
        Iterator itr = q.questoes.iterator();
        while (itr.hasNext()) {
            q.questoesNaoRespondidas.add((Questao) itr.next() );    
        }
        //q.questoesNaoRespondidas = q.questoes;
    }
    


    public static double calcularPontuacao(Questionario q) {
        double cotacao =0;
        if (q.questoesRespondidas.size() == 0) return cotacao;
        //System.out.println("why tho");
        for (Map.Entry<Questao, Resposta> entry : q.questoesRespondidas.entrySet()) {
            Questao quest = (Questao)entry.getKey();
            Resposta resp = (Resposta)entry.getValue();
            cotacao += calcCotacao(resp, quest);
        }
        return cotacao;
    }

    public static double calcCotacao(Resposta r, Questao q) {
        return q.pontuacao * r.getCotacaoRelativa()/100;
    }

    public static void guardarrespostas(ParamOpcionais po, Questionario q , String fic ) {
        Saver s = new Saver();
        s.printInFile(q, fic);
    }


    public static void importar(ParamOpcionais po, String fic, Questionario q ) {

        CharStream input;
        try {
            input = CharStreams.fromStream(new FileInputStream(fic));
        } catch (Exception ex) {System.out.println("Ocorreu um erro ao abrir o ficheiro para importar."); return; }
        BaseDadosLexer lexer = new BaseDadosLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BaseDadosParser parser = new BaseDadosParser(tokens);
        
        importQuestoes = new ArrayList<Questao>();

        ParseTree tree = parser.program();
        if (parser.getNumberOfSyntaxErrors() == 0) {
            
            Execute visitor0 = new Execute();
            visitor0.visit(tree);

        }

        Iterator itr = importQuestoes.iterator();
        while (itr.hasNext()) {
            q.questoes.add((Questao)itr.next());
        }


    }


    public static ArrayList<Questao> importQuestoes = new ArrayList<Questao>();

}