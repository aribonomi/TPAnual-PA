package dao.negocio;

public class Direccion {
	
	private int id_direccion;
	private String calle;
	private String altura;
	private String ciudad;
	private String codigoPostal; 
	private Provincia provincia;
	private Pais pais;
	
	public Direccion(int id_direccion, String calle, String altura, String ciudad, String codigoPostal,
			Provincia provincia, Pais pais) {
		this.id_direccion = id_direccion;
		this.calle = calle;
		this.altura = altura;
		this.ciudad = ciudad;
		this.codigoPostal = codigoPostal;
		this.provincia = provincia;
		this.pais = pais;
	}

	public int getId_direccion() {
		return id_direccion;
	}
	public void setId_direccion(int id_direccion) {
		this.id_direccion = id_direccion;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getAltura() {
		return altura;
	}
	public void setAltura(String altura) {
		this.altura = altura;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	
}