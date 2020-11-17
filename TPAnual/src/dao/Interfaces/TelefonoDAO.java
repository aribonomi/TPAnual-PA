package dao.Interfaces;

import java.util.List;

import dao.negocio.Telefono;

public interface TelefonoDAO{

	
	public void addTelefono(Telefono telefono);
	public void deleteTelefono(String id_telefono);
	public void updateTelefono(Telefono telefono);
	public List<Telefono> ListAllTelefono();
    public Telefono getTelefono(String id_telefono);
    public Telefono obtenerUltimo();

}
