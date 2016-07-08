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
public class MenuBean implements Serializable {

	/**
	 * Creates a new instance of MenuBean
	 */
	public MenuBean() {
	}

	public String ingresarCliente() {
		return "inscripcionDueno";
	}

	public String ingresarMascota() {
		return "inscripcionMascota";
	}

	public String ingresarFicha() {
		return "ingreso";
	}

	public String verFichas(){
		return "busquedaAnimal";
	}

}
