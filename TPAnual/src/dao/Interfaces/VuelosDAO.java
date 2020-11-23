package dao.Interfaces;

import java.util.List;

import dao.negocio.Vuelo;

public interface VuelosDAO {

	public void altaVuelo(Vuelo vuelo);
	public void bajaVuelo(String nroDeVuelo);
	public void modificarVuelo(Vuelo vuelo);
	public List<Vuelo> ListAllVuelo();
	public Vuelo getVuelos(Integer idVuelo);
	public List<Integer> obtenerIDs(); 
	
}
