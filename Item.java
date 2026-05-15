public abstract class Item{

    protected int id;
    protected String titulo;
    protected boolean disponivel;

    public Item(int id,String titulo){
        this.id = id;
        this.titulo=titulo;
        this.disponivel = true;
    }

    public int getId(){
        return id;
    }
    public String getTitulo(){
        return titulo;
    }
    public boolean isDisponivel(){
        return disponivel;
    }

    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }
    @Override

    public String toString(){
        return "ID: " + id +
               " | Título: " + titulo +
               " | Disponível: " + disponivel;
    }
}