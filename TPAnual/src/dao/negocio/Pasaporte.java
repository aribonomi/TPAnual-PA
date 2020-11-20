package dao.negocio;

import java.util.*;

public class Pasaporte {
	
	private Integer id_Pasaporte;
	private String numero;
	private String autoridadEmision;
	private String fechaEmision;
	private String fechaVencimiento;
	private Pais paisEmision;
	
	
	public Pasaporte(String numero, String autoridadEmision, String fechaEmision, String fechaVencimiento,
			Pais paisEmision) {
		
		this.numero = numero;
		this.autoridadEmision = autoridadEmision;
		this.fechaEmision = fechaEmision;
		this.fechaVencimiento = fechaVencimiento;
		this.paisEmision = paisEmision;
	}
	
	
	
	public Pasaporte(Integer id_Pasaporte, String numero, String autoridadEmision, String fechaEmision,
			String fechaVencimiento, Pais paisEmision) {
		super();
		this.id_Pasaporte = id_Pasaporte;
		this.numero = numero;
		this.autoridadEmision = autoridadEmision;
		this.fechaEmision = fechaEmision;
		this.fechaVencimiento = fechaVencimiento;
		this.paisEmision = paisEmision;
	}


	public Integer getId_Pasaporte() {
		return id_Pasaporte;
	}
	public void setId_Pasaporte(Integer id_Pasaporte) {
		this.id_Pasaporte = id_Pasaporte;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getAutoridadEmision() {
		return autoridadEmision;
	}
	public void setAutoridadEmision(String autoridadEmision) {
		this.autoridadEmision = autoridadEmision;
	}
	public String getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public Pais getPaisEmision() {
		return paisEmision;
	}
	public void setPaisEmision(Pais paisEmision) {
		this.paisEmision = paisEmision;
	}


	@Override
	public String toString() {
		return "Pasaporte [id_Pasaporte=" + id_Pasaporte + ", numero=" + numero + ", autoridadEmision="
				+ autoridadEmision + ", fechaEmision=" + fechaEmision + ", fechaVencimiento=" + fechaVencimiento
				+ ", paisEmision=" + paisEmision + "]";
	}
	
	
	
	
}
