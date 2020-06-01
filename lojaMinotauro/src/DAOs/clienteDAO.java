package DAOs;
import GerenciarConexao.GerenciadorConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Cliente;

public class clienteDAO {
    public static boolean Salvar(Cliente c) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
                
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("INSERT INTO produtos (nome,sexo,cpf,email,endereco"
            + ",telefone,estCivil,nascimento) VALUES(?,?,?,?,?,?,?,?)"
            , Statement.RETURN_GENERATED_KEYS);
            
            instrucaoSQL.setString(1, c.getNome());
            instrucaoSQL.setString(2, c.getSexo());
            instrucaoSQL.setInt(3, c.getCPF());
            instrucaoSQL.setString(4, c.getEmail());
            instrucaoSQL.setString(5, c.getEndereco());
            instrucaoSQL.setInt(6, c.getTelefone());
            instrucaoSQL.setString(7, c.getEstCivil());
            instrucaoSQL.setInt(8, c.getNascimento());
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(linhasAfetadas>0)
            {
                retorno = true;
                
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys();//Recupero o ID
                if (generatedKeys.next()) {
                        c.setidCliente(generatedKeys.getInt(1));
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
    
    public static boolean Atualizar(Cliente c){
    boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
                
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("UPDATE produtos SET nome = ?, categoria=?, quandidade=?, preco=? WHERE idProduto =? ");
            
            
            instrucaoSQL.setString(1, c.getNome());
            instrucaoSQL.setString(2, c.getSexo());
            instrucaoSQL.setInt(3, c.getCPF());
            instrucaoSQL.setString(4, c.getEmail());
            instrucaoSQL.setString(5, c.getEndereco());
            instrucaoSQL.setInt(6, c.getTelefone());
            instrucaoSQL.setString(7, c.getEstCivil());
            instrucaoSQL.setInt(8, c.getNascimento());
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(linhasAfetadas>0)
            {
                retorno = true;
                
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys();//Recupero o ID
                if (generatedKeys.next()) {
                        c.setidCliente(generatedKeys.getInt(1));
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
    
    public static ArrayList<Cliente> Pesquisar (){
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        try {
        conexao = GerenciadorConexao.abrirConexao();
        instrucaoSQL = conexao.prepareStatement("SELECT NOME FROM cliente;");
        rs = instrucaoSQL.executeQuery();
        while(rs.next())
            {
                Cliente c = new Cliente();
                c.setidCliente(rs.getInt("idCliente"));
                c.setNome(rs.getString("nome"));
                c.setSexo(rs.getString("sexo"));
                c.setCPF(rs.getInt("cpf"));
                c.setEmail(rs.getString("email"));
                c.setEndereco(rs.getString("enreco"));
                c.setTelefone(rs.getInt("telefone"));
                c.setEstCivil(rs.getString("estCivil"));
                c.setNascimento(rs.getInt("nascimento"));
                
                listaClientes.add(c);
            }
            
        }catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaClientes = null;
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
        
        return listaClientes;
    }
    
    public static boolean Excluir(Cliente c) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
                
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("DELETE FROM produtos WHERE idProduto = ?");
            
            instrucaoSQL.setInt(1, c.getidCliente());
            
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(linhasAfetadas>0)
            {
                retorno = true;
                
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys();//Recupero o ID
                if (generatedKeys.next()) {
                        c.setidCliente(generatedKeys.getInt(1));
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
