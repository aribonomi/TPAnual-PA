package dao.Interfaces;

import java.util.List;

import dao.negocio.Aerolinea;

public interface LineaAereaDAO{

	public void altaLineaAerea(Aerolinea aerolinea);
	public void bajaLineaAerea(String id_aerolinea);
	public void modificarLineaAerea(Aerolinea aerolinea);
	public Aerolinea getLineaArea(String id_aerolinea);
	//public List<LineaAerea> consultaLineaAerea(;
	
}
