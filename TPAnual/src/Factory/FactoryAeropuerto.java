package Factory;

import dao.Interfaces.AeropuertoDAO;
import dao.implDB.AeropuertoDaoImplMysql;

public class FactoryAeropuerto {
	
	public static AeropuertoDAO getAeropuertoDaoImplMysql() {

		return new AeropuertoDaoImplMysql();

	}

}
