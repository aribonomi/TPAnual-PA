package dao.negocio;

import java.util.Date;

public class Vuelo {
	
	private int id_Vuelo;
	private String numero;
	private int cantidadAsientos;
	private Aeropuerto aeropuertoLlegada;
	private Aeropuerto aeropuertoSalida;
	private Date fechaLlegada;
	private Date fechaSalida;
	private Date tiempoVuelo;
	
	public Vuelo(int id_Vuelo, String numero, int cantidadAsientos, Aeropuerto aeropuertoLlegada,
			Aeropuerto aeropuertoSalida, Date fechaLlegada, Date fechaSalida, Date tiempoVuelo) {
		this.id_Vuelo = id_Vuelo;
		this.numero = numero;
		this.cantidadAsientos = cantidadAsientos;
		this.aeropuertoLlegada = aeropuertoLlegada;
		this.aeropuertoSalida = aeropuertoSalida;
		this.fechaLlegada = fechaLlegada;
		this.fechaSalida = fechaSalida;
		this.tiempoVuelo = tiempoVuelo;
	}

	public int getId_Vuelo() {
		return id_Vuelo;
	}
	public void setId_Vuelo(int id_Vuelo) {
		this.id_Vuelo = id_Vuelo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public int getCantidadAsientos() {
		return cantidadAsientos;
	}
	public void setCantidadAsientos(int cantidadAsientos) {
		this.cantidadAsientos = cantidadAsientos;
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
	public Date getFechaLlegada() {
		return fechaLlegada;
	}
	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public Date getTiempoVuelo() {
		return tiempoVuelo;
	}
	public void setTiempoVuelo(Date tiempoVuelo) {
		this.tiempoVuelo = tiempoVuelo;
	}
	

}
