package dao.implDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

import dao.Interfaces.PasaporteDAO;
import dao.negocio.Pasaporte;
import dao.util.ConexionMySQL;

public class PasaporteDAOImplMySQL implements PasaporteDAO{
	
	ConexionMySQL sql;

	final String INSERTAR = "INSERT INTO pasaporte (numero_pasaporte, autoridad_emision, fecha_emision, fecha_vencimiento, id_pais) VALUES(?,?,?,?,?)";
	final String ELIMINAR = "DELETE FROM pasaporte WHERE id_pasaporte = ?";
	
	final String CONSULTAR = "SELECT * FROM pasaporte WHERE id_pasaporte = ?";

	public PasaporteDAOImplMySQL() {
		this.sql = new ConexionMySQL();
	}

	@Override
	public void alta(Pasaporte objeto) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = sql.getConnection();
			pst = con.prepareStatement(INSERTAR);
			
			pst.setString(1, objeto.getNumero());
			pst.setString(2, objeto.getAutoridadEmision());
			pst.setDate(3, new Date(objeto.getFechaEmision().getTime()));
			pst.setDate(4, new Date(objeto.getFechaVencimiento().getTime()));
			pst.setInt(5, objeto.getPaisEmision().getId_pais());
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificacion(Pasaporte objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void consulta(String id) {
		// TODO Auto-generated method stub
		
	}

}
