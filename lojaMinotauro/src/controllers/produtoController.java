package controllers;
import models.Produto;
import DAOs.produtoDAO;

public class produtoController {
    public static boolean Cadastrar(String nomeProduto, String categoriaProduto,
    int quantidadeProduto, double precoProduto){
        
        Produto objProduto = new Produto();
        objProduto.setnome(nomeProduto);
        objProduto.setcategoria(categoriaProduto);
        objProduto.setquantidade(quantidadeProduto);
        objProduto.setpreco(precoProduto);
        
        boolean retorno = produtoDAO.Cadastrar(objProduto);
        
        return retorno;
    }
    
    public static boolean Atualizar(String nomeProduto){
        
        Produto objProduto = new Produto();
        objProduto.setnome(nomeProduto);
        
        boolean retorno = produtoDAO.Atualizar(objProduto);
        
        return retorno;
    }
    
    public static boolean Excluir(String nomeProduto){
        
        Produto objProduto = new Produto();
        objProduto.setnome(nomeProduto);
        
        boolean retorno = produtoDAO.Excluir(objProduto);
        
        return retorno;
    }
}



