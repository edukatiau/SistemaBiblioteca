package br.com.projetobiblioteca.apresentacao.telalogin;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.projetobiblioteca.apresentacao.SistemaBiblioteca;
import br.com.projetobiblioteca.apresentacao.telamenu.TelaFunc;
import br.com.projetobiblioteca.persistencia.FuncionarioDAO;
import br.com.projetobiblioteca.utils.Colors;

public class TelaLoginFunc {
    static Scanner sc = new Scanner(System.in);
    
    public TelaLoginFunc() {
    }

    public static void loginFunc() throws SQLException, InterruptedException{

        System.out.println(Colors.ANSI_BLUE + "-----LOGIN FUNC-----" + Colors.ANSI_RESET);
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Senha: ");
        String senha = sc.next();
        
        System.out.print("Logando");
        for(int i = 0; i < 3; i++){
            System.out.print(".");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        if(funcionarioDAO.login(email, senha)){
            System.out.println(Colors.ANSI_GREEN + "\nLogin efetuado com sucesso!" + Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE + "--------------------" + Colors.ANSI_RESET);
            Thread.sleep(1000);
            TelaFunc.menuFunc(funcionarioDAO.buscarPorEmail(email));
        }else{
            System.out.println(Colors.ANSI_RED + "\nEmail ou senha incorretos..." + Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE + "--------------------" + Colors.ANSI_RESET);
            Thread.sleep(1000);
            SistemaBiblioteca.menu();
        }
    }
}
