package br.com.projetobiblioteca.apresentacao.telamenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.projetobiblioteca.model.Funcionário;
import br.com.projetobiblioteca.model.Obra;
import br.com.projetobiblioteca.persistencia.ObraDAO;

public class TelaListarObras {

    public static void TelaListarObras(Funcionário funcionario) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----LISTAR OBRAS-----");
        System.out.println("1 - Listar todas as obras");
        System.out.println("2 - Listar obras por gênero");
        System.out.println("3 - Listar obras por título");
        System.out.println("4 - Listar obras por autor");
        System.out.println("5 - Listar obras por editora");
        System.out.println("6 - Listar obras por ano");
        System.out.println("7 - Listar obras por biblioteca");
        System.out.println("0 - Voltar");
        System.out.print("Escolha uma opção: ");
        int escolha = sc.nextInt();
        System.out.println("-------------------");

        switch (escolha) {
            case 1:
                listarTodasAsObras();
                break;
            case 2:
                listarObrasPorGenero();
                break;
            case 3:
                listarObrasPorTitulo();
                break;
            case 4:
                listarObrasPorAutor();
                break;
            case 5:
                listarObrasPorEditora();
                break;
            case 6:
                listarObrasPorAno();
                break;
            case 7:
                listarObrasPorBiblioteca();
                break;
            case 0:
                // Voltar
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    private static void listarTodasAsObras() {
        // Implementação para listar todas as obras
        List<Obra> obrasList = new ArrayList<>();
        ObraDAO obraDAO = new ObraDAO();

        for(Obra obra : obraDAO.buscarTodos()){
            obrasList.add(obra);
        }

        System.out.println("-----LISTAR OBRAS-----");
        int i = 1;
        for(Obra obra : obrasList){
            System.out.println("Obra " + i);
            System.out.println(obra.toString());
            i++;
        }
        System.out.println("-------------------");

    }

    private static void listarObrasPorGenero() {
        // Implementação para listar obras por gênero
    }

    private static void listarObrasPorTitulo() {
        // Implementação para listar obras por título
    }

    private static void listarObrasPorAutor() {
        // Implementação para listar obras por autor
    }

    private static void listarObrasPorEditora() {
        // Implementação para listar obras por editora
    }

    private static void listarObrasPorAno() {
        // Implementação para listar obras por ano
    }

    private static void listarObrasPorBiblioteca() {
        // Implementação para listar obras por biblioteca
    }
}