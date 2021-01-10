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

//Conexión a mysql	
	ConexionMySQL sql = new ConexionMySQL();
	
//Statements	
	final String add = "INSERT INTO prog_avanzada.cliente (nombre, apellido, dni, fecha_de_nacimiento, cuit_cuil, email, id_direccion, id_telefono, id_pasaporte, id_pasajero_frecuente) VALUES(?,?,?,?,?,?,?,?,?,?)";
	final String delete = "DELETE FROM prog_avanzada.cliente WHERE id_cliente = ?";
	final String update = "UPDATE prog_avanzada.cliente set nombre = ?, apellido = ?, dni = ? , fecha_de_nacimiento = ?, "
		+ "cuit_cuil = ?, email = ? WHERE id_cliente=? ";
	final String ListAll = "SELECT * FROM prog_avanzada.cliente";
	final String get = "SELECT * FROM prog_avanzada.cliente WHERE dni = ?";
	final String CONSULTAPORID = "SELECT * FROM prog_avanzada.cliente WHERE id_cliente = ?";
	final String OBTENERIDS = "SELECT id_cliente FROM prog_avanzada.cliente";
	final String OBTENERULTIMO = "SELECT * FROM prog_avanzada.cliente ORDER BY id_cliente DESC LIMIT 1";

	
	@Override
	public boolean altaCliente(Cliente cliente) {
		
	//Realizo la conexión	
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {		
			conexion = sql.getConnection();
			ps = conexion.prepareStatement(add);
			
		//Seteo los parámetros	
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
			return true;
		}catch (SQLException e) {
			e.printStackTrace(); 
			return false;
		}finally {	
			//Cierro la conexión	
			try {ps.close();conexion.close();}
			catch(Exception e) {e.printStackTrace();}
		}
		
	}

	@Override
	public boolean bajaCliente(String dni) {
	
	//Realizo la conexión	
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {
			conexion = sql.getConnection();
			ps = conexion.prepareCall(delete);
			
		//Seteo los parámetros	
			ps.setString(1, dni);
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
	public boolean modificarCliente(Cliente cliente) {
	
	//Realizo la conexión	
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {
			conexion = sql.getConnection();
			ps = conexion.prepareCall(update);
			
		//Seteo los parámetros	
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellido());
			ps.setString(3, cliente.getDni());
			ps.setString(4, cliente.getFecha_nacimiento());
			ps.setString(5, cliente.getCuit_cuil());
			ps.setString(6, cliente.getEmail());
			ps.setInt(7, cliente.getId_cliente());

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
	public Cliente getCliente(String dni) {
		
	//Realizo la conexión	
		Connection conexion = null;
	    PreparedStatement ps = null;	    
		try {	 
			conexion = sql.getConnection();
		    ps = conexion.prepareStatement(get);
		    
		//Seteo el parámetro    
		    ps.setString(1, dni);
		    ResultSet rs = ps.executeQuery();
				    
			while(rs.next()) {
				
			//Obtengo los datos y creo un objeto cliente	 
				String nombre = (rs.getString(("nombre")));
			    String apellido = (rs.getString(("apellido")));
				String fecha_nacimiento = (rs.getString("fecha_de_nacimiento"));
				String cuit_cuil = rs.getString("cuit_cuil");
				String email = rs.getString("email");
				Integer id_direccion = rs.getInt("id_direccion");
				Integer id_telefono = rs.getInt("id_telefono");
				Integer id_pasaporte = rs.getInt("id_pasaporte");
				Integer id_pf = rs.getInt("id_pasajero_frecuente");
				
			//Creo los objetos que contiene el cliente solo con su id para obtener el resto de los datos en el mvc	
				Direccion d = new Direccion(id_direccion, null, null, null, null, null, null);
				Telefono t = new Telefono(id_telefono, null, null, null);
				Pasaporte p = new Pasaporte(id_pasaporte.toString(), null, null, null, null);
				PasajeroFrecuente pf = new PasajeroFrecuente(id_pf.toString(), null, null, null);
				
				Cliente cliente = new Cliente(nombre,apellido,dni,cuit_cuil,fecha_nacimiento,email,d,t,p,pf);
				return cliente;
			
		}
		conexion.close();
	} catch (SQLException e) {e.printStackTrace();}
	return null;}
	

	@Override
	public List<Cliente> ListAllCliente() {
		
	//Realizo la conexión	
		Connection conexion = null;
		 PreparedStatement ps = null;
		 List<Cliente> lista= new ArrayList<>();
		 try {
			conexion = sql.getConnection();
		    ps = conexion.prepareStatement(ListAll);
			ResultSet rs = ps.executeQuery();    
			while(rs.next()) {
				
			//Obtengo los datos y creo un objeto cliente	
				String nombre = (rs.getString(("nombre")));
				String apellido = (rs.getString(("apellido")));
				String dni = (rs.getString("dni"));
				String fecha_nacimiento = (rs.getString("fecha_de_nacimiento"));
				String cuit_cuil = rs.getString("cuit_cuil");
				String email = rs.getString("email");
						
				Cliente cliente = new Cliente(nombre,apellido,dni,fecha_nacimiento,cuit_cuil,email,null,null,null,null);
				
			//Agrego el cliente a la lista	
				lista.add(cliente);
		    }
		//Cierro la conexión	
			conexion.close();
					
	} catch (SQLException e) {e.printStackTrace();}
			return lista;	
	}

	@Override
	public Cliente consultaPorId(Integer id) {
		
	//Realizo la conexión	
		Connection conexion = null;
	    PreparedStatement ps = null;	    
		try {	 
			conexion = sql.getConnection();
		    ps = conexion.prepareStatement(CONSULTAPORID);
		    
		//Seteo el parámetro    
		    ps.setInt(1, id);
		    ResultSet rs = ps.executeQuery();
				    
			while(rs.next()) {
				
			//Obtengo los datos y creo un objeto cliente	
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
				
			//Creo los objetos que contiene el cliente solo con su id para obtener el resto de los datos en el mvc	
				Direccion d = new Direccion(id_direccion, null, null, null, null, null, null);
				Telefono t = new Telefono(id_telefono, null, null, null);
				Pasaporte p = new Pasaporte(id_pasaporte, null, null, null, null, null);
				PasajeroFrecuente pf = new PasajeroFrecuente(id_pf, null, null, null, null);
				
				Cliente cliente = new Cliente(codigo,nombre,apellido,dni,cuit_cuil,fecha_nacimiento,email,d,t,p,pf);
				return cliente;
			}
		//Cierro la conexión	
			conexion.close();
		}catch (SQLException e) {e.printStackTrace();}
		return null;
	}

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
				
			//Obtengo el id y lo agrego a la lista	 
				Integer id = rs.getInt("id_cliente");
						
				lista.add(id);
		     }
		//Cierro la conexión	
			conexion.close();
					
		}catch (SQLException e) {e.printStackTrace();}
		return lista;	
	}

	@Override
	public Cliente obtenerUltimo() {
		
	//Realizo la conexión	
		Connection conexion = null;
	    PreparedStatement ps = null;	    
		try {	 
			conexion = sql.getConnection();
		    ps = conexion.prepareStatement(OBTENERULTIMO);

		    ResultSet rs = ps.executeQuery();
				    
			while(rs.next()) {
				
			//Obtengo los datos y creo el objeto cliente	
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
				
			//Creo los objetos que contiene el cliente solo con su id para obtener el resto de los datos en el mvc	
				Direccion d = new Direccion(id_direccion, null, null, null, null, null, null);
				Telefono t = new Telefono(id_telefono, null, null, null);
				Pasaporte p = new Pasaporte(id_pasaporte, null, null, null, null, null);
				PasajeroFrecuente pf = new PasajeroFrecuente(id_pf, null, null, null, null);
				
				Cliente cliente = new Cliente(codigo,nombre,apellido,dni,cuit_cuil,fecha_nacimiento,email,d,t,p,pf);
				return cliente;
			}
			
		//Cierro la conexión	
			conexion.close();
		} catch (SQLException e) {e.printStackTrace();}
		return null;
	}
		

}