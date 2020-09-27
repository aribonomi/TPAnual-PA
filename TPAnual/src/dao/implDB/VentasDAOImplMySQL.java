package dao.implDB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.Interfaces.VentasDAO;
import dao.negocio.Direccion;
import dao.negocio.Venta;
import dao.util.ConexionMySQL;

public class VentasDAOImplMySQL implements VentasDAO{
	
	ConexionMySQL sql;
	
	public VentasDAOImplMySQL() {
		this.sql = new ConexionMySQL();
	}

	final String INSERTAR = "INSERT INTO ventas (fecha_hora_venta, forma_pago, id_cliente, id_vuelo, id_aerolinea) VALUES(?,?,?)";
	final String ELIMINAR = "DELETE FROM ventas WHERE id_venta = ?";
	
	final String CONSULTAR = "SELECT * FROM ventas WHERE id_venta = ?";

	@Override
	public void alta(Venta objeto) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = sql.getConnection();
			pst = con.prepareStatement(INSERTAR);
			
			pst.setDate(1, new Date(objeto.getFecha().getTime()));
			pst.setString(2, objeto.getFormaDePago());
			pst.setInt(3, objeto.getCliente().getId_cliente());
			pst.setInt(4, objeto.getVuelo().getId_Vuelo());
			pst.setInt(5, objeto.getAerolinea().getId_aeroLinea());
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
	public void modificacion(Venta objeto) {
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
			
			Venta d = new Venta(0, null, null, null, null, null);
			
			while(rs.next()) {
				d.setId_Venta(rs.getInt("id_venta"));
				d.setFecha(rs.getDate("fecha_hora_venta"));
				d.setFormaDePago(rs.getString("forma_pago"));
				d.getCliente().setId_cliente(rs.getInt("id_cliente"));
				d.getVuelo().setId_Vuelo(rs.getInt("id_vuelo"));
				d.getAerolinea().setId_aeroLinea(rs.getInt("id_aerolinea"));
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
