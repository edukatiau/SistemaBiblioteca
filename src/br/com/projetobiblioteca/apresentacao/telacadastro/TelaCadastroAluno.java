package br.com.projetobiblioteca.apresentacao.telacadastro;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.projetobiblioteca.model.Aluno;
import br.com.projetobiblioteca.model.Campus;
import br.com.projetobiblioteca.model.Funcionário;
import br.com.projetobiblioteca.persistencia.AlunoDAO;
import br.com.projetobiblioteca.persistencia.CampusDAO;
import br.com.projetobiblioteca.utils.Colors;

public class TelaCadastroAluno {
    static Scanner sc = new Scanner(System.in);

    public TelaCadastroAluno()  {
    }

    public static void cadastrarAluno(Funcionário funcionario) throws SQLException {
        System.out.println(Colors.ANSI_BLUE + "-----CADASTRO ALUNO-----" + Colors.ANSI_RESET);
        System.out.print("Insira o nome do aluno: ");
        String nome = sc.nextLine();
        System.out.print("Insira o email do aluno: ");
        String email = sc.nextLine();
        System.out.print("Insira a senha do aluno: ");
        String senha = sc.nextLine();
        System.out.print("Insira a matricula do aluno: ");
        String matricula = sc.nextLine();
        System.out.print("Insira o curso do aluno: ");
        String curso = sc.nextLine();
    
        // Fazer verificação dos campus existentes
        System.out.print("Insira o campus do aluno: ");
        String campusName = sc.nextLine().toUpperCase();
        Campus campus = buscarCampusPorNome(campusName);
        if (campus == null) {
            System.out.println(Colors.ANSI_RED + "Campus não encontrado!" + Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
            return;
        }
    
        // Fazer verificação dos alunos existentes
        AlunoDAO alunoDAO = new AlunoDAO();
        boolean alunoExistente = false;
    
        for (Aluno a : alunoDAO.buscarTodos()) {
            if (a.getMatricula().equals(matricula)) {
                System.out.println(Colors.ANSI_RED + "Aluno já cadastrado!" + Colors.ANSI_RESET );
                System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
                alunoExistente = true;
                break;
            }
        }
    
        if (!alunoExistente) {
            Aluno aluno = new Aluno(0, nome, email, senha, matricula, curso, campus);
            aluno = alunoDAO.adicionar(aluno);
            System.out.println(Colors.ANSI_GREEN + "Aluno cadastrado com sucesso" + Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
        }
    
    }
    
    private static Campus buscarCampusPorNome(String nome) throws SQLException {
        CampusDAO campusDAO = new CampusDAO();
    
        for (Campus c : campusDAO.buscarTodos()) {
            if (c.getNome().equals(nome)) {
                return c;
            }
        }
    
        return null;
    }
    
}
