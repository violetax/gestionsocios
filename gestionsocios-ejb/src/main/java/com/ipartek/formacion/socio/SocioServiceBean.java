package com.ipartek.formacion.socio;

import java.util.List;

import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import com.ipartek.formacion.persistence.Socio;
/**
* <h1> Esta clase implementa la interfaz remota y los métodos CRUD.</h1>
*
@author Violeta González
*
*
**/

/**
 * Session Bean implementation class SocioServiceBean
 */
@Stateless(name="socioServiceBean")
public class SocioServiceBean implements SocioServiceRemote {

	private static final Logger LOGGER = Logger.getLogger(SocioServiceBean.class);
    
    @PersistenceContext(unitName="gestionsocios")
    private EntityManager entityManager;
    

	@Override
	public List<Socio> getAll() {
		
		LOGGER.debug("Carga de socios.");
		
		TypedQuery<Socio> psocios = entityManager.createNamedQuery("socio.getAll", Socio.class);
		return psocios.getResultList();

	}


	@Override
	public Socio getById(long codigo) {
		Socio socio = entityManager.find(Socio.class, codigo);
		return socio;
	}


	@Override
	public Socio create(Socio socio) {
		try {
			LOGGER.debug("Crear socio: " + socio.toString());
			socio = entityManager.merge(socio);
		} catch (Exception e) {}
		return socio;
	}


	@Override
	public Socio update(Socio socio) {
		try {
			LOGGER.debug("Editar socio: " + socio.toString());
			socio = entityManager.merge(socio);
		} catch (Exception e) {}
		return socio;
	}


	@Override
	public void delete(long codigo) {
		try {
			LOGGER.debug("Borrar socio");
		entityManager.remove(entityManager.find(Socio.class, codigo));
		} catch (Exception e) {}
		
	}


	@Override
	public List<Socio> getCompetidores() {
			LOGGER.debug("Carga de competidores.");
			
			TypedQuery<Socio> pcompetidores = entityManager.createNamedQuery("socio.getCompetidores", Socio.class);			
			List <Socio> competidores = pcompetidores.getResultList();
			return competidores;
			
	}
}
