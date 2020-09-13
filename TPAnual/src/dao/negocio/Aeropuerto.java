package dao.negocio;

public class Aeropuerto {
	
	private int id_Aeropuerto;
	private String identificacion;
	private String ciudad;
	private Pais pais;
	private Provincia provincia;
	
	public Aeropuerto(int id_Aeropuerto, String identificacion, String ciudad, Pais pais, Provincia provincia) {
		super();
		this.id_Aeropuerto = id_Aeropuerto;
		this.identificacion = identificacion;
		this.ciudad = ciudad;
		this.pais = pais;
		this.provincia = provincia;
	}

	public int getId_Aeropuerto() {
		return id_Aeropuerto;
	}

	public void setId_Aeropuerto(int id_Aeropuerto) {
		this.id_Aeropuerto = id_Aeropuerto;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	
}
