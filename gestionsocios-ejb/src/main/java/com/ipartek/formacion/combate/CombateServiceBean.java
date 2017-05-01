package com.ipartek.formacion.combate;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import com.ipartek.formacion.persistence.Combate;
/**
* <h1> Esta clase implementa la interfaz remota y los métodos CRUD.</h1>
*
@author Violeta González
*
*
**/

/**
 * Session Bean implementation class CombateServiceBean
 */
@Stateless(name="combateServiceBean")
public class CombateServiceBean implements CombateServiceRemote {

	private static final Logger LOGGER = Logger.getLogger(CombateServiceBean.class);
       
    @PersistenceContext(unitName="gestionsocios")
    private EntityManager entityManager;
    

	

	@Override
	public List<Combate> getAll() {
		
		LOGGER.debug("Carga de combates.");
		
		TypedQuery<Combate> pcombates = entityManager.createNamedQuery("combate.getAll", Combate.class);
		return pcombates.getResultList();

	}


	@Override
	public Combate getById(long codigo) {
		Combate combate = entityManager.find(Combate.class, codigo);
		return combate;
	}


	@Override
	public Combate create(Combate combate) {
		try {
			LOGGER.debug("Crear combate: " + combate.toString());
			combate = entityManager.merge(combate);
		} catch (Exception e) {}
		return combate;
	}


	@Override
	public Combate update(Combate combate) {
		try {
			LOGGER.debug("Editar combate: " + combate.toString());
			combate = entityManager.merge(combate);
		} catch (Exception e) {}
		return combate;
	}


	@Override
	public void delete(long codigo) {
		try {
			LOGGER.debug("Borrar combate");
		entityManager.remove(entityManager.find(Combate.class, codigo));
		} catch (Exception e) {}
		
	}

}
