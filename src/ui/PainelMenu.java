package ui;

import javax.swing.*;
import java.awt.Font;

// --- PAINEL DO MENU PRINCIPAL  ---
public class PainelMenu extends JPanel {

    private final TelaPrincipal telaPrincipal;

    public PainelMenu(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        this.setLayout(null);

        // Título
        JLabel labelTitulo = new JLabel("JOGO DA FORCA", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 50)); // Fonte um pouco maior para a tela maior
        labelTitulo.setBounds(0, 150, 1200, 60); // Posição Y ajustada para 150
        add(labelTitulo);

        // --- VISUAL DOS BOTÕES  ---

        // Botão Jogar
        JButton botaoJogar = new JButton("Jogar");
        botaoJogar.setBounds(500, 280, 200, 50); // X=500 (centro), Y=280
        add(botaoJogar);

        // Botão Ver Ranking
        JButton botaoRanking = new JButton("Ver Ranking");
        botaoRanking.setBounds(500, 350, 200, 50); // X=500, Y=350
        add(botaoRanking);

        // Botão Créditos
        JButton botaoCreditos = new JButton("Créditos");
        botaoCreditos.setBounds(500, 420, 200, 50); // X=500, Y=420
        add(botaoCreditos);

        // Botão Sair
        JButton botaoSair = new JButton("Sair");
        botaoSair.setBounds(500, 490, 200, 50); // X=500, Y=490
        add(botaoSair);

        // --- AÇÃO DOS BOTÕES ---

        // Botão Jogar
        botaoJogar.addActionListener(e -> {
            telaPrincipal.trocarTela("SELECAO_MODO");
        });

        // Botão Ver Ranking
        botaoRanking.addActionListener(e -> {
            telaPrincipal.trocarTela("SELECAO_RANKING");
        });

        // Botão Créditos
        botaoCreditos.addActionListener(e -> {
            telaPrincipal.trocarTela("CREDITOS");
        });

        // Botão Sair
        botaoSair.addActionListener(e -> {
            System.exit(0);
        });
    }
}