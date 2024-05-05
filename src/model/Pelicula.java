package model;

import java.util.Date;

public class Pelicula {
	private int id_pelicula;
	private String titulo;
	private String genero;
	private Date fecha;
	private int id_director;
	

	public Pelicula(String titulo, String genero, Date fecha, int id_director) {
		super();
		this.titulo = titulo;
		this.genero = genero;
		this.fecha = fecha;
		this.id_director = id_director;
	}
	public int getId_pelicula() {
		return id_pelicula;
	}
	public void setId_pelicula(int id_pelicula) {
		this.id_pelicula = id_pelicula;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getId_director() {
		return id_director;
	}
	public void setId_director(int id_director) {
		this.id_director = id_director;
	}
	@Override
	public String toString() {
		return "Pelicula [id_pelicula=" + id_pelicula + ", titulo=" + titulo + ", genero=" + genero + ", fecha=" + fecha
				+ ", id_director=" + id_director + "]";
	}
}
