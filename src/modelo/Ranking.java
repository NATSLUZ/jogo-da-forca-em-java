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
    public void exibirRanking(String nomeArquivo){
        List<Jogador> jogadoresDoRanking = new ArrayList<>();

        // Ler o arquivo e carrega os jogadores para uma lista
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))){
            String linha;
            while ((linha = reader.readLine()) !=null) {

                // Separa a linha "Nome, Pontos" usando virgula
                String[] partes = linha.split(",");
                if (partes.length == 2){
                    String nome = partes [0].trim();

                    // Converte a parte da pontuação de texto para número
                    int pontuacao = Integer.parseInt(partes[1].trim());

                    // Cria um jogador e define sua pontuação para a lista
                    Jogador jogador = new Jogador(nome);
                    jogador.setPontuacao(pontuacao);
                    jogadoresDoRanking.add(jogador);
                }
            }
        } catch (IOException e) {
            System.out.println("Ainda não há um ranking para este jogo");
            return;
        } catch (NumberFormatException e) {
            System.out.println("Erro ao ler ranking");
            return;
        }

        // Ordena o ranking na tela pela maior pontuação/ordem decrescente
        jogadoresDoRanking.sort(Comparator.comparing(Jogador::getPontuacao).reversed());

        // Exibe o ranking formatado

        int posicao = 1;
        for (Jogador jogador : jogadoresDoRanking){
            System.out.println(posicao + "º. " + jogador.getNome() + " - " + jogador.getPontuacao() + " pontos");
            posicao++;
        }
        System.out.println("------------------------------------------");
    }
}
