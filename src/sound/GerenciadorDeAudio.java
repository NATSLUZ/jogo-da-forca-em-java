package sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

// Classe responsável por gerenciar a reprodução de áudio do jogo.
public class GerenciadorDeAudio {

    private Clip clip; // O 'Clip' é o objeto que segura e controla o áudio.

    // Carrega e inicia a reprodução de um arquivo de áudio.

    public void tocarMusica(String caminhoDoAudio) {
        // Se já estiver tocando uma música, para antes de começar a nova.
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }

        try {
            File arquivoDeAudio = new File(caminhoDoAudio);

            if (arquivoDeAudio.exists()) {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(arquivoDeAudio);
                clip = AudioSystem.getClip();
                clip.open(audioStream);

                // Inicia a música em loop (ela vai repetir para sempre)
                clip.loop(Clip.LOOP_CONTINUOUSLY);

                System.out.println("Música iniciada: " + caminhoDoAudio);

            } else {
                System.err.println("ERRO: Arquivo de áudio não encontrado em: " + caminhoDoAudio);
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            // Imprime qualquer erro que possa ocorrer ao tentar tocar o áudio.
            e.printStackTrace();
        }
    }

    // Para a reprodução da música que está tocando atualmente.
    public void pararMusica() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close(); // Libera os recursos do sistema
            System.out.println("Música parada.");
        }
    }
}