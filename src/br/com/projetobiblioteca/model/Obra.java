package br.com.projetobiblioteca.model;

import java.util.List;

public class Obra {
    private long idObra;
    private String titulo;
    private String autor;
    private String edicao;
    private String anoLancamento;

    //Associação 1:N entre Obras e TipoObra
    private TipoObra tipoObra;
    //Associação 1:N entre Obras e Biblioteca
    private Biblioteca biblioteca;
    //Associação 1:N entre Obras e Emprestimo
    private List<Emprestimo> listEmprestimos;

    public Obra(){
        super();
    }

    public Obra(long idLivro, String titulo, String autor, String edicao, String anoLancamento, TipoObra tipoObra, Biblioteca biblioteca) {
        this.idObra = idLivro;
        this.titulo = titulo;
        this.autor = autor;
        this.edicao = edicao;
        this.anoLancamento = anoLancamento;
        this.tipoObra = tipoObra;
        this.biblioteca = biblioteca;
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

    public TipoObra getTipoObra() {
        return tipoObra;
    }

    public void setTipoObra(TipoObra tipoObra) {
        this.tipoObra = tipoObra;
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
        return "Obra [idLivro=" + idObra + ", titulo=" + titulo + ", autor=" + autor + ", edicao=" + edicao
                + ", anoLancamento=" + anoLancamento + ", tipoObra=" + tipoObra.getTIPO_OBRA() + ", biblioteca=" + biblioteca.getNome()
                + "]";
    }
}