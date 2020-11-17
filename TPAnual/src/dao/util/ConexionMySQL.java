package dao.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ConexionMySQL {

public Connection getConnection() {
	
	try {
		//Properties prop = new Properties();
		//InputStream input = new FileInputStream("resources/connection.properties");
		//prop.load(input);
		
//		Class.forName(prop.getProperty("db.driver"));
//		Connection con = DriverManager.getConnection(prop.getProperty("db.url"), prop.getProperty("db.user"), 
//				prop.getProperty("db.password"));
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prog_avanzada", "root", "42472339");
		if(!con.isClosed()) {
			System.out.println("Conexión establecida");
		}
		return con;
		
		
	}catch(SQLException /*FileNotFoundException*/ e) {
		System.out.println("No se pudo establecer conexión con la base de datos");
		e.printStackTrace();
	}catch(ClassNotFoundException e) {
		System.out.println("No se encontró el driver");
		e.printStackTrace();
	}//catch(IOException e) {
//		System.out.println("No se pudo encontrar el archivo properties");
//		e.printStackTrace();
//	}
	return null;
}
}