package com.ipartek.formacion.recibo;

import java.util.List;

import javax.ejb.Remote;

import com.ipartek.formacion.persistence.Recibo;
/**
* <h1> Esta interfaz define métodos CRUD.</h1>
*
@author Violeta González
*
*
**/

@Remote
public interface ReciboServiceRemote {

	public List<Recibo> getAll();
	public Recibo getById(long codigo);

	public Recibo create(Recibo recibo);
	public Recibo update(Recibo recibo);

	public void delete(long codigo);
	
}
