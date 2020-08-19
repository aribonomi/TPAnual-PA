package dao.venta;

import java.util.Date;

import dao.Cliente.Cliente;
import dao.Vuelo.Aerolinea;
import dao.Vuelo.Vuelo;

public class Venta {
	
	private int id_Venta;
	private Cliente cliente;
	private Vuelo vuelo;
	private Aerolinea aerolinea;
	private Date fecha;
	private String formaDePago;
	
	public Venta(int id_Venta, Cliente cliente, Vuelo vuelo, Aerolinea aerolinea, Date fecha, String formaDePago) {
		this.id_Venta = id_Venta;
		this.cliente = cliente;
		this.vuelo = vuelo;
		this.aerolinea = aerolinea;
		this.fecha = fecha;
		this.formaDePago = formaDePago;
	}

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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getFormaDePago() {
		return formaDePago;
	}

	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}
	
	
	
}
