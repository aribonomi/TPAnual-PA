package Cliente;

public class PasajeroFrecuente {
	
	private String areolinea;
	private String alianza;
	private String categoria;
	private String numero;
	
	public PasajeroFrecuente(String areolinea, String alianza, String categoria, String numero) {
		this.areolinea = areolinea;
		this.alianza = alianza;
		this.categoria = categoria;
		this.numero = numero;
	}

	public String getAreolinea() {
		return areolinea;
	}
	public void setAreolinea(String areolinea) {
		this.areolinea = areolinea;
	}

	public String getAlianza() {
		return alianza;
	}
	public void setAlianza(String alianza) {
		this.alianza = alianza;
	}

	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
	

}
