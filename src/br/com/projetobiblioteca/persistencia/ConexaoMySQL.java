package br.com.projetobiblioteca.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {

    private String ip;
    private String porta;
    private String login;
    private String senha;
    private String banco;

    private Connection conexao;

    public ConexaoMySQL(String ip, String porta, String login, String senha, String banco) {
        this.ip = ip;
        this.porta = porta;
        this.login = login;
        this.senha = senha;
        this.banco = banco;
    }

    // Método para obter a conexão
    public void abrirConexao(){ 
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String URL = "jdbc:mysql://" + ip + ":" + porta + "/" + banco;
            this.conexao = DriverManager.getConnection(URL, login, senha);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para fechar a conexão
    public void fecharConexao(){
        try {
            if(this.conexao != null || !this.conexao.isClosed()){
                this.conexao.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
