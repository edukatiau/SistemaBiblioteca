package br.com.projetobiblioteca.apresentacao.telacadastro;

import java.sql.SQLException;

import br.com.projetobiblioteca.model.TipoObra;
import br.com.projetobiblioteca.persistencia.TipoObraDAO;

public class CadastroGenero {
    public static void CadastroGenero() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static TipoObra cadastrarGenero(String genero) throws SQLException{
        TipoObraDAO tipoObraDAO = new TipoObraDAO();
        TipoObra tipoObra = new TipoObra();

        // Verifica se o gênero já existe no banco de dados
        // Se não existir, cadastra o gênero
        if(tipoObraDAO.listarTiposObras().isEmpty()){
            tipoObra.setTIPO_OBRA(genero);
            tipoObra = tipoObraDAO.adicionar(tipoObra);
            System.out.println("Gênero cadastrado com sucesso!");
        }else{ // Se existir, retorna o gênero
            for(TipoObra tipoObraAux : tipoObraDAO.listarTiposObras()){
                if(tipoObraAux.getTIPO_OBRA().equals(genero)){
                    tipoObra = tipoObraAux;
                    System.out.println("Gênero encontrado!");
                    break;
                }
            }
            // Se não encontrar, cadastra o gênero
            if(tipoObra.getTIPO_OBRA() == null){
                tipoObra.setTIPO_OBRA(genero);
                tipoObra = tipoObraDAO.adicionar(tipoObra);
                System.out.println("Gênero cadastrado com sucesso!");
            }
        }

        return tipoObra;
    }
}
