package br.com.projetobiblioteca.model;

import java.util.List;

public class Campus {
    private String nome;
    private String endereco;
    private String telefone;

    //Associação 1:1 entre Campus e Biblioteca
    private Biblioteca biblioteca;
    //Associação 1:N entre Campus e Aluno
    private List<Aluno> listAlunos;

    public Campus(){
        super();
    }
}
