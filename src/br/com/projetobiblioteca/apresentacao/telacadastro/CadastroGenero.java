package br.com.projetobiblioteca.apresentacao.telacadastro;

import java.sql.SQLException;

import br.com.projetobiblioteca.model.Genero;
import br.com.projetobiblioteca.persistencia.GeneroDAO;

public class CadastroGenero {
    public CadastroGenero() {
    }

    public static Genero cadastrarGenero(String genero) throws SQLException {
        GeneroDAO generoDAO = new GeneroDAO();
    
        // Busca o gênero no banco de dados
        for (Genero generoAux : generoDAO.listarTiposObras()) {
            if (generoAux.getGenero().equals(genero)) {
                System.out.println("Gênero encontrado!");
                return generoAux;
            }
        }
    
        // Se não encontrar, cadastra o gênero
        Genero novoGenero = new Genero();
        novoGenero.setGenero(genero);
        generoDAO.adicionar(novoGenero);
        System.out.println("Gênero cadastrado com sucesso!");
    
        return novoGenero;
    }
    
}