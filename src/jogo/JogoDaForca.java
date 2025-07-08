package jogo;

import leitor.*;
import modelo.*;

import java.util.*;


 // CLASSE ABSTRATA: Define o contrato e o estado de uma sessão de jogo.

public abstract class JogoDaForca {

    protected List<Jogador> jogadores;
    protected Tema temaEscolhido;
    protected List<String> palavrasDoTema;
    protected Map<String, String> mapaDeDicas;
    protected int rodadasJogadas;
    private final Random random = new Random();

    // O construtor é compartilhado por todas as subclasses.
    public JogoDaForca() {
        this.jogadores = new ArrayList<>();
    }


     // MÉTODOS CONCRETOS: Lógica implementada pela SUPERCLASSE.


    // PASSO CONCRETO 1: Preparar a sessão de jogo, escolher o leitor correto (Normal ou Adapter)
    //e carrega a lista de palavras e o mapa de dicas, dependendo do tema.


    public void prepararSessao(Tema tema) {
        this.temaEscolhido = tema;
        this.rodadasJogadas = 0;

        LeitorPalavras leitor;
        if (tema == Tema.DESAFIO) {
            LeitorJsonAdapter adapter = new LeitorJsonAdapter();
            leitor = adapter;
            this.mapaDeDicas = adapter.getMapaDeDicas();
        } else {
            leitor = new LeitorPalavrasArquivo();
            this.mapaDeDicas = null;
        }
        this.palavrasDoTema = leitor.carregarPalavras(tema);
    }

    public List<Jogador> getJogadores() {
        return this.jogadores;
    }


     // PASSO CONCRETO 2: Sorteia uma palavra da lista, e remove da lista, cria um obj Rodada para ser usado.
     // Remove-a para não repetir, e cria um novo objeto Rodada pronto para ser usado.
     // Retorna um novo obj Rodada, ou null se as palavras acabaram.

    protected Rodada criarProximaRodada() {
        if (palavrasDoTema == null || palavrasDoTema.isEmpty()) {
            return null;
        }
        int indiceSorteado = random.nextInt(palavrasDoTema.size());
        String palavraSorteada = palavrasDoTema.get(indiceSorteado);
        palavrasDoTema.remove(indiceSorteado);

        String dica = (mapaDeDicas != null) ? mapaDeDicas.get(palavraSorteada) : null;

        this.rodadasJogadas++;
        return new Rodada(palavraSorteada, dica);
    }

    // PASSO CONCRETO 3: Prepara e retorna a próxima rodada do jogo.
    // Retorna O próximo objeto Rodada a ser jogado, ou null se a sessão acabou.

    public Rodada proximaRodada() {
        if (isSessaoTerminada()) {
            return null;
        }
        return criarProximaRodada();
    }


    // MÉTODOS ABSTRATOS (Implementados pelas Subclasses)
    // (JogoSolo, JogoMultiplayer).


     // PASSO ABSTRATO 1: Define os jogadores para a sessão de jogo.
     // A implementação varia se for 1 ou 2 jogadores.

    public abstract void setJogadores(List<Jogador> jogadores);

     // PASSO ABSTRATO 2: Retorna o jogador com o turno ativo.
     // No modo solo, retorna sempre o mesmo jogador. No multiplayer, alterna.
     // Retorna O objeto Jogador que está jogando na rodada atual.

    public abstract Jogador getJogadorDaVez();

     // PASSO ABSTRATO 3: Prepara e retorna a próxima rodada do jogo.
     // A GUI (ou outro cliente) chamará este método para avançar na partida.
     // Retorna O próximo objeto Rodada a ser jogado.


     // PASSO ABSTRATO 4: Verifica o fim da sessão de jogo
     // Jogo solo termina com 5 rodadas, Multiplayer com 10.
     // Retorna true se a sessão terminou, false caso contrário.

    public abstract boolean isSessaoTerminada();

     // PASSO ABSTRATO 5: Realiza as ações finais da sessão.
     // A implementação definirá como salvar no ranking e como determinar o vencedor.

    public abstract void finalizarSessao();


}
