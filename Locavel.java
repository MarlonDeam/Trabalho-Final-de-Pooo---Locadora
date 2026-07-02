/**
 * Interface que define o comportamento de objetos que podem ser locados.
 *
 * <p>As classes que implementam esta interface devem fornecer
 * informações sobre seus detalhes e permitir o controle de sua
 * disponibilidade para locação.</p>
 *
 * @author Marlon Deam
 * @version 1.0
 */
public interface Locavel {

    /**
     * Retorna uma descrição detalhada do objeto locável.
     *
     * @return uma string contendo os detalhes do objeto.
     */
    String getDetalhes();

    /**
     * Verifica se o objeto está disponível para locação.
     *
     * @return {@code true} se o objeto estiver disponível;
     *         {@code false} caso contrário.
     */
    boolean isDisponivel();

    /**
     * Define a disponibilidade do objeto para locação.
     *
     * @param disponivel novo estado de disponibilidade do objeto.
     */
    void setDisponivel(boolean disponivel);
}