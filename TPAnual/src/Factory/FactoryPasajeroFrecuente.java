package Factory;

import dao.Interfaces.PasajeroFrecuenteDAO;
import dao.implDB.PasajeroFrecuenteDAOImplMySQL;

public class FactoryPasajeroFrecuente {
	
	public static PasajeroFrecuenteDAO getPasajeroFrecuenteDaoImplMysql() {


		return new PasajeroFrecuenteDAOImplMySQL();

	}

}
