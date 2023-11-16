package br.com.projetobiblioteca.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.projetobiblioteca.model.Emprestimo;

public class EmprestimoDAO {
    
    private ConexaoMySQL conexao;

    public EmprestimoDAO() {
        this.conexao = new ConexaoMySQL(BdConfigs.IP, BdConfigs.PORTA, BdConfigs.USER, BdConfigs.PASSWORD, BdConfigs.BD_NAME);
    }

    //metodo adicionar
    public Emprestimo adicionar(Emprestimo emprestimo){
        //abrir conexao
        conexao.abrirConexao();

        //inserir no bd
        String sql = "INSERT INTO emprestimo VALUES (null, ?, ?, ?, ?, ?, ?)";
        PreparedStatement st;
        try {
            st = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setDate(1, emprestimo.getDataEmprestimo());
            st.setDate(2, emprestimo.getDataDevolucao());
            st.setDate(3, emprestimo.getDataDevolucaoEfetiva());
            st.setString(4, emprestimo.getStatus());
            st.setLong(5, emprestimo.getAluno().getIdUsuario());
            st.setLong(6, emprestimo.getObras().getIdObra());
            int linhasAfetadas = st.executeUpdate();
            if(linhasAfetadas>0) {
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()) {
                    emprestimo.setIdEmprestimo(rs.getLong(1));
                }			
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // fechar a conexao
            conexao.fecharConexao();
        }
        return emprestimo;
    }

    //metodo buscarporId
    public Emprestimo buscarPorID(long id){
        Emprestimo u = null;
        this.conexao.abrirConexao();

        String sql = "SELECT * FROM emprestimo WHERE id_emprestimo=?";
        PreparedStatement st;
        try {
            st = conexao.getConexao().prepareStatement(sql);
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                u = new Emprestimo();
                u.setIdEmprestimo(rs.getLong("id_emprestimo"));
                u.setDataEmprestimo(rs.getDate("data_emprestimo"));
                u.setDataDevolucao(rs.getDate("data_devolucao"));
                u.setDataDevolucaoEfetiva(rs.getDate("data_devolucao_efetiva"));
                u.setStatus(rs.getString("status"));
                u.setAluno(new AlunoDAO().buscarPorId(rs.getLong("id_aluno")));
                u.setObras(new ObraDAO().buscarPorId(rs.getLong("id_obra")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    //metodo atualizar
    public Emprestimo editar(Emprestimo emprestimo){
        // abrir conexao com bd
		this.conexao.abrirConexao();
		// inserir no banco
        String sql = "UPDATE emprestimo SET data_emprestimo=?, data_devolucao=?, data_devolucao_efetiva=?, status=?, id_aluno=?, id_obra=? WHERE id_emprestimo=?;";
        PreparedStatement st;
		try {
			st = conexao.getConexao().prepareStatement(sql);
            st.setDate(1, emprestimo.getDataEmprestimo());
            st.setDate(2, emprestimo.getDataDevolucao());
            st.setDate(3, emprestimo.getDataDevolucaoEfetiva());
            st.setString(4, emprestimo.getStatus());
            st.setLong(5, emprestimo.getAluno().getIdUsuario());
            st.setLong(6, emprestimo.getObras().getIdObra());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// fechar a conexao
			conexao.fecharConexao();
		}
        return emprestimo;
    }

    //metodo deletar
    public void deletar(Emprestimo emprestimo){
        //abrir conexao
        conexao.abrirConexao();

        //inserir no bd
        String sql = "DELETE FROM emprestimo WHERE id_emprestimo=?";
        PreparedStatement st;
        try {
            st = conexao.getConexao().prepareStatement(sql);
            st.setLong(1, emprestimo.getIdEmprestimo());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // fechar a conexao
            conexao.fecharConexao();
        }
    }
}