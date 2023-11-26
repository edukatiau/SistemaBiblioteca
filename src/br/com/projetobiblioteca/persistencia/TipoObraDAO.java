package br.com.projetobiblioteca.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetobiblioteca.model.TipoObra;

public class TipoObraDAO {
    
    private ConexaoMySQL conexao;

    public TipoObraDAO(){
        this.conexao = new ConexaoMySQL(BdConfigs.IP, BdConfigs.PORTA, BdConfigs.USER, BdConfigs.PASSWORD, BdConfigs.BD_NAME);
    }

    //metodo adicionar
    public TipoObra adicionar(TipoObra tipoobra) throws SQLException{
        //abrir conexao
        conexao.abrirConexao();

        //inserir no bd
        String sql = "INSERT INTO genero VALUES (null, ?)";
        PreparedStatement st;
        try {
            st = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, tipoobra.getTIPO_OBRA());
            int linhasAfetadas = st.executeUpdate();
            if(linhasAfetadas>0) {
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()) {
                    tipoobra.setId_tipoobra(rs.getLong(1));
                }			
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // fechar a conexao
            conexao.fecharConexao();
        }
        return tipoobra;
    }

    //buscarporNome
    public TipoObra buscarPorNome(String nomeTipoObra) {
		TipoObra u = null;
		// abrir conexao com bd
		this.conexao.abrirConexao();
		// inserir no banco
		String sql = "SELECT * FROM genero WHERE nome=?;";
		PreparedStatement st;
		try {
			st = conexao.getConexao().prepareStatement(sql);
			st.setString(1, nomeTipoObra);
			ResultSet rs = st.executeQuery();
			// converter a linha inteira do rs em um usuario
			// o rs é tudo que veio da busca no banco
			if (rs.next()) {
				// converter a linha em um usuario
				u = new TipoObra();
				u.setId_tipoobra(rs.getLong("id_genero"));
				u.setTIPO_OBRA(rs.getString("nome"));
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
    public TipoObra buscarPorId(long id) {
        TipoObra b = null;
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
                b = new TipoObra();
                b.setId_tipoobra(rs.getLong("id_genero"));
                b.setTIPO_OBRA(rs.getString("nome"));
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
    public List<TipoObra> listarTiposObras(){
        List<TipoObra> listaTipoObra = new ArrayList<>();
        TipoObra c = null;
        // abrir conexao com bd
        this.conexao.abrirConexao();
        // inserir no banco
        String sql = "SELECT * FROM genero;";
        PreparedStatement st;
        try {
            st = conexao.getConexao().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                c = new TipoObra();
                c.setId_tipoobra(rs.getLong("id_genero"));
                c.setTIPO_OBRA(rs.getString("nome"));
                listaTipoObra.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // fechar a conexao
            conexao.fecharConexao();
        }
        return listaTipoObra;
    }

    //metodo atualizar
    public TipoObra editar(TipoObra tipoobra){
        this.conexao.abrirConexao();

        //atualizar no bd
        String sql = "UPDATE genero SET nome=? WHERE id_genero=?";
        PreparedStatement st;
        try {
            st = conexao.getConexao().prepareStatement(sql);
            st.setString(1, tipoobra.getTIPO_OBRA());
            st.setLong(2, tipoobra.getId_tipoobra());
            int linhasAfetadas = st.executeUpdate();
            if(linhasAfetadas>0) {
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()) {
                    tipoobra.setId_tipoobra(rs.getLong(1));
                }			
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // fechar a conexao
            conexao.fecharConexao();
        }
        return tipoobra;
    }

    //metodo deletar
    public void deletar(TipoObra tipoObra){
        //abrir conexao
        conexao.abrirConexao();
        //inserir no bd
        String sql = "DELETE FROM genero WHERE id_genero=?";
        PreparedStatement st;
        try {
            st = conexao.getConexao().prepareStatement(sql);
            st.setLong(1, tipoObra.getId_tipoobra());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // fechar a conexao
            conexao.fecharConexao();
        }
    }
}
