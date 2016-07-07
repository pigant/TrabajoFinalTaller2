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

	public List<Ficha> findByMascotaId(int mascotaId);

}
