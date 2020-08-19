package dao.Cliente;

import java.util.*;
import dao.Vuelo.Pais;

public class Pasaporte {
	
	private int id_Pasaporte;
	private String numero;
	private String autoridadEmision;
	private Date fechaEmision;
	private Date fechaVencimiento;
	private Pais paisEmision;
	
	
	public Pasaporte(int id_Pasaporte, String numero, String autoridadEmision, Date fechaEmision, Date fechaVencimiento,
			Pais paisEmision) {
		this.id_Pasaporte = id_Pasaporte;
		this.numero = numero;
		this.autoridadEmision = autoridadEmision;
		this.fechaEmision = fechaEmision;
		this.fechaVencimiento = fechaVencimiento;
		this.paisEmision = paisEmision;
	}
	
	
	public int getId_Pasaporte() {
		return id_Pasaporte;
	}
	public void setId_Pasaporte(int id_Pasaporte) {
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
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public Pais getPaisEmision() {
		return paisEmision;
	}
	public void setPaisEmision(Pais paisEmision) {
		this.paisEmision = paisEmision;
	}
	
	
	
	
}
