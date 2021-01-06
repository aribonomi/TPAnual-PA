package Factory;

import dao.Interfaces.ClienteDAO;
import dao.implDB.ClienteDAOImplMySQL;

public class FactoryCliente {
	
	public static ClienteDAO getClienteDaoImplMysql() {

		return new ClienteDAOImplMySQL();
	}

}
