package dao.implDB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Interfaces.VentasDAO;
import dao.negocio.Direccion;
import dao.negocio.Venta;
import dao.negocio.Vuelo;
import dao.util.ConexionMySQL;

public class VentasDAOImplMySQL implements VentasDAO{
	
    ConexionMySQL sql = new ConexionMySQL();
	final String add = "INSERT INTO prog_avanzada.ventas (fecha_hora_venta, forma_pago) VALUES(?,?)";
	final String delete = "DELETE FROM prog_avanzada.ventas WHERE id_ventas = ?";
	final String update = "UPDATE prog_avanzada.ventas set id_ventas = ? , fecha_hora_venta = ?, forma_pago = ? WHERE id_ventas = ? ";
	final String ListALL = "SELECT * FROM prog_avanzada.ventas";
	final String get = "SELECT * FROM prog_avanzada.ventas WHERE id_ventas = ?";
	  
	@Override
	public void altaVenta(Venta venta) {
		
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {		
			conexion = sql.getConnection();
			ps = conexion.prepareStatement(add);
			
			ps.setString(1, venta.getFecha());
			ps.setString(2, venta.getFormaDePago());
			ps.executeUpdate();	
					} 
			catch (SQLException e) { e.printStackTrace();}
		finally {	
			try {ps.close();conexion.close();}
			catch(Exception e) {e.printStackTrace();}
		}
		
	}
	@Override
	public void bajaVenta(String id_venta) {
		
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {
		conexion = sql.getConnection();
		ps = conexion.prepareCall(delete);
		ps.setString(1, id_venta);
		ps.executeUpdate();	
		conexion.close();
	} 
		catch (SQLException e) {e.printStackTrace();}
	}
	@Override
	public void modificarVenta(Venta venta) {
	
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {
			conexion = sql.getConnection();
			ps = conexion.prepareCall(update);
			ps.setString(1, venta.getFecha());
			ps.setString(2, venta.getFormaDePago());
	     	ps.executeUpdate();
			conexion.close();
			} catch (SQLException e) {e.printStackTrace();}	
		}
	
	@Override
	public List<Venta> ListAllVenta() {
		
		Connection conexion = null;
		PreparedStatement ps = null;
		List<Venta> lista= new ArrayList<>();
		 try {
		 conexion = sql.getConnection();
	     ps = conexion.prepareStatement(ListALL);
		 ResultSet rs = ps.executeQuery();    
		 while(rs.next()) {
			 
		
		String fecha_hora_venta = (rs.getString(("fecha_hora_venta")));
		String forma_pago = (rs.getString("forma_pago"));
		
		Venta venta = new Venta(fecha_hora_venta,forma_pago,null,null,null);
		lista.add(venta);
		 
	     }
			conexion.close();
					
	} catch (SQLException e) {e.printStackTrace();}
			return lista;	
	}
		
	@Override
	public Venta getVentas(String id_venta) {
		
		Connection conexion = null;
	    PreparedStatement ps = null;	    
		try {	 
		conexion = sql.getConnection();
	    ps = conexion.prepareStatement(get);
	    ps.setString(1, id_venta);
	    ResultSet rs = ps.executeQuery();
			    
		while(rs.next()) {
			 
	   String fecha_hora_venta = (rs.getString(("fecha_hora_venta")));
		String forma_pago = (rs.getString("forma_pago"));
			
		Venta venta = new Venta(fecha_hora_venta,forma_pago,null,null,null);
		return venta;
	}
	conexion.close();
	} catch (SQLException e) {e.printStackTrace();}
	return null;}
	}

	