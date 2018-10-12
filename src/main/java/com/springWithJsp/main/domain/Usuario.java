package com.springWithJsp.main.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String usuario;
	
	private String contrasena;
	
	private String identificacion;
	
	private String nombre;
	
	private String apellido;
	
	private String email;
	
	public Usuario() {
		super();
	}

	public Usuario(String usuario, String contrasena, String identificacion, String nombre, String apellido,
			String email) {
		super();
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", usuario=" + usuario + ", contrasena=" + contrasena + ", identificacion="
				+ identificacion + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + "]";
	}
	
	

}
