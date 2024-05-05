package controller;

import java.sql.Connection;
import java.util.ArrayList;

import dao.Dao;
import model.Pelicula;

public class FilmController {
	private ArrayList<Pelicula> peliculas;
	private Connection conexionSQL;
	
	public FilmController() {
		//Establecemos conexión
		conexionSQL = Dao.getConnection();
		
	}
}
