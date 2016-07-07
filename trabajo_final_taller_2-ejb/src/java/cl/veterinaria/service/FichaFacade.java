/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.veterinaria.service;

import cl.veterinaria.entity.Ficha;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ignacio
 */
@Stateless
public class FichaFacade extends AbstractFacade<Ficha> implements FichaFacadeLocal {

	@PersistenceContext(unitName = "trabajo_final_taller_2-ejbPU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public FichaFacade() {
		super(Ficha.class);
	}

	@Override
	public List<Ficha> findByMascotaId(int mascotaId){
		Query q = getEntityManager()
				.createNamedQuery("Ficha.findByMascotaId")
				.setParameter("mascotaId", mascotaId);
		return (List<Ficha>) q.getResultList();
	}
	
}
