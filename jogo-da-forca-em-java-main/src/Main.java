import ui.TelaPrincipal;
import javax.swing.SwingUtilities;

//Classe principal que inicia a aplicação do Jogo
// Cria e exibir a janela principal da interface gráfica
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Cria uma instância da nossa janela principal
            TelaPrincipal tela = new TelaPrincipal();
            // Torna a janela visível para o usuário
            tela.setVisible(true);
        });
    }
}