package dao.negocio;

import java.util.Date;

public class Venta {
	
	private int id_Venta;
	private Cliente cliente;
	private Vuelo vuelo;
	private Aerolinea aerolinea;
	private String fecha;
	private String formaDePago;
	
	public Venta(String fecha, String formaDePago, Cliente cliente, Vuelo vuelo, Aerolinea aerolinea) {
		
		this.cliente = cliente;
		this.vuelo = vuelo;
		this.aerolinea = aerolinea;
		this.fecha = fecha;
		this.formaDePago = formaDePago;
	}
	
	public Venta() {}

	public int getId_Venta() {
		return id_Venta;
	}

	public void setId_Venta(int id_Venta) {
		this.id_Venta = id_Venta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	public Aerolinea getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getFormaDePago() {
		return formaDePago;
	}

	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}

	@Override
	public String toString() {
		return "Venta [id_Venta=" + id_Venta + ", cliente=" + cliente + ", vuelo=" + vuelo + ", aerolinea=" + aerolinea
				+ ", fecha=" + fecha + ", formaDePago=" + formaDePago + "]";
	}
	
	
	
}
