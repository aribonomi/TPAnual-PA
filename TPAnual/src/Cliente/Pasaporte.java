package Cliente;

import java.util.*;

public class Pasaporte {
	
	private String autridadDeEmision;
	private Date fechaEmision;
	private Date fechaVencimiento;
	private String nroPasaporte;
	private String paisDeEmision;
	
	public Pasaporte(String autridadDeEmision, Date fechaEmision, Date fechaVencimiento, String nroPasaporte, String paisDeEmision) {
		this.autridadDeEmision = autridadDeEmision;
		this.fechaEmision = fechaEmision;
		this.fechaVencimiento = fechaVencimiento;
		this.nroPasaporte = nroPasaporte;
		this.paisDeEmision = paisDeEmision;
	}

	public String getAutridadDeEmision() {
		return autridadDeEmision;
	}

	public void setAutridadDeEmision(String autridadDeEmision) {
		this.autridadDeEmision = autridadDeEmision;
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

	public String getNroPasaporte() {
		return nroPasaporte;
	}

	public void setNroPasaporte(String nroPasaporte) {
		this.nroPasaporte = nroPasaporte;
	}

	public String getPaisDeEmision() {
		return paisDeEmision;
	}

	public void setPaisDeEmision(String paisDeEmision) {
		this.paisDeEmision = paisDeEmision;
	}
	
	
	

}
