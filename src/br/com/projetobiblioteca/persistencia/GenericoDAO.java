package br.com.projetobiblioteca.persistencia;

import java.util.List;

public interface GenericoDAO {
    Object adicionar(Object entidade);
    void editar(Object entidade);
    void excluir(Object entidade);
    Object buscarPorId(long id);
    List<Object> buscarTodos();
}
