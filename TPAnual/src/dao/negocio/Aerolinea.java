package dao.negocio;

import java.util.List;

public class Aerolinea {

	private int id_aeroLinea;
	private String nombre;
	private Alianza alianza;
	
	public Aerolinea(String nombre, Alianza alianza) {
		
		this.nombre = nombre;
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


	public Alianza getAlianza() {
		return alianza;
	}

	public void setAlianza(Alianza alianza) {
		this.alianza = alianza;
	}

	@Override
	public String toString() {
		return "Aerolinea \nID =" + id_aeroLinea + " \nNombre= " + nombre + "\nAlianza=" + alianza;
	}

	
	
	

	
	
}
