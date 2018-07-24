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
public class FornecedorMODEL {

    public void insertFornecedorMODEL(Fornecedor fornecedor) {
        if (fornecedor != null) {

            try {
                FornecedorJpaDAO.getInstance().cadastrar(fornecedor);

            } catch (Exception e) {
                System.out.println("Erro na operação" + e.getMessage());

            }
        }
    }

    public void updateFornecedorMODEL(Fornecedor fornecedor) {
        if (fornecedor != null) {
            try {
                FornecedorJpaDAO.getInstance().atualizar(fornecedor);

            } catch (Exception e) {
                System.out.println("Erro na operação" + e.getMessage());

            }
        }
    }

    public void deleteFornecedorMODEl(Fornecedor fornecedor) {
        if (fornecedor != null) {
            try {
                FornecedorJpaDAO.getInstance().deletar(fornecedor);

            } catch (Exception e) {
                System.out.println("Erro na operação" + e.getMessage());

            }
        }
    }

    public List<Fornecedor> findbyCnpjMODEL(String cnpj) {
        try {
            return FornecedorJpaDAO.getInstance().mostrarPorCnpj(cnpj);
        } catch (Exception e) {
            System.out.println("Erro na operação" + e.getMessage());

        }
        return null;
    }

    public List<Fornecedor> findAllMODEL() {
        try {
            return FornecedorJpaDAO.getInstance().mostrarTodos();

        } catch (Exception e) {
            System.out.println("Erro na operação" + e.getMessage());

        }
        return null;
    }

    public Fornecedor mostrarPorIdMODEL(int id) {
        try {
            return FornecedorJpaDAO.getInstance().mostrarPorID(id);

        } catch (Exception e) {
            System.out.println("Erro na operação" + e.getMessage());

        }
        return null;
    }
}
