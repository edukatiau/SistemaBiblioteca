package br.com.projetobiblioteca.apresentacao.telamenu.alunos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.projetobiblioteca.model.Aluno;
import br.com.projetobiblioteca.model.Funcionário;
import br.com.projetobiblioteca.persistencia.AlunoDAO;
import br.com.projetobiblioteca.utils.Colors;

public class TelaListarAlunos {
    static Scanner sc = new Scanner(System.in);
    
    public TelaListarAlunos() {
    }

    public static void listarAlunos(Funcionário funcionario) throws InterruptedException{
        System.out.println(Colors.ANSI_BLUE + "-----LISTAR ALUNOS-----" + Colors.ANSI_RESET);
        System.out.println("1 - Listar todos os alunos");
        System.out.println("2 - Listar alunos por nome");
        System.out.println("3 - Listar alunos por curso");
        System.out.println("0 - Voltar");
        System.out.print("Escolha uma opção: ");
        int escolha = sc.nextInt();
        System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);

        switch (escolha) {
            case 1:
                listarTodosOsAlunos();
                break;
            case 2:
                listarAlunosPorNome();
                break;
            case 3:
                listarAlunosPorCurso();
                break;
            case 0:
                // Voltar
                return;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        TelaListarAlunos.listarAlunos(funcionario);
    }

    private static void listarAlunosPorCurso() throws InterruptedException {
        List<Aluno> alunosList = new ArrayList<>();
        AlunoDAO alunoDAO = new AlunoDAO();

        System.out.println(Colors.ANSI_BLUE + "-----LISTAR ALUNOS-----" + Colors.ANSI_RESET);
        System.out.println("Curso do aluno: ");
        String cursoAluno = sc.next();

        for(Aluno aluno : alunoDAO.buscarPorCurso(cursoAluno)){
            alunosList.add(aluno);
        }

        int i = 1;
        for(Aluno aluno : alunosList){
            System.out.println("Aluno " + i);
            System.out.println(aluno.toString() + "\n");
            i++;
            Thread.sleep(500);
        }

        System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
    }

    private static void listarAlunosPorNome() throws InterruptedException {
        List<Aluno> alunosList = new ArrayList<>();
        AlunoDAO alunoDAO = new AlunoDAO();

        System.out.println(Colors.ANSI_BLUE + "-----LISTAR ALUNOS-----" + Colors.ANSI_RESET);
        System.out.print("Nome do aluno: ");
        String nomeAluno = sc.next();

        for(Aluno aluno : alunoDAO.buscarPorNome(nomeAluno)){
            alunosList.add(aluno);
        }

        int i = 1;
        for(Aluno aluno : alunosList){
            System.out.println("Aluno " + i);
            System.out.println(aluno.toString() + "\n");
            i++;
            Thread.sleep(500);
        }

        System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);

    }

    private static void listarTodosOsAlunos() throws InterruptedException {
        List<Aluno> alunosList = new ArrayList<>();
        AlunoDAO alunoDAO = new AlunoDAO();

        for(Aluno aluno : alunoDAO.buscarTodos()){
            alunosList.add(aluno);
        }

        System.out.println(Colors.ANSI_BLUE + "-----LISTAR ALUNOS-----" + Colors.ANSI_RESET);
        int i = 1;
        for(Aluno aluno : alunosList){
            System.out.println("Aluno " + i);
            System.out.println(aluno.toString() + "\n");
            i++;
            Thread.sleep(500);
        }

        System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
    }

}
