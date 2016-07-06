/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.veterinaria.service;

import cl.veterinaria.entity.Dueno;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ignacio
 */
@Local
public interface DuenoFacadeLocal {

	void create(Dueno dueno);

	void edit(Dueno dueno);

	void remove(Dueno dueno);

	Dueno find(Object id);

	List<Dueno> findAll();

	List<Dueno> findRange(int[] range);

	int count();
	
}
