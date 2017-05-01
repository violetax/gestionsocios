package com.ipartek.formacion.recibo;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import com.ipartek.formacion.persistence.Recibo;
/**
* <h1> Esta clase implementa la interfaz remota y los métodos CRU  D.</h1>
*
@author Violeta González
*
*
**/

/**
 * Session Bean implementation class ReciboServiceBean
 */
@Stateless(name="reciboServiceBean")
public class ReciboServiceBean implements ReciboServiceRemote {

	private static final Logger LOGGER = Logger.getLogger(ReciboServiceBean.class);
	    
    @PersistenceContext(unitName="gestionsocios")
    private EntityManager entityManager;
    


	@Override
	public List<Recibo> getAll() {
		
		LOGGER.debug("Carga de recibos.");
		
		TypedQuery<Recibo> precibos = entityManager.createNamedQuery("recibo.getAll", Recibo.class);
		return precibos.getResultList();

	}


	@Override
	public Recibo getById(long codigo) {
		Recibo recibo = entityManager.find(Recibo.class, codigo);
		return recibo;
	}


	@Override
	public Recibo create(Recibo recibo) {
		try {
			LOGGER.debug("Crear recibo: " + recibo.toString());
			recibo = entityManager.merge(recibo);
		} catch (Exception e) {}
		return recibo;
	}


	@Override
	public Recibo update(Recibo recibo) {
		try {
			LOGGER.debug("Editar recibo: " + recibo.toString());
			recibo = entityManager.merge(recibo);
		} catch (Exception e) {}
		return recibo;
	}


	@Override
	public void delete(long codigo) {
		try {
			LOGGER.debug("Borrar recibo");
		entityManager.remove(entityManager.find(Recibo.class, codigo));
		} catch (Exception e) {}
		
	}

}
