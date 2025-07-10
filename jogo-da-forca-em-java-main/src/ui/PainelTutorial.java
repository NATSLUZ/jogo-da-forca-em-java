package ui;

import javax.swing.*;
import java.awt.*;

// PAINEL DE TUTORIAL (COMO JOGAR O JOGO)
public class PainelTutorial extends PainelComFundo {

    private final TelaPrincipal telaPrincipal;

    public PainelTutorial(TelaPrincipal telaPrincipal) {
        super("recursos/img/fundo_tutorial.png");

        this.telaPrincipal = telaPrincipal;
        setLayout(null);

        // Título
        JLabel labelTitulo = new JLabel("COMO JOGAR", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 50));
        labelTitulo.setForeground(Color.BLACK);
        labelTitulo.setBounds(0, 80, 1200, 60);
        add(labelTitulo);

        // Área de texto
        JTextArea areaTexto = new JTextArea();
        areaTexto.setFont(new Font("Arial", Font.PLAIN, 22));
        areaTexto.setForeground(Color.BLACK);

        // Configurações para fazer o JTextArea parecer um JLabel
        areaTexto.setWrapStyleWord(true);
        areaTexto.setLineWrap(true);
        areaTexto.setOpaque(false);
        areaTexto.setEditable(false);
        areaTexto.setFocusable(false);

        // Texto
        areaTexto.setText(
                "Bem-vindo ao Jogo da Forca!\n\n" +
                        "• O jogo pode ser jogado no modo solo ou multiplayer.\n\n" +
                        "• O objetivo é evitar que o estudante da UNEB seja enforcado, para isso vc precisa" +
                        " adivinhar a palavra ou frase secreta, letra por letra, antes que seja tarde demais.\n\n" +
                        "• Uma sessão de jogo no modo solo é composta por 5 rodadas. No modo multiplayer, são 10 rodadas no total (5 para cada jogador).\n\n" +
                        "• Para um desafio extra, experimente o 'Modo Desafio', com palavras grandes e frases famosas que testarão seu conhecimento!"
        );

        areaTexto.setBounds(200, 200, 800, 350);
        add(areaTexto);

        // VISUAL DOS BOTÕES

        // Botão Voltar
        JButton botaoVoltar = new JButton("Voltar ao Menu");
        botaoVoltar.setBounds(500, 600, 200, 50);
        add(botaoVoltar);

        // --- AÇÃO DOS BOTÕES ---
        botaoVoltar.addActionListener(e -> telaPrincipal.trocarTela("MENU"));
    }
}
