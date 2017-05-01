package com.ipartek.formacion.controller.formater;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.ipartek.formacion.persistence.Recibo;
import com.ipartek.formacion.service.interfaces.ReciboService;
/**
*
*
@author Violeta González
*
*
**/

public class ReciboConverter implements Converter<String, Recibo> {
	@Autowired
	ReciboService rS;
	private static final Logger LOGGER = LoggerFactory.getLogger(ReciboConverter.class);

	@Override
	public Recibo convert(String codigo) {
		
		
		Recibo recibo = rS.getById(Long.parseLong(codigo));
		
		LOGGER.info("Recibo converter: hecho.");
		
		return recibo;
	}

}