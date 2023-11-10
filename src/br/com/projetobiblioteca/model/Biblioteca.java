package br.com.projetobiblioteca.model;

import java.util.List;

public class Biblioteca {
    private long id_biblioteca;
    private String nome;

    //Associação 1:N entre Biblioteca e Obras
    private List<Obra> listObras;
    //Associação 1:N entre Biblioteca e Funcionarios
    private List<Funcionário> listFuncionarios;
    //Associação 1:1 entre Biblioteca e Campus
    private Campus campus;

    public Biblioteca(){
        super();
    }

    
}