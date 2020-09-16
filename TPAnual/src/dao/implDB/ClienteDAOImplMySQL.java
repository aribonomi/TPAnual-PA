package dao.implDB;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.Interfaces.ClienteDAO;
import dao.negocio.Cliente;
import dao.util.ConexionMySQL;

public class ClienteDAOImplMySQL implements ClienteDAO {

//
	ConexionMySQL sql = new ConexionMySQL();



	@Override
	public void alta(Cliente cliente) {

		Connection conexion = null;
		CallableStatement cst = null;

		try {

			conexion = sql.getConnection();
			cst = conexion.prepareCall("call prog_avanzada.add_cliente(?, ?, ?, ?, ?)");

			cst.setString(1,cliente.getNombre());
			cst.setString(2, cliente.getApellido());
			cst.setString(3, cliente.getDni());
			//cst.setDate(4, (Date) cliente.getFechaNacimiento());
			cst.setString(4, cliente.getCuit_cuil());
			cst.setString(5, cliente.getEmail());

			cst.execute();

			conexion.close();


		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void baja(String dni) {

		Connection conexion = null;
		CallableStatement cst = null;

       
		try {
			conexion = sql.getConnection();
			cst = conexion.prepareCall("call prog_avanzada.delete_cliente(?)");
			cst.setString(1, dni);
			cst.execute();
			conexion.close();


		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void modificacion(Cliente cliente) {

		Connection conexion = null;
		CallableStatement cst = null;

       

		try {


			//cliente.setNombre("Juan");
			//cliente.setApellido("Maxw");
			//cliente.setDNI("42296105");
			//cliente.setCuil("cuit");
			//cliente.setEmail("juan_09@hotmail");

			conexion = sql.getConnection();
			cst = conexion.prepareCall("call prog_avanzada.update_cliente (?, ?, ?, ?, ?)");

			cst.setString(1,cliente.getNombre());
			cst.setString(2, cliente.getApellido());
			cst.setString(3, cliente.getDni());
			//cst.setDate(4, (Date) cliente.getFechaNacimiento());
			cst.setString(4, cliente.getCuit_cuil());
			cst.setString(5, cliente.getEmail());


			cst.execute();

			conexion.close();


		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void consulta(String dni) {


		Connection conexion = null;
		PreparedStatement ps = null;

        Cliente cliente = new Cliente();

        try {

        	conexion = sql.getConnection();
        	String query = "SELECT * FROM prog_avanzada.cliente WHERE dni=?";
        	ps = conexion.prepareStatement(query);


        	ps.setString(1, dni);
        	ResultSet rs = ps.executeQuery();

        	while(rs.next()) {

        		cliente.setId_cliente(rs.getInt("id_cliente"));
        		cliente.setNombre(rs.getString(("nombre")));
        		cliente.setApellido(rs.getString("apellido"));
        		cliente.setDni(rs.getString("dni"));
        		// cliente.setFechaNacimiento(rs.getDate("fecha_de_nacimiento"));
        		cliente.setEmail(rs.getString("email"));
        		cliente.setCuit_cuil(rs.getString("cuit_cuil"));

        	}

        	conexion.close();

       

        } catch (SQLException e) {

        	e.printStackTrace();
        }

	}
}