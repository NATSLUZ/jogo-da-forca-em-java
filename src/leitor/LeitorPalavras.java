package leitor;

// Importa o enum Tema
import modelo.Tema;

import java.util.List;

public interface LeitorPalavras {
    List<String> carregarPalavras(Tema tema);
}
