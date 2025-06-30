package leitor;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Map;

public class LeitorDeJsonExterno {

    public Map<String, String> getPalavrasComDicasDoJson() {
        String nomeArquivo ="desafios.json";
        Gson gson = new Gson();

        try {
            Reader reader = new FileReader("recursos/" + nomeArquivo);
            Type tipoDoMapa = new TypeToken<Map<String, String>>() {}.getType();
            Map<String, String> mapaDePalavras = gson.fromJson(reader, tipoDoMapa);

            System.out.println("[LeitorDeJsonExterno]: Arquivo '" + nomeArquivo + "' lido com sucesso via Gson.");
            return mapaDePalavras != null ? mapaDePalavras : Collections.emptyMap();

        } catch (FileNotFoundException e) {
            System.err.println("ERRO: O arquivo JSON não foi encontrado: " + "recursos/" + nomeArquivo);
            return Collections.emptyMap();
        }
    }
}
