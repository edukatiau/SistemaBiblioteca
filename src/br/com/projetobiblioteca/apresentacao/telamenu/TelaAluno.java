package br.com.projetobiblioteca.apresentacao.telamenu;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.projetobiblioteca.apresentacao.telamenu.alunos.TelaAlunoEmprestimos;
import br.com.projetobiblioteca.apresentacao.telamenu.alunos.TelaAlunoPerfil;
import br.com.projetobiblioteca.apresentacao.telamenu.obras.TelaListarObras;
import br.com.projetobiblioteca.model.Aluno;
import br.com.projetobiblioteca.utils.Colors;

public class TelaAluno {
    static Scanner sc = new Scanner(System.in);

    public TelaAluno() {
    }
    
    public static void menuAluno(Aluno aluno) throws SQLException, InterruptedException {
        System.out.println(Colors.ANSI_BLUE + "-----MENU ALUNO-----" + Colors.ANSI_RESET);
        System.out.println("1 - Meu Perfil");
        System.out.println("2 - Listar Obras Disponíveis");
        System.out.println("3 - Listar Meus Emprestimos");
        System.out.println("4 - Listar Meus Atrasos");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
        int escolha = 0;
        if (sc.hasNextInt()) {
            escolha = sc.nextInt();
        } else {
            System.out.println(Colors.ANSI_RED + "Entrada inválida. Tente novamente...\n" + Colors.ANSI_RESET);
            sc.next(); // Discard the invalid input
            menuAluno(aluno);
        }
        System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
    
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
                return;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        
        TelaAluno.menuAluno(aluno);
    }
    
}
