package Factory;

import dao.Interfaces.PaisDAO;
import dao.implDB.PaisDAOImplMySQL;

public class FactoryPais {
	
	public static PaisDAO getPaisDao() {

		return new PaisDAOImplMySQL();
	}

}
