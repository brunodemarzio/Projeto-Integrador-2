package controllers;
import DAOs.clienteDAO;
import models.Cliente;

public class clienteController {
    public static boolean Salvar(String nomeCliente, String sexoCliente, int CPFcliente,
        String emailCliente, String enderecoCliente, int telefoneCliente, String estCivilCliente, int nascimentoCliente){
        
        Cliente objCliente = new Cliente();
        objCliente.setNome(nomeCliente);
        objCliente.setSexo(sexoCliente);
        objCliente.setCPF(CPFcliente);
        objCliente.setEmail(emailCliente);
        objCliente.setEndereco(enderecoCliente);
        objCliente.setTelefone(telefoneCliente);
        objCliente.setEstCivil(estCivilCliente);
        objCliente.setNascimento(nascimentoCliente);
        
        boolean retorno = clienteDAO.Salvar(objCliente);
        
        return retorno;
    }
    
    public static boolean Atualizar(String nomeCliente,String CPFcliente){
        
        Cliente objCliente = new Cliente();
        objCliente.setNome(nomeCliente);
        objCliente.setNome(CPFcliente);
        
        boolean retorno = clienteDAO.Atualizar(objCliente);
        
        return retorno;
    }
    
     public static boolean Excluir(String nomeCliente,String CPFcliente){
        
        Cliente objCliente = new Cliente();
        objCliente.setNome(nomeCliente);
        objCliente.setNome(CPFcliente);
        
        boolean retorno = clienteDAO.Excluir(objCliente);
        
        return retorno;
    }
}
