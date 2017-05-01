package com.ipartek.formacion.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.persistence.Velada;
import com.ipartek.formacion.service.interfaces.VeladaService;
import com.ipartek.formacion.velada.VeladaServiceRemote;
/**
*
*
@author Violeta González
*
*
**/

@Service("veladaServiceImp")
public class VeladaServiceImp implements VeladaService {

	@Resource(name="veladaServiceRemote")
	private VeladaServiceRemote veladaServiceRemote;


	@Override
	public void setVeladaServiceRemote(VeladaServiceRemote veladaService) {
		this.veladaServiceRemote = veladaService;
		
	}

	@Override
	public List<Velada> getAll() {
		return veladaServiceRemote.getAll();
	}

	@Override
	public Velada getById(long codigo) {
		return veladaServiceRemote.getById(codigo);
	}

	@Override
	public Velada create(Velada Velada) {
		return veladaServiceRemote.create(Velada);
	}

	@Override
	public Velada update(Velada Velada) {
		return veladaServiceRemote.update(Velada);
	}

	@Override
	public void delete(long codigo) {
		Velada velada = veladaServiceRemote.getById(codigo);
        velada.setActivo(false);
        veladaServiceRemote.update(velada);
		
	}

	@Override
	public List<Velada> getAllPast() {
		return veladaServiceRemote.getAllPast();
	}

}