package jogo;

import modelo.Jogador;
import modelo.Ranking;

import java.util.List;


public class JogoMultiplayer extends JogoDaForca {

    private final int TOTAL_RODADAS = 10; // 5 para cada jogador
    public JogoMultiplayer() {
        super();
    }

    // Define a lista com 2 jogadores para o multiplayr.
    @Override
    public void setJogadores(List<Jogador> jogadores) {
        if (jogadores != null && jogadores.size() == 2) {
            this.jogadores = jogadores;
        } else {
            System.err.println("Erro: O modo multiplayer espera exatamente dois jogadores.");
        }
    }

    // Implementação para obter o jogador da vez.
    // No modo Multiplayer, alterna entre jogador 0 (par) e 1 (impar).
    @Override
    public Jogador getJogadorDaVez() {
        if (this.jogadores == null || this.jogadores.isEmpty()) {
            return null;
        }
        // Usa o número de rodadas jogadas para determinar o turno.
        // rodadasJogadas começa em 0.
        // Turno 1 (rodadasJogadas=0, par) -> jogador 0
        // Turno 2 (rodadasJogadas=1, ímpar) -> jogador 1
        // Turno 3 (rodadasJogadas=2, par) -> jogador 0
        int indiceJogador = this.rodadasJogadas % 2;
        return this.jogadores.get(indiceJogador);
    }


    // Implementação da condição de término da sessão para o modo multiplayer.
    // No modo multiplayer a sessão é terminada após 10 rodadas, 5 para cada jogador.
    @Override
    public boolean isSessaoTerminada() {
        // A sessão termina se palavras acabaram.
        return rodadasJogadas >= TOTAL_RODADAS || (palavrasDoTema != null && palavrasDoTema.isEmpty());
    }

    // Implementação da finalização da sessão para o modo multiplayer.
    // Salva pontuação no ranking Multiplayer.
    @Override
    public void finalizarSessao() {
        if (jogadores != null && jogadores.size() == 2) {
            System.out.println("Lógica de negócio: Finalizando sessão e salvando pontuações...");
            Ranking ranking = new Ranking();
            ranking.adicionarPontuacao(jogadores.get(0), "ranking_multi.txt");
            ranking.adicionarPontuacao(jogadores.get(1), "ranking_multi.txt");
        }
    }
}