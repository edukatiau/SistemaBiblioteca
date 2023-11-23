package br.com.projetobiblioteca.model;

public class Funcionário extends Usuario{

    //Associação 1:1 entre Funcionário e Biblioteca
    private Biblioteca biblioteca;

    public Funcionário(){
        super();
    }

    public Funcionário(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public Funcionário(long idUsuario, String nome, String email, String senha, Biblioteca biblioteca) {
        super(idUsuario, nome, email, senha);
        this.biblioteca = biblioteca;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public String toString() {
        return "Funcionário [biblioteca=" + biblioteca + "]";
    }
}
