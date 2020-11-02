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

    ConexionMySQL sql = new ConexionMySQL();
	final String add = "INSERT INTO prog_avanzada.pais (nombre_pais) VALUES(?)";
	final String delete = "DELETE FROM prog_avanzada.pais WHERE id_pais = ?";
	final String update = "UPDATE prog_avanzada.pais set nombre_pais = ? WHERE id_pais = ? ";
    final String ListAll = "SELECT * FROM prog_avanzada.pais";
	final String get = "SELECT * FROM prog_avanzada.pais WHERE nombre_pais = ?";
	
	@Override
	public void addPais(Pais pais) {
		
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {		
			conexion = sql.getConnection();
			ps = conexion.prepareStatement(add);
			ps.setString(1, pais.getNombrePais());
			ps.executeUpdate();	
			} 
			catch (SQLException e) { e.printStackTrace();}
			finally {	
			try {ps.close();conexion.close();}
			catch(Exception e) {e.printStackTrace();}
		}
	}

	@Override
	public void deletePais(String nombre_pais) {
		
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {
		conexion = sql.getConnection();
		ps = conexion.prepareCall(delete);
		ps.setString(1, nombre_pais);
		ps.executeUpdate();	
		conexion.close();
	} 
		catch (SQLException e) {e.printStackTrace();}
}

	@Override
	public void updatePais(Pais pais) {
		
		Connection conexion = null;
		PreparedStatement ps = null;

		try {
			conexion = sql.getConnection();
			ps = conexion.prepareCall(update);

			ps.setString(1, pais.getNombrePais());
	     	ps.executeUpdate();
			conexion.close();
			} catch (SQLException e) {e.printStackTrace();}	
		}
	

	@Override
	public List<Pais> ListAllPais() {
		
		Connection conexion = null;
		 PreparedStatement ps = null;
		 List<Pais> lista= new ArrayList<>();
		 try {
		 conexion = sql.getConnection();
	     ps = conexion.prepareStatement(ListAll);
		 ResultSet rs = ps.executeQuery();    
		 while(rs.next()) {
		
		String nombrepais = (rs.getString(("nombre_pais")));  
		Pais pais = new Pais(nombrepais);
		lista.add(pais);
	    }
			conexion.close();
					
	} catch (SQLException e) {e.printStackTrace();}
			return lista;	
	}
		
	

	@Override
	public Pais getPais(String nombre_pais) {
		
		Connection conexion = null;
	    PreparedStatement ps = null;	    
		try {	 
		conexion = sql.getConnection();
	    ps = conexion.prepareStatement(get);
	    ps.setString(1, nombre_pais);
	    ResultSet rs = ps.executeQuery();
			    
		while(rs.next()) {
			 
		String nombrepais = (rs.getString(("nombre_pais")));
	    
		Pais pais = new Pais(nombrepais);
		return pais;
	}
	conexion.close();
	} catch (SQLException e) {e.printStackTrace();}
	return null;}
	}