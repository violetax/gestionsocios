package com.ipartek.formacion.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ipartek.formacion.persistence.Combate;
/**
*
*
@author Violeta González
*
*
**/

public class CombateValidator implements Validator {

	private static final Logger LOGGER = LoggerFactory.getLogger(CombateValidator.class);
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Combate.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		
		try {
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "velada", "requerida.velada");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "socio", "requerido.competidor");
			/*
			 * Esta validación no funciona:
			 
			 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "resultado", "requerido.resultado");
			
			if (combate.getResultado() == null) {
				errors.rejectValue(resultado, "requerido.resultado");
				}
			*/
			
		} catch (Exception e) {
			LOGGER.info("La validación del combate falla.");
		}

	}

}
