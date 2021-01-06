package dao.Interfaces;


import java.util.List;

import dao.negocio.Cliente;

public interface ClienteDAO{
	
//ABM y consultas	
	public boolean altaCliente(Cliente cliente);
	public boolean bajaCliente(String dni);
	public boolean modificarCliente(Cliente cliente);

//Consulta por dni	
	public Cliente getCliente(String dni);
	
//Consulta por id cliente	
	public Cliente consultaPorId(Integer id);
	public List<Cliente> ListAllCliente();
	
//Retorna una lista con los IDs de los clientes	
	public List<Integer> obtenerIDs();
	
//Obtiene al último cliente agregado	
	public Cliente obtenerUltimo();

}
