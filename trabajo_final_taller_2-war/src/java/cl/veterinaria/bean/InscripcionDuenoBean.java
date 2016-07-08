package cl.veterinaria.bean;

import cl.veterinaria.entity.Dueno;
import cl.veterinaria.service.DuenoFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author ignacio
 */
@Named(value = "ingresoDuenoBean")
@ViewScoped
public class InscripcionDuenoBean implements Serializable {

	@EJB
	private DuenoFacadeLocal duenoFacade;

	private int rut;
	private String nombre;
	private Integer telefono;

	/**
	 * Creates a new instance of IngresoDuenoBean
	 */
	public InscripcionDuenoBean() {
	}

	public String ingresarDueno() {
		//Comprobaciones
		boolean correcto = true;
		correcto &= rutDisponible();
		correcto &= !nombre.equals("");
		correcto &= telefono != null;
		//Correcto
		if (correcto) {
			Dueno d = new Dueno();
			d.setRut(rut);
			d.setNombre(nombre);
			d.setTelefono(telefono);
			duenoFacade.create(d);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Dueño ingresado correctamente"));
			return "menu";
		} //Incorrecto
		else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Datos inválidos", "Debe rellenar todos los datos y no se pueden repetir los rut"));
			return "";
		}
	}

	public boolean rutDisponible() {
		Dueno dueno = duenoFacade.find(rut);
		if (dueno == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Rut disponible"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Rut ya existe", "Intene otro rut, ya que el ingresado ya existe"));
		}
		return dueno == null;
	}

	public int getRut() {
		return rut;
	}

	public void setRut(int rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

}
