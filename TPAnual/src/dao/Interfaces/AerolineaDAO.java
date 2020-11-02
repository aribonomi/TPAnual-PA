package dao.Interfaces;

import java.util.List;

import dao.negocio.Aerolinea;

public interface AerolineaDAO {

	public void addAerolinea(Aerolinea aerolinea);
	public void deleteAerolinea(String nombre_aerolinea);
	public void updateAerolinea(Aerolinea aerolinea);
	public List<Aerolinea> ListAllAerolinea();
	public Aerolinea getAerolinea(String nombre_Aerolinea);

}
