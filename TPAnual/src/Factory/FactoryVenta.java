package Factory;

import dao.Interfaces.VentasDAO;
import dao.implDB.VentasDAOImplMySQL;

public class FactoryVenta {
	
	public static VentasDAO getVentasDaoImplMysql() {
		   
    	return new VentasDAOImplMySQL();
    }

}
