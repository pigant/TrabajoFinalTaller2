package cl.veterinaria.bean;

import cl.veterinaria.entity.Ficha;
import cl.veterinaria.entity.Mascota;
import cl.veterinaria.service.FichaFacadeLocal;
import cl.veterinaria.service.MascotaFacadeLocal;
import java.io.Serializable;
import java.util.List;
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
@Named(value = "fichaBean")
@ViewScoped
public class FichaBean implements Serializable {

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

	@PostConstruct
	public void init() {
		Map<String, String> mapa = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		if (mapa.containsKey("mascota")) {
			int mascotaId = Integer.valueOf(mapa.get("mascota"));
			listaFichas = fichaFacade.findByMascotaId(mascotaId);
			mascota = mascotaFacade.find(mascotaId);
		}

	}

	public String parsearSexo(){
		switch(mascota.getSexo()){
			case 'M':
				return "Masculino";
			case 'F':
				return "Femenino";
		}
		return "";
	}

	public String verDetalle(int detalleId) {
		return "detalle.xhtml?faces-redirect=true&detalle=" + detalleId;
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
