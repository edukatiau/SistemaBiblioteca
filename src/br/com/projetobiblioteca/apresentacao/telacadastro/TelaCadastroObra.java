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

        TipoObraDAO tipoObraDAO = new TipoObraDAO();
        TipoObra tipoObra = new TipoObra();
        if(tipoObraDAO.listarTiposObras().isEmpty()) {
            TipoObra tipoObra2 = new TipoObra(0, genero);
            tipoObra2 = tipoObraDAO.adicionar(tipoObra2);
            System.out.println("Gênero cadastrado com sucesso!");
        } else {
            for(TipoObra tipoObra3 : tipoObraDAO.listarTiposObras()) {
                if(tipoObra.getTIPO_OBRA().equals(genero)) {
                    tipoObra = tipoObra3;
                    break;
                } else {
                    TipoObra tipoObra2 = new TipoObra(0, genero);
                    tipoObra = tipoObraDAO.adicionar(tipoObra2);
                    System.out.println("Gênero cadastrado com sucesso!");
                    break;
                }
            }
        }
        //tipoObra = tipoObraDAO.buscarPorNome(genero);
        
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
}
