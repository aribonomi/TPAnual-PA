package dao.Interfaces;

import dao.negocio.Aeropuerto;

public interface AeropuertoDAO {
	
	public void altaAeropuerto(Aeropuerto aeropuerto);
	public void bajaAeropuerto(Aeropuerto aeropuerto);
	public void modificacionAeropuerto(Aeropuerto aeropuerto);
	public void consultaAeropuerto(Aeropuerto aeropuerto);

}
