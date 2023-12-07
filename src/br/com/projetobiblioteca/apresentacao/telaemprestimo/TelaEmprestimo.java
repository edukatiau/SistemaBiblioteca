package br.com.projetobiblioteca.apresentacao.telaemprestimo;

import java.util.Scanner;

import br.com.projetobiblioteca.model.Funcionário;
import br.com.projetobiblioteca.utils.Colors;


public class TelaEmprestimo {
    static Scanner sc = new Scanner(System.in);

    public TelaEmprestimo() {
    }

    public static void telaEmprestimo(Funcionário funcionario) throws InterruptedException {

        System.out.println(Colors.ANSI_BLUE + "-----EMPRÉSTIMOS-----" + Colors.ANSI_RESET);
        System.out.println("1 - Emprestar Obra");
        System.out.println("2 - Devolver Obra");
        System.out.println("3 - Listar Empréstimos");
        System.out.println("4 - Listar Empréstimos Atrasados");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");

        int escolha = 0;
        if (sc.hasNextInt()) {
            escolha = sc.nextInt();
        } else {
            System.out.println(Colors.ANSI_RED + "Entrada inválida. Tente novamente...\n" + Colors.ANSI_RESET);
            sc.next(); // Discard the invalid input
            telaEmprestimo(funcionario);
        }
        System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);

        switch (escolha) {
            case 1:
                TelaEmprestarObra.emprestarObra(funcionario);
                break;
            case 2:
                TelaDevolucaoObra.devolverObra(funcionario);
                break;
            case 3:
                TelaListarEmprestimos.listarEmprestimos(funcionario);
                break;
            case 4:
                TelaListarEmprestimos.listarEmprestimosAtrasados(funcionario);
                break;
            case 0:
                System.out.println("Saindo...");
                return;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        TelaEmprestimo.telaEmprestimo(funcionario);
    }
}