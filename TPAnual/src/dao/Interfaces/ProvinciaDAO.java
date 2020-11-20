package dao.Interfaces;

import java.util.List;

import dao.negocio.Provincia;

public interface ProvinciaDAO{

	public void addProvincia(Provincia provincia);
	public void deleteProvincia(String nombre_provincia);
	public void updateProvincia(Provincia provincia);
	public List<Provincia> ListAllProvincia();
	public Provincia getProvincia(String nombre_provincia);
	
	public List<String> obtenerNombres();
	
}
