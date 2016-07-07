/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.veterinaria.bean;

import cl.veterinaria.entity.Ficha;
import cl.veterinaria.entity.Mascota;
import cl.veterinaria.service.FichaFacadeLocal;
import cl.veterinaria.service.MascotaFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author ignacio
 */
@Named(value = "fichaBean")
@ViewScoped
public class FichaBean implements Serializable{

	@EJB
	private FichaFacadeLocal fichaFacade;

	@EJB
	private MascotaFacadeLocal mascotaFacade;

	private Mascota mascota;

	private List<Ficha> listaFichas;

	/**
	 * Creates a new instance of FichaBean
	 */
	public FichaBean() {
	}

	public String verDetalle(int detalleId){
		return "detalle.xhtml?faces-redirect=true&detalle="+detalleId;
	}

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	public List<Ficha> getListaFichas() {
		return listaFichas;
	}

	public void setListaFichas(List<Ficha> listaFichas) {
		this.listaFichas = listaFichas;
	}
	
}
