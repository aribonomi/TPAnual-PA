package dao.implDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.Interfaces.PasajeroFrecuenteDAO;
import dao.negocio.Direccion;
import dao.negocio.PasajeroFrecuente;
import dao.util.ConexionMySQL;

public class PasajeroFrecuenteDAOImplMySQL implements PasajeroFrecuenteDAO{
	
	ConexionMySQL sql;

	final String INSERTAR = "INSERT INTO pasajero_frecuente (alianza, numero, categoria, id_aerolinea) VALUES(?,?,?,?,?)";
	final String ELIMINAR = "DELETE FROM pasajero_frecuente WHERE id_pasajero_frecuente = ?";
	
	final String CONSULTAR = "SELECT * FROM pasajero_frecuente WHERE id_pasajero_frecuente = ?";
	
	public PasajeroFrecuenteDAOImplMySQL() {
		this.sql = new ConexionMySQL();
	}

	@Override
	public void alta(PasajeroFrecuente objeto) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = sql.getConnection();
			pst = con.prepareStatement(INSERTAR);
			
			pst.setString(1, objeto.getAlianza().toString());
			pst.setString(2, objeto.getNumero());
			pst.setString(3, objeto.getCategoria());
			pst.setInt(4, objeto.getAerolinea().getId_aeroLinea());
			
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
	public void modificacion(PasajeroFrecuente objeto) {
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
			
			PasajeroFrecuente p = new PasajeroFrecuente(0, null, null, null, null);
			
			while(rs.next()) {
				p.setId_pasajeroFrecuente(rs.getInt("id_pasajero_frecuente"));
				//No se cómo setear una alianza porque es un enumerator
				p.setNumero(rs.getString("numero"));
				p.setCategoria(rs.getString("categoria"));
				p.getAerolinea().setId_aeroLinea(rs.getInt("id_aerolinea"));
				
				System.out.println(p.toString());
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
