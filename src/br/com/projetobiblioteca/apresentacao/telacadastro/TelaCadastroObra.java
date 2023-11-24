package br.com.projetobiblioteca.apresentacao.telacadastro;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.projetobiblioteca.apresentacao.telamenu.TelaFunc;
import br.com.projetobiblioteca.model.Funcionário;
import br.com.projetobiblioteca.model.Obra;
import br.com.projetobiblioteca.model.TipoObra;
import br.com.projetobiblioteca.persistencia.ObraDAO;
import br.com.projetobiblioteca.persistencia.TipoObraDAO;

public class TelaCadastroObra {
    public static void TelaCadastroObra(Funcionário funcionario) throws SQLException{
        Scanner sc = new Scanner(System.in);
        System.out.println("-----CADASTRO OBRA-----");
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        //System.out.print("Editora: ");
        //String editora = sc.nextLine();
        System.out.print("Edição: ");
        String edicao = sc.nextLine();
        System.out.print("Ano: ");
        String ano = sc.next();

        System.out.print("Gênero: ");
        String genero = sc.next().toUpperCase();
        sc.nextLine();

        TipoObra tipoObra = cadastrarGenero(genero);

        Obra obra = new Obra(0, titulo, autor, edicao, ano, tipoObra, funcionario.getBiblioteca());

        System.out.println(obra.toString());
        System.out.println("Confirma o cadastro? (S/N)");
        String confirmacao = sc.next().toUpperCase();

        if(confirmacao.equals("N")){
            System.out.println("Cadastro cancelado!");
            TelaFunc.TelaFunc(funcionario);
        }
        else if(!confirmacao.equals("S")){
            System.out.println("Opção inválida!");
            TelaFunc.TelaFunc(funcionario);
        }else{
            ObraDAO obraDAO = new ObraDAO();
            obraDAO.adicionar(obra);

            System.out.println("Obra cadastrada com sucesso!");
        }

        TelaFunc.TelaFunc(funcionario);
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
