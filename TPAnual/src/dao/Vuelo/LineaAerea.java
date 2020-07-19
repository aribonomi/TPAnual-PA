package dao.Vuelo;

public class LineaAerea {
	private String alianza;
	private LineaAerea nombreAerolinea;
	private Vuelo vuelo;
	
	
	public LineaAerea(String alianza, LineaAerea nombreAerolinea, Vuelo vuelo) {
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


	public LineaAerea getNombreAerolinea() {
		return nombreAerolinea;
	}


	public void setNombreAerolinea(LineaAerea nombreAerolinea) {
		this.nombreAerolinea = nombreAerolinea;
	}


	public Vuelo getVuelo() {
		return vuelo;
	}


	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
	
	
	
	
}
