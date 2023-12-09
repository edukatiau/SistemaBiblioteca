package br.com.projetobiblioteca.apresentacao.telamenu.funcionarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.projetobiblioteca.model.Aluno;
import br.com.projetobiblioteca.model.Campus;
import br.com.projetobiblioteca.model.Funcionário;
import br.com.projetobiblioteca.persistencia.AlunoDAO;
import br.com.projetobiblioteca.persistencia.CampusDAO;
import br.com.projetobiblioteca.persistencia.FuncionarioDAO;
import br.com.projetobiblioteca.utils.Colors;

public class TelaListarFuncionarios {
    static Scanner sc = new Scanner(System.in);

    public static void listarFuncionarios() throws InterruptedException {
        System.out.println(Colors.ANSI_BLUE + "-----LISTAR FUNCIONÁRIOS---" + Colors.ANSI_RESET);

        System.out.println("1 - Listar todos");
        System.out.println("2 - Listar por campus");

        System.out.println("0 - Voltar");
        System.out.print("Escolha uma opção: ");
        int escolha = 0;
        if (sc.hasNextInt()) {
            escolha = sc.nextInt();
        } else {
            System.out.println(Colors.ANSI_RED + "Entrada inválida. Tente novamente...\n" + Colors.ANSI_RESET);
            sc.next(); // Discard the invalid input
            listarFuncionarios();
        }
        System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);

        switch (escolha) {
            case 1:
                // Listar todos
                listarTodosFuncionarios();
                break;
            case 2:
                // Listar por campus
                listarFuncionariosCampus();
                break;
            case 0:
                // Voltar
                return;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    public static void listarTodosFuncionarios() throws InterruptedException{
        List<Funcionário> funcionariosList = new ArrayList<>();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        for(Funcionário funcionario : funcionarioDAO.buscarTodos()){
            funcionariosList.add(funcionario);
        }

        System.out.println(Colors.ANSI_BLUE + "-----LISTAR FUNCIONÁRIOS-----" + Colors.ANSI_RESET);
        int i = 1;
        for(Funcionário funcionário : funcionariosList){
            System.out.println("Aluno " + i);
            System.out.println(funcionário.toString() + "\n");
            i++;
            Thread.sleep(500);
        }

        System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
    }

    public static void listarFuncionariosCampus() throws InterruptedException{
        List<Funcionário> funcionarioList = new ArrayList<>();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        
        System.out.println(Colors.ANSI_BLUE + "-----LISTAR FUNCIONÁRIO POR CAMPUS----- " + Colors.ANSI_RESET);
        System.out.print("Digite o campus: ");
        sc.nextLine();
        String campus = sc.nextLine().toUpperCase();
        System.out.println("");

        CampusDAO campusDAO = new CampusDAO();
        Campus campusObj = campusDAO.buscarPorNome(campus);

        for(Funcionário funcionário : funcionarioDAO.buscarPorCampus(campusObj.getId_campus())){
            funcionarioList.add(funcionário);
        }

        System.out.println(Colors.ANSI_BLUE + "-----FUNCIONÁRIOS DO CAMPUS " + campus.toUpperCase() + "-----" + Colors.ANSI_RESET);
        int i = 1;
        for(Funcionário funcionário : funcionarioList){
            System.out.println("Funcionário " + i);
            System.out.println(funcionário.toString() + "\n");
            i++;
            Thread.sleep(500);
        }
        System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
    }

}
