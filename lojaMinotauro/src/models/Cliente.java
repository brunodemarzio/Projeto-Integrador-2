
package models;


public class Cliente {
    private int ID;
    private String nomeCliente;
    private String sexoCliente;
    private String cpfCliente;
    private String emailCliente;
    private String enderecoCliente;
    private int telefoneCliente;
    private String EstCivilCliente;
    private int nascimentoCliente;
    
    public Cliente() {
    }
    
    public int getidCliente() {
        return ID;
    }
    public void setidCliente(int idCliente) {
        this.ID = idCliente;
    }
    public String getNome() {
        return nomeCliente;
    }
    public void setNome(String nome) {
        this.nomeCliente = nome;
    }
    public String getSexo() {
        return sexoCliente;
    }
    public void setSexo(String sexo){
        this.sexoCliente = sexo;
    }
    public String getCPF() {
        return cpfCliente;
    }
    public void setCPF(String cpf) {
        this.cpfCliente = cpf;
    }
    public String getEmail() {
        return emailCliente;
    }
    public void setEmail(String email) {
        this.emailCliente = email;
    }
    public String getEndereco() {
        return enderecoCliente;
    }
    public void setEndereco(String endereco) {
        this.enderecoCliente = endereco;
    }
    public int getTelefone() {
        return telefoneCliente;
    }
    public void setTelefone(int telefone) {
        this.telefoneCliente = telefone;
    }
    public String getEstCivil() {
        return EstCivilCliente;
    }
    public void setEstCivil(String estCivil) {
        this.EstCivilCliente = estCivil;
    }
    public int getNascimento(){
        return nascimentoCliente;
    }
    public void setNascimento(int nascimento){
        this.nascimentoCliente = nascimento;
    }
}
