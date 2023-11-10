package br.com.projetobiblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario{
    private String matricula;
    private String curso;

    //Associação 1:N entre Aluno e Emprestimo
    private List<Emprestimo> listEmprestimos;
    //Associação 1:N entre Aluno e Campus
    private Campus campus;

    public Aluno(){
        super();
    }

    public Aluno(String matricula, String curso, List<Emprestimo> listEmprestimos, Campus campus) {
        this.matricula = matricula;
        this.curso = curso;
        this.listEmprestimos = listEmprestimos;
        this.campus = campus;
    }

    public Aluno(String nome, String email, String senha, String matricula, String curso, Campus campus) {
        super(nome, email, senha);
        this.matricula = matricula;
        this.curso = curso;
        this.listEmprestimos = new ArrayList<Emprestimo>();
        this.campus = campus;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public List<Emprestimo> getListEmprestimos() {
        return listEmprestimos;
    }

    public void setListEmprestimos(List<Emprestimo> listEmprestimos) {
        this.listEmprestimos = listEmprestimos;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    @Override
    public String toString() {
        return "Aluno [matricula=" + matricula + ", curso=" + curso + ", listEmprestimos=" + listEmprestimos
                + ", campus=" + campus + "]";
    }    
}
