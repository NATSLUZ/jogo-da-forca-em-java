package leitor;

import modelo.Tema;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorPalavrasArquivo implements LeitorPalavras {

    // Carrega uma lista de palavras de um arquivo de texto
    @Override
    public List<String> carregarPalavras(Tema tema) {
        List<String> palavrasDoTema = new ArrayList<>();

        String caminhoArquivo = "recursos/" + tema.getNomeArquivo();

        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;

            // Lê o arquivo, linha por linha
            while ((linha = reader.readLine()) != null) {

                //limpa a palavra de espaços em branco e converte para minusculas
                String palavraLimpa = linha.trim().toLowerCase();
                if (!palavraLimpa.isEmpty()) {
                    palavrasDoTema.add(palavraLimpa);
                }
            }

        // Em casos de erros na leitura do arquivo
        } catch (FileNotFoundException e) {
            System.err.println("ERRO: Arquivo de palavras não encontrado em: " + caminhoArquivo);
            System.err.println("Verifique se o diretório 'recursos' está na raiz do projeto e se o arquivo exite");
        } catch (IOException e) {
            System.err.println("ERRO ao ler arquvio de palavras" + caminhoArquivo);
        }
        return palavrasDoTema;


    }

}
