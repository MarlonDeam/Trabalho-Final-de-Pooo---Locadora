import java.io.Serializable;

/**
 * Representa um jogo disponível para locação na locadora.
 *
 * <p>Esta classe herda as características da classe {@code Item},
 * adicionando informações específicas sobre jogos, como plataforma,
 * gênero e classificação indicativa.</p>
 *
 * @author Marlon Deam
 * @version 1.0
 */
public class Jogo extends Item implements Serializable {

    /** Plataforma na qual o jogo pode ser executado. */
    private String plataforma;

    /** Gênero do jogo. */
    private String genero;

    /** Classificação indicativa do jogo. */
    private int classeIndicativa;

    /**
     * Cria um novo jogo.
     *
     * @param id identificador único do jogo.
     * @param titulo título do jogo.
     * @param plataforma plataforma em que o jogo está disponível.
     * @param genero gênero do jogo.
     * @param classeIndicativa classificação indicativa do jogo.
     */
    public Jogo(int id, String titulo, String plataforma, String genero, int classeIndicativa) {
        super(id, titulo);
        this.plataforma = plataforma;
        this.genero = genero;
        this.classeIndicativa = classeIndicativa;
    }

    /**
     * Retorna a plataforma do jogo.
     *
     * @return a plataforma do jogo.
     */
    public String getPlataforma() {
        return plataforma;
    }

    /**
     * Retorna o gênero do jogo.
     *
     * @return o gênero do jogo.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Retorna a classificação indicativa do jogo.
     *
     * @return a classificação indicativa do jogo.
     */
    public int classeIndicativa() {
        return classeIndicativa;
    }

    /**
     * Retorna uma descrição completa do jogo,
     * incluindo suas informações e disponibilidade.
     *
     * @return uma string contendo os detalhes do jogo.
     */
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