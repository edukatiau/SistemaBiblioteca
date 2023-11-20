package br.com.projetobiblioteca.apresentacao;

import java.util.Scanner;

public class TelaAdm {

    public static void TelaAdm() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----MENU ADM-----");
        System.out.println("1 - Cadastrar Funcionário");
        System.out.println("2 - Cadastrar Aluno");
        System.out.println("3 - Cadastrar Campus");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
        int escolha = sc.nextInt();
        System.out.println("---------------");
        //sc.close();
    }

}
