package br.com.projetobiblioteca.apresentacao;

import java.sql.Date;
import java.sql.SQLException;
//import java.util.List;
import java.util.Scanner;

import br.com.projetobiblioteca.model.Aluno;
import br.com.projetobiblioteca.model.Biblioteca;
import br.com.projetobiblioteca.model.Campus;
import br.com.projetobiblioteca.model.Funcionário;
import br.com.projetobiblioteca.model.Obra;
import br.com.projetobiblioteca.model.TipoObra;
import br.com.projetobiblioteca.persistencia.AlunoDAO;
import br.com.projetobiblioteca.persistencia.BibliotecaDAO;
import br.com.projetobiblioteca.persistencia.CampusDAO;
import br.com.projetobiblioteca.persistencia.FuncionarioDAO;
import br.com.projetobiblioteca.persistencia.ObraDAO;
import br.com.projetobiblioteca.persistencia.TipoObraDAO;

public class Teste {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {

        // cadastrarAluno();
        // cadastrarCampus();
        // CampusDAO campusDAO = new CampusDAO();
        // cadastrarBiblioteca(campusDAO.buscarPorId(1));
        // BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
        // cadastrarFuncionario(bibliotecaDAO.buscarPorId(1));

        //cadastarTipoObra();
        //BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
        //cadastrarObra(bibliotecaDAO.buscarPorId(1));
        
        // ObraDAO obraDAO = new ObraDAO();
        // List<Obra> listaObras = obraDAO.buscarTodos();
        // for(Obra u:listaObras) {
        // System.out.println(u.toString());
        // }

        // Campus campus = new Campus("sapucaia", "sapucaia do sul", "519999999", null,
        // null);
        // AlunoDAO alunoDAO = new AlunoDAO();
        // cadastrar aluno
        // Aluno edu = new Aluno(0, "eduardo", "eduard2o@gmail.com", "123",
        // "15123456789", "ads", campus);
        // alunoDAO.adicionar(edu);

        // editar aluno
        // Aluno edu = new Aluno(5, "eduardo", "edu@gmail.com", "345", "123456789",
        // "ads", campus);
        // alunoDAO.editar(edu);

        // excluir aluno
        // Aluno edu = new Aluno(0, "edu", "edu@gmail.com", "123", "123456789", "ads",
        // campus);
        // alunoDAO.excluir(8);

        // TESTE DO BUSCAR POR ID
        // AlunoDAO uDAO = new AlunoDAO();
        // Aluno u = new Aluno();
        // uDAO.buscarPorId(u.getIdUsuario());
        // System.out.println(u.toString());

        // TESTE DO BUSCAR TODOS
        // AlunoDAO uDAO = new AlunoDAO();
        // List<Aluno> listaAlunos = uDAO.buscarTodos();
        // for(Aluno u:listaAlunos) {
        // System.out.println(u.toString());
        // }
        
    }

    public static void cadastrarAluno() throws SQLException {
        System.out.println("Insira o nome do aluno:");
        String nome = sc.next();
        System.out.println("Insira o email do aluno:");
        String email = sc.next();
        System.out.println("Insira a senha do aluno:");
        String senha = sc.next();
        System.out.println("Insira a matricula do aluno:");
        String matricula = sc.next();
        System.out.println("Insira o curso do aluno:");
        String curso = sc.nextLine();

        // fazer verificação dos campus existentes
        System.out.println("Insira o campus do aluno:");
        String campusName = sc.next();
        Campus campus = new Campus();
        campus.setId_campus(0);

        Aluno aluno = new Aluno(0, nome, email, senha, matricula, curso, campus);
        AlunoDAO alunoDAO = new AlunoDAO();
        aluno = alunoDAO.adicionar(aluno);
        System.out.println("Aluno cadastrado com sucesso");
        sc.close();

    }

    public static void cadastrarCampus() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira o nome do campus:");
        String nome = sc.nextLine();
        System.out.println("Insira o endereço do campus:");
        String endereco = sc.nextLine();
        System.out.println("Insira o telefone do campus:");
        String telefone = sc.nextLine();

        Campus campus = new Campus(0, nome, endereco, telefone);
        CampusDAO campusDAO = new CampusDAO();
        campus = campusDAO.adicionar(campus);
        System.out.println("Campus cadastrado com sucesso");
        sc.close();
    }

    public static void cadastrarBiblioteca(Campus campus) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira o nome da biblioteca:");
        String nome = sc.nextLine();

        Biblioteca biblioteca = new Biblioteca(0, nome, campus);
        BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
        biblioteca = bibliotecaDAO.adicionar(biblioteca);

        CampusDAO campusDAO = new CampusDAO();
        campusDAO.atualizar(campus, biblioteca);

        System.out.println("Biblioteca cadastrada com sucesso");
        sc.close();
    }

    public static void cadastrarFuncionario(Biblioteca biblioteca) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira o nome do funcionario:");
        String nome = sc.nextLine();
        System.out.println("Insira o email do funcionario:");
        String email = sc.nextLine();
        System.out.println("Insira a senha do funcionario:");
        String senha = sc.nextLine();
        System.out.println("Insira o salario do funcionario:");
        double salario = sc.nextDouble();

        Funcionário funcionario = new Funcionário(0, nome, email, senha, salario, biblioteca);
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionario = funcionarioDAO.adicionar(funcionario);

        System.out.println("Funcionario cadastrado com sucesso");
        sc.close();
    }

    public static void cadastarTipoObra() throws SQLException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira o tipo da obra:");
        String tipo = sc.nextLine();

        TipoObra tipoObra = new TipoObra(0, tipo);
        TipoObraDAO tipoObraDAO = new TipoObraDAO();
        tipoObra = tipoObraDAO.adicionar(tipoObra);
        System.out.println("Tipo de obra cadastrado com sucesso");
        sc.close();
    }

    public static void cadastrarObra(Biblioteca biblioteca) throws SQLException {
    Scanner sc = new Scanner(System.in);
    System.out.println("Insira o titulo da obra:");
    String titulo = sc.nextLine();
    System.out.println("Insira o autor da obra:");
    String autor = sc.nextLine();
    System.out.println("Insira a edição da obra:");
    String edicao = sc.nextLine();

    System.out.println("Insira a data de lançamento da obra:");
    String dataLancamento = sc.nextLine();

    String[] dataLancamentoArray = dataLancamento.split("/");
    int dia = Integer.parseInt(dataLancamentoArray[0]);
    int mes = Integer.parseInt(dataLancamentoArray[1]);
    int ano = Integer.parseInt(dataLancamentoArray[2]);
    Date data = new Date(ano, mes, dia);

    System.out.println("Insira o tipo da obra:");
    String tipo = sc.nextLine();

    TipoObraDAO tipoObraDAO = new TipoObraDAO();
    TipoObra tipoObra = tipoObraDAO.buscarPorNome(tipo);

    Obra obra = new Obra(0, titulo, autor, edicao, data, tipoObra, biblioteca);
    ObraDAO obraDAO = new ObraDAO();
    obra = obraDAO.adicionar(obra);
    System.out.println("Obra cadastrada com sucesso");
    sc.close();
    }
}