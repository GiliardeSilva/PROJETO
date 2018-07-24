/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.Entrada;
import MODEL.EntradaMODEL;
import java.util.List;

/**
 *
 * @author Giliarde
 */
public class EntradaCONTROLLER {

    private Entrada entrada;
    private EntradaMODEL entradaModel;

    public EntradaCONTROLLER() {
        this.entrada = new Entrada();
        this.entradaModel = new EntradaMODEL();
    }

    public Entrada getEntrada() {
        return entrada;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    public void cadastrarEntrada() {
        this.entradaModel.insertEntradaMODEL(entrada);

    }

    public void atualizarEntrada() {

        this.entradaModel.updateEntradaMODEL(entrada);

    }

    public void deletarEntrada() {

        this.entradaModel.deleteEntradaMODEl(entrada);

    }

    public List<Entrada> mostrarTodos() {

        return this.entradaModel.findAllMODEL();

    }

    public Entrada mostrarPorId(int id) {

        return this.entradaModel.mostrarPorIdMODEL(id);
    }
}
