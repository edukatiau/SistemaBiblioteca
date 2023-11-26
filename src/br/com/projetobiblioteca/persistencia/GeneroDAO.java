package br.com.projetobiblioteca.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetobiblioteca.model.Genero;

public class GeneroDAO {
    
    private ConexaoMySQL conexao;

    public GeneroDAO(){
        this.conexao = new ConexaoMySQL(BdConfigs.IP, BdConfigs.PORTA, BdConfigs.USER, BdConfigs.PASSWORD, BdConfigs.BD_NAME);
    }

    //metodo adicionar
    public Genero adicionar(Genero Genero) throws SQLException{
        //abrir conexao
        conexao.abrirConexao();

        //inserir no bd
        String sql = "INSERT INTO genero VALUES (null, ?)";
        PreparedStatement st;
        try {
            st = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, Genero.getGenero());
            int linhasAfetadas = st.executeUpdate();
            if(linhasAfetadas>0) {
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()) {
                    Genero.setId_Genero(rs.getLong(1));
                }			
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // fechar a conexao
            conexao.fecharConexao();
        }
        return Genero;
    }

    //buscarporNome
    public Genero buscarPorNome(String nomeGenero) {
		Genero u = null;
		// abrir conexao com bd
		this.conexao.abrirConexao();
		// inserir no banco
		String sql = "SELECT * FROM genero WHERE nome=?;";
		PreparedStatement st;
		try {
			st = conexao.getConexao().prepareStatement(sql);
			st.setString(1, nomeGenero);
			ResultSet rs = st.executeQuery();
			// converter a linha inteira do rs em um usuario
			// o rs é tudo que veio da busca no banco
			if (rs.next()) {
				// converter a linha em um usuario
				u = new Genero();
				u.setId_Genero(rs.getLong("id_genero"));
				u.setGenero(rs.getString("nome"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// fechar a conexao
			conexao.fecharConexao();
		}
		return u;
	}

    // buscarPorId
    public Genero buscarPorId(long id) {
        Genero b = null;
        // abrir conexao com bd
        this.conexao.abrirConexao();
        // inserir no banco
        String sql = "SELECT * FROM genero WHERE id_genero=?;";
        PreparedStatement st;
        try {
            st = conexao.getConexao().prepareStatement(sql);
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                b = new Genero();
                b.setId_Genero(rs.getLong("id_genero"));
                b.setGenero(rs.getString("nome"));
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
    public List<Genero> listarTiposObras(){
        List<Genero> listaGenero = new ArrayList<>();
        Genero c = null;
        // abrir conexao com bd
        this.conexao.abrirConexao();
        // inserir no banco
        String sql = "SELECT * FROM genero;";
        PreparedStatement st;
        try {
            st = conexao.getConexao().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                c = new Genero();
                c.setId_Genero(rs.getLong("id_genero"));
                c.setGenero(rs.getString("nome"));
                listaGenero.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // fechar a conexao
            conexao.fecharConexao();
        }
        return listaGenero;
    }

    //metodo atualizar
    public Genero editar(Genero Genero){
        this.conexao.abrirConexao();

        //atualizar no bd
        String sql = "UPDATE genero SET nome=? WHERE id_genero=?";
        PreparedStatement st;
        try {
            st = conexao.getConexao().prepareStatement(sql);
            st.setString(1, Genero.getGenero());
            st.setLong(2, Genero.getId_Genero());
            int linhasAfetadas = st.executeUpdate();
            if(linhasAfetadas>0) {
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()) {
                    Genero.setId_Genero(rs.getLong(1));
                }			
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // fechar a conexao
            conexao.fecharConexao();
        }
        return Genero;
    }

    //metodo deletar
    public void deletar(Genero Genero){
        //abrir conexao
        conexao.abrirConexao();
        //inserir no bd
        String sql = "DELETE FROM genero WHERE id_genero=?";
        PreparedStatement st;
        try {
            st = conexao.getConexao().prepareStatement(sql);
            st.setLong(1, Genero.getId_Genero());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // fechar a conexao
            conexao.fecharConexao();
        }
    }
}
