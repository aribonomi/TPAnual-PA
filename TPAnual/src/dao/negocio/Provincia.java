package dao.negocio;

public class Provincia {
	
	private String id_provincia;
	private String nombreProvincia;
	
	public Provincia(String id_provincia, String nombreProvincia) {
		this.id_provincia = id_provincia;
		this.nombreProvincia = nombreProvincia;
	}
	
	public String getId_provincia() {
		return id_provincia;
	}
	public void setId_provincia(String id_provincia) {
		this.id_provincia = id_provincia;
	}
	public String getNombreProvincia() {
		return nombreProvincia;
	}
	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}
	

}
