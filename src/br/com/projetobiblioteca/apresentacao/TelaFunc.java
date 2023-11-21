package br.com.projetobiblioteca.apresentacao;

import java.util.Scanner;

public class TelaFunc {

    public static void TelaFunc() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----MENU FUNC-----");
        System.out.println("1 - Cadastrar Obra");
        System.out.println("2 - Editar Obra");
        System.out.println("3 - Listar Obras");
        System.out.println("4 - Remover Obra");
        System.out.println("5 - Cadastrar Aluno");
        System.out.println("6 - Editar Aluno");
        System.out.println("7 - Listar Alunos");
        System.out.println("8 - Remover Aluno");
        
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
        int escolha = sc.nextInt();
        System.out.println("-------------------");
    }

    

}
