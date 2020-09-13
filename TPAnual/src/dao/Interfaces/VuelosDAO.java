package dao.Interfaces;

import dao.negocio.Vuelo;

public interface VuelosDAO {

	public void altaVuelo(Vuelo vuelo);
	public void bajaVuelo(String nroDeVuelo);
	public void modificarVuelo(Vuelo vuelo);
	public void consultaVuelo(String nroDeVuelo);
	
}
