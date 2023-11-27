package br.com.projetobiblioteca.apresentacao.telacadastro;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.projetobiblioteca.apresentacao.telamenu.TelaAdm;
import br.com.projetobiblioteca.model.Aluno;
import br.com.projetobiblioteca.model.Campus;
import br.com.projetobiblioteca.model.Funcionário;
import br.com.projetobiblioteca.persistencia.AlunoDAO;
import br.com.projetobiblioteca.persistencia.CampusDAO;

public class TelaCadastroAluno {

    public TelaCadastroAluno()  {
    }

    public static void cadastrarAluno(Funcionário funcionario) throws SQLException{
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
        if(campus.getNome().equals("")) {
            System.out.println("Campus não encontrado");
            TelaAdm.menuAdm();
        }

        // fazer verificação dos alunos existentes
        AlunoDAO alunoDAO = new AlunoDAO();
        if(alunoDAO.buscarTodos().isEmpty()) {
            Aluno aluno = new Aluno(0, nome, email, senha, matricula, curso, campus);
            aluno = alunoDAO.adicionar(aluno);
            System.out.println("Aluno cadastrado com sucesso");
        } else {
            for(Aluno a:alunoDAO.buscarTodos()) {
                if(a.getNome().equals(nome)) {
                    System.out.println("Aluno já cadastrado");
                    break;
                } else {
                    Aluno aluno = new Aluno(0, nome, email, senha, matricula, curso, campus);
                    aluno = alunoDAO.adicionar(aluno);
                    System.out.println("Aluno cadastrado com sucesso");
                }
            }
        }
    TelaAdm.menuAdm();
    }
}
