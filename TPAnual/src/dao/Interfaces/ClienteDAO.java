package dao.Interfaces;

import dao.Cliente.Cliente;

public interface ClienteDAO {
	
	public void altaCliente(Cliente cliente);
	public void bajaCliente(String dni);
	public void modificarCliente(Cliente cliente);
	public void consultaCliente(String dni);

}
