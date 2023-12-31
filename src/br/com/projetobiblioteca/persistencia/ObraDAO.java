package br.com.projetobiblioteca.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetobiblioteca.model.Obra;
import br.com.projetobiblioteca.model.Genero;

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
        String sql = "INSERT INTO obra VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement st;
        try {
            st = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, obra.getTitulo());
            st.setString(2, obra.getAutor());
            st.setString(3, obra.getEdicao());
            st.setString(4, obra.getAnoLancamento());

            st.setInt(5, obra.getObraEmprestada() ? 1 : 0);

            st.setLong(6, obra.getGenero().getId_Genero());
            st.setLong(7, obra.getBiblioteca().getId_biblioteca());
            int linhasAfetadas = st.executeUpdate();
            if(linhasAfetadas>0) {
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()) {
                    obra.setIdObra(rs.getLong(1));
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
				u.setIdObra(rs.getLong("id_obra"));
                u.setTitulo(rs.getString("titulo"));
                u.setAutor(rs.getString("autor"));
                u.setEdicao(rs.getString("edicao"));
                u.setAnoLancamento(rs.getString("ano_lancamento"));
                
                u.setObraEmprestada(rs.getInt("emprestado") == 1 ? true : false);

                GeneroDAO GeneroDAO = new GeneroDAO();
                u.setGenero(GeneroDAO.buscarPorId(rs.getLong("id_genero")));
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

    public Obra buscarPorId(long idObra) {
        Obra u = null;
		// abrir conexao com bd
		this.conexao.abrirConexao();
		// inserir no banco
		String sql = "SELECT * FROM obra WHERE id_obra=?;";
		PreparedStatement st;
		try {
			st = conexao.getConexao().prepareStatement(sql);
			st.setLong(1, idObra);
			ResultSet rs = st.executeQuery();
			// converter a linha inteira do rs em um usuario
			// o rs é tudo que veio da busca no banco
			if (rs.next()) {
				// converter a linha em um usuario
				u = new Obra();
				u.setIdObra(rs.getLong("id_obra"));
                u.setTitulo(rs.getString("titulo"));
                u.setAutor(rs.getString("autor"));
                u.setEdicao(rs.getString("edicao"));
                u.setAnoLancamento(rs.getString("ano_lancamento"));

                u.setObraEmprestada(rs.getInt("emprestado") == 1 ? true : false);

                GeneroDAO GeneroDAO = new GeneroDAO();
                u.setGenero(GeneroDAO.buscarPorId(rs.getLong("id_genero")));
                BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
                u.setBiblioteca(bibliotecaDAO.buscarPorId(rs.getLong("id_biblioteca")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// fechar a conexao
			conexao.fecharConexao();
		}
		return u;
	}

    //metodo atualizar 
    public Obra editar(Obra obra){
        this.conexao.abrirConexao();

        String sql = "UPDATE obra SET titulo=?, autor=?, edicao=?, ano_lancamento=?, emprestado=?, id_genero=?, id_biblioteca=? WHERE id_obra=?";
        PreparedStatement st;
        try {
            st = conexao.getConexao().prepareStatement(sql);
            st.setString(1, obra.getTitulo());
            st.setString(2, obra.getAutor());
            st.setString(3, obra.getEdicao());
            st.setString(4, obra.getAnoLancamento());
            
            st.setInt(5, obra.getObraEmprestada() ? 1 : 0);
            
            st.setLong(6, obra.getGenero().getId_Genero());
            st.setLong(7, obra.getBiblioteca().getId_biblioteca());
            st.setLong(8, obra.getIdObra());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // fechar a conexao
            conexao.fecharConexao();
        }
        return obra;
    }

    //metodo deletar
    public void deletar(Obra obra){
        this.conexao.abrirConexao();

        String sql = "DELETE FROM obra WHERE id_obra=?";
        PreparedStatement st;
        try {
            st = conexao.getConexao().prepareStatement(sql);
            st.setLong(1, obra.getIdObra());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // fechar a conexao
            conexao.fecharConexao();
        }
    }

    public List<Obra> buscarPorGenero(String genero) {
        List<Obra> listaObras = new ArrayList<>();
        
        conexao.abrirConexao();
        
        String sql = "SELECT * FROM obra WHERE id_genero=?;";
        PreparedStatement st;
        
        try {
            st = conexao.getConexao().prepareStatement(sql);
            GeneroDAO GeneroDAO = new GeneroDAO();
            Genero Genero = GeneroDAO.buscarPorNome(genero);
            if(Genero == null){
                System.out.println("Gênero não encontrado!");
            } else {
                st.setLong(1, Genero.getId_Genero());
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    Obra u = new Obra();
                    u.setIdObra(rs.getLong("id_obra"));
                    u.setTitulo(rs.getString("titulo"));
                    u.setAutor(rs.getString("autor"));
                    u.setEdicao(rs.getString("edicao"));
                    u.setAnoLancamento(rs.getString("ano_lancamento"));

                    u.setObraEmprestada(rs.getInt("emprestado") == 1 ? true : false);

                    u.setGenero(GeneroDAO.buscarPorId(rs.getLong("id_genero")));
                    BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
                    u.setBiblioteca(bibliotecaDAO.buscarPorId(rs.getLong("id_biblioteca")));
                    listaObras.add(u);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conexao.fecharConexao();
        }

        return listaObras;
    }

    public List<Obra> buscarPorTitulo(String titulo) {
        conexao.abrirConexao();

        List<Obra> listaObras = new ArrayList<>();

        String sql = "SELECT * FROM obra WHERE titulo=?;";
        PreparedStatement st;
        try {
            st = conexao.getConexao().prepareStatement(sql);
            st.setString(1, titulo);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Obra u = new Obra();
                u.setIdObra(rs.getLong("id_obra"));
                u.setTitulo(rs.getString("titulo"));
                u.setAutor(rs.getString("autor"));
                u.setEdicao(rs.getString("edicao"));
                u.setAnoLancamento(rs.getString("ano_lancamento"));

                u.setObraEmprestada(rs.getInt("emprestado") == 1 ? true : false);

                GeneroDAO GeneroDAO = new GeneroDAO();
                u.setGenero(GeneroDAO.buscarPorId(rs.getLong("id_genero")));
                BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
                u.setBiblioteca(bibliotecaDAO.buscarPorId(rs.getLong("id_biblioteca")));
                listaObras.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return listaObras;
    }

    public List<Obra> buscarPorAutor(String autor) {
        List<Obra> listaObras = new ArrayList<>();
        Obra u = null;
        
        conexao.abrirConexao();

        String sql = "SELECT * FROM obra WHERE autor=?;";
        PreparedStatement st;

        try {
            st = conexao.getConexao().prepareStatement(sql);
            st.setString(1, autor);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                u = new Obra();
                u.setIdObra(rs.getLong("id_obra"));
                u.setTitulo(rs.getString("titulo"));
                u.setAutor(rs.getString("autor"));
                u.setEdicao(rs.getString("edicao"));
                u.setAnoLancamento(rs.getString("ano_lancamento"));

                u.setObraEmprestada(rs.getInt("emprestado") == 1 ? true : false);

                GeneroDAO GeneroDAO = new GeneroDAO();
                u.setGenero(GeneroDAO.buscarPorId(rs.getLong("id_genero")));
                BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
                u.setBiblioteca(bibliotecaDAO.buscarPorId(rs.getLong("id_biblioteca")));
                listaObras.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return listaObras;
    }

    public List<Obra> buscarPorAno(String ano) {
        List<Obra> listaObras = new ArrayList<>();
        Obra u = null;
        
        conexao.abrirConexao();

        String sql = "SELECT * FROM obra WHERE ano_lancamento=?;";
        PreparedStatement st;

        try {
            st = conexao.getConexao().prepareStatement(sql);
            st.setString(1, ano);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                u = new Obra();
                u.setIdObra(rs.getLong("id_obra"));
                u.setTitulo(rs.getString("titulo"));
                u.setAutor(rs.getString("autor"));
                u.setEdicao(rs.getString("edicao"));
                u.setAnoLancamento(rs.getString("ano_lancamento"));

                u.setObraEmprestada(rs.getInt("emprestado") == 1 ? true : false);

                GeneroDAO GeneroDAO = new GeneroDAO();
                u.setGenero(GeneroDAO.buscarPorId(rs.getLong("id_genero")));
                BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
                u.setBiblioteca(bibliotecaDAO.buscarPorId(rs.getLong("id_biblioteca")));
                listaObras.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return listaObras;
    }

    public List<Obra> buscarPorBiblioteca(long id_biblioteca) {
        List<Obra> listaObras = new ArrayList<>();
        Obra u = null;
        
        conexao.abrirConexao();

        String sql = "SELECT * FROM obra WHERE id_biblioteca=?;";
        PreparedStatement st;

        try {
            st = conexao.getConexao().prepareStatement(sql);
            st.setLong(1, id_biblioteca);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                u = new Obra();
                u.setIdObra(rs.getLong("id_obra"));
                u.setTitulo(rs.getString("titulo"));
                u.setAutor(rs.getString("autor"));
                u.setEdicao(rs.getString("edicao"));
                u.setAnoLancamento(rs.getString("ano_lancamento"));

                u.setObraEmprestada(rs.getInt("emprestado") == 1 ? true : false);

                GeneroDAO GeneroDAO = new GeneroDAO();
                u.setGenero(GeneroDAO.buscarPorId(rs.getLong("id_genero")));
                BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
                u.setBiblioteca(bibliotecaDAO.buscarPorId(rs.getLong("id_biblioteca")));
                listaObras.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return listaObras;
        }
}
