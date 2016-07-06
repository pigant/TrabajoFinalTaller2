/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.veterinaria.service;

import cl.veterinaria.entity.Ficha;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ignacio
 */
@Local
public interface FichaFacadeLocal {

	void create(Ficha ficha);

	void edit(Ficha ficha);

	void remove(Ficha ficha);

	Ficha find(Object id);

	List<Ficha> findAll();

	List<Ficha> findRange(int[] range);

	int count();
	
}
