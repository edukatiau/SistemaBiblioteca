package br.com.projetobiblioteca.apresentacao.telacadastro;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.projetobiblioteca.apresentacao.telamenu.TelaAdm;
import br.com.projetobiblioteca.model.Biblioteca;
import br.com.projetobiblioteca.model.Campus;
import br.com.projetobiblioteca.persistencia.BibliotecaDAO;
import br.com.projetobiblioteca.persistencia.CampusDAO;

public class TelaCadastroCampus {

    public static void TelaCadastroCampus() throws SQLException {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Insira o nome do campus:");
        String nome = sc.nextLine().toUpperCase();
        System.out.println("Insira o endereco do campus:");
        String endereco = sc.nextLine();
        System.out.println("Insira o telefone do campus:");
        String telefone = sc.nextLine();
        
        // fazer verificação dos campus existentes
        CampusDAO campusDAO = new CampusDAO();
        if(campusDAO.buscarTodos().isEmpty()) {
            Biblioteca biblioteca = new Biblioteca();
            biblioteca = new Biblioteca(0, nome);
            BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
            biblioteca = bibliotecaDAO.adicionar(biblioteca);
            
            Campus campus = new Campus();
            campus = new Campus(0, nome, endereco, telefone, biblioteca);
            campus = campusDAO.adicionar(campus);
            System.out.println("Campus cadastrado com sucesso");
        } else{
            for(Campus c:campusDAO.buscarTodos()) {
                if(c.getNome().equals(nome)) {
                    System.out.println("Campus já cadastrado");
                    break;
                }else{
                    Biblioteca biblioteca = new Biblioteca();
                    biblioteca = new Biblioteca(0, nome);
                    BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
                    bibliotecaDAO.adicionar(biblioteca);
                    
                    Campus campus = new Campus();
                    campus = new Campus(0, nome, endereco, telefone, biblioteca);
                    campusDAO.adicionar(campus);
                    System.out.println("Campus cadastrado com sucesso");
                }
            }
        }
    TelaAdm.TelaAdm();
    }
}
