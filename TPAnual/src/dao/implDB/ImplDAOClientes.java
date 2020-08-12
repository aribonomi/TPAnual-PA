package dao.implDB;

import java.util.List;

import dao.Cliente.Cliente;
import dao.Interfaces.ClienteDAO;

public class ImplDAOClientes implements ClienteDAO{
	
	List<Cliente> listaClientes;
	
	

	public ImplDAOClientes(List<Cliente> listaClientes) {
		super();
		this.listaClientes = listaClientes;
	}

	@Override
	public void altaCliente(Cliente cliente) {
		listaClientes.add(cliente);
		
	}

	@Override
	public void bajaCliente(String dni) {
		// TODO Auto-generated method stub
		
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
