package dao.Interfaces;

import java.util.List;

import dao.negocio.PasajeroFrecuente;

public interface PasajeroFrecuenteDAO{

	public void addPasajeroFrecuente(PasajeroFrecuente pasajerofrecuente);
	public void deletePasajeroFrecuente(String id_pasajero_frecuente);
	public void updatePasajeroFrecuente(PasajeroFrecuente pasajerofrecuente);
	public List<PasajeroFrecuente> ListAllPasajeroFrecuente();
	public PasajeroFrecuente getPasajeroFrecuente(String id_pasajero_frecuente);

}
