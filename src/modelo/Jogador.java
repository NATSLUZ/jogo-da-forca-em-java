package modelo;

public class Jogador {
    private String nome;
    private int pontuacao;

    public Jogador(String nome){
        this.nome = nome;
        this.pontuacao = 0;
    }

    // Incrementa 1 ponto na pontuação
    public void adicionarPonto(){
        this.pontuacao++;
    }

    // Permite alterar a pontuação diretamente
    public void setPontuacao(int pontuacao){
        this.pontuacao = pontuacao;
    }

    // Getters básicos para acessar os dados do jogador.
    public String getNome(){
        return nome;
    }

    public int getPontuacao(){
        return pontuacao;
    }

    // Exibição do jogador no ranking
    @Override
    public String toString(){
        return "Jogador:" + nome + ", Pontuação: " + pontuacao;
    }


}

