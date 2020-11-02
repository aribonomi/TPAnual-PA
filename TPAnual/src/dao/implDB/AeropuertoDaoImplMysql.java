package dao.implDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Interfaces.AeropuertoDAO;
import dao.negocio.Aeropuerto;
import dao.negocio.Direccion;
import dao.negocio.Vuelo;
import dao.util.ConexionMySQL;

public class AeropuertoDaoImplMysql implements AeropuertoDAO {

	ConexionMySQL sql = new ConexionMySQL();
	final String add = "INSERT INTO prog_avanzada.aeropuerto (codigo_aeropuerto, ciudad) VALUES(?,?)";
	final String delete = "DELETE FROM prog_avanzada.aeropuerto WHERE codigo_aeropuerto = ?";
	final String update = "UPDATE prog_avanzada.aeropuerto set codigo_aeropuerto = ?, ciudad = ? WHERE codigo_aeropuerto = ? ";
	final String ListAll = "SELECT * FROM prog_avanzada.aeropuerto";
	final String get = "SELECT * FROM prog_avanzada.aeropuerto WHERE codigo_aeropuerto = ?";
	
	@Override
	public void altaAeropuerto(Aeropuerto aeropuerto) {
		
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {		
			conexion = sql.getConnection();
			ps = conexion.prepareStatement(add);
			ps.setString(1, aeropuerto.getIdentificacion());
			ps.setString(2, aeropuerto.getCiudad());
			ps.executeUpdate();	
			} 
			catch (SQLException e) { e.printStackTrace();}
			finally {	
			try {ps.close();conexion.close();}
			catch(Exception e) {e.printStackTrace();}
		}
		
	}
		

	@Override
	public void bajaAeropuerto(String codigo_aeropuerto) {
		
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {
		conexion = sql.getConnection();
		ps = conexion.prepareCall(delete);
		ps.setString(1, codigo_aeropuerto);
		ps.executeUpdate();	
		conexion.close();
	} 
		catch (SQLException e) {e.printStackTrace();}
	}

	@Override
	public void modificacionAeropuerto(Aeropuerto aeropuerto) {
		
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {
			conexion = sql.getConnection();
			ps = conexion.prepareCall(update);
			ps.setString(1, aeropuerto.getIdentificacion());
			ps.setString(2, aeropuerto.getCiudad());
		

	     	ps.executeUpdate();
			conexion.close();
			} catch (SQLException e) {e.printStackTrace();}	
		}

	@Override
	public List<Aeropuerto> ListAllAeropuerto() {
		
	Connection conexion = null;
	PreparedStatement ps = null;
	List<Aeropuerto> lista= new ArrayList<>();
		 try {
		 conexion = sql.getConnection();
	     ps = conexion.prepareStatement(ListAll);
		 ResultSet rs = ps.executeQuery();    
		 while(rs.next()) {
			 
		String identificador = (rs.getString(("numero_vuelo")));
		String ciudad = (rs.getString("ciudad"));
			   
		Aeropuerto aeropuerto = new Aeropuerto(identificador,ciudad,null,null);
		 lista.add(aeropuerto);
	     }
			conexion.close();
					
	} catch (SQLException e) {e.printStackTrace();}
			return lista;	
	}
		


	@Override
	public Aeropuerto getAeropuerto(String codigo_aeropuerto) {
		

		Connection conexion = null;
	    PreparedStatement ps = null;	    
		try {	 
		conexion = sql.getConnection();
	    ps = conexion.prepareStatement(get);
	    ps.setString(1, codigo_aeropuerto);
	    ResultSet rs = ps.executeQuery();
			    
		while(rs.next()) {
			 
		String identificador = (rs.getString(("numero_vuelo")));
	    String ciudad = (rs.getString("ciudad"));
	   
		Aeropuerto aeropuerto = new Aeropuerto(identificador,ciudad,null,null);
		return aeropuerto;
	}
	conexion.close();
	} catch (SQLException e) {e.printStackTrace();}
	return null;}

}
