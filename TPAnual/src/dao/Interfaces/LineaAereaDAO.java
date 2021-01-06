package dao.Interfaces;

import java.util.List;

import dao.negocio.Aerolinea;

public interface LineaAereaDAO{

//ABM y consultas	
	public boolean altaLineaAerea(Aerolinea aerolinea);
	public boolean bajaLineaAerea(String id_aerolinea);
	public boolean modificarLineaAerea(Aerolinea aerolinea);
	public Aerolinea getLineaArea(String id_aerolinea);
	
//Obtiene la lista de nombres de aerolíneas	
	public List<String> obtenerNombres();
	
//Retorna una aerolína a partir de un nombre	
	public Aerolinea consultarPorNombre(String nombre);
	
}
