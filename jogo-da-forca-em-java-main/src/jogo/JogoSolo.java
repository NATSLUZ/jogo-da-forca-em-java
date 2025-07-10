package jogo;

import modelo.Jogador;
import modelo.Ranking;

import java.util.List;


public class JogoSolo extends JogoDaForca {

    private final int TOTAL_RODADAS = 5;
    public JogoSolo() {
        super();
    }


     // Implementação abstrata: Define o jogdador da sessão.
     // No modo solo, esperamos uma lista com apenas 1 jogador.
    @Override
    public void setJogadores(List<Jogador> jogadores) {
        if (jogadores != null && jogadores.size() == 1) {
            this.jogadores = jogadores;
        } else {
            System.err.println("Erro: O modo solo espera exatamente um jogador.");
        }
    }


     // Implementação para obter o jogador da vez.
     // No modo solo, é sempre o primeiro (e único) jogador da lista.
    @Override
    public Jogador getJogadorDaVez() {
        if (this.jogadores != null && !this.jogadores.isEmpty()) {
            return this.jogadores.get(0);
        }
        return null;
    }


     // Implementação da condição de término da sessão para o modo solo.
    // No modo Solo a sessão é terminada após 5 rodadas
    @Override
    public boolean isSessaoTerminada() {
        // A sessão termina se palavras acabaram.
        return rodadasJogadas >= TOTAL_RODADAS || (palavrasDoTema != null && palavrasDoTema.isEmpty());
    }

     // Implementação da finalização da sessão para o modo solo.
     // Salva pontuação no ranking Solo.
    @Override
    public void finalizarSessao() {
        Jogador jogador = getJogadorDaVez();
        if (jogador != null) {
            System.out.println("Lógica de negócio: Finalizando sessão e salvando pontuação para " + jogador.getNome());
            Ranking ranking = new Ranking();
            ranking.adicionarPontuacao(jogador, "ranking_solo.txt");
        }
    }
}
