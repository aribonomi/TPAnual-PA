package Factory;

import dao.Interfaces.DireccionDAO;
import dao.implDB.DireccionDaoImplMysql;

public class FactoryDireccion {
	
	public static DireccionDAO getDireccionDaoImplMysql() {

		return new DireccionDaoImplMysql();

	}

}
