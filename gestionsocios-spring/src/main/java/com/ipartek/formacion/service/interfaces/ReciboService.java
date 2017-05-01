package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.persistence.Recibo;
import com.ipartek.formacion.recibo.ReciboServiceRemote;
/**
*
*
@author Violeta González
*
*
**/

public interface ReciboService {

	void setReciboServiceRemote(ReciboServiceRemote reciboService);
	
	public List<Recibo> getAll();
	public Recibo getById(long codigo);
	public Recibo create(Recibo recibo);
	public Recibo update(Recibo recibo);
	public void delete(long codigo);
	
}
