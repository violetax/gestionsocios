package com.ipartek.formacion.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.service.interfaces.CombateService;
import com.ipartek.formacion.combate.CombateServiceRemote;
import com.ipartek.formacion.persistence.Combate;
/**
*
*
@author Violeta González
*
*
**/

@Service("combateServiceImp")
public class CombateServiceImp implements CombateService {
	
	@Resource(name="combateServiceRemote")
	private CombateServiceRemote combateServiceRemote;
	
	
	@Override
	public void setCombateServiceRemote(CombateServiceRemote combateService) {
		this.combateServiceRemote = combateService; 
		
	}


	@Override
	public List<Combate> getAll() {
		return combateServiceRemote.getAll();
	}

	@Override
	public Combate getById(long codigo) {
		return combateServiceRemote.getById(codigo);
	}

	@Override
	public Combate create(Combate combate) {
		return combateServiceRemote.create(combate);
	}

	@Override
	public Combate update(Combate combate) {
		return combateServiceRemote.update(combate);
	}

	@Override
	public void delete(long codigo) {
		Combate combate = combateServiceRemote.getById(codigo);
        combate.setActivo(false);
        combateServiceRemote.update(combate);
		
	}

}