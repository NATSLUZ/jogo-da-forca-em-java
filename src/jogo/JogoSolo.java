package jogo;

import modelo.Jogador;
import modelo.Ranking;
import modelo.Rodada;

public class JogoSolo extends JogoDaForca {
    private Jogador jogador;

    //implementa a preparação do jogo
    @Override
    protected void prepararJogadores() {
        System.out.print("Digite o nome do jogador: ");
        String nome = scanner.nextLine();
        this.jogador = new Jogador(nome);
        System.out.println("Bem-Vindo, " + jogador.getNome() + "!");
    }

    //lógica rodadas solo
    @Override
    protected void jogarRodadas(){
        for (int i = 1; i <= 5; i++) {
            System.out.println("\n--- Vamos começar, RODADA " + i + " de 5 ---");
            String palavraSorteada = leitor.sortearPalavra(palavrasDoTema);

            //remove a palavra sorteada para não repetir
            palavrasDoTema.remove(palavraSorteada);

            Rodada rodada = new Rodada(palavraSorteada);

            //Loop de uma rodada
            while (!rodada.isFimDeRodada()){
                System.out.println("--- RODADA " + i + " de 5 ---");
                System.out.println("Jogador: " + jogador.getNome() + " | Pontuação: " + jogador.getPontuacao());
                System.out.println(rodada.getEnforcadoArt());
                System.out.println("Palavra: " + rodada.getPalavraVisivel());
                System.out.print("Histórico de letras ");
                rodada.getLetrasTentadas().forEach(letra -> System.out.print(letra + ""));
                System.out.print("\n\nDigite uma letra: ");
                String input = scanner.nextLine().trim();
                if (input.length() ==1 ){
                    rodada.tentarLetra(input.charAt(0));
                }
            }

            //Fim da rodada, vereficar pontuação
            if (rodada.isPalavraDescoberta()){
                System.out.println("\nPARABÈNS! Você acertou a palavra: " + rodada.getPalavraSecreta());
                jogador.adicionarPonto();
            } else {
                System.out.println("\nQUE PENA! Você foi enfocado! A palavra era: " + rodada.getPalavraSecreta());
            }
            System.out.println("Pressione ENTER para continuar par a próxima rodada...");
            scanner.nextLine();
        }
    }

    //finaliza o jogo solo
    @Override
    protected void finalizarSessao() {
        System.out.println("---FIM DA SESSÂO---");
        System.out.println("Resultado Final:");
        System.out.println(jogador); //metodo toString
        //Ranking solo
        System.out.println("\nSalvando sua pontuação no ranking...");
        Ranking ranking = new Ranking();
        ranking.adicionarPontuacao(jogador, "ranking_solo.txt");
        System.out.println("\nObrigado por JOGAR! Até a próxima!");

    }

}
