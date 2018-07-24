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
public class SaidaMODEL {

    public void insertSaidaMODEL(Saida saida) {
        if (saida != null) {
            try {
                SaidaJpaDAO.getInstance().cadastrar(saida);

            } catch (Exception e) {
                System.out.println("Erro na operação" + e.getMessage());

            }
        }
    }

    public void updateSaidaMODEL(Saida saida) {
        if (saida != null) {
            try {
                SaidaJpaDAO.getInstance().atualizar(saida);

            } catch (Exception e) {
                System.out.println("Erro na operação" + e.getMessage());

            }
        }
    }

    public void deleteSaidaMODEl(Saida saida) {
        if (saida != null) {
            try {
                SaidaJpaDAO.getInstance().deletar(saida);

            } catch (Exception e) {
                System.out.println("Erro na operação" + e.getMessage());

            }
        }
    }

    public List<Saida> findAllMODEL() {
        try {
            return SaidaJpaDAO.getInstance().mostrarTodos();

        } catch (Exception e) {
            System.out.println("Erro na operação" + e.getMessage());

        }
        return null;
    }

    public Saida mostrarPorIdMODEL(int id) {
        try {
            return SaidaJpaDAO.getInstance().mostrarPorID(id);

        } catch (Exception e) {
            System.out.println("Erro na operação" + e.getMessage());

        }
        return null;
    }
}
