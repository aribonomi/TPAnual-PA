package dao.Cliente;

import java.util.Date;

public class Cliente {
	
	private String cuil;
	private String DNI;
	private String email;
	private Date FechaNacimiento;
	private String nombreApellido;
	private PasajeroFrecuente pasajerofrecuente;
	private Pasaporte pasaporte;
	private Telefono telefono;
	private Direccion direccion;
	
	public Cliente(String cuil, String DNI, String email, Date fechaNacimiento, String nombreApellido,
			PasajeroFrecuente pasajerofrecuente, Pasaporte pasaporte, Telefono telefono, Direccion direccion) {
		this.cuil = cuil;
		this.DNI = DNI;
		this.email = email;
		this.FechaNacimiento = fechaNacimiento;
		this.nombreApellido = nombreApellido;
		this.pasajerofrecuente = pasajerofrecuente;
		this.pasaporte = pasaporte;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	
	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return FechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public PasajeroFrecuente getPasajerofrecuente() {
		return pasajerofrecuente;
	}

	public void setPasajerofrecuente(PasajeroFrecuente pasajerofrecuente) {
		this.pasajerofrecuente = pasajerofrecuente;
	}

	public Pasaporte getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(Pasaporte pasaporte) {
		this.pasaporte = pasaporte;
	}

	public Telefono getTelefono() {
		return telefono;
	}

	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
	}
	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
}
