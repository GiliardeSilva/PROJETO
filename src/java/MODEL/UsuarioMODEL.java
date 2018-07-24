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
public class UsuarioMODEL {

    public void insertUsuarioMODEL(Usuario usuario) {
        if (usuario != null) {

            try {
                UsuarioJpaDAO.getInstance().cadastrar(usuario);

            } catch (Exception e) {
                System.out.println("Erro na operação" + e.getMessage());

            }
        }
    }

    public void updateUsuarioMODEL(Usuario usuario) {
        if (usuario != null) {
            try {
                UsuarioJpaDAO.getInstance().atualizar(usuario);

            } catch (Exception e) {
                System.out.println("Erro na operação" + e.getMessage());

            }
        }
    }

    public void deleteUsuarioMODEl(Usuario usuario) {
        if (usuario != null) {

            try {
                UsuarioJpaDAO.getInstance().deletar(usuario);

            } catch (Exception e) {
                System.out.println("Erro na operação" + e.getMessage());

            }
        }
    }

    public List<Usuario> findbyCpfMODEL(String descricao) {
        try {
            return UsuarioJpaDAO.getInstance().mostrarPorCpf(descricao);
        } catch (Exception e) {
            System.out.println("Erro na operação" + e.getMessage());

        }
        return null;
    }

    public List<Usuario> findAllMODEL() {
        try {
            return UsuarioJpaDAO.getInstance().mostrarTodos();

        } catch (Exception e) {
            System.out.println("Erro na operação" + e.getMessage());

        }
        return null;
    }

    public Usuario mostrarPorIdMODEL(int id) {
        try {
            return UsuarioJpaDAO.getInstance().mostrarPorID(id);

        } catch (Exception e) {
            System.out.println("Erro na operação" + e.getMessage());

        }
        return null;
    }
}
