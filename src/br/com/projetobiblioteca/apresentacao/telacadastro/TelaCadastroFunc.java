package br.com.projetobiblioteca.apresentacao.telacadastro;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.projetobiblioteca.model.Biblioteca;
import br.com.projetobiblioteca.model.Campus;
import br.com.projetobiblioteca.model.Funcionário;
import br.com.projetobiblioteca.persistencia.BibliotecaDAO;
import br.com.projetobiblioteca.persistencia.CampusDAO;
import br.com.projetobiblioteca.persistencia.FuncionarioDAO;

public class TelaCadastroFunc {

    public static void TelaCadastroFunc() throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Insira o nome do funcionario:");
        String nome = sc.nextLine();
        sc.nextLine();
        System.out.print("Insira o email do funcionario:");
        String email = sc.next();
        sc.nextLine();
        System.out.print("Insira a senha do funcionario:");
        String senha = sc.next();
        sc.nextLine();

        // fazer verificação das bibliotecas existentes
        System.out.println("Insira a biblioteca do funcionario:");
        String biblioName = sc.nextLine().toUpperCase();
        Biblioteca biblioteca = new Biblioteca();
        BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
        for(Biblioteca b:bibliotecaDAO.buscarTodos()){
            if(b.getNome().equals(biblioName)) {
                biblioteca = b;
            } else{
                System.out.println("Biblioteca não encontrado");
                break;
            }
        }

        //fazer verificação dos funcionarios existentes
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        for(Funcionário f:funcionarioDAO.buscarTodos()) {
            if(f.getNome().equals(nome)) {
                System.out.println("Funcionario já cadastrado");
                break;
            } else {
                Funcionário funcionario = new Funcionário(0, nome, email, senha, biblioteca);
                funcionario = funcionarioDAO.adicionar(funcionario);
                System.out.println("Funcionario cadastrado com sucesso");
            }
        }
    }
}