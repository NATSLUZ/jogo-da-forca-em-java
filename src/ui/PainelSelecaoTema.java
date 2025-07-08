package ui;

import modelo.Jogador;
import modelo.Tema;

import javax.swing.*;
import java.awt.*;
import java.util.List;

//PAINEL PARA O JOGADOR SELECIONAR O TEMA DO JOGO
// Esta tela recebe a lista de jogadores da tela anterior.

public class PainelSelecaoTema extends JPanel {

    private final TelaPrincipal telaPrincipal;
    private final List<Jogador> jogadores;

    public PainelSelecaoTema(TelaPrincipal telaPrincipal, List<Jogador> jogadores) {
        this.telaPrincipal = telaPrincipal;
        this.jogadores = jogadores; // Guarda a lista de jogadores recebida
        setLayout(null);

        // Título
        JLabel labelTitulo = new JLabel("ESCOLHA UM TEMA");
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 50));
        labelTitulo.setBounds(350, 150, 500, 50);
        add(labelTitulo);

        // --- BOTÔES ---
        // Cria botões dinamicamente para cada tema do enum tema
        int yPos = 250; // Posição Y inicial do primeiro botão
        for (Tema tema : Tema.values()) {
            JButton botaoTema = new JButton(tema.getDescricao());
            botaoTema.setBounds(500, yPos, 200, 50);
            add(botaoTema);

            // Cada botão chama o mesmo método, passando o tema correspondente
            botaoTema.addActionListener(e -> iniciarJogoComTema(tema));

            yPos += 70; // Aumenta a posição Y para o próximo botão
        }
    }

    // Método auxiliar que é chamado quando um botão de tema é clicado.
    private void iniciarJogoComTema(Tema tema) {
        System.out.println("Jogadores prontos. Tema escolhido: " + tema.name());
        // Chama o método na TelaPrincipal
        telaPrincipal.iniciarNovoJogo(this.jogadores, tema);
    }
}