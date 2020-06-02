package Cliente;

public class Telefono {
	
	private String nroCelular;
	private String nroLaboral;
	private String nroPersonal;
	
	
	public Telefono(String nroCelular,String nroLaboral,String nroPersonal) {
		this.nroCelular=nroCelular;
		this.nroLaboral=nroLaboral;
		this.nroPersonal=nroPersonal;
	}


	public String getNroCelular() {
		return nroCelular;
	}
	public void setNroCelular(String nroCelular) {
		this.nroCelular = nroCelular;
	}


	public String getNroLaboral() {
		return nroLaboral;
	}
	public void setNroLaboral(String nroLaboral) {
		this.nroLaboral = nroLaboral;
	}


	public String getNroPersonal() {
		return nroPersonal;
	}
	public void setNroPersonal(String nroPersonal) {
		this.nroPersonal = nroPersonal;
	}

	
}
