package com.ipartek.formacion.listeners;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.PostLoad;

import com.ipartek.formacion.persistence.Velada;
/**
 * <h1> Clase para acción PostLoad.</h1>
*
*
@author Violeta González
*
*
**/


public class VeladaListener {
	/**
	 * <p> Este método devuelve combinadas dos propiedades de la clase que toma com argumento.</p>
	 * 
	 **/
	@PostLoad
	public void veladaPostLoad(Velada velada) throws ParseException {
		
		Date fecha = velada.getFecha();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		String fechaVelada = sdf.format(fecha);
		
		
		velada.setIdentificador(velada.getLugar() + ", " + fechaVelada );
		
		
		
	}
}
