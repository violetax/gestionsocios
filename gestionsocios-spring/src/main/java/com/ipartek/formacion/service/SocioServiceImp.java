package com.ipartek.formacion.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.persistence.Socio;
import com.ipartek.formacion.service.interfaces.SocioService;
import com.ipartek.formacion.socio.SocioServiceRemote;
/**
*
*
@author Violeta González
*
*
**/

@Service("socioServiceImp")
public class SocioServiceImp implements SocioService {


	@Resource(name="socioServiceRemote")
	private SocioServiceRemote socioServiceRemote;
	
	@Override
	public void setSocioServiceRemote(SocioServiceRemote socioService) {
		this.socioServiceRemote = socioService; 
		
	}

	@Override
	public List<Socio> getAll() {
		return socioServiceRemote.getAll();
	}

	@Override
	public Socio getById(long codigo) {
		return socioServiceRemote.getById(codigo);
	}

	@Override
	public Socio create(Socio socio) {
		return socioServiceRemote.create(socio);
	}

	@Override
	public Socio update(Socio socio) {
		return socioServiceRemote.update(socio);
	}

	@Override
	public void delete(long codigo) {
		Socio socio = socioServiceRemote.getById(codigo);
        socio.setActivo(false);
        socioServiceRemote.update(socio);
		
	}

	@Override
	public List<Socio> getCompetidores() {
		return socioServiceRemote.getCompetidores();
	}

}