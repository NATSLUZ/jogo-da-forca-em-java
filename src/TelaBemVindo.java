import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaBemVindo extends JFrame {
    public TelaBemVindo() {
        setTitle("Jogo da Forca");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela

        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Bem-vindo ao Jogo da Forca!", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        painel.add(titulo, BorderLayout.NORTH);

        JLabel mensagem = new JLabel("<html><div style='text-align: center;'>Tente adivinhar a palavra escondida<br>antes de ser enforcado!</div></html>", JLabel.CENTER);
        painel.add(mensagem, BorderLayout.CENTER);

        JButton botaoIniciar = new JButton("Iniciar Jogo");
        botaoIniciar.setFont(new Font("Arial", Font.PLAIN, 16));
        botaoIniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "O jogo será iniciado...");
                // Aqui você pode abrir a próxima tela
            }
        });

        JPanel painelBotao = new JPanel();
        painelBotao.add(botaoIniciar);
        painel.add(painelBotao, BorderLayout.SOUTH);

        add(painel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaBemVindo();
    }
}
