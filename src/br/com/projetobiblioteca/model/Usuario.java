package br.com.projetobiblioteca.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Usuario {
    private long idUsuario;
    private String nome;
    private String email;
    private String senha;

    public Usuario() {
        super();
    }

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario [idUsuario=" + idUsuario + ", nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
    }
    
}
