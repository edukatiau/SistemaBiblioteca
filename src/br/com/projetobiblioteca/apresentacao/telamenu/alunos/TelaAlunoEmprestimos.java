package br.com.projetobiblioteca.apresentacao.telamenu.alunos;

import java.util.List;

import br.com.projetobiblioteca.model.Aluno;
import br.com.projetobiblioteca.model.Emprestimo;
import br.com.projetobiblioteca.persistencia.EmprestimoDAO;

public class TelaAlunoEmprestimos {

    public static void listarMeusEmprestimos(Aluno aluno) {
        System.out.println("-----MEUS EMPRESTIMOS-----");
        
        List<Emprestimo> emprestimos = null;
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO();

        emprestimos = emprestimoDAO.buscarPorAluno(aluno);

        if (emprestimos != null) {
            int i = 1;
            for (Emprestimo emprestimo : emprestimos) {
                System.out.println("Emprestimo " + i + ":");
                System.out.println(emprestimo + "\n");
                i++;
            }
        } else {
            System.out.println("Nenhum emprestimo encontrado!");
        }
        
    }

    public static void listarMeusAtrasos(Aluno aluno) {
        System.out.println("-----MEUS ATRASOS-----");
        
        List<Emprestimo> emprestimos = null;
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO();

        emprestimos = emprestimoDAO.buscarPorAluno(aluno);

        if (emprestimos != null) {
            for (Emprestimo emprestimo : emprestimos) {
                int i = 1;
                if (emprestimo.getStatus().equals("ATRASADO")) {
                    System.out.println("Emprestimo " + i + ":");
                    System.out.println(emprestimo + "\n");
                    i++;
                }
            }
        } else {
            System.out.println("Nenhum emprestimo encontrado!");
        }
    }

}
