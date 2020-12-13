package dao.Interfaces;

import java.util.List;

import dao.negocio.Aeropuerto;

public interface AeropuertoDAO{
	
//ABM y consultas	
	public void altaAeropuerto(Aeropuerto aeropuerto);
	public void bajaAeropuerto(String codigo_aeropuerto);
	public void modificacionAeropuerto(Aeropuerto aeropuerto);
	public List<Aeropuerto> ListAllAeropuerto();
	public Aeropuerto getAeropuerto(Integer id_aeropuerto);
	
//Retorna un aeropuerto a partir de un código	
	public Aeropuerto consultaPorCodigo(String codigo_aeropuerto);
	
//Retorna una lista con los códigos de vuelo	
	public List<String> obtenerCodigos();
	
	

}
