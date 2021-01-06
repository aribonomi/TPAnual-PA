package dao.implDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Factory.Factory;
import dao.Interfaces.LineaAereaDAO;
import dao.Interfaces.PaisDAO;
import dao.Interfaces.PasajeroFrecuenteDAO;
import dao.negocio.Aerolinea;
import dao.negocio.Alianza;
import dao.negocio.Direccion;
import dao.negocio.PasajeroFrecuente;
import dao.negocio.Vuelo;
import dao.util.ConexionMySQL;

public class PasajeroFrecuenteDAOImplMySQL implements PasajeroFrecuenteDAO{

//Conexión a mysql    
	ConexionMySQL sql = new ConexionMySQL();
    
//Statements	
    final String add = "INSERT INTO prog_avanzada.pasajero_frecuente (alianza, numero, categoria, id_aerolinea) VALUES(?,?,?,?)";
	final String delete = "DELETE FROM prog_avanzada.pasajero_frecuente WHERE id_pasajero_frecuente = ?";
	final String update = "UPDATE prog_avanzada.pasajero_frecuente set alianza=?, categoria = ?, numero = ? WHERE id_pasajero_frecuente = ? ";
	final String ListAll = "SELECT * FROM prog_avanzada.pasajero_frecuente";
	final String get = "SELECT * FROM prog_avanzada.pasajero_frecuente WHERE id_pasajero_frecuente = ?";
	final String OBTENERULTIMO = "SELECT * FROM prog_avanzada.pasajero_frecuente ORDER BY id_pasajero_frecuente DESC LIMIT 1";
	

	@Override
	public boolean addPasajeroFrecuente(PasajeroFrecuente pasajerofrecuente) {
		
	//Realizo la conexión	
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {		
			conexion = sql.getConnection();
			ps = conexion.prepareStatement(add);
			
		//Seteo los parámetros	
			ps.setString(1, pasajerofrecuente.getAlianza().toString());
			ps.setString(2, pasajerofrecuente.getNumero());
			ps.setString(3, pasajerofrecuente.getCategoria());
			ps.setInt(4, pasajerofrecuente.getAerolinea().getId_aeroLinea());
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
	public boolean deletePasajeroFrecuente(String id_pasajero_frecuente) {
		
	//Realizo la conexión	
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {
			conexion = sql.getConnection();
			ps = conexion.prepareCall(delete);
		
		//Seteo el parámetro	
			ps.setInt(1, Integer.parseInt(id_pasajero_frecuente));
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
	public boolean updatePasajeroFrecuente(PasajeroFrecuente pasajerofrecuente) {
		
	//Realizo la conexión	
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {
			conexion = sql.getConnection();
			ps = conexion.prepareCall(update);
			
		//Seteo los parámetros	
			ps.setString(3, pasajerofrecuente.getCategoria());
			ps.setString(2, pasajerofrecuente.getNumero());
			ps.setString(1, pasajerofrecuente.getAlianza().toString());
			ps.setInt(4, pasajerofrecuente.getId_pasajeroFrecuente());
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
	public List<PasajeroFrecuente> ListAllPasajeroFrecuente() {
		
	//Realizo la conexión	
		Connection conexion = null;
		 PreparedStatement ps = null;
		 List<PasajeroFrecuente> lista= new ArrayList<>();
		 try {
			conexion = sql.getConnection();
		    ps = conexion.prepareStatement(ListAll);
			ResultSet rs = ps.executeQuery();    
			while(rs.next()) {
			
			//Obtengo los datos y creo el objeto pasajero frecuente	
				String categoria = (rs.getString(("categoria")));
				String numero = (rs.getString("numero"));
				PasajeroFrecuente pasajerofrecuente = new PasajeroFrecuente(categoria,numero,null,null);	
				
			//Agrego el pasajero frecuente a la lista	
				lista.add(pasajerofrecuente);
		}
	//Cierro la conexión	
		conexion.close();
						
		} catch (SQLException e) {e.printStackTrace();}
			return lista;	
	}
		
	@Override
	public PasajeroFrecuente getPasajeroFrecuente(String id_pasajero_frecuente) {

	//Realizo la conexión
		Connection conexion = null;
	    PreparedStatement ps = null;	    
		try {	 
			conexion = sql.getConnection();
		    ps = conexion.prepareStatement(get);
		    
		//Seteo el parámetro    
		    ps.setString(1, id_pasajero_frecuente);
		    ResultSet rs = ps.executeQuery();
				    
			while(rs.next()) {
				
			//Obtengo los datos y creo el objeto	
				Integer id = rs.getInt("id_pasajero_frecuente");	
				String categoria = (rs.getString(("categoria")));
			    String numero = (rs.getString("numero"));
			    String alianza = rs.getString("alianza");
			    Integer id_aerolinea = rs.getInt("id_aerolinea");
			    Aerolinea aerolinea = new Aerolinea(id_aerolinea, null, null);
			    
				PasajeroFrecuente pasajerofrecuente = new PasajeroFrecuente(id,categoria,numero,Alianza.valueOf(alianza),aerolinea);	
				return pasajerofrecuente;	
		}
		conexion.close();
		} catch (SQLException e) {e.printStackTrace();}
	return null;}

	@Override
	public PasajeroFrecuente obtenerUltimo() {
		
	//Realizo la conexión	
		Connection conexion = null;
	    PreparedStatement ps = null;	    
		try {	 
			conexion = sql.getConnection();
		    ps = conexion.prepareStatement(OBTENERULTIMO);
		    ResultSet rs = ps.executeQuery();
				    
			while(rs.next()) {
				
			//Obtengo los datos y creo el objeto	
				String id = rs.getString("id_pasajero_frecuente");	
				String categoria = (rs.getString(("categoria")));
			    String numero = (rs.getString("numero"));
			    String alianza = rs.getString("alianza");
			    Integer id_aerolinea = rs.getInt("id_aerolinea");
			    Aerolinea aerolinea = new Aerolinea(id_aerolinea, null, null);
			    
				PasajeroFrecuente pasajerofrecuente = new PasajeroFrecuente(Integer.parseInt(id), categoria,numero,Alianza.valueOf(alianza),aerolinea);	
				return pasajerofrecuente;	
			}
			conexion.close();
			} catch (SQLException e) {e.printStackTrace();}
		return null;
	}
	}