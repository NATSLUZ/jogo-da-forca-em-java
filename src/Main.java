import jogo.JogoDaForca;
import jogo.JogoSolo;
import modelo.Ranking;

public class Main {
    public static void main(String[] args) {
        JogoDaForca jogo = new JogoSolo();
        jogo.iniciar();

        // EXibição do Ranking
        System.out.println("\nExibindo o ranking atual do modo solo:");
        Ranking ranking = new Ranking();
        ranking.exibirRanking("ranking_solo.txt");

    }
}
