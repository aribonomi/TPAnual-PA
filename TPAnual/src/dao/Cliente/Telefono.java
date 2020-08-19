package dao.Cliente;

public class Telefono {
	
	private int id_Telefono;
	private String persona;
	private String celular;
	private String laboral;
	
	public Telefono(int id_Telefono, String persona, String celular, String laboral) {
		this.id_Telefono = id_Telefono;
		this.persona = persona;
		this.celular = celular;
		this.laboral = laboral;
	}

	public int getId_Telefono() {
		return id_Telefono;
	}
	public void setId_Telefono(int id_Telefono) {
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
	
}
