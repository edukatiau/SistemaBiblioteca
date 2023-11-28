package br.com.projetobiblioteca.model;

import java.sql.Date;
import java.util.Calendar;

public class Emprestimo {
    private long idEmprestimo;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private Date dataDevolucaoEfetiva;
    private String status;

    //Associação 1:N entre Emprestimo e Aluno
    private Aluno aluno;
    //Associação 1:N entre Emprestimo e Obra
    private Obra obras;

    public Emprestimo(){
        super();
    }

    public Emprestimo(long idEmprestimo, Date dataEmprestimo, Date dataDevolucao,
        Aluno aluno, Obra obras) {
        this.idEmprestimo = idEmprestimo;
        this.dataEmprestimo = dataEmprestimo;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataEmprestimo);
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        this.dataDevolucao = new Date(calendar.getTimeInMillis());

        this.status = "ATIVO";
        this.aluno = aluno;
        this.obras = obras;
        this.obras.setObraEmprestada = true;
    }

    public long getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(long idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Date getDataDevolucaoEfetiva() {
        return dataDevolucaoEfetiva;
    }

    public void setDataDevolucaoEfetiva(Date dataDevolucaoEfetiva) {
        this.dataDevolucaoEfetiva = dataDevolucaoEfetiva;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Obra getObras() {
        return obras;
    }

    public void setObras(Obra obras) {
        this.obras = obras;
    }
    /*
    @Override
    public String toString() {
        return "Emprestimo [idEmprestimo=" + idEmprestimo + ", dataEmprestimo=" + dataEmprestimo + ", dataDevolucao="
                + dataDevolucao + ", dataDevolucaoEfetiva=" + dataDevolucaoEfetiva + ", status=" + status + ", aluno="
                + aluno + ", obras=" + obras + "]";
    }
    */

    @Override
    public String toString() {
        return "Emprestimo [idEmprestimo=" + idEmprestimo + ", dataEmprestimo=" + dataEmprestimo + ", dataDevolucao="
                + dataDevolucao + ", dataDevolucaoEfetiva=" + dataDevolucaoEfetiva + ", status=" + status + ", aluno="
                + aluno.getNome() + ", obras=" + obras.getTitulo() + "]";
    }
}
