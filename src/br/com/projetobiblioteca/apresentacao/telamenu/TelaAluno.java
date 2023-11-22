package br.com.projetobiblioteca.apresentacao.telamenu;

import java.util.Scanner;

import br.com.projetobiblioteca.model.Aluno;

public class TelaAluno {

    public static void TelaAluno(Aluno aluno) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----MENU ALUNO-----");
        System.out.println("1 - Meu Perfil");
        System.out.println("2 - Listar Obras Disponíveis");
        System.out.println("3 - Listar Meus Emprestimos");
        System.out.println("4 - Listar Meus Atrasos");
        System.out.println("0 - Sair");
        System.out.println("Escolha uma opção: ");
        int escolha = sc.nextInt();
    }

}
