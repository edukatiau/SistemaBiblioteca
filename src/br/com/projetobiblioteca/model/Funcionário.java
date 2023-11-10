package br.com.projetobiblioteca.model;

public class Funcionário extends Usuario{
    private double salario;

    //Associação 1:1 entre Funcionário e Biblioteca
    private Biblioteca biblioteca;
    
    public Funcionário(){
        super();
    }
}
