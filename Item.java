import java.io.Serializable;

/**
 * Classe abstrata que representa um item disponível para locação.
 *
 * <p>Esta classe serve como base para os diferentes tipos de itens
 * da locadora, como filmes e jogos. Ela implementa as interfaces
 * {@code Locavel} e {@code Cadastravel}, fornecendo informações
 * comuns a todos os itens, como identificador, título e disponibilidade.</p>
 *
 * @author Marlon Deam
 * @version 1.0
 */
public abstract class Item implements Locavel, Cadastravel, Serializable {

    /** Identificador único do item. */
    protected int id;

    /** Título do item. */
    protected String titulo;

    /** Indica se o item está disponível para locação. */
    protected boolean disponivel;

    /**
     * Cria um novo item.
     *
     * @param id identificador único do item.
     * @param titulo título do item.
     */
    public Item(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.disponivel = true;
    }

    /**
     * Retorna o identificador do item.
     *
     * @return o identificador do item.
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Retorna o título do item.
     *
     * @return o título do item.
     */
    @Override
    public String getTitulo() {
        return titulo;
    }

    /**
     * Verifica se o item está disponível para locação.
     *
     * @return {@code true} se o item estiver disponível;
     *         {@code false} caso contrário.
     */
    public boolean isDisponivel() {
        return disponivel;
    }

    /**
     * Define a disponibilidade do item.
     *
     * @param disponivel novo estado de disponibilidade do item.
     */
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    /**
     * Retorna uma descrição detalhada do item.
     *
     * <p>Este método deve ser implementado pelas subclasses para
     * fornecer informações específicas sobre cada tipo de item.</p>
     *
     * @return uma string contendo os detalhes do item.
     */
    public abstract String getDetalhes();

    /**
     * Retorna uma representação textual do item.
     *
     * @return uma string contendo o identificador, o título e a
     * disponibilidade do item.
     */
    @Override
    public String toString() {
        return "ID: " + id +
               " | Título: " + titulo +
               " | Disponível: " + disponivel;
    }
}