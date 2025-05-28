package Jogo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //JOGO DA FORCA

        String palavra = "melancia";
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> estadoPalavra = new ArrayList<>();
        int respostasErradas =0;

        for (int i = 0; i < palavra.length(); i++){
            estadoPalavra.add('_');

        }
        System.out.println();
        System.out.println("*******************************");
        System.out.println("Bem vindo ao Java Jogo da forca");
        System.out.println("*******************************");

        while (respostasErradas < 6){

            System.out.print(getEnforcadoArt(respostasErradas));

            System.out.println();
            System.out.println("Palavra: ");

            for (char c : estadoPalavra){
                System.out.print(c + " ");

            }
            System.out.println();

            System.out.print("Adivinhe uma letra: ");
            char chute = scanner.next().toLowerCase().charAt(0);

            //verifica se o chute bate com a palavra
            if (palavra.indexOf(chute)  >= 0){
                System.out.print("Letra adivinhada!");

                for (int i = 0; i < palavra.length(); i++){
                    if (palavra.charAt(i) == chute){
                        estadoPalavra.set(i, chute);
                    }
                }

                if (!estadoPalavra.contains('_')){
                    System.out.print(getEnforcadoArt(respostasErradas));
                    System.out.println("PARABÉNS, VOCÊ ACERTOU A PALAVRA! ");
                    System.out.println("A palavra era: " + palavra);
                    break;
                }
            }
            else {
                respostasErradas++;
                System.out.println("Resposta errada, tente novamente! ");
            }

        }

        if (respostasErradas >= 6){
            System.out.print(getEnforcadoArt(respostasErradas));
            System.out.print("FIM DE JOGO!");
            System.out.print("A palavra era: " + palavra);
        }

        scanner.close();

    }

    static String getEnforcadoArt (int respostasErradas){

        return switch (respostasErradas){
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
}
