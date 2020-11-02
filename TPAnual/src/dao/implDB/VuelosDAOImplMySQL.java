package dao.implDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Interfaces.VuelosDAO;
import dao.negocio.Vuelo;
import dao.util.ConexionMySQL;

public class VuelosDAOImplMySQL implements VuelosDAO{
	
  ConexionMySQL sql = new ConexionMySQL();
  final String add = "INSERT INTO prog_avanzada.vuelos (numero_vuelo, cant_asientos, fecha_hora_salida, fecha_hora_llegada, tiempo_vuelo) VALUES(?,?,?,?,?)";
  final String delete = "DELETE FROM prog_avanzada.vuelos WHERE id_aeropuerto = ?";
  final String update = "UPDATE prog_avanzada.vuelos set numero_vuelo = ?, cant_asientos = ?, fecha_hora_llegada = ? , fecha_hora_llegada = ?, tiempo_vuelo = ? WHERE numero_vuelo = ? ";
  final String ListAll = "SELECT * FROM prog_avanzada.vuelos";
  final String get = "SELECT * FROM prog_avanzada.vuelos WHERE numero_vuelo = ?";

@Override
public void altaVuelo(Vuelo vuelo) {
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {		
			conexion = sql.getConnection();
			ps = conexion.prepareStatement(add);
			ps.setString(1, vuelo.getNumero());
			ps.setInt(2, vuelo.getCantidadAsientos());
			ps.setString(3, vuelo.getFechaSalida());
			ps.setString(4, vuelo.getFechaLlegada());
			ps.setString(5, vuelo.getTiempoVuelo());
			
			ps.executeUpdate();	
					} 
			catch (SQLException e) { e.printStackTrace();}
			finally {	
			try {ps.close();conexion.close();}
			catch(Exception e) {e.printStackTrace();}
		}
}


	@Override
	public void bajaVuelo(String nroDeVuelo) {
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {
		conexion = sql.getConnection();
		ps = conexion.prepareCall(delete);
		ps.setString(1, nroDeVuelo);
		ps.executeUpdate();	
		conexion.close();
	} 
		catch (SQLException e) {e.printStackTrace();}
	}
		
	@Override
	public void modificarVuelo(Vuelo vuelo) {
		
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {
			conexion = sql.getConnection();
			ps = conexion.prepareCall(update);

			ps.setString(1, vuelo.getNumero());
			ps.setInt(2, vuelo.getCantidadAsientos());
			ps.setString(3, vuelo.getFechaSalida());
			ps.setString(4, vuelo.getFechaLlegada());
			ps.setString(5, vuelo.getTiempoVuelo());
			

	     	ps.executeUpdate();
			conexion.close();
			} catch (SQLException e) {e.printStackTrace();}	
		}
	

	@Override
	public List<Vuelo> ListAllVuelo() {
		
		Connection conexion = null;
		 PreparedStatement ps = null;
		 List<Vuelo> lista= new ArrayList<>();
		 try {
		 conexion = sql.getConnection();
	     ps = conexion.prepareStatement(ListAll);
		 ResultSet rs = ps.executeQuery();    
		 while(rs.next()) {
			 
	     String numero = (rs.getString(("numero_vuelo")));
		 int cant_asientos = (rs.getInt(("cant_asientos")));
		 String fechaLlegada = (rs.getString("fecha_hora_llegada"));
	     String fechaSalida = (rs.getString("fecha_hora_salida"));
		 String tiempoVuelo = rs.getString("tiempo_vuelo");
		 Vuelo vuelo = new Vuelo(numero, cant_asientos, fechaLlegada,fechaSalida,tiempoVuelo,null,null);	
					
		 lista.add(vuelo);
		 
	     }
			conexion.close();
					
	} catch (SQLException e) {e.printStackTrace();}
			return lista;	
	}
	
	@Override
	public Vuelo getVuelos(String nroDeVuelo) {
	
		Connection conexion = null;
	    PreparedStatement ps = null;	    
		try {	 
		conexion = sql.getConnection();
	    ps = conexion.prepareStatement(get);
	    ps.setString(1, nroDeVuelo);
	    ResultSet rs = ps.executeQuery();
			    
		while(rs.next()) {
			 
		String numero = (rs.getString(("numero_vuelo")));
	    int cant_asientos = (rs.getInt(("cant_asientos")));
	    String fechaLlegada = (rs.getString("fecha_hora_llegada"));
		String fechaSalida = (rs.getString("fecha_hora_salida"));
		String tiempoVuelo = rs.getString("tiempo_vuelo");
		Vuelo vuelo = new Vuelo(numero, cant_asientos, fechaLlegada,fechaSalida,tiempoVuelo,null,null);	
		return vuelo;	
	}
	conexion.close();
	} catch (SQLException e) {e.printStackTrace();}
	return null;}
}
