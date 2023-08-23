package com.producto.servicioweb_proyectoPOO.entidad;

import lombok.Data;

@Data
public class UsuarioEntidad {
	private Integer codigoUsuario;
	private String email;
	private String contraseña;
	private String nombres;
	private String apellidos;
	private Integer perfil;
	
	public Integer getCodigoUsuario() {
		return codigoUsuario;
	}
	public void setCodigoUsuario(Integer codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Integer getPerfil() {
		return perfil;
	}
	public void setPerfil(Integer perfil) {
		this.perfil = perfil;
	}
}