package dao.Interfaces;

import java.util.List;

import dao.negocio.Aeropuerto;

public interface AeropuertoDAO{
	
	public void altaAeropuerto(Aeropuerto aeropuerto);
	public void bajaAeropuerto(String codigo_aeropuerto);
	public void modificacionAeropuerto(Aeropuerto aeropuerto);
	public List<Aeropuerto> ListAllAeropuerto();
	public Aeropuerto getAeropuerto(Integer id_aeropuerto);
	public Aeropuerto consultaPorCodigo(String codigo_aeropuerto);
	public List<String> obtenerCodigos();
	
	

}
