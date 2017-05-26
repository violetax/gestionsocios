package com.ipartek.formacion.api.restfulclients;

import java.util.List;

import com.ipartek.formacion.persistence.Socio;
/**
*
*
@author Violeta González
*
*
**/



public interface SocioRestClient {

	final static String URL = "http://localhost:8080/gestionsocios/api/socios";
	
	public List<Socio> getAll();	
	public Socio getById(int codigo);	
	public Socio create(Socio socio);	
	public Socio update(Socio socio);	
	public void delete(int codigo);
	
}
