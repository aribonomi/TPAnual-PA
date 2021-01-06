package Factory;

import dao.Interfaces.LineaAereaDAO;
import dao.implDB.LineaAereaDAOImplMySQL;

public class FactoryLineaAerea {
	
	public static LineaAereaDAO getLineaAereaDaoImplMysql() {

		return new LineaAereaDAOImplMySQL();
	}


}
