package com.ipartek.formacion.velada;

import java.util.List;

import javax.ejb.Remote;

import com.ipartek.formacion.persistence.Velada;
/**
* <h1> Esta interfaz define métodos CRUD ademmás de un método para aplicar   un named query de la entidad de persistencia correspondiente.</h1>
*
@author Violeta González
*
*
**/

@Remote
public interface VeladaServiceRemote {

	public List<Velada> getAll();
	public List<Velada> getAllPast();
	public Velada getById(long codigo);

	public Velada create(Velada velada);
	public Velada update(Velada velada);

	public void delete(long codigo);
}
