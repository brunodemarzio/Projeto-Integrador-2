
package DAOs;
import models.Produto;
import GerenciarConexao.GerenciadorConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Leo Motta
 */
public class produtoDAO {
    
    public static ArrayList<Produto> Pesquisar (){
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
        try {
        conexao = GerenciadorConexao.abrirConexao();
        instrucaoSQL = conexao.prepareStatement("SELECT NOME FROM produtos;");
        rs = instrucaoSQL.executeQuery();
        while(rs.next())
            {
                Produto p = new Produto();
                p.setidProduto(rs.getInt("idProduto"));
                p.setnome(rs.getString("nome"));
                p.setcategoria(rs.getString("categoria"));
                p.setquantidade(rs.getInt("quantidade"));
                p.setpreco(rs.getDouble("preco"));
                
                listaProdutos.add(p);
            }
            
        }catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaProdutos = null;
        } finally{
            //Libero os recursos da memória
            try {
                if(rs!=null)
                    rs.close();                
                if(instrucaoSQL!=null)
                    instrucaoSQL.close();
                
                conexao.close();
                //GerenciadorConexao.fecharConexao();
                        
                } catch (SQLException ex) {
            }
        }
        
        return listaProdutos;
    }
    
    public static boolean Atualizar(Produto p) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
                
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("UPDATE produtos SET nome = ?, categoria=?, quandidade=?, preco=? WHERE idProduto =? ");
            
            
            instrucaoSQL.setString(1, p.getnome());
            instrucaoSQL.setString(2, p.getcategoria());
            instrucaoSQL.setInt(3, p.getquantidade());
            instrucaoSQL.setDouble(4, p.getpreco());
            instrucaoSQL.setInt(5, p.getidProduto());
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(linhasAfetadas>0)
            {
                retorno = true;
                
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys();//Recupero o ID
                if (generatedKeys.next()) {
                        p.setidProduto(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Falha ao obter o ID do produto.");
                }
            }
            else{
                retorno = false;
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally{
            
            //Libero os recursos da memória
            try {
                if(instrucaoSQL!=null)
                    instrucaoSQL.close();
                    GerenciadorConexao.fecharConexao();
                } catch (SQLException ex) {
            }
        }
        
        return retorno;
    }
    
    public static boolean Cadastrar(Produto p) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
                
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("INSERT INTO produtos (nome,categoria,quantidade,preco) VALUES(?,?,?,?)"
            , Statement.RETURN_GENERATED_KEYS);
            
            instrucaoSQL.setString(1, p.getnome());
            instrucaoSQL.setString(2, p.getcategoria());
            instrucaoSQL.setInt(3, p.getquantidade());
            instrucaoSQL.setDouble(4, p.getpreco());
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(linhasAfetadas>0)
            {
                retorno = true;
                
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys();//Recupero o ID
                if (generatedKeys.next()) {
                        p.setidProduto(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Falha ao obter o ID do produto.");
                }
            }
            else{
                retorno = false;
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally{
            
            //Libero os recursos da memória
            try {
                if(instrucaoSQL!=null)
                    instrucaoSQL.close();
                    GerenciadorConexao.fecharConexao();
                } catch (SQLException ex) {
            }
        }
        
        return retorno;
    }
    
    public static boolean Excluir(Produto p) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
                
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("DELETE FROM produtos WHERE idProduto = ?");
            
            instrucaoSQL.setInt(1, p.getidProduto());
            
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(linhasAfetadas>0)
            {
                retorno = true;
                
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys();//Recupero o ID
                if (generatedKeys.next()) {
                        p.setidProduto(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Falha ao obter o ID do produto.");
                }
            }
            else{
                retorno = false;
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally{
            
            //Libero os recursos da memória
            try {
                if(instrucaoSQL!=null)
                    instrucaoSQL.close();
                    GerenciadorConexao.fecharConexao();
                } catch (SQLException ex) {
            }
        }
        
        return retorno;
    }
    
}