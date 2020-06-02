package controllers;
import DAOs.vendedorDAO;
import models.Vendedor;

public class vendedorController {
    public static boolean Salvar(String nomeVendedor, String sexoVendedor, String CPFVendedor){
        
        Vendedor objVendedor = new Vendedor();
        objVendedor.setNome(nomeVendedor);
        objVendedor.setSexo(sexoVendedor);
        objVendedor.setCPF(CPFVendedor);
        
        boolean retorno = vendedorDAO.Salvar(objVendedor);
        
        return retorno;
    }
    
    public static boolean Atualizar(String nomeVendedor){
        
        Vendedor objVendedor = new Vendedor();
        objVendedor.setNome(nomeVendedor);
        
        boolean retorno = vendedorDAO.Atualizar(objVendedor);
        
        return retorno;
    }
    
     public static boolean Excluir(String nomeVendedor){
        
        Vendedor objVendedor = new Vendedor();
        objVendedor.setNome(nomeVendedor);
        
        boolean retorno = vendedorDAO.Excluir(objVendedor);
        
        return retorno;
    }
}
