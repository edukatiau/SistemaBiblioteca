package br.com.projetobiblioteca.apresentacao.telamenu.alunos;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.projetobiblioteca.apresentacao.telamenu.TelaAluno;
import br.com.projetobiblioteca.model.Aluno;
import br.com.projetobiblioteca.persistencia.AlunoDAO;

public class TelaAlunoPerfil {
    static Scanner sc = new Scanner(System.in);

    public static void meuPerfil(Aluno aluno) throws SQLException {
        System.out.println("-----MEU PERFIL-----");
        System.out.println("Seja Bem-Vindo " + aluno.getNome() + "!" + "\nCurso: " + aluno.getCurso() + "\nMatrícula: " + aluno.getMatricula() + "\nEmail: " + aluno.getEmail());
        System.out.println("1 - Editar Email");
        System.out.println("2 - Editar Senha");
        System.out.println("0 - Voltar");
        System.out.print("Escolha uma opção: ");
        int escolha = sc.nextInt();
        System.out.println("-------------------");

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
                TelaAluno.menuAluno(aluno);
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    private static void editarEmail(Aluno aluno) {
        System.out.println("Insira o novo email: ");
        String email = sc.nextLine();

        System.out.println("Trocar " + aluno.getEmail() + " por " + email + "? (S/N)");
        String confirmacao = sc.next().toUpperCase();

        if (confirmacao.equals("S")){
            aluno.setEmail(email);
            AlunoDAO alunoDAO = new AlunoDAO();
            alunoDAO.editar(aluno);

            System.out.println("Email alterado com sucesso!");
        } else {
            System.out.println("Email não alterado!");
        }
    }

    private static void editarSenha(Aluno aluno) {
        System.out.println("Insira a nova senha: ");
        String senha = sc.nextLine();

        System.out.println("Trocar " + aluno.getSenha() + " por " + senha + "? (S/N)");
        String confirmacao = sc.next().toUpperCase();

        if (confirmacao.equals("S")){
            aluno.setSenha(senha);
            AlunoDAO alunoDAO = new AlunoDAO();
            alunoDAO.editar(aluno);

            System.out.println("Senha alterada com sucesso!");
        } else {
            System.out.println("Senha não alterada!");
        }
    }
}
