package leitor;

import modelo.Tema;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LeitorJsonAdapter implements LeitorPalavras {

    private final LeitorDeJsonExterno leitorJson;
    private final Map<String, String> mapaDeDicas;

    public LeitorJsonAdapter(){
        this.leitorJson = new LeitorDeJsonExterno();
        this.mapaDeDicas = leitorJson.getPalavrasComDicasDoJson();
    }

    @Override
    public List<String> carregarPalavras(Tema tema) {
        return new ArrayList<>(this.mapaDeDicas.keySet());
    }

    public Map<String, String> getMapaDeDicas() {
        return this.mapaDeDicas;
    }
}
