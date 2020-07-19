package dao.Vuelo;

public class Provincia {
	
	private String id;
	private String nombreProvincia;
	
	public Provincia(String id, String nombreProvincia) {
		this.id = id;
		this.nombreProvincia = nombreProvincia;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombreProvincia() {
		return nombreProvincia;
	}
	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}
	

}
