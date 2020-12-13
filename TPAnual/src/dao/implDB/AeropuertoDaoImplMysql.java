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

public class AeropuertoDaoImplMysql implements AeropuertoDAO {

//Conexión a mysql	
	ConexionMySQL sql = new ConexionMySQL();
	
//Obtengo las implementaciones de los objetos contenidos en el aeropuerto	
	PaisDAO paisDAO = new Factory().getPaisDao();
	ProvinciaDAO provinciaDAO = new Factory().getProvinciaDaoImplMysql();
	
//Statements	
	final String add = "INSERT INTO prog_avanzada.aeropuerto (codigo_aeropuerto, ciudad, id_pais, id_provincia) VALUES(?,?,?,?)";
	final String delete = "DELETE FROM prog_avanzada.aeropuerto WHERE id_aeropuerto = ?";
	final String update = "UPDATE prog_avanzada.aeropuerto set codigo_aeropuerto = ?, ciudad = ? WHERE id_aeropuerto = ? ";
	final String ListAll = "SELECT * FROM prog_avanzada.aeropuerto";
	final String get = "SELECT * FROM prog_avanzada.aeropuerto WHERE id_aeropuerto = ?";
	final String CONSULTAPORCODIGO = "SELECT * FROM prog_avanzada.aeropuerto WHERE codigo_aeropuerto = ?";
	final String OBTENERCODIGOS = "SELECT codigo_aeropuerto FROM prog_avanzada.aeropuerto";
	
	
	@Override
	public void altaAeropuerto(Aeropuerto aeropuerto) {
		
	//Realizo la conexión	
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {		
			conexion = sql.getConnection();
			ps = conexion.prepareStatement(add);
			
		//Seteo los parámetros	
			ps.setString(1, aeropuerto.getIdentificacion());
			ps.setString(2, aeropuerto.getCiudad());
			ps.setInt(3, aeropuerto.getPais().getId_pais());
			ps.setInt(4, aeropuerto.getProvincia().getId_provincia());
			ps.executeUpdate();	
			} 
			catch (SQLException e) { e.printStackTrace();}
			finally {	
		//Cierro las conexiones		
			try {ps.close();conexion.close();}
			catch(Exception e) {e.printStackTrace();}
		}
		
	}
		

	@Override
	public void bajaAeropuerto(String codigo_aeropuerto) {
		
	//Realizo la conexión	
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {
			conexion = sql.getConnection();
			ps = conexion.prepareCall(delete);
			
		//Seteo los parámetros	
			ps.setString(1, codigo_aeropuerto);
			ps.executeUpdate();	
			
		//Cierro la conexión	
			ps.close();
			conexion.close();
			
		}catch (SQLException e) {e.printStackTrace();}
	}

	@Override
	public void modificacionAeropuerto(Aeropuerto aeropuerto) {
		
	//Realizo la conexión	
		Connection conexion = null;
		PreparedStatement ps = null;
		
		try {
			conexion = sql.getConnection();
			ps = conexion.prepareCall(update);
			
		//Seteo los parámetros	
			ps.setString(1, aeropuerto.getIdentificacion());
			ps.setString(2, aeropuerto.getCiudad());
			ps.setInt(3, aeropuerto.getId_Aeropuerto());
			ps.executeUpdate();
	     	
	     //Cierro la conexión
	     	ps.close();
			conexion.close();
			} catch (SQLException e) {e.printStackTrace();}	
		}

	@Override
	public List<Aeropuerto> ListAllAeropuerto() {
		
	//Realizo la conexión	
		Connection conexion = null;
		PreparedStatement ps = null;
		List<Aeropuerto> lista= new ArrayList<>();
		try {
			conexion = sql.getConnection();
		    ps = conexion.prepareStatement(ListAll);
			ResultSet rs = ps.executeQuery();    
			while(rs.next()) {
				
			//Obtengo los datos y creo un objeto aeropuerto	 
				String identificador = (rs.getString(("numero_vuelo")));
				String ciudad = (rs.getString("ciudad"));
					   
				Aeropuerto aeropuerto = new Aeropuerto(identificador,ciudad,null,null);
				
			//Agrego el aeropuerto a la lista	
				lista.add(aeropuerto);
			}
			ps.close();
			conexion.close();
					
		} catch (SQLException e) {e.printStackTrace();}
		return lista;	
	}
		


	@Override
	public Aeropuerto getAeropuerto(Integer id_aeropuerto) {
		
	//Realizo la conexión
		Connection conexion = null;
	    PreparedStatement ps = null;	    
		try {	 
			conexion = sql.getConnection();
		    ps = conexion.prepareStatement(get);
		    
		//Seteo el parámetro    
		    ps.setInt(1, id_aeropuerto);
		    ResultSet rs = ps.executeQuery();
				    
			while(rs.next()) {
			//Obtengo los datos y creo un objeto aeropuerto	
				Integer id = rs.getInt("id_aeropuerto");	 
				String codigo = (rs.getString(("codigo_aeropuerto")));
			    String ciudad = (rs.getString("ciudad"));
			    Integer id_pais = rs.getInt("id_pais");
			    Integer id_provincia = rs.getInt("id_provincia");
			    
			//Obtengo los objetos país y provincia a partir de su id    
			    Pais pais = paisDAO.getPaisPorID(id_pais);
			    Provincia provincia = provinciaDAO.getProvincia(id_provincia.toString());
			   
				Aeropuerto aeropuerto = new Aeropuerto(id, codigo, ciudad,pais,provincia);
				return aeropuerto;
			}
			ps.close();
			conexion.close();
		} catch (SQLException e) {e.printStackTrace();}
	return null;}


	@Override
	public Aeropuerto consultaPorCodigo(String codigo_aeropuerto) {
		
	//Realizo la conexión	
		Connection conexion = null;
	    PreparedStatement ps = null;	    
		try {	 
			conexion = sql.getConnection();
		    ps = conexion.prepareStatement(CONSULTAPORCODIGO);
		    
		//Seteo el parámetro    
		    ps.setString(1, codigo_aeropuerto);
		    ResultSet rs = ps.executeQuery();
				    
			while(rs.next()) {
				
			//Obtengo los datos y creo un objeto aeropuerto	
				Integer id = rs.getInt("id_aeropuerto");	 
				String codigo = (rs.getString(("codigo_aeropuerto")));
			    String ciudad = (rs.getString("ciudad"));
			    Integer id_pais = rs.getInt("id_pais");
			    Integer id_provincia = rs.getInt("id_provincia");
			    
			//Obtengo un país y una provincia a partir de sus ids    
			    Pais pais = paisDAO.getPaisPorID(id_pais);
			    Provincia provincia = provinciaDAO.getProvincia(id_provincia.toString());
			   
				Aeropuerto aeropuerto = new Aeropuerto(id, codigo, ciudad,pais,provincia);
				return aeropuerto;
		}
		conexion.close();
	} catch (SQLException e) {e.printStackTrace();}
	return null;
	}


	@Override
	public List<String> obtenerCodigos() {
		
	//Realizo la conexión	
		Connection conexion = null;
		PreparedStatement ps = null;
		List<String> codigos= new ArrayList<>();
			 try {
				 conexion = sql.getConnection();
			     ps = conexion.prepareStatement(OBTENERCODIGOS);
				 ResultSet rs = ps.executeQuery();    
				 while(rs.next()) {
				 //Obtengo el código y lo agrego a la lista 
					String codigo = rs.getString("codigo_aeropuerto");
					codigos.add(codigo);
			     }
			conexion.close();
						
			} catch (SQLException e) {e.printStackTrace();}
			return codigos;	
	}

}
