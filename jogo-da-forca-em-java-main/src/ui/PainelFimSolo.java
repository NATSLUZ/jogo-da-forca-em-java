package ui;

import modelo.Jogador;
import javax.swing.*;
import java.awt.*;

//Painel que exibe o resultado final de uma partida solo
public class PainelFimSolo extends PainelComFundo {

    private final TelaPrincipal telaPrincipal;

    public PainelFimSolo(TelaPrincipal telaPrincipal, Jogador jogador) {
        super("recursos/img/fundo_fim_solo.png");

        this.telaPrincipal = telaPrincipal;
        setLayout(null);


        // Imagem de Fim de Jogo
        JLabel labelArte = new JLabel(new ImageIcon("recursos/img/fim_jogo.png"));
        labelArte.setBounds(775, 100, 250, 250);
        add(labelArte);

        // Texto de Resultado
        JLabel labelResultado = new JLabel("FIM DE JOGO!", SwingConstants.CENTER);
        labelResultado.setFont(new Font("Arial", Font.BOLD, 40));
        labelResultado.setBounds(0, 320, 600, 50);
        add(labelResultado);

        // Texto de pontuação
        String textoPontuacao = "Parabéns, " + jogador.getNome() + "! Sua pontuação final foi: " + jogador.getPontuacao();
        JLabel labelPontuacao = new JLabel(textoPontuacao, SwingConstants.CENTER);
        labelPontuacao.setFont(new Font("Arial", Font.PLAIN, 22));
        labelPontuacao.setBounds(0, 370, 600, 40); // Largura de 600
        add(labelPontuacao);

        // --- VISUAL DOS BOTÕES ---

        // Botão Ver Ranking
        JButton botaoVerRanking = new JButton("Ver Ranking Solo");
        botaoVerRanking.setBounds(90, 480, 200, 50); // Posição X ajustada para a esquerda
        add(botaoVerRanking);

        // Botão Voltar ao Menu
        JButton botaoVoltarMenu = new JButton("Voltar ao Menu");
        botaoVoltarMenu.setBounds(310, 480, 200, 50); // Posição X ajustada para a esquerda
        add(botaoVoltarMenu);

        // --- AÇÕES DOS BOTÕES ---

        // Botão Ver Ranking
        botaoVerRanking.addActionListener(e -> {
            telaPrincipal.iniciarTelaDeRanking("SOLO");
        });

        // Botão Voltar ao Menu
        botaoVoltarMenu.addActionListener(e -> {
            telaPrincipal.trocarTela("MENU");
        });
    }
}