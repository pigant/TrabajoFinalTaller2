/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.veterinaria.bean;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author ignacio
 */
@Named(value = "menuBean")
@ViewScoped
public class MenuBean implements Serializable{

	/**
	 * Creates a new instance of MenuBean
	 */
	public MenuBean() {
	}

	public String ingresarCliente(){
		return "inscripcionDueno";
	}

	public String ingresarMascota(){
		return "inscripcionMascota";
	}

	public String ingresarFicha(){
		return "ingreso";
	}
	
}
