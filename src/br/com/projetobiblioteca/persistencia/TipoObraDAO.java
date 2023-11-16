package br.com.projetobiblioteca.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        String sql = "INSERT INTO tipoobra VALUES (null, ?)";
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
		String sql = "SELECT * FROM tipoobra WHERE nome=?;";
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
				u.setId_tipoobra(rs.getLong("id_tipoobra"));
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
        String sql = "SELECT * FROM tipoobra WHERE id_tipoobra=?;";
        PreparedStatement st;
        try {
            st = conexao.getConexao().prepareStatement(sql);
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                b = new TipoObra();
                b.setId_tipoobra(rs.getLong("id_tipoobra"));
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

    //metodo atualizar

    //metodo deletar
}
