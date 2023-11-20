package br.com.projetobiblioteca.apresentacao;

import java.util.Scanner;

import br.com.projetobiblioteca.apresentacao.telalogin.TelaLoginAdm;
import br.com.projetobiblioteca.apresentacao.telalogin.TelaLoginAluno;
import br.com.projetobiblioteca.apresentacao.telalogin.TelaLoginFunc;

public class SistemaBiblioteca {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello World");
        menu();
    }

    public static void menu(){
        System.out.println("------------");
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
                TelaLoginAdm.TelaLoginAdm();
                break;
            case 2:
                TelaLoginFunc.TelaLoginFunc();
                break;
            case 3:
                TelaLoginAluno.TelaLoginAluno();
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
