/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.veterinaria.service;

import cl.veterinaria.entity.TipoAnimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ignacio
 */
@Stateless
public class TipoAnimalFacade extends AbstractFacade<TipoAnimal> implements TipoAnimalFacadeLocal {

	@PersistenceContext(unitName = "trabajo_final_taller_2-ejbPU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public TipoAnimalFacade() {
		super(TipoAnimal.class);
	}
	
}
