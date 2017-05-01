package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.socio.SocioServiceRemote;
import com.ipartek.formacion.persistence.Socio;
/**
*
*
@author Violeta González
*
*
**/

public interface SocioService {

	public void setSocioServiceRemote(SocioServiceRemote socioService);
	
	public List<Socio> getAll();
	public Socio getById(long codigo);
	public Socio create(Socio socio);
	public Socio update(Socio socio);
	public void delete(long codigo);
	
	public List<Socio> getCompetidores();
}