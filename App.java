import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        System.out.println("\nSeja bem vindo ao Torneio de corrida de Startaps! o STARTUP RUSH!\n");

        int participantes, batalha;

        Scanner scan = new Scanner(System.in);

        Torneio torneio1 = new Torneio();

        participantes = torneio1.setParticipantes(scan);

        Startup [] startups = torneio1.setStartups(scan, participantes);

        Startup [] random = torneio1.randomizer(startups);

        /** Startup temporária */
        Startup st = null;

        boolean [] batalhaAtiva = new boolean[participantes/2];
        boolean [] startupAtiva = new boolean[participantes];

        Startup [] vencedores = new Startup[participantes/2];
        Startup [] finalistas = new Startup[2];

        System.out.println("Perfeito! Iniciaremos o torneio com " + participantes + " startups.\n"+ "As equipes foram divididas nas seguintes chaves:\n");

        int contador;
        boolean sf;

        /** Código responsável por realizar a primeira rodada do Torneio;
         *  Verifica se alguma batalha se encerrou. Se sim, adiciona o vencedor no lugar da chave;
         *  Seleciona uma batalha e os participantes da chave;
         *  Atribui os pontos manualmente de maneira individual para cada Startup;
         *  Encerra o loop quando todas as batalhas forem finalizadas.
         */
        for (int i = 0; i < participantes/2;) {
            
            contador = 0;
            
            for (int j = 0; j < random.length; j = j+2) {
                if (batalhaAtiva[contador]) {
                    if (startupAtiva[j]){
                        System.out.println("Vencedor da chave " + (contador+1) + ": " + random[j].getNome() + " (" + random[j].getPontos() + " pontos)");
                    } else if (startupAtiva[j+1]){
                        System.out.println("Vencedor da chave " + (contador+1) + ": " + random[j+1].getNome() + " (" + random[j+1].getPontos() + " pontos)");
                    }
                } else{
                    System.out.println("Chave " + (contador+1) + ": " + random[j].getNome() + " (" + random[j].getPontos() + " pontos)"  + " x " + random[j+1].getNome() + " (" + random[j+1].getPontos() + " pontos)" );
                }
                contador++;
            }

             batalha = torneio1.selectBatalha(random, scan);
             System.out.println("Você selecionou a chave " + batalha + ".");


             switch (batalha) {
                 case 1:
                     if (batalhaAtiva[0]) {
                         System.out.println("Essa batalha já está encerrada. Por favor, selecione outra.");
                         break;
                     }
                     while (!startupAtiva[0] || !startupAtiva[1]) {
                         System.out.print("(1) - " + random[0].getNome()  + " (" + random[0].getPontos() + " pontos)" + "\n(2) - " + random[1].getNome() + " (" + random[1].getPontos() + " pontos)\n");
                         System.out.println("Digite o número de qual Startup deseja selecionar:");
                         st = torneio1.selectStartup(random, scan, batalha);
                         if (st == random[0] && !startupAtiva[0]) {
                             startupAtiva[0] = true;
                             random[0].adiconarPontos(scan);
                         } else if (st == random[1] && !startupAtiva[1]) {
                             startupAtiva[1] = true;
                             random[1].adiconarPontos(scan);
                         } else if (startupAtiva[0] || startupAtiva[1]){
                             System.out.println("Os pontos dessa equipe já foram adicionados! Por favor, selecione outra.\n");
                         }
                     }
                     st = torneio1.setVencedor(random[0], random[1]);
                     if (st == null) {
                         sf = torneio1.sharkFight();
                         if (sf) {
                             random[0].sharkPoint();
                             st = torneio1.setVencedor(random[0], random[1]);
                         } else {
                             random[1].sharkPoint();
                             st = torneio1.setVencedor(random[0], random[1]);
                         }
                     }
                     if (st.getPontos() == random[0].getPontos()){
                         startupAtiva[1] = false;
                     } else if (st.getPontos() == random[1].getPontos()){
                         startupAtiva[0] = false;
                     }
                     break;
                 case 2:
                     if (batalhaAtiva[1]) {
                         System.out.println("Essa batalha já está encerrada. Por favor, selecione outra.");
                         break;
                     }
                     while (!startupAtiva[2] || !startupAtiva[3]) {
                         System.out.print("(1) - " + random[2].getNome()  + " (" + random[2].getPontos() + " pontos)" + "\n(2) - " + random[3].getNome() + " (" + random[3].getPontos() + " pontos)\n");
                         System.out.println("Digite o número de qual Startup deseja selecionar:");
                         st = torneio1.selectStartup(random, scan, batalha);
                         if (st == random[2] && !startupAtiva[2]) {
                             startupAtiva[2] = true;
                             random[2].adiconarPontos(scan);
                         } else if (st == random[3] && !startupAtiva[3]) {
                             startupAtiva[3] = true;
                             random[3].adiconarPontos(scan);
                         } else if (startupAtiva[2] || startupAtiva[3]){
                             System.out.println("Os pontos dessa equipe já foram adicionados! Por favor, selecione outra.\n");
                         }
                     }
                     st = torneio1.setVencedor(random[2], random[3]);
                     if (st == null) {
                         sf = torneio1.sharkFight();
                         if (sf) {
                             random[2].sharkPoint();
                             st = torneio1.setVencedor(random[2], random[3]);
                         } else{
                             random[3].sharkPoint();
                             st = torneio1.setVencedor(random[2], random[3]);
                         }
                     }

                     if (st.getPontos() == random[2].getPontos()){
                         startupAtiva[3] = false;
                     } else if (st.getPontos() == random[3].getPontos()){
                         startupAtiva[2] = false;
                     }
                     break;
                 case 3:
                     if (batalhaAtiva[2]) {
                         System.out.println("Essa batalha já está encerrada. Por favor, selecione outra.");
                         break;
                     }
                     while (!startupAtiva[4] || !startupAtiva[5]) {
                         System.out.print("(1) - " + random[4].getNome()  + " (" + random[4].getPontos() + " pontos)" + "\n(2) - " + random[5].getNome() + " (" + random[5].getPontos() + " pontos)\n");
                         System.out.println("Digite o número de qual Startup deseja selecionar:");
                         st = torneio1.selectStartup(random, scan, batalha);
                         if (st == random[4] && !startupAtiva[4]) {
                             startupAtiva[4] = true;
                             random[4].adiconarPontos(scan);
                         } else if (st == random[5] && !startupAtiva[5]) {
                             startupAtiva[5] = true;
                             random[5].adiconarPontos(scan);
                         } else if (startupAtiva[4] || startupAtiva[5]){
                             System.out.println("Os pontos dessa equipe já foram adicionados! Por favor, selecione outra.\n");
                         }
                     }
                     st = torneio1.setVencedor(random[4], random[5]);
                     if (st == null) {
                         sf = torneio1.sharkFight();
                         if (sf) {
                             random[4].sharkPoint();
                             st = torneio1.setVencedor(random[4], random[5]);
                         } else {
                             random[5].sharkPoint();
                             st = torneio1.setVencedor(random[4], random[5]);
                         }
                     }
                     if (st.getPontos() == random[4].getPontos()){
                         startupAtiva[5] = false;
                     } else if (st.getPontos() == random[5].getPontos()){
                         startupAtiva[4] = false;
                     }
                     break;
                 case 4:
                     if (batalhaAtiva[3]) {
                         System.out.println("Essa batalha já está encerrada. Por favor, selecione outra.");
                         break;
                     }
                     while (!startupAtiva[6] || !startupAtiva[7]) {
                         System.out.print("(1) - " + random[6].getNome()  + " (" + random[6].getPontos() + " pontos)" + "\n(2) - " + random[7].getNome() + " (" + random[7].getPontos() + " pontos)\n");
                         st = torneio1.selectStartup(random, scan, batalha);
                         if (st == random[6] && !startupAtiva[6]) {
                             startupAtiva[6] = true;
                             random[6].adiconarPontos(scan);
                         } else if (st == random[7] && !startupAtiva[7]) {
                             startupAtiva[7] = true;
                             random[7].adiconarPontos(scan);
                         } else if (startupAtiva[6] || startupAtiva[7]){
                             System.out.println("Os pontos dessa equipe já foram adicionados! Por favor, selecione outra.\n");
                         }
                     }
                     st = torneio1.setVencedor(random[6], random[7]);
                     if (st == null) {
                         sf = torneio1.sharkFight();
                         if (sf) {
                             random[6].sharkPoint();
                             st = torneio1.setVencedor(random[6], random[7]);
                         } else {
                             random[8].sharkPoint();
                             st = torneio1.setVencedor(random[6], random[7]);
                         }
                     }
                     if (st.getPontos() == random[6].getPontos()){
                         startupAtiva[7] = false;
                     } else if (st.getPontos() == random[7].getPontos()){
                         startupAtiva[6] = false;
                     }
                     break;
             }
            vencedores[i] = st;

            if (!batalhaAtiva[batalha-1]) {
                i++;
                batalhaAtiva[batalha - 1] = true;
            }
            
        }

        System.out.println("\nA primeira batalha encerrou! Esses foram os vencedores da primeira etapa:\n");

        for (int i = 0; i < vencedores.length; i++) {
            System.out.println("Vencedor da chave " + (i+1) + ": " + vencedores[i].getNome() + " (" + vencedores[i].getPontos() + " pontos)");
        }


        for(int i = 0; i < startupAtiva.length; i++){
            startupAtiva[i] = false;
        }
        for(int i = 0; i < batalhaAtiva.length; i++){
            batalhaAtiva[i] = false;
        }
        for (int i = 0; i < random.length; i++) {
            for (int j = 0; j < vencedores.length; j++) {
                if (random[i].getNome().equals(vencedores[j].getNome())) {
                    random[i] = vencedores[j];
                }
            }
        }

        /**Reseta o boolean dos pontos das Startups Vencedoras*/
        for (int i = 0; i < vencedores.length; i++){
            vencedores[i].resetEstadoPontos();
        }

        vencedores = torneio1.randomizer(vencedores);

        if ((participantes/2) == 2){
            System.out.println("\nDaremos início agora a segunda e última batalha!");

        } else if ((participantes/2) == 4){
            System.out.println("\nDaremos início agora a segunda batalha!");
        }

        int br;
        /** Código responsável por realizar a segunda rodada do Torneio;
         *  Verifica se alguma batalha se encerrou. Se sim, adiciona o vencedor no lugar da chave;
         *  Atribui apenas 1 rodada caso o torneio tenha iniciado com 4 participantes;
         *  Ativa o modo "Battle Royale" para possibilidade de uso caso tenha iniciado com 6 participantes;
         *  Atribui os pontos manualmente de maneira individual para cada Startup;
         *  Encerra o loop quando todas as batalhas forem finalizadas.
         */
        for (int i = 0; i < (vencedores.length/2);) {

            batalha = 1;
            if ((participantes) == 6){
                br = torneio1.setBattleRoyale(scan);
                if (br == 1) {
                    batalha = 1;
                } else if (br == 2) {
                    batalha = 3;
                }
            } else if ((participantes) == 8) {

                contador = 0;

                for (int j = 0; j < vencedores.length; j = j+2) {

                    if (batalhaAtiva[contador]) {
                        if (startupAtiva[j]){
                            System.out.println("Vencedor da chave " + (contador+1) + ": " + vencedores[j].getNome() + " (" + vencedores[j].getPontos() + " pontos)");
                        } else if (startupAtiva[j+1]){
                            System.out.println("Vencedor da chave " + (contador+1) + ": " + vencedores[j+1].getNome() + " (" + vencedores[j+1].getPontos() + " pontos)");
                        }
                    } else{
                        System.out.println("Chave " + (contador+1) + ": " + vencedores[j].getNome() + " (" + vencedores[j].getPontos() + " pontos)"  + " x " + vencedores[j+1].getNome() + " (" + vencedores[j+1].getPontos() + " pontos)" );
                    }
                    contador++;
                }

                batalha = torneio1.selectBatalha(vencedores, scan);
                System.out.println("Você selecionou a chave " + batalha + ".");
            }

            switch (batalha) {
                case 1:
                    if (batalhaAtiva[0]) {
                        System.out.println("Essa batalha já está encerrada. Por favor, selecione outra.");
                        break;
                    }
                    while (!startupAtiva[0] || !startupAtiva[1]) {
                        System.out.print("(1) - " + vencedores[0].getNome() + " (" + vencedores[0].getPontos() + " pontos)" + "\n(2) - " + vencedores[1].getNome() + " (" + vencedores[1].getPontos() + " pontos)\n");
                        System.out.println("Digite o número de qual Startup deseja selecionar:");
                        st = torneio1.selectStartup(vencedores, scan, batalha);
                        if (st == vencedores[0] && !startupAtiva[0]) {
                            startupAtiva[0] = true;
                            vencedores[0].adiconarPontos(scan);
                        } else if (st == vencedores[1] && !startupAtiva[1]) {
                            startupAtiva[1] = true;
                            vencedores[1].adiconarPontos(scan);
                        } else if (startupAtiva[0] || startupAtiva[1]) {
                            System.out.println("Os pontos dessa equipe já foram adicionados! Por favor, selecione outra.\n");
                        }
                    }
                    st = torneio1.setVencedor(vencedores[0], vencedores[1]);
                    if (st == null) {
                        sf = torneio1.sharkFight();
                        if (sf) {
                            random[0].sharkPoint();
                            st = torneio1.setVencedor(random[0], random[1]);
                        } else {
                            random[1].sharkPoint();
                            st = torneio1.setVencedor(random[0], random[1]);
                        }
                    }
                    if (st.getPontos() == vencedores[0].getPontos()) {
                        startupAtiva[1] = false;
                    } else if (st.getPontos() == vencedores[1].getPontos()) {
                        startupAtiva[0] = false;
                    }
                    break;
                case 2:
                    if (batalhaAtiva[1]) {
                        System.out.println("Essa batalha já está encerrada. Por favor, selecione outra.");
                        break;
                    }
                    while (!startupAtiva[2] || !startupAtiva[3]) {
                        System.out.print("(1) - " + vencedores[2].getNome() + " (" + vencedores[2].getPontos() + " pontos)" + "\n(2) - " + vencedores[3].getNome() + " (" + vencedores[3].getPontos() + " pontos)\n");
                        System.out.println("Digite o número de qual Startup deseja selecionar:");
                        st = torneio1.selectStartup(vencedores, scan, batalha);
                        if (st == vencedores[2] && !startupAtiva[2]) {
                            startupAtiva[2] = true;
                            vencedores[2].adiconarPontos(scan);
                        } else if (st == vencedores[3] && !startupAtiva[3]) {
                            startupAtiva[3] = true;
                            vencedores[3].adiconarPontos(scan);
                        } else if (startupAtiva[2] || startupAtiva[3]) {
                            System.out.println("Os pontos dessa equipe já foram adicionados! Por favor, selecione outra.\n");
                        }
                    }
                    st = torneio1.setVencedor(vencedores[2], vencedores[3]);
                    if (st == null) {
                        sf = torneio1.sharkFight();
                        if (sf) {
                            random[2].sharkPoint();
                            st = torneio1.setVencedor(random[2], random[3]);
                        } else {
                            random[3].sharkPoint();
                            st = torneio1.setVencedor(random[2], random[3]);
                        }
                    }
                    if (st.getPontos() == vencedores[2].getPontos()) {
                        startupAtiva[3] = false;
                    } else if (st.getPontos() == vencedores[3].getPontos()) {
                        startupAtiva[2] = false;
                    }
                    break;
                case  3:
                    int total = vencedores[0].getPontos()+vencedores[1].getPontos()+vencedores[2].getPontos();
                    int sorte = torneio1.battleRoyale(vencedores);
                    if (sorte < vencedores[0].getPontos()) {
                        vencedores[0].vencedorPoint();
                        System.out.println("\nO vencedor do Battle Royale foi: "+ vencedores[0].getNome() + ", com " + vencedores[0].getPontos() + " pontos. Ele tinha apenas " + (100*(vencedores[0].getPontos()-30)/total) + "% de chance de vitória!\n");
                    } else if (sorte < vencedores[0].getPontos() + vencedores[1].getPontos()) {
                        vencedores[1].vencedorPoint();
                        System.out.println("\nO vencedor do Battle Royale foi: "+ vencedores[1].getNome() + ", com " + vencedores[1].getPontos() + " pontos. Ele tinha apenas " + (100*(vencedores[1].getPontos()-30)/total) + "% de chance de vitória!\n");
                    } else {
                        vencedores[2].vencedorPoint();
                        System.out.println("\nO vencedor do Battle Royale foi: "+ vencedores[2].getNome() + ", com " + vencedores[2].getPontos() + " pontos. Ele tinha apenas " + (100*(vencedores[2].getPontos()-30)/total) + "% de chance de vitória!\n");
                    }
                    break;
            }

            finalistas[i] = st;

            if (!batalhaAtiva[batalha-1]) {
                i++;
                batalhaAtiva[batalha - 1] = true;
            }
        }

        for (int i = 0; i < random.length; i++) {
            for (int j = 0; j < vencedores.length; j++) {
                if (random[i].getNome().equals(vencedores[j].getNome())) {
                    random[i] = vencedores[j];
                }
            }
        }

        /** Código responsável por realizar a terceira rodada do Torneio;
         *  Rodada final apenas caso o numero de participantes seja = 8;
         *  Volta o estado dos booleans utilizados para false;
         *  Atribui os pontos manualmente de maneira individual para cada Startup;
         *  Altera os valor dos pontos dos finalistas no array original.
         */
        if (participantes == 8) {
            System.out.println("\nA segunda batalha encerrou! Esses foram os vencedores da segunda etapa:\n");

            for (int i = 0; i < finalistas.length; i++) {
                System.out.println("Vencedor da chave " + (i+1) + ": " + finalistas[i].getNome() + " (" + finalistas[i].getPontos() + " pontos)");
            }


            for(int i = 0; i < startupAtiva.length; i++){
                startupAtiva[i] = false;
            }
            for(int i = 0; i < batalhaAtiva.length; i++){
                batalhaAtiva[i] = false;
            }
            for (int i = 0; i < random.length; i++) {
                for (int j = 0; j < finalistas.length; j++) {
                    if (random[i].getNome().equals(finalistas[j].getNome())) {
                        random[i] = finalistas[j];
                    }
                }
            }
            for (int i = 0; i < finalistas.length; i++){
                finalistas[i].resetEstadoPontos();
            }

            finalistas = torneio1.randomizer(finalistas);

            System.out.println("\nDaremos início agora a terceira e última batalha!");
            batalha = 1;
            System.out.println("Veja abaixo as duas equipes finalistas:");
            
            while (!startupAtiva[0] || !startupAtiva[1]) {
                System.out.print("(1) - " + finalistas[0].getNome() + " (" + finalistas[0].getPontos() + " pontos)" + "\n(2) - " + finalistas[1].getNome() + " (" + finalistas[1].getPontos() + " pontos)\n");
                System.out.println("Digite o número de qual Startup deseja selecionar:");
                st = torneio1.selectStartup(finalistas, scan, batalha);
                if (st == finalistas[0] && !startupAtiva[0]) {
                    startupAtiva[0] = true;
                    finalistas[0].adiconarPontos(scan);
                } else if (st == finalistas[1] && !startupAtiva[1]) {
                    startupAtiva[1] = true;
                    finalistas[1].adiconarPontos(scan);
                } else if (startupAtiva[0] || startupAtiva[1]) {
                    System.out.println("Os pontos dessa equipe já foram adicionados! Por favor, selecione outra.\n");
                }
            }
            st = torneio1.setVencedor(finalistas[0], finalistas[1]);
            if (st == null) {
                sf = torneio1.sharkFight();
                if (sf) {
                    random[0].sharkPoint();
                    st = torneio1.setVencedor(finalistas[0], finalistas[1]);
                } else {
                    random[1].sharkPoint();
                    st = torneio1.setVencedor(finalistas[0], finalistas[1]);
                }
            }
            if (st.getPontos() == finalistas[0].getPontos()) {
                startupAtiva[1] = false;
            } else if (st.getPontos() == finalistas[1].getPontos()) {
                startupAtiva[0] = false;
            }

            for (int i = 0; i < random.length; i++) {
                for (int j = 0; j < finalistas.length; j++) {
                    if (random[i].getNome().equals(finalistas[j].getNome())) {
                        random[i] = finalistas[j];
                    }
                }
            }

        }

        /** Realiza a organização dos pontos em ordem decrescente */
        for (int i = 0; i < random.length - 1; i++) {
            for (int j = 0; j < random.length - 1 - i; j++) {
                if (random[j].getPontos() < random[j + 1].getPontos()) {

                    Startup temp = random[j];
                    random[j] = random[j + 1];
                    random[j + 1] = temp;
                }
            }
        }

        /** Funcionalidade [5] (Relatórios e resultados) */
        System.out.println("Relatório do torneio:\n");
        System.out.printf("%-10s | %-20s | %-6s | %-6s | %-5s | %-6s | %-6s%n", "Pontos", "Startup", "PC", "PB","BTU", "II", "FN");
        System.out.printf("------------------------------------------------------------------------------------------%n");
        for (int i = 0; i < startups.length; i++) {
            random[i].relatorio();
        }
        System.out.println("\nLegenda para tabela:\n");
        System.out.println("PC - Pitch Convincente\nPB - Produto com Bugs\nBTU - Boa Tração de Usuários\nII - Investidor Irritado\nFN - Fake News no Pitch\n");

        System.out.println("Slogan da equipe campeã do Startup Rush: " + random[0].getSlogan());
    }
}
