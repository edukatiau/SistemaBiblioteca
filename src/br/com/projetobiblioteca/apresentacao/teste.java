package br.com.projetobiblioteca.apresentacao;

import java.sql.SQLException;
import java.util.List;

import br.com.projetobiblioteca.model.Aluno;
import br.com.projetobiblioteca.model.Campus;
import br.com.projetobiblioteca.model.Usuario;
import br.com.projetobiblioteca.persistencia.AlunoDAO;

public class teste {
    public static void main(String[] args) throws SQLException {
        Campus campus = new Campus("sapucaia", "sapucaia do sul", "519999999", null, null);
        AlunoDAO alunoDAO = new AlunoDAO();
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
        //AlunoDAO uDAO = new AlunoDAO();
        //Aluno u = uDAO.buscarPorId(8);
        //System.out.println(u.toString());

        // TESTE DO BUSCAR TODOS
		//AlunoDAO uDAO = new AlunoDAO();
		//List<Aluno> listaAlunos = uDAO.buscarTodos();		
		//for(Aluno u:listaAlunos) {
		//	System.out.println(u.toString());
		//}
    }
}
