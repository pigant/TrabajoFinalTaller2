package cl.veterinaria.bean;

import cl.veterinaria.entity.Dueno;
import cl.veterinaria.entity.Ficha;
import cl.veterinaria.entity.Mascota;
import cl.veterinaria.service.DuenoFacadeLocal;
import cl.veterinaria.service.FichaFacadeLocal;
import cl.veterinaria.service.MascotaFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author ignacio
 */
@Named(value = "ingresoBean")
@ViewScoped
public class IngresoBean implements Serializable {

	@EJB
	private DuenoFacadeLocal duenoFacade;

	@EJB
	private MascotaFacadeLocal mascotaFacade;

	@EJB
	private FichaFacadeLocal fichaFacade;

	private Dueno dueno;
	private int duenoId;
	private int mascotaId;
	private Mascota mascota;
	private String diagnostico;
	private String receta;

	private List<Mascota> listaMascota = new ArrayList<>();

	/**
	 * Creates a new instance of IngresoBean
	 */
	public IngresoBean() {
	}

	public void buscarMascotas() {
		listaMascota = mascotaFacade.findByDuenoId(duenoId);
	}

	public void seleccionarMascota() {
		mascota = mascotaFacade.find(mascotaId);
	}

	public String ingresarFicha() {
		//Comprobaciones
		boolean correcto = true;
		//Positivo
		if (correcto) {
			Ficha f = new Ficha();
			f.setMascotaId(mascota);
			f.setRecetario(receta);
			f.setDiagnostico(diagnostico);
			f.setFecha(new Date());
			fichaFacade.create(f);
			FacesContext.getCurrentInstance()
					.addMessage(null, new FacesMessage("Ficha creada correctamente"));
			return "menu";
		} //negativo
		else {
			FacesContext.getCurrentInstance()
					.addMessage(null, new FacesMessage("Datos faltantes"));
			return "";
		}
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

	public List<Mascota> getListaMascota() {
		return listaMascota;
	}

	public int getDuenoId() {
		return duenoId;
	}

	public void setDuenoId(int duenoId) {
		this.duenoId = duenoId;
	}

	public int getMascotaId() {
		return mascotaId;
	}

	public void setMascotaId(int mascotaId) {
		this.mascotaId = mascotaId;
	}

}
