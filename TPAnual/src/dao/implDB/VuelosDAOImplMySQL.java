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

public class VuelosDAOImplMySQL implements VuelosDAO{
	
//Conexión a mysql  
	ConexionMySQL sql = new ConexionMySQL();
  
//Obtengo las implementaciones de los objetos contenidos dentro del vuelo  
	AeropuertoDAO aeropDAO = new Factory().getAeropuertoDaoImplMysql();
	LineaAereaDAO laDAO = new Factory().getLineaAereaDaoImplMysql();
  
//Statements  
	final String add = "INSERT INTO prog_avanzada.vuelos (numero_vuelo, cant_asientos, fecha_hora_salida, fecha_hora_llegada, tiempo_vuelo, id_aerolinea, id_aeropuerto_salida, id_aeropuerto_llegada) VALUES(?,?,?,?,?,?,?,?)";
	final String delete = "DELETE FROM prog_avanzada.vuelos WHERE id_vuelo = ?";
	final String update = "UPDATE prog_avanzada.vuelos set numero_vuelo = ?, cant_asientos = ?, fecha_hora_llegada = ? , fecha_hora_llegada = ?, tiempo_vuelo = ?, id_aerolinea = ?, id_aeropuerto_salida=?, id_aeropuerto_llegada=? WHERE id_vuelo = ? ";
	final String ListAll = "SELECT * FROM prog_avanzada.vuelos";
	final String get = "SELECT * FROM prog_avanzada.vuelos WHERE id_vuelo = ?";
	final String OBTENERIDS = "SELECT id_vuelo FROM prog_avanzada.vuelos";
	final String OBTENERULTIMO = "SELECT * FROM vuelos ORDER BY id_vuelo DESC LIMIT 1";

@Override
public void altaVuelo(Vuelo vuelo) {
		
//Realizo la conexión	
	Connection conexion = null;
	PreparedStatement ps = null;
	
	try {		
		conexion = sql.getConnection();
		ps = conexion.prepareStatement(add);
		
	//Seteo los parámetros	
		ps.setString(1, vuelo.getNumero());
		ps.setInt(2, vuelo.getCantidadAsientos());
		ps.setString(3, vuelo.getFechaSalida());
		ps.setString(4, vuelo.getFechaLlegada());
		ps.setString(5, vuelo.getTiempoVuelo());
		ps.setInt(6, vuelo.getAerolinea().getId_aeroLinea());
		ps.setInt(7, vuelo.getAeropuertoSalida().getId_Aeropuerto());
		ps.setInt(8, vuelo.getAeropuertoLlegada().getId_Aeropuerto());
			
		ps.executeUpdate();	
	}catch (SQLException e) { e.printStackTrace();}
	//Cierro la conexión	
	finally {	
		try {ps.close();conexion.close();}
		catch(Exception e) {e.printStackTrace();}
	}
}


	@Override
	public void bajaVuelo(String nroDeVuelo) {
		
	//Realizo la conexión	
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {
			conexion = sql.getConnection();
			ps = conexion.prepareCall(delete);
			
		//Seteo los parámetros	
			ps.setString(1, nroDeVuelo);
			ps.executeUpdate();	
			
		//Cierro la conexión	
			conexion.close();
		}catch (SQLException e) {e.printStackTrace();}
	}
		
	@Override
	public void modificarVuelo(Vuelo vuelo) {
		
	//Realizo la conexión	
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {
			conexion = sql.getConnection();
			ps = conexion.prepareCall(update);

		//Seteo los parámetros	
			ps.setString(1, vuelo.getNumero());
			ps.setInt(2, vuelo.getCantidadAsientos());
			ps.setString(3, vuelo.getFechaSalida());
			ps.setString(4, vuelo.getFechaLlegada());
			ps.setString(5, vuelo.getTiempoVuelo());
			ps.setInt(6, vuelo.getAerolinea().getId_aeroLinea());
			ps.setInt(7, vuelo.getAeropuertoSalida().getId_Aeropuerto());
			ps.setInt(8, vuelo.getAeropuertoLlegada().getId_Aeropuerto());
			ps.setInt(9, vuelo.getId_Vuelo());
			

	     	ps.executeUpdate();
	     	
	     //Cierro la conexión	
			conexion.close();
		} catch (SQLException e) {e.printStackTrace();}	
	}
	

	@Override
	public List<Vuelo> ListAllVuelo() {
		
	//Realizo la conexión	
		Connection conexion = null;
		PreparedStatement ps = null;
		List<Vuelo> lista= new ArrayList<>();
		try {
			conexion = sql.getConnection();
		    ps = conexion.prepareStatement(ListAll);
			ResultSet rs = ps.executeQuery();    
			while(rs.next()) {
				 
			//Obtengo los datos y creo el objeto Vuelo   
				String numero = (rs.getString(("numero_vuelo")));
				int cant_asientos = (rs.getInt(("cant_asientos")));
				String fechaLlegada = (rs.getString("fecha_hora_llegada"));
			    String fechaSalida = (rs.getString("fecha_hora_salida"));
				String tiempoVuelo = rs.getString("tiempo_vuelo");
				 
				 
				Vuelo vuelo = new Vuelo(numero, cant_asientos, fechaLlegada,fechaSalida,tiempoVuelo,null,null, null);	
							
			//Agrego el vuelo a la lista	
				lista.add(vuelo);
			 
		    }
			conexion.close();
						
		} catch (SQLException e) {e.printStackTrace();}
			return lista;	
	}
	
