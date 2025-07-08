package ui;

import modelo.Jogador;

import javax.swing.*;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

// PAINEL PARA INSERIR NOME DE JOGADOR SOLO
public class PainelNomeJogador extends JPanel {

    private final TelaPrincipal telaPrincipal;

    public PainelNomeJogador(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        setLayout(null);

        // Título
        JLabel labelTitulo = new JLabel("MODO SOLO", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 50));
        labelTitulo.setBounds(0, 150, 1200, 60);
        add(labelTitulo);

        // Campo de Texto para o Nome
        JLabel labelNome = new JLabel("Digite seu nome:");
        labelNome.setFont(new Font("Arial", Font.PLAIN, 20));
        labelNome.setBounds(500, 250, 200, 30);
        add(labelNome);

        JTextField campoNome = new JTextField();
        campoNome.setFont(new Font("Arial", Font.PLAIN, 20));
        campoNome.setBounds(500, 280, 200, 40);
        add(campoNome);

        // --- VISUAL DOS BOTÕES ---

        // Botão Continuar.
        JButton botaoContinuar = new JButton("Continuar");
        botaoContinuar.setBounds(500, 340, 200, 50);
        add(botaoContinuar);

        // Botão Voltar.
        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setBounds(500, 400, 200, 50);
        add(botaoVoltar);

        // --- AÇÃO DOS BOTÕES ---

        // Botão Continuar.
        botaoContinuar.addActionListener(e -> {
            String nomeJogador = campoNome.getText();
            if (nomeJogador != null && !nomeJogador.trim().isEmpty()) {
                // Cria uma LISTA de jogadores, mesmo que só tenha um.
                List<Jogador> jogadores = new ArrayList<>();
                jogadores.add(new Jogador(nomeJogador));

                // Pede para a TelaPrincipal iniciar a próxima etapa (seleção de tema),
                // passando a LISTA de jogadores.
                telaPrincipal.iniciarSelecaoDeTema(jogadores);
            } else {
                JOptionPane.showMessageDialog(this, "O nome não pode ser vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Botão Voltar
        botaoVoltar.addActionListener(e -> {
            telaPrincipal.trocarTela("SELECAO_MODO");
        });
    }
}
