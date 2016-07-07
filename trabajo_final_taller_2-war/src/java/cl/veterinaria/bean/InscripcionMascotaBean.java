package cl.veterinaria.bean;

import cl.veterinaria.entity.Dueno;
import cl.veterinaria.entity.Mascota;
import cl.veterinaria.service.DuenoFacadeLocal;
import cl.veterinaria.service.MascotaFacadeLocal;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author ignacio
 */
@Named(value = "ingresoMascotaBean")
@ViewScoped
public class InscripcionMascotaBean implements Serializable{

	@EJB
	private MascotaFacadeLocal mascotaFacade;

	@EJB
	private DuenoFacadeLocal duenoFacade;

	private String nombre;
	private String raza;
	private char sexo;
	private Date fechaNacimiento;
	private int duenoId;
	private Dueno dueno;
	/**
	 * Creates a new instance of IngresoMascotaBean
	 */
	public InscripcionMascotaBean() {
	}

	public String ingresoMascota(){
		Mascota m = new Mascota();
		m.setNombre(nombre);
		m.setSexo(sexo);
		m.setFechaNacimiento(fechaNacimiento);
		m.setDuenoId(dueno);
		mascotaFacade.create(m);
		return "menu";
	}

	public void buscarDueno(){
		dueno = duenoFacade.find(duenoId);
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
	
}
