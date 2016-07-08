package cl.veterinaria.bean;

import cl.veterinaria.entity.Ficha;
import cl.veterinaria.service.FichaFacadeLocal;
import java.io.Serializable;
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
public class DetalleBean implements Serializable {

	@EJB
	private FichaFacadeLocal fichaFacade;

	private Ficha ficha;

	/**
	 * Creates a new instance of DetalleBean
	 */
	public DetalleBean() {
	}

	@PostConstruct
	public void init() {
		Map<String, String> mapa = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		if (mapa.containsKey("detalle")) {
			int detalle = Integer.valueOf(mapa.get("detalle"));
			ficha = fichaFacade.find(detalle);
		}
	}

	public Ficha getFicha() {
		return ficha;
	}

	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}

}
