package br.com.projetobiblioteca.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetobiblioteca.model.Biblioteca;
import br.com.projetobiblioteca.model.Campus;
import br.com.projetobiblioteca.model.Funcionário;


public class FuncionarioDAO{
    
    private ConexaoMySQL conexao;

    public FuncionarioDAO(){
        this.conexao = new ConexaoMySQL(BdConfigs.IP, BdConfigs.PORTA, BdConfigs.USER, BdConfigs.PASSWORD, BdConfigs.BD_NAME);
    }

    //metodo adicionar
    public Funcionário adicionar(Funcionário funcionario) throws SQLException{
        //abrir conexao
        conexao.abrirConexao();

        //inserir no bd
        String sql = "INSERT INTO funcionario VALUES (null, ?, ?, ?, ?)";
        PreparedStatement st;
		try {
			st = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			st.setString(1, funcionario.getNome());
			st.setString(2, funcionario.getEmail());
			st.setString(3, funcionario.getSenha());
            st.setLong(4, funcionario.getBiblioteca().getId_biblioteca());
			int linhasAfetadas = st.executeUpdate();
			if(linhasAfetadas>0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					funcionario.setIdUsuario(rs.getLong(1));
				}			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// fechar a conexao
			conexao.fecharConexao();
		}
		return funcionario;
    }

