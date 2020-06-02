package DAOs;
import GerenciarConexao.GerenciadorConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Vendedor;

public class vendedorDAO {
    public static boolean Salvar(Vendedor c) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
                
    try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("INSERT INTO vendedores (nome,sexo,cpf,email,endereco"
            + ",telefone,estCivil,nascimento) VALUES(?,?,?,?,?,?,?,?)"
            , Statement.RETURN_GENERATED_KEYS);
            
            instrucaoSQL.setString(1, c.getNome());
            instrucaoSQL.setString(2, c.getSexo());
            instrucaoSQL.setString(3, c.getCPF());
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(linhasAfetadas>0)
            {
                retorno = true;
                
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys();//Recupero o ID
                if (generatedKeys.next()) {
                        c.setidVendedor(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Falha ao obter o ID do vendedor.");
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
        
    public static boolean Atualizar(Vendedor c){
    boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
                
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("UPDATE vendedor SET nome = ?, sexo=?, cpf=? WHERE idVend =? ");
            
            
            instrucaoSQL.setString(1, c.getNome());
            instrucaoSQL.setString(2, c.getSexo());
            instrucaoSQL.setString(3, c.getCPF());
            
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(linhasAfetadas>0)
            {
                retorno = true;
                
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys();//Recupero o ID
                if (generatedKeys.next()) {
                        c.setidVendedor(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Falha ao obter o ID do vendedor.");
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
    
    public static ArrayList<Vendedor> Pesquisar (){
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ArrayList<Vendedor> listaVendedores = new ArrayList<Vendedor>();
        try {
        conexao = GerenciadorConexao.abrirConexao();
        instrucaoSQL = conexao.prepareStatement("SELECT NOME FROM vendedores;");
        rs = instrucaoSQL.executeQuery();
        while(rs.next())
            {
                Vendedor c = new Vendedor();
                c.setidVendedor(rs.getInt("idVend"));
                c.setNome(rs.getString("nome"));
                c.setSexo(rs.getString("sexo"));
                c.setCPF(rs.getString("cpf"));
                
                listaVendedores.add(c);
            }
            
        }catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaVendedores = null;
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
        
        return listaVendedores;
    }
    
    public static boolean Excluir(Vendedor c) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
                
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("DELETE FROM vendedores WHERE idVend = ?");
            
            instrucaoSQL.setInt(1, c.getidVendedor());
            
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(linhasAfetadas>0)
            {
                retorno = true;
                
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys();//Recupero o ID
                if (generatedKeys.next()) {
                        c.setidVendedor(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Falha ao obter o ID do vendedor.");
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
