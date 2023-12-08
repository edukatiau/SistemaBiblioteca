package br.com.projetobiblioteca.apresentacao.telamenu.funcionarios;

import java.util.Scanner;

import br.com.projetobiblioteca.model.Funcionário;
import br.com.projetobiblioteca.persistencia.FuncionarioDAO;
import br.com.projetobiblioteca.utils.Colors;

public class TelaRemoverFuncionario {
    static Scanner sc = new Scanner(System.in);

    public static void removerFuncionario() {
        System.out.println(Colors.ANSI_BLUE + "-----REMOVER FUNCIONÁRIO---" + Colors.ANSI_RESET);
        System.out.print("ID Funcionário: ");
        int idFuncionario = sc.nextInt();

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        Funcionário funcionario = funcionarioDAO.buscarPorId(idFuncionario);

        if (funcionario == null) {
            System.out.println(Colors.ANSI_RED + "Funcionário não encontrado!" + Colors.ANSI_RESET);
        } else {
            System.out.println(funcionario.toString());
            System.out.println("Confirma a remoção? (S/N)");
            String confirmacao = sc.next().toUpperCase();

            if (!confirmacao.equals("S")) {
                System.out.println(Colors.ANSI_RED + "Remoção cancelada!" + Colors.ANSI_RESET);
            } else {
                funcionarioDAO.excluir(funcionario.getIdUsuario());
                System.out.println(Colors.ANSI_GREEN + "Funcionário removido com sucesso!" + Colors.ANSI_RESET);
            }
            System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
        }
    }

}
