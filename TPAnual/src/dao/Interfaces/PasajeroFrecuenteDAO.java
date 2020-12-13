package dao.Interfaces;

import java.util.List;

import dao.negocio.PasajeroFrecuente;

public interface PasajeroFrecuenteDAO{

//ABM y consultas	
	public void addPasajeroFrecuente(PasajeroFrecuente pasajerofrecuente);
	public void deletePasajeroFrecuente(String id_pasajero_frecuente);
	public void updatePasajeroFrecuente(PasajeroFrecuente pasajerofrecuente);
	public List<PasajeroFrecuente> ListAllPasajeroFrecuente();
	public PasajeroFrecuente getPasajeroFrecuente(String id_pasajero_frecuente);
	
//Obtiene el �ltimo pasajero frecuente ingresado	
	public PasajeroFrecuente obtenerUltimo();

}
