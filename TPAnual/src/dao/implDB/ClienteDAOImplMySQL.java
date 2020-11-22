package dao.implDB;
import java.sql.CallableStatement;
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

public class ClienteDAOImplMySQL implements ClienteDAO {

	
	ConexionMySQL sql = new ConexionMySQL();
	DireccionDAO direccionDAO = new Factory().getDireccionDaoImplMysql();
	TelefonoDAO telefonoDAO = new Factory().getTelefonoDaoImplMysql();
	PasaporteDAO pasaporteDAO = new Factory().getPasaporteDaoImplMysql();
	PasajeroFrecuenteDAO pfDAO = new Factory().getPasajeroFrecuenteDaoImplMysql();
	
	final String add = "INSERT INTO prog_avanzada.cliente (nombre, apellido, dni, fecha_de_nacimiento, cuit_cuil, email, id_direccion, id_telefono, id_pasaporte, id_pasajero_frecuente) VALUES(?,?,?,?,?,?,?,?,?,?)";
	final String delete = "DELETE FROM prog_avanzada.cliente WHERE id_cliente = ?";
	final String update = "UPDATE prog_avanzada.cliente set nombre = ?, apellido = ?, dni = ? , fecha_de_nacimiento = ?, "
		+ "cuit_cuil = ?, email = ? WHERE id_cliente=? ";
	final String ListAll = "SELECT * FROM prog_avanzada.cliente";
	final String get = "SELECT * FROM prog_avanzada.cliente WHERE dni = ?";
	final static String CONSULTAPORID = "SELECT * FROM prog_avanzada.cliente WHERE id_cliente = ?";

	
	@Override
	public void altaCliente(Cliente cliente) {
		
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {		
			conexion = sql.getConnection();
			ps = conexion.prepareStatement(add);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellido());
			ps.setString(3, cliente.getDni());
			ps.setString(4, cliente.getFecha_nacimiento());
			ps.setString(5, cliente.getCuit_cuil());
			ps.setString(6, cliente.getEmail());
			ps.setInt(7, cliente.getdireccion().getId_direccion());
			ps.setInt(8, cliente.gettelefono().getId_Telefono());
			ps.setInt(9, cliente.getpasaporte().getId_Pasaporte());
			ps.setInt(10, cliente.getpasajeroFrecuente().getId_pasajeroFrecuente());

			ps.executeUpdate();	
					} 
			catch (SQLException e) { e.printStackTrace();}
			finally {	
			try {ps.close();conexion.close();}
			catch(Exception e) {e.printStackTrace();}
		}
		
	}

	@Override
	public void bajaCliente(String dni) {
	
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {
		conexion = sql.getConnection();
		ps = conexion.prepareCall(delete);
		ps.setString(1, dni);
		ps.executeUpdate();	
		conexion.close();
	} 
		catch (SQLException e) {e.printStackTrace();}
	}
	

	@Override
	public void modificarCliente(Cliente cliente) {
	
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {
			conexion = sql.getConnection();
			ps = conexion.prepareCall(update);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellido());
			ps.setString(3, cliente.getDni());
			ps.setString(4, cliente.getFecha_nacimiento());
			ps.setString(5, cliente.getCuit_cuil());
			ps.setString(6, cliente.getEmail());
			ps.setInt(7, cliente.getId_cliente());

	     	ps.executeUpdate();
			conexion.close();
			} catch (SQLException e) {e.printStackTrace();}	
		}
	
	@Override
	public Cliente getCliente(String dni) {
		
		Connection conexion = null;
	    PreparedStatement ps = null;	    
		try {	 
		conexion = sql.getConnection();
	    ps = conexion.prepareStatement(get);
	    ps.setString(1, dni);
	    ResultSet rs = ps.executeQuery();
			    
		while(rs.next()) {
			 
		String nombre = (rs.getString(("nombre")));
	    String apellido = (rs.getString(("apellido")));
		String fecha_nacimiento = (rs.getString("fecha_de_nacimiento"));
		String cuit_cuil = rs.getString("cuit_cuil");
		String email = rs.getString("email");
		Integer id_direccion = rs.getInt("id_direccion");
		Integer id_telefono = rs.getInt("id_telefono");
		Integer id_pasaporte = rs.getInt("id_pasaporte");
		Integer id_pf = rs.getInt("id_pasajero_frecuente");
		
		Direccion d = direccionDAO.getDireccion(id_direccion.toString());
		Telefono t = telefonoDAO.getTelefono(id_telefono.toString());
		Pasaporte p = pasaporteDAO.getPasaporte(id_pasaporte.toString());
		PasajeroFrecuente pf = pfDAO.getPasajeroFrecuente(id_pf.toString());
		
		Cliente cliente = new Cliente(nombre,apellido,dni,cuit_cuil,fecha_nacimiento,email,d,t,p,pf);
		return cliente;
		
	}
	conexion.close();
	} catch (SQLException e) {e.printStackTrace();}
	return null;}
	

	@Override
	public List<Cliente> ListAllCliente() {
		Connection conexion = null;
		 PreparedStatement ps = null;
		 List<Cliente> lista= new ArrayList<>();
		 try {
		 conexion = sql.getConnection();
	     ps = conexion.prepareStatement(ListAll);
		 ResultSet rs = ps.executeQuery();    
		 while(rs.next()) {
			 
		String nombre = (rs.getString(("nombre")));
		String apellido = (rs.getString(("apellido")));
		String dni = (rs.getString("dni"));
		String fecha_nacimiento = (rs.getString("fecha_de_nacimiento"));
		String cuit_cuil = rs.getString("cuit_cuil");
		String email = rs.getString("email");
				
		Cliente cliente = new Cliente(nombre,apellido,dni,fecha_nacimiento,cuit_cuil,email,null,null,null,null);
		lista.add(cliente);
	     }
			conexion.close();
					
	} catch (SQLException e) {e.printStackTrace();}
			return lista;	
	}

	@Override
	public Cliente consultaPorId(Integer id) {
		Connection conexion = null;
	    PreparedStatement ps = null;	    
		try {	 
			conexion = sql.getConnection();
		    ps = conexion.prepareStatement(CONSULTAPORID);
		    ps.setInt(1, id);
		    ResultSet rs = ps.executeQuery();
				    
			while(rs.next()) {
				Integer codigo = rs.getInt("id_cliente"); 
				String nombre = (rs.getString(("nombre")));
			    String apellido = (rs.getString(("apellido")));
			    String dni = rs.getNString("dni");
				String fecha_nacimiento = (rs.getString("fecha_de_nacimiento"));
				String cuit_cuil = rs.getString("cuit_cuil");
				String email = rs.getString("email");
				Integer id_direccion = rs.getInt("id_direccion");
				Integer id_telefono = rs.getInt("id_telefono");
				Integer id_pasaporte = rs.getInt("id_pasaporte");
				Integer id_pf = rs.getInt("id_pasajero_frecuente");
				
				Direccion d = direccionDAO.getDireccion(id_direccion.toString());
				Telefono t = telefonoDAO.getTelefono(id_telefono.toString());
				Pasaporte p = pasaporteDAO.getPasaporte(id_pasaporte.toString());
				PasajeroFrecuente pf = pfDAO.getPasajeroFrecuente(id_pf.toString());
				
				Cliente cliente = new Cliente(codigo,nombre,apellido,dni,cuit_cuil,fecha_nacimiento,email,d,t,p,pf);
				return cliente;
			}
			conexion.close();
		} catch (SQLException e) {e.printStackTrace();}
		return null;
	}
		

}