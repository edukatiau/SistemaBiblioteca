package br.com.projetobiblioteca.apresentacao.telacadastro;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.projetobiblioteca.apresentacao.telamenu.TelaAdm;
import br.com.projetobiblioteca.model.Biblioteca;
import br.com.projetobiblioteca.model.Campus;
import br.com.projetobiblioteca.persistencia.BibliotecaDAO;
import br.com.projetobiblioteca.persistencia.CampusDAO;
import br.com.projetobiblioteca.utils.Colors;

public class TelaCadastroCampus {
    static Scanner sc = new Scanner(System.in);

    public TelaCadastroCampus() {  
    }

    public static void cadastrarCampus() throws SQLException, InterruptedException {
        System.out.println(Colors.ANSI_BLUE + "-----CADASTRO CAMPUS-----" + Colors.ANSI_RESET);
        System.out.print("Insira o nome do campus: ");
        String nome = sc.nextLine().toUpperCase();
        System.out.print("Insira o endereco do campus: ");
        String endereco = sc.nextLine();
        System.out.print("Insira o telefone do campus: ");
        String telefone = sc.nextLine();
    
        // fazer verificação dos campus existentes
        CampusDAO campusDAO = new CampusDAO();
    
        // Verificar se o campus já existe na lista de campus
        boolean campusExistente = false;
        for (Campus c : campusDAO.buscarTodos()) {
            if (c.getNome().equals(nome)) {
                System.out.println(Colors.ANSI_RED + "Campus já cadastrado!" + Colors.ANSI_RESET);
                System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
                campusExistente = true;
                return;
            }
            if(c.getTelefone().equals(telefone)){
                System.out.println(Colors.ANSI_RED + "Telefone já cadastrado!" + Colors.ANSI_RESET);
                System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
                campusExistente = true;
                return;
            }
            if(c.getEndereco().equals(endereco)){
                System.out.println(Colors.ANSI_RED + "Endereço já cadastrado!" + Colors.ANSI_RESET);
                System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
                campusExistente = true;
                return;
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
            System.out.println(Colors.ANSI_GREEN + "Campus cadastrado com sucesso!" + Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
        }
    
    TelaAdm.menuAdm();
    }
}
