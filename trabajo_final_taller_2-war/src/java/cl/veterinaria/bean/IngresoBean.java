/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.veterinaria.bean;

import cl.veterinaria.entity.Dueno;
import cl.veterinaria.entity.Mascota;
import cl.veterinaria.service.DuenoFacadeLocal;
import cl.veterinaria.service.FichaFacadeLocal;
import cl.veterinaria.service.MascotaFacadeLocal;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author ignacio
 */
@Named(value = "ingresoBean")
@ViewScoped
public class IngresoBean {

	@EJB
	private DuenoFacadeLocal duenoFacade;

	@EJB
	private MascotaFacadeLocal mascotaFacade;

	@EJB
	private FichaFacadeLocal fichaFacade;

	private Dueno dueno;
	private Mascota mascota;
	private String diagnostico;
	private String receta;

	/**
	 * Creates a new instance of IngresoBean
	 */
	public IngresoBean() {
	}

	public void buscarMascotas() {

	}

	public void seleccionarMascota() {

	}

	public String ingresarFicha() {
		return "menu";
	}

	public Dueno getDueno() {
		return dueno;
	}

	public void setDueno(Dueno dueno) {
		this.dueno = dueno;
	}

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getReceta() {
		return receta;
	}

	public void setReceta(String receta) {
		this.receta = receta;
	}

}
