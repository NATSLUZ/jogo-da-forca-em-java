package jogo;

import leitor.LeitorPalavrasArquivo;
import modelo.Tema;

import java.util.List;
import java.util.Scanner;

public abstract class JogoDaForca {
    protected LeitorPalavrasArquivo leitor;
    protected Scanner scanner;
    protected List<String> palavrasDoTema;
    protected Tema temaEscolhido;

    // Quando o jogo é iniciado instancia leitor e scanner
    public JogoDaForca (Scanner scanner) {
        this.leitor = new LeitorPalavrasArquivo();
        this.scanner = scanner;
    }

    // Template Method - passo a passo
    public final void iniciar(){
        boasVindas();
        prepararJogadores();
        escolherTema();
        jogarRodadas();
        finalizarSessao();
    }

    // Método concreto, igual para todas as subclasses
    protected void boasVindas(){
        System.out.println("**************************");
        System.out.println("Bem-vindo ao jogo da Forca");
        System.out.println("**************************");
    }

    // Escolher tema (concreto)
    protected void escolherTema(){
        while (temaEscolhido==null) {
            Tema.listarTemas();
            System.out.print("Digite o número do tema desejado: ");
            if (scanner.hasNextInt()){
                int escolha = scanner.nextInt();
                scanner.nextLine();
                temaEscolhido = Tema.escolherTema(escolha);

                // Verifica se o tema escolhido é válido
                if (temaEscolhido != null){
                    palavrasDoTema = leitor.carregarPalavras(temaEscolhido);
                    if (palavrasDoTema.isEmpty()){
                        System.err.println("ERRO: Arquivo vázio ou tema não encontrado: ");
                        temaEscolhido = null;
                    }
                } else {
                    System.out.println("Opção inválida, tente novamente.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número. ");
                scanner.nextLine();
            }
        }
    }

    // Passos abstrados:implementados pelas subclasses;

    // Cada tipo de jogo prepara os jogadores de um jeito
    protected abstract void prepararJogadores();

    // Cada tipo de jogo terá sua propria lógica de rodadas
    protected abstract void jogarRodadas();

    // Cada tipo de jogo finaliza de forma diferente
    protected abstract void finalizarSessao();


}
