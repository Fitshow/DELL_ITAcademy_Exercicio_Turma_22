import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Startup {

    private final String nome;
    private final String slogan;
    private final Date dataFundacao;
    private int pontos = 70;
    private boolean pitchConvincente;
    private int contaPitchConvincente;
    private boolean produtoComBugs;
    private int contaProdutoComBugs;
    private boolean boaTracaoDeUsuarios;
    private int contaBoaTracaoDeUsuarios;
    private boolean investidorIrritado;
    private int contaInvestidorIrritado;
    private boolean fakeNewsNoPitch;
    private int contaFakeNewsNoPitch;


    Startup(String nome, String slogan, Date dataNascimento) {
        this.nome = nome;
        this.slogan = slogan;
        this.dataFundacao = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getSlogan() {
        return slogan;
    }

    public int getPontos() {
        return pontos;
    }

    /** Método sharkPoint()
     *  Adiciona +2 pontos quando o método sharkPoint é chamado
     */
    public int sharkPoint(){
        pontos = pontos + 2;
        return pontos;
    }

    /** Método vencedorPoint()
     *  Adiciona +30 pontos quando o método vencedorPoint é chamado.
     */
    public int vencedorPoint(){
        pontos = pontos + 30;
        return pontos;
    }

    /** Método resetEstadoPontos()
     *  Retorna os booleans para estado falso.
     */
    public void resetEstadoPontos(){
        pitchConvincente = false;
        produtoComBugs = false;
        boaTracaoDeUsuarios = false;
        investidorIrritado = false;
        fakeNewsNoPitch = false;
    }

    /** Método adicionarPontos()
     *  Permite a seleção de qual opção de pontos o usuário deseja registrar;
     *  Verifica se a entrada inserida corresponde a um dos números presente;
     *  Limita o registro de uma operação para apenas 1 uso por batalha;
     *  Adiciona ou remove pontos, com base na operação indicada.
     */
    public void adiconarPontos(Scanner scan) {

        int temp = 10;

        do{
            System.out.println("\nDigite o número do item que deseja realizar:\n" +
                    "(0) - Finalizar a somatória de pontos");
            if (!pitchConvincente){
                System.out.println("(1) - Pitch convincente: +6 pontos");
            } else{
                System.out.println("(1) - Pitch convincente: pontos adicionados.");
            }
            if (!produtoComBugs){
                System.out.println("(2) - Produto com bugs: -4 pontos");
            } else{
                System.out.println("(2) - Produto com bugs: pontos removidos.");
            }
            if (!boaTracaoDeUsuarios){
                System.out.println("(3) - Boa tracao de usuarios: +3 pontos");
            } else{
                System.out.println("(3) - Boa tracao de usuarios: pontos adicionados.");
            }
            if (!investidorIrritado){
                System.out.println("(4) - Investidor irritado: -6 pontos");
            } else{
                System.out.println("(4) - Investidor irritado: pontos removidos.");
            }
            if (!fakeNewsNoPitch){
                System.out.println("(5) - Fake news no pitch: -8 pontos");
            } else{
                System.out.println("(5) - Fake news no pitch: pontos removidos.");
            }
            try {
                temp = scan.nextInt();
                scan.nextLine(); // Limpa o buffer

                switch(temp) {
                    case 0:
                        break;
                    case 1:
                        if (!pitchConvincente) {
                            pitchConvincente = true;
                            pontos += 6;
                            System.out.println("Operação realizada (+6 pontos).");
                            contaPitchConvincente ++;
                        } else {
                            System.out.println("Essa opção já foi utilizada. Por favor, use outra.");
                        }
                        break;
                    case 2:
                        if (!produtoComBugs) {
                            produtoComBugs = true;
                            pontos -= 4;
                            System.out.println("Operação realizada (-4 pontos).");
                            contaProdutoComBugs ++;
                        } else {
                            System.out.println("Essa opção já foi utilizada. Por favor, use outra.");
                        }
                        break;
                    case 3:
                        if (!boaTracaoDeUsuarios) {
                            boaTracaoDeUsuarios = true;
                            pontos += 3;
                            System.out.println("Operação realizada (+3 pontos).");
                            contaBoaTracaoDeUsuarios ++;
                        } else {
                            System.out.println("Essa opção já foi utilizada. Por favor, use outra.");
                        }
                        break;
                    case 4:
                        if (!investidorIrritado) {
                            investidorIrritado = true;
                            pontos -= 6;
                            System.out.println("Operação realizada (-6 pontos).");
                            contaInvestidorIrritado ++;
                        } else {
                            System.out.println("Essa opção já foi utilizada. Por favor, use outra.");
                        }
                        break;
                    case 5:
                        if (!fakeNewsNoPitch) {
                            fakeNewsNoPitch = true;
                            pontos -= 8;
                            System.out.println("Operação realizada (-8 pontos).");
                            contaFakeNewsNoPitch ++;
                        } else {
                            System.out.println("Essa opção já foi utilizada. Por favor, use outra.");
                        }
                        break;
                    default:
                        System.out.println("Número inválido! Por favor, utilize apenas os números presentes na lista.");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, digite apenas os números inteiros presentes na lista.");
                scan.nextLine(); // Limpa o buffer para próxima tentativa
            }

        }while (temp != 0);

        System.out.println("Encerrando processo...\n");
    }

    /** Método relatorio()
     *  Funcionalidade [5] (Relatórios e resultados);
     *  Imprime as informações solicitadas, separadas por uma formatação previamente definida.
     */
    public void relatorio() {
        System.out.printf("%-10s | %-20s | %-6s | %-6s | %-5s | %-6s | %-6s%n", pontos, nome, contaPitchConvincente, contaProdutoComBugs, contaBoaTracaoDeUsuarios, contaInvestidorIrritado, contaFakeNewsNoPitch);
    }

}