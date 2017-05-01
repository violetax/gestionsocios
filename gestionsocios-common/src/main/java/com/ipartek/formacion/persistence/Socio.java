package com.ipartek.formacion.persistence;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
//import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.ipartek.formacion.listeners.SocioListener;

/**
 * <h1> Entidad JPA: </h1>
 *
 * <h1> Entidad JPA: Socio</h1>
 *
 * <p> Esta clase recoge las propiedades de la tabla Socio.</p>
 * <p> Crea otra NamedQuery para recoger auqellos registros qeu cumplan una condición: que el valor de su campo boolean de competidor sea TRUE.</p>
 *
 *
 *  @author Violeta González 
 *
 *
 *  **/ 

@Table(name = "socio")
@Entity(name = "socio")
@EntityListeners(value=SocioListener.class)
@NamedQueries({
	@NamedQuery(name = "socio.getAll", query = "SELECT s FROM socio as s WHERE s.activo = TRUE"),
	@NamedQuery(name = "socio.getCompetidores", query = "SELECT s FROM socio as s WHERE s.activo = TRUE AND s.competidor = TRUE")
})
public class Socio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private long codigo;
	
	private String nombre;
	private String apellidos;
	private String telefono;
	private String email;
	private String nrotarjeta;
	private boolean competidor;
	private boolean activo;
	
	@Transient
	private String identificador;
	
	public Socio() {
		super();		
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNrotarjeta() {
		return nrotarjeta;
	}

	public void setNrotarjeta(String nrotarjeta) {
		this.nrotarjeta = nrotarjeta;
	}
	

	public boolean isCompetidor() {
		return competidor;
	}

	public void setCompetidor(boolean competidor) {
		this.competidor = competidor;
	}

	

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime *result + (int) (codigo ^(codigo >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Socio)) {
			return false;
		}
		Socio other = (Socio) obj;
		if (codigo != other.codigo) {
			return false;
		}
		

		return true;
	}

	
	
}
