package dao.negocio;

import java.util.Date;

public class Vuelo {
	
	private int id_Vuelo;
	private String numero;
	private int cantidadAsientos;
	private Aeropuerto aeropuertoLlegada;
	private Aeropuerto aeropuertoSalida;
	private String fechaLlegada;
	private String fechaSalida;
	private String tiempoVuelo;
	private Aerolinea aerolinea;
	
	public Vuelo(String numero, int cantidadAsientos,String fechaLlegada, String fechaSalida, String tiempoVuelo, Aeropuerto aeropuertoLlegada,Aeropuerto aeropuertoSalida, Aerolinea aerolinea) {
		
		this.numero = numero;
		this.cantidadAsientos = cantidadAsientos;
		this.aeropuertoLlegada = aeropuertoLlegada;
		this.aeropuertoSalida = aeropuertoSalida;
		this.fechaLlegada = fechaLlegada;
		this.fechaSalida = fechaSalida;
		this.tiempoVuelo = tiempoVuelo;
		this.aerolinea = aerolinea;
	}
	public Vuelo() { }
	
	
	

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
	public String getFechaLlegada() {
		return fechaLlegada;
	}
	public void setFechaLlegada(String fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}
	public String getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public String getTiempoVuelo() {
		return tiempoVuelo;
	}
	public void setTiempoVuelo(String tiempoVuelo) {
		this.tiempoVuelo = tiempoVuelo;
	}
	
	
	public Aerolinea getAerolinea() {
		return aerolinea;
	}
	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}
	@Override
	public String toString() {
		return "Vuelo \nID= " + id_Vuelo + "\nNúmero= " + numero + "\nCantidadAsientos= " + cantidadAsientos
				+ "\nAeropuerto Llegada= " + aeropuertoLlegada + "\nAeropuerto Salida= " + aeropuertoSalida
				+ "\nFecha Llegada= " + fechaLlegada + "\nFecha Salida= " + fechaSalida + "\nTiempo Vuelo= " + tiempoVuelo
				+ "\nAerolinea= " + aerolinea;
	}
	
	
	
	

}
