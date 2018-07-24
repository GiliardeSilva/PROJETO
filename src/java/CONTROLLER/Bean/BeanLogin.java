package CONTROLLER.Bean;


import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 20171D13GR0217
 */
@ManagedBean
@RequestScoped
public class BeanLogin {
    
    private String usuario;
    private String senha;

    public BeanLogin(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public BeanLogin() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void logar(){
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(this.usuario.equals("admin") && this.senha.equals("admin")){
            context.getExternalContext().getSessionMap().put("user",usuario);
            context.getExternalContext().getSessionMap().put("perfil",senha);
            try{
                context.getExternalContext().redirect("PaginaInicial.xhtml");
                
            }catch(IOException e){
                e.printStackTrace();
            }
        }else{
            context.addMessage(null, new FacesMessage("A autenticação falhou"));
        }
        
    }
    
    public void deslogar(){
         FacesContext context = FacesContext.getCurrentInstance();
         context.getExternalContext().invalidateSession();
         try{
         context.getExternalContext().redirect("logar.xhtml");
         }catch(IOException e){
             e.printStackTrace();
         }
        
    }
    
}
