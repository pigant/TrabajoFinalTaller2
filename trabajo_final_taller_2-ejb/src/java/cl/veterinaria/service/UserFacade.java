/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.veterinaria.service;

import cl.veterinaria.entity.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	
}
