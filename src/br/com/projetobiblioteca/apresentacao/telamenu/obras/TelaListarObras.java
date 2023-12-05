package br.com.projetobiblioteca.apresentacao.telamenu.obras;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.projetobiblioteca.model.Biblioteca;
import br.com.projetobiblioteca.model.Obra;
import br.com.projetobiblioteca.persistencia.ObraDAO;
import br.com.projetobiblioteca.utils.Colors;

public class TelaListarObras {
    static Scanner sc = new Scanner(System.in);

    public TelaListarObras() {
    }

    public static void listarObras(Biblioteca biblioteca) throws InterruptedException {
        System.out.println(Colors.ANSI_BLUE + "-----LISTAR OBRAS-----" + Colors.ANSI_RESET);
        System.out.println("1 - Listar todas as obras");
        System.out.println("2 - Listar obras por gênero");
        System.out.println("3 - Listar obras por título");
        System.out.println("4 - Listar obras por autor");
        System.out.println("5 - Listar obras por ano");
        System.out.println("0 - Voltar");
        System.out.print("Escolha uma opção: ");
        int escolha = sc.nextInt();
        System.out.println(Colors.ANSI_BLUE + "---------------------" + Colors.ANSI_RESET);

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
                listarObrasPorAno();
                break;
            case 0:
                System.out.println("Voltando...");
                return;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        TelaListarObras.listarObras(biblioteca);
    }

    private static void listarTodasAsObras() throws InterruptedException {
        List<Obra> obrasList = new ArrayList<>();
        ObraDAO obraDAO = new ObraDAO();

        for(Obra obra : obraDAO.buscarTodos()){
            obrasList.add(obra);
        }

        System.out.println(Colors.ANSI_BLUE + "-----LISTAR OBRAS-----" + Colors.ANSI_RESET);
        int i = 1;
        for(Obra obra : obrasList){
            System.out.println("Obra " + i);
            System.out.println(obra.toString() + "\n");
            i++;
            Thread.sleep(500);
        }
        System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);

    }

    private static void listarObrasPorGenero() throws InterruptedException {
        List<Obra> obrasList = new ArrayList<>();
        ObraDAO obraDAO = new ObraDAO();
        
        System.out.println(Colors.ANSI_BLUE + "-----LISTAR OBRAS POR GÊNERO----- " + Colors.ANSI_RESET);
        System.out.print("Digite o gênero: ");
        sc.nextLine();
        String genero = sc.nextLine().toUpperCase();
        System.out.println("");

        for(Obra obra : obraDAO.buscarPorGenero(genero)){
            obrasList.add(obra);
        }

        System.out.println(Colors.ANSI_BLUE + "-----OBRAS DE GÊNERO " + genero.toUpperCase() + "-----" + Colors.ANSI_RESET);
        int i = 1;
        for(Obra obra : obrasList){
            System.out.println("Obra " + i);
            System.out.println(obra.toString() + "\n");
            i++;
            Thread.sleep(500);
        }
        System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
        
    }

    private static void listarObrasPorTitulo() throws InterruptedException {
        List<Obra> obrasList = new ArrayList<>();
        ObraDAO obraDAO = new ObraDAO();

        System.out.println(Colors.ANSI_BLUE + "-----LISTAR OBRAS POR TÍTULO-----" + Colors.ANSI_RESET);
        System.out.print("Digite o título: ");
        sc.nextLine();
        String titulo = sc.nextLine().toUpperCase();
        System.out.println("");

        for(Obra obra : obraDAO.buscarPorTitulo(titulo)){
            obrasList.add(obra);
        }
        
        System.out.println(Colors.ANSI_BLUE + "-----OBRAS COM TÍTULO " + titulo.toUpperCase() + "-----" + Colors.ANSI_RESET);
        int i = 1;
        for(Obra obra : obrasList){
            System.out.println("Obra " + i);
            System.out.println(obra.toString() + "\n");
            i++;
            Thread.sleep(500);
        }

        System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
        
    }

    private static void listarObrasPorAutor() throws InterruptedException {
        // Implementação para listar obras por autor
        List<Obra> obrasList = new ArrayList<>();
        ObraDAO obraDAO = new ObraDAO();

        System.out.println(Colors.ANSI_BLUE + "-----LISTAR OBRAS POR AUTOR-----" + Colors.ANSI_RESET);

        System.out.print("Digite o autor: ");
        sc.nextLine();
        String autor = sc.nextLine().toUpperCase();
        System.out.println("");

        for(Obra obra : obraDAO.buscarPorAutor(autor)){
            obrasList.add(obra);
        }

        System.out.println(Colors.ANSI_BLUE + "-----OBRAS DO AUTOR " + autor.toUpperCase() + "-----" + Colors.ANSI_RESET);
        int i = 1;
        for(Obra obra : obrasList){
            System.out.println("Obra " + i);
            System.out.println(obra.toString() + "\n");
            i++;
            Thread.sleep(500);
        }

        System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);

    }

    private static void listarObrasPorAno() throws InterruptedException {
        // Implementação para listar obras por ano
        List<Obra> obrasList = new ArrayList<>();
        ObraDAO obraDAO = new ObraDAO();
    
        System.out.println(Colors.ANSI_BLUE + "-----LISTAR OBRAS POR ANO-----" + Colors.ANSI_RESET);
    
        System.out.print("Digite o ano: ");
        sc.nextLine();
        String ano = sc.next().toUpperCase();
        System.out.println("");
    
        for(Obra obra : obraDAO.buscarPorAno(ano)){
            obrasList.add(obra);
        }

        System.out.println(Colors.ANSI_BLUE + "-----OBRAS DO ANO " + ano.toUpperCase() + "-----" + Colors.ANSI_RESET);
        int i = 1;
        for(Obra obra : obrasList){
            System.out.println("Obra " + i);
            System.out.println(obra.toString() + "\n");
            i++;
            Thread.sleep(500);
        }

        System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
        
    }
}