/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.Categoria;
import MODEL.CategoriaMODEL;
import java.util.List;

/**
 *
 * @author Giliarde
 */
public class CategoriaCONTROLLER {

    private Categoria categoria;
    private CategoriaMODEL categoriaModel;

    public CategoriaCONTROLLER() {
        this.categoria = new Categoria();
        this.categoriaModel = new CategoriaMODEL();
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void cadastrarCategoria() {

        this.categoriaModel.insertCategoriaMODEL(categoria);

    }

    public void atualizarCategoria() {

        this.categoriaModel.updateCategoriaMODEL(categoria);

    }

    public void deletarCategoria() {

        this.categoriaModel.deleteCategoriaMODEl(categoria);

    }

    public List<Categoria> mostrarPorDescricao(String descricao) {

        return this.categoriaModel.findbyDescricaoMODEL(descricao);

    }

    public List<Categoria> mostrarTodos() {

        return this.categoriaModel.findAllMODEL();

    }

    public Categoria mostrarPorId(int id) {

        return this.categoriaModel.mostrarPorIdMODEL(id);

    }
}
