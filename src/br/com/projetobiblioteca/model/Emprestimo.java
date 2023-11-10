package br.com.projetobiblioteca.model;

import java.sql.Date;

public class Emprestimo {
    private long idEmprestimo;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private Date dataDevolucaoEfetiva;
    private String status;

    //Associação 1:N entre Emprestimo e Aluno
    private Aluno aluno;
    //Associação 1:N entre Emprestimo e Obra
    private Obra obras;

    public Emprestimo(){
        super();
    }


    
}
