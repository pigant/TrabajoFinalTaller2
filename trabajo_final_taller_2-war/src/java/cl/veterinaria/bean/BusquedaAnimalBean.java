/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.veterinaria.bean;

import cl.veterinaria.entity.Mascota;
import cl.veterinaria.service.MascotaFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author ignacio
 */
@Named(value = "busquedaAnimalBean")
@ViewScoped
public class BusquedaAnimalBean {

	@EJB
	private MascotaFacadeLocal mascotaFacade;

	private String nombre;

	private List<Mascota> listaMascotas;

	/**
	 * Creates a new instance of BusquedaAnimalBean
	 */
	public BusquedaAnimalBean() {
	}

	public void buscarMascota(){

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Mascota> getListaMascotas() {
		return listaMascotas;
	}
	
}
