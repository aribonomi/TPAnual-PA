package dao.Interfaces;

import java.util.List;

import dao.negocio.Pais;

public interface PaisDAO{

//ABM y consultas	
	public boolean addPais(Pais pais);
	public boolean deletePais(String nombre_pais);
	public boolean updatePais(Pais pais);
	public List<Pais> ListAllPais();
	public Pais getPaisPorID(Integer id);
	
//Obtiene un pa�s a partir de su nombre	
	public Pais getPais(String nombre_pais);	
	
//Retorna una lista con los nombres de los pa�ses	
	public List<String> obtenerNombres();
	
	
	
}
