package com.producto.servicioweb_proyectoPOO.dto;

import lombok.Data;

@Data
public class ProductoNuevo {
	private Integer codigoProducto;
	private Integer codigoTalla;
	private Integer codigoTipoProducto;
	private String nombre;
	private String tipo;
	private String genero;
	private double precioUnitario;
	private String color;
	private String marca;
	private String modelo;
	private String material;
	private String imagen;
	
	public Integer getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(Integer codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public Integer getCodigoTalla() {
		return codigoTalla;
	}
	public void setCodigoTalla(Integer codigoTalla) {
		this.codigoTalla = codigoTalla;
	}
	public Integer getCodigoTipoProducto() {
		return codigoTipoProducto;
	}
	public void setCodigoTipoProducto(Integer codigoTipoProducto) {
		this.codigoTipoProducto = codigoTipoProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
}
