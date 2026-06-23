import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Locacao {
    private Cliente cliente;
    private Item item;
    private LocalDate dataRetirada;
    private LocalDate dataPrevista;
    private LocalDate dataEntrega;
    private static final double MULTA_POR_DIA = 2.0;

    public Locacao(Cliente cliente, Item item, int diasPrazo) {
        this.cliente = cliente;
        this.item = item;
        this.dataRetirada = LocalDate.now();
        this.dataPrevista = dataRetirada.plusDays(diasPrazo);
        this.dataEntrega = null;
        item.setDisponivel(false);
    }
    public Locacao(Cliente cliente, Item item, LocalDate dataRetirada, LocalDate dataPrevista) {
    this.cliente = cliente;
    this.item = item;
    this.dataRetirada = dataRetirada;
    this.dataPrevista = dataPrevista;
    this.dataEntrega = null;
    item.setDisponivel(false);
}


    public Cliente getCliente() {
        return cliente;
    }

    public Item getItem() {
        return item;
    }

    public LocalDate getDataRetirada() {
        return dataRetirada;
    }

    public LocalDate getDataPrevista() {
        return dataPrevista;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public boolean isDevolvido() {
        return dataEntrega != null;
    }

    public void registrarDevolucao() {
        this.dataEntrega = LocalDate.now();
        item.setDisponivel(true);

        double multa = calcularMulta();
        if (multa > 0) {
            cliente.adicionarMulta(multa);
        }
    }

    public void renovar(int diasExtras) {
        this.dataPrevista = dataPrevista.plusDays(diasExtras);
    }

    public double calcularMulta() {
        if (dataEntrega == null) return 0;

        long diasAtraso = ChronoUnit.DAYS.between(dataPrevista, dataEntrega);
        if (diasAtraso > 0) {
            return diasAtraso * MULTA_POR_DIA;
        }
        return 0;
    }

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