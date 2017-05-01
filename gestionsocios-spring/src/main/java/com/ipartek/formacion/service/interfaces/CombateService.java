package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.combate.CombateServiceRemote;
import com.ipartek.formacion.persistence.Combate;
/**
*
*
@author Violeta González
*
*
**/

public interface CombateService {

	void setCombateServiceRemote(CombateServiceRemote combateService);
	
	public List<Combate> getAll();
	public Combate getById(long codigo);
	public Combate create(Combate combate);
	public Combate update(Combate combate);
	public void delete(long codigo);

}