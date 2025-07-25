package ui;

import modelo.Jogador;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// PAINEL PARA INSERIR NOME DE JOGADOR MULTIPLAYER
public class PainelNomesMultiplayer extends JPanel {

    private final TelaPrincipal telaPrincipal;

    public PainelNomesMultiplayer(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        this.setLayout(new BorderLayout());

        PainelComFundo painelDeFundo = new PainelComFundo("recursos/img/fundo_multiplayer.png");
        painelDeFundo.setLayout(null); // O painel interno continua com layout nulo


        // Título
        JLabel labelTitulo = new JLabel("MODO MULTIPLAYER", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 50));
        labelTitulo.setForeground(Color.BLACK); // Cor do texto para contraste
        labelTitulo.setBounds(0, 100, 1200, 60);
        painelDeFundo.add(labelTitulo);

        // Jogador 1
        JLabel labelNome1 = new JLabel("Nome do Jogador 1:");
        labelNome1.setFont(new Font("Arial", Font.PLAIN, 20));
        labelNome1.setForeground(Color.BLACK);
        labelNome1.setBounds(500, 200, 200, 30);
        painelDeFundo.add(labelNome1);

        JTextField campoNome1 = new JTextField();
        campoNome1.setFont(new Font("Arial", Font.PLAIN, 20));
        campoNome1.setBounds(500, 230, 200, 40);
        painelDeFundo.add(campoNome1);

        // Jogador 2
        JLabel labelNome2 = new JLabel("Nome do Jogador 2:");
        labelNome2.setFont(new Font("Arial", Font.PLAIN, 20));
        labelNome2.setForeground(Color.BLACK);
        labelNome2.setBounds(500, 290, 200, 30);
        painelDeFundo.add(labelNome2);

        JTextField campoNome2 = new JTextField();
        campoNome2.setFont(new Font("Arial", Font.PLAIN, 20));
        campoNome2.setBounds(500, 320, 200, 40);
        painelDeFundo.add(campoNome2);

        // --- VISUAL DOS BOTÕES ---

        // Botão Continuar
        JButton botaoContinuar = new JButton("Continuar");
        botaoContinuar.setBounds(500, 380, 200, 50);
        painelDeFundo.add(botaoContinuar);

        // Botão Voltar
        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setBounds(500, 440, 200, 50);
        painelDeFundo.add(botaoVoltar);

        this.add(painelDeFundo, BorderLayout.CENTER);

        // --- AÇÃO DOS BOTÕES ---

        // Botão Continuar
        botaoContinuar.addActionListener(e -> {
            String nome1 = campoNome1.getText();
            String nome2 = campoNome2.getText();

            // Verifica se ambos os nomes foram preenchidos
            if (!nome1.trim().isEmpty() && !nome2.trim().isEmpty()) {
                List<Jogador> jogadores = new ArrayList<>();
                jogadores.add(new Jogador(nome1));
                jogadores.add(new Jogador(nome2));

                // Pede para a TelaPrincipal iniciar a próxima etapa (seleção de tema),
                // passando a lista com os DOIS jogadores.
                telaPrincipal.iniciarSelecaoDeTema(jogadores);
            } else {
                JOptionPane.showMessageDialog(this, "Ambos os nomes devem ser preenchidos.",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Botão Voltar
        botaoVoltar.addActionListener(e -> {
            // Volta para a tela de seleção de modo
            telaPrincipal.trocarTela("SELECAO_MODO");
        });
    }
}