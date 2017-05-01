package com.ipartek.formacion.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ipartek.formacion.persistence.Recibo;
/**
*
*
@author Violeta González
*
*
**/

public class ReciboValidator implements Validator {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReciboValidator.class);
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Recibo.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Recibo recibo = (Recibo) target;
		Integer cantidad = null;
		
		try {
			
			cantidad = Integer.parseInt(recibo.getCantidad());
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cantidad", "requerida.cantidad");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "socio", "requerido.socio");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fechapago", "requerida.fecha");
						
			if (cantidad < 0) {
				errors.rejectValue("cantidad", "negativa.cantidad");
				LOGGER.info("La cantidad no llega.");
			}
			
			if (cantidad > 1000) {
				errors.rejectValue("cantidad", "excesiva.cantidad");
				LOGGER.info("La cantidad se pasa.");
			}
		
		} catch (NumberFormatException e) {
			
			errors.rejectValue("cantidad", "rara.cantidad");
			LOGGER.info("No es un número.");
			
		}

	}

}