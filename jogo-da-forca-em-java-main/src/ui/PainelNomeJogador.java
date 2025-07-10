package ui;

import modelo.Jogador;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// PAINEL PARA INSERIR NOME DE JOGADOR SOLO
public class PainelNomeJogador extends JPanel {

    private final TelaPrincipal telaPrincipal;

    public PainelNomeJogador(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        this.setLayout(new BorderLayout());

        PainelComFundo painelDeFundo = new PainelComFundo("recursos/img/fundo_nome_solo.png");
        painelDeFundo.setLayout(null);

        // Título
        JLabel labelTitulo = new JLabel("MODO SOLO", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 50));
        labelTitulo.setForeground(Color.BLACK); // Cor do texto para contraste
        labelTitulo.setBounds(0, 150, 1200, 60);
        painelDeFundo.add(labelTitulo);

        // Campo de Texto para o Nome
        JLabel labelNome = new JLabel("Digite seu nome:");
        labelNome.setFont(new Font("Arial", Font.PLAIN, 20));
        labelNome.setForeground(Color.BLACK);
        labelNome.setBounds(500, 250, 200, 30);
        painelDeFundo.add(labelNome);

        JTextField campoNome = new JTextField();
        campoNome.setFont(new Font("Arial", Font.PLAIN, 20));
        campoNome.setBounds(500, 280, 200, 40);
        painelDeFundo.add(campoNome);

        // --- VISUAL DOS BOTÕES ---

        // Botão Continuar
        JButton botaoContinuar = new JButton("Continuar");
        botaoContinuar.setBounds(500, 340, 200, 50);
        painelDeFundo.add(botaoContinuar);

        // Botão Voltar
        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setBounds(500, 400, 200, 50);
        painelDeFundo.add(botaoVoltar);

        this.add(painelDeFundo, BorderLayout.CENTER);

        // --- AÇÃO DOS BOTÕES ---

        // Botão Continuar
        botaoContinuar.addActionListener(e -> {
            String nomeJogador = campoNome.getText();
            if (nomeJogador != null && !nomeJogador.trim().isEmpty()) {
                List<Jogador> jogadores = new ArrayList<>();
                jogadores.add(new Jogador(nomeJogador));
                telaPrincipal.iniciarSelecaoDeTema(jogadores);
            } else {
                JOptionPane.showMessageDialog(this, "O nome não pode ser vazio.", "Erro",
                            JOptionPane.ERROR_MESSAGE);
            }
        });

        // Botão Voltar
        botaoVoltar.addActionListener(e -> {
            telaPrincipal.trocarTela("SELECAO_MODO");
        });
    }
}