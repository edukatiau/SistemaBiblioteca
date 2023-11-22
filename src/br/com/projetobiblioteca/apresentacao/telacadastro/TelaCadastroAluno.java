package br.com.projetobiblioteca.apresentacao.telacadastro;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.projetobiblioteca.model.Aluno;
import br.com.projetobiblioteca.model.Campus;
import br.com.projetobiblioteca.persistencia.AlunoDAO;
import br.com.projetobiblioteca.persistencia.CampusDAO;

public class TelaCadastroAluno {

    public static void TelaCadastroAluno() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira o nome do aluno:");
        String nome = sc.nextLine();
        System.out.println("Insira o email do aluno:");
        String email = sc.next();
        sc.nextLine();
        System.out.println("Insira a senha do aluno:");
        String senha = sc.next();
        sc.nextLine();
        System.out.println("Insira a matricula do aluno:");
        String matricula = sc.next();
        sc.nextLine();
        System.out.println("Insira o curso do aluno:");
        String curso = sc.next();
        sc.nextLine();
        
        // fazer verificação dos campus existentes
        System.out.println("Insira o campus do aluno:");
        String campusName = sc.nextLine().toUpperCase();
        Campus campus = new Campus();
        CampusDAO campusDAO = new CampusDAO();
        for(Campus c:campusDAO.buscarTodos()) {
            if(c.getNome().equals(campusName)) {
                campus = c;
            }
        }
        Aluno aluno = new Aluno(0, nome, email, senha, matricula, curso, campus);
        AlunoDAO alunoDAO = new AlunoDAO();
        aluno = alunoDAO.adicionar(aluno);
        System.out.println("Aluno cadastrado com sucesso");
    }

}
