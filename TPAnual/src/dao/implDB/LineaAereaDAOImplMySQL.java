package dao.implDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Interfaces.LineaAereaDAO;
import dao.negocio.Aerolinea;
import dao.negocio.Alianza;
import dao.negocio.Pais;
import dao.negocio.Vuelo;
import dao.util.ConexionMySQL;

public class LineaAereaDAOImplMySQL implements LineaAereaDAO{

    ConexionMySQL sql = new ConexionMySQL();
	final String add = "INSERT INTO prog_avanzada.aerolinea (nombre_aerolinea, alianza) VALUES(?,?)";
	final String delete = "DELETE FROM prog_avanzada.aerolinea WHERE id_aerolinea = ?";
	final String update = "UPDATE prog_avanzada.aerolinea set nombre_aerolinea = ?, alianza = ? WHERE id_aerolinea = ? ";
	final String consulta = "SELECT * FROM prog_avanzada.aerolinea";
	final String get = "SELECT * FROM prog_avanzada.aerolinea WHERE id_aerolinea = ?";
	final static String CONSULTAPORNOMBRE = "SELECT * FROM prog_avanzada.aerolinea WHERE nombre_aerolinea = ? LIMIT 1";
	final static String OBTENERNOMBRES = "SELECT nombre_aerolinea FROM prog_avanzada.aerolinea";


	
	@Override
	public void altaLineaAerea(Aerolinea aerolinea) {
		
		
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {		
			conexion = sql.getConnection();
			ps = conexion.prepareStatement(add);
			ps.setString(1, aerolinea.getNombre());
			ps.setString(2, aerolinea.getAlianza().name());
			ps.executeUpdate();	
					} 
			catch (SQLException e) { e.printStackTrace();}
			finally {	
			try {ps.close();conexion.close();}
			catch(Exception e) {e.printStackTrace();}
		}
		
	}

	@Override
	public void bajaLineaAerea(String id_aerolinea) {
		
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {
		conexion = sql.getConnection();
		ps = conexion.prepareCall(delete);
		ps.setString(1, id_aerolinea);
		ps.executeUpdate();	
		conexion.close();
	} 
		catch (SQLException e) {e.printStackTrace();}
	}
		
	

	@Override
	public void modificarLineaAerea(Aerolinea aerolinea) {
		
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {
			conexion = sql.getConnection();
			ps = conexion.prepareCall(update);
		
			ps.setString(1, aerolinea.getNombre());
			ps.setString(2, aerolinea.getAlianza().name());
			ps.setInt(3, aerolinea.getId_aeroLinea());
	
	     	ps.executeUpdate();
			conexion.close();
			} catch (SQLException e) {e.printStackTrace();}	
		}
	

	@Override
	public Aerolinea getLineaArea(String id_aerolinea) {
		

		Connection conexion = null;
	    PreparedStatement ps = null;	    
		try {	 
		conexion = sql.getConnection();
	    ps = conexion.prepareStatement(get);
	    ps.setString(1, id_aerolinea);
	    ResultSet rs = ps.executeQuery();
			    
		while(rs.next()) {
		
		String id = rs.getString("id_aerolinea");	
		String numero = (rs.getString(("nombre_aerolinea")));
	    String alianza = (rs.getString(("alianza")));
	    alianza.toUpperCase();
	  
	    Aerolinea aerolinea = new Aerolinea(Integer.parseInt(id), numero, Alianza.valueOf(alianza));
	    return aerolinea;
	    
	}
	conexion.close();
	} catch (SQLException e) {e.printStackTrace();}
	return null;
	}

	@Override
	public Aerolinea consultarPorNombre(String nombre) {
		Connection conexion = null;
	    PreparedStatement ps = null;	    
		try {	 
			conexion = sql.getConnection();
		    ps = conexion.prepareStatement(CONSULTAPORNOMBRE);
		    ps.setString(1, nombre);
		    ResultSet rs = ps.executeQuery();
				    
			while(rs.next()) {
			
				String id = rs.getString("id_aerolinea");	
				String numero = (rs.getString(("nombre_aerolinea")));
			    String alianza = (rs.getString(("alianza")));
			    alianza.toUpperCase();
			  
			    Aerolinea aerolinea = new Aerolinea(Integer.parseInt(id), numero, Alianza.valueOf(alianza));
			    return aerolinea;
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
		    ps = conexion.prepareStatement(OBTENERNOMBRES);
			ResultSet rs = ps.executeQuery();    
			while(rs.next()) {
			
				String nombre = (rs.getString(("nombre_aerolinea")));  
				lista.add(nombre);
		    }
		conexion.close();
						
		} catch (SQLException e) {e.printStackTrace();}
		return lista;
	}
	
	
}
