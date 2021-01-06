package dao.Interfaces;

import java.util.List;

import dao.negocio.Pasaporte;

public interface PasaporteDAO{

//ABM y consultas	
	public boolean addPasaporte(Pasaporte pasaporte);
	public boolean deletePasaporte(String numero_pasaporte);
	public boolean updatePasaporte(Pasaporte pasaporte);
	public List<Pasaporte> ListAllPasaporte();
	public Pasaporte getPasaporte(String numero_pasaporte);
	
//Obtiene el último pasaporte ingresado	
	public Pasaporte obtenerUltimo();
	
}
