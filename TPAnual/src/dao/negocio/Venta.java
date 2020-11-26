package dao.negocio;

import java.util.Date;

public class Venta {
	
	private Integer id_Venta;
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
	
	

	public Venta(Integer id_Venta, Cliente cliente, Vuelo vuelo, Aerolinea aerolinea, String fecha, String formaDePago) {
		super();
		this.id_Venta = id_Venta;
		this.cliente = cliente;
		this.vuelo = vuelo;
		this.aerolinea = aerolinea;
		this.fecha = fecha;
		this.formaDePago = formaDePago;
	}

	public Integer getId_Venta() {
		return id_Venta;
	}

	public void setId_Venta(Integer id_Venta) {
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
		return "Venta \nId: " + id_Venta + "\nCliente: " + cliente + "\nVuelo: " + vuelo + "\nAerolinea: " + aerolinea
				+ "\nFecha: " + fecha + "\nForma de pago: " + formaDePago;
	}
	
	
	
}
