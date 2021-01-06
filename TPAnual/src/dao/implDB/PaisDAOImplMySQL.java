package dao.implDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Interfaces.PaisDAO;
import dao.negocio.Pais;
import dao.negocio.PasajeroFrecuente;
import dao.negocio.Vuelo;
import dao.util.ConexionMySQL;

public class PaisDAOImplMySQL implements PaisDAO{

//Conexión a mysql    
	ConexionMySQL sql = new ConexionMySQL();
	
//Statements	
	final String add = "INSERT INTO prog_avanzada.pais (nombre_pais) VALUES(?)";
	final String delete = "DELETE FROM prog_avanzada.pais WHERE id_pais = ?";
	final String update = "UPDATE prog_avanzada.pais set nombre_pais = ? WHERE id_pais = ? ";
    final String ListAll = "SELECT * FROM prog_avanzada.pais";
	final String get = "SELECT * FROM prog_avanzada.pais WHERE nombre_pais = ?";
	final String OBTENERID = "SELECT id_pais FROM prog_avanzada.pais WHERE nombre_pais = ? LIMIT 1";	
	final String GETPAISPORID = "SELECT * FROM prog_avanzada.pais WHERE id_pais = ?";
	
	
	@Override
	public boolean addPais(Pais pais) {
		
	//Realizo la conexión
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {		
			conexion = sql.getConnection();
			ps = conexion.prepareStatement(add);
			
		//Seteo el parámetro	
			ps.setString(1, pais.getNombrePais());
			ps.executeUpdate();	
			
			return true;
		}catch (SQLException e) {
			e.printStackTrace(); 
			return false;
		}finally {	
		//cierro la conexión		
			try {ps.close();conexion.close();}
			catch(Exception e) {e.printStackTrace();}
		}
	}

	@Override
	public boolean deletePais(String nombre_pais) {
		
	//Realizo la conexión	
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {
		conexion = sql.getConnection();
		ps = conexion.prepareCall(delete);
		
	//Seteo el parámetro	
		ps.setString(1, nombre_pais);
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
	public boolean updatePais(Pais pais) {
		
	//Realizo la conexión	
		Connection conexion = null;
		PreparedStatement ps = null;

		try {
			conexion = sql.getConnection();
			ps = conexion.prepareCall(update);

		//Seteo el parámetro	
			ps.setString(1, pais.getNombrePais());
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
	public List<Pais> ListAllPais() {
		
	//Realizo la conexión	
		Connection conexion = null;
		PreparedStatement ps = null;
		List<Pais> lista= new ArrayList<>();
		try {
			conexion = sql.getConnection();
		    ps = conexion.prepareStatement(ListAll);
			ResultSet rs = ps.executeQuery();    
			while(rs.next()) {
			
			//Obtengo el nombre del país y creo el objeto	
				String nombrepais = (rs.getString(("nombre_pais")));  
				Pais pais = new Pais(nombrepais);
				
			//Agrego el país a la lista	
				lista.add(pais);
		    }
			conexion.close();
						
		} catch (SQLException e) {e.printStackTrace();}
			return lista;	
	}
		
	

	@Override
	public Pais getPais(String nombre_pais) {
		
	//Realizo la conexión	
		Connection conexion = null;
	    PreparedStatement ps = null;	    
		try {	 
			conexion = sql.getConnection();
		    ps = conexion.prepareStatement(get);
		    
		//Seteo el parámetro    
		    ps.setString(1, nombre_pais);
		    ResultSet rs = ps.executeQuery();
				    
			while(rs.next()) {
			
			//Obtengo los datos y creo el objeto país	
				String nombrepais = (rs.getString(("nombre_pais")));
				Integer id = rs.getInt("id_pais");
			    
				Pais pais = new Pais(id,nombrepais);
				return pais;
		}
		conexion.close();
		} catch (SQLException e) {e.printStackTrace();}
	return null;}

	@Override
	public List<String> obtenerNombres() {
		
	//Realizo la conexión	
		Connection conexion = null;
		 PreparedStatement ps = null;
		 List<String> lista= new ArrayList<>();
		 try {
			conexion = sql.getConnection();
		    ps = conexion.prepareStatement(ListAll);
			ResultSet rs = ps.executeQuery();    
			while(rs.next()) {
			
			//Obtengo el nombre del país y lo agrego a la lista	 
				String nombrepais = (rs.getString(("nombre_pais")));  
				lista.add(nombrepais);
		    }
			conexion.close();
					
		 } catch (SQLException e) {e.printStackTrace();}
		return lista;	
	}

	@Override
	public Pais getPaisPorID(Integer id) {
		
	//Realizo la conexión	
		Connection conexion = null;
	    PreparedStatement ps = null;	    
		try {	 
			conexion = sql.getConnection();
		    ps = conexion.prepareStatement(GETPAISPORID);
		    ps.setInt(1, id);
		    ResultSet rs = ps.executeQuery();
				    
			while(rs.next()) {
				
			//Obtengo los datos del país y creo el objeto	
				String nombrepais = (rs.getString(("nombre_pais")));
				int id_pais = rs.getInt("id_pais");
			    
				Pais pais = new Pais(id_pais,nombrepais);
				return pais;
		}
			conexion.close();
		}catch (SQLException e) {e.printStackTrace();}
		return null;
	}
}
	

	