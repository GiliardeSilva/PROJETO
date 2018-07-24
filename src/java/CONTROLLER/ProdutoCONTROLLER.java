/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.Produto;
import MODEL.ProdutoMODEL;
import java.util.List;

/**
 *
 * @author Giliarde
 */
public class ProdutoCONTROLLER {

    private Produto produto;
    private ProdutoMODEL produtoModel;

    public ProdutoCONTROLLER() {
        this.produto = new Produto();
        this.produtoModel = new ProdutoMODEL();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void cadastrarProduto() {

        this.produtoModel.insertProdutoMODEL(produto);

    }

    public void atualizarProduto() {

        this.produtoModel.updateProdutoMODEL(produto);

    }

    public void deletarProduto() {

        this.produtoModel.deleteProdutoMODEl(produto);

    }

    public List<Produto> mostrarPorDescricao(String descricao) {

        return this.produtoModel.findbyDescricaoMODEL(descricao);

    }

    public List<Produto> mostrarTodos() {

        return this.produtoModel.findAllMODEL();

    }

    public Produto mostrarPorId(int id) {

        return this.produtoModel.mostrarPorIdMODEL(id);

    }
}
