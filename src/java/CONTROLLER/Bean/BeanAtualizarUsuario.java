package CONTROLLER.Bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Leonardo Izidoro
 */
@ManagedBean
@RequestScoped
public class BeanAtualizarUsuario {

    /**
     * Creates a new instance of BeanAtualizarUsuario
     */
    public BeanAtualizarUsuario() {
    }
    public void linkar() throws IOException{
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().redirect("AtualizarUsuario.xhtml");
    }
    
}
