package ui;

import modelo.Jogador;

import javax.swing.*;
import java.awt.*;

// --- PAINEL DE RESULTADO DE PARTIDA DO MODO SOLO  ---
public class PainelFimSolo extends JPanel {

    private final TelaPrincipal telaPrincipal;

    public PainelFimSolo(TelaPrincipal telaPrincipal, Jogador jogador) {
        this.telaPrincipal = telaPrincipal;
        setLayout(null);
        setBackground(new Color(230, 240, 255)); // Um fundo levemente diferente

        // Imagem de arte da tela Fim de Jogo Solo
        JLabel labelArte = new JLabel(new ImageIcon("recursos/img/fim_jogo.png"));
        labelArte.setBounds(475, 50, 250, 250);
        add(labelArte);

        // Texto de Resultado
        JLabel labelResultado = new JLabel("FIM DE JOGO!", SwingConstants.CENTER);
        labelResultado.setFont(new Font("Arial", Font.BOLD, 40));
        labelResultado.setBounds(0, 320, 1200, 50);
        add(labelResultado);

        // Texto de pontuação
        String textoPontuacao = "Parabéns, " + jogador.getNome() + "! Sua pontuação final foi: " + jogador.getPontuacao();
        JLabel labelPontuacao = new JLabel(textoPontuacao, SwingConstants.CENTER);
        labelPontuacao.setFont(new Font("Arial", Font.PLAIN, 22));
        labelPontuacao.setBounds(0, 370, 1200, 40);
        add(labelPontuacao);

        // --- VISUAL DOS BOTÕES ---

        // Botão Ver Ranking Solo
        JButton botaoVerRanking = new JButton("Ver Ranking Solo");
        botaoVerRanking.setBounds(380, 480, 200, 50);
        add(botaoVerRanking);

        // Botão Voltar ao menu
        JButton botaoVoltarMenu = new JButton("Voltar ao Menu");
        botaoVoltarMenu.setBounds(620, 480, 200, 50);
        add(botaoVoltarMenu);

        // --- AÇÂO DOS BOTÔES ---

        // Botão Ver Ranking Solo
        botaoVerRanking.addActionListener(e -> {
            telaPrincipal.iniciarTelaDeRanking("SOLO");
        });

        // Botão Voltar ao Menu
        botaoVoltarMenu.addActionListener(e -> {
            telaPrincipal.trocarTela("MENU");
        });
    }
}