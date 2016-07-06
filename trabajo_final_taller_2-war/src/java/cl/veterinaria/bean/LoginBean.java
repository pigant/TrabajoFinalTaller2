/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.veterinaria.bean;

import cl.veterinaria.entity.User;
import cl.veterinaria.service.UserFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author Sistemas
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	@EJB
	private UserFacadeLocal userFacade;

    private User usuario;
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }

	public String ingresoLogin(){
		return "menu";
	}

    public User getUsuarios() {
        return usuario;
    }

    public void setUsuarios(User user) {
        this.usuario = user;
    }
    
}
