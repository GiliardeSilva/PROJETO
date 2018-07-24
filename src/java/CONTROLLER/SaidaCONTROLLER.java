/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.Saida;
import MODEL.SaidaMODEL;
import java.util.List;

/**
 *
 * @author Giliarde
 */
public class SaidaCONTROLLER {

    private Saida saida;
    private SaidaMODEL saidaModel;

    public SaidaCONTROLLER() {
        this.saida = new Saida();
        this.saidaModel = new SaidaMODEL();
    }

    public Saida getSaida() {
        return saida;
    }

    public void setSaida(Saida saida) {
        this.saida = saida;
    }

    public void cadastrarSaida() {

        this.saidaModel.insertSaidaMODEL(saida);

    }

    public void atualizarSaida() {

        this.saidaModel.updateSaidaMODEL(saida);

    }

    public void deletarSaida() {

        this.saidaModel.deleteSaidaMODEl(saida);

    }

    public List<Saida> mostrarTodos() {

        return this.saidaModel.findAllMODEL();

    }

    public Saida mostrarPorId(int id) {

        return this.saidaModel.mostrarPorIdMODEL(id);
    }

}
