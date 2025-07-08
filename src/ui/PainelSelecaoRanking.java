package ui;

import javax.swing.*;
import java.awt.Font;


 // PAINEL ONDE O JOGADOR ESCOLHE QUAL RANKING QUER VER (SOLO OU MULTIPLAYER)
public class PainelSelecaoRanking extends JPanel {

    private final TelaPrincipal telaPrincipal;

    public PainelSelecaoRanking(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        setLayout(null);

        // Título
        JLabel labelTitulo = new JLabel("VER RANKING", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 50));
        labelTitulo.setBounds(0, 150, 1200, 60);
        add(labelTitulo);

        // VISUAL DOS BOTÕES

        // Botão Ranking Solo
        JButton botaoRankingSolo = new JButton("Ranking - Modo Solo");
        botaoRankingSolo.setBounds(500, 280, 200, 50);
        add(botaoRankingSolo);

        // Botão Ranking Multiplayer
        JButton botaoRankingMulti = new JButton("Ranking - Multiplayer");
        botaoRankingMulti.setBounds(500, 350, 200, 50);
        add(botaoRankingMulti);

        // Botão Voltar
        JButton botaoVoltar = new JButton("Voltar ao Menu");
        botaoVoltar.setBounds(500, 420, 200, 50);
        add(botaoVoltar);

        // --- AÇÃO DOS BOTÕES ---

        // Botão Ranking Solo
        botaoRankingSolo.addActionListener(e -> {
            telaPrincipal.iniciarTelaDeRanking("SOLO");
        });

        // Botão Ranking Multiplayer
        botaoRankingMulti.addActionListener(e -> {
            telaPrincipal.iniciarTelaDeRanking("MULTIPLAYER");
        });

        // Botão Voltar
        botaoVoltar.addActionListener(e -> {
            telaPrincipal.trocarTela("MENU");
        });
    }
}
