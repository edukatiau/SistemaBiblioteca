package br.com.projetobiblioteca.apresentacao.telamenu.funcionarios;

import java.util.Scanner;

import br.com.projetobiblioteca.model.Biblioteca;
import br.com.projetobiblioteca.model.Funcionário;
import br.com.projetobiblioteca.persistencia.BibliotecaDAO;
import br.com.projetobiblioteca.persistencia.FuncionarioDAO;
import br.com.projetobiblioteca.utils.Colors;

public class TelaEditarFuncionario {
    static Scanner sc = new Scanner(System.in);
    public static void editarFuncionario() {
        System.out.println(Colors.ANSI_BLUE + "-----EDITAR FUNCIONÁRIO-----" + Colors.ANSI_RESET);
        System.out.print("ID do funcionário: ");

        long id = 0;
        if (sc.hasNextLong()) {
            id = sc.nextLong();
        } else {
            System.out.println(Colors.ANSI_RED + "Entrada inválida. Tente novamente...\n" + Colors.ANSI_RESET);
            sc.next(); // Discard the invalid input
            editarFuncionario();
        }

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        Funcionário funcionario = funcionarioDAO.buscarPorId(id);

        if (funcionario == null) {
            System.out.println(Colors.ANSI_RED + "Funcionário não encontrado!" + Colors.ANSI_RESET);
            return;
        }

        System.out.println(funcionario.toString());
        System.out.println("Confirmar funcionário? (S/N)");
        sc.nextLine();
        String confirmacao = sc.nextLine();

        if (confirmacao.equalsIgnoreCase("S")) {
            exibirOpcoesEdicao(funcionario);
        } else {
            System.out.println(Colors.ANSI_RED + "Cancelada a operação!" + Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
        }

    }

    public static void exibirOpcoesEdicao(Funcionário funcionario){
        System.out.println("1 - Editar nome");
        System.out.println("2 - Editar email");
        System.out.println("3 - Editar senha");
        System.out.println("4 - Editar biblioteca");

        System.out.println("0 - Voltar");
        System.out.print("Escolha uma opção: ");
        int escolha = 0;
        if (sc.hasNextInt()) {
            escolha = sc.nextInt();
        } else {
            System.out.println(Colors.ANSI_RED + "Entrada inválida. Tente novamente...\n" + Colors.ANSI_RESET);
            sc.next(); // Discard the invalid input
            exibirOpcoesEdicao(funcionario);
        }
        System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);

        switch (escolha) {
            case 1:
                // Editar nome
                editarNome(funcionario);
                break;
            case 2:
                // Editar email
                editarEmail(funcionario);
                break;
            case 3:
                // Editar senha
                editarSenha(funcionario);
                break;
            case 4:
                // Editar biblioteca
                editarBiblioteca(funcionario);
                break;
            case 0:
                // Voltar
                return;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        exibirOpcoesEdicao(funcionario);
    }

    public static void editarNome(Funcionário funcionario) {
        System.out.println("Insira o novo nome: ");
        sc.nextLine();
        String nome = sc.nextLine();

        System.out.println("Trocar " + funcionario.getNome() + " por " + nome + "? (S/N)");
        String confirmacao = sc.next().toUpperCase();

        if (confirmacao.equals("S")){
            funcionario.setNome(nome);
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            funcionarioDAO.editar(funcionario);

            System.out.println(Colors.ANSI_GREEN + "Nome alterado com sucesso!" + Colors.ANSI_RESET);
        } else {
            System.out.println(Colors.ANSI_RED + "Nome não alterado!" + Colors.ANSI_RESET);
        }
        System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
    }

    public static void editarEmail(Funcionário funcionario) {
        System.out.print("Insira o novo email: ");
        sc.nextLine();
        String email = sc.nextLine();

        System.out.println("Trocar " + funcionario.getEmail() + " por " + email + "? (S/N)");
        String confirmacao = sc.next().toUpperCase();

        if (confirmacao.equals("S")){
            funcionario.setEmail(email);
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            funcionarioDAO.editar(funcionario);

            System.out.println(Colors.ANSI_GREEN + "Email alterado com sucesso!" + Colors.ANSI_RESET);
        } else {
            System.out.println(Colors.ANSI_RED + "Email não alterado!" + Colors.ANSI_RESET);
        }
        System.out.println(Colors.ANSI_BLUE + "--------------------" + Colors.ANSI_RESET);
    }

    public static void editarSenha(Funcionário funcionario) {
        System.out.print("Insira a nova senha: ");
        sc.nextLine();
        String senha = sc.nextLine();

        System.out.println("Trocar " + funcionario.getSenha() + " por " + senha + "? (S/N)");
        String confirmacao = sc.next().toUpperCase();

        if (confirmacao.equals("S")){
            funcionario.setSenha(senha);
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            funcionarioDAO.editar(funcionario);

            System.out.println(Colors.ANSI_GREEN + "Senha alterada com sucesso!" + Colors.ANSI_RESET);
        } else {
            System.out.println(Colors.ANSI_RED + "Senha não alterada!" + Colors.ANSI_RESET);
        }
        System.out.println(Colors.ANSI_BLUE + "--------------------" + Colors.ANSI_RESET);
    }

    public static void editarBiblioteca(Funcionário funcionario) {
        System.out.print("Insira a nova biblioteca: ");
        sc.nextLine();
        String biblioteca = sc.nextLine().toUpperCase();

        System.out.println("Trocar " + funcionario.getBiblioteca().getNome() + " por " + biblioteca + "? (S/N)");
        String confirmacao = sc.next().toUpperCase();

        if (confirmacao.equals("S")){
            BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
            Biblioteca b = bibliotecaDAO.buscarPorNome(biblioteca);
            funcionario.setBiblioteca(b);
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            funcionarioDAO.editar(funcionario);

            System.out.println(Colors.ANSI_GREEN + "Biblioteca alterada com sucesso!" + Colors.ANSI_RESET);
        } else {
            System.out.println(Colors.ANSI_RED + "Biblioteca não alterada!" + Colors.ANSI_RESET);
        }
        System.out.println(Colors.ANSI_BLUE + "--------------------" + Colors.ANSI_RESET);    
    }

}
