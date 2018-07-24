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
public class ProdutoMODEL {

    public void insertProdutoMODEL(Produto produto) {
        if (produto != null) {
            try {
                ProdutoJpaDAO.getInstance().cadastrar(produto);

            } catch (Exception e) {
                System.out.println("Erro na operação" + e.getMessage());

            }
        }
    }

    public void updateProdutoMODEL(Produto produto) {
        if (produto != null) {

            try {
                ProdutoJpaDAO.getInstance().atualizar(produto);

            } catch (Exception e) {
                System.out.println("Erro na operação" + e.getMessage());

            }
        }
    }

    public void deleteProdutoMODEl(Produto produto) {
        if (produto != null) {

            try {
                ProdutoJpaDAO.getInstance().deletar(produto);

            } catch (Exception e) {
                System.out.println("Erro na operação" + e.getMessage());

            }

        }
    }

    public List<Produto> findbyDescricaoMODEL(String descricao) {
        try {
            return ProdutoJpaDAO.getInstance().mostrarPorDescricao(descricao);
        } catch (Exception e) {
            System.out.println("Erro na operação" + e.getMessage());

        }
        return null;
    }

    public List<Produto> findAllMODEL() {
        try {
            return ProdutoJpaDAO.getInstance().mostrarTodos();

        } catch (Exception e) {
            System.out.println("Erro na operação" + e.getMessage());

        }
        return null;
    }

    public Produto mostrarPorIdMODEL(int id) {
        try {
            return ProdutoJpaDAO.getInstance().mostrarPorID(id);

        } catch (Exception e) {
            System.out.println("Erro na operação" + e.getMessage());

        }
        return null;
    }
}
