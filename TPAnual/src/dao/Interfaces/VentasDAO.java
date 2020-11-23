package dao.Interfaces;

import java.util.List;

import dao.negocio.Venta;

public interface VentasDAO{
	
	public void altaVenta(Venta venta);
	public void bajaVenta(String id_veta);
	public void modificarVenta(Venta venta);
	public List<Venta> ListAllVenta();
	public Venta getVentas(String id_venta);
	public List<Integer> obtenerIds();

}
