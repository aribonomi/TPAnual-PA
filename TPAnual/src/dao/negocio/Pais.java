package dao.negocio;

public class Pais {
	
	private Integer id_pais;
	private String nombrePais;
	
	public Pais(String nombrePais) {
		this.nombrePais = nombrePais;
	}
	
	public Pais(Integer id_pais, String nombrePais) {
		this.id_pais = id_pais;
		this.nombrePais = nombrePais;
	}
	
	public Integer getId_pais() {
		return id_pais;
	}
	public void setId_pais(Integer id_pais) {
		this.id_pais = id_pais;
	}
	public String getNombrePais() {
		return nombrePais;
	}
	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	@Override
	public String toString() {
		return "Pais [id_pais=" + id_pais + ", nombrePais=" + nombrePais + "]";
	}
	
	

}
