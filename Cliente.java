public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private double multa;

    public Cliente(int id, String nome, String cpf, String telefone){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.multa = 0;
    }
    public int getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public String getCpf(){
        return cpf;
    }
    public String getTelefone(){
        return telefone;
    }
    public Double getMulta(){
        return multa;
    }
    public void adicionarMulta(double valor){
        this.multa += valor;
    }
    public void quitarMulta(){
        this.multa = 0;
    }
    public boolean temPendencia(){
        return multa > 0;
    }

        @Override
    public String toString() {
        return "ID: " + id +
               " | Nome: " + nome +
               " | CPF: " + cpf +
               " | Telefone: " + telefone +
               " | Multa: R$ " + multa;
    }
}

