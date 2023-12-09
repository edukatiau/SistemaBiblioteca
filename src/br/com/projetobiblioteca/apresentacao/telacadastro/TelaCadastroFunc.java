package br.com.projetobiblioteca.apresentacao.telacadastro;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.projetobiblioteca.apresentacao.telamenu.TelaAdm;
import br.com.projetobiblioteca.model.Biblioteca;
import br.com.projetobiblioteca.model.Funcionário;
import br.com.projetobiblioteca.persistencia.BibliotecaDAO;
import br.com.projetobiblioteca.persistencia.FuncionarioDAO;
import br.com.projetobiblioteca.utils.Colors;

public class TelaCadastroFunc {
    static Scanner sc = new Scanner(System.in);

    public TelaCadastroFunc() {
    }

    public static void cadastrarFuncionario() throws SQLException, InterruptedException{
        System.out.println(Colors.ANSI_BLUE + "-----CADASTRO FUNCIONARIO-----" + Colors.ANSI_RESET);
        System.out.print("Insira o nome do funcionario: ");
        String nome = sc.nextLine();
        System.out.print("Insira o email do funcionario: ");
        String email = sc.next();
        System.out.print("Insira a senha do funcionario: ");
        String senha = sc.next();

        // fazer verificação das bibliotecas existentes
        System.out.print("Insira o nome da biblioteca do funcionario: ");
        sc.nextLine();
        String biblioName = sc.nextLine().toUpperCase();
        Biblioteca biblioteca = new Biblioteca();
        BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
        
        for(Biblioteca b:bibliotecaDAO.buscarTodos()){
            if(b.getNome().equals(biblioName)) {
                biblioteca = b;
            }
        }
        if(biblioteca.getNome().equals("")) {
            System.out.println(Colors.ANSI_RED + "Biblioteca não encontrada!" + Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
            return;
        }

        // fazer verificação dos funcionários existentes
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        
        // Verificar se o e-mail já existe na lista de funcionários
        boolean funcionarioExistente = false;
        for (Funcionário f : funcionarioDAO.buscarTodos()) {
            if (f.getEmail().equals(email)) {
                System.out.println(Colors.ANSI_RED + "Funcionário já cadastrado!" + Colors.ANSI_RESET);
                System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
                funcionarioExistente = true;
                return;
            }
        }

        // Se o funcionário não existe, adicioná-lo
        if (!funcionarioExistente) {
            Funcionário funcionario = new Funcionário(0, nome, email, senha, biblioteca);
            funcionario = funcionarioDAO.adicionar(funcionario);
            System.out.println(Colors.ANSI_GREEN + "Funcionário cadastrado com sucesso!" + Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLUE + "-------------------" + Colors.ANSI_RESET);
        }

    TelaAdm.menuAdm();
    }
}
