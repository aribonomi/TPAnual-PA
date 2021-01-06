package dao.Interfaces;

import java.util.List;

import dao.negocio.PasajeroFrecuente;

public interface PasajeroFrecuenteDAO{

//ABM y consultas	
	public boolean addPasajeroFrecuente(PasajeroFrecuente pasajerofrecuente);
	public boolean deletePasajeroFrecuente(String id_pasajero_frecuente);
	public boolean updatePasajeroFrecuente(PasajeroFrecuente pasajerofrecuente);
	public List<PasajeroFrecuente> ListAllPasajeroFrecuente();
	public PasajeroFrecuente getPasajeroFrecuente(String id_pasajero_frecuente);
	
//Obtiene el último pasajero frecuente ingresado	
	public PasajeroFrecuente obtenerUltimo();

}
