package br.com.projetobiblioteca.apresentacao.telamenu.alunos;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.projetobiblioteca.model.Aluno;
import br.com.projetobiblioteca.persistencia.AlunoDAO;
import br.com.projetobiblioteca.utils.Colors;

public class TelaAlunoPerfil {
    static Scanner sc = new Scanner(System.in);

    public static void meuPerfil(Aluno aluno) throws SQLException, InterruptedException {
        System.out.println(Colors.ANSI_BLUE + "-----MEU PERFIL-----" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_GREEN + "Seja Bem-Vindo, " + aluno.getNome() + "!" + "\nCurso: " + aluno.getCurso() + "\nMatrícula: " + aluno.getMatricula() + "\nEmail: " + aluno.getEmail() + Colors.ANSI_RESET);
        System.out.println("1 - Editar Email");
        System.out.println("2 - Editar Senha");
        System.out.println("0 - Voltar");
        System.out.print("Escolha uma opção: ");
        int escolha = sc.nextInt();
        System.out.println(Colors.ANSI_BLUE + "--------------------" + Colors.ANSI_RESET);

        switch (escolha) {
            case 1:
                editarEmail(aluno);
                meuPerfil(aluno);
                break;
            case 2:
                editarSenha(aluno);
                meuPerfil(aluno);
                break;
            case 0:
                // Voltar
                return;
            default:
                System.out.println("Opção inválida!");
                meuPerfil(aluno);
                break;
        }
    }

    private static void editarEmail(Aluno aluno) {
        System.out.print("Insira o novo email: ");
        sc.nextLine();
        String email = sc.nextLine();

        System.out.println("Trocar " + aluno.getEmail() + " por " + email + "? (S/N)");
        String confirmacao = sc.next().toUpperCase();

        if (confirmacao.equals("S")){
            aluno.setEmail(email);
            AlunoDAO alunoDAO = new AlunoDAO();
            alunoDAO.editar(aluno);

            System.out.println(Colors.ANSI_GREEN + "Email alterado com sucesso!" + Colors.ANSI_RESET);
        } else {
            System.out.println(Colors.ANSI_RED + "Email não alterado!" + Colors.ANSI_RESET);
        }
        System.out.println(Colors.ANSI_BLUE + "--------------------" + Colors.ANSI_RESET);
    }

    private static void editarSenha(Aluno aluno) {
        System.out.print("Insira a nova senha: ");
        sc.nextLine();
        String senha = sc.nextLine();

        System.out.println("Trocar " + aluno.getSenha() + " por " + senha + "? (S/N)");
        String confirmacao = sc.next().toUpperCase();

        if (confirmacao.equals("S")){
            aluno.setSenha(senha);
            AlunoDAO alunoDAO = new AlunoDAO();
            alunoDAO.editar(aluno);

            System.out.println(Colors.ANSI_GREEN + "Senha alterada com sucesso!" + Colors.ANSI_RESET);
        } else {
            System.out.println(Colors.ANSI_RED + "Senha não alterada!" + Colors.ANSI_RESET);
        }
        System.out.println(Colors.ANSI_BLUE + "--------------------" + Colors.ANSI_RESET);
    }
}
