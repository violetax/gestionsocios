package com.ipartek.formacion.listeners;

import javax.persistence.PostLoad;

import com.ipartek.formacion.persistence.Socio;

/**
* <h1> Clase para acción PostLoad.</h1>
* 
@author Violeta González
*
*
**/

public class SocioListener {
	/**
	 * <p> Este método devuelve combinadas dos propiedades de la clase que toma com argumento.</p>
	 * 
	 **/
	@PostLoad
	public void socioPostLoad(Socio socio) {
		socio.setIdentificador(socio.getNombre() + " " + socio.getApellidos());
	}
}
