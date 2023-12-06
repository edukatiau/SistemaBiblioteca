package br.com.projetobiblioteca.apresentacao.telaemprestimo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.projetobiblioteca.model.Emprestimo;
import br.com.projetobiblioteca.model.Funcionário;
import br.com.projetobiblioteca.persistencia.EmprestimoDAO;
import br.com.projetobiblioteca.utils.Colors;

public class TelaListarEmprestimos {
    public TelaListarEmprestimos() {
    }

    public static void listarEmprestimos(Funcionário funcionario) throws InterruptedException {
        System.out.println(Colors.ANSI_BLUE + "-----LISTA EMPRESTIMOS-----" + Colors.ANSI_RESET);
        List<Emprestimo> emprestimos = new ArrayList<>();
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO();

        atualizarEmprestimosAtrasados();

        emprestimos = emprestimoDAO.buscarTodos();

        int i = 1;
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println("Emprestimo " + i);
            System.out.println(emprestimo.toString());
            i++;
            Thread.sleep(500);
        }

    }

    public static void listarEmprestimosAtrasados(Funcionário funcionario) throws InterruptedException {
        System.out.println(Colors.ANSI_BLUE + "-----LISTA EMPRESTIMOS ATRASADOS-----" + Colors.ANSI_RESET);
        List<Emprestimo> emprestimos = new ArrayList<>();
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO();

        atualizarEmprestimosAtrasados();

        emprestimos = emprestimoDAO.buscarTodos();

        int i = 1;
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getStatus().equals("ATRASADO")) {
                System.out.println("Emprestimo " + i);
                System.out.println(emprestimo.toString());
                i++;
                Thread.sleep(500);
            }
        }
    }

    private static void atualizarEmprestimosAtrasados(){
        List<Emprestimo> emprestimos = new ArrayList<>();
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO();

        emprestimos = emprestimoDAO.buscarTodos();

        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getStatus().equals("ATIVO")) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(emprestimo.getDataDevolucao()); //Configura a data de devolução
                calendar.add(Calendar.DAY_OF_MONTH, 1);
                Date dataDevolucao = new Date(calendar.getTimeInMillis());
                if (dataDevolucao.before(new Date(System.currentTimeMillis()))) { //Se a data de devolução for anterior à data atual
                    emprestimo.setStatus("ATRASADO");
                    emprestimoDAO.editar(emprestimo);
                }
            }
        }
    }
}
