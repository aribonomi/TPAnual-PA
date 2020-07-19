package dao.Cliente;

public class Direccion {
	
	private String altura;
	private String calle;
	private String ciudad;
	private String CodigoPostal;
	private String pais; //En el diagrama de clases dice que esto es un int Revisar
	private String provincia; //En el diagrama de clases dice que esto es un int Revisar
	
	public Direccion(String altura, String calle, String ciudad, String codigoPostal, String pais, String provincia) {
		this.altura = altura;
		this.calle = calle;
		this.ciudad = ciudad;
		this.CodigoPostal = codigoPostal;
		this.pais = pais;
		this.provincia = provincia;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodigoPostal() {
		return CodigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		CodigoPostal = codigoPostal;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

}
