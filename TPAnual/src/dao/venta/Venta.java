package dao.venta;

import java.time.LocalDate;
import java.time.LocalDateTime;

import dao.Cliente.Cliente;
import dao.Vuelo.LineaAerea;
import dao.Vuelo.Vuelo;

public class Venta {
	private Cliente cliente;
	private String formaDePago;
	private LocalDate horaDeVenta;
	private Vuelo vuelo;
	private LineaAerea lineaAerea;
	
	
	public Venta(Cliente cliente, String formaDePago, LocalDate horaDeVenta, Vuelo vuelo, LineaAerea lineaAerea) {
		super();
		this.cliente = cliente;
		this.formaDePago = formaDePago;
		this.horaDeVenta = horaDeVenta;
		this.vuelo = vuelo;
		this.lineaAerea = lineaAerea;
	}


	@Override
	public String toString() {
		return "Venta \nCliente = " + cliente + "\nFormaDePago = " + formaDePago + "\nHoraDeVenta = " + horaDeVenta
				+ "\nVuelo = " + vuelo + "\nLineaAerea = " + lineaAerea;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public String getFormaDePago() {
		return formaDePago;
	}


	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}


	public LocalDate getHoraDeVenta() {
		return horaDeVenta;
	}


	public void setHoraDeVenta(LocalDate horaDeVenta) {
		this.horaDeVenta = horaDeVenta;
	}


	public Vuelo getVuelo() {
		return vuelo;
	}


	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}


	public LineaAerea getLineaAerea() {
		return lineaAerea;
	}


	public void setLineaAerea(LineaAerea lineaAerea) {
		this.lineaAerea = lineaAerea;
	}
	
	
	
}
