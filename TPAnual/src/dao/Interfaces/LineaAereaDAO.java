package dao.Interfaces;

import java.util.List;

import dao.negocio.Aerolinea;

public interface LineaAereaDAO{

//ABM y consultas	
	public void altaLineaAerea(Aerolinea aerolinea);
	public void bajaLineaAerea(String id_aerolinea);
	public void modificarLineaAerea(Aerolinea aerolinea);
	public Aerolinea getLineaArea(String id_aerolinea);
	
//Obtiene la lista de nombres de aerol�neas	
	public List<String> obtenerNombres();
	
//Retorna una aerol�na a partir de un nombre	
	public Aerolinea consultarPorNombre(String nombre);
	
}
