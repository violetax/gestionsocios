package com.ipartek.formacion.webservices.soapservers.interfaces;

import java.util.List;

import com.ipartek.formacion.persistence.Socio;

public interface CompetidorServiceWS {

	public List<Socio> getCompetidores();
	
}