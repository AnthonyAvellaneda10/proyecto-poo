package com.producto.servicioweb_proyectoPOO.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.producto.servicioweb_proyectoPOO.dao.Dao;
import com.producto.servicioweb_proyectoPOO.dto.ProductoNuevo;
import com.producto.servicioweb_proyectoPOO.dto.UsuarioLogin;
import com.producto.servicioweb_proyectoPOO.dto.UsuarioNuevo;
import com.producto.servicioweb_proyectoPOO.dto.rest.producto.Producto;
import com.producto.servicioweb_proyectoPOO.dto.rest.producto.ProductoDetalle;
import com.producto.servicioweb_proyectoPOO.dto.rest.producto.RespuestaProducto;
import com.producto.servicioweb_proyectoPOO.dto.rest.producto.Usuario;
import com.producto.servicioweb_proyectoPOO.entidad.UsuarioEntidad;
import com.producto.servicioweb_proyectoPOO.exception.NotFoundException;

@Service
@Transactional
public class ServicioImpl implements Servicio {
	
	@Autowired
	private Dao dao;

	public ProductoNuevo añadirProducto(ProductoNuevo productoNuevo) {
		return dao.añadirProducto(productoNuevo);
	}

	@Override
	public RespuestaProducto buscarProductosPorNombreBD(String nombreProducto) {
		RespuestaProducto respuesta = new RespuestaProducto();
		respuesta.setProductos(dao.buscarProductosPorNombreBD(nombreProducto));
		return respuesta;
	}
	
	public RespuestaProducto obtenerProductos(){
		RespuestaProducto respuesta = new RespuestaProducto();
		respuesta.setProductos(dao.obtenerProductos());
		return respuesta;
	}

	@Override
	public ProductoDetalle mostrarProductoDetallado(Integer idProducto) {
		return dao.mostrarProductoDetallado(idProducto);
	}

	public List<Producto> obtenerProductos(String nombreProducto) {
		List<Producto> listaProductos = dao.obtenerProductos();
		List<Producto> listaNewProductos = new ArrayList<>();
		for (Producto respuestaProducto : listaProductos) {
			if (respuestaProducto.getNombre().toLowerCase().contains(nombreProducto.toLowerCase())) {
				listaNewProductos.add(respuestaProducto);
			}
		}
		return listaNewProductos;
	}

	@Override
	public Usuario registrarUsuario(UsuarioNuevo usuarioNuevo) {
		UsuarioEntidad usuarioEntidad = null;
		Usuario usuario = new Usuario();
		Integer maxCodigo = null;
		boolean existeUsuario = existeUsuario(usuarioNuevo.getEmail());
		if (existeUsuario) {
			throw new NotFoundException("El usuario ya existe");
		} else {
			maxCodigo = obtenerMaximoCodigoUsuario();
			if (maxCodigo == null) {
				maxCodigo = 1;
			} else {
				maxCodigo = maxCodigo + 1;
			}
			usuarioEntidad = setearUsuarioEntidad(usuarioNuevo, maxCodigo);
			dao.registrarUsuario(usuarioEntidad);
			usuario = dao.obtenerUsuario(usuarioEntidad.getEmail());
		}
		return usuario;
	}

	private Integer obtenerMaximoCodigoUsuario() {
		return dao.obtenerMaximoCodigoUsuario();
	}

	private boolean existeUsuario(String email) {
		boolean existeUsuario = false;
		if (dao.existeUsuario(email) == 1)
			existeUsuario = true;
		return existeUsuario;
	}

	private UsuarioEntidad setearUsuarioEntidad(UsuarioNuevo usuario, int idUsuario) {
		UsuarioEntidad usuarioEntidad = new UsuarioEntidad();
		usuarioEntidad.setCodigoUsuario(idUsuario);
		usuarioEntidad.setEmail(usuario.getEmail());
		usuarioEntidad.setContraseña(usuario.getContraseña());
		usuarioEntidad.setNombres(usuario.getNombres());
		usuarioEntidad.setApellidos(usuario.getApellidos());
		usuarioEntidad.setPerfil(2);
		return usuarioEntidad;
	}

	@Override
	public Usuario autenticarUsuario(UsuarioLogin usuarioLogin) {
		boolean existUsuario = existeUsuario(usuarioLogin.getEmail());
		if(!existUsuario) {
			throw new NotFoundException("Usuario no existe");
		}
		
		Usuario usuario = dao.autenticarUsuario(usuarioLogin);
		if (usuario == null) {
			throw new NotFoundException("Usuario y/o contraseña incorrecta");
		}
		return usuario;
	}


}
