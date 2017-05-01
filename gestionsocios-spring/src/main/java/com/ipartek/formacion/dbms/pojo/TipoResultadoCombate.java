package com.ipartek.formacion.dbms.pojo;

import java.io.Serializable;
/**
* <h4> Clase que crea un setter y un getter para una string.</h4>
* <p> Este es un objeto para una sola propiedad de tipo String. Tiene la finalidad de poblar una lista en un controlador. Los elementos String de esta lista podrán ser accedidos por la vista correspondiente a través del getter de este objeto. </p>
*
@author Violeta González
*
*
**/

public class TipoResultadoCombate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String resultado;
	
	public TipoResultadoCombate() {
		super();
		this.resultado = "";
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	
}
