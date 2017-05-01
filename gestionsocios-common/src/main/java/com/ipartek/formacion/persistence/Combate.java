package com.ipartek.formacion.persistence;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * <h1> Entidad JPA: Combate</h1>
 *
 * <p> Esta clase recoge las propiedades de la tabla Combate.</p>
 * <p> Crea también una NamedQuery para recoger todos los registros de la tabla.</p>
 * 
 * @author Violeta González
 *
 */

@Table(name = "combate")
@Entity(name = "combate")
@NamedQueries({ @NamedQuery(name = "combate.getAll", query = "SELECT c FROM combate as c WHERE c.activo = TRUE") })
public class Combate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private long codigo;
	
	private String resultado;
	private String comentarios;
	private boolean activo;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "codigo_socio")
	private Socio socio;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "codigo_velada")
	private Velada velada;
	
	
	public Combate() {
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

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public Velada getVelada() {
		return velada;
	}

	public void setVelada(Velada velada) {
		this.velada = velada;
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
		if (!(obj instanceof Combate)) {
			return false;
		}
		Combate other = (Combate) obj;
		if (codigo != other.codigo) {
			return false;
		}
		

		return true;
	}

	
	
}
