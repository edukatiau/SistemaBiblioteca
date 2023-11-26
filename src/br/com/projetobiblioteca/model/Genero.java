package br.com.projetobiblioteca.model;

import java.util.List;

public class Genero {
    private long id_Genero;
    public String Genero;

    private List<Obra> listObras;

    public Genero() {
        super();
    }

    public Genero(long id_Genero, String TIPO_OBRA) {
        this.id_Genero = id_Genero;
        this.Genero = TIPO_OBRA;
    }

    public long getId_Genero() {
        return id_Genero;
    }

    public void setId_Genero(long id_Genero) {
        this.id_Genero = id_Genero;
    }

    public String getGenero() {
        return this.Genero;
    }

    public void setGenero(String tIPO_OBRA) {
        this.Genero = tIPO_OBRA;
    }

    public List<Obra> getListObras() {
        return listObras;
    }

    public void setListObras(List<Obra> listObras) {
        this.listObras = listObras;
    }

    @Override
    public String toString() {
        return "Genero [ Genero=" + Genero + "]";
    }
}
