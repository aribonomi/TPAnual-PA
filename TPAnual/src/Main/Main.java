package Main;

import java.util.ArrayList;
import java.util.List;

import Factory.Factory;
import dao.Interfaces.*;
import dao.negocio.*;

public class Main {
	
	
	public static void main(String[] args){
		
		
	VuelosDAO vueloDAO = Factory.getVuelosDaoImplMysql();
	List<Telefono> l = new ArrayList();
	
	Vuelo vuelo = vueloDAO.obtenerUltimo();
	
	System.out.println(vuelo.toString());
		
	}


}
