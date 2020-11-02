package dao.Interfaces;

import java.util.List;

import dao.negocio.Pasaporte;

public interface PasaporteDAO{

	public void addPasaporte(Pasaporte pasaporte);
	public void deletePasaporte(String numero_pasaporte);
	public void updatePasaporte(Pasaporte pasaporte);
	public List<Pasaporte> ListAllPasaporte();
	public Pasaporte getPasaporte(String numero_pasaporte);
	
}
