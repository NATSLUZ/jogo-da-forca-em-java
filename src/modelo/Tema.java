package modelo;

public enum Tema {
    COMIDAS("comidas.txt","Pratos, frutas ou legumes"),
    OBJETOS("objetos.txt","Objetos de todos os tamanhos e tipos"),
    ANIMAIS("animais.txt","Insetos, mamíferos, animais de todos os tipos");

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

    public static void listarTemas(){
        System.out.println("Escolha um tema:");
        for (int i = 0; i <Tema.values().length; i++){
            System.out.println((i + 1) + ". " + Tema.values()[i].getDescricao() + " (Arquivo: " + Tema.values()[i].getNomeArquivo() + ")");
        }
    }

    public static Tema escolherTema(int escolha) {
        if (escolha > 0 && escolha <= Tema.values().length){
            return Tema.values()[escolha - 1];
        }
        return null;
    }

}
