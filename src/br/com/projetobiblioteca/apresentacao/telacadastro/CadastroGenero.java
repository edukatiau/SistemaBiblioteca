package br.com.projetobiblioteca.apresentacao.telacadastro;

import java.sql.SQLException;

import br.com.projetobiblioteca.model.Genero;
import br.com.projetobiblioteca.persistencia.GeneroDAO;

public class CadastroGenero {
    public static void CadastroGenero() {
    }

    public static Genero cadastrarGenero(String genero) throws SQLException{
        GeneroDAO GeneroDAO = new GeneroDAO();
        Genero Genero = new Genero();

        // Verifica se o gênero já existe no banco de dados
        // Se não existir, cadastra o gênero
        if(GeneroDAO.listarTiposObras().isEmpty()){
            Genero.setGenero(genero);
            Genero = GeneroDAO.adicionar(Genero);
            System.out.println("Gênero cadastrado com sucesso!");
        }else{ // Se existir, retorna o gênero
            for(Genero GeneroAux : GeneroDAO.listarTiposObras()){
                if(GeneroAux.getGenero().equals(genero)){
                    Genero = GeneroAux;
                    System.out.println("Gênero encontrado!");
                    break;
                }
            }
            // Se não encontrar, cadastra o gênero
            if(Genero.getGenero() == null){
                Genero.setGenero(genero);
                Genero = GeneroDAO.adicionar(Genero);
                System.out.println("Gênero cadastrado com sucesso!");
            }
        }

        return Genero;
    }
}
