package br.com.projetobiblioteca.model;

import java.util.List;

public class TipoObra {
    
    public static String TIPO_OBRA;

    public final String LIVRO = "livro";
    public final String ARTIGO = "artigo";
    public final String REVISTA = "revista";
    public final String OUTROS = "outros";

    private List<Obra> listObras;

    public TipoObra() {
        super();
    }

    public TipoObra(List<Obra> listObras) {
        this.listObras = listObras;
    }

    public static String getTIPO_OBRA() {
        return TIPO_OBRA;
    }

    public static void setTIPO_OBRA(String tIPO_OBRA) {
        TIPO_OBRA = tIPO_OBRA;
    }

    public String getLIVRO() {
        return LIVRO;
    }

    public String getARTIGO() {
        return ARTIGO;
    }

    public String getREVISTA() {
        return REVISTA;
    }

    public String getOUTROS() {
        return OUTROS;
    }

    public List<Obra> getListObras() {
        return listObras;
    }

    public void setListObras(List<Obra> listObras) {
        this.listObras = listObras;
    }
}
