package br.com.projetobiblioteca.apresentacao;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import br.com.projetobiblioteca.model.Aluno;
import br.com.projetobiblioteca.model.Campus;
import br.com.projetobiblioteca.model.Usuario;
import br.com.projetobiblioteca.persistencia.AlunoDAO;

public class Teste {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {

        //cadastrarAluno();


        //Campus campus = new Campus("sapucaia", "sapucaia do sul", "519999999", null, null);
        //AlunoDAO alunoDAO = new AlunoDAO();
        //cadastrar aluno
        //Aluno edu = new Aluno(0, "eduardo", "eduard2o@gmail.com", "123", "15123456789", "ads", campus);
        //alunoDAO.adicionar(edu);
        
        //editar aluno
        //Aluno edu = new Aluno(5, "eduardo", "edu@gmail.com", "345", "123456789", "ads", campus);
        //alunoDAO.editar(edu);

        //excluir aluno
        //Aluno edu = new Aluno(0, "edu", "edu@gmail.com", "123", "123456789", "ads", campus);
        //alunoDAO.excluir(8);

        // TESTE DO BUSCAR POR ID
        AlunoDAO uDAO = new AlunoDAO();
        Aluno u = uDAO.buscarPorId(u.getIdUsuario());
        System.out.println(u.toString());

        // TESTE DO BUSCAR TODOS
		//AlunoDAO uDAO = new AlunoDAO();
		//List<Aluno> listaAlunos = uDAO.buscarTodos();		
		//for(Aluno u:listaAlunos) {
		//	System.out.println(u.toString());
		//}
    }

    public static void cadastrarAluno() throws SQLException{
        System.out.println("Insira o nome do aluno:");
        String nome = sc.next();
        System.out.println("Insira o email do aluno:");
        String email = sc.next();
        System.out.println("Insira a senha do aluno:");
        String senha = sc.next();
        System.out.println("Insira a matricula do aluno:");
        String matricula = sc.next();
        System.out.println("Insira o curso do aluno:");
        String curso = sc.next();
        
        //fazer verificação dos campus existentes 
        System.out.println("Insira o campus do aluno:");
        String campusName = sc.next();
        Campus campus = new Campus();
        campus.setId_campus(0);

        Aluno aluno = new Aluno(0, nome, email, senha, matricula, curso, campus);
        AlunoDAO alunoDAO = new AlunoDAO();
        aluno = alunoDAO.adicionar(aluno);
        System.out.println("Aluno cadastrado com sucesso");

    }

}
