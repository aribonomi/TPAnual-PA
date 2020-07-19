package dao.Vuelo;

public class Pais {
	
	private String id;
	private String nombrePais;
	
	public Pais(String id, String nombrePais) {
		this.id = id;
		this.nombrePais = nombrePais;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombrePais() {
		return nombrePais;
	}
	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}
	
	

}
