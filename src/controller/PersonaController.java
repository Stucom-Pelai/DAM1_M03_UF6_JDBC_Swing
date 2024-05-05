package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.Dao;
import model.Persona;

public class PersonaController {
	//Fuente de información
	private ArrayList<Persona> personas;
	private Connection conexionSQL;
	
	public PersonaController() {
		//Establecemos conexión
		conexionSQL = Dao.getConnection();
		personas = new ArrayList<>();
	}
	public void addPersona(Persona p) {
		System.out.println("Se está añadiendo la persona " + p);
		//Hagamos la operación en SQL
		try {
			System.out.println("INSERTANDO UN ELEMENTO EN LA TABLA PERSONA...");
			System.out.println("INSERT INTO persona(dni,nombre,apellido) VALUES ('"+p.getDni()+"','"+p.getNombre()+"','"+p.getApellido()+"')");
			Statement st = conexionSQL.createStatement();
			st.executeUpdate("INSERT INTO persona(dni,nombre,apellido) VALUES ('"+p.getDni()+"','"+p.getNombre()+"','"+p.getApellido()+"')");
			System.out.println("PERSONA INSERTADA!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		personas.add(p);
	}
	/**
	 * Obtiene todas las personas que se apellidan de la misma forma
	 * @param apellidoBusqueda apellido a buscar
	 * */
	public ArrayList<Persona> selectPersonasPorApellido(String apellidoBusqueda){
		ArrayList<Persona> personasMismoApellido = new ArrayList<>();
		for(Persona persona : this.personas) {
			if(persona.getApellido().equals(apellidoBusqueda)) {
				personasMismoApellido.add(persona);
			}
		}
		return personasMismoApellido;
	}
	/**
	 * Seleccionar todas las personas de la BBDD y guardarlas en un ArrayList
	 * */
	public ArrayList<Persona> getPersonas() {
		personas = new ArrayList<>();
		try {
			Statement st = conexionSQL.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM persona");
			while(rs.next()) {
				int idPersona = rs.getInt("id_persona");
				String dni = rs.getString("dni");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				Persona p = new Persona(dni, nombre, apellido);
				p.setId(idPersona);
				//Agregamos al array una vez tengamos el objeto
				personas.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return personas;
	}
	
	public Persona getPersona(int indice) {
		return personas.get(indice);
	}

	public void setPersonas(ArrayList<Persona> personas) {
		this.personas = personas;
	}
	
	
}