	@Override
	public Vuelo getVuelos(Integer idVuelo) {
	
	//Realizo la conexión	
		Connection conexion = null;
	    PreparedStatement ps = null;	    
		try {	 
			conexion = sql.getConnection();
		    ps = conexion.prepareStatement(get);
		    
		//Seteo el parámetro    
		    ps.setInt(1, idVuelo);
		    ResultSet rs = ps.executeQuery();
				    
			while(rs.next()) {
				
			//Obtengo los valores y creo el objeto	
				Integer id = rs.getInt("id_vuelo");	 
				String numero = (rs.getString(("numero_vuelo")));
			    int cant_asientos = (rs.getInt(("cant_asientos")));
			    String fechaLlegada = (rs.getString("fecha_hora_llegada"));
				String fechaSalida = (rs.getString("fecha_hora_salida"));
				String tiempoVuelo = rs.getString("tiempo_vuelo");
				Integer id_aerolinea = rs.getInt("id_aerolinea");
				Integer id_aeropuerto_salida = rs.getInt("id_aeropuerto_salida");
				Integer id_aeropuerto_llegada = rs.getInt("id_aeropuerto_llegada");
				
			//Obtengo la aerolínea y los aeropuertos mediante sus ids	
				Aerolinea aerolinea = laDAO.getLineaArea(id_aerolinea.toString());
				Aeropuerto aeropuertoSalida = aeropDAO.getAeropuerto(id_aeropuerto_salida);
				Aeropuerto aeropuertoLlegada = aeropDAO.getAeropuerto(id_aeropuerto_llegada);
				
				Vuelo vuelo = new Vuelo(id, numero, cant_asientos, fechaLlegada, fechaSalida, tiempoVuelo, aeropuertoLlegada, aeropuertoSalida, aerolinea);	
				return vuelo;	
		}
		conexion.close();
		} catch (SQLException e) {e.printStackTrace();}
	return null;}


	@Override
	public List<Integer> obtenerIDs() {
		
	//Realizo la conexión	
		Connection conexion = null;
		PreparedStatement ps = null;
		List<Integer> lista= new ArrayList<>();
		try {
			conexion = sql.getConnection();
		    ps = conexion.prepareStatement(OBTENERIDS);
			ResultSet rs = ps.executeQuery();    
			while(rs.next()) {
			
			//Obtengo el id y lo agrego a la lista de ids	
			    Integer id = rs.getInt("id_vuelo");
									
				lista.add(id);
			 
		    }
			conexion.close();
					
	} catch (SQLException e) {e.printStackTrace();}
			return lista;	
	}


	@Override
	public Vuelo obtenerUltimo() {
		
	//Realizo la conexión	
		Connection conexion = null;
	    PreparedStatement ps = null;	    
		try {	 
			conexion = sql.getConnection();
		    ps = conexion.prepareStatement(OBTENERULTIMO);
		    ResultSet rs = ps.executeQuery();
				    
			while(rs.next()) {
				
			//Obtengo los valores y creo el objeto vuelo	
				Integer id = rs.getInt("id_vuelo");	 
				String numero = (rs.getString(("numero_vuelo")));
			    int cant_asientos = (rs.getInt(("cant_asientos")));
			    String fechaLlegada = (rs.getString("fecha_hora_llegada"));
				String fechaSalida = (rs.getString("fecha_hora_salida"));
				String tiempoVuelo = rs.getString("tiempo_vuelo");
				Integer id_aerolinea = rs.getInt("id_aerolinea");
				Integer id_aeropuerto_salida = rs.getInt("id_aeropuerto_salida");
				Integer id_aeropuerto_llegada = rs.getInt("id_aeropuerto_llegada");
				
			//Obtengo la aerolínea y los aeropuertos a partir de sus ids	
				Aerolinea aerolinea = laDAO.getLineaArea(id_aerolinea.toString());
				Aeropuerto aeropuertoSalida = aeropDAO.getAeropuerto(id_aeropuerto_salida);
				Aeropuerto aeropuertoLlegada = aeropDAO.getAeropuerto(id_aeropuerto_llegada);
				
				Vuelo vuelo = new Vuelo(id, numero, cant_asientos, fechaLlegada, fechaSalida, tiempoVuelo, aeropuertoLlegada, aeropuertoSalida, aerolinea);	
				return vuelo;	
			}
			conexion.close();
		} catch (SQLException e) {e.printStackTrace();}
		return null;}
	
	
	
	
}
