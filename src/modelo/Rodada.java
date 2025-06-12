package modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//gerencia a lógica de uma rodada de jogo
public class Rodada {

    private final String palavraSecreta;
    private final List<Character> estadoPalavraVisivel;
    private final Set<Character> letrasTentadas;
    private int tentativasErradas;
    private final int MAX_TENTATIVAS_ERRADAS = 6;

    //constroi uma rodada com uma palavra secreta
    public Rodada(String palavra) {
        this.palavraSecreta = palavra.toLowerCase();
        this.estadoPalavraVisivel = new ArrayList<>();
        this.letrasTentadas = new HashSet<>();
        this.tentativasErradas = 0;

        //inicializa o estado visivel da palavra com underscore
        for (char c : this.palavraSecreta.toCharArray()) {
            if (Character.isLetter(c)) {
                this.estadoPalavraVisivel.add('_');
            } else {
                //revela caracteres que não são letras
                this.estadoPalavraVisivel.add(c);

            }
        }
    }

    //Retorna a palavra como ela deve aparecer na tela
    public String getPalavraVisivel (){
        StringBuilder sb = new  StringBuilder();
        for (Character c : estadoPalavraVisivel) {
            sb.append(c).append(" ");
        }
        return sb.toString().trim();
    }

    //retorna a Arte do enforcado
    public String getEnforcadoArt(){
        return switch (tentativasErradas) {
            case 0 -> """
                     
                     
                     
                      """;
            case 1 -> """
                       O
                     
                     
                      """;
            case 2 -> """
                       O
                       |
                     
                      """;
            case 3 -> """
                       O
                      /|
                     
                      """;
            case 4 -> """
                       O
                      /|\\
                     
                      """;
            case 5 -> """
                       O
                      /|\\
                      /
                      """;
            case 6 -> """
                       O
                      /|\\
                      / \\
                      """;
            default -> "";
        };

    }

    //processa a tentativa de uma letra, Ignora se não for letra ou se já foi tentada.
    // revela a letra se acertar, aumenta tentativasErradas se errar.
    // retorna true se acertou, false se errou ou foi inválida.
    public boolean tentarLetra(char letra) {
        char letraMinusc = Character.toLowerCase(letra);

        if (!Character.isLetter(letraMinusc) || letrasTentadas.contains(letraMinusc)){
            return false;
        }

        letrasTentadas.add(letraMinusc);
        boolean acertou = false;
        for (int i = 0; i < palavraSecreta.length(); i++) {
            if (palavraSecreta.charAt(i) == letraMinusc) {
                estadoPalavraVisivel.set(i, letraMinusc);
                acertou = true;
            }
        }

        if (!acertou) {
            tentativasErradas++;
        }
        return acertou;

    }

    //Verifica fim da rodada

    //verifica se a palavra foi descoberta
    public boolean isPalavraDescoberta(){
        return !estadoPalavraVisivel.contains('_');
    }

    //verifica se o jogado atingiu o numero maximo de tentativas
    public boolean isEnforcado(){
        return tentativasErradas >= MAX_TENTATIVAS_ERRADAS;
    }

    //verifica se o jogo terminou, se a palvra foi descoberta ou não
    public boolean isFimDeRodada() {
        return isPalavraDescoberta () || isEnforcado();
    }

    //getters uteis

    //retrona a palavra inteira
    public String getPalavraSecreta() {
        return palavraSecreta;
    }

    public int getTentativasErradas(){
        return tentativasErradas;
    }

    // retorna as letras que já foram tentadas
    public Set<Character> getLetrasTentadas(){
        return letrasTentadas;
    }



}



