package cl.veterinaria.bean;

import cl.veterinaria.entity.User;
import cl.veterinaria.service.UserFacadeLocal;
import javax.inject.Named;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Sistemas
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	@EJB
	private UserFacadeLocal userFacade;

	private User usuario;

	/**
	 * Creates a new instance of LoginBean
	 */
	public LoginBean() {
		usuario = new User();
	}

	public String ingresoLogin() {
		//Realizar comprobacion
		usuario = userFacade.findByUserAndPass(
				usuario.getUsername(), usuario.getPassword());
		//Comprobacion correcta
		if (usuario != null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Ingreso correcto"));
			return "menu";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Usuario no existente"));
			return "";

		}
	}

	public User getUsuarios() {
		return usuario;
	}

	public void setUsuarios(User user) {
		this.usuario = user;
	}

}
