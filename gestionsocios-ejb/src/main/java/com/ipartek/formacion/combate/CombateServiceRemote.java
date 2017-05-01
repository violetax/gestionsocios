package com.ipartek.formacion.combate;

import java.util.List;

import javax.ejb.Remote;

import com.ipartek.formacion.persistence.Combate;
/**
* <h1> Esta interfaz define métodos CRUD.</h1>
*
@author Violeta González
*
*
**/

@Remote
public interface CombateServiceRemote {

	public List<Combate> getAll();
	public Combate getById(long codigo);
	
	public Combate create(Combate combate);
	public Combate update(Combate combate);
	
	public void delete(long codigo);
	
}
