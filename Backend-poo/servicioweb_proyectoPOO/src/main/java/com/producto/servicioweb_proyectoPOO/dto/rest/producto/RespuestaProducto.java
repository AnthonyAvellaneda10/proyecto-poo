package com.producto.servicioweb_proyectoPOO.dto.rest.producto;

import java.util.List;

import lombok.Data;

@Data
public class RespuestaProducto {
	List<Producto> productos;

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
}