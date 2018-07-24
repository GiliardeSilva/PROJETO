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
 * @author 20171D13GR0217
 */
@ManagedBean
@RequestScoped
public class BeanBuscarEstoque {

    /**
     * Creates a new instance of BeanBuscarEstoque
     */
    public BeanBuscarEstoque() {
    }
     public void linkar() throws IOException{
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().redirect("BuscarEstoque.xhtml");
        
        
    }
    
}
