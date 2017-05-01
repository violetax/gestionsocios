package com.ipartek.formacion.controller.formater;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.ipartek.formacion.persistence.Combate;
import com.ipartek.formacion.service.interfaces.CombateService;
/**
*
*
@author Violeta González
*
*
**/

public class CombateConverter implements Converter<String, Combate> {

	@Autowired
	CombateService cS;
	private static final Logger LOGGER = LoggerFactory.getLogger(CombateConverter.class);
	
	@Override
	public Combate convert(String codigo) {
		Combate combate = cS.getById(Long.parseLong(codigo));
		
		LOGGER.info("Combate converter: hecho.");
		
		return combate;
	}

	

}
