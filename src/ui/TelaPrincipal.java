package ui;

import sound.GerenciadorDeAudio;
import jogo.JogoDaForca;
import jogo.JogoMultiplayer;
import jogo.JogoSolo;
import modelo.Jogador;
import modelo.Rodada;
import modelo.Tema;

import javax.swing.*;
import java.awt.*;
import java.util.List;


//PAINEL PRINCIPAL, GERENCIA OS PAINÉIS (TELAS) DO JOGO
public class TelaPrincipal extends JFrame {

    private final CardLayout cardLayout;
    private final JPanel painelPrincipal;

    // Atributo que segura a instância da SESSÃO DE JOGO ATIVA.
    private JogoDaForca jogoAtual;
    // Atributo para "lembrar" o tema da sessão atual
    private Tema temaAtual;

    // Gerenciador de áudio
    private final GerenciadorDeAudio gerenciadorDeAudio;

    // Tela principal
    public TelaPrincipal() {
        setTitle("Jogo da Forca");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // --- INICIALIZAÇÃO DA MÚSICA  ---
        this.gerenciadorDeAudio = new GerenciadorDeAudio();
        this.gerenciadorDeAudio.tocarMusica("recursos/audio/musica_fundo.wav");

        cardLayout = new CardLayout();
        painelPrincipal = new JPanel(cardLayout);

        // Cria e adiciona os painéis de navegação
        painelPrincipal.add(new PainelMenu(this), "MENU");
        painelPrincipal.add(new PainelSelecaoModo(this), "SELECAO_MODO");
        painelPrincipal.add(new PainelNomeJogador(this), "NOME_JOGADOR");
        painelPrincipal.add(new PainelNomesMultiplayer(this), "NOMES_MULTIPLAYER");
        painelPrincipal.add(new PainelSelecaoRanking(this), "SELECAO_RANKING");
        painelPrincipal.add(new PainelCreditos(this), "CREDITOS");
        painelPrincipal.add(new PainelTutorial(this), "TUTORIAL");

        add(painelPrincipal);
    }

    // Métodos de Controle da Música
    public void pararMusicaDeFundo() {
        if (gerenciadorDeAudio != null) {
            gerenciadorDeAudio.pararMusica();
        }
    }

    public void tocarMusicaDeFundo() {
        if (gerenciadorDeAudio != null) {
            gerenciadorDeAudio.tocarMusica("recursos/audio/musica_fundo.wav");
        }
    }

    // Inicia uma nova sessão de jogo. É chamado quando um tema é escolhido
    public void iniciarNovoJogo(List<Jogador> jogadores, Tema tema) {
        // 1. Guarda o tema da sessão atual
        this.temaAtual = tema;

        // 2. Decide qual gerenciador de sessão criar
        this.jogoAtual = (jogadores.size() == 1) ? new JogoSolo() : new JogoMultiplayer();

        // 3. Prepara a sessão com os dados recebidos
        this.jogoAtual.setJogadores(jogadores);
        this.jogoAtual.prepararSessao(this.temaAtual);

        // 4. Pede para iniciar a primeira rodada
        proximaRodada();
    }

    // Pede ao gerenciador de sessão pela próxima rodada e atualiza a tela.
    public void proximaRodada() {
        // Exibe tela de fim de jogo
        if (jogoAtual.isSessaoTerminada()) {
            jogoAtual.finalizarSessao(); // Salva o ranking

            // Verifica se o jogo que acabou era solo para mostrar a tela correta
            if (jogoAtual instanceof JogoSolo) {
                PainelFimSolo painelFim = new PainelFimSolo(this, jogoAtual.getJogadorDaVez());
                painelPrincipal.add(painelFim, "FIM_SOLO");
                trocarTela("FIM_SOLO");
            } else if (jogoAtual instanceof JogoMultiplayer) {
                // Se era multiplayer, cria e mostra a tela de fim de jogo multiplayer
                PainelFimMultiplayer painelFim = new PainelFimMultiplayer(this, jogoAtual.getJogadores());
                painelPrincipal.add(painelFim, "FIM_MULTIPLAYER");
                trocarTela("FIM_MULTIPLAYER");
            }
            return;
        }

        // Se não terminou, pede a próxima rodada ao gerenciador
        Rodada rodada = jogoAtual.proximaRodada();

        if (rodada != null) {
            // Cria um novo painel de jogo, passando todas as informações necessárias
            PainelJogo painelJogo = new PainelJogo(this, jogoAtual.getJogadorDaVez(), rodada, this.temaAtual);
            painelPrincipal.add(painelJogo, "JOGO");
            trocarTela("JOGO");
        } else {
            // Caso de segurança: as palavras do tema acabaram
            jogoAtual.finalizarSessao();
            JOptionPane.showMessageDialog(this, "Fim de Jogo! As palavras do tema acabaram.",
                    "Fim de Sessão", JOptionPane.INFORMATION_MESSAGE);
            trocarTela("MENU");
        }
    }

    // Permite que o PainelJogo informe que o jogador da vez pontuou.
    public void jogadorAcertou() {
        if (jogoAtual != null && jogoAtual.getJogadorDaVez() != null) {
            jogoAtual.getJogadorDaVez().adicionarPonto();
        }
    }

    // --- MÉTODOS DE NAVEGAÇÃO ---
    public void trocarTela(String nomeDoPainel) {
        cardLayout.show(painelPrincipal, nomeDoPainel);
    }

    public void iniciarSelecaoDeTema(List<Jogador> jogadores) {
        PainelSelecaoTema painelTema = new PainelSelecaoTema(this, jogadores);
        painelPrincipal.add(painelTema, "SELECAO_TEMA");
        trocarTela("SELECAO_TEMA");
    }

    public void iniciarTelaDeRanking(String modo) {
        PainelRanking painelRanking = new PainelRanking(this, modo);
        String nomeDoPainel = "RANKING_" + modo.toUpperCase();
        painelPrincipal.add(painelRanking, nomeDoPainel);
        trocarTela(nomeDoPainel);
    }
}