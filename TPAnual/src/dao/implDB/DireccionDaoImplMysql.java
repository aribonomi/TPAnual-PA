package dao.implDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

import dao.Interfaces.DireccionDAO;
import dao.negocio.Direccion;
import dao.util.ConexionMySQL;

public class DireccionDaoImplMysql implements DireccionDAO{
	
	ConexionMySQL sql;
	
	public DireccionDaoImplMysql() {
		this.sql = new ConexionMySQL();
	}

	final String INSERTAR = "INSERT INTO direccion (altura, calle, ciudad, codigo_postal, id_pais, id_provincia) VALUES(?,?,?,?,?,?)";
	final String ELIMINAR = "DELETE FROM direccion WHERE id_direccion = ?";
	
	final String CONSULTAR = "SELECT * FROM direccion WHERE id_direccion = ?";
	
	@Override
	public void alta(Direccion objeto) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = sql.getConnection();
			pst = con.prepareStatement(INSERTAR);
			
			pst.setString(1, objeto.getAltura());
			pst.setString(2, objeto.getCalle());
			pst.setString(3, objeto.getCiudad());
			pst.setString(4, objeto.getCodigoPostal());
			pst.setInt(5, objeto.getPais().getId_pais());//Cambié los id de provincia y país a int
			pst.setInt(6, objeto.getProvincia().getId_provincia());
			
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
	public void modificacion(Direccion objeto) {
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
			
			Direccion d = new Direccion(0, null, null, null, null, null, null);
			
			while(rs.next()) {
				d.setId_direccion(rs.getInt("id_direccion"));
				d.setAltura(rs.getString("altura"));
				d.setCalle(rs.getString("calle"));
				d.setCiudad(rs.getNString("ciudad"));
				d.setCodigoPostal("codigo_postal");
				d.getPais().setId_pais(rs.getInt("id_pais"));
				d.getProvincia().setId_provincia(rs.getInt("id_provincia"));
				System.out.println(d.toString());
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
