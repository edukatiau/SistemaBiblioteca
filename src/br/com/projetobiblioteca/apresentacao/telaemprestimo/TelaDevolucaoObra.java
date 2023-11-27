package br.com.projetobiblioteca.apresentacao.telaemprestimo;

import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;

import br.com.projetobiblioteca.model.Aluno;
import br.com.projetobiblioteca.model.Emprestimo;
import br.com.projetobiblioteca.model.Funcionário;
import br.com.projetobiblioteca.model.Obra;
import br.com.projetobiblioteca.persistencia.AlunoDAO;
import br.com.projetobiblioteca.persistencia.EmprestimoDAO;
import br.com.projetobiblioteca.persistencia.ObraDAO;

public class TelaDevolucaoObra {
    static Scanner sc = new Scanner(System.in);
    
    public TelaDevolucaoObra(){
    }

    public static void devolverObra(Funcionário funcionario) {
        System.out.println("-----DEVOLVER OBRA-----");
        Aluno aluno = buscarAluno();
        if (aluno == null) {
            System.out.println("Aluno não encontrado");
            TelaEmprestimo.telaEmprestimo(funcionario);
        }

        System.err.println(aluno.toString());
        System.out.println("Confirmar aluno? (S/N)");
        String confirmacao = sc.next().toUpperCase();
        sc.nextLine();
        if(!confirmacao.equals("S")){
            System.out.println("Cancelado");
            TelaEmprestimo.telaEmprestimo(funcionario);
        }
        
        Obra obra = buscarObra();
        if (obra == null) {
            System.out.println("Obra não encontrada");
            TelaEmprestimo.telaEmprestimo(funcionario);
        }

        System.err.println(obra.toString());
        System.out.println("Confirmar obra? (S/N)");
        confirmacao = sc.next().toUpperCase();
        sc.nextLine();
        if(!confirmacao.equals("S")){
            System.out.println("Cancelado");
            TelaEmprestimo.telaEmprestimo(funcionario);
        }

        Emprestimo emprestimo = new Emprestimo();
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
        emprestimo = emprestimoDAO.buscarPorAlunoObra(aluno.getIdUsuario(), obra.getIdObra());

        if (emprestimo == null || emprestimo.getAluno().getNome().equals("")) {
            System.out.println("Empréstimo não encontrado");
            TelaEmprestimo.telaEmprestimo(funcionario);
        }

        System.out.println(emprestimo.toString());
        System.out.println("Confirmar devolução? (S/N)");
        confirmacao = sc.next().toUpperCase();
        sc.nextLine();

        if (!confirmacao.equals("S")) {
            System.out.println("Cancelado");
            TelaEmprestimo.telaEmprestimo(funcionario);
        }

        Calendar calender1 = Calendar.getInstance();
        Date dataDevolucaoEfetiva = new Date(calender1.getTimeInMillis()); //Pega a data atual
        emprestimo.setDataDevolucaoEfetiva(dataDevolucaoEfetiva);
        emprestimo.setStatus("DEVOLVIDO");
        emprestimoDAO.editar(emprestimo);

        System.out.println("Obra devolvida com sucesso");        
    }

    private static Aluno buscarAluno() {
        System.out.println("Insira a matricula aluno:");
        String matricula = sc.nextLine();
        AlunoDAO alunoDAO = new AlunoDAO();
        return alunoDAO.buscarPorMatricula(matricula);
    }

    private static Obra buscarObra() {
        System.out.println("Insira o id da obra:");
        long idObra = sc.nextLong();
        sc.nextLine();
        ObraDAO obraDAO = new ObraDAO();
        return obraDAO.buscarPorId(idObra);
    }
}
