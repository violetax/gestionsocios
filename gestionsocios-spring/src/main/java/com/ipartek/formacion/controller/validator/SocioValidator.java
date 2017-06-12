package com.ipartek.formacion.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.persistence.Socio;
import com.ipartek.formacion.service.Util;
/**
*
*
@author Violeta Gonzalez
*
*
**/

public class SocioValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramClass) {
		return Socio.class.equals(paramClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Socio socio = (Socio) target;
		String nombre = socio.getNombre();
		String apellidos = socio.getApellidos();
		String telefono = socio.getTelefono();
		String email = socio.getEmail();
		String nrotarjeta = socio.getNrotarjeta();

		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "requerido.nombre");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellidos", "requerido.apellidos");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono", "requerido.telefono");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "requerido.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nrotarjeta", "requerido.nrotarjeta");
	
		
		if (nombre != null && !Util.validarNombre(nombre)) {
			errors.rejectValue("nombre", "raro.nombre");
		}
		
		if (apellidos != null && !Util.validarApellidos(apellidos)) {
			errors.rejectValue("apellidos", "raro.apellidos");
		}
		
		if (telefono != null && !Util.validarTelefono(telefono)) {
			errors.rejectValue("telefono", "raro.telefono");
		}
		
		if (email != null && !Util.validarEmail(email)) {
			errors.rejectValue("email", "raro.email");
		}
		
		if (nrotarjeta != null && !Util.validarNrotarjeta(nrotarjeta)) {
			errors.rejectValue("nrotarjeta", "raro.nrotarjeta");
		}
		
		
	}
}