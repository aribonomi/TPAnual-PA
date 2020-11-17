package dao.implDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Interfaces.ProvinciaDAO;
import dao.negocio.Provincia;
import dao.negocio.Telefono;
import dao.util.ConexionMySQL;

public class ProvinciaDAOImplMySQL implements ProvinciaDAO{

	ConexionMySQL sql = new ConexionMySQL();
	final String add = "INSERT INTO prog_avanzada.provincia (nombre_provincia) VALUES(?)";
	final String delete = "DELETE FROM prog_avanzada.provincia WHERE id_provincia = ?";
	final String update = "UPDATE prog_avanzada.provincia set nombre_provincia = ? WHERE id_provincia = ? ";
	final String ListAll = "SELECT * FROM prog_avanzada.provincia";
    final String get = "SELECT * FROM prog_avanzada.provincia WHERE id_provincia = ?";
	
	@Override
	public void addProvincia(Provincia provincia) {
		
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {		
			conexion = sql.getConnection();
			ps = conexion.prepareStatement(add);
			ps.setString(1, provincia.getNombreProvincia());
			ps.executeUpdate();	
					} 
			catch (SQLException e) { e.printStackTrace();}
		finally {	
			try {ps.close();conexion.close();}
			catch(Exception e) {e.printStackTrace();}
		}
		
	}

	@Override
	public void deleteProvincia(String nombre_provincia) {
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {
		conexion = sql.getConnection();
		ps = conexion.prepareCall(delete);
		ps.setString(1, nombre_provincia);
		ps.executeUpdate();	
		conexion.close();
	} 
		catch (SQLException e) {e.printStackTrace();}
	}

	@Override
	public void updateProvincia(Provincia provincia) {
		
		Connection conexion = null;
		PreparedStatement ps = null;
		try {
			conexion = sql.getConnection();
			ps = conexion.prepareCall(update);
			ps.setString(1, provincia.getNombreProvincia());
			
	     	ps.executeUpdate();
			conexion.close();
			} catch (SQLException e) {e.printStackTrace();}	
		}
	
	@Override
	public List<Provincia> ListAllProvincia() {
		Connection conexion = null;
		 PreparedStatement ps = null;
		 List<Provincia> lista= new ArrayList<>();
		 try {
		 conexion = sql.getConnection();
	     ps = conexion.prepareStatement(ListAll);
		 ResultSet rs = ps.executeQuery();    
		 while(rs.next()) {
			 
		String nombre_p = (rs.getString("nombre_provincia"));
		Provincia provincia = new Provincia(nombre_p);	
		
		 lista.add(provincia);
	     }
			conexion.close();
					
	} catch (SQLException e) {e.printStackTrace();}
			return lista;	
	}
	@Override
	public Provincia getProvincia(String nombre_provincia) {
		
		Connection conexion = null;
	    PreparedStatement ps = null;	    
		try {	 
		conexion = sql.getConnection();
	    ps = conexion.prepareStatement(get);
	    ps.setString(1, nombre_provincia);
	    ResultSet rs = ps.executeQuery();
		while(rs.next()) {
	    String nombre_p = (rs.getString("nombre_provincia"));
		Provincia provincia = new Provincia(nombre_p);	
		return provincia;	
	}
	conexion.close();
	} catch (SQLException e) {e.printStackTrace();}
	return null;
	}

	@Override
	public List<String> obtenerNombres() {
		Connection conexion = null;
		PreparedStatement ps = null;
		List<String> lista= new ArrayList<>();
		try {
			conexion = sql.getConnection();
		    ps = conexion.prepareStatement(ListAll);
			ResultSet rs = ps.executeQuery();    
			while(rs.next()) {
				 
			String nombre_p = (rs.getString("nombre_provincia"));
			
			lista.add(nombre_p);
		    }
			conexion.close();
					
		} catch (SQLException e) {e.printStackTrace();}
		return lista;	
	}


}
