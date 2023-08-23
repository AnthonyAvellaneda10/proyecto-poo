package com.producto.servicioweb_proyectoPOO.dao;

import java.util.List;

import com.producto.servicioweb_proyectoPOO.dto.ProductoNuevo;
import com.producto.servicioweb_proyectoPOO.dto.UsuarioLogin;
import com.producto.servicioweb_proyectoPOO.dto.rest.producto.Producto;
import com.producto.servicioweb_proyectoPOO.dto.rest.producto.ProductoDetalle;
import com.producto.servicioweb_proyectoPOO.dto.rest.producto.Usuario;
import com.producto.servicioweb_proyectoPOO.entidad.UsuarioEntidad;

public interface Dao {
	public ProductoNuevo añadirProducto(ProductoNuevo productoNuevo);
	public ProductoDetalle mostrarProductoDetallado(Integer idProducto);
	public List<Producto> buscarProductosPorNombreBD(String nombreProducto);
	public List<Producto> obtenerProductos();
	
	public UsuarioEntidad registrarUsuario(UsuarioEntidad usuario);
	
	public Integer existeUsuario(String email);
	public Integer obtenerMaximoCodigoUsuario();
	public Usuario obtenerUsuario(String email);
	public Usuario autenticarUsuario(UsuarioLogin usuarioLogin);
	
}
