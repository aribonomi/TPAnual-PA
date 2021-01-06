package dao.Interfaces;

import java.util.List;

import dao.negocio.Vuelo;

public interface VuelosDAO {

//ABM y consultas	
	public boolean altaVuelo(Vuelo vuelo);
	public boolean bajaVuelo(String nroDeVuelo);
	public boolean modificarVuelo(Vuelo vuelo);
	public List<Vuelo> ListAllVuelo();
	public Vuelo getVuelos(Integer idVuelo);
	public List<Integer> obtenerIDs(); 
	
//Obtiene el último vuelo ingresado	
	public Vuelo obtenerUltimo();
	
}
