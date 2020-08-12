package dao.Vuelo;

public class LineaAerea {
	private String alianza;
	private String nombreAerolinea;
	private Vuelo vuelo;
	
	
	public LineaAerea(String alianza, String nombreAerolinea, Vuelo vuelo) {
		super();
		this.alianza = alianza;
		this.nombreAerolinea = nombreAerolinea;
		this.vuelo = vuelo;
	}


	@Override
	public String toString() {
		return "LineaAerea: \nAlianza = " + alianza + "\nNombreAerolinea = " + nombreAerolinea + "\nVuelo = " + vuelo;
	}


	public String getAlianza() {
		return alianza;
	}


	public void setAlianza(String alianza) {
		this.alianza = alianza;
	}


	public String getNombreAerolinea() {
		return nombreAerolinea;
	}


	public void setNombreAerolinea(String nombreAerolinea) {
		this.nombreAerolinea = nombreAerolinea;
	}


	public Vuelo getVuelo() {
		return vuelo;
	}


	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
	
	
	
	
}
