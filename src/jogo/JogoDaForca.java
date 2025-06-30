package jogo;

import leitor.LeitorJsonAdapter;
import leitor.LeitorPalavrasArquivo;
import leitor.LeitorPalavras;
import modelo.Tema;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Map;


public abstract class JogoDaForca {
    protected LeitorPalavras leitor;
    protected Scanner scanner;
    protected List<String> palavrasDoTema;
    protected Tema temaEscolhido;
    protected Random random;
    protected Map<String, String> mapaDeDicas;

    // Quando o jogo é iniciado instancia leitor e scanner
    public JogoDaForca (Scanner scanner) {
        this.scanner = scanner;
        this.random = new Random();
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

                // Lógica de decisão do ADAPTER
                if (temaEscolhido != null){
                    if (temaEscolhido == Tema.DESAFIO) {
                        LeitorJsonAdapter adapter = new LeitorJsonAdapter();
                        this.leitor = adapter;
                        this.mapaDeDicas = adapter.getMapaDeDicas();
                        System.out.println("\n[MODO DESAFIO ATIVADO! PALAVRAS ESPECIAIS CARREGADAS.]");
                    } else {
                        this.leitor = new LeitorPalavrasArquivo();
                        this.mapaDeDicas = null;
                    }

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



    protected String sortearPalavraDaLista() {
        if (palavrasDoTema == null || palavrasDoTema.isEmpty()) {
            return null;
        }
        // Sorteia um índice aleatório da lista de palavras do tema
        int indiceSorteado = random.nextInt(palavrasDoTema.size());
        // Pega a palavra nesse índice
        String palavraSorteada = palavrasDoTema.get(indiceSorteado);
        // Remove a palavra da lista para não ser sorteada novamente na mesma sessão
        palavrasDoTema.remove(palavraSorteada);
        return palavraSorteada;
    }

    // Passos abstrados:implementados pelas subclasses;

    // Cada tipo de jogo prepara os jogadores de um jeito
    protected abstract void prepararJogadores();

    // Cada tipo de jogo terá sua propria lógica de rodadas
    protected abstract void jogarRodadas();

    // Cada tipo de jogo finaliza de forma diferente
    protected abstract void finalizarSessao();

}
