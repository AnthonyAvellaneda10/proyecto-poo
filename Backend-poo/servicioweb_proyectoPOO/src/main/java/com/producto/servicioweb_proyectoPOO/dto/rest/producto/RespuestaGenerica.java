package com.producto.servicioweb_proyectoPOO.dto.rest.producto;

import lombok.Data;

@Data
public class RespuestaGenerica {
	private String mensaje;

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
