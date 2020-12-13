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

//Conexión a mysql   
	ConexionMySQL sql = new ConexionMySQL();
	
//Statements	
	final String add = "INSERT INTO prog_avanzada.aerolinea (nombre_aerolinea, alianza) VALUES(?,?)";
	final String delete = "DELETE FROM prog_avanzada.aerolinea WHERE id_aerolinea = ?";
	final String update = "UPDATE prog_avanzada.aerolinea set nombre_aerolinea = ?, alianza = ? WHERE id_aerolinea = ? ";
	final String consulta = "SELECT * FROM prog_avanzada.aerolinea";
	final String get = "SELECT * FROM prog_avanzada.aerolinea WHERE id_aerolinea = ?";
	final String CONSULTAPORNOMBRE = "SELECT * FROM prog_avanzada.aerolinea WHERE nombre_aerolinea = ? LIMIT 1";
	final String OBTENERNOMBRES = "SELECT nombre_aerolinea FROM prog_avanzada.aerolinea";


	
	@Override
	public void altaLineaAerea(Aerolinea aerolinea) {
		
	//Realizo la conexión	
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {		
			conexion = sql.getConnection();
			ps = conexion.prepareStatement(add);
			
		//Seteo los parámetros	
			ps.setString(1, aerolinea.getNombre());
			ps.setString(2, aerolinea.getAlianza().name());
			ps.executeUpdate();	
					} 
			catch (SQLException e) { e.printStackTrace();}
			finally {	
			//Cierro la conexión	
			try {ps.close();conexion.close();}
			catch(Exception e) {e.printStackTrace();}
		}
		
	}

	@Override
	public void bajaLineaAerea(String id_aerolinea) {
		
	//Realizo la conexión	
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {
			conexion = sql.getConnection();
			ps = conexion.prepareCall(delete);
			
		//Seteo el parámetro	
			ps.setString(1, id_aerolinea);
			ps.executeUpdate();	
			
		//Cierro la conexión	
			conexion.close();
		}catch (SQLException e) {e.printStackTrace();}
	}
		
	

	@Override
	public void modificarLineaAerea(Aerolinea aerolinea) {
		
	//Realizo la conexión	
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {
			conexion = sql.getConnection();
			ps = conexion.prepareCall(update);
		
		//Seteo los parámetros
			ps.setString(1, aerolinea.getNombre());
			ps.setString(2, aerolinea.getAlianza().name());
			ps.setInt(3, aerolinea.getId_aeroLinea());
	
	     	ps.executeUpdate();
	     	
	     //Cierro la conexión	
			conexion.close();
			} catch (SQLException e) {e.printStackTrace();}	
		}
	

	@Override
	public Aerolinea getLineaArea(String id_aerolinea) {
		
		
	//Realizo la conexión	
		Connection conexion = null;
	    PreparedStatement ps = null;	    
		try {	 
			conexion = sql.getConnection();
		    ps = conexion.prepareStatement(get);
		    
		//Seteo el parámetro    
		    ps.setString(1, id_aerolinea);
		    ResultSet rs = ps.executeQuery();
				    
			while(rs.next()) {
			
			//Obtengo los datos y creo el objeto aerolínea	
				String id = rs.getString("id_aerolinea");	
				String numero = (rs.getString(("nombre_aerolinea")));
			    String alianza = (rs.getString(("alianza")));
			    alianza.toUpperCase();
			  
			    Aerolinea aerolinea = new Aerolinea(Integer.parseInt(id), numero, Alianza.valueOf(alianza));
			    return aerolinea;
		    
		}
		
	//Cierro la conexión		
		conexion.close();
		} catch (SQLException e) {e.printStackTrace();}
	return null;
	}

	@Override
	public Aerolinea consultarPorNombre(String nombre) {
		
	//Realizo la conexión	
		Connection conexion = null;
	    PreparedStatement ps = null;	    
		try {	 
			conexion = sql.getConnection();
		    ps = conexion.prepareStatement(CONSULTAPORNOMBRE);
		    
		//Seteo el parámetro    
		    ps.setString(1, nombre);
		    ResultSet rs = ps.executeQuery();
				    
			while(rs.next()) {
			
			//Obtiene los datos y crea un objeto aerolínea	
				String id = rs.getString("id_aerolinea");	
				String numero = (rs.getString(("nombre_aerolinea")));
			    String alianza = (rs.getString(("alianza")));
			    alianza.toUpperCase();
			  
			    Aerolinea aerolinea = new Aerolinea(Integer.parseInt(id), numero, Alianza.valueOf(alianza));
			    return aerolinea;
			}
		//Cierro la conexión	
			conexion.close();
		} catch (SQLException e) {e.printStackTrace();}
		return null;
		}

	@Override
	public List<String> obtenerNombres() {
		
	//Realizo la conexión	
		Connection conexion = null;
		PreparedStatement ps = null;
		List<String> lista= new ArrayList<>();
		try {
			conexion = sql.getConnection();
		    ps = conexion.prepareStatement(OBTENERNOMBRES);
			ResultSet rs = ps.executeQuery();    
			while(rs.next()) {
			
			//Obtengo el nombre y lo agrego a la lista	
				String nombre = (rs.getString(("nombre_aerolinea")));  
				lista.add(nombre);
		    }
	//Cierro la conexión		
		conexion.close();
						
		} catch (SQLException e) {e.printStackTrace();}
		return lista;
	}
	
	
}
