package br.com.projetobiblioteca.persistencia;

import java.util.List;


public interface GenericoDAO {
    void adicionar();
    void editar(Object entidade);
    void excluir(Object entidade);
    Object buscarPorId(long id);
    List<Object> buscarTodos();
}
