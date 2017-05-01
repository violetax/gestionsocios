package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.persistence.Velada;
import com.ipartek.formacion.velada.VeladaServiceRemote;
/**
*
*
@author Violeta González
*
*
**/

public interface VeladaService {

	void setVeladaServiceRemote(VeladaServiceRemote veladaService);
	
	public List<Velada> getAll();
	public List<Velada> getAllPast();
	public Velada getById(long codigo);
	public Velada create(Velada velada);
	public Velada update(Velada velada);
	public void delete(long codigo);
	
}