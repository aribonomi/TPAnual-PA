package dao.Vuelo;

public class Pais {
	
	private String id_pais;
	private String nombrePais;
	
	public Pais(String id_pais, String nombrePais) {
		this.id_pais = id_pais;
		this.nombrePais = nombrePais;
	}
	
	public String getId_pais() {
		return id_pais;
	}
	public void setId_pais(String id_pais) {
		this.id_pais = id_pais;
	}
	public String getNombrePais() {
		return nombrePais;
	}
	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}
	
	

}
