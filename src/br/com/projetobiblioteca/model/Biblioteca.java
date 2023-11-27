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
        id_biblioteca = 0;
        nome = "";
    }

    public Biblioteca(long id_biblioteca, String nome) {
        this.id_biblioteca = id_biblioteca;
        this.nome = nome;
    }

    public long getId_biblioteca() {
        return id_biblioteca;
    }

    public void setId_biblioteca(long id_biblioteca) {
        this.id_biblioteca = id_biblioteca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Obra> getListObras() {
        return listObras;
    }

    public void setListObras(List<Obra> listObras) {
        this.listObras = listObras;
    }

    public List<Funcionário> getListFuncionarios() {
        return listFuncionarios;
    }

    public void setListFuncionarios(List<Funcionário> listFuncionarios) {
        this.listFuncionarios = listFuncionarios;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    /*
    @Override
    public String toString() {
        return "Biblioteca [id_biblioteca=" + id_biblioteca + ", nome=" + nome + ", listObras=" + listObras
                + ", listFuncionarios=" + listFuncionarios + ", campus=" + campus + "]";
    }*/

    @Override
    public String toString(){
        return "Biblioteca [Id= " + id_biblioteca +", Nome=" + nome + ", Campus=" + campus.getNome() + "]";
    }
}