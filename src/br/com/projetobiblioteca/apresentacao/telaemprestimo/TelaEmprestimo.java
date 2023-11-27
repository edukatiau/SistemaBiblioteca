package br.com.projetobiblioteca.apresentacao.telaemprestimo;

import java.util.Scanner;

import br.com.projetobiblioteca.model.Funcionário;


public class TelaEmprestimo {
    static Scanner sc = new Scanner(System.in);

    public TelaEmprestimo() {
    }

    public static void telaEmprestimo(Funcionário funcionario) {

        System.out.println("-----EMPRÉSTIMOS-----");
        System.out.println("1 - Emprestar Obra");
        System.out.println("2 - Devolver Obra");
        System.out.println("3 - Listar Empréstimos");
        System.out.println("4 - Listar Empréstimos Atrasados");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");

        int escolha = sc.nextInt();
        System.out.println("-------------------");

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
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }
}