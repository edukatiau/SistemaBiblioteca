package br.com.projetobiblioteca.apresentacao.telamenu;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.projetobiblioteca.apresentacao.SistemaBiblioteca;
import br.com.projetobiblioteca.apresentacao.telamenu.alunos.TelaAlunoEmprestimos;
import br.com.projetobiblioteca.apresentacao.telamenu.alunos.TelaAlunoPerfil;
import br.com.projetobiblioteca.apresentacao.telamenu.obras.TelaListarObras;
import br.com.projetobiblioteca.model.Aluno;

public class TelaAluno {
    static Scanner sc = new Scanner(System.in);

    public TelaAluno() {
    }
    
    public static void menuAluno(Aluno aluno) throws SQLException {
        System.out.println("-----MENU ALUNO-----");
        System.out.println("1 - Meu Perfil");
        System.out.println("2 - Listar Obras Disponíveis");
        System.out.println("3 - Listar Meus Emprestimos");
        System.out.println("4 - Listar Meus Atrasos");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
        int escolha = sc.nextInt();
    
        switch (escolha) {
            case 1:
                TelaAlunoPerfil.meuPerfil(aluno);
                break;
            case 2:
                TelaListarObras.listarObras(aluno.getCampus().getBiblioteca());
                break;
            case 3:
                TelaAlunoEmprestimos.listarMeusEmprestimos(aluno);
                break;
            case 4:
                TelaAlunoEmprestimos.listarMeusAtrasos(aluno);
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
    
}
