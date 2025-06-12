package modelo;

public class Jogador {
    private String nome;
    private int pontuacao;

    public Jogador(String nome){
        this.nome = nome;
        this.pontuacao = 0;
    }

    public void adicionarPonto(){
        this.pontuacao++;
    }

    public void setPontuacao(int pontuacao){
        this.pontuacao = pontuacao;
    }

    public String getNome(){
        return nome;
    }

    public int getPontuacao(){
        return pontuacao;
    }

    @Override
    public String toString(){
        return "Jogador:" + nome + ", Pontuação: " + pontuacao;
    }


}

