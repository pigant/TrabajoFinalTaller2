package cl.veterinaria.bean;

import cl.veterinaria.entity.Mascota;
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
@Named(value = "busquedaAnimalBean")
@ViewScoped
public class BusquedaAnimalBean implements Serializable {

	@EJB
	private MascotaFacadeLocal mascotaFacade;

	private String nombre;

	private List<Mascota> listaMascotas;

	/**
	 * Creates a new instance of BusquedaAnimalBean
	 */
	public BusquedaAnimalBean() {
	}

	public void buscarMascota() {
		listaMascotas = mascotaFacade.findLikeNombre(nombre + '%');
	}

	public String verFicha(int mascotaId) {
		return "ficha.xhtml?faces-redirect=true&mascota=" + mascotaId;
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
