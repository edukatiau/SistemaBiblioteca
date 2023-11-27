package br.com.projetobiblioteca.apresentacao.telamenu.obras;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.projetobiblioteca.model.Biblioteca;
import br.com.projetobiblioteca.model.Obra;
import br.com.projetobiblioteca.persistencia.ObraDAO;

public class TelaListarObras {
    static Scanner sc = new Scanner(System.in);

    public TelaListarObras() {
    }

    public static void listarObras(Biblioteca biblioteca) {
        System.out.println("-----LISTAR OBRAS-----");
        System.out.println("1 - Listar todas as obras");
        System.out.println("2 - Listar obras por gênero");
        System.out.println("3 - Listar obras por título");
        System.out.println("4 - Listar obras por autor");
        System.out.println("6 - Listar obras por ano");
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
            case 6:
                listarObrasPorAno();
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
        List<Obra> obrasList = new ArrayList<>();
        ObraDAO obraDAO = new ObraDAO();
        
        System.out.println("-----LISTAR OBRAS POR GÊNERO-----");
        System.out.print("Digite o gênero: ");
        String genero = sc.next().toUpperCase();
        System.out.println("-------------------");

        for(Obra obra : obraDAO.buscarPorGenero(genero)){
            obrasList.add(obra);
        }

        System.out.println("-----OBRAS DE GÊNERO " + genero.toUpperCase() + "-----");
        int i = 1;
        for(Obra obra : obrasList){
            System.out.println("Obra " + i);
            System.out.println(obra.toString());
            i++;
        }
        System.out.println("-------------------");
        
    }

    private static void listarObrasPorTitulo() {
        // Implementação para listar obras por título
        List<Obra> obrasList = new ArrayList<>();
        ObraDAO obraDAO = new ObraDAO();

        System.out.println("-----LISTAR OBRAS POR TÍTULO-----");
        System.out.print("Digite o título: ");
        String titulo = sc.next().toUpperCase();
        System.out.println("-------------------");

        for(Obra obra : obraDAO.buscarPorTitulo(titulo)){
            obrasList.add(obra);
        }
        
        System.out.println("-----OBRAS COM TÍTULO " + titulo.toUpperCase() + "-----");
        int i = 1;
        for(Obra obra : obrasList){
            System.out.println("Obra " + i);
            System.out.println(obra.toString());
            i++;
        }

        System.out.println("-------------------");
        
    }

    private static void listarObrasPorAutor() {
        // Implementação para listar obras por autor
        List<Obra> obrasList = new ArrayList<>();
        ObraDAO obraDAO = new ObraDAO();

        System.out.println("-----LISTAR OBRAS POR AUTOR-----");

        System.out.print("Digite o autor: ");
        String autor = sc.next().toUpperCase();
        System.out.println("-------------------");

        for(Obra obra : obraDAO.buscarPorAutor(autor)){
            obrasList.add(obra);
        }

        System.out.println("-----OBRAS DO AUTOR " + autor.toUpperCase() + "-----");
        int i = 1;
        for(Obra obra : obrasList){
            System.out.println("Obra " + i);
            System.out.println(obra.toString());
            i++;
        }

        System.out.println("-------------------");

    }

    private static void listarObrasPorAno() {
        // Implementação para listar obras por ano
        List<Obra> obrasList = new ArrayList<>();
        ObraDAO obraDAO = new ObraDAO();
    
        System.out.println("-----LISTAR OBRAS POR ANO-----");
    
        System.out.print("Digite o ano: ");
        String ano = sc.next().toUpperCase();
        System.out.println("-------------------");
    
        for(Obra obra : obraDAO.buscarPorAno(ano)){
            obrasList.add(obra);
        }

        System.out.println("-----OBRAS DO ANO " + ano.toUpperCase() + "-----");
        int i = 1;
        for(Obra obra : obrasList){
            System.out.println("Obra " + i);
            System.out.println(obra.toString());
            i++;
        }

        System.out.println("-------------------");
        
    }
}