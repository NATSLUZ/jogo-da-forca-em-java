package ui;

import javax.swing.*;
import java.awt.*;

// PAINEL DE SELEÇÃO DE MODO DE JOGO
public class PainelSelecaoModo extends JPanel {

    private final TelaPrincipal telaPrincipal;

    public PainelSelecaoModo(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        this.setLayout(new BorderLayout());

        PainelComFundo painelDeFundo = new PainelComFundo("recursos/img/fundo_selecao_modo.png");
        painelDeFundo.setLayout(null); // O painel interno continua com layout nulo.


        // Título
        JLabel labelTitulo = new JLabel("MODOS DE JOGO", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 50));
        labelTitulo.setForeground(Color.BLACK); // Sugestão de cor para contrastar
        labelTitulo.setBounds(0, 150, 1200, 60);
        painelDeFundo.add(labelTitulo);

        // ---VISUAL DOS BOTÕES ---


        // Botão Modo Solo
        JButton botaoSolo = new JButton("Modo Solo");
        botaoSolo.setBounds(500, 280, 200, 50);
        painelDeFundo.add(botaoSolo);

        // Botão Modo Multiplayer
        JButton botaoMultiplayer = new JButton("Modo Multiplayer");
        botaoMultiplayer.setBounds(500, 350, 200, 50);
        painelDeFundo.add(botaoMultiplayer);

        // Botão Voltar
        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setBounds(500, 420, 200, 50);
        painelDeFundo.add(botaoVoltar);

        this.add(painelDeFundo, BorderLayout.CENTER);

        // --- AÇÃO DOS BOTÕES ---

        // Botão Voltar
        botaoVoltar.addActionListener(e -> {
            telaPrincipal.trocarTela("MENU");
        });

        // Botão Modo Solo
        botaoSolo.addActionListener(e -> {
            telaPrincipal.trocarTela("NOME_JOGADOR");
        });

        // Botão Multiplayer
        botaoMultiplayer.addActionListener(e -> {
            telaPrincipal.trocarTela("NOMES_MULTIPLAYER");
        });
    }
}