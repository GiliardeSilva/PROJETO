/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.util.List;

/**
 *
 * @author Giliarde
 */
public interface DAO<T> {

    public void cadastrar(T obj);

    public void atualizar(T obj);

    public void deletar(T obj);

    public T mostrarPorID(int codigo);

    public List<T> mostrarTodos();

}
