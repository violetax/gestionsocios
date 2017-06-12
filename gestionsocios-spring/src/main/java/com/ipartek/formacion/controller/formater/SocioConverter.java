package com.ipartek.formacion.controller.formater;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.ipartek.formacion.persistence.Socio;
import com.ipartek.formacion.service.interfaces.SocioService;

/**
*
* @Violeta González
*
**/

public class SocioConverter implements Converter<String, Socio> {
	
	public SocioConverter() {
	}
	
	@Autowired
	SocioService sS;
	private static final Logger LOGGER = LoggerFactory.getLogger(SocioConverter.class);

	@Override
	public Socio convert(String codigo) {
		Socio socio = sS.getById(Long.parseLong(codigo));
		
		LOGGER.info(codigo);
		
		LOGGER.info("Socio converter: hecho.");
		
		return socio;
	}

}
