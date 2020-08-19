package dao.Cliente;

import dao.Vuelo.Aerolinea;

public class PasajeroFrecuente {
	
	private int id_pasajeroFrecuente;
	private String categoria;
	private String numero;
	//FALTA ALIANZA REY
	private Aerolinea aerolinea;
	
	public PasajeroFrecuente(int id_pasajeroFrecuente, String categoria, String numero, Aerolinea aerolinea) {
		this.id_pasajeroFrecuente = id_pasajeroFrecuente;
		this.categoria = categoria;
		this.numero = numero;
		this.aerolinea = aerolinea;
	}

	public int getId_pasajeroFrecuente() {
		return id_pasajeroFrecuente;
	}
	public void setId_pasajeroFrecuente(int id_pasajeroFrecuente) {
		this.id_pasajeroFrecuente = id_pasajeroFrecuente;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Aerolinea getAerolinea() {
		return aerolinea;
	}
	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}
	
	
	
	
}
