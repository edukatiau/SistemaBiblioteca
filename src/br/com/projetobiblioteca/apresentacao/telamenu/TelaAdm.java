package br.com.projetobiblioteca.apresentacao.telamenu;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.projetobiblioteca.apresentacao.SistemaBiblioteca;
import br.com.projetobiblioteca.apresentacao.telacadastro.TelaCadastroAluno;
import br.com.projetobiblioteca.apresentacao.telacadastro.TelaCadastroCampus;
import br.com.projetobiblioteca.apresentacao.telacadastro.TelaCadastroFunc;

public class TelaAdm {

    public static void TelaAdm() throws SQLException {
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

        switch (escolha) {
            case 1:
                TelaCadastroFunc.TelaCadastroFunc();
                break;
            case 2:
                TelaCadastroAluno.TelaCadastroAluno();
                break;
            case 3:
                TelaCadastroCampus.TelaCadastroCampus();
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida...");
                TelaAdm();
                break;
        }
        SistemaBiblioteca.menu();
    }

}
