package models;

public class Vendedor {
    private int ID;
    private String nomeVendedor;
    private String sexoVendedor;
    private String cpfVendedor;
    
    public Vendedor(){
    }
    
    public int getidVendedor() {
        return ID;
    }
    public void setidVendedor(int idCliente) {
        this.ID = ID;
    }
    public String getNome() {
        return nomeVendedor;
    }
    public void setNome(String nome) {
        this.nomeVendedor = nome;
    }
    public String getSexo() {
        return sexoVendedor;
    }
    public void setSexo(String sexo){
        this.sexoVendedor = sexo;
    }
    public String getCPF() {
        return cpfVendedor;
    }
    public void setCPF(String cpf) {
        this.cpfVendedor = cpf;
    }
}
