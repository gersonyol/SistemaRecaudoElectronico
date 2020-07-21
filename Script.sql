
/* Creación Base de Datos */
CREATE DATABASE bd_recargas;


/* Creación de tablas */
CREATE TABLE tbl_empleado (

id_empleado INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
nombre_empleado VARCHAR (50),
apellido_empleado VARCHAR (50),
edad_empleado INT,
user_empleado VARCHAR (35),
password_empleado VARCHAR (35),
id_tipo_empleado INT,
id_estado INT 

);

CREATE TABLE tbl_tipo_empleado (

id_tipo_empleado INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
nombre_tipo_empleado VARCHAR (35),
descripcion_tipo_empleado VARCHAR (35)

);

CREATE TABLE tbl_estado (

id_estado INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
nombre_estado VARCHAR (35),
descripcion_estado VARCHAR(35)

);


CREATE TABLE tbl_usuario (

id_usuario INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
nombre_usuario VARCHAR (50),
apellido_usuario VARCHAR (50),
celular_usuario INT,
user_usuario VARCHAR (35),
password_usuario VARCHAR (35),
id_empleado INT, 
id_tipo_usuario INT,
id_detalle_recarga INT 

);

CREATE TABLE tbl_tipo_usuario (

id_tipo_usuario INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
nombre_tipo_usuario VARCHAR (35),
descripcion_tipo_usuario VARCHAR (35)

);

CREATE TABLE tbl_detalle_recarga (

id_detalle_recarga INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
fecha_detalle_recarga DATE,
hora_detalle_recarga TIME,
id_recarga INT 

);

CREATE TABLE tbl_recarga (

id_recarga INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
cantidad_recarga INT,
descripcion_recarga VARCHAR (35)

);


/* Consulta INSERT INTO para ingresar datos en una tabla */
INSERT INTO tbl_tipo_empleado (nombre_tipo_empleado, descripcion_tipo_empleado)
VALUES
('Administrador', 'Administra a los empleados'),
('Empleado', 'Administra a los usuarios')

INSERT INTO tbl_estado (nombre_estado, descripcion_estado)
VALUES 
('Activo','Acceso al sistema'),
('Inactivo', 'Acceso restringido')

INSERT INTO tbl_tipo_usuario (nombre_tipo_usuario, descripcion_tipo_usuario)
VALUES 
('General', 'Personas en general'),
('Estudiante', 'Persona cursando sus estudios'),
('Adulto Mayor', 'Persona de 60 años en adelante'),
('Discapacitados', 'Persona con discapacidades fisicas')
 
INSERT INTO tbl_recarga (cantidad_recarga, descripcion_recarga)
VALUES
('5', 'Cinco quetzales'),
('10', 'Diez quetzales'),
('20', 'Veinte quetzales'),
('50', 'Cincuenta quetzales'),
('100', 'Cien quetzales')


/* Consulta SELECT para mostrar todos los registros de una tabla */
SELECT * FROM tbl_empleado;
SELECT * FROM tbl_usuario;

SELECT * FROM tbl_tipo_empleado;
SELECT * FROM tbl_estado;
SELECT * FROM tbl_tipo_usuario;
SELECT * FROM tbl_recarga; 

SELECT * FROM tbl_detalle_recarga;


/* Consulta DELETE para borrar registros de una tabla */
DELETE FROM tbl_empleado; 
DELETE FROM tbl_usuario;

DELETE FROM tbl_tipo_empleado;
DELETE FROM tbl_estado;
DELETE FROM tbl_tipo_usuario;
DELETE FROM tbl_recarga;

DELETE FROM tbl_detalle_recarga;


/* Consulta DROP para borrar una tabla */
DROP TABLE tbl_empleado; 
DROP TABLE tbl_usuario;

DROP TABLE tbl_tipo_empleado;
DROP TABLE tbl_estado;
DROP TABLE tbl_tipo_usuario;
DROP TABLE tbl_recarga;

DROP TABLE tbl_detalle_recarga;













