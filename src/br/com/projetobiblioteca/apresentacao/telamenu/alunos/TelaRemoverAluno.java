package br.com.projetobiblioteca.apresentacao.telamenu.alunos;

import java.util.Scanner;

import br.com.projetobiblioteca.model.Aluno;
import br.com.projetobiblioteca.model.Funcionário;
import br.com.projetobiblioteca.persistencia.AlunoDAO;

public class TelaRemoverAluno {

    public static void TelaRemoverAluno(Funcionário funcionario) {
        Scanner sc = new Scanner(System.in);
        System.err.println("------REMOVER ALUNO-----");
        System.out.println("Matricula do aluno: ");
        String matriculaAluno = sc.next();

        AlunoDAO alunoDAO = new AlunoDAO();
        Aluno aluno = alunoDAO.buscarPorMatricula(matriculaAluno);

        if (aluno == null) {
            System.out.println("Aluno não encontrado!");
        } else {
            System.out.println(aluno.toString());
            System.out.println("Confirma a remoção? (S/N)");
            String confirmacao = sc.next().toUpperCase();

            if (confirmacao.equals("N")) {
                System.out.println("Remoção cancelada!");
            } else if (!confirmacao.equals("S")) {
                System.out.println("Opção inválida!");
            } else {
                alunoDAO.excluir(aluno.getIdUsuario());
                System.out.println("Aluno removido com sucesso!");
            }
        }
    }

}
