package br.com.projetobiblioteca.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.projetobiblioteca.model.Biblioteca;

public class BibliotecaDAO {
    private ConexaoMySQL conexao;
    
    public BibliotecaDAO(){
        this.conexao = new ConexaoMySQL(BdConfigs.IP, BdConfigs.PORTA, BdConfigs.USER, BdConfigs.PASSWORD, BdConfigs.BD_NAME);
    }
    
    //metodo adicionar
    public Biblioteca adicionar(Biblioteca biblioteca) throws SQLException{
        //abrir conexao
        conexao.abrirConexao();
        //inserir no bd
        String sql = "INSERT INTO biblioteca VALUES (null)";
        PreparedStatement st;
        try {
            st = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            int linhasAfetadas = st.executeUpdate();
            if(linhasAfetadas>0) {
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()) {
                    biblioteca.setId_biblioteca(rs.getLong(1));
                }			
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // fechar a conexao
            conexao.fecharConexao();
        }
        return biblioteca;    
    }
}
