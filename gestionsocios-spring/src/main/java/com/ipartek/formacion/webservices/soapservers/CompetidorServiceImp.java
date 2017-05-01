package com.ipartek.formacion.webservices.soapservers;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipartek.formacion.persistence.Socio;
import com.ipartek.formacion.service.interfaces.SocioService;
import com.ipartek.formacion.webservices.soapservers.interfaces.CompetidorServiceWS;

@WebService
public class CompetidorServiceImp implements CompetidorServiceWS {

	@Autowired
	SocioService sS;
	
	@WebMethod(exclude=true)
	public void setSocioService(SocioService competidorService) {
		this.sS = competidorService;
	}
	
	
	@WebMethod(operationName="obtenerCompetidores")
	public List<Socio> getCompetidores() {
		return sS.getCompetidores();
	}

}
