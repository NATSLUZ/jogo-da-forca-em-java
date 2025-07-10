package ui;

import modelo.Jogador;
import modelo.Ranking;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

// PAINEL PARA EXIBIR TELA DE RANKING
public class PainelRanking extends PainelComFundo {

    private final TelaPrincipal telaPrincipal;

    public PainelRanking(TelaPrincipal telaPrincipal, String modo) {
        super("recursos/img/fundo_ranking.png");

        this.telaPrincipal = telaPrincipal;
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setOpaque(false); // Importante para painéis com fundos customizados

        // Título da tela de Ranking
        String tituloStr = "RANKING - MODO " + modo.toUpperCase();
        JLabel labelTitulo = new JLabel(tituloStr, SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 40));
        labelTitulo.setForeground(Color.WHITE); // Cor do texto para contraste
        add(labelTitulo, BorderLayout.NORTH);

        // Define qual arquivo de ranking ler com base no modo
        String arquivoRanking = modo.equalsIgnoreCase("SOLO") ? "ranking_solo.txt" : "ranking_multi.txt";

        // Pega a lista de jogadores já ordenada
        Ranking ranking = new Ranking();
        List<Jogador> jogadores = ranking.getListaDeJogadoresOrdenados(arquivoRanking);

        // Criação da Tabela
        String[] colunas = {"Posição", "Nome", "Pontuação"};
        DefaultTableModel tableModel = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        int posicao = 1;
        int pontuacaoAnterior = -1;
        for (int i = 0; i < jogadores.size(); i++) {
            Jogador jogador = jogadores.get(i);
            if (jogador.getPontuacao() != pontuacaoAnterior) {
                posicao = i + 1;
            }
            tableModel.addRow(new Object[]{posicao + "º", jogador.getNome(), jogador.getPontuacao()});
            pontuacaoAnterior = jogador.getPontuacao();
        }

        JTable tabela = new JTable(tableModel);
        tabela.setFont(new Font("Arial", Font.PLAIN, 16));
        tabela.setRowHeight(25);

        tabela.setOpaque(false);
        ((JComponent)tabela.getDefaultRenderer(Object.class)).setOpaque(false);

        // Adiciona a tabela a um painel com sroll
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        add(scrollPane, BorderLayout.CENTER);

        // --- VISUAL DOS BOTÕES ---

        // Botão Voltar ao Menu
        JButton botaoVoltar = new JButton("Voltar ao Menu");
        // Ação do botão voltar
        botaoVoltar.addActionListener(e -> telaPrincipal.trocarTela("MENU"));

        // Adiciona um painel para o botão voltar
        JPanel painelBotao = new JPanel();
        painelBotao.setOpaque(false);
        painelBotao.add(botaoVoltar);
        add(painelBotao, BorderLayout.SOUTH);
    }
}
