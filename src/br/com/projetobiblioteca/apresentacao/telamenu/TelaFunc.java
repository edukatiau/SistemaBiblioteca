package br.com.projetobiblioteca.apresentacao.telamenu;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.projetobiblioteca.apresentacao.telacadastro.TelaCadastroAluno;
import br.com.projetobiblioteca.apresentacao.telacadastro.TelaCadastroObra;
import br.com.projetobiblioteca.apresentacao.telaemprestimo.TelaEmprestimo;
import br.com.projetobiblioteca.apresentacao.telamenu.alunos.TelaEditarAlunos;
import br.com.projetobiblioteca.apresentacao.telamenu.alunos.TelaListarAlunos;
import br.com.projetobiblioteca.apresentacao.telamenu.alunos.TelaRemoverAluno;
import br.com.projetobiblioteca.apresentacao.telamenu.obras.TelaEditarObra;
import br.com.projetobiblioteca.apresentacao.telamenu.obras.TelaListarObras;
import br.com.projetobiblioteca.apresentacao.telamenu.obras.TelaRemoverObra;
import br.com.projetobiblioteca.model.Funcionário;
import br.com.projetobiblioteca.utils.Colors;

public class TelaFunc {
    static Scanner sc = new Scanner(System.in);

    public TelaFunc() {
    }

    public static void menuFunc(Funcionário funcionario) throws SQLException, InterruptedException {
        System.out.println(Colors.ANSI_BLUE + "-----MENU FUNC-----" + Colors.ANSI_RESET);
        System.out.println("1 - Cadastrar Obra");
        System.out.println("2 - Editar Obra");
        System.out.println("3 - Listar Obras");
        System.out.println("4 - Remover Obra");
        System.out.println("");
        System.out.println("5 - Cadastrar Aluno");
        System.out.println("6 - Editar Aluno");
        System.out.println("7 - Listar Alunos");
        System.out.println("8 - Remover Aluno");
        System.out.println("");
        System.out.println("9 - Empréstimos");
        
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
        int escolha = 0;
        if (sc.hasNextInt()) {
            escolha = sc.nextInt();
        } else {
            System.out.println(Colors.ANSI_RED + "Entrada inválida. Tente novamente...\n" + Colors.ANSI_RESET);
            sc.next(); // Discard the invalid input
            menuFunc(funcionario);
        }
        System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);

        switch (escolha) {
            case 1:
                TelaCadastroObra.cadastrarObra(funcionario);
                break;
            case 2:
                TelaEditarObra.editarObra(funcionario);
                break;
            case 3:
                TelaListarObras.listarObras(funcionario.getBiblioteca());
                break;
            case 4:
                TelaRemoverObra.removerObra(funcionario);
                break;
            case 5:
                TelaCadastroAluno.cadastrarAluno(funcionario);
                break;
            case 6:
                TelaEditarAlunos.editarAlunos(funcionario);
                break;
            case 7:
                TelaListarAlunos.listarAlunos(funcionario);
                break;
            case 8:
                TelaRemoverAluno.removerAluno(funcionario);
                break;
            case 9:
                TelaEmprestimo.telaEmprestimo(funcionario);
                break;
            case 0:
                System.out.println("Saindo...");
                return;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        TelaFunc.menuFunc(funcionario);
        
    }
}
