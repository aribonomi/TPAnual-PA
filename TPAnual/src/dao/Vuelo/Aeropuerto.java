package dao.Vuelo;

public class Aeropuerto {
	
	private String ciudad;
	private String idAeropuerto;
	private Pais pais;
	private Provincia provincia;
	
	public Aeropuerto(String ciudad, String idAeropuerto, Pais pais, Provincia provincia) {
		this.ciudad = ciudad;
		this.idAeropuerto = idAeropuerto;
		this.pais = pais;
		this.provincia = provincia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getIdAeropuerto() {
		return idAeropuerto;
	}

	public void setIdAeropuerto(String idAeropuerto) {
		this.idAeropuerto = idAeropuerto;
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