    //metodo buscarporId
    // buscarPorId
	public Funcionário buscarPorId(long id) {
		Funcionário f = null;
		// abrir conexao com bd
		this.conexao.abrirConexao();
		// inserir no banco
		String sql = "SELECT * FROM funcionario WHERE id_funcionario=?;";
		PreparedStatement st;
		try {
			st = conexao.getConexao().prepareStatement(sql);
			st.setLong(1, id);
			ResultSet rs = st.executeQuery();
			// converter a linha inteira do rs em um usuario
			// o rs é tudo que veio da busca no banco
			if (rs.next()) {
				// converter a linha em um usuario
				f = new Funcionário();
				f.setIdUsuario(rs.getLong("id_funcionario"));
				f.setNome(rs.getString("nome"));
				f.setEmail(rs.getString("email"));
				f.setSenha(rs.getString("senha"));
				f.setBiblioteca(new BibliotecaDAO().buscarPorId(rs.getLong("id_biblioteca")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// fechar a conexao
			conexao.fecharConexao();
		}
		return f;
	}

	//metodo buscarporEmail
    // buscarPorEmail
	public Funcionário buscarPorEmail(String email) {
		Funcionário f = null;
		// abrir conexao com bd
		this.conexao.abrirConexao();
		// inserir no banco
		String sql = "SELECT * FROM funcionario WHERE email=?;";
		PreparedStatement st;
		try {
			st = conexao.getConexao().prepareStatement(sql);
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
			// converter a linha inteira do rs em um usuario
			// o rs é tudo que veio da busca no banco
			if (rs.next()) {
				// converter a linha em um usuario
				f = new Funcionário();
				f.setIdUsuario(rs.getLong("id_funcionario"));
				f.setNome(rs.getString("nome"));
				f.setEmail(rs.getString("email"));
				f.setSenha(rs.getString("senha"));
				f.setBiblioteca(new BibliotecaDAO().buscarPorId(rs.getLong("id_biblioteca")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// fechar a conexao
			conexao.fecharConexao();
		}
		return f;
	}


    //metodo buscartodos
	// buscarTodos
	public List<Funcionário> buscarTodos() {
		List<Funcionário> listaFuncionarios = new ArrayList<>();
		Funcionário u = null;
		// abrir conexao com bd
		this.conexao.abrirConexao();
		// inserir no banco
		String sql = "SELECT * FROM funcionario;";
		PreparedStatement st;
		try {
			st = conexao.getConexao().prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			// converter a linha inteira do rs em um usuario
			// o rs é tudo que veio da busca no banco
			while (rs.next()) {
				// converter a linha em um usuario
				u = new Funcionário();
				u.setIdUsuario(rs.getLong("id_funcionario"));
				u.setNome(rs.getString("nome"));
				u.setEmail(rs.getString("email"));
				u.setSenha(rs.getString("senha"));
				u.setBiblioteca(new BibliotecaDAO().buscarPorId(rs.getLong("id_biblioteca")));
				listaFuncionarios.add(u);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// fechar a conexao
			conexao.fecharConexao();
		}
		return listaFuncionarios;
	}


    //metodo editar
    // editar
	public void editar(Funcionário funcionario) {
		// abrir conexao com bd
		this.conexao.abrirConexao();
		// inserir no banco
		String sql = "UPDATE funcionario SET nome=?, email=?, senha=? WHERE id_funcionario=?;";
		PreparedStatement st;
		try {
			st = conexao.getConexao().prepareStatement(sql);
			st.setString(1, funcionario.getNome());
			st.setString(2, funcionario.getEmail());
			st.setString(3, funcionario.getSenha());
			st.setLong(4, funcionario.getIdUsuario());
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
		String sql = "DELETE FROM funcionario WHERE id_funcionario=?;";
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

	//metodo login
	// login
	public boolean loginAdm(String email, String senha) {
		Funcionário f = null;
		// abrir conexao com bd
		this.conexao.abrirConexao();
		// inserir no banco
		String sql = "SELECT * FROM funcionario WHERE email=? AND senha=?;";
		PreparedStatement st;
		try {
			st = conexao.getConexao().prepareStatement(sql);
			st.setString(1, email);
			st.setString(2, senha);
			ResultSet rs = st.executeQuery();
			// converter a linha inteira do rs em um usuario
			// o rs é tudo que veio da busca no banco
			if (rs.next()) {
				// converter a linha em um usuario
				f = new Funcionário();
				f.setIdUsuario(rs.getLong("id_funcionario"));
				f.setNome(rs.getString("nome"));
				f.setEmail(rs.getString("email"));
				f.setSenha(rs.getString("senha"));

				if(f.getEmail().equals("admin") && f.getSenha().equals("admin")){
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// fechar a conexao
			conexao.fecharConexao();
		}
		return false;
	}

	public boolean login(String email, String senha){
		Funcionário f = null;
		// abrir conexao com bd
		this.conexao.abrirConexao();
		// inserir no banco
		String sql = "SELECT * FROM funcionario WHERE email=? AND senha=?;";
		PreparedStatement st;
		try {
			st = conexao.getConexao().prepareStatement(sql);
			st.setString(1, email);
			st.setString(2, senha);
			ResultSet rs = st.executeQuery();
			// converter a linha inteira do rs em um usuario
			// o rs é tudo que veio da busca no banco
			if (rs.next()) {
				// converter a linha em um usuario
				f = new Funcionário();
				f.setIdUsuario(rs.getLong("id_funcionario"));
				f.setNome(rs.getString("nome"));
				f.setEmail(rs.getString("email"));
				f.setSenha(rs.getString("senha"));

				if(f.getEmail().equals(email) && f.getSenha().equals(senha)){
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// fechar a conexao
			conexao.fecharConexao();
		}
		return false;
	}

    public List<Funcionário> buscarPorBiblioteca(long id_biblioteca) {
        List<Funcionário> funcionariosList = new ArrayList<>();
        
        conexao.abrirConexao();
        
        String sql = "SELECT * FROM funcionario WHERE id_biblioteca=?;";
        PreparedStatement st;
        
        try {
            st = conexao.getConexao().prepareStatement(sql);
            st.setLong(1, id_biblioteca);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Funcionário funcionario = new Funcionário();
				funcionario.setIdUsuario(rs.getLong("id_funcionario"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setEmail(rs.getString("email"));
				funcionario.setSenha(rs.getString("senha"));
				funcionario.setBiblioteca(new BibliotecaDAO().buscarPorId(rs.getLong("id_biblioteca")));
				funcionariosList.add(funcionario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conexao.fecharConexao();
        }

        return funcionariosList;
    }
}
