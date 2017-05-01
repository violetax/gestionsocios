package com.ipartek.formacion.velada;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import com.ipartek.formacion.persistence.Velada;
/**
* <h1> Esta clase implementa la interfaz remota y los métodos CRUD.</h1>
*
@author Violeta González
*
*
**/

/**
 * Session Bean implementation class VeladaServiceBean
 */
@Stateless(name="veladaServiceBean")
public class VeladaServiceBean implements VeladaServiceRemote {

	private static final Logger LOGGER = Logger.getLogger(VeladaServiceBean.class);
	    
    @PersistenceContext(unitName="gestionsocios")
    private EntityManager entityManager;
    

	@Override
	public List<Velada> getAll() {
		
		LOGGER.debug("Carga de veladas.");
		
		TypedQuery<Velada> pveladas = entityManager.createNamedQuery("velada.getAll", Velada.class);
		return pveladas.getResultList();

	}


	@Override
	public Velada getById(long codigo) {
		Velada velada = entityManager.find(Velada.class, codigo);	
		return velada;
	}


	@Override
	public Velada create(Velada velada) {
		try {
			LOGGER.debug("Crear velada: " + velada.toString());
			velada = entityManager.merge(velada);
		} catch (Exception e) {}
		return velada;
	}


	@Override
	public Velada update(Velada velada) {
		try {
			LOGGER.debug("Editar velada: " + velada.toString());
			velada = entityManager.merge(velada);
		} catch (Exception e) {}
		return velada;
	}


	@Override
	public void delete(long codigo) {
		try {
			LOGGER.debug("Borrar velada");
		entityManager.remove(entityManager.find(Velada.class, codigo));
		} catch (Exception e) {}
		
	}


	@Override
	public List<Velada> getAllPast() {
			
		LOGGER.debug("Carga de veladas pasadas.");
		
		TypedQuery<Velada> pveladas = entityManager.createNamedQuery("velada.getAllPast", Velada.class);
		return pveladas.getResultList();
	}

	
	
}
