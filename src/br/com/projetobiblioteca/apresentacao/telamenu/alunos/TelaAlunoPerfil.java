package br.com.projetobiblioteca.apresentacao.telamenu.alunos;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.projetobiblioteca.apresentacao.telamenu.TelaAluno;
import br.com.projetobiblioteca.model.Aluno;
import br.com.projetobiblioteca.persistencia.AlunoDAO;

public class TelaAlunoPerfil {
    static Scanner sc = new Scanner(System.in);

    public static void meuPerfil(Aluno aluno) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----MEU PERFIL-----");
        System.out.println("Seja Bem-Vindo " + aluno.getNome() + "!" + "\nCurso: " + aluno.getCurso() + "\nMatrícula: " + aluno.getMatricula() + "\nEmail: " + aluno.getEmail());
        System.out.println("1 - Editar Nome");
        System.out.println("2 - Editar Matrícula");
        System.out.println("3 - Editar Curso");
        System.out.println("4 - Editar Email");
        System.out.println("5 - Editar Senha");
        System.out.println("0 - Voltar");
        System.out.print("Escolha uma opção: ");
        int escolha = sc.nextInt();
        System.out.println("-------------------");

        switch (escolha) {
            case 1:
                editarNome(aluno);
                meuPerfil(aluno);
                break;
            case 2:
                editarMatricula(aluno);
                meuPerfil(aluno);
                break;
            case 3:
                editarCurso(aluno);
                meuPerfil(aluno);
                break;
            case 4:
                editarEmail(aluno);
                meuPerfil(aluno);
                break;
            case 5:
                editarSenha(aluno);
                meuPerfil(aluno);
                break;
            case 0:
                // Voltar
                TelaAluno.TelaAluno(aluno);
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    private static void editarNome(Aluno aluno) {
        System.out.println("Insira o novo nome: ");
        String nome = sc.nextLine();

        System.out.println("Trocar " + aluno.getNome() + " por " + nome + "? (S/N)");
        String confirmacao = sc.next().toUpperCase();

        if (confirmacao.equals("S")){
            aluno.setNome(nome);
            AlunoDAO alunoDAO = new AlunoDAO();
            alunoDAO.editar(aluno);

            System.out.println("Nome alterado com sucesso!");
        } else {
            System.out.println("Nome não alterado!");
        }

    }

    private static void editarMatricula(Aluno aluno) {
        System.out.println("Insira a nova matrícula: ");
        String matricula = sc.nextLine();

        System.out.println("Trocar " + aluno.getMatricula() + " por " + matricula + "? (S/N)");
        String confirmacao = sc.next().toUpperCase();

        if (confirmacao.equals("S")){
            aluno.setMatricula(matricula);
            AlunoDAO alunoDAO = new AlunoDAO();
            alunoDAO.editar(aluno);

            System.out.println("Matrícula alterada com sucesso!");
        } else {
            System.out.println("Matrícula não alterada!");
        }
    }

    private static void editarCurso(Aluno aluno) {
        System.out.println("Insira o novo curso: ");
        String curso = sc.nextLine();

        System.out.println("Trocar " + aluno.getCurso() + " por " + curso + "? (S/N)");
        String confirmacao = sc.next().toUpperCase();

        if (confirmacao.equals("S")){
            aluno.setCurso(curso);
            AlunoDAO alunoDAO = new AlunoDAO();
            alunoDAO.editar(aluno);

            System.out.println("Curso alterado com sucesso!");
        } else {
            System.out.println("Curso não alterado!");
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
