package dao.negocio;

public class Provincia {
	
	private Integer id_provincia;
	private String nombreProvincia;
	
	public Provincia(String nombreProvincia) {
		
		this.nombreProvincia = nombreProvincia;
	}
	
	public Provincia(Integer id_provincia, String nombreProvincia) {
		super();
		this.id_provincia = id_provincia;
		this.nombreProvincia = nombreProvincia;
	}

	public Integer getId_provincia() {
		return id_provincia;
	}
	public void setId_provincia(Integer id_provincia) {
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
