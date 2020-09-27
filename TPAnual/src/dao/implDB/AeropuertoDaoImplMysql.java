package dao.implDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.Interfaces.AeropuertoDAO;
import dao.negocio.Aeropuerto;
import dao.negocio.Direccion;
import dao.util.ConexionMySQL;

public class AeropuertoDaoImplMysql implements AeropuertoDAO {
	
	ConexionMySQL sql;
	
	public AeropuertoDaoImplMysql() {
		this.sql = new ConexionMySQL();
	}

	final String INSERTAR = "INSERT INTO aeropuerto (codigo_aeropuerto, ciudad, id_pais, id_provincia) VALUES(?,?,?,?)";
	final String ELIMINAR = "DELETE FROM aeropuerto WHERE id_aeropuerto = ?";
	
	final String CONSULTAR = "SELECT * FROM aeropuerto WHERE id_aeropuerto = ?";

	@Override
	public void alta(Aeropuerto objeto) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = sql.getConnection();
			pst = con.prepareStatement(INSERTAR);
			
			pst.setString(1, objeto.getIdentificacion());
			pst.setString(2, objeto.getCiudad());
			pst.setInt(3, objeto.getPais().getId_pais());
			pst.setInt(4, objeto.getProvincia().getId_provincia());
			
			int registrosIngresados = pst.executeUpdate();
			
			System.out.println(registrosIngresados+" registro(s) ingresado(s)");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public void baja(String id) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = sql.getConnection();
			pst = con.prepareStatement(ELIMINAR);
			
			pst.setString(1, id);//Este id es un String y el id de mySQL es un int. No se si eso va a traer problemas
			
			int registrosActualizados = pst.executeUpdate();
			
			System.out.println(registrosActualizados+" registro(s) actualizado(s)");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public void modificacion(Aeropuerto objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void consulta(String id) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = sql.getConnection();
			pst = con.prepareStatement(CONSULTAR);
			ResultSet rs = pst.executeQuery();
			
			pst.setString(1, id);
			
			Aeropuerto a = new Aeropuerto(0, null, null, null, null);
			
			while(rs.next()) {
				a.setId_Aeropuerto(rs.getInt("id_aeropuerto"));
				a.setIdentificacion(rs.getString("codigo_aeropuerto"));
				a.setCiudad(rs.getNString("ciudad"));
				a.getPais().setId_pais(rs.getInt("id_pais"));
				a.getProvincia().setId_provincia(rs.getInt("id_provincia"));
				System.out.println(a.toString());
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
