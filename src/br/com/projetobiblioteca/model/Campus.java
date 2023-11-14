package br.com.projetobiblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class Campus {
    private long id_campus;
    private String nome;
    private String endereco;
    private String telefone;

    //Associação 1:1 entre Campus e Biblioteca
    private Biblioteca biblioteca;
    //Associação 1:N entre Campus e Aluno
    private List<Aluno> listAlunos;

    public Campus(){
        super();
        this.id_campus = 0;
        this.nome = "";
        this.endereco = "";
        this.telefone = "";
        this.biblioteca = new Biblioteca();
        this.listAlunos = new ArrayList<Aluno>();
    }

    public Campus(long id_campus, String nome, String endereco, String telefone) {
        this.id_campus = id_campus;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public List<Aluno> getListAlunos() {
        return listAlunos;
    }

    public void setListAlunos(List<Aluno> listAlunos) {
        this.listAlunos = listAlunos;
    }

    @Override
    public String toString() {
        return "Campus [nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + ", biblioteca="
                + biblioteca + ", listAlunos=" + listAlunos + "]";
    }

    public long getId_campus() {
        return id_campus;
    }

    public void setId_campus(long id_campus) {
        this.id_campus = id_campus;
    }
}
