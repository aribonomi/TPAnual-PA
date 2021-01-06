package dao.implDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Factory.Factory;

import java.sql.Date;

import dao.Interfaces.PaisDAO;
import dao.Interfaces.PasaporteDAO;
import dao.negocio.Pais;
import dao.negocio.Pasaporte;
import dao.negocio.Provincia;
import dao.util.ConexionMySQL;

public class PasaporteDAOImplMySQL implements PasaporteDAO{
	
//Conexión a mysql	
	ConexionMySQL sql = new ConexionMySQL();
    
	
//Statements	
	final String add = "INSERT INTO prog_avanzada.pasaporte (numero_pasaporte,autoridad_emision,fecha_emision,fecha_vencimiento, id_pais) VALUES(?,?,?,?,?)";
	final String delete = "DELETE FROM prog_avanzada.pasaporte WHERE id_pasaporte = ?";
	final String update = "UPDATE prog_avanzada.pasaporte set numero_pasaporte = ? , autoridad_emision = ?, fecha_emision = ?, fecha_vencimiento = ? WHERE id_pasaporte = ? ";
	final String ListAll = "SELECT * FROM prog_avanzada.pasaporte";
    final String get = "SELECT * FROM prog_avanzada.pasaporte WHERE id_pasaporte = ?";
    final String OBTENERULTIMO = "SELECT * FROM prog_avanzada.pasaporte ORDER BY id_pasaporte DESC LIMIT 1";
    
	@Override
	public boolean addPasaporte(Pasaporte pasaporte) {
		
	//Realizo la conexión	
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {		
			conexion = sql.getConnection();
			ps = conexion.prepareStatement(add);
			
		//Seteo los parámetros	
			ps.setString(1, pasaporte.getNumero());
			ps.setString(2, pasaporte.getAutoridadEmision());
			ps.setString(3, pasaporte.getFechaEmision());
			ps.setString(4, pasaporte.getFechaVencimiento());
			ps.setInt(5, pasaporte.getPaisEmision().getId_pais());
			ps.executeUpdate();	
			
			return true;
		}catch (SQLException e) {
			e.printStackTrace(); 
			return false;
		}
	//Cierro la conexión	
		finally {	
			try {ps.close();conexion.close();}
			catch(Exception e) {e.printStackTrace();}
		}
		
	}
	@Override
	public boolean deletePasaporte(String numero_pasaporte) {
		
	//Realizo la conexión	
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {
		conexion = sql.getConnection();
		ps = conexion.prepareCall(delete);
		
	//Seteo el parámetro	
		ps.setInt(1, Integer.parseInt(numero_pasaporte));
		ps.executeUpdate();	
	//Cierro la conexión	
		conexion.close();
		
		return true;
		}catch (SQLException e) {
			e.printStackTrace(); 
			return false;
		}
	}
	
	@Override
	public boolean updatePasaporte(Pasaporte pasaporte) {
		
	//Realizo la conexión	
		Connection conexion = null;
		PreparedStatement ps = null;
		try {
			conexion = sql.getConnection();
			ps = conexion.prepareCall(update);
			
		//Seteo los parámetros	
			ps.setString(1, pasaporte.getNumero());
			ps.setString(2, pasaporte.getAutoridadEmision());
			ps.setString(3, pasaporte.getFechaEmision());
			ps.setString(4, pasaporte.getFechaVencimiento());
			ps.setInt(5, pasaporte.getId_Pasaporte());
			
	     	ps.executeUpdate();
	     	
	     //Cierro la conexión	
			conexion.close();
			
			return true;
		}catch (SQLException e) {
			e.printStackTrace(); 
			return false;
		}
		}
		
	@Override
	public List<Pasaporte> ListAllPasaporte() {
		
	//Realizo la conexión	
		Connection conexion = null;
		PreparedStatement ps = null;
		List<Pasaporte> lista= new ArrayList<>();
		try {
			conexion = sql.getConnection();
		    ps = conexion.prepareStatement(ListAll);
			ResultSet rs = ps.executeQuery();    
			while(rs.next()) {
				 
			//Obtengo los datos y creo el objeto pasaporte	
				String numero = (rs.getString("nombre_pasaporte"));
				String autoridadEmision = (rs.getString("autoridad_emision"));
				String fecha_emision = (rs.getString("fecha_emision"));
				String fecha_vencimiento = (rs.getString("fecha_vencimiento"));
				Pasaporte pasaporte = new Pasaporte(numero,autoridadEmision,fecha_emision,fecha_vencimiento,null);
				
			//Agrego el pasaporte a la lista	
				lista.add(pasaporte);
		    }
			conexion.close();
						
		}catch (SQLException e) {e.printStackTrace();}
			return lista;	
	}
	
	@Override
	public Pasaporte getPasaporte(String numero_pasaporte) {
		
	//Realizo la conexión	
		Connection conexion = null;
	    PreparedStatement ps = null;	    
		try {	 
			conexion = sql.getConnection();
		    ps = conexion.prepareStatement(get);
		    ps.setString(1, numero_pasaporte);
		    ResultSet rs = ps.executeQuery();
			while(rs.next()) {
		
			//Obtengo los datos y creo el objeto pasaporte	
				Integer id = rs.getInt("id_pasaporte");	
			    String numero = (rs.getString("numero_pasaporte"));
			    String autoridadEmision = (rs.getString("autoridad_emision"));
			    String fecha_emision = (rs.getString("fecha_emision"));
			    String fecha_vencimiento = (rs.getString("fecha_vencimiento"));
			    Integer id_pais = rs.getInt("id_pais");
			    
			//Creo el objeto país solo con su id para después obtener el resto de los datos en el mvc
			    Pais pais = new Pais(id_pais, null);
		
				Pasaporte pasaporte = new Pasaporte(id,numero,autoridadEmision,fecha_emision,fecha_vencimiento,pais);
				return pasaporte;	
			}
		//Cierro la conexión	
			conexion.close();
		} catch (SQLException e) {e.printStackTrace();}
		return null;
	}
	
	
	@Override
	public Pasaporte obtenerUltimo() {
		
	//Realizo la conexión	
		Connection conexion = null;
	    PreparedStatement ps = null;	    
		try {	 
			conexion = sql.getConnection();
		    ps = conexion.prepareStatement(OBTENERULTIMO);
		    ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
			//Obtengo los datos y creo el objeto	
				String id = rs.getString("id_pasaporte");
			    String numero = (rs.getString("numero_pasaporte"));
			    String autoridadEmision = (rs.getString("autoridad_emision"));
			    String fecha_emision = (rs.getString("fecha_emision"));
			    String fecha_vencimiento = (rs.getString("fecha_vencimiento"));
			    Integer id_pais = rs.getInt("id_pais");
			    
			//Creo el objeto país solo con su id para después obtener el resto de los datos en el mvc
			    Pais pais = new Pais(id_pais, null);
		
				Pasaporte pasaporte = new Pasaporte(Integer.parseInt(id), numero,autoridadEmision,fecha_emision,fecha_vencimiento,pais);
				return pasaporte;	
		}
		conexion.close();
		} catch (SQLException e) {e.printStackTrace();}
	return null;
	}

	

}
