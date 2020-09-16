package dao.Interfaces;

public interface DAOManager<T, K> {
	
	public void alta(T objeto);
	public void baja(K id);
	public void modificacion(T objeto);
	public void consulta(K id);

}
