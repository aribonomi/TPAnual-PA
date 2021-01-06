package dao.Interfaces;

import java.util.List;

import dao.negocio.Provincia;

public interface ProvinciaDAO{

//ABM y consultas	
	public boolean addProvincia(Provincia provincia);
	public boolean deleteProvincia(String nombre_provincia);
	public boolean updateProvincia(Provincia provincia);
	public List<Provincia> ListAllProvincia();
	public Provincia getProvincia(String id_provincia);
	
//Obtiene una provincia a partir de su nombre	
	public Provincia getProvinciaPorNombre(String nombre_provincia);
	
//Retorna una ista con los nombres de las provincias	
	public List<String> obtenerNombres();
	
}
