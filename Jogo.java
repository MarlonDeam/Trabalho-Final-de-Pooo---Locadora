public class Jogo extends Item {
    private String plataforma;
    private String genero;
    private int classeIndicativa;    

    public Jogo (int id, String titulo, String plataforma, String genero, int classeIndicativa) {
        super(id, titulo);
        this.plataforma = plataforma;
        this.genero = genero;
        this.classeIndicativa = classeIndicativa;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public String getGenero() {
        return genero;
    }

    public int classeIndicativa() {
        return classeIndicativa;
    }

    @Override
    public String getDetalhes() {
        return "Jogo | ID: " + id +
               " | Título: " + titulo +
               " | Plataforma: " + plataforma +
               " | Gênero: " + genero +
               " | Indicativo: " + classeIndicativa +
               " | Disponível: " + disponivel;
    }
}