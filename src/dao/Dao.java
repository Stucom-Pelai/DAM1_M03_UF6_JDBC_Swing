package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
	private Connection conn;
	private final static String HOST = "localhost";
	private final static Integer PORT = 3307;
	private final static String DBNAME = "dam1swingjdbc";
	private final static String DBUSER = "root";
	private final static String DBPWD = null;

	public static Connection getConnection() {
		try {
			System.out.println("Estableciendo conexión...");
			Connection c = DriverManager.getConnection("jdbc:mysql://"+HOST+":"+PORT + "/" + DBNAME, DBUSER, DBPWD);
			System.out.println("Conexión establecida...");
			return c;
		} catch (SQLException e) {
			System.err.println("[ERROR] No se ha podido establecer conexión");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
}
