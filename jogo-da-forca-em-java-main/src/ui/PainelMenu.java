package ui;

import javax.swing.*;
import java.awt.*;

// PAINEL DO MENU PRINCIPAL
public class PainelMenu extends JPanel {

    private final TelaPrincipal telaPrincipal;

    public PainelMenu(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        this.setLayout(new BorderLayout());

        PainelComFundo painelDeFundo = new PainelComFundo("recursos/img/fundo_menu.png");
        painelDeFundo.setLayout(null);

        // Título
        JLabel labelTitulo = new JLabel("JOGO DA FORCA", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 50));
        labelTitulo.setForeground(Color.BLACK); // Mudei para branco para melhor contraste
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

        // Botão Tutorial
        JButton botaoTutorial = new JButton("Tutorial");
        botaoTutorial.setBounds(500, 420, 200, 50); // Posição Y ajustada
        painelDeFundo.add(botaoTutorial);

        // Botão Créditos
        JButton botaoCreditos = new JButton("Créditos");
        botaoCreditos.setBounds(500, 490, 200, 50); // Posição Y ajustada para baixo
        painelDeFundo.add(botaoCreditos);

        // Botão Sair
        JButton botaoSair = new JButton("Sair");
        botaoSair.setBounds(500, 560, 200, 50); // Posição Y ajustada para baixo
        painelDeFundo.add(botaoSair);

        // --- BOTÃO DE MÚSICA ---
        final boolean[] musicaTocando = {true};

        JButton botaoMusica = new JButton("Música: ON");
        botaoMusica.setFont(new Font("Arial", Font.PLAIN, 12));
        // Posiciona o botão no canto superior direito da tela
        botaoMusica.setBounds(1060, 20, 110, 40);
        painelDeFundo.add(botaoMusica);

        this.add(painelDeFundo, BorderLayout.CENTER);

        // --- AÇÃO DOS BOTÕES ---

        // Botão Jogar
        botaoJogar.addActionListener(e ->
                telaPrincipal.trocarTela("SELECAO_MODO"));

        //Botão Ver Ranking
        botaoRanking.addActionListener(e ->
                telaPrincipal.trocarTela("SELECAO_RANKING"));

        // Botão Tutorial
        botaoTutorial.addActionListener(e ->
                telaPrincipal.trocarTela("TUTORIAL"));

        // Botão Créditos
        botaoCreditos.addActionListener(e ->
                telaPrincipal.trocarTela("CREDITOS"));

        // Botão Sair
        botaoSair.addActionListener(e -> System.exit(0));

        // Botão Música
        botaoMusica.addActionListener(e -> {
            if (musicaTocando[0]) {
                // Se a música está tocando, pede para a TelaPrincipal parar
                telaPrincipal.pararMusicaDeFundo();
                botaoMusica.setText("Música: OFF");
                musicaTocando[0] = false;
            } else {
                // Se a música está parada, pede para a TelaPrincipal tocar
                telaPrincipal.tocarMusicaDeFundo();
                botaoMusica.setText("Música: ON");
                musicaTocando[0] = true;
            }
        });

    }
}