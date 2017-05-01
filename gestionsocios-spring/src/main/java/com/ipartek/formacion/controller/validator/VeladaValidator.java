package com.ipartek.formacion.controller.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.persistence.Velada;
/**
*
*
@author Violeta González
*
*
**/

public class VeladaValidator implements Validator {

	private static final Logger LOGGER = LoggerFactory.getLogger(VeladaValidator.class);
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Velada.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		try {
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fecha", "requerida.fecha");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lugar", "requerido.lugar");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "provincia", "requerida.provincia");
			
		} catch (Exception e) {
			LOGGER.info("La validación de la velada falla.");
		}

	}

}