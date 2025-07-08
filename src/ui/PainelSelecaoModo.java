package ui;

import javax.swing.*;
import java.awt.Font;


// PAINEL DE SELEÇÃO DE MODO DE JOGO
public class PainelSelecaoModo extends JPanel {

    private final TelaPrincipal telaPrincipal;

    public PainelSelecaoModo(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        setLayout(null);

        // Título
        JLabel labelTitulo = new JLabel("MODOS DE JOGO", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 50));
        labelTitulo.setBounds(0, 150, 1200, 60);
        add(labelTitulo);

        // ---VISUAL DOS BOTÕES ---

        // Botão Modo Solo
        JButton botaoSolo = new JButton("Modo Solo");
        botaoSolo.setBounds(500, 280, 200, 50);
        add(botaoSolo);

        // Botão Modo Multiplayer
        JButton botaoMultiplayer = new JButton("Modo Multiplayer");
        botaoMultiplayer.setBounds(500, 350, 200, 50);
        add(botaoMultiplayer);

        // Botão Voltar
        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setBounds(500, 420, 200, 50);
        add(botaoVoltar);

        // --- AÇÃO DOS BOTÕES ---

        // Botão Voltar
        botaoVoltar.addActionListener(e -> {
            telaPrincipal.trocarTela("MENU");
        });

        // Botão Modo Solo
        botaoSolo.addActionListener(e -> {
            // Em vez de um JOptionPane, agora trocamos para a nossa tela customizada.
            telaPrincipal.trocarTela("NOME_JOGADOR");
        });

        // Botão Multiplayer
        botaoMultiplayer.addActionListener(e -> {
            // Em vez de um JOptionPane, agora trocamos para a nossa tela de inserir nomes.
            telaPrincipal.trocarTela("NOMES_MULTIPLAYER");
        });
    }
}
