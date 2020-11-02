package dao.Interfaces;

import java.util.List;

import dao.negocio.Direccion;

public interface DireccionDAO{
	
	public void altaDireccion(Direccion direccion);
	public void bajaDireccion(String id_direccion);
	public void modificacionDireccion(Direccion direccion);
	public List<Direccion> ListAllDireccion();
	public Direccion getDireccion(String id_direccion);

}
