package dao.Vuelo;

import java.util.Date;

public class Vuelo {
	
	private Aeropuerto aeropuertoLlegada;
	private Aeropuerto aeropuertoSalida;
	private int cantidadAsientos;
	private Date fechaHoraLlegada;
	private Date fechaHoraSalida;
	private String nroDeVuelo;
	private String tiempoDeVuelo;
	
	public Vuelo(Aeropuerto aeropuertoLlegada, Aeropuerto aeropuertoSalida, int cantidadAsientos, Date fechaHoraLlegada,
			Date fechaHoraSalida, String nroDeVuelo, String tiempoDeVuelo) {
		this.aeropuertoLlegada = aeropuertoLlegada;
		this.aeropuertoSalida = aeropuertoSalida;
		this.cantidadAsientos = cantidadAsientos;
		this.fechaHoraLlegada = fechaHoraLlegada;
		this.fechaHoraSalida = fechaHoraSalida;
		this.nroDeVuelo = nroDeVuelo;
		this.tiempoDeVuelo = tiempoDeVuelo;
	}
	public Aeropuerto getAeropuertoLlegada() {
		return aeropuertoLlegada;
	}
	public void setAeropuertoLlegada(Aeropuerto aeropuertoLlegada) {
		this.aeropuertoLlegada = aeropuertoLlegada;
	}
	public Aeropuerto getAeropuertoSalida() {
		return aeropuertoSalida;
	}
	public void setAeropuertoSalida(Aeropuerto aeropuertoSalida) {
		this.aeropuertoSalida = aeropuertoSalida;
	}
	public int getCantidadAsientos() {
		return cantidadAsientos;
	}
	public void setCantidadAsientos(int cantidadAsientos) {
		this.cantidadAsientos = cantidadAsientos;
	}
	public Date getFechaHoraLlegada() {
		return fechaHoraLlegada;
	}
	public void setFechaHoraLlegada(Date fechaHoraLlegada) {
		this.fechaHoraLlegada = fechaHoraLlegada;
	}
	public Date getFechaHoraSalida() {
		return fechaHoraSalida;
	}
	public void setFechaHoraSalida(Date fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
	}
	public String getNroDeVuelo() {
		return nroDeVuelo;
	}
	public void setNroDeVuelo(String nroDeVuelo) {
		this.nroDeVuelo = nroDeVuelo;
	}
	public String getTiempoDeVuelo() {
		return tiempoDeVuelo;
	}
	public void setTiempoDeVuelo(String tiempoDeVuelo) {
		this.tiempoDeVuelo = tiempoDeVuelo;
	}
	
	
	

}
