package br.com.projetobiblioteca.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    //metodo buscarporId
    public Biblioteca buscarPorId(long id) {
        Biblioteca b = null;
        // abrir conexao com bd
        this.conexao.abrirConexao();
        // inserir no banco
        String sql = "SELECT * FROM campus WHERE id_biblioteca=?;";
        PreparedStatement st;
        try {
            st = conexao.getConexao().prepareStatement(sql);
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                b = new Biblioteca();
                b.setId_biblioteca(rs.getLong("id_biblioteca"));
                b.setNome(rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // fechar a conexao
            conexao.fecharConexao();
        }
        return b;
    }

    //metodo buscarTodos
    public List<Biblioteca> buscarTodos(){
        List<Biblioteca> listaBibliotecas = new ArrayList<>();
        Biblioteca u = null;
        this.conexao.abrirConexao();
        //inserir no bd
        String sql = "SELECT * FROM biblioteca";
        PreparedStatement st;
        try {
            st = conexao.getConexao().prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			// converter a linha inteira do rs em um usuario
			// o rs é tudo que veio da busca no banco
			while (rs.next()) {
				// converter a linha em um usuario
				u = new Biblioteca();
				u.setId_biblioteca(rs.getLong("id_biblioteca"));
				u.setNome(rs.getString("nome"));
				listaBibliotecas.add(u);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// fechar a conexao
			conexao.fecharConexao();
		}
		return listaBibliotecas;
    }

    //metodo atualizar
    public Biblioteca editar(Biblioteca biblioteca){
        this.conexao.abrirConexao();
        //inserir no bd
        String sql = "UPDATE biblioteca SET nome=? WHERE id_biblioteca=?";
        PreparedStatement st;
        try {
            st = conexao.getConexao().prepareStatement(sql);
            st.setString(1, biblioteca.getNome());
            st.setLong(2, biblioteca.getId_biblioteca());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // fechar a conexao
            conexao.fecharConexao();
        }
        return biblioteca;
    }

    //metodo deletar
    public void deletar(Biblioteca biblioteca){
        //abrir conexao
        conexao.abrirConexao();
        //inserir no bd
        String sql = "DELETE FROM biblioteca WHERE id_biblioteca=?";
        PreparedStatement st;
        try {
            st = conexao.getConexao().prepareStatement(sql);
            st.setLong(1, biblioteca.getId_biblioteca());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // fechar a conexao
            conexao.fecharConexao();
        }
    }
}
