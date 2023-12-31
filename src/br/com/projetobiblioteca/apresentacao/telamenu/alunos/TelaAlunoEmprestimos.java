package br.com.projetobiblioteca.apresentacao.telamenu.alunos;

import java.util.List;

import br.com.projetobiblioteca.apresentacao.telaemprestimo.TelaListarEmprestimos;
import br.com.projetobiblioteca.model.Aluno;
import br.com.projetobiblioteca.model.Emprestimo;
import br.com.projetobiblioteca.persistencia.EmprestimoDAO;
import br.com.projetobiblioteca.utils.Colors;

public class TelaAlunoEmprestimos {

    public static void listarMeusEmprestimos(Aluno aluno) throws InterruptedException {
        System.out.println(Colors.ANSI_BLUE + "-----MEUS EMPRESTIMOS-----" + Colors.ANSI_RESET);
        
        List<Emprestimo> emprestimos = null;
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO();

        TelaListarEmprestimos.atualizarEmprestimosAtrasados();

        emprestimos = emprestimoDAO.buscarPorAluno(aluno);

        if (!emprestimos.isEmpty()) {
            int i = 1;
            for (Emprestimo emprestimo : emprestimos) {
                System.out.println("Emprestimo " + i + ":");
                System.out.println(emprestimo + "\n");
                Thread.sleep(500);
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

        int i = 1;
        if (!emprestimos.isEmpty()) {
            for (Emprestimo emprestimo : emprestimos) {
                if (emprestimo.getStatus().equals("ATRASADO")) {
                    System.out.println("Emprestimo " + i + ":");
                    System.out.println(emprestimo + "\n");
                    i++;
                }
            }
        }
        if(i == 1) {
            System.out.println(Colors.ANSI_RED + "Nenhum emprestimo encontrado!" + Colors.ANSI_RESET);
        }
        System.out.println(Colors.ANSI_BLUE + "---------------------" + Colors.ANSI_RESET);
    }

}
