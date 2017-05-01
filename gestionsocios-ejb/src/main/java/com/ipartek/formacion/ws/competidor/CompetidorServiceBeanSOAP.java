package com.ipartek.formacion.ws.competidor;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import com.ipartek.formacion.persistence.Socio;
import com.ipartek.formacion.socio.SocioServiceRemote;

/**
 * Session Bean implementation class CompetidorServiceBeanSOAP
 */
@WebService(endpointInterface = "com.ipartek.formacion.ws.competidor.CompetidorServiceSOAPRemote", serviceName = "competidorService")
@Stateless(name="CompetidorServiceSOAP")
public class CompetidorServiceBeanSOAP implements CompetidorServiceSOAPRemote {

	
	@EJB
	SocioServiceRemote sS;
    /**
     * Default constructor. 
     */
    public CompetidorServiceBeanSOAP() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public List<Socio> getCompetidores() {
    	return sS.getCompetidores();
    }
    
}