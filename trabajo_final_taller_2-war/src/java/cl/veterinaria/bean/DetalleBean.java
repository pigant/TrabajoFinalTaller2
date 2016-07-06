/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.veterinaria.bean;

import cl.veterinaria.entity.Ficha;
import cl.veterinaria.service.FichaFacadeLocal;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author ignacio
 */
@Named(value = "detalleBean")
@ViewScoped
public class DetalleBean {

	@EJB
	private FichaFacadeLocal fichaFacade;

	private Ficha ficha;
	/**
	 * Creates a new instance of DetalleBean
	 */
	public DetalleBean() {
	}

	@PostConstruct
	public void init(){
		Map<String, String> mapa = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		int detalle = Integer.valueOf(mapa.get("detalle"));
		ficha = fichaFacade.find(detalle);
	}
	
}
