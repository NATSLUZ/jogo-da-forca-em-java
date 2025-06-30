package jogo;

import modelo.Jogador;
import modelo.Ranking;
import modelo.Rodada;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Implementação jogo multiplayer

public class JogoMultiplayer extends JogoDaForca {

    private List<Jogador> jogadores;

    public JogoMultiplayer(Scanner scanner) {
        super(scanner);
        this.jogadores = new ArrayList<>();

    }

    // Sobrescreve o método para preprar dois jogadores
    @Override
    protected void prepararJogadores() {
        System.out.println("\n--- Preparando Modo Multiplayer ---");

        // Adiciona o 1 player a lista
        System.out.println("Digite o nome do Jogador 1: ");
        String nome1 = scanner.nextLine();
        this.jogadores.add(new Jogador(nome1));

        // Adiciona o 2 player a lista
        System.out.println("Digite o nome do Jogador 2: ");
        String nome2 =  scanner.nextLine();
        this.jogadores.add(new Jogador(nome2));

        System.out.println("\nBem-Vindos, " + jogadores.get(0).getNome() + " e " + jogadores.get(1).getNome() + "!");
        System.out.println("Que comece a disputa!");
    }

    // Lógica das rodadas multiplayer
    @Override
    protected void jogarRodadas() {

        // 10 rodadas alternadas no total, 5 para cada jogador
        for (int i = 1; i <= 10; i++) {

            // Lógica para decir a vez do jogador
            // Se impar jogador 0
            // Se par jogador 1
            int indiceJogadorDaVez = (i % 2 == 1) ? 0 : 1;
            Jogador jogadorDaVez = jogadores.get(indiceJogadorDaVez);

            System.out.println("--- RODADA " + i + " de 10 ---");
            System.out.println("---> Vez de: " + jogadorDaVez.getNome() + " <--");
            System.out.println("Placar: "
                    + jogadores.get(0).getNome() + " "
                    + jogadores.get(0).getPontuacao() + " x "
                    + jogadores.get(1).getPontuacao() + " "
                    + jogadores.get(1).getNome());

            System.out.println("\nPressione ENTER para sortear sua palavra...");
            scanner.nextLine();

            String palavraSorteada = sortearPalavraDaLista();
            if (palavraSorteada == null){
                System.out.println("Não há mais palavras neste tema");
                break;
            }

            String dica =null;
            if (mapaDeDicas != null){
                dica = mapaDeDicas.get(palavraSorteada);
            }

            Rodada rodada = new Rodada(palavraSorteada, dica);
            if (rodada.getDica() != null){
                System.out.println("================== DICA =================");
                System.out.println(" " + rodada.getDica());
                System.out.println("=======================================");
            }

            // Loop de uma única rodada
            while (!rodada.isFimDeRodada()){
                System.out.println("--- RODADA " + i + " de 10 --- (Vez de: " + jogadorDaVez.getNome() + ")");
                System.out.println(rodada.getEnforcadoArt());
                System.out.println("Palavra: " + rodada.getPalavraVisivel());
                System.out.print("Histórico de letras: ");
                rodada.getLetrasTentadas().forEach(letra -> System.out.print(letra + " "));
                System.out.print("\n\nDigite uma letra: ");
                String input = scanner.nextLine().trim();
                if (input.length() == 1){
                    rodada.tentarLetra(input.charAt(0));
                }
            }

            // Fim da rodada, verifica se acertou para pontuar
            if (rodada.isPalavraDescoberta()) {
                System.out.println("\nPARABÉNS, " + jogadorDaVez.getNome() + "! Você acertou a palavra: "
                        + rodada.getPalavraSecreta());

                // Adiciona o ponto para o player
                jogadorDaVez.adicionarPonto();
            } else {
                System.out.println("\nQUE PENA! Você foi enforcado! A palavra era: " + rodada.getPalavraSecreta());
            }

            // Pausa antes da proxima rodada
            if (i < 10){
                System.out.println("Pressione ENTER para a próxima rodada...");
                scanner.nextLine();
            }
        }
    }

    // Finaliza a sessão multiplayer
    @Override
    protected void finalizarSessao() {
        System.out.println("\n--- FIM DA SESSÃO MULTIPLAYER ---");

        Jogador jogador1 = jogadores.get(0);
        Jogador jogador2 = jogadores.get(1);

        System.out.println("Placar Final:");
        System.out.println(jogador1.getNome() + ": " + jogador1.getPontuacao() + " Pontos");
        System.out.println(jogador2.getNome() + ": " + jogador2.getPontuacao() + " Pontos");

        // Declara o vencedor
        System.out.println("\n--- RESULTADO ---");
        if (jogador1.getPontuacao() > jogador2.getPontuacao()) {
            System.out.println("O vencedor é: " + jogador1.getNome() + "!");
        } else if (jogador2.getPontuacao() > jogador1.getPontuacao()) {
            System.out.println("O vencedor é: " + jogador2.getNome() + "!");
        } else {
            System.out.println("A partida terminou EMPATADA! ");
        }

        // Salva a pontuação dos jogadores no ranking multiplayer
        System.out.println("\nSalvando as pontuações no ranking multiplayer...");
        Ranking ranking = new Ranking();
        ranking.adicionarPontuacao(jogador1, "ranking_multi.txt");
        ranking.adicionarPontuacao(jogador2, "ranking_multi.txt");

        System.out.println("\nObrigado por jogar!");
    }
}
