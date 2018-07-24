/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.Usuario;
import MODEL.UsuarioMODEL;
import java.util.List;

/**
 *
 * @author Giliarde
 */
public class UsuarioCONTROLLER {

    private Usuario usuario;
    private UsuarioMODEL usuarioModel;

    public UsuarioCONTROLLER() {
        this.usuario = new Usuario();
        this.usuarioModel = new UsuarioMODEL();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void cadastrarUsuario() {

        this.usuarioModel.insertUsuarioMODEL(usuario);

    }

    public void atualizarUsuario() {

        this.usuarioModel.updateUsuarioMODEL(usuario);

    }

    public void deletarUsuario() {

        this.usuarioModel.deleteUsuarioMODEl(usuario);

    }

    public List<Usuario> mostrarPorCpf(String descricao) {

        return this.usuarioModel.findbyCpfMODEL(descricao);

    }

    public List<Usuario> mostrarTodos() {

        return this.usuarioModel.findAllMODEL();

    }

    public Usuario mostrarPorId(int id) {

        return this.usuarioModel.mostrarPorIdMODEL(id);

    }
}
