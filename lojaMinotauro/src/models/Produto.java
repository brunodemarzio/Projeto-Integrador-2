package models;


public class Produto {
    private int idProduto;
    private String nomeProduto;
    private String categoriaProduto;
    private int quantidadeProduto;
    private double valorProduto;

    /**
     *
     */
    public Produto() {
    }
    
    public int getidProduto() {
        return idProduto;
    }
    public void setidProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    public String getnome() {
        return nomeProduto;
    }
    public void setnome(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    public String getcategoria() {
        return categoriaProduto;
    }
    public void setcategoria(String categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }
    public int getquantidade() {
        return quantidadeProduto;
    }
    public void setquantidade(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }
    public double getpreco() {
        return valorProduto;
    }
    public void setpreco(double valorProduto) {
        this.valorProduto = valorProduto;
    }
}

