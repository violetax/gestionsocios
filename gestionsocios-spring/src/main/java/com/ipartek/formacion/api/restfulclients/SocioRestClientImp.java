package com.ipartek.formacion.api.restfulclients;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.ipartek.formacion.persistence.Socio;
/**
*
*
@author Violeta González
*
*
**/

@Transactional
@Service
public class SocioRestClientImp implements SocioRestClient {

	private static final Logger LOGGER = LoggerFactory.getLogger(SocioRestClientImp.class);
	
	@Override
	public List<Socio> getAll() {
		
		RestTemplate template = new RestTemplate();
		List<Socio> socios = null;
		
		socios = template.getForObject(SocioRestClient.URL + ".json", List.class);
		
		LOGGER.debug("REST getAll socios: " + socios.toString());
		
		return socios;
	}

	@Override
	public Socio getById(int codigo) {
		
		RestTemplate template = new RestTemplate();
		Socio socio = null;
		
		socio = template.getForObject(SocioRestClient.URL + "/", Socio.class);
		
		LOGGER.debug("REST getById socio: " + socio.toString());
		
		return socio;
	}

	@Override
	public Socio create(Socio socio) {
		
		RestTemplate template = new RestTemplate();
		URI uri = template.postForLocation(SocioRestClient.URL, socio);
		
		Socio soc = template.getForObject(uri, Socio.class);
		
		LOGGER.debug("REST create socio: " + soc.toString());
		
		return soc;
	}

	@Override
	public Socio update(Socio socio) {
		
		RestTemplate template = new RestTemplate();
		
		template.put(SocioRestClient.URL + "/" + socio.getCodigo(), socio);
		
		LOGGER.debug("REST update socio: " + socio.toString());
		
		return socio;
	}

	@Override
	public void delete(int codigo) {
		RestTemplate template = new RestTemplate();
		template.delete(SocioRestClient.URL + "/" + codigo); 

		LOGGER.debug("REST delete socio");
		
	}

}