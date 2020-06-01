
package models;


public class Cliente {
    private int ID;
    private String nomeCliente;
    private String sexoCliente;
    private int cpfCliente;
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
        this.ID = ID;
    }
    public String getNome() {
        return nomeCliente;
    }
    public void setNome(String nome) {
        this.nomeCliente = nomeCliente;
    }
    public String getSexo() {
        return sexoCliente;
    }
    public void setSexo(String sexo){
        this.sexoCliente=sexoCliente;
    }
    public int getCPF() {
        return cpfCliente;
    }
    public void setCPF(int cpf) {
        this.cpfCliente = cpfCliente;
    }
    public String getEmail() {
        return emailCliente;
    }
    public void setEmail(String email) {
        this.emailCliente = emailCliente;
    }
    public String getEndereco() {
        return enderecoCliente;
    }
    public void setEndereco(String endereco) {
        this.enderecoCliente = enderecoCliente;
    }
    public int getTelefone() {
        return telefoneCliente;
    }
    public void setTelefone(int telefone) {
        this.telefoneCliente = telefoneCliente;
    }
    public String getEstCivil() {
        return EstCivilCliente;
    }
    public void setEstCivil(String estCivil) {
        this.EstCivilCliente = EstCivilCliente;
    }
    public int getNascimento(){
        return nascimentoCliente;
    }
    public void setNascimento(int nascimento){
        this.nascimentoCliente = nascimentoCliente;
    }
}
