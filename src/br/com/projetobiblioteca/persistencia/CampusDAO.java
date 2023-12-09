package br.com.projetobiblioteca.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetobiblioteca.model.Biblioteca;
import br.com.projetobiblioteca.model.Campus;

public class CampusDAO {
    
    private ConexaoMySQL conexao;

    public CampusDAO(){
        this.conexao = new ConexaoMySQL(BdConfigs.IP, BdConfigs.PORTA, BdConfigs.USER, BdConfigs.PASSWORD, BdConfigs.BD_NAME);
    }

    //metodo adicionar
    public Campus adicionar(Campus campus) throws SQLException{
        //abrir conexao
        conexao.abrirConexao();

        //inserir no bd
        String sql = "INSERT INTO campus VALUES (null, ?, ?, ?, ?)";
        PreparedStatement st;
        try {
            st = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, campus.getNome());
            st.setString(2, campus.getEndereco());
            st.setString(3, campus.getTelefone());
            st.setLong(4, campus.getBiblioteca().getId_biblioteca());
            int linhasAfetadas = st.executeUpdate();
            if(linhasAfetadas>0) {
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()) {
                    campus.setId_campus(rs.getLong(1));
                }			
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // fechar a conexao
            conexao.fecharConexao();
        }
        return campus;
    }

    //metodo buscarporId
    // buscarPorId
    public Campus buscarPorId(long id) {
        Campus c = null;
        // abrir conexao com bd
        this.conexao.abrirConexao();
        // inserir no banco
        String sql = "SELECT * FROM campus WHERE id_campus=?;";
        PreparedStatement st;
        try {
            st = conexao.getConexao().prepareStatement(sql);
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                c = new Campus();
                c.setId_campus(rs.getLong("id_campus"));
                c.setNome(rs.getString("nome"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // fechar a conexao
            conexao.fecharConexao();
        }
        return c;
    }

    //metodo buscarTodos
    public List<Campus> buscarTodos(){
        List<Campus> listaCampus = new ArrayList<>();
        Campus c = null;
        // abrir conexao com bd
        this.conexao.abrirConexao();
        // inserir no banco
        String sql = "SELECT * FROM campus;";
        PreparedStatement st;
        try {
            st = conexao.getConexao().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                c = new Campus();
                c.setId_campus(rs.getLong("id_campus"));
                c.setNome(rs.getString("nome"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));
                c.setBiblioteca(new BibliotecaDAO().buscarPorId(rs.getLong("id_biblioteca")));
                listaCampus.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // fechar a conexao
            conexao.fecharConexao();
        }   
        return listaCampus;
    }

    //metodo atualizar
    public void editar(Campus campus, Biblioteca biblioteca) throws SQLException{
        //abrir conexao
        conexao.abrirConexao();

        //atualizar no bd
        String sql = "UPDATE campus SET nome=?, endereco=?, telefone=?, id_biblioteca=? WHERE id_campus=?";
        PreparedStatement st;
        try {
            st = conexao.getConexao().prepareStatement(sql);
            st.setString(1, campus.getNome());
            st.setString(2, campus.getEndereco());
            st.setString(3, campus.getTelefone());
            st.setLong(4, campus.getId_campus());
            st.setLong(5, biblioteca.getId_biblioteca());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // fechar a conexao
            conexao.fecharConexao();
        }
    }

    //metodo deletar
    public void deletar(long id) throws SQLException{
        //abrir conexao
        conexao.abrirConexao();

        //deletar no bd
        String sql = "DELETE FROM campus WHERE id_campus=?";
        PreparedStatement st;
        try {
            st = conexao.getConexao().prepareStatement(sql);
            st.setLong(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // fechar a conexao
            conexao.fecharConexao();
        }   
    }

    public Campus buscarPorNome(String nome) {
        Campus c = null;
        // abrir conexao com bd
        conexao.abrirConexao();
        // buscar no banco
        String sql = "SELECT * FROM campus WHERE nome=?;";
        PreparedStatement st;
        try {
            st = conexao.getConexao().prepareStatement(sql);
            st.setString(1, nome);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                c = new Campus();
                c.setId_campus(rs.getLong("id_campus"));
                c.setNome(rs.getString("nome"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));
                c.setBiblioteca(new BibliotecaDAO().buscarPorId(rs.getLong("id_biblioteca")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // fechar a conexao
            conexao.fecharConexao();
        }

        return c;
    }
}