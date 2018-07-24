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
public class EntradaMODEL {

    public void insertEntradaMODEL(Entrada entrada) {
        if (entrada != null) {

            try {
                EntradaJpaDAO.getInstance().cadastrar(entrada);

            } catch (Exception e) {
                System.out.println("Erro na operação" + e.getMessage());

            }
        }
    }

    public void updateEntradaMODEL(Entrada entrada) {
        if (entrada != null) {
            try {
                EntradaJpaDAO.getInstance().atualizar(entrada);

            } catch (Exception e) {
                System.out.println("Erro na operação" + e.getMessage());

            }
        }
    }

    public void deleteEntradaMODEl(Entrada entrada) {
        if (entrada != null) {
            try {
                EntradaJpaDAO.getInstance().deletar(entrada);

            } catch (Exception e) {
                System.out.println("Erro na operação" + e.getMessage());

            }
        }
    }

    public List<Entrada> findAllMODEL() {
        try {
            return EntradaJpaDAO.getInstance().mostrarTodos();

        } catch (Exception e) {
            System.out.println("Erro na operação" + e.getMessage());

        }
        return null;
    }

    public Entrada mostrarPorIdMODEL(int id) {
        try {
            return EntradaJpaDAO.getInstance().mostrarPorID(id);

        } catch (Exception e) {
            System.out.println("Erro na operação" + e.getMessage());

        }
        return null;
    }
}
