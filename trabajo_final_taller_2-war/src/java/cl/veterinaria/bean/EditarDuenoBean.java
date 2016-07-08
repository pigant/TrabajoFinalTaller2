/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.veterinaria.bean;

import cl.veterinaria.entity.Dueno;
import cl.veterinaria.service.DuenoFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.event.CellEditEvent;

/**
 *
 * @author ignacio
 */
@Named(value = "editarDuenoBean")
@ViewScoped
public class EditarDuenoBean implements Serializable {

	@EJB
	private DuenoFacadeLocal duenoFacade;

	private int rut;
	private Dueno dueno;
	private List<Dueno> listaDuenos;

	/**
	 * Creates a new instance of EditarDuenoBean
	 */
	public EditarDuenoBean() {
	}

	@PostConstruct
	public void init() {
		listaDuenos = duenoFacade.findAll();
	}

	public void buscarDueno() {
		dueno = duenoFacade.find(rut);
		if (dueno == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dueno no existe"));
		}
	}

	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();

		if (newValue != null && !newValue.equals(oldValue)) {
		}
	}

	public int getRut() {
		return rut;
	}

	public void setRut(int rut) {
		this.rut = rut;
	}

	public Dueno getDueno() {
		return dueno;
	}

	public void setDueno(Dueno dueno) {
		this.dueno = dueno;
	}

	public List<Dueno> getListaDuenos() {
		return listaDuenos;
	}

	public void setListaDuenos(List<Dueno> listaDuenos) {
		this.listaDuenos = listaDuenos;
	}

}
