package br.com.projetobiblioteca.model;

import java.sql.Date;
import java.util.List;

public class Obra {
    private long idLivro;
    private String titulo;
    private String autor;
    private String edicao;
    private Date dataLancamento;

    //Associação 1:N entre Obras e TipoObra
    private TipoObra tipoObra;
    //Associação 1:N entre Obras e Biblioteca
    private Biblioteca biblioteca;
    //Associação 1:N entre Obras e Emprestimo
    private List<Emprestimo> listEmprestimos;

    public Obra(){
        super();
    }
}