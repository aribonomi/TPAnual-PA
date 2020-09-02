package dao.Vuelo;

import java.util.List;

import dao.Cliente.Alianza;

public class Aerolinea {

	private int id_aeroLinea;
	private String nombre;
	private List<Vuelo> vuelos;
	private Alianza alianza;
	
	public Aerolinea(int id_aeroLinea, String nombre, List<Vuelo> vuelos, Alianza alianza) {
		this.id_aeroLinea = id_aeroLinea;
		this.nombre = nombre;
		this.vuelos = vuelos;
		this.alianza = alianza;
	}

	public int getId_aeroLinea() {
		return id_aeroLinea;
	}

	public void setId_aeroLinea(int id_aeroLinea) {
		this.id_aeroLinea = id_aeroLinea;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Vuelo> getVuelos() {
		return vuelos;
	}

	public void setVuelos(List<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

	public Alianza getAlianza() {
		return alianza;
	}

	public void setAlianza(Alianza alianza) {
		this.alianza = alianza;
	}
	
	

	
	
}
