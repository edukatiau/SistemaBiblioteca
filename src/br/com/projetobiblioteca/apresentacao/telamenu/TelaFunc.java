package br.com.projetobiblioteca.apresentacao.telamenu;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.projetobiblioteca.apresentacao.SistemaBiblioteca;
import br.com.projetobiblioteca.apresentacao.telacadastro.TelaCadastroObra;
import br.com.projetobiblioteca.model.Funcionário;

public class TelaFunc {

    public static void TelaFunc(Funcionário funcionario) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----MENU FUNC-----");
        System.out.println("1 - Cadastrar Obra");
        System.out.println("2 - Editar Obra");
        System.out.println("3 - Listar Obras");
        System.out.println("4 - Remover Obra");
        System.out.println("5 - Cadastrar Aluno");
        System.out.println("6 - Editar Aluno");
        System.out.println("7 - Listar Alunos");
        System.out.println("8 - Remover Aluno");
        
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
        int escolha = sc.nextInt();
        System.out.println("-------------------");

        switch (escolha) {
            case 1:
                TelaCadastroObra.TelaCadastroObra(funcionario);
                TelaFunc(funcionario);
                break;
            case 2:
                //TelaEditarObra.TelaEditarObra(funcionario);
                TelaFunc(funcionario);
                break;
            case 3:
                TelaListarObras.TelaListarObras(funcionario);
                TelaFunc(funcionario);
                break;
            case 4:
                TelaRemoverObra.TelaRemoverObra(funcionario);
                TelaFunc(funcionario);
                break;
            case 5:
                //TelaCadastroAluno.TelaCadastroAluno(funcionario);
                TelaFunc(funcionario);
                break;
            case 6:
                //TelaEditarAluno.TelaEditarAluno(funcionario);
                TelaFunc(funcionario);
                break;
            case 7:
                //TelaListarAlunos.TelaListarAlunos(funcionario);
                TelaFunc(funcionario);
                break;
            case 8:
                //TelaRemoverAluno.TelaRemoverAluno(funcionario);
                TelaFunc(funcionario);
                break;
            case 0:
                System.out.println("Saindo...");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        
        
    }
}
