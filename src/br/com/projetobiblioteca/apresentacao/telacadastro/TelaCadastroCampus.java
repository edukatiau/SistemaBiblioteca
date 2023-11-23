package br.com.projetobiblioteca.apresentacao.telacadastro;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.projetobiblioteca.model.Campus;
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
        for(Campus c:campusDAO.buscarTodos()) {
            if(c.getNome().equals(nome)) {
                System.out.println("Campus já cadastrado");
                break;
            }else{
                Campus campus = new Campus();
                campus = new Campus(0, nome, endereco, telefone);
                campusDAO.adicionar(campus);
                System.out.println("Campus cadastrado com sucesso");
            }
        }
    }

}
