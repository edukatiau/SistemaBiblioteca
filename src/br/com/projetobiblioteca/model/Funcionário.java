package br.com.projetobiblioteca.model;

public class Funcionário extends Usuario{
    private double salario;

    //Associação 1:1 entre Funcionário e Biblioteca
    private Biblioteca biblioteca;

    public Funcionário(){
        super();
    }

    public Funcionário(double salario, Biblioteca biblioteca) {
        this.salario = salario;
        this.biblioteca = biblioteca;
    }

    public Funcionário(String nome, String email, String senha, double salario, Biblioteca biblioteca) {
        super(nome, email, senha);
        this.salario = salario;
        this.biblioteca = biblioteca;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    
}
