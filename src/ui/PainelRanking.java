package ui;

import modelo.Jogador;
import modelo.Ranking;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

// PAINEL PARA EXIBIR TELA DE RANKING
public class PainelRanking extends JPanel {

    private final TelaPrincipal telaPrincipal;

    public PainelRanking(TelaPrincipal telaPrincipal, String modo) {
        this.telaPrincipal = telaPrincipal;
        setLayout(new BorderLayout(10, 10)); // Usaremos BorderLayout aqui

        // Título da tela de Ranking
        String tituloStr = "RANKING - MODO " + modo.toUpperCase();
        JLabel labelTitulo = new JLabel(tituloStr, SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 30));
        add(labelTitulo, BorderLayout.NORTH);

        // Define qual arquivo de ranking ler com base no modo
        String arquivoRanking = modo.equalsIgnoreCase("SOLO") ? "ranking_solo.txt" : "ranking_multi.txt";

        // Pega a lista de jogadores já ordenada
        Ranking ranking = new Ranking();
        List<Jogador> jogadores = ranking.getListaDeJogadoresOrdenados(arquivoRanking);

        // Criação da Tabela
        String[] colunas = {"Posição", "Nome", "Pontuação"};
        DefaultTableModel tableModel = new DefaultTableModel(colunas, 0); // 0 linhas iniciais

        int posicao = 1;
        for (Jogador jogador : jogadores) {
            tableModel.addRow(new Object[]{posicao + "º", jogador.getNome(), jogador.getPontuacao()});
            posicao++;
        }

        JTable tabela = new JTable(tableModel);
        tabela.setFont(new Font("Arial", Font.PLAIN, 16));
        tabela.setRowHeight(25);

        // Adiciona a tabela a um painel com sroll
        JScrollPane scrollPane = new JScrollPane(tabela);
        add(scrollPane, BorderLayout.CENTER);

        // --- VISUAL DOS BOTÕES ---

        // Botão Voltar
        JButton botaoVoltar = new JButton("Voltar ao Menu");
        // Ação do botão voltar
        botaoVoltar.addActionListener(e -> telaPrincipal.trocarTela("MENU"));

        // Adiciona um painel para o botão voltar
        JPanel painelSul = new JPanel();
        painelSul.add(botaoVoltar);
        add(painelSul, BorderLayout.SOUTH);
    }
}
