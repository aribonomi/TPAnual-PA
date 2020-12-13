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

//Conexión a mysql	
	ConexionMySQL sql = new ConexionMySQL();
	
//Statements	
	final String add = "INSERT INTO prog_avanzada.telefono (personal, celular, laboral) VALUES(?,?,?)";
	final String delete = "DELETE FROM prog_avanzada.telefono WHERE id_telefono = ?";
	final String update = "UPDATE prog_avanzada.telefono set personal = ?, celular = ?, laboral = ? WHERE id_telefono = ? ";
	final String ListAll = "SELECT * FROM prog_avanzada.telefono";
	final String get = "SELECT * FROM prog_avanzada.telefono WHERE id_telefono = ?";
	final String OBTENERULTIMO = "SELECT * FROM prog_avanzada.telefono ORDER BY id_telefono DESC LIMIT 1";
	
	
	@Override
	public void addTelefono(Telefono telefono) {
		
	//Realizo la conexión	
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {		
			conexion = sql.getConnection();
			ps = conexion.prepareStatement(add);
			
		//Seteo los parámetros	
			ps.setString(1, telefono.getPersona());
			ps.setString(2, telefono.getCelular());
			ps.setString(3, telefono.getLaboral());
			ps.executeUpdate();	
			} 
		catch (SQLException e) { e.printStackTrace();}
	//Cierro la conexión		
		finally {	
			try {ps.close();conexion.close();}
			catch(Exception e) {e.printStackTrace();}
		}
	}
		
	@Override
	public void deleteTelefono(String id_telefono) {
		
	//Realizo la conexión	
		Connection conexion = null;
		PreparedStatement ps = null;
		try {
			conexion = sql.getConnection();
			ps = conexion.prepareCall(delete);
			
		//Seteo el parámetro	
			ps.setString(1, id_telefono);
			ps.executeUpdate();	
			
		//Cierro la conexión	
			conexion.close();
		}catch (SQLException e) {e.printStackTrace();}
	}
	
	@Override
	public void updateTelefono(Telefono telefono) {
		
	//Realizo la conexión	
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {
			conexion = sql.getConnection();
			ps = conexion.prepareCall(update);

		//Seteo los parámetros	
			ps.setString(1, telefono.getPersona());
			ps.setString(2, telefono.getCelular());
			ps.setString(3, telefono.getLaboral());
			ps.setInt(4, telefono.getId_Telefono());
			
	     	ps.executeUpdate();
	     	
	     //Cierro la conexión	
			conexion.close();
			} catch (SQLException e) {e.printStackTrace();}	
		}
	
	
	@Override
	public List<Telefono> ListAllTelefono() {
		
	//Realizo la conexión	
		Connection conexion = null;
		PreparedStatement ps = null;
		List<Telefono> lista= new ArrayList<>();
		try {
			conexion = sql.getConnection();
		    ps = conexion.prepareStatement(ListAll);
			ResultSet rs = ps.executeQuery();    
			while(rs.next()) {
			
			//Obtengo los datos y creo el objeto teléfono		
				String personal = (rs.getString("personal"));
				String celular = (rs.getString("celular"));
				String laboral = rs.getString("laboral");
						
				Telefono telefono = new Telefono(personal,celular,laboral);	
			//Agrego el teléfono a la lista	
				lista.add(telefono);
		    }
			conexion.close();
						
		} catch (SQLException e) {e.printStackTrace();}
			return lista;	
	}
		
		
	
	@Override
	public Telefono getTelefono(String id_telefono) {
		
	//Realizo la conexión	
		Connection conexion = null;
	    PreparedStatement ps = null;	    
		try {	 
			conexion = sql.getConnection();
		    ps = conexion.prepareStatement(get);
		    
		//Seteo el parámetro    
		    ps.setString(1, id_telefono);
		    ResultSet rs = ps.executeQuery();
		
			while(rs.next()) {
				 
			//Obtengo los datos y creo el objeto teléfono	
				Integer id = rs.getInt("id_telefono");	
			    String personal = (rs.getString("personal"));
				String celular = (rs.getString("celular"));
				String laboral = rs.getString("laboral");
				
				Telefono telefono = new Telefono(id,personal,celular,laboral);	
				return telefono;	
		}
		conexion.close();
		} catch (SQLException e) {e.printStackTrace();}
	return null;
	}

	@Override
	public Telefono obtenerUltimo() {
		
	//Realizo la conexión	
		Connection conexion = null;
	    PreparedStatement ps = null;	    
		try {	 
			conexion = sql.getConnection();
		    ps = conexion.prepareStatement(OBTENERULTIMO);
		    ResultSet rs = ps.executeQuery();
		
			while(rs.next()) {
			
			//Obtengo los datos y creo el objeto teléfono	
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
