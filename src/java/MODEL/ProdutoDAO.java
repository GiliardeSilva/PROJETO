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
public interface ProdutoDAO extends DAO<Produto>{
    public List<Produto> mostrarPorDescricao(String descricao);
    
}
