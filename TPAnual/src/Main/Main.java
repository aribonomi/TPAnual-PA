package Main;

import java.util.ArrayList;
import java.util.List;

import Factory.Factory;
import dao.Interfaces.AerolineaDAO;
import dao.Interfaces.ClienteDAO;
import dao.Interfaces.TelefonoDAO;
import dao.negocio.Cliente;
import dao.negocio.Telefono;

public class Main {
	
	
	public static void main(String[] args){
		
		
	TelefonoDAO telefonoDAO = Factory.getTelefonoDaoImplMysql();
	List<Telefono> l = new ArrayList();
	
	l = telefonoDAO.ListAllTelefono();
	
	System.out.println(l.toString());
		
	}


}
