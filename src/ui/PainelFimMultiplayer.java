package ui;

import modelo.Jogador;

import javax.swing.*;
import java.awt.*;
import java.util.List;


// --- PAINEL DE RESULTADO DE PARTIDA DO MODO MULTIPLAYER  ---
public class PainelFimMultiplayer extends JPanel {

    private final TelaPrincipal telaPrincipal;

    public PainelFimMultiplayer(TelaPrincipal telaPrincipal, List<Jogador> jogadores) {
        this.telaPrincipal = telaPrincipal;
        setLayout(null);
        setBackground(new Color(230, 240, 255));

        // Pega os dois jogadores da lista
        Jogador jogador1 = jogadores.get(0);
        Jogador jogador2 = jogadores.get(1);

        // Lógica para determinar o texto do resultado
        String textoResultado;
        if (jogador1.getPontuacao() > jogador2.getPontuacao()) {
            textoResultado = "O vencedor é " + jogador1.getNome() + "!";
        } else if (jogador2.getPontuacao() > jogador1.getPontuacao()) {
            textoResultado = "O vencedor é " + jogador2.getNome() + "!";
        } else {
            textoResultado = "A partida terminou em EMPATE!";
        }

        // Imagem de arte da tela Fim de Jogo Multiplayer
        JLabel labelArte = new JLabel(new ImageIcon("recursos/img/fim_jogo.png"));
        labelArte.setBounds(475, 50, 250, 250);
        add(labelArte);

        // Texto de Resultado
        JLabel labelVencedor = new JLabel(textoResultado, SwingConstants.CENTER);
        labelVencedor.setFont(new Font("Arial", Font.BOLD, 35));
        labelVencedor.setBounds(0, 320, 1200, 50);
        add(labelVencedor);

        // Placar Final
        String placar = jogador1.getNome() + ": " + jogador1.getPontuacao() + " pontos   vs   " + jogador2.getNome() + ": " + jogador2.getPontuacao() + " pontos";
        JLabel labelPlacar = new JLabel(placar, SwingConstants.CENTER);
        labelPlacar.setFont(new Font("Arial", Font.PLAIN, 20));
        labelPlacar.setBounds(0, 370, 1200, 40);
        add(labelPlacar);

        // --- VISUAL DOS BOTÕES ---

        // Botão Ver Ranking
        JButton botaoVerRanking = new JButton("Ver Ranking Multi");
        botaoVerRanking.setBounds(380, 480, 200, 50);
        add(botaoVerRanking);

        // Botão Voltar ao menu
        JButton botaoVoltarMenu = new JButton("Voltar ao Menu");
        botaoVoltarMenu.setBounds(620, 480, 200, 50);
        add(botaoVoltarMenu);

        // --- AÇÃO DOS BOTÕES ---

        // Botão Ver Ranking.
        botaoVerRanking.addActionListener(e -> {
            telaPrincipal.iniciarTelaDeRanking("MULTIPLAYER");
        });

        // Botão Voltar ao Menu
        botaoVoltarMenu.addActionListener(e -> {
            telaPrincipal.trocarTela("MENU");
        });
    }
}