package dao.negocio;

public class Telefono {
	
	private Integer id_Telefono;
	private String persona;
	private String celular;
	private String laboral;
	
	public Telefono(String persona, String celular, String laboral) {
		
		this.persona = persona;
		this.celular = celular;
		this.laboral = laboral;
	}
	
	public Telefono(Integer id_Telefono, String persona, String celular, String laboral) {
		this.id_Telefono = id_Telefono;
		this.persona = persona;
		this.celular = celular;
		this.laboral = laboral;
	}

	public Integer getId_Telefono() {
		return id_Telefono;
	}
	public void setId_Telefono(Integer id_Telefono) {
		this.id_Telefono = id_Telefono;
	}
	public String getPersona() {
		return persona;
	}
	public void setPersona(String persona) {
		this.persona = persona;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getLaboral() {
		return laboral;
	}
	public void setLaboral(String laboral) {
		this.laboral = laboral;
	}

	@Override
	public String toString() {
		return "Telefono [id_Telefono=" + id_Telefono + ", persona=" + persona + ", celular=" + celular + ", laboral="
				+ laboral + "]";
	}
	
}
