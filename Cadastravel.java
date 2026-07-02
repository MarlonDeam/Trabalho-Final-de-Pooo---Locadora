/**
 * Interface que define os métodos necessários para objetos
 * que podem ser cadastrados no sistema da locadora.
 *
 * As classes que implementam esta interface devem fornecer
 * um identificador único e um título para o objeto cadastrado.
 *
 * @author Marlon Deam
 * @version 1.0
 */
public interface Cadastravel {

    /**
     * Retorna o identificador único do objeto.
     *
     * @return o identificador do objeto.
     */
    int getId();

    /**
     * Retorna o título do objeto cadastrado.
     *
     * @return o título do objeto.
     */
    String getTitulo();
}