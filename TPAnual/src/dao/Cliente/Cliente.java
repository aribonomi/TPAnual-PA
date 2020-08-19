package dao.Cliente;

public class Cliente {
	
	private String id_cliente;
	private String nombre;
	private String apellido;
	private String dni;
	private String cuit_cuil;
	private String fecha_nacimiento;
	private String email;
	private Direccion direccion;
	private Telefono telefono;
	private Pasaporte pasaporte;
	private PasajeroFrecuente pasajeroFrecuente;
	
	public Cliente(String id_cliente, String nombre, String apellido, String dni, String cuit_cuil,
			String fecha_nacimiento, String email, Direccion direccion, Telefono telefono, Pasaporte pasaporte,
			PasajeroFrecuente pasajeroFrecuente) {
		this.id_cliente = id_cliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.cuit_cuil = cuit_cuil;
		this.fecha_nacimiento = fecha_nacimiento;
		this.email = email;
		this.direccion = direccion;
		this.telefono = telefono;
		this.pasaporte = pasaporte;
		this.pasajeroFrecuente = pasajeroFrecuente;
	}

	public String getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDmo(String dni) {
		this.dni = dni;
	}
	public String getCuit_cuil() {
		return cuit_cuil;
	}
	public void setCuit_cuil(String cuit_cuil) {
		this.cuit_cuil = cuit_cuil;
	}
	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Direccion getdireccion() {
		return direccion;
	}
	public void setId_direccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public Telefono gettelefono() {
		return telefono;
	}
	public void setId_telefono(Telefono telefono) {
		this.telefono = telefono;
	}
	public Pasaporte getpasaporte() {
		return pasaporte;
	}
	public void setId_pasaporte(Pasaporte pasaporte) {
		this.pasaporte = pasaporte;
	}
	public PasajeroFrecuente getpasajeroFrecuente() {
		return pasajeroFrecuente;
	}
	public void setpasajeroFrecuente(PasajeroFrecuente pasajeroFrecuente) {
		this.pasajeroFrecuente = pasajeroFrecuente;
	}
	
}
