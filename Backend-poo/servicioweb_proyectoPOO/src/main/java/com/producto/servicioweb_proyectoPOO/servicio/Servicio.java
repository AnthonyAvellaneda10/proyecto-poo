package com.producto.servicioweb_proyectoPOO.servicio;

import java.util.List;

import com.producto.servicioweb_proyectoPOO.dto.ProductoNuevo;
import com.producto.servicioweb_proyectoPOO.dto.UsuarioLogin;
import com.producto.servicioweb_proyectoPOO.dto.UsuarioNuevo;
import com.producto.servicioweb_proyectoPOO.dto.rest.producto.Producto;
import com.producto.servicioweb_proyectoPOO.dto.rest.producto.ProductoDetalle;
import com.producto.servicioweb_proyectoPOO.dto.rest.producto.RespuestaProducto;
import com.producto.servicioweb_proyectoPOO.dto.rest.producto.Usuario;

public interface Servicio {
	//Productos
	public ProductoNuevo añadirProducto(ProductoNuevo productoNuevo);
	public ProductoDetalle mostrarProductoDetallado(Integer idProducto);
	public RespuestaProducto buscarProductosPorNombreBD(String nombreProducto);
	public List<Producto> obtenerProductos(String nombreProducto);
	public RespuestaProducto obtenerProductos();
	
	//Usuario
	public Usuario registrarUsuario(UsuarioNuevo usuario);
	public Usuario autenticarUsuario(UsuarioLogin usuarioLogin);
}
