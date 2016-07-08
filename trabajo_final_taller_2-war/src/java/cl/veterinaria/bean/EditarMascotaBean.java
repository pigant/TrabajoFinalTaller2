/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.veterinaria.bean;

import cl.veterinaria.entity.Mascota;
import cl.veterinaria.entity.TipoAnimal;
import cl.veterinaria.service.MascotaFacadeLocal;
import cl.veterinaria.service.TipoAnimalFacadeLocal;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.event.CellEditEvent;

/**
 *
 * @author ignacio
 */
@Named(value = "editarMascotaBean")
@ViewScoped
public class EditarMascotaBean implements Serializable{

	@EJB
	private TipoAnimalFacadeLocal tipoAnimalFacade1;

	@EJB
	private TipoAnimalFacadeLocal tipoAnimalFacade;

	@EJB
	private MascotaFacadeLocal mascotaFacade;

	private int tipoAnimalIdTemporal;

	List<Mascota> listaMascota;

	List<TipoAnimal> listaTipoAnimal;
	/**
	 * Creates a new instance of EditarMascotaBean
	 */
	public EditarMascotaBean() {
	}

	@PostConstruct
	public void init(){
		listaMascota = mascotaFacade.findAll();
		listaTipoAnimal = tipoAnimalFacade.findAll();
	}

	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();
		
		if (newValue != null && !newValue.equals(oldValue)) {
			Mascota m = listaMascota.get(event.getRowIndex());
			String nombreColumna = event.getColumn().getHeaderText();
			switch(nombreColumna)
			{
				case "Nombre":
					m.setNombre((String) newValue);
					break;
				case "Raza":
					m.setRaza((String) newValue);
					break;
				case "Sexo":
					m.setSexo((char) newValue);
					break;
				case "Fecha nacimiento":
					m.setFechaNacimiento((Date) newValue);
					break;
			}
			mascotaFacade.edit(m);
		}
	}

	public String parsearSexo(char sex){
		switch(sex){
			case 'F':
				return "Femenino";
			case 'M':
				return "Masculino";
		}
		return "";
	}

	public void eliminarMascota(int mascotaId){
		Mascota m = mascotaFacade.find(mascotaId);
		listaMascota.remove(m);
		mascotaFacade.remove(m);
	}

	public List<Mascota> getListaMascota() {
		return listaMascota;
	}

	public void setListaMascota(List<Mascota> listaMascota) {
		this.listaMascota = listaMascota;
	}

	public int getTipoAnimalIdTemporal() {
		return tipoAnimalIdTemporal;
	}

	public void setTipoAnimalIdTemporal(int tipoAnimalIdTemporal) {
		this.tipoAnimalIdTemporal = tipoAnimalIdTemporal;
	}

	public List<TipoAnimal> getListaTipoAnimal() {
		return listaTipoAnimal;
	}

	public void setListaTipoAnimal(List<TipoAnimal> listaTipoAnimal) {
		this.listaTipoAnimal = listaTipoAnimal;
	}

	
	
}
