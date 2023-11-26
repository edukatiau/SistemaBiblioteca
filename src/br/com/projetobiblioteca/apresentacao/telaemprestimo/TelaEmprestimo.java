package br.com.projetobiblioteca.apresentacao.telaemprestimo;

import java.sql.Date;
import java.util.Scanner;

import br.com.projetobiblioteca.model.Aluno;
import br.com.projetobiblioteca.model.Emprestimo;
import br.com.projetobiblioteca.model.Funcionário;
import br.com.projetobiblioteca.model.Obra;
import br.com.projetobiblioteca.persistencia.AlunoDAO;
import br.com.projetobiblioteca.persistencia.EmprestimoDAO;
import br.com.projetobiblioteca.persistencia.ObraDAO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TelaEmprestimo {
    static Scanner sc = new Scanner(System.in);

    public static void TelaEmprestimo(Funcionário funcionario) {

        System.out.println("-----EMPRÉSTIMOS-----");
        System.out.println("1 - Emprestar Obra");
        System.out.println("2 - Devolver Obra");
        System.out.println("3 - Listar Empréstimos");
        System.out.println("4 - Listar Empréstimos Atrasados");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");

        int escolha = sc.nextInt();
        System.out.println("-------------------");

        switch (escolha) {
            case 1:
                emprestarObra(funcionario);
                break;
            case 2:
                devolverObra(funcionario);
                break;
            case 3:
                listarEmprestimos(funcionario);
                break;
            case 4:
                listarEmprestimosAtrasados(funcionario);
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    private static void emprestarObra(Funcionário funcionario) {
        System.out.println("------EMPRESTAR OBRA-----");
        System.out.println("Insira a matricula aluno:");
        String matricula = sc.next();
        sc.nextLine();
        
        Aluno aluno = new Aluno();
        AlunoDAO alunoDAO = new AlunoDAO();
        aluno = alunoDAO.buscarPorMatricula(matricula);
        
        if (aluno == null || aluno.getNome().equals("")) {
            System.out.println("Aluno não encontrado");
            TelaEmprestimo.TelaEmprestimo(funcionario);
        }

        System.err.println(aluno.toString());
        System.out.println("Confirmar aluno? (S/N)");
        String confirmacao = sc.next().toUpperCase();
        sc.nextLine();
        if(confirmacao.equals("N")){
            System.out.println("Cancelado");
            TelaEmprestimo.TelaEmprestimo(funcionario);
        }
        
        System.out.println("Insira o id da obra:");
        long idObra = sc.nextLong();
        sc.nextLine();

        Obra obra = new Obra();
        ObraDAO obraDAO = new ObraDAO();
        obra = obraDAO.buscarPorId(idObra);

        if (obra == null || obra.getTitulo().equals("")) {
            System.out.println("Obra não encontrada");
            TelaEmprestimo.TelaEmprestimo(funcionario);
        }

        System.err.println(obra.toString());
        System.out.println("Confirmar obra? (S/N)");
        confirmacao = sc.next().toUpperCase();
        sc.nextLine();
        if(confirmacao.equals("N")){
            System.out.println("Cancelado");
            TelaEmprestimo.TelaEmprestimo(funcionario);
        }

        Calendar calender1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.DAY_OF_MONTH, 7);
        Date dataEmprestimo = new Date(calender1.getTimeInMillis());
        Date dataDevolucao = new Date(calendar2.getTimeInMillis());
        Emprestimo emprestimo = new Emprestimo(0, dataEmprestimo, dataDevolucao, aluno, obra);
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
        emprestimo = emprestimoDAO.adicionar(emprestimo);

        System.out.println("Obra emprestada com sucesso");
            // Use the 'emprestimo' object as needed

        TelaEmprestimo.TelaEmprestimo(funcionario);
    }
    
    private static void devolverObra(Funcionário funcionario) {
        System.out.println("-----DEVOLVER OBRA-----");
        System.out.println("Insira a matricula do aluno:");
        String matricula = sc.next();
        sc.nextLine();

        Aluno aluno = new Aluno();
        AlunoDAO alunoDAO = new AlunoDAO();
        aluno = alunoDAO.buscarPorMatricula(matricula);

        if (aluno == null || aluno.getNome().equals("")) {
            System.out.println("Aluno não encontrado");
            TelaEmprestimo.TelaEmprestimo(funcionario);
        }

        System.out.println(aluno.toString());
        System.out.println("Confirmar aluno? (S/N)");
        String confirmacao = sc.next().toUpperCase();
        sc.nextLine();

        if (confirmacao.equals("N")) {
            System.out.println("Cancelado");
            TelaEmprestimo.TelaEmprestimo(funcionario);
        }

        System.out.println("Insira o id da obra:");
        long idObra = sc.nextLong();
        sc.nextLine();

        Obra obra = new Obra();
        ObraDAO obraDAO = new ObraDAO();
        obra = obraDAO.buscarPorId(idObra);

        if (obra == null || obra.getTitulo().equals("")) {
            System.out.println("Obra não encontrada");
            TelaEmprestimo.TelaEmprestimo(funcionario);
        }

        System.out.println(obra.toString());
        System.out.println("Confirmar obra? (S/N)");
        confirmacao = sc.next().toUpperCase();
        sc.nextLine();

        if (confirmacao.equals("N")) {
            System.out.println("Cancelado");
            TelaEmprestimo.TelaEmprestimo(funcionario);
        }

        Emprestimo emprestimo = new Emprestimo();
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
        emprestimo = emprestimoDAO.buscarPorAlunoObra(aluno.getIdUsuario(), obra.getIdObra());

        if (emprestimo == null || emprestimo.getAluno().getNome().equals("")) {
            System.out.println("Empréstimo não encontrado");
            TelaEmprestimo.TelaEmprestimo(funcionario);
        }

        System.out.println(emprestimo.toString());
        System.out.println("Confirmar devolução? (S/N)");
        confirmacao = sc.next().toUpperCase();
        sc.nextLine();

        if (confirmacao.equals("N")) {
            System.out.println("Cancelado");
            TelaEmprestimo.TelaEmprestimo(funcionario);
        }

        Calendar calender1 = Calendar.getInstance();
        Date dataDevolucaoEfetiva = new Date(calender1.getTimeInMillis());
        emprestimo.setDataDevolucaoEfetiva(dataDevolucaoEfetiva);
        emprestimo.setStatus("DEVOLVIDO");
        emprestimoDAO.editar(emprestimo);

        System.out.println("Obra devolvida com sucesso");
        // Use the 'emprestimo' object as needed
        
    }

    private static void listarEmprestimos(Funcionário funcionario) {
        System.out.println("-----LISTA EMPRESTIMOS-----");
        List<Emprestimo> emprestimos = new ArrayList<>();
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO();

        emprestimos = emprestimoDAO.buscarTodos();

        int i = 1;
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println("Emprestimo " + i);
            System.out.println(emprestimo.toString());
            i++;
        }

        TelaEmprestimo(funcionario);

    }

    private static void listarEmprestimosAtrasados(Funcionário funcionario) {
        System.out.println("-----LISTA EMPRESTIMOS ATRASADOS-----");
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
            }
        }

        TelaEmprestimo(funcionario);
    }

    private static void atualizarEmprestimosAtrasados(){
        List<Emprestimo> emprestimos = new ArrayList<>();
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO();

        emprestimos = emprestimoDAO.buscarTodos();

        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getStatus().equals("ATIVO")) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(emprestimo.getDataDevolucao());
                calendar.add(Calendar.DAY_OF_MONTH, 1);
                Date dataDevolucao = new Date(calendar.getTimeInMillis());
                if (dataDevolucao.before(new Date(System.currentTimeMillis()))) {
                    emprestimo.setStatus("ATRASADO");
                    emprestimoDAO.editar(emprestimo);
                }
            }
        }
    }
}