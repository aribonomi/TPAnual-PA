package Factory;

import dao.Interfaces.TelefonoDAO;
import dao.implDB.TelefonoDAOImplMySQL;

public class FactoryTelefono {
	
	public static TelefonoDAO getTelefonoDaoImplMysql() {

		return new TelefonoDAOImplMySQL();
	}

}
