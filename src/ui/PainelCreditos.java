package ui;

import javax.swing.*;
import java.awt.*;


// --- PAINEL QUE EXIBE OS CRÉDITOS DO JOGO ---
public class PainelCreditos extends PainelComFundo {

    private final TelaPrincipal telaPrincipal;

    public PainelCreditos(TelaPrincipal telaPrincipal) {
        super("recursos/img/fundo_creditos.png");
        this.telaPrincipal = telaPrincipal;
        setLayout(null);
        setBackground(new Color(245, 245, 245)); // Um cinza bem claro

        // Título da Tela
        JLabel labelTitulo = new JLabel("CRÉDITOS", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 50));
        labelTitulo.setBounds(0, 40, 800, 50);
        add(labelTitulo);
        

        // Campo Programadores
        JLabel labelProgTitulo = new JLabel("Programadores", SwingConstants.CENTER);
        labelProgTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        labelProgTitulo.setBounds(0, 300, 800, 30);
        add(labelProgTitulo);

        JLabel labelProgNomes = new JLabel("Natan Luz & Yude Lima", SwingConstants.CENTER);
        labelProgNomes.setFont(new Font("Arial", Font.PLAIN, 20));
        labelProgNomes.setBounds(0, 330, 800, 30);
        add(labelProgNomes);

        // Campo Artes
        JLabel labelArtesTitulo = new JLabel("Artes", SwingConstants.CENTER);
        labelArtesTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        labelArtesTitulo.setBounds(0, 390, 800, 30);
        add(labelArtesTitulo);

        JLabel labelArtesNomes = new JLabel("Diego Luz & Natan Luz", SwingConstants.CENTER);
        labelArtesNomes.setFont(new Font("Arial", Font.PLAIN, 20));
        labelArtesNomes.setBounds(0, 420, 800, 30);
        add(labelArtesNomes);

        // Campo Professor Orientador
        JLabel labelProfTitulo = new JLabel("Professor Orientador", SwingConstants.CENTER);
        labelProfTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        labelProfTitulo.setForeground(Color.BLACK);
        labelProfTitulo.setBounds(0, 150, 800, 30); // Posição Y ajustada
        add(labelProfTitulo);

        JLabel labelProfNome = new JLabel("Larissa Rocha", SwingConstants.CENTER);
        labelProfNome.setFont(new Font("Arial", Font.PLAIN, 24));
        labelProfNome.setForeground(Color.BLACK);
        labelProfNome.setBounds(0, 190, 800, 30); // Posição Y ajustada
        add(labelProfNome);

        // --- VISUAL DOS BOTÕES ---

        // Botão Voltar
        JButton botaoVoltar = new JButton("Voltar ao Menu");
        botaoVoltar.setBounds(300, 500, 200, 50);
        add(botaoVoltar);

        // --- AÇÃO DOS BOTÕES ---

        // Botão VOLTAR
        botaoVoltar.addActionListener(e -> {
            telaPrincipal.trocarTela("MENU");
        });
    }
}