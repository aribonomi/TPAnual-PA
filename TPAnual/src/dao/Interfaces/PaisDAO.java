package dao.Interfaces;

import java.util.List;

import dao.negocio.Pais;

public interface PaisDAO{

	public void addPais(Pais pais);
	public void deletePais(String nombre_pais);
	public void updatePais(Pais pais);
	public List<Pais> ListAllPais();
	public Pais getPais(String nombre_pais);
	
}
