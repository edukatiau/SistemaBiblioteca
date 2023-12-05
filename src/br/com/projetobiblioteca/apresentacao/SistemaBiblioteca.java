package br.com.projetobiblioteca.apresentacao;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.projetobiblioteca.apresentacao.telalogin.TelaLoginAdm;
import br.com.projetobiblioteca.apresentacao.telalogin.TelaLoginAluno;
import br.com.projetobiblioteca.apresentacao.telalogin.TelaLoginFunc;
import br.com.projetobiblioteca.utils.Colors;

public class SistemaBiblioteca {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SQLException, InterruptedException {
        System.out.println(Colors.ANSI_CYAN + "\r\n" + //
                "    __    _                ______         \r\n" + //
                "   / /   (_)   ___________/_  __/__  _____\r\n" + //
                "  / /   / / | / / ___/ __ \\/ / / _ \\/ ___/\r\n" + //
                " / /___/ /| |/ / /  / /_/ / / /  __/ /__  \r\n" + //
                "/_____/_/ |___/_/   \\____/_/  \\___/\\___/  \r\n" + //
                "                                          \r\n" + //
                "" + Colors.ANSI_RESET);
        menu();
    }

    public static void menu() throws SQLException, InterruptedException{
        System.out.println(Colors.ANSI_BLUE + "-----SISTEMA BIBLIOTECA-----" + Colors.ANSI_RESET);
        System.out.println("1 - Login Administrador");
        System.out.println("2 - Login Funcionário");
        System.out.println("3 - Login Aluno");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
        int escolha = sc.nextInt();
        System.out.println(Colors.ANSI_BLUE + "----------------------------" + Colors.ANSI_RESET);

        switch (escolha) {
            case 1:
                TelaLoginAdm.loginAdm();
                SistemaBiblioteca.menu();
                break;
            case 2:
                TelaLoginFunc.loginFunc();
                SistemaBiblioteca.menu();
                break;
            case 3:
                TelaLoginAluno.loginAluno();
                SistemaBiblioteca.menu();
                break;
            case 0:
                System.out.println("Saindo...");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida...");
                menu();
                break;
        }
    }
}
