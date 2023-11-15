package br.com.projetobiblioteca.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetobiblioteca.model.Obra;

public class ObraDAO {
    
    private ConexaoMySQL conexao;

    public ObraDAO(){
        this.conexao = new ConexaoMySQL(BdConfigs.IP, BdConfigs.PORTA, BdConfigs.USER, BdConfigs.PASSWORD, BdConfigs.BD_NAME);
    }

    //metodo adicionar
    public Obra adicionar(Obra obra) throws SQLException{
        //abrir conexao
        conexao.abrirConexao();

        //inserir no bd
        String sql = "INSERT INTO obra VALUES (null, ?, ?, ?, ?, ?, ?)";
        PreparedStatement st;
        try {
            st = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, obra.getTitulo());
            st.setString(2, obra.getAutor());
            st.setString(3, obra.getEdicao());
            st.setDate(4, obra.getDataLancamento());
            st.setLong(5, obra.getTipoObra().getId_tipoobra());
            st.setLong(6, obra.getBiblioteca().getId_biblioteca());
            int linhasAfetadas = st.executeUpdate();
            if(linhasAfetadas>0) {
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()) {
                    obra.setIdLivro(rs.getLong(1));
                }			
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // fechar a conexao
            conexao.fecharConexao();
        }
        return obra;
    }

    // buscarTodos
	public List<Obra> buscarTodos() {
		List<Obra> listaObras = new ArrayList<>();
		Obra u = null;
		// abrir conexao com bd
		this.conexao.abrirConexao();
		// inserir no banco
		String sql = "SELECT * FROM obra;";
		PreparedStatement st;
		try {
			st = conexao.getConexao().prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			// converter a linha inteira do rs em um usuario
			// o rs é tudo que veio da busca no banco
			while (rs.next()) {
				// converter a linha em um usuario
				u = new Obra();
				u.setIdLivro(rs.getLong("id_obra"));
                u.setTitulo(rs.getString("titulo"));
                u.setAutor(rs.getString("autor"));
                u.setEdicao(rs.getString("edicao"));
                u.setDataLancamento(rs.getDate("data_lancamento"));
                TipoObraDAO tipoObraDAO = new TipoObraDAO();
                u.setTipoObra(tipoObraDAO.buscarPorId(rs.getLong("id_tipoobra")));
                BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
                u.setBiblioteca(bibliotecaDAO.buscarPorId(rs.getLong("id_biblioteca")));
				listaObras.add(u);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// fechar a conexao
			conexao.fecharConexao();
		}
		return listaObras;
	}
}
