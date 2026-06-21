import java.time.LocalDate;

public class Locacao{
    private Cliente cliente;
    private Item item;
    private LocalDate dataRetirada;
    private LocalDate dataPrevista;
    private LocalDate dataEntrega;
    private static final double MULTA_POR_DIA = 2.0;

    public Locacao(Cliente cliente, Item item, int diasPrazo){
        this.cliente = cliente;
        this.item = item;
        this.dataRetirada = LocalDate.now();
        this.dataPrevista = dataRetirada.plusDays(diasPrazo);
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

    





}