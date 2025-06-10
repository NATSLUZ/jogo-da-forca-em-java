import leitor.LeitorPalavrasArquivo;
import modelo.Rodada;
import modelo.Tema;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LeitorPalavrasArquivo leitor = new LeitorPalavrasArquivo();

        System.out.println("**************************");
        System.out.println("Bem-vindo ao jogo da Forca");
        System.out.println("**************************");

        //escolhe tema
        Tema temaEscolhido = null;
        List<String> palavraDoTema = null;

        //loop para escolher tema válido
        while(temaEscolhido == null){
            //temas disponiveis
            Tema.listarTemas();
            System.out.println("Digite o número do tema desejado: ");

            if (scanner.hasNextInt()){
                int escolha =scanner.nextInt();
                //limpa o buffer
                scanner.nextLine();
                //válida a escolha
                temaEscolhido = Tema.escolherTema(escolha);

                if (temaEscolhido !=null) {
                    //carrega as palavras
                    palavraDoTema = leitor.carregarPalavras(temaEscolhido);

                    if (palavraDoTema.isEmpty()){
                        System.out.println("ERRO: Arquivo vázio ou tema não encontrado: ");
                        temaEscolhido = null;
                    }
                } else {
                    System.out.println("Opção inválida. Tente novamente. ");
                }

            } else {
                System.out.println("Entrada inválida. Por favor, digite um número. ");
                scanner.nextLine();
            }
        }

        //inicio da rodada
        // sorteia uma palavra da lista
        String palavraSorteada = leitor.sortearPalavra(palavraDoTema);
        // inicia rodada com palavra sorteada
        Rodada rodada = new Rodada(palavraSorteada);

        System.out.println("\nVamos começar! O tema escolhido é: " + temaEscolhido.name());
        System.out.println("Palavra sorteado! Tente adivinhar. Boa sorte!");

        //Loop do jogo
        while (!rodada.isFimDeRodada()){
            System.out.println(rodada.getEnforcadoArt());
            System.out.println("Palavra: " + rodada.getPalavraVisivel());
            System.out.print("Histórico de letras: ");
            for (char letraTentada : rodada.getLetrasTentadas()){
                System.out.println(letraTentada + "");
            }
            //pula linha
            System.out.println();

            System.out.println("Digite uma letra: ");
            String input = scanner.nextLine().trim();

            if (input.length() ==1){
                rodada.tentarLetra(input.charAt(0));
            } else {
                System.out.println("Por favor, digite apenas UMA letra.");
            }
            System.out.println("______________________________________");
        }

        //Fim do jogo
        if (rodada.isPalavraDescoberta()){
            System.out.println("Parabéns! Você acertou a palavra!");
        } else {
            System.out.println("FIM DE JOGO! VOCÊ FOI ENFORCADO!");
        }
        System.out.println("A palavra era: " + rodada.getPalavraSecreta());
        scanner.close();
    }


}
