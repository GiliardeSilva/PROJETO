/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.Fornecedor;
import MODEL.FornecedorMODEL;
import java.util.List;

/**
 *
 * @author Giliarde
 */
public class FornecedorCONTROLLER {

    private Fornecedor fornecedor;
    private FornecedorMODEL fornecedorModel;

    public FornecedorCONTROLLER() {
        this.fornecedor = new Fornecedor();
        this.fornecedorModel = new FornecedorMODEL();
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public void cadastrarFornecedor() {

        this.fornecedorModel.insertFornecedorMODEL(fornecedor);

    }

    public void atualizarFornecedor() {

        this.fornecedorModel.updateFornecedorMODEL(fornecedor);

    }

    public void deletarFornecedor() {

        this.fornecedorModel.deleteFornecedorMODEl(fornecedor);

    }

    public List<Fornecedor> mostrarPorCnpj(String descricao) {

        return this.fornecedorModel.findbyCnpjMODEL(descricao);

    }

    public List<Fornecedor> mostrarTodos() {

        return this.fornecedorModel.findAllMODEL();

    }

    public Fornecedor mostrarPorId(int id) {

        return this.fornecedorModel.mostrarPorIdMODEL(id);

    }

}
