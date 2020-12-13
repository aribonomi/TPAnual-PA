package dao.Interfaces;

import java.util.List;

import dao.negocio.Direccion;

public interface DireccionDAO{
	
	
//ABM y consultas	
	public void altaDireccion(Direccion direccion);
	public void bajaDireccion(String id_direccion);
	public void modificacionDireccion(Direccion direccion);
	public List<Direccion> ListAllDireccion();
	public Direccion getDireccion(String id_direccion);
	
//Obtiene la �ltima direcci�n ingresada	
	public Direccion obtenerUltimo();

}
