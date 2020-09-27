package dao.implDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.Interfaces.TelefonoDAO;
import dao.negocio.Direccion;
import dao.negocio.Telefono;
import dao.util.ConexionMySQL;

public class TelefonoDAOImplMySQL implements TelefonoDAO{

	ConexionMySQL sql;
	
	public TelefonoDAOImplMySQL() {
		this.sql = new ConexionMySQL();
	}

	final String INSERTAR = "INSERT INTO telefono (personal, celular, labolar) VALUES(?,?,?)";
	final String ELIMINAR = "DELETE FROM telefono WHERE id_telefono = ?";
	
	final String CONSULTAR = "SELECT * FROM telefono WHERE id_telefono = ?";
	
	@Override
	public void alta(Telefono objeto) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = sql.getConnection();
			pst = con.prepareStatement(INSERTAR);
			
			pst.setString(1, objeto.getPersona());
			pst.setString(2, objeto.getCelular());
			pst.setString(3, objeto.getLaboral());
			
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
	public void modificacion(Telefono objeto) {
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
			
			Telefono t = new Telefono(0, null, null, null);
			
			while(rs.next()) {
				t.setId_Telefono(rs.getInt("id_telefono"));
				t.setPersona(rs.getString("personal"));
				t.setCelular(rs.getString("celular"));
				t.setLaboral(rs.getNString("labolar"));
				System.out.println(t.toString());
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
