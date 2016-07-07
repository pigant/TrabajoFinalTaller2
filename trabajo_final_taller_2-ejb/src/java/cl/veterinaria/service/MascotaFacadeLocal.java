package cl.veterinaria.service;

import cl.veterinaria.entity.Mascota;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ignacio
 */
@Local
public interface MascotaFacadeLocal {

	void create(Mascota mascota);

	void edit(Mascota mascota);

	void remove(Mascota mascota);

	Mascota find(Object id);

	List<Mascota> findAll();

	List<Mascota> findRange(int[] range);

	int count();

	public List<Mascota> findByDuenoId(int mascotaId);

	public List<Mascota> findLikeNombre(String nombre);

}
