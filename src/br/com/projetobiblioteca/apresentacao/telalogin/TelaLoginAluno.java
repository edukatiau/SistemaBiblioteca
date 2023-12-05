package br.com.projetobiblioteca.apresentacao.telalogin;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.projetobiblioteca.apresentacao.telamenu.TelaAluno;
import br.com.projetobiblioteca.model.Aluno;
import br.com.projetobiblioteca.persistencia.AlunoDAO;
import br.com.projetobiblioteca.utils.Colors;

public class TelaLoginAluno {
    static Scanner sc = new Scanner(System.in);
    
    public TelaLoginAluno() {
    }

    public static void loginAluno() throws SQLException, InterruptedException{
        
        System.out.println(Colors.ANSI_BLUE + "-----LOGIN ALUNO-----" + Colors.ANSI_RESET);
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

        AlunoDAO alunoDAO = new AlunoDAO();
        if(alunoDAO.login(email, senha)){
            System.out.println(Colors.ANSI_GREEN + "\nLogin efetuado com sucesso!" + Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
            Thread.sleep(1000);
            Aluno aluno = new Aluno();
            aluno = alunoDAO.buscarPorEmail(email);
            TelaAluno.menuAluno(aluno);
        }
        else{
            System.out.println(Colors.ANSI_RED + "\nEmail ou senha incorretos..." + Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
            Thread.sleep(1000);
            return;
        }

        
    }
}
