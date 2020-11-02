package dao.negocio;

public class Provincia {
	
	private int id_provincia;
	private String nombreProvincia;
	
	public Provincia(String nombreProvincia) {
		
		this.nombreProvincia = nombreProvincia;
	}
	
	public int getId_provincia() {
		return id_provincia;
	}
	public void setId_provincia(int id_provincia) {
		this.id_provincia = id_provincia;
	}
	public String getNombreProvincia() {
		return nombreProvincia;
	}
	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}

	@Override
	public String toString() {
		return "Provincia [id_provincia=" + id_provincia + ", nombreProvincia=" + nombreProvincia + "]";
	}
	

}
