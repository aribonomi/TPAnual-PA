package dao.implDB;

public class ImplDAOFactory {

	public static ImplDAOClientes BdeD(String tipo) {
		
	if(tipo.equalsIgnoreCase("sql")) {
		return new ImplDAOClientes();
	}else {
		System.out.println("No se encontr� la implementaci�n ingresada");
		return null;
	}
}
}
