package br.com.projetobiblioteca.apresentacao.telamenu.alunos;

import java.util.List;

import br.com.projetobiblioteca.model.Aluno;
import br.com.projetobiblioteca.model.Emprestimo;
import br.com.projetobiblioteca.persistencia.EmprestimoDAO;
import br.com.projetobiblioteca.utils.Colors;

public class TelaAlunoEmprestimos {

    public static void listarMeusEmprestimos(Aluno aluno) {
        System.out.println(Colors.ANSI_BLUE + "-----MEUS EMPRESTIMOS-----" + Colors.ANSI_RESET);
        
        List<Emprestimo> emprestimos = null;
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO();

        emprestimos = emprestimoDAO.buscarPorAluno(aluno);

        if (!emprestimos.isEmpty()) {
            int i = 1;
            for (Emprestimo emprestimo : emprestimos) {
                System.out.println("Emprestimo " + i + ":");
                System.out.println(emprestimo + "\n");
                i++;
            }
        } else {
            System.out.println(Colors.ANSI_RED + "Nenhum emprestimo encontrado!" + Colors.ANSI_RESET);
        }
        System.out.println(Colors.ANSI_BLUE + "---------------------" + Colors.ANSI_RESET);
        
    }

    public static void listarMeusAtrasos(Aluno aluno) {
        System.out.println(Colors.ANSI_BLUE + "-----MEUS ATRASOS-----" + Colors.ANSI_RESET);
        
        List<Emprestimo> emprestimos = null;
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO();

        emprestimos = emprestimoDAO.buscarPorAluno(aluno);

        if (!emprestimos.isEmpty()) {
            for (Emprestimo emprestimo : emprestimos) {
                int i = 1;
                if (emprestimo.getStatus().equals("ATRASADO")) {
                    System.out.println("Emprestimo " + i + ":");
                    System.out.println(emprestimo + "\n");
                    i++;
                }
            }
        } else {
            System.out.println(Colors.ANSI_RED + "Nenhum emprestimo encontrado!" + Colors.ANSI_RESET);
        }
        System.out.println(Colors.ANSI_BLUE + "---------------------" + Colors.ANSI_RESET);
    }

}
