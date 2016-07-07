package cl.veterinaria.service;

import cl.veterinaria.entity.Dueno;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ignacio
 */
@Stateless
public class DuenoFacade extends AbstractFacade<Dueno> implements DuenoFacadeLocal {

	@PersistenceContext(unitName = "trabajo_final_taller_2-ejbPU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public DuenoFacade() {
		super(Dueno.class);
	}

}
