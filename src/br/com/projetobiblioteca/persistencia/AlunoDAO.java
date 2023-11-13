package br.com.projetobiblioteca.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetobiblioteca.model.Aluno;

public class AlunoDAO {
    
    private ConexaoMySQL conexao;

    public AlunoDAO(){
        this.conexao = new ConexaoMySQL(BdConfigs.IP, BdConfigs.PORTA, BdConfigs.USER, BdConfigs.PASSWORD, BdConfigs.BD_NAME);
    }

    //metodo adicionar
    public void adicionar(Aluno aluno) throws SQLException{
        //abrir conexao
        conexao.abrirConexao();

        //inserir no bd
        String sql = "INSERT INTO aluno VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement st;
		try {
			st = conexao.getConexao().prepareStatement(sql);
			st.setString(1, aluno.getNome());
			st.setString(2, aluno.getEmail());
			st.setString(3, aluno.getSenha());
            st.setString(4, aluno.getMatricula());
            st.setString(5, aluno.getCurso());
            st.setLong(6, 2);
            st.setLong(7, 1);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// fechar a conexao
			conexao.fecharConexao();
		}
    }

    //metodo buscarporId
    // buscarPorId
	public Aluno buscarPorId(long id) {
		Aluno u = null;
		// abrir conexao com bd
		this.conexao.abrirConexao();
		// inserir no banco
		String sql = "SELECT * FROM aluno WHERE id_aluno=?;";
		PreparedStatement st;
		try {
			st = conexao.getConexao().prepareStatement(sql);
			st.setLong(1, id);
			ResultSet rs = st.executeQuery();
			// converter a linha inteira do rs em um usuario
			// o rs � tudo que veio da busca no banco
			if (rs.next()) {
				// converter a linha em um usuario
				u = new Aluno();
				u.setId(rs.getLong("id_aluno"));
				u.setNome(rs.getString("nome"));
				u.setEmail(rs.getString("email"));
				u.setSenha(rs.getString("senha"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// fechar a conexao
			conexao.fecharConexao();
		}
		return u;
	}


    //metodo buscartodos
	// buscarTodos
	public List<Aluno> buscarTodos() {
		List<Aluno> listaAlunos = new ArrayList<>();
		Aluno u = null;
		// abrir conexao com bd
		this.conexao.abrirConexao();
		// inserir no banco
		String sql = "SELECT * FROM aluno;";
		PreparedStatement st;
		try {
			st = conexao.getConexao().prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			// converter a linha inteira do rs em um usuario
			// o rs � tudo que veio da busca no banco
			while (rs.next()) {
				// converter a linha em um usuario
				u = new Aluno();
				u.setId(rs.getLong("id_aluno"));
				u.setNome(rs.getString("nome"));
				u.setEmail(rs.getString("email"));
				u.setSenha(rs.getString("senha"));
				listaAlunos.add(u);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// fechar a conexao
			conexao.fecharConexao();
		}
		return listaAlunos;
	}


    //metodo editar
    // editar
	public void editar(Aluno aluno) {
		// abrir conexao com bd
		this.conexao.abrirConexao();
		// inserir no banco
		String sql = "UPDATE aluno SET nome=?, email=?, senha=? WHERE id_aluno=?;";
		PreparedStatement st;
		try {
			st = conexao.getConexao().prepareStatement(sql);
			st.setString(1, aluno.getNome());
			st.setString(2, aluno.getEmail());
			st.setString(3, aluno.getSenha());
			st.setLong(4, aluno.getIdUsuario());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// fechar a conexao
			conexao.fecharConexao();
		}
	}

    //metodo excluir
    // excluir
	public void excluir(long id) {
		// abrir conexao com bd
		this.conexao.abrirConexao();
		// inserir no banco
		String sql = "DELETE FROM aluno WHERE id_aluno=?;";
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
}