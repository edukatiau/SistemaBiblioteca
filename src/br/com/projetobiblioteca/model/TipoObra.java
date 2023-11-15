package br.com.projetobiblioteca.model;

import java.util.List;

public class TipoObra {
    private long id_tipoobra;
    public String TIPO_OBRA;

    public final String LIVRO = "livro";
    public final String ARTIGO = "artigo";
    public final String REVISTA = "revista";
    public final String OUTROS = "outros";

    private List<Obra> listObras;

    public TipoObra() {
        super();
    }

    public TipoObra(long id_tipoobra, String TIPO_OBRA) {
        this.id_tipoobra = id_tipoobra;
        switch (TIPO_OBRA) {
            case LIVRO:
                this.TIPO_OBRA = LIVRO;
                break;
            case ARTIGO:
                this.TIPO_OBRA = ARTIGO;
                break;
            case REVISTA:
                this.TIPO_OBRA = REVISTA;
                break;
            case OUTROS:
                this.TIPO_OBRA = OUTROS;
                break;
            default:
                break;
        }
    }

    public long getId_tipoobra() {
        return id_tipoobra;
    }

    public void setId_tipoobra(long id_tipoobra) {
        this.id_tipoobra = id_tipoobra;
    }

    public String getTIPO_OBRA() {
        return this.TIPO_OBRA;
    }

    public void setTIPO_OBRA(String tIPO_OBRA) {
        this.TIPO_OBRA = tIPO_OBRA;
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

    @Override
    public String toString() {
        return "TipoObra [ TIPO_OBRA=" + TIPO_OBRA + "]";
    }
}
