package dao.Interfaces;

import dao.negocio.Direccion;

public interface DireccionDAO {
	
	public void altaDireccion(Direccion direccion);
	public void bajaDireccion(Direccion direccion);
	public void modificacionDireccion(Direccion direccion);
	public void consultaDireccion(Direccion direccion);
	

}
