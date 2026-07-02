import java.io.Serializable;

/**
 * Representa um cliente cadastrado na locadora.
 *
 * <p>Armazena as informações pessoais do cliente, como nome,
 * CPF e telefone, além do valor de multas pendentes.
 * Também fornece métodos para gerenciar multas e verificar
 * se o cliente possui pendências financeiras.</p>
 *
 * @author Marlon Deam
 * @version 1.0
 */
public class Cliente implements Serializable {

    /** Identificador único do cliente. */
    private int id;

    /** Nome completo do cliente. */
    private String nome;

    /** CPF do cliente. */
    private String cpf;

    /** Telefone para contato do cliente. */
    private String telefone;

    /** Valor total das multas pendentes do cliente. */
    private double multa;

    /**
     * Cria um novo cliente.
     *
     * @param id identificador único do cliente.
     * @param nome nome completo do cliente.
     * @param cpf CPF do cliente.
     * @param telefone telefone para contato.
     */
    public Cliente(int id, String nome, String cpf, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.multa = 0;
    }

    /**
     * Retorna o identificador do cliente.
     *
     * @return o identificador do cliente.
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna o nome do cliente.
     *
     * @return o nome do cliente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o CPF do cliente.
     *
     * @return o CPF do cliente.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Retorna o telefone do cliente.
     *
     * @return o telefone do cliente.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Retorna o valor total das multas pendentes.
     *
     * @return o valor da multa.
     */
    public Double getMulta() {
        return multa;
    }

    /**
     * Adiciona um valor à multa do cliente.
     *
     * @param valor valor a ser acrescentado à multa.
     */
    public void adicionarMulta(double valor) {
        this.multa += valor;
    }

    /**
     * Quita todas as multas pendentes do cliente,
     * definindo o valor da multa como zero.
     */
    public void quitarMulta() {
        this.multa = 0;
    }

    /**
     * Verifica se o cliente possui multas pendentes.
     *
     * @return {@code true} se houver multa pendente;
     *         {@code false} caso contrário.
     */
    public boolean temPendencia() {
        return multa > 0;
    }

    /**
     * Retorna uma representação textual do cliente.
     *
     * @return uma string contendo os dados do cliente.
     */
    @Override
    public String toString() {
        return "ID: " + id +
               " | Nome: " + nome +
               " | CPF: " + cpf +
               " | Telefone: " + telefone +
               " | Multa: R$ " + multa;
    }
}