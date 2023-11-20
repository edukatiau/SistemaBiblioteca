package br.com.projetobiblioteca.apresentacao.telalogin;

import java.util.Scanner;

import br.com.projetobiblioteca.apresentacao.TelaFunc;
import br.com.projetobiblioteca.persistencia.FuncionarioDAO;

public class TelaLoginFunc {
    
    public static void TelaLoginFunc(){
        Scanner sc = new Scanner(System.in);

        System.out.println("-----LOGIN FUNC-----");
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Senha: ");
        String senha = sc.next();
        
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        if(funcionarioDAO.login(email, senha)){
            System.out.println("Login efetuado com sucesso!");
            TelaFunc.TelaFunc();
        }else{
            System.out.println("Email ou senha incorretos!");
            System.out.println("---------------------");
        }
    }
}
