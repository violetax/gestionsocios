package com.ipartek.formacion.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
*
*
@author Violeta González
*
*
**/

public final class Util {
	private static final Logger LOGGER = LoggerFactory.getLogger(Util.class);

	private Util() {

	}

	public static boolean checkRegex(final String REGEX, final String parameter) {
		boolean valido = false;
		final Pattern pattern = Pattern.compile(REGEX);
		final Matcher matcher = pattern.matcher(parameter);
		if (matcher.matches()) {
			valido = true;
		}
		return valido;
	}


	public static boolean validarTelefono(final String telefono) {
		boolean valido = false;
		final String REGEX = "[0-9]{9}";

		if (checkRegex(REGEX, telefono)) {
			valido = true;
		}
		return valido;
	}

	public static boolean validarEmail(final String email) {
		boolean valido = false;
		final String REGEX = ("[^ ]*@[^ ]*.[^ ]{2,4}");
		if (checkRegex(REGEX, email)) {
			valido = true;
		}
		return valido;
	}

	public static boolean validarNombre(String nombre) {
		boolean valido = false;
		final String REGEX = "[a-zA-Z]+";
		if (checkRegex(REGEX, nombre)) {
			valido = true;
		}
		return valido;
	}
	
	public static boolean validarApellidos(String apellidos) {
		boolean valido = false;
		final String REGEX = "[a-zA-Z]+( +[a-zA-Z]+)?";
		if (checkRegex(REGEX, apellidos)) {
			valido = true;
		}
		return valido;
	}
	
	public static boolean validarNrotarjeta(String nrotarjeta) {
		boolean valido = false;
		final String REGEX = "[0-9]{16}";

		if (checkRegex(REGEX, nrotarjeta)) {
			valido = true;
		}
		return valido;
	}

	}
