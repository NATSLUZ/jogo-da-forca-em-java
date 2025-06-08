package modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Rodada {

    private final String palavraSecreta;
    private final List<Character> estadoPalavraVisivel;
    private final Set<Character> letrasTentadas;
    private int tentativasErradas;
    private final int MAX_TENTATIVAS_ERRADAS = 6;

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

    public boolean tentarLetra(char letra) {
        char letraMinusc = Character.toLowerCase(letra);

        if (!Character.isLetter(letraMinusc) || letrasTentadas.contains(letraMinusc)){
            //se não for uma letra retorna falso

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

    //verifica estado do jogo
    public boolean isPalavraDescoberta(){
        return !estadoPalavraVisivel.contains('_');
    }

    public boolean isEnforcado(){
        return tentativasErradas >= MAX_TENTATIVAS_ERRADAS;
    }

    public boolean isFimDeRodada() {
        return isPalavraDescoberta () || isEnforcado();
    }

    //getters uteis
    public String getPalavraSecreta() {
        return palavraSecreta;
    }

    public int getTentativasErradas(){
        return tentativasErradas;
    }

    public Set<Character> getLetrasTentadas(){
        return letrasTentadas;
    }



}



