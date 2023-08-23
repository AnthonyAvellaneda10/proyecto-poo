CREATE DATABASE proyecto_poo;

USE proyecto_poo;

CREATE TABLE tipoProducto(
	codigo_tipo_producto NUMERIC(8) PRIMARY KEY,
	descripcion VARCHAR(120)
);

CREATE TABLE talla(
	codigo_talla NUMERIC(8) PRIMARY KEY,
	especificacion_talla VARCHAR(5)
);

CREATE TABLE producto(
	codigo_producto NUMERIC(9) PRIMARY KEY,
	codigo_talla NUMERIC(8),
	codigo_tipo_producto NUMERIC(8),
	nombre VARCHAR(100),
	tipo VARCHAR(50),
	genero VARCHAR(50),
	precio_unitario NUMERIC(7,2),
	color VARCHAR(30),
	marca VARCHAR(30),
	modelo VARCHAR(30),
	material VARCHAR(30),
	imagen VARCHAR(500)
);

ALTER TABLE producto ADD FOREIGN KEY (codigo_talla) 
REFERENCES talla(codigo_talla);

ALTER TABLE producto ADD FOREIGN KEY (codigo_tipo_producto) 
REFERENCES tipoproducto(codigo_tipo_producto);

INSERT INTO tipoproducto(codigo_tipo_producto,descripcion) VALUES(1,'Composición 95% Algodón 5% Elastano');
INSERT INTO tipoproducto(codigo_tipo_producto,descripcion) VALUES(2,'Para la temporada Primavera-Verano');
INSERT INTO tipoproducto(codigo_tipo_producto,descripcion) VALUES(3,'Ideal para que tengas dulces sueños');
INSERT INTO tipoproducto(codigo_tipo_producto,descripcion) VALUES(4,'Ideal para tus clases de Ballet');
INSERT INTO tipoproducto(codigo_tipo_producto,descripcion) VALUES(5,'Para la temporada Otoño-Invierno');
INSERT INTO tipoproducto(codigo_tipo_producto,descripcion) VALUES(6,'Estilo casual');

INSERT INTO talla(codigo_talla,especificacion_talla) VALUES(1,'S');
INSERT INTO talla(codigo_talla,especificacion_talla) VALUES(2,'M');
INSERT INTO talla(codigo_talla,especificacion_talla) VALUES(3,'L');
INSERT INTO talla(codigo_talla,especificacion_talla) VALUES(4,'28');
INSERT INTO talla(codigo_talla,especificacion_talla) VALUES(5,'30');
INSERT INTO talla(codigo_talla,especificacion_talla) VALUES(6,'32');
INSERT INTO talla(codigo_talla,especificacion_talla) VALUES(7,'40');
INSERT INTO talla(codigo_talla,especificacion_talla) VALUES(8,'41');
INSERT INTO talla(codigo_talla,especificacion_talla) VALUES(9,'42');

INSERT INTO producto(codigo_producto,codigo_talla,codigo_tipo_producto,nombre,tipo,genero,precio_unitario,color,marca,modelo,material,imagen)
VALUES(1,9,2,'Zapatos Formales Hombre Newport Manchester','Zapatos formales','Hombre',99.90,'Negro','NEWPORT','MANCHESTER NE','Sintético','assets/imagenes/productos/ZapatoNegro.jpg');
INSERT INTO producto(codigo_producto,codigo_talla,codigo_tipo_producto,nombre,tipo,genero,precio_unitario,color,marca,modelo,material,imagen)
VALUES(2,3,1,'Polo Manga Corta Mujer Sybilla','Polos','Mujer',29.90,'Blanco','Sybilla','M1POS116NO','Algodón','assets/imagenes/productos/PoloBlanco.jpg');
INSERT INTO producto(codigo_producto,codigo_talla,codigo_tipo_producto,nombre,tipo,genero,precio_unitario,color,marca,modelo,material,imagen)
VALUES(3,1,3,'Polo Manga Larga Niña','Polos','Niña',19.90,'Marfil','ELEVEN','BSCPOLOFPMLGT','Algodón','assets/imagenes/productos/PoloMarfil.jpg');
INSERT INTO producto(codigo_producto,codigo_talla,codigo_tipo_producto,nombre,tipo,genero,precio_unitario,color,marca,modelo,material,imagen)
VALUES(4,5,4,'Zapatos Niña Coniglio Bal Apli Rs','Ballerinas','Niña',79.90,'Rosa','Coniglio','BAL APLI RS','Tela','assets/imagenes/productos/ZapatoRosa.jpg');
INSERT INTO producto(codigo_producto,codigo_talla,codigo_tipo_producto,nombre,tipo,genero,precio_unitario,color,marca,modelo,material,imagen)
VALUES(5,2,6,'Polera Mujer Newport','Poleras','Mujer',49.50,'Guinda','	Newport','BSCPLN360NI','Poliéster','assets/imagenes/productos/PoleraGuinda.jpg');
INSERT INTO producto(codigo_producto,codigo_talla,codigo_tipo_producto,nombre,tipo,genero,precio_unitario,color,marca,modelo,material,imagen)
VALUES(6,3,5,'Polera Hombre','Poleras','Hombre',99.90,'Verde Oliva','Doo Australia','SSH TRAIL W21','Algodón','assets/imagenes/productos/PoleraVerdeOliva.jpg');

SELECT pr.nombre,pr.genero,pr.precio_unitario,pr.color,t.especificacion_talla,tpr.descripcion 
FROM talla t JOIN producto pr ON(t.codigo_talla=pr.codigo_talla)
JOIN tipoproducto tpr ON(pr.codigo_tipo_producto=tpr.codigo_tipo_producto)
WHERE pr.nombre LIKE '%polera%';

SELECT pr.nombre,pr.tipo,pr.genero,pr.precio_unitario,pr.color,pr.marca,pr.modelo,pr.material,t.especificacion_talla,tpr.descripcion,pr.imagen
FROM talla t JOIN producto pr ON(t.codigo_talla=pr.codigo_talla)
JOIN tipoproducto tpr ON(pr.codigo_tipo_producto=tpr.codigo_tipo_producto)
WHERE pr.codigo_producto = 1;

SELECT nombre,precio_unitario,imagen 
FROM producto
WHERE nombre LIKE '%polo%';


CREATE TABLE usuario(
	codigo_usuario NUMERIC(9) PRIMARY KEY,
	email VARCHAR(200),
	contraseña VARCHAR(100),
	nombres VARCHAR(150),
	apellidos VARCHAR(150),
	perfil NUMERIC(3)
);

INSERT INTO usuario(codigo_usuario,email,contraseña,nombres,apellidos,perfil) 
VALUES(1,'correo@gmail.com','123','Anthony', 'Avellaneda', 2);
INSERT INTO usuario(codigo_usuario,email,contraseña,nombres,apellidos,perfil) 
VALUES(2,'correo2@gmail.com','12','Jean', 'Avellaneda', 2);
