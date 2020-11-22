package dao.implDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Factory.Factory;
import dao.Interfaces.*;
import dao.negocio.*;
import dao.util.ConexionMySQL;

public class AeropuertoDaoImplMysql implements AeropuertoDAO {

	ConexionMySQL sql = new ConexionMySQL();
	
	PaisDAO paisDAO = new Factory().getPaisDao();
	ProvinciaDAO provinciaDAO = new Factory().getProvinciaDaoImplMysql();
	
	final String add = "INSERT INTO prog_avanzada.aeropuerto (codigo_aeropuerto, ciudad, id_pais, id_provincia) VALUES(?,?,?,?)";
	final String delete = "DELETE FROM prog_avanzada.aeropuerto WHERE id_aeropuerto = ?";
	final String update = "UPDATE prog_avanzada.aeropuerto set codigo_aeropuerto = ?, ciudad = ? WHERE id_aeropuerto = ? ";
	final String ListAll = "SELECT * FROM prog_avanzada.aeropuerto";
	final String get = "SELECT * FROM prog_avanzada.aeropuerto WHERE id_aeropuerto = ?";
	final static String CONSULTAPORCODIGO = "SELECT * FROM prog_avanzada.aeropuerto WHERE codigo_aeropuerto = ?";
	final static String OBTENERCODIGOS = "SELECT codigo_aeropuerto FROM prog_avanzada.aeropuerto";
	
	
	@Override
	public void altaAeropuerto(Aeropuerto aeropuerto) {
		
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {		
			conexion = sql.getConnection();
			ps = conexion.prepareStatement(add);
			ps.setString(1, aeropuerto.getIdentificacion());
			ps.setString(2, aeropuerto.getCiudad());
			ps.setInt(3, aeropuerto.getPais().getId_pais());
			ps.setInt(4, aeropuerto.getProvincia().getId_provincia());
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
			ps.setInt(3, aeropuerto.getId_Aeropuerto());
		

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
	public Aeropuerto getAeropuerto(Integer id_aeropuerto) {
		

		Connection conexion = null;
	    PreparedStatement ps = null;	    
		try {	 
		conexion = sql.getConnection();
	    ps = conexion.prepareStatement(get);
	    ps.setInt(1, id_aeropuerto);
	    ResultSet rs = ps.executeQuery();
			    
		while(rs.next()) {
		Integer id = rs.getInt("id_aeropuerto");	 
		String codigo = (rs.getString(("codigo_aeropuerto")));
	    String ciudad = (rs.getString("ciudad"));
	    Integer id_pais = rs.getInt("id_pais");
	    Integer id_provincia = rs.getInt("id_provincia");
	    
	    Pais pais = paisDAO.getPaisPorID(id_pais);
	    Provincia provincia = provinciaDAO.getProvincia(id_provincia.toString());
	   
		Aeropuerto aeropuerto = new Aeropuerto(id, codigo, ciudad,pais,provincia);
		return aeropuerto;
	}
	conexion.close();
	} catch (SQLException e) {e.printStackTrace();}
	return null;}


	@Override
	public Aeropuerto consultaPorCodigo(String codigo_aeropuerto) {
		Connection conexion = null;
	    PreparedStatement ps = null;	    
		try {	 
			conexion = sql.getConnection();
		    ps = conexion.prepareStatement(CONSULTAPORCODIGO);
		    ps.setString(1, codigo_aeropuerto);
		    ResultSet rs = ps.executeQuery();
				    
			while(rs.next()) {
				Integer id = rs.getInt("id_aeropuerto");	 
				String codigo = (rs.getString(("codigo_aeropuerto")));
			    String ciudad = (rs.getString("ciudad"));
			    Integer id_pais = rs.getInt("id_pais");
			    Integer id_provincia = rs.getInt("id_provincia");
			    
			    Pais pais = paisDAO.getPaisPorID(id_pais);
			    Provincia provincia = provinciaDAO.getProvincia(id_provincia.toString());
			   
				Aeropuerto aeropuerto = new Aeropuerto(id, codigo, ciudad,pais,provincia);
				return aeropuerto;
		}
		conexion.close();
	} catch (SQLException e) {e.printStackTrace();}
	return null;
	}


	@Override
	public List<String> obtenerCodigos() {
		Connection conexion = null;
		PreparedStatement ps = null;
		List<String> codigos= new ArrayList<>();
			 try {
				 conexion = sql.getConnection();
			     ps = conexion.prepareStatement(OBTENERCODIGOS);
				 ResultSet rs = ps.executeQuery();    
				 while(rs.next()) {
					 
					String codigo = rs.getString("codigo_aeropuerto");
					codigos.add(codigo);
			     }
			conexion.close();
						
			} catch (SQLException e) {e.printStackTrace();}
			return codigos;	
	}

}
