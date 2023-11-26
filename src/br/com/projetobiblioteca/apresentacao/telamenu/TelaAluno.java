package br.com.projetobiblioteca.apresentacao.telamenu;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.projetobiblioteca.apresentacao.SistemaBiblioteca;
import br.com.projetobiblioteca.apresentacao.telamenu.alunos.TelaAlunoPerfil;
import br.com.projetobiblioteca.apresentacao.telamenu.obras.TelaListarObras;
import br.com.projetobiblioteca.model.Aluno;

public class TelaAluno {

    public static void TelaAluno(Aluno aluno) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----MENU ALUNO-----");
        System.out.println("1 - Meu Perfil");
        System.out.println("2 - Listar Obras Disponíveis");
        System.out.println("3 - Listar Meus Emprestimos");
        System.out.println("4 - Listar Meus Atrasos");
        System.out.println("0 - Sair");
        System.out.println("Escolha uma opção: ");
        int escolha = sc.nextInt();
    
        switch (escolha) {
            case 1:
                TelaAlunoPerfil.meuPerfil(aluno);
                break;
            case 2:
                TelaListarObras.TelaListarObras(aluno.getCampus().getBiblioteca());
                break;
            case 3:
                listarMeusEmprestimos();
                break;
            case 4:
                listarMeusAtrasos();
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        
        SistemaBiblioteca.menu();
    }
    
    private static void meuPerfil() {
        // TODO: Implementar lógica para exibir o perfil do aluno
    }
    
    private static void listarObrasDisponiveis() {
        // TODO: Implementar lógica para listar as obras disponíveis
    }
    
    private static void listarMeusEmprestimos() {
        // TODO: Implementar lógica para listar os empréstimos do aluno
    }
    
    private static void listarMeusAtrasos() {
        // TODO: Implementar lógica para listar os atrasos do aluno
    }
}
