package com.ipartek.formacion.socio;

import java.util.List;

import javax.ejb.Remote;

import com.ipartek.formacion.persistence.Socio;
/**
* <h1> Esta interfaz define métodos CRUD ademmás de un método para aplicar un named query de la entidad de persistencia correspondiente.</h1>
*
@author Violeta González
*
*
**/

@Remote
public interface SocioServiceRemote {
	
	public List<Socio> getAll();
	public Socio getById(long codigo);
	public Socio create(Socio socio);
	public Socio update(Socio socio);
	public void delete(long codigo);
	
	public List<Socio> getCompetidores();
}
