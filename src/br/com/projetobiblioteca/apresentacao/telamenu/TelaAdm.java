package br.com.projetobiblioteca.apresentacao.telamenu;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.projetobiblioteca.apresentacao.SistemaBiblioteca;
import br.com.projetobiblioteca.apresentacao.telacadastro.TelaCadastroCampus;
import br.com.projetobiblioteca.apresentacao.telacadastro.TelaCadastroFunc;
import br.com.projetobiblioteca.apresentacao.telamenu.campus.TelaEditarCampus;
import br.com.projetobiblioteca.apresentacao.telamenu.campus.TelaListarCampus;
import br.com.projetobiblioteca.apresentacao.telamenu.campus.TelaRemoverCampus;
import br.com.projetobiblioteca.apresentacao.telamenu.funcionarios.TelaEditarFuncionario;
import br.com.projetobiblioteca.apresentacao.telamenu.funcionarios.TelaListarFuncionarios;
import br.com.projetobiblioteca.apresentacao.telamenu.funcionarios.TelaRemoverFuncionario;
import br.com.projetobiblioteca.utils.Colors;

public class TelaAdm {
    static Scanner sc = new Scanner(System.in);

    public TelaAdm() {
    }

    public static void menuAdm() throws SQLException, InterruptedException {
        System.out.println(Colors.ANSI_BLUE + "-----MENU ADM-----" + Colors.ANSI_RESET);
        System.out.println("1 - Cadastrar Funcionário");
        System.out.println("2 - Listar Funcionários");
        System.out.println("3 - Editar Funcionário");
        System.out.println("4 - Remover Funcionário");
        System.out.println("");
        System.out.println("5 - Cadastrar Campus");
        System.out.println("6 - Listar Campi");
        System.out.println("7 - Editar Campus");
        System.out.println("8 - Remover Campus");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
        int escolha = 0;
        if (sc.hasNextInt()) {
            escolha = sc.nextInt();
        } else {
            System.out.println(Colors.ANSI_RED + "Entrada inválida. Tente novamente...\n" + Colors.ANSI_RESET);
            sc.next(); // Discard the invalid input
            menuAdm();
        }
        System.out.println(Colors.ANSI_BLUE + "-----------------" + Colors.ANSI_RESET);

        switch (escolha) {
            case 1:
                TelaCadastroFunc.cadastrarFuncionario();
                TelaAdm.menuAdm();
                break;
            case 2:
                TelaListarFuncionarios.listarFuncionarios();
                TelaAdm.menuAdm();
                break;
            case 3:
                TelaEditarFuncionario.editarFuncionario();
                TelaAdm.menuAdm();
                break;
            case 4:
                TelaRemoverFuncionario.removerFuncionario();
                TelaAdm.menuAdm();
                break;
            case 5:
                TelaCadastroCampus.cadastrarCampus();
                TelaAdm.menuAdm();
                break;
            case 6:
                TelaListarCampus.listarCampus();
                TelaAdm.menuAdm();
                break;
            case 7:
                TelaEditarCampus.editarCampus();
                TelaAdm.menuAdm();
                break;
            case 8:
                TelaRemoverCampus.removerCampus();
                TelaAdm.menuAdm();
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
