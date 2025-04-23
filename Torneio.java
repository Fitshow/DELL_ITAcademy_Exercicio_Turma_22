import java.util.Random;
import java.util.Scanner;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Torneio {

    private int participantes = 0;

    /** Método setParticipantes()
     *  Lê o número de participantes presentes no torneio e cria as Startups;
     *  Imprime uma mensagem de erro caso o número de participantes esteja incorreto;
     *  Repete o código até que o número de participantes seja 4, 6 ou 8;
     *  Retorna um int com o número de participantes informado.
     */
    public int setParticipantes(Scanner scan) {
        System.out.print("Digite o número de startups participantes (4, 6 ou 8): ");
        do {
            String p = scan.nextLine();

            try {
                participantes = Integer.parseInt(p);

                if (participantes < 4 || participantes > 8 || participantes % 2 == 1) {
                    System.out.print("Número inválido! Por favor, digite apenas números entre 4, 6 ou 8: ");
                    participantes = 0;
                }

            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida! Por favor, digite apenas números entre 4, 6 ou 8: ");
            }
        } while (participantes == 0);

        return participantes;
    }

    /** Método setStartups()
     *  Lê as informações das startups participantes e as armazena em um array;
     *  Solicita nome, slogan e data de fundação para cada participante;
     *  Verifica e valida a data inserida no formato dd/MM/yyyy;
     *  Retorna um array de startups preenchido com os dados informados.
     */
    public Startup[] setStartups(Scanner scan, int participantes) {

    Startup[] startups = new Startup[participantes];
    Startup blank = new Startup("","", null);

    System.out.println("\nEscreva as informações das Startups participantes: \n");

    for (int i = 0; i < participantes; i++) {
        System.out.println((i + 1) + "ª Startup: ");

        String nome = null;
        boolean nomeOk;

        do {
            nomeOk = true;
            try {
                System.out.print("Nome: ");
                nome = scan.nextLine();

                if (blank.getNome().equalsIgnoreCase(nome)) {
                    System.out.println("Não esqueça de dar um nome para Startup!");
                    nomeOk = false;
                }

                for (int j = 0; j < i; j++) {
                    if (startups[j].getNome().equalsIgnoreCase(nome)) {
                        System.out.println("Nome já utilizado por outra startup! Por favor escolha outro.");
                        nomeOk = false;
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida! Por favor, insira um nome apropriado.");
                nomeOk = false;
            }
        } while (!nomeOk);

        String slogan = null;
        boolean sloganOk;
        do {
            sloganOk = true;
            try {
                System.out.print("Slogan: ");
                slogan = scan.nextLine();

                if (blank.getSlogan().equalsIgnoreCase(slogan)) {
                    System.out.println("Não esqueça de criar um Slogan para Startup!");
                    sloganOk = false;
                }

            } catch (Exception e) {
                System.out.println("Entrada inválida! Por favor, insira um slogan apropriado.");
                sloganOk = false;
            }
        } while (!sloganOk);

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false);

        Date dataFundacao = null;
        while (dataFundacao == null) {
            System.out.print("Data de fundação (dd/mm/aaaa): ");
            String dataTexto = scan.nextLine();

            try {
                dataFundacao = formato.parse(dataTexto);
            } catch (ParseException e) {
                System.out.println("Data inválida! Tente novamente.");
            }
        }

        startups[i] = new Startup(nome, slogan, dataFundacao);
    }
    return startups;
    }

    /** Método randomizer()
     *  Embaralha a quantidade de participantes recebidas em um array de inteiros;
     *  Garante que nenhum número se repete dentro desse array;
     *  Cria um novo array com o conteúdo do array de startups + o index do array de inteiros;
     *  Retorna esse novo array com as startups em ordem aleatória.
     */
    public Startup[] randomizer(Startup[] startups){

        int [] b = new int [startups.length];
        Random r = new Random();
        boolean unico;

        for (int i = 0; i < startups.length;) {
            int temp = r.nextInt(startups.length);
            unico = true;

            for (int j = 0; j < i; j++) {
                if (b[j] == temp) {
                    unico = false;
                    break;
                }
            }
            if (unico) {
                b[i] = temp;
                i++;
            }
        }

        Startup [] startupsRandom = new Startup[startups.length];

        for (int i = 0; i < startups.length; i++) {
            startupsRandom[i] = startups[b[i]];
        }
        return startupsRandom;
    }

    /** Método selectBatalha()
     *  Pede para o usuário selecionar uma das chaves disponíveis;
     *  Garante que a entrada seja válida (entre 1 e o número de batalhas possíveis, ou apenas 1);
     *  Repete a solicitação até que um número válido seja inserido;
     *  Retorna o número inteiro da batalha selecionada.
     */
    public int selectBatalha(Startup[] startupsRandom, Scanner scan){

        int batalha = 0;
        do{
            System.out.print("\nDigite qual a chave da batalha que deseja administrar: ");
            String b = scan.nextLine();

            try {
                batalha = Integer.parseInt(b);

                if (batalha < 1 || batalha > startupsRandom.length/2) {
                    System.out.println("Número inválido! Por favor, digite apenas números entre 1 a "+ startupsRandom.length/2 +".");
                    batalha = 0;
                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, digite apenas números inteiros.");
            }

        } while(batalha == 0);

        return batalha;
    }

    /**
     * Método selectStartup()
     * Permite que o usuário escolha entre as duas startups participantes da batalha;
     * Verifica se a entrada está entre os valores permitidos (1 ou 2);
     * Localiza e retorna a startup correspondente à batalha e equipe escolhida.
     */
    public Startup selectStartup(Startup[] startupsRandom, Scanner scan, int batalha){

        Startup s = null;

        int equipe = 0;
        do{
            String st = scan.nextLine();

            try {
                equipe = Integer.parseInt(st);

                if (equipe < 1 || equipe > 2) {
                    System.out.println("Número inválido! Por favor, digite apenas 1 ou 2: ");
                    equipe = 0;
                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, digite apenas números inteiros entre 1 ou 2: ");
            }

        } while(equipe == 0);

        int temp = 1;

        for (int i = 0; i < startupsRandom.length; i = i+2) {

            if (batalha == temp){
                switch (equipe){
                    case 1:
                        s = startupsRandom[i];
                        break;
                    case 2:
                        s = startupsRandom[i+1];
                }
            }
            temp ++;
        }
        return s;
    }

    /**
     * Método setVencedor()
     * Compara a pontuação entre duas startups e atribui pontos extras para a vencedora (+30);
     * Retorna a Startup vencedora ou null em caso de empate.
     */
    public Startup setVencedor(Startup s1, Startup s2){

        if (s1.getPontos() == s2.getPontos()){
            return null;
        } else if (s1.getPontos() > s2.getPontos()){
            s1.vencedorPoint();
            return s1;
        } else {
            s2.vencedorPoint();
            return s2;
        }
    }

    /**
    * Método sharkFight()
    * Retorna um boolean aleatório para desempatar 2 Startups empatadas.
    */
    public boolean sharkFight() {
        Random r = new Random();
        return r.nextBoolean();
    }

    public int battleRoyale(Startup[] vencedores) {
        int pt = vencedores[0].getPontos() + vencedores[1].getPontos() + vencedores[2].getPontos();
        Random r = new Random();
        int sorte = r.nextInt(pt);
        return sorte;
    }

    public int setBattleRoyale(Scanner scan){
        int n = 0;
        do {
            System.out.println("\nDigite qual opção deseja seguir com para a última rodada:");
            System.out.println("(1) - Normal");
            System.out.println("(2) - Battle Royale");
            String temp = scan.nextLine();
            try {
                n = Integer.parseInt(temp);
                if (n < 1 || n > 2) {
                    System.out.println("Número inválido! Por favor, digite apenas os números 1 ou 2.");
                    n = 0;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, digite apenas os números 1 ou 2.");

            }
        } while (n == 0);

        return n;
    }
}
