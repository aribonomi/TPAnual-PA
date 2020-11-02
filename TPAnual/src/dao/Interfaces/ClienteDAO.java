package dao.Interfaces;


import java.util.List;

import dao.negocio.Cliente;

public interface ClienteDAO{
	
	public void altaCliente(Cliente cliente);
	public void bajaCliente(String dni);
	public void modificarCliente(Cliente cliente);
	public Cliente getCliente(String dni);
	public List<Cliente> ListAllCliente();

}
