package modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ranking {

    // Salva a pontuação do jogado em uma arquivo
    public void adicionarPontuacao(Jogador jogador, String nomeArquivo){
        try (FileWriter fileWriter = new FileWriter(nomeArquivo, true);
             PrintWriter printWriter = new PrintWriter(fileWriter)){

            // "NOME, PONTUAÇÂO"
            printWriter.println(jogador.getNome() + "," + jogador.getPontuacao());
        } catch (IOException e){
            System.err.println("ERRO ao salvar no ranking: " + e.getMessage());
        }
    }

    // Lê o arquivo e ordena os jogadores
    public List<Jogador> getListaDeJogadoresOrdenados(String nomeArquivo) {
        List<Jogador> jogadoresDoRanking = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 2) {
                    String nome = partes[0].trim();
                    int pontuacao = Integer.parseInt(partes[1].trim());
                    Jogador jogador = new Jogador(nome);
                    jogador.setPontuacao(pontuacao);
                    jogadoresDoRanking.add(jogador);
                }
            }
        } catch (IOException e) {
            // Se o arquivo não existe, apenas retorna uma lista vazia.
            System.out.println("Arquivo de ranking não encontrado, será criado um novo.");
        } catch (NumberFormatException e) {
            System.err.println("Erro ao ler o ranking: formato de pontuação inválido.");
        }

        // Ordena a lista pela maior pontuação. Se houver empate, ordena por nome.
        jogadoresDoRanking.sort(
                Comparator.comparingInt(Jogador::getPontuacao).reversed()
                        .thenComparing(Jogador::getNome)
        );

        return jogadoresDoRanking;
    }
}
