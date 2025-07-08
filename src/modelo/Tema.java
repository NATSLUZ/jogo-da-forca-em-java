package modelo;

public enum Tema {
    COMIDAS("comidas.txt","Comidas"),
    OBJETOS("objetos.txt","Objetos"),
    ANIMAIS("animais.txt","Animais"),
    DESAFIO("desafios.json","Modo Desafio");

    private final String nomeArquivo;
    private final String descricao;

    Tema(String nomeArquivo, String descricao){
        this.nomeArquivo = nomeArquivo;
        this.descricao = descricao;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public String getDescricao() {
        return descricao;
    }

}
