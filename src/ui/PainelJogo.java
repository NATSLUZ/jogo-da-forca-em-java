package ui;

import modelo.Jogador;
import modelo.Rodada;
import modelo.Tema;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

 // PAINEL INTERATIVO ONDE O JOGO DA FORCA ACONTECE
public class PainelJogo extends JPanel {

    private final TelaPrincipal telaPrincipal;
    private final Jogador jogadorDaVez;
    private final Rodada rodadaAtual;

    private final JLabel labelPalavraVisivel;
    private final JLabel labelImagemForca;
    private final JLabel labelStatus;
    private final List<JButton> botoesTeclado = new ArrayList<>();

    // O construtor agora recebe o Tema também, para poder exibi-lo
    public PainelJogo(TelaPrincipal telaPrincipal, Jogador jogadorDaVez, Rodada rodadaAtual, Tema tema) {
        this.telaPrincipal = telaPrincipal;
        this.jogadorDaVez = jogadorDaVez;
        this.rodadaAtual = rodadaAtual;

        setLayout(null);
        setBackground(new Color(240, 248, 255));

        // --- COMPONENTES VISUAIS ---
        labelStatus = new JLabel();
        labelStatus.setFont(new Font("Arial", Font.BOLD, 20));
        labelStatus.setBounds(50, 20, 600, 30);
        add(labelStatus);

        JLabel labelTema = new JLabel("Tema: " + tema.getDescricao());
        labelTema.setFont(new Font("Arial", Font.ITALIC, 18));
        labelTema.setBounds(50, 50, 600, 30);
        add(labelTema);

        labelImagemForca = new JLabel();
        labelImagemForca.setBounds(100, 100, 300, 300);
        add(labelImagemForca);

        labelPalavraVisivel = new JLabel();

        // Lógica de tamanho dinânamico para palavra a ser adivinhada,
        // garante que a palavra vai caber na tela do jogo sem ser cortada.
        int tamanhoPalavra = rodadaAtual.getPalavraSecreta().length();
        int tamanhoFonte;

        if (tamanhoPalavra > 25) {
            tamanhoFonte = 20; // Para frases muito longas
        } else if (tamanhoPalavra > 15) {
            tamanhoFonte = 28; // Para palavras longas
        } else {
            tamanhoFonte = 40; // Tamanho padrão para palavras normais
        }
        labelPalavraVisivel.setFont(new Font("Monospaced", Font.BOLD, tamanhoFonte));
        labelPalavraVisivel.setBounds(450, 180, 700, 60);
        labelPalavraVisivel.setHorizontalAlignment(SwingConstants.LEFT);
        add(labelPalavraVisivel);

        // Dica vísivel para o modo Desafio
        if (rodadaAtual.getDica() != null) {
            JTextArea areaDica = new JTextArea("Dica: " + rodadaAtual.getDica());
            areaDica.setFont(new Font("Arial", Font.ITALIC, 16));
            areaDica.setWrapStyleWord(true);
            areaDica.setLineWrap(true);
            areaDica.setOpaque(false);
            areaDica.setEditable(false);
            areaDica.setFocusable(false);
            areaDica.setBounds(450, 250, 500, 80);
            add(areaDica);
        }

        // --- VISUAL DOS BOTÕES ---

        // Botão desistir e voltar
        JButton botaoDesistir = new JButton("Desistir e Voltar ao Menu");
        botaoDesistir.setBounds(475, 680, 250, 50);
        add(botaoDesistir);
        // Ação do botão Voltar
        botaoDesistir.addActionListener(e -> telaPrincipal.trocarTela("MENU"));

        // --- Teclado virtual ---
        JPanel painelTeclado = new JPanel(new GridLayout(4, 7, 8, 8));
        painelTeclado.setBounds(100, 450, 1000, 200);
        painelTeclado.setOpaque(false);

        for (char c = 'A'; c <= 'Z'; c++) {
            JButton botaoLetra = new JButton(String.valueOf(c));
            botaoLetra.setFont(new Font("Arial", Font.BOLD, 18));
            final char letra = c;
            botaoLetra.addActionListener(e -> cliqueLetra(letra, botaoLetra));
            botoesTeclado.add(botaoLetra);
            painelTeclado.add(botaoLetra);
        }
        add(painelTeclado);

        atualizarTela(); // Exibe o estado inicial
    }

    // Ação executada quando um botão de letra do teclado é clicado
    private void cliqueLetra(char letra, JButton botao) {
        rodadaAtual.tentarLetra(letra);
        botao.setEnabled(false);
        atualizarTela();
        if (rodadaAtual.isFimDeRodada()) {
            finalizarRodada();
        }
    }

    // Redesenha a tela para refletir o estado atual do jogo
    private void atualizarTela() {
        labelPalavraVisivel.setText(rodadaAtual.getPalavraVisivel());
        int erros = rodadaAtual.getTentativasErradas();

        // Arte da imagem da Forca
        String caminhoDaImagem = "recursos/img/forca/forca_" + erros + ".png";
        labelImagemForca.setIcon(new ImageIcon(caminhoDaImagem));
        labelStatus.setText("Vez de: " + jogadorDaVez.getNome() + " | Pontos na sessão: " + jogadorDaVez.getPontuacao());
    }

    // Executa as ações de fim de rodada (vitória ou derrota)
    private void finalizarRodada() {
        botoesTeclado.forEach(botao -> botao.setEnabled(false));
        String mensagemFinal;

        if (rodadaAtual.isPalavraDescoberta()) {
            telaPrincipal.jogadorAcertou();
            mensagemFinal = "Parabéns, " + jogadorDaVez.getNome() + "! Você acertou a palavra!";
        } else {
            mensagemFinal = "Que pena! A palavra era: " + rodadaAtual.getPalavraSecreta();
        }

        atualizarTela();
        JOptionPane.showMessageDialog(this, mensagemFinal, "Fim da Rodada", JOptionPane.INFORMATION_MESSAGE);
        telaPrincipal.proximaRodada();
    }
}