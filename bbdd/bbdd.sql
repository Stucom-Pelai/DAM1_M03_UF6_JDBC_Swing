CREATE DATABASE dam1swingjdbc;
USE dam1swingjdbc;

CREATE TABLE Persona(
	id_persona INTEGER AUTO_INCREMENT PRIMARY KEY,
    dni VARCHAR(9) NOT NULL UNIQUE KEY,
    nombre VARCHAR(50) NULL,
    apellido VARCHAR(50) NULL
);
CREATE TABLE Pelicula(
	id_pelicula INTEGER AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    genero VARCHAR(100) NOT NULL,
    anyo DATE,
	id_persona INTEGER,
    FOREIGN KEY (id_persona) REFERENCES persona(id_persona)
);