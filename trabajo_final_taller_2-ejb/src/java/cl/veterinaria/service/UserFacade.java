package cl.veterinaria.service;

import cl.veterinaria.entity.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ignacio
 */
@Stateless
public class UserFacade extends AbstractFacade<User> implements UserFacadeLocal {

	@PersistenceContext(unitName = "trabajo_final_taller_2-ejbPU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public UserFacade() {
		super(User.class);
	}

	@Override
	public User findByUserAndPass(String username, String password) {
		Query q = getEntityManager().createNamedQuery("User.findByUserAndPass");
		q.setParameter("username", username);
		q.setParameter("password", password);
		return (User) q.getSingleResult();
	}

}
