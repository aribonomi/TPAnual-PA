package dao.Interfaces;

import java.util.List;

import dao.negocio.Direccion;

public interface DireccionDAO{
	
	
//ABM y consultas	
	public boolean altaDireccion(Direccion direccion);
	public boolean bajaDireccion(String id_direccion);
	public boolean modificacionDireccion(Direccion direccion);
	public List<Direccion> ListAllDireccion();
	public Direccion getDireccion(String id_direccion);
	
//Obtiene la última dirección ingresada	
	public Direccion obtenerUltimo();

}
