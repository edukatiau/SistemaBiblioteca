package br.com.projetobiblioteca.apresentacao.telamenu.alunos;

import java.util.Scanner;

import br.com.projetobiblioteca.model.Aluno;
import br.com.projetobiblioteca.model.Emprestimo;
import br.com.projetobiblioteca.model.Funcionário;
import br.com.projetobiblioteca.persistencia.AlunoDAO;
import br.com.projetobiblioteca.persistencia.EmprestimoDAO;
import br.com.projetobiblioteca.utils.Colors;

public class TelaRemoverAluno {
    static Scanner sc = new Scanner(System.in);

    public TelaRemoverAluno() {
    }

    public static void removerAluno(Funcionário funcionario) {
        System.err.println(Colors.ANSI_BLUE + "------REMOVER ALUNO-----" + Colors.ANSI_RESET);
        System.out.print("Matricula do aluno: ");
        String matriculaAluno = sc.next();

        AlunoDAO alunoDAO = new AlunoDAO();
        Aluno aluno = alunoDAO.buscarPorMatricula(matriculaAluno);

        if (aluno == null) {
            System.out.println(Colors.ANSI_RED + "Aluno não encontrado!" + Colors.ANSI_RESET);
        } else {

            if(verificarEmprestimo(aluno)){
                return;
            }

            System.out.println(aluno.toString());
            System.out.println("Confirma a remoção? (S/N)");
            String confirmacao = sc.next().toUpperCase();

            if (!confirmacao.equals("S")) {
                System.out.println(Colors.ANSI_RED + "Remoção cancelada!" + Colors.ANSI_RESET);
            } else {
                alunoDAO.excluir(aluno.getIdUsuario());
                System.out.println(Colors.ANSI_GREEN + "Aluno removido com sucesso!" + Colors.ANSI_RESET);
            }
            System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
        }
    }

    public static boolean verificarEmprestimo(Aluno aluno){
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO();

        if(emprestimoDAO.buscarTodos().size() > 0){
            for(Emprestimo emprestimo : emprestimoDAO.buscarTodos()){
                if(emprestimo.getAluno().getMatricula() == aluno.getMatricula()){
                    System.out.println(Colors.ANSI_RED + "Não é possível remover um aluno com empréstimos pendentes!" + Colors.ANSI_RESET);
                    return true;
                }
            }
        }
        
        return false;
    }

}
