/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.veterinaria.service;

import cl.veterinaria.entity.TipoAnimal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ignacio
 */
@Local
public interface TipoAnimalFacadeLocal {

	void create(TipoAnimal tipoAnimal);

	void edit(TipoAnimal tipoAnimal);

	void remove(TipoAnimal tipoAnimal);

	TipoAnimal find(Object id);

	List<TipoAnimal> findAll();

	List<TipoAnimal> findRange(int[] range);

	int count();
	
}
