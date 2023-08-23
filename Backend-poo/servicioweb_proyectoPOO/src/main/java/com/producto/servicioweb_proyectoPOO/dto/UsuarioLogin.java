package com.producto.servicioweb_proyectoPOO.dto;

import lombok.Data;

@Data
public class UsuarioLogin {
	private String email;
	private String contraseña;
	
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
}
