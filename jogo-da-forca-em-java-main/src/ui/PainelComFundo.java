package ui;

import javax.swing.*;
import java.awt.*;

// JPANEL CUSTOMINZADO QUE DESENHA A IMAGEM DE FUNDO
public class PainelComFundo extends JPanel {

    private Image imagemDeFundo;

    //Construtor que recebe o caminho da imagem de fundo.
    public PainelComFundo(String caminhoImagem) {
        // Carrega a imagem a partir do caminho fornecido
        this.imagemDeFundo = new ImageIcon(caminhoImagem).getImage();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Desenha a imagem de fundo, para preencher o painel
        g.drawImage(imagemDeFundo, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
