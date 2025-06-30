package leitor;

import modelo.Tema;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LeitorPalavrasArquivo implements LeitorPalavras {
    private final Random random;

    public LeitorPalavrasArquivo() {
        this.random = new Random();
    }

    @Override
    public List<String> carregarPalavras(Tema tema) {
        List<String> palavrasDoTema = new ArrayList<>();

        String caminhoArquivo = "recursos/" + tema.getNomeArquivo();

        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String palavraLimpa = linha.trim().toLowerCase();
                if (!palavraLimpa.isEmpty()) {
                    palavrasDoTema.add(palavraLimpa);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("ERRO: Arquivo de palavras não encontrado em: " + caminhoArquivo);
            System.err.println("Verifique se o diretório 'recursos' está na raiz do projeto e se o arquivo exite");
        } catch (IOException e) {
            System.err.println("ERRO ao ler arquvio de palavras" + caminhoArquivo);
        }
        return palavrasDoTema;


    }

    public String sortearPalavra(List<String> palavras) {
        if (palavras == null || palavras.isEmpty()) {
            return null;
        }
        return palavras.get(random.nextInt(palavras.size()));
    }
}
