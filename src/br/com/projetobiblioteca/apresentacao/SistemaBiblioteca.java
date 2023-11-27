package br.com.projetobiblioteca.apresentacao;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.projetobiblioteca.apresentacao.telalogin.TelaLoginAdm;
import br.com.projetobiblioteca.apresentacao.telalogin.TelaLoginAluno;
import br.com.projetobiblioteca.apresentacao.telalogin.TelaLoginFunc;

public class SistemaBiblioteca {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        System.out.println("Hello World");
        menu();
    }

    public static void menu() throws SQLException{
        System.out.println("-----SISTEMA BIBLIOTECA-----");
        System.out.println("1 - Login Administrador");
        System.out.println("2 - Login Funcionário");
        System.out.println("3 - Login Aluno");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
        int escolha = sc.nextInt();
        System.out.println("------------");
        //sc.close();

        switch (escolha) {
            case 1:
                TelaLoginAdm.loginAdm();
                break;
            case 2:
                TelaLoginFunc.loginFunc();
                break;
            case 3:
                TelaLoginAluno.loginAluno();
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida...");
                menu();
                break;
        }
    }
}
