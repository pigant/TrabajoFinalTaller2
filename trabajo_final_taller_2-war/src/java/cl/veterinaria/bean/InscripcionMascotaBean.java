package cl.veterinaria.bean;

import cl.veterinaria.entity.Dueno;
import cl.veterinaria.entity.Mascota;
import cl.veterinaria.entity.TipoAnimal;
import cl.veterinaria.service.DuenoFacadeLocal;
import cl.veterinaria.service.MascotaFacadeLocal;
import cl.veterinaria.service.TipoAnimalFacadeLocal;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author ignacio
 */
@Named(value = "ingresoMascotaBean")
@ViewScoped
public class InscripcionMascotaBean implements Serializable {

	@EJB
	private TipoAnimalFacadeLocal tipoAnimalFacade;

	@EJB
	private MascotaFacadeLocal mascotaFacade;

	@EJB
	private DuenoFacadeLocal duenoFacade;

	private String nombre;
	private int tipoAnimalId;
	private List<TipoAnimal> clasesAnimales;
	private String raza;
	private char sexo;
	private Date fechaNacimiento;
	private int duenoId;
	private Dueno dueno;

	/**
	 * Creates a new instance of IngresoMascotaBean
	 */
	public InscripcionMascotaBean() {
		sexo = 'M';
	}

	@PostConstruct
	public void init(){
		clasesAnimales = tipoAnimalFacade.findAll();
	}

	public String ingresoMascota() {
		//Comprobaciones
		boolean correcto = true;
		correcto &= !nombre.equals("");
		correcto &= fechaNacimiento != null;
		correcto &= dueno != null;
		//Correcto
		if (correcto) {
			Mascota m = new Mascota();
			m.setNombre(nombre);
			m.setSexo(sexo);
			m.setFechaNacimiento(fechaNacimiento);
			m.setDuenoId(dueno);
			m.setTipoAnimalId(tipoAnimalFacade.find(tipoAnimalId));
			m.setRaza(raza);
			mascotaFacade.create(m);
			FacesContext.getCurrentInstance().
					addMessage(null, new FacesMessage("Mascota ingresada"));
			return "menu";
		} //Incorrecto
		else {
			if (dueno == null) {
				FacesContext.getCurrentInstance().
						addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_ERROR, "Dueño no existe", "Debe elegir un dueño que exista"));
			} else {
				FacesContext.getCurrentInstance().
						addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_ERROR, "Datos faltantes", "Debe completar todos los campos"));
			}
			return "";
		}
	}

	public void buscarDueno() {
		dueno = duenoFacade.find(duenoId);
		//dueno no encontrado
		if (dueno == null) {
			FacesContext.getCurrentInstance().
					addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Dueño no encontrado", "Ingrese un rut existente"));
		} //Dueno encontrado
		else {
			FacesContext.getCurrentInstance().
					addMessage(null, new FacesMessage("Dueño encontrado"));
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getDuenoId() {
		return duenoId;
	}

	public void setDuenoId(int duenoId) {
		this.duenoId = duenoId;
	}

	public int getTipoAnimalId() {
		return tipoAnimalId;
	}

	public void setTipoAnimalId(int tipoAnimalId) {
		this.tipoAnimalId = tipoAnimalId;
	}

	public List<TipoAnimal> getClasesAnimales() {
		return clasesAnimales;
	}

	public void setClasesAnimales(List<TipoAnimal> clasesAnimales) {
		this.clasesAnimales = clasesAnimales;
	}

}
