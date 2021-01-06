package Factory;

import dao.Interfaces.ProvinciaDAO;
import dao.implDB.ProvinciaDAOImplMySQL;

public class FactoryProvincia {
	
	public static ProvinciaDAO getProvinciaDaoImplMysql() {

		return new ProvinciaDAOImplMySQL();
	}

}
