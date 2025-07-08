package ui;

import javax.swing.*;
import java.awt.*;


// --- PAINEL QUE EXIBE OS CRÉDITOS DO JOGO ---
public class PainelCreditos extends JPanel {

    private final TelaPrincipal telaPrincipal;

    public PainelCreditos(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        setLayout(null);
        setBackground(new Color(245, 245, 245)); // Um cinza bem claro

        // Título da Tela
        JLabel labelTitulo = new JLabel("CRÉDITOS", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 50));
        labelTitulo.setBounds(0, 40, 800, 50);
        add(labelTitulo);

        // Imagem de Arte (Placeholder)
        JLabel labelArte = new JLabel(new ImageIcon("recursos/img/creditos_arte.png"));
        labelArte.setBounds(275, 100, 250, 180);
        add(labelArte);

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