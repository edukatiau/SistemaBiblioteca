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
}
