package br.com.projetobiblioteca.apresentacao.telalogin;

import java.util.Scanner;

import br.com.projetobiblioteca.apresentacao.TelaAdm;
import br.com.projetobiblioteca.persistencia.FuncionarioDAO;

public class TelaLoginAdm {
    
    public static void TelaLoginAdm(){
        Scanner sc = new Scanner(System.in);

        System.out.println("-----LOGIN ADM-----");
        System.out.print("Email: ");
        String email = sc.next();
        //sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.next();
        //sc.nextLine();

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        if(funcionarioDAO.loginAdm(email, senha)){
            System.out.println("Login efetuado com sucesso!");
            TelaAdm.TelaAdm();
        }else{
            System.out.println("Email ou senha incorretos...");
            System.out.println("---------------");
        }
        
        //sc.close();
    }
}
