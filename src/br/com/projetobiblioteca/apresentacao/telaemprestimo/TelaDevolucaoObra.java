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
import br.com.projetobiblioteca.utils.Colors;

public class TelaDevolucaoObra {
    static Scanner sc = new Scanner(System.in);
    
    public TelaDevolucaoObra(){
    }

    public static void devolverObra(Funcionário funcionario) throws InterruptedException {
        System.out.println(Colors.ANSI_BLUE + "-----DEVOLVER OBRA-----" + Colors.ANSI_RESET);
        Aluno aluno = buscarAluno();
        if (aluno == null) {
            System.out.println(Colors.ANSI_RED + "Aluno não encontrado!" + Colors.ANSI_RESET);
            return;
        }

        System.err.println(aluno.toString());
        System.out.println("Confirmar aluno? (S/N)");
        String confirmacao = sc.next().toUpperCase();
        sc.nextLine();
        if(!confirmacao.equals("S")){
            System.out.println(Colors.ANSI_RED + "Cancelado!" + Colors.ANSI_RESET);
            return; 
        }
        
        Obra obra = buscarObra();
        if (obra == null) {
            System.out.println(Colors.ANSI_RED + "Obra não encontrada!" + Colors.ANSI_RESET);
            return;
        }

        System.err.println(obra.toString());
        System.out.println("Confirmar obra? (S/N)");
        confirmacao = sc.next().toUpperCase();
        sc.nextLine();
        if(!confirmacao.equals("S")){
            System.out.println(Colors.ANSI_RED + "Cancelado" + Colors.ANSI_RESET);
            TelaEmprestimo.telaEmprestimo(funcionario);
        }

        Emprestimo emprestimo = new Emprestimo();
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
        emprestimo = emprestimoDAO.buscarPorAlunoObra(aluno.getIdUsuario(), obra.getIdObra());

        if (emprestimo == null || emprestimo.getAluno().getNome().equals("")) {
            System.out.println(Colors.ANSI_RED + "Empréstimo não encontrado" + Colors.ANSI_RESET);
            return;
        }

        System.out.println(emprestimo.toString());
        System.out.println("Confirmar devolução? (S/N)");
        confirmacao = sc.next().toUpperCase();
        sc.nextLine();

        if (!confirmacao.equals("S")) {
            System.out.println(Colors.ANSI_RED + "Cancelado" + Colors.ANSI_RESET);
            TelaEmprestimo.telaEmprestimo(funcionario);
        }

        Calendar calender1 = Calendar.getInstance();
        Date dataDevolucaoEfetiva = new Date(calender1.getTimeInMillis()); //Pega a data atual
        emprestimo.setDataDevolucaoEfetiva(dataDevolucaoEfetiva);

        emprestimo.setStatus("DEVOLVIDO");
        obra.setObraEmprestada(false);
        ObraDAO obraDAO = new ObraDAO();
        obraDAO.editar(obra);
        emprestimoDAO.editar(emprestimo);

        System.out.println(Colors.ANSI_GREEN + "Obra devolvida com sucesso" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
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
