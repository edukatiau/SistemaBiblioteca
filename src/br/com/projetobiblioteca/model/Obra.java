package br.com.projetobiblioteca.model;

import java.util.List;

public class Obra {
    private long idObra;
    private String titulo;
    private String autor;
    private String edicao;
    private String anoLancamento;
    private boolean obraEmprestada;

    //Associação 1:N entre Obras e Genero
    private Genero genero;
    //Associação 1:N entre Obras e Biblioteca
    private Biblioteca biblioteca;
    //Associação 1:N entre Obras e Emprestimo
    private List<Emprestimo> listEmprestimos;

    public Obra(){
        super();
    }
    
    public Obra(long idLivro, String titulo, String autor, String edicao, String anoLancamento, Genero Genero, Biblioteca biblioteca) {
        this.idObra = idLivro;
        this.titulo = titulo;
        this.autor = autor;
        this.edicao = edicao;
        this.anoLancamento = anoLancamento;
        this.genero = Genero;
        this.biblioteca = biblioteca;
        this.obraEmprestada = false;
    }

    public long getIdObra() {
        return idObra;
    }

    public void setIdObra(long idObra) {
        this.idObra = idObra;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public boolean getObraEmprestada(){
        return obraEmprestada;
    }

    public void setObraEmprestada(boolean value){
        this.obraEmprestada = value;
    }
    
    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public List<Emprestimo> getListEmprestimos() {
        return listEmprestimos;
    }

    public void setListEmprestimos(List<Emprestimo> listEmprestimos) {
        this.listEmprestimos = listEmprestimos;
    }

    @Override
    public String toString() {
        return "Obra [idLivro=" + idObra + ", Título=" + titulo + ", Autor=" + autor + ", Edição=" + edicao
                + ", Ano de Lançamento=" + anoLancamento + ", Gênero=" + genero.getGenero() + ", Biblioteca=" + biblioteca.getNome()
                + "]";
    }
}
