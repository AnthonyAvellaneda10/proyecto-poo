package com.producto.servicioweb_proyectoPOO.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.producto.servicioweb_proyectoPOO.dto.ProductoNuevo;
import com.producto.servicioweb_proyectoPOO.dto.UsuarioLogin;
import com.producto.servicioweb_proyectoPOO.dto.UsuarioNuevo;
import com.producto.servicioweb_proyectoPOO.dto.rest.producto.Producto;
import com.producto.servicioweb_proyectoPOO.dto.rest.producto.ProductoDetalle;
import com.producto.servicioweb_proyectoPOO.dto.rest.producto.RespuestaProducto;
import com.producto.servicioweb_proyectoPOO.dto.rest.producto.Usuario;
import com.producto.servicioweb_proyectoPOO.servicio.Servicio;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = { "*" })
public class Controlador {
	@Autowired
	private Servicio servicio;

	@ApiOperation(value = "Añade un producto")
	@RequestMapping(value = "/añadir-producto", method = RequestMethod.POST, produces = "application/json;charset=utf-8", consumes = "application/json;charset=utf-8")
	public @ResponseBody ProductoNuevo añadirProducto(@RequestBody ProductoNuevo productoNuevo) {
		return servicio.añadirProducto(productoNuevo);
	}
	
	@ApiOperation(value = "Mostrar detalle del producto al hacer click")
	@RequestMapping(value = "/buscar-producto/{idProducto}", method = RequestMethod.GET, produces = "application/json;charset=utf-8", consumes = "application/json;charset=utf-8")
	public @ResponseBody ProductoDetalle mostrarProductoDetallado(
			@PathVariable("idProducto") Integer idProducto) {
		return servicio.mostrarProductoDetallado(idProducto);
	}
	
	@ApiOperation(value = "Busqueda de productos por nombre")
	@RequestMapping(value = "/buscar-productos-nombre/{nombreProducto}", method = RequestMethod.GET, produces = "application/json;charset=utf-8", consumes = "application/json;charset=utf-8")
	public @ResponseBody RespuestaProducto buscarProductosPorNombreBD(
			@PathVariable("nombreProducto") String nombreProducto) {
		return servicio.buscarProductosPorNombreBD(nombreProducto);
	}
	
	@ApiOperation(value = "No usar")
	@RequestMapping(value = "/obtener-productos/{nombreProducto}", method = RequestMethod.GET, produces = "application/json;charset=utf-8", consumes = "application/json;charset=utf-8")
	public @ResponseBody List<Producto> obtenerProductos(
			@PathVariable("nombreProducto") String nombreProducto) {
		return servicio.obtenerProductos(nombreProducto);
	}

	@ApiOperation(value = "Listado de todos los productos")
	@RequestMapping(value = "/obtener-productos", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public @ResponseBody RespuestaProducto obtenerProductos() {
		return servicio.obtenerProductos();
	}

	@ApiOperation(value = "Registrar un usuario")
	@RequestMapping(value = "/registrar-usuario", method = RequestMethod.POST, produces = "application/json;charset=utf-8", consumes = "application/json;charset=utf-8")
	public @ResponseBody Usuario registrarUsuario(@RequestBody UsuarioNuevo usuario) {
		return servicio.registrarUsuario(usuario);
	}
	
	@ApiOperation(value = "Autenticar usuario")
	@RequestMapping(value = "/autenticar-usuario", method = RequestMethod.POST, produces = "application/json;charset=utf-8", consumes = "application/json;charset=utf-8")
	public @ResponseBody Usuario autenticarUsuario(@RequestBody UsuarioLogin usuarioLogin) {
		return servicio.autenticarUsuario(usuarioLogin);
	}

}
