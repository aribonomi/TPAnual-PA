package dao.implDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Factory.Factory;
import dao.Interfaces.AerolineaDAO;
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

    ConexionMySQL sql = new ConexionMySQL();
    LineaAereaDAO aerolineaDAO = new Factory().getLineaAereaDaoImplMysql();
    
	final String add = "INSERT INTO prog_avanzada.pasajero_frecuente (alianza, numero, categoria, id_aerolinea) VALUES(?,?,?,?)";
	final String delete = "DELETE FROM prog_avanzada.pasajero_frecuente WHERE id_pasajero_frecuente = ?";
	final String update = "UPDATE prog_avanzada.pasajero_frecuente set alianza=?, categoria = ?, numero = ? WHERE id_pasajero_frecuente = ? ";
	final String ListAll = "SELECT * FROM prog_avanzada.pasajero_frecuente";
	final String get = "SELECT * FROM prog_avanzada.pasajero_frecuente WHERE id_pasajero_frecuente = ?";
	final static String OBTENERULTIMO = "SELECT * FROM prog_avanzada.pasajero_frecuente ORDER BY id_pasajero_frecuente DESC LIMIT 1";
	

	@Override
	public void addPasajeroFrecuente(PasajeroFrecuente pasajerofrecuente) {
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {		
			conexion = sql.getConnection();
			ps = conexion.prepareStatement(add);
			ps.setString(1, pasajerofrecuente.getAlianza().toString());
			ps.setString(2, pasajerofrecuente.getNumero());
			ps.setString(3, pasajerofrecuente.getCategoria());
			ps.setInt(4, pasajerofrecuente.getAerolinea().getId_aeroLinea());
			ps.executeUpdate();	
					} 
			catch (SQLException e) { e.printStackTrace();}
			finally {	
			try {ps.close();conexion.close();}
			catch(Exception e) {e.printStackTrace();}
		}
	}

	@Override
	public void deletePasajeroFrecuente(String id_pasajero_frecuente) {
		
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {
		conexion = sql.getConnection();
		ps = conexion.prepareCall(delete);
		ps.setInt(1, Integer.parseInt(id_pasajero_frecuente));
		ps.executeUpdate();	
		conexion.close();
	} 
		catch (SQLException e) {e.printStackTrace();}
	}
	

	@Override
	public void updatePasajeroFrecuente(PasajeroFrecuente pasajerofrecuente) {
		
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {
			conexion = sql.getConnection();
			ps = conexion.prepareCall(update);
			ps.setString(3, pasajerofrecuente.getCategoria());
			ps.setString(2, pasajerofrecuente.getNumero());
			ps.setString(1, pasajerofrecuente.getAlianza().toString());
			ps.setInt(4, pasajerofrecuente.getId_pasajeroFrecuente());
	     	ps.executeUpdate();
			conexion.close();
			} catch (SQLException e) {e.printStackTrace();}	
		}
	
	@Override
	public List<PasajeroFrecuente> ListAllPasajeroFrecuente() {
		Connection conexion = null;
		 PreparedStatement ps = null;
		 List<PasajeroFrecuente> lista= new ArrayList<>();
		 try {
		 conexion = sql.getConnection();
	     ps = conexion.prepareStatement(ListAll);
		 ResultSet rs = ps.executeQuery();    
		 while(rs.next()) {
			 
		String categoria = (rs.getString(("categoria")));
		String numero = (rs.getString("numero"));
		PasajeroFrecuente pasajerofrecuente = new PasajeroFrecuente(categoria,numero,null,null);	
		 lista.add(pasajerofrecuente);
	     }
			conexion.close();
					
	} catch (SQLException e) {e.printStackTrace();}
			return lista;	
	}
		
	@Override
	public PasajeroFrecuente getPasajeroFrecuente(String id_pasajero_frecuente) {

		Connection conexion = null;
	    PreparedStatement ps = null;	    
		try {	 
		conexion = sql.getConnection();
	    ps = conexion.prepareStatement(get);
	    ps.setString(1, id_pasajero_frecuente);
	    ResultSet rs = ps.executeQuery();
			    
		while(rs.next()) {
		Integer id = rs.getInt("id_pasajero_frecuente");	
		String categoria = (rs.getString(("categoria")));
	    String numero = (rs.getString("numero"));
	    String alianza = rs.getString("alianza");
	    Integer id_aerolinea = rs.getInt("id_aerolinea");
	    
	    Aerolinea aerolinea = aerolineaDAO.getLineaArea(id_aerolinea.toString());
	    
		PasajeroFrecuente pasajerofrecuente = new PasajeroFrecuente(id,categoria,numero,Alianza.valueOf(alianza),aerolinea);	
		return pasajerofrecuente;	
	}
	conexion.close();
	} catch (SQLException e) {e.printStackTrace();}
	return null;}

	@Override
	public PasajeroFrecuente obtenerUltimo() {
		Connection conexion = null;
	    PreparedStatement ps = null;	    
		try {	 
		conexion = sql.getConnection();
	    ps = conexion.prepareStatement(OBTENERULTIMO);
	    ResultSet rs = ps.executeQuery();
			    
		while(rs.next()) {
		String id = rs.getString("id_pasajero_frecuente");	
		String categoria = (rs.getString(("categoria")));
	    String numero = (rs.getString("numero"));
	    String alianza = rs.getString("alianza");
	    Integer id_aerolinea = rs.getInt("id_aerolinea");
	    
	    Aerolinea aerolinea = aerolineaDAO.getLineaArea(id_aerolinea.toString());
	    
		PasajeroFrecuente pasajerofrecuente = new PasajeroFrecuente(Integer.parseInt(id), categoria,numero,Alianza.valueOf(alianza),aerolinea);	
		return pasajerofrecuente;	
		}
		conexion.close();
		} catch (SQLException e) {e.printStackTrace();}
		return null;
	}
	}