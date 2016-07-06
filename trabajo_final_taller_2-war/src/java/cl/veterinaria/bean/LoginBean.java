/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.veterinaria.bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Sistemas
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private String usuarios;
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }

    public String getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(String usuarios) {
        this.usuarios = usuarios;
    }
    
}
