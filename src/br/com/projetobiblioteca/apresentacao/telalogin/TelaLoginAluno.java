package br.com.projetobiblioteca.apresentacao.telalogin;

import java.util.Scanner;

import br.com.projetobiblioteca.apresentacao.telamenu.TelaAluno;
import br.com.projetobiblioteca.model.Aluno;
import br.com.projetobiblioteca.persistencia.AlunoDAO;

public class TelaLoginAluno {
    
    public static void TelaLoginAluno(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("-----LOGIN ALUNO-----");
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Senha: ");
        String senha = sc.next();
        
        AlunoDAO alunoDAO = new AlunoDAO();
        if(alunoDAO.login(email, senha)){
            System.out.println("Login efetuado com sucesso!");
            Aluno aluno = new Aluno();
            aluno = alunoDAO.buscarPorEmail(email);
            TelaAluno.TelaAluno(aluno);
        }
        else{
            System.out.println("Email ou senha incorretos!");
            System.out.println("---------------------");
        }
    }
}
