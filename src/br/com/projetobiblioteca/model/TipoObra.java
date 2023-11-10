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

    public TipoObra(String tipoObra) {
        super();
        TipoObra.TIPO_OBRA = tipoObra;
    }

    public String getLivro() {
        return LIVRO;
    }
    public String getArtigo() {
        return ARTIGO;
    }
    public String getRevista() {
        return REVISTA;
    }
    public String getOutros() {
        return OUTROS;
    }

    
}
