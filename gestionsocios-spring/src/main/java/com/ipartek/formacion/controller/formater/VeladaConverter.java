package com.ipartek.formacion.controller.formater;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.ipartek.formacion.persistence.Velada;
import com.ipartek.formacion.service.interfaces.VeladaService;
/**
*
*
@author Violeta González
*
*
**/

public class VeladaConverter implements Converter<String, Velada> {
	
	public VeladaConverter() {
	}
	
	
	@Autowired
	VeladaService sS;
	private static final Logger LOGGER = LoggerFactory.getLogger(VeladaConverter.class);

	@Override
	public Velada convert(String codigo) {
		Velada velada = sS.getById(Long.parseLong(codigo));
		
		LOGGER.info("Velada converter: hecho.");
		
		return velada;
	}

}