package br.com.projetobiblioteca.apresentacao.telamenu.alunos;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.projetobiblioteca.apresentacao.telamenu.TelaFunc;
import br.com.projetobiblioteca.model.Aluno;
import br.com.projetobiblioteca.model.Funcionário;
import br.com.projetobiblioteca.persistencia.AlunoDAO;
import br.com.projetobiblioteca.utils.Colors;

public class TelaEditarAlunos {
    static Scanner sc = new Scanner(System.in);
    
    public static void editarAlunos(Funcionário funcionario) throws SQLException, InterruptedException {
        System.out.println(Colors.ANSI_BLUE + "-----EDITAR ALUNOS-----" + Colors.ANSI_RESET);
    
        System.out.print("Matrícula do aluno: ");
        String matricula = sc.nextLine();
    
        AlunoDAO alunoDAO = new AlunoDAO();
        Aluno aluno = alunoDAO.buscarPorMatricula(matricula);
    
        if (aluno == null) {
            System.out.println(Colors.ANSI_RED + "Aluno não encontrado!" + Colors.ANSI_RESET);
            return;
        }
    
        System.out.println(aluno.toString());
        System.out.println("Confirmar aluno? (S/N)");
        String confirmacao = sc.nextLine();
    
        if (confirmacao.equalsIgnoreCase("S")) {
            exibirOpcoesEdicao(aluno, funcionario);
        } else {
            System.out.println(Colors.ANSI_RED + "Cancelada a operação!" + Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
        }
    }
    
    private static void exibirOpcoesEdicao(Aluno aluno, Funcionário funcionario) throws SQLException, InterruptedException {    
        System.out.println("1 - Editar Nome");
        System.out.println("2 - Editar Curso");
        System.out.println("3 - Editar Matrícula");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
        //sc.nextLine();
        int escolha = sc.nextInt();
        System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
    
        switch (escolha) {
            case 1:
                editarNome(aluno);
                break;
            case 2:
                editarCurso(aluno);
                break;
            case 3:
                editarMatricula(aluno);
                break;
            case 0:
                TelaFunc.menuFunc(funcionario);
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    
        TelaEditarAlunos.exibirOpcoesEdicao(aluno, funcionario);;
    }
    
    private static void editarNome(Aluno aluno) {
        System.out.println("Insira o novo nome: ");
        sc.nextLine();
        String nome = sc.nextLine();

        System.out.println("Trocar " + aluno.getNome() + " por " + nome + "? (S/N)");
        String confirmacao = sc.next().toUpperCase();

        if (confirmacao.equals("S")){
            aluno.setNome(nome);
            AlunoDAO alunoDAO = new AlunoDAO();
            alunoDAO.editar(aluno);

            System.out.println(Colors.ANSI_GREEN + "Nome alterado com sucesso!" + Colors.ANSI_RESET);
        } else {
            System.out.println(Colors.ANSI_RED + "Nome não alterado!" + Colors.ANSI_RESET);
        }
        System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);

    }
    
    private static void editarCurso(Aluno aluno) {
        System.out.print("Insira o novo curso: ");
        sc.nextLine();
        String curso = sc.nextLine();

        System.out.println("Trocar " + aluno.getCurso() + " por " + curso + "? (S/N)");
        String confirmacao = sc.next().toUpperCase();

        if (confirmacao.equals("S")){
            aluno.setCurso(curso);
            AlunoDAO alunoDAO = new AlunoDAO();
            alunoDAO.editar(aluno);

            System.out.println(Colors.ANSI_GREEN + "Curso alterado com sucesso!" + Colors.ANSI_RESET);
        } else {
            System.out.println(Colors.ANSI_RED + "Curso não alterado!" + Colors.ANSI_RESET);
        }
        System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
    }
    
    private static void editarMatricula(Aluno aluno) {
        System.out.print("Insira a nova matrícula: ");
        sc.nextLine();
        String matricula = sc.nextLine();

        System.out.println("Trocar " + aluno.getMatricula() + " por " + matricula + "? (S/N)");
        //sc.nextLine();
        String confirmacao = sc.next().toUpperCase();

        if (confirmacao.equals("S")){
            aluno.setMatricula(matricula);
            AlunoDAO alunoDAO = new AlunoDAO();
            alunoDAO.editar(aluno);

            System.out.println(Colors.ANSI_GREEN + "Matrícula alterada com sucesso!" + Colors.ANSI_RESET);
        } else {
            System.out.println(Colors.ANSI_RED + "Matrícula não alterada!" + Colors.ANSI_RESET);
        }
        System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
    }
}