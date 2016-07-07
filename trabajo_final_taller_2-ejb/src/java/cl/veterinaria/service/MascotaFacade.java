/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.veterinaria.service;

import cl.veterinaria.entity.Dueno;
import cl.veterinaria.entity.Mascota;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ignacio
 */
@Stateless
public class MascotaFacade extends AbstractFacade<Mascota> implements MascotaFacadeLocal {

	@PersistenceContext(unitName = "trabajo_final_taller_2-ejbPU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public MascotaFacade() {
		super(Mascota.class);
	}

	@Override
	public List<Mascota> findByDuenoId(int duenoId){
		Query q = getEntityManager().createNamedQuery("Mascota.findByDuenoId")
				.setParameter("duenoId", duenoId);
		return (List<Mascota>) q.getResultList();

	}
	
}
