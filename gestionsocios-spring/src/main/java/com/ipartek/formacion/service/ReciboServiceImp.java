package com.ipartek.formacion.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.persistence.Recibo;
import com.ipartek.formacion.recibo.ReciboServiceRemote;
import com.ipartek.formacion.service.interfaces.ReciboService;
/**
*
*
@author Violeta González
*
*
**/

@Service("reciboServiceImp")
public class ReciboServiceImp implements ReciboService {

	@Resource(name="reciboServiceRemote")
	private ReciboServiceRemote reciboServiceRemote;
	
	@Override
	public void setReciboServiceRemote(ReciboServiceRemote reciboService) {
		this.reciboServiceRemote = reciboService;
		
	}

	@Override
	public List<Recibo> getAll() {
		return reciboServiceRemote.getAll();
	}

	@Override
	public Recibo getById(long codigo) {
		return reciboServiceRemote.getById(codigo);
	}

	@Override
	public Recibo create(Recibo recibo) {
		return reciboServiceRemote.create(recibo);
	}

	@Override
	public Recibo update(Recibo recibo) {
		return reciboServiceRemote.update(recibo);
	}

	@Override
	public void delete(long codigo) {
		Recibo recibo = reciboServiceRemote.getById(codigo);
        recibo.setActivo(false);
        reciboServiceRemote.update(recibo);
		
	}

}