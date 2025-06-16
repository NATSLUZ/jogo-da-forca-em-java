package leitor;


import modelo.Tema;// Importa o enum Tema

import java.util.List;
public interface LeitorPalavras {
    List<String> carregarPalavras(Tema tema);
}
