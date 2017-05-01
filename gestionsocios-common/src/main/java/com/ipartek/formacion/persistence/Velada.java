package com.ipartek.formacion.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.ipartek.formacion.listeners.VeladaListener;

/**
 * <h1> Entidad JPA: Velada</h1>
 *
 * <p> Esta clase recoge las propiedades de la tabla Velada</p>
 * <p> Crea también una NamedQuery para recoger todos los registros de la tabla.</p>
 * <p> Crea otra NamedQuery para recoger auqellos registros qeu cumplan una condición: que el valor de su campo de fecha sea anterior a hoy.</p>
 *
 *
 * @author Violeta González
 * 
 * 
 * **/

@Table(name = "velada")
@Entity(name = "velada")
@EntityListeners(value=VeladaListener.class)
@NamedQueries({ 
		@NamedQuery(name = "velada.getAll", query = "SELECT v FROM velada as v WHERE v.activo = TRUE"), 
		@NamedQuery(name = "velada.getAllPast", query = "SELECT v FROM velada as v WHERE v.activo = TRUE AND v.fecha < CURRENT_DATE")
		})
public class Velada implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private long codigo;
	
	private Date fecha;
	private String lugar;
	private String provincia;
	private String comentarios;
	private boolean activo;
	

	@Transient
	private String identificador;
	
	public Velada() {
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



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public String getLugar() {
		return lugar;
	}



	public void setLugar(String lugar) {
		this.lugar = lugar;
	}



	public String getProvincia() {
		return provincia;
	}



	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}



	public String getComentarios() {
		return comentarios;
	}



	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
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
		if (!(obj instanceof Velada)) {
			return false;
		}
		Velada other = (Velada) obj;
		if (codigo != other.codigo) {
			return false;
		}
		

		return true;
	}

	
	
}
