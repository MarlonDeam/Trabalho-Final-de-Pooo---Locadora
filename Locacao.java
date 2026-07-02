import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Representa uma locação realizada por um cliente.
 *
 * <p>Esta classe é responsável por registrar informações sobre a
 * locação de um item, incluindo o cliente responsável, as datas de
 * retirada, devolução e prazo previsto, além de calcular multas por
 * atraso e controlar a disponibilidade do item.</p>
 *
 * @author Marlon Deam
 * @version 1.0
 */
public class Locacao implements Serializable {

    /** Cliente responsável pela locação. */
    private Cliente cliente;

    /** Item que está sendo alugado. */
    private Item item;

    /** Data em que o item foi retirado. */
    private LocalDate dataRetirada;

    /** Data prevista para devolução do item. */
    private LocalDate dataPrevista;

    /** Data em que o item foi efetivamente devolvido. */
    private LocalDate dataEntrega;

    /** Valor da multa cobrada por dia de atraso. */
    private static final double MULTA_POR_DIA = 2.0;

    /**
     * Cria uma nova locação utilizando a data atual como data de retirada.
     *
     * <p>Ao criar a locação, o item é automaticamente marcado como
     * indisponível para novas locações.</p>
     *
     * @param cliente cliente responsável pela locação.
     * @param item item que será alugado.
     * @param diasPrazo quantidade de dias permitidos para devolução.
     */
    public Locacao(Cliente cliente, Item item, int diasPrazo) {
        this.cliente = cliente;
        this.item = item;
        this.dataRetirada = LocalDate.now();
        this.dataPrevista = dataRetirada.plusDays(diasPrazo);
        this.dataEntrega = null;
        item.setDisponivel(false);
    }

    /**
     * Cria uma nova locação informando manualmente as datas.
     *
     * <p>Este construtor é útil para restaurar locações salvas ou
     * realizar testes unitários.</p>
     *
     * @param cliente cliente responsável pela locação.
     * @param item item alugado.
     * @param dataRetirada data de retirada do item.
     * @param dataPrevista data prevista para devolução.
     */
    public Locacao(Cliente cliente, Item item, LocalDate dataRetirada, LocalDate dataPrevista) {
        this.cliente = cliente;
        this.item = item;
        this.dataRetirada = dataRetirada;
        this.dataPrevista = dataPrevista;
        this.dataEntrega = null;
        item.setDisponivel(false);
    }

    /**
     * Retorna o cliente responsável pela locação.
     *
     * @return o cliente da locação.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Retorna o item alugado.
     *
     * @return o item da locação.
     */
    public Item getItem() {
        return item;
    }

    /**
     * Retorna a data em que o item foi retirado.
     *
     * @return a data de retirada.
     */
    public LocalDate getDataRetirada() {
        return dataRetirada;
    }

    /**
     * Retorna a data prevista para devolução.
     *
     * @return a data prevista de devolução.
     */
    public LocalDate getDataPrevista() {
        return dataPrevista;
    }

    /**
     * Retorna a data em que o item foi devolvido.
     *
     * @return a data de entrega ou {@code null} caso o item ainda
     * não tenha sido devolvido.
     */
    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    /**
     * Verifica se o item já foi devolvido.
     *
     * @return {@code true} se a devolução foi registrada;
     * {@code false} caso contrário.
     */
    public boolean isDevolvido() {
        return dataEntrega != null;
    }

    /**
     * Registra a devolução do item.
     *
     * <p>Ao registrar a devolução, o item volta a ficar disponível
     * para locação. Caso exista atraso na devolução, a multa é
     * calculada e adicionada ao cliente.</p>
     */
    public void registrarDevolucao() {
        this.dataEntrega = LocalDate.now();
        item.setDisponivel(true);

        double multa = calcularMulta();
        if (multa > 0) {
            cliente.adicionarMulta(multa);
        }
    }

    /**
     * Renova o prazo da locação.
     *
     * @param diasExtras quantidade de dias adicionais concedidos.
     */
    public void renovar(int diasExtras) {
        this.dataPrevista = dataPrevista.plusDays(diasExtras);
    }

    /**
     * Calcula o valor da multa por atraso na devolução.
     *
     * <p>A multa é calculada multiplicando a quantidade de dias
     * de atraso pelo valor definido em {@code MULTA_POR_DIA}.</p>
     *
     * @return o valor da multa. Retorna {@code 0} caso o item
     * ainda não tenha sido devolvido ou não exista atraso.
     */
    public double calcularMulta() {
        if (dataEntrega == null) return 0;

        long diasAtraso = ChronoUnit.DAYS.between(dataPrevista, dataEntrega);
        if (diasAtraso > 0) {
            return diasAtraso * MULTA_POR_DIA;
        }
        return 0;
    }

    /**
     * Retorna uma representação textual da locação.
     *
     * @return uma string contendo o cliente, o item, as datas da
     * locação e o valor da multa calculada.
     */
    @Override
    public String toString() {
        return "Cliente: " + cliente.getNome() +
               " | Item: " + item.getTitulo() +
               " | Retirada: " + dataRetirada +
               " | Prevista: " + dataPrevista +
               " | Entrega: " + (dataEntrega != null ? dataEntrega : "Em aberto") +
               " | Multa: R$ " + calcularMulta();
    }
}