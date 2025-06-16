package ui;

import jogo.JogoDaForca;
import jogo.JogoMultiplayer;
import jogo.JogoSolo;
import modelo.Ranking;

import java.util.Scanner;

// Gerencia e exibi menu principal e sub-menus
public class MenuConsole {
    private final Scanner scanner;
    private final Ranking ranking;

    public MenuConsole(){
        this.scanner = new Scanner(System.in);
        this.ranking = new Ranking();
    }

    // Exibi o menu principal e a navegação do usuário.
    // Loop até o usuário escolher sair.
    public void exibir (){
        boolean sair = false;
        while (!sair){
            System.out.println("\n===== JOGO DA FORCA =====");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Jogar");
            System.out.println("2. Ver Ranking");
            System.out.println("3. Sair");

            String opcao = scanner.nextLine();

            switch (opcao){
                case "1":
                    exibirSubMenuJogar();
                    break;
                case "2":
                    exibirSubMenuRanking();
                    break;
                case "3":
                    sair = true;
                    System.out.println("\nObrigado por jogar! Até a próxima");
                    break;
                default:
                    System.out.println("\nOpçao inválida! Presisone ENTER para tentar novamente");
                    break;

            }

        }
        scanner.close();
    }

    // Exibi sub-menu com as opções de jogo
    private void exibirSubMenuJogar(){
        System.out.println("\n--- Modos de Jogo ---");
        System.out.println("Escolha uma opção: ");
        System.out.println("1. Modo Singleplayer");
        System.out.println("2. Modo Multiplayer");
        System.out.println("3. Voltar ao Menu Principal");

        String opcao = scanner.nextLine();
        switch (opcao) {
            case "1":
                JogoDaForca jogoSolo = new JogoSolo(this.scanner);
                jogoSolo.iniciar();
                break;

            case "2":
                JogoDaForca jogoMulti = new JogoMultiplayer(this.scanner);
                jogoMulti.iniciar();
                break;

            case "3":
                break;
            default:
                System.out.print("Opção inválida! Pressione ENTER para voltar...");
                scanner.nextLine();
                break;
        }
    }

    // Exibi sub-menu com as opções de Ranking
    private void exibirSubMenuRanking(){
        System.out.println("\n--- VER RANKING ---");
        System.out.println("Escolha uma opção: ");
        System.out.println("1. Ranking - Singleplayer");
        System.out.println("2. Ranking - Multiplayer");
        System.out.println("3. Voltar ao Menu Principal ");

        String opcao = scanner.nextLine();
        switch (opcao) {
            case "1":
                System.out.println("RANKING MODO SINGLEPLAYER");
                ranking.exibirRanking("ranking_solo.txt");
                System.out.print("\nPresione ENTER para voltar...");
                scanner.nextLine();
                break;

            case  "2":
                System.out.println("RANKING MODO MULTIPLAYER");
                ranking.exibirRanking("ranking_multi.txt");
                System.out.print("\nPresione ENTER para voltar...");
                scanner.nextLine();
                break;

            case "3":
                break;

            default:
                System.out.print("Opção inválida! Pressione ENTER para voltar...");
                scanner.nextLine();
                break;
        }
    }
}
