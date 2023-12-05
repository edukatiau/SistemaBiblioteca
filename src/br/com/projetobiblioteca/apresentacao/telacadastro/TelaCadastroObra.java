package br.com.projetobiblioteca.apresentacao.telacadastro;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.projetobiblioteca.apresentacao.telamenu.TelaFunc;
import br.com.projetobiblioteca.model.Funcionário;
import br.com.projetobiblioteca.model.Obra;
import br.com.projetobiblioteca.model.Genero;
import br.com.projetobiblioteca.persistencia.ObraDAO;

public class TelaCadastroObra {
    static Scanner sc = new Scanner(System.in);
    
    public TelaCadastroObra() {
    }

    public static void cadastrarObra(Funcionário funcionario) throws SQLException, InterruptedException{
        System.out.println("-----CADASTRO OBRA-----");
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        //System.out.print("Editora: ");
        //String editora = sc.nextLine();
        System.out.print("Edição: ");
        String edicao = sc.nextLine();
        System.out.print("Ano: ");
        String ano = sc.next();

        System.out.print("Gênero: ");
        String genero = sc.next().toUpperCase();
        sc.nextLine();

        Genero Genero = CadastroGenero.cadastrarGenero(genero);

        Obra obra = new Obra(0, titulo, autor, edicao, ano, Genero, funcionario.getBiblioteca());

        System.out.println(obra.toString());
        System.out.println("Confirma o cadastro? (S/N)");
        String confirmacao = sc.next().toUpperCase();

        if(!confirmacao.equals("S")){
            System.out.println("Cadastro cancelado!");
            TelaFunc.menuFunc(funcionario);
        } else {
            ObraDAO obraDAO = new ObraDAO();
            obraDAO.adicionar(obra);

            System.out.println("Obra cadastrada com sucesso!");
        }

        TelaFunc.menuFunc(funcionario);
    }

    
}
