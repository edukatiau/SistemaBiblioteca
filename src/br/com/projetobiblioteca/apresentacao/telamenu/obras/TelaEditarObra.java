package br.com.projetobiblioteca.apresentacao.telamenu.obras;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.projetobiblioteca.apresentacao.telacadastro.CadastroGenero;
import br.com.projetobiblioteca.apresentacao.telamenu.TelaFunc;
import br.com.projetobiblioteca.model.Funcionário;
import br.com.projetobiblioteca.model.Obra;
import br.com.projetobiblioteca.model.Genero;
import br.com.projetobiblioteca.persistencia.ObraDAO;
import br.com.projetobiblioteca.utils.Colors;

public class TelaEditarObra {
    static Scanner sc = new Scanner(System.in);

    public TelaEditarObra() {
    }

    public static void editarObra(Funcionário funcionario) throws SQLException, InterruptedException {

        System.out.println(Colors.ANSI_BLUE + "-----EDITAR OBRA-----" + Colors.ANSI_RESET);
        System.out.print("Id da obra: ");
        long idObra = sc.nextLong();

        ObraDAO obraDAO = new ObraDAO();
        Obra obra = obraDAO.buscarPorId(idObra);
        
        if (obra == null) {
            System.out.println(Colors.ANSI_RED + "Obra não encontrada!" + Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
            return;
        } else {
            System.out.println(obra.toString());
            System.out.println("1 - Editar Título");
            System.out.println("2 - Editar Autor");
            System.out.println("3 - Editar Edição");
            System.out.println("4 - Editar Ano");
            System.out.println("5 - Editar Gênero");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");
            int escolha = 0;
        if (sc.hasNextInt()) {
            escolha = sc.nextInt();
        } else {
            System.out.println(Colors.ANSI_RED + "Entrada inválida. Tente novamente...\n" + Colors.ANSI_RESET);
            sc.next(); // Discard the invalid input
            editarObra(funcionario);
        }
            System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);

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
                    return;
                default:
                    System.out.println("Opção inválida!");
                    break;
                }
            TelaFunc.menuFunc(funcionario);
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

        System.out.println(Colors.ANSI_GREEN + "Gênero editado com sucesso!" + Colors.ANSI_RESET);
    }

    private static void editarEdicao(Obra obra) {
        System.out.println("Nova Edição: ");
        sc.nextLine();
        String edicao = sc.nextLine();
        obra.setEdicao(edicao);

        ObraDAO obraDAO = new ObraDAO();
        obraDAO.editar(obra);

        System.out.println(Colors.ANSI_GREEN + "Edição editada com sucesso!" + Colors.ANSI_RESET);
    }

    private static void editarAno(Obra obra) {
        System.out.println("Novo Ano: ");
        sc.nextLine();
        String ano = sc.nextLine();
        obra.setAnoLancamento(ano);

        ObraDAO obraDAO = new ObraDAO();
        obraDAO.editar(obra);

        System.out.println(Colors.ANSI_GREEN + "Ano editado com sucesso!" + Colors.ANSI_RESET);
    }

    private static void editarAutor(Obra obra) {
        System.out.print("Novo Autor: ");
        sc.nextLine();
        String autor = sc.nextLine();
        obra.setAutor(autor);

        ObraDAO obraDAO = new ObraDAO();
        obraDAO.editar(obra);

        System.out.println(Colors.ANSI_GREEN + "Autor editado com sucesso!" + Colors.ANSI_RESET);
    }

    public static void editarTitulo(Obra obra) {
        System.out.println("Novo Título: ");
        sc.nextLine();
        String titulo = sc.nextLine();
        obra.setTitulo(titulo);

        ObraDAO obraDAO = new ObraDAO();
        obraDAO.editar(obra);

        System.out.println(Colors.ANSI_GREEN + "Título editado com sucesso!" + Colors.ANSI_RESET);
    }

}
