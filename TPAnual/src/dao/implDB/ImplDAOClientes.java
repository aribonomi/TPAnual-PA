package dao.implDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.xdevapi.Statement;

import dao.Cliente.Cliente;
import dao.Interfaces.ClienteDAO;
import dao.util.ConexionMySQL;

public class ImplDAOClientes implements ClienteDAO{
	
	List<Cliente> listaClientes;
	ConexionMySQL sql;
	
	

	public ImplDAOClientes(List<Cliente> listaClientes) {
		super();
		this.listaClientes = listaClientes;
		sql = new ConexionMySQL();
		
	}
	
	public ImplDAOClientes() {
		
	}

	@Override
	public void altaCliente(Cliente cliente) {
		listaClientes.add(cliente);
		
	}

	@Override
	public void bajaCliente(String dni) {
		Connection con = null;
		Statement st = null;
		
		try {
			con.setAutoCommit(false);
			
			
			con.commit();
		}catch(SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public void modificarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void consultaCliente(String dni) {
		// TODO Auto-generated method stub
		
	}
	

}
