package ui;

import modelo.Jogador;
import modelo.Tema;

import javax.swing.*;
import java.awt.*;
import java.util.List;

//PAINEL PARA O JOGADOR SELECIONAR O TEMA DO JOGO
// Esta tela recebe a lista de jogadores da tela anterior.
public class PainelSelecaoTema extends PainelComFundo {

    private final TelaPrincipal telaPrincipal;
    private final List<Jogador> jogadores;

    public PainelSelecaoTema(TelaPrincipal telaPrincipal, List<Jogador> jogadores) {
        super("recursos/img/fundo_tema.png");

        this.telaPrincipal = telaPrincipal;
        this.jogadores = jogadores;
        setLayout(null);

        // Título
        JLabel labelTitulo = new JLabel("ESCOLHA UM TEMA", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 50));
        labelTitulo.setForeground(Color.BLACK); // Cor do texto alterada para bom contraste
        labelTitulo.setBounds(0, 150, 1200, 60);
        add(labelTitulo);

        // --- BOTÔES ---
        // Cria botões dinamicamente para cada tema do enum tema
        int yPos = 250;
        final int LARGURA_BOTAO = 250;
        final int X_BOTAO = (1200 / 2) - (LARGURA_BOTAO / 2);

        for (Tema tema : Tema.values()) {
            JButton botaoTema = new JButton(tema.getDescricao());
            botaoTema.setBounds(X_BOTAO, yPos, LARGURA_BOTAO, 50);
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