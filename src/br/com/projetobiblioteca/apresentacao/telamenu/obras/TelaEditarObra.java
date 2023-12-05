package br.com.projetobiblioteca.apresentacao.telamenu.obras;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.projetobiblioteca.apresentacao.telacadastro.CadastroGenero;
import br.com.projetobiblioteca.apresentacao.telamenu.TelaFunc;
import br.com.projetobiblioteca.model.Funcionário;
import br.com.projetobiblioteca.model.Obra;
import br.com.projetobiblioteca.model.Genero;
import br.com.projetobiblioteca.persistencia.ObraDAO;

public class TelaEditarObra {
    static Scanner sc = new Scanner(System.in);

    public TelaEditarObra() {
    }

    public static void editarObra(Funcionário funcionario) throws SQLException {

        System.out.println("-----EDITAR OBRA-----");
        System.out.println("Id da obra: ");
        long idObra = sc.nextLong();

        ObraDAO obraDAO = new ObraDAO();
        Obra obra = obraDAO.buscarPorId(idObra);
        
        if (obra == null) {
            System.out.println("Obra não encontrada!");
        } else {
            System.out.println(obra.toString());
            System.out.println("1 - Editar Título");
            System.out.println("2 - Editar Autor");
            System.out.println("3 - Editar Edição");
            System.out.println("4 - Editar Ano");
            System.out.println("5 - Editar Gênero");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");
            int escolha = sc.nextInt();
            System.out.println("-------------------");

            switch (escolha) {
                case 1:
                    editarTitulo(obra);
                    break;
                case 2:
                    editarAutor(obra);
                    break;
                case 3:
                    editarEdicao(obra);
                    break;
                case 4:
                    editarAno(obra);
                    break;
                case 5:
                    editarGenero(obra);
                    break;
                case 0:
                    TelaFunc.menuFunc(funcionario);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    TelaFunc.menuFunc(funcionario);
                    break;
            }
        }
    }

    private static void editarGenero(Obra obra) throws SQLException {
        System.out.print("Novo Gênero: ");
        sc.nextLine();
        String genero = sc.nextLine().toUpperCase();

        Genero Genero = CadastroGenero.cadastrarGenero(genero);
        obra.setGenero(Genero);

        ObraDAO obraDAO = new ObraDAO();
        obraDAO.editar(obra);

        System.out.println("Gênero editado com sucesso!");
    }

    private static void editarEdicao(Obra obra) {
        System.out.println("Nova Edição: ");
        sc.nextLine();
        String edicao = sc.nextLine();
        obra.setEdicao(edicao);

        ObraDAO obraDAO = new ObraDAO();
        obraDAO.editar(obra);

        System.out.println("Edição editada com sucesso!");
    }

    private static void editarAno(Obra obra) {
        System.out.println("Novo Ano: ");
        sc.nextLine();
        String ano = sc.nextLine();
        obra.setAnoLancamento(ano);

        ObraDAO obraDAO = new ObraDAO();
        obraDAO.editar(obra);

        System.out.println("Ano editado com sucesso!");
    }

    private static void editarAutor(Obra obra) {
        System.out.print("Novo Autor: ");
        sc.nextLine();
        String autor = sc.nextLine();
        obra.setAutor(autor);

        ObraDAO obraDAO = new ObraDAO();
        obraDAO.editar(obra);

        System.out.println("Autor editado com sucesso!");
    }

    public static void editarTitulo(Obra obra) {
        System.out.println("Novo Título: ");
        sc.nextLine();
        String titulo = sc.nextLine();
        obra.setTitulo(titulo);

        ObraDAO obraDAO = new ObraDAO();
        obraDAO.editar(obra);

        System.out.println("Título editado com sucesso!");
    }

}
