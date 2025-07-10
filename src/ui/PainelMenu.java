package ui;

import javax.swing.*;
import java.awt.*;

// --- PAINEL DO MENU PRINCIPAL  ---
public class PainelMenu extends JPanel {

    private final TelaPrincipal telaPrincipal;

    public PainelMenu(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        this.setLayout(new BorderLayout());

        PainelComFundo painelDeFundo = new PainelComFundo("recursos/img/fundo_menu.png");
        painelDeFundo.setLayout(null); // O painel interno continua com layout nulo para os botões.

        // Título
        JLabel labelTitulo = new JLabel("JOGO DA FORCA", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 50));
        labelTitulo.setForeground(Color.BLACK); // Sugestão: Cor branca para contrastar bem com a imagem de fundo
        labelTitulo.setBounds(0, 150, 1200, 60);
        painelDeFundo.add(labelTitulo);

        // --- VISUAL DOS BOTÕES  ---

        // Botão Jogar
        JButton botaoJogar = new JButton("Jogar");
        botaoJogar.setBounds(500, 280, 200, 50);
        painelDeFundo.add(botaoJogar);

        // Botão Ver Ranking
        JButton botaoRanking = new JButton("Ver Ranking");
        botaoRanking.setBounds(500, 350, 200, 50);
        painelDeFundo.add(botaoRanking);

        // Botão Créditos
        JButton botaoCreditos = new JButton("Créditos");
        botaoCreditos.setBounds(500, 420, 200, 50);
        painelDeFundo.add(botaoCreditos);

        // Botão Sair
        JButton botaoSair = new JButton("Sair");
        botaoSair.setBounds(500, 490, 200, 50);
        painelDeFundo.add(botaoSair);

        this.add(painelDeFundo, BorderLayout.CENTER);

        // --- AÇÃO DOS BOTÕES  ---

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