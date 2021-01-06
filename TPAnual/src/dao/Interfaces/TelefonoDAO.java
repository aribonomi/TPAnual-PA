package dao.Interfaces;

import java.util.List;

import dao.negocio.Telefono;

public interface TelefonoDAO{

//ABM y consultas	
	public boolean addTelefono(Telefono telefono);
	public boolean deleteTelefono(String id_telefono);
	public boolean updateTelefono(Telefono telefono);
	public List<Telefono> ListAllTelefono();
    public Telefono getTelefono(String id_telefono);
    
//Obtiene el último teléfono ingresado 
    public Telefono obtenerUltimo();

}
