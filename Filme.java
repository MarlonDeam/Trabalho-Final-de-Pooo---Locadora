public class Filme extends Item {
    private String diretor;
    private String genero;
    private int duracao; // em minutos

    public Filme(int id, String titulo, String diretor, String genero, int duracao) {
        super(id, titulo);
        this.diretor = diretor;
        this.genero = genero;
        this.duracao = duracao;
    }

    public String getDiretor() {
        return diretor;
    }

    public String getGenero() {
        return genero;
    }

    public int getDuracao() {
        return duracao;
    }

    @Override
    public String getDetalhes() {
        return "Filme | ID: " + id +
               " | Título: " + titulo +
               " | Diretor: " + diretor +
               " | Gênero: " + genero +
               " | Duração: " + duracao + " min" +
               " | Disponível: " + disponivel;
    }
}