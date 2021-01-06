package Factory;

import dao.Interfaces.VuelosDAO;
import dao.implDB.VuelosDAOImplMySQL;

public class FactoryVuelo {
	
	public static VuelosDAO getVuelosDaoImplMysql() {

    	return new VuelosDAOImplMySQL();
    }

}
