package dao.Interfaces;

import java.util.List;

import dao.negocio.Venta;

public interface VentasDAO{
	
//ABM y consultas	
	public boolean altaVenta(Venta venta);
	public boolean bajaVenta(String id_veta);
	public boolean modificarVenta(Venta venta);
	public List<Venta> ListAllVenta();
	public Venta getVentas(String id_venta);
	public List<Integer> obtenerIds();
	
//Obtiene la última venta realizada	
	public Venta obtenerUltima();

}
