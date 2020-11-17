package dao.implDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Interfaces.TelefonoDAO;
import dao.negocio.Direccion;
import dao.negocio.Telefono;
import dao.negocio.Vuelo;
import dao.util.ConexionMySQL;

public class TelefonoDAOImplMySQL implements TelefonoDAO{

	ConexionMySQL sql = new ConexionMySQL();
	final String add = "INSERT INTO prog_avanzada.telefono (personal, celular, laboral) VALUES(?,?,?)";
	final String delete = "DELETE FROM prog_avanzada.telefono WHERE id_telefono = ?";
	final String update = "UPDATE prog_avanzada.telefono set personal = ?, celular = ?, laboral = ? WHERE id_telefono = ? ";
	final String ListAll = "SELECT * FROM prog_avanzada.telefono";
	final String get = "SELECT * FROM prog_avanzada.telefono WHERE id_telefono = ?";
	final static String OBTENERULTIMO = "SELECT * FROM prog_avanzada.telefono ORDER BY id_telefono DESC LIMIT 1";
	
	
	@Override
	public void addTelefono(Telefono telefono) {
		
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {		
			conexion = sql.getConnection();
			ps = conexion.prepareStatement(add);
			ps.setString(1, telefono.getPersona());
			ps.setString(2, telefono.getCelular());
			ps.setString(3, telefono.getLaboral());
			ps.executeUpdate();	
			} 
			catch (SQLException e) { e.printStackTrace();}
			finally {	
			try {ps.close();conexion.close();}
			catch(Exception e) {e.printStackTrace();}
		}
	}
		
	@Override
	public void deleteTelefono(String id_telefono) {
		Connection conexion = null;
		PreparedStatement ps = null;
		try {
		conexion = sql.getConnection();
		ps = conexion.prepareCall(delete);
		ps.setString(1, id_telefono);
		ps.executeUpdate();	
		conexion.close();
	} 
		catch (SQLException e) {e.printStackTrace();}
	}
	@Override
	public void updateTelefono(Telefono telefono) {
		
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {
			conexion = sql.getConnection();
			ps = conexion.prepareCall(update);

			ps.setString(1, telefono.getPersona());
			ps.setString(2, telefono.getCelular());
			ps.setString(3, telefono.getLaboral());
	
	     	ps.executeUpdate();
			conexion.close();
			} catch (SQLException e) {e.printStackTrace();}	
		}
	@Override
	public List<Telefono> ListAllTelefono() {
		Connection conexion = null;
		 PreparedStatement ps = null;
		 List<Telefono> lista= new ArrayList<>();
		 try {
		 conexion = sql.getConnection();
	     ps = conexion.prepareStatement(ListAll);
		 ResultSet rs = ps.executeQuery();    
		 while(rs.next()) {
			 
		String personal = (rs.getString("personal"));
		String celular = (rs.getString("celular"));
		String laboral = rs.getString("laboral");
				
		Telefono telefono = new Telefono(personal,celular,laboral);	
		lista.add(telefono);
	     }
			conexion.close();
					
	} catch (SQLException e) {e.printStackTrace();}
			return lista;	
	}
		
		
	
	@Override
	public Telefono getTelefono(String id_telefono) {
		
		Connection conexion = null;
	    PreparedStatement ps = null;	    
		try {	 
		conexion = sql.getConnection();
	    ps = conexion.prepareStatement(get);
	    ps.setString(1, id_telefono);
	    ResultSet rs = ps.executeQuery();
	
		while(rs.next()) {
			 
	    String personal = (rs.getString("personal"));
		String celular = (rs.getString("celular"));
		String laboral = rs.getString("laboral");
		
		Telefono telefono = new Telefono(personal,celular,laboral);	
		return telefono;	
	}
	conexion.close();
	} catch (SQLException e) {e.printStackTrace();}
	return null;
	}

	@Override
	public Telefono obtenerUltimo() {
		Connection conexion = null;
	    PreparedStatement ps = null;	    
		try {	 
		conexion = sql.getConnection();
	    ps = conexion.prepareStatement(OBTENERULTIMO);
	    ResultSet rs = ps.executeQuery();
	
		while(rs.next()) {
			 
	    String id = (rs.getString("id_telefono"));
		String personal = (rs.getString("personal"));
		String celular = (rs.getString("celular"));
		String laboral = rs.getString("laboral");
		
		Telefono telefono = new Telefono(Integer.parseInt(id), personal,celular,laboral);	
		return telefono;	
	}
	conexion.close();
	} catch (SQLException e) {e.printStackTrace();}
	return null;
	}
}
