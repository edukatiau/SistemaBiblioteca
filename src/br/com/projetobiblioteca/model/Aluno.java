package br.com.projetobiblioteca.model;

import java.util.List;

public class Aluno extends Usuario{
    private String matricula;
    private String curso;

    //Associação 1:N entre Aluno e Emprestimo
    private List<Emprestimo> listEmprestimos;
    //Associação 1:N entre Aluno e Campus
    private Campus campus;

    public Aluno(){
        super();
    }
}
