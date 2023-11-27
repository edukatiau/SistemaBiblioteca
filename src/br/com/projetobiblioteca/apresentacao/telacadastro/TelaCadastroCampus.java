package br.com.projetobiblioteca.apresentacao.telacadastro;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.projetobiblioteca.apresentacao.telamenu.TelaAdm;
import br.com.projetobiblioteca.model.Biblioteca;
import br.com.projetobiblioteca.model.Campus;
import br.com.projetobiblioteca.persistencia.BibliotecaDAO;
import br.com.projetobiblioteca.persistencia.CampusDAO;

public class TelaCadastroCampus {
    static Scanner sc = new Scanner(System.in);

    public TelaCadastroCampus() {  
    }

    public static void cadastrarCampus() throws SQLException {
    
        System.out.println("Insira o nome do campus:");
        String nome = sc.nextLine().toUpperCase();
        System.out.println("Insira o endereco do campus:");
        String endereco = sc.nextLine();
        System.out.println("Insira o telefone do campus:");
        String telefone = sc.nextLine();
    
        // fazer verificação dos campus existentes
        CampusDAO campusDAO = new CampusDAO();
    
        // Verificar se o campus já existe na lista de campi
        boolean campusExistente = false;
        for (Campus c : campusDAO.buscarTodos()) {
            if (c.getNome().equals(nome)) {
                System.out.println("Campus já cadastrado");
                campusExistente = true;
                break;
            }
        }
    
        // Se o campus não existe, adicioná-lo
        if (!campusExistente) {
            // Criar uma nova biblioteca
            Biblioteca biblioteca = new Biblioteca(0, nome);
            BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
            bibliotecaDAO.adicionar(biblioteca);
    
            // Adicionar o novo campus
            Campus campus = new Campus(0, nome, endereco, telefone, biblioteca);
            campusDAO.adicionar(campus);
            System.out.println("Campus cadastrado com sucesso");
        }
    
    TelaAdm.menuAdm();
    }
}
