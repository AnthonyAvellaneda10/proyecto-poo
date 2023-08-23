package com.producto.servicioweb_proyectoPOO.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.producto.servicioweb_proyectoPOO.dto.ProductoNuevo;
import com.producto.servicioweb_proyectoPOO.dto.UsuarioLogin;
import com.producto.servicioweb_proyectoPOO.dto.rest.producto.Producto;
import com.producto.servicioweb_proyectoPOO.dto.rest.producto.ProductoDetalle;
import com.producto.servicioweb_proyectoPOO.dto.rest.producto.Usuario;
import com.producto.servicioweb_proyectoPOO.entidad.UsuarioEntidad;

@Repository
public class DaoImpl implements Dao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private Connection conexion;

	private void obtenerConexion() throws SQLException {
		conexion = jdbcTemplate.getDataSource().getConnection();
	}

	private void cerrarConexion() throws SQLException {
		conexion.commit();
		conexion.close();
		conexion = null;
	}
	
	//Perfil administrador
	public ProductoNuevo añadirProducto(ProductoNuevo productoNuevo) {
		try {
			obtenerConexion();
			String sql = "INSERT INTO producto(codigo_producto,codigo_talla,codigo_tipo_producto,nombre,tipo,genero,precio_unitario,color,marca,modelo,material,imagen)"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setInt(1, productoNuevo.getCodigoProducto());
			sentencia.setInt(2, productoNuevo.getCodigoTalla());
			sentencia.setInt(3, productoNuevo.getCodigoTipoProducto());
			sentencia.setString(4, productoNuevo.getNombre());
			sentencia.setString(5, productoNuevo.getTipo());
			sentencia.setString(6, productoNuevo.getGenero());
			sentencia.setDouble(7, productoNuevo.getPrecioUnitario());
			sentencia.setString(8, productoNuevo.getColor());
			sentencia.setString(9, productoNuevo.getMarca());
			sentencia.setString(10, productoNuevo.getModelo());
			sentencia.setString(11, productoNuevo.getMaterial());
			sentencia.setString(12, productoNuevo.getImagen());
			sentencia.executeUpdate();
			sentencia.close();
			cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productoNuevo;
	}

	// Perfil cliente
		// Cuando el cliente de click en un producto, saldrá más detallado el producto
	public ProductoDetalle mostrarProductoDetallado(Integer idProducto) {
		ProductoDetalle productoRetorno = null;
		try {
			obtenerConexion();
			String SQL = "SELECT pr.nombre,pr.tipo,pr.genero,pr.precio_unitario,pr.color,pr.marca,pr.modelo,pr.material,t.especificacion_talla,tpr.descripcion,pr.imagen"
					+ " FROM talla t JOIN producto pr ON(t.codigo_talla=pr.codigo_talla)"
					+ " JOIN tipoproducto tpr ON(pr.codigo_tipo_producto=tpr.codigo_tipo_producto)"
					+ " WHERE pr.codigo_producto = ? ";

			PreparedStatement sentencia = conexion.prepareStatement(SQL);
			sentencia.setInt(1, idProducto);
			ResultSet resultado = sentencia.executeQuery();

			while (resultado.next()) {
				productoRetorno = new ProductoDetalle();
				productoRetorno.setNombre(resultado.getString("nombre"));
				productoRetorno.setTipo(resultado.getString("tipo"));
				productoRetorno.setGenero(resultado.getString("genero"));
				productoRetorno.setPrecioUnitario(resultado.getDouble("precio_unitario"));
				productoRetorno.setColor(resultado.getString("color"));
				productoRetorno.setMarca(resultado.getString("marca"));
				productoRetorno.setModelo(resultado.getString("modelo"));
				productoRetorno.setMaterial(resultado.getString("material"));
				productoRetorno.setTalla(resultado.getString("especificacion_talla"));
				productoRetorno.setDescripcion(resultado.getString("descripcion"));
				productoRetorno.setImagen(resultado.getString("imagen"));
			}
			resultado.close();
			sentencia.close();
			cerrarConexion();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return productoRetorno;
	}

	public List<Producto> buscarProductosPorNombreBD(String nombreProducto) {
		List<Producto> lista = new ArrayList<Producto>();
		try {
			obtenerConexion();
			String SQL = "SELECT codigo_producto,nombre,precio_unitario,imagen" + " FROM producto" + " WHERE nombre LIKE ? ";

			PreparedStatement sentencia = conexion.prepareStatement(SQL);
			sentencia.setString(1, ("%" + nombreProducto + "%"));
			ResultSet resultado = sentencia.executeQuery();
			while (resultado.next()) {
				Producto producto = new Producto();
				producto = new Producto();
				producto.setIdProducto(resultado.getInt("codigo_producto"));
				producto.setNombre(resultado.getString("nombre"));
				producto.setPrecioUnitario(resultado.getDouble("precio_unitario"));
				producto.setImagen(resultado.getString("imagen"));
				lista.add(producto);
			}
			resultado.close();
			sentencia.close();
			cerrarConexion();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return lista;
	}

		// Para el muestreo de productos en la pagina web
	public List<Producto> obtenerProductos() {
		List<Producto> lista = new ArrayList<Producto>();
		try {
			obtenerConexion();
			Statement sentencia = conexion.createStatement();
			String SQL = "SELECT codigo_producto,nombre,precio_unitario,imagen FROM producto";
			ResultSet resultado = sentencia.executeQuery(SQL);

			while (resultado.next()) {
				Producto producto = new Producto();
				producto.setIdProducto(resultado.getInt("codigo_producto"));
				producto.setNombre(resultado.getString("nombre"));
				producto.setPrecioUnitario(resultado.getDouble("precio_unitario"));
				producto.setImagen(resultado.getString("imagen"));
				lista.add(producto);
			}
			resultado.close();
			sentencia.close();
			cerrarConexion();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return lista;
	}

	public UsuarioEntidad registrarUsuario(UsuarioEntidad usuario) {
		try {
			obtenerConexion();
			String sql = "INSERT INTO usuario(codigo_usuario,email,contraseña,nombres,apellidos,perfil)"
					+ " VALUES (?,?,?,?,?,?)";
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setInt(1, usuario.getCodigoUsuario());
			sentencia.setString(2, usuario.getEmail());
			sentencia.setString(3, usuario.getContraseña());
			sentencia.setString(4, usuario.getNombres());
			sentencia.setString(5, usuario.getApellidos());
			sentencia.setInt(6, usuario.getPerfil());
			sentencia.executeUpdate();
			sentencia.close();
			cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	public Integer existeUsuario(String email) {
		Integer filas = null;
		try {
			obtenerConexion();
			String sql = "SELECT COUNT(*)" + " FROM usuario" + " WHERE email = ?";
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, email);
			ResultSet resultado = sentencia.executeQuery();
			if (resultado.next()) {
				filas = resultado.getInt(1);
			}
			sentencia.close();
			cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filas;
	}
	
	public Usuario obtenerUsuario(String email) {
		Usuario respuestaUsuario = null;
		try {
			obtenerConexion();
			String sql = "SELECT codigo_usuario,email,nombres,apellidos,perfil" + " FROM usuario"
					+ " WHERE email = ?";
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, email);
			ResultSet resultado = sentencia.executeQuery();
			while (resultado.next()) {
				respuestaUsuario = new Usuario();
				respuestaUsuario.setId(resultado.getInt("codigo_usuario"));
				respuestaUsuario.setEmail(resultado.getString("email"));
				respuestaUsuario.setNombres(resultado.getString("nombres"));
				respuestaUsuario.setApellidos(resultado.getString("apellidos"));
				respuestaUsuario.setPerfil(resultado.getInt("perfil"));
			}
			sentencia.close();
			cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return respuestaUsuario;
	}

	public Integer obtenerMaximoCodigoUsuario() {
		Integer filas = null;
		try {
			obtenerConexion();
			Statement sentencia = conexion.createStatement();
			String SQL = "SELECT MAX(codigo_usuario)" + " FROM usuario";
			ResultSet resultado = sentencia.executeQuery(SQL);
			if (resultado.next()) {
				filas = resultado.getInt(1);
			}
			resultado.close();
			sentencia.close();
			cerrarConexion();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return filas;
	}
	
	public Usuario autenticarUsuario(UsuarioLogin usuarioLogin) {
		Usuario respuestaUsuario = null;
		try {
			obtenerConexion();
			String sql = "SELECT codigo_usuario,email,nombres,apellidos,perfil" + " FROM usuario"
					+ " WHERE email = ? AND contraseña = ?";
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, usuarioLogin.getEmail());
			sentencia.setString(2, usuarioLogin.getContraseña());
			ResultSet resultado = sentencia.executeQuery();
			while (resultado.next()) {
				respuestaUsuario = new Usuario();
				respuestaUsuario.setId(resultado.getInt("codigo_usuario"));
				respuestaUsuario.setEmail(resultado.getString("email"));
				respuestaUsuario.setNombres(resultado.getString("nombres"));
				respuestaUsuario.setApellidos(resultado.getString("apellidos"));
				respuestaUsuario.setPerfil(resultado.getInt("perfil"));
			}
			sentencia.close();
			cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return respuestaUsuario;
	}

}
