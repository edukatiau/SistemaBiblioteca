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

public class TelaEmprestarObra {
    static Scanner sc = new Scanner(System.in);
    
    public TelaEmprestarObra() {
    }

    public static void emprestarObra(Funcionário funcionario) {
        System.out.println(Colors.ANSI_BLUE + "------EMPRESTAR OBRA-----" + Colors.ANSI_RESET);
                
        Aluno aluno = buscarAluno();
        if (aluno == null) {
            System.out.println(Colors.ANSI_RED + "Aluno não encontrado" + Colors.ANSI_RESET);
            return;
        }

        System.err.println(aluno.toString());
        System.out.println("Confirmar aluno? (S/N)");
        String confirmacao = sc.next().toUpperCase();
        sc.nextLine();
        if(!confirmacao.equals("S")){
            System.out.println(Colors.ANSI_RED + "Cancelado" + Colors.ANSI_RESET);
            return;
        }
        
        Obra obra = buscarObra();
        if (obra == null) {
            System.out.println(Colors.ANSI_RED + "Obra não encontrada" + Colors.ANSI_RESET);
            return;
        }
        if (obra.getObraEmprestada()){
            System.out.println(Colors.ANSI_RED+"Obra não disponível para empréstimo"+Colors.ANSI_RESET);
            return;
        }

        System.err.println(obra.toString());
        System.out.println("Confirmar obra? (S/N)");
        confirmacao = sc.next().toUpperCase();
        sc.nextLine();
        if(!confirmacao.equals("S")){
            System.out.println(Colors.ANSI_RED + "Cancelado" + Colors.ANSI_RESET);
            return;
        }

        
        Calendar calendarioEmprestimo = Calendar.getInstance();
        Calendar calendarioDevolucao = Calendar.getInstance();
        calendarioDevolucao.add(Calendar.DAY_OF_MONTH, 7);
        Date dataEmprestimo = new Date(calendarioEmprestimo.getTimeInMillis()); //Data de hoje
        Date dataDevolucao = new Date(calendarioDevolucao.getTimeInMillis()); //Data de hoje + 7 dias (1 semana)

        Emprestimo emprestimo = new Emprestimo(0, dataEmprestimo, dataDevolucao, aluno, obra);
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
        emprestimo = emprestimoDAO.adicionar(emprestimo);
        
        obra.setObraEmprestada(true);
        ObraDAO obraDAO = new ObraDAO();
        obraDAO.editar(obra);

        System.out.println(Colors.ANSI_GREEN + "Obra emprestada com sucesso!" + Colors.ANSI_RESET);
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
