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
public class CategoriaMODEL {

    public void insertCategoriaMODEL(Categoria categoria) {
        if (categoria != null) {
            try {
                CategoriaJpaDAO.getInstance().cadastrar(categoria);

            } catch (Exception e) {
                System.out.println("Erro na operação" + e.getMessage());
            }
        } 
    }

    public void updateCategoriaMODEL(Categoria categoria) {
        if (categoria != null) {

            try {
                CategoriaJpaDAO.getInstance().atualizar(categoria);

            } catch (Exception e) {
                System.out.println("Erro na operação" + e.getMessage());
            }
        }
    }

    public void deleteCategoriaMODEl(Categoria categoria) {
        if (categoria != null) {

            try {
                CategoriaJpaDAO.getInstance().deletar(categoria);

            } catch (Exception e) {
                System.out.println("Erro na operação" + e.getMessage());

            }
        } 
    }

    public List<Categoria> findbyDescricaoMODEL(String descricao) {
        try {
            return CategoriaJpaDAO.getInstance().mostrarPorDescricao(descricao);
        } catch (Exception e) {
            System.out.println("Erro na operação" + e.getMessage());
        }
        return null;
    }

    public List<Categoria> findAllMODEL() {
        try {
            return CategoriaJpaDAO.getInstance().mostrarTodos();

        } catch (Exception e) {
            System.out.println("Erro na operação" + e.getMessage());
        }
        return null;
    }

    public Categoria mostrarPorIdMODEL(int id) {
        try {
            return CategoriaJpaDAO.getInstance().mostrarPorID(id);

        } catch (Exception e) {
            System.out.println("Erro na operação" + e.getMessage());
        }
        return null;
    }
}
