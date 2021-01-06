package Factory;

import dao.Interfaces.PasaporteDAO;
import dao.implDB.PasaporteDAOImplMySQL;

public class FactoryPasaporte {
	
	public static PasaporteDAO getPasaporteDaoImplMysql() {


		return new PasaporteDAOImplMySQL();
	}

}
