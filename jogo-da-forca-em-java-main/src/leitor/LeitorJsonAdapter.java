package leitor;

import modelo.Tema;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// ADAPTER: "Traduz" a saída da classe LeitorDeJsonExterno para a interface
// LeitorPalavras, que o  jogo espera.
public class LeitorJsonAdapter implements LeitorPalavras {

    private final LeitorDeJsonExterno leitorJson;
    // Guarda o mapa completo de palavras e dicas lido pelo leitor externo.
    private final Map<String, String> mapaDeDicas;

    // Construtor inicializa o leitor de JSON e carrega os dados do arquivo.
    public LeitorJsonAdapter(){
        this.leitorJson = new LeitorDeJsonExterno();
        this.mapaDeDicas = leitorJson.getPalavrasComDicasDoJson();
    }

    // Cumpre o contrato da interface LeitorPalavras.
    // Adapta o mapa de dados, retornando apenas uma lista com as palavras (as chaves do json).
    @Override
    public List<String> carregarPalavras(Tema tema) {
        return new ArrayList<>(this.mapaDeDicas.keySet());
    }

    // Método extra para o mapa completo com as dicas.
    // É usado no Modo Desafio para obter a dica de cada palavra.
    // Retorna O mapa completo de palavras e suas respectivas dicas (os valores do arquivo json).

    public Map<String, String> getMapaDeDicas() {
        return this.mapaDeDicas;
    }
}
