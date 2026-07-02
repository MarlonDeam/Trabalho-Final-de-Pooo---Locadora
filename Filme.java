import java.io.Serializable;

/**
 * Representa um filme disponível para locação na locadora.
 *
 * <p>Esta classe herda as características da classe {@code Item},
 * acrescentando informações específicas de um filme, como diretor,
 * gênero e duração.</p>
 *
 * @author Marlon Deam
 * @version 1.0
 */
public class Filme extends Item implements Serializable {

    /** Nome do diretor do filme. */
    private String diretor;

    /** Gênero do filme. */
    private String genero;

    /** Duração do filme em minutos. */
    private int duracao;

    /**
     * Cria um novo filme.
     *
     * @param id identificador único do filme.
     * @param titulo título do filme.
     * @param diretor nome do diretor do filme.
     * @param genero gênero do filme.
     * @param duracao duração do filme em minutos.
     */
    public Filme(int id, String titulo, String diretor, String genero, int duracao) {
        super(id, titulo);
        this.diretor = diretor;
        this.genero = genero;
        this.duracao = duracao;
    }

    /**
     * Retorna o nome do diretor do filme.
     *
     * @return o diretor do filme.
     */
    public String getDiretor() {
        return diretor;
    }

    /**
     * Retorna o gênero do filme.
     *
     * @return o gênero do filme.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Retorna a duração do filme.
     *
     * @return a duração do filme em minutos.
     */
    public int getDuracao() {
        return duracao;
    }

    /**
     * Retorna uma descrição completa do filme,
     * incluindo suas informações e disponibilidade.
     *
     * @return uma string contendo os detalhes do filme.
     */
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