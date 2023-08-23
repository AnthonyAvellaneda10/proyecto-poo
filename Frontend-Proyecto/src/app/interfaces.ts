export interface Producto {
	idProducto?: number;
    marca?:string;
    nombre?: string;
    precioUnitario?: number;
    imagen?: string;
}

export interface RespuestaProducto {
	productos: Producto[];
}

export interface ProductoDetallado{
	nombre?: string;
	tipo?: string;
	genero?: string;
	precioUnitario?: number;
	color?: string;
	marca?: string;
	modelo?: string;
	material?: string;
	talla?: string;
	descripcion?: string;
	imagen?: string;
}

export interface Usuario{
    id?: number;
	email?:string;
	nombres?:string;
	apellidos?:string;
	perfil?: number;
}

export interface UsuarioLogin{
    email?:string;
	contraseña?:string;
}

export interface UsuarioNuevo{
    email?:string;
	contraseña?:string;
	nombres?:string;
	apellidos?:string;
}