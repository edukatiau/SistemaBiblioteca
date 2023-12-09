package br.com.projetobiblioteca.apresentacao.telamenu.campus;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.projetobiblioteca.model.Biblioteca;
import br.com.projetobiblioteca.model.Campus;
import br.com.projetobiblioteca.persistencia.CampusDAO;
import br.com.projetobiblioteca.utils.Colors;

public class TelaEditarCampus {
    static Scanner sc = new Scanner(System.in);

    public static void editarCampus() throws SQLException {
System.out.println(Colors.ANSI_BLUE + "-----EDITAR CAMPUS-----" + Colors.ANSI_RESET);
        System.out.print("ID do campus: ");

        long id = 0;
        if (sc.hasNextLong()) {
            id = sc.nextLong();
        } else {
            System.out.println(Colors.ANSI_RED + "Entrada inválida. Tente novamente...\n" + Colors.ANSI_RESET);
            sc.next();
            editarCampus();
        }

        CampusDAO campusDAO = new CampusDAO();
        Campus campus = campusDAO.buscarPorId(id);

        if (campus == null) {
            System.out.println(Colors.ANSI_RED + "Campus não encontrado!" + Colors.ANSI_RESET);
            return;
        }

        System.out.println(campus.toString());
        System.out.println("Confirmar Campus? (S/N)");
        sc.nextLine();
        String confirmacao = sc.nextLine();

        if (confirmacao.equalsIgnoreCase("S")) {
            exibirOpcoesEdicao(campus);
        } else {
            System.out.println(Colors.ANSI_RED + "Cancelada a operação!" + Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
        }

    }

    public static void exibirOpcoesEdicao(Campus campus) throws SQLException{
        System.out.println("1 - Editar nome");
        System.out.println("2 - Editar endereço");
        System.out.println("3 - Editar telefone");

        System.out.println("0 - Voltar");
        System.out.print("Escolha uma opção: ");
        int escolha = 0;
        if (sc.hasNextInt()) {
            escolha = sc.nextInt();
        } else {
            System.out.println(Colors.ANSI_RED + "Entrada inválida. Tente novamente...\n" + Colors.ANSI_RESET);
            sc.next(); // Discard the invalid input
            exibirOpcoesEdicao(campus);
        }
        System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);

        switch (escolha) {
            case 1:
                // Editar nome
                editarNome(campus);
                break;
            case 2:
                // Editar email
                editarEndereco(campus);
                break;
            case 3:
                // Editar senha
                editarTelefone(campus);
                break;
            case 0:
                // Voltar
                return;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        exibirOpcoesEdicao(campus);
    }

    public static void editarNome(Campus campus) throws SQLException {
        System.out.println("Insira o novo nome: ");
        sc.nextLine();
        String nome = sc.nextLine().toUpperCase();

        System.out.println("Trocar " + campus.getNome() + " por " + nome + "? (S/N)");
        String confirmacao = sc.next().toUpperCase();

        if (confirmacao.equals("S")){
            campus.setNome(nome);
            CampusDAO campusDAO = new CampusDAO();
            Biblioteca biblioteca = new Biblioteca();
            biblioteca.setId_biblioteca(campus.getId_campus());
            campusDAO.editar(campus, biblioteca);

            System.out.println(Colors.ANSI_GREEN + "Nome alterado com sucesso!" + Colors.ANSI_RESET);
        } else {
            System.out.println(Colors.ANSI_RED + "Nome não alterado!" + Colors.ANSI_RESET);
        }
        System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
    }

    public static void editarEndereco(Campus campus) throws SQLException {
        System.out.println("Insira o novo endereço: ");
        sc.nextLine();
        String endereco = sc.nextLine();

        System.out.println("Trocar " + campus.getEndereco() + " por " + endereco + "? (S/N)");
        String confirmacao = sc.next().toUpperCase();

        if (confirmacao.equals("S")){
            campus.setEndereco(endereco);
            CampusDAO campusDAO = new CampusDAO();
            Biblioteca biblioteca = new Biblioteca();
            biblioteca.setId_biblioteca(campus.getId_campus());
            campusDAO.editar(campus, biblioteca);

            System.out.println(Colors.ANSI_GREEN + "Endereço alterado com sucesso!" + Colors.ANSI_RESET);
        } else {
            System.out.println(Colors.ANSI_RED + "Endereço não alterado!" + Colors.ANSI_RESET);
        }
        System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
    }

    public static void editarTelefone(Campus campus) throws SQLException {
        System.out.println("Insira o novo telefone: ");
        sc.nextLine();
        String telefone = sc.nextLine();

        System.out.println("Trocar " + campus.getTelefone() + " por " + telefone + "? (S/N)");
        String confirmacao = sc.next().toUpperCase();

        if (confirmacao.equals("S")){
            campus.setTelefone(telefone);
            CampusDAO campusDAO = new CampusDAO();
            Biblioteca biblioteca = new Biblioteca();
            biblioteca.setId_biblioteca(campus.getId_campus());
            campusDAO.editar(campus, biblioteca);

            System.out.println(Colors.ANSI_GREEN + "Telefone alterado com sucesso!" + Colors.ANSI_RESET);
        } else {
            System.out.println(Colors.ANSI_RED + "Telefone não alterado!" + Colors.ANSI_RESET);
        }
        System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
    }
}
