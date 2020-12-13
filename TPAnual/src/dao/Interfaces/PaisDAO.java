package dao.Interfaces;

import java.util.List;

import dao.negocio.Pais;

public interface PaisDAO{

//ABM y consultas	
	public void addPais(Pais pais);
	public void deletePais(String nombre_pais);
	public void updatePais(Pais pais);
	public List<Pais> ListAllPais();
	public Pais getPaisPorID(Integer id);
	
//Obtiene un país a partir de su nombre	
	public Pais getPais(String nombre_pais);	
	
//Retorna una lista con los nombres de los países	
	public List<String> obtenerNombres();
	
	
	
}
