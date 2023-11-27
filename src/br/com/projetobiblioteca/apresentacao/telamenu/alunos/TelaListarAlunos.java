package br.com.projetobiblioteca.apresentacao.telamenu.alunos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.projetobiblioteca.model.Aluno;
import br.com.projetobiblioteca.model.Funcionário;
import br.com.projetobiblioteca.persistencia.AlunoDAO;

public class TelaListarAlunos {
    static Scanner sc = new Scanner(System.in);
    
    public TelaListarAlunos() {
    }

    public static void listarAlunos(Funcionário funcionario){
        System.out.println("-----LISTAR ALUNOS-----");
        System.out.println("1 - Listar todos os alunos");
        System.out.println("2 - Listar alunos por nome");
        System.out.println("0 - Voltar");
        System.out.print("Escolha uma opção: ");
        int escolha = sc.nextInt();
        System.out.println("-------------------");

        switch (escolha) {
            case 1:
                listarTodosOsAlunos();
                break;
            case 2:
                listarAlunosPorNome();
                break;
            case 0:
                // Voltar
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    private static void listarAlunosPorNome() {
        List<Aluno> alunosList = new ArrayList<>();
        AlunoDAO alunoDAO = new AlunoDAO();

        System.out.println("-----LISTAR ALUNOS-----");
        System.out.println("Nome do aluno: ");
        String nomeAluno = sc.next();

        for(Aluno aluno : alunoDAO.buscarPorNome(nomeAluno)){
            alunosList.add(aluno);
        }

        System.out.println("-----LISTAR ALUNOS-----");
        int i = 1;
        for(Aluno aluno : alunosList){
            System.out.println("Aluno " + i);
            System.out.println(aluno.toString());
            i++;
        }

        System.out.println("-------------------");

    }

    private static void listarTodosOsAlunos() {
        List<Aluno> alunosList = new ArrayList<>();
        AlunoDAO alunoDAO = new AlunoDAO();

        for(Aluno aluno : alunoDAO.buscarTodos()){
            alunosList.add(aluno);
        }

        System.out.println("-----LISTAR ALUNOS-----");
        int i = 1;
        for(Aluno aluno : alunosList){
            System.out.println("Aluno " + i);
            System.out.println(aluno.toString());
            i++;
        }

        System.out.println("-------------------");
    }
}
