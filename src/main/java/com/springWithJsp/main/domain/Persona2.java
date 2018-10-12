package com.springWithJsp.main.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONA2")
public class Persona2 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String comodin;

	private String proceso;

	private String fuente;

	private String estado;

	private String terminado;

	@ManyToOne(optional = false)
	@JoinColumn(name = "USUARIO_ID")
	private Usuario usuarioId;

	public Persona2() {
		super();
	}

	public Persona2(String comodin, String proceso, String fuente, String estado, String terminado, Usuario usuario) {
		super();
		this.comodin = comodin;
		this.proceso = proceso;
		this.fuente = fuente;
		this.estado = estado;
		this.terminado = terminado;
		this.usuarioId = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComodin() {
		return comodin;
	}

	public void setComodin(String comodin) {
		this.comodin = comodin;
	}

	public String getProceso() {
		return proceso;
	}

	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

	public String getFuente() {
		return fuente;
	}

	public void setFuente(String fuente) {
		this.fuente = fuente;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTerminado() {
		return terminado;
	}

	public void setTerminado(String terminado) {
		this.terminado = terminado;
	}

	public Usuario getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Usuario usuarioId) {
		this.usuarioId = usuarioId;
	}

	@Override
	public String toString() {
		return "Persona2 [id=" + id + ", comodin=" + comodin + ", proceso=" + proceso + ", fuente=" + fuente
				+ ", estado=" + estado + ", terminado=" + terminado + ", usuarioId=" + usuarioId + "]";
	}

}
