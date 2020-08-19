package dao.Vuelo;

import java.util.List;

public class Aerolinea {

	private int id_aeroLinea;
	private String nombre;
	private List<Vuelo> vuelos;
	// Alianza
	
	public Aerolinea(int id_aeroLinea, String nombre, List<Vuelo> vuelos) {
		this.id_aeroLinea = id_aeroLinea;
		this.nombre = nombre;
		this.vuelos = vuelos;
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

	
	
}
