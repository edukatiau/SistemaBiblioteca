package br.com.projetobiblioteca.apresentacao.telamenu;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.projetobiblioteca.apresentacao.SistemaBiblioteca;
import br.com.projetobiblioteca.apresentacao.telacadastro.TelaCadastroCampus;
import br.com.projetobiblioteca.apresentacao.telacadastro.TelaCadastroFunc;
import br.com.projetobiblioteca.utils.Colors;

public class TelaAdm {
    static Scanner sc = new Scanner(System.in);

    public TelaAdm() {
    }

    public static void menuAdm() throws SQLException, InterruptedException {
        System.out.println(Colors.ANSI_BLUE + "-----MENU ADM-----" + Colors.ANSI_RESET);
        System.out.println("1 - Cadastrar Funcionário");
        System.out.println("2 - Cadastrar Campus");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
        int escolha = sc.nextInt();
        System.out.println(Colors.ANSI_BLUE + "-----------------" + Colors.ANSI_RESET);
        //sc.close();

        switch (escolha) {
            case 1:
                TelaCadastroFunc.cadastrarFuncionario();
                break;
            case 2:
                TelaCadastroCampus.cadastrarCampus();
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida...");
                menuAdm();
                break;
        }
        SistemaBiblioteca.menu();
    }

}
